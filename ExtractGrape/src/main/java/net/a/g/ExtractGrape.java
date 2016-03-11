package net.a.g;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

import org.jboss.byteman.rule.Rule;
import org.jboss.byteman.rule.helper.Helper;
import org.reflections.ReflectionUtils;

import com.google.common.base.Predicates;

public class ExtractGrape extends Helper {
	protected ExtractGrape(Rule rule) {
		super(rule);
	}

	public static void extract(Class clazz) {
		try {
			if (clazz.isPrimitive() || clazz.getName().equals("[B") || clazz.getName().startsWith("java.lang")) {
				return;
			}

			Class[] interfacesArray = clazz.getInterfaces();
			boolean isSerializable = false;
			for (Class interf : interfacesArray) {
				if (interf.equals(Serializable.class)) {
					System.out.println("##ByteMan " + clazz.getName() + " Serializable OK");
					isSerializable = true;
					break;
				}
			}

			if (!isSerializable) {
				System.out.println("##ByteMan " + clazz.getName() + " Serializable KO");

			}

			Set<Method> methods = ReflectionUtils.getMethods(clazz,
					Predicates.and(ReflectionUtils.withModifier(java.lang.reflect.Modifier.PUBLIC),
							ReflectionUtils.withPrefix("get")));

			for (Method method : methods) {
				Class returnClass = method.getReturnType();
				// Gestion des collections
				if (Collection.class.isAssignableFrom(returnClass)) {
					Type returnType = method.getGenericReturnType();
					if (returnType instanceof ParameterizedType) {
						ParameterizedType paramType = (ParameterizedType) returnType;
						Type[] argTypes = paramType.getActualTypeArguments();
						if (argTypes.length > 0) {
							extract((Class<?>) argTypes[0]);
						}
					}
				} else {
					Class clazz2 = method.getReturnType();
					extract(clazz2);
				}
			}
		} catch (Throwable t) {
			System.out.println("##ByteMan Exception :" + t.getMessage());
		}
	}

}

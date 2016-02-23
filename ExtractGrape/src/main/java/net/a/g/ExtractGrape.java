package net.a.g;

import java.io.Serializable;
import java.lang.reflect.Method;
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
		if (clazz.isPrimitive() || clazz.getName().equals("[B") || clazz.getName().startsWith("java.lang")) {
			return;
		}

		Class[] oo = clazz.getInterfaces();
		boolean isSerializable = false;
		for (Class class1 : oo) {
			if (class1.equals(Serializable.class)) {
				System.out.println("##ByteMan "+ clazz.getName() + " Serializable OK");
				isSerializable = true;
				break;
			}
		}
		if (!isSerializable) {
			System.out.println("##ByteMan "+ clazz.getName() + " Serializable KO");

		}

		Set<Method> methods = ReflectionUtils.getMethods(clazz, Predicates.and(
				ReflectionUtils.withModifier(java.lang.reflect.Modifier.PUBLIC), ReflectionUtils.withPrefix("get")));

		for (Method method : methods) {
			Class clazz2 = method.getReturnType();
			extract(clazz2);
		}
	}

}

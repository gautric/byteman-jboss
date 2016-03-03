package org.jboss.as.quickstarts.helloworld;

import java.io.Serializable;

public class TestBean2 implements Serializable {

	private String hello;
	private int hi;
	private boolean toto;
	private TestBean3 bean3;

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	public int getHi() {
		return hi;
	}

	public void setHi(int hi) {
		this.hi = hi;
	}

	public boolean isToto() {
		return toto;
	}

	public void setToto(boolean toto) {
		this.toto = toto;
	}

	public TestBean3 getBean3() {
		return bean3;
	}

	public void setBean3(TestBean3 bean3) {
		this.bean3 = bean3;
	}

}

package org.rhc;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.rhc.model.SampleOne;

public class MakeErrorTest {
	
	
	@Test
	public void shouldMakeClassCastErrorHappenJava() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		StatelessKieSession kSession = kContainer.newStatelessKieSession("with_error_session");
		kSession.execute(new SampleOne());
	}
	
	@Test
	public void shouldMakeExpectedErrorHappenMvel() {
		//Just set dialect to mvel
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		StatelessKieSession kSession = kContainer.newStatelessKieSession("with_expected_error_session");
		kSession.execute(new SampleOne());
	}
	
	@Test
	public void shouldMakeExpectedErrorNoBindingInAccumulateJava() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		StatelessKieSession kSession = kContainer.newStatelessKieSession("with_expected_error_no_binding_session");
		kSession.execute(new SampleOne());
	}

}

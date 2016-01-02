/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine.junit4;

import org.junit.gen5.engine.EngineAwareTestDescriptor;
import org.junit.gen5.engine.EngineDescriptor;
import org.junit.gen5.engine.ExecutionRequest;
import org.junit.gen5.engine.TestEngine;
import org.junit.gen5.engine.TestPlanSpecification;
import org.junit.gen5.engine.junit4.discovery.JUnit4TestPlanSpecificationResolver;

public class JUnit4TestEngine implements TestEngine {

	@Override
	public String getId() {
		return "junit4";
	}

	@Override
	public EngineAwareTestDescriptor discoverTests(TestPlanSpecification specification) {
		EngineDescriptor engineDescriptor = new EngineDescriptor(this);
		new JUnit4TestPlanSpecificationResolver(engineDescriptor).resolve(specification);
		return engineDescriptor;
	}

	@Override
	public void execute(ExecutionRequest request) {
	}
}

/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine.support.hierarchical;

import static org.junit.gen5.engine.support.hierarchical.Node.SkipResult.dontSkip;
import static org.junit.gen5.engine.support.hierarchical.Node.SkipResult.skip;

import org.junit.gen5.engine.support.descriptor.EngineDescriptor;

public class DummyEngineDescriptor extends EngineDescriptor implements Node<DummyEngineExecutionContext> {

	private String skippedReason;
	private boolean skipped;

	public DummyEngineDescriptor(String engineId) {
		super(engineId, engineId);
	}

	public void markSkipped(String reason) {
		this.skipped = true;
		this.skippedReason = reason;
	}

	@Override
	public SkipResult shouldBeSkipped(DummyEngineExecutionContext context) {
		return skipped ? skip(skippedReason) : dontSkip();
	}

}

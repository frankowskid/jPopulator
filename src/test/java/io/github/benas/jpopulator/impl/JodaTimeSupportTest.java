/*
 * The MIT License
 *
 *   Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */

package io.github.benas.jpopulator.impl;

import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.beans.Organizer;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Joda Time support.
 *
 * @author Nikola Milivojevic (0dziga0@gmail.com)
 */
public class JodaTimeSupportTest {

	private Populator populator;
	
	@Before
    public void setUp() throws Exception {
        populator = new PopulatorBuilder().build();
    }
    
    @Test
    public void jodaTimeBeansShouldBeFilledIn() {

        Organizer organizer = populator.populateBean(Organizer.class);

        assertThat(organizer).isNotNull();
        assertThat(organizer.getAnniversary()).isNotNull();
    	assertThat(organizer.getBirthday()).isNotNull();
    	assertThat(organizer.getHiking()).isNotNull();
    	assertThat(organizer.getClasses()).isNotNull();
    	assertThat(organizer.getTraining()).isNotNull();
    	assertThat(organizer.getWorkDuration()).isNotNull();
    }
}

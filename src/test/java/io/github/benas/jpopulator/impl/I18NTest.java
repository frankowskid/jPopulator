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
import io.github.benas.jpopulator.beans.Address;
import io.github.benas.jpopulator.beans.Person;
import io.github.benas.jpopulator.randomizers.CountryRandomizer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for I18n support.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class I18NTest {

    /**
     * The populator to test.
     */
    private Populator populator;

    @BeforeClass
    public static void setupLocale() {
        Locale.setDefault(new Locale("FR", "fr"));
    }

    @Before
    public void setUp() throws Exception {
        populator = new PopulatorBuilder()
                .registerRandomizer(Address.class, String.class, "country", new CountryRandomizer())
                .build();
    }

    @Test
    public void generatedValueShouldBeInternationalized() throws Exception {
        Person person = populator.populateBean(Person.class);

        assertThat(person.getAddress().getCountry())
                .isIn(Arrays.asList("Etats Unis", "Chine", "Allemagne", "France", "Italie", "Espagne"));
    }

    @AfterClass
    public static void resetLocale() {
        Locale.setDefault(Locale.getDefault());
    }

}

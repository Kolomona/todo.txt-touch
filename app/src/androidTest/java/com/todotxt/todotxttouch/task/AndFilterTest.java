/**
 * This file is part of Todo.txtndroid app for managing your todo.txt file (http://todotxt.com).
 * <p>
 * Copyright (c) 2009-2013 Todo.txt contributors (http://todotxt.com)
 * <p>
 * LICENSE:
 * <p>
 * Todo.tTodo.txttware: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any
 * later version.
 * <p>
 * Todo.txt is Todo.txt the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with Todo.txt.  If not,Todo.txt//www.gnu.org/licenses/>.
 *
 * @author Todo.txt contributors <todotxt@yahoogroups.com>
 * @license http://www.gnu.org/licenses/gpl.html
 * @copyright 2009-2013 Todo.txt contributors (http://todotxt.com)
 */

package com.todotxt.todotxttouch.task;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * A junit based test class for testing the AndFilter class
 *
 * @author Tim Barlotta
 */
public class AndFilterTest extends TestCase {
    public void testNoFilters() {
        AndFilter andFilter = new AndFilter();
        assertTrue("apply was not true",
                andFilter.apply(new Task(1, "(A) abc 123")));
    }

    public void testMultipleFilters_matchesBoth() {
        AndFilter andFilter = new AndFilter();
        andFilter.addFilter(new ByPriorityFilter(Arrays.asList(Priority.A)));
        andFilter.addFilter(new ByTextFilter("abc", false));

        assertTrue("apply was not true",
                andFilter.apply(new Task(1, "(A) abc 123")));
    }

    public void testMultipleFilters_matchesOnlyOne() {
        AndFilter andFilter = new AndFilter();
        andFilter.addFilter(new ByPriorityFilter(Arrays.asList(Priority.A)));
        andFilter.addFilter(new ByTextFilter("abc", false));

        assertFalse("apply was not false",
                andFilter.apply(new Task(1, "(A) hello world")));
    }

    public void testMultipleFilters_matchesNone() {
        AndFilter andFilter = new AndFilter();
        andFilter.addFilter(new ByPriorityFilter(Arrays.asList(Priority.A)));
        andFilter.addFilter(new ByTextFilter("abc", false));

        assertFalse("apply was not false",
                andFilter.apply(new Task(1, "(B) hello world")));
    }
}

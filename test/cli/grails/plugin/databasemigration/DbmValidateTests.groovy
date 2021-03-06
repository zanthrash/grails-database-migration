/* Copyright 2010-2011 SpringSource.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugin.databasemigration

/**
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class DbmValidateTests extends AbstractScriptTests {

	void testValidate() {

		generateChangelog()

		executeAndCheck 'dbm-validate'

		assertTrue output.contains(
			'Starting dbm-validate for database sa @ jdbc:h2:tcp://localhost/./target/testdb/testdb')
	}

    void testValidateForSecondaryDataSource() {

        generateSecondaryChagelog()

   		executeAndCheck (['dbm-validate', '--dataSource=secondary'])

   		assertTrue output.contains(
   			'Starting dbm-validate for database sa @ jdbc:h2:tcp://localhost/./target/testdb/testdb-secondary')
   	}

}

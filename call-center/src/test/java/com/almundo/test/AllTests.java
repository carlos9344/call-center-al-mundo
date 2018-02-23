package com.almundo.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Run test
 * @author Carlos ANgulo
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CallCenterTest.class, DispatcherTest.class, NoAvailableEmployeeScenarioTest.class })
public class AllTests {

}

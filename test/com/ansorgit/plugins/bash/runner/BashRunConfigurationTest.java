/*
 * Copyright (c) Joachim Ansorg, mail@ansorg-it.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.runner;

import com.ansorgit.plugins.bash.LightBashCodeInsightFixtureTestCase;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationModule;
import com.intellij.execution.configurations.UnknownRunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author jansorg
 */
public class BashRunConfigurationTest extends LightBashCodeInsightFixtureTestCase {
    @Test
    public void testBuildOption() throws Exception {
        //dummy setup
        BashRunConfiguration config = new BashRunConfiguration("Bash", new RunConfigurationModule(getProject()), new ConfigurationFactory(BashConfigurationType.getInstance()) {
            @NotNull
            @Override
            public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
                return new UnknownRunConfiguration(this, project);
            }
        });

        Assert.assertFalse("The make step must not be enabled by default", config.isCompileBeforeLaunchAddedByDefault());
    }
}
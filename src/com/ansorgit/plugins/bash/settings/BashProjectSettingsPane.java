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

package com.ansorgit.plugins.bash.settings;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * @author jansorg
 */
public class BashProjectSettingsPane implements Disposable {
    private JPanel settingsPane;
    private JTextArea globalVarList;
    private JCheckBox globalVarAutocompletion;
    private JCheckBox bash4Support;
    private JCheckBox autocompleteInternalVars;
    private JCheckBox autocompleteInternalCommands;
    private JCheckBox enableFormatterCheckbox;
    private JCheckBox autocompletePathCommands;
    private JCheckBox globalFunctionVarDefs;
    private JCheckBox enableEvalEscapesCheckbox;
    JCheckBox useTerminalPlugin;

    @SuppressWarnings("BoundFieldAssignment")
    public void dispose() {
        this.settingsPane = null;
        this.globalVarList = null;
        this.bash4Support = null;
        this.autocompleteInternalVars = null;
        this.autocompleteInternalCommands = null;
        this.enableFormatterCheckbox = null;
        this.autocompletePathCommands = null;
        this.globalFunctionVarDefs = null;
        this.enableEvalEscapesCheckbox = null;
    }

    public void setData(BashProjectSettings settings) {
        globalVarAutocompletion.setSelected(settings.isAutcompleteGlobalVars());
        globalVarList.setText(joinGlobalVarList(settings.getGlobalVariables()));
        bash4Support.setSelected(settings.isSupportBash4());
        autocompleteInternalCommands.setSelected(settings.isAutocompleteBuiltinCommands());
        autocompleteInternalVars.setSelected(settings.isAutocompleteBuiltinVars());
        autocompletePathCommands.setSelected(settings.isAutocompletePathCommands());
        enableFormatterCheckbox.setSelected(settings.isFormatterEnabled());
        enableEvalEscapesCheckbox.setSelected(settings.isEvalEscapesEnabled());
        globalFunctionVarDefs.setSelected(settings.isGlobalFunctionVarDefs());

        //expermimental
        useTerminalPlugin.setSelected(settings.isUseTerminalPlugin());
    }

    public void storeSettings(BashProjectSettings settings) {
        settings.setAutcompleteGlobalVars(globalVarAutocompletion.isSelected());
        settings.setGlobalVariables(splitGlobalVarList(globalVarList.getText()));
        settings.setSupportBash4(bash4Support.isSelected());
        settings.setAutocompleteBuiltinCommands(autocompleteInternalCommands.isSelected());
        settings.setAutocompleteBuiltinVars(autocompleteInternalVars.isSelected());
        settings.setFormatterEnabled(enableFormatterCheckbox.isSelected());
        settings.setEvalEscapesEnabled(enableEvalEscapesCheckbox.isSelected());
        settings.setAutocompletePathCommands(autocompletePathCommands.isSelected());
        settings.setGlobalFunctionVarDefs(globalFunctionVarDefs.isSelected());

        //experimental
        settings.setUseTerminalPlugin(useTerminalPlugin.isSelected());
    }

    public boolean isModified(BashProjectSettings settings) {
        return settings.isAutcompleteGlobalVars() != globalVarAutocompletion.isSelected() ||
                !joinGlobalVarList(settings.getGlobalVariables()).equals(globalVarList.getText()) ||
                bash4Support.isSelected() != settings.isSupportBash4() ||
                autocompleteInternalVars.isSelected() != settings.isAutocompleteBuiltinVars() ||
                autocompleteInternalCommands.isSelected() != settings.isAutocompleteBuiltinCommands() ||
                enableFormatterCheckbox.isSelected() != settings.isFormatterEnabled() ||
                enableEvalEscapesCheckbox.isSelected() != settings.isEvalEscapesEnabled() ||
                autocompletePathCommands.isSelected() != settings.isAutocompletePathCommands() ||
                globalFunctionVarDefs.isSelected() != settings.isGlobalFunctionVarDefs() ||
                useTerminalPlugin.isSelected() != settings.isUseTerminalPlugin();
    }

    public JPanel getPanel() {
        return settingsPane;
    }

    private String joinGlobalVarList(Collection<String> data) {
        return StringUtil.join(data, "\n");
    }

    private Set<String> splitGlobalVarList(String data) {
        if (data.length() == 0) {
            return Collections.emptySet();
        }

        return new LinkedHashSet<String>(Arrays.asList(data.split("\\n").clone()));
    }

    private void createUIComponents() {
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        settingsPane = new JPanel();
        settingsPane.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        settingsPane.add(panel1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.setBorder(BorderFactory.createTitledBorder("Variables"));
        final JLabel label1 = new JLabel();
        label1.setText("Registered global variables (one variable per line):");
        panel1.add(label1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        globalVarAutocompletion = new JCheckBox();
        globalVarAutocompletion.setSelected(true);
        globalVarAutocompletion.setText("Offer registered global variables in autocompletion");
        globalVarAutocompletion.setMnemonic('O');
        globalVarAutocompletion.setDisplayedMnemonicIndex(0);
        panel1.add(globalVarAutocompletion, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        globalVarList = new JTextArea();
        globalVarList.setMargin(new Insets(5, 5, 5, 5));
        globalVarList.setText("");
        globalVarList.putClientProperty("html.disable", Boolean.TRUE);
        scrollPane1.setViewportView(globalVarList);
        globalFunctionVarDefs = new JCheckBox();
        globalFunctionVarDefs.setText("Variables defined in functions are globally visible");
        panel1.add(globalFunctionVarDefs, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        settingsPane.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        panel2.setBorder(BorderFactory.createTitledBorder("Language level"));
        bash4Support = new JCheckBox();
        bash4Support.setText("Support Bash 4.x language elements");
        bash4Support.setMnemonic('S');
        bash4Support.setDisplayedMnemonicIndex(0);
        panel2.add(bash4Support, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        settingsPane.add(panel3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        panel3.setBorder(BorderFactory.createTitledBorder("Autocompletion"));
        autocompleteInternalVars = new JCheckBox();
        autocompleteInternalVars.setText("Show built-in variables ($PWD, $PATH, ...)");
        panel3.add(autocompleteInternalVars, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel3.add(spacer1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        autocompleteInternalCommands = new JCheckBox();
        autocompleteInternalCommands.setText("Show built-in commands (echo, export, ...)");
        panel3.add(autocompleteInternalCommands, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        autocompletePathCommands = new JCheckBox();
        autocompletePathCommands.setText("Show commands in $PATH");
        panel3.add(autocompletePathCommands, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        settingsPane.add(panel4, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        panel4.setBorder(BorderFactory.createTitledBorder("Experimental features - use at your own risk!"));
        enableFormatterCheckbox = new JCheckBox();
        enableFormatterCheckbox.setText("Enable formatter");
        panel4.add(enableFormatterCheckbox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel4.add(spacer2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        enableEvalEscapesCheckbox = new JCheckBox();
        enableEvalEscapesCheckbox.setText("Support escaped values in 'eval'-code");
        panel4.add(enableEvalEscapesCheckbox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        useTerminalPlugin = new JCheckBox();
        useTerminalPlugin.setText("Use Terminal Plugin to run Bash scripts");
        useTerminalPlugin.setToolTipText("Uses JetBrains's Terminal plugin to run Bash scripts. The plugin has to be enabled.");
        panel4.add(useTerminalPlugin, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return settingsPane;
    }
}

package com.github.rholder.gradle.intellij;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;

/**
 * Toggle whether we show actual or replaced dependency text in the Gradle
 * dependency views, coordinating via the shared Project specific GradleService.
 * See plugin.xml for additional wiring.
 */
public class ToggleShowReplacedAction  extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);

        GradleService gradleService = ServiceManager.getService(project, GradleService.class);
        gradleService.toggleShowReplaced();
    }
}
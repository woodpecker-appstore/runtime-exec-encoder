package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.plugin.payload.*;

import java.util.ArrayList;
import java.util.List;

public class RuntimeExecEncoder implements IHelperPlugin {
    public static IHelperPluginCallbacks callbacks;
    public static IPluginHelper pluginHelper;


    @Override
    public void HelperPluginMain(IHelperPluginCallbacks iHelperPluginCallbacks) {
        callbacks = iHelperPluginCallbacks;
        pluginHelper = callbacks.getPluginHelper();
        callbacks.setHelperPluginName("Runtime.exec command encoder");
        callbacks.setHelperPluginVersion("0.1.1");
        callbacks.setHelperPluginAutor("c0ny1@woodpecker-framework");
        List<IHelper> helperList = new ArrayList<IHelper>();
        helperList.add(new BashCommandEncoder());
        helperList.add(new BashCommand2Encoder());
        helperList.add(new PowershellCommandEncoder());
        helperList.add(new PythonCommandEncoder());
        helperList.add(new PerlCommandEncoder());
        callbacks.registerHelper(helperList);
    }
}

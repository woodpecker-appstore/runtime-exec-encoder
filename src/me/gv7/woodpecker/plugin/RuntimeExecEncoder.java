package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.plugin.payload.BashCommandEncoder;
import me.gv7.woodpecker.plugin.payload.PerlCommandEncoder;
import me.gv7.woodpecker.plugin.payload.PowershellCommandEncoder;
import me.gv7.woodpecker.plugin.payload.PythonCommandEncoder;
import java.util.ArrayList;
import java.util.List;

public class RuntimeExecEncoder implements IHelperPlugin {
    public static IHelperPluginCallbacks callbacks;
    public static IPluginHelper pluginHelper;


    @Override
    public void HelperPluginMain(IHelperPluginCallbacks iHelperPluginCallbacks) {
        this.callbacks = iHelperPluginCallbacks;
        this.pluginHelper = callbacks.getPluginHelper();
        callbacks.setHelperPluginName("Runtime.exec command encoder");
        callbacks.setHelperPluginVersion("0.1.0");
        callbacks.setHelperPluginAutor("c0ny1");
        List<IHelper> helperList = new ArrayList<IHelper>();
        helperList.add(new BashCommandEncoder());
        helperList.add(new PowershellCommandEncoder());
        helperList.add(new PythonCommandEncoder());
        helperList.add(new PerlCommandEncoder());
        callbacks.registerHelper(helperList);
    }
}

package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.plugin.payload.BashCommandEncoder;
import me.gv7.woodpecker.plugin.payload.PerlCommandEncoder;
import me.gv7.woodpecker.plugin.payload.PowershellCommandEncoder;
import me.gv7.woodpecker.plugin.payload.PythonCommandEncoder;
import java.util.ArrayList;
import java.util.List;

public class RuntimeExecEncoder implements IPlugin {
    public static IExtenderCallbacks callbacks;
    public static IPluginHelper pluginHelper;

    public void PluginMain(IExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.pluginHelper = callbacks.getPluginHelper();
        callbacks.setPluginName("Runtime.exec command encoder");
        callbacks.setPluginVersion("0.1.0");
        callbacks.setPluginAutor("c0ny1");
        List<IPayloadGenerator> payloadGeneratorList = new ArrayList<IPayloadGenerator>();
        payloadGeneratorList.add(new BashCommandEncoder());
        payloadGeneratorList.add(new PowershellCommandEncoder());
        payloadGeneratorList.add(new PythonCommandEncoder());
        payloadGeneratorList.add(new PerlCommandEncoder());
        callbacks.registerPayloadGenerator(payloadGeneratorList);
    }
}

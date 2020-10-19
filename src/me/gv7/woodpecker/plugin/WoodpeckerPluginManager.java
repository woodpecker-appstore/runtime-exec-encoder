package me.gv7.woodpecker.plugin;

public class WoodpeckerPluginManager implements IPluginManager {
    public void registerPluginManagerCallbacks(IPluginManagerCallbacks iPluginManagerCallbacks) {
        RuntimeExecEncoder echoTextConverter = new RuntimeExecEncoder();
        iPluginManagerCallbacks.registerHelperPlugin(echoTextConverter);
    }
}

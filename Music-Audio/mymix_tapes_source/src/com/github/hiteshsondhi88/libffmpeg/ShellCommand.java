// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import java.io.IOException;

// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            Log, CommandResult, Util

class ShellCommand
{

    ShellCommand()
    {
    }

    Process run(String as[])
    {
        Process process;
        try
        {
            process = Runtime.getRuntime().exec(as);
        }
        catch (IOException ioexception)
        {
            Log.e((new StringBuilder()).append("Exception while trying to run: ").append(as).toString(), ioexception);
            return null;
        }
        return process;
    }

    CommandResult runWaitFor(String as[])
    {
        Integer integer;
        String s;
        String s1;
        Process process;
        process = run(as);
        s1 = null;
        integer = null;
        s = null;
        as = null;
        if (process == null) goto _L2; else goto _L1
_L1:
        as = s1;
        integer = Integer.valueOf(process.waitFor());
        as = integer;
        if (!CommandResult.success(integer)) goto _L4; else goto _L3
_L3:
        as = integer;
        s1 = Util.convertInputStreamToString(process.getInputStream());
        as = s1;
_L2:
        Util.destroyProcess(process);
        s = as;
        as = integer;
_L6:
        return new CommandResult(CommandResult.success(as), s);
_L4:
        as = integer;
        s1 = Util.convertInputStreamToString(process.getErrorStream());
        as = s1;
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e("Interrupt exception", interruptedexception);
        Util.destroyProcess(process);
        if (true) goto _L6; else goto _L5
_L5:
        as;
        Util.destroyProcess(process);
        throw as;
        if (true) goto _L2; else goto _L7
_L7:
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;


// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            Util

class CommandResult
{

    final String output;
    final boolean success;

    CommandResult(boolean flag, String s)
    {
        success = flag;
        output = s;
    }

    static CommandResult getDummyFailureResponse()
    {
        return new CommandResult(false, "");
    }

    static CommandResult getOutputFromProcess(Process process)
    {
        String s;
        if (success(Integer.valueOf(process.exitValue())))
        {
            s = Util.convertInputStreamToString(process.getInputStream());
        } else
        {
            s = Util.convertInputStreamToString(process.getErrorStream());
        }
        return new CommandResult(success(Integer.valueOf(process.exitValue())), s);
    }

    static boolean success(Integer integer)
    {
        return integer != null && integer.intValue() == 0;
    }
}

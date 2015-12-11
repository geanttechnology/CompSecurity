// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import java.util.concurrent.atomic.AtomicReference;

public abstract class CommandLine
{

    private static final AtomicReference a = new AtomicReference();
    private static boolean b;

    CommandLine()
    {
    }

    public static boolean a()
    {
        return a.get() != null;
    }

    public static CommandLine b()
    {
        CommandLine commandline = (CommandLine)a.get();
        if (!b && commandline == null)
        {
            throw new AssertionError();
        } else
        {
            return commandline;
        }
    }

    private static native void nativeAppendSwitch(String s);

    private static native void nativeAppendSwitchWithValue(String s, String s1);

    private static native void nativeAppendSwitchesAndArguments(String as[]);

    static native String nativeGetSwitchValue(String s);

    static native boolean nativeHasSwitch(String s);

    private static native void nativeReset();

    public abstract boolean a(String s);

    public abstract String b(String s);

    static 
    {
        boolean flag;
        if (!org/chromium/base/CommandLine.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}

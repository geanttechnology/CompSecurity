// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;


// Referenced classes of package org.chromium.base:
//            CommandLine

class  extends CommandLine
{

    public final boolean a(String s)
    {
        return CommandLine.nativeHasSwitch(s);
    }

    public final String b(String s)
    {
        return CommandLine.nativeGetSwitchValue(s);
    }

    private ()
    {
    }
}

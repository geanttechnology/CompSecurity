// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils;

import android.os.Process;

public class CommonUtil
{

    public static final String currentThreadIdentifier()
    {
        return String.format("[0x%x]", new Object[] {
            Integer.valueOf(Process.myTid())
        });
    }
}

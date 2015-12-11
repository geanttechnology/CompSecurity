// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.util;


public final class MASHDebug
{

    private static boolean sDebugable = false;

    private MASHDebug()
    {
    }

    public static boolean isEnabled()
    {
        return sDebugable;
    }

    public static void setEnabled(boolean flag)
    {
        sDebugable = flag;
    }

}

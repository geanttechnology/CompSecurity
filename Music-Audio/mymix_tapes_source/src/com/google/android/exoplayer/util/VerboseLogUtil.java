// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;


public final class VerboseLogUtil
{

    private static volatile boolean enableAllTags;
    private static volatile String enabledTags[];

    private VerboseLogUtil()
    {
    }

    public static boolean areAllTagsEnabled()
    {
        return enableAllTags;
    }

    public static boolean isTagEnabled(String s)
    {
        if (!enableAllTags) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        String as[] = enabledTags;
        if (as == null || as.length == 0)
        {
            return false;
        }
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= as.length)
                {
                    break label1;
                }
                if (as[i].equals(s))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    public static void setEnableAllTags(boolean flag)
    {
        enableAllTags = flag;
    }

    public static transient void setEnabledTags(String as[])
    {
        enabledTags = as;
        enableAllTags = false;
    }
}

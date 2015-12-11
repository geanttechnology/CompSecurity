// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;


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
        boolean flag1 = false;
        if (!enableAllTags) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        String as[] = enabledTags;
        flag = flag1;
        if (as == null)
        {
            continue;
        }
        flag = flag1;
        if (as.length == 0)
        {
            continue;
        }
        int i = 0;
        do
        {
            flag = flag1;
            if (i >= as.length)
            {
                continue;
            }
            if (as[i].equals(s))
            {
                return true;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
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

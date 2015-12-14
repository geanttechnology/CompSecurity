// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.settings;

import java.io.File;

public class RootUtil
{

    public static boolean deviceIsRooted()
    {
        String as[] = new String[8];
        as[0] = "/sbin/su";
        as[1] = "/system/bin/su";
        as[2] = "/system/xbin/su";
        as[3] = "/data/local/xbin/su";
        as[4] = "/data/local/bin/su";
        as[5] = "/system/sd/xbin/su";
        as[6] = "/system/bin/failsafe/su";
        as[7] = "/data/local/su";
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if ((new File(as[i])).exists())
            {
                return true;
            }
        }

        return false;
    }
}

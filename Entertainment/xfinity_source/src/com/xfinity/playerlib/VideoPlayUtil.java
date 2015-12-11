// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VideoPlayUtil
{

    private final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/VideoPlayUtil);

    public VideoPlayUtil()
    {
    }

    public String getDisplayTime(int i, int j)
    {
        if (i < 0)
        {
            i = 0;
        }
        int k = i / 1000 / 3600;
        int l = (i / 1000 - k * 60 * 60) / 60;
        i = i / 1000 - k * 3600 - l * 60;
        if (j > 0x36ee80)
        {
            return String.format(Locale.US, "%d:%02d:%02d", new Object[] {
                Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i)
            });
        } else
        {
            return String.format(Locale.US, "%02d:%02d", new Object[] {
                Integer.valueOf(l), Integer.valueOf(i)
            });
        }
    }
}

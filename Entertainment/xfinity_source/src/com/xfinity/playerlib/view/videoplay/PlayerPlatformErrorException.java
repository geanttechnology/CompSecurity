// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.google.common.base.Splitter;
import java.util.Iterator;

public class PlayerPlatformErrorException extends CimException
{

    private final boolean localPlayback;
    private final int majorCode;
    private final int minorCode;
    private final String rawCode;

    public PlayerPlatformErrorException(String s, String s1)
    {
        this(s, s1, false);
    }

    public PlayerPlatformErrorException(String s, String s1, boolean flag)
    {
        super(String.format("code: %s, description: %s", new Object[] {
            s, s1
        }));
        rawCode = s;
        s = Splitter.on('.').split(s).iterator();
        int j = intValue((String)s.next());
        int i = j;
        if (j == 0x186a0)
        {
            i = j;
            if (s.hasNext())
            {
                i = intValue((String)s.next());
            }
        }
        majorCode = i;
        i = -1;
        if (s.hasNext())
        {
            i = intValue((String)s.next());
        }
        minorCode = i;
        localPlayback = flag;
    }

    private int intValue(String s)
    {
        int i;
        try
        {
            i = Integer.valueOf(s).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        return i;
    }

    public int getMajorCode()
    {
        return majorCode;
    }

    public int getMinorCode()
    {
        return minorCode;
    }

    public String getRawCode()
    {
        return rawCode;
    }

    public boolean isLocalPlayback()
    {
        return localPlayback;
    }
}

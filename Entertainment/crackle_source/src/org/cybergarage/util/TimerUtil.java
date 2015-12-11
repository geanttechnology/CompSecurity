// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.util;


public final class TimerUtil
{

    public TimerUtil()
    {
    }

    public static final void wait(int i)
    {
        long l = i;
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public static final void waitRandom(int i)
    {
        long l = (int)(Math.random() * (double)i);
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}

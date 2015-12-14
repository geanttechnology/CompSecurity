// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;


public class Numbers
{

    private Numbers()
    {
    }

    public static long convertMillisecondsToSecondsRoundedUp(long l)
    {
        return Math.round(Math.ceil((float)l / 1000F));
    }

    public static Double parseDouble(Object obj)
        throws ClassCastException
    {
        if (obj instanceof Number)
        {
            return Double.valueOf(((Number)obj).doubleValue());
        }
        if (obj instanceof String)
        {
            Double double1;
            try
            {
                double1 = Double.valueOf((String)obj);
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new ClassCastException((new StringBuilder()).append("Unable to parse ").append(obj).append(" as double.").toString());
            }
            return double1;
        } else
        {
            throw new ClassCastException((new StringBuilder()).append("Unable to parse ").append(obj).append(" as double.").toString());
        }
    }
}

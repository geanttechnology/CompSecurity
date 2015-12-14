// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Calendar;

public class fg
{

    private static String a = null;
    private static float b = 0.0F;

    public static int a(Long long1)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(long1.longValue());
        int i = calendar.get(1);
        return Calendar.getInstance().get(1) - i;
    }

}

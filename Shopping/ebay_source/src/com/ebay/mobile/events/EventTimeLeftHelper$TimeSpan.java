// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;


// Referenced classes of package com.ebay.mobile.events:
//            EventTimeLeftHelper

public static class days
{

    public final int days;
    public final int hours;
    public final int minutes;
    public final int seconds;
    private final int years;

    public _cls9(long l)
    {
        if (l <= 0L)
        {
            seconds = 0;
            minutes = 0;
            hours = 0;
            days = 0;
            years = 0;
            return;
        } else
        {
            days = (int)(l / 1000L / 60L / 60L / 24L);
            hours = (int)(l / 1000L / 60L / 60L) - days * 24;
            minutes = (int)(l / 1000L / 60L) - days * 24 - hours * 60;
            seconds = (int)(l / 1000L) - days * 24 - hours * 60 - minutes * 60;
            years = days / 365;
            return;
        }
    }
}

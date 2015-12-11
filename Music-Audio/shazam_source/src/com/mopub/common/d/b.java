// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class b
{

    protected static b a = new b();

    public b()
    {
    }

    public static Date a()
    {
        return new Date();
    }

    public static String b()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("Z", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getDefault());
        return simpledateformat.format(new Date());
    }

}

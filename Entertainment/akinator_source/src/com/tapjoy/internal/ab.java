// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ab
{

    private static final ThreadLocal a = new ThreadLocal() {

        protected final Object initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        }

    };
    private static final ThreadLocal b = new ThreadLocal() {

        protected final Object initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        }

    };

    public static String a(Date date)
    {
        return ((DateFormat)a.get()).format(date);
    }

}

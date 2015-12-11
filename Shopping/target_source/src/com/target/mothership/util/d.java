// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import com.target.a.a.b;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class d
{

    private static final String TAG = com/target/mothership/util/d.getSimpleName();

    public d()
    {
    }

    public static Date a(String s, String s1)
    {
        if (s1 == null || s == null)
        {
            return null;
        }
        s = (new SimpleDateFormat(s, Locale.US)).parse(s1, new ParsePosition(0));
        return s;
        s;
        b.a(TAG, "Unable to parse the date");
        return null;
        s;
        return null;
    }

}

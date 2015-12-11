// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import android.support.v7.aqo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter
{

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    public DateFormatter()
    {
    }

    public Date getFormattedDate(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = sdf.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "getFormattedDate : error parsing data", new Object[0]);
            return null;
        }
        return s;
    }
}

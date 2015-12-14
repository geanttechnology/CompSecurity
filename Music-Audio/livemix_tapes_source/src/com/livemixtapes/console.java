// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.util.Log;

public final class console
{

    private console()
    {
        throw new RuntimeException();
    }

    public static void log()
    {
        v("console", new Object[] {
            "null"
        });
    }

    public static transient void log(Object aobj[])
    {
        v("console", aobj);
    }

    public static transient void v(String s, Object aobj[])
    {
        String s2 = "";
        String s1 = s;
        if (s == null)
        {
            s1 = "console";
        }
        int i = 0;
        do
        {
            if (i >= aobj.length)
            {
                Log.v("console", s2.substring(1));
                if (!s1.equals("console"))
                {
                    Log.v(s1, s2.substring(1));
                }
                return;
            }
            if (aobj[i] != null)
            {
                String s3 = aobj[i].toString();
                s = s3;
                if (s3.length() == 0)
                {
                    s = " ";
                }
            } else
            {
                s = "null";
            }
            s2 = (new StringBuilder(String.valueOf(s2))).append(" ").append(s).toString();
            i++;
        } while (true);
    }
}

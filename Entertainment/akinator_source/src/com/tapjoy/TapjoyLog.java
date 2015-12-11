// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.util.Log;
import com.tapjoy.internal.gd;
import java.util.ArrayList;

public class TapjoyLog
{

    private static boolean a = false;
    private static boolean b = false;
    private static ArrayList c;

    public TapjoyLog()
    {
    }

    public static void clearLogHistory()
    {
        if (c != null)
        {
            c.clear();
        }
    }

    public static void d(String s, String s1)
    {
        if (a)
        {
            Log.d(s, s1);
        }
        if (b)
        {
            c.add(s1);
        }
    }

    public static void e(String s, String s1)
    {
        if (a)
        {
            Log.e(s, s1);
        }
        if (b)
        {
            c.add(s1);
        }
    }

    public static ArrayList getLogHistory()
    {
        return c;
    }

    public static void i(String s, String s1)
    {
        if (a)
        {
            if (s1.length() > 4096)
            {
                for (int j = 0; j <= s1.length() / 4096; j++)
                {
                    int l = (j + 1) * 4096;
                    int k = l;
                    if (l > s1.length())
                    {
                        k = s1.length();
                    }
                    Log.i(s, s1.substring(j * 4096, k));
                }

            } else
            {
                Log.i(s, s1);
            }
        }
        if (b)
        {
            c.add(s1);
        }
    }

    public static boolean isLoggingEnabled()
    {
        return a;
    }

    public static void saveLogHistory(boolean flag)
    {
        b = flag;
        if (flag)
        {
            c = new ArrayList(1024);
            return;
        } else
        {
            c = null;
            return;
        }
    }

    public static void setDebugEnabled(boolean flag)
    {
        Log.i("TapjoyLog", (new StringBuilder("enableLogging: ")).append(flag).toString());
        a = flag;
        gd.a().a(flag);
    }

    public static void v(String s, String s1)
    {
        if (a)
        {
            Log.v(s, s1);
        }
        if (b)
        {
            c.add(s1);
        }
    }

    public static void w(String s, String s1)
    {
        if (a)
        {
            Log.w(s, s1);
        }
        if (b)
        {
            c.add(s1);
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;

class x
{

    private final SharedPreferences a;

    x(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context cannot be null!");
        } else
        {
            a = context.getApplicationContext().getSharedPreferences("com.appdynamics.eumagent.runtime.agentState", 0);
            return;
        }
    }

    public void a(String s, long l)
    {
        a.edit().putLong(s, l).commit();
    }

    public void a(String s, String s1)
    {
        a.edit().putString(s, s1).commit();
    }

    public void a(String s, boolean flag)
    {
        a.edit().putBoolean(s, flag).commit();
    }

    public long b(String s, long l)
    {
        return a.getLong(s, l);
    }

    public String b(String s, String s1)
    {
        return a.getString(s, s1);
    }

    public boolean b(String s, boolean flag)
    {
        return a.getBoolean(s, false);
    }
}

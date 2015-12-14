// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import myobfuscated.f.m;

public final class a
{

    public Context a;
    public final String b;

    public a(Context context)
    {
        a = null;
        this;
        JVM INSTR monitorenter ;
        a = context;
        this;
        JVM INSTR monitorexit ;
        context = context.getResources().getString(m.e(context, "app_name_short"));
        b = (new StringBuilder("sinPref_")).append(context).toString();
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    private int d(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = a.getSharedPreferences(b, 0).getInt(s, 0);
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public final int a()
    {
        return a.getSharedPreferences(b, 0).getInt("textureMaxSize", 0);
    }

    public final int a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        int i;
        obj = a.getSharedPreferences(b, 0);
        i = ((SharedPreferences) (obj)).getInt(s, 0);
        obj = ((SharedPreferences) (obj)).edit();
        i++;
        ((android.content.SharedPreferences.Editor) (obj)).putInt(s, i).commit();
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public final void a(int i)
    {
        android.content.SharedPreferences.Editor editor = a.getSharedPreferences(b, 0).edit();
        editor.putInt("textureMaxSize", i);
        editor.commit();
    }

    public final void a(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        a.getSharedPreferences((new StringBuilder()).append(b).append("boolean_values").toString(), 0).edit().putBoolean(s, flag).commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final boolean b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.getSharedPreferences((new StringBuilder()).append(b).append("boolean_values").toString(), 0).getBoolean(s, false);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public final int c(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = d(s);
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    // Unreferenced inner class com/socialin/android/util/a$1

/* anonymous class */
    public final class _cls1 extends Thread
    {

        private a a;

        public final void run()
        {
            Object obj = a;
            int i = ((a) (obj)).a.getSharedPreferences(((a) (obj)).b, 0).getInt("visitsCount", 0);
            obj = a.a.getSharedPreferences(a.b, 0).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putInt("visitsCount", i + 1);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
        }

            public 
            {
                a = a.this;
                super();
            }
    }

}

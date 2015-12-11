// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.j;

import android.support.v4.view.q;
import android.view.MenuItem;
import android.view.View;
import com.helpshift.app.e;

public class com.helpshift.j.c
{
    public static interface a
    {

        public abstract boolean e();

        public abstract boolean f();
    }

    public static interface b
    {

        public abstract void a(boolean flag);
    }

    public static interface c
    {

        public abstract boolean b(String s);

        public abstract boolean c(String s);
    }


    private static boolean a;

    public static View a(MenuItem menuitem)
    {
        if (menuitem instanceof e)
        {
            return ((e)menuitem).getActionView();
        } else
        {
            return q.a(menuitem);
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}

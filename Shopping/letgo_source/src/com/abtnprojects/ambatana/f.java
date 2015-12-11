// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.app.Activity;
import android.support.v7.all;
import android.view.LayoutInflater;

public class f
{

    private all a;

    public f()
    {
    }

    public void a()
    {
        all.a();
    }

    public void a(Activity activity)
    {
        if (activity != null)
        {
            android.view.View view = activity.getLayoutInflater().inflate(0x7f040063, null);
            if (a != null)
            {
                all.a(a);
            }
            a = all.a(activity, view, 0x7f100091, (new android.support.v7.alk.a()).a(4000).b(0x10a0000).c(0x10a0001).a());
            a.b();
        }
    }
}

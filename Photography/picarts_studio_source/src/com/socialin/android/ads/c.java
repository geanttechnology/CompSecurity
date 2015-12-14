// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.picsart.studio.ads.i;
import com.socialin.android.util.Utils;

public class c
{

    String a;
    public boolean b;
    i c;
    int d;
    int e;
    Context f;
    ViewGroup g;

    public c(Context context, ViewGroup viewgroup, String s, boolean flag)
    {
        c = null;
        d = 320;
        e = 50;
        f = context;
        g = viewgroup;
        a = s;
        if (Utils.i(f) && flag)
        {
            d = (int)TypedValue.applyDimension(1, 728F, f.getResources().getDisplayMetrics());
            e = (int)TypedValue.applyDimension(1, 90F, f.getResources().getDisplayMetrics());
            return;
        } else
        {
            d = (int)TypedValue.applyDimension(1, 320F, f.getResources().getDisplayMetrics());
            e = (int)TypedValue.applyDimension(1, 50F, f.getResources().getDisplayMetrics());
            return;
        }
    }

    public final void a()
    {
        b = false;
        if (c != null)
        {
            c.b();
        }
    }

    static 
    {
        (new StringBuilder()).append(com/socialin/android/ads/c.getName()).append(" - ");
    }
}

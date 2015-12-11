// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.sheet;

import android.os.Handler;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.fragment.g.b;
import com.shazam.android.fragment.g.c;
import com.shazam.model.analytics.AnalyticsInfo;
import java.util.ArrayList;

public abstract class a extends BaseAppCompatActivity
    implements c
{

    private final Handler a = com.shazam.i.b.z.a.a();

    public a()
    {
    }

    protected final void a(ArrayList arraylist)
    {
        a.post(new Runnable(arraylist) {

            final int a = 0x7f090145;
            final ArrayList b;
            final AnalyticsInfo c = null;
            final a d;

            public final void run()
            {
                com.shazam.android.fragment.g.b.a(a, b, c).a(d.getSupportFragmentManager());
            }

            
            {
                d = a.this;
                b = arraylist;
                super();
            }
        });
    }

    public final void d()
    {
        finish();
    }
}

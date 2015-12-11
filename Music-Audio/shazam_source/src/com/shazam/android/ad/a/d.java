// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.a;

import android.app.Activity;
import com.b.a.i;
import com.shazam.android.ac.c;
import java.util.concurrent.Executor;

public final class d extends c
{

    private final Executor a;

    public d(Executor executor)
    {
        a = executor;
    }

    public final void onActivityPaused(Activity activity)
    {
        a.execute(new Runnable() {

            final d a;

            public final void run()
            {
                i.b();
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    public final void onActivityResumed(Activity activity)
    {
        a.execute(new Runnable() {

            final d a;

            public final void run()
            {
                i.a();
            }

            
            {
                a = d.this;
                super();
            }
        });
    }
}

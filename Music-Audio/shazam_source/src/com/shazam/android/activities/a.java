// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.view.View;
import android.view.ViewTreeObserver;
import at.markushi.ui.RevealColorView;
import com.shazam.i.b.h.b;

public final class a
{

    final View a;
    final RevealColorView b;
    final Runnable c;
    final com.shazam.android.b.b d;
    final long e;

    public a(View view, RevealColorView revealcolorview)
    {
        this(view, revealcolorview, null);
    }

    public a(View view, RevealColorView revealcolorview, Runnable runnable)
    {
        d = com.shazam.i.b.h.b.a();
        e = (long)(400F * d.a());
        a = view;
        b = revealcolorview;
        c = runnable;
    }

    public final void a(int i, boolean flag)
    {
        if (flag)
        {
            a.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(i) {

                final int a;
                final a b;

                public final boolean onPreDraw()
                {
                    b.a.getViewTreeObserver().removeOnPreDrawListener(this);
                    b.b.postDelayed(new Runnable(this) {

                        final _cls1 a;

                        public final void run()
                        {
                            long l = (long)(300F * a.b.d.a());
                            int ai[] = new int[2];
                            a.b.a.getLocationInWindow(ai);
                            a.b.b.a(ai[0] + a.b.a.getWidth() / 2, ai[1] + a.b.a.getHeight() / 2, a.a, l, null);
                            if (a.b.c != null)
                            {
                                a.b.b.postDelayed(a.b.c, l / 2L);
                            }
                        }

            
            {
                a = _pcls1;
                super();
            }
                    }, b.e);
                    return true;
                }

            
            {
                b = a.this;
                a = i;
                super();
            }
            });
        } else
        {
            b.setBackgroundColor(i);
            if (c != null)
            {
                c.run();
                return;
            }
        }
    }
}

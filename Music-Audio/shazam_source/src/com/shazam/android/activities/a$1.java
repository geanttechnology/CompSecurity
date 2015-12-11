// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.view.View;
import android.view.ViewTreeObserver;
import at.markushi.ui.RevealColorView;
import com.shazam.android.b.b;

// Referenced classes of package com.shazam.android.activities:
//            a

final class a
    implements android.view.TreeObserver.OnPreDrawListener
{

    final int a;
    final a b;

    public final boolean onPreDraw()
    {
        b.a.getViewTreeObserver().removeOnPreDrawListener(this);
        b.b.postDelayed(new Runnable() {

            final a._cls1 a;

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
                a = a._cls1.this;
                super();
            }
        }, b.e);
        return true;
    }

    _cls1.a(a a1, int i)
    {
        b = a1;
        a = i;
        super();
    }
}

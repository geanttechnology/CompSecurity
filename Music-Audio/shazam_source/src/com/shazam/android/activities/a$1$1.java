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
    implements Runnable
{

    final a a;

    public final void run()
    {
        long l = (long)(300F * a.a.d.a());
        int ai[] = new int[2];
        a.a.a.getLocationInWindow(ai);
        a.a.b.a(ai[0] + a.a.a.getWidth() / 2, ai[1] + a.a.a.getHeight() / 2, a.a, l, null);
        if (a.a.c != null)
        {
            a.a.b.postDelayed(a.a.c, l / 2L);
        }
    }

    rawListener(rawListener rawlistener)
    {
        a = rawlistener;
        super();
    }

    // Unreferenced inner class com/shazam/android/activities/a$1

/* anonymous class */
    final class a._cls1
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final int a;
        final a b;

        public final boolean onPreDraw()
        {
            b.a.getViewTreeObserver().removeOnPreDrawListener(this);
            b.b.postDelayed(new a._cls1._cls1(this), b.e);
            return true;
        }

            
            {
                b = a1;
                a = i;
                super();
            }
    }

}

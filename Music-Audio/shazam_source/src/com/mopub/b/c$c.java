// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.mopub.b:
//            c

public static final class w
{
    static final class a
    {

        final View a[];
        final Handler b;
        Runnable c;
        int d;
        final Runnable e;

        static void a(a a1)
        {
            a1.d = a1.d - 1;
            if (a1.d == 0 && a1.c != null)
            {
                a1.c.run();
                a1.c = null;
            }
        }

        private a(Handler handler, View aview[])
        {
            e = new _cls1(this);
            b = handler;
            a = aview;
        }

        a(Handler handler, View aview[], byte byte0)
        {
            this(handler, aview);
        }
    }


    final Handler a = new Handler();
    a b;

    public final void a()
    {
        if (b != null)
        {
            a a1 = b;
            a1.b.removeCallbacks(a1.e);
            a1.c = null;
            b = null;
        }
    }

    w()
    {
    }

    // Unreferenced inner class com/mopub/b/c$c$a$1

/* anonymous class */
    final class a._cls1
        implements Runnable
    {

        final a a;

        public final void run()
        {
            View aview[] = a.a;
            int j = aview.length;
            int i = 0;
            while (i < j) 
            {
                View view = aview[i];
                if (view.getHeight() > 0 || view.getWidth() > 0)
                {
                    a.a(a);
                } else
                {
                    view.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(this, view) {

                        final View a;
                        final a._cls1 b;

                        public final boolean onPreDraw()
                        {
                            a.getViewTreeObserver().removeOnPreDrawListener(this);
    final class a._cls1
        implements Runnable
    {
                            a.a(b.a);
                            return true;
                        }

            
            {
                b = _pcls1;
                a = view;
                super();
            }
                    });
                }
                i++;
            }
        }

            
            {
                a = a1;
                super();
            }
    }

}

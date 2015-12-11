// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.mopub.b:
//            c

static final class 
{

    final View a[];
    final Handler b;
    Runnable c;
    int d;
    final Runnable e;

    static void a( )
    {
        .d = .d - 1;
        if (.d == 0 && .c != null)
        {
            .c.run();
            .c = null;
        }
    }

    private (Handler handler, View aview[])
    {
        e = new Runnable() {

            final c.c.a a;

            public final void run()
            {
                View aview1[] = a.a;
                int j = aview1.length;
                int i = 0;
                while (i < j) 
                {
                    View view = aview1[i];
                    if (view.getHeight() > 0 || view.getWidth() > 0)
                    {
                        c.c.a.a(a);
                    } else
                    {
                        view.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(this, view) {

                            final View a;
                            final _cls1 b;

                            public final boolean onPreDraw()
                            {
                                a.getViewTreeObserver().removeOnPreDrawListener(this);
                                c.c.a.a(b.a);
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
                a = c.c.a.this;
                super();
            }
        };
        b = handler;
        a = aview;
    }

    (Handler handler, View aview[], byte byte0)
    {
        this(handler, aview);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.google.ads.conversiontracking:
//            j, h

public abstract class c
{

    public c()
    {
    }

    protected void a(Context context, j.c c1, boolean flag, boolean flag1, boolean flag2)
    {
        (new Thread(new Runnable(context, c1, flag, flag1, flag2) {

            final Context a;
            final j.c b;
            final boolean c;
            final boolean d;
            final boolean e;
            final c f;

            public void run()
            {
                String s;
                try
                {
                    s = j.a(a, b);
                }
                catch (Exception exception)
                {
                    Log.e("GoogleConversionReporter", "Error sending ping", exception);
                    return;
                }
                if (s == null)
                {
                    break MISSING_BLOCK_LABEL_43;
                }
                j.a(a).a(s, b, c, d, e);
            }

            
            {
                f = c.this;
                a = context;
                b = c2;
                c = flag;
                d = flag1;
                e = flag2;
                super();
            }
        })).start();
    }
}

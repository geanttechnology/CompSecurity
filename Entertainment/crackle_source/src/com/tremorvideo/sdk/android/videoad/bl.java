// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Context;
import com.tremorvideo.sdk.android.a.c;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bf, ad, n

public class bl extends bf
    implements com.tremorvideo.sdk.android.a.i.b
{
    public class a
        implements Runnable
    {

        Context a;
        com.tremorvideo.sdk.android.a.i.b b;
        c c;
        final bl d;

        public void run()
        {
            c.a(a, b);
        }

        public a(Context context, com.tremorvideo.sdk.android.a.i.b b1, c c1)
        {
            d = bl.this;
            super();
            a = context;
            b = b1;
            c = c1;
        }
    }


    boolean a;
    Context b;
    n c;
    c d;

    public bl(bf.a a1, Context context, n n1)
    {
        super(a1);
        a = false;
        b = context;
        c = n1;
    }

    public void a(boolean flag, boolean flag1)
    {
        if (d != null)
        {
            d.f();
        }
        if (flag)
        {
            a(bf.b.b);
            return;
        }
        if (flag1)
        {
            ad.d("Xml Validation timed out");
            a(com.tremorvideo.sdk.android.videoad.bf.b.c);
            return;
        } else
        {
            ad.d("Buy It Now Xml invalid");
            a(com.tremorvideo.sdk.android.videoad.bf.b.c);
            return;
        }
    }

    protected void e()
    {
        d = c.y();
        if (d != null)
        {
            d.a(b);
            d.e();
            a a1 = new a(b, this, d);
            ((Activity)b).runOnUiThread(a1);
        }
    }

    protected void f()
    {
        a(bf.b.e);
    }

    protected void g()
    {
        d = c.y();
        if (d != null)
        {
            d.a(b);
            d.e();
            a a1 = new a(b, this, d);
            ((Activity)b).runOnUiThread(a1);
        }
    }

    public String toString()
    {
        return "JobProcessBuyItNow";
    }
}

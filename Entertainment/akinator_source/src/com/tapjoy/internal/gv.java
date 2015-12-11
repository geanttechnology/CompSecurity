// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Rect;

// Referenced classes of package com.tapjoy.internal:
//            bp, fr, bu, bq, 
//            cw, gr

public final class gv
{

    public static final bp g = new bp() {

        public final Object a(bu bu1)
        {
            gr gr1 = null;
            boolean flag = false;
            String s1 = "";
            bu1.i();
            String s = null;
            String s2 = null;
            Rect rect = null;
            while (bu1.k()) 
            {
                String s3 = bu1.m();
                if ("region".equals(s3))
                {
                    rect = (Rect)bu1.a(bq.b);
                } else
                if ("value".equals(s3))
                {
                    s2 = bu1.n();
                } else
                if ("dismiss".equals(s3))
                {
                    flag = bu1.o();
                } else
                if ("url".equals(s3))
                {
                    s1 = bu1.n();
                } else
                if ("redirect_url".equals(s3))
                {
                    s = cw.b(bu1.n());
                } else
                if (gr.a(s3))
                {
                    gr1 = gr.a(s3, bu1);
                } else
                {
                    bu1.t();
                }
            }
            bu1.j();
            return new gv(rect, s2, flag, s1, s, gr1);
        }

    };
    public final Rect a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final fr f;

    gv(Rect rect, String s, boolean flag, String s1, String s2, fr fr)
    {
        a = rect;
        b = s;
        c = flag;
        d = s1;
        e = s2;
        f = fr;
    }

}

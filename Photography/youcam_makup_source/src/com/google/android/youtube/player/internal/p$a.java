// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;

// Referenced classes of package com.google.android.youtube.player.internal:
//            p

final class <init> extends <init>
{

    final p a;

    public final void a(Bitmap bitmap, String s, boolean flag, boolean flag1)
    {
        p.a(a).post(new Runnable(flag, flag1, bitmap, s) {

            final boolean a;
            final boolean b;
            final Bitmap c;
            final String d;
            final p.a e;

            public final void run()
            {
                p.a(e.a, a);
                p.b(e.a, b);
                e.a.a(c, d);
            }

            
            {
                e = p.a.this;
                a = flag;
                b = flag1;
                c = bitmap;
                d = s;
                super();
            }
        });
    }

    public final void a(String s, boolean flag, boolean flag1)
    {
        p.a(a).post(new Runnable(flag, flag1, s) {

            final boolean a;
            final boolean b;
            final String c;
            final p.a d;

            public final void run()
            {
                p.a(d.a, a);
                p.b(d.a, b);
                d.a.b(c);
            }

            
            {
                d = p.a.this;
                a = flag;
                b = flag1;
                c = s;
                super();
            }
        });
    }

    private _cls2.c(p p1)
    {
        a = p1;
        super();
    }

    <init>(p p1, byte byte0)
    {
        this(p1);
    }
}

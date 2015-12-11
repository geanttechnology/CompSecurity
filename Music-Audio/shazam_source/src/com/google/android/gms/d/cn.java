// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Handler;
import com.google.android.gms.ads.internal.p;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            gi, co, cp, gm, 
//            he

public final class cn extends gi
{

    final he a;
    final cp b;
    private final String c;

    cn(he he, cp cp1, String s)
    {
        a = he;
        b = cp1;
        c = s;
        p.r().a.add(this);
    }

    public final void a()
    {
        b.a(c);
        gm.a.post(new Runnable() {

            final cn a;

            public final void run()
            {
                co co1 = p.r();
                cn cn1 = a;
                co1.a.remove(cn1);
            }

            
            {
                a = cn.this;
                super();
            }
        });
        return;
        Exception exception;
        exception;
        gm.a.post(new _cls1());
        throw exception;
    }

    public final void b()
    {
        b.a();
    }
}

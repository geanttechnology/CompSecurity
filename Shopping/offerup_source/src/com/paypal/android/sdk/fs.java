// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.paypal.android.sdk:
//            hb, fq, gq, gi, 
//            fr, gl, ft, gn, 
//            gd, ha, ju

final class fs extends hb
{

    final fq a;
    private final ft b;
    private final boolean c;

    private fs(fq fq1, ft ft1, boolean flag)
    {
        a = fq1;
        super("OkHttp %s", new Object[] {
            fq1.b.c()
        });
        b = ft1;
        c = flag;
    }

    fs(fq fq1, ft ft1, boolean flag, byte byte0)
    {
        this(fq1, ft1, false);
    }

    final String a()
    {
        return a.b.a().g();
    }

    final Object b()
    {
        return a.b.g();
    }

    protected final void c()
    {
        boolean flag = true;
        Object obj;
        boolean flag1;
        obj = a;
        flag1 = c;
        obj = (new fr(((fq) (obj)), 0, ((fq) (obj)).b, flag1)).a(((fq) (obj)).b);
        flag1 = a.a;
        if (!flag1) goto _L2; else goto _L1
_L1:
        b.a(a.b, new IOException("Canceled"));
_L4:
        fq.a(a).r().b(this);
        return;
_L2:
        b.a(((gu) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
_L10:
        if (!flag) goto _L6; else goto _L5
_L5:
        Logger logger;
        Level level;
        StringBuilder stringbuilder;
        Object obj2;
        logger = ha.a;
        level = Level.INFO;
        stringbuilder = new StringBuilder("Callback failure for ");
        obj2 = a;
        String s;
        if (((fq) (obj2)).a)
        {
            s = "canceled call";
        } else
        {
            s = "call";
        }
        obj2 = ((fq) (obj2)).b.a().c("/...");
        logger.log(level, stringbuilder.append((new StringBuilder()).append(s).append(" to ").append(obj2).toString()).toString(), ((Throwable) (obj1)));
_L8:
        fq.a(a).r().b(this);
        return;
_L6:
        b.a(a.c.d(), ((IOException) (obj1)));
        if (true) goto _L8; else goto _L7
_L7:
        obj1;
        fq.a(a).r().b(this);
        throw obj1;
        obj1;
        flag = false;
        if (true) goto _L10; else goto _L9
_L9:
    }
}

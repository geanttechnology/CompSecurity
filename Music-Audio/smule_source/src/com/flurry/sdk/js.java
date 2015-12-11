// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Referenced classes of package com.flurry.sdk:
//            ir, jx, jy, io, 
//            jz, is, jw, ia

public final class js extends ir
{

    public static final is a = new is() {

        public ir a(ia ia, jw jw1)
        {
            if (jw1.a() == java/sql/Date)
            {
                return new js();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    public js()
    {
    }

    public Date a(jx jx1)
    {
        this;
        JVM INSTR monitorenter ;
        if (jx1.f() != jy.i) goto _L2; else goto _L1
_L1:
        jx1.j();
        jx1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return jx1;
_L2:
        jx1 = new Date(b.parse(jx1.h()).getTime());
        if (true) goto _L4; else goto _L3
_L3:
        jx1;
        throw new io(jx1);
        jx1;
        this;
        JVM INSTR monitorexit ;
        throw jx1;
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (Date)obj);
    }

    public void a(jz jz1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        date = null;
_L4:
        jz1.b(date);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        date = b.format(date);
        if (true) goto _L4; else goto _L3
_L3:
        jz1;
        throw jz1;
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

}

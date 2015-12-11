// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.u;
import com.google.b.x;
import com.google.b.y;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class j extends x
{

    public static final y a = new y() {

        public final x a(f f, com.google.b.c.a a1)
        {
            if (a1.a == java/sql/Date)
            {
                return new j();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    public j()
    {
    }

    private void a(c c1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        date = null;
_L4:
        c1.b(date);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        date = b.format(date);
        if (true) goto _L4; else goto _L3
_L3:
        c1;
        throw c1;
    }

    private Date b(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a1.f() != b.i) goto _L2; else goto _L1
_L1:
        a1.k();
        a1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return a1;
_L2:
        a1 = new Date(b.parse(a1.i()).getTime());
        if (true) goto _L4; else goto _L3
_L3:
        a1;
        throw new u(a1);
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(c c1, Object obj)
    {
        a(c1, (Date)obj);
    }

}

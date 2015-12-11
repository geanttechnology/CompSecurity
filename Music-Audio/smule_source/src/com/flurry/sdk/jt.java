// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.flurry.sdk:
//            ir, jx, jy, io, 
//            jz, is, jw, ia

public final class jt extends ir
{

    public static final is a = new is() {

        public ir a(ia ia, jw jw1)
        {
            if (jw1.a() == java/sql/Time)
            {
                return new jt();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    public jt()
    {
    }

    public Time a(jx jx1)
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
        jx1 = new Time(b.parse(jx1.h()).getTime());
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
        a(jz1, (Time)obj);
    }

    public void a(jz jz1, Time time)
    {
        this;
        JVM INSTR monitorenter ;
        if (time != null) goto _L2; else goto _L1
_L1:
        time = null;
_L4:
        jz1.b(time);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        time = b.format(time);
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.flurry.sdk:
//            ir, io, jx, jy, 
//            jz, is, jw, ia

public final class jl extends ir
{

    public static final is a = new is() {

        public ir a(ia ia, jw jw1)
        {
            if (jw1.a() == java/util/Date)
            {
                return new jl();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat b;
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat d = a();

    public jl()
    {
        b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    }

    private static DateFormat a()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpledateformat;
    }

    private Date a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Date date = c.parse(s);
        s = date;
_L1:
        this;
        JVM INSTR monitorexit ;
        return s;
        ParseException parseexception;
        parseexception;
        parseexception = b.parse(s);
        s = parseexception;
          goto _L1
        parseexception;
        parseexception = d.parse(s);
        s = parseexception;
          goto _L1
        parseexception;
        throw new io(s, parseexception);
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Date a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        } else
        {
            return a(jx1.h());
        }
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
        jz1.f();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        jz1.b(b.format(date));
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.f;
import com.google.b.u;
import com.google.b.x;
import com.google.b.y;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class c extends x
{

    public static final y a = new y() {

        public final x a(f f, com.google.b.c.a a1)
        {
            if (a1.a == java/util/Date)
            {
                return new c();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat b;
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat d;

    public c()
    {
        b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        d = simpledateformat;
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
        throw new u(s, parseexception);
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void a(com.google.b.d.c c1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        c1.f();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        c1.b(b.format(date));
        if (true) goto _L4; else goto _L3
_L3:
        c1;
        throw c1;
    }

    public final Object a(a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        } else
        {
            return a(a1.i());
        }
    }

    public final volatile void a(com.google.b.d.c c1, Object obj)
    {
        a(c1, (Date)obj);
    }

}

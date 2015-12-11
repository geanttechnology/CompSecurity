// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import com.google.b.d.c;
import com.google.b.x;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

public final class a extends x
{

    private final b.a.d.a a;

    public a()
    {
        a = new b.a.d.a();
    }

    public a(TimeZone timezone)
    {
        a = new b.a.d.a(timezone);
    }

    private Date b(com.google.b.d.a a1)
    {
        a1 = a1.i();
        Date date;
        try
        {
            date = a.parse(a1);
        }
        catch (ParseException parseexception)
        {
            throw new IOException((new StringBuilder("Could not parse date ")).append(a1).toString(), parseexception);
        }
        return date;
    }

    public final Object a(com.google.b.d.a a1)
    {
        return b(a1);
    }

    public final void a(c c1, Object obj)
    {
        obj = (Date)obj;
        c1.b(a.format(((Date) (obj))));
    }
}

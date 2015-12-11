// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.flurry.sdk:
//            if, in, ig, io, 
//            il, ik, im, ie

final class hv
    implements if, in
{

    private final DateFormat a;
    private final DateFormat b;
    private final DateFormat c;

    hv()
    {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public hv(int i, int j)
    {
        this(DateFormat.getDateTimeInstance(i, j, Locale.US), DateFormat.getDateTimeInstance(i, j));
    }

    hv(String s)
    {
        this(((DateFormat) (new SimpleDateFormat(s, Locale.US))), ((DateFormat) (new SimpleDateFormat(s))));
    }

    hv(DateFormat dateformat, DateFormat dateformat1)
    {
        a = dateformat;
        b = dateformat1;
        c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date a(ig ig1)
    {
        dateformat;
        JVM INSTR monitorenter ;
        Date date;
        synchronized (b)
        {
            date = b.parse(ig1.b());
        }
        return date;
        ParseException parseexception;
        parseexception;
        Date date1 = a.parse(ig1.b());
        dateformat;
        JVM INSTR monitorexit ;
        return date1;
        ig1;
        dateformat;
        JVM INSTR monitorexit ;
        throw ig1;
        date1;
        date1 = c.parse(ig1.b());
        dateformat;
        JVM INSTR monitorexit ;
        return date1;
        date1;
        throw new io(ig1.b(), date1);
    }

    public volatile ig a(Object obj, Type type, im im)
    {
        return a((Date)obj, type, im);
    }

    public ig a(Date date, Type type, im im)
    {
        synchronized (b)
        {
            date = new il(a.format(date));
        }
        return date;
        date;
        type;
        JVM INSTR monitorexit ;
        throw date;
    }

    public Date a(ig ig1, Type type, ie ie)
    {
        if (!(ig1 instanceof il))
        {
            throw new ik("The date should be a string value");
        }
        ig1 = a(ig1);
        if (type == java/util/Date)
        {
            return ig1;
        }
        if (type == java/sql/Timestamp)
        {
            return new Timestamp(ig1.getTime());
        }
        if (type == java/sql/Date)
        {
            return new java.sql.Date(ig1.getTime());
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append(getClass()).append(" cannot deserialize to ").append(type).toString());
        }
    }

    public Object b(ig ig1, Type type, ie ie)
    {
        return a(ig1, type, ie);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(com/flurry/sdk/hv.getSimpleName());
        stringbuilder.append('(').append(b.getClass().getSimpleName()).append(')');
        return stringbuilder.toString();
    }
}

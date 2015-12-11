// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package android.support.v7:
//            aez, afh, afa, afi, 
//            aff, afe, afg, aey

final class aep
    implements aez, afh
{

    private final DateFormat a;
    private final DateFormat b;
    private final DateFormat c;

    aep()
    {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public aep(int i, int j)
    {
        this(DateFormat.getDateTimeInstance(i, j, Locale.US), DateFormat.getDateTimeInstance(i, j));
    }

    aep(String s)
    {
        this(((DateFormat) (new SimpleDateFormat(s, Locale.US))), ((DateFormat) (new SimpleDateFormat(s))));
    }

    aep(DateFormat dateformat, DateFormat dateformat1)
    {
        a = dateformat;
        b = dateformat1;
        c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date a(afa afa1)
    {
        dateformat;
        JVM INSTR monitorenter ;
        Date date;
        synchronized (b)
        {
            date = b.parse(afa1.b());
        }
        return date;
        ParseException parseexception;
        parseexception;
        Date date1 = a.parse(afa1.b());
        dateformat;
        JVM INSTR monitorexit ;
        return date1;
        afa1;
        dateformat;
        JVM INSTR monitorexit ;
        throw afa1;
        date1;
        date1 = c.parse(afa1.b());
        dateformat;
        JVM INSTR monitorexit ;
        return date1;
        date1;
        throw new afi(afa1.b(), date1);
    }

    public volatile afa a(Object obj, Type type, afg afg)
    {
        return a((Date)obj, type, afg);
    }

    public afa a(Date date, Type type, afg afg)
    {
        synchronized (b)
        {
            date = new aff(a.format(date));
        }
        return date;
        date;
        type;
        JVM INSTR monitorexit ;
        throw date;
    }

    public Date a(afa afa1, Type type, aey aey)
        throws afe
    {
        if (!(afa1 instanceof aff))
        {
            throw new afe("The date should be a string value");
        }
        afa1 = a(afa1);
        if (type == java/util/Date)
        {
            return afa1;
        }
        if (type == java/sql/Timestamp)
        {
            return new Timestamp(afa1.getTime());
        }
        if (type == java/sql/Date)
        {
            return new java.sql.Date(afa1.getTime());
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append(getClass()).append(" cannot deserialize to ").append(type).toString());
        }
    }

    public Object b(afa afa1, Type type, aey aey)
        throws afe
    {
        return a(afa1, type, aey);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(android/support/v7/aep.getSimpleName());
        stringbuilder.append('(').append(b.getClass().getSimpleName()).append(')');
        return stringbuilder.toString();
    }
}

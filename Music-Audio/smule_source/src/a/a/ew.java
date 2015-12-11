// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package a.a:
//            ex, ey

public final class ew
{

    public static final ew a = new ew();
    private ey b;
    private ThreadLocal c;

    private ew()
    {
        b = new ex(this, (byte)0);
        c = new ThreadLocal();
    }

    private SimpleDateFormat b()
    {
        SimpleDateFormat simpledateformat1 = (SimpleDateFormat)c.get();
        SimpleDateFormat simpledateformat = simpledateformat1;
        if (simpledateformat1 == null)
        {
            simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
            simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
            simpledateformat.setLenient(false);
            c.set(simpledateformat);
        }
        return simpledateformat;
    }

    public final long a(String s)
    {
        return b().parse(s).getTime();
    }

    public final String a()
    {
        return a(b.a());
    }

    public final String a(Date date)
    {
        return b().format(date);
    }

}

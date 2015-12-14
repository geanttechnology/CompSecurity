// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;

import java.util.Date;
import org.jivesoftware.smack.util.r;

// Referenced classes of package org.jivesoftware.smack.packet:
//            e

public class StreamMgmt extends e
{

    private String a;
    private String b;
    private Date d;
    private String e;

    public StreamMgmt()
    {
        b = "U";
        d = new Date(0L);
        j("U");
    }

    public String a()
    {
        return a;
    }

    public void a(String s)
    {
        e = s;
    }

    public void a(Date date)
    {
        d = date;
    }

    public Date c()
    {
        return d;
    }

    public String d()
    {
        return e;
    }

    public r e()
    {
        r r1 = new r();
        r1.a("r");
        r1.d(e_());
        r1.e(a());
        r1.d("id", q());
        if (d != null && d != new Date(0L))
        {
            r1.d("ts", String.valueOf(d.getTime()));
        }
        r1.a();
        return r1;
    }

    public String e_()
    {
        return b;
    }

    public CharSequence g()
    {
        return e();
    }

    public String toString()
    {
        return e().toString();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


// Referenced classes of package netswipe:
//            dk, dp, dt

public class dj
{

    private final String a;
    private final dk b;
    private final dt c;

    public dj(String s, dt dt1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (dt1 == null)
        {
            throw new IllegalArgumentException("Body may not be null");
        } else
        {
            a = s;
            c = dt1;
            b = new dk();
            a(dt1);
            b(dt1);
            c(dt1);
            return;
        }
    }

    public String a()
    {
        return a;
    }

    public void a(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Field name may not be null");
        } else
        {
            b.a(new dp(s, s1));
            return;
        }
    }

    protected void a(dt dt1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("form-data; name=\"");
        stringbuilder.append(a());
        stringbuilder.append("\"");
        if (dt1.b() != null)
        {
            stringbuilder.append("; filename=\"");
            stringbuilder.append(dt1.b());
            stringbuilder.append("\"");
        }
        a("Content-Disposition", stringbuilder.toString());
    }

    public dt b()
    {
        return c;
    }

    protected void b(dt dt1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(dt1.a());
        if (dt1.c() != null)
        {
            stringbuilder.append("; charset=");
            stringbuilder.append(dt1.c());
        }
        a("Content-Type", stringbuilder.toString());
    }

    public dk c()
    {
        return b;
    }

    protected void c(dt dt1)
    {
        a("Content-Transfer-Encoding", dt1.d());
    }
}

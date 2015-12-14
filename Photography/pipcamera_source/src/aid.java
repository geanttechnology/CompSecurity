// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class aid
{

    private final String a;
    private final aie b;
    private final ail c;

    public aid(String s, ail ail1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (ail1 == null)
        {
            throw new IllegalArgumentException("Body may not be null");
        } else
        {
            a = s;
            c = ail1;
            b = new aie();
            a(ail1);
            b(ail1);
            c(ail1);
            return;
        }
    }

    public String a()
    {
        return a;
    }

    protected void a(ail ail1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("form-data; name=\"");
        stringbuilder.append(a());
        stringbuilder.append("\"");
        if (ail1.b() != null)
        {
            stringbuilder.append("; filename=\"");
            stringbuilder.append(ail1.b());
            stringbuilder.append("\"");
        }
        a("Content-Disposition", stringbuilder.toString());
    }

    public void a(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Field name may not be null");
        } else
        {
            b.a(new aih(s, s1));
            return;
        }
    }

    public ail b()
    {
        return c;
    }

    protected void b(ail ail1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(ail1.a());
        if (ail1.c() != null)
        {
            stringbuilder.append("; charset=");
            stringbuilder.append(ail1.c());
        }
        a("Content-Type", stringbuilder.toString());
    }

    public aie c()
    {
        return b;
    }

    protected void c(ail ail1)
    {
        a("Content-Transfer-Encoding", ail1.d());
    }
}

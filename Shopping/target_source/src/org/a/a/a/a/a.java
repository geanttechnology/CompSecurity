// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;

import org.a.a.a.a.a.c;
import org.a.a.a.a.a.d;
import org.a.a.a.a.a.f;
import org.a.a.a.a.b.b;

// Referenced classes of package org.a.a.a.a:
//            i, d

public class a
{

    private final String a;
    private final i b = new i();
    private final f c;

    public a(String s, f f1)
    {
        org.a.a.a.a.b.b.a(s, "Name");
        org.a.a.a.a.b.b.a(f1, "Body");
        a = s;
        c = f1;
        a(f1);
        b(f1);
        c(f1);
    }

    public String a()
    {
        return a;
    }

    public void a(String s, String s1)
    {
        org.a.a.a.a.b.b.a(s, "Field name");
        b.a(new org.a.a.a.a.d(s, s1));
    }

    protected void a(f f1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("form-data; name=\"");
        stringbuilder.append(a());
        stringbuilder.append("\"");
        if (f1.a() != null)
        {
            stringbuilder.append("; filename=\"");
            stringbuilder.append(f1.a());
            stringbuilder.append("\"");
        }
        a("Content-Disposition", stringbuilder.toString());
    }

    public f b()
    {
        return c;
    }

    protected void b(f f1)
    {
        Object obj;
        if (f1 instanceof d)
        {
            obj = ((d)f1).f();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            a("Content-Type", ((c) (obj)).toString());
            return;
        }
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append(f1.e());
        if (f1.b() != null)
        {
            ((StringBuilder) (obj)).append("; charset=");
            ((StringBuilder) (obj)).append(f1.b());
        }
        a("Content-Type", ((StringBuilder) (obj)).toString());
    }

    public i c()
    {
        return b;
    }

    protected void c(f f1)
    {
        a("Content-Transfer-Encoding", f1.c());
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import com.crittercism.app.CrittercismConfig;
import java.util.List;

// Referenced classes of package a.a:
//            at

public final class ae extends CrittercismConfig
{

    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public ae(String s, CrittercismConfig crittercismconfig)
    {
        super(crittercismconfig);
        b = "https://api.crittercism.com";
        c = "https://apm.crittercism.com";
        d = "https://txn.ingest.crittercism.com/api/v1/transactions";
        e = "https://appload.ingest.crittercism.com";
        f = "524c99a04002057fcd000001";
        s = at.a(s).a();
        b = (new StringBuilder("https://api.")).append(s).toString();
        c = (new StringBuilder("https://apm.")).append(s).toString();
        e = (new StringBuilder("https://appload.ingest.")).append(s).toString();
        d = (new StringBuilder("https://txn.ingest.")).append(s).append("/api/v1/transactions").toString();
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof ae))
        {
            return false;
        }
        ae ae1 = (ae)obj;
        return super.equals(obj) && a(b, ae1.b) && a(c, ae1.c) && a(d, ae1.d) && a(e, ae1.e) && a(f, ae1.f);
    }

    public final int hashCode()
    {
        return ((((super.hashCode() * 31 + b.hashCode()) * 31 + c.hashCode()) * 31 + d.hashCode()) * 31 + e.hashCode()) * 31 + f.hashCode();
    }

    public final List j()
    {
        List list = super.j();
        list.add(c);
        return list;
    }

    public final String k()
    {
        return b;
    }

    public final String l()
    {
        return c;
    }

    public final String m()
    {
        return d;
    }

    public final String n()
    {
        return e;
    }

    public final String o()
    {
        return f;
    }

    public final String p()
    {
        return a;
    }
}

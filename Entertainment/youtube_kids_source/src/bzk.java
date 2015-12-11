// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.List;
import org.apache.http.client.methods.HttpUriRequest;

public final class bzk extends cqz
{

    private bng b;
    private bzj c;
    private final cby d;

    public bzk(bkf bkf1, String s, List list, bng bng1, bzj bzj1, cby cby1)
    {
        super(bkf1, s, list);
        b = (bng)b.a(bng1);
        c = (bzj)b.a(bzj1);
        d = (cby)b.a(cby1);
    }

    public bzk(bkf bkf1, List list, bng bng1, bzj bzj1)
    {
        super(bkf1, list);
        b = (bng)b.a(bng1);
        c = (bzj)b.a(bzj1);
        d = null;
    }

    public bzk(bkf bkf1, List list, bng bng1, bzj bzj1, cby cby1)
    {
        super(bkf1, list);
        b = (bng)b.a(bng1);
        c = (bzj)b.a(bzj1);
        d = (cby)b.a(cby1);
    }

    private HttpUriRequest a(bzi bzi1)
    {
        bzi1 = super.b(bzi1);
        bzi1.setHeader("GData-Version", c.b);
        return bzi1;
    }

    public final volatile Object a(Object obj)
    {
        return a((bzi)obj);
    }

    protected final HttpUriRequest a(cqy cqy)
    {
        cqy = (bzi)cqy;
        if (b != null) goto _L2; else goto _L1
_L1:
        cqy = ((bzi) (cqy)).a;
_L4:
        Object obj = cqy;
        if (d != null)
        {
            cpj cpj1 = d.a.b();
            obj = cqy;
            if (cpj1 != cpj.a)
            {
                obj = cqy;
                if (cpj1.b.b())
                {
                    obj = cqy.buildUpon().appendQueryParameter("on-behalf-of", cpj1.b.d()).build();
                }
            }
        }
        return a.a(((Uri) (obj)));
_L2:
        Object obj1 = b;
        cqy = ((bzi) (cqy)).a;
        String s = cqy.toString();
        obj1 = ((bng) (obj1)).a(s);
        if (!s.equals(obj1))
        {
            cqy = Uri.parse(((String) (obj1)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final HttpUriRequest b(cqy cqy)
    {
        return a((bzi)cqy);
    }
}

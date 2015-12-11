// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public final class cic
{

    final Map a;
    final cie b;
    private final mh c;

    public cic(mh mh1)
    {
        this(mh1, ((Map) (new HashMap())));
    }

    private cic(mh mh1, Map map)
    {
        c = (mh)b.a(mh1);
        a = (Map)b.a(map);
        b = new cie();
    }

    public final aql a(Uri uri, String s)
    {
        b.b();
        crf crf1 = crf.a();
        uri = new cid(this, uri.toString(), crf1, s);
        uri.e = false;
        c.a(uri);
        try
        {
            uri = (aql)crf1.get();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new mp(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new mp(uri);
        }
        return uri;
    }
}

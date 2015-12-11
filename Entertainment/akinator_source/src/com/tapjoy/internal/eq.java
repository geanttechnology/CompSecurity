// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.net.http.AndroidHttpClient;
import android.util.Log;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.tapjoy.internal:
//            es, fn, fg, er, 
//            fk

class eq extends es
{

    private static final String e = com/tapjoy/internal/eq.getName();
    public fg a;

    public eq(AndroidHttpClient androidhttpclient, String s, er er1, Map map, fk fk)
    {
        super(androidhttpclient, es.a.a, s, er1, map, fk);
        a = null;
    }

    public final fk.c a()
    {
        if (b.f() == fk.c.b)
        {
            if (a != null && a.a())
            {
                return fk.c.b;
            } else
            {
                return fk.c.j;
            }
        } else
        {
            return super.a();
        }
    }

    public void run()
    {
        String s = e;
        (new StringBuilder("starting retrieval: ")).append(c).append("?").append(d.b());
        a = null;
        super.run();
        if (b() != 200)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        a = new fg();
        a.a(super.b.d().getEntity().getContent());
        return;
        IOException ioexception;
        ioexception;
        Log.e(e, "IO Error", ioexception);
        return;
    }

}

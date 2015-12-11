// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import android.support.v7.apv;
import android.support.v7.apw;
import android.support.v7.apx;
import android.support.v7.aqk;
import android.support.v7.aql;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpEngine, CacheRequest

class val.cacheBody
    implements aqk
{

    boolean cacheRequestClosed;
    final HttpEngine this$0;
    final apw val$cacheBody;
    final CacheRequest val$cacheRequest;
    final apx val$source;

    public void close()
        throws IOException
    {
        if (!cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
        {
            cacheRequestClosed = true;
            val$cacheRequest.abort();
        }
        val$source.close();
    }

    public long read(apv apv1, long l)
        throws IOException
    {
        try
        {
            l = val$source.read(apv1, l);
        }
        // Misplaced declaration of an exception variable
        catch (apv apv1)
        {
            if (!cacheRequestClosed)
            {
                cacheRequestClosed = true;
                val$cacheRequest.abort();
            }
            throw apv1;
        }
        if (l == -1L)
        {
            if (!cacheRequestClosed)
            {
                cacheRequestClosed = true;
                val$cacheBody.close();
            }
            return -1L;
        } else
        {
            apv1.a(val$cacheBody.b(), apv1.a() - l, l);
            val$cacheBody.v();
            return l;
        }
    }

    public aql timeout()
    {
        return val$source.timeout();
    }

    ()
    {
        this$0 = final_httpengine;
        val$source = apx1;
        val$cacheRequest = cacherequest;
        val$cacheBody = apw.this;
        super();
    }
}

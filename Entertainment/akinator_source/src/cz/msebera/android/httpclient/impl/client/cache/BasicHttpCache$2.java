// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateCallback;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            BasicHttpCache

class val.variantCacheKey
    implements HttpCacheUpdateCallback
{

    final BasicHttpCache this$0;
    final HttpCacheEntry val$entry;
    final HttpRequest val$req;
    final String val$variantCacheKey;
    final String val$variantKey;

    public HttpCacheEntry update(HttpCacheEntry httpcacheentry)
        throws IOException
    {
        return doGetUpdatedParentEntry(val$req.getRequestLine().getUri(), httpcacheentry, val$entry, val$variantKey, val$variantCacheKey);
    }

    k()
    {
        this$0 = final_basichttpcache;
        val$req = httprequest;
        val$entry = httpcacheentry;
        val$variantKey = s;
        val$variantCacheKey = String.this;
        super();
    }
}

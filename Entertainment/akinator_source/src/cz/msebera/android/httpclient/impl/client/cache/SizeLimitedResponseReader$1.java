// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            ResponseProxyHandler, SizeLimitedResponseReader

class this._cls0 extends ResponseProxyHandler
{

    final SizeLimitedResponseReader this$0;

    public void close()
        throws IOException
    {
        SizeLimitedResponseReader.access$000(SizeLimitedResponseReader.this).close();
    }

    Q(HttpResponse httpresponse)
    {
        this$0 = SizeLimitedResponseReader.this;
        super(httpresponse);
    }
}

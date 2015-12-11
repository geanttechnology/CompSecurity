// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            AsyncHttpClient

private static final class  extends HttpEntityWrapper
{

    public final InputStream getContent()
    {
        return new GZIPInputStream(wrappedEntity.getContent());
    }

    public final long getContentLength()
    {
        return -1L;
    }

    public (HttpEntity httpentity)
    {
        super(httpentity);
    }
}

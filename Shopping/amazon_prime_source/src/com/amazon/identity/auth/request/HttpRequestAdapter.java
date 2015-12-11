// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.request;

import android.net.Uri;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StreamUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;

// Referenced classes of package com.amazon.identity.auth.request:
//            IRequestAdapter

public class HttpRequestAdapter
    implements IRequestAdapter
{

    private static final String TAG = com/amazon/identity/auth/request/HttpRequestAdapter.getName();
    public final HttpRequest mHttpRequest;

    public HttpRequestAdapter(HttpRequest httprequest)
    {
        mHttpRequest = httprequest;
    }

    public byte[] getBody()
    {
        if (!(mHttpRequest instanceof HttpEntityEnclosingRequest))
        {
            return new byte[0];
        }
        HttpEntity httpentity = ((HttpEntityEnclosingRequest)mHttpRequest).getEntity();
        if (httpentity == null)
        {
            return new byte[0];
        }
        byte abyte0[];
        try
        {
            abyte0 = StreamUtils.readInputStream(httpentity.getContent());
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not turn body into byte array", ioexception);
            return new byte[0];
        }
        return abyte0;
    }

    public String getHeader(String s)
    {
        s = mHttpRequest.getFirstHeader(s);
        if (s == null)
        {
            return null;
        } else
        {
            return s.getValue();
        }
    }

    public Map getHeaders()
    {
        HashMap hashmap = new HashMap();
        Header aheader[] = mHttpRequest.getAllHeaders();
        int j = aheader.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = aheader[i];
            String s = ((Header) (obj)).getName();
            obj = ((Header) (obj)).getValue();
            if (!hashmap.containsKey(s))
            {
                hashmap.put(s, new ArrayList());
            }
            ((List)hashmap.get(s)).add(obj);
        }

        return hashmap;
    }

    public String getHttpVerb()
    {
        return mHttpRequest.getRequestLine().getMethod();
    }

    public Uri getUri()
    {
        return Uri.parse(mHttpRequest.getRequestLine().getUri());
    }

    public void setHeader(String s, String s1)
    {
        mHttpRequest.setHeader(s, s1);
    }

}

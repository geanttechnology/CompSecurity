// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.sponsorpay.utils:
//            UrlBuilder, SponsorPayLogger

public class SPHttpConnection
{

    private static final String TAG = "SPHttpConnection";
    private String mBody;
    private Map mHeaders;
    private List mHeadersToAdd;
    private boolean mOpen;
    private int mResponseCode;
    private URL mUrl;

    private SPHttpConnection(String s)
    {
        mOpen = false;
        mUrl = new URL(s);
    }

    public static SPHttpConnection getConnection(UrlBuilder urlbuilder)
    {
        return new SPHttpConnection(urlbuilder.buildUrl());
    }

    public static SPHttpConnection getConnection(String s)
    {
        return new SPHttpConnection(s);
    }

    private String readStream(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i <= 0)
            {
                bytearrayoutputstream.close();
                return new String(bytearrayoutputstream.toByteArray(), "UTF-8");
            }
            bytearrayoutputstream.write(abyte0, 0, i);
        } while (true);
    }

    public SPHttpConnection addHeader(String s, String s1)
    {
        if (mHeadersToAdd == null)
        {
            mHeadersToAdd = new LinkedList();
        }
        mHeadersToAdd.add(new Header(s, s1));
        return this;
    }

    public String getBodyContent()
    {
        if (!mOpen)
        {
            throw new IOException("The connection has not been opened yet.");
        } else
        {
            return mBody;
        }
    }

    public List getHeader(String s)
    {
        if (!mOpen)
        {
            throw new IOException("The connection has not been opened yet.");
        } else
        {
            return (List)mHeaders.get(s);
        }
    }

    public Map getHeaders()
    {
        if (!mOpen)
        {
            throw new IOException("The connection has not been opened yet.");
        } else
        {
            return mHeaders;
        }
    }

    public int getResponseCode()
    {
        if (!mOpen)
        {
            throw new IOException("The connection has not been opened yet.");
        } else
        {
            return mResponseCode;
        }
    }

    public SPHttpConnection open()
    {
        Object obj;
        Object obj3;
        obj = null;
        obj3 = null;
        Object obj1 = (HttpURLConnection)mUrl.openConnection();
        if (mHeadersToAdd == null) goto _L2; else goto _L1
_L1:
        obj = mHeadersToAdd.iterator();
_L4:
        boolean flag = ((Iterator) (obj)).hasNext();
        if (flag) goto _L3; else goto _L2
_L2:
        obj = ((HttpURLConnection) (obj1)).getInputStream();
_L5:
        mBody = readStream(((InputStream) (obj)));
        mResponseCode = ((HttpURLConnection) (obj1)).getResponseCode();
        mHeaders = Collections.unmodifiableMap(((HttpURLConnection) (obj1)).getHeaderFields());
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        mOpen = true;
        return this;
_L3:
        Header header = (Header)((Iterator) (obj)).next();
        ((HttpURLConnection) (obj1)).addRequestProperty(header.key, header.value);
          goto _L4
        Object obj2;
        obj2;
_L8:
        obj = obj1;
        SponsorPayLogger.e("SPHttpConnection", ((Exception) (obj2)).getLocalizedMessage(), ((Exception) (obj2)));
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        mOpen = true;
        return this;
        obj;
        obj = ((HttpURLConnection) (obj1)).getErrorStream();
          goto _L5
        obj2;
        obj1 = obj;
        obj = obj2;
_L7:
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        mOpen = true;
        throw obj;
        obj;
        if (true) goto _L7; else goto _L6
_L6:
        obj2;
        obj1 = obj3;
          goto _L8
    }

    private class Header
    {

        String key;
        final SPHttpConnection this$0;
        String value;

        public Header(String s, String s1)
        {
            this$0 = SPHttpConnection.this;
            super();
            key = s;
            value = s1;
        }
    }

}

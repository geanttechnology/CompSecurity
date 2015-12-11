// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, AsyncHttpClient, LogInterface

public abstract class SaxAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    private static final String LOG_TAG = "SaxAsyncHttpRH";
    private DefaultHandler handler;

    public SaxAsyncHttpResponseHandler(DefaultHandler defaulthandler)
    {
        handler = null;
        if (defaulthandler == null)
        {
            throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
        } else
        {
            handler = defaulthandler;
            return;
        }
    }

    protected byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        Object obj;
        Object obj1;
        Object obj2;
        java.io.InputStream inputstream;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        inputstream = httpentity.getContent();
        obj2 = null;
        obj = null;
        obj1 = null;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        httpentity = ((HttpEntity) (obj));
        XMLReader xmlreader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        httpentity = ((HttpEntity) (obj));
        xmlreader.setContentHandler(handler);
        httpentity = ((HttpEntity) (obj));
        obj = new InputStreamReader(inputstream, getCharset());
        xmlreader.parse(new InputSource(((java.io.Reader) (obj))));
        AsyncHttpClient.silentCloseInputStream(inputstream);
        ParserConfigurationException parserconfigurationexception;
        if (obj != null)
        {
            try
            {
                ((InputStreamReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity) { }
        }
        return null;
        httpentity;
        obj = obj1;
        obj1 = httpentity;
_L6:
        httpentity = ((HttpEntity) (obj));
        AsyncHttpClient.log.e("SaxAsyncHttpRH", "getResponseData exception", ((Throwable) (obj1)));
        AsyncHttpClient.silentCloseInputStream(inputstream);
        if (obj != null)
        {
            try
            {
                ((InputStreamReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity) { }
        }
        break MISSING_BLOCK_LABEL_94;
        parserconfigurationexception;
        obj = obj2;
_L4:
        httpentity = ((HttpEntity) (obj));
        AsyncHttpClient.log.e("SaxAsyncHttpRH", "getResponseData exception", parserconfigurationexception);
        AsyncHttpClient.silentCloseInputStream(inputstream);
        if (obj != null)
        {
            try
            {
                ((InputStreamReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity) { }
        }
        break MISSING_BLOCK_LABEL_94;
        obj;
_L2:
        AsyncHttpClient.silentCloseInputStream(inputstream);
        if (httpentity != null)
        {
            try
            {
                httpentity.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity) { }
        }
        throw obj;
        parserconfigurationexception;
        httpentity = ((HttpEntity) (obj));
        obj = parserconfigurationexception;
        if (true) goto _L2; else goto _L1
_L1:
        parserconfigurationexception;
        if (true) goto _L4; else goto _L3
_L3:
        parserconfigurationexception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public abstract void onFailure(int i, Header aheader[], DefaultHandler defaulthandler);

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        onFailure(i, aheader, handler);
    }

    public abstract void onSuccess(int i, Header aheader[], DefaultHandler defaulthandler);

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        onSuccess(i, aheader, handler);
    }
}

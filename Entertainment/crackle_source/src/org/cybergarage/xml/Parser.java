// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.http.HTTPResponse;

// Referenced classes of package org.cybergarage.xml:
//            ParserException, Node

public abstract class Parser
{

    public Parser()
    {
    }

    public Node parse(File file)
        throws ParserException
    {
        Node node;
        try
        {
            file = new FileInputStream(file);
            node = parse(((InputStream) (file)));
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new ParserException(file);
        }
        return node;
    }

    public abstract Node parse(InputStream inputstream)
        throws ParserException;

    public Node parse(String s)
        throws ParserException
    {
        try
        {
            s = parse(((InputStream) (new ByteArrayInputStream(s.getBytes()))));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParserException(s);
        }
        return s;
    }

    public Node parse(URL url)
        throws ParserException
    {
        Object obj = url.getHost();
        int j = url.getPort();
        int i = j;
        if (j == -1)
        {
            i = 80;
        }
        String s = url.getPath();
        HttpURLConnection httpurlconnection;
        InputStream inputstream;
        Node node;
        try
        {
            httpurlconnection = (HttpURLConnection)url.openConnection();
            httpurlconnection.setRequestMethod("GET");
            httpurlconnection.setRequestProperty("Content-Length", "0");
        }
        catch (Exception exception)
        {
            HTTPRequest httprequest = new HTTPRequest();
            httprequest.setMethod("GET");
            httprequest.setURI(s);
            obj = httprequest.post(((String) (obj)), i);
            if (!((HTTPResponse) (obj)).isSuccessful())
            {
                throw new ParserException((new StringBuilder("HTTP comunication failed: no answer from peer.Unable to retrive resoure -> ")).append(url.toString()).toString());
            } else
            {
                return parse(((InputStream) (new ByteArrayInputStream((new String(((HTTPResponse) (obj)).getContent())).getBytes()))));
            }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        httpurlconnection.setRequestProperty("HOST", ((String) (obj)));
        inputstream = httpurlconnection.getInputStream();
        node = parse(inputstream);
        inputstream.close();
        httpurlconnection.disconnect();
        return node;
    }
}

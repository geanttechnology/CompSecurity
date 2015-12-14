// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.data;

import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.model.GlideUrl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// Referenced classes of package com.bumptech.glide.load.data:
//            DataFetcher

public class HttpUrlFetcher
    implements DataFetcher
{
    private static class DefaultHttpUrlConnectionFactory
        implements HttpUrlConnectionFactory
    {

        public HttpURLConnection build(URL url)
            throws IOException
        {
            return (HttpURLConnection)url.openConnection();
        }

        private DefaultHttpUrlConnectionFactory()
        {
        }

    }

    static interface HttpUrlConnectionFactory
    {

        public abstract HttpURLConnection build(URL url)
            throws IOException;
    }


    private static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private HttpURLConnection urlConnection;

    public HttpUrlFetcher(GlideUrl glideurl)
    {
        this(glideurl, DEFAULT_CONNECTION_FACTORY);
    }

    HttpUrlFetcher(GlideUrl glideurl, HttpUrlConnectionFactory httpurlconnectionfactory)
    {
        glideUrl = glideurl;
        connectionFactory = httpurlconnectionfactory;
    }

    private InputStream loadDataWithRedirects(URL url, int i, URL url1)
        throws IOException
    {
        if (i >= 5)
        {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url1 != null)
        {
            try
            {
                if (url.toURI().equals(url1.toURI()))
                {
                    throw new IOException("In re-direct loop");
                }
            }
            // Misplaced declaration of an exception variable
            catch (URL url1) { }
        }
        urlConnection = connectionFactory.build(url);
        urlConnection.setConnectTimeout(2500);
        urlConnection.setReadTimeout(2500);
        urlConnection.setUseCaches(false);
        urlConnection.setDoInput(true);
        urlConnection.connect();
        if (isCancelled)
        {
            return null;
        }
        int j = urlConnection.getResponseCode();
        if (j / 100 == 2)
        {
            stream = urlConnection.getInputStream();
            return stream;
        }
        if (j / 100 == 3)
        {
            url1 = urlConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(url1))
            {
                throw new IOException("Received empty or null redirect url");
            } else
            {
                return loadDataWithRedirects(new URL(url, url1), i + 1, url);
            }
        }
        if (j == -1)
        {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        } else
        {
            throw new IOException((new StringBuilder()).append("Request failed ").append(j).append(": ").append(urlConnection.getResponseMessage()).toString());
        }
    }

    public void cancel()
    {
        isCancelled = true;
    }

    public void cleanup()
    {
        if (stream != null)
        {
            try
            {
                stream.close();
            }
            catch (IOException ioexception) { }
        }
        if (urlConnection != null)
        {
            urlConnection.disconnect();
        }
    }

    public String getId()
    {
        return glideUrl.toString();
    }

    public InputStream loadData(Priority priority)
        throws Exception
    {
        return loadDataWithRedirects(glideUrl.toURL(), 0, null);
    }

    public volatile Object loadData(Priority priority)
        throws Exception
    {
        return loadData(priority);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer.util.Predicate;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.Map;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            UriDataSource, DataSpec

public interface HttpDataSource
    extends UriDataSource
{
    public static class HttpDataSourceException extends IOException
    {

        public final DataSpec dataSpec;

        public HttpDataSourceException(DataSpec dataspec)
        {
            dataSpec = dataspec;
        }

        public HttpDataSourceException(IOException ioexception, DataSpec dataspec)
        {
            super(ioexception);
            dataSpec = dataspec;
        }

        public HttpDataSourceException(String s, DataSpec dataspec)
        {
            super(s);
            dataSpec = dataspec;
        }

        public HttpDataSourceException(String s, IOException ioexception, DataSpec dataspec)
        {
            super(s, ioexception);
            dataSpec = dataspec;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException
    {

        public final String contentType;

        public InvalidContentTypeException(String s, DataSpec dataspec)
        {
            super((new StringBuilder()).append("Invalid content type: ").append(s).toString(), dataspec);
            contentType = s;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException
    {

        public final Map headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i, Map map, DataSpec dataspec)
        {
            super((new StringBuilder()).append("Response code: ").append(i).toString(), dataspec);
            responseCode = i;
            headerFields = map;
        }
    }


    public static final Predicate REJECT_PAYWALL_TYPES = new Predicate() {

        public volatile boolean evaluate(Object obj)
        {
            return evaluate((String)obj);
        }

        public boolean evaluate(String s)
        {
            s = Util.toLowerInvariant(s);
            return !TextUtils.isEmpty(s) && (!s.contains("text") || s.contains("text/vtt")) && !s.contains("html") && !s.contains("xml");
        }

    };

    public abstract void clearAllRequestProperties();

    public abstract void clearRequestProperty(String s);

    public abstract void close()
        throws HttpDataSourceException;

    public abstract Map getResponseHeaders();

    public abstract long open(DataSpec dataspec)
        throws HttpDataSourceException;

    public abstract int read(byte abyte0[], int i, int j)
        throws HttpDataSourceException;

    public abstract void setRequestProperty(String s, String s1);

}

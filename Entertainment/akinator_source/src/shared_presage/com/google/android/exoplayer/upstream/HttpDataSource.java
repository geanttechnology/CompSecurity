// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import java.io.IOException;
import java.util.Map;
import shared_presage.com.google.android.exoplayer.util.Predicate;

// Referenced classes of package shared_presage.com.google.android.exoplayer.upstream:
//            UriDataSource, b, DataSpec

public interface HttpDataSource
    extends UriDataSource
{
    public static class HttpDataSourceException extends IOException
    {

        public final DataSpec dataSpec;

        public HttpDataSourceException(IOException ioexception, DataSpec dataspec)
        {
            super(ioexception);
            dataSpec = dataspec;
        }

        public HttpDataSourceException(String s, IOException ioexception, DataSpec dataspec)
        {
            super(s, ioexception);
            dataSpec = dataspec;
        }

        public HttpDataSourceException(String s, DataSpec dataspec)
        {
            super(s);
            dataSpec = dataspec;
        }

        public HttpDataSourceException(DataSpec dataspec)
        {
            dataSpec = dataspec;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException
    {

        public final String contentType;

        public InvalidContentTypeException(String s, DataSpec dataspec)
        {
            super((new StringBuilder("Invalid content type: ")).append(s).toString(), dataspec);
            contentType = s;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException
    {

        public final Map headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i, Map map, DataSpec dataspec)
        {
            super((new StringBuilder("Response code: ")).append(i).toString(), dataspec);
            responseCode = i;
            headerFields = map;
        }
    }


    public static final Predicate REJECT_PAYWALL_TYPES = new b();

    public abstract void clearAllRequestProperties();

    public abstract void clearRequestProperty(String s);

    public abstract void close();

    public abstract Map getResponseHeaders();

    public abstract long open(DataSpec dataspec);

    public abstract int read(byte abyte0[], int i, int j);

    public abstract void setRequestProperty(String s, String s1);

}

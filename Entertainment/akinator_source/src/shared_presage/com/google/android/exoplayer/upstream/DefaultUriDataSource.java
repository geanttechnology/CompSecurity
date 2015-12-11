// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.upstream:
//            UriDataSource, DefaultHttpDataSource, FileDataSource, AssetDataSource, 
//            ContentDataSource, DataSpec, TransferListener

public final class DefaultUriDataSource
    implements UriDataSource
{

    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_FILE = "file";
    private final UriDataSource assetDataSource;
    private final UriDataSource contentDataSource;
    private UriDataSource dataSource;
    private final UriDataSource fileDataSource;
    private final UriDataSource httpDataSource;

    public DefaultUriDataSource(Context context, String s)
    {
        this(context, null, s, false);
    }

    public DefaultUriDataSource(Context context, TransferListener transferlistener, String s)
    {
        this(context, transferlistener, s, false);
    }

    public DefaultUriDataSource(Context context, TransferListener transferlistener, String s, boolean flag)
    {
        this(context, transferlistener, ((UriDataSource) (new DefaultHttpDataSource(s, null, transferlistener, 8000, 8000, flag))));
    }

    public DefaultUriDataSource(Context context, TransferListener transferlistener, UriDataSource uridatasource)
    {
        httpDataSource = (UriDataSource)Assertions.checkNotNull(uridatasource);
        fileDataSource = new FileDataSource(transferlistener);
        assetDataSource = new AssetDataSource(context, transferlistener);
        contentDataSource = new ContentDataSource(context, transferlistener);
    }

    public final void close()
    {
        if (dataSource == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        dataSource.close();
        dataSource = null;
        return;
        Exception exception;
        exception;
        dataSource = null;
        throw exception;
    }

    public final String getUri()
    {
        if (dataSource == null)
        {
            return null;
        } else
        {
            return dataSource.getUri();
        }
    }

    public final long open(DataSpec dataspec)
    {
        String s;
        boolean flag;
        if (dataSource == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        s = dataspec.uri.getScheme();
        if ("file".equals(s) || TextUtils.isEmpty(s))
        {
            if (dataspec.uri.getPath().startsWith("/android_asset/"))
            {
                dataSource = assetDataSource;
            } else
            {
                dataSource = fileDataSource;
            }
        } else
        if ("asset".equals(s))
        {
            dataSource = assetDataSource;
        } else
        if ("content".equals(s))
        {
            dataSource = contentDataSource;
        } else
        {
            dataSource = httpDataSource;
        }
        return dataSource.open(dataspec);
    }

    public final int read(byte abyte0[], int i, int j)
    {
        return dataSource.read(abyte0, i, j);
    }
}

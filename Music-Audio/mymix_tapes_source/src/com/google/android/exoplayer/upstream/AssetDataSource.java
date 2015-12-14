// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            UriDataSource, TransferListener, DataSpec

public final class AssetDataSource
    implements UriDataSource
{
    public static final class AssetDataSourceException extends IOException
    {

        public AssetDataSourceException(IOException ioexception)
        {
            super(ioexception);
        }
    }


    private final AssetManager assetManager;
    private long bytesRemaining;
    private InputStream inputStream;
    private final TransferListener listener;
    private boolean opened;
    private String uriString;

    public AssetDataSource(Context context)
    {
        this(context, null);
    }

    public AssetDataSource(Context context, TransferListener transferlistener)
    {
        assetManager = context.getAssets();
        listener = transferlistener;
    }

    public void close()
        throws AssetDataSourceException
    {
        uriString = null;
        if (inputStream == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        inputStream.close();
        inputStream = null;
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
            }
        }
        return;
        Object obj;
        obj;
        throw new AssetDataSourceException(((IOException) (obj)));
        obj;
        inputStream = null;
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
            }
        }
        throw obj;
    }

    public String getUri()
    {
        return uriString;
    }

    public long open(DataSpec dataspec)
        throws AssetDataSourceException
    {
        String s1;
        uriString = dataspec.uri.toString();
        s1 = dataspec.uri.getPath();
        if (!s1.startsWith("/android_asset/")) goto _L2; else goto _L1
_L1:
        String s = s1.substring(15);
_L4:
        uriString = dataspec.uri.toString();
        inputStream = assetManager.open(s, 1);
        if (inputStream.skip(dataspec.position) < dataspec.position)
        {
            throw new EOFException();
        }
        break MISSING_BLOCK_LABEL_116;
_L2:
        s = s1;
        if (!s1.startsWith("/")) goto _L4; else goto _L3
_L3:
        s = s1.substring(1);
          goto _L4
        if (dataspec.length == -1L) goto _L6; else goto _L5
_L5:
        bytesRemaining = dataspec.length;
_L8:
        opened = true;
        if (listener != null)
        {
            listener.onTransferStart();
        }
        return bytesRemaining;
_L6:
        try
        {
            bytesRemaining = inputStream.available();
            if (bytesRemaining == 0x7fffffffL)
            {
                bytesRemaining = -1L;
            }
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new AssetDataSourceException(dataspec);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int read(byte abyte0[], int i, int j)
        throws AssetDataSourceException
    {
        if (bytesRemaining != 0L) goto _L2; else goto _L1
_L1:
        i = -1;
_L4:
        return i;
_L2:
        if (bytesRemaining != -1L)
        {
            long l;
            try
            {
                l = Math.min(bytesRemaining, j);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new AssetDataSourceException(abyte0);
            }
            j = (int)l;
        }
        j = inputStream.read(abyte0, i, j);
        i = j;
        if (j > 0)
        {
            if (bytesRemaining != -1L)
            {
                bytesRemaining = bytesRemaining - (long)j;
            }
            i = j;
            if (listener != null)
            {
                listener.onBytesTransferred(j);
                return j;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}

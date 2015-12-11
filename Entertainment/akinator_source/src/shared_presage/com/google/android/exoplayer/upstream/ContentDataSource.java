// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package shared_presage.com.google.android.exoplayer.upstream:
//            UriDataSource, TransferListener, DataSpec

public final class ContentDataSource
    implements UriDataSource
{
    public static class ContentDataSourceException extends IOException
    {

        public ContentDataSourceException(IOException ioexception)
        {
            super(ioexception);
        }
    }


    private long bytesRemaining;
    private InputStream inputStream;
    private final TransferListener listener;
    private boolean opened;
    private final ContentResolver resolver;
    private String uriString;

    public ContentDataSource(Context context)
    {
        this(context, null);
    }

    public ContentDataSource(Context context, TransferListener transferlistener)
    {
        resolver = context.getContentResolver();
        listener = transferlistener;
    }

    public final void close()
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
        throw new ContentDataSourceException(((IOException) (obj)));
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

    public final String getUri()
    {
        return uriString;
    }

    public final long open(DataSpec dataspec)
    {
        try
        {
            uriString = dataspec.uri.toString();
            inputStream = new FileInputStream(resolver.openAssetFileDescriptor(dataspec.uri, "r").getFileDescriptor());
            if (inputStream.skip(dataspec.position) < dataspec.position)
            {
                throw new EOFException();
            }
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new ContentDataSourceException(dataspec);
        }
        if (dataspec.length == -1L)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        bytesRemaining = dataspec.length;
_L1:
        opened = true;
        if (listener != null)
        {
            listener.onTransferStart();
        }
        return bytesRemaining;
        bytesRemaining = inputStream.available();
        if (bytesRemaining == 0L)
        {
            bytesRemaining = -1L;
        }
          goto _L1
    }

    public final int read(byte abyte0[], int i, int j)
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
                throw new ContentDataSourceException(abyte0);
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

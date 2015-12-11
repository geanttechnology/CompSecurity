// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class StreamUtils
{

    public static final String TAG = com/amazon/identity/auth/device/utils/StreamUtils.getName();

    private StreamUtils()
    {
    }

    public static void closeParcelFileDescriptor(ParcelFileDescriptor parcelfiledescriptor)
    {
        if (parcelfiledescriptor == null)
        {
            return;
        }
        try
        {
            parcelfiledescriptor.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ParcelFileDescriptor parcelfiledescriptor)
        {
            MAPLog.e(TAG, "IOException closing parcel file descriptor");
        }
    }

    public static void closeStream(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            MAPLog.e(TAG, "IOException thrown closing input stream");
        }
    }

    public static byte[] readInputStream(InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i >= 0)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    public static void writeToStreamAndClose(OutputStream outputstream, byte abyte0[])
        throws IOException
    {
        outputstream.write(abyte0);
        closeStream(outputstream);
        return;
        abyte0;
        closeStream(outputstream);
        throw abyte0;
    }

}

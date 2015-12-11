// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package co.vine.android.network:
//            MultipartEntity

public static class mContext
    implements mContext
{

    private final Context mContext;
    private final Uri mUri;

    public InputStream getInputStream()
        throws IOException
    {
        return mContext.getContentResolver().openInputStream(mUri);
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        InputStream inputstream = mContext.getContentResolver().openInputStream(mUri);
        byte abyte0[] = new byte[4096];
        do
        {
            int i = inputstream.read(abyte0);
            if (i > 0)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }

    public (Context context, Uri uri)
    {
        mUri = uri;
        mContext = context;
    }
}

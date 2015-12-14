// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;

// Referenced classes of package com.amazon.gallery.framework.network.upload:
//            MultipartEntityWithProgress, UploadProgressListener

class listener extends FilterOutputStream
{

    private final UploadProgressListener listener;
    final MultipartEntityWithProgress this$0;

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (Thread.interrupted())
        {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
        out.write(abyte0, i, j);
        if (listener != null)
        {
            listener.incrementProgress(j);
        }
    }

    public (OutputStream outputstream, UploadProgressListener uploadprogresslistener)
    {
        this$0 = MultipartEntityWithProgress.this;
        super(outputstream);
        listener = uploadprogresslistener;
    }
}

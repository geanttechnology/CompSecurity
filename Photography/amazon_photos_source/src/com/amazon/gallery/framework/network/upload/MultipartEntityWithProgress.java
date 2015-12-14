// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;

// Referenced classes of package com.amazon.gallery.framework.network.upload:
//            UploadProgressListener

public class MultipartEntityWithProgress extends MultipartEntity
{
    class ProgressOutputStream extends FilterOutputStream
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

        public ProgressOutputStream(OutputStream outputstream, UploadProgressListener uploadprogresslistener)
        {
            this$0 = MultipartEntityWithProgress.this;
            super(outputstream);
            listener = uploadprogresslistener;
        }
    }


    private final UploadProgressListener listener;

    public MultipartEntityWithProgress(HttpMultipartMode httpmultipartmode, String s, Charset charset, UploadProgressListener uploadprogresslistener)
    {
        super(httpmultipartmode, s, charset);
        listener = uploadprogresslistener;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        super.writeTo(new ProgressOutputStream(outputstream, listener));
    }
}

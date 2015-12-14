// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;
import com.parse.entity.mime.HttpMultipartMode;
import com.parse.entity.mime.MultipartEntity;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

// Referenced classes of package com.parse:
//            ProgressCallback, Parse

class CountingMultipartEntity extends MultipartEntity
{
    public static class CountingOutputStream extends FilterOutputStream
    {

        private boolean hasReportedDone;
        private final ProgressCallback progressCallback;
        private long totalSize;
        private long uploadedSize;

        private void notifyCallback()
        {
            if (!hasReportedDone)
            {
                int i = Math.round(((float)uploadedSize / (float)totalSize) * 100F);
                Parse.callbackOnMainThreadAsync(Task.forResult(Integer.valueOf(i)), progressCallback);
                if (i == 100)
                {
                    hasReportedDone = true;
                    return;
                }
            }
        }

        public void write(int i)
            throws IOException
        {
            out.write(i);
            uploadedSize = uploadedSize + 1L;
            notifyCallback();
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            out.write(abyte0, i, j);
            uploadedSize = uploadedSize + (long)j;
            notifyCallback();
        }

        public CountingOutputStream(OutputStream outputstream, ProgressCallback progresscallback, long l)
        {
            super(outputstream);
            hasReportedDone = false;
            progressCallback = progresscallback;
            totalSize = l;
            uploadedSize = 0L;
        }
    }


    private final ProgressCallback progressCallback;

    public CountingMultipartEntity(ProgressCallback progresscallback)
    {
        progressCallback = progresscallback;
    }

    public CountingMultipartEntity(HttpMultipartMode httpmultipartmode, ProgressCallback progresscallback)
    {
        super(httpmultipartmode);
        progressCallback = progresscallback;
    }

    public CountingMultipartEntity(HttpMultipartMode httpmultipartmode, String s, Charset charset, ProgressCallback progresscallback)
    {
        super(httpmultipartmode, s, charset);
        progressCallback = progresscallback;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        super.writeTo(new CountingOutputStream(outputstream, progressCallback, getContentLength()));
    }
}

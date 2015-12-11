// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.entity.FileEntity;

// Referenced classes of package co.vine.android.util:
//            VineProgressListener, VineProgressEvent

public class MeasureOutputStream extends FileEntity
{
    public static class CountingOutputStream extends FilterOutputStream
    {

        private final VineProgressEvent mProgressEvent = new VineProgressEvent(1);
        private final VineProgressListener mProgressListener;

        public void write(int i)
            throws IOException
        {
            out.write(i);
            mProgressEvent.setBytesTransfered(1);
            if (mProgressListener != null)
            {
                mProgressListener.progressChanged(mProgressEvent);
            }
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            out.write(abyte0, i, j);
            mProgressEvent.setBytesTransfered(j);
            if (mProgressListener != null)
            {
                mProgressListener.progressChanged(mProgressEvent);
            }
        }

        public CountingOutputStream(OutputStream outputstream, VineProgressListener vineprogresslistener)
        {
            super(outputstream);
            mProgressListener = vineprogresslistener;
        }
    }


    private final VineProgressListener mProgressListener;

    public MeasureOutputStream(File file, String s, VineProgressListener vineprogresslistener)
    {
        super(file, s);
        mProgressListener = vineprogresslistener;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        super.writeTo(new CountingOutputStream(outputstream, mProgressListener));
    }
}

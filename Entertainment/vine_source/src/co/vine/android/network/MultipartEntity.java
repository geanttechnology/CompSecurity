// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import co.vine.android.util.Util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicHeader;

// Referenced classes of package co.vine.android.network:
//            MultipartInputStream, CountingOutputStream, ProgressListener

public class MultipartEntity extends AbstractHttpEntity
{
    public static class ByteArrayEntity
        implements Entity
    {

        private final byte mValue[];

        public InputStream getInputStream()
            throws IOException
        {
            return new ByteArrayInputStream(mValue);
        }

        public void writeTo(OutputStream outputstream)
            throws IOException
        {
            outputstream.write(mValue);
        }

        public ByteArrayEntity(byte abyte0[])
        {
            mValue = abyte0;
        }
    }

    public static interface Entity
    {

        public abstract InputStream getInputStream()
            throws IOException;

        public abstract void writeTo(OutputStream outputstream)
            throws IOException;
    }

    public static class UriEntity
        implements Entity
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

        public UriEntity(Context context, Uri uri)
        {
            mUri = uri;
            mContext = context;
        }
    }


    public static final String BOUNDARY = "--vineaADFASDFADSFAFD";
    public static final String BOUNDARY_NAME = "vineaADFASDFADSFAFD";
    private static final int BUFF_SIZE = 4096;
    public static final String CRLF = "\r\n";
    public static final String DASH_DASH = "--";
    private static final String UTF8 = "UTF-8";
    private int mApproxStreamLength;
    private final Context mContext;
    private final ArrayList mEntities = new ArrayList();
    private int mLength;
    private final ProgressListener mListener;

    public MultipartEntity(Context context, ProgressListener progresslistener)
    {
        mListener = progresslistener;
        contentType = new BasicHeader("Content-Type", "multipart/form-data; boundary=vineaADFASDFADSFAFD");
        mContext = context.getApplicationContext();
    }

    public void addFile(String s, String s1, Uri uri)
        throws IOException
    {
        s = (new StringBuilder()).append("--vineaADFASDFADSFAFD").append("\r\n").append("Content-Disposition: form-data; name=\"").append(s).append("\"; filename=\"").append(s1).append("\"").append("\r\n").append("Content-Type: image/jpeg").append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n").toString().getBytes("UTF-8");
        s1 = "\r\n".getBytes("UTF-8");
        ArrayList arraylist = mEntities;
        arraylist.add(new ByteArrayEntity(s));
        arraylist.add(new UriEntity(mContext, uri));
        arraylist.add(new ByteArrayEntity(s1));
        mApproxStreamLength = (int)((float)mApproxStreamLength + (Util.getFileSize(mContext, uri) * 1024F + (float)s.length + (float)s1.length));
    }

    public void addString(String s, String s1)
    {
        s = (new StringBuilder()).append("--vineaADFASDFADSFAFD").append("\r\n").append("Content-Disposition: form-data; name=\"").append(s).append("\"").append("\r\n").append("\r\n").append(s1).append("\r\n").toString().getBytes();
        mApproxStreamLength = mApproxStreamLength + s.length;
        mLength = mLength + s.length;
        mEntities.add(new ByteArrayEntity(s));
    }

    public void end()
        throws IOException
    {
        mEntities.add(new ByteArrayEntity("--vineaADFASDFADSFAFD--\r\n".getBytes("UTF-8")));
    }

    public InputStream getContent()
        throws IOException
    {
        return new MultipartInputStream(mEntities);
    }

    public long getContentLength()
    {
        return (long)mLength;
    }

    public boolean isRepeatable()
    {
        return true;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        outputstream = new CountingOutputStream(outputstream, mApproxStreamLength, mListener);
        for (Iterator iterator = mEntities.iterator(); iterator.hasNext(); ((Entity)iterator.next()).writeTo(outputstream)) { }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods.multipart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class Part
{

    protected static final String BOUNDARY = "----------------314159265358979323846";
    protected static final byte BOUNDARY_BYTES[];
    protected static final String CHARSET = "; charset=";
    protected static final byte CHARSET_BYTES[] = EncodingUtil.getAsciiBytes("; charset=");
    protected static final String CONTENT_DISPOSITION = "Content-Disposition: form-data; name=";
    protected static final byte CONTENT_DISPOSITION_BYTES[] = EncodingUtil.getAsciiBytes("Content-Disposition: form-data; name=");
    protected static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding: ";
    protected static final byte CONTENT_TRANSFER_ENCODING_BYTES[] = EncodingUtil.getAsciiBytes("Content-Transfer-Encoding: ");
    protected static final String CONTENT_TYPE = "Content-Type: ";
    protected static final byte CONTENT_TYPE_BYTES[] = EncodingUtil.getAsciiBytes("Content-Type: ");
    protected static final String CRLF = "\r\n";
    protected static final byte CRLF_BYTES[] = EncodingUtil.getAsciiBytes("\r\n");
    private static final byte DEFAULT_BOUNDARY_BYTES[];
    protected static final String EXTRA = "--";
    protected static final byte EXTRA_BYTES[] = EncodingUtil.getAsciiBytes("--");
    private static final Log LOG;
    protected static final String QUOTE = "\"";
    protected static final byte QUOTE_BYTES[] = EncodingUtil.getAsciiBytes("\"");
    static Class class$org$apache$commons$httpclient$methods$multipart$Part;
    private byte boundaryBytes[];

    public Part()
    {
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public static String getBoundary()
    {
        return "----------------314159265358979323846";
    }

    public static long getLengthOfParts(Part apart[])
        throws IOException
    {
        return getLengthOfParts(apart, DEFAULT_BOUNDARY_BYTES);
    }

    public static long getLengthOfParts(Part apart[], byte abyte0[])
        throws IOException
    {
        LOG.trace("getLengthOfParts(Parts[])");
        if (apart == null)
        {
            throw new IllegalArgumentException("Parts may not be null");
        }
        long l = 0L;
        for (int i = 0; i < apart.length; i++)
        {
            apart[i].setPartBoundary(abyte0);
            long l1 = apart[i].length();
            if (l1 < 0L)
            {
                return -1L;
            }
            l += l1;
        }

        return l + (long)EXTRA_BYTES.length + (long)abyte0.length + (long)EXTRA_BYTES.length + (long)CRLF_BYTES.length;
    }

    public static void sendParts(OutputStream outputstream, Part apart[])
        throws IOException
    {
        sendParts(outputstream, apart, DEFAULT_BOUNDARY_BYTES);
    }

    public static void sendParts(OutputStream outputstream, Part apart[], byte abyte0[])
        throws IOException
    {
        if (apart == null)
        {
            throw new IllegalArgumentException("Parts may not be null");
        }
        if (abyte0 == null || abyte0.length == 0)
        {
            throw new IllegalArgumentException("partBoundary may not be empty");
        }
        for (int i = 0; i < apart.length; i++)
        {
            apart[i].setPartBoundary(abyte0);
            apart[i].send(outputstream);
        }

        outputstream.write(EXTRA_BYTES);
        outputstream.write(abyte0);
        outputstream.write(EXTRA_BYTES);
        outputstream.write(CRLF_BYTES);
    }

    public abstract String getCharSet();

    public abstract String getContentType();

    public abstract String getName();

    protected byte[] getPartBoundary()
    {
        if (boundaryBytes == null)
        {
            return DEFAULT_BOUNDARY_BYTES;
        } else
        {
            return boundaryBytes;
        }
    }

    public abstract String getTransferEncoding();

    public boolean isRepeatable()
    {
        return true;
    }

    public long length()
        throws IOException
    {
        LOG.trace("enter length()");
        if (lengthOfData() < 0L)
        {
            return -1L;
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            sendStart(bytearrayoutputstream);
            sendDispositionHeader(bytearrayoutputstream);
            sendContentTypeHeader(bytearrayoutputstream);
            sendTransferEncodingHeader(bytearrayoutputstream);
            sendEndOfHeader(bytearrayoutputstream);
            sendEnd(bytearrayoutputstream);
            return (long)bytearrayoutputstream.size() + lengthOfData();
        }
    }

    protected abstract long lengthOfData()
        throws IOException;

    public void send(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter send(OutputStream out)");
        sendStart(outputstream);
        sendDispositionHeader(outputstream);
        sendContentTypeHeader(outputstream);
        sendTransferEncodingHeader(outputstream);
        sendEndOfHeader(outputstream);
        sendData(outputstream);
        sendEnd(outputstream);
    }

    protected void sendContentTypeHeader(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter sendContentTypeHeader(OutputStream out)");
        String s = getContentType();
        if (s != null)
        {
            outputstream.write(CRLF_BYTES);
            outputstream.write(CONTENT_TYPE_BYTES);
            outputstream.write(EncodingUtil.getAsciiBytes(s));
            s = getCharSet();
            if (s != null)
            {
                outputstream.write(CHARSET_BYTES);
                outputstream.write(EncodingUtil.getAsciiBytes(s));
            }
        }
    }

    protected abstract void sendData(OutputStream outputstream)
        throws IOException;

    protected void sendDispositionHeader(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter sendDispositionHeader(OutputStream out)");
        outputstream.write(CONTENT_DISPOSITION_BYTES);
        outputstream.write(QUOTE_BYTES);
        outputstream.write(EncodingUtil.getAsciiBytes(getName()));
        outputstream.write(QUOTE_BYTES);
    }

    protected void sendEnd(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter sendEnd(OutputStream out)");
        outputstream.write(CRLF_BYTES);
    }

    protected void sendEndOfHeader(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter sendEndOfHeader(OutputStream out)");
        outputstream.write(CRLF_BYTES);
        outputstream.write(CRLF_BYTES);
    }

    protected void sendStart(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter sendStart(OutputStream out)");
        outputstream.write(EXTRA_BYTES);
        outputstream.write(getPartBoundary());
        outputstream.write(CRLF_BYTES);
    }

    protected void sendTransferEncodingHeader(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter sendTransferEncodingHeader(OutputStream out)");
        String s = getTransferEncoding();
        if (s != null)
        {
            outputstream.write(CRLF_BYTES);
            outputstream.write(CONTENT_TRANSFER_ENCODING_BYTES);
            outputstream.write(EncodingUtil.getAsciiBytes(s));
        }
    }

    void setPartBoundary(byte abyte0[])
    {
        boundaryBytes = abyte0;
    }

    public String toString()
    {
        return getName();
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$multipart$Part == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.multipart.Part");
            class$org$apache$commons$httpclient$methods$multipart$Part = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$multipart$Part;
        }
        LOG = LogFactory.getLog(class1);
        BOUNDARY_BYTES = EncodingUtil.getAsciiBytes("----------------314159265358979323846");
        DEFAULT_BOUNDARY_BYTES = BOUNDARY_BYTES;
    }
}

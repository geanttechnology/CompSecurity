// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ExceptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpException, HttpMethod, HttpParser

public class ChunkedInputStream extends InputStream
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$ChunkedInputStream;
    private boolean bof;
    private int chunkSize;
    private boolean closed;
    private boolean eof;
    private InputStream in;
    private HttpMethod method;
    private int pos;

    public ChunkedInputStream(InputStream inputstream)
        throws IOException
    {
        this(inputstream, null);
    }

    public ChunkedInputStream(InputStream inputstream, HttpMethod httpmethod)
        throws IOException
    {
        bof = true;
        eof = false;
        closed = false;
        method = null;
        if (inputstream == null)
        {
            throw new IllegalArgumentException("InputStream parameter may not be null");
        } else
        {
            in = inputstream;
            method = httpmethod;
            pos = 0;
            return;
        }
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

    static void exhaustInputStream(InputStream inputstream)
        throws IOException
    {
        for (byte abyte0[] = new byte[1024]; inputstream.read(abyte0) >= 0;) { }
    }

    private static int getChunkSizeFromInputStream(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream;
        int i;
        bytearrayoutputstream = new ByteArrayOutputStream();
        i = 0;
_L14:
        if (i == -1) goto _L2; else goto _L1
_L1:
        int k;
        k = inputstream.read();
        if (k == -1)
        {
            throw new IOException("chunked stream ended unexpectedly");
        }
        i;
        JVM INSTR tableswitch 0 2: default 64
    //                   0 74
    //                   1 118
    //                   2 139;
           goto _L3 _L4 _L5 _L6
_L3:
        throw new RuntimeException("assertion failed");
_L4:
        k;
        JVM INSTR lookupswitch 2: default 100
    //                   13: 108
    //                   34: 113;
           goto _L7 _L8 _L9
_L7:
        bytearrayoutputstream.write(k);
        continue; /* Loop/switch isn't completed */
_L8:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L9:
        i = 2;
          goto _L7
_L5:
        if (k == 10)
        {
            i = -1;
        } else
        {
            throw new IOException("Protocol violation: Unexpected single newline character in chunk size");
        }
        continue; /* Loop/switch isn't completed */
_L6:
        k;
        JVM INSTR lookupswitch 2: default 168
    //                   34: 187
    //                   92: 176;
           goto _L10 _L11 _L12
_L10:
        bytearrayoutputstream.write(k);
        continue; /* Loop/switch isn't completed */
_L12:
        bytearrayoutputstream.write(inputstream.read());
        continue; /* Loop/switch isn't completed */
_L11:
        i = 0;
        if (true) goto _L10; else goto _L2
        if (true) goto _L14; else goto _L13
_L13:
_L2:
        inputstream = EncodingUtil.getAsciiString(bytearrayoutputstream.toByteArray());
        int j = inputstream.indexOf(';');
        if (j > 0)
        {
            inputstream = inputstream.substring(0, j).trim();
        } else
        {
            inputstream = inputstream.trim();
        }
        try
        {
            j = Integer.parseInt(inputstream.trim(), 16);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new IOException("Bad chunk size: " + inputstream);
        }
        return j;
    }

    private void nextChunk()
        throws IOException
    {
        if (!bof)
        {
            readCRLF();
        }
        chunkSize = getChunkSizeFromInputStream(in);
        bof = false;
        pos = 0;
        if (chunkSize == 0)
        {
            eof = true;
            parseTrailerHeaders();
        }
    }

    private void parseTrailerHeaders()
        throws IOException
    {
        String s = "US-ASCII";
        Header aheader[];
        try
        {
            if (method != null)
            {
                s = method.getParams().getHttpElementCharset();
            }
            aheader = HttpParser.parseHeaders(in, s);
        }
        catch (HttpException httpexception)
        {
            LOG.error("Error parsing trailer headers", httpexception);
            IOException ioexception = new IOException(httpexception.getMessage());
            ExceptionUtil.initCause(ioexception, httpexception);
            throw ioexception;
        }
        if (method != null)
        {
            for (int i = 0; i < aheader.length; i++)
            {
                method.addResponseFooter(aheader[i]);
            }

        }
    }

    private void readCRLF()
        throws IOException
    {
        int i = in.read();
        int j = in.read();
        if (i != 13 || j != 10)
        {
            throw new IOException("CRLF expected at end of chunk: " + i + "/" + j);
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
        if (closed)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (!eof)
        {
            exhaustInputStream(this);
        }
        eof = true;
        closed = true;
        return;
        Exception exception;
        exception;
        eof = true;
        closed = true;
        throw exception;
    }

    public int read()
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Attempted read from closed stream.");
        }
        if (!eof) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (pos < chunkSize)
        {
            break; /* Loop/switch isn't completed */
        }
        nextChunk();
        if (eof) goto _L1; else goto _L3
_L3:
        pos = pos + 1;
        return in.read();
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("Attempted read from closed stream.");
        }
        if (!eof) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (pos < chunkSize)
        {
            break; /* Loop/switch isn't completed */
        }
        nextChunk();
        if (eof) goto _L1; else goto _L3
_L3:
        j = Math.min(j, chunkSize - pos);
        i = in.read(abyte0, i, j);
        pos = pos + i;
        return i;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$ChunkedInputStream == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.ChunkedInputStream");
            class$org$apache$commons$httpclient$ChunkedInputStream = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$ChunkedInputStream;
        }
        LOG = LogFactory.getLog(class1);
    }
}

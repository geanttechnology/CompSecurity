// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.methods.multipart:
//            PartBase, FilePartSource, PartSource

public class FilePart extends PartBase
{

    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    protected static final String FILE_NAME = "; filename=";
    private static final byte FILE_NAME_BYTES[] = EncodingUtil.getAsciiBytes("; filename=");
    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$multipart$FilePart;
    private PartSource source;

    public FilePart(String s, File file)
        throws FileNotFoundException
    {
        this(s, ((PartSource) (new FilePartSource(file))), null, null);
    }

    public FilePart(String s, File file, String s1, String s2)
        throws FileNotFoundException
    {
        this(s, ((PartSource) (new FilePartSource(file))), s1, s2);
    }

    public FilePart(String s, String s1, File file)
        throws FileNotFoundException
    {
        this(s, ((PartSource) (new FilePartSource(s1, file))), null, null);
    }

    public FilePart(String s, String s1, File file, String s2, String s3)
        throws FileNotFoundException
    {
        this(s, ((PartSource) (new FilePartSource(s1, file))), s2, s3);
    }

    public FilePart(String s, PartSource partsource)
    {
        this(s, partsource, null, null);
    }

    public FilePart(String s, PartSource partsource, String s1, String s2)
    {
        String s3 = s1;
        if (s1 == null)
        {
            s3 = "application/octet-stream";
        }
        s1 = s2;
        if (s2 == null)
        {
            s1 = "ISO-8859-1";
        }
        super(s, s3, s1, "binary");
        if (partsource == null)
        {
            throw new IllegalArgumentException("Source may not be null");
        } else
        {
            source = partsource;
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

    protected PartSource getSource()
    {
        LOG.trace("enter getSource()");
        return source;
    }

    protected long lengthOfData()
        throws IOException
    {
        LOG.trace("enter lengthOfData()");
        return source.getLength();
    }

    protected void sendData(OutputStream outputstream)
        throws IOException
    {
        InputStream inputstream;
        byte abyte0[];
        LOG.trace("enter sendData(OutputStream out)");
        if (lengthOfData() == 0L)
        {
            LOG.debug("No data to send.");
            return;
        }
        abyte0 = new byte[4096];
        inputstream = source.createInputStream();
_L1:
        int i = inputstream.read(abyte0);
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        outputstream;
        inputstream.close();
        throw outputstream;
        inputstream.close();
        return;
    }

    protected void sendDispositionHeader(OutputStream outputstream)
        throws IOException
    {
        LOG.trace("enter sendDispositionHeader(OutputStream out)");
        super.sendDispositionHeader(outputstream);
        String s = source.getFileName();
        if (s != null)
        {
            outputstream.write(FILE_NAME_BYTES);
            outputstream.write(QUOTE_BYTES);
            outputstream.write(EncodingUtil.getAsciiBytes(s));
            outputstream.write(QUOTE_BYTES);
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$multipart$FilePart == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.multipart.FilePart");
            class$org$apache$commons$httpclient$methods$multipart$FilePart = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$multipart$FilePart;
        }
        LOG = LogFactory.getLog(class1);
    }
}

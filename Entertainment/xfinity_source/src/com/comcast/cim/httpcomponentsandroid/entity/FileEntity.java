// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.entity:
//            AbstractHttpEntity

public class FileEntity extends AbstractHttpEntity
    implements Cloneable
{

    protected final File file;

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public InputStream getContent()
        throws IOException
    {
        return new FileInputStream(file);
    }

    public long getContentLength()
    {
        return file.length();
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
        FileInputStream fileinputstream;
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        fileinputstream = new FileInputStream(file);
        byte abyte0[] = new byte[4096];
_L1:
        int i = fileinputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        outputstream;
        fileinputstream.close();
        throw outputstream;
        outputstream.flush();
        fileinputstream.close();
        return;
    }
}

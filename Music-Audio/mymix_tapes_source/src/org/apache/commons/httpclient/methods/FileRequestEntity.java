// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package org.apache.commons.httpclient.methods:
//            RequestEntity

public class FileRequestEntity
    implements RequestEntity
{

    final String contentType;
    final File file;

    public FileRequestEntity(File file1, String s)
    {
        if (file1 == null)
        {
            throw new IllegalArgumentException("File may not be null");
        } else
        {
            file = file1;
            contentType = s;
            return;
        }
    }

    public long getContentLength()
    {
        return file.length();
    }

    public String getContentType()
    {
        return contentType;
    }

    public boolean isRepeatable()
    {
        return true;
    }

    public void writeRequest(OutputStream outputstream)
        throws IOException
    {
        FileInputStream fileinputstream;
        byte abyte0[];
        abyte0 = new byte[4096];
        fileinputstream = new FileInputStream(file);
_L1:
        int i = fileinputstream.read(abyte0);
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        outputstream;
        fileinputstream.close();
        throw outputstream;
        fileinputstream.close();
        return;
    }
}

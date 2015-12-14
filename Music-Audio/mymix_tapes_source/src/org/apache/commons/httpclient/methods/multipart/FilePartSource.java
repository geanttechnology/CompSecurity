// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.apache.commons.httpclient.methods.multipart:
//            PartSource

public class FilePartSource
    implements PartSource
{

    private File file;
    private String fileName;

    public FilePartSource(File file1)
        throws FileNotFoundException
    {
        file = null;
        fileName = null;
        file = file1;
        if (file1 != null)
        {
            if (!file1.isFile())
            {
                throw new FileNotFoundException("File is not a normal file.");
            }
            if (!file1.canRead())
            {
                throw new FileNotFoundException("File is not readable.");
            }
            fileName = file1.getName();
        }
    }

    public FilePartSource(String s, File file1)
        throws FileNotFoundException
    {
        this(file1);
        if (s != null)
        {
            fileName = s;
        }
    }

    public InputStream createInputStream()
        throws IOException
    {
        if (file != null)
        {
            return new FileInputStream(file);
        } else
        {
            return new ByteArrayInputStream(new byte[0]);
        }
    }

    public String getFileName()
    {
        if (fileName == null)
        {
            return "noname";
        } else
        {
            return fileName;
        }
    }

    public long getLength()
    {
        if (file != null)
        {
            return file.length();
        } else
        {
            return 0L;
        }
    }
}

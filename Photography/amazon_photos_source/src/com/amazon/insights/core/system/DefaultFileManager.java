// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.insights.core.system:
//            FileManager

public class DefaultFileManager
    implements FileManager
{

    private final File directory;

    public DefaultFileManager(File file)
    {
        directory = file;
    }

    public File createDirectory(String s)
    {
        File file = new File(directory, s);
        s = file;
        if (!file.exists())
        {
            s = file;
            if (!file.mkdirs())
            {
                s = null;
            }
        }
        return s;
    }

    public File createFile(File file)
        throws IOException
    {
        File file1 = file;
        if (!file.exists())
        {
            file1 = file;
            if (!file.createNewFile())
            {
                file1 = null;
            }
        }
        return file1;
    }

    public boolean deleteFile(File file)
    {
        if (file.exists())
        {
            return file.delete();
        } else
        {
            return false;
        }
    }

    public File getDirectory(String s)
    {
        return new File(directory, s);
    }

    public Set listFilesInDirectory(File file)
    {
        HashSet hashset = new HashSet();
        if (file.exists())
        {
            file = file.listFiles();
            int j = file.length;
            for (int i = 0; i < j; i++)
            {
                hashset.add(file[i]);
            }

        }
        return Collections.unmodifiableSet(hashset);
    }

    public InputStream newInputStream(File file)
        throws FileNotFoundException
    {
        return new FileInputStream(file);
    }

    public OutputStream newOutputStream(File file, boolean flag)
        throws FileNotFoundException
    {
        return new FileOutputStream(file, flag);
    }
}

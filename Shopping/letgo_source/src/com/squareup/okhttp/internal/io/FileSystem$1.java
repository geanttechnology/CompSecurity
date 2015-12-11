// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.io;

import android.support.v7.aqe;
import android.support.v7.aqj;
import android.support.v7.aqk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.io:
//            FileSystem

static final class 
    implements FileSystem
{

    public aqj appendingSink(File file)
        throws FileNotFoundException
    {
        aqj aqj;
        try
        {
            aqj = aqe.c(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            file.getParentFile().mkdirs();
            return aqe.c(file);
        }
        return aqj;
    }

    public void delete(File file)
        throws IOException
    {
        if (!file.delete() && file.exists())
        {
            throw new IOException((new StringBuilder()).append("failed to delete ").append(file).toString());
        } else
        {
            return;
        }
    }

    public void deleteContents(File file)
        throws IOException
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder()).append("not a readable directory: ").append(file).toString());
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            file = afile[i];
            if (file.isDirectory())
            {
                deleteContents(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder()).append("failed to delete ").append(file).toString());
            }
        }

    }

    public boolean exists(File file)
        throws IOException
    {
        return file.exists();
    }

    public void rename(File file, File file1)
        throws IOException
    {
        delete(file1);
        if (!file.renameTo(file1))
        {
            throw new IOException((new StringBuilder()).append("failed to rename ").append(file).append(" to ").append(file1).toString());
        } else
        {
            return;
        }
    }

    public aqj sink(File file)
        throws FileNotFoundException
    {
        aqj aqj;
        try
        {
            aqj = aqe.b(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            file.getParentFile().mkdirs();
            return aqe.b(file);
        }
        return aqj;
    }

    public long size(File file)
    {
        return file.length();
    }

    public aqk source(File file)
        throws FileNotFoundException
    {
        return aqe.a(file);
    }

    ()
    {
    }
}

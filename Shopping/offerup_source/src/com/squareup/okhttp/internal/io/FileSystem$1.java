// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.io;

import d.aa;
import d.ab;
import d.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.io:
//            FileSystem

final class 
    implements FileSystem
{

    public final aa appendingSink(File file)
    {
        aa aa;
        try
        {
            aa = q.c(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            file.getParentFile().mkdirs();
            return q.c(file);
        }
        return aa;
    }

    public final void delete(File file)
    {
        if (!file.delete() && file.exists())
        {
            throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
        } else
        {
            return;
        }
    }

    public final void deleteContents(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder("not a readable directory: ")).append(file).toString());
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
                throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
            }
        }

    }

    public final boolean exists(File file)
    {
        return file.exists();
    }

    public final void rename(File file, File file1)
    {
        delete(file1);
        if (!file.renameTo(file1))
        {
            throw new IOException((new StringBuilder("failed to rename ")).append(file).append(" to ").append(file1).toString());
        } else
        {
            return;
        }
    }

    public final aa sink(File file)
    {
        aa aa;
        try
        {
            aa = q.b(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            file.getParentFile().mkdirs();
            return q.b(file);
        }
        return aa;
    }

    public final long size(File file)
    {
        return file.length();
    }

    public final ab source(File file)
    {
        return q.a(file);
    }

    ()
    {
    }
}

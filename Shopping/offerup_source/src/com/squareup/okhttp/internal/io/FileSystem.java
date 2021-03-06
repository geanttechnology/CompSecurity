// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.io;

import d.aa;
import d.ab;
import java.io.File;

public interface FileSystem
{

    public static final FileSystem SYSTEM = new _cls1();

    public abstract aa appendingSink(File file);

    public abstract void delete(File file);

    public abstract void deleteContents(File file);

    public abstract boolean exists(File file);

    public abstract void rename(File file, File file1);

    public abstract aa sink(File file);

    public abstract long size(File file);

    public abstract ab source(File file);


    private class _cls1
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

        _cls1()
        {
        }
    }

}

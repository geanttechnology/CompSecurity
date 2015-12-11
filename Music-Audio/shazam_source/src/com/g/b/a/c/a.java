// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.c;

import c.m;
import c.r;
import c.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface a
{

    public static final a a = new a() {

        public final s a(File file)
        {
            return m.a(file);
        }

        public final void a(File file, File file1)
        {
            d(file1);
            if (!file.renameTo(file1))
            {
                throw new IOException((new StringBuilder("failed to rename ")).append(file).append(" to ").append(file1).toString());
            } else
            {
                return;
            }
        }

        public final r b(File file)
        {
            r r;
            try
            {
                r = m.b(file);
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                file.getParentFile().mkdirs();
                return m.b(file);
            }
            return r;
        }

        public final r c(File file)
        {
            r r;
            try
            {
                r = m.c(file);
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                file.getParentFile().mkdirs();
                return m.c(file);
            }
            return r;
        }

        public final void d(File file)
        {
            if (!file.delete() && file.exists())
            {
                throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
            } else
            {
                return;
            }
        }

        public final boolean e(File file)
        {
            return file.exists();
        }

        public final long f(File file)
        {
            return file.length();
        }

        public final void g(File file)
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
                    g(file);
                }
                if (!file.delete())
                {
                    throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
                }
            }

        }

    };

    public abstract s a(File file);

    public abstract void a(File file, File file1);

    public abstract r b(File file);

    public abstract r c(File file);

    public abstract void d(File file);

    public abstract boolean e(File file);

    public abstract long f(File file);

    public abstract void g(File file);

}

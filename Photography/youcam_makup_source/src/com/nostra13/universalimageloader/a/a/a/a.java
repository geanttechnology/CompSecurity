// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.b.b;
import com.nostra13.universalimageloader.b.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public abstract class a
    implements com.nostra13.universalimageloader.a.a.a
{

    public static final android.graphics.Bitmap.CompressFormat a;
    protected final File b;
    protected final File c;
    protected final com.nostra13.universalimageloader.a.a.b.a d;
    protected int e;
    protected android.graphics.Bitmap.CompressFormat f;
    protected int g;

    public a(File file)
    {
        this(file, null);
    }

    public a(File file, File file1)
    {
        this(file, file1, com.nostra13.universalimageloader.core.a.b());
    }

    public a(File file, File file1, com.nostra13.universalimageloader.a.a.b.a a1)
    {
        e = 32768;
        f = a;
        g = 100;
        if (file == null)
        {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (a1 == null)
        {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        } else
        {
            b = file;
            c = file1;
            d = a1;
            return;
        }
    }

    public File a(String s)
    {
        return b(s);
    }

    public boolean a(String s, Bitmap bitmap)
    {
        BufferedOutputStream bufferedoutputstream;
        File file;
        file = b(s);
        s = new File((new StringBuilder()).append(file.getAbsolutePath()).append(".tmp").toString());
        bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(s), e);
        boolean flag = bitmap.compress(f, g, bufferedoutputstream);
        com.nostra13.universalimageloader.b.b.a(bufferedoutputstream);
        boolean flag1 = flag;
        if (flag)
        {
            flag1 = flag;
            if (!s.renameTo(file))
            {
                flag1 = false;
            }
        }
        if (!flag1)
        {
            s.delete();
        }
        bitmap.recycle();
        return flag1;
        bitmap;
        com.nostra13.universalimageloader.b.b.a(bufferedoutputstream);
        s.delete();
        throw bitmap;
    }

    public boolean a(String s, InputStream inputstream, c c1)
    {
        File file;
        File file1;
        file = b(s);
        file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append(".tmp").toString());
        s = new BufferedOutputStream(new FileOutputStream(file1), e);
        boolean flag = com.nostra13.universalimageloader.b.b.a(inputstream, s, c1, e);
        com.nostra13.universalimageloader.b.b.a(s);
        boolean flag1 = flag;
        if (flag)
        {
            flag1 = flag;
            if (!file1.renameTo(file))
            {
                flag1 = false;
            }
        }
        if (!flag1)
        {
            file1.delete();
        }
        return flag1;
        inputstream;
        com.nostra13.universalimageloader.b.b.a(s);
        throw inputstream;
        s;
        flag = false;
_L2:
        boolean flag2 = flag;
        if (flag)
        {
            flag2 = flag;
            if (!file1.renameTo(file))
            {
                flag2 = false;
            }
        }
        if (!flag2)
        {
            file1.delete();
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected File b(String s)
    {
        String s1;
label0:
        {
            s1 = d.a(s);
            File file = b;
            s = file;
            if (b.exists())
            {
                break label0;
            }
            s = file;
            if (b.mkdirs())
            {
                break label0;
            }
            s = file;
            if (c == null)
            {
                break label0;
            }
            if (!c.exists())
            {
                s = file;
                if (!c.mkdirs())
                {
                    break label0;
                }
            }
            s = c;
        }
        return new File(s, s1);
    }

    static 
    {
        a = android.graphics.Bitmap.CompressFormat.PNG;
    }
}

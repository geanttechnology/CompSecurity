// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            aht, ajs, aia

public abstract class ahu
    implements aht
{

    public static final android.graphics.Bitmap.CompressFormat a;
    protected final File b;
    protected final File c;
    protected final aia d;
    protected int e;
    protected android.graphics.Bitmap.CompressFormat f;
    protected int g;

    public ahu(File file, File file1, aia aia1)
    {
        e = 32768;
        f = a;
        g = 100;
        if (file == null)
        {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (aia1 == null)
        {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        } else
        {
            b = file;
            c = file1;
            d = aia1;
            return;
        }
    }

    public File a(String s)
    {
        return b(s);
    }

    public boolean a(String s, Bitmap bitmap)
        throws IOException
    {
        BufferedOutputStream bufferedoutputstream;
        File file;
        file = b(s);
        s = new File((new StringBuilder()).append(file.getAbsolutePath()).append(".tmp").toString());
        bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(s), e);
        boolean flag = bitmap.compress(f, g, bufferedoutputstream);
        ajs.a(bufferedoutputstream);
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
        ajs.a(bufferedoutputstream);
        s.delete();
        throw bitmap;
    }

    public boolean a(String s, InputStream inputstream, ajs.a a1)
        throws IOException
    {
        File file;
        File file1;
        file = b(s);
        file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append(".tmp").toString());
        s = new BufferedOutputStream(new FileOutputStream(file1), e);
        boolean flag = ajs.a(inputstream, s, a1, e);
        ajs.a(s);
        ajs.a(inputstream);
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
        a1;
        ajs.a(s);
        throw a1;
        s;
        flag = false;
_L2:
        ajs.a(inputstream);
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

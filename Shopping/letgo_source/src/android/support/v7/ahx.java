// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            aht, ahw, ajt, aia, 
//            ajs

public class ahx
    implements aht
{

    public static final android.graphics.Bitmap.CompressFormat a;
    protected ahw b;
    protected final aia c;
    protected int d;
    protected android.graphics.Bitmap.CompressFormat e;
    protected int f;
    private File g;

    public ahx(File file, File file1, aia aia1, long l, int i)
        throws IOException
    {
        d = 32768;
        e = a;
        f = 100;
        if (file == null)
        {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (aia1 == null)
        {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        if (l == 0L)
        {
            l = 0x7fffffffffffffffL;
        }
        if (i == 0)
        {
            i = 0x7fffffff;
        }
        g = file1;
        c = aia1;
        a(file, file1, l, i);
    }

    private void a(File file, File file1, long l, int i)
        throws IOException
    {
        b = ahw.a(file, 1, 1, l, i);
_L1:
        return;
        file;
        ajt.a(file);
        if (file1 != null)
        {
            a(file1, null, l, i);
        }
        if (b == null)
        {
            throw file;
        }
          goto _L1
    }

    private String b(String s)
    {
        return c.a(s);
    }

    public File a(String s)
    {
        Object obj;
        Object obj2;
        obj2 = null;
        obj = null;
        s = b.a(b(s));
        if (s != null) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = obj;
        if (s != null)
        {
            s.close();
            obj1 = obj;
        }
_L4:
        return ((File) (obj1));
_L2:
        obj = s;
        obj1 = s.a(0);
        obj = obj1;
          goto _L1
        IOException ioexception;
        ioexception;
        s = null;
_L7:
        obj = s;
        ajt.a(ioexception);
        ioexception = obj2;
        if (s == null) goto _L4; else goto _L3
_L3:
        s.close();
        return null;
        s;
        obj = null;
_L6:
        if (obj != null)
        {
            ((ahw.c) (obj)).close();
        }
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        ioexception;
          goto _L7
    }

    public boolean a(String s, Bitmap bitmap)
        throws IOException
    {
        ahw.a a1;
        a1 = b.b(b(s));
        if (a1 == null)
        {
            return false;
        }
        s = new BufferedOutputStream(a1.a(0), d);
        boolean flag = bitmap.compress(e, f, s);
        ajs.a(s);
        if (flag)
        {
            a1.a();
            return flag;
        } else
        {
            a1.b();
            return flag;
        }
        bitmap;
        ajs.a(s);
        throw bitmap;
    }

    public boolean a(String s, InputStream inputstream, ajs.a a1)
        throws IOException
    {
        BufferedOutputStream bufferedoutputstream;
        s = b.b(b(s));
        if (s == null)
        {
            return false;
        }
        bufferedoutputstream = new BufferedOutputStream(s.a(0), d);
        boolean flag = ajs.a(inputstream, bufferedoutputstream, a1, d);
        ajs.a(bufferedoutputstream);
        if (flag)
        {
            s.a();
            return flag;
        } else
        {
            s.b();
            return flag;
        }
        inputstream;
        ajs.a(bufferedoutputstream);
        s.b();
        throw inputstream;
    }

    static 
    {
        a = android.graphics.Bitmap.CompressFormat.PNG;
    }
}

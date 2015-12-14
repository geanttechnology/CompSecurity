// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a.a;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.a.a.a;
import com.nostra13.universalimageloader.b.b;
import com.nostra13.universalimageloader.b.c;
import com.nostra13.universalimageloader.b.d;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.a.a.a.a:
//            a, e, b

public class f
    implements a
{

    public static final android.graphics.Bitmap.CompressFormat a;
    protected com.nostra13.universalimageloader.a.a.a.a.a b;
    protected final com.nostra13.universalimageloader.a.a.b.a c;
    protected int d;
    protected android.graphics.Bitmap.CompressFormat e;
    protected int f;
    private File g;

    public f(File file, com.nostra13.universalimageloader.a.a.b.a a1, long l)
    {
        this(file, null, a1, l, 0);
    }

    public f(File file, File file1, com.nostra13.universalimageloader.a.a.b.a a1, long l, int i)
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
        if (a1 == null)
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
        c = a1;
        a(file, file1, l, i);
    }

    private void a(File file, File file1, long l, int i)
    {
        b = com.nostra13.universalimageloader.a.a.a.a.a.a(file, 1, 1, l, i);
_L1:
        return;
        file;
        com.nostra13.universalimageloader.b.d.a(file);
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
        com.nostra13.universalimageloader.b.d.a(ioexception);
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
            ((e) (obj)).close();
        }
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        ioexception;
          goto _L7
    }

    public void a(int i)
    {
        f = i;
    }

    public void a(android.graphics.Bitmap.CompressFormat compressformat)
    {
        e = compressformat;
    }

    public boolean a(String s, Bitmap bitmap)
    {
        com.nostra13.universalimageloader.a.a.a.a.b b1;
        b1 = b.b(b(s));
        if (b1 == null)
        {
            return false;
        }
        s = new BufferedOutputStream(b1.a(0), d);
        boolean flag = bitmap.compress(e, f, s);
        com.nostra13.universalimageloader.b.b.a(s);
        if (flag)
        {
            b1.a();
            return flag;
        } else
        {
            b1.b();
            return flag;
        }
        bitmap;
        com.nostra13.universalimageloader.b.b.a(s);
        throw bitmap;
    }

    public boolean a(String s, InputStream inputstream, c c1)
    {
        BufferedOutputStream bufferedoutputstream;
        s = b.b(b(s));
        if (s == null)
        {
            return false;
        }
        bufferedoutputstream = new BufferedOutputStream(s.a(0), d);
        boolean flag = com.nostra13.universalimageloader.b.b.a(inputstream, bufferedoutputstream, c1, d);
        com.nostra13.universalimageloader.b.b.a(bufferedoutputstream);
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
        com.nostra13.universalimageloader.b.b.a(bufferedoutputstream);
        s.b();
        throw inputstream;
    }

    static 
    {
        a = android.graphics.Bitmap.CompressFormat.PNG;
    }
}

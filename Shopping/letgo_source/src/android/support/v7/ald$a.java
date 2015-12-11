// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            ald, alj

public static final class <init>
{

    private final d a;
    private final Bitmap b;
    private final InputStream c;
    private final int d;

    public Bitmap a()
    {
        return b;
    }

    public InputStream b()
    {
        return c;
    }

    public c c()
    {
        return a;
    }

    int d()
    {
        return d;
    }

    public (Bitmap bitmap,  )
    {
        this((Bitmap)alj.a(bitmap, "bitmap == null"), null, , 0);
    }

    <init>(Bitmap bitmap, InputStream inputstream, <init> <init>1, int i)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (bitmap != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (inputstream == null)
        {
            flag1 = false;
        }
        if (!(flag1 ^ flag))
        {
            throw new AssertionError();
        } else
        {
            b = bitmap;
            c = inputstream;
            a = (a)alj.a(<init>1, "loadedFrom == null");
            d = i;
            return;
        }
    }

    public d(InputStream inputstream, d d1)
    {
        this(null, (InputStream)alj.a(inputstream, "stream == null"), d1, 0);
    }
}

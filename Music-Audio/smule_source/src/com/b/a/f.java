// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.graphics.Bitmap;

// Referenced classes of package com.b.a:
//            g

public class f extends g
{

    public f(int i)
    {
        super(i);
    }

    protected volatile int a(Object obj, Object obj1)
    {
        return a((String)obj, (Bitmap)obj1);
    }

    protected int a(String s, Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}

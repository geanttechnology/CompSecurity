// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package p.af;

import android.graphics.Bitmap;
import p.t.c;

class a
    implements p.n.a
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public Bitmap a(int i, int j, android.graphics.Bitmap.Config config)
    {
        return a.b(i, j, config);
    }

    public void a(Bitmap bitmap)
    {
        if (!a.a(bitmap))
        {
            bitmap.recycle();
        }
    }
}

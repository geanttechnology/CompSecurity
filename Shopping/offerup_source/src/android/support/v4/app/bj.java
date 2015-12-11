// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.graphics.Bitmap;

// Referenced classes of package android.support.v4.app:
//            bx, bl

public final class bj extends bx
{

    Bitmap a;

    public bj()
    {
    }

    public final bj a(Bitmap bitmap)
    {
        a = bitmap;
        return this;
    }

    public final bj a(CharSequence charsequence)
    {
        c = bl.e(charsequence);
        return this;
    }

    public final bj b(CharSequence charsequence)
    {
        d = bl.e(charsequence);
        e = true;
        return this;
    }
}

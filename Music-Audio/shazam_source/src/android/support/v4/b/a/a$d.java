// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.b.a;

import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.b.a:
//            a, f

static class rawable extends rawable
{

    public final void a(Drawable drawable, boolean flag)
    {
        drawable.setAutoMirrored(flag);
    }

    public final boolean b(Drawable drawable)
    {
        return drawable.isAutoMirrored();
    }

    public Drawable c(Drawable drawable)
    {
        Object obj = drawable;
        if (!(drawable instanceof f))
        {
            obj = new f(drawable);
        }
        return ((Drawable) (obj));
    }

    rawable()
    {
    }
}

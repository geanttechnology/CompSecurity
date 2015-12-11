// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c.a;

import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.c.a:
//            b, l

class c extends b
{

    c()
    {
    }

    public final void a(Drawable drawable)
    {
        drawable.jumpToCurrentState();
    }

    public Drawable c(Drawable drawable)
    {
        Object obj = drawable;
        if (!(drawable instanceof l))
        {
            obj = new l(drawable);
        }
        return ((Drawable) (obj));
    }
}

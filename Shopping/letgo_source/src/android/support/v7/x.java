// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7:
//            ac

class x
{

    public static void a(Drawable drawable)
    {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable)
    {
        Object obj = drawable;
        if (!(drawable instanceof ac))
        {
            obj = new ac(drawable);
        }
        return ((Drawable) (obj));
    }
}

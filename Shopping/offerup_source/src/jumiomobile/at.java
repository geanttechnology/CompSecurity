// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;

public class at
{

    public static void a(Drawable drawable, int i)
    {
        if ((drawable instanceof BitmapDrawable) || (drawable instanceof NinePatchDrawable))
        {
            drawable.setTint(i);
            return;
        } else
        {
            drawable.setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        }
    }
}

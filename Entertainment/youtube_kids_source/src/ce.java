// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

final class ce extends cd
{

    ce()
    {
    }

    public final void a(Drawable drawable, float f, float f1)
    {
        drawable.setHotspot(f, f1);
    }

    public final void a(Drawable drawable, int i)
    {
        drawable.setTint(i);
    }

    public final void a(Drawable drawable, int i, int j, int k, int l)
    {
        drawable.setHotspotBounds(i, j, k, l);
    }

    public final void a(Drawable drawable, ColorStateList colorstatelist)
    {
        drawable.setTintList(colorstatelist);
    }

    public final void a(Drawable drawable, android.graphics.PorterDuff.Mode mode)
    {
        drawable.setTintMode(mode);
    }
}

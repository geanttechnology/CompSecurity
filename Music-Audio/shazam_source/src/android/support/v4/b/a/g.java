// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.b.a;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.b.a:
//            f

final class g extends f
{

    g(Drawable drawable)
    {
        super(drawable);
    }

    public final void applyTheme(android.content.res.Resources.Theme theme)
    {
        b.applyTheme(theme);
    }

    public final boolean canApplyTheme()
    {
        return b.canApplyTheme();
    }

    public final Rect getDirtyBounds()
    {
        return b.getDirtyBounds();
    }

    public final void getOutline(Outline outline)
    {
        b.getOutline(outline);
    }

    public final void setHotspot(float f1, float f2)
    {
        b.setHotspot(f1, f2);
    }

    public final void setHotspotBounds(int i, int j, int k, int l)
    {
        b.setHotspotBounds(i, j, k, l);
    }
}

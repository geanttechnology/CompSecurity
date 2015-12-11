// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

final class ia extends Resources
{

    private final hy a;

    public ia(Resources resources, hy hy1)
    {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        a = hy1;
    }

    public final Drawable getDrawable(int i)
    {
        Drawable drawable = super.getDrawable(i);
        if (drawable != null)
        {
            a.a(i, drawable);
        }
        return drawable;
    }
}

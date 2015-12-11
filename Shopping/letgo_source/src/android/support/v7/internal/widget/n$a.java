// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7.internal.widget:
//            j, n, p

static class a extends j
{

    private final p a;

    public Drawable getDrawable(int i)
        throws android.content.res.urces.NotFoundException
    {
        Drawable drawable = super.getDrawable(i);
        if (drawable != null)
        {
            a.a(i, drawable);
        }
        return drawable;
    }

    public xception(Resources resources, p p1)
    {
        super(resources);
        a = p1;
    }
}

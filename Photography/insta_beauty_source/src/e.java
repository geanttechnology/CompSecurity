// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;

class e
    implements android.support.v4.app.ActionBarDrawerToggle.Delegate, o
{

    final c a;

    private e(c c1)
    {
        a = c1;
        super();
    }

    e(c c1, d d)
    {
        this(c1);
    }

    public Drawable getThemeUpIndicator()
    {
        TypedArray typedarray = a.l().obtainStyledAttributes(new int[] {
            a.j()
        });
        Drawable drawable = typedarray.getDrawable(0);
        typedarray.recycle();
        return drawable;
    }

    public void setActionBarDescription(int i)
    {
        ActionBar actionbar = a.b();
        if (actionbar != null)
        {
            actionbar.a(i);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, int i)
    {
        ActionBar actionbar = a.b();
        if (actionbar != null)
        {
            actionbar.a(drawable);
            actionbar.a(i);
        }
    }
}

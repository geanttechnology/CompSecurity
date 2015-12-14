// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;

class d
    implements android.support.v4.app.ActionBarDrawerToggle.Delegate, i
{

    final c a;

    private d(c c1)
    {
        a = c1;
        super();
    }

    d(c c1, c._cls1 _pcls1)
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

    public void setActionBarDescription(int j)
    {
        ActionBar actionbar = a.b();
        if (actionbar != null)
        {
            actionbar.a(j);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, int j)
    {
        ActionBar actionbar = a.b();
        if (actionbar != null)
        {
            actionbar.a(drawable);
            actionbar.a(j);
        }
    }
}

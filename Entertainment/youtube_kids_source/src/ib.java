// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public final class ib
{

    public final TypedArray a;
    private final Context b;
    private hy c;

    private ib(Context context, TypedArray typedarray)
    {
        b = context;
        a = typedarray;
    }

    public static ib a(Context context, AttributeSet attributeset, int ai[], int i, int j)
    {
        return new ib(context, context.obtainStyledAttributes(attributeset, ai, i, 0));
    }

    public final int a(int i, int j)
    {
        return a.getInt(i, j);
    }

    public final Drawable a(int i)
    {
        if (a.hasValue(i))
        {
            int j = a.getResourceId(i, 0);
            if (j != 0)
            {
                return a().a(j);
            }
        }
        return a.getDrawable(i);
    }

    public final hy a()
    {
        if (c == null)
        {
            c = new hy(b);
        }
        return c;
    }

    public final boolean a(int i, boolean flag)
    {
        return a.getBoolean(i, flag);
    }

    public final int b(int i, int j)
    {
        return a.getDimensionPixelOffset(i, j);
    }

    public final CharSequence b(int i)
    {
        return a.getText(i);
    }

    public final int c(int i, int j)
    {
        return a.getDimensionPixelSize(i, j);
    }

    public final boolean c(int i)
    {
        return a.hasValue(i);
    }

    public final int d(int i, int j)
    {
        return a.getLayoutDimension(i, 0);
    }

    public final int e(int i, int j)
    {
        return a.getResourceId(i, j);
    }
}

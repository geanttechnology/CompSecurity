// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.wishabi.flipp.widget:
//            da

public class cz extends da
{

    private final Context a;
    public final Cursor d;

    protected cz(Context context, Cursor cursor)
    {
        a = context;
        d = cursor;
    }

    protected final View a(int i, int j, View view)
    {
        if (!d.moveToPosition(b(i, j)))
        {
            throw new IllegalStateException((new StringBuilder("Couldn't move cursor to position ")).append(b(i, j)).toString());
        } else
        {
            return a(a, d, i, view);
        }
    }

    protected final View a(int i, View view, ViewGroup viewgroup)
    {
        return a(a, i, view, viewgroup);
    }

    protected View a(Context context, int i, View view, ViewGroup viewgroup)
    {
        return null;
    }

    protected View a(Context context, Cursor cursor, int i, View view)
    {
        return null;
    }

    public final Object a(int i)
    {
        if (d != null && i < d.getCount())
        {
            d.moveToPosition(i);
            return d;
        } else
        {
            return null;
        }
    }
}

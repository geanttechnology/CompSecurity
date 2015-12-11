// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.droidparts.adapter.cursor;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import org.droidparts.Injector;

public abstract class CursorAdapter extends android.widget.CursorAdapter
{

    private final Context ctx;
    private LayoutInflater layoutInflater;

    public CursorAdapter(Context context, Cursor cursor)
    {
        super(context, cursor);
        ctx = context.getApplicationContext();
        Injector.inject(context, this);
    }

    protected Context getContext()
    {
        return ctx;
    }

    protected LayoutInflater getLayoutInflater()
    {
        return layoutInflater;
    }

    public void requeryData()
    {
        Cursor cursor = getCursor();
        if (cursor != null)
        {
            cursor.requery();
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.widget:
//            CursorAdapter

public abstract class ResourceCursorAdapter extends CursorAdapter
{

    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    public ResourceCursorAdapter(Context context, int i)
    {
        super(context, null, true);
        mDropDownLayout = i;
        mLayout = i;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return mInflater.inflate(mDropDownLayout, viewgroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return mInflater.inflate(mLayout, viewgroup, false);
    }
}

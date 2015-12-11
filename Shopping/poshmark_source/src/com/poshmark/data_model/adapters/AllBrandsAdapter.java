// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.view_holders.AllBrandsListViewHolder;

public class AllBrandsAdapter extends CursorAdapter
{

    private LayoutInflater inflater;

    public AllBrandsAdapter(Context context, Fragment fragment, Cursor cursor, int i)
    {
        super(context, cursor, i);
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        view = (AllBrandsListViewHolder)view.getTag();
        context = cursor.getString(cursor.getColumnIndex("canonical_name"));
        ((AllBrandsListViewHolder) (view)).title.setText(context);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        inflater = LayoutInflater.from(context);
        context = inflater.inflate(0x7f03000c, viewgroup, false);
        cursor = new AllBrandsListViewHolder();
        cursor.title = (PMTextView)context.findViewById(0x7f0c0056);
        context.setTag(cursor);
        return context;
    }
}

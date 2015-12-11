// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.utils.view_holders.ListingViewHolder;

public class UserInteractionsAdapter extends CursorAdapter
{

    public UserInteractionsAdapter(Context context, Cursor cursor, int i)
    {
        super(context, cursor, i);
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        context = (CustomMatrixCursor)cursor;
        context = (UserReference)context.get(context.getColumnIndex(PMData.DATA_COL));
        cursor = (ImageView)view.findViewById(0x7f0c02f4);
        ImageLoader imageloader = ImageLoader.getInstance();
        if (context.getAvataar() != null)
        {
            imageloader.displayImage(context.getAvataar(), cursor);
        } else
        {
            cursor.setImageResource(0x7f0200d4);
        }
        ((TextView)view.findViewById(0x7f0c02f5)).setText(context.getDisplayHandle());
    }

    public CharSequence convertToString(Cursor cursor)
    {
        cursor = (CustomMatrixCursor)cursor;
        cursor = ((UserReference)cursor.get(cursor.getColumnIndex(PMData.DATA_COL))).getDisplayHandle();
        return (new StringBuilder()).append("@").append(cursor).toString();
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f0300c8, viewgroup, false);
        context.setTag(new ListingViewHolder());
        return context;
    }
}

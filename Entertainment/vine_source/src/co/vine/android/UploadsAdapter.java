// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.client.AppController;

public class UploadsAdapter extends CursorAdapter
{
    private class UploadViewHolder
    {

        public ImageView retry;
        public TextView status;
        final UploadsAdapter this$0;
        public ImageView thumbnail;

        public UploadViewHolder(View view)
        {
            this$0 = UploadsAdapter.this;
            super();
            thumbnail = (ImageView)view.findViewById(0x7f0a0065);
            status = (TextView)view.findViewById(0x7f0a0228);
            retry = (ImageView)view.findViewById(0x7f0a0229);
        }
    }


    protected final AppController mAppController;
    private final int mDividerColor;

    public UploadsAdapter(Context context, AppController appcontroller, int i)
    {
        this(context, appcontroller, i, 0x7f090094);
    }

    public UploadsAdapter(Context context, AppController appcontroller, int i, int j)
    {
        super(context, null, i);
        mAppController = appcontroller;
        mDividerColor = context.getResources().getColor(j);
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        view = (UploadViewHolder)view.getTag();
        ((UploadViewHolder) (view)).status.setText(0x7f0e025a);
        ((UploadViewHolder) (view)).retry.setVisibility(8);
        if (cursor.getPosition() == 0)
        {
            ((UploadViewHolder) (view)).retry.setVisibility(0);
        }
        context = cursor.getString(6);
        ((UploadViewHolder) (view)).thumbnail.setImageBitmap(BitmapFactory.decodeFile(context));
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f03009f, viewgroup, false);
        context.findViewById(0x7f0a0060).setBackgroundColor(mDividerColor);
        context.setTag(new UploadViewHolder(context));
        return context;
    }
}

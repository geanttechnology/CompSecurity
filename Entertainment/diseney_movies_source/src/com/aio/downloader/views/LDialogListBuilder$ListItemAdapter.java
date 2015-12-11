// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.views:
//            LDialogListBuilder, LDialogController

public class isChooseMode extends BaseAdapter
{
    private class ViewHolder
    {

        ImageView mIconImageView;
        TextView mTextView;
        final LDialogListBuilder.ListItemAdapter this$1;

        private ViewHolder()
        {
            this$1 = LDialogListBuilder.ListItemAdapter.this;
            super();
        }

        ViewHolder(ViewHolder viewholder)
        {
            this();
        }
    }


    private boolean isChooseMode;
    private String items[];
    private Context mContext;
    private int selectedIndex;
    final LDialogListBuilder this$0;

    public int getCount()
    {
        return items.length;
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        ImageView imageview;
        boolean flag;
        if (view == null)
        {
            viewgroup = new ViewHolder(null);
            view = View.inflate(mContext, 0x7f030073, null);
            viewgroup.mTextView = (TextView)view.findViewById(0x7f0702c6);
            viewgroup.mIconImageView = (ImageView)view.findViewById(0x7f0702c7);
            if (isChooseMode)
            {
                ((ViewHolder) (viewgroup)).mIconImageView.setVisibility(0);
            }
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        imageview = ((ViewHolder) (viewgroup)).mIconImageView;
        if (selectedIndex == position)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        imageview.setSelected(flag);
        ((ViewHolder) (viewgroup)).mTextView.setText(items[position]);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final LDialogListBuilder.ListItemAdapter this$1;
            private final int val$position;

            public void onClick(View view1)
            {
                if (LDialogListBuilder.access$0(this$0) != null)
                {
                    if (LDialogListBuilder.access$1(this$0) == null)
                    {
                        view1 = null;
                    } else
                    {
                        view1 = LDialogListBuilder.access$1(this$0).getDialogInterface();
                    }
                    LDialogListBuilder.access$0(this$0).onClick(view1, position);
                    if (view1 != null)
                    {
                        view1.dismiss();
                    }
                }
            }

            
            {
                this$1 = LDialogListBuilder.ListItemAdapter.this;
                position = i;
                super();
            }
        });
        return view;
    }

    public void setSelectedIndex(int i)
    {
        selectedIndex = i;
        notifyDataSetChanged();
    }


    public _cls1.val.position(Context context, String as[], int i, boolean flag)
    {
        this$0 = LDialogListBuilder.this;
        super();
        selectedIndex = -1;
        mContext = context;
        items = as;
        selectedIndex = i;
        isChooseMode = flag;
    }
}

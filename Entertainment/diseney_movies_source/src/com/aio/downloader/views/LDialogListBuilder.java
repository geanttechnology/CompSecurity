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
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.views:
//            LAlertDialog, LDialogController

public class LDialogListBuilder extends LAlertDialog.Builder
{
    public class ListItemAdapter extends BaseAdapter
    {

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

        public View getView(int i, View view, ViewGroup viewgroup)
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
            if (selectedIndex == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            imageview.setSelected(flag);
            ((ViewHolder) (viewgroup)).mTextView.setText(items[i]);
            view.setOnClickListener(i. new android.view.View.OnClickListener() {

                final ListItemAdapter this$1;
                private final int val$position;

                public void onClick(View view)
                {
                    if (mListener != null)
                    {
                        if (mController == null)
                        {
                            view = null;
                        } else
                        {
                            view = mController.getDialogInterface();
                        }
                        mListener.onClick(view, position);
                        if (view != null)
                        {
                            view.dismiss();
                        }
                    }
                }

            
            {
                this$1 = final_listitemadapter;
                position = I.this;
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


        public ListItemAdapter(Context context, String as[], int i, boolean flag)
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

    private class ListItemAdapter.ViewHolder
    {

        ImageView mIconImageView;
        TextView mTextView;
        final ListItemAdapter this$1;

        private ListItemAdapter.ViewHolder()
        {
            this$1 = ListItemAdapter.this;
            super();
        }

        ListItemAdapter.ViewHolder(ListItemAdapter.ViewHolder viewholder)
        {
            this();
        }
    }


    private ListItemAdapter mAdapter;
    private Context mContext;
    private LDialogController mController;
    private boolean mIsChooseMode;
    private ListView mListView;
    private android.content.DialogInterface.OnClickListener mListener;
    private int mSelectedIndex;

    public LDialogListBuilder(Context context, int i, boolean flag)
    {
        super(context);
        mSelectedIndex = -1;
        mContext = context;
        context = View.inflate(mContext, 0x7f030072, null);
        mListView = (ListView)context.findViewById(0x7f0702c5);
        setView(context);
        mSelectedIndex = i;
        mIsChooseMode = flag;
    }

    public LAlertDialog create()
    {
        LAlertDialog lalertdialog = super.create();
        mController = lalertdialog.getController();
        return lalertdialog;
    }

    public LAlertDialog.Builder setItems(String as[], android.content.DialogInterface.OnClickListener onclicklistener)
    {
        mListener = onclicklistener;
        mAdapter = new ListItemAdapter(mContext, as, mSelectedIndex, mIsChooseMode);
        mListView.setAdapter(mAdapter);
        return this;
    }

    public void setSelectedIndex(int i)
    {
        mSelectedIndex = i;
        if (mAdapter != null)
        {
            mAdapter.setSelectedIndex(i);
        }
    }

    public LAlertDialog show()
    {
        LAlertDialog lalertdialog = create();
        lalertdialog.show();
        return lalertdialog;
    }


}

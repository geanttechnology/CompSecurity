// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wishlist;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.wishlist.WishListManageController;
import com.amazon.rio.j2me.client.services.mShop.ListList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.wishlist:
//            WishListChooserSubscriber

public class WishListChooserView extends ListView
{
    private class WishListsAdapter extends BaseAdapter
        implements android.widget.AdapterView.OnItemClickListener
    {

        private List mWishLists;
        final WishListChooserView this$0;

        public int getCount()
        {
            if (mWishLists == null)
            {
                return 0;
            } else
            {
                return mWishLists.size();
            }
        }

        public ListList getItem(int i)
        {
            return (ListList)mWishLists.get(i);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = View.inflate(mActivity, com.amazon.mShop.android.lib.R.layout.wishlist_chooser_item, null);
            }
            viewgroup = getItem(i);
            TextView textview = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_title);
            textview.setText(viewgroup.getListTitle());
            ImageView imageview = (ImageView)view.findViewById(com.amazon.mShop.android.lib.R.id.check_mark);
            ListList listlist;
            switch (mOperationType)
            {
            default:
                imageview.setVisibility(8);
                textview.setTextColor(getResources().getColor(com.amazon.mShop.android.lib.R.color.dark_text));
                return view;

            case 0: // '\0'
                listlist = WishListManageController.getInstance().getCurrentList();
                break;
            }
            if (listlist != null && viewgroup.getListId().equals(listlist.getListId()))
            {
                imageview.setVisibility(0);
                textview.setTextColor(getResources().getColor(com.amazon.mShop.android.lib.R.color.background_gray));
                return view;
            } else
            {
                imageview.setVisibility(8);
                textview.setTextColor(getResources().getColor(com.amazon.mShop.android.lib.R.color.dark_text));
                return view;
            }
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            mOperationType;
            JVM INSTR tableswitch 0 0: default 24
        //                       0 51;
               goto _L1 _L2
_L1:
            adapterview = getItem(i);
            mChooserSubscriber.onListSelected(adapterview, mOperationType);
            return;
_L2:
            for (int j = 0; j < getChildCount(); j++)
            {
                adapterview = getChildAt(j);
                if (adapterview != null)
                {
                    ((ImageView)adapterview.findViewById(com.amazon.mShop.android.lib.R.id.check_mark)).setVisibility(8);
                }
            }

            ((ImageView)view.findViewById(com.amazon.mShop.android.lib.R.id.check_mark)).setVisibility(0);
            if (true) goto _L1; else goto _L3
_L3:
        }

        public void setWishLists(List list)
        {
            mWishLists = list;
        }

        private WishListsAdapter()
        {
            this$0 = WishListChooserView.this;
            super();
        }

    }


    private AmazonActivity mActivity;
    private WishListChooserSubscriber mChooserSubscriber;
    private int mOperationType;
    protected WishListsAdapter mWishListsAdapter;

    public WishListChooserView(AmazonActivity amazonactivity, int i, WishListChooserSubscriber wishlistchoosersubscriber)
    {
        super(amazonactivity);
        mActivity = amazonactivity;
        mChooserSubscriber = wishlistchoosersubscriber;
        mOperationType = i;
        mWishListsAdapter = new WishListsAdapter();
        setBackgroundResource(com.amazon.mShop.android.lib.R.color.white);
        setItemsCanFocus(true);
        setAdapter(mWishListsAdapter);
        setOnItemClickListener(mWishListsAdapter);
    }

    public void setWishLists(List list)
    {
        mWishListsAdapter.setWishLists(list);
    }



}

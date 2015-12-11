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
import android.widget.TextView;
import com.amazon.mShop.control.wishlist.WishListManageController;
import com.amazon.rio.j2me.client.services.mShop.ListList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.wishlist:
//            WishListChooserView, WishListChooserSubscriber

private class <init> extends BaseAdapter
    implements android.widget.stsAdapter
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
            view = View.inflate(WishListChooserView.access$100(WishListChooserView.this), com.amazon.mShop.android.lib.s._fld0, null);
        }
        viewgroup = getItem(i);
        TextView textview = (TextView)view.findViewById(com.amazon.mShop.android.lib.Item);
        textview.setText(viewgroup.getListTitle());
        ImageView imageview = (ImageView)view.findViewById(com.amazon.mShop.android.lib.Item);
        ListList listlist;
        switch (WishListChooserView.access$200(WishListChooserView.this))
        {
        default:
            imageview.setVisibility(8);
            textview.setTextColor(getResources().getColor(com.amazon.mShop.android.lib.s._fld0));
            return view;

        case 0: // '\0'
            listlist = WishListManageController.getInstance().getCurrentList();
            break;
        }
        if (listlist != null && viewgroup.getListId().equals(listlist.getListId()))
        {
            imageview.setVisibility(0);
            textview.setTextColor(getResources().getColor(com.amazon.mShop.android.lib.entList));
            return view;
        } else
        {
            imageview.setVisibility(8);
            textview.setTextColor(getResources().getColor(com.amazon.mShop.android.lib.entList));
            return view;
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        WishListChooserView.access$200(WishListChooserView.this);
        JVM INSTR tableswitch 0 0: default 24
    //                   0 51;
           goto _L1 _L2
_L1:
        adapterview = getItem(i);
        WishListChooserView.access$300(WishListChooserView.this).onListSelected(adapterview, WishListChooserView.access$200(WishListChooserView.this));
        return;
_L2:
        for (int j = 0; j < getChildCount(); j++)
        {
            adapterview = getChildAt(j);
            if (adapterview != null)
            {
                ((ImageView)adapterview.findViewById(com.amazon.mShop.android.lib.s._fld0)).setVisibility(8);
            }
        }

        ((ImageView)view.findViewById(com.amazon.mShop.android.lib.s._fld0)).setVisibility(0);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setWishLists(List list)
    {
        mWishLists = list;
    }

    private ()
    {
        this$0 = WishListChooserView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

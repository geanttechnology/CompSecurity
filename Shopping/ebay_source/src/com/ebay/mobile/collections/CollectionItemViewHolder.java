// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionItemViewModel

public class CollectionItemViewHolder extends ViewHolder
{
    public class HolderView
    {

        private final RemoteImageView imageView;
        private final View parentView;
        private final TextView priceView;
        private final View selectableView;
        final CollectionItemViewHolder this$0;
        private final TextView titleView;

        public void setImageUrl(String s)
        {
            if (imageView != null)
            {
                imageView.setRemoteImageUrl(s);
            }
        }

        public void setItemIdTag(String s)
        {
            if (selectableView != null)
            {
                selectableView.setTag(s);
            }
        }

        public void setLargeImageHeight(boolean flag)
        {
            float f = itemView.getResources().getDimension(0x7f090049);
            if (flag)
            {
                ((android.view.ViewGroup.MarginLayoutParams)imageView.getLayoutParams()).height = (int)(2.0F * f);
                return;
            } else
            {
                ((android.view.ViewGroup.MarginLayoutParams)imageView.getLayoutParams()).height = (int)f;
                return;
            }
        }

        public void setPrice(String s)
        {
            if (priceView != null)
            {
                priceView.setText(s);
            }
        }

        public void setTitle(String s)
        {
            if (titleView != null)
            {
                titleView.setText(s);
            }
        }

        public void setVisibility(int i)
        {
            if (parentView != null)
            {
                parentView.setVisibility(i);
            }
        }

        public HolderView(TextView textview, TextView textview1, RemoteImageView remoteimageview, View view, View view1)
        {
            this$0 = CollectionItemViewHolder.this;
            super();
            titleView = textview;
            priceView = textview1;
            imageView = remoteimageview;
            selectableView = view;
            parentView = view1;
        }
    }


    public List holderViews;

    public CollectionItemViewHolder(View view)
    {
        super(view);
        holderViews = new ArrayList();
        if (!getViews(itemView.findViewById(0x7f100124)))
        {
            getViews(itemView);
        } else
        if (getViews(itemView.findViewById(0x7f100125)) && getViews(itemView.findViewById(0x7f10012a)) && getViews(itemView.findViewById(0x7f100129)) && !getViews(itemView.findViewById(0x7f10012b)))
        {
            return;
        }
    }

    private boolean getViews(View view)
    {
        View view1;
        if (view != null)
        {
            if ((view1 = view.findViewById(0x7f1000f1)) != null)
            {
                view1.setOnClickListener(this);
                RemoteImageView remoteimageview = (RemoteImageView)view.findViewById(0x7f100126);
                TextView textview = (TextView)view.findViewById(0x7f100127);
                TextView textview1 = (TextView)view.findViewById(0x7f100128);
                holderViews.add(new HolderView(textview, textview1, remoteimageview, view1, view));
                return true;
            }
        }
        return false;
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        if (!(viewmodel instanceof CollectionItemViewModel))
        {
            return false;
        }
        for (viewmodel = ((CollectionItemViewModel)viewmodel).collectionItems.iterator(); viewmodel.hasNext();)
        {
            CollectionItemViewModel.CollectionItemDetail collectionitemdetail = (CollectionItemViewModel.CollectionItemDetail)viewmodel.next();
            if (!isNotEmpty(new CharSequence[] {
    collectionitemdetail.image, collectionitemdetail.itemId
}))
            {
                return false;
            }
        }

        return true;
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if ((viewmodel instanceof CollectionItemViewModel) && ((CollectionItemViewModel)viewmodel).collectionItems != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        CollectionItemViewModel collectionitemviewmodel;
        int i;
        int k;
        int l;
        collectionitemviewmodel = (CollectionItemViewModel)viewmodel;
        k = collectionitemviewmodel.collectionItems.size();
        if (k == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = (int)itemView.getResources().getDimension(0x7f090143);
        l = (int)itemView.getResources().getDimension(0x7f090141);
        collectionitemviewmodel.viewType;
        JVM INSTR tableswitch 3 5: default 104
    //                   3 215
    //                   4 231
    //                   5 247;
           goto _L3 _L4 _L5 _L6
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_247;
_L7:
        i = 0;
        while (i < k) 
        {
            CollectionItemViewModel.CollectionItemDetail collectionitemdetail = (CollectionItemViewModel.CollectionItemDetail)collectionitemviewmodel.collectionItems.get(i);
            HolderView holderview = (HolderView)holderViews.get(i);
            holderview.setVisibility(0);
            holderview.setTitle(collectionitemdetail.title);
            holderview.setPrice(collectionitemdetail.price);
            holderview.setImageUrl(collectionitemdetail.image);
            holderview.setItemIdTag(collectionitemdetail.itemId);
            if (viewmodel.viewType == 5)
            {
                setFullSpan(true);
                holderview.setLargeImageHeight(true);
            } else
            {
                setFullSpan(false);
                holderview.setLargeImageHeight(false);
            }
            i++;
        }
        break MISSING_BLOCK_LABEL_277;
_L4:
        itemView.setPadding(i, 0, l, 0);
          goto _L7
_L5:
        itemView.setPadding(l, 0, i, 0);
          goto _L7
        itemView.setPadding(i, 0, i, 0);
          goto _L7
        int i1 = holderViews.size();
        int j = k;
        while (j < i1) 
        {
            ((HolderView)holderViews.get(j)).setVisibility(8);
            j++;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }
}

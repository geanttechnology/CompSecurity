// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionItemViewHolder

public class parentView
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
            ((android.view.der.itemView)imageView.getLayoutParams()).Params = (int)(2.0F * f);
            return;
        } else
        {
            ((android.view.Params)imageView.getLayoutParams()).Params = (int)f;
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

    public (TextView textview, TextView textview1, RemoteImageView remoteimageview, View view, View view1)
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

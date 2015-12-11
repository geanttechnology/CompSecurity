// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.ObjectSubscriberAdapter;
import com.amazon.mShop.imageview.MShopScaleGestoreDetector;

// Referenced classes of package com.amazon.mShop.details:
//            ProductImagesView

private class this._cls0 extends ObjectSubscriberAdapter
{

    final ProductImagesView this$0;

    public int getCount()
    {
        return ProductImagesView.access$200(ProductImagesView.this).getCount();
    }

    public Drawable getItem(int i)
    {
        return ProductImagesView.access$200(ProductImagesView.this).getImage(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view instanceof ImageView)
        {
            viewgroup = (ImageView)view;
            view = viewgroup;
            if (Integer.valueOf(i).equals(viewgroup.getTag()))
            {
                return viewgroup;
            }
        } else
        {
            view = new ImageView(getContext());
            view.setAdjustViewBounds(true);
            view.setFocusable(false);
            view.setLayoutParams(new android.widget.geAdapter.getContext(-1, -2));
            view.setTag(Integer.valueOf(i));
        }
        ProductImagesView.access$1000(ProductImagesView.this, getItem(i), view, false);
        return view;
    }

    public void onImageReceived(Drawable drawable, int i)
    {
        notifyDataSetChanged();
        ProductImagesView.access$300(ProductImagesView.this, drawable, i);
        if (ProductImagesView.access$400(ProductImagesView.this) == null)
        {
            ProductImagesView.access$402(ProductImagesView.this, new GestureDetector(getContext(), new er(ProductImagesView.this, null)));
            if (Integer.parseInt(android.os.._fld1) >= 8)
            {
                ProductImagesView.access$602(ProductImagesView.this, MShopScaleGestoreDetector.newInstance(getContext(), new (ProductImagesView.this, null)));
            } else
            {
                ProductImagesView.access$602(ProductImagesView.this, MShopScaleGestoreDetector.newInstance(getContext(), null));
            }
            ProductImagesView.access$100(ProductImagesView.this).setOnTouchListener(ProductImagesView.access$800(ProductImagesView.this));
            if (ProductImagesView.access$900(ProductImagesView.this) == -1)
            {
                setSelectedState(0, ICK);
                ProductImagesView.access$100(ProductImagesView.this).setSelection(0);
            }
        }
        if (ProductImagesView.access$900(ProductImagesView.this) == i)
        {
            setSelectedState(ProductImagesView.access$900(ProductImagesView.this), ICK);
            ProductImagesView.access$100(ProductImagesView.this).setSelection(ProductImagesView.access$900(ProductImagesView.this));
        }
    }

    public (AmazonActivity amazonactivity)
    {
        this$0 = ProductImagesView.this;
        super(amazonactivity);
    }
}

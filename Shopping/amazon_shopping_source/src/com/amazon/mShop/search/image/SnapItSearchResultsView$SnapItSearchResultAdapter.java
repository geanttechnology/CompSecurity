// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.ItemView;
import com.amazon.mShop.NonPagedItemAdapter;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.search.image.ImageSearchController;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.ui.WeakReferenceBitmapDrawable;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItSearchResultsView

protected class this._cls0 extends NonPagedItemAdapter
{

    final SnapItSearchResultsView this$0;

    private byte[] convertDrawableIntoByteArray(Drawable drawable)
    {
        Bitmap bitmap = null;
        if (drawable instanceof WeakReferenceBitmapDrawable)
        {
            bitmap = ((WeakReferenceBitmapDrawable)drawable).getBitmap();
        } else
        if (drawable instanceof BitmapDrawable)
        {
            bitmap = ((BitmapDrawable)drawable).getBitmap();
        }
        if (bitmap != null)
        {
            drawable = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.esultAdapter, 100, drawable);
            return drawable.toByteArray();
        } else
        {
            return null;
        }
    }

    public int getCount()
    {
        return SnapItSearchResultsView.access$100(SnapItSearchResultsView.this).count();
    }

    public Object getItem(int i)
    {
        return SnapItSearchResultsView.access$100(SnapItSearchResultsView.this).getSearchResult(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        SearchResult searchresult;
        Bitmap bitmap;
        String s;
        if (view == null)
        {
            view = (ItemView)mLayoutInflater.inflate(mRowResId, null);
        } else
        {
            view = (ItemView)view;
        }
        view.setIsGetImageFromURL(true);
        searchresult = (SearchResult)getItem(i);
        s = ImageUtil.getImageUrl(searchresult.getBasicProduct().getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib..getItem));
        bitmap = (Bitmap)LRUCache.getValue(s, android/graphics/Bitmap);
        viewgroup = null;
        if (bitmap != null)
        {
            viewgroup = new com.amazon.mShop.net.tAdapter.getItem(s, null);
            viewgroup = DrawableFactory.getInstance().wable(getResources(), bitmap, viewgroup);
        }
        view.update(this, searchresult, viewgroup, i);
        return view;
    }

    protected Object makeObjectForForward(int i, View view)
    {
        ProductController productcontroller = new ProductController((SearchResult)getItem(i));
        productcontroller.setClickStreamTag(ClickStreamTag.ORIGIN_SNAP_TELL);
        view = (ImageView)view.findViewById(com.amazon.mShop.android.lib..getItem);
        if (view != null)
        {
            productcontroller.setThumbnail(convertDrawableIntoByteArray(view.getDrawable()));
        }
        RefMarkerObserver.logRefMarker("sr_snap_pd");
        return productcontroller;
    }

    public void setListView(ListView listview)
    {
        setAdapterView(listview);
    }

    public (AmazonActivity amazonactivity, int i)
    {
        this$0 = SnapItSearchResultsView.this;
        super(amazonactivity, i);
    }
}

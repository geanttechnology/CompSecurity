// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.android.widget.ExpandingImageView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.view.ItemAdapter;
import com.ebay.common.view.ViewCache;
import com.ebay.nautilus.domain.data.EbayItem;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            RtmItemListActivity

private class init> extends ArrayAdapter
{

    private static final int layout = 0x7f030074;
    private final Bitmap bannerImage;
    private final LayoutInflater inflater;
    private final ItemAdapter itemAdapter;
    final RtmItemListActivity this$0;

    private View getBannerView(Context context)
    {
        context = new ExpandingImageView(context);
        context.setImageBitmap(bannerImage);
        return context;
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public int getCount()
    {
        return super.getCount() + 1;
    }

    public EbayItem getItem(int i)
    {
        return (EbayItem)super.getItem(i - 1);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        long l1 = -1L;
        long l = l1;
        if (i != 0)
        {
            EbayItem ebayitem = getItem(i);
            l = l1;
            if (ebayitem != null)
            {
                l = ebayitem.id;
            }
        }
        return l;
    }

    public int getItemViewType(int i)
    {
        if (i == 0)
        {
            return -1;
        } else
        {
            return super.getItemViewType(i - 1);
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i == 0)
        {
            return getBannerView(super.getContext());
        }
        EbayItem ebayitem;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f030074, viewgroup, false);
            view = new ViewCache(viewgroup);
            viewgroup.setTag(view);
            itemAdapter.init(view);
        } else
        {
            viewgroup = view;
            view = (ViewCache)viewgroup.getTag();
        }
        ebayitem = getItem(i);
        view.object = ebayitem;
        if (ebayitem != null)
        {
            itemAdapter.setItem(view, ebayitem, i);
            return viewgroup;
        } else
        {
            ((ViewCache) (view)).image.setImageResource(0x7f0201f5);
            ((ViewCache) (view)).image.setTag(null);
            ((ViewCache) (view)).text.setText(null);
            ((ViewCache) (view)).rightColumnText1.setText(null);
            ((ViewCache) (view)).rightColumnText2.setText(null);
            ((ViewCache) (view)).rightColumnText3.setText(null);
            ((ViewCache) (view)).rightColumnText4.setText(null);
            ((ViewCache) (view)).rightColumnText5.setVisibility(8);
            ((ViewCache) (view)).imageLeaveFeedback.setVisibility(8);
            ((ViewCache) (view)).imageItemShipped.setVisibility(8);
            ((ViewCache) (view)).imageStampEnding.setVisibility(8);
            ((ViewCache) (view)).imageStampOutbid.setVisibility(8);
            ((ViewCache) (view)).imageStampPaid.setVisibility(8);
            return viewgroup;
        }
    }

    public boolean isEnabled(int i)
    {
        return i > 0;
    }

    public (Activity activity, List list, Bitmap bitmap)
    {
        this$0 = RtmItemListActivity.this;
        super(activity, 0x7f030074, list);
        bannerImage = bitmap;
        inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        itemAdapter = new init>(RtmItemListActivity.this, activity, true, true, true);
    }
}

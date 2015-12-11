// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import com.amazon.mShop.ItemView;
import com.amazon.mShop.ObjectSubscriberAdapter;
import com.amazon.mShop.details.ItemViewUtils;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSearchResultWrapper

public class ViewItAnimationItemView extends ItemView
{

    private ImageView mItemRowImage;
    private Button mSeeAllMatchesButton;

    public ViewItAnimationItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mItemRowImage = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.item_row_image);
        mSeeAllMatchesButton = (Button)findViewById(com.amazon.mShop.android.lib.R.id.see_all_matched_items_button);
    }

    public void update(ObjectSubscriberAdapter objectsubscriberadapter, Object obj, byte abyte0[], int i)
    {
        objectsubscriberadapter = (SearchResult)obj;
        com.amazon.rio.j2me.client.services.mShop.BasicOfferListing basicofferlisting = objectsubscriberadapter.getBasicOffer();
        BasicProductInfo basicproductinfo = objectsubscriberadapter.getBasicProduct();
        setImageRequester(obj);
        String s = ImageUtil.getImageUrl(basicproductinfo.getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_item_thumbnail_picture_max_dimension));
        obj = (Bitmap)LRUCache.getValue(s, android/graphics/Bitmap);
        objectsubscriberadapter = null;
        if (obj != null)
        {
            objectsubscriberadapter = new com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams(s, null);
            objectsubscriberadapter = DrawableFactory.getInstance().createDrawable(getResources(), ((Bitmap) (obj)), objectsubscriberadapter);
        }
        ItemViewUtils.updateImageWithDrawable(objectsubscriberadapter, mItemRowImage);
        if (objectsubscriberadapter == null && abyte0 == null && basicproductinfo != null && !Util.isEmpty(basicproductinfo.getImageUrl()))
        {
            getImageFromBackground(basicproductinfo.getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_item_thumbnail_picture_max_dimension));
        }
        updateItemView(i, basicofferlisting, basicproductinfo);
    }

    protected void updateAnimationItem(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        if (viewitsearchresultwrapper != null && !Util.isEmpty(viewitsearchresultwrapper.getSearchResults()))
        {
            if (viewitsearchresultwrapper.getSearchResults().size() > 1)
            {
                mSeeAllMatchesButton.setVisibility(0);
            } else
            {
                mSeeAllMatchesButton.setVisibility(8);
            }
            update((ObjectSubscriberAdapter)null, viewitsearchresultwrapper.getSearchResults().get(0), (byte[])null, 0);
        }
    }
}

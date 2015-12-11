// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.control.item.Product;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.details.ItemViewUtils;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.ui.BadgeView;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.util.BadgeUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BadgeInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;

// Referenced classes of package com.amazon.mShop:
//            Stars, AmazonActivity, ObjectSubscriberAdapter

public class ItemView extends LinearLayout
    implements com.amazon.mShop.net.HttpFetcher.Subscriber
{

    private BadgeView mBadgeView;
    private BitmapFetcher mBitmapFetcher;
    private Object mImageRequester;
    private boolean mIsGetImageFromURL;
    private LinearLayout mItemRowAmazonpoints;
    private TextView mItemRowBylineBinding;
    private TextView mItemRowCustomerReviewsCount;
    private ImageView mItemRowImage;
    private TextView mItemRowPrice;
    private Stars mItemRowRating;
    private TextView mItemRowTitle;
    private TextView mItemRowUsedAndNew;

    public ItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void cancelBitmapFetcher()
    {
        if (mBitmapFetcher != null)
        {
            mBitmapFetcher.cancel();
            mBitmapFetcher = null;
        }
    }

    private String getImageUrlFromObject(Object obj)
    {
        if (obj instanceof SearchResult)
        {
            obj = ((SearchResult)obj).getBasicProduct();
            if (obj != null)
            {
                return ((BasicProductInfo) (obj)).getImageUrl();
            }
        } else
        if (obj instanceof Product)
        {
            obj = ((Product)obj).getBasicProduct();
            if (obj != null)
            {
                return ((BasicProductInfo) (obj)).getImageUrl();
            }
        }
        return null;
    }

    protected void getImageFromBackground(String s)
    {
        getImageFromBackground(s, getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.item_row_height));
    }

    protected void getImageFromBackground(String s, int i)
    {
        if (mBitmapFetcher == null || mBitmapFetcher.isCancelled()) goto _L2; else goto _L1
_L1:
        if (!mBitmapFetcher.getParams().getBaseUrl().equals(s)) goto _L4; else goto _L3
_L3:
        return;
_L4:
        cancelBitmapFetcher();
_L2:
        if (s != null)
        {
            mBitmapFetcher = new BitmapFetcher(s, Integer.valueOf(i), this);
            mBitmapFetcher.fetch();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        cancelBitmapFetcher();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mItemRowImage = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.item_row_image);
        mItemRowTitle = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.item_title);
        mItemRowBylineBinding = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.item_byline_binding);
        mItemRowPrice = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.item_price);
        mItemRowAmazonpoints = (LinearLayout)findViewById(com.amazon.mShop.android.lib.R.id.item_amazonpoints);
        mItemRowUsedAndNew = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.item_used_and_new);
        mItemRowRating = (Stars)findViewById(com.amazon.mShop.android.lib.R.id.item_rating);
        mItemRowCustomerReviewsCount = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.item_customer_reviews_count);
        mBadgeView = (BadgeView)findViewById(com.amazon.mShop.android.lib.R.id.item_badge);
    }

    public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
    {
    }

    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        if (mBitmapFetcher != null && !mBitmapFetcher.isCancelled())
        {
            String s = ((com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams)params).getBaseUrl();
            if (mImageRequester != null && s.equals(getImageUrlFromObject(mImageRequester)))
            {
                mItemRowImage.setImageDrawable(DrawableFactory.getInstance().createDrawable(getResources(), bitmap, params));
            }
            mBitmapFetcher = null;
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        onHttpResponseReceived((Bitmap)obj, params);
    }

    protected void setImageRequester(Object obj)
    {
        mImageRequester = obj;
    }

    public void setIsGetImageFromURL(boolean flag)
    {
        mIsGetImageFromURL = flag;
    }

    protected boolean shouldShowItemBadge(BasicOfferListing basicofferlisting)
    {
        return BadgeUtils.isContainedBadge(basicofferlisting);
    }

    protected void showBadgeImageTogetherWithPrice(BasicOfferListing basicofferlisting, BasicProductInfo basicproductinfo)
    {
label0:
        {
            if (mItemRowPrice != null && mBadgeView == null)
            {
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
                basicproductinfo = ProductController.getPriceToDisplay(basicproductinfo, basicofferlisting);
                if (!Util.isEmpty(basicproductinfo))
                {
                    spannablestringbuilder.append(UIUtils.convertUnsupportedCharacter(getContext(), basicproductinfo, com.amazon.mShop.util.UIUtils.CharacterColor.RED));
                }
                ItemViewUtils.setBadgeImage((AmazonActivity)getContext(), basicofferlisting, mItemRowPrice, spannablestringbuilder, 0);
                if (spannablestringbuilder.length() <= 0)
                {
                    break label0;
                }
                mItemRowPrice.setText(spannablestringbuilder);
                mItemRowPrice.setVisibility(0);
            }
            return;
        }
        mItemRowPrice.setText(null);
        mItemRowPrice.setVisibility(8);
    }

    public void update(ObjectSubscriberAdapter objectsubscriberadapter, Object obj, Drawable drawable, int i)
    {
        ItemViewUtils.updateImageWithDrawable(drawable, mItemRowImage);
        objectsubscriberadapter = null;
        BasicProductInfo basicproductinfo = null;
        if (obj instanceof SearchResult)
        {
            mImageRequester = obj;
            objectsubscriberadapter = (SearchResult)obj;
            obj = objectsubscriberadapter.getBasicOffer();
            BasicProductInfo basicproductinfo1 = objectsubscriberadapter.getBasicProduct();
            objectsubscriberadapter = ((ObjectSubscriberAdapter) (obj));
            basicproductinfo = basicproductinfo1;
            if (mIsGetImageFromURL)
            {
                objectsubscriberadapter = ((ObjectSubscriberAdapter) (obj));
                basicproductinfo = basicproductinfo1;
                if (drawable == null)
                {
                    objectsubscriberadapter = ((ObjectSubscriberAdapter) (obj));
                    basicproductinfo = basicproductinfo1;
                    if (basicproductinfo1 != null)
                    {
                        objectsubscriberadapter = ((ObjectSubscriberAdapter) (obj));
                        basicproductinfo = basicproductinfo1;
                        if (!Util.isEmpty(basicproductinfo1.getImageUrl()))
                        {
                            getImageFromBackground(basicproductinfo1.getImageUrl());
                            basicproductinfo = basicproductinfo1;
                            objectsubscriberadapter = ((ObjectSubscriberAdapter) (obj));
                        }
                    }
                }
            }
        }
        updateItemView(i, objectsubscriberadapter, basicproductinfo);
    }

    public void update(ObjectSubscriberAdapter objectsubscriberadapter, Object obj, byte abyte0[], int i)
    {
        ItemViewUtils.updateImage(abyte0, mItemRowImage);
        if (obj instanceof SearchResult)
        {
            objectsubscriberadapter = (SearchResult)obj;
            abyte0 = objectsubscriberadapter.getBasicOffer();
            BasicProductInfo basicproductinfo = objectsubscriberadapter.getBasicProduct();
            objectsubscriberadapter = abyte0;
            obj = basicproductinfo;
            if (mIsGetImageFromURL)
            {
                objectsubscriberadapter = abyte0;
                obj = basicproductinfo;
                if (basicproductinfo != null)
                {
                    objectsubscriberadapter = abyte0;
                    obj = basicproductinfo;
                    if (!Util.isEmpty(basicproductinfo.getImageUrl()))
                    {
                        getImageFromBackground(basicproductinfo.getImageUrl());
                        obj = basicproductinfo;
                        objectsubscriberadapter = abyte0;
                    }
                }
            }
        } else
        {
            if (!(obj instanceof Product))
            {
                continue;
            }
            obj = (Product)obj;
            objectsubscriberadapter = ((Product) (obj)).getBasicOffer();
            obj = ((Product) (obj)).getBasicProduct();
        }
        do
        {
            updateItemView(i, objectsubscriberadapter, ((BasicProductInfo) (obj)));
            do
            {
                return;
            } while (!(obj instanceof HomeItem));
            obj = (HomeItem)obj;
            objectsubscriberadapter = ((HomeItem) (obj)).getBasicOffer();
            obj = ((HomeItem) (obj)).getBasicProduct();
        } while (true);
    }

    protected void updateItemView(int i, BasicOfferListing basicofferlisting, BasicProductInfo basicproductinfo)
    {
        String s = ItemViewUtils.getDisplayByLineAndBinding(basicproductinfo, getContext());
        if (Util.isEmpty(s))
        {
            mItemRowBylineBinding.setVisibility(8);
        } else
        {
            mItemRowBylineBinding.setVisibility(0);
            mItemRowBylineBinding.setText(s);
        }
        ItemViewUtils.updatePrice(mItemRowPrice, basicproductinfo, basicofferlisting);
        if (mBadgeView != null)
        {
            if (shouldShowItemBadge(basicofferlisting))
            {
                mBadgeView.update(basicofferlisting.getBadgeInfo().getBadge());
            } else
            {
                mBadgeView.setVisibility(8);
            }
        }
        if (basicproductinfo != null)
        {
            if (Util.isEmpty(basicproductinfo.getTitle()))
            {
                mItemRowTitle.setVisibility(8);
            } else
            {
                mItemRowTitle.setVisibility(0);
                String s1 = (new StringBuilder()).append(i + 1).append(". ").append(basicproductinfo.getTitle()).toString();
                mItemRowTitle.setText(s1);
            }
            mItemRowRating.setRating(basicproductinfo.getAverageOverallRating());
            if (basicproductinfo.getAverageOverallRating() != null)
            {
                mItemRowCustomerReviewsCount.setVisibility(0);
                mItemRowCustomerReviewsCount.setText((new StringBuilder()).append("(").append(basicproductinfo.getCustomerReviewsCount()).append(")").toString());
            } else
            {
                mItemRowCustomerReviewsCount.setVisibility(8);
            }
        } else
        {
            mItemRowTitle.setVisibility(8);
            mItemRowRating.setRating(null);
            mItemRowCustomerReviewsCount.setVisibility(8);
        }
        s = ProductController.getAmazonPoints(basicofferlisting);
        if (s != null)
        {
            mItemRowAmazonpoints.setVisibility(0);
            ((TextView)findViewById(com.amazon.mShop.android.lib.R.id.item_amazonpoints_value)).setText(s);
        } else
        {
            mItemRowAmazonpoints.setVisibility(8);
        }
        basicofferlisting = ItemViewUtils.getNewAndUsed(basicproductinfo, basicofferlisting, getContext());
        if (ConfigUtils.isEnabled(getContext(), com.amazon.mShop.android.lib.R.string.config_hasMarketplaceOffers) && basicofferlisting != null)
        {
            mItemRowUsedAndNew.setText(UIUtils.convertUnsupportedCharacter(getContext(), basicofferlisting, com.amazon.mShop.util.UIUtils.CharacterColor.DARK_GRAY));
            mItemRowUsedAndNew.setVisibility(0);
            return;
        } else
        {
            mItemRowUsedAndNew.setVisibility(8);
            return;
        }
    }
}

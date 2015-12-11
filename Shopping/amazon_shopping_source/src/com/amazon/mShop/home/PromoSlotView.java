// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.BitmapUtil;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.rio.j2me.client.services.mShop.Action;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.home:
//            HomeView

public class PromoSlotView extends ImageView
{
    private class PromoSlotImage extends Drawable
        implements com.amazon.mShop.net.HttpFetcher.Subscriber
    {

        private BitmapFetcher mBitmapFetcher;
        private float mGenericMarginOnProductPromo;
        private String mHeader;
        private float mProductHeaderFontSize;
        private float mProductTitleFontSize;
        private boolean mPromoImageOnly;
        private float mPromoSlotHeight;
        private float mPromoSlotWidth;
        private Resources mRes;
        private float mRightMarginOnThumbnail;
        private Bitmap mThumbnail;
        private String mThumbnailImageUrl;
        private String mTitle;
        final PromoSlotView this$0;

        private void calculatePixelValues()
        {
            mGenericMarginOnProductPromo = mRes.getDimension(com.amazon.mShop.android.lib.R.dimen.generic_margin_on_product_promo);
            mRightMarginOnThumbnail = mRes.getDimension(com.amazon.mShop.android.lib.R.dimen.right_margin_on_thumbnail);
            mProductHeaderFontSize = mRes.getDimension(com.amazon.mShop.android.lib.R.dimen.product_header_font_size);
            mProductTitleFontSize = mRes.getDimension(com.amazon.mShop.android.lib.R.dimen.product_title_font_size);
        }

        private void cancelImageFetcher()
        {
            if (mBitmapFetcher != null)
            {
                mBitmapFetcher.cancel();
                mBitmapFetcher = null;
            }
        }

        private void setImageUrl(String s)
        {
            mThumbnailImageUrl = s;
            if (mBitmapFetcher == null || mBitmapFetcher.isCancelled()) goto _L2; else goto _L1
_L1:
            if (!mBitmapFetcher.getParams().getBaseUrl().equals(s)) goto _L4; else goto _L3
_L3:
            return;
_L4:
            cancelImageFetcher();
_L2:
            if (s != null)
            {
                if (mPageMetricsObserver != null)
                {
                    mPageMetricsObserver.startForObject(s);
                }
                int i;
                if (mPromoImageOnly)
                {
                    i = (int)mPromoSlotWidth;
                } else
                {
                    i = (int)((double)mPromoSlotHeight * 0.875D);
                }
                mBitmapFetcher = new BitmapFetcher(s, Integer.valueOf(i), this, true, com.amazon.mShop.net.MShopDiskCachePolicy.ResidencePriority.RESIDENCE_PRIORITY_1);
                mBitmapFetcher.fetch();
                return;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        public void cancel()
        {
            cancelImageFetcher();
        }

        public void draw(Canvas canvas)
        {
            float f;
            float f4;
            Paint paint;
            Object obj;
            calculatePixelValues();
            float f1;
            float f5;
            Typeface typeface;
            if (mThumbnail == null)
            {
                f = 0.0F;
            } else
            {
                f = mThumbnail.getWidth();
            }
            if (mThumbnail == null)
            {
                f1 = 0.0F;
            } else
            {
                f1 = mThumbnail.getHeight();
            }
            paint = new Paint();
            typeface = Typeface.create("Calibri", 0);
            paint.setColor(mRes.getColor(com.amazon.mShop.android.lib.R.color.amazon_gold));
            paint.setFlags(1);
            paint.setAntiAlias(true);
            paint.setTypeface(typeface);
            paint.setTextSize(mProductHeaderFontSize);
            f4 = paint.getFontSpacing();
            obj = new RectF();
            f5 = getMeasuredWidth();
            if (mPromoImageOnly && f < mPromoSlotWidth)
            {
                obj.left = (f5 - f) / 2.0F;
            } else
            {
                obj.left = (f5 - mPromoSlotWidth) / 2.0F;
            }
            obj.top = (mPromoSlotHeight - f1) / 2.0F;
            if (mThumbnail != null)
            {
                canvas.drawBitmap(mThumbnail, ((RectF) (obj)).left, ((RectF) (obj)).top, null);
            }
            if (!mPromoImageOnly) goto _L2; else goto _L1
_L1:
            return;
_L2:
            float f6;
            int i;
            int j;
            int k;
            float f2 = mPromoSlotWidth - f - mRightMarginOnThumbnail - mGenericMarginOnProductPromo;
            i = 0;
            if (mHeader != null)
            {
                i = paint.breakText(mHeader, true, f2, null);
            }
            RectF rectf = new RectF();
            f6 = (mPromoSlotHeight * 0.125F) / 2.0F;
            rectf.left = ((RectF) (obj)).left + f + mRightMarginOnThumbnail;
            if (mHeader != null)
            {
                rectf.top = mProductHeaderFontSize + f6 + mGenericMarginOnProductPromo;
            } else
            {
                rectf.top = mProductTitleFontSize + f6;
            }
            if (mHeader != null)
            {
                if (mHeader.length() <= i)
                {
                    canvas.drawText(mHeader, rectf.left, rectf.top, paint);
                } else
                {
                    canvas.drawText(mHeader.substring(0, i), rectf.left, rectf.top, paint);
                }
            }
            obj = Typeface.create("Calibri", 0);
            paint.setColor(mRes.getColor(com.amazon.mShop.android.lib.R.color.gray_text));
            paint.setTextSize(mProductTitleFontSize);
            paint.setTypeface(((Typeface) (obj)));
            f6 = paint.getFontSpacing();
            obj = new RectF();
            obj.left = rectf.left;
            obj.top = rectf.top + f4;
            i = 0;
            f4 = paint.measureText("...");
            paint.breakText(mTitle.substring(0, mTitle.length()), true, f2, null);
            j = 0;
            f = f2;
_L5:
            if ((float)j >= 3F) goto _L1; else goto _L3
_L3:
            for (k = i; k < mTitle.length() && mTitle.charAt(k) == ' '; k++) { }
            if (k == mTitle.length()) goto _L1; else goto _L4
_L4:
            float f3 = f;
            if ((float)j == 2.0F)
            {
                f3 = f - f4;
            }
            int l = k + paint.breakText(mTitle.substring(k, mTitle.length()), true, f3, null);
            int i1 = mTitle.substring(k, l).lastIndexOf(" ");
            i = l;
            if (-1 != i1)
            {
                i = l;
                if ((float)j != 2.0F)
                {
                    i = l;
                    if (l < mTitle.length())
                    {
                        i = l;
                        if (mTitle.charAt(l) != ' ')
                        {
                            i = i1 + k;
                        }
                    }
                }
            }
            if (i < mTitle.length())
            {
                if ((float)j == 2.0F)
                {
                    canvas.drawText((new StringBuilder()).append(mTitle.substring(k, i)).append("...").toString(), ((RectF) (obj)).left, ((RectF) (obj)).top, paint);
                } else
                {
                    canvas.drawText(mTitle.substring(k, i), ((RectF) (obj)).left, ((RectF) (obj)).top, paint);
                }
                obj.top = ((RectF) (obj)).top + f6;
                if (-1 != i1)
                {
                    i++;
                }
                j++;
                f = f3;
            } else
            {
                canvas.drawText(mTitle.substring(k, mTitle.length()), ((RectF) (obj)).left, ((RectF) (obj)).top, paint);
                return;
            }
              goto _L5
        }

        public int getOpacity()
        {
            return 0;
        }

        public Bitmap getThumbnail()
        {
            if (!mPromoImageOnly && mThumbnail != null)
            {
                return mThumbnail;
            } else
            {
                return null;
            }
        }

        public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
        {
            setDefaultPromoSlot();
            mBitmapFetcher = null;
            if (mPageMetricsObserver != null)
            {
                mPageMetricsObserver.onCancelled();
            }
        }

        public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
        {
            if (mBitmapFetcher != null && !mBitmapFetcher.isCancelled())
            {
                params = ((com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams)params).getBaseUrl();
                if (params.equals(mThumbnailImageUrl))
                {
                    mThumbnail = bitmap;
                    showPromoSlot();
                    setFocusable(true);
                    setBackgroundResource(com.amazon.mShop.android.lib.R.color.gallery_image_selector);
                    setClickable(true);
                    setTag(mPromoSlotValue);
                    setOnClickListener(new android.view.View.OnClickListener() {

                        final PromoSlotImage this$1;

                        public void onClick(View view)
                        {
                            if (view.getTag() instanceof PromoSlot)
                            {
                                navigateToAction(mPromoSlotValue);
                            }
                            if (!Util.isEmpty(mRefMarker))
                            {
                                RefMarkerObserver.logRefMarker(mRefMarker);
                            }
                        }

            
            {
                this$1 = PromoSlotImage.this;
                super();
            }
                    });
                }
                mBitmapFetcher = null;
                if (mPageMetricsObserver != null)
                {
                    mPageMetricsObserver.completeForObject(params);
                }
            }
        }

        public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
        {
            onHttpResponseReceived((Bitmap)obj, params);
        }

        public void setAlpha(int i)
        {
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
        }

        public PromoSlotImage(Resources resources, String s, float f, float f1)
        {
            this$0 = PromoSlotView.this;
            super();
            mRes = null;
            mHeader = null;
            mTitle = null;
            mThumbnail = null;
            mRes = resources;
            mPromoSlotHeight = f;
            mPromoSlotWidth = f1;
            mPromoImageOnly = true;
            setImageUrl(s);
        }

        public PromoSlotImage(Resources resources, String s, String s1, String s2, float f, float f1)
        {
            this$0 = PromoSlotView.this;
            super();
            mRes = null;
            mHeader = null;
            mTitle = null;
            mThumbnail = null;
            mRes = resources;
            mHeader = s1;
            mTitle = s2;
            mPromoSlotHeight = f;
            mPromoSlotWidth = f1;
            setImageUrl(s);
        }
    }


    private String mActionParam;
    private String mActionType;
    private int mDefaultImageRes;
    private PageMetricsObserver mPageMetricsObserver;
    private PromoSlotImage mPromoSlotImage;
    private PromoSlot mPromoSlotValue;
    private String mRefMarker;

    public PromoSlotView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setImageBitmap(BitmapUtil.loadImage(getResources(), com.amazon.mShop.android.lib.R.drawable.promo_loading, true, true, true, true));
    }

    private boolean ignorePromoSlot(PromoSlot promoslot)
    {
        return promoslot.getAction().getType() == 11 && (!MShopPushNotificationUtils.isPushNotificationAvailable() || !MShopPushNotificationUtils.isMarketplaceSupportsNotification());
    }

    private void navigateToAction(PromoSlot promoslot)
    {
        byte abyte0[];
        abyte0 = null;
        if (!Util.isEmpty(promoslot.getSlotToken()))
        {
            HomeView.postClickedSlotToken(promoslot.getSlotToken());
        }
        promoslot.getAction().getType();
        JVM INSTR tableswitch 2 12: default 84
    //                   2 85
    //                   3 99
    //                   4 114
    //                   5 165
    //                   6 236
    //                   7 84
    //                   8 84
    //                   9 84
    //                   10 84
    //                   11 304
    //                   12 267;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L1 _L1 _L1 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_267;
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_304;
_L9:
        return;
_L2:
        ActivityUtils.startDealsActivity(getContext(), null, promoslot.getClickStreamOrigin());
        return;
_L3:
        ActivityUtils.startWishListActivity(getContext(), promoslot.getClickStreamOrigin(), null, -1);
        return;
_L4:
        if (mPromoSlotImage != null)
        {
            Bitmap bitmap = mPromoSlotImage.getThumbnail();
            if (bitmap != null)
            {
                abyte0 = UIUtils.convertBitmapToByteArray(bitmap);
            }
            HomeView.forwardProductDetailsView(getContext(), promoslot.getProduct(), new ClickStreamTag(promoslot.getClickStreamOrigin()), abyte0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (promoslot.getAction() != null && !Util.isEmpty(promoslot.getAction().getParams()))
        {
            promoslot = promoslot.getAction().getParams();
            if (!(new AmazonNavManager()).navigate(promoslot, getContext()))
            {
                promoslot = new Intent("android.intent.action.VIEW", Uri.parse(promoslot));
                try
                {
                    getContext().startActivity(promoslot);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (PromoSlot promoslot)
                {
                    return;
                }
            }
        }
        if (true) goto _L9; else goto _L6
_L6:
        AmazonActivity amazonactivity = (AmazonActivity)getContext();
        amazonactivity.pushView(new AmazonBrandedWebView(amazonactivity, promoslot.getAction().getParams(), "", true));
        return;
        Context context = getContext();
        Intent intent = new Intent(context, com/amazon/mShop/web/MShopWebActivity);
        intent.putExtra(WebConstants.getWebViewUrlKey(), promoslot.getAction().getParams());
        context.startActivity(intent);
        return;
        ActivityUtils.startNotificationSettingActivity(getContext(), null);
        return;
    }

    private void setDefaultClickStreamOrigin(PromoSlot promoslot, int i)
    {
        if (promoslot != null && i >= 0 && i < HomeView.ACTION_NAME_DICTIONARY.size())
        {
            promoslot.setClickStreamOrigin((new StringBuilder()).append(getResources().getString(com.amazon.mShop.android.lib.R.string.home_promo_clickstream_prefix)).append((String)HomeView.ACTION_NAME_DICTIONARY.get(Integer.valueOf(i))).toString());
        }
    }

    private void showPromoSlot()
    {
        setImageDrawable(mPromoSlotImage);
    }

    public void clear()
    {
        setFocusable(false);
        setClickable(false);
        if (mPromoSlotImage != null)
        {
            mPromoSlotImage.cancel();
            mPromoSlotImage = null;
        }
    }

    public void setDefaultPromoSlot()
    {
        BitmapUtil.setImageResource(this, mDefaultImageRes);
        setFocusable(true);
        setBackgroundResource(com.amazon.mShop.android.lib.R.color.gallery_image_selector);
        setClickable(true);
        setOnClickListener(new android.view.View.OnClickListener() {

            final PromoSlotView this$0;

            public void onClick(View view)
            {
                view = new Action();
                int i = ((Integer)HomeView.ACTION_TYPE_DICTIONARY.get(mActionType)).intValue();
                view.setType(i);
                view.setParams(mActionParam);
                PromoSlot promoslot = new PromoSlot();
                promoslot.setAction(view);
                if (i == 4)
                {
                    HomeItem homeitem = new HomeItem();
                    homeitem.setAsin(view.getParams());
                    promoslot.setProduct(homeitem);
                }
                setDefaultClickStreamOrigin(promoslot, view.getType());
                navigateToAction(promoslot);
                if (!Util.isEmpty(mRefMarker))
                {
                    RefMarkerObserver.logRefMarker(mRefMarker);
                }
            }

            
            {
                this$0 = PromoSlotView.this;
                super();
            }
        });
    }

    public void setDefaultPromoSlotInfo(int i, String s, String s1, String s2)
    {
        mDefaultImageRes = i;
        mActionType = s;
        mActionParam = s1;
        mRefMarker = s2;
    }

    public void update(PromoSlot promoslot, PageMetricsObserver pagemetricsobserver)
    {
        Object obj;
        HomeItem homeitem;
        mPageMetricsObserver = pagemetricsobserver;
        mPromoSlotValue = promoslot;
        homeitem = promoslot.getProduct();
        obj = null;
        if (Util.isEmpty(promoslot.getClickStreamOrigin()))
        {
            setDefaultClickStreamOrigin(promoslot, promoslot.getAction().getType());
        }
        if (Util.isEmpty(promoslot.getImageUrl())) goto _L2; else goto _L1
_L1:
        pagemetricsobserver = promoslot.getImageUrl();
_L4:
        float f;
        float f1;
        f = HomeView.getPromoSlotHeight();
        f1 = HomeView.getPromoSlotWidth();
        if (Util.isEmpty(pagemetricsobserver) || ignorePromoSlot(promoslot))
        {
            setDefaultPromoSlot();
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (homeitem != null && !Util.isEmpty(homeitem.getImageUrl()))
        {
            pagemetricsobserver = homeitem.getImageUrl();
        } else
        {
            pagemetricsobserver = obj;
            if (homeitem != null)
            {
                pagemetricsobserver = obj;
                if (homeitem.getBasicProduct() != null)
                {
                    pagemetricsobserver = obj;
                    if (!Util.isEmpty(homeitem.getBasicProduct().getImageUrl()))
                    {
                        pagemetricsobserver = homeitem.getBasicProduct().getImageUrl();
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!Util.isEmpty(promoslot.getImageUrl()))
        {
            mPromoSlotImage = new PromoSlotImage(getResources(), promoslot.getImageUrl(), f, f1);
            return;
        } else
        {
            mPromoSlotImage = new PromoSlotImage(getResources(), pagemetricsobserver, promoslot.getProductHeader(), homeitem.getBasicProduct().getTitle(), f, f1);
            return;
        }
    }








}

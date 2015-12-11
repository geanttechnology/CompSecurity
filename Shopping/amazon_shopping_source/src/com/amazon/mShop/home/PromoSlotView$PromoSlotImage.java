// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;

// Referenced classes of package com.amazon.mShop.home:
//            PromoSlotView

private class setImageUrl extends Drawable
    implements com.amazon.mShop.net.
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
        mGenericMarginOnProductPromo = mRes.getDimension(com.amazon.mShop.android.lib.duct_promo);
        mRightMarginOnThumbnail = mRes.getDimension(com.amazon.mShop.android.lib.nail);
        mProductHeaderFontSize = mRes.getDimension(com.amazon.mShop.android.lib.ize);
        mProductTitleFontSize = mRes.getDimension(com.amazon.mShop.android.lib.ze);
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
            if (PromoSlotView.access$000(PromoSlotView.this) != null)
            {
                PromoSlotView.access$000(PromoSlotView.this).startForObject(s);
            }
            int i;
            if (mPromoImageOnly)
            {
                i = (int)mPromoSlotWidth;
            } else
            {
                i = (int)((double)mPromoSlotHeight * 0.875D);
            }
            mBitmapFetcher = new BitmapFetcher(s, Integer.valueOf(i), this, true, com.amazon.mShop.net.ePriority.RESIDENCE_PRIORITY_1);
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
        paint.setColor(mRes.getColor(com.amazon.mShop.android.lib.ail));
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
        paint.setColor(mRes.getColor(com.amazon.mShop.android.lib.));
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

    public void onHttpRequestFailed(com.amazon.mShop.net. )
    {
        setDefaultPromoSlot();
        mBitmapFetcher = null;
        if (PromoSlotView.access$000(PromoSlotView.this) != null)
        {
            PromoSlotView.access$000(PromoSlotView.this).onCancelled();
        }
    }

    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net. )
    {
        if (mBitmapFetcher != null && !mBitmapFetcher.isCancelled())
        {
             = ((com.amazon.mShop.net.rams)).getBaseUrl();
            if (.equals(mThumbnailImageUrl))
            {
                mThumbnail = bitmap;
                PromoSlotView.access$100(PromoSlotView.this);
                setFocusable(true);
                setBackgroundResource(com.amazon.mShop.android.lib.r);
                setClickable(true);
                setTag(PromoSlotView.access$200(PromoSlotView.this));
                setOnClickListener(new android.view.View.OnClickListener() {

                    final PromoSlotView.PromoSlotImage this$1;

                    public void onClick(View view)
                    {
                        if (view.getTag() instanceof PromoSlot)
                        {
                            PromoSlotView.access$300(this$0, PromoSlotView.access$200(this$0));
                        }
                        if (!Util.isEmpty(PromoSlotView.access$400(this$0)))
                        {
                            RefMarkerObserver.logRefMarker(PromoSlotView.access$400(this$0));
                        }
                    }

            
            {
                this$1 = PromoSlotView.PromoSlotImage.this;
                super();
            }
                });
            }
            mBitmapFetcher = null;
            if (PromoSlotView.access$000(PromoSlotView.this) != null)
            {
                PromoSlotView.access$000(PromoSlotView.this).completeForObject();
            }
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net. )
    {
        onHttpResponseReceived((Bitmap)obj, );
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }

    public _cls1.this._cls1(Resources resources, String s, float f, float f1)
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

    public setImageUrl(Resources resources, String s, String s1, String s2, float f, float f1)
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

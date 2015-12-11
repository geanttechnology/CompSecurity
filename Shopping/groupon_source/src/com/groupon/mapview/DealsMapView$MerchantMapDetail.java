// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.Marker;
import com.groupon.db.models.DealSummary;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.ImageUrl;
import com.groupon.view.DealsMapRating;
import com.groupon.view.UrlImageView;
import com.squareup.picasso.Callback;
import java.util.Date;
import java.util.HashMap;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mapview:
//            DealsMapView

public class addView extends FrameLayout
{

    int bottomHitOffset;
    int bottomOffset;
    int heightPx;
    LayoutInflater inflater;
    dedListener listener;
    Marker marker;
    final DealsMapView this$0;
    int widthPx;

    public void getHitRect(Rect rect)
    {
        super.getHitRect(rect);
        rect.bottom = rect.bottom - bottomHitOffset;
    }

    public void setData(Marker marker1)
    {
        marker = marker1;
        Object obj = (ontainer)DealsMapView.access$100(DealsMapView.this).get(marker1.getTitle());
        marker1 = null;
        if (obj != null)
        {
            marker1 = ontainer.access._mth200(((ontainer) (obj)));
        }
        int i;
        if (marker1 != null)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        setVisibility(i);
        if (marker1 == null)
        {
            return;
        }
        Object obj1 = (UrlImageView)findViewById(0x7f100121);
        ((UrlImageView) (obj1)).setCallback(new Callback() {

            final DealsMapView.MerchantMapDetail this$1;

            public void onError(ImageView imageview)
            {
            }

            public void onSuccess(ImageView imageview)
            {
                if (listener != null)
                {
                    listener.onImageLoaded(marker);
                }
            }

            
            {
                this$1 = DealsMapView.MerchantMapDetail.this;
                super();
            }
        });
        int j;
        boolean flag;
        boolean flag1;
        if (Strings.notEmpty(((DealSummary) (marker1)).derivedImageUrl))
        {
            obj = new ImageUrl(((DealSummary) (marker1)).derivedImageUrl, true);
        } else
        {
            obj = new ImageUrl(((DealSummary) (marker1)).sidebarImageUrl, false);
        }
        ((UrlImageView) (obj1)).setImageUrl(((ImageUrl) (obj)), widthPx, heightPx);
        obj1 = (TextView)findViewById(0x7f1003ed);
        if (((DealSummary) (marker1)).derivedOptionEndRedemptionAt == null)
        {
            obj = ((DealSummary) (marker1)).endRedemptionAt;
        } else
        {
            obj = ((DealSummary) (marker1)).derivedOptionEndRedemptionAt;
        }
        if (obj != null && (new Date()).after(((Date) (obj))))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        flag = ((DealSummary) (marker1)).isSoldOut;
        flag1 = Strings.equalsIgnoreCase("closed", ((DealSummary) (marker1)).status);
        if (i != 0 || flag || flag1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj1)).setVisibility(i);
        if (flag)
        {
            i = 0x7f0803b4;
        } else
        {
            i = 0x7f080124;
        }
        ((TextView) (obj1)).setText(i);
        ((TextView)findViewById(0x7f1003ee)).setText(((DealSummary) (marker1)).derivedMerchantName);
        ((TextView)findViewById(0x7f1003f0)).setText(((DealSummary) (marker1)).announcementTitle);
        i = ((DealSummary) (marker1)).derivedMinimumPurchaseQuantity;
        j = ((DealSummary) (marker1)).derivedPriceAmount;
        if (j == 0)
        {
            obj = "";
        } else
        {
            obj = DealsMapView.access$500(DealsMapView.this).formatWithQuantity(j, ((DealSummary) (marker1)).derivedPriceCurrencyCode, i, com.groupon.util.ehavior.OnlyIfZero);
        }
        flag = marker1.getDisplayOption("discount", true);
        obj1 = (TextView)findViewById(0x7f1003f1);
        if (flag)
        {
            if (DealsMapView.access$600(DealsMapView.this).getCurrentCountry().isJapan())
            {
                ((TextView) (obj1)).setText(DealsMapView.access$700(DealsMapView.this, ((DealSummary) (marker1)).derivedDiscountPercent));
            } else
            {
                ((TextView) (obj1)).setText(DealsMapView.access$800(DealsMapView.this, marker1, i));
                ((TextView) (obj1)).setPaintFlags(((TextView) (obj1)).getPaintFlags() | 0x10);
            }
        } else
        {
            ((TextView) (obj1)).setVisibility(8);
        }
        ((TextView)findViewById(0x7f1003f2)).setText(((CharSequence) (obj)));
        obj = (DealsMapRating)findViewById(0x7f1003ef);
        if (((DealSummary) (marker1)).grouponRating != 0.0D)
        {
            ((DealsMapRating) (obj)).setRating(((DealSummary) (marker1)).grouponRating);
            ((DealsMapRating) (obj)).setVisibility(0);
            return;
        } else
        {
            ((DealsMapRating) (obj)).setVisibility(8);
            return;
        }
    }

    public void setListener(dedListener dedlistener)
    {
        listener = dedlistener;
    }

    public _cls1.this._cls1(Context context)
    {
        this$0 = DealsMapView.this;
        super(context);
        widthPx = getResources().getDimensionPixelSize(0x7f0b01c1);
        heightPx = getResources().getDimensionPixelSize(0x7f0b01c0);
        bottomOffset = (int)context.getResources().getDimension(0x7f0b0009);
        bottomHitOffset = bottomOffset + (int)context.getResources().getDimension(0x7f0b000a);
        RoboGuice.getInjector(context).injectMembers(this);
        dealsmapview = (LinearLayout)inflater.inflate(0x7f030158, null);
        context = new android.widget.(-2, -2);
        context.y = 0;
        addView(DealsMapView.this, context);
    }
}

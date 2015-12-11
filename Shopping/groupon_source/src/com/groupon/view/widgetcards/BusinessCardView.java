// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.db.models.Business;
import com.groupon.db.models.BusinessSummary;
import com.groupon.db.models.Location;
import com.groupon.view.BusinessMapSlice;
import com.groupon.view.UrlImageView;
import com.squareup.picasso.Callback;
import java.text.DecimalFormat;
import java.util.List;
import roboguice.util.Strings;

public abstract class BusinessCardView extends FrameLayout
{

    protected TextView businessLocation;
    private TextView businessName;
    private UrlImageView businessPhoto;
    protected DecimalFormat decimalFormat;
    protected BusinessMapSlice mapSlice;

    public BusinessCardView(Context context)
    {
        this(context, null, 0);
    }

    public BusinessCardView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BusinessCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        businessPhoto = (UrlImageView)findViewById(0x7f100157);
        businessName = (TextView)findViewById(0x7f10015a);
        businessLocation = (TextView)findViewById(0x7f100159);
        mapSlice = (BusinessMapSlice)findViewById(0x7f10013f);
        decimalFormat = new DecimalFormat("0.0");
    }

    public void setInfo(final Business business)
    {
        businessName.setText(business.name);
        if (!Strings.isEmpty(business.heroImageUrl))
        {
            businessPhoto.setVisibility(0);
            businessPhoto.setCallback(new Callback() {

                final BusinessCardView this$0;
                final Business val$business;

                public void onError(ImageView imageview)
                {
                    businessPhoto.setVisibility(8);
                    setMapSliceImage(business);
                }

                public void onSuccess(ImageView imageview)
                {
                    mapSlice.setVisibility(8);
                }

            
            {
                this$0 = BusinessCardView.this;
                business = business1;
                super();
            }
            });
            businessPhoto.setImageUrl((new StringBuilder()).append(business.heroImageUrl).append("t670x147.jpg").toString());
            return;
        } else
        {
            setMapSliceImage(business);
            return;
        }
    }

    public void setInfo(final BusinessSummary businessSummary)
    {
        businessName.setText(businessSummary.name);
        if (!Strings.isEmpty(businessSummary.heroImageUrl))
        {
            businessPhoto.setVisibility(0);
            businessPhoto.setCallback(new Callback() {

                final BusinessCardView this$0;
                final BusinessSummary val$businessSummary;

                public void onError(ImageView imageview)
                {
                    businessPhoto.setVisibility(8);
                    setMapSliceImage(businessSummary);
                }

                public void onSuccess(ImageView imageview)
                {
                    mapSlice.setVisibility(8);
                }

            
            {
                this$0 = BusinessCardView.this;
                businessSummary = businesssummary;
                super();
            }
            });
            businessPhoto.setImageUrl((new StringBuilder()).append(businessSummary.heroImageUrl).append("t670x147.jpg").toString());
            return;
        } else
        {
            setMapSliceImage(businessSummary);
            return;
        }
    }

    protected void setMapSliceImage(Business business)
    {
        business = business.getLocations();
        if (business.size() > 0)
        {
            mapSlice.setLocationWithImageSize((Location)business.get(0), 100, 100);
            return;
        } else
        {
            mapSlice.setLocation(null);
            return;
        }
    }

    protected void setMapSliceImage(BusinessSummary businesssummary)
    {
        Location location = new Location();
        location.lat = businesssummary.lat;
        location.lng = businesssummary.lng;
        if (location.lat != 0.0D || location.lng != 0.0D)
        {
            mapSlice.setLocationWithImageSize(location, 100, 100);
            return;
        } else
        {
            mapSlice.setLocation(null);
            return;
        }
    }

}

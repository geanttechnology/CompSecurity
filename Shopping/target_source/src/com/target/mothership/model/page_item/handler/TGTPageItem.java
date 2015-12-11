// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.page_item.interfaces.Action;
import com.target.mothership.model.page_item.interfaces.CardSize;
import com.target.mothership.model.page_item.interfaces.CustomAction;
import com.target.mothership.model.page_item.interfaces.DigitalVendorMarketing;
import com.target.mothership.model.page_item.interfaces.DisplayDates;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.page_item.interfaces.PageItemCollection;
import com.target.mothership.model.page_item.interfaces.ProductInfo;
import com.target.mothership.model.page_item.interfaces.TrackingInfo;
import com.target.mothership.model.page_item.interfaces.WeeklyAdInfo;

class TGTPageItem
    implements PageItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPageItem a(Parcel parcel)
        {
            return new TGTPageItem(parcel);
        }

        public TGTPageItem[] a(int l)
        {
            return new TGTPageItem[l];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
        }

    };
    private Action mAction;
    private CardSize mCardSize;
    private PageItemCollection mChildPage;
    private CustomAction mCustomAction;
    private DigitalVendorMarketing mDigitalVendorMarketing;
    private DisplayDates mDisplayDates;
    private String mDisplayText;
    private ImageInfo mImageInfo;
    private ProductInfo mProductInfo;
    private String mStrikethroughText;
    private TrackingInfo mTrackingInfo;
    private WeeklyAdInfo mWeeklyAdInfo;

    public TGTPageItem()
    {
    }

    private TGTPageItem(Parcel parcel)
    {
        mAction = (Action)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/Action.getClassLoader());
        mCardSize = (CardSize)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/CardSize.getClassLoader());
        mChildPage = (PageItemCollection)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/PageItemCollection.getClassLoader());
        mCustomAction = (CustomAction)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/CustomAction.getClassLoader());
        mDigitalVendorMarketing = (DigitalVendorMarketing)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/DigitalVendorMarketing.getClassLoader());
        mDisplayDates = (DisplayDates)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/DisplayDates.getClassLoader());
        mDisplayText = parcel.readString();
        mImageInfo = (ImageInfo)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/ImageInfo.getClassLoader());
        mProductInfo = (ProductInfo)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/ProductInfo.getClassLoader());
        mStrikethroughText = parcel.readString();
        mTrackingInfo = (TrackingInfo)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/TrackingInfo.getClassLoader());
        mWeeklyAdInfo = (WeeklyAdInfo)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/WeeklyAdInfo.getClassLoader());
    }


    public e a()
    {
        return com.google.a.a.e.c(mAction);
    }

    public void a(Action action)
    {
        mAction = action;
    }

    public void a(CardSize cardsize)
    {
        mCardSize = cardsize;
    }

    public void a(CustomAction customaction)
    {
        mCustomAction = customaction;
    }

    public void a(DigitalVendorMarketing digitalvendormarketing)
    {
        mDigitalVendorMarketing = digitalvendormarketing;
    }

    public void a(DisplayDates displaydates)
    {
        mDisplayDates = displaydates;
    }

    public void a(ImageInfo imageinfo)
    {
        mImageInfo = imageinfo;
    }

    public void a(PageItemCollection pageitemcollection)
    {
        mChildPage = pageitemcollection;
    }

    public void a(ProductInfo productinfo)
    {
        mProductInfo = productinfo;
    }

    public void a(TrackingInfo trackinginfo)
    {
        mTrackingInfo = trackinginfo;
    }

    public void a(WeeklyAdInfo weeklyadinfo)
    {
        mWeeklyAdInfo = weeklyadinfo;
    }

    public void a(String s)
    {
        mDisplayText = s;
    }

    public CardSize b()
    {
        return mCardSize;
    }

    public void b(String s)
    {
        mStrikethroughText = s;
    }

    public e c()
    {
        return com.google.a.a.e.c(mChildPage);
    }

    public e d()
    {
        return com.google.a.a.e.c(mCustomAction);
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mDigitalVendorMarketing);
    }

    public e f()
    {
        return com.google.a.a.e.c(mDisplayDates);
    }

    public e g()
    {
        return com.google.a.a.e.c(mDisplayText);
    }

    public e h()
    {
        return com.google.a.a.e.c(mImageInfo);
    }

    public e i()
    {
        return com.google.a.a.e.c(mStrikethroughText);
    }

    public e j()
    {
        return com.google.a.a.e.c(mTrackingInfo);
    }

    public e k()
    {
        return com.google.a.a.e.c(mWeeklyAdInfo);
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        parcel.writeParcelable(mAction, l);
        parcel.writeParcelable(mCardSize, l);
        parcel.writeParcelable(mChildPage, l);
        parcel.writeParcelable(mCustomAction, l);
        parcel.writeParcelable(mDigitalVendorMarketing, l);
        parcel.writeParcelable(mDisplayDates, l);
        parcel.writeString(mDisplayText);
        parcel.writeParcelable(mImageInfo, l);
        parcel.writeParcelable(mProductInfo, l);
        parcel.writeString(mStrikethroughText);
        parcel.writeParcelable(mTrackingInfo, l);
        parcel.writeParcelable(mWeeklyAdInfo, l);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SourceIdentification
    implements Parcelable
{
    public static interface Link
    {

        public static final String ACTIVITY = "activity";
        public static final String ALL_CATEGORIES = "AllCategories";
        public static final String AUTO_COMPLETE_WITHOUT_CATEGORY = "ac";
        public static final String AUTO_COMPLETE_WITH_CATEGORY = "acwc";
        public static final String BUYING_BIDS = "bids";
        public static final String BUYING_NOT_WON = "lost";
        public static final String BUYING_OFFERS = "offers";
        public static final String BUYING_WON = "purchases";
        public static final String FEATURED = "featured";
        public static final String MY_EBAY_ALL = "all";
        public static final String RECENT_SEARCH = "rs";
        public static final String SAVED_SEARCH = "ss";
        public static final String SCAN = "scan";
        public static final String SELL = "sell";
        public static final String SELLING_ALL = "All";
        public static final String SELLING_AWAITING_PAYMENT = "AwaitingPayment";
        public static final String SELLING_AWAITING_SHIPMENT = "AwaitingShipment";
        public static final String SELLING_OFFERS = "NewOffers";
        public static final String USER_TYPES_QUERY = "utq";
        public static final String WATCHING_ACTIVE = "active";
        public static final String WATCHING_ENDED = "ended";
    }

    public static interface Module
    {

        public static final String ACTIVE = "active";
        public static final String AD = "ad";
        public static final String BROWSE_CATEGORY = "browsecat";
        public static final String BUYING_OVERVIEW_CARD = "buyingoverview";
        public static final String COLLECTION = "collection";
        public static final String COLLECTIONS = "collections";
        public static final String DEALS = "deals";
        public static final String DRAFTS = "drafts";
        public static final String EBAYPLUS = "plus";
        public static final String FEED = "feed";
        public static final String FOLLOWING_CARD = "followedsearch";
        public static final String HOME_CAROUSEL = "carousel";
        public static final String HOME_FEATURED_CATEGORY = "featcat";
        public static final String HOME_MY_EBAY_WIDGET = "mbwh";
        public static final String HOME_RECENTS = "recents";
        public static final String LIST_AN_ITEM = "listanitem";
        public static final String MEMBER = "member";
        public static final String MENU_BUYING = "buying";
        public static final String MENU_HOME = "home";
        public static final String MENU_MESSAGES = "msgs";
        public static final String MENU_NAVIGATION = "pmn";
        public static final String MENU_NOTIFICATIONS = "notifications";
        public static final String MENU_PROFILE = "profile";
        public static final String MENU_SELLING = "selling";
        public static final String MENU_SETTINGS = "setting";
        public static final String MENU_WATCHING = "watching";
        public static final String MY_EBAY = "me";
        public static final String NOTIFICATIONS_CARD = "notifications";
        public static final String RVI_CARD = "recents";
        public static final String SALES_EVENTS = "salesevents";
        public static final String SCHEDULED = "scheduled";
        public static final String SCHEDULER_CANCEL = "cancel";
        public static final String SCHEDULER_DONE = "done";
        public static final String SEARCH = "search";
        public static final String SEARCH_BOX = "sm";
        public static final String SELLER_OFFER = "sop";
        public static final String SELLING_OVERVIEW_CARD = "sellingoverview";
        public static final String SOLD = "sold";
        public static final String TRENDING_SEEMORE = "moretrending";
        public static final String TRENDING_TOPIC = "trend";
        public static final String UNSOLD = "unsold";
        public static final String VIP_SHIPPING_OPTION_EBN = "ebn";
        public static final String VIP_SHIPPING_OPTION_ISPU = "isp";
        public static final String VIP_SHIPPING_OPTION_NORMAL = "ship";
        public static final String WATCHING_CARD = "watching";
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SourceIdentification createFromParcel(Parcel parcel)
        {
            return new SourceIdentification(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SourceIdentification[] newArray(int i)
        {
            return new SourceIdentification[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String SOURCE_ID_TAG = "com.ebay.mobile.analytics.sid";
    private String event;
    private String link;
    private String module;

    private SourceIdentification()
    {
    }

    private SourceIdentification(Parcel parcel)
    {
        event = parcel.readString();
        module = parcel.readString();
        link = parcel.readString();
    }


    public SourceIdentification(String s)
    {
        this(s, null, null);
    }

    public SourceIdentification(String s, String s1)
    {
        this(s, s1, null);
    }

    public SourceIdentification(String s, String s1, String s2)
    {
        event = s;
        module = s1;
        link = s2;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getEvent()
    {
        return event;
    }

    public String getLink()
    {
        return link;
    }

    public String getModule()
    {
        return module;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(event);
        parcel.writeString(module);
        parcel.writeString(link);
    }

}

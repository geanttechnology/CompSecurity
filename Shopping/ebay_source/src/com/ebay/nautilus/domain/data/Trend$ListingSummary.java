// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            Trend

public static class url
    implements Parcelable
{

    public static final android.os.end.ListingSummary.url CREATOR = new android.os.Parcelable.Creator() {

        public Trend.ListingSummary createFromParcel(Parcel parcel)
        {
            return new Trend.ListingSummary(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Trend.ListingSummary[] newArray(int i)
        {
            return new Trend.ListingSummary[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public operty displayPrice;
    public operty image;
    public String listingId;
    public String title;
    public String url;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(listingId);
        parcel.writeString(title);
        parcel.writeString(image.image);
        parcel.writeDouble((()displayPrice.value).value);
        parcel.writeString((()displayPrice.value).currency);
        parcel.writeInt(displayPrice.textSpans.size());
        for (Iterator iterator = displayPrice.textSpans.iterator(); iterator.hasNext(); parcel.writeString(((operty.textSpans)iterator.next()).textSpans)) { }
        parcel.writeString(url);
    }


    public _cls1(Parcel parcel)
    {
        listingId = parcel.readString();
        title = parcel.readString();
        image = new image();
        image.image = parcel.readString();
        displayPrice = new operty();
        displayPrice.value = new ();
        (()displayPrice.value).value = parcel.readDouble();
        (()displayPrice.value).currency = parcel.readString();
        int i = parcel.readInt();
        displayPrice.textSpans = new ArrayList(i);
        for (; i > 0; i--)
        {
            _cls1 _lcls1 = new ();
            _lcls1. = parcel.readString();
            displayPrice.textSpans.add(_lcls1);
        }

        url = parcel.readString();
    }
}

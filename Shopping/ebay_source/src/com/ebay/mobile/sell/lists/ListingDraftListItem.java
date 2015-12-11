// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import java.util.ArrayList;
import java.util.Date;

public class ListingDraftListItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ListingDraftListItem createFromParcel(Parcel parcel)
        {
            return new ListingDraftListItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ListingDraftListItem[] newArray(int i)
        {
            return new ListingDraftListItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String categoryPath;
    public Date date;
    private byte dateExists;
    public String id;
    public String imageUrl;
    public String listingMode;
    public int siteId;
    public String title;

    ListingDraftListItem(Parcel parcel)
    {
        dateExists = parcel.readByte();
        if (dateExists != 0)
        {
            date = new Date(parcel.readLong());
        }
        siteId = parcel.readInt();
        id = parcel.readString();
        listingMode = parcel.readString();
        imageUrl = parcel.readString();
        title = parcel.readString();
        categoryPath = parcel.readString();
    }

    public ListingDraftListItem(ListingDraft listingdraft)
    {
        refresh(listingdraft);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ListingDraftListItem)
        {
            if (obj == this)
            {
                return true;
            }
            obj = (ListingDraftListItem)obj;
            if (((ListingDraftListItem) (obj)).siteId == siteId && ((ListingDraftListItem) (obj)).id.equals(id))
            {
                return true;
            }
        }
        return false;
    }

    public String getLeafCategory()
    {
        if (!TextUtils.isEmpty(categoryPath))
        {
            String as[] = categoryPath.split(":");
            if (as.length > 0)
            {
                return as[as.length - 1];
            } else
            {
                return categoryPath;
            }
        } else
        {
            return null;
        }
    }

    public void refresh(ListingDraft listingdraft)
    {
        title = listingdraft.title.getStringValue();
        String s = null;
        int i;
        if (!listingdraft.pictureUrls.isEmpty())
        {
            s = ((LdsField)listingdraft.pictureUrls.get(0)).getStringValue();
        } else
        if (listingdraft.productStockPhoto != null)
        {
            s = listingdraft.productStockPhoto.getStringValue();
        }
        imageUrl = s;
        if (listingdraft.lastModified != null)
        {
            date = listingdraft.lastModified.getDateValue();
        }
        if (date != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        dateExists = (byte)i;
        id = listingdraft.id;
        siteId = listingdraft.siteId;
        categoryPath = listingdraft.categoryIdPath.getStringValue().replace(" > ", ":");
        if (!TextUtils.isEmpty(listingdraft.listingMode))
        {
            listingMode = listingdraft.listingMode;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeByte(dateExists);
        if (date != null)
        {
            parcel.writeLong(date.getTime());
        }
        parcel.writeInt(siteId);
        parcel.writeString(id);
        parcel.writeString(listingMode);
        parcel.writeString(imageUrl);
        parcel.writeString(title);
        parcel.writeString(categoryPath);
    }

}

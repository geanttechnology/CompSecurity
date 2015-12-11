// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SavedListingDraftDataManager

public static class <init>
    implements Parcelable
{

    public static final android.os.aManager.DraftIdWithSite.siteId CREATOR = new android.os.Parcelable.Creator() {

        public SavedListingDraftDataManager.DraftIdWithSite createFromParcel(Parcel parcel)
        {
            return new SavedListingDraftDataManager.DraftIdWithSite(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SavedListingDraftDataManager.DraftIdWithSite[] newArray(int i)
        {
            return new SavedListingDraftDataManager.DraftIdWithSite[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String draftId;
    public int siteId;

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof <init>)
        {
            if (obj == this)
            {
                return true;
            }
            obj = (<init>)obj;
            if (((<init>) (obj)).siteId == siteId && ((siteId) (obj)).draftId.equals(draftId))
            {
                return true;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(draftId);
        parcel.writeInt(siteId);
    }


    public _cls1(int i, String s)
    {
        siteId = i;
        draftId = s;
    }

    private draftId(Parcel parcel)
    {
        draftId = parcel.readString();
        siteId = parcel.readInt();
    }

    siteId(Parcel parcel, siteId siteid)
    {
        this(parcel);
    }
}

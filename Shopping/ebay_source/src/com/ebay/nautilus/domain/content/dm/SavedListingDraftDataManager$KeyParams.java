// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SavedListingDraftDataManager, UserContextObservingDataManager

public static final class _cls1 extends 
    implements Parcelable
{

    public static final android.os.aftDataManager.KeyParams CREATOR = new android.os.Parcelable.Creator() {

        public SavedListingDraftDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return SavedListingDraftDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SavedListingDraftDataManager.KeyParams[] newArray(int i)
        {
            return new SavedListingDraftDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public SavedListingDraftDataManager create(EbayContext ebaycontext)
    {
        return new SavedListingDraftDataManager(ebaycontext, this, null);
    }

    public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof create);
    }


    public _cls1()
    {
    }
}

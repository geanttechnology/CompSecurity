// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextDataManager

public static final class _cls1 extends com.ebay.nautilus.domain.content.ms
    implements Parcelable
{

    public static final android.os.extDataManager.KeyParams CREATOR = new android.os.Parcelable.Creator() {

        public UserContextDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return UserContextDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UserContextDataManager.KeyParams[] newArray(int i)
        {
            return new UserContextDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public volatile DataManager createManager(EbayContext ebaycontext)
    {
        return createManager(ebaycontext);
    }

    public UserContextDataManager createManager(EbayContext ebaycontext)
    {
        return new UserContextDataManager(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        return obj instanceof createManager;
    }

    public String toString()
    {
        return "UserContextDataManager.KEY";
    }


    public _cls1()
    {
    }
}

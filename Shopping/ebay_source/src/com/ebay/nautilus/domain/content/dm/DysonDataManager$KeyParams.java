// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            DysonDataManager, UserContextObservingDataManager

public static final class _cls1 extends ager.KeyBase
    implements Parcelable
{

    public static final android.os.ontext CREATOR = new android.os.Parcelable.Creator() {

        public DysonDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return DysonDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public DysonDataManager.KeyParams[] newArray(int i)
        {
            return new DysonDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    protected DysonDataManager create(EbayContext ebaycontext)
    {
        return new DysonDataManager(ebaycontext, this, null);
    }

    protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }


    _cls1()
    {
    }
}

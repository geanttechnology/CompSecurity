// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SymbanDataManager, UserContextObservingDataManager

public static final class _cls1 extends ger.KeyBase
    implements Parcelable
{

    public static final android.os.ntext CREATOR = new android.os.Parcelable.Creator() {

        public SymbanDataManager.KeyParams createFromParcel(Parcel parcel)
        {
            return SymbanDataManager.KEY;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SymbanDataManager.KeyParams[] newArray(int i)
        {
            return new SymbanDataManager.KeyParams[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public SymbanDataManager create(EbayContext ebaycontext)
    {
        return new SymbanDataManager(ebaycontext);
    }

    public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }


    protected _cls1()
    {
    }
}

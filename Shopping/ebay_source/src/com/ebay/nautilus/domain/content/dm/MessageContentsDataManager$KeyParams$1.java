// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import com.ebay.nautilus.domain.data.EbayMessage;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageContentsDataManager

static final class 
    implements android.os.sDataManager.KeyParams._cls1
{

    public  createFromParcel(Parcel parcel)
    {
        return new nit>((EbayMessage)EbayMessage.CREATOR.KeyParams(parcel));
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public createFromParcel[] newArray(int i)
    {
        return new createFromParcel[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.promotions;

import android.os.Parcel;

// Referenced classes of package com.target.ui.helper.promotions:
//            PromotionStatusRequestParams

static final class 
    implements android.os.tatusRequestParams._cls1
{

    public PromotionStatusRequestParams a(Parcel parcel)
    {
        return new PromotionStatusRequestParams(parcel);
    }

    public PromotionStatusRequestParams[] a(int i)
    {
        return new PromotionStatusRequestParams[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}

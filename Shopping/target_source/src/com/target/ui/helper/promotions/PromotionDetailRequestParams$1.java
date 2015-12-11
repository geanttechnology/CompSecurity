// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.promotions;

import android.os.Parcel;

// Referenced classes of package com.target.ui.helper.promotions:
//            PromotionDetailRequestParams

static final class 
    implements android.os.etailRequestParams._cls1
{

    public PromotionDetailRequestParams a(Parcel parcel)
    {
        return new PromotionDetailRequestParams(parcel);
    }

    public PromotionDetailRequestParams[] a(int i)
    {
        return new PromotionDetailRequestParams[i];
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

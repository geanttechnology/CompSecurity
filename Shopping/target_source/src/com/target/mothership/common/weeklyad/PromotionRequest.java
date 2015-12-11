// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.weeklyad;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;

// Referenced classes of package com.target.mothership.common.weeklyad:
//            PromotionSlug

public class PromotionRequest
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PromotionRequest a(Parcel parcel)
        {
            return new PromotionRequest(parcel);
        }

        public PromotionRequest[] a(int i)
        {
            return new PromotionRequest[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private String mPreviewDate;
    private PromotionSlug mPromotionSlug;

    private PromotionRequest(Parcel parcel)
    {
        mPromotionSlug = (PromotionSlug)parcel.readParcelable(com/target/mothership/common/weeklyad/PromotionSlug.getClassLoader());
        mPreviewDate = parcel.readString();
    }


    public PromotionRequest(PromotionSlug promotionslug)
    {
        mPromotionSlug = promotionslug;
    }

    public PromotionRequest(String s)
    {
        mPreviewDate = s;
    }

    public e a()
    {
        return e.c(mPromotionSlug);
    }

    public void a(String s)
    {
        mPreviewDate = s;
    }

    public e b()
    {
        return e.c(mPreviewDate);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mPromotionSlug, i);
        parcel.writeString(mPreviewDate);
    }

}

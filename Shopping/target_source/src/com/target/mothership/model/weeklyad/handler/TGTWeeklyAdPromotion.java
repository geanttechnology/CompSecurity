// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.weeklyad.PromotionSlug;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPromotion;
import java.util.Date;

class TGTWeeklyAdPromotion
    implements Parcelable, WeeklyAdPromotion
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTWeeklyAdPromotion a(Parcel parcel)
        {
            return new TGTWeeklyAdPromotion(parcel);
        }

        public TGTWeeklyAdPromotion[] a(int i)
        {
            return new TGTWeeklyAdPromotion[i];
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
    private Date mEndDate;
    private PromotionSlug mSlug;
    private Date mStartDate;

    public TGTWeeklyAdPromotion()
    {
    }

    private TGTWeeklyAdPromotion(Parcel parcel)
    {
        Object obj = null;
        super();
        mSlug = (PromotionSlug)parcel.readParcelable(com/target/mothership/common/weeklyad/PromotionSlug.getClassLoader());
        long l = parcel.readLong();
        Date date;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mStartDate = date;
        l = parcel.readLong();
        if (l == -1L)
        {
            parcel = obj;
        } else
        {
            parcel = new Date(l);
        }
        mEndDate = parcel;
    }


    public PromotionSlug a()
    {
        return mSlug;
    }

    public void a(PromotionSlug promotionslug)
    {
        mSlug = promotionslug;
    }

    public void a(Date date)
    {
        mStartDate = date;
    }

    public Date b()
    {
        return mStartDate;
    }

    public void b(Date date)
    {
        mEndDate = date;
    }

    public Date c()
    {
        return mEndDate;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        parcel.writeParcelable(mSlug, i);
        long l;
        if (mStartDate != null)
        {
            l = mStartDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mEndDate != null)
        {
            l = mEndDate.getTime();
        }
        parcel.writeLong(l);
    }

}

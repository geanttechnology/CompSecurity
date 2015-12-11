// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.page_item.interfaces.DisplayDates;
import java.util.Date;

class TGTDisplayDates
    implements DisplayDates
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTDisplayDates a(Parcel parcel)
        {
            return new TGTDisplayDates(parcel);
        }

        public TGTDisplayDates[] a(int i)
        {
            return new TGTDisplayDates[i];
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
    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    private Date mEndDate;
    private Date mStartDate;

    public TGTDisplayDates()
    {
    }

    private TGTDisplayDates(Parcel parcel)
    {
        Object obj = null;
        super();
        long l = parcel.readLong();
        Date date;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mEndDate = date;
        l = parcel.readLong();
        if (l == -1L)
        {
            parcel = obj;
        } else
        {
            parcel = new Date(l);
        }
        mStartDate = parcel;
    }


    public e a()
    {
        return e.c(mEndDate);
    }

    public void a(Date date)
    {
        mEndDate = date;
    }

    public e b()
    {
        return e.c(mStartDate);
    }

    public void b(Date date)
    {
        mStartDate = date;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        long l;
        if (mEndDate != null)
        {
            l = mEndDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mStartDate != null)
        {
            l = mStartDate.getTime();
        }
        parcel.writeLong(l);
    }

}

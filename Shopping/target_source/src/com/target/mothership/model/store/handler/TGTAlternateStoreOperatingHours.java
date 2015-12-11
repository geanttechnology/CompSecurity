// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.store.interfaces.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.target.mothership.model.store.handler:
//            TGTStoreOperatingHours

public class TGTAlternateStoreOperatingHours
    implements Parcelable, a
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAlternateStoreOperatingHours a(Parcel parcel)
        {
            return new TGTAlternateStoreOperatingHours(parcel);
        }

        public TGTAlternateStoreOperatingHours[] a(int i)
        {
            return new TGTAlternateStoreOperatingHours[i];
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
    private List mOperatingHours;
    private Date mStartDate;

    TGTAlternateStoreOperatingHours()
    {
    }

    private TGTAlternateStoreOperatingHours(Parcel parcel)
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
        mStartDate = date;
        l = parcel.readLong();
        if (l == -1L)
        {
            date = obj;
        } else
        {
            date = new Date(l);
        }
        mEndDate = date;
        mOperatingHours = new ArrayList();
        parcel.readList(mOperatingHours, com/target/mothership/model/store/handler/TGTStoreOperatingHours.getClassLoader());
    }


    public Date a()
    {
        return mStartDate;
    }

    public void a(Date date)
    {
        mStartDate = date;
    }

    public void a(List list)
    {
        mOperatingHours = list;
    }

    public Date b()
    {
        return mEndDate;
    }

    public void b(Date date)
    {
        mEndDate = date;
    }

    public List c()
    {
        return mOperatingHours;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
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
        parcel.writeList(mOperatingHours);
    }

}

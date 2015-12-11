// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.guest.interfaces.OrderHistoryYearGroup;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTOrderSummary

public class TGTOrderHistoryYearGroup
    implements OrderHistoryYearGroup
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderHistoryYearGroup a(Parcel parcel)
        {
            return new TGTOrderHistoryYearGroup(parcel);
        }

        public TGTOrderHistoryYearGroup[] a(int i)
        {
            return new TGTOrderHistoryYearGroup[i];
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
    private List mOrderSummaryList;
    private int mYear;

    TGTOrderHistoryYearGroup()
    {
    }

    private TGTOrderHistoryYearGroup(Parcel parcel)
    {
        mYear = parcel.readInt();
        mOrderSummaryList = new ArrayList();
        parcel.readList(mOrderSummaryList, com/target/mothership/model/guest/handler/TGTOrderSummary.getClassLoader());
    }


    public int a()
    {
        return mYear;
    }

    public void a(int i)
    {
        mYear = i;
    }

    public void a(List list)
    {
        mOrderSummaryList = list;
    }

    public List b()
    {
        return mOrderSummaryList;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mYear);
        parcel.writeList(mOrderSummaryList);
    }

}

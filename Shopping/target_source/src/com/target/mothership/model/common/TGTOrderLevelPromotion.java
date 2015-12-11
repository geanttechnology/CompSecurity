// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;
import com.target.mothership.common.b;

// Referenced classes of package com.target.mothership.model.common:
//            OrderLevelPromotion

public class TGTOrderLevelPromotion
    implements OrderLevelPromotion
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderLevelPromotion a(Parcel parcel)
        {
            return new TGTOrderLevelPromotion(parcel);
        }

        public TGTOrderLevelPromotion[] a(int i)
        {
            return new TGTOrderLevelPromotion[i];
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
    private String mDescription;
    private b mGroupName;

    public TGTOrderLevelPromotion()
    {
    }

    private TGTOrderLevelPromotion(Parcel parcel)
    {
        mDescription = parcel.readString();
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = b.values()[i];
        }
        mGroupName = parcel;
    }


    public void a(b b1)
    {
        mGroupName = b1;
    }

    public void a(String s)
    {
        mDescription = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDescription);
        if (mGroupName == null)
        {
            i = -1;
        } else
        {
            i = mGroupName.ordinal();
        }
        parcel.writeInt(i);
    }

}

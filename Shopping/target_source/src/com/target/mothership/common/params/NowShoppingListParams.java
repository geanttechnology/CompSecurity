// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.common.params:
//            NowShoppingProdParams

public class NowShoppingListParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NowShoppingListParams a(Parcel parcel)
        {
            return new NowShoppingListParams(parcel);
        }

        public NowShoppingListParams[] a(int i)
        {
            return new NowShoppingListParams[i];
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
    private List mNowShoppingProdParamsList;
    private String mShoppingListId;

    private NowShoppingListParams(Parcel parcel)
    {
        mShoppingListId = parcel.readString();
        mNowShoppingProdParamsList = new ArrayList();
        parcel.readList(mNowShoppingProdParamsList, com/target/mothership/common/params/NowShoppingProdParams.getClassLoader());
    }


    public NowShoppingListParams(String s, List list)
    {
        mShoppingListId = s;
        mNowShoppingProdParamsList = list;
    }

    public String a()
    {
        return mShoppingListId;
    }

    public List b()
    {
        return mNowShoppingProdParamsList;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mShoppingListId);
        parcel.writeList(mNowShoppingProdParamsList);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.model.list.interfaces.ListItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.common.params:
//            NowShoppingListParams, NowShoppingProdParams

public class GoogleNowSendCardParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public GoogleNowSendCardParams a(Parcel parcel)
        {
            return new GoogleNowSendCardParams(parcel);
        }

        public GoogleNowSendCardParams[] a(int i)
        {
            return new GoogleNowSendCardParams[i];
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
    private String mDeviceId;
    private String mGuestId;
    private Integer mPrefferedStoreId;
    private NowShoppingListParams mShoppingListParams;

    private GoogleNowSendCardParams(Parcel parcel)
    {
        mDeviceId = parcel.readString();
        mGuestId = parcel.readString();
        mPrefferedStoreId = Integer.valueOf(parcel.readInt());
        mShoppingListParams = (NowShoppingListParams)parcel.readParcelable(com/target/mothership/common/params/NowShoppingListParams.getClassLoader());
    }


    public GoogleNowSendCardParams(String s, StoreIdentifier storeidentifier, ListDetail listdetail)
    {
        if (listdetail.getGuestId().equals("none"))
        {
            mGuestId = null;
        } else
        {
            mGuestId = listdetail.getGuestId();
        }
        mDeviceId = s;
        mPrefferedStoreId = Integer.valueOf(storeidentifier.a());
        storeidentifier = listdetail.getListItems();
        s = new ArrayList();
        for (storeidentifier = storeidentifier.iterator(); storeidentifier.hasNext(); s.add(new NowShoppingProdParams((ListItem)storeidentifier.next()))) { }
        mShoppingListParams = new NowShoppingListParams(String.valueOf(listdetail.getKey()), s);
    }

    public String a()
    {
        return mGuestId;
    }

    public String b()
    {
        return mDeviceId;
    }

    public int c()
    {
        return mPrefferedStoreId.intValue();
    }

    public NowShoppingListParams d()
    {
        return mShoppingListParams;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDeviceId);
        parcel.writeString(mGuestId);
        int j;
        if (mPrefferedStoreId == null)
        {
            j = -1;
        } else
        {
            j = mPrefferedStoreId.intValue();
        }
        parcel.writeInt(j);
        parcel.writeParcelable(mShoppingListParams, i);
    }

}

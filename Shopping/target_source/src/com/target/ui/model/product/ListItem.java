// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.ui.util.q;

public class ListItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ListItem a(Parcel parcel)
        {
            return new ListItem(parcel);
        }

        public ListItem[] a(int i)
        {
            return new ListItem[i];
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
    private static final String TAG = com/target/ui/model/product/ListItem.getSimpleName();
    private final String mKey;
    private final String mValue;

    private ListItem(Parcel parcel)
    {
        mKey = parcel.readString();
        mValue = parcel.readString();
    }


    public ListItem(String s, String s1)
    {
        mKey = s;
        mValue = s1;
    }

    public String a()
    {
        return mKey;
    }

    public String b()
    {
        return mValue;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag3 = false;
        if (!(obj instanceof ListItem)) goto _L2; else goto _L1
_L1:
        boolean flag1;
        obj = (ListItem)obj;
        flag1 = mKey.equals(((ListItem) (obj)).a());
        boolean flag = mValue.equals(((ListItem) (obj)).b());
_L5:
        boolean flag2 = flag3;
        if (flag1)
        {
            flag2 = flag3;
            if (flag)
            {
                flag2 = true;
            }
        }
        return flag2;
        obj;
        flag1 = false;
_L3:
        q.a(TAG, (new StringBuilder()).append("Object should of type ListItem : ").append(obj).toString());
        flag = false;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L3; else goto _L2
_L2:
        flag = false;
        flag1 = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public int hashCode()
    {
        return mKey.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mKey);
        parcel.writeString(mValue);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shippingFields;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.support.ParcelableCreator;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.groupon.models.shippingFields:
//            ShippingSelectValue

public class ShippingField
    implements Parcelable
{

    public static android.os.Parcelable.Creator CREATOR = new ParcelableCreator(com/groupon/models/shippingFields/ShippingField);
    public HashMap dynamicSelectValues;
    public String label;
    public String name;
    public String parentField;
    public boolean required;
    public List selectValues;
    public String type;

    public ShippingField()
    {
    }

    public ShippingField(Parcel parcel)
    {
        dynamicSelectValues = new HashMap();
        name = parcel.readString();
        label = parcel.readString();
        type = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        required = flag;
        parcel.readList(selectValues, com/groupon/models/shippingFields/ShippingSelectValue.getClassLoader());
        parentField = parcel.readString();
        parcel.readMap(dynamicSelectValues, com/groupon/models/shippingFields/ShippingSelectValue.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeString(label);
        parcel.writeString(type);
        if (required)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeList(selectValues);
        parcel.writeString(parentField);
        parcel.writeMap(dynamicSelectValues);
    }

}

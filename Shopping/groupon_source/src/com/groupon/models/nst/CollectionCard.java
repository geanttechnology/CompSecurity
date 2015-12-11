// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class CollectionCard extends JsonEncodedNSTField
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CollectionCard createFromParcel(Parcel parcel)
        {
            return new CollectionCard(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CollectionCard[] newArray(int i)
        {
            return new CollectionCard[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String cardUUID;
    public final int position;
    public final String source;
    public final String templateId;

    protected CollectionCard(Parcel parcel)
    {
        source = parcel.readString();
        cardUUID = parcel.readString();
        templateId = parcel.readString();
        position = parcel.readInt();
    }

    public CollectionCard(String s, String s1, String s2, int i)
    {
        source = s;
        cardUUID = s1;
        templateId = s2;
        position = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(source);
        parcel.writeString(cardUUID);
        parcel.writeString(templateId);
        parcel.writeInt(position);
    }

}

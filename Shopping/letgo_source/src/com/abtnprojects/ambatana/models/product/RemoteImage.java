// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            AbstractImage

public class RemoteImage extends AbstractImage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RemoteImage createFromParcel(Parcel parcel)
        {
            return new RemoteImage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RemoteImage[] newArray(int i)
        {
            return new RemoteImage[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String id;
    private final String url;

    protected RemoteImage(Parcel parcel)
    {
        url = parcel.readString();
        id = parcel.readString();
    }

    public RemoteImage(String s, String s1)
    {
        url = s;
        id = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDisplayUrl()
    {
        return url;
    }

    public String getId()
    {
        return id;
    }

    public String getUrl()
    {
        return url;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Image{url='").append(url).append('\'').append(", id=").append(id).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(url);
        parcel.writeString(id);
    }

}

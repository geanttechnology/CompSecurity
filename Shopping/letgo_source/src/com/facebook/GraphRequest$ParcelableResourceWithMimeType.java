// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.facebook:
//            GraphRequest, k

public static class <init>
    implements Parcelable
{

    public static final android.os.e.b CREATOR = new android.os.Parcelable.Creator() {

        public GraphRequest.ParcelableResourceWithMimeType a(Parcel parcel)
        {
            return new GraphRequest.ParcelableResourceWithMimeType(parcel, null);
        }

        public GraphRequest.ParcelableResourceWithMimeType[] a(int i)
        {
            return new GraphRequest.ParcelableResourceWithMimeType[i];
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
    private final String a;
    private final Parcelable b;

    public String a()
    {
        return a;
    }

    public Parcelable b()
    {
        return b;
    }

    public int describeContents()
    {
        return 1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeParcelable(b, i);
    }


    private _cls1(Parcel parcel)
    {
        a = parcel.readString();
        b = parcel.readParcelable(k.f().getClassLoader());
    }

    b(Parcel parcel, b b1)
    {
        this(parcel);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.facebook:
//            FacebookSdk

public class resource
    implements Parcelable
{

    public static final android.os.e.resource CREATOR = new _cls1();
    private final String mimeType;
    private final Parcelable resource;

    public int describeContents()
    {
        return 1;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public Parcelable getResource()
    {
        return resource;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mimeType);
        parcel.writeParcelable(resource, i);
    }


    private _cls1(Parcel parcel)
    {
        mimeType = parcel.readString();
        resource = parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
    }

    resource(Parcel parcel, resource resource1)
    {
        this(parcel);
    }

    public <init>(Parcelable parcelable, String s)
    {
        mimeType = s;
        resource = parcelable;
    }

    /* block-local class not found */
    class _cls1 {}

}

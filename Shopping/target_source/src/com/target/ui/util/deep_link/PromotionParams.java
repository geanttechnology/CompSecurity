// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;

public class PromotionParams
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PromotionParams a(Parcel parcel)
        {
            return new PromotionParams(parcel);
        }

        public PromotionParams[] a(int i)
        {
            return new PromotionParams[i];
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
    private final String mCode;
    private Uri mSecondaryDeepLink;
    private final String mType;

    private PromotionParams(Parcel parcel)
    {
        mCode = parcel.readString();
        mType = parcel.readString();
        mSecondaryDeepLink = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
    }


    public PromotionParams(String s, String s1)
    {
        mType = s;
        mCode = s1;
    }

    public String a()
    {
        return mCode;
    }

    public void a(Uri uri)
    {
        mSecondaryDeepLink = uri;
    }

    public e b()
    {
        return e.c(mSecondaryDeepLink);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCode);
        parcel.writeString(mType);
        parcel.writeParcelable(mSecondaryDeepLink, i);
    }

}

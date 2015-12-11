// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.page_item.interfaces.Action;

class TGTAction
    implements Action
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAction a(Parcel parcel)
        {
            return new TGTAction(parcel);
        }

        public TGTAction[] a(int i)
        {
            return new TGTAction[i];
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
    private String mAppId;
    private String mTarget;
    private String mText;

    public TGTAction()
    {
    }

    private TGTAction(Parcel parcel)
    {
        mAppId = parcel.readString();
        mTarget = parcel.readString();
        mText = parcel.readString();
    }


    public e a()
    {
        return e.c(mAppId);
    }

    public void a(String s)
    {
        mAppId = s;
    }

    public String b()
    {
        return mTarget;
    }

    public void b(String s)
    {
        mTarget = s;
    }

    public e c()
    {
        return e.c(mText);
    }

    public void c(String s)
    {
        mText = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mAppId);
        parcel.writeString(mTarget);
        parcel.writeString(mText);
    }

}

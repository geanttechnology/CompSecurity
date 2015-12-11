// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.page_item.b;
import com.target.mothership.model.page_item.interfaces.Action;
import com.target.mothership.model.page_item.interfaces.CustomAction;
import com.target.mothership.model.page_item.interfaces.ImageInfo;

class TGTCustomAction
    implements CustomAction
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCustomAction a(Parcel parcel)
        {
            return new TGTCustomAction(parcel);
        }

        public TGTCustomAction[] a(int i)
        {
            return new TGTCustomAction[i];
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
    private String mDescription;
    private ImageInfo mImageInfo;
    private String mImageUrl;
    private Action mPrimaryAction;
    private Action mSecondaryAction;
    private b mType;

    public TGTCustomAction()
    {
    }

    private TGTCustomAction(Parcel parcel)
    {
        mDescription = parcel.readString();
        mImageInfo = (ImageInfo)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/ImageInfo.getClassLoader());
        mImageUrl = parcel.readString();
        mPrimaryAction = (Action)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/Action.getClassLoader());
        mSecondaryAction = (Action)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/Action.getClassLoader());
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = com.target.mothership.common.page_item.b.values()[i];
        }
        mType = parcel;
    }


    public String a()
    {
        return mDescription;
    }

    public void a(b b1)
    {
        mType = b1;
    }

    public void a(Action action)
    {
        mPrimaryAction = action;
    }

    public void a(ImageInfo imageinfo)
    {
        mImageInfo = imageinfo;
    }

    public void a(String s)
    {
        mDescription = s;
    }

    public e b()
    {
        return com.google.a.a.e.c(mImageInfo);
    }

    public void b(Action action)
    {
        mSecondaryAction = action;
    }

    public void b(String s)
    {
        mImageUrl = s;
    }

    public e c()
    {
        return com.google.a.a.e.c(mImageUrl);
    }

    public e d()
    {
        return com.google.a.a.e.c(mPrimaryAction);
    }

    public int describeContents()
    {
        return 0;
    }

    public e e()
    {
        return com.google.a.a.e.c(mSecondaryAction);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDescription);
        parcel.writeParcelable(mImageInfo, i);
        parcel.writeString(mImageUrl);
        parcel.writeParcelable(mPrimaryAction, i);
        parcel.writeParcelable(mSecondaryAction, i);
        if (mType == null)
        {
            i = -1;
        } else
        {
            i = mType.ordinal();
        }
        parcel.writeInt(i);
    }

}

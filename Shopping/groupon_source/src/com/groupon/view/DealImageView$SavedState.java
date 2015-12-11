// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.groupon.view:
//            DealImageView

protected static class <init> extends android.view.ate
{

    public static final android.os.State.currentPosition CREATOR = new android.os.Parcelable.Creator() {

        public DealImageView.SavedState createFromParcel(Parcel parcel)
        {
            return new DealImageView.SavedState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public DealImageView.SavedState[] newArray(int i)
        {
            return new DealImageView.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    protected int currentPosition;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.ToParcel(parcel, i);
        parcel.writeInt(currentPosition);
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        currentPosition = parcel.readInt();
    }

    currentPosition(Parcel parcel, currentPosition currentposition)
    {
        this(parcel);
    }

    protected <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}

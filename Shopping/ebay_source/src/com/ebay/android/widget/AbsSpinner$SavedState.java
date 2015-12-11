// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.ebay.android.widget:
//            AbsSpinner

static class <init> extends android.view.SavedState
{

    public static final android.os.r.SavedState.position CREATOR = new android.os.Parcelable.Creator() {

        public AbsSpinner.SavedState createFromParcel(Parcel parcel)
        {
            return new AbsSpinner.SavedState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AbsSpinner.SavedState[] newArray(int i)
        {
            return new AbsSpinner.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    int position;
    long selectedId;

    public String toString()
    {
        return (new StringBuilder()).append("AbsSpinner.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" selectedId=").append(selectedId).append(" position=").append(position).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.iteToParcel(parcel, i);
        parcel.writeLong(selectedId);
        parcel.writeInt(position);
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        selectedId = parcel.readLong();
        position = parcel.readInt();
    }

    position(Parcel parcel, position position1)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}

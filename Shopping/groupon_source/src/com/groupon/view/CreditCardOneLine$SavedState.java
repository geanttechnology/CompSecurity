// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.groupon.view:
//            CreditCardOneLine

protected static class <init> extends android.view.ate
{

    public static final android.os.State.ccNumber CREATOR = new android.os.Parcelable.Creator() {

        public CreditCardOneLine.SavedState createFromParcel(Parcel parcel)
        {
            return new CreditCardOneLine.SavedState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CreditCardOneLine.SavedState[] newArray(int i)
        {
            return new CreditCardOneLine.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    protected String ccNumber;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.rcel(parcel, i);
        parcel.writeString(ccNumber);
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        ccNumber = parcel.readString();
    }

    ccNumber(Parcel parcel, ccNumber ccnumber)
    {
        this(parcel);
    }

    protected <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}

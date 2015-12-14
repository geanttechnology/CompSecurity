// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.os.Parcel;
import android.os.Parcelable;

class <init> extends android.view.SavedState
{

    public static final android.os.t.PanelState.toString CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new SlidingUpPanelLayout.SavedState(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int i)
        {
            return new SlidingUpPanelLayout.SavedState[i];
        }

    };
    _cls1 a;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.l(parcel, i);
        parcel.writeString(a.toString());
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        try
        {
            a = (a)Enum.valueOf(com/picsart/studio/view/SlidingUpPanelLayout$PanelState, parcel.readString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            a = COLLAPSED;
        }
    }

    COLLAPSED(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}

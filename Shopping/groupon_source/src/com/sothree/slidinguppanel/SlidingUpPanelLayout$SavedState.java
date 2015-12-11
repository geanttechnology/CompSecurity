// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sothree.slidinguppanel;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.sothree.slidinguppanel:
//            SlidingUpPanelLayout

static class <init> extends android.view.ut.SavedState
{

    public static final android.os.yout.PanelState.toString CREATOR = new android.os.Parcelable.Creator() {

        public SlidingUpPanelLayout.SavedState createFromParcel(Parcel parcel)
        {
            return new SlidingUpPanelLayout.SavedState(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SlidingUpPanelLayout.SavedState[] newArray(int i)
        {
            return new SlidingUpPanelLayout.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    _cls1.newArray mSlideState;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.l(parcel, i);
        parcel.writeString(mSlideState.toString());
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        try
        {
            mSlideState = (mSlideState)Enum.valueOf(com/sothree/slidinguppanel/SlidingUpPanelLayout$PanelState, parcel.readString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            mSlideState = COLLAPSED;
        }
    }

    COLLAPSED(Parcel parcel, COLLAPSED collapsed)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}

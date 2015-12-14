// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;

class a extends android.view.erView.SavedState
{

    public static final android.os.ulerView.SavedState.a CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new RulerView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new RulerView.SavedState[i];
        }

    };
    private float a;

    static float a(a a1)
    {
        return a1.a;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.riteToParcel(parcel, i);
        parcel.writeFloat(a);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        a = parcel.readFloat();
    }

    public a(Parcelable parcelable, float f)
    {
        super(parcelable);
        a = f;
    }
}

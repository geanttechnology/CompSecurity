// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.view;

import android.os.Parcel;
import android.os.Parcelable;

public class b extends android.view.Preview.SavedState
{

    public static final android.os.erPreview.SavedState.b CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new ColorPickerPreview.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new ColorPickerPreview.SavedState[i];
        }

    };
    private int a;
    private boolean b;

    static int a(b b1)
    {
        return b1.a;
    }

    static int a(a a1, int i)
    {
        a1.a = i;
        return i;
    }

    static boolean a(a a1, boolean flag)
    {
        a1.b = flag;
        return flag;
    }

    static boolean b(b b1)
    {
        return b1.b;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.cel(parcel, i);
        parcel.writeInt(a);
        if (b)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    public _cls1(Parcel parcel)
    {
        boolean flag = true;
        super(parcel);
        a = parcel.readInt();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        b = flag;
    }

    public b(Parcelable parcelable)
    {
        super(parcelable);
    }
}

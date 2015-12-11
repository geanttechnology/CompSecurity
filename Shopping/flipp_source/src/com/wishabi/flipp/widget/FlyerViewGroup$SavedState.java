// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.wishabi.flipp.widget:
//            bu

class b extends android.view..SavedState
{

    public static final android.os.up.SavedState.b CREATOR = new bu();
    final int a;
    final int b;

    public String toString()
    {
        return (new StringBuilder("FlyerViewGroup.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" mLeft =").append(a).append(" mRight =").append(b).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.oParcel(parcel, i);
        parcel.writeInt(a);
        parcel.writeInt(b);
    }


    public (Parcel parcel)
    {
        super(parcel);
        a = parcel.readInt();
        b = parcel.readInt();
    }

    b(Parcelable parcelable, int i, int j)
    {
        super(parcelable);
        a = i;
        b = j;
    }
}

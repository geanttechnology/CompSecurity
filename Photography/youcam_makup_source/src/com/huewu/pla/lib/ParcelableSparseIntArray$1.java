// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib;

import android.os.Parcel;

// Referenced classes of package com.huewu.pla.lib:
//            ParcelableSparseIntArray

final class 
    implements android.os.rray._cls1
{

    public ParcelableSparseIntArray a(Parcel parcel)
    {
        return new ParcelableSparseIntArray(parcel, null);
    }

    public ParcelableSparseIntArray[] a(int i)
    {
        return new ParcelableSparseIntArray[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}

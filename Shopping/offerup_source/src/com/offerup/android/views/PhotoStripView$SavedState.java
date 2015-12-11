// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package com.offerup.android.views:
//            c

class a extends android.view.w.SavedState
{

    public static final android.os.iew.SavedState.a CREATOR = new c();
    private ArrayList a;

    static ArrayList a(a a1)
    {
        return a1.a;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.oParcel(parcel, i);
        parcel.writeList(a);
    }


    private _cls9(Parcel parcel)
    {
        super(parcel);
        a = parcel.createTypedArrayList(Uri.CREATOR);
    }

    a(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable, ArrayList arraylist)
    {
        super(parcelable);
        a = arraylist;
    }
}

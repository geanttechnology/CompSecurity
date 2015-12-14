// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package viewpagerindicator;

import android.os.Parcel;
import android.os.Parcelable;
import cfk;
import cfl;

public class <init> extends android.view.State
{

    public static final android.os.edState.a CREATOR = new cfl();
    int a;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.el(parcel, i);
        parcel.writeInt(a);
    }


    private (Parcel parcel)
    {
        super(parcel);
        a = parcel.readInt();
    }

    public a(Parcel parcel, cfk cfk)
    {
        this(parcel);
    }

    public <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}

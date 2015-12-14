// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package viewpagerindicator;

import android.os.Parcel;
import android.os.Parcelable;
import cfy;
import cga;

public class <init> extends android.view.State
{

    public static final android.os.edState.a CREATOR = new cga();
    int a;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.State(parcel, i);
        parcel.writeInt(a);
    }


    private (Parcel parcel)
    {
        super(parcel);
        a = parcel.readInt();
    }

    public a(Parcel parcel, cfy cfy)
    {
        this(parcel);
    }

    public <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}

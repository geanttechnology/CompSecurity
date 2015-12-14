// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import l;

public class 
    implements Parcelable
{

    public static final android.os..SavedState.c CREATOR = new l();
    int a;
    boolean b;
    Bundle c;

    public static  a(Parcel parcel)
    {
        return b(parcel);
    }

    private static b b(Parcel parcel)
    {
        boolean flag = true;
        b b1 = new <init>();
        b1.a = parcel.readInt();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        b1.b = flag;
        if (b1.b)
        {
            b1.c = parcel.readBundle();
        }
        return b1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a);
        if (b)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (b)
        {
            parcel.writeBundle(c);
        }
    }


    private ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseIntArray;

public class ParcelableSparseIntArray extends SparseIntArray
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ParcelableSparseIntArray a(Parcel parcel)
        {
            return new ParcelableSparseIntArray(parcel);
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

    };

    public ParcelableSparseIntArray()
    {
    }

    private ParcelableSparseIntArray(Parcel parcel)
    {
        a(parcel.readSparseArray(ClassLoader.getSystemClassLoader()));
    }


    private SparseArray a()
    {
        SparseArray sparsearray = new SparseArray();
        int i = 0;
        for (int j = size(); i < j; i++)
        {
            sparsearray.append(keyAt(i), Integer.valueOf(valueAt(i)));
        }

        return sparsearray;
    }

    private void a(SparseArray sparsearray)
    {
        int j = sparsearray.size();
        for (int i = 0; i < j; i++)
        {
            put(sparsearray.keyAt(i), ((Integer)sparsearray.valueAt(i)).intValue());
        }

    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSparseArray(a());
    }

}

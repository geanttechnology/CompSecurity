// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.scan;

import android.os.Parcel;
import android.os.Parcelable;

public class ScanResultItem
    implements Parcelable
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a CONNECTION_ISSUE;
        public static final a NO_RESULT;
        public static final a PRODUCT_NOT_FOUND;
        public static final a PRODUCT_RESULT;
        public static final a UPC_RESULT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/model/scan/ScanResultItem$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            NO_RESULT = new a("NO_RESULT", 0);
            UPC_RESULT = new a("UPC_RESULT", 1);
            PRODUCT_RESULT = new a("PRODUCT_RESULT", 2);
            PRODUCT_NOT_FOUND = new a("PRODUCT_NOT_FOUND", 3);
            CONNECTION_ISSUE = new a("CONNECTION_ISSUE", 4);
            $VALUES = (new a[] {
                NO_RESULT, UPC_RESULT, PRODUCT_RESULT, PRODUCT_NOT_FOUND, CONNECTION_ISSUE
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ScanResultItem a(Parcel parcel)
        {
            return new ScanResultItem(parcel);
        }

        public ScanResultItem[] a(int i)
        {
            return new ScanResultItem[i];
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
    private String mProduct;
    private a mScanStatus;
    private String mUpc;

    private ScanResultItem(Parcel parcel)
    {
        mUpc = parcel.readString();
        mProduct = parcel.readString();
        mScanStatus = a.values()[parcel.readInt()];
    }


    public ScanResultItem(String s)
    {
        a(a.UPC_RESULT);
        a(s);
    }

    public String a()
    {
        return mUpc;
    }

    public void a(a a1)
    {
        mScanStatus = a1;
    }

    public void a(String s)
    {
        mUpc = s;
    }

    public String b()
    {
        return mProduct;
    }

    public void b(String s)
    {
        mProduct = s;
    }

    public a c()
    {
        return mScanStatus;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mUpc);
        parcel.writeString(mProduct);
        parcel.writeInt(mScanStatus.ordinal());
    }

}

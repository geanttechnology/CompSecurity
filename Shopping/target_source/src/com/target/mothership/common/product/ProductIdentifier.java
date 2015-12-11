// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public abstract class ProductIdentifier
    implements Parcelable, Comparable
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a BARCODE;
        public static final a CATENTRYID;
        public static final a DPCI;
        public static final a TCIN;
        public static final a UPC;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/common/product/ProductIdentifier$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            TCIN = new a("TCIN", 0);
            UPC = new a("UPC", 1);
            DPCI = new a("DPCI", 2);
            CATENTRYID = new a("CATENTRYID", 3);
            BARCODE = new a("BARCODE", 4);
            $VALUES = (new a[] {
                TCIN, UPC, DPCI, CATENTRYID, BARCODE
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private String mRawId;

    public ProductIdentifier(Parcel parcel)
    {
        mRawId = parcel.readString();
    }

    public ProductIdentifier(String s)
    {
        mRawId = s;
    }

    public int a(ProductIdentifier productidentifier)
    {
        if (productidentifier == null)
        {
            return 0;
        } else
        {
            return mRawId.compareTo(productidentifier.b());
        }
    }

    public abstract a a();

    public abstract List a(List list);

    public String b()
    {
        return mRawId;
    }

    public int compareTo(Object obj)
    {
        return a((ProductIdentifier)obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (ProductIdentifier)obj;
        if (mRawId == null) goto _L4; else goto _L3
_L3:
        if (mRawId.equals(((ProductIdentifier) (obj)).mRawId)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((ProductIdentifier) (obj)).mRawId == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        if (mRawId != null)
        {
            return mRawId.hashCode();
        } else
        {
            return 0;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mRawId);
    }
}

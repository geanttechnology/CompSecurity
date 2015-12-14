// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzi

public final class LineItem
    implements SafeParcelable
{
    public final class Builder
    {

        final LineItem zzaWH;

        public LineItem build()
        {
            return zzaWH;
        }

        public Builder setCurrencyCode(String s)
        {
            zzaWH.zzaWc = s;
            return this;
        }

        public Builder setDescription(String s)
        {
            zzaWH.description = s;
            return this;
        }

        public Builder setQuantity(String s)
        {
            zzaWH.zzaWE = s;
            return this;
        }

        public Builder setRole(int i)
        {
            zzaWH.zzaWG = i;
            return this;
        }

        public Builder setTotalPrice(String s)
        {
            zzaWH.zzaWb = s;
            return this;
        }

        public Builder setUnitPrice(String s)
        {
            zzaWH.zzaWF = s;
            return this;
        }

        private Builder()
        {
            zzaWH = LineItem.this;
            super();
        }

    }

    public static interface Role
    {

        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    String description;
    private final int mVersionCode;
    String zzaWE;
    String zzaWF;
    int zzaWG;
    String zzaWb;
    String zzaWc;

    LineItem()
    {
        mVersionCode = 1;
        zzaWG = 0;
    }

    LineItem(int i, String s, String s1, String s2, String s3, int j, String s4)
    {
        mVersionCode = i;
        description = s;
        zzaWE = s1;
        zzaWF = s2;
        zzaWb = s3;
        zzaWG = j;
        zzaWc = s4;
    }

    public static Builder newBuilder()
    {
        LineItem lineitem = new LineItem();
        lineitem.getClass();
        return lineitem. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCurrencyCode()
    {
        return zzaWc;
    }

    public String getDescription()
    {
        return description;
    }

    public String getQuantity()
    {
        return zzaWE;
    }

    public int getRole()
    {
        return zzaWG;
    }

    public String getTotalPrice()
    {
        return zzaWb;
    }

    public String getUnitPrice()
    {
        return zzaWF;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

}

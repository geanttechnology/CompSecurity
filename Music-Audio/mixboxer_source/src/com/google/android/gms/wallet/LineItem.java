// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            f

public final class LineItem
    implements SafeParcelable
{
    public final class Builder
    {

        final LineItem Gz;

        public LineItem build()
        {
            return Gz;
        }

        public Builder setCurrencyCode(String s)
        {
            Gz.Gk = s;
            return this;
        }

        public Builder setDescription(String s)
        {
            Gz.description = s;
            return this;
        }

        public Builder setQuantity(String s)
        {
            Gz.Gw = s;
            return this;
        }

        public Builder setRole(int i)
        {
            Gz.Gy = i;
            return this;
        }

        public Builder setTotalPrice(String s)
        {
            Gz.Gj = s;
            return this;
        }

        public Builder setUnitPrice(String s)
        {
            Gz.Gx = s;
            return this;
        }

        private Builder()
        {
            Gz = LineItem.this;
            super();
        }

    }

    public static interface Role
    {

        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }


    public static final android.os.Parcelable.Creator CREATOR = new f();
    String Gj;
    String Gk;
    String Gw;
    String Gx;
    int Gy;
    String description;
    private final int kg;

    LineItem()
    {
        kg = 1;
        Gy = 0;
    }

    LineItem(int i, String s, String s1, String s2, String s3, int j, String s4)
    {
        kg = i;
        description = s;
        Gw = s1;
        Gx = s2;
        Gj = s3;
        Gy = j;
        Gk = s4;
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
        return Gk;
    }

    public String getDescription()
    {
        return description;
    }

    public String getQuantity()
    {
        return Gw;
    }

    public int getRole()
    {
        return Gy;
    }

    public String getTotalPrice()
    {
        return Gj;
    }

    public String getUnitPrice()
    {
        return Gx;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        f.a(this, parcel, i);
    }

}

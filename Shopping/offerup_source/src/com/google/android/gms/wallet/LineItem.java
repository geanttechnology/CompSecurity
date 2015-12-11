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

    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    String description;
    private final int mVersionCode;
    String zzbcL;
    String zzbcM;
    int zzbcN;
    String zzbci;
    String zzbcj;

    LineItem()
    {
        mVersionCode = 1;
        zzbcN = 0;
    }

    LineItem(int i, String s, String s1, String s2, String s3, int j, String s4)
    {
        mVersionCode = i;
        description = s;
        zzbcL = s1;
        zzbcM = s2;
        zzbci = s3;
        zzbcN = j;
        zzbcj = s4;
    }

    public static Builder newBuilder()
    {
        LineItem lineitem = new LineItem();
        lineitem.getClass();
        return lineitem. new Builder(null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getCurrencyCode()
    {
        return zzbcj;
    }

    public final String getDescription()
    {
        return description;
    }

    public final String getQuantity()
    {
        return zzbcL;
    }

    public final int getRole()
    {
        return zzbcN;
    }

    public final String getTotalPrice()
    {
        return zzbci;
    }

    public final String getUnitPrice()
    {
        return zzbcM;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }


    private class Builder
    {

        final LineItem zzbcO;

        public final LineItem build()
        {
            return zzbcO;
        }

        public final Builder setCurrencyCode(String s)
        {
            zzbcO.zzbcj = s;
            return this;
        }

        public final Builder setDescription(String s)
        {
            zzbcO.description = s;
            return this;
        }

        public final Builder setQuantity(String s)
        {
            zzbcO.zzbcL = s;
            return this;
        }

        public final Builder setRole(int i)
        {
            zzbcO.zzbcN = i;
            return this;
        }

        public final Builder setTotalPrice(String s)
        {
            zzbcO.zzbci = s;
            return this;
        }

        public final Builder setUnitPrice(String s)
        {
            zzbcO.zzbcM = s;
            return this;
        }

        private Builder()
        {
            zzbcO = LineItem.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}

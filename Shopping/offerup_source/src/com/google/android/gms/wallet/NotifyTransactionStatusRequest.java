// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzm

public final class NotifyTransactionStatusRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    final int mVersionCode;
    int status;
    String zzbcp;
    String zzbdz;

    NotifyTransactionStatusRequest()
    {
        mVersionCode = 1;
    }

    NotifyTransactionStatusRequest(int i, String s, int j, String s1)
    {
        mVersionCode = i;
        zzbcp = s;
        status = j;
        zzbdz = s1;
    }

    public static Builder newBuilder()
    {
        NotifyTransactionStatusRequest notifytransactionstatusrequest = new NotifyTransactionStatusRequest();
        notifytransactionstatusrequest.getClass();
        return notifytransactionstatusrequest. new Builder(null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getDetailedReason()
    {
        return zzbdz;
    }

    public final String getGoogleTransactionId()
    {
        return zzbcp;
    }

    public final int getStatus()
    {
        return status;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }


    private class Builder
    {

        final NotifyTransactionStatusRequest zzbdA;

        public final NotifyTransactionStatusRequest build()
        {
            boolean flag1 = true;
            boolean flag;
            if (!TextUtils.isEmpty(zzbdA.zzbcp))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "googleTransactionId is required");
            if (zzbdA.status > 0 && zzbdA.status <= 8)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "status is an unrecognized value");
            return zzbdA;
        }

        public final Builder setDetailedReason(String s)
        {
            zzbdA.zzbdz = s;
            return this;
        }

        public final Builder setGoogleTransactionId(String s)
        {
            zzbdA.zzbcp = s;
            return this;
        }

        public final Builder setStatus(int i)
        {
            zzbdA.status = i;
            return this;
        }

        private Builder()
        {
            zzbdA = NotifyTransactionStatusRequest.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}

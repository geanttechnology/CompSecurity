// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.eg;

// Referenced classes of package com.google.android.gms.wallet:
//            j

public final class NotifyTransactionStatusRequest
    implements SafeParcelable
{
    public final class Builder
    {

        final NotifyTransactionStatusRequest GW;

        public NotifyTransactionStatusRequest build()
        {
            boolean flag1 = true;
            boolean flag;
            if (!TextUtils.isEmpty(GW.Gn))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            eg.b(flag, "googleTransactionId is required");
            if (GW.status >= 1 && GW.status <= 8)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            eg.b(flag, "status is an unrecognized value");
            return GW;
        }

        public Builder setDetailedReason(String s)
        {
            GW.GV = s;
            return this;
        }

        public Builder setGoogleTransactionId(String s)
        {
            GW.Gn = s;
            return this;
        }

        public Builder setStatus(int i)
        {
            GW.status = i;
            return this;
        }

        private Builder()
        {
            GW = NotifyTransactionStatusRequest.this;
            super();
        }

    }

    public static interface Status
    {

        public static final int SUCCESS = 1;
    }

    public static interface Status.Error
    {

        public static final int AVS_DECLINE = 7;
        public static final int BAD_CARD = 4;
        public static final int BAD_CVC = 3;
        public static final int DECLINED = 5;
        public static final int FRAUD_DECLINE = 8;
        public static final int OTHER = 6;
        public static final int UNKNOWN = 2;
    }


    public static final android.os.Parcelable.Creator CREATOR = new j();
    String GV;
    String Gn;
    final int kg;
    int status;

    NotifyTransactionStatusRequest()
    {
        kg = 1;
    }

    NotifyTransactionStatusRequest(int i, String s, int k, String s1)
    {
        kg = i;
        Gn = s;
        status = k;
        GV = s1;
    }

    public static Builder newBuilder()
    {
        NotifyTransactionStatusRequest notifytransactionstatusrequest = new NotifyTransactionStatusRequest();
        notifytransactionstatusrequest.getClass();
        return notifytransactionstatusrequest. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDetailedReason()
    {
        return GV;
    }

    public String getGoogleTransactionId()
    {
        return Gn;
    }

    public int getStatus()
    {
        return status;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        j.a(this, parcel, i);
    }

}

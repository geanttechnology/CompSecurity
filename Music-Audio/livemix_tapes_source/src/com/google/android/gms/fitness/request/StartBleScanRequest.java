// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zznh;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzaa, zzn, BleScanCallback

public class StartBleScanRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private DataType zzapZ[];
        private zzn zzaqB;
        private int zzaqC;

        static DataType[] zza(Builder builder)
        {
            return builder.zzapZ;
        }

        static zzn zzb(Builder builder)
        {
            return builder.zzaqB;
        }

        static int zzc(Builder builder)
        {
            return builder.zzaqC;
        }

        public StartBleScanRequest build()
        {
            boolean flag;
            if (zzaqB != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must set BleScanCallback");
            return new StartBleScanRequest(this);
        }

        public Builder setBleScanCallback(BleScanCallback blescancallback)
        {
            zza(com.google.android.gms.fitness.request.zza.zza.zzsa().zza(blescancallback));
            return this;
        }

        public transient Builder setDataTypes(DataType adatatype[])
        {
            zzapZ = adatatype;
            return this;
        }

        public Builder setTimeoutSecs(int i)
        {
            boolean flag1 = true;
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Stop time must be greater than zero");
            if (i <= 60)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "Stop time must be less than 1 minute");
            zzaqC = i;
            return this;
        }

        public Builder zza(zzn zzn1)
        {
            zzaqB = zzn1;
            return this;
        }

        public Builder()
        {
            zzapZ = new DataType[0];
            zzaqC = 10;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzaa();
    private final int mVersionCode;
    private final String zzOZ;
    private final List zzanw;
    private final zznh zzapE;
    private final zzn zzaqB;
    private final int zzaqC;

    StartBleScanRequest(int i, List list, IBinder ibinder, int j, IBinder ibinder1, String s)
    {
        mVersionCode = i;
        zzanw = list;
        zzaqB = zzn.zza.zzbM(ibinder);
        zzaqC = j;
        if (ibinder1 == null)
        {
            list = null;
        } else
        {
            list = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder1);
        }
        zzapE = list;
        zzOZ = s;
    }

    private StartBleScanRequest(Builder builder)
    {
        this(((List) (zzli.zzb(Builder.zza(builder)))), Builder.zzb(builder), Builder.zzc(builder), null, null);
    }


    public StartBleScanRequest(StartBleScanRequest startblescanrequest, zznh zznh1, String s)
    {
        this(startblescanrequest.zzanw, startblescanrequest.zzaqB, startblescanrequest.zzaqC, zznh1, s);
    }

    public StartBleScanRequest(List list, zzn zzn1, int i, zznh zznh1, String s)
    {
        mVersionCode = 3;
        zzanw = list;
        zzaqB = zzn1;
        zzaqC = i;
        zzapE = zznh1;
        zzOZ = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getDataTypes()
    {
        return Collections.unmodifiableList(zzanw);
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    public int getTimeoutSecs()
    {
        return zzaqC;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("dataTypes", zzanw).zzg("timeoutSecs", Integer.valueOf(zzaqC)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzaa.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzapE == null)
        {
            return null;
        } else
        {
            return zzapE.asBinder();
        }
    }

    public IBinder zzsy()
    {
        return zzaqB.asBinder();
    }

}

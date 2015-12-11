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
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.internal.zzoj;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzaa, zzn, BleScanCallback

public class StartBleScanRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private zzn zzasY;
        private int zzasZ;
        private DataType zzasw[];

        static DataType[] zza(Builder builder)
        {
            return builder.zzasw;
        }

        static zzn zzb(Builder builder)
        {
            return builder.zzasY;
        }

        static int zzc(Builder builder)
        {
            return builder.zzasZ;
        }

        public StartBleScanRequest build()
        {
            boolean flag;
            if (zzasY != null)
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
            zza(com.google.android.gms.fitness.request.zza.zza.zzsM().zza(blescancallback));
            return this;
        }

        public transient Builder setDataTypes(DataType adatatype[])
        {
            zzasw = adatatype;
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
            zzasZ = i;
            return this;
        }

        public Builder zza(zzn zzn1)
        {
            zzasY = zzn1;
            return this;
        }

        public Builder()
        {
            zzasw = new DataType[0];
            zzasZ = 10;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzaa();
    private final int mVersionCode;
    private final List zzapW;
    private final zzn zzasY;
    private final int zzasZ;
    private final zzoj zzasb;

    StartBleScanRequest(int i, List list, IBinder ibinder, int j, IBinder ibinder1)
    {
        mVersionCode = i;
        zzapW = list;
        zzasY = zzn.zza.zzbM(ibinder);
        zzasZ = j;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder1);
    }

    private StartBleScanRequest(Builder builder)
    {
        this(((List) (zzmj.zzb(Builder.zza(builder)))), Builder.zzb(builder), Builder.zzc(builder), null);
    }


    public StartBleScanRequest(StartBleScanRequest startblescanrequest, zzoj zzoj1)
    {
        this(startblescanrequest.zzapW, startblescanrequest.zzasY, startblescanrequest.zzasZ, zzoj1);
    }

    public StartBleScanRequest(List list, zzn zzn1, int i, zzoj zzoj1)
    {
        mVersionCode = 4;
        zzapW = list;
        zzasY = zzn1;
        zzasZ = i;
        zzasb = zzoj1;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getDataTypes()
    {
        return Collections.unmodifiableList(zzapW);
    }

    public int getTimeoutSecs()
    {
        return zzasZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("dataTypes", zzapW).zzg("timeoutSecs", Integer.valueOf(zzasZ)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzaa.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasb == null)
        {
            return null;
        } else
        {
            return zzasb.asBinder();
        }
    }

    public IBinder zztk()
    {
        return zzasY.asBinder();
    }

}

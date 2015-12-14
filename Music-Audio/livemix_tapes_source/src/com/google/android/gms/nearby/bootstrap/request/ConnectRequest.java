// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.nearby.bootstrap.Device;

// Referenced classes of package com.google.android.gms.nearby.bootstrap.request:
//            zza

public class ConnectRequest
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    private final String description;
    private final String name;
    private final long timeoutMillis;
    final int versionCode;
    private final byte zzaJa;
    private final Device zzaJb;
    private final zzow zzaJc;
    private final zzox zzaJd;
    private final zzoy zzaJe;
    private final String zzaJf;
    private final byte zzaJg;

    ConnectRequest(int i, Device device, String s, String s1, byte byte0, long l, 
            String s2, byte byte1, IBinder ibinder, IBinder ibinder1, IBinder ibinder2)
    {
        versionCode = i;
        zzaJb = (Device)zzx.zzv(device);
        name = zzx.zzcs(s);
        description = (String)zzx.zzv(s1);
        zzaJa = byte0;
        timeoutMillis = l;
        zzaJg = byte1;
        zzaJf = s2;
        zzx.zzv(ibinder);
        zzaJc = com.google.android.gms.internal.zzow.zza.zzcZ(ibinder);
        zzx.zzv(ibinder1);
        zzaJd = com.google.android.gms.internal.zzox.zza.zzda(ibinder1);
        zzx.zzv(ibinder2);
        zzaJe = com.google.android.gms.internal.zzoy.zza.zzdb(ibinder2);
    }

    public int describeContents()
    {
        zza zza1 = CREATOR;
        return 0;
    }

    public String getDescription()
    {
        return description;
    }

    public String getName()
    {
        return name;
    }

    public String getToken()
    {
        return zzaJf;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza zza1 = CREATOR;
        zza.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzaJe == null)
        {
            return null;
        } else
        {
            return zzaJe.asBinder();
        }
    }

    public byte zzyc()
    {
        return zzaJa;
    }

    public Device zzye()
    {
        return zzaJb;
    }

    public long zzyf()
    {
        return timeoutMillis;
    }

    public byte zzyg()
    {
        return zzaJg;
    }

    public IBinder zzyh()
    {
        if (zzaJc == null)
        {
            return null;
        } else
        {
            return zzaJc.asBinder();
        }
    }

    public IBinder zzyi()
    {
        if (zzaJd == null)
        {
            return null;
        } else
        {
            return zzaJd.asBinder();
        }
    }

}

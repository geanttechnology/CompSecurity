// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zznl;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzh

public final class Device
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int mVersionCode;
    private final int zzUS;
    private final String zzWs;
    private final String zzanY;
    private final String zzanZ;
    private final String zzaoa;
    private final int zzaob;

    Device(int i, String s, String s1, String s2, String s3, int j, int k)
    {
        mVersionCode = i;
        zzanY = (String)zzx.zzv(s);
        zzanZ = (String)zzx.zzv(s1);
        zzWs = "";
        zzaoa = (String)zzx.zzv(s3);
        zzUS = j;
        zzaob = k;
    }

    public Device(String s, String s1, String s2, int i)
    {
        this(s, s1, "", s2, i, 0);
    }

    public Device(String s, String s1, String s2, String s3, int i, int j)
    {
        this(1, s, s1, "", s3, i, j);
    }

    public static Device getLocalDevice(Context context)
    {
        int i = zzmi.zzaw(context);
        context = zzas(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, android.os.Build.VERSION.RELEASE, context, i, 2);
    }

    private boolean zza(Device device)
    {
        return zzw.equal(zzanY, device.zzanY) && zzw.equal(zzanZ, device.zzanZ) && zzw.equal(zzWs, device.zzWs) && zzw.equal(zzaoa, device.zzaoa) && zzUS == device.zzUS && zzaob == device.zzaob;
    }

    private static String zzas(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zzrJ()
    {
        return zzrI() == 1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof Device) && zza((Device)obj);
    }

    public String getManufacturer()
    {
        return zzanY;
    }

    public String getModel()
    {
        return zzanZ;
    }

    String getStreamIdentifier()
    {
        return String.format("%s:%s:%s", new Object[] {
            zzanY, zzanZ, zzaoa
        });
    }

    public int getType()
    {
        return zzUS;
    }

    public String getUid()
    {
        return zzaoa;
    }

    public String getVersion()
    {
        return zzWs;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanY, zzanZ, zzWs, zzaoa, Integer.valueOf(zzUS)
        });
    }

    public String toString()
    {
        return String.format("Device{%s:%s:%s:%s}", new Object[] {
            getStreamIdentifier(), zzWs, Integer.valueOf(zzUS), Integer.valueOf(zzaob)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public int zzrI()
    {
        return zzaob;
    }

    public String zzrK()
    {
        if (zzrJ())
        {
            return zzaoa;
        } else
        {
            return zznl.zzcV(zzaoa);
        }
    }

}

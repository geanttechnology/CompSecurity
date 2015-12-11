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
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zzom;

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
    private final int zzWJ;
    private final String zzYk;
    private final int zzaqA;
    private final String zzaqx;
    private final String zzaqy;
    private final String zzaqz;

    Device(int i, String s, String s1, String s2, String s3, int j, int k)
    {
        mVersionCode = i;
        zzaqx = (String)zzx.zzw(s);
        zzaqy = (String)zzx.zzw(s1);
        zzYk = "";
        zzaqz = (String)zzx.zzw(s3);
        zzWJ = j;
        zzaqA = k;
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
        int i = zznk.zzax(context);
        context = zzat(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, android.os.Build.VERSION.RELEASE, context, i, 2);
    }

    private boolean zza(Device device)
    {
        return zzw.equal(zzaqx, device.zzaqx) && zzw.equal(zzaqy, device.zzaqy) && zzw.equal(zzYk, device.zzYk) && zzw.equal(zzaqz, device.zzaqz) && zzWJ == device.zzWJ && zzaqA == device.zzaqA;
    }

    private static String zzat(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zzsv()
    {
        return zzsu() == 1;
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
        return zzaqx;
    }

    public String getModel()
    {
        return zzaqy;
    }

    String getStreamIdentifier()
    {
        return String.format("%s:%s:%s", new Object[] {
            zzaqx, zzaqy, zzaqz
        });
    }

    public int getType()
    {
        return zzWJ;
    }

    public String getUid()
    {
        return zzaqz;
    }

    public String getVersion()
    {
        return zzYk;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaqx, zzaqy, zzYk, zzaqz, Integer.valueOf(zzWJ)
        });
    }

    public String toString()
    {
        return String.format("Device{%s:%s:%s:%s}", new Object[] {
            getStreamIdentifier(), zzYk, Integer.valueOf(zzWJ), Integer.valueOf(zzaqA)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public int zzsu()
    {
        return zzaqA;
    }

    public String zzsw()
    {
        if (zzsv())
        {
            return zzaqz;
        } else
        {
            return zzom.zzcU(zzaqz);
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zza

public final class Application
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    public static final Application zzans;
    private final int mVersionCode;
    private final String zzOZ;
    private final String zzWs;
    private final String zzant;

    Application(int i, String s, String s1, String s2)
    {
        mVersionCode = i;
        zzOZ = (String)zzx.zzv(s);
        zzWs = "";
        zzant = s2;
    }

    public Application(String s, String s1, String s2)
    {
        this(1, s, "", s2);
    }

    private boolean zza(Application application)
    {
        return zzOZ.equals(application.zzOZ) && zzw.equal(zzWs, application.zzWs) && zzw.equal(zzant, application.zzant);
    }

    public static Application zzcQ(String s)
    {
        return zze(s, null, null);
    }

    public static Application zze(String s, String s1, String s2)
    {
        if ("com.google.android.gms".equals(s))
        {
            return zzans;
        } else
        {
            return new Application(s, s1, s2);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof Application) && zza((Application)obj);
    }

    public String getPackageName()
    {
        return zzOZ;
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
            zzOZ, zzWs, zzant
        });
    }

    public String toString()
    {
        return String.format("Application{%s:%s:%s}", new Object[] {
            zzOZ, zzWs, zzant
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.fitness.data.zza.zza(this, parcel, i);
    }

    public String zzrt()
    {
        return zzant;
    }

    static 
    {
        zzans = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    }
}

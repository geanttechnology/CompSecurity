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
    public static final Application zzapS;
    private final int mVersionCode;
    private final String zzQe;
    private final String zzYk;
    private final String zzapT;

    Application(int i, String s, String s1, String s2)
    {
        mVersionCode = i;
        zzQe = (String)zzx.zzw(s);
        zzYk = "";
        zzapT = s2;
    }

    public Application(String s, String s1, String s2)
    {
        this(1, s, "", s2);
    }

    private boolean zza(Application application)
    {
        return zzQe.equals(application.zzQe) && zzw.equal(zzYk, application.zzYk) && zzw.equal(zzapT, application.zzapT);
    }

    public static Application zzcP(String s)
    {
        return zze(s, null, null);
    }

    public static Application zze(String s, String s1, String s2)
    {
        if ("com.google.android.gms".equals(s))
        {
            return zzapS;
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
        return zzQe;
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
            zzQe, zzYk, zzapT
        });
    }

    public String toString()
    {
        return String.format("Application{%s:%s:%s}", new Object[] {
            zzQe, zzYk, zzapT
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.fitness.data.zza.zza(this, parcel, i);
    }

    public String zzsf()
    {
        return zzapT;
    }

    static 
    {
        zzapS = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    }
}

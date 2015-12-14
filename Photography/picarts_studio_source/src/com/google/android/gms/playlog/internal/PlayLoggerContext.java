// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            zze

public class PlayLoggerContext
    implements SafeParcelable
{

    public static final zze CREATOR = new zze();
    public final String packageName;
    public final int versionCode;
    public final int zzaRR;
    public final int zzaRS;
    public final String zzaRT;
    public final String zzaRU;
    public final boolean zzaRV;
    public final String zzaRW;
    public final boolean zzaRX;
    public final int zzaRY;

    public PlayLoggerContext(int i, String s, int j, int k, String s1, String s2, boolean flag, 
            String s3, boolean flag1, int l)
    {
        versionCode = i;
        packageName = s;
        zzaRR = j;
        zzaRS = k;
        zzaRT = s1;
        zzaRU = s2;
        zzaRV = flag;
        zzaRW = s3;
        zzaRX = flag1;
        zzaRY = l;
    }

    public PlayLoggerContext(String s, int i, int j, String s1, String s2, boolean flag)
    {
        versionCode = 1;
        packageName = (String)zzx.zzw(s);
        zzaRR = i;
        zzaRS = j;
        zzaRW = null;
        zzaRT = s1;
        zzaRU = s2;
        zzaRV = flag;
        zzaRX = false;
        zzaRY = 0;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof PlayLoggerContext)
            {
                if (versionCode != ((PlayLoggerContext) (obj = (PlayLoggerContext)obj)).versionCode || !packageName.equals(((PlayLoggerContext) (obj)).packageName) || zzaRR != ((PlayLoggerContext) (obj)).zzaRR || zzaRS != ((PlayLoggerContext) (obj)).zzaRS || !zzw.equal(zzaRW, ((PlayLoggerContext) (obj)).zzaRW) || !zzw.equal(zzaRT, ((PlayLoggerContext) (obj)).zzaRT) || !zzw.equal(zzaRU, ((PlayLoggerContext) (obj)).zzaRU) || zzaRV != ((PlayLoggerContext) (obj)).zzaRV || zzaRX != ((PlayLoggerContext) (obj)).zzaRX || zzaRY != ((PlayLoggerContext) (obj)).zzaRY)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(versionCode), packageName, Integer.valueOf(zzaRR), Integer.valueOf(zzaRS), zzaRW, zzaRT, zzaRU, Boolean.valueOf(zzaRV), Boolean.valueOf(zzaRX), Integer.valueOf(zzaRY)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("PlayLoggerContext[");
        stringbuilder.append("versionCode=").append(versionCode).append(',');
        stringbuilder.append("package=").append(packageName).append(',');
        stringbuilder.append("packageVersionCode=").append(zzaRR).append(',');
        stringbuilder.append("logSource=").append(zzaRS).append(',');
        stringbuilder.append("logSourceName=").append(zzaRW).append(',');
        stringbuilder.append("uploadAccount=").append(zzaRT).append(',');
        stringbuilder.append("loggingId=").append(zzaRU).append(',');
        stringbuilder.append("logAndroidId=").append(zzaRV).append(',');
        stringbuilder.append("isAnonymous=").append(zzaRX).append(',');
        stringbuilder.append("qosTier=").append(zzaRY);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

}

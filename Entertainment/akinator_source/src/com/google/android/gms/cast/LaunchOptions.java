// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Parcel;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.cast:
//            zzd

public class LaunchOptions
    implements SafeParcelable
{
    public static final class Builder
    {

        private LaunchOptions zzVU;

        public LaunchOptions build()
        {
            return zzVU;
        }

        public Builder setLocale(Locale locale)
        {
            zzVU.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean flag)
        {
            zzVU.setRelaunchIfRunning(flag);
            return this;
        }

        public Builder()
        {
            zzVU = new LaunchOptions();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    private final int mVersionCode;
    private boolean zzVS;
    private String zzVT;

    public LaunchOptions()
    {
        this(1, false, zzf.zzb(Locale.getDefault()));
    }

    LaunchOptions(int i, boolean flag, String s)
    {
        mVersionCode = i;
        zzVS = flag;
        zzVT = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof LaunchOptions))
            {
                return false;
            }
            obj = (LaunchOptions)obj;
            if (zzVS != ((LaunchOptions) (obj)).zzVS || !zzf.zza(zzVT, ((LaunchOptions) (obj)).zzVT))
            {
                return false;
            }
        }
        return true;
    }

    public String getLanguage()
    {
        return zzVT;
    }

    public boolean getRelaunchIfRunning()
    {
        return zzVS;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Boolean.valueOf(zzVS), zzVT
        });
    }

    public void setLanguage(String s)
    {
        zzVT = s;
    }

    public void setRelaunchIfRunning(boolean flag)
    {
        zzVS = flag;
    }

    public String toString()
    {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[] {
            Boolean.valueOf(zzVS), zzVT
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}

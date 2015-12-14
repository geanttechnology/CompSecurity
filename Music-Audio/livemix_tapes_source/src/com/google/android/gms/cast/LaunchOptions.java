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
//            zzc

public class LaunchOptions
    implements SafeParcelable
{
    public static final class Builder
    {

        private LaunchOptions zzUd;

        public LaunchOptions build()
        {
            return zzUd;
        }

        public Builder setLocale(Locale locale)
        {
            zzUd.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean flag)
        {
            zzUd.setRelaunchIfRunning(flag);
            return this;
        }

        public Builder()
        {
            zzUd = new LaunchOptions();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    private boolean zzUb;
    private String zzUc;

    public LaunchOptions()
    {
        this(1, false, zzf.zzb(Locale.getDefault()));
    }

    LaunchOptions(int i, boolean flag, String s)
    {
        mVersionCode = i;
        zzUb = flag;
        zzUc = s;
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
            if (zzUb != ((LaunchOptions) (obj)).zzUb || !zzf.zza(zzUc, ((LaunchOptions) (obj)).zzUc))
            {
                return false;
            }
        }
        return true;
    }

    public String getLanguage()
    {
        return zzUc;
    }

    public boolean getRelaunchIfRunning()
    {
        return zzUb;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Boolean.valueOf(zzUb), zzUc
        });
    }

    public void setLanguage(String s)
    {
        zzUc = s;
    }

    public void setRelaunchIfRunning(boolean flag)
    {
        zzUb = flag;
    }

    public String toString()
    {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[] {
            Boolean.valueOf(zzUb), zzUc
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}

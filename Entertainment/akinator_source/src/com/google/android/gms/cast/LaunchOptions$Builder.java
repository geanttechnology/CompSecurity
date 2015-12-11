// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.cast:
//            LaunchOptions

public static final class zzVU
{

    private LaunchOptions zzVU;

    public LaunchOptions build()
    {
        return zzVU;
    }

    public zzVU setLocale(Locale locale)
    {
        zzVU.setLanguage(zzf.zzb(locale));
        return this;
    }

    public age setRelaunchIfRunning(boolean flag)
    {
        zzVU.setRelaunchIfRunning(flag);
        return this;
    }

    public ()
    {
        zzVU = new LaunchOptions();
    }
}

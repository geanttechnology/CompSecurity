// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.cast:
//            LaunchOptions

public static final class zzUd
{

    private LaunchOptions zzUd;

    public LaunchOptions build()
    {
        return zzUd;
    }

    public zzUd setLocale(Locale locale)
    {
        zzUd.setLanguage(zzf.zzb(locale));
        return this;
    }

    public age setRelaunchIfRunning(boolean flag)
    {
        zzUd.setRelaunchIfRunning(flag);
        return this;
    }

    public ()
    {
        zzUd = new LaunchOptions();
    }
}

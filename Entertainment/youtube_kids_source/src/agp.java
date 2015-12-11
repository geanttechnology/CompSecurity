// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.DisplayMetrics;
import com.google.android.speech.params.DeviceParams;
import java.util.Locale;

public final class agp
    implements DeviceParams
{

    public agp()
    {
    }

    public final String getApplicationVersion()
    {
        return "1";
    }

    public final String getDeviceCountry()
    {
        return Locale.getDefault().getCountry();
    }

    public final DisplayMetrics getDisplayMetrics()
    {
        return null;
    }

    public final String getSearchDomainCountryCode()
    {
        return getDeviceCountry();
    }

    public final String getUserAgent()
    {
        return "com.google.android.apps.youtube.kids";
    }
}

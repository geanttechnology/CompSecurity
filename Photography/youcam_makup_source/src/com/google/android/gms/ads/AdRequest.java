// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.at;
import java.util.Date;
import java.util.Set;

public final class AdRequest
{

    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final at ks;

    private AdRequest(Builder builder)
    {
        ks = new at(Builder.a(builder));
    }

    AdRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    at T()
    {
        return ks;
    }

    public Date getBirthday()
    {
        return ks.getBirthday();
    }

    public String getContentUrl()
    {
        return ks.getContentUrl();
    }

    public Bundle getCustomEventExtrasBundle(Class class1)
    {
        return ks.getCustomEventExtrasBundle(class1);
    }

    public int getGender()
    {
        return ks.getGender();
    }

    public Set getKeywords()
    {
        return ks.getKeywords();
    }

    public Location getLocation()
    {
        return ks.getLocation();
    }

    public NetworkExtras getNetworkExtras(Class class1)
    {
        return ks.getNetworkExtras(class1);
    }

    public Bundle getNetworkExtrasBundle(Class class1)
    {
        return ks.getNetworkExtrasBundle(class1);
    }

    public boolean isTestDevice(Context context)
    {
        return ks.isTestDevice(context);
    }

    static 
    {
        DEVICE_ID_EMULATOR = at.DEVICE_ID_EMULATOR;
    }

    /* member class not found */
    class Builder {}

}

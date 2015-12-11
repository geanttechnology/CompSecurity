// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.af;
import java.util.Date;
import java.util.Set;

public final class AdRequest
{
    public static final class Builder
    {

        private final com.google.android.gms.internal.af.a dX = new com.google.android.gms.internal.af.a();

        static com.google.android.gms.internal.af.a a(Builder builder)
        {
            return builder.dX;
        }

        public Builder addKeyword(String s)
        {
            dX.g(s);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkextras)
        {
            dX.a(networkextras);
            return this;
        }

        public Builder addTestDevice(String s)
        {
            dX.h(s);
            return this;
        }

        public AdRequest build()
        {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date date)
        {
            dX.a(date);
            return this;
        }

        public Builder setGender(int i)
        {
            dX.d(i);
            return this;
        }

        public Builder setLocation(Location location)
        {
            dX.a(location);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean flag)
        {
            dX.e(flag);
            return this;
        }

        public Builder()
        {
        }
    }


    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final af dW;

    private AdRequest(Builder builder)
    {
        dW = new af(Builder.a(builder));
    }


    public Date getBirthday()
    {
        return dW.getBirthday();
    }

    public int getGender()
    {
        return dW.getGender();
    }

    public Set getKeywords()
    {
        return dW.getKeywords();
    }

    public Location getLocation()
    {
        return dW.getLocation();
    }

    public NetworkExtras getNetworkExtras(Class class1)
    {
        return dW.getNetworkExtras(class1);
    }

    public boolean isTestDevice(Context context)
    {
        return dW.isTestDevice(context);
    }

    af v()
    {
        return dW;
    }

    static 
    {
        DEVICE_ID_EMULATOR = af.DEVICE_ID_EMULATOR;
    }
}

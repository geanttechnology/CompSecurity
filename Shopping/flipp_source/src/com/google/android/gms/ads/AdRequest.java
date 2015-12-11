// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.o;
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
    private final o dW;

    private AdRequest(Builder builder)
    {
        dW = new o(Builder.a(builder));
    }

    AdRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final Date getBirthday()
    {
        return dW.b;
    }

    public final int getGender()
    {
        return dW.c;
    }

    public final Set getKeywords()
    {
        return dW.d;
    }

    public final Location getLocation()
    {
        return dW.e;
    }

    public final NetworkExtras getNetworkExtras(Class class1)
    {
        return dW.a(class1);
    }

    public final boolean isTestDevice(Context context)
    {
        return dW.a(context);
    }

    final o v()
    {
        return dW;
    }

    static 
    {
        DEVICE_ID_EMULATOR = o.a;
    }

    private class Builder
    {

        private final p dX = new p();

        static p a(Builder builder)
        {
            return builder.dX;
        }

        public final Builder addKeyword(String s)
        {
            dX.a(s);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkextras)
        {
            dX.a(networkextras);
            return this;
        }

        public final Builder addTestDevice(String s)
        {
            dX.b(s);
            return this;
        }

        public final AdRequest build()
        {
            return new AdRequest(this, null);
        }

        public final Builder setBirthday(Date date)
        {
            dX.d = date;
            return this;
        }

        public final Builder setGender(int i)
        {
            dX.e = i;
            return this;
        }

        public final Builder setLocation(Location location)
        {
            dX.f = location;
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean flag)
        {
            dX.a(flag);
            return this;
        }

        public Builder()
        {
        }
    }

}

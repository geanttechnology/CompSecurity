// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.internal.as;
import java.util.Date;

public final class AdRequest
{
    public static final class Builder
    {

        private final com.google.android.gms.internal.as.a kq = new com.google.android.gms.internal.as.a();

        static com.google.android.gms.internal.as.a a(Builder builder)
        {
            return builder.kq;
        }

        public Builder addKeyword(String s)
        {
            kq.g(s);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class class1, Bundle bundle)
        {
            kq.a(class1, bundle);
            return this;
        }

        public Builder addTestDevice(String s)
        {
            kq.h(s);
            return this;
        }

        public AdRequest build()
        {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date date)
        {
            kq.a(date);
            return this;
        }

        public Builder setGender(int i)
        {
            kq.d(i);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean flag)
        {
            kq.g(flag);
            return this;
        }

        public Builder()
        {
        }
    }


    public static final String DEVICE_ID_EMULATOR;
    private final as kp;

    private AdRequest(Builder builder)
    {
        kp = new as(Builder.a(builder));
    }


    as O()
    {
        return kp;
    }

    static 
    {
        DEVICE_ID_EMULATOR = as.DEVICE_ID_EMULATOR;
    }
}

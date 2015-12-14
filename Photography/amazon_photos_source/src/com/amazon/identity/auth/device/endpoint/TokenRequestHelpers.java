// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;

import android.os.Bundle;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import java.util.Locale;

public final class TokenRequestHelpers
{
    public static final class PROTOCOL extends Enum
    {

        private static final PROTOCOL $VALUES[];
        public static final PROTOCOL HTTPS;

        public static PROTOCOL valueOf(String s)
        {
            return (PROTOCOL)Enum.valueOf(com/amazon/identity/auth/device/endpoint/TokenRequestHelpers$PROTOCOL, s);
        }

        public static PROTOCOL[] values()
        {
            return (PROTOCOL[])$VALUES.clone();
        }

        public String toString()
        {
            return (new StringBuilder()).append(super.toString().toLowerCase(Locale.US)).append("://").toString();
        }

        static 
        {
            HTTPS = new PROTOCOL("HTTPS", 0);
            $VALUES = (new PROTOCOL[] {
                HTTPS
            });
        }

        private PROTOCOL(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/endpoint/TokenRequestHelpers.getName();

    private TokenRequestHelpers()
    {
    }

    public static String getRequestUrlSchemeAndAuthority(Bundle bundle, PROTOCOL protocol, String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = TAG;
            s1 = s;
            if (bundle != null)
            {
                s1 = AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(bundle);
            }
        }
        if (s1 == null)
        {
            bundle = TAG;
            bundle = EnvironmentUtils.getInstance().getDefaultAmazonDomain();
        } else
        {
            bundle = EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(s1);
        }
        return (new StringBuilder()).append(protocol.toString()).append(bundle).toString();
    }

}

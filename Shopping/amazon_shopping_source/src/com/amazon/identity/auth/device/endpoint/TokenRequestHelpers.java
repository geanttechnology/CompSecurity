// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;

import android.os.Bundle;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.EnvironmentUtils;
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
            HTTPS = new PROTOCOL("HTTPS");
            $VALUES = (new PROTOCOL[] {
                HTTPS
            });
        }

        private PROTOCOL(String s)
        {
            super(s, 0);
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/endpoint/TokenRequestHelpers.getName();

    private TokenRequestHelpers()
    {
    }

    static String getRequestUrlAuthority(Bundle bundle, String s)
    {
        String s1 = s;
        String s2 = s1;
        if (s == null)
        {
            s = TAG;
            s2 = s1;
            if (bundle != null)
            {
                s2 = AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(bundle);
            }
        }
        if (s2 == null)
        {
            bundle = TAG;
            return EnvironmentUtils.getInstance().getDefaultAmazonDomain();
        } else
        {
            return EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(s2);
        }
    }

    public static String getRequestUrlSchemeAndAuthority(Bundle bundle, PROTOCOL protocol, String s)
    {
        bundle = getRequestUrlAuthority(bundle, s);
        return (new StringBuilder()).append(protocol.toString()).append(bundle).toString();
    }

}

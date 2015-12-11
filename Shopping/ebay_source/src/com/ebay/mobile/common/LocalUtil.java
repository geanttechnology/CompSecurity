// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.content.Context;
import com.ebay.nautilus.domain.EbayCountry;

public class LocalUtil
{

    public LocalUtil()
    {
    }

    public static int getPudoAvailabilitiesResourceForCountry(EbayCountry ebaycountry)
    {
        if (ebaycountry == null)
        {
            throw new IllegalArgumentException("country must not be null");
        }
        int i = 0x7f080006;
        if ("GB".equals(ebaycountry.getCountryCode()))
        {
            i = 0x7f080005;
        }
        return i;
    }

    public static int getPudoResourceForCountry(EbayCountry ebaycountry)
    {
        if (ebaycountry == null)
        {
            throw new IllegalArgumentException("country must not be null");
        }
        int i = 0x7f07023d;
        if ("GB".equals(ebaycountry.getCountryCode()))
        {
            i = 0x7f0708c0;
        }
        return i;
    }

    public static String getPudoWithinDistanceStringForCountry(Context context, EbayCountry ebaycountry, double d)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context must not be null");
        }
        if (ebaycountry == null)
        {
            throw new IllegalArgumentException("country must not be null");
        }
        String s = ebaycountry.getCountryCode();
        if ((int)d == 1)
        {
            ebaycountry = context.getString(0x7f070bc3);
            if ("GB".equals(s))
            {
                ebaycountry = context.getString(0x7f070bc4);
            }
        } else
        {
            ebaycountry = context.getString(0x7f070bc5, new Object[] {
                Double.valueOf(d)
            });
            if ("GB".equals(s))
            {
                return context.getString(0x7f070bc6, new Object[] {
                    Double.valueOf(d)
                });
            }
        }
        return ebaycountry;
    }
}

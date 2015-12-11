// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import java.util.Locale;

public final class DcsState
{

    public final String country;
    public final EbayCountry ebayCountry;
    public final boolean isGbh;
    public final String language;
    public final Locale locale;
    public final int rolloutThreshold;
    public final EbaySite site;
    public final String user;

    public DcsState(EbayCountry ebaycountry, String s, int i)
    {
        boolean flag = false;
        super();
        ebayCountry = ebaycountry;
        if (ebaycountry != null)
        {
            site = ebaycountry.site;
            country = ebaycountry.getCountryCode();
            language = ebaycountry.getSiteLanguageCode();
            if (!ebaycountry.isSite())
            {
                flag = true;
            }
            isGbh = flag;
        } else
        {
            site = EbaySite.US;
            country = null;
            language = null;
            isGbh = false;
        }
        rolloutThreshold = i;
        locale = Locale.getDefault();
        if (s == null)
        {
            user = s;
        } else
        {
            user = s.toLowerCase(locale);
        }
        if (i < 0 || i > 100)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("threshold ").append(i).append(" must be in the range [0, 100]").toString());
        } else
        {
            return;
        }
    }

    private DcsState(EbayCountry ebaycountry, String s, String s1, boolean flag, String s2, int i)
    {
        ebayCountry = ebaycountry;
        if (ebaycountry != null)
        {
            ebaycountry = ebaycountry.site;
        } else
        {
            ebaycountry = EbaySite.US;
        }
        site = ebaycountry;
        country = s;
        language = s1;
        isGbh = flag;
        user = s2;
        rolloutThreshold = i;
        locale = Locale.getDefault();
    }

    private DcsState(DcsState dcsstate, Locale locale1)
    {
        ebayCountry = dcsstate.ebayCountry;
        site = dcsstate.site;
        country = dcsstate.country;
        language = dcsstate.language;
        isGbh = dcsstate.isGbh;
        user = dcsstate.user;
        rolloutThreshold = dcsstate.rolloutThreshold;
        locale = locale1;
    }

    public DcsState setCountry(EbayCountry ebaycountry)
    {
        if (ebayCountry == ebaycountry)
        {
            return this;
        }
        String s;
        String s1;
        boolean flag;
        if (ebaycountry != null)
        {
            s = ebaycountry.getCountryCode();
            s1 = ebaycountry.getSiteLanguageCode();
            if (!ebaycountry.isSite())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            s = null;
            s1 = null;
            flag = false;
        }
        return new DcsState(ebaycountry, s, s1, flag, user, rolloutThreshold);
    }

    public DcsState setLocale(Locale locale1)
    {
        if (locale.equals(locale1))
        {
            return this;
        } else
        {
            return new DcsState(this, locale1);
        }
    }

    public DcsState setRolloutThreshold(int i)
    {
        if (i == rolloutThreshold)
        {
            return this;
        } else
        {
            return new DcsState(ebayCountry, country, language, isGbh, user, i);
        }
    }

    public DcsState setUser(String s)
    {
        if (s != null)
        {
            if (s.length() == 0)
            {
                throw new IllegalArgumentException("userId must not be empty");
            }
            s = s.toLowerCase(locale);
        }
        if (TextUtils.equals(s, user))
        {
            return this;
        } else
        {
            return new DcsState(ebayCountry, country, language, isGbh, s, rolloutThreshold);
        }
    }
}

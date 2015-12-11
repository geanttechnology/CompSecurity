// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.util.ObjectUtil;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchConfigurationManager, SearchRealm

public class SearchConfiguration
{
    public static final class Builder
    {

        private String id;
        private SearchRealm realm;
        private Map realms;

        public SearchConfiguration build()
        {
            return new SearchConfiguration(this);
        }

        public String getId()
        {
            return id;
        }

        public SearchRealm getRealm()
        {
            return realm;
        }

        public Map getRealms()
        {
            return realms;
        }

        public Builder setId(String s)
        {
            id = s;
            return this;
        }

        public Builder setRealm(SearchRealm searchrealm)
        {
            realm = searchrealm;
            return this;
        }

        public Builder setRealms(Map map)
        {
            realms = map;
            return this;
        }




        public Builder()
        {
        }
    }


    private final String id;
    private volatile SearchRealm realm;
    private final Map realms;

    private SearchConfiguration(Builder builder)
    {
        id = builder.id;
        realms = builder.realms;
        realm = builder.realm;
    }


    public static SearchConfiguration getConfiguration()
    {
        return SearchConfigurationManager.getInstance().getConfiguration();
    }

    private SearchRealm getFirstRealm()
    {
        Iterator iterator = realms.entrySet().iterator();
        if (iterator.hasNext())
        {
            return (SearchRealm)((java.util.Map.Entry)iterator.next()).getValue();
        } else
        {
            return null;
        }
    }

    public SearchRealm getDefaultRealm()
    {
        return getRealmForLocale(Locale.getDefault());
    }

    public String getId()
    {
        return id;
    }

    public SearchRealm getRealm()
    {
        this;
        JVM INSTR monitorenter ;
        SearchRealm searchrealm;
        if (realm == null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        searchrealm = realm;
        this;
        JVM INSTR monitorexit ;
        return searchrealm;
        realm = getDefaultRealm();
        searchrealm = realm;
        this;
        JVM INSTR monitorexit ;
        return searchrealm;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public SearchRealm getRealm(String s)
    {
        return (SearchRealm)realms.get(s);
    }

    public SearchRealm getRealmById(String s)
    {
        return (SearchRealm)realms.get(s);
    }

    public SearchRealm getRealmByMarketplaceId(int i)
    {
        if (realms == null)
        {
            return null;
        }
        for (Iterator iterator = realms.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getValue() != null && ((SearchRealm)entry.getValue()).getMarketplaceId() == i)
            {
                return (SearchRealm)entry.getValue();
            }
        }

        return null;
    }

    public SearchRealm getRealmByObfuscatedMarketplaceId(String s)
    {
        if (realms == null)
        {
            return null;
        }
        for (Iterator iterator = realms.entrySet().iterator(); iterator.hasNext();)
        {
            SearchRealm searchrealm = (SearchRealm)((java.util.Map.Entry)iterator.next()).getValue();
            if (searchrealm != null && ObjectUtil.isEqual(s, searchrealm.getObfuscatedMarketplaceId()))
            {
                return searchrealm;
            }
        }

        return null;
    }

    public SearchRealm getRealmForLocale(Locale locale)
    {
        if (locale == null)
        {
            locale = getRealmById("us");
            if (locale != null)
            {
                return locale;
            } else
            {
                return getFirstRealm();
            }
        }
        SearchRealm searchrealm = null;
        int k = -1;
        Iterator iterator = realms.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SearchRealm searchrealm1 = (SearchRealm)((java.util.Map.Entry)iterator.next()).getValue();
            int j = 0;
            int i = j;
            if (searchrealm1.getLocale() != null)
            {
                i = j;
                if (searchrealm1.getLocale().equals(locale.toString()))
                {
                    i = 0 + 8;
                }
            }
            j = i;
            if (searchrealm1.getCountry() != null)
            {
                j = i;
                if (searchrealm1.getCountry().equals(locale.getCountry()))
                {
                    j = i + 4;
                }
            }
            i = j;
            if (searchrealm1.getLanguage() != null)
            {
                i = j;
                if (searchrealm1.getLanguage().equals(locale.getLanguage()))
                {
                    i = j + 2;
                }
            }
            j = i;
            if (searchrealm1.getVariant() != null)
            {
                j = i;
                if (searchrealm1.getVariant().equals(locale.getVariant()))
                {
                    j = i + 1;
                }
            }
            if (j > 1 && j > k)
            {
                searchrealm = searchrealm1;
                k = j;
            }
        } while (true);
        locale = searchrealm;
        if (searchrealm == null)
        {
            locale = getRealmById("us");
        }
        if (locale == null)
        {
            locale = getFirstRealm();
        }
        return locale;
    }

    public Map getRealms()
    {
        return realms;
    }

    public void setRealm(SearchRealm searchrealm)
    {
        this;
        JVM INSTR monitorenter ;
        realm = searchrealm;
        this;
        JVM INSTR monitorexit ;
        return;
        searchrealm;
        this;
        JVM INSTR monitorexit ;
        throw searchrealm;
    }

    public void setRealmId(String s)
    {
        setRealm(getRealmById(s));
    }
}

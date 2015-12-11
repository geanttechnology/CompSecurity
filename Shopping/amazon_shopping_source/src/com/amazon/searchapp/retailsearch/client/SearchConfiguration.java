// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

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

        public Builder setId(String s)
        {
            id = s;
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

    public SearchRealm getDefaultRealm()
    {
        return getRealmForLocale(Locale.getDefault());
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

    public SearchRealm getRealmById(String s)
    {
        return (SearchRealm)realms.get(s);
    }

    public SearchRealm getRealmForLocale(Locale locale)
    {
        SearchRealm searchrealm = null;
        if (locale == null)
        {
            return getRealmById("us");
        }
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
        if (searchrealm != null)
        {
            return searchrealm;
        } else
        {
            return getRealmById("us");
        }
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
}

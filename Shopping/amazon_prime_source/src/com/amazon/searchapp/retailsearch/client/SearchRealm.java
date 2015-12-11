// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.io.Serializable;

public final class SearchRealm
    implements Serializable
{
    public static final class Builder
    {

        private String completionServiceUrl;
        private String encodingParam;
        private String encodingValue;
        private String id;
        private String inputEncoding;
        private String locale;
        private int marketplaceId;
        private String obfuscatedMarketplaceId;
        private String searchServiceUrl;
        private String secureCompletionServiceUrl;
        private String secureSearchServiceUrl;
        private String secureSiteUrl;
        private String siteUrl;

        public SearchRealm build()
        {
            return new SearchRealm(this);
        }

        public String getCompletionServiceUrl()
        {
            return completionServiceUrl;
        }

        public String getEncodingParam()
        {
            return encodingParam;
        }

        public String getEncodingValue()
        {
            return encodingValue;
        }

        public String getId()
        {
            return id;
        }

        public String getInputEncoding()
        {
            return inputEncoding;
        }

        public String getLocale()
        {
            return locale;
        }

        public int getMarketplaceId()
        {
            return marketplaceId;
        }

        public String getObfuscatedMarketplaceId()
        {
            return obfuscatedMarketplaceId;
        }

        public String getSearchServiceUrl()
        {
            return searchServiceUrl;
        }

        public String getSecureCompletionServiceUrl()
        {
            return secureCompletionServiceUrl;
        }

        public String getSecureSearchServiceUrl()
        {
            return secureSearchServiceUrl;
        }

        public String getSecureSiteUrl()
        {
            return secureSiteUrl;
        }

        public String getSiteUrl()
        {
            return siteUrl;
        }

        public Builder setCompletionServiceUrl(String s)
        {
            completionServiceUrl = s;
            return this;
        }

        public Builder setEncodingParam(String s)
        {
            encodingParam = s;
            return this;
        }

        public Builder setEncodingValue(String s)
        {
            encodingValue = s;
            return this;
        }

        public Builder setId(String s)
        {
            id = s;
            return this;
        }

        public Builder setInputEncoding(String s)
        {
            inputEncoding = s;
            return this;
        }

        public Builder setLocale(String s)
        {
            locale = s;
            return this;
        }

        public Builder setMarketplaceId(int i)
        {
            marketplaceId = i;
            return this;
        }

        public Builder setObfuscatedMarketplaceId(String s)
        {
            obfuscatedMarketplaceId = s;
            return this;
        }

        public Builder setSearchServiceUrl(String s)
        {
            searchServiceUrl = s;
            return this;
        }

        public Builder setSecureCompletionServiceUrl(String s)
        {
            secureCompletionServiceUrl = s;
            return this;
        }

        public Builder setSecureSearchServiceUrl(String s)
        {
            secureSearchServiceUrl = s;
            return this;
        }

        public Builder setSecureSiteUrl(String s)
        {
            secureSiteUrl = s;
            return this;
        }

        public Builder setSiteUrl(String s)
        {
            siteUrl = s;
            return this;
        }













        public Builder()
        {
        }
    }


    private final String completionServiceUrl;
    private final String country;
    private final String encodingParam;
    private final String encodingValue;
    private final String id;
    private final String inputEncoding;
    private final String language;
    private final String locale;
    private final int marketplaceId;
    private final String obfuscatedMarketplaceId;
    private final String searchServiceUrl;
    private final String secureCompletionServiceUrl;
    private final String secureSearchServiceUrl;
    private final String secureSiteUrl;
    private final String siteUrl;
    private final String variant;

    private SearchRealm(Builder builder)
    {
        Object obj = null;
        super();
        id = builder.id;
        locale = builder.locale;
        marketplaceId = builder.marketplaceId;
        obfuscatedMarketplaceId = builder.obfuscatedMarketplaceId;
        String as[];
        String s;
        if (locale != null)
        {
            as = locale.split("_", -1);
        } else
        {
            as = null;
        }
        if (as != null && as.length > 0)
        {
            s = as[0];
        } else
        {
            s = null;
        }
        language = s;
        if (as != null && as.length > 1)
        {
            s = as[1];
        } else
        {
            s = null;
        }
        country = s;
        s = obj;
        if (as != null)
        {
            s = obj;
            if (as.length > 2)
            {
                s = as[2];
            }
        }
        variant = s;
        siteUrl = builder.siteUrl;
        secureSiteUrl = builder.secureSiteUrl;
        searchServiceUrl = builder.searchServiceUrl;
        secureSearchServiceUrl = builder.secureSearchServiceUrl;
        completionServiceUrl = builder.secureCompletionServiceUrl;
        secureCompletionServiceUrl = builder.secureCompletionServiceUrl;
        inputEncoding = builder.inputEncoding;
        encodingParam = builder.encodingParam;
        encodingValue = builder.encodingValue;
    }


    public String getCompletionServiceUrl()
    {
        return completionServiceUrl;
    }

    public String getCountry()
    {
        return country;
    }

    public String getEncodingParam()
    {
        return encodingParam;
    }

    public String getEncodingValue()
    {
        return encodingValue;
    }

    public String getId()
    {
        return id;
    }

    public String getInputEncoding()
    {
        return inputEncoding;
    }

    public String getLanguage()
    {
        return language;
    }

    public String getLocale()
    {
        return locale;
    }

    public int getMarketplaceId()
    {
        return marketplaceId;
    }

    public String getObfuscatedMarketplaceId()
    {
        return obfuscatedMarketplaceId;
    }

    public String getSearchServiceUrl()
    {
        return searchServiceUrl;
    }

    public String getSecureCompletionServiceUrl()
    {
        return secureCompletionServiceUrl;
    }

    public String getSecureSearchServiceUrl()
    {
        return secureSearchServiceUrl;
    }

    public String getSecureSiteUrl()
    {
        return secureSiteUrl;
    }

    public String getSiteUrl()
    {
        return siteUrl;
    }

    public String getVariant()
    {
        return variant;
    }
}

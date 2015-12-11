// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;

public class HalNetworkProvider
    implements HalParseable
{

    private String brand;
    private long companyId;
    private boolean isPremium;
    private String logoUrl;
    private String name;
    private long networkId;
    private String parentCompany;
    private String shortCode;

    public HalNetworkProvider()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (HalNetworkProvider)obj;
            if (companyId != ((HalNetworkProvider) (obj)).companyId)
            {
                return false;
            }
            if (isPremium != ((HalNetworkProvider) (obj)).isPremium)
            {
                return false;
            }
            if (networkId != ((HalNetworkProvider) (obj)).networkId)
            {
                return false;
            }
            if (brand == null ? ((HalNetworkProvider) (obj)).brand != null : !brand.equals(((HalNetworkProvider) (obj)).brand))
            {
                return false;
            }
            if (logoUrl == null ? ((HalNetworkProvider) (obj)).logoUrl != null : !logoUrl.equals(((HalNetworkProvider) (obj)).logoUrl))
            {
                return false;
            }
            if (!name.equals(((HalNetworkProvider) (obj)).name))
            {
                return false;
            }
            if (parentCompany == null ? ((HalNetworkProvider) (obj)).parentCompany != null : !parentCompany.equals(((HalNetworkProvider) (obj)).parentCompany))
            {
                return false;
            }
            if (shortCode == null ? ((HalNetworkProvider) (obj)).shortCode != null : !shortCode.equals(((HalNetworkProvider) (obj)).shortCode))
            {
                return false;
            }
        }
        return true;
    }

    public String getBrand()
    {
        return brand;
    }

    public long getCompanyId()
    {
        return companyId;
    }

    public String getLogoUrl()
    {
        return logoUrl;
    }

    public String getName()
    {
        return name;
    }

    public long getNetworkId()
    {
        return networkId;
    }

    public String getParentCompany()
    {
        return parentCompany;
    }

    public String getShortCode()
    {
        return shortCode;
    }

    public int hashCode()
    {
        int i1 = 0;
        int j1 = (int)(networkId ^ networkId >>> 32);
        int k1 = (int)(companyId ^ companyId >>> 32);
        int l1 = name.hashCode();
        int i;
        int j;
        int k;
        int l;
        if (isPremium)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (shortCode != null)
        {
            j = shortCode.hashCode();
        } else
        {
            j = 0;
        }
        if (logoUrl != null)
        {
            k = logoUrl.hashCode();
        } else
        {
            k = 0;
        }
        if (brand != null)
        {
            l = brand.hashCode();
        } else
        {
            l = 0;
        }
        if (parentCompany != null)
        {
            i1 = parentCompany.hashCode();
        }
        return ((((((j1 * 31 + k1) * 31 + l1) * 31 + i) * 31 + j) * 31 + k) * 31 + l) * 31 + i1;
    }

    public boolean isPremium()
    {
        return isPremium;
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        String s = microdatapropertyresolver.fetchOptionalString("companyId");
        if (s != null)
        {
            companyId = Long.parseLong(s);
            s = microdatapropertyresolver.fetchOptionalString("id");
            if (s != null)
            {
                networkId = Long.parseLong(s);
            }
            name = microdatapropertyresolver.fetchString("name");
            isPremium = microdatapropertyresolver.fetchBoolean("isPremium");
            shortCode = microdatapropertyresolver.fetchOptionalString("shortCode");
            logoUrl = microdatapropertyresolver.fetchOptionalString("logo");
            brand = microdatapropertyresolver.fetchOptionalString("brand");
            parentCompany = microdatapropertyresolver.fetchOptionalString("parentCompany");
        }
    }
}

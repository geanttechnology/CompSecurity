// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveResponse

public class GetAccountEndpointResponse
    implements CloudDriveResponse
{

    private String contentUrl;
    private String countryAtSignup;
    private boolean customerExists;
    private String marketplaceAtSignup;
    private String metadataUrl;
    private String region;
    private String retailUrl;

    public GetAccountEndpointResponse()
    {
    }

    public int compareTo(CloudDriveResponse clouddriveresponse)
    {
        if (clouddriveresponse != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (clouddriveresponse == this)
        {
            return 0;
        }
        if (!(clouddriveresponse instanceof GetAccountEndpointResponse))
        {
            return 1;
        }
        clouddriveresponse = (GetAccountEndpointResponse)clouddriveresponse;
        s = getContentUrl();
        s1 = clouddriveresponse.getContentUrl();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        s = getMarketplaceAtSignup();
        s1 = clouddriveresponse.getMarketplaceAtSignup();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        s = getCountryAtSignup();
        s1 = clouddriveresponse.getCountryAtSignup();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        if (!isCustomerExists() && clouddriveresponse.isCustomerExists())
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L14; else goto _L15
_L15:
        if (isCustomerExists() && !clouddriveresponse.isCustomerExists())
        {
            return 1;
        }
        s = getMetadataUrl();
        s1 = clouddriveresponse.getMetadataUrl();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        s = getRegion();
        s1 = clouddriveresponse.getRegion();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L18; else goto _L19
_L19:
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        s = getRetailUrl();
        clouddriveresponse = clouddriveresponse.getRetailUrl();
        if (s == clouddriveresponse)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L22; else goto _L23
_L23:
        if (clouddriveresponse == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)s).compareTo(clouddriveresponse);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        return 0;
_L25:
        if (!s.equals(clouddriveresponse))
        {
            int j = s.hashCode();
            int l = clouddriveresponse.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L26; else goto _L27
_L27:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveResponse)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof GetAccountEndpointResponse)
            {
                if (compareTo((GetAccountEndpointResponse)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getContentUrl()
    {
        return contentUrl;
    }

    public String getCountryAtSignup()
    {
        return countryAtSignup;
    }

    public String getMarketplaceAtSignup()
    {
        return marketplaceAtSignup;
    }

    public String getMetadataUrl()
    {
        return metadataUrl;
    }

    public String getRegion()
    {
        return region;
    }

    public String getRetailUrl()
    {
        return retailUrl;
    }

    public int hashCode()
    {
        int k1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (getContentUrl() == null)
        {
            i = 0;
        } else
        {
            i = getContentUrl().hashCode();
        }
        if (getMarketplaceAtSignup() == null)
        {
            j = 0;
        } else
        {
            j = getMarketplaceAtSignup().hashCode();
        }
        if (getCountryAtSignup() == null)
        {
            k = 0;
        } else
        {
            k = getCountryAtSignup().hashCode();
        }
        if (isCustomerExists())
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (getMetadataUrl() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getMetadataUrl().hashCode();
        }
        if (getRegion() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getRegion().hashCode();
        }
        if (getRetailUrl() != null)
        {
            k1 = getRetailUrl().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1;
    }

    public boolean isCustomerExists()
    {
        return customerExists;
    }

    public void setContentUrl(String s)
    {
        contentUrl = s;
    }

    public void setCountryAtSignup(String s)
    {
        countryAtSignup = s;
    }

    public void setCustomerExists(boolean flag)
    {
        customerExists = flag;
    }

    public void setMarketplaceAtSignup(String s)
    {
        marketplaceAtSignup = s;
    }

    public void setMetadataUrl(String s)
    {
        metadataUrl = s;
    }

    public void setRegion(String s)
    {
        region = s;
    }

    public void setRetailUrl(String s)
    {
        retailUrl = s;
    }
}

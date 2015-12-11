// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.country;

import java.io.Serializable;
import java.util.Arrays;

// Referenced classes of package com.groupon.models.country:
//            LegalDocument

public class EnabledFeatures
    implements Serializable
{

    public String activePromotion;
    public boolean addBillingRecords;
    public boolean billingRecordsAPI;
    public boolean breakdowns;
    public boolean buyAsGift;
    public String channels[];
    public boolean dealsAutocomplete;
    public boolean discussionForums;
    public boolean facebookConnect;
    public LegalDocument legalDocument;
    public boolean locationAutocomplete;
    public boolean markAsUsed;
    public boolean megamind;
    public boolean multiLanguage;
    public boolean multipleImages;
    public boolean nearby;
    public boolean newsletterOptIn;
    public boolean passwordReset;
    public boolean relevanceFeatured;
    public boolean requireCVVForBillingRecordsIds;
    public boolean requireCpf;
    public boolean search;
    public boolean subscriptions;

    public EnabledFeatures()
    {
        channels = new String[0];
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof EnabledFeatures))
            {
                return false;
            }
            obj = (EnabledFeatures)obj;
            if (addBillingRecords != ((EnabledFeatures) (obj)).addBillingRecords)
            {
                return false;
            }
            if (billingRecordsAPI != ((EnabledFeatures) (obj)).billingRecordsAPI)
            {
                return false;
            }
            if (breakdowns != ((EnabledFeatures) (obj)).breakdowns)
            {
                return false;
            }
            if (buyAsGift != ((EnabledFeatures) (obj)).buyAsGift)
            {
                return false;
            }
            if (dealsAutocomplete != ((EnabledFeatures) (obj)).dealsAutocomplete)
            {
                return false;
            }
            if (discussionForums != ((EnabledFeatures) (obj)).discussionForums)
            {
                return false;
            }
            if (facebookConnect != ((EnabledFeatures) (obj)).facebookConnect)
            {
                return false;
            }
            if (locationAutocomplete != ((EnabledFeatures) (obj)).locationAutocomplete)
            {
                return false;
            }
            if (markAsUsed != ((EnabledFeatures) (obj)).markAsUsed)
            {
                return false;
            }
            if (multiLanguage != ((EnabledFeatures) (obj)).multiLanguage)
            {
                return false;
            }
            if (multipleImages != ((EnabledFeatures) (obj)).multipleImages)
            {
                return false;
            }
            if (nearby != ((EnabledFeatures) (obj)).nearby)
            {
                return false;
            }
            if (newsletterOptIn != ((EnabledFeatures) (obj)).newsletterOptIn)
            {
                return false;
            }
            if (passwordReset != ((EnabledFeatures) (obj)).passwordReset)
            {
                return false;
            }
            if (relevanceFeatured != ((EnabledFeatures) (obj)).relevanceFeatured)
            {
                return false;
            }
            if (requireCVVForBillingRecordsIds != ((EnabledFeatures) (obj)).requireCVVForBillingRecordsIds)
            {
                return false;
            }
            if (requireCpf != ((EnabledFeatures) (obj)).requireCpf)
            {
                return false;
            }
            if (search != ((EnabledFeatures) (obj)).search)
            {
                return false;
            }
            if (megamind != ((EnabledFeatures) (obj)).megamind)
            {
                return false;
            }
            if (subscriptions != ((EnabledFeatures) (obj)).subscriptions)
            {
                return false;
            }
            if (activePromotion == null ? ((EnabledFeatures) (obj)).activePromotion != null : !activePromotion.equals(((EnabledFeatures) (obj)).activePromotion))
            {
                return false;
            }
            if (!Arrays.equals(channels, ((EnabledFeatures) (obj)).channels))
            {
                return false;
            }
            if (legalDocument == null ? ((EnabledFeatures) (obj)).legalDocument != null : !legalDocument.equals(((EnabledFeatures) (obj)).legalDocument))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int i5 = 1;
        int j5 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int k5;
        if (requireCpf)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (breakdowns)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (multipleImages)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (legalDocument != null)
        {
            l = legalDocument.hashCode();
        } else
        {
            l = 0;
        }
        if (requireCVVForBillingRecordsIds)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (multiLanguage)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (billingRecordsAPI)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (addBillingRecords)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (subscriptions)
        {
            i2 = 1;
        } else
        {
            i2 = 0;
        }
        k5 = Arrays.hashCode(channels);
        if (markAsUsed)
        {
            j2 = 1;
        } else
        {
            j2 = 0;
        }
        if (facebookConnect)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        if (passwordReset)
        {
            l2 = 1;
        } else
        {
            l2 = 0;
        }
        if (buyAsGift)
        {
            i3 = 1;
        } else
        {
            i3 = 0;
        }
        if (discussionForums)
        {
            j3 = 1;
        } else
        {
            j3 = 0;
        }
        if (nearby)
        {
            k3 = 1;
        } else
        {
            k3 = 0;
        }
        if (search)
        {
            l3 = 1;
        } else
        {
            l3 = 0;
        }
        if (megamind)
        {
            i4 = 1;
        } else
        {
            i4 = 0;
        }
        if (locationAutocomplete)
        {
            j4 = 1;
        } else
        {
            j4 = 0;
        }
        if (dealsAutocomplete)
        {
            k4 = 1;
        } else
        {
            k4 = 0;
        }
        if (relevanceFeatured)
        {
            l4 = 1;
        } else
        {
            l4 = 0;
        }
        if (!newsletterOptIn)
        {
            i5 = 0;
        }
        if (activePromotion != null)
        {
            j5 = activePromotion.hashCode();
        }
        return (((((((((((((((((((((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + k5) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31 + j4) * 31 + k4) * 31 + l4) * 31 + i5) * 31 + j5;
    }
}

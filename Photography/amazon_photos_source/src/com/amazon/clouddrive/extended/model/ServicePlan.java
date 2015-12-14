// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import java.util.Map;

// Referenced classes of package com.amazon.clouddrive.extended.model:
//            BillingSchedule, Period

public class ServicePlan
    implements Comparable
{

    private boolean available;
    private BillingSchedule billingSchedule;
    private Period contractLength;
    private boolean isPromotion;
    private String marketplaceId;
    private String planDescription;
    private String planGroupId;
    private String planId;
    private String planType;
    private String priceAttribute;
    private boolean renewable;
    private Map storageMap;

    public ServicePlan()
    {
    }

    public int compareTo(ServicePlan serviceplan)
    {
        if (serviceplan != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (serviceplan == this)
        {
            return 0;
        }
        obj = getPlanType();
        obj1 = serviceplan.getPlanType();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getPlanId();
        obj1 = serviceplan.getPlanId();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        if (!isRenewable() && serviceplan.isRenewable())
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (isRenewable() && !serviceplan.isRenewable())
        {
            return 1;
        }
        obj = getPlanDescription();
        obj1 = serviceplan.getPlanDescription();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        obj = getStorageMap();
        obj1 = serviceplan.getStorageMap();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        if (!isPromotion() && serviceplan.isPromotion())
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (isPromotion() && !serviceplan.isPromotion())
        {
            return 1;
        }
        obj = getMarketplaceId();
        obj1 = serviceplan.getMarketplaceId();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        obj = getBillingSchedule();
        obj1 = serviceplan.getBillingSchedule();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        obj = getPriceAttribute();
        obj1 = serviceplan.getPriceAttribute();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L25:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L26; else goto _L27
_L27:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        if (!isAvailable() && serviceplan.isAvailable())
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L29:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L30; else goto _L31
_L31:
        if (isAvailable() && !serviceplan.isAvailable())
        {
            return 1;
        }
        obj = getContractLength();
        obj1 = serviceplan.getContractLength();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L33; else goto _L32
_L32:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L34
_L34:
        obj = getPlanGroupId();
        serviceplan = serviceplan.getPlanGroupId();
        if (obj == serviceplan)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L33:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L34; else goto _L35
_L35:
        if (serviceplan == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L37; else goto _L36
_L36:
        k = ((Comparable)obj).compareTo(serviceplan);
        i = k;
        if (k != 0) goto _L6; else goto _L38
_L38:
        return 0;
_L37:
        if (!obj.equals(serviceplan))
        {
            int j = obj.hashCode();
            int l = serviceplan.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L38; else goto _L39
_L39:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ServicePlan)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof ServicePlan)
            {
                if (compareTo((ServicePlan)obj) != 0)
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

    public BillingSchedule getBillingSchedule()
    {
        return billingSchedule;
    }

    public Period getContractLength()
    {
        return contractLength;
    }

    public String getMarketplaceId()
    {
        return marketplaceId;
    }

    public String getPlanDescription()
    {
        return planDescription;
    }

    public String getPlanGroupId()
    {
        return planGroupId;
    }

    public String getPlanId()
    {
        return planId;
    }

    public String getPlanType()
    {
        return planType;
    }

    public String getPriceAttribute()
    {
        return priceAttribute;
    }

    public Map getStorageMap()
    {
        return storageMap;
    }

    public int hashCode()
    {
        int j2 = 1;
        int l2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int k2;
        if (getPlanType() == null)
        {
            i = 0;
        } else
        {
            i = getPlanType().hashCode();
        }
        if (getPlanId() == null)
        {
            j = 0;
        } else
        {
            j = getPlanId().hashCode();
        }
        if (isRenewable())
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (getPlanDescription() == null)
        {
            l = 0;
        } else
        {
            l = getPlanDescription().hashCode();
        }
        if (getStorageMap() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getStorageMap().hashCode();
        }
        if (isPromotion())
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (getMarketplaceId() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getMarketplaceId().hashCode();
        }
        if (getBillingSchedule() == null)
        {
            l1 = 0;
        } else
        {
            l1 = getBillingSchedule().hashCode();
        }
        if (getPriceAttribute() == null)
        {
            i2 = 0;
        } else
        {
            i2 = getPriceAttribute().hashCode();
        }
        if (!isAvailable())
        {
            j2 = 0;
        }
        if (getContractLength() == null)
        {
            k2 = 0;
        } else
        {
            k2 = getContractLength().hashCode();
        }
        if (getPlanGroupId() != null)
        {
            l2 = getPlanGroupId().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1 + l1 + i2 + j2 + k2 + l2;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public boolean isPromotion()
    {
        return isPromotion;
    }

    public boolean isRenewable()
    {
        return renewable;
    }

    public void setAvailable(boolean flag)
    {
        available = flag;
    }

    public void setBillingSchedule(BillingSchedule billingschedule)
    {
        billingSchedule = billingschedule;
    }

    public void setContractLength(Period period)
    {
        contractLength = period;
    }

    public void setMarketplaceId(String s)
    {
        marketplaceId = s;
    }

    public void setPlanDescription(String s)
    {
        planDescription = s;
    }

    public void setPlanGroupId(String s)
    {
        planGroupId = s;
    }

    public void setPlanId(String s)
    {
        planId = s;
    }

    public void setPlanType(String s)
    {
        planType = s;
    }

    public void setPriceAttribute(String s)
    {
        priceAttribute = s;
    }

    public void setPromotion(boolean flag)
    {
        isPromotion = flag;
    }

    public void setRenewable(boolean flag)
    {
        renewable = flag;
    }

    public void setStorageMap(Map map)
    {
        storageMap = map;
    }
}

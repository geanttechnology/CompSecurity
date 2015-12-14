// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;


// Referenced classes of package com.amazon.clouddrive.extended.model:
//            Period

public class BillingSchedule
    implements Comparable
{

    private Period billingPeriod;
    private String currencyCode;
    private String price;

    public BillingSchedule()
    {
    }

    public int compareTo(BillingSchedule billingschedule)
    {
        if (billingschedule != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (billingschedule == this)
        {
            return 0;
        }
        obj = getBillingPeriod();
        obj1 = billingschedule.getBillingPeriod();
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
        obj = getCurrencyCode();
        obj1 = billingschedule.getCurrencyCode();
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
        obj = getPrice();
        billingschedule = billingschedule.getPrice();
        if (obj == billingschedule)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
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
        if (billingschedule == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(billingschedule);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        return 0;
_L13:
        if (!obj.equals(billingschedule))
        {
            int j = obj.hashCode();
            int l = billingschedule.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L14; else goto _L15
_L15:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((BillingSchedule)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof BillingSchedule)
            {
                if (compareTo((BillingSchedule)obj) != 0)
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

    public Period getBillingPeriod()
    {
        return billingPeriod;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public String getPrice()
    {
        return price;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getBillingPeriod() == null)
        {
            i = 0;
        } else
        {
            i = getBillingPeriod().hashCode();
        }
        if (getCurrencyCode() == null)
        {
            j = 0;
        } else
        {
            j = getCurrencyCode().hashCode();
        }
        if (getPrice() != null)
        {
            k = getPrice().hashCode();
        }
        return 1 + i + j + k;
    }

    public void setBillingPeriod(Period period)
    {
        billingPeriod = period;
    }

    public void setCurrencyCode(String s)
    {
        currencyCode = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }
}

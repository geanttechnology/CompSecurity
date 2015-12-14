// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;


public class SubscriptionProblem
    implements Comparable
{

    private long billingPeriodNumber;
    private String effectiveDate;
    private String problemCode;
    private String problemID;
    private String problemStatus;

    public SubscriptionProblem()
    {
    }

    public int compareTo(SubscriptionProblem subscriptionproblem)
    {
        if (subscriptionproblem != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (subscriptionproblem == this)
        {
            return 0;
        }
        s = getEffectiveDate();
        s1 = subscriptionproblem.getEffectiveDate();
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
        if (getBillingPeriodNumber() < subscriptionproblem.getBillingPeriodNumber())
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
        if (getBillingPeriodNumber() > subscriptionproblem.getBillingPeriodNumber())
        {
            return 1;
        }
        s = getProblemID();
        s1 = subscriptionproblem.getProblemID();
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
        if (!(s instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        s = getProblemCode();
        s1 = subscriptionproblem.getProblemCode();
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
        s = getProblemStatus();
        subscriptionproblem = subscriptionproblem.getProblemStatus();
        if (s == subscriptionproblem)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
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
        if (subscriptionproblem == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)s).compareTo(subscriptionproblem);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        return 0;
_L17:
        if (!s.equals(subscriptionproblem))
        {
            int j = s.hashCode();
            int l = subscriptionproblem.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L18; else goto _L19
_L19:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SubscriptionProblem)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof SubscriptionProblem)
            {
                if (compareTo((SubscriptionProblem)obj) != 0)
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

    public long getBillingPeriodNumber()
    {
        return billingPeriodNumber;
    }

    public String getEffectiveDate()
    {
        return effectiveDate;
    }

    public String getProblemCode()
    {
        return problemCode;
    }

    public String getProblemID()
    {
        return problemID;
    }

    public String getProblemStatus()
    {
        return problemStatus;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        int i1;
        if (getEffectiveDate() == null)
        {
            i = 0;
        } else
        {
            i = getEffectiveDate().hashCode();
        }
        i1 = (int)getBillingPeriodNumber();
        if (getProblemID() == null)
        {
            j = 0;
        } else
        {
            j = getProblemID().hashCode();
        }
        if (getProblemCode() == null)
        {
            k = 0;
        } else
        {
            k = getProblemCode().hashCode();
        }
        if (getProblemStatus() != null)
        {
            l = getProblemStatus().hashCode();
        }
        return 1 + i + i1 + j + k + l;
    }

    public void setBillingPeriodNumber(long l)
    {
        billingPeriodNumber = l;
    }

    public void setEffectiveDate(String s)
    {
        effectiveDate = s;
    }

    public void setProblemCode(String s)
    {
        problemCode = s;
    }

    public void setProblemID(String s)
    {
        problemID = s;
    }

    public void setProblemStatus(String s)
    {
        problemStatus = s;
    }
}

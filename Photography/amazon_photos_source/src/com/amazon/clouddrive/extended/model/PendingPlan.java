// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;


public class PendingPlan
    implements Comparable
{

    private String endDate;
    private String planId;
    private String startDate;

    public PendingPlan()
    {
    }

    public int compareTo(PendingPlan pendingplan)
    {
        if (pendingplan != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (pendingplan == this)
        {
            return 0;
        }
        s = getPlanId();
        s1 = pendingplan.getPlanId();
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
        s = getEndDate();
        s1 = pendingplan.getEndDate();
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
        s = getStartDate();
        pendingplan = pendingplan.getStartDate();
        if (s == pendingplan)
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
        if (pendingplan == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)s).compareTo(pendingplan);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        return 0;
_L13:
        if (!s.equals(pendingplan))
        {
            int j = s.hashCode();
            int l = pendingplan.hashCode();
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
        return compareTo((PendingPlan)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof PendingPlan)
            {
                if (compareTo((PendingPlan)obj) != 0)
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

    public String getEndDate()
    {
        return endDate;
    }

    public String getPlanId()
    {
        return planId;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getPlanId() == null)
        {
            i = 0;
        } else
        {
            i = getPlanId().hashCode();
        }
        if (getEndDate() == null)
        {
            j = 0;
        } else
        {
            j = getEndDate().hashCode();
        }
        if (getStartDate() != null)
        {
            k = getStartDate().hashCode();
        }
        return 1 + i + j + k;
    }

    public void setEndDate(String s)
    {
        endDate = s;
    }

    public void setPlanId(String s)
    {
        planId = s;
    }

    public void setStartDate(String s)
    {
        startDate = s;
    }
}

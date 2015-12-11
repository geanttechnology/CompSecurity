// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.common;

import java.util.List;

public class NBestResult
    implements Comparable
{

    private List mHypotheses;
    private String mId;
    private String mStatus;

    public NBestResult()
    {
    }

    public int compareTo(NBestResult nbestresult)
    {
        if (nbestresult != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        String s;
        if (nbestresult == this)
        {
            return 0;
        }
        obj = getId();
        s = nbestresult.getId();
        if (obj == s)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (s == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(s);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getStatus();
        s = nbestresult.getStatus();
        if (obj == s)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(s))
        {
            i = obj.hashCode();
            k = s.hashCode();
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
        if (s == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(s);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj = getHypotheses();
        nbestresult = nbestresult.getHypotheses();
        if (obj == nbestresult)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj.equals(s))
        {
            i = obj.hashCode();
            k = s.hashCode();
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
        if (nbestresult == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(nbestresult);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        return 0;
_L13:
        if (!obj.equals(nbestresult))
        {
            int j = obj.hashCode();
            int l = nbestresult.hashCode();
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
        return compareTo((NBestResult)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof NBestResult)
            {
                if (compareTo((NBestResult)obj) != 0)
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

    public List getHypotheses()
    {
        return mHypotheses;
    }

    public String getId()
    {
        return mId;
    }

    public String getStatus()
    {
        return mStatus;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getId() == null)
        {
            i = 0;
        } else
        {
            i = getId().hashCode();
        }
        if (getStatus() == null)
        {
            j = 0;
        } else
        {
            j = getStatus().hashCode();
        }
        if (getHypotheses() != null)
        {
            k = getHypotheses().hashCode();
        }
        return 1 + i + j + k;
    }

    public void setHypotheses(List list)
    {
        mHypotheses = list;
    }

    public void setId(String s)
    {
        mId = s;
    }

    public void setStatus(String s)
    {
        mStatus = s;
    }
}

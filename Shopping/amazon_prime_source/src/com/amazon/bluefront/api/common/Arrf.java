// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.common;

import java.util.List;

public class Arrf
    implements Comparable
{

    private String mId;
    private List mUtterances;

    public Arrf()
    {
    }

    public int compareTo(Arrf arrf)
    {
        if (arrf != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        List list;
        if (arrf == this)
        {
            return 0;
        }
        obj = getUtterances();
        list = arrf.getUtterances();
        if (obj == list)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (list == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(list);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getId();
        arrf = arrf.getId();
        if (obj == arrf)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(list))
        {
            i = obj.hashCode();
            k = list.hashCode();
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
        if (arrf == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(arrf);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return 0;
_L9:
        if (!obj.equals(arrf))
        {
            int j = obj.hashCode();
            int l = arrf.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Arrf)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof Arrf)
            {
                if (compareTo((Arrf)obj) != 0)
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

    public String getId()
    {
        return mId;
    }

    public List getUtterances()
    {
        return mUtterances;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getUtterances() == null)
        {
            i = 0;
        } else
        {
            i = getUtterances().hashCode();
        }
        if (getId() != null)
        {
            j = getId().hashCode();
        }
        return 1 + i + j;
    }

    public void setId(String s)
    {
        mId = s;
    }

    public void setUtterances(List list)
    {
        mUtterances = list;
    }
}

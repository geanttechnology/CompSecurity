// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


public class MediaTypeUsage
    implements Comparable
{

    private long count;
    private String lastUploadedTime;

    public MediaTypeUsage()
    {
    }

    public int compareTo(MediaTypeUsage mediatypeusage)
    {
        if (mediatypeusage != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (mediatypeusage == this)
        {
            return 0;
        }
        s = getLastUploadedTime();
        s1 = mediatypeusage.getLastUploadedTime();
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
        if (getCount() < mediatypeusage.getCount())
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s.equals(s1))
        {
            int j = s.hashCode();
            int l = s1.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        return getCount() <= mediatypeusage.getCount() ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((MediaTypeUsage)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof MediaTypeUsage)
            {
                if (compareTo((MediaTypeUsage)obj) != 0)
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

    public long getCount()
    {
        return count;
    }

    public String getLastUploadedTime()
    {
        return lastUploadedTime;
    }

    public int hashCode()
    {
        int i;
        if (getLastUploadedTime() == null)
        {
            i = 0;
        } else
        {
            i = getLastUploadedTime().hashCode();
        }
        return 1 + i + (int)getCount();
    }

    public void setCount(long l)
    {
        count = l;
    }

    public void setLastUploadedTime(String s)
    {
        lastUploadedTime = s;
    }
}

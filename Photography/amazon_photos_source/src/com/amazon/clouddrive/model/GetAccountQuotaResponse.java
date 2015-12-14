// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveResponse

public class GetAccountQuotaResponse
    implements CloudDriveResponse
{

    private long available;
    private String lastCalculated;
    private long quota;

    public GetAccountQuotaResponse()
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
        if (!(clouddriveresponse instanceof GetAccountQuotaResponse))
        {
            return 1;
        }
        clouddriveresponse = (GetAccountQuotaResponse)clouddriveresponse;
        if (getQuota() < clouddriveresponse.getQuota())
        {
            return -1;
        }
        if (getQuota() > clouddriveresponse.getQuota())
        {
            return 1;
        }
        s = getLastCalculated();
        s1 = clouddriveresponse.getLastCalculated();
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
        if (getAvailable() < clouddriveresponse.getAvailable())
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
        return getAvailable() <= clouddriveresponse.getAvailable() ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveResponse)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof GetAccountQuotaResponse)
            {
                if (compareTo((GetAccountQuotaResponse)obj) != 0)
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

    public long getAvailable()
    {
        return available;
    }

    public String getLastCalculated()
    {
        return lastCalculated;
    }

    public long getQuota()
    {
        return quota;
    }

    public int hashCode()
    {
        int j = (int)getQuota();
        int i;
        if (getLastCalculated() == null)
        {
            i = 0;
        } else
        {
            i = getLastCalculated().hashCode();
        }
        return 1 + j + i + (int)getAvailable();
    }

    public void setAvailable(long l)
    {
        available = l;
    }

    public void setLastCalculated(String s)
    {
        lastCalculated = s;
    }

    public void setQuota(long l)
    {
        quota = l;
    }
}

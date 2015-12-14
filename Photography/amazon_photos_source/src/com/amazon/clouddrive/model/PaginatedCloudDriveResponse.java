// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveResponse

public abstract class PaginatedCloudDriveResponse
    implements CloudDriveResponse
{

    private long count;
    private String nextToken;

    public PaginatedCloudDriveResponse()
    {
    }

    public int compareTo(CloudDriveResponse clouddriveresponse)
    {
        int j = -1;
        if (clouddriveresponse != null) goto _L2; else goto _L1
_L1:
        int i = j;
_L6:
        return i;
_L2:
        Object obj;
        if (clouddriveresponse == this)
        {
            return 0;
        }
        if (!(clouddriveresponse instanceof PaginatedCloudDriveResponse))
        {
            return 1;
        }
        obj = (PaginatedCloudDriveResponse)clouddriveresponse;
        i = j;
        if (getCount() < ((PaginatedCloudDriveResponse) (obj)).getCount())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (getCount() > ((PaginatedCloudDriveResponse) (obj)).getCount())
        {
            return 1;
        }
        clouddriveresponse = getNextToken();
        obj = ((PaginatedCloudDriveResponse) (obj)).getNextToken();
        if (clouddriveresponse == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (clouddriveresponse == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return 1;
        }
        if (!(clouddriveresponse instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)clouddriveresponse).compareTo(obj);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return 0;
_L4:
        if (!clouddriveresponse.equals(obj))
        {
            int k = clouddriveresponse.hashCode();
            int l = obj.hashCode();
            i = j;
            if (k < l)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (true) goto _L6; else goto _L8
_L8:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveResponse)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof PaginatedCloudDriveResponse)
            {
                if (compareTo((PaginatedCloudDriveResponse)obj) != 0)
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

    public String getNextToken()
    {
        return nextToken;
    }

    public int hashCode()
    {
        int j = (int)getCount();
        int i;
        if (getNextToken() == null)
        {
            i = 0;
        } else
        {
            i = getNextToken().hashCode();
        }
        return 1 + j + i;
    }

    public void setCount(long l)
    {
        count = l;
    }

    public void setNextToken(String s)
    {
        nextToken = s;
    }
}

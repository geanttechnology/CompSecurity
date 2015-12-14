// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            PaginatedCloudDriveResponse, NodeListingResponse, CloudDriveResponse

public class ListNodesResponse extends PaginatedCloudDriveResponse
    implements NodeListingResponse
{

    private List data;

    public ListNodesResponse()
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
        List list;
        Object obj;
        if (clouddriveresponse == this)
        {
            return 0;
        }
        if (!(clouddriveresponse instanceof ListNodesResponse))
        {
            return 1;
        }
        obj = (ListNodesResponse)clouddriveresponse;
        list = getData();
        obj = ((ListNodesResponse) (obj)).getData();
        if (list == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (list == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return 1;
        }
        if (!(list instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)list).compareTo(obj);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return super.compareTo(clouddriveresponse);
_L4:
        if (!list.equals(obj))
        {
            int k = list.hashCode();
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
            if (obj instanceof ListNodesResponse)
            {
                if (compareTo((ListNodesResponse)obj) != 0)
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

    public List getData()
    {
        return data;
    }

    public int hashCode()
    {
        int i;
        if (getData() == null)
        {
            i = 0;
        } else
        {
            i = getData().hashCode();
        }
        return (1 + i) * 31 + super.hashCode();
    }

    public void setData(List list)
    {
        data = list;
    }
}

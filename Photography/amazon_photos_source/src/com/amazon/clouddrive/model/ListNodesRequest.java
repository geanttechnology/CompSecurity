// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            PaginatedCloudDriveRequest, CloudDriveRequest

public class ListNodesRequest extends PaginatedCloudDriveRequest
{

    private String assetMapping;
    private Boolean tempLink;

    public ListNodesRequest()
    {
    }

    public int compareTo(CloudDriveRequest clouddriverequest)
    {
        if (clouddriverequest != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        Boolean boolean1;
        if (clouddriverequest == this)
        {
            return 0;
        }
        if (!(clouddriverequest instanceof ListNodesRequest))
        {
            return 1;
        }
        obj = (ListNodesRequest)clouddriverequest;
        obj1 = getTempLink();
        boolean1 = ((ListNodesRequest) (obj)).getTempLink();
        if (obj1 == boolean1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        if (boolean1 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj1).compareTo(boolean1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj1 = getAssetMapping();
        obj = ((ListNodesRequest) (obj)).getAssetMapping();
        if (obj1 == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj1.equals(boolean1))
        {
            i = obj1.hashCode();
            k = boolean1.hashCode();
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
        if (obj == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj1).compareTo(obj);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return super.compareTo(clouddriverequest);
_L9:
        if (!obj1.equals(obj))
        {
            int j = obj1.hashCode();
            int l = obj.hashCode();
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
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof ListNodesRequest)
            {
                if (compareTo((ListNodesRequest)obj) != 0)
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

    public String getAssetMapping()
    {
        return assetMapping;
    }

    public Boolean getTempLink()
    {
        return tempLink;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getTempLink().booleanValue())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (getAssetMapping() != null)
        {
            j = getAssetMapping().hashCode();
        }
        return (1 + i + j) * 31 + super.hashCode();
    }
}

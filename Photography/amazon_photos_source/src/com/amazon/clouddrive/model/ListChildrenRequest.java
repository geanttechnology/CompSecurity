// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            PaginatedCloudDriveRequest, CloudDriveRequest

public class ListChildrenRequest extends PaginatedCloudDriveRequest
{

    private String assetMapping;
    private String id;
    private Boolean tempLink;

    public ListChildrenRequest(String s)
    {
        id = s;
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
        String s;
        if (clouddriverequest == this)
        {
            return 0;
        }
        if (!(clouddriverequest instanceof ListChildrenRequest))
        {
            return 1;
        }
        obj = (ListChildrenRequest)clouddriverequest;
        obj1 = getAssetMapping();
        s = ((ListChildrenRequest) (obj)).getAssetMapping();
        if (obj1 == s)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        if (s == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj1).compareTo(s);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj1 = getId();
        s = ((ListChildrenRequest) (obj)).getId();
        if (obj1 == s)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj1.equals(s))
        {
            i = obj1.hashCode();
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
        if (!(obj1 instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj1).compareTo(s);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj1 = getTempLink();
        obj = ((ListChildrenRequest) (obj)).getTempLink();
        if (obj1 == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj1.equals(s))
        {
            i = obj1.hashCode();
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
        if (obj == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj1).compareTo(obj);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        return super.compareTo(clouddriverequest);
_L13:
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
        if (true) goto _L14; else goto _L15
_L15:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof ListChildrenRequest)
            {
                if (compareTo((ListChildrenRequest)obj) != 0)
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

    public String getId()
    {
        return id;
    }

    public Boolean getTempLink()
    {
        return tempLink;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getAssetMapping() == null)
        {
            i = 0;
        } else
        {
            i = getAssetMapping().hashCode();
        }
        if (getId() == null)
        {
            j = 0;
        } else
        {
            j = getId().hashCode();
        }
        if (getTempLink().booleanValue())
        {
            k = 1;
        }
        return (1 + i + j + k) * 31 + super.hashCode();
    }
}

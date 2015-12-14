// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveRequest

public abstract class PaginatedCloudDriveRequest
    implements CloudDriveRequest
{

    private String fields;
    private String filters;
    private Integer limit;
    private Integer offset;
    private String sort;
    private String startToken;

    public PaginatedCloudDriveRequest()
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
        if (clouddriverequest == this)
        {
            return 0;
        }
        if (!(clouddriverequest instanceof PaginatedCloudDriveRequest))
        {
            return 1;
        }
        clouddriverequest = (PaginatedCloudDriveRequest)clouddriverequest;
        obj = getFields();
        obj1 = clouddriverequest.getFields();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getStartToken();
        obj1 = clouddriverequest.getStartToken();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj = getFilters();
        obj1 = clouddriverequest.getFilters();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        obj = getOffset();
        obj1 = clouddriverequest.getOffset();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        obj = getLimit();
        obj1 = clouddriverequest.getLimit();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L18; else goto _L19
_L19:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        obj = getSort();
        clouddriverequest = clouddriverequest.getSort();
        if (obj == clouddriverequest)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L22; else goto _L23
_L23:
        if (clouddriverequest == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)obj).compareTo(clouddriverequest);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        return 0;
_L25:
        if (!obj.equals(clouddriverequest))
        {
            int j = obj.hashCode();
            int l = clouddriverequest.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L26; else goto _L27
_L27:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof PaginatedCloudDriveRequest)
            {
                if (compareTo((PaginatedCloudDriveRequest)obj) != 0)
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

    public String getFields()
    {
        return fields;
    }

    public String getFilters()
    {
        return filters;
    }

    public Integer getLimit()
    {
        return limit;
    }

    public Integer getOffset()
    {
        return offset;
    }

    public String getSort()
    {
        return sort;
    }

    public String getStartToken()
    {
        return startToken;
    }

    public int hashCode()
    {
        int j1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        if (getFields() == null)
        {
            i = 0;
        } else
        {
            i = getFields().hashCode();
        }
        if (getStartToken() == null)
        {
            j = 0;
        } else
        {
            j = getStartToken().hashCode();
        }
        if (getFilters() == null)
        {
            k = 0;
        } else
        {
            k = getFilters().hashCode();
        }
        if (getOffset() == null)
        {
            l = 0;
        } else
        {
            l = getOffset().hashCode();
        }
        if (getLimit() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getLimit().hashCode();
        }
        if (getSort() != null)
        {
            j1 = getSort().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1;
    }

    public void setFilters(String s)
    {
        filters = s;
    }

    public void setLimit(Integer integer)
    {
        limit = integer;
    }

    public void setOffset(Integer integer)
    {
        offset = integer;
    }

    public void setSort(String s)
    {
        sort = s;
    }
}

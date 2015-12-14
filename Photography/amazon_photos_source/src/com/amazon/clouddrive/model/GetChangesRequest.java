// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveRequest

public class GetChangesRequest
    implements CloudDriveRequest
{

    private String checkpoint;
    private Integer chunkSize;
    private String includePurged;
    private Integer limit;
    private Integer maxNodes;

    public GetChangesRequest()
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
        if (!(clouddriverequest instanceof GetChangesRequest))
        {
            return 1;
        }
        clouddriverequest = (GetChangesRequest)clouddriverequest;
        obj = getIncludePurged();
        obj1 = clouddriverequest.getIncludePurged();
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
        obj = getChunkSize();
        obj1 = clouddriverequest.getChunkSize();
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
        obj = getCheckpoint();
        obj1 = clouddriverequest.getCheckpoint();
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
        obj = getMaxNodes();
        obj1 = clouddriverequest.getMaxNodes();
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
        clouddriverequest = clouddriverequest.getLimit();
        if (obj == clouddriverequest)
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
        if (clouddriverequest == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj).compareTo(clouddriverequest);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        return 0;
_L21:
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
        if (true) goto _L22; else goto _L23
_L23:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof GetChangesRequest)
            {
                if (compareTo((GetChangesRequest)obj) != 0)
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

    public String getCheckpoint()
    {
        return checkpoint;
    }

    public Integer getChunkSize()
    {
        return chunkSize;
    }

    public String getIncludePurged()
    {
        return includePurged;
    }

    public Integer getLimit()
    {
        return limit;
    }

    public Integer getMaxNodes()
    {
        return maxNodes;
    }

    public int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
        if (getIncludePurged() == null)
        {
            i = 0;
        } else
        {
            i = getIncludePurged().hashCode();
        }
        if (getChunkSize() == null)
        {
            j = 0;
        } else
        {
            j = getChunkSize().hashCode();
        }
        if (getCheckpoint() == null)
        {
            k = 0;
        } else
        {
            k = getCheckpoint().hashCode();
        }
        if (getMaxNodes() == null)
        {
            l = 0;
        } else
        {
            l = getMaxNodes().hashCode();
        }
        if (getLimit() != null)
        {
            i1 = getLimit().hashCode();
        }
        return 1 + i + j + k + l + i1;
    }

    public void setCheckpoint(String s)
    {
        checkpoint = s;
    }

    public void setIncludePurged(String s)
    {
        includePurged = s;
    }
}

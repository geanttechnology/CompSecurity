// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.CloudDriveRequest;
import com.amazon.clouddrive.model.ObjectComparator;
import java.util.List;

// Referenced classes of package com.amazon.clouddrive.extended.model:
//            BulkAddRemoveRequest

public class BulkTrashRestoreNodesRequest
    implements BulkAddRemoveRequest
{

    private List nodeIds;
    private String op;
    private Boolean recurse;
    private String resourceVersion;

    public BulkTrashRestoreNodesRequest(List list, String s)
    {
        nodeIds = list;
        op = s;
    }

    public int compareTo(CloudDriveRequest clouddriverequest)
    {
        int i;
        if (clouddriverequest == null)
        {
            i = -1;
        } else
        {
            if (clouddriverequest == this)
            {
                return 0;
            }
            if (!(clouddriverequest instanceof BulkTrashRestoreNodesRequest))
            {
                return 1;
            }
            clouddriverequest = (BulkTrashRestoreNodesRequest)clouddriverequest;
            int j = ObjectComparator.compare(getNodeIds(), clouddriverequest.getNodeIds());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getOp(), clouddriverequest.getOp());
                i = k;
                if (k == 0)
                {
                    int l = ObjectComparator.compare(getRecurse(), clouddriverequest.getRecurse());
                    i = l;
                    if (l == 0)
                    {
                        int i1 = ObjectComparator.compare(getResourceVersion(), clouddriverequest.getResourceVersion());
                        i = i1;
                        if (i1 == 0)
                        {
                            return 0;
                        }
                    }
                }
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        while (obj == this || (obj instanceof BulkTrashRestoreNodesRequest) && compareTo((BulkTrashRestoreNodesRequest)obj) == 0) 
        {
            return true;
        }
        return false;
    }

    public List getNodeIds()
    {
        return nodeIds;
    }

    public String getOp()
    {
        return op;
    }

    public Boolean getRecurse()
    {
        return recurse;
    }

    public String getResourceVersion()
    {
        return resourceVersion;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (getNodeIds() == null)
        {
            i = 0;
        } else
        {
            i = getNodeIds().hashCode();
        }
        if (getOp() == null)
        {
            j = 0;
        } else
        {
            j = getOp().hashCode();
        }
        if (getRecurse() == null)
        {
            k = 0;
        } else
        {
            k = getRecurse().hashCode();
        }
        if (getResourceVersion() != null)
        {
            l = getResourceVersion().hashCode();
        }
        return 1 + i + j + k + l;
    }

    public void setRecurse(Boolean boolean1)
    {
        recurse = boolean1;
    }

    public void setResourceVersion(String s)
    {
        resourceVersion = s;
    }
}

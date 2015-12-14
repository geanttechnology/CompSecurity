// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveRequest, ObjectComparator

public class UpdateCollectionPropertiesRequest
    implements CloudDriveRequest
{

    private String id;
    private List operations;

    public UpdateCollectionPropertiesRequest()
    {
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
            if (!(clouddriverequest instanceof UpdateCollectionPropertiesRequest))
            {
                return 1;
            }
            clouddriverequest = (UpdateCollectionPropertiesRequest)clouddriverequest;
            int j = ObjectComparator.compare(getId(), clouddriverequest.getId());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getOperations(), clouddriverequest.getOperations());
                i = k;
                if (k == 0)
                {
                    return 0;
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
        if (obj != this)
        {
            if (obj instanceof UpdateCollectionPropertiesRequest)
            {
                if (compareTo((UpdateCollectionPropertiesRequest)obj) != 0)
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
        return id;
    }

    public List getOperations()
    {
        return operations;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getId() == null)
        {
            i = 0;
        } else
        {
            i = getId().hashCode();
        }
        if (getOperations() != null)
        {
            j = getOperations().hashCode();
        }
        return (1 + i + j) * 31 + super.hashCode();
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setOperations(List list)
    {
        operations = list;
    }
}

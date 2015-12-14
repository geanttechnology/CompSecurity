// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.CloudDriveResponse;
import com.amazon.clouddrive.model.NodeListingResponse;
import com.amazon.clouddrive.model.ObjectComparator;
import com.amazon.clouddrive.model.PaginatedCloudDriveResponse;
import java.util.List;

public class ListNodesExtendedResponse extends PaginatedCloudDriveResponse
    implements NodeListingResponse
{

    private List mData;

    public ListNodesExtendedResponse()
    {
    }

    public int compareTo(CloudDriveResponse clouddriveresponse)
    {
        int i;
        if (clouddriveresponse == null)
        {
            i = -1;
        } else
        {
            if (clouddriveresponse == this)
            {
                return 0;
            }
            if (!(clouddriveresponse instanceof ListNodesExtendedResponse))
            {
                return 1;
            }
            ListNodesExtendedResponse listnodesextendedresponse = (ListNodesExtendedResponse)clouddriveresponse;
            int j = ObjectComparator.compare(getData(), listnodesextendedresponse.getData());
            i = j;
            if (j == 0)
            {
                return super.compareTo(clouddriveresponse);
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveResponse)obj);
    }

    public boolean equals(Object obj)
    {
        while (obj == this || (obj instanceof ListNodesExtendedResponse) && compareTo((ListNodesExtendedResponse)obj) == 0) 
        {
            return true;
        }
        return false;
    }

    public List getData()
    {
        return mData;
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
        mData = list;
    }
}

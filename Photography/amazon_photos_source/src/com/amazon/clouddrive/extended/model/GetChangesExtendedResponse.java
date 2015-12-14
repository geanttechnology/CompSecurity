// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.CloudDriveResponse;
import com.amazon.clouddrive.model.IGetChangesResponse;
import com.amazon.clouddrive.model.ObjectComparator;
import java.util.List;

public class GetChangesExtendedResponse
    implements IGetChangesResponse
{

    private String mCheckpoint;
    private List mNodes;
    private boolean mReset;

    public GetChangesExtendedResponse()
    {
    }

    public int compareTo(CloudDriveResponse clouddriveresponse)
    {
        int i = -1;
        if (clouddriveresponse != null)
        {
            if (clouddriveresponse == this)
            {
                return 0;
            }
            if (!(clouddriveresponse instanceof GetChangesExtendedResponse))
            {
                return 1;
            }
            clouddriveresponse = (GetChangesExtendedResponse)clouddriveresponse;
            if (isReset() || !clouddriveresponse.isReset())
            {
                if (isReset() && !clouddriveresponse.isReset())
                {
                    return 1;
                }
                int j = ObjectComparator.compare(getCheckpoint(), clouddriveresponse.getCheckpoint());
                i = j;
                if (j == 0)
                {
                    int k = ObjectComparator.compare(getNodes(), clouddriveresponse.getNodes());
                    i = k;
                    if (k == 0)
                    {
                        return 0;
                    }
                }
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
        while (obj == this || (obj instanceof GetChangesExtendedResponse) && compareTo((GetChangesExtendedResponse)obj) == 0) 
        {
            return true;
        }
        return false;
    }

    public String getCheckpoint()
    {
        return mCheckpoint;
    }

    public List getNodes()
    {
        return mNodes;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (isReset())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (getCheckpoint() != null)
        {
            j = getCheckpoint().hashCode();
        } else
        {
            j = 0;
        }
        if (getNodes() != null)
        {
            k = getNodes().hashCode();
        }
        return 1 + i + j + k;
    }

    public boolean isReset()
    {
        return mReset;
    }

    public void setCheckpoint(String s)
    {
        mCheckpoint = s;
    }

    public void setNodes(List list)
    {
        mNodes = list;
    }

    public void setReset(boolean flag)
    {
        mReset = flag;
    }
}

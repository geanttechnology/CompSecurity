// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.CloudDriveResponse;
import com.amazon.clouddrive.model.ObjectComparator;
import java.util.Map;

// Referenced classes of package com.amazon.clouddrive.extended.model:
//            BulkResponse

public class BulkAddRemoveChildResponse
    implements BulkResponse
{

    private Map errorMap;
    private String message;

    public BulkAddRemoveChildResponse()
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
            if (!(clouddriveresponse instanceof BulkAddRemoveChildResponse))
            {
                return 1;
            }
            clouddriveresponse = (BulkAddRemoveChildResponse)clouddriveresponse;
            int j = ObjectComparator.compare(getMessage(), clouddriveresponse.getMessage());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getErrorMap(), clouddriveresponse.getErrorMap());
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
        return compareTo((CloudDriveResponse)obj);
    }

    public boolean equals(Object obj)
    {
        while (obj == this || (obj instanceof BulkAddRemoveChildResponse) && compareTo((BulkAddRemoveChildResponse)obj) == 0) 
        {
            return true;
        }
        return false;
    }

    public Map getErrorMap()
    {
        return errorMap;
    }

    public String getMessage()
    {
        return message;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getMessage() == null)
        {
            i = 0;
        } else
        {
            i = getMessage().hashCode();
        }
        if (getErrorMap() != null)
        {
            j = getErrorMap().hashCode();
        }
        return 1 + i + j;
    }

    public void setErrorMap(Map map)
    {
        errorMap = map;
    }

    public void setMessage(String s)
    {
        message = s;
    }
}

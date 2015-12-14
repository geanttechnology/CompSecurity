// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveRequest

public class GetAccountQuotaRequest
    implements CloudDriveRequest
{

    public GetAccountQuotaRequest()
    {
    }

    public int compareTo(CloudDriveRequest clouddriverequest)
    {
        boolean flag = false;
        byte byte0;
        if (clouddriverequest == null)
        {
            byte0 = -1;
        } else
        {
            byte0 = flag;
            if (clouddriverequest != this)
            {
                byte0 = flag;
                if (!(clouddriverequest instanceof GetAccountQuotaRequest))
                {
                    return 1;
                }
            }
        }
        return byte0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof GetAccountQuotaRequest)
            {
                if (compareTo((GetAccountQuotaRequest)obj) != 0)
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

    public int hashCode()
    {
        return 1;
    }
}

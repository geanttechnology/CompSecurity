// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.CloudDriveRequest;

public class SetupAccountRequest
    implements CloudDriveRequest
{

    private String termsOfUse;

    public SetupAccountRequest()
    {
    }

    public int compareTo(CloudDriveRequest clouddriverequest)
    {
        int j = -1;
        if (clouddriverequest != null) goto _L2; else goto _L1
_L1:
        int i = j;
_L6:
        return i;
_L2:
        Object obj;
        if (clouddriverequest == this)
        {
            return 0;
        }
        if (!(clouddriverequest instanceof SetupAccountRequest))
        {
            return 1;
        }
        obj = (SetupAccountRequest)clouddriverequest;
        clouddriverequest = getTermsOfUse();
        obj = ((SetupAccountRequest) (obj)).getTermsOfUse();
        if (clouddriverequest == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (clouddriverequest == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return 1;
        }
        if (!(clouddriverequest instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)clouddriverequest).compareTo(obj);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return 0;
_L4:
        if (!clouddriverequest.equals(obj))
        {
            int k = clouddriverequest.hashCode();
            int l = obj.hashCode();
            i = j;
            if (k < l)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (true) goto _L6; else goto _L8
_L8:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof SetupAccountRequest)
            {
                if (compareTo((SetupAccountRequest)obj) != 0)
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

    public String getTermsOfUse()
    {
        return termsOfUse;
    }

    public int hashCode()
    {
        int i;
        if (getTermsOfUse() == null)
        {
            i = 0;
        } else
        {
            i = getTermsOfUse().hashCode();
        }
        return (1 + i) * 31 + super.hashCode();
    }

    public void setTermsOfUse(String s)
    {
        termsOfUse = s;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveRequest

public class RemoveChildFromParentRequest
    implements CloudDriveRequest
{

    private String childId;
    private String parentId;

    public RemoveChildFromParentRequest(String s, String s1)
    {
        parentId = s;
        childId = s1;
    }

    public int compareTo(CloudDriveRequest clouddriverequest)
    {
        if (clouddriverequest != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (clouddriverequest == this)
        {
            return 0;
        }
        if (!(clouddriverequest instanceof RemoveChildFromParentRequest))
        {
            return 1;
        }
        clouddriverequest = (RemoveChildFromParentRequest)clouddriverequest;
        s = getParentId();
        s1 = clouddriverequest.getParentId();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        s = getChildId();
        clouddriverequest = clouddriverequest.getChildId();
        if (s == clouddriverequest)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (clouddriverequest == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)s).compareTo(clouddriverequest);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return 0;
_L9:
        if (!s.equals(clouddriverequest))
        {
            int j = s.hashCode();
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
        if (true) goto _L10; else goto _L11
_L11:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof RemoveChildFromParentRequest)
            {
                if (compareTo((RemoveChildFromParentRequest)obj) != 0)
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

    public String getChildId()
    {
        return childId;
    }

    public String getParentId()
    {
        return parentId;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getParentId() == null)
        {
            i = 0;
        } else
        {
            i = getParentId().hashCode();
        }
        if (getChildId() != null)
        {
            j = getChildId().hashCode();
        }
        return 1 + i + j;
    }
}

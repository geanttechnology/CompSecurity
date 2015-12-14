// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            EditableNodeRequest

public class PostNodeRequest extends EditableNodeRequest
{

    private String conflictResolution;
    private String localId;

    public PostNodeRequest()
    {
    }

    public int compareTo(EditableNodeRequest editablenoderequest)
    {
        if (editablenoderequest != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        String s;
        String s1;
        if (editablenoderequest == this)
        {
            return 0;
        }
        if (!(editablenoderequest instanceof PostNodeRequest))
        {
            return 1;
        }
        obj = (PostNodeRequest)editablenoderequest;
        s = getLocalId();
        s1 = ((PostNodeRequest) (obj)).getLocalId();
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
        s = getConflictResolution();
        obj = ((PostNodeRequest) (obj)).getConflictResolution();
        if (s == obj)
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
        if (obj == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)s).compareTo(obj);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return super.compareTo(editablenoderequest);
_L9:
        if (!s.equals(obj))
        {
            int j = s.hashCode();
            int l = obj.hashCode();
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

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof PostNodeRequest)
            {
                if (compareTo((PostNodeRequest)obj) != 0)
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

    public String getConflictResolution()
    {
        return conflictResolution;
    }

    public String getLocalId()
    {
        return localId;
    }

    public int hashCode()
    {
        int i;
        if (getLocalId() == null)
        {
            i = 0;
        } else
        {
            i = getLocalId().hashCode();
        }
        return (1 + i) * 31 + super.hashCode();
    }

    public void setConflictResolution(String s)
    {
        conflictResolution = s;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            Node, EditableNode

public class CreateNodeResponse extends Node
{

    private String location;

    public CreateNodeResponse()
    {
    }

    public int compareTo(EditableNode editablenode)
    {
        int j = -1;
        if (editablenode != null) goto _L2; else goto _L1
_L1:
        int i = j;
_L6:
        return i;
_L2:
        String s;
        Object obj;
        if (editablenode == this)
        {
            return 0;
        }
        if (!(editablenode instanceof CreateNodeResponse))
        {
            return 1;
        }
        obj = (CreateNodeResponse)editablenode;
        s = getLocation();
        obj = ((CreateNodeResponse) (obj)).getLocation();
        if (s == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)s).compareTo(obj);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return super.compareTo(editablenode);
_L4:
        if (!s.equals(obj))
        {
            int k = s.hashCode();
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
        return compareTo((EditableNode)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof CreateNodeResponse)
            {
                if (compareTo((CreateNodeResponse)obj) != 0)
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

    public String getLocation()
    {
        return location;
    }

    public int hashCode()
    {
        int i;
        if (getLocation() == null)
        {
            i = 0;
        } else
        {
            i = getLocation().hashCode();
        }
        return (1 + i) * 31 + super.hashCode();
    }

    public void setLocation(String s)
    {
        location = s;
    }
}

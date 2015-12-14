// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            PostNodeRequest, EditableNodeRequest

public class CreateNodeRequest extends PostNodeRequest
{

    public CreateNodeRequest(String s, String s1)
    {
        setName(s);
        setKind(s1);
    }

    public int compareTo(EditableNodeRequest editablenoderequest)
    {
        if (editablenoderequest == null)
        {
            return -1;
        }
        if (editablenoderequest == this)
        {
            return 0;
        }
        if (!(editablenoderequest instanceof CreateNodeRequest))
        {
            return 1;
        } else
        {
            return super.compareTo(editablenoderequest);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof CreateNodeRequest)
            {
                if (compareTo((CreateNodeRequest)obj) != 0)
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
        return super.hashCode() + 31;
    }
}

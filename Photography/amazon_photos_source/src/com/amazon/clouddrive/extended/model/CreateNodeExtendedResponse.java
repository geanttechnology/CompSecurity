// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.EditableNode;
import com.amazon.clouddrive.model.ObjectComparator;

// Referenced classes of package com.amazon.clouddrive.extended.model:
//            NodeExtended

public class CreateNodeExtendedResponse extends NodeExtended
{

    private String mLocation;

    public CreateNodeExtendedResponse()
    {
    }

    public int compareTo(EditableNode editablenode)
    {
        int i;
        if (editablenode == null)
        {
            i = -1;
        } else
        {
            if (editablenode == this)
            {
                return 0;
            }
            if (!(editablenode instanceof CreateNodeExtendedResponse))
            {
                return 1;
            }
            CreateNodeExtendedResponse createnodeextendedresponse = (CreateNodeExtendedResponse)editablenode;
            int j = ObjectComparator.compare(getLocation(), createnodeextendedresponse.getLocation());
            i = j;
            if (j == 0)
            {
                return super.compareTo(editablenode);
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((EditableNode)obj);
    }

    public boolean equals(Object obj)
    {
        while (obj == this || (obj instanceof CreateNodeExtendedResponse) && compareTo((CreateNodeExtendedResponse)obj) == 0) 
        {
            return true;
        }
        return false;
    }

    public String getLocation()
    {
        return mLocation;
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
        mLocation = s;
    }
}

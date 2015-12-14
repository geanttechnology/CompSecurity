// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.EditableNode;
import com.amazon.clouddrive.model.Node;
import com.amazon.clouddrive.model.ObjectComparator;

// Referenced classes of package com.amazon.clouddrive.extended.model:
//            EditableNodeExtended

public class NodeExtended extends Node
    implements EditableNodeExtended
{

    private Boolean mRestricted;
    private String mShareId;
    private String mShareURL;

    public NodeExtended()
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
            if (!(editablenode instanceof NodeExtended))
            {
                return 1;
            }
            NodeExtended nodeextended = (NodeExtended)editablenode;
            int j = ObjectComparator.compare(isRestricted(), nodeextended.isRestricted());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getShareId(), nodeextended.getShareId());
                i = k;
                if (k == 0)
                {
                    int l = ObjectComparator.compare(getShareURL(), nodeextended.getShareURL());
                    i = l;
                    if (l == 0)
                    {
                        return super.compareTo(editablenode);
                    }
                }
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
        while (obj == this || (obj instanceof NodeExtended) && compareTo((NodeExtended)obj) == 0) 
        {
            return true;
        }
        return false;
    }

    public String getShareId()
    {
        return mShareId;
    }

    public String getShareURL()
    {
        return mShareURL;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (isRestricted() == null)
        {
            i = 0;
        } else
        {
            i = isRestricted().hashCode();
        }
        if (getShareId() == null)
        {
            j = 0;
        } else
        {
            j = getShareId().hashCode();
        }
        if (getShareURL() != null)
        {
            k = getShareURL().hashCode();
        }
        return (1 + i + j + k) * 31 + super.hashCode();
    }

    public Boolean isRestricted()
    {
        return mRestricted;
    }

    public void setRestricted(Boolean boolean1)
    {
        mRestricted = boolean1;
    }

    public void setShareId(String s)
    {
        mShareId = s;
    }

    public void setShareURL(String s)
    {
        mShareURL = s;
    }
}

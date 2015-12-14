// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            EditableNode, INode

public class Node extends EditableNode
    implements INode
{

    private List assets;
    private String createdBy;
    private String createdDate;
    private String eTagRequest;
    private String eTagResponse;
    private Boolean exclusivelyTrashed;
    private Boolean isRoot;
    private Boolean isShared;
    private String modifiedDate;
    private Boolean recursivelyTrashed;
    private String tempLink;
    private long version;

    public Node()
    {
    }

    public int compareTo(EditableNode editablenode)
    {
        if (editablenode != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        Object obj2;
        if (editablenode == this)
        {
            return 0;
        }
        if (!(editablenode instanceof Node))
        {
            return 1;
        }
        obj = (Node)editablenode;
        if (getVersion() < ((Node) (obj)).getVersion())
        {
            return -1;
        }
        if (getVersion() > ((Node) (obj)).getVersion())
        {
            return 1;
        }
        obj1 = getETagResponse();
        obj2 = ((Node) (obj)).getETagResponse();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj1 = getAssets();
        obj2 = ((Node) (obj)).getAssets();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
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
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj1 = isShared();
        obj2 = ((Node) (obj)).isShared();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        obj1 = isRoot();
        obj2 = ((Node) (obj)).isRoot();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L14; else goto _L15
_L15:
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        obj1 = getETagRequest();
        obj2 = ((Node) (obj)).getETagRequest();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L18; else goto _L19
_L19:
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        obj1 = isExclusivelyTrashed();
        obj2 = ((Node) (obj)).isExclusivelyTrashed();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L22; else goto _L23
_L23:
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        obj1 = getCreatedDate();
        obj2 = ((Node) (obj)).getCreatedDate();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L25:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L26; else goto _L27
_L27:
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        obj1 = isRecursivelyTrashed();
        obj2 = ((Node) (obj)).isRecursivelyTrashed();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L29:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L30; else goto _L31
_L31:
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L33; else goto _L32
_L32:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L34
_L34:
        obj1 = getModifiedDate();
        obj2 = ((Node) (obj)).getModifiedDate();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L33:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L34; else goto _L35
_L35:
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L37; else goto _L36
_L36:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L38
_L38:
        obj1 = getCreatedBy();
        obj2 = ((Node) (obj)).getCreatedBy();
        if (obj1 == obj2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L37:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L38; else goto _L39
_L39:
        if (obj2 == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L41; else goto _L40
_L40:
        k = ((Comparable)obj1).compareTo(obj2);
        i = k;
        if (k != 0) goto _L6; else goto _L42
_L42:
        obj1 = getTempLink();
        obj = ((Node) (obj)).getTempLink();
        if (obj1 == obj)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L41:
        if (!obj1.equals(obj2))
        {
            i = obj1.hashCode();
            k = obj2.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L42; else goto _L43
_L43:
        if (obj == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L45; else goto _L44
_L44:
        k = ((Comparable)obj1).compareTo(obj);
        i = k;
        if (k != 0) goto _L6; else goto _L46
_L46:
        return super.compareTo(editablenode);
_L45:
        if (!obj1.equals(obj))
        {
            int j = obj1.hashCode();
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
        if (true) goto _L46; else goto _L47
_L47:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((EditableNode)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof Node)
            {
                if (compareTo((Node)obj) != 0)
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

    public List getAssets()
    {
        return assets;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public String getCreatedDate()
    {
        return createdDate;
    }

    public String getETagRequest()
    {
        return eTagRequest;
    }

    public String getETagResponse()
    {
        return eTagResponse;
    }

    public String getModifiedDate()
    {
        return modifiedDate;
    }

    public String getTempLink()
    {
        return tempLink;
    }

    public long getVersion()
    {
        return version;
    }

    public int hashCode()
    {
        int k2 = 0;
        int l2 = (int)getVersion();
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (getETagResponse() == null)
        {
            i = 0;
        } else
        {
            i = getETagResponse().hashCode();
        }
        if (getAssets() == null)
        {
            j = 0;
        } else
        {
            j = getAssets().hashCode();
        }
        if (isShared() == null)
        {
            k = 0;
        } else
        {
            k = isShared().hashCode();
        }
        if (isRoot() == null)
        {
            l = 0;
        } else
        {
            l = isRoot().hashCode();
        }
        if (getETagRequest() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getETagRequest().hashCode();
        }
        if (isExclusivelyTrashed() == null)
        {
            j1 = 0;
        } else
        {
            j1 = isExclusivelyTrashed().hashCode();
        }
        if (getCreatedDate() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getCreatedDate().hashCode();
        }
        if (isRecursivelyTrashed() == null)
        {
            l1 = 0;
        } else
        {
            l1 = isRecursivelyTrashed().hashCode();
        }
        if (getModifiedDate() == null)
        {
            i2 = 0;
        } else
        {
            i2 = getModifiedDate().hashCode();
        }
        if (getCreatedBy() == null)
        {
            j2 = 0;
        } else
        {
            j2 = getCreatedBy().hashCode();
        }
        if (getTempLink() != null)
        {
            k2 = getTempLink().hashCode();
        }
        return (1 + l2 + i + j + k + l + i1 + j1 + k1 + l1 + i2 + j2 + k2) * 31 + super.hashCode();
    }

    public Boolean isExclusivelyTrashed()
    {
        return exclusivelyTrashed;
    }

    public Boolean isRecursivelyTrashed()
    {
        return recursivelyTrashed;
    }

    public Boolean isRoot()
    {
        return isRoot;
    }

    public Boolean isShared()
    {
        return isShared;
    }

    public void setAssets(List list)
    {
        assets = list;
    }

    public void setCreatedBy(String s)
    {
        createdBy = s;
    }

    public void setCreatedDate(String s)
    {
        createdDate = s;
    }

    public void setETagRequest(String s)
    {
        eTagRequest = s;
    }

    public void setETagResponse(String s)
    {
        eTagResponse = s;
    }

    public void setExclusivelyTrashed(Boolean boolean1)
    {
        exclusivelyTrashed = boolean1;
    }

    public void setIsRoot(Boolean boolean1)
    {
        isRoot = boolean1;
    }

    public void setIsShared(Boolean boolean1)
    {
        isShared = boolean1;
    }

    public void setModifiedDate(String s)
    {
        modifiedDate = s;
    }

    public void setRecursivelyTrashed(Boolean boolean1)
    {
        recursivelyTrashed = boolean1;
    }

    public void setTempLink(String s)
    {
        tempLink = s;
    }

    public void setVersion(long l)
    {
        version = l;
    }
}

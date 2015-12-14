// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.clouddrive.model:
//            IEditableNode, ContentProperties, CollectionProperties, Settings

public class EditableNode
    implements IEditableNode, Comparable
{

    private CollectionProperties collectionProperties;
    private ContentProperties contentProperties;
    private String description;
    private String id;
    private String kind;
    private List labels;
    private String name;
    private Map parentMap;
    private List parents;
    private Map properties;
    private Settings settings;
    private String status;
    private List transforms;

    public EditableNode()
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
        if (editablenode == this)
        {
            return 0;
        }
        obj = getName();
        obj1 = editablenode.getName();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getDescription();
        obj1 = editablenode.getDescription();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj = getParents();
        obj1 = editablenode.getParents();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        obj = getId();
        obj1 = editablenode.getId();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        obj = getContentProperties();
        obj1 = editablenode.getContentProperties();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        obj = getProperties();
        obj1 = editablenode.getProperties();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        obj = getKind();
        obj1 = editablenode.getKind();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L25:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        obj = getLabels();
        obj1 = editablenode.getLabels();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L29:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L33; else goto _L32
_L32:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L34
_L34:
        obj = getStatus();
        obj1 = editablenode.getStatus();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L33:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L37; else goto _L36
_L36:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L38
_L38:
        obj = getCollectionProperties();
        obj1 = editablenode.getCollectionProperties();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L37:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L41; else goto _L40
_L40:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L42
_L42:
        obj = getParentMap();
        obj1 = editablenode.getParentMap();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L41:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L45; else goto _L44
_L44:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L46
_L46:
        obj = getSettings();
        obj1 = editablenode.getSettings();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L45:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L46; else goto _L47
_L47:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L49; else goto _L48
_L48:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L50
_L50:
        obj = getTransforms();
        editablenode = editablenode.getTransforms();
        if (obj == editablenode)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L49:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L50; else goto _L51
_L51:
        if (editablenode == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L53; else goto _L52
_L52:
        k = ((Comparable)obj).compareTo(editablenode);
        i = k;
        if (k != 0) goto _L6; else goto _L54
_L54:
        return 0;
_L53:
        if (!obj.equals(editablenode))
        {
            int j = obj.hashCode();
            int l = editablenode.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L54; else goto _L55
_L55:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((EditableNode)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof EditableNode)
            {
                if (compareTo((EditableNode)obj) != 0)
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

    public CollectionProperties getCollectionProperties()
    {
        return collectionProperties;
    }

    public ContentProperties getContentProperties()
    {
        return contentProperties;
    }

    public String getDescription()
    {
        return description;
    }

    public String getId()
    {
        return id;
    }

    public String getKind()
    {
        return kind;
    }

    public List getLabels()
    {
        return labels;
    }

    public String getName()
    {
        return name;
    }

    public Map getParentMap()
    {
        return parentMap;
    }

    public List getParents()
    {
        return parents;
    }

    public Map getProperties()
    {
        return properties;
    }

    public Settings getSettings()
    {
        return settings;
    }

    public String getStatus()
    {
        return status;
    }

    public List getTransforms()
    {
        return transforms;
    }

    public int hashCode()
    {
        int i3 = 0;
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
        int k2;
        int l2;
        if (getName() == null)
        {
            i = 0;
        } else
        {
            i = getName().hashCode();
        }
        if (getDescription() == null)
        {
            j = 0;
        } else
        {
            j = getDescription().hashCode();
        }
        if (getParents() == null)
        {
            k = 0;
        } else
        {
            k = getParents().hashCode();
        }
        if (getId() == null)
        {
            l = 0;
        } else
        {
            l = getId().hashCode();
        }
        if (getContentProperties() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getContentProperties().hashCode();
        }
        if (getProperties() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getProperties().hashCode();
        }
        if (getKind() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getKind().hashCode();
        }
        if (getLabels() == null)
        {
            l1 = 0;
        } else
        {
            l1 = getLabels().hashCode();
        }
        if (getStatus() == null)
        {
            i2 = 0;
        } else
        {
            i2 = getStatus().hashCode();
        }
        if (getCollectionProperties() == null)
        {
            j2 = 0;
        } else
        {
            j2 = getCollectionProperties().hashCode();
        }
        if (getParentMap() == null)
        {
            k2 = 0;
        } else
        {
            k2 = getParentMap().hashCode();
        }
        if (getSettings() == null)
        {
            l2 = 0;
        } else
        {
            l2 = getSettings().hashCode();
        }
        if (getTransforms() != null)
        {
            i3 = getTransforms().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1 + l1 + i2 + j2 + k2 + l2 + i3;
    }

    public void setCollectionProperties(CollectionProperties collectionproperties)
    {
        collectionProperties = collectionproperties;
    }

    public void setContentProperties(ContentProperties contentproperties)
    {
        contentProperties = contentproperties;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setKind(String s)
    {
        kind = s;
    }

    public void setLabels(List list)
    {
        labels = list;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setParentMap(Map map)
    {
        parentMap = map;
    }

    public void setParents(List list)
    {
        parents = list;
    }

    public void setProperties(Map map)
    {
        properties = map;
    }

    public void setSettings(Settings settings1)
    {
        settings = settings1;
    }

    public void setStatus(String s)
    {
        status = s;
    }

    public void setTransforms(List list)
    {
        transforms = list;
    }
}

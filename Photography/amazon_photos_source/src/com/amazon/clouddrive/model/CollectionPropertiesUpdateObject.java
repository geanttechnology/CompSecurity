// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            ObjectComparator, CollectionProperties

public class CollectionPropertiesUpdateObject
    implements Comparable
{

    private CollectionProperties collectionProperties;
    private String op;
    private String path;

    public CollectionPropertiesUpdateObject()
    {
    }

    public int compareTo(CollectionPropertiesUpdateObject collectionpropertiesupdateobject)
    {
        int i;
        if (collectionpropertiesupdateobject == null)
        {
            i = -1;
        } else
        {
            if (collectionpropertiesupdateobject == this)
            {
                return 0;
            }
            int j = ObjectComparator.compare(getCollectionProperties(), collectionpropertiesupdateobject.getCollectionProperties());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getOp(), collectionpropertiesupdateobject.getOp());
                i = k;
                if (k == 0)
                {
                    int l = ObjectComparator.compare(getPath(), collectionpropertiesupdateobject.getPath());
                    i = l;
                    if (l == 0)
                    {
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CollectionPropertiesUpdateObject)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof CollectionPropertiesUpdateObject)
            {
                if (compareTo((CollectionPropertiesUpdateObject)obj) != 0)
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

    public String getOp()
    {
        return op;
    }

    public String getPath()
    {
        return path;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getCollectionProperties() == null)
        {
            i = 0;
        } else
        {
            i = getCollectionProperties().hashCode();
        }
        if (getOp() == null)
        {
            j = 0;
        } else
        {
            j = getOp().hashCode();
        }
        if (getPath() != null)
        {
            k = getPath().hashCode();
        }
        return 1 + i + j + k;
    }

    public void setCollectionProperties(CollectionProperties collectionproperties)
    {
        collectionProperties = collectionproperties;
    }

    public void setOp(String s)
    {
        op = s;
    }

    public void setPath(String s)
    {
        path = s;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveResponse, ObjectComparator, CollectionProperties

public class CollectionPropertiesResponse
    implements CloudDriveResponse
{

    private CollectionProperties collectionProperties;
    private String id;

    public CollectionPropertiesResponse()
    {
    }

    public int compareTo(CloudDriveResponse clouddriveresponse)
    {
        int i;
        if (clouddriveresponse == null)
        {
            i = -1;
        } else
        {
            if (clouddriveresponse == this)
            {
                return 0;
            }
            if (!(clouddriveresponse instanceof CollectionPropertiesResponse))
            {
                return 1;
            }
            clouddriveresponse = (CollectionPropertiesResponse)clouddriveresponse;
            int j = ObjectComparator.compare(getCollectionProperties(), clouddriveresponse.getCollectionProperties());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getId(), clouddriveresponse.getId());
                i = k;
                if (k == 0)
                {
                    return 0;
                }
            }
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveResponse)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof CollectionPropertiesResponse)
            {
                if (compareTo((CollectionPropertiesResponse)obj) != 0)
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

    public String getId()
    {
        return id;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getCollectionProperties() == null)
        {
            i = 0;
        } else
        {
            i = getCollectionProperties().hashCode();
        }
        if (getId() != null)
        {
            j = getId().hashCode();
        }
        return 1 + i + j;
    }

    public void setCollectionProperties(CollectionProperties collectionproperties)
    {
        collectionProperties = collectionproperties;
    }

    public void setId(String s)
    {
        id = s;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            ObjectComparator

public class CoverObject
    implements Comparable
{

    private String id;
    private Boolean isDefault;
    private String tempLink;

    public CoverObject()
    {
    }

    public int compareTo(CoverObject coverobject)
    {
        int i;
        if (coverobject == null)
        {
            i = -1;
        } else
        {
            if (coverobject == this)
            {
                return 0;
            }
            int j = ObjectComparator.compare(getId(), coverobject.getId());
            i = j;
            if (j == 0)
            {
                int k = ObjectComparator.compare(getTempLink(), coverobject.getTempLink());
                i = k;
                if (k == 0)
                {
                    int l = ObjectComparator.compare(isDefault(), coverobject.isDefault());
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
        return compareTo((CoverObject)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof CoverObject)
            {
                if (compareTo((CoverObject)obj) != 0)
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

    public String getId()
    {
        return id;
    }

    public String getTempLink()
    {
        return tempLink;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getId() == null)
        {
            i = 0;
        } else
        {
            i = getId().hashCode();
        }
        if (getTempLink() == null)
        {
            j = 0;
        } else
        {
            j = getTempLink().hashCode();
        }
        if (isDefault() != null)
        {
            k = isDefault().hashCode();
        }
        return 1 + i + j + k;
    }

    public Boolean isDefault()
    {
        return isDefault;
    }

    public void setDefault(Boolean boolean1)
    {
        isDefault = boolean1;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setTempLink(String s)
    {
        tempLink = s;
    }
}

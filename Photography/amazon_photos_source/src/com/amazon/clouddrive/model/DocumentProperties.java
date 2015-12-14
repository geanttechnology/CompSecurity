// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.util.List;

public class DocumentProperties
    implements Comparable
{

    private List authors;
    private String documentVersion;
    private String title;

    public DocumentProperties()
    {
    }

    public int compareTo(DocumentProperties documentproperties)
    {
        if (documentproperties != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (documentproperties == this)
        {
            return 0;
        }
        obj = getTitle();
        obj1 = documentproperties.getTitle();
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
        obj = getAuthors();
        obj1 = documentproperties.getAuthors();
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
        obj = getDocumentVersion();
        documentproperties = documentproperties.getDocumentVersion();
        if (obj == documentproperties)
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
        if (documentproperties == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(documentproperties);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        return 0;
_L13:
        if (!obj.equals(documentproperties))
        {
            int j = obj.hashCode();
            int l = documentproperties.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L14; else goto _L15
_L15:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((DocumentProperties)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof DocumentProperties)
            {
                if (compareTo((DocumentProperties)obj) != 0)
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

    public List getAuthors()
    {
        return authors;
    }

    public String getDocumentVersion()
    {
        return documentVersion;
    }

    public String getTitle()
    {
        return title;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getTitle() == null)
        {
            i = 0;
        } else
        {
            i = getTitle().hashCode();
        }
        if (getAuthors() == null)
        {
            j = 0;
        } else
        {
            j = getAuthors().hashCode();
        }
        if (getDocumentVersion() != null)
        {
            k = getDocumentVersion().hashCode();
        }
        return 1 + i + j + k;
    }

    public void setAuthors(List list)
    {
        authors = list;
    }

    public void setDocumentVersion(String s)
    {
        documentVersion = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}

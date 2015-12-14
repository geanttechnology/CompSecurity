// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;


// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveRequest

public class GetNodeRequest
    implements CloudDriveRequest
{

    private String assetMapping;
    private String fields;
    private String id;
    private Boolean tempLink;

    public GetNodeRequest(String s)
    {
        id = s;
    }

    public int compareTo(CloudDriveRequest clouddriverequest)
    {
        if (clouddriverequest != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        String s;
        if (clouddriverequest == this)
        {
            return 0;
        }
        if (!(clouddriverequest instanceof GetNodeRequest))
        {
            return 1;
        }
        clouddriverequest = (GetNodeRequest)clouddriverequest;
        obj = getId();
        s = clouddriverequest.getId();
        if (obj == s)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (s == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(s);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = getFields();
        s = clouddriverequest.getFields();
        if (obj == s)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(s))
        {
            i = obj.hashCode();
            k = s.hashCode();
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
        if (s == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(s);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj = getAssetMapping();
        s = clouddriverequest.getAssetMapping();
        if (obj == s)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj.equals(s))
        {
            i = obj.hashCode();
            k = s.hashCode();
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
        if (s == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(s);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        obj = getTempLink();
        clouddriverequest = clouddriverequest.getTempLink();
        if (obj == clouddriverequest)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!obj.equals(s))
        {
            i = obj.hashCode();
            k = s.hashCode();
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
        if (clouddriverequest == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)obj).compareTo(clouddriverequest);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        return 0;
_L17:
        if (!obj.equals(clouddriverequest))
        {
            int j = obj.hashCode();
            int l = clouddriverequest.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L18; else goto _L19
_L19:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof GetNodeRequest)
            {
                if (compareTo((GetNodeRequest)obj) != 0)
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

    public String getAssetMapping()
    {
        return assetMapping;
    }

    public String getFields()
    {
        return fields;
    }

    public String getId()
    {
        return id;
    }

    public Boolean getTempLink()
    {
        return tempLink;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (getId() == null)
        {
            i = 0;
        } else
        {
            i = getId().hashCode();
        }
        if (getFields() == null)
        {
            j = 0;
        } else
        {
            j = getFields().hashCode();
        }
        if (getAssetMapping() == null)
        {
            k = 0;
        } else
        {
            k = getAssetMapping().hashCode();
        }
        if (getTempLink().booleanValue())
        {
            l = 1;
        }
        return 1 + i + j + k + l;
    }
}

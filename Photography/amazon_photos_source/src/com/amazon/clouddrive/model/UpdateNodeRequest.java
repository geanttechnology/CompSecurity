// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import com.amazon.clouddrive.utils.Optional;

// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveRequest, Settings

public class UpdateNodeRequest
    implements CloudDriveRequest
{

    private Optional mDescription;
    private String mId;
    private Optional mLabels;
    private Optional mName;
    private Optional mSettings;

    public UpdateNodeRequest(String s)
    {
        mName = Optional.absent();
        mDescription = Optional.absent();
        mLabels = Optional.absent();
        mSettings = Optional.absent();
        mId = s;
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
        Object obj1;
        if (clouddriverequest == this)
        {
            return 0;
        }
        if (!(clouddriverequest instanceof UpdateNodeRequest))
        {
            return 1;
        }
        clouddriverequest = (UpdateNodeRequest)clouddriverequest;
        obj = getName();
        obj1 = clouddriverequest.getName();
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
        obj1 = clouddriverequest.getDescription();
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
        obj = getId();
        obj1 = clouddriverequest.getId();
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
        obj = getLabels();
        obj1 = clouddriverequest.getLabels();
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
        obj = getSettings();
        clouddriverequest = clouddriverequest.getSettings();
        if (obj == clouddriverequest)
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
        if (clouddriverequest == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj).compareTo(clouddriverequest);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        return 0;
_L21:
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
        if (true) goto _L22; else goto _L23
_L23:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof UpdateNodeRequest)
            {
                if (compareTo((UpdateNodeRequest)obj) != 0)
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

    public Optional getDescription()
    {
        return mDescription;
    }

    public String getId()
    {
        return mId;
    }

    public Optional getLabels()
    {
        return mLabels;
    }

    public Optional getName()
    {
        return mName;
    }

    public Optional getSettings()
    {
        return mSettings;
    }

    public int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
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
        if (getId() == null)
        {
            k = 0;
        } else
        {
            k = getId().hashCode();
        }
        if (getLabels() == null)
        {
            l = 0;
        } else
        {
            l = getLabels().hashCode();
        }
        if (getSettings() != null)
        {
            i1 = getSettings().hashCode();
        }
        return 1 + i + j + k + l + i1;
    }

    public void setName(String s)
    {
        mName = Optional.of(s);
    }

    public void setSettings(Settings settings)
    {
        mSettings = Optional.of(settings);
    }
}

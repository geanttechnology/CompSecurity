// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.io.OutputStream;

// Referenced classes of package com.amazon.clouddrive.model:
//            CloudDriveRequest, ObjectComparator

public class DownloadFileRequest
    implements CloudDriveRequest
{

    private int mBlockSize;
    private String mId;
    private OutputStream mOutputStream;
    private int mResolution;
    private String mTransform;
    private int mViewBox;

    public DownloadFileRequest(String s, OutputStream outputstream)
    {
        mViewBox = -1;
        mBlockSize = 32768;
        mResolution = -1;
        mId = s;
        mOutputStream = outputstream;
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
        if (!(clouddriverequest instanceof DownloadFileRequest))
        {
            return 1;
        }
        clouddriverequest = (DownloadFileRequest)clouddriverequest;
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
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int i1;
        i1 = ((Comparable)obj).compareTo(obj1);
        i = i1;
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        obj = Integer.valueOf(getViewBox());
        obj1 = Integer.valueOf(clouddriverequest.getViewBox());
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
            i1 = obj1.hashCode();
            if (i < i1)
            {
                return -1;
            }
            if (i > i1)
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
        i1 = ((Comparable)obj).compareTo(obj1);
        i = i1;
        if (i1 != 0) goto _L6; else goto _L10
_L10:
        obj = getOutputStream();
        obj1 = clouddriverequest.getOutputStream();
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
            i1 = obj1.hashCode();
            if (i < i1)
            {
                return -1;
            }
            if (i > i1)
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
        i1 = ((Comparable)obj).compareTo(obj1);
        i = i1;
        if (i1 != 0) goto _L6; else goto _L14
_L14:
        obj = Integer.valueOf(getBlockSize());
        obj1 = Integer.valueOf(clouddriverequest.getBlockSize());
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
            i1 = obj1.hashCode();
            if (i < i1)
            {
                return -1;
            }
            if (i > i1)
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
        i1 = ((Comparable)obj).compareTo(obj1);
        i = i1;
        if (i1 != 0) goto _L6; else goto _L18
_L18:
        int j = ObjectComparator.compare(getTransform(), clouddriverequest.getTransform());
        if (j != 0)
        {
            return j;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!obj.equals(obj1))
        {
            int k = obj.hashCode();
            int j1 = obj1.hashCode();
            if (k < j1)
            {
                return -1;
            }
            if (k > j1)
            {
                return 1;
            }
        }
        if (true) goto _L18; else goto _L19
_L19:
        int l = ObjectComparator.compare(Integer.valueOf(getResolution()), Integer.valueOf(clouddriverequest.getResolution()));
        if (l != 0)
        {
            return l;
        } else
        {
            return 0;
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveRequest)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof DownloadFileRequest)
            {
                if (compareTo((DownloadFileRequest)obj) != 0)
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

    public int getBlockSize()
    {
        return mBlockSize;
    }

    public String getId()
    {
        return mId;
    }

    public OutputStream getOutputStream()
    {
        return mOutputStream;
    }

    public int getResolution()
    {
        return mResolution;
    }

    public String getTransform()
    {
        return mTransform;
    }

    public int getViewBox()
    {
        return mViewBox;
    }

    public boolean hasResolution()
    {
        return getResolution() > 0;
    }

    public boolean hasTransform()
    {
        return getTransform() != null;
    }

    public boolean hasViewBoxSet()
    {
        return mViewBox > 0;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        int k;
        int l;
        if (getId() == null)
        {
            i = 0;
        } else
        {
            i = getId().hashCode();
        }
        k = getViewBox();
        l = mOutputStream.hashCode();
        if (getTransform() != null)
        {
            j = getTransform().hashCode();
        }
        return 1 + i + k + l + j + getResolution();
    }

    public void setResolution(int i)
    {
        mResolution = i;
    }

    public void setTransform(String s)
    {
        mTransform = s;
    }

    public void setViewBox(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("viewBox must be greater than 0");
        } else
        {
            mViewBox = i;
            return;
        }
    }
}

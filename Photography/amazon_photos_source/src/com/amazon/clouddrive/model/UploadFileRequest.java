// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model;

import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.amazon.clouddrive.model:
//            PostNodeRequest, Suppress, EditableNodeRequest

public class UploadFileRequest extends PostNodeRequest
{

    private int mBlockSize;
    private int mChunkSize;
    private long mContentLength;
    private InputStream mInputStream;
    private String mMD5;
    private Suppress mSuppress;
    private boolean mUseChunkedStreaming;

    public UploadFileRequest(String s, InputStream inputstream, long l)
    {
        mBlockSize = 32768;
        mUseChunkedStreaming = false;
        mChunkSize = 0;
        setName(s);
        setKind("FILE");
        mInputStream = inputstream;
        mContentLength = l;
    }

    public int compareTo(EditableNodeRequest editablenoderequest)
    {
        if (editablenoderequest != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        Object obj2;
        if (editablenoderequest == this)
        {
            return 0;
        }
        if (!(editablenoderequest instanceof UploadFileRequest))
        {
            return 1;
        }
        obj = (UploadFileRequest)editablenoderequest;
        obj1 = getInputStream();
        obj2 = ((UploadFileRequest) (obj)).getInputStream();
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
        obj1 = Integer.valueOf(getBlockSize());
        obj2 = Integer.valueOf(((UploadFileRequest) (obj)).getBlockSize());
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
        obj1 = getSuppress();
        obj2 = ((UploadFileRequest) (obj)).getSuppress();
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
        obj1 = Long.valueOf(getContentLength());
        obj2 = Long.valueOf(((UploadFileRequest) (obj)).getContentLength());
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
        obj1 = Boolean.valueOf(useChunkedStreaming());
        obj2 = Boolean.valueOf(((UploadFileRequest) (obj)).useChunkedStreaming());
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
        obj1 = Integer.valueOf(getChunkSize());
        obj2 = Integer.valueOf(((UploadFileRequest) (obj)).getChunkSize());
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
        obj1 = getMD5();
        obj = ((UploadFileRequest) (obj)).getMD5();
        if (obj1 == obj)
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
        if (obj == null)
        {
            return 1;
        }
        if (!(obj1 instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)obj1).compareTo(obj);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        return super.compareTo(editablenoderequest);
_L29:
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
        if (true) goto _L30; else goto _L31
_L31:
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof UploadFileRequest)
            {
                if (compareTo((UploadFileRequest)obj) != 0)
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

    public int getChunkSize()
    {
        return mChunkSize;
    }

    public long getContentLength()
    {
        return mContentLength;
    }

    public InputStream getInputStream()
    {
        return mInputStream;
    }

    public String getMD5()
    {
        return mMD5;
    }

    public String getSuppress()
    {
        if (mSuppress == null)
        {
            return null;
        } else
        {
            return mSuppress.parameter;
        }
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        if (getInputStream() == null)
        {
            i = 0;
        } else
        {
            i = getInputStream().hashCode();
        }
        l = Integer.valueOf(getBlockSize()).hashCode();
        if (getSuppress() == null)
        {
            j = 0;
        } else
        {
            j = getSuppress().hashCode();
        }
        i1 = Long.valueOf(getContentLength()).hashCode();
        j1 = Boolean.valueOf(useChunkedStreaming()).hashCode();
        k1 = Integer.valueOf(getChunkSize()).hashCode();
        if (getMD5() != null)
        {
            k = getMD5().hashCode();
        }
        return (1 + i + l + j + i1 + j1 + k1 + k) * 31 + super.hashCode();
    }

    public void setChunkedStreaming(boolean flag)
    {
        mUseChunkedStreaming = flag;
    }

    public void setSuppress(Suppress suppress)
    {
        mSuppress = suppress;
    }

    public boolean useChunkedStreaming()
    {
        return mUseChunkedStreaming;
    }

    public UploadFileRequest withChunkedStreaming(boolean flag)
    {
        setChunkedStreaming(flag);
        return this;
    }

    public UploadFileRequest withKind(String s)
    {
        setKind(s);
        return this;
    }

    public UploadFileRequest withParents(List list)
    {
        setParents(list);
        return this;
    }
}

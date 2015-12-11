// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v1;

import java.util.Map;

// Referenced classes of package com.amazon.bluefront.api.v1:
//            RecognitionParameters

public class RequestParameters
    implements Comparable
{

    private Map mMetadata;
    private RecognitionParameters mRecognitionParameters;
    private String mRequestId;

    public RequestParameters()
    {
    }

    public int compareTo(RequestParameters requestparameters)
    {
        if (requestparameters != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (requestparameters == this)
        {
            return 0;
        }
        obj = getRequestId();
        obj1 = requestparameters.getRequestId();
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
        obj = getRecognitionParameters();
        obj1 = requestparameters.getRecognitionParameters();
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
        obj = getMetadata();
        requestparameters = requestparameters.getMetadata();
        if (obj == requestparameters)
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
        if (requestparameters == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(requestparameters);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        return 0;
_L13:
        if (!obj.equals(requestparameters))
        {
            int j = obj.hashCode();
            int l = requestparameters.hashCode();
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
        return compareTo((RequestParameters)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof RequestParameters)
            {
                if (compareTo((RequestParameters)obj) != 0)
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

    public Map getMetadata()
    {
        return mMetadata;
    }

    public RecognitionParameters getRecognitionParameters()
    {
        return mRecognitionParameters;
    }

    public String getRequestId()
    {
        return mRequestId;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getRequestId() == null)
        {
            i = 0;
        } else
        {
            i = getRequestId().hashCode();
        }
        if (getRecognitionParameters() == null)
        {
            j = 0;
        } else
        {
            j = getRecognitionParameters().hashCode();
        }
        if (getMetadata() != null)
        {
            k = getMetadata().hashCode();
        }
        return 1 + i + j + k;
    }

    public void setMetadata(Map map)
    {
        mMetadata = map;
    }

    public void setRecognitionParameters(RecognitionParameters recognitionparameters)
    {
        mRecognitionParameters = recognitionparameters;
    }

    public void setRequestId(String s)
    {
        mRequestId = s;
    }
}

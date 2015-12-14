// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.CloudDriveResponse;

public class GetSplashResponse
    implements CloudDriveResponse
{

    private String splashId;
    private String splashText;
    private String url;

    public GetSplashResponse()
    {
    }

    public int compareTo(CloudDriveResponse clouddriveresponse)
    {
        if (clouddriveresponse != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (clouddriveresponse == this)
        {
            return 0;
        }
        if (!(clouddriveresponse instanceof GetSplashResponse))
        {
            return 1;
        }
        clouddriveresponse = (GetSplashResponse)clouddriveresponse;
        s = getSplashText();
        s1 = clouddriveresponse.getSplashText();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        s = getSplashId();
        s1 = clouddriveresponse.getSplashId();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        s = getUrl();
        clouddriveresponse = clouddriveresponse.getUrl();
        if (s == clouddriveresponse)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
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
        if (clouddriveresponse == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)s).compareTo(clouddriveresponse);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        return 0;
_L13:
        if (!s.equals(clouddriveresponse))
        {
            int j = s.hashCode();
            int l = clouddriveresponse.hashCode();
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
        return compareTo((CloudDriveResponse)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof GetSplashResponse)
            {
                if (compareTo((GetSplashResponse)obj) != 0)
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

    public String getSplashId()
    {
        return splashId;
    }

    public String getSplashText()
    {
        return splashText;
    }

    public String getUrl()
    {
        return url;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (getSplashText() == null)
        {
            i = 0;
        } else
        {
            i = getSplashText().hashCode();
        }
        if (getSplashId() == null)
        {
            j = 0;
        } else
        {
            j = getSplashId().hashCode();
        }
        if (getUrl() != null)
        {
            k = getUrl().hashCode();
        }
        return (1 + i + j + k) * 31 + super.hashCode();
    }

    public void setSplashId(String s)
    {
        splashId = s;
    }

    public void setSplashText(String s)
    {
        splashText = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}

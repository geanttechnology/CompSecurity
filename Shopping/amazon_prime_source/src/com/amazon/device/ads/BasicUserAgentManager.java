// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            UserAgentManager, AndroidTargetUtils, Version

class BasicUserAgentManager
    implements UserAgentManager
{

    private String userAgentStringWithSDKVersion;
    private String userAgentStringWithoutSDKVersion;

    BasicUserAgentManager()
    {
    }

    void buildAndSetUserAgentString(Context context)
    {
        setUserAgentString("");
    }

    public String getUserAgentString()
    {
        return userAgentStringWithSDKVersion;
    }

    public void populateUserAgentString(Context context)
    {
label0:
        {
            if (userAgentStringWithSDKVersion == null)
            {
                if (!AndroidTargetUtils.isAtLeastAndroidAPI(7))
                {
                    break label0;
                }
                setUserAgentString(System.getProperty("http.agent"));
            }
            return;
        }
        buildAndSetUserAgentString(context);
    }

    public void setUserAgentString(String s)
    {
        if (s != null && !s.equals(userAgentStringWithoutSDKVersion))
        {
            userAgentStringWithoutSDKVersion = s;
            userAgentStringWithSDKVersion = (new StringBuilder()).append(s).append(" ").append(Version.getUserAgentSDKVersion()).toString();
        }
    }
}

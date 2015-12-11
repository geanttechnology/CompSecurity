// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.WebSettings;

// Referenced classes of package com.amazon.device.ads:
//            AndroidTargetUtils, AndroidBuildInfo

public static class androidBuildInfo
{
    public class WebSettingsAdapter
    {

        final AndroidTargetUtils.AndroidClassAdapter this$0;
        private final WebSettings webSettings;

        public void setMediaPlaybackRequiresUserGesture(boolean flag)
        {
            if (isAtLeastAndroidAPI(17))
            {
                AndroidTargetUtils.JellyBeanMR1TargetUtils.setMediaPlaybackRequiresUserGesture(webSettings, flag);
            }
        }

        public WebSettingsAdapter(WebSettings websettings)
        {
            this$0 = AndroidTargetUtils.AndroidClassAdapter.this;
            super();
            webSettings = websettings;
        }
    }


    private final AndroidBuildInfo androidBuildInfo;

    private boolean isAtLeastAndroidAPI(int i)
    {
        return AndroidTargetUtils.isAtLeastAndroidAPI(androidBuildInfo, i);
    }

    public WebSettingsAdapter withWebSettings(WebSettings websettings)
    {
        return new WebSettingsAdapter(websettings);
    }


    public WebSettingsAdapter.webSettings(AndroidBuildInfo androidbuildinfo)
    {
        androidBuildInfo = androidbuildinfo;
    }
}

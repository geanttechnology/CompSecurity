// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.xfinity.playerlib.model.videoplay.PlayerConfigurationListener;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class it> extends PlayerConfigurationListener
{

    final PreDownloadFlowFragment this$0;

    public void configurationFailed(String s)
    {
        super.configurationFailed(s);
        throw new CimException(s);
    }

    public void configurationLoaded()
    {
        super.configurationLoaded();
        PreDownloadFlowFragment.access$4100(PreDownloadFlowFragment.this);
    }

    ()
    {
        this$0 = PreDownloadFlowFragment.this;
        super();
    }
}

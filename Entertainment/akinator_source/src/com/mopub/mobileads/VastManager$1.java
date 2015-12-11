// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            VastManager, VastVideoConfig

class g
    implements oadTask.VastVideoDownloadTaskListener
{

    final VastManager this$0;
    final VastVideoConfig val$vastVideoConfig;

    public void onComplete(boolean flag)
    {
        if (flag && VastManager.access$000(VastManager.this, val$vastVideoConfig))
        {
            VastManager.access$100(VastManager.this).onVastVideoConfigurationPrepared(val$vastVideoConfig);
            return;
        } else
        {
            VastManager.access$100(VastManager.this).onVastVideoConfigurationPrepared(null);
            return;
        }
    }

    g()
    {
        this$0 = final_vastmanager;
        val$vastVideoConfig = VastVideoConfig.this;
        super();
    }
}

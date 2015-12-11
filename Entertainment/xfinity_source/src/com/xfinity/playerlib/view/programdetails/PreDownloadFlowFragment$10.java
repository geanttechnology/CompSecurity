// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.xfinity.playerlib.authorization.SMILResource;
import com.xfinity.playerlib.authorization.ThePlatformClient;
import com.xfinity.playerlib.model.consumable.hal.HalVideoProfile;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls0 extends NonCachingBaseTask
{

    final PreDownloadFlowFragment this$0;

    public SMILResource execute()
    {
        return PreDownloadFlowFragment.access$1300(PreDownloadFlowFragment.this).getSMILResource(PreDownloadFlowFragment.access$1200(PreDownloadFlowFragment.this).getManifestUrl());
    }

    public volatile Object execute()
    {
        return execute();
    }

    ()
    {
        this$0 = PreDownloadFlowFragment.this;
        super();
    }
}

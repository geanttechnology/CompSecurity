// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.xfinity.playerlib.downloads.TitaniumTicket;
import com.xfinity.playerlib.downloads.TitaniumTicketClient;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls0 extends NonCachingBaseTask
{

    final PreDownloadFlowFragment this$0;

    public TitaniumTicket execute()
    {
        return PreDownloadFlowFragment.access$3700(PreDownloadFlowFragment.this).getTitaniumTicket(((PlayNowUser)PreDownloadFlowFragment.access$900(PreDownloadFlowFragment.this).getUser()).getAuthKeys(), PreDownloadFlowFragment.access$200(PreDownloadFlowFragment.this), PreDownloadFlowFragment.access$1200(PreDownloadFlowFragment.this));
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

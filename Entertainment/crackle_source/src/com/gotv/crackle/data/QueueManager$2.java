// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;

// Referenced classes of package com.gotv.crackle.data:
//            QueueManager, Localization

class val.tag extends Thread
{

    final QueueManager this$0;
    final String val$queueTitle;
    final String val$tag;

    public void run()
    {
        QueueManager.access$002(QueueManager.this, String.format("http://%s/queue/%s/list/member/%s/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$queueTitle, QueueManager.access$100(QueueManager.this), Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
        }));
        QueueManager.access$200(QueueManager.this, false, val$tag);
    }

    ()
    {
        this$0 = final_queuemanager;
        val$queueTitle = s;
        val$tag = String.this;
        super();
    }
}

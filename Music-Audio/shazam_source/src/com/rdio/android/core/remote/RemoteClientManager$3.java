// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.remote;

import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.util.Logging;

// Referenced classes of package com.rdio.android.core.remote:
//            RemoteClientManager

class this._cls0
    implements com.rdio.android.core.seListener
{

    final RemoteClientManager this$0;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        if (rdioapiresponse.isSuccess())
        {
            logging.log(3, "RemoteClientManager", "Successfully updated active player with web service");
        } else
        {
            logging.log(3, "RemoteClientManager", "Failed to update active player with web service");
        }
        RemoteClientManager.access$200(RemoteClientManager.this).run();
    }

    ner()
    {
        this$0 = RemoteClientManager.this;
        super();
    }
}

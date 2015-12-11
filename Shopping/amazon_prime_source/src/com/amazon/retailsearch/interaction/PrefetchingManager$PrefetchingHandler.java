// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            PrefetchingManager, SearchDataSource

class this._cls0 extends Handler
{

    final PrefetchingManager this$0;

    public void handleMessage(Message message)
    {
        if ((message.what == 1 || message.what == 2) && (message.obj instanceof RetailSearchQuery))
        {
            searchDataSource.prefetchQuery((RetailSearchQuery)message.obj);
        }
    }

    public (Looper looper)
    {
        this$0 = PrefetchingManager.this;
        super(looper);
    }
}

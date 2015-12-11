// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import com.arellomobile.android.push.utils.executor.ExecutorHelper;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager

class val.regId
    implements Runnable
{

    final PushManager this$0;
    final Context val$context;
    final String val$regId;

    public void run()
    {
        android.os.AsyncTask _tmp = PushManager.access$002(PushManager.access$100(PushManager.this, val$context, val$regId));
        ExecutorHelper.executeAsyncTask(PushManager.access$000());
    }

    .ExecutorHelper()
    {
        this$0 = final_pushmanager;
        val$context = context1;
        val$regId = String.this;
        super();
    }
}

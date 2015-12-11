// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import dav;
import java.util.concurrent.Executor;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3DataManager

class val.postDelete extends dav
{

    final Greco3DataManager this$0;
    final Runnable val$postDelete;

    public void run()
    {
        blockingUpdateResources(true);
        if (val$postDelete != null)
        {
            Greco3DataManager.access$300(Greco3DataManager.this).execute(val$postDelete);
        }
    }

    transient (int ai[], Runnable runnable)
    {
        this$0 = final_greco3datamanager;
        val$postDelete = runnable;
        super(String.this, ai);
    }
}

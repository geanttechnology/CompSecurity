// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import dav;
import java.io.File;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3EngineManager

class val.completionCb extends dav
{

    final Greco3EngineManager this$0;
    final Runnable val$completionCb;
    final boolean val$force;
    final File val$path;

    public void run()
    {
        Greco3EngineManager.access$100(Greco3EngineManager.this, val$path, val$force);
        if (val$completionCb != null)
        {
            val$completionCb.run();
        }
    }

    transient (boolean flag, Runnable runnable)
    {
        this$0 = final_greco3enginemanager;
        val$path = File.this;
        val$force = flag;
        val$completionCb = runnable;
        super(final_s, final_ai);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.util.Log;

// Referenced classes of package net.singular.sdk:
//            PostableWorker, SingularLog

class val.name
    implements ceptionHandler
{

    final PostableWorker this$0;
    final SingularLog val$log;
    final String val$name;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (val$log != null)
        {
            val$log.e("singular_sdk", String.format("%s background thread had died.", new Object[] {
                val$name
            }), throwable);
            return;
        } else
        {
            Log.e("singular_sdk", String.format("%s background thread had died.", new Object[] {
                val$name
            }), throwable);
            return;
        }
    }

    Handler()
    {
        this$0 = final_postableworker;
        val$log = singularlog;
        val$name = String.this;
        super();
    }
}

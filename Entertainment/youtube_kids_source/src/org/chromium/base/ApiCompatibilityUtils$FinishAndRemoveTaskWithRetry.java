// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.app.Activity;

// Referenced classes of package org.chromium.base:
//            ThreadUtils

class 
    implements Runnable
{

    private final Activity a;
    private int b;

    public void run()
    {
label0:
        {
            a.finishAndRemoveTask();
            b = b + 1;
            if (!a.isFinishing())
            {
                if ((long)b >= 3L)
                {
                    break label0;
                }
                ThreadUtils.a(this, 500L);
            }
            return;
        }
        a.finish();
    }
}

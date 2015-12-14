// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import java.io.File;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            AidTask

class this._cls0
    implements Runnable
{

    final AidTask this$0;

    public void run()
    {
        int i = 0;
        do
        {
            if (i >= 1)
            {
                return;
            }
            File file = AidTask.access$0(AidTask.this, i);
            try
            {
                file.delete();
            }
            catch (Exception exception) { }
            i++;
        } while (true);
    }

    ()
    {
        this$0 = AidTask.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;


// Referenced classes of package com.amazon.dcp.settings:
//            BackgroundSynchronizer, SettingsCacheUpdater

class this._cls0
    implements Runnable
{

    final BackgroundSynchronizer this$0;

    public void run()
    {
        try
        {
            BackgroundSynchronizer.access$100(BackgroundSynchronizer.this).updateFromContentProvider(BackgroundSynchronizer.access$000(BackgroundSynchronizer.this));
            BackgroundSynchronizer.access$200(BackgroundSynchronizer.this, false, null);
            return;
        }
        catch (Throwable throwable)
        {
            BackgroundSynchronizer.access$200(BackgroundSynchronizer.this, false, throwable);
        }
    }

    ()
    {
        this$0 = BackgroundSynchronizer.this;
        super();
    }
}

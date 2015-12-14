// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.support.v4.app.FragmentActivity;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoSaveManagerImpl, NewFeatureNotification

class this._cls0
    implements Runnable
{

    final AutoSaveManagerImpl this$0;

    public void run()
    {
        NewFeatureNotification.launchNewFeatureNotificationIfNeverSeen((FragmentActivity)AutoSaveManagerImpl.access$1100(AutoSaveManagerImpl.this));
    }

    ()
    {
        this$0 = AutoSaveManagerImpl.this;
        super();
    }
}

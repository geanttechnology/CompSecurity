// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;


// Referenced classes of package com.crashlytics.android.beta:
//            ActivityLifecycleCheckForUpdatesController

class this._cls1
    implements Runnable
{

    final kForUpdates this$1;

    public void run()
    {
        checkForUpdates();
    }

    Q()
    {
        this$1 = this._cls1.this;
        super();
    }
}

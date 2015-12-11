// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import com.newrelic.agent.android.background.ApplicationStateMonitor;

// Referenced classes of package com.newrelic.agent.android.util:
//            UiBackgroundListener

class this._cls0
    implements Runnable
{

    final UiBackgroundListener this$0;

    public void run()
    {
        ApplicationStateMonitor.getInstance().uiHidden();
    }

    onitor()
    {
        this$0 = UiBackgroundListener.this;
        super();
    }
}

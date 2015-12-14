// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.amazon.gallery.framework.gallery.view:
//            ViewNotificationManager, ViewStateListener

class this._cls0
    implements Runnable
{

    final ViewNotificationManager this$0;

    public void run()
    {
        for (Iterator iterator = ViewNotificationManager.access$000(ViewNotificationManager.this).iterator(); iterator.hasNext(); ((ViewStateListener)iterator.next()).onExitFullScreen()) { }
    }

    I()
    {
        this$0 = ViewNotificationManager.this;
        super();
    }
}

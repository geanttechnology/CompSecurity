// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            UploadNotification

class this._cls0 extends BroadcastReceiver
{

    final UploadNotification this$0;

    public void onReceive(Context context, Intent intent)
    {
        handleIntent(intent);
    }

    ()
    {
        this$0 = UploadNotification.this;
        super();
    }
}

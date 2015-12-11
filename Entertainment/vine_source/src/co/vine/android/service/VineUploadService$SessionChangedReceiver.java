// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.client.VineAccountHelper;

// Referenced classes of package co.vine.android.service:
//            VineUploadService

public class this._cls0 extends BroadcastReceiver
{

    final VineUploadService this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null && ("co.vine.android.session.logout".equals(intent.getAction()) || "co.vine.android.session.login".equals(intent.getAction())))
        {
            VineAccountHelper.resetActiveSession();
        }
    }

    public ()
    {
        this$0 = VineUploadService.this;
        super();
    }
}

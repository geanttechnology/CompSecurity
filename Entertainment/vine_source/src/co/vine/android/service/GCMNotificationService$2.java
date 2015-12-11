// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.edisonwang.android.slog.SLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android.service:
//            GCMNotificationService

class this._cls0 extends BroadcastReceiver
{

    final GCMNotificationService this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = GCMNotificationService.access$200(GCMNotificationService.this);
        context;
        JVM INSTR monitorenter ;
        SLog.d("Received camera request result: {}.", intent);
        if ("co.vine.android.camera.request.conversation.state.on".equals(intent.getAction()))
        {
            long l = intent.getLongExtra("co.vine.android.camera.request.conversation.state.id", -1L);
            GCMNotificationService.access$200(GCMNotificationService.this).remove(Long.valueOf(l));
            GCMNotificationService.access$300(GCMNotificationService.this, intent.getIntExtra("notification_id", 2), l);
        }
        for (intent = GCMNotificationService.access$200(GCMNotificationService.this).values().iterator(); intent.hasNext(); ((ildableNotification)intent.next()).build()) { }
        break MISSING_BLOCK_LABEL_113;
        intent;
        context;
        JVM INSTR monitorexit ;
        throw intent;
        GCMNotificationService.access$200(GCMNotificationService.this).clear();
        context;
        JVM INSTR monitorexit ;
    }

    ildableNotification()
    {
        this$0 = GCMNotificationService.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.penthera.virtuososdk.service:
//            VirtuosoService

class this._cls0 extends BroadcastReceiver
{

    final VirtuosoService this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (context == null)
        {
            com.penthera.virtuososdk.utility.adCallbackType("VirtuosoService-ApiReceiver", "onReceive(): null action");
        } else
        {
            com.penthera.virtuososdk.utility.adCallbackType("VirtuosoService-ApiReceiver", (new StringBuilder("got action [")).append(context).append("]").toString());
            if (!context.equals("virtuoso.intent.action.COMMS_FAILURE"))
            {
                if (context.equals("virtuoso.intent.action.QUEUE_CHANGED"))
                {
                    context = intent.getExtras();
                    VirtuosoService.access$8(VirtuosoService.this, context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.adCallbackType.EDownloadQueueChanged, context);
                    VirtuosoService.access$9(VirtuosoService.this, context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.adCallbackType.EFullListChanged, context);
                    return;
                }
                if (context.equals("virtuoso.intent.action.DOWNLOAD_LIST_CHANGED"))
                {
                    context = intent.getExtras();
                    VirtuosoService.access$8(VirtuosoService.this, context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.adCallbackType.EDownloadedListChanged, context);
                    VirtuosoService.access$9(VirtuosoService.this, context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.adCallbackType.EFullListChanged, context);
                    return;
                }
                if (context.equals("virtuoso.intent.action.INTENT_FRAGMENT_COMPLETE_CALLBACK"))
                {
                    context = intent.getExtras();
                    VirtuosoService.access$10(VirtuosoService.this, context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.adCallbackType.EFragmentComplete, context);
                    return;
                }
                if (context.equals("virtuoso.intent.action.DOWNLOAD_CALLBACK"))
                {
                    if (!VirtuosoService.access$11(VirtuosoService.this))
                    {
                        com.penthera.virtuososdk.utility.sts.sendBroadcast("virtuoso.intent.action.DOWNLOAD_UPDATE");
                    }
                    context = intent.getExtras();
                    VirtuosoService.access$8(VirtuosoService.this, context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.adCallbackType.values()[context.getInt("download_update_type")], context.getParcelable("download_update_data"));
                    return;
                }
                if (context.equals("virtuoso.intent.action.SETTING_CHANGED"))
                {
                    context = intent.getExtras();
                    VirtuosoService.access$8(VirtuosoService.this, context.getString("com.penthera.virtuososdk.client.pckg"), com.penthera.virtuososdk.utility.adCallbackType.ESettingsChanged, context);
                    return;
                } else
                {
                    com.penthera.virtuososdk.utility.ttingsChanged("VirtuosoService-ApiReceiver", (new StringBuilder("onReceive(): unknown action: ")).append(context).toString());
                    return;
                }
            }
        }
    }

    sts()
    {
        this$0 = VirtuosoService.this;
        super();
    }
}

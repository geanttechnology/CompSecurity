// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.Context;
import android.content.Intent;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.event.BackgroundEvent;
import com.exacttarget.etpushsdk.event.BackgroundEventListener;
import com.exacttarget.etpushsdk.event.CloudPagesChangedEvent;
import com.exacttarget.etpushsdk.event.CloudPagesResponse;
import com.exacttarget.etpushsdk.event.CloudPagesResponseListener;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.m;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETException, ETPushReceiver

public class ETCloudPageManager
    implements BackgroundEventListener, CloudPagesResponseListener
{

    private static ETCloudPageManager a;
    private Context b;

    private ETCloudPageManager(Context context)
    {
        b = context;
        EventBus.getInstance().register(this);
    }

    protected static void a(Context context)
    {
        if (a == null)
        {
            m.a("~!ETCloudPageManager", "readyAimFire()");
            a = new ETCloudPageManager(context);
            return;
        } else
        {
            throw new ETException("You must have called readyAimFire more than once.");
        }
    }

    public void a()
    {
        Intent intent = new Intent(b, com/exacttarget/etpushsdk/ETPushReceiver);
        intent.putExtra("et_send_type_extra", "et_send_type_cloudpage");
        b.sendBroadcast(intent);
    }

    public void onEvent(BackgroundEvent backgroundevent)
    {
        if (d.j() && !backgroundevent.isInBackground())
        {
            m.a("~!ETCloudPageManager", "In FOREGROUND");
            a();
        }
    }

    public void onEvent(CloudPagesResponse cloudpagesresponse)
    {
        if (cloudpagesresponse == null) goto _L2; else goto _L1
_L1:
        if (cloudpagesresponse.getMessages() == null || cloudpagesresponse.getMessages().isEmpty()) goto _L2; else goto _L3
_L3:
        cloudpagesresponse = cloudpagesresponse.getMessages().iterator();
_L4:
        Message message;
        Message message1;
        if (!cloudpagesresponse.hasNext())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        message = (Message)cloudpagesresponse.next();
        message1 = e.a(message.getId());
        if (message1 == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        message.setRead(message1.getRead());
        message.setMessageDeleted(message1.getMessageDeleted());
        e.c(message);
          goto _L4
        cloudpagesresponse;
        m.c("~!ETCloudPageManager", cloudpagesresponse.getMessage(), cloudpagesresponse);
_L2:
        return;
        e.a(message);
          goto _L4
        EventBus.getInstance().a(new CloudPagesChangedEvent());
        return;
    }
}

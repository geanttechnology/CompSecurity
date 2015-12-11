// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.digimarc.dms.resolver:
//            MessageID, PayoffContainer, ResolverService

class ResolverServiceHandler extends Handler
{

    private static final String TAG = "ResolverServiceHandler";
    private ResolverService mService;
    private boolean mShutdownRequested;

    public ResolverServiceHandler(ResolverService resolverservice)
    {
        mShutdownRequested = false;
        mService = resolverservice;
    }

    public void handleMessage(Message message)
    {
        if (!mShutdownRequested)
        {
            if (message.what == MessageID.resolverservice_handler_payloadresolved_message)
            {
                message = (PayoffContainer)message.obj;
                mService.payloadResolved(message);
                return;
            }
            if (message.what == MessageID.reportAction_success)
            {
                mService.reportActionSuccess((String)message.obj);
                return;
            }
            if (message.what == MessageID.reportAction_failed)
            {
                mService.reportActionFailed((String)message.obj, message.arg1);
                return;
            }
            if (message.what == MessageID.resolverthreadhandler_shutdown_requested)
            {
                mShutdownRequested = true;
                return;
            }
        }
    }

    public void syncSend(Message message)
    {
        this;
        JVM INSTR monitorenter ;
        sendMessage(message);
        this;
        JVM INSTR monitorexit ;
        return;
        message;
        throw message;
    }
}

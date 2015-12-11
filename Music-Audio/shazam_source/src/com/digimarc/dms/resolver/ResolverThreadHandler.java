// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.digimarc.dms.resolver:
//            DigimarcResolver, Logger, MessageID, ResolverServiceHandler, 
//            ResolveItem, PayoffContainer

class ResolverThreadHandler extends Handler
{

    private static final String TAG = "ResolverThreadHandler";
    private final ResolverServiceHandler mNotifyHandler;
    private final DigimarcResolver mRouter;

    public ResolverThreadHandler(Context context, String s, String s1, ResolverServiceHandler resolverservicehandler, boolean flag, String s2)
    {
        mRouter = new DigimarcResolver(context, resolverservicehandler, s, s1, flag, s2);
        mNotifyHandler = resolverservicehandler;
    }

    private void notifyThreadOfResolve(PayoffContainer payoffcontainer)
    {
        Logger.getInstance().endResolve();
        payoffcontainer = mNotifyHandler.obtainMessage(MessageID.resolverservice_handler_payloadresolved_message, payoffcontainer);
        mNotifyHandler.syncSend(payoffcontainer);
    }

    public void handleMessage(Message message)
    {
        if (message.what == MessageID.resolverthreadhandler_resolve_message)
        {
            message = (ResolveItem)message.obj;
            Logger.getInstance().startResolve();
            notifyThreadOfResolve(mRouter.resolve(message));
        } else
        {
            if (message.what == MessageID.resolverthreadhandler_exit_thread_message)
            {
                removeMessages(MessageID.resolverthreadhandler_resolve_message);
                Looper.myLooper().quit();
                return;
            }
            if (message.what == MessageID.resolverthreadhandler_ghost_resolve_message)
            {
                message = (ResolveItem)message.obj;
                mRouter.resolve(message);
                return;
            }
            if (message.what == MessageID.resolverthreadhandler_reportaction_message)
            {
                String s = (String)message.obj;
                if (s != null && s.length() > 0)
                {
                    int i = mRouter.reportAction(s);
                    if (i == 200)
                    {
                        message = mNotifyHandler.obtainMessage(MessageID.reportAction_success, message.obj);
                    } else
                    {
                        message = mNotifyHandler.obtainMessage(MessageID.reportAction_failed, i, 0, message.obj);
                    }
                    mNotifyHandler.syncSend(message);
                    return;
                }
            }
        }
    }
}

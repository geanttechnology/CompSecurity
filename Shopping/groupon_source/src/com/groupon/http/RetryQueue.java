// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.content.Context;
import android.content.DialogInterface;
import com.groupon.events.activity.OnDestroyEvent;
import com.groupon.network.HttpResponseException;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.DialogManager;
import com.squareup.otto.Bus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class RetryQueue
{

    private Bus bus;
    private Context context;
    private DialogManager dialogManager;
    private ArrayList queue;

    public RetryQueue()
    {
    }

    private void clear()
    {
        this;
        JVM INSTR monitorenter ;
        int i = queue.size();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        Ln.d("Clearing %s items from retry queue for context %s", new Object[] {
            Integer.valueOf(i), context
        });
        queue.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void add(final AbstractRetryAsyncTask t, Exception exception)
    {
        this;
        JVM INSTR monitorenter ;
        Ln.d("Adding %s to retry queue for context %s: %s", new Object[] {
            t, context, Strings.toString(queue)
        });
        queue.add(t);
        if (queue.size() != 1) goto _L2; else goto _L1
_L1:
        if (!(exception instanceof HttpResponseException)) goto _L4; else goto _L3
_L3:
        exception = context.getString(0x7f0801a1);
_L6:
        Object obj = exception;
        if (Ln.isDebugEnabled())
        {
            obj = (new StringBuilder()).append(exception).append("\n<a href='internal:///logviewer'>Show Logs</a>").toString();
        }
        dialogManager.showAlertDialog(null, obj, Integer.valueOf(0x7f080336), new android.content.DialogInterface.OnClickListener() {

            final RetryQueue this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                retry();
            }

            
            {
                this$0 = RetryQueue.this;
                super();
            }
        }, Integer.valueOf(0x7f080084), new android.content.DialogInterface.OnClickListener() {

            final RetryQueue this$0;
            final AbstractRetryAsyncTask val$t;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                t.onUserCancelRetry();
                synchronized (RetryQueue.this)
                {
                    clear();
                }
                return;
                exception1;
                dialoginterface;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                this$0 = RetryQueue.this;
                t = abstractretryasynctask;
                super();
            }
        }, false, true);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (exception instanceof IOException)
        {
            exception = context.getString(0x7f080165);
            continue; /* Loop/switch isn't completed */
        }
        exception = context.getString(0x7f0801a6);
        if (true) goto _L6; else goto _L5
_L5:
        t;
        throw t;
    }

    protected void init()
    {
        bus.register(new Object() {

            final RetryQueue this$0;

            public void onEvent(OnDestroyEvent ondestroyevent)
            {
                clear();
                bus.unregister(this);
            }

            
            {
                this$0 = RetryQueue.this;
                super();
            }
        });
    }

    public void retry()
    {
        this;
        JVM INSTR monitorenter ;
        Ln.d("Retrying %s queued http tasks in context %s", new Object[] {
            Integer.valueOf(queue.size()), context
        });
        for (Iterator iterator = queue.iterator(); iterator.hasNext(); ((AbstractRetryAsyncTask)iterator.next()).retry()) { }
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        throw exception;
        queue.clear();
        this;
        JVM INSTR monitorexit ;
    }


}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.b.h;
import com.urbanairship.BaseManager;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushUser, RichPushInbox, RichPushUpdateService

public class RichPushManager extends BaseManager
{

    public static final String RICH_PUSH_KEY = "_uamid";
    private BroadcastReceiver foregroundReceiver;
    private final RichPushInbox inbox;
    private final List listeners;
    private final AtomicInteger refreshMessageRequestCount;
    private final RichPushUser user;

    public RichPushManager(Context context, PreferenceDataStore preferencedatastore)
    {
        this(new RichPushUser(preferencedatastore), new RichPushInbox(context));
    }

    RichPushManager(RichPushUser richpushuser, RichPushInbox richpushinbox)
    {
        refreshMessageRequestCount = new AtomicInteger();
        listeners = new ArrayList();
        user = richpushuser;
        inbox = richpushinbox;
    }

    private List getListeners()
    {
        ArrayList arraylist;
        synchronized (listeners)
        {
            arraylist = new ArrayList(listeners);
        }
        return arraylist;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static boolean isRichPushMessage(Bundle bundle)
    {
        return bundle.containsKey("_uamid");
    }

    public static boolean isRichPushMessage(Map map)
    {
        return map.containsKey("_uamid");
    }

    private void onMessagesUpdate(boolean flag)
    {
        for (Iterator iterator = getListeners().iterator(); iterator.hasNext();)
        {
            Listener listener = (Listener)iterator.next();
            try
            {
                listener.onUpdateMessages(flag);
            }
            catch (Exception exception)
            {
                Logger.error("RichPushManager - Unable to complete onUpdateMessages() callback.", exception);
            }
        }

    }

    private void onUserUpdate(boolean flag)
    {
        for (Iterator iterator = getListeners().iterator(); iterator.hasNext();)
        {
            Listener listener = (Listener)iterator.next();
            try
            {
                listener.onUpdateUser(flag);
            }
            catch (Exception exception)
            {
                Logger.error("RichPushManager - Unable to complete onUpdateUser() callback.", exception);
            }
        }

    }

    private void refreshMessages(boolean flag, RefreshMessagesCallback refreshmessagescallback)
    {
        if (isRefreshingMessages() && !flag)
        {
            Logger.debug("Skipping refresh messages, messages are already refreshing. Callback will not be triggered.");
            return;
        } else
        {
            refreshmessagescallback = new _cls2();
            Logger.debug("RichPushManager - Starting update service.");
            Context context = UAirship.getApplicationContext();
            context.startService((new Intent(context, com/urbanairship/richpush/RichPushUpdateService)).setAction("com.urbanairship.richpush.MESSAGES_UPDATE").putExtra("com.urbanairship.richpush.RESULT_RECEIVER", refreshmessagescallback));
            return;
        }
    }

    public void addListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.add(listener);
        }
        return;
        listener;
        list;
        JVM INSTR monitorexit ;
        throw listener;
    }

    public RichPushInbox getRichPushInbox()
    {
        this;
        JVM INSTR monitorenter ;
        RichPushInbox richpushinbox = inbox;
        this;
        JVM INSTR monitorexit ;
        return richpushinbox;
        Exception exception;
        exception;
        throw exception;
    }

    public RichPushUser getRichPushUser()
    {
        this;
        JVM INSTR monitorenter ;
        RichPushUser richpushuser = user;
        this;
        JVM INSTR monitorexit ;
        return richpushuser;
        Exception exception;
        exception;
        throw exception;
    }

    protected void init()
    {
        inbox.refresh();
        updateUser(false);
        foregroundReceiver = new _cls1();
        h h1 = h.a(UAirship.getApplicationContext());
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.urbanairship.analytics.APP_FOREGROUND");
        intentfilter.addAction("com.urbanairship.analytics.APP_BACKGROUND");
        h1.a(foregroundReceiver, intentfilter);
        UAirship.getApplicationContext().registerReceiver(foregroundReceiver, intentfilter);
    }

    public boolean isRefreshingMessages()
    {
        return refreshMessageRequestCount.get() > 0;
    }

    public void refreshMessages()
    {
        refreshMessages(false);
    }

    public void refreshMessages(RefreshMessagesCallback refreshmessagescallback)
    {
        refreshMessages(true, refreshmessagescallback);
    }

    public void refreshMessages(boolean flag)
    {
        refreshMessages(flag, null);
    }

    public void removeListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.remove(listener);
        }
        return;
        listener;
        list;
        JVM INSTR monitorexit ;
        throw listener;
    }

    protected void tearDown()
    {
        if (foregroundReceiver != null)
        {
            UAirship.getApplicationContext().unregisterReceiver(foregroundReceiver);
            foregroundReceiver = null;
        }
    }

    public void updateUser()
    {
        updateUser(true);
    }

    public void updateUser(boolean flag)
    {
        _cls3 _lcls3 = new _cls3();
        Logger.debug("RichPushManager - Starting update service.");
        Context context = UAirship.getApplicationContext();
        context.startService((new Intent(context, com/urbanairship/richpush/RichPushUpdateService)).setAction("com.urbanairship.richpush.USER_UPDATE").putExtra("com.urbanairship.richpush.RESULT_RECEIVER", _lcls3).putExtra("com.urbanairship.richpush.EXTRA_FORCEFULLY", flag));
    }

    public void updateUserIfNecessary()
    {
        updateUser(false);
    }




    private class Listener
    {

        public abstract void onUpdateMessages(boolean flag);

        public abstract void onUpdateUser(boolean flag);
    }


    private class _cls2 extends UpdateResultReceiver
    {
        private class UpdateResultReceiver extends ResultReceiver
        {

            protected void onReceiveResult(int i, Bundle bundle)
            {
                boolean flag;
                if (i == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                onUpdate(flag);
            }

            public abstract void onUpdate(boolean flag);

            public UpdateResultReceiver()
            {
                super(new Handler(Looper.getMainLooper()));
            }
        }


        final RichPushManager this$0;
        final RefreshMessagesCallback val$callback;
        final int val$requestNumber;

        public void onUpdate(boolean flag)
        {
            if (refreshMessageRequestCount.compareAndSet(requestNumber, 0))
            {
                onMessagesUpdate(flag);
            }
            if (callback != null)
            {
                callback.onRefreshMessages(flag);
            }
        }

        _cls2()
        {
            this$0 = RichPushManager.this;
            requestNumber = i;
            callback = refreshmessagescallback;
            super();
        }

        private class RefreshMessagesCallback
        {

            public abstract void onRefreshMessages(boolean flag);
        }

    }


    private class _cls1 extends BroadcastReceiver
    {

        final RichPushManager this$0;

        public void onReceive(Context context, Intent intent)
        {
            if ("com.urbanairship.analytics.APP_FOREGROUND".equals(intent.getAction()))
            {
                refreshMessages();
                return;
            } else
            {
                context.startService((new Intent(context, com/urbanairship/richpush/RichPushUpdateService)).setAction("com.urbanairship.richpush.SYNC_MESSAGE_STATE"));
                return;
            }
        }

        _cls1()
        {
            this$0 = RichPushManager.this;
            super();
        }
    }


    private class _cls3 extends UpdateResultReceiver
    {

        final RichPushManager this$0;

        public void onUpdate(boolean flag)
        {
            onUserUpdate(flag);
        }

        _cls3()
        {
            this$0 = RichPushManager.this;
            super();
        }
    }

}

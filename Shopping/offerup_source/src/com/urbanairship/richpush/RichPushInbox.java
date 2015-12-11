// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushResolver, RichPushMessage

public class RichPushInbox
{

    private static final SentAtRichPushMessageComparator MESSAGE_COMPARATOR = new SentAtRichPushMessageComparator();
    public static final String MESSAGE_DATA_SCHEME = "message";
    public static final String VIEW_INBOX_INTENT_ACTION = "com.urbanairship.VIEW_RICH_PUSH_INBOX";
    public static final String VIEW_MESSAGE_INTENT_ACTION = "com.urbanairship.VIEW_RICH_PUSH_MESSAGE";
    private static final Object inboxLock = new Object();
    private final Set deletedMessageIds;
    private final Executor executor;
    private final List listeners;
    private final Map readMessages;
    private final RichPushResolver richPushResolver;
    private final Map unreadMessages;

    RichPushInbox(Context context)
    {
        this(new RichPushResolver(context), ((Executor) (Executors.newSingleThreadExecutor())));
    }

    RichPushInbox(RichPushResolver richpushresolver, Executor executor1)
    {
        listeners = new ArrayList();
        deletedMessageIds = new HashSet();
        unreadMessages = new HashMap();
        readMessages = new HashMap();
        richPushResolver = richpushresolver;
        executor = executor1;
    }

    private void notifyListeners()
    {
        (new Handler(Looper.getMainLooper())).post(new _cls4());
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

    public void deleteMessages(final Set messageIds)
    {
        executor.execute(new _cls3());
        Object obj = inboxLock;
        obj;
        JVM INSTR monitorenter ;
        messageIds = messageIds.iterator();
_L2:
        String s;
        RichPushMessage richpushmessage;
        do
        {
            if (!messageIds.hasNext())
            {
                break MISSING_BLOCK_LABEL_109;
            }
            s = (String)messageIds.next();
            richpushmessage = getMessage(s);
        } while (richpushmessage == null);
        richpushmessage.deleted = true;
        unreadMessages.remove(s);
        readMessages.remove(s);
        deletedMessageIds.add(s);
        if (true) goto _L2; else goto _L1
_L1:
        messageIds;
        obj;
        JVM INSTR monitorexit ;
        throw messageIds;
        obj;
        JVM INSTR monitorexit ;
        notifyListeners();
        return;
    }

    public int getCount()
    {
        int i;
        int j;
        synchronized (inboxLock)
        {
            i = unreadMessages.size();
            j = readMessages.size();
        }
        return i + j;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public RichPushMessage getMessage(String s)
    {
        if (s == null)
        {
            return null;
        }
        synchronized (inboxLock)
        {
            if (!unreadMessages.containsKey(s))
            {
                break MISSING_BLOCK_LABEL_48;
            }
            s = (RichPushMessage)unreadMessages.get(s);
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s = (RichPushMessage)readMessages.get(s);
        obj;
        JVM INSTR monitorexit ;
        return s;
    }

    public Set getMessageIds()
    {
        HashSet hashset;
        synchronized (inboxLock)
        {
            hashset = new HashSet(getCount());
            hashset.addAll(readMessages.keySet());
            hashset.addAll(unreadMessages.keySet());
        }
        return hashset;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List getMessages()
    {
        ArrayList arraylist;
        synchronized (inboxLock)
        {
            arraylist = new ArrayList(getCount());
            arraylist.addAll(unreadMessages.values());
            arraylist.addAll(readMessages.values());
            Collections.sort(arraylist, MESSAGE_COMPARATOR);
        }
        return arraylist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getReadCount()
    {
        int i;
        synchronized (inboxLock)
        {
            i = readMessages.size();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List getReadMessages()
    {
        ArrayList arraylist;
        synchronized (inboxLock)
        {
            arraylist = new ArrayList(readMessages.values());
            Collections.sort(arraylist, MESSAGE_COMPARATOR);
        }
        return arraylist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getUnreadCount()
    {
        int i;
        synchronized (inboxLock)
        {
            i = unreadMessages.size();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List getUnreadMessages()
    {
        ArrayList arraylist;
        synchronized (inboxLock)
        {
            arraylist = new ArrayList(unreadMessages.values());
            Collections.sort(arraylist, MESSAGE_COMPARATOR);
        }
        return arraylist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void markMessagesRead(final Set messageIds)
    {
        executor.execute(new _cls1());
        Object obj = inboxLock;
        obj;
        JVM INSTR monitorenter ;
        messageIds = messageIds.iterator();
_L2:
        String s;
        RichPushMessage richpushmessage;
        do
        {
            if (!messageIds.hasNext())
            {
                break MISSING_BLOCK_LABEL_108;
            }
            s = (String)messageIds.next();
            richpushmessage = (RichPushMessage)unreadMessages.get(s);
        } while (richpushmessage == null);
        richpushmessage.unreadClient = false;
        unreadMessages.remove(s);
        readMessages.put(s, richpushmessage);
        if (true) goto _L2; else goto _L1
_L1:
        messageIds;
        obj;
        JVM INSTR monitorexit ;
        throw messageIds;
        notifyListeners();
        obj;
        JVM INSTR monitorexit ;
    }

    public void markMessagesUnread(final Set messageIds)
    {
        executor.execute(new _cls2());
        Object obj = inboxLock;
        obj;
        JVM INSTR monitorenter ;
        messageIds = messageIds.iterator();
_L2:
        String s;
        RichPushMessage richpushmessage;
        do
        {
            if (!messageIds.hasNext())
            {
                break MISSING_BLOCK_LABEL_108;
            }
            s = (String)messageIds.next();
            richpushmessage = (RichPushMessage)readMessages.get(s);
        } while (richpushmessage == null);
        richpushmessage.unreadClient = true;
        readMessages.remove(s);
        unreadMessages.put(s, richpushmessage);
        if (true) goto _L2; else goto _L1
_L1:
        messageIds;
        obj;
        JVM INSTR monitorexit ;
        throw messageIds;
        obj;
        JVM INSTR monitorexit ;
        notifyListeners();
        return;
    }

    void refresh()
    {
        Object obj2 = richPushResolver.getMessages();
        Object obj = inboxLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        HashSet hashset;
        HashSet hashset1;
        obj1 = new HashSet(unreadMessages.keySet());
        hashset = new HashSet(readMessages.keySet());
        hashset1 = new HashSet(deletedMessageIds);
        unreadMessages.clear();
        readMessages.clear();
        obj2 = ((List) (obj2)).iterator();
_L3:
        RichPushMessage richpushmessage;
        if (!((Iterator) (obj2)).hasNext())
        {
            break MISSING_BLOCK_LABEL_285;
        }
        richpushmessage = (RichPushMessage)((Iterator) (obj2)).next();
        if (!richpushmessage.isDeleted() && !hashset1.contains(richpushmessage.getMessageId())) goto _L2; else goto _L1
_L1:
        deletedMessageIds.add(richpushmessage.getMessageId());
          goto _L3
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
_L2:
label0:
        {
            if (!((Set) (obj1)).contains(richpushmessage.getMessageId()))
            {
                break label0;
            }
            richpushmessage.unreadClient = true;
            unreadMessages.put(richpushmessage.getMessageId(), richpushmessage);
        }
          goto _L3
label1:
        {
            if (!hashset.contains(richpushmessage.getMessageId()))
            {
                break label1;
            }
            richpushmessage.unreadClient = false;
            readMessages.put(richpushmessage.getMessageId(), richpushmessage);
        }
          goto _L3
label2:
        {
            if (!richpushmessage.unreadClient)
            {
                break label2;
            }
            unreadMessages.put(richpushmessage.getMessageId(), richpushmessage);
        }
          goto _L3
        readMessages.put(richpushmessage.getMessageId(), richpushmessage);
          goto _L3
        obj;
        JVM INSTR monitorexit ;
        notifyListeners();
        return;
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




    private class _cls4
        implements Runnable
    {

        final RichPushInbox this$0;

        public void run()
        {
            List list = listeners;
            list;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new ArrayList(listeners)).iterator(); iterator.hasNext(); ((Listener)iterator.next()).onUpdateInbox()) { }
            break MISSING_BLOCK_LABEL_59;
            Exception exception;
            exception;
            list;
            JVM INSTR monitorexit ;
            throw exception;
            list;
            JVM INSTR monitorexit ;
        }

        _cls4()
        {
            this$0 = RichPushInbox.this;
            super();
        }

        private class Listener
        {

            public abstract void onUpdateInbox();
        }

    }


    private class _cls3
        implements Runnable
    {

        final RichPushInbox this$0;
        final Set val$messageIds;

        public void run()
        {
            richPushResolver.markMessagesDeleted(messageIds);
        }

        _cls3()
        {
            this$0 = RichPushInbox.this;
            messageIds = set;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final RichPushInbox this$0;
        final Set val$messageIds;

        public void run()
        {
            richPushResolver.markMessagesRead(messageIds);
        }

        _cls1()
        {
            this$0 = RichPushInbox.this;
            messageIds = set;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final RichPushInbox this$0;
        final Set val$messageIds;

        public void run()
        {
            richPushResolver.markMessagesUnread(messageIds);
        }

        _cls2()
        {
            this$0 = RichPushInbox.this;
            messageIds = set;
            super();
        }
    }


    private class SentAtRichPushMessageComparator
        implements Comparator
    {

        public int compare(RichPushMessage richpushmessage, RichPushMessage richpushmessage1)
        {
            if (richpushmessage1.getSentDateMS() == richpushmessage.getSentDateMS())
            {
                return richpushmessage.getMessageId().compareTo(richpushmessage1.getMessageId());
            } else
            {
                return Long.valueOf(richpushmessage1.getSentDateMS()).compareTo(Long.valueOf(richpushmessage.getSentDateMS()));
            }
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((RichPushMessage)obj, (RichPushMessage)obj1);
        }

        SentAtRichPushMessageComparator()
        {
        }
    }

}

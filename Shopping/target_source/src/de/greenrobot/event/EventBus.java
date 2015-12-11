// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

// Referenced classes of package de.greenrobot.event:
//            EventBusBuilder, HandlerPoster, BackgroundPoster, AsyncPoster, 
//            SubscriberMethodFinder, SubscriberExceptionEvent, Subscription, EventBusException, 
//            NoSubscriberEvent, SubscriberMethod, ThreadMode, PendingPost

public class EventBus
{
    static interface PostCallback
    {

        public abstract void onPostCompleted(List list);
    }

    static final class PostingThreadState
    {

        boolean canceled;
        Object event;
        final List eventQueue = new ArrayList();
        boolean isMainThread;
        boolean isPosting;
        Subscription subscription;

        PostingThreadState()
        {
        }
    }


    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    public static String TAG = "EventBus";
    static volatile EventBus defaultInstance;
    private static final Map eventTypesCache = new HashMap();
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal currentPostingThreadState;
    private final boolean eventInheritance;
    private final ExecutorService executorService;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final HandlerPoster mainThreadPoster;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final Map typesBySubscriber;

    public EventBus()
    {
        this(DEFAULT_BUILDER);
    }

    EventBus(EventBusBuilder eventbusbuilder)
    {
        currentPostingThreadState = new ThreadLocal() {

            final EventBus this$0;

            protected PostingThreadState initialValue()
            {
                return new PostingThreadState();
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                this$0 = EventBus.this;
                super();
            }
        };
        subscriptionsByEventType = new HashMap();
        typesBySubscriber = new HashMap();
        stickyEvents = new ConcurrentHashMap();
        mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);
        backgroundPoster = new BackgroundPoster(this);
        asyncPoster = new AsyncPoster(this);
        subscriberMethodFinder = new SubscriberMethodFinder(false);
        logSubscriberExceptions = eventbusbuilder.logSubscriberExceptions;
        logNoSubscriberMessages = eventbusbuilder.logNoSubscriberMessages;
        sendSubscriberExceptionEvent = eventbusbuilder.sendSubscriberExceptionEvent;
        sendNoSubscriberEvent = eventbusbuilder.sendNoSubscriberEvent;
        throwSubscriberException = eventbusbuilder.throwSubscriberException;
        eventInheritance = eventbusbuilder.eventInheritance;
        executorService = eventbusbuilder.executorService;
    }

    static void addInterfaces(List list, Class aclass[])
    {
        int j = aclass.length;
        for (int i = 0; i < j; i++)
        {
            Class class1 = aclass[i];
            if (!list.contains(class1))
            {
                list.add(class1);
                addInterfaces(list, class1.getInterfaces());
            }
        }

    }

    public static EventBusBuilder builder()
    {
        return new EventBusBuilder();
    }

    private void checkPostStickyEventToSubscription(Subscription subscription, Object obj)
    {
        if (obj != null)
        {
            boolean flag;
            if (Looper.getMainLooper() == Looper.myLooper())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            postToSubscription(subscription, obj, flag);
        }
    }

    public static void clearCaches()
    {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public static EventBus getDefault()
    {
        if (defaultInstance != null) goto _L2; else goto _L1
_L1:
        de/greenrobot/event/EventBus;
        JVM INSTR monitorenter ;
        if (defaultInstance == null)
        {
            defaultInstance = new EventBus();
        }
        de/greenrobot/event/EventBus;
        JVM INSTR monitorexit ;
_L2:
        return defaultInstance;
        Exception exception;
        exception;
        de/greenrobot/event/EventBus;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void handleSubscriberException(Subscription subscription, Object obj, Throwable throwable)
    {
        if (obj instanceof SubscriberExceptionEvent)
        {
            if (logSubscriberExceptions)
            {
                Log.e(TAG, (new StringBuilder()).append("SubscriberExceptionEvent subscriber ").append(subscription.subscriber.getClass()).append(" threw an exception").toString(), throwable);
                subscription = (SubscriberExceptionEvent)obj;
                Log.e(TAG, (new StringBuilder()).append("Initial event ").append(((SubscriberExceptionEvent) (subscription)).causingEvent).append(" caused exception in ").append(((SubscriberExceptionEvent) (subscription)).causingSubscriber).toString(), ((SubscriberExceptionEvent) (subscription)).throwable);
            }
        } else
        {
            if (throwSubscriberException)
            {
                throw new EventBusException("Invoking subscriber failed", throwable);
            }
            if (logSubscriberExceptions)
            {
                Log.e(TAG, (new StringBuilder()).append("Could not dispatch event: ").append(obj.getClass()).append(" to subscribing class ").append(subscription.subscriber.getClass()).toString(), throwable);
            }
            if (sendSubscriberExceptionEvent)
            {
                post(new SubscriberExceptionEvent(this, throwable, obj, subscription.subscriber));
                return;
            }
        }
    }

    private List lookupAllEventTypes(Class class1)
    {
        Map map = eventTypesCache;
        map;
        JVM INSTR monitorenter ;
        Object obj1 = (List)eventTypesCache.get(class1);
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj1 = new ArrayList();
        obj = class1;
_L1:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        ((List) (obj1)).add(obj);
        addInterfaces(((List) (obj1)), ((Class) (obj)).getInterfaces());
        obj = ((Class) (obj)).getSuperclass();
          goto _L1
        eventTypesCache.put(class1, obj1);
        obj = obj1;
        map;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        class1;
        map;
        JVM INSTR monitorexit ;
        throw class1;
    }

    private void postSingleEvent(Object obj, PostingThreadState postingthreadstate)
        throws Error
    {
        Class class1 = obj.getClass();
        boolean flag;
        if (eventInheritance)
        {
            List list = lookupAllEventTypes(class1);
            int j = list.size();
            int i = 0;
            flag = false;
            for (; i < j; i++)
            {
                flag |= postSingleEventForEventType(obj, postingthreadstate, (Class)list.get(i));
            }

        } else
        {
            flag = postSingleEventForEventType(obj, postingthreadstate, class1);
        }
        if (!flag)
        {
            if (logNoSubscriberMessages)
            {
                Log.d(TAG, (new StringBuilder()).append("No subscribers registered for event ").append(class1).toString());
            }
            if (sendNoSubscriberEvent && class1 != de/greenrobot/event/NoSubscriberEvent && class1 != de/greenrobot/event/SubscriberExceptionEvent)
            {
                post(new NoSubscriberEvent(this, obj));
            }
        }
    }

    private boolean postSingleEventForEventType(Object obj, PostingThreadState postingthreadstate, Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = (CopyOnWriteArrayList)subscriptionsByEventType.get(class1);
        this;
        JVM INSTR monitorexit ;
        if (class1 == null || class1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_127;
        }
        class1 = class1.iterator();
_L2:
        Subscription subscription;
        if (!class1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        subscription = (Subscription)class1.next();
        postingthreadstate.event = obj;
        postingthreadstate.subscription = subscription;
        boolean flag;
        postToSubscription(subscription, obj, postingthreadstate.isMainThread);
        flag = postingthreadstate.canceled;
        postingthreadstate.event = null;
        postingthreadstate.subscription = null;
        postingthreadstate.canceled = false;
        if (!flag) goto _L2; else goto _L1
_L1:
        return true;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        postingthreadstate.event = null;
        postingthreadstate.subscription = null;
        postingthreadstate.canceled = false;
        throw obj;
        return false;
    }

    private void postToSubscription(Subscription subscription, Object obj, boolean flag)
    {
        static class _cls2
        {

            static final int $SwitchMap$de$greenrobot$event$ThreadMode[];

            static 
            {
                $SwitchMap$de$greenrobot$event$ThreadMode = new int[ThreadMode.values().length];
                try
                {
                    $SwitchMap$de$greenrobot$event$ThreadMode[ThreadMode.PostThread.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$de$greenrobot$event$ThreadMode[ThreadMode.MainThread.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$de$greenrobot$event$ThreadMode[ThreadMode.BackgroundThread.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$de$greenrobot$event$ThreadMode[ThreadMode.Async.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.de.greenrobot.event.ThreadMode[subscription.subscriberMethod.threadMode.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown thread mode: ").append(subscription.subscriberMethod.threadMode).toString());

        case 1: // '\001'
            invokeSubscriber(subscription, obj);
            return;

        case 2: // '\002'
            if (flag)
            {
                invokeSubscriber(subscription, obj);
                return;
            } else
            {
                mainThreadPoster.enqueue(subscription, obj);
                return;
            }

        case 3: // '\003'
            if (flag)
            {
                backgroundPoster.enqueue(subscription, obj);
                return;
            } else
            {
                invokeSubscriber(subscription, obj);
                return;
            }

        case 4: // '\004'
            asyncPoster.enqueue(subscription, obj);
            return;
        }
    }

    private void subscribe(Object obj, SubscriberMethod subscribermethod)
    {
        Object obj1;
        Class class1;
        Subscription subscription;
        int i;
        class1 = subscribermethod.eventType;
        obj1 = (CopyOnWriteArrayList)subscriptionsByEventType.get(class1);
        subscription = new Subscription(obj, subscribermethod);
        List list;
        int j;
        if (obj1 == null)
        {
            obj1 = new CopyOnWriteArrayList();
            subscriptionsByEventType.put(class1, obj1);
        } else
        if (((CopyOnWriteArrayList) (obj1)).contains(subscription))
        {
            throw new EventBusException((new StringBuilder()).append("Subscriber ").append(obj.getClass()).append(" already registered to event ").append(class1).toString());
        }
        obj1;
        JVM INSTR monitorenter ;
        j = ((CopyOnWriteArrayList) (obj1)).size();
        i = 0;
_L2:
        if (i > j)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        if (i == j)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        if (subscribermethod.priority <= ((Subscription)((CopyOnWriteArrayList) (obj1)).get(i)).subscriberMethod.priority)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        ((CopyOnWriteArrayList) (obj1)).add(i, subscription);
        obj1;
        JVM INSTR monitorexit ;
        list = (List)typesBySubscriber.get(obj);
        obj1 = list;
        if (list == null)
        {
            obj1 = new ArrayList();
            typesBySubscriber.put(obj, obj1);
        }
        ((List) (obj1)).add(class1);
        if (subscribermethod.sticky)
        {
            if (eventInheritance)
            {
                for (obj = stickyEvents.entrySet().iterator(); ((Iterator) (obj)).hasNext();)
                {
                    subscribermethod = (java.util.Map.Entry)((Iterator) (obj)).next();
                    if (class1.isAssignableFrom((Class)subscribermethod.getKey()))
                    {
                        checkPostStickyEventToSubscription(subscription, subscribermethod.getValue());
                    }
                }

            } else
            {
                checkPostStickyEventToSubscription(subscription, stickyEvents.get(class1));
            }
        }
        break; /* Loop/switch isn't completed */
        i++;
        if (true) goto _L2; else goto _L1
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L1:
    }

    private void unubscribeByEventType(Object obj, Class class1)
    {
        int j;
        j = 0;
        class1 = (List)subscriptionsByEventType.get(class1);
        if (class1 == null) goto _L2; else goto _L1
_L1:
        class1;
        JVM INSTR monitorenter ;
        int i = class1.size();
_L3:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        Subscription subscription = (Subscription)class1.get(j);
        if (subscription.subscriber != obj)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        subscription.active = false;
        class1.remove(j);
        j--;
        i--;
        break MISSING_BLOCK_LABEL_95;
        class1;
        JVM INSTR monitorexit ;
        return;
        obj;
        class1;
        JVM INSTR monitorexit ;
        throw obj;
        j++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void cancelEventDelivery(Object obj)
    {
        PostingThreadState postingthreadstate = (PostingThreadState)currentPostingThreadState.get();
        if (!postingthreadstate.isPosting)
        {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj == null)
        {
            throw new EventBusException("Event may not be null");
        }
        if (postingthreadstate.event != obj)
        {
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        if (postingthreadstate.subscription.subscriberMethod.threadMode != ThreadMode.PostThread)
        {
            throw new EventBusException(" event handlers may only abort the incoming event");
        } else
        {
            postingthreadstate.canceled = true;
            return;
        }
    }

    ExecutorService getExecutorService()
    {
        return executorService;
    }

    public Object getStickyEvent(Class class1)
    {
        synchronized (stickyEvents)
        {
            class1 = ((Class) (class1.cast(stickyEvents.get(class1))));
        }
        return class1;
        class1;
        map;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public boolean hasSubscriberForEvent(Class class1)
    {
        class1 = lookupAllEventTypes(class1);
        if (class1 == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = class1.size();
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = (Class)class1.get(i);
        this;
        JVM INSTR monitorenter ;
        obj = (CopyOnWriteArrayList)subscriptionsByEventType.get(obj);
        this;
        JVM INSTR monitorexit ;
        if (obj != null && !((CopyOnWriteArrayList) (obj)).isEmpty())
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_73;
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        return false;
    }

    void invokeSubscriber(PendingPost pendingpost)
    {
        Object obj = pendingpost.event;
        Subscription subscription = pendingpost.subscription;
        PendingPost.releasePendingPost(pendingpost);
        if (subscription.active)
        {
            invokeSubscriber(subscription, obj);
        }
    }

    void invokeSubscriber(Subscription subscription, Object obj)
    {
        try
        {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, new Object[] {
                obj
            });
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            handleSubscriberException(subscription, obj, invocationtargetexception.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (Subscription subscription)
        {
            throw new IllegalStateException("Unexpected exception", subscription);
        }
    }

    public boolean isRegistered(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = typesBySubscriber.containsKey(obj);
        this;
        JVM INSTR monitorexit ;
        return flag;
        obj;
        throw obj;
    }

    public void post(Object obj)
    {
        PostingThreadState postingthreadstate;
        List list;
        postingthreadstate = (PostingThreadState)currentPostingThreadState.get();
        list = postingthreadstate.eventQueue;
        list.add(obj);
        if (postingthreadstate.isPosting)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        boolean flag;
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        postingthreadstate.isMainThread = flag;
        postingthreadstate.isPosting = true;
        if (postingthreadstate.canceled)
        {
            throw new EventBusException("Internal error. Abort state was not reset");
        }
        for (; !list.isEmpty(); postSingleEvent(list.remove(0), postingthreadstate)) { }
        break MISSING_BLOCK_LABEL_115;
        obj;
        postingthreadstate.isPosting = false;
        postingthreadstate.isMainThread = false;
        throw obj;
        postingthreadstate.isPosting = false;
        postingthreadstate.isMainThread = false;
    }

    public void postSticky(Object obj)
    {
        synchronized (stickyEvents)
        {
            stickyEvents.put(obj.getClass(), obj);
        }
        post(obj);
        return;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void register(Object obj)
    {
        Object obj1 = obj.getClass();
        boolean flag = ((Class) (obj1)).isAnonymousClass();
        for (obj1 = subscriberMethodFinder.findSubscriberMethods(((Class) (obj1)), flag).iterator(); ((Iterator) (obj1)).hasNext(); subscribe(obj, (SubscriberMethod)((Iterator) (obj1)).next())) { }
    }

    public void removeAllStickyEvents()
    {
        synchronized (stickyEvents)
        {
            stickyEvents.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object removeStickyEvent(Class class1)
    {
        synchronized (stickyEvents)
        {
            class1 = ((Class) (class1.cast(stickyEvents.remove(class1))));
        }
        return class1;
        class1;
        map;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public boolean removeStickyEvent(Object obj)
    {
        Map map = stickyEvents;
        map;
        JVM INSTR monitorenter ;
        Class class1 = obj.getClass();
        if (!obj.equals(stickyEvents.get(class1)))
        {
            break MISSING_BLOCK_LABEL_44;
        }
        stickyEvents.remove(class1);
        return true;
        map;
        JVM INSTR monitorexit ;
        return false;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void unregister(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = (List)typesBySubscriber.get(obj);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); unubscribeByEventType(obj, (Class)((Iterator) (obj1)).next())) { }
        break MISSING_BLOCK_LABEL_58;
        obj;
        throw obj;
        typesBySubscriber.remove(obj);
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Log.w(TAG, (new StringBuilder()).append("Subscriber to unregister was not registered before: ").append(obj.getClass()).toString());
          goto _L1
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextWrapper;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public abstract class DataManager
{
    private static class DataManagerContext extends EbayContextWrapper
    {

        public DataManagerContext(EbayContext ebaycontext)
        {
            super(ebaycontext);
        }
    }

    public static abstract class DataManagerKeyParams
    {

        public static final int PRIME = 31;

        public abstract DataManager createManager(EbayContext ebaycontext);

        public int describeContents()
        {
            return 0;
        }

        public int hashCode()
        {
            return getClass().getName().hashCode();
        }

        public String toString()
        {
            return "";
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

        public DataManagerKeyParams()
        {
        }
    }

    private static final class Dispatcher
    {

        private final Handler handler;
        volatile Object iface;

        public final void dispatchChange(Method method, Object aobj[])
        {
            if (handler == null)
            {
                invoke(method, aobj);
                return;
            } else
            {
                handler.post(new NotificationRunnable(method, aobj));
                return;
            }
        }

        final void invoke(Method method, Object aobj[])
        {
            try
            {
                method.invoke(iface, aobj);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Method method)
            {
                throw new RuntimeException(method);
            }
        }

        public String toString()
        {
            return (new StringBuilder()).append("dispatches to ").append(iface).toString();
        }

        public Dispatcher(Object obj, Handler handler1)
        {
            iface = obj;
            handler = handler1;
        }
    }

    private final class Dispatcher.NotificationRunnable
        implements Runnable
    {

        public final Object args[];
        public final Method method;
        final Dispatcher this$0;

        public void run()
        {
            invoke(method, args);
        }

        public Dispatcher.NotificationRunnable(Method method1, Object aobj[])
        {
            this$0 = Dispatcher.this;
            super();
            method = method1;
            args = aobj;
        }
    }

    private static final class DmLink
        implements InvocationHandler
    {

        final WeakReference dataManagerBackRef;

        public Object invoke(Object obj, Method method, Object aobj[])
            throws Throwable
        {
            boolean flag3 = true;
            boolean flag4 = true;
            boolean flag = true;
            int i = 0;
            Object obj1 = dataManagerBackRef.get();
            if (java/lang/Object.equals(method.getDeclaringClass()))
            {
                if (method.getName().equals("toString"))
                {
                    return (new StringBuilder()).append("Proxy to: ").append(obj1).toString();
                }
                if (method.getName().equals("equals"))
                {
                    if (obj != aobj[0])
                    {
                        flag = false;
                    }
                    return Boolean.valueOf(flag);
                }
                if (method.getName().equals("hashCode"))
                {
                    if (obj1 != null)
                    {
                        i = obj1.hashCode();
                    }
                    return Integer.valueOf(i);
                } else
                {
                    return null;
                }
            }
            if (com/ebay/nautilus/domain/content/DataManager$VerifyObserver.equals(method.getDeclaringClass()))
            {
                if (method.getName().equals("isConnected"))
                {
                    boolean flag1;
                    if (obj1 != null)
                    {
                        flag1 = flag3;
                    } else
                    {
                        flag1 = false;
                    }
                    return Boolean.valueOf(flag1);
                }
                if (method.getName().equals("isProxyFor"))
                {
                    boolean flag2;
                    if (aobj[0] == obj1)
                    {
                        flag2 = flag4;
                    } else
                    {
                        flag2 = false;
                    }
                    return Boolean.valueOf(flag2);
                } else
                {
                    return null;
                }
            }
            if (obj1 == null)
            {
                return null;
            } else
            {
                return method.invoke(obj1, aobj);
            }
        }

        public DmLink(Object obj)
        {
            dataManagerBackRef = new WeakReference(obj);
        }
    }

    private static class DmReference extends WeakReference
    {

        final DataManagerKeyParams params;

        public DmReference(DataManagerKeyParams datamanagerkeyparams, DataManager datamanager, ReferenceQueue referencequeue)
        {
            super(datamanager, referencequeue);
            params = datamanagerkeyparams;
        }
    }

    private static final class Observable
        implements InvocationHandler
    {

        static final Handler handler = new Handler(Looper.getMainLooper());
        private final ArrayList dispatchers = new ArrayList();
        private final Class interfaces[];

        private boolean contains(Object obj)
        {
            return indexOf(obj) != -1;
        }

        private int indexOf(Object obj)
        {
            ArrayList arraylist;
            int i;
            arraylist = dispatchers;
            i = arraylist.size() - 1;
_L6:
            if (i < 0) goto _L2; else goto _L1
_L1:
            Object obj1 = ((Dispatcher)arraylist.get(i)).iface;
            if (obj1 != obj) goto _L4; else goto _L3
_L3:
            return i;
_L4:
            if (!(obj1 instanceof VerifyObserver))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj1 = (VerifyObserver)obj1;
            if (((VerifyObserver) (obj1)).isProxyFor(obj)) goto _L3; else goto _L5
_L5:
            if (!((VerifyObserver) (obj1)).isConnected())
            {
                arraylist.remove(i);
            }
            i--;
              goto _L6
_L2:
            return -1;
        }

        private Object newProxyInterface(InvocationHandler invocationhandler)
        {
            return Proxy.newProxyInstance(interfaces[0].getClassLoader(), interfaces, invocationhandler);
        }

        void dispatch(Dispatcher dispatcher1, Method method, Object aobj[])
        {
            handler.post(new NotificationRunnable(dispatcher1, method, aobj));
        }

        final Object getProxyFor(Object obj)
        {
            if (obj == null)
            {
                throw new IllegalArgumentException("The observer is null.");
            }
            ArrayList arraylist = dispatchers;
            arraylist;
            JVM INSTR monitorenter ;
            ArrayList arraylist1;
            int i;
            arraylist1 = dispatchers;
            i = arraylist1.size() - 1;
_L2:
            if (i < 0)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            Object obj1;
            obj1 = ((Dispatcher)arraylist1.get(i)).iface;
            if (!(obj1 instanceof VerifyObserver) || !((VerifyObserver)obj1).isProxyFor(obj))
            {
                break MISSING_BLOCK_LABEL_89;
            }
            arraylist;
            JVM INSTR monitorexit ;
            return obj1;
            arraylist;
            JVM INSTR monitorexit ;
            return null;
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            i--;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public Object getSafeCallback(Object obj)
        {
            ArrayList arraylist = dispatchers;
            arraylist;
            JVM INSTR monitorenter ;
            int i = indexOf(obj);
            if (i != -1)
            {
                break MISSING_BLOCK_LABEL_55;
            }
            throw new IllegalStateException((new StringBuilder()).append("Observer ").append(obj).append(" was not registered.").toString());
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            obj = (Dispatcher)dispatchers.get(i);
            arraylist;
            JVM INSTR monitorexit ;
            return newProxyInterface(((_cls1) (obj)). new InvocationHandler() {

                final Observable this$0;
                final Dispatcher val$dispatcher;

                public Object invoke(Object obj, Method method, Object aobj[])
                    throws Throwable
                {
                    boolean flag = false;
                    if (java/lang/Object.equals(method.getDeclaringClass()))
                    {
                        if (method.getName().equals("toString"))
                        {
                            return (new StringBuilder()).append("Proxy to: ").append(dispatcher).toString();
                        }
                        if (method.getName().equals("equals"))
                        {
                            if (obj == aobj[0])
                            {
                                flag = true;
                            }
                            return Boolean.valueOf(flag);
                        }
                        if (method.getName().equals("hashCode"))
                        {
                            return Integer.valueOf(dispatcher.hashCode());
                        } else
                        {
                            return null;
                        }
                    } else
                    {
                        dispatch(dispatcher, method, aobj);
                        return null;
                    }
                }

            
            {
                this$0 = final_observable1;
                dispatcher = Dispatcher.this;
                super();
            }
            });
        }

        public Object invoke(Object obj, Method method, Object aobj[])
            throws Throwable
        {
            boolean flag = false;
            if (java/lang/Object.equals(method.getDeclaringClass()))
            {
                if (method.getName().equals("toString"))
                {
                    return toString();
                }
                if (method.getName().equals("equals"))
                {
                    if (obj == aobj[0])
                    {
                        flag = true;
                    }
                    return Boolean.valueOf(flag);
                }
                if (method.getName().equals("hashCode"))
                {
                    return Integer.valueOf(hashCode());
                } else
                {
                    return null;
                }
            } else
            {
                handler.post(new NotificationRunnable(method, aobj));
                return null;
            }
        }

        public boolean isEmpty()
        {
            boolean flag;
            synchronized (dispatchers)
            {
                flag = dispatchers.isEmpty();
            }
            return flag;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public Object newProxyInterface()
        {
            return Proxy.newProxyInstance(interfaces[0].getClassLoader(), interfaces, this);
        }

        public Class observerClass()
        {
            return interfaces[0];
        }

        public void registerObserver(Object obj, Handler handler1)
        {
            if (obj == null)
            {
                throw new IllegalArgumentException("The observer is null.");
            }
            ArrayList arraylist = dispatchers;
            arraylist;
            JVM INSTR monitorenter ;
            if (contains(obj))
            {
                throw new IllegalStateException((new StringBuilder()).append("Observer ").append(obj).append(" is already registered.").toString());
            }
            break MISSING_BLOCK_LABEL_66;
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            dispatchers.add(new Dispatcher(obj, handler1));
            arraylist;
            JVM INSTR monitorexit ;
        }

        public void swapObserver(Object obj, Object obj1)
        {
            if (obj == null)
            {
                throw new IllegalArgumentException("The newObserver is null.");
            }
            if (obj1 == null)
            {
                throw new IllegalArgumentException("The oldObserver is null.");
            }
            ArrayList arraylist = dispatchers;
            arraylist;
            JVM INSTR monitorenter ;
            int i = indexOf(obj1);
            if (i != -1)
            {
                break MISSING_BLOCK_LABEL_85;
            }
            throw new IllegalStateException((new StringBuilder()).append("Observer ").append(obj1).append(" was not registered.").toString());
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            ((Dispatcher)dispatchers.get(i)).iface = obj;
            arraylist;
            JVM INSTR monitorexit ;
        }

        public String toString()
        {
            String s;
            synchronized (dispatchers)
            {
                s = (new StringBuilder()).append("Registered observers[").append(dispatchers.size()).append(']').toString();
            }
            return s;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void unregisterObserver(Object obj)
        {
            if (obj == null)
            {
                throw new IllegalArgumentException("The observer is null.");
            }
            ArrayList arraylist = dispatchers;
            arraylist;
            JVM INSTR monitorenter ;
            int i = indexOf(obj);
            if (i != -1)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            throw new IllegalStateException((new StringBuilder()).append("Observer ").append(obj).append(" was not registered.").toString());
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            dispatchers.remove(i);
            arraylist;
            JVM INSTR monitorexit ;
        }



        public Observable(Class class1)
        {
            interfaces = (new Class[] {
                class1
            });
        }
    }

    private final class Observable.NotificationRunnable
        implements Runnable
    {

        private final Object _args[];
        private final Dispatcher _dispatcher;
        private final Method _method;
        final Observable this$0;

        public void run()
        {
            ArrayList arraylist = dispatchers;
            arraylist;
            JVM INSTR monitorenter ;
            if (_dispatcher == null) goto _L2; else goto _L1
_L1:
            if (dispatchers.contains(_dispatcher))
            {
                _dispatcher.dispatchChange(_method, _args);
            }
_L4:
            return;
_L2:
            if (dispatchers.isEmpty()) goto _L4; else goto _L3
_L3:
            Object obj;
            Iterator iterator;
            obj = new ArrayList(dispatchers.size());
            iterator = dispatchers.iterator();
_L5:
            Dispatcher dispatcher1;
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_165;
                }
                dispatcher1 = (Dispatcher)iterator.next();
                if (!(dispatcher1.iface instanceof VerifyObserver) || ((VerifyObserver)dispatcher1.iface).isConnected())
                {
                    break MISSING_BLOCK_LABEL_155;
                }
                iterator.remove();
            } while (true);
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            ((ArrayList) (obj)).add(dispatcher1);
              goto _L5
            obj = ((ArrayList) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                ((Dispatcher)((Iterator) (obj)).next()).dispatchChange(_method, _args);
            }
              goto _L4
        }

        public Observable.NotificationRunnable(Dispatcher dispatcher1, Method method, Object aobj[])
        {
            this$0 = Observable.this;
            super();
            _method = method;
            _args = aobj;
            _dispatcher = dispatcher1;
        }

        public Observable.NotificationRunnable(Method method, Object aobj[])
        {
            this$0 = Observable.this;
            super();
            _method = method;
            _args = aobj;
            _dispatcher = null;
        }
    }

    protected static interface VerifyObserver
    {

        public abstract boolean isConnected();

        public abstract boolean isProxyFor(Object obj);
    }


    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayDataManager", 3, "Log data manager usage");
    private static final HashMap map = new HashMap();
    private static final ReferenceQueue referenceQueue = new ReferenceQueue();
    private final DataManagerContext context;
    protected final Object dispatcher;
    final Observable observable;

    protected DataManager(EbayContext ebaycontext, Class class1)
    {
        context = new DataManagerContext(ebaycontext.getApplicationContext());
        observable = new Observable(class1);
        dispatcher = observable.newProxyInterface();
    }

    public static void TEST_resetAllForTestCase()
    {
        HashMap hashmap = map;
        hashmap;
        JVM INSTR monitorenter ;
        DmReference dmreference1;
        for (Iterator iterator = map.values().iterator(); iterator.hasNext(); dmreference1.clear())
        {
            dmreference1 = (DmReference)iterator.next();
            if (logger.isLoggable)
            {
                logParamsMsg("Removing reference to data manager: ", dmreference1.params);
            }
        }

        break MISSING_BLOCK_LABEL_67;
        Exception exception;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
        map.clear();
_L2:
        DmReference dmreference = (DmReference)referenceQueue.poll();
        if (dmreference == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (!logger.isLoggable) goto _L2; else goto _L1
_L1:
        logParamsMsg("Removing from reference queue data manager: ", dmreference.params);
          goto _L2
        hashmap;
        JVM INSTR monitorexit ;
    }

    public static transient AsyncTask executeOnThreadPool(AsyncTask asynctask, Object aobj[])
    {
        return asynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, aobj);
    }

    public static DataManager get(EbayContext ebaycontext, DataManagerKeyParams datamanagerkeyparams)
    {
        if (ebaycontext == null)
        {
            throw new IllegalArgumentException("context is null!");
        }
        if (datamanagerkeyparams == null)
        {
            throw new IllegalArgumentException("key is null!");
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            return getHelper(ebaycontext, datamanagerkeyparams);
        } else
        {
            return (DataManager)runOnMainThread(new Callable(ebaycontext, datamanagerkeyparams) {

                final EbayContext val$context;
                final DataManagerKeyParams val$key;

                public DataManager call()
                {
                    return DataManager.getHelper(context, key);
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                context = ebaycontext;
                key = datamanagerkeyparams;
                super();
            }
            });
        }
    }

    public static Collection getExisting(EbayContext ebaycontext, Class class1)
    {
        if (ebaycontext == null)
        {
            throw new IllegalArgumentException("context is null!");
        }
        if (class1 == null)
        {
            throw new IllegalArgumentException("dmClass is null!");
        }
        HashMap hashmap = map;
        hashmap;
        JVM INSTR monitorenter ;
        Iterator iterator = map.values().iterator();
        ebaycontext = null;
_L1:
        DataManager datamanager;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_111;
            }
            datamanager = (DataManager)((DmReference)iterator.next()).get();
        } while (!class1.isInstance(datamanager));
        if (ebaycontext != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        ebaycontext = new ArrayList();
        ebaycontext.add(class1.cast(datamanager));
          goto _L1
        hashmap;
        JVM INSTR monitorexit ;
        if (ebaycontext == null)
        {
            return Collections.emptyList();
        } else
        {
            return ebaycontext;
        }
        ebaycontext;
_L3:
        hashmap;
        JVM INSTR monitorexit ;
        throw ebaycontext;
        ebaycontext;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private static DataManager getHelper(EbayContext ebaycontext, DataManagerKeyParams datamanagerkeyparams)
    {
        HashMap hashmap = map;
        hashmap;
        JVM INSTR monitorenter ;
        DataManager datamanager = getIfExists(ebaycontext, datamanagerkeyparams);
        Object obj;
        obj = datamanager;
        if (datamanager != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        ebaycontext = datamanagerkeyparams.createManager(ebaycontext);
        map.put(datamanagerkeyparams, new DmReference(datamanagerkeyparams, ebaycontext, referenceQueue));
        obj = ebaycontext;
        if (!logger.isLoggable)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        logger.log((new StringBuilder()).append("Created a new: ").append(ebaycontext).toString());
        obj = ebaycontext;
        hashmap;
        JVM INSTR monitorexit ;
        return ((DataManager) (obj));
        ebaycontext;
        hashmap;
        JVM INSTR monitorexit ;
        throw ebaycontext;
    }

    public static DataManager getIfExists(EbayContext ebaycontext, DataManagerKeyParams datamanagerkeyparams)
    {
        if (ebaycontext == null)
        {
            throw new IllegalArgumentException("context is null!");
        }
        if (datamanagerkeyparams == null)
        {
            throw new IllegalArgumentException("key is null!");
        }
        HashMap hashmap = map;
        hashmap;
        JVM INSTR monitorenter ;
_L1:
        ebaycontext = (DmReference)referenceQueue.poll();
        if (ebaycontext == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (logger.isLoggable)
        {
            logParamsMsg("Removing unreferenced data manager: ", ((DmReference) (ebaycontext)).params);
        }
        if (map.get(((DmReference) (ebaycontext)).params) == ebaycontext)
        {
            map.remove(((DmReference) (ebaycontext)).params);
        }
          goto _L1
        ebaycontext;
        hashmap;
        JVM INSTR monitorexit ;
        throw ebaycontext;
        ebaycontext = (DmReference)map.get(datamanagerkeyparams);
        if (ebaycontext == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        ebaycontext = (DataManager)ebaycontext.get();
_L2:
        hashmap;
        JVM INSTR monitorexit ;
        return ebaycontext;
        ebaycontext = null;
          goto _L2
    }

    private static void logParamsMsg(String s, Object obj)
    {
        Class class1 = obj.getClass().getDeclaringClass();
        if (class1 != null)
        {
            logger.log((new StringBuilder()).append(s).append(class1.getSimpleName()).append(" {").append(obj).append('}').toString());
            return;
        } else
        {
            logger.log((new StringBuilder()).append(s).append(obj).toString());
            return;
        }
    }

    private static Object runOnMainThread(Callable callable)
    {
        NautilusKernel.verifyNotMain();
        try
        {
            callable = new FutureTask(callable);
            Observable.handler.post(callable);
            callable = ((Callable) (callable.get()));
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            Thread.currentThread().interrupt();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            Throwable throwable = callable.getCause();
            if (throwable instanceof Error)
            {
                throw (Error)throwable;
            }
            if (throwable instanceof RuntimeException)
            {
                throw (RuntimeException)throwable;
            }
            if (throwable != null)
            {
                callable = throwable;
            }
            throw new RuntimeException(callable);
        }
        return callable;
    }

    protected static void runOnMainThread(Runnable runnable)
    {
        Observable.handler.post(runnable);
    }

    private Response sendRequest(Request request, ResultStatusOwner resultstatusowner)
        throws InterruptedException
    {
        if (resultstatusowner == null)
        {
            throw new IllegalArgumentException("result is null");
        } else
        {
            request = sendRequest(request);
            resultstatusowner.setResultStatus(request.getResultStatus());
            return request;
        }
    }

    public final Context getContext()
    {
        return (Context)context.getExtension(android/content/Context);
    }

    public final EbayContext getEbayContext()
    {
        return context;
    }

    public abstract Object getParams();

    protected final Object getSafeCallback(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            return observable.getSafeCallback(obj);
        }
    }

    public abstract void loadData(Object obj);

    protected final DataManager observeDm(DataManagerKeyParams datamanagerkeyparams)
    {
        DataManager datamanager = get(getEbayContext(), datamanagerkeyparams);
        Class class1 = datamanager.observable.observerClass();
        datamanagerkeyparams = null;
        if (class1.isInstance(this))
        {
            datamanagerkeyparams = new DmLink(this);
            datamanagerkeyparams = ((DataManagerKeyParams) (Proxy.newProxyInstance(class1.getClassLoader(), new Class[] {
                class1, com/ebay/nautilus/domain/content/DataManager$VerifyObserver
            }, datamanagerkeyparams)));
            datamanager.registerObserver(datamanagerkeyparams);
        }
        datamanager.loadData(datamanagerkeyparams);
        return datamanager;
    }

    protected void onLastObserverUnregistered()
    {
    }

    public final void registerObserver(Object obj)
    {
        registerObserver(obj, null);
    }

    public final void registerObserver(Object obj, Handler handler)
    {
        NautilusKernel.verifyMain();
        observable.registerObserver(obj, handler);
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Registered observer: ").append(obj).append(" with: ").append(this).toString());
        }
    }

    protected final Response safeSendRequest(Request request, ResultStatusOwner resultstatusowner)
    {
        try
        {
            request = sendRequest(request, resultstatusowner);
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            resultstatusowner.setResultStatus(ResultStatus.CANCELED);
            return null;
        }
        return request;
    }

    protected final Response sendRequest(Request request)
        throws InterruptedException
    {
        return context.getConnector().sendRequest(request);
    }

    public final void swapObserver(Object obj, Object obj1)
    {
        NautilusKernel.verifyMain();
        observable.swapObserver(obj, obj1);
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Swapped observer: ").append(obj).append(" for: ").append(obj1).append(" in: ").append(this).toString());
        }
    }

    public final String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(" {").append(getParams()).append("} ").append(observable).toString();
    }

    protected final void unObserveDm(DataManager datamanager)
    {
        if (datamanager.observable.observerClass().isInstance(this))
        {
            Object obj = datamanager.observable.getProxyFor(this);
            if (obj != null)
            {
                datamanager.unregisterObserver(obj);
            }
        }
    }

    public final void unregisterObserver(Object obj)
    {
        NautilusKernel.verifyMain();
        observable.unregisterObserver(obj);
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Unregistered observer: ").append(obj).append(" with: ").append(this).toString());
        }
        if (observable.isEmpty())
        {
            runOnMainThread(new Runnable() {

                final DataManager this$0;

                public void run()
                {
                    if (observable.isEmpty())
                    {
                        onLastObserverUnregistered();
                    }
                }

            
            {
                this$0 = DataManager.this;
                super();
            }
            });
        }
    }


}

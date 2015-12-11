// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

private static final class interfaces
    implements InvocationHandler
{
    private final class NotificationRunnable
        implements Runnable
    {

        private final Object _args[];
        private final DataManager.Dispatcher _dispatcher;
        private final Method _method;
        final DataManager.Observable this$0;

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
            DataManager.Dispatcher dispatcher;
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_165;
                }
                dispatcher = (DataManager.Dispatcher)iterator.next();
                if (!(dispatcher.iface instanceof DataManager.VerifyObserver) || ((DataManager.VerifyObserver)dispatcher.iface).isConnected())
                {
                    break MISSING_BLOCK_LABEL_155;
                }
                iterator.remove();
            } while (true);
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            ((ArrayList) (obj)).add(dispatcher);
              goto _L5
            obj = ((ArrayList) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                ((DataManager.Dispatcher)((Iterator) (obj)).next()).dispatchChange(_method, _args);
            }
              goto _L4
        }

        public NotificationRunnable(DataManager.Dispatcher dispatcher, Method method, Object aobj[])
        {
            this$0 = DataManager.Observable.this;
            super();
            _method = method;
            _args = aobj;
            _dispatcher = dispatcher;
        }

        public NotificationRunnable(Method method, Object aobj[])
        {
            this$0 = DataManager.Observable.this;
            super();
            _method = method;
            _args = aobj;
            _dispatcher = null;
        }
    }


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
        Object obj1 = ((dispatchers)arraylist.get(i)).iface;
        if (obj1 != obj) goto _L4; else goto _L3
_L3:
        return i;
_L4:
        if (!(obj1 instanceof ver))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = (ver)obj1;
        if (((ver) (obj1)).isProxyFor(obj)) goto _L3; else goto _L5
_L5:
        if (!((ver) (obj1)).isConnected())
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

    void dispatch(interfaces interfaces1, Method method, Object aobj[])
    {
        handler.post(new NotificationRunnable(interfaces1, method, aobj));
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
        obj1 = ((dispatchers)arraylist1.get(i)).iface;
        if (!(obj1 instanceof ver) || !((ver)obj1).isProxyFor(obj))
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

    public Object getSafeCallback(final Object dispatcher)
    {
        ArrayList arraylist = dispatchers;
        arraylist;
        JVM INSTR monitorenter ;
        int i = indexOf(dispatcher);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        throw new IllegalStateException((new StringBuilder()).append("Observer ").append(dispatcher).append(" was not registered.").toString());
        dispatcher;
        arraylist;
        JVM INSTR monitorexit ;
        throw dispatcher;
        dispatcher = (indexOf)dispatchers.get(i);
        arraylist;
        JVM INSTR monitorexit ;
        return newProxyInterface(new InvocationHandler() {

            final DataManager.Observable this$0;
            final DataManager.Dispatcher val$dispatcher;

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
                this$0 = DataManager.Observable.this;
                dispatcher = dispatcher1;
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
        dispatchers.add(new <init>(obj, handler1));
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
        ((indexOf)dispatchers.get(i)).iface = obj;
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



    public _cls1.val.dispatcher(Class class1)
    {
        interfaces = (new Class[] {
            class1
        });
    }
}

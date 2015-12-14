// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view;

import android.os.Handler;
import com.amazon.gallery.foundation.utils.DebugAssert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.gallery.view:
//            ViewStateListener, ViewDescriptor

public class ViewNotificationManager
{

    private static ThreadLocal TEMP_LISTENER_LIST = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Collection initialValue()
        {
            return new ArrayList();
        }

    };
    private Handler handler;
    private final Set listeners = new HashSet();

    public ViewNotificationManager()
    {
        handler = new Handler();
    }

    private Collection getTemporaryListenersCopy()
    {
        this;
        JVM INSTR monitorenter ;
        Collection collection;
        collection = (Collection)TEMP_LISTENER_LIST.get();
        collection.clear();
        collection.addAll(listeners);
        this;
        JVM INSTR monitorexit ;
        return collection;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean addListener(ViewStateListener viewstatelistener)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = listeners.add(viewstatelistener);
        DebugAssert.assertTrue(flag, "listener already added");
        this;
        JVM INSTR monitorexit ;
        return flag;
        viewstatelistener;
        throw viewstatelistener;
    }

    public void clearListeners()
    {
        this;
        JVM INSTR monitorenter ;
        listeners.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean hasViewStateListener(ViewStateListener viewstatelistener)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = listeners.contains(viewstatelistener);
        this;
        JVM INSTR monitorexit ;
        return flag;
        viewstatelistener;
        throw viewstatelistener;
    }

    public void notifyEnterFullScreen()
    {
        handler.post(new Runnable() {

            final ViewNotificationManager this$0;

            public void run()
            {
                for (Iterator iterator = getTemporaryListenersCopy().iterator(); iterator.hasNext(); ((ViewStateListener)iterator.next()).onEnterFullScreen()) { }
            }

            
            {
                this$0 = ViewNotificationManager.this;
                super();
            }
        });
    }

    public void notifyExitFullScreen()
    {
        handler.post(new Runnable() {

            final ViewNotificationManager this$0;

            public void run()
            {
                for (Iterator iterator = getTemporaryListenersCopy().iterator(); iterator.hasNext(); ((ViewStateListener)iterator.next()).onExitFullScreen()) { }
            }

            
            {
                this$0 = ViewNotificationManager.this;
                super();
            }
        });
    }

    public void notifyViewStateChange(final ViewDescriptor viewDescriptor, final boolean finalized)
    {
        handler.post(new Runnable() {

            final ViewNotificationManager this$0;
            final boolean val$finalized;
            final ViewDescriptor val$viewDescriptor;

            public void run()
            {
                for (Iterator iterator = getTemporaryListenersCopy().iterator(); iterator.hasNext(); ((ViewStateListener)iterator.next()).onViewStateChange(viewDescriptor, finalized)) { }
            }

            
            {
                this$0 = ViewNotificationManager.this;
                viewDescriptor = viewdescriptor;
                finalized = flag;
                super();
            }
        });
    }

    public boolean removeListener(ViewStateListener viewstatelistener)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = listeners.remove(viewstatelistener);
        DebugAssert.assertTrue(flag, "listener not registered");
        this;
        JVM INSTR monitorexit ;
        return flag;
        viewstatelistener;
        throw viewstatelistener;
    }


}

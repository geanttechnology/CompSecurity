// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.google.tagmanager:
//            Clock, TagManager, Container, Log

public class ContainerOpener
{
    public static interface ContainerFuture
    {

        public abstract Container get();

        public abstract boolean isDone();
    }

    private static class ContainerFutureImpl
        implements ContainerFuture
    {

        private volatile Container mContainer;
        private Semaphore mContainerIsReady;
        private volatile boolean mHaveGotten;

        public Container get()
        {
            if (mHaveGotten)
            {
                return mContainer;
            }
            try
            {
                mContainerIsReady.acquire();
            }
            catch (InterruptedException interruptedexception) { }
            mHaveGotten = true;
            return mContainer;
        }

        public boolean isDone()
        {
            return mHaveGotten || mContainerIsReady.availablePermits() > 0;
        }

        public void setContainer(Container container)
        {
            mContainer = container;
            mContainerIsReady.release();
        }

        private ContainerFutureImpl()
        {
            mContainerIsReady = new Semaphore(0);
        }

    }

    public static interface Notifier
    {

        public abstract void containerAvailable(Container container);
    }

    public static final class OpenType extends Enum
    {

        private static final OpenType $VALUES[];
        public static final OpenType PREFER_FRESH;
        public static final OpenType PREFER_NON_DEFAULT;

        public static OpenType valueOf(String s)
        {
            return (OpenType)Enum.valueOf(com/google/tagmanager/ContainerOpener$OpenType, s);
        }

        public static OpenType[] values()
        {
            return (OpenType[])$VALUES.clone();
        }

        static 
        {
            PREFER_NON_DEFAULT = new OpenType("PREFER_NON_DEFAULT", 0);
            PREFER_FRESH = new OpenType("PREFER_FRESH", 1);
            $VALUES = (new OpenType[] {
                PREFER_NON_DEFAULT, PREFER_FRESH
            });
        }

        private OpenType(String s, int i)
        {
            super(s, i);
        }
    }

    private class WaitForFresh
        implements Container.Callback
    {

        private final long mOldestTimeToBeFresh;
        final ContainerOpener this$0;

        private boolean isFresh()
        {
            return mOldestTimeToBeFresh < mContainer.getLastRefreshTime();
        }

        public void containerRefreshBegin(Container container, Container.RefreshType refreshtype)
        {
        }

        public void containerRefreshFailure(Container container, Container.RefreshType refreshtype, Container.RefreshFailure refreshfailure)
        {
            if (refreshtype == Container.RefreshType.NETWORK)
            {
                callNotifiers(container);
            }
        }

        public void containerRefreshSuccess(Container container, Container.RefreshType refreshtype)
        {
            if (refreshtype == Container.RefreshType.NETWORK || isFresh())
            {
                callNotifiers(container);
            }
        }

        public WaitForFresh(long l)
        {
            this$0 = ContainerOpener.this;
            super();
            mOldestTimeToBeFresh = l;
        }
    }

    private class WaitForNonDefaultRefresh
        implements Container.Callback
    {

        final ContainerOpener this$0;

        public void containerRefreshBegin(Container container, Container.RefreshType refreshtype)
        {
        }

        public void containerRefreshFailure(Container container, Container.RefreshType refreshtype, Container.RefreshFailure refreshfailure)
        {
            if (refreshtype == Container.RefreshType.NETWORK)
            {
                callNotifiers(container);
            }
        }

        public void containerRefreshSuccess(Container container, Container.RefreshType refreshtype)
        {
            callNotifiers(container);
        }

        public WaitForNonDefaultRefresh()
        {
            this$0 = ContainerOpener.this;
            super();
        }
    }


    public static final long DEFAULT_TIMEOUT_IN_MILLIS = 2000L;
    private static final Map mContainerIdNotifiersMap = new HashMap();
    private Clock mClock;
    private volatile Container mContainer;
    private final String mContainerId;
    private boolean mHaveNotified;
    private Notifier mNotifier;
    private final TagManager mTagManager;
    private final long mTimeoutInMillis;

    private ContainerOpener(TagManager tagmanager, String s, Long long1, Notifier notifier)
    {
        mClock = new Clock() {

            final ContainerOpener this$0;

            public long currentTimeMillis()
            {
                return System.currentTimeMillis();
            }

            
            {
                this$0 = ContainerOpener.this;
                super();
            }
        };
        mTagManager = tagmanager;
        mContainerId = s;
        long l;
        if (long1 != null)
        {
            l = Math.max(1L, long1.longValue());
        } else
        {
            l = 2000L;
        }
        mTimeoutInMillis = l;
        mNotifier = notifier;
    }

    private void callNotifiers(Container container)
    {
        this;
        JVM INSTR monitorenter ;
        if (mHaveNotified)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        com/google/tagmanager/ContainerOpener;
        JVM INSTR monitorenter ;
        Object obj = (List)mContainerIdNotifiersMap.remove(mContainerId);
        com/google/tagmanager/ContainerOpener;
        JVM INSTR monitorexit ;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((Notifier)((Iterator) (obj)).next()).containerAvailable(container)) { }
        break MISSING_BLOCK_LABEL_80;
        container;
        throw container;
        container;
        com/google/tagmanager/ContainerOpener;
        JVM INSTR monitorexit ;
        throw container;
        mHaveNotified = true;
        this;
        JVM INSTR monitorexit ;
    }

    private void open(Container.RefreshType refreshtype)
    {
        long l = mClock.currentTimeMillis();
        boolean flag = false;
        com/google/tagmanager/ContainerOpener;
        JVM INSTR monitorenter ;
        mContainer = mTagManager.getContainer(mContainerId);
        if (mContainer != null) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        obj = new ArrayList();
        ((List) (obj)).add(mNotifier);
        mNotifier = null;
        mContainerIdNotifiersMap.put(mContainerId, obj);
        obj = mTagManager;
        s = mContainerId;
        if (refreshtype != Container.RefreshType.SAVED) goto _L4; else goto _L3
_L3:
        refreshtype = new WaitForNonDefaultRefresh();
_L7:
        mContainer = ((TagManager) (obj)).openContainer(s, refreshtype);
_L5:
        com/google/tagmanager/ContainerOpener;
        JVM INSTR monitorexit ;
        if (flag)
        {
            mNotifier.containerAvailable(mContainer);
            mNotifier = null;
            return;
        } else
        {
            setTimer(Math.max(1L, mTimeoutInMillis - (mClock.currentTimeMillis() - l)));
            return;
        }
_L4:
        refreshtype = new WaitForFresh(l - 0x2932e00L);
        continue; /* Loop/switch isn't completed */
        refreshtype;
        com/google/tagmanager/ContainerOpener;
        JVM INSTR monitorexit ;
        throw refreshtype;
_L2:
        refreshtype = (List)mContainerIdNotifiersMap.get(mContainerId);
label0:
        {
            if (refreshtype != null)
            {
                break label0;
            }
            flag = true;
        }
          goto _L5
        refreshtype.add(mNotifier);
        mNotifier = null;
        com/google/tagmanager/ContainerOpener;
        JVM INSTR monitorexit ;
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static ContainerFuture openContainer(TagManager tagmanager, String s, OpenType opentype, Long long1)
    {
        ContainerFutureImpl containerfutureimpl = new ContainerFutureImpl();
        openContainer(tagmanager, s, opentype, long1, new Notifier(containerfutureimpl) {

            final ContainerFutureImpl val$future;

            public void containerAvailable(Container container)
            {
                future.setContainer(container);
            }

            
            {
                future = containerfutureimpl;
                super();
            }
        });
        return containerfutureimpl;
    }

    public static void openContainer(TagManager tagmanager, String s, OpenType opentype, Long long1, Notifier notifier)
    {
        if (tagmanager == null)
        {
            throw new NullPointerException("TagManager cannot be null.");
        }
        if (s == null)
        {
            throw new NullPointerException("ContainerId cannot be null.");
        }
        if (opentype == null)
        {
            throw new NullPointerException("OpenType cannot be null.");
        }
        if (notifier == null)
        {
            throw new NullPointerException("Notifier cannot be null.");
        }
        s = new ContainerOpener(tagmanager, s, long1, notifier);
        if (opentype == OpenType.PREFER_FRESH)
        {
            tagmanager = Container.RefreshType.NETWORK;
        } else
        {
            tagmanager = Container.RefreshType.SAVED;
        }
        s.open(tagmanager);
    }

    private void setTimer(long l)
    {
        TimerTask timertask = new TimerTask() {

            final ContainerOpener this$0;

            public void run()
            {
                Log.i("Timer expired.");
                callNotifiers(mContainer);
            }

            
            {
                this$0 = ContainerOpener.this;
                super();
            }
        };
        (new Timer("ContainerOpener")).schedule(timertask, l);
    }



}

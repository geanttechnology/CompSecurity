// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

// Referenced classes of package com.google.common.util.concurrent:
//            ListenableFuture, Uninterruptibles, MoreExecutors

public abstract class AbstractFuture
    implements ListenableFuture
{
    private static abstract class AtomicHelper
    {

        abstract boolean casListeners(AbstractFuture abstractfuture, Listener listener, Listener listener1);

        abstract boolean casValue(AbstractFuture abstractfuture, Object obj, Object obj1);

        abstract boolean casWaiters(AbstractFuture abstractfuture, Waiter waiter, Waiter waiter1);

        abstract void putNext(Waiter waiter, Waiter waiter1);

        abstract void putThread(Waiter waiter, Thread thread);

        private AtomicHelper()
        {
        }

    }

    private static final class Cancellation
    {

        final Throwable cause;
        final boolean wasInterrupted;

        Cancellation(boolean flag, Throwable throwable)
        {
            wasInterrupted = flag;
            cause = (Throwable)Preconditions.checkNotNull(throwable);
        }
    }

    private static final class Failure
    {

        static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") {

            public Throwable fillInStackTrace()
            {
                this;
                JVM INSTR monitorenter ;
                return this;
            }

        });
        final Throwable exception;


        Failure(Throwable throwable)
        {
            exception = (Throwable)Preconditions.checkNotNull(throwable);
        }
    }

    private static final class Listener
    {

        static final Listener TOMBSTONE = new Listener(null, null);
        final Executor executor;
        Listener next;
        final Runnable task;


        Listener(Runnable runnable, Executor executor1)
        {
            task = runnable;
            executor = executor1;
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper
    {

        boolean casListeners(AbstractFuture abstractfuture, Listener listener, Listener listener1)
        {
            return AbstractFuture.LISTENERS_UPDATER.compareAndSet(abstractfuture, listener, listener1);
        }

        boolean casValue(AbstractFuture abstractfuture, Object obj, Object obj1)
        {
            return AbstractFuture.VALUE_UPDATER.compareAndSet(abstractfuture, obj, obj1);
        }

        boolean casWaiters(AbstractFuture abstractfuture, Waiter waiter, Waiter waiter1)
        {
            return AbstractFuture.WAITERS_UPDATER.compareAndSet(abstractfuture, waiter, waiter1);
        }

        void putNext(Waiter waiter, Waiter waiter1)
        {
            AbstractFuture.WAITER_NEXT_UPDATER.lazySet(waiter, waiter1);
        }

        void putThread(Waiter waiter, Thread thread)
        {
            AbstractFuture.WAITER_THREAD_UPDATER.lazySet(waiter, thread);
        }

        private SafeAtomicHelper()
        {
        }

    }

    private final class SetFuture
        implements Runnable
    {

        final ListenableFuture future;
        final AbstractFuture this$0;

        public void run()
        {
            if (value != this)
            {
                return;
            } else
            {
                completeWithFuture(future, this);
                return;
            }
        }

        SetFuture(ListenableFuture listenablefuture)
        {
            this$0 = AbstractFuture.this;
            super();
            future = listenablefuture;
        }
    }

    static abstract class TrustedFuture extends AbstractFuture
    {

        public final void addListener(Runnable runnable, Executor executor)
        {
            addListener(runnable, executor);
        }

        public final Object get()
            throws InterruptedException, ExecutionException
        {
            return get();
        }

        public final Object get(long l, TimeUnit timeunit)
            throws InterruptedException, ExecutionException, TimeoutException
        {
            return get(l, timeunit);
        }

        public final boolean isCancelled()
        {
            return isCancelled();
        }

        public final boolean isDone()
        {
            return isDone();
        }

        TrustedFuture()
        {
        }
    }

    private static final class UnsafeAtomicHelper extends AtomicHelper
    {

        static final long LISTENERS_OFFSET;
        static final Unsafe UNSAFE;
        static final long VALUE_OFFSET;
        static final long WAITERS_OFFSET;
        static final long WAITER_NEXT_OFFSET;
        static final long WAITER_THREAD_OFFSET;

        boolean casListeners(AbstractFuture abstractfuture, Listener listener, Listener listener1)
        {
            return UNSAFE.compareAndSwapObject(abstractfuture, LISTENERS_OFFSET, listener, listener1);
        }

        boolean casValue(AbstractFuture abstractfuture, Object obj, Object obj1)
        {
            return UNSAFE.compareAndSwapObject(abstractfuture, VALUE_OFFSET, obj, obj1);
        }

        boolean casWaiters(AbstractFuture abstractfuture, Waiter waiter, Waiter waiter1)
        {
            return UNSAFE.compareAndSwapObject(abstractfuture, WAITERS_OFFSET, waiter, waiter1);
        }

        void putNext(Waiter waiter, Waiter waiter1)
        {
            UNSAFE.putObject(waiter, WAITER_NEXT_OFFSET, waiter1);
        }

        void putThread(Waiter waiter, Thread thread)
        {
            UNSAFE.putObject(waiter, WAITER_THREAD_OFFSET, thread);
        }

        static 
        {
            Unsafe unsafe;
            try
            {
                unsafe = Unsafe.getUnsafe();
            }
            catch (SecurityException securityexception)
            {
                try
                {
                    securityexception = (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction() {

                        public volatile Object run()
                            throws Exception
                        {
                            return run();
                        }

                        public Unsafe run()
                            throws Exception
                        {
                            Field afield[] = sun/misc/Unsafe.getDeclaredFields();
                            int j = afield.length;
                            for (int i = 0; i < j; i++)
                            {
                                Object obj = afield[i];
                                ((Field) (obj)).setAccessible(true);
                                obj = ((Field) (obj)).get(null);
                                if (sun/misc/Unsafe.isInstance(obj))
                                {
                                    return (Unsafe)sun/misc/Unsafe.cast(obj);
                                }
                            }

                            throw new NoSuchFieldError("the Unsafe");
                        }

                    });
                }
                catch (PrivilegedActionException privilegedactionexception)
                {
                    throw new RuntimeException("Could not initialize intrinsics", privilegedactionexception.getCause());
                }
            }
            try
            {
                WAITERS_OFFSET = unsafe.objectFieldOffset(com/google/common/util/concurrent/AbstractFuture.getDeclaredField("waiters"));
                LISTENERS_OFFSET = unsafe.objectFieldOffset(com/google/common/util/concurrent/AbstractFuture.getDeclaredField("listeners"));
                VALUE_OFFSET = unsafe.objectFieldOffset(com/google/common/util/concurrent/AbstractFuture.getDeclaredField("value"));
                WAITER_THREAD_OFFSET = unsafe.objectFieldOffset(com/google/common/util/concurrent/AbstractFuture$Waiter.getDeclaredField("thread"));
                WAITER_NEXT_OFFSET = unsafe.objectFieldOffset(com/google/common/util/concurrent/AbstractFuture$Waiter.getDeclaredField("next"));
                UNSAFE = unsafe;
                return;
            }
            catch (Exception exception)
            {
                throw Throwables.propagate(exception);
            }
        }

        private UnsafeAtomicHelper()
        {
        }

    }

    private static abstract class UnsafeAtomicHelperFactory extends Enum
    {

        private static final UnsafeAtomicHelperFactory $VALUES[];
        public static final UnsafeAtomicHelperFactory DONT_EVEN_TRY_TO_CREATE;
        public static final UnsafeAtomicHelperFactory REALLY_TRY_TO_CREATE;

        public static UnsafeAtomicHelperFactory valueOf(String s)
        {
            return (UnsafeAtomicHelperFactory)Enum.valueOf(com/google/common/util/concurrent/AbstractFuture$UnsafeAtomicHelperFactory, s);
        }

        public static UnsafeAtomicHelperFactory[] values()
        {
            return (UnsafeAtomicHelperFactory[])$VALUES.clone();
        }

        abstract AtomicHelper tryCreateUnsafeAtomicHelper();

        static 
        {
            REALLY_TRY_TO_CREATE = new UnsafeAtomicHelperFactory("REALLY_TRY_TO_CREATE", 0) {

                AtomicHelper tryCreateUnsafeAtomicHelper()
                {
                    return new UnsafeAtomicHelper();
                }

            };
            DONT_EVEN_TRY_TO_CREATE = new UnsafeAtomicHelperFactory("DONT_EVEN_TRY_TO_CREATE", 1) {

                AtomicHelper tryCreateUnsafeAtomicHelper()
                {
                    return null;
                }

            };
            $VALUES = (new UnsafeAtomicHelperFactory[] {
                REALLY_TRY_TO_CREATE, DONT_EVEN_TRY_TO_CREATE
            });
        }

        private UnsafeAtomicHelperFactory(String s, int i)
        {
            super(s, i);
        }

    }

    private static final class Waiter
    {

        static final Waiter TOMBSTONE = new Waiter(false);
        volatile Waiter next;
        volatile Thread thread;

        void setNext(Waiter waiter)
        {
            AbstractFuture.ATOMIC_HELPER.putNext(this, waiter);
        }

        void unpark()
        {
            Thread thread1 = thread;
            if (thread1 != null)
            {
                thread = null;
                LockSupport.unpark(thread1);
            }
        }


        Waiter()
        {
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        Waiter(boolean flag)
        {
        }
    }


    private static final AtomicHelper ATOMIC_HELPER;
    private static final AtomicReferenceFieldUpdater LISTENERS_UPDATER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000L;
    private static final AtomicReferenceFieldUpdater VALUE_UPDATER;
    private static final AtomicReferenceFieldUpdater WAITERS_UPDATER;
    private static final AtomicReferenceFieldUpdater WAITER_NEXT_UPDATER;
    private static final AtomicReferenceFieldUpdater WAITER_THREAD_UPDATER;
    private static final Logger log;
    private volatile Listener listeners;
    private volatile Object value;
    private volatile Waiter waiters;

    protected AbstractFuture()
    {
    }

    static final CancellationException cancellationExceptionWithCause(String s, Throwable throwable)
    {
        s = new CancellationException(s);
        s.initCause(throwable);
        return s;
    }

    private Listener clearListeners()
    {
        Listener listener;
        do
        {
            listener = listeners;
        } while (!ATOMIC_HELPER.casListeners(this, listener, Listener.TOMBSTONE));
        return listener;
    }

    private Waiter clearWaiters()
    {
        Waiter waiter;
        do
        {
            waiter = waiters;
        } while (!ATOMIC_HELPER.casWaiters(this, waiter, Waiter.TOMBSTONE));
        return waiter;
    }

    private void complete()
    {
        for (Waiter waiter = clearWaiters(); waiter != null; waiter = waiter.next)
        {
            waiter.unpark();
        }

        Listener listener1 = clearListeners();
        Listener listener = null;
        Listener listener2;
        do
        {
            listener2 = listener;
            if (listener1 == null)
            {
                break;
            }
            listener2 = listener1.next;
            listener1.next = listener;
            listener = listener1;
            listener1 = listener2;
        } while (true);
        for (; listener2 != null; listener2 = listener2.next)
        {
            executeListener(listener2.task, listener2.executor);
        }

        done();
    }

    private boolean completeWithFuture(ListenableFuture listenablefuture, Object obj)
    {
        boolean flag = false;
        if (!(listenablefuture instanceof TrustedFuture)) goto _L2; else goto _L1
_L1:
        listenablefuture = ((ListenableFuture) (((AbstractFuture)listenablefuture).value));
_L4:
        if (ATOMIC_HELPER.casValue(this, obj, listenablefuture))
        {
            complete();
            flag = true;
        }
        return flag;
_L2:
        listenablefuture = ((ListenableFuture) (Uninterruptibles.getUninterruptibly(listenablefuture)));
        if (listenablefuture == null)
        {
            try
            {
                listenablefuture = ((ListenableFuture) (NULL));
            }
            // Misplaced declaration of an exception variable
            catch (ListenableFuture listenablefuture)
            {
                listenablefuture = new Failure(listenablefuture.getCause());
            }
            // Misplaced declaration of an exception variable
            catch (ListenableFuture listenablefuture)
            {
                listenablefuture = new Cancellation(false, listenablefuture);
            }
            // Misplaced declaration of an exception variable
            catch (ListenableFuture listenablefuture)
            {
                listenablefuture = new Failure(listenablefuture);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void executeListener(Runnable runnable, Executor executor)
    {
        try
        {
            executor.execute(runnable);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            Logger logger = log;
            Level level = Level.SEVERE;
            runnable = String.valueOf(runnable);
            executor = String.valueOf(executor);
            logger.log(level, (new StringBuilder(String.valueOf(runnable).length() + 57 + String.valueOf(executor).length())).append("RuntimeException while executing runnable ").append(runnable).append(" with executor ").append(executor).toString(), runtimeexception);
            return;
        }
    }

    private Object getDoneValue(Object obj)
        throws ExecutionException
    {
        if (obj instanceof Cancellation)
        {
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation)obj).cause);
        }
        if (obj instanceof Failure)
        {
            throw new ExecutionException(((Failure)obj).exception);
        }
        if (obj == NULL)
        {
            return null;
        } else
        {
            return obj;
        }
    }

    private void removeWaiter(Waiter waiter)
    {
        waiter.thread = null;
_L4:
        Waiter waiter1;
        Waiter waiter2;
        waiter1 = null;
        waiter2 = waiters;
        waiter = waiter2;
        if (waiter2 != Waiter.TOMBSTONE) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (waiter == null) goto _L1; else goto _L3
_L3:
        Waiter waiter3;
        waiter3 = waiter.next;
        if (waiter.thread != null)
        {
            waiter2 = waiter;
        } else
        {
label0:
            {
                if (waiter1 == null)
                {
                    break label0;
                }
                waiter1.next = waiter3;
                waiter2 = waiter1;
                if (waiter1.thread == null)
                {
                    break; /* Loop/switch isn't completed */
                }
            }
        }
_L5:
        waiter = waiter3;
        waiter1 = waiter2;
          goto _L2
          goto _L1
        waiter2 = waiter1;
        if (ATOMIC_HELPER.casWaiters(this, waiter, waiter3)) goto _L5; else goto _L4
    }

    public void addListener(Runnable runnable, Executor executor)
    {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        Listener listener = listeners;
        if (listener != Listener.TOMBSTONE)
        {
            Listener listener2 = new Listener(runnable, executor);
            Listener listener1;
            do
            {
                listener2.next = listener;
                if (ATOMIC_HELPER.casListeners(this, listener, listener2))
                {
                    return;
                }
                listener1 = listeners;
                listener = listener1;
            } while (listener1 != Listener.TOMBSTONE);
        }
        executeListener(runnable, executor);
    }

    public boolean cancel(boolean flag)
    {
        Object obj = value;
        boolean flag1;
        if (obj == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 | (obj instanceof SetFuture))
        {
            Cancellation cancellation = new Cancellation(flag, newCancellationCause());
            Object obj1;
            do
            {
                if (ATOMIC_HELPER.casValue(this, obj, cancellation))
                {
                    if (flag)
                    {
                        interruptTask();
                    }
                    complete();
                    if (obj instanceof SetFuture)
                    {
                        ((SetFuture)obj).future.cancel(flag);
                    }
                    return true;
                }
                obj1 = value;
                obj = obj1;
            } while (obj1 instanceof SetFuture);
        }
        return false;
    }

    void done()
    {
    }

    public Object get()
        throws InterruptedException, ExecutionException
    {
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
        Object obj = value;
        boolean flag;
        boolean flag2;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!(obj instanceof SetFuture))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag & flag2)
        {
            return getDoneValue(obj);
        }
        obj = waiters;
        if (obj != Waiter.TOMBSTONE)
        {
            Waiter waiter1 = new Waiter();
            Waiter waiter;
            do
            {
                waiter1.setNext(((Waiter) (obj)));
                if (ATOMIC_HELPER.casWaiters(this, ((Waiter) (obj)), waiter1))
                {
                    do
                    {
                        LockSupport.park(this);
                        if (Thread.interrupted())
                        {
                            removeWaiter(waiter1);
                            throw new InterruptedException();
                        }
                        obj = value;
                        boolean flag1;
                        boolean flag3;
                        if (obj != null)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!(obj instanceof SetFuture))
                        {
                            flag3 = true;
                        } else
                        {
                            flag3 = false;
                        }
                    } while (!(flag1 & flag3));
                    return getDoneValue(obj);
                }
                waiter = waiters;
                obj = waiter;
            } while (waiter != Waiter.TOMBSTONE);
        }
        return getDoneValue(value);
    }

    public Object get(long l, TimeUnit timeunit)
        throws InterruptedException, TimeoutException, ExecutionException
    {
        Waiter waiter1;
        long l1;
        long l2;
        l2 = timeunit.toNanos(l);
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
        timeunit = ((TimeUnit) (value));
        boolean flag;
        boolean flag3;
        if (timeunit != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!(timeunit instanceof SetFuture))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag & flag3)
        {
            return getDoneValue(timeunit);
        }
        if (l2 > 0L)
        {
            l1 = System.nanoTime() + l2;
        } else
        {
            l1 = 0L;
        }
        l = l2;
        if (l2 < 1000L) goto _L2; else goto _L1
_L1:
        timeunit = waiters;
        if (timeunit == Waiter.TOMBSTONE) goto _L4; else goto _L3
_L3:
        waiter1 = new Waiter();
_L7:
        waiter1.setNext(timeunit);
        if (!ATOMIC_HELPER.casWaiters(this, timeunit, waiter1)) goto _L6; else goto _L5
_L5:
        do
        {
            LockSupport.parkNanos(this, l2);
            if (Thread.interrupted())
            {
                removeWaiter(waiter1);
                throw new InterruptedException();
            }
            timeunit = ((TimeUnit) (value));
            boolean flag1;
            boolean flag4;
            if (timeunit != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!(timeunit instanceof SetFuture))
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (flag1 & flag4)
            {
                return getDoneValue(timeunit);
            }
            l = l1 - System.nanoTime();
            l2 = l;
        } while (l >= 1000L);
        removeWaiter(waiter1);
_L2:
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        timeunit = ((TimeUnit) (value));
        Waiter waiter;
        boolean flag2;
        boolean flag5;
        if (timeunit != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!(timeunit instanceof SetFuture))
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (flag2 & flag5)
        {
            return getDoneValue(timeunit);
        }
        break MISSING_BLOCK_LABEL_320;
_L6:
        waiter = waiters;
        timeunit = waiter;
        if (waiter != Waiter.TOMBSTONE) goto _L7; else goto _L4
_L4:
        return getDoneValue(value);
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
        l = l1 - System.nanoTime();
          goto _L2
        throw new TimeoutException();
    }

    protected void interruptTask()
    {
    }

    public boolean isCancelled()
    {
        return value instanceof Cancellation;
    }

    public boolean isDone()
    {
        boolean flag1 = true;
        Object obj = value;
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (obj instanceof SetFuture)
        {
            flag1 = false;
        }
        return flag & flag1;
    }

    final void maybePropagateCancellation(Future future)
    {
        boolean flag;
        if (future != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag & isCancelled())
        {
            future.cancel(wasInterrupted());
        }
    }

    protected Throwable newCancellationCause()
    {
        return new CancellationException("Future.cancel() was called.");
    }

    protected boolean set(Object obj)
    {
        if (obj == null)
        {
            obj = NULL;
        }
        if (ATOMIC_HELPER.casValue(this, null, obj))
        {
            complete();
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean setException(Throwable throwable)
    {
        throwable = new Failure((Throwable)Preconditions.checkNotNull(throwable));
        if (ATOMIC_HELPER.casValue(this, null, throwable))
        {
            complete();
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean setFuture(ListenableFuture listenablefuture)
    {
        Preconditions.checkNotNull(listenablefuture);
        Object obj1 = value;
        Object obj = obj1;
        if (obj1 == null)
        {
            if (listenablefuture.isDone())
            {
                return completeWithFuture(listenablefuture, null);
            }
            obj = new SetFuture(listenablefuture);
            if (ATOMIC_HELPER.casValue(this, null, obj))
            {
                try
                {
                    listenablefuture.addListener(((Runnable) (obj)), MoreExecutors.directExecutor());
                }
                // Misplaced declaration of an exception variable
                catch (ListenableFuture listenablefuture)
                {
                    try
                    {
                        listenablefuture = new Failure(listenablefuture);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ListenableFuture listenablefuture)
                    {
                        listenablefuture = Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, obj, listenablefuture);
                }
                return true;
            }
            obj = value;
        }
        if (obj instanceof Cancellation)
        {
            listenablefuture.cancel(((Cancellation)obj).wasInterrupted);
        }
        return false;
    }

    final Throwable trustedGetException()
    {
        return ((Failure)value).exception;
    }

    protected final boolean wasInterrupted()
    {
        Object obj = value;
        return (obj instanceof Cancellation) && ((Cancellation)obj).wasInterrupted;
    }

    static 
    {
        Object obj;
        log = Logger.getLogger(com/google/common/util/concurrent/AbstractFuture.getName());
        obj = null;
        AtomicHelper atomichelper = UnsafeAtomicHelperFactory.values()[0].tryCreateUnsafeAtomicHelper();
        obj = atomichelper;
_L2:
        if (obj == null)
        {
            WAITER_THREAD_UPDATER = AtomicReferenceFieldUpdater.newUpdater(com/google/common/util/concurrent/AbstractFuture$Waiter, java/lang/Thread, "thread");
            WAITER_NEXT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(com/google/common/util/concurrent/AbstractFuture$Waiter, com/google/common/util/concurrent/AbstractFuture$Waiter, "next");
            WAITERS_UPDATER = AtomicReferenceFieldUpdater.newUpdater(com/google/common/util/concurrent/AbstractFuture, com/google/common/util/concurrent/AbstractFuture$Waiter, "waiters");
            LISTENERS_UPDATER = AtomicReferenceFieldUpdater.newUpdater(com/google/common/util/concurrent/AbstractFuture, com/google/common/util/concurrent/AbstractFuture$Listener, "listeners");
            VALUE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(com/google/common/util/concurrent/AbstractFuture, java/lang/Object, "value");
            obj = new SafeAtomicHelper();
        } else
        {
            WAITER_THREAD_UPDATER = null;
            WAITER_NEXT_UPDATER = null;
            WAITERS_UPDATER = null;
            LISTENERS_UPDATER = null;
            VALUE_UPDATER = null;
        }
        ATOMIC_HELPER = ((AtomicHelper) (obj));
        NULL = new Object();
        return;
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }








}

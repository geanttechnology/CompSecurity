// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.util.concurrent:
//            GwtFuturesCatchingSpecialization, MoreExecutors, ListenableFuture, FuturesGetChecked, 
//            Uninterruptibles, SerializingExecutor, SettableFuture, ExecutionError, 
//            UncheckedExecutionException, AsyncFunction, FutureCallback, FutureFallback, 
//            CheckedFuture, AbstractFuture, Platform, CollectionFuture, 
//            AbstractCheckedFuture

public final class Futures extends GwtFuturesCatchingSpecialization
{
    private static abstract class AbstractCatchingFuture extends AbstractFuture.TrustedFuture
        implements Runnable
    {

        Class exceptionType;
        Object fallback;
        ListenableFuture inputFuture;

        abstract void doFallback(Object obj, Throwable throwable)
            throws Exception;

        final void done()
        {
            maybePropagateCancellation(inputFuture);
            inputFuture = null;
            exceptionType = null;
            fallback = null;
        }

        public final void run()
        {
            Object obj;
            boolean flag2 = true;
            obj = inputFuture;
            Class class1 = exceptionType;
            Object obj1 = fallback;
            boolean flag;
            boolean flag1;
            if (obj == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (class1 == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (obj1 != null)
            {
                flag2 = false;
            }
            if (flag2 | (flag1 | flag) | isCancelled())
            {
                return;
            }
            inputFuture = null;
            exceptionType = null;
            fallback = null;
            try
            {
                set(Uninterruptibles.getUninterruptibly(((Future) (obj))));
                return;
            }
            catch (ExecutionException executionexception)
            {
                executionexception = executionexception.getCause();
            }
            // Misplaced declaration of an exception variable
            catch (ExecutionException executionexception) { }
            try
            {
                if (Platform.isInstanceOfThrowableClass(executionexception, class1))
                {
                    doFallback(obj1, executionexception);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (ExecutionException executionexception)
            {
                setException(executionexception);
                return;
            }
            setException(executionexception);
            return;
        }

        AbstractCatchingFuture(ListenableFuture listenablefuture, Class class1, Object obj)
        {
            inputFuture = (ListenableFuture)Preconditions.checkNotNull(listenablefuture);
            exceptionType = (Class)Preconditions.checkNotNull(class1);
            fallback = Preconditions.checkNotNull(obj);
        }
    }

    private static abstract class AbstractChainingFuture extends AbstractFuture.TrustedFuture
        implements Runnable
    {

        Object function;
        ListenableFuture inputFuture;

        abstract void doTransform(Object obj, Object obj1)
            throws Exception;

        final void done()
        {
            maybePropagateCancellation(inputFuture);
            inputFuture = null;
            function = null;
        }

        public final void run()
        {
            boolean flag1 = true;
            Object obj;
            Object obj1;
            boolean flag2;
            obj1 = inputFuture;
            obj = function;
            flag2 = isCancelled();
            boolean flag;
            if (obj1 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (obj != null)
            {
                flag1 = false;
            }
            if (flag1 | (flag | flag2))
            {
                return;
            }
              goto _L1
_L3:
            inputFuture = null;
            function = null;
            obj1 = Uninterruptibles.getUninterruptibly(((Future) (obj1)));
            doTransform(obj, obj1);
            return;
            obj;
            try
            {
                cancel(false);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                setException(((UndeclaredThrowableException) (obj)).getCause());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                setException(((Throwable) (obj)));
            }
            return;
            obj;
            setException(((ExecutionException) (obj)).getCause());
            return;
_L1:
            if (true) goto _L3; else goto _L2
_L2:
        }

        AbstractChainingFuture(ListenableFuture listenablefuture, Object obj)
        {
            inputFuture = (ListenableFuture)Preconditions.checkNotNull(listenablefuture);
            function = Preconditions.checkNotNull(obj);
        }
    }

    static final class AsyncCatchingFuture extends AbstractCatchingFuture
    {

        void doFallback(AsyncFunction asyncfunction, Throwable throwable)
            throws Exception
        {
            asyncfunction = asyncfunction.apply(throwable);
            Preconditions.checkNotNull(asyncfunction, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
            setFuture(asyncfunction);
        }

        volatile void doFallback(Object obj, Throwable throwable)
            throws Exception
        {
            doFallback((AsyncFunction)obj, throwable);
        }

        AsyncCatchingFuture(ListenableFuture listenablefuture, Class class1, AsyncFunction asyncfunction)
        {
            super(listenablefuture, class1, asyncfunction);
        }
    }

    private static final class AsyncChainingFuture extends AbstractChainingFuture
    {

        void doTransform(AsyncFunction asyncfunction, Object obj)
            throws Exception
        {
            asyncfunction = asyncfunction.apply(obj);
            Preconditions.checkNotNull(asyncfunction, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
            setFuture(asyncfunction);
        }

        volatile void doTransform(Object obj, Object obj1)
            throws Exception
        {
            doTransform((AsyncFunction)obj, obj1);
        }

        AsyncChainingFuture(ListenableFuture listenablefuture, AsyncFunction asyncfunction)
        {
            super(listenablefuture, asyncfunction);
        }
    }

    static final class CatchingFuture extends AbstractCatchingFuture
    {

        void doFallback(Function function, Throwable throwable)
            throws Exception
        {
            set(function.apply(throwable));
        }

        volatile void doFallback(Object obj, Throwable throwable)
            throws Exception
        {
            doFallback((Function)obj, throwable);
        }

        CatchingFuture(ListenableFuture listenablefuture, Class class1, Function function)
        {
            super(listenablefuture, class1, function);
        }
    }

    private static final class ChainingFuture extends AbstractChainingFuture
    {

        void doTransform(Function function, Object obj)
        {
            set(function.apply(obj));
        }

        volatile void doTransform(Object obj, Object obj1)
            throws Exception
        {
            doTransform((Function)obj, obj1);
        }

        ChainingFuture(ListenableFuture listenablefuture, Function function)
        {
            super(listenablefuture, function);
        }
    }

    private static class ImmediateCancelledFuture extends ImmediateFuture
    {

        private final CancellationException thrown = new CancellationException("Immediate cancelled future.");

        public Object get()
        {
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", thrown);
        }

        public boolean isCancelled()
        {
            return true;
        }

        ImmediateCancelledFuture()
        {
        }
    }

    private static class ImmediateFailedCheckedFuture extends ImmediateFuture
        implements CheckedFuture
    {

        private final Exception thrown;

        public Object checkedGet()
            throws Exception
        {
            throw thrown;
        }

        public Object checkedGet(long l, TimeUnit timeunit)
            throws Exception
        {
            Preconditions.checkNotNull(timeunit);
            throw thrown;
        }

        public Object get()
            throws ExecutionException
        {
            throw new ExecutionException(thrown);
        }

        ImmediateFailedCheckedFuture(Exception exception)
        {
            thrown = exception;
        }
    }

    private static class ImmediateFailedFuture extends ImmediateFuture
    {

        private final Throwable thrown;

        public Object get()
            throws ExecutionException
        {
            throw new ExecutionException(thrown);
        }

        ImmediateFailedFuture(Throwable throwable)
        {
            thrown = throwable;
        }
    }

    private static abstract class ImmediateFuture
        implements ListenableFuture
    {

        private static final Logger log = Logger.getLogger(com/google/common/util/concurrent/Futures$ImmediateFuture.getName());

        public void addListener(Runnable runnable, Executor executor)
        {
            Preconditions.checkNotNull(runnable, "Runnable was null.");
            Preconditions.checkNotNull(executor, "Executor was null.");
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

        public boolean cancel(boolean flag)
        {
            return false;
        }

        public abstract Object get()
            throws ExecutionException;

        public Object get(long l, TimeUnit timeunit)
            throws ExecutionException
        {
            Preconditions.checkNotNull(timeunit);
            return get();
        }

        public boolean isCancelled()
        {
            return false;
        }

        public boolean isDone()
        {
            return true;
        }


        private ImmediateFuture()
        {
        }

    }

    private static class ImmediateSuccessfulCheckedFuture extends ImmediateFuture
        implements CheckedFuture
    {

        private final Object value;

        public Object checkedGet()
        {
            return value;
        }

        public Object checkedGet(long l, TimeUnit timeunit)
        {
            Preconditions.checkNotNull(timeunit);
            return value;
        }

        public Object get()
        {
            return value;
        }

        ImmediateSuccessfulCheckedFuture(Object obj)
        {
            value = obj;
        }
    }

    private static class ImmediateSuccessfulFuture extends ImmediateFuture
    {

        static final ImmediateSuccessfulFuture NULL = new ImmediateSuccessfulFuture(null);
        private final Object value;

        public Object get()
        {
            return value;
        }


        ImmediateSuccessfulFuture(Object obj)
        {
            value = obj;
        }
    }

    private static final class ListFuture extends CollectionFuture
    {

        ListFuture(ImmutableCollection immutablecollection, boolean flag)
        {
            init(new ListFutureRunningState(immutablecollection, flag));
        }
    }

    private final class ListFuture.ListFutureRunningState extends CollectionFuture.CollectionFutureRunningState
    {

        final ListFuture this$0;

        public volatile Object combine(List list)
        {
            return combine(list);
        }

        public List combine(List list)
        {
            java.util.ArrayList arraylist = Lists.newArrayList();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                list = (Optional)iterator.next();
                if (list != null)
                {
                    list = ((List) (list.orNull()));
                } else
                {
                    list = null;
                }
                arraylist.add(list);
            }
            return Collections.unmodifiableList(arraylist);
        }

        ListFuture.ListFutureRunningState(ImmutableCollection immutablecollection, boolean flag)
        {
            this$0 = ListFuture.this;
            super(ListFuture.this, immutablecollection, flag);
        }
    }

    private static class MappingCheckedFuture extends AbstractCheckedFuture
    {

        final Function mapper;

        protected Exception mapException(Exception exception)
        {
            return (Exception)mapper.apply(exception);
        }

        MappingCheckedFuture(ListenableFuture listenablefuture, Function function)
        {
            super(listenablefuture);
            mapper = (Function)Preconditions.checkNotNull(function);
        }
    }

    private static final class NonCancellationPropagatingFuture extends AbstractFuture.TrustedFuture
    {

        NonCancellationPropagatingFuture(ListenableFuture listenablefuture)
        {
            listenablefuture.addListener(listenablefuture. new _cls1(), MoreExecutors.directExecutor());
        }
    }

    private static final class TimeoutFuture extends AbstractFuture.TrustedFuture
    {

        ListenableFuture delegateRef;
        Future timer;

        void done()
        {
            maybePropagateCancellation(delegateRef);
            Future future = timer;
            if (future != null)
            {
                future.cancel(false);
            }
            delegateRef = null;
            timer = null;
        }

        TimeoutFuture(ListenableFuture listenablefuture)
        {
            delegateRef = (ListenableFuture)Preconditions.checkNotNull(listenablefuture);
        }
    }

    private static final class TimeoutFuture.Fire
        implements Runnable
    {

        TimeoutFuture timeoutFutureRef;

        public void run()
        {
            TimeoutFuture timeoutfuture = timeoutFutureRef;
            if (timeoutfuture != null) goto _L2; else goto _L1
_L1:
            ListenableFuture listenablefuture;
            return;
_L2:
            if ((listenablefuture = timeoutfuture.delegateRef) == null) goto _L1; else goto _L3
_L3:
            timeoutFutureRef = null;
            if (listenablefuture.isDone())
            {
                timeoutfuture.setFuture(listenablefuture);
                return;
            }
            String s = String.valueOf(listenablefuture);
            timeoutfuture.setException(new TimeoutException((new StringBuilder(String.valueOf(s).length() + 18)).append("Future timed out: ").append(s).toString()));
            listenablefuture.cancel(true);
            return;
            Exception exception;
            exception;
            listenablefuture.cancel(true);
            throw exception;
        }

        TimeoutFuture.Fire(TimeoutFuture timeoutfuture)
        {
            timeoutFutureRef = timeoutfuture;
        }
    }


    private static final AsyncFunction DEREFERENCER = new AsyncFunction() {

        public ListenableFuture apply(ListenableFuture listenablefuture)
        {
            return listenablefuture;
        }

        public volatile ListenableFuture apply(Object obj)
            throws Exception
        {
            return apply((ListenableFuture)obj);
        }

    };

    private Futures()
    {
    }

    public static void addCallback(ListenableFuture listenablefuture, FutureCallback futurecallback)
    {
        addCallback(listenablefuture, futurecallback, MoreExecutors.directExecutor());
    }

    public static void addCallback(ListenableFuture listenablefuture, FutureCallback futurecallback, Executor executor)
    {
        Preconditions.checkNotNull(futurecallback);
        listenablefuture.addListener(new Runnable(listenablefuture, futurecallback) {

            final FutureCallback val$callback;
            final ListenableFuture val$future;

            public void run()
            {
                Object obj;
                try
                {
                    obj = Uninterruptibles.getUninterruptibly(future);
                }
                catch (ExecutionException executionexception)
                {
                    callback.onFailure(executionexception.getCause());
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    callback.onFailure(runtimeexception);
                    return;
                }
                catch (Error error)
                {
                    callback.onFailure(error);
                    return;
                }
                callback.onSuccess(obj);
            }

            
            {
                future = listenablefuture;
                callback = futurecallback;
                super();
            }
        }, executor);
    }

    public static ListenableFuture allAsList(Iterable iterable)
    {
        return new ListFuture(ImmutableList.copyOf(iterable), true);
    }

    public static transient ListenableFuture allAsList(ListenableFuture alistenablefuture[])
    {
        return new ListFuture(ImmutableList.copyOf(alistenablefuture), true);
    }

    static AsyncFunction asAsyncFunction(FutureFallback futurefallback)
    {
        Preconditions.checkNotNull(futurefallback);
        return new AsyncFunction(futurefallback) {

            final FutureFallback val$fallback;

            public volatile ListenableFuture apply(Object obj)
                throws Exception
            {
                return apply((Throwable)obj);
            }

            public ListenableFuture apply(Throwable throwable)
                throws Exception
            {
                return (ListenableFuture)Preconditions.checkNotNull(fallback.create(throwable), "FutureFallback.create returned null instead of a Future. Did you mean to return immediateFuture(null)?");
            }

            
            {
                fallback = futurefallback;
                super();
            }
        };
    }

    public static ListenableFuture catching(ListenableFuture listenablefuture, Class class1, Function function)
    {
        class1 = new CatchingFuture(listenablefuture, class1, function);
        listenablefuture.addListener(class1, MoreExecutors.directExecutor());
        return class1;
    }

    public static ListenableFuture catching(ListenableFuture listenablefuture, Class class1, Function function, Executor executor)
    {
        class1 = new CatchingFuture(listenablefuture, class1, function);
        listenablefuture.addListener(class1, rejectionPropagatingExecutor(executor, class1));
        return class1;
    }

    public static ListenableFuture catchingAsync(ListenableFuture listenablefuture, Class class1, AsyncFunction asyncfunction)
    {
        class1 = new AsyncCatchingFuture(listenablefuture, class1, asyncfunction);
        listenablefuture.addListener(class1, MoreExecutors.directExecutor());
        return class1;
    }

    public static ListenableFuture catchingAsync(ListenableFuture listenablefuture, Class class1, AsyncFunction asyncfunction, Executor executor)
    {
        class1 = new AsyncCatchingFuture(listenablefuture, class1, asyncfunction);
        listenablefuture.addListener(class1, rejectionPropagatingExecutor(executor, class1));
        return class1;
    }

    public static ListenableFuture dereference(ListenableFuture listenablefuture)
    {
        return transformAsync(listenablefuture, DEREFERENCER);
    }

    public static Object get(Future future, long l, TimeUnit timeunit, Class class1)
        throws Exception
    {
        return getChecked(future, class1, l, timeunit);
    }

    public static Object get(Future future, Class class1)
        throws Exception
    {
        return getChecked(future, class1);
    }

    public static Object getChecked(Future future, Class class1)
        throws Exception
    {
        return FuturesGetChecked.getChecked(future, class1);
    }

    public static Object getChecked(Future future, Class class1, long l, TimeUnit timeunit)
        throws Exception
    {
        return FuturesGetChecked.getChecked(future, class1, l, timeunit);
    }

    public static Object getUnchecked(Future future)
    {
        Preconditions.checkNotNull(future);
        try
        {
            future = ((Future) (Uninterruptibles.getUninterruptibly(future)));
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            wrapAndThrowUnchecked(future.getCause());
            throw new AssertionError();
        }
        return future;
    }

    public static ListenableFuture immediateCancelledFuture()
    {
        return new ImmediateCancelledFuture();
    }

    public static CheckedFuture immediateCheckedFuture(Object obj)
    {
        return new ImmediateSuccessfulCheckedFuture(obj);
    }

    public static CheckedFuture immediateFailedCheckedFuture(Exception exception)
    {
        Preconditions.checkNotNull(exception);
        return new ImmediateFailedCheckedFuture(exception);
    }

    public static ListenableFuture immediateFailedFuture(Throwable throwable)
    {
        Preconditions.checkNotNull(throwable);
        return new ImmediateFailedFuture(throwable);
    }

    public static ListenableFuture immediateFuture(Object obj)
    {
        if (obj == null)
        {
            return ImmediateSuccessfulFuture.NULL;
        } else
        {
            return new ImmediateSuccessfulFuture(obj);
        }
    }

    public static ImmutableList inCompletionOrder(Iterable iterable)
    {
        ConcurrentLinkedQueue concurrentlinkedqueue = Queues.newConcurrentLinkedQueue();
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        SerializingExecutor serializingexecutor = new SerializingExecutor(MoreExecutors.directExecutor());
        SettableFuture settablefuture;
        for (iterable = iterable.iterator(); iterable.hasNext(); builder.add(settablefuture))
        {
            ListenableFuture listenablefuture = (ListenableFuture)iterable.next();
            settablefuture = SettableFuture.create();
            concurrentlinkedqueue.add(settablefuture);
            listenablefuture.addListener(new Runnable(concurrentlinkedqueue, listenablefuture) {

                final ConcurrentLinkedQueue val$delegates;
                final ListenableFuture val$future;

                public void run()
                {
                    ((SettableFuture)delegates.remove()).setFuture(future);
                }

            
            {
                delegates = concurrentlinkedqueue;
                future = listenablefuture;
                super();
            }
            }, serializingexecutor);
        }

        return builder.build();
    }

    public static Future lazyTransform(Future future, Function function)
    {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Future(future, function) {

            final Function val$function;
            final Future val$input;

            private Object applyTransformation(Object obj)
                throws ExecutionException
            {
                try
                {
                    obj = function.apply(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new ExecutionException(((Throwable) (obj)));
                }
                return obj;
            }

            public boolean cancel(boolean flag)
            {
                return input.cancel(flag);
            }

            public Object get()
                throws InterruptedException, ExecutionException
            {
                return applyTransformation(input.get());
            }

            public Object get(long l, TimeUnit timeunit)
                throws InterruptedException, ExecutionException, TimeoutException
            {
                return applyTransformation(input.get(l, timeunit));
            }

            public boolean isCancelled()
            {
                return input.isCancelled();
            }

            public boolean isDone()
            {
                return input.isDone();
            }

            
            {
                input = future;
                function = function1;
                super();
            }
        };
    }

    public static CheckedFuture makeChecked(ListenableFuture listenablefuture, Function function)
    {
        return new MappingCheckedFuture((ListenableFuture)Preconditions.checkNotNull(listenablefuture), function);
    }

    public static ListenableFuture nonCancellationPropagating(ListenableFuture listenablefuture)
    {
        return new NonCancellationPropagatingFuture(listenablefuture);
    }

    private static Executor rejectionPropagatingExecutor(Executor executor, AbstractFuture abstractfuture)
    {
        Preconditions.checkNotNull(executor);
        if (executor == MoreExecutors.directExecutor())
        {
            return executor;
        } else
        {
            return new Executor(executor, abstractfuture) {

                volatile boolean thrownFromDelegate;
                final Executor val$delegate;
                final AbstractFuture val$future;

                public void execute(Runnable runnable)
                {
                    delegate.execute(runnable. new Runnable() {

                        final _cls2 this$0;
                        final Runnable val$command;

                        public void run()
                        {
                            thrownFromDelegate = false;
                            command.run();
                        }

            
            {
                this$0 = final__pcls2;
                command = Runnable.this;
                super();
            }
                    });
_L1:
                    return;
                    runnable;
                    if (thrownFromDelegate)
                    {
                        future.setException(runnable);
                        return;
                    }
                      goto _L1
                }

            
            {
                delegate = executor;
                future = abstractfuture;
                super();
                thrownFromDelegate = true;
            }
            };
        }
    }

    public static ListenableFuture successfulAsList(Iterable iterable)
    {
        return new ListFuture(ImmutableList.copyOf(iterable), false);
    }

    public static transient ListenableFuture successfulAsList(ListenableFuture alistenablefuture[])
    {
        return new ListFuture(ImmutableList.copyOf(alistenablefuture), false);
    }

    public static ListenableFuture transform(ListenableFuture listenablefuture, Function function)
    {
        Preconditions.checkNotNull(function);
        function = new ChainingFuture(listenablefuture, function);
        listenablefuture.addListener(function, MoreExecutors.directExecutor());
        return function;
    }

    public static ListenableFuture transform(ListenableFuture listenablefuture, Function function, Executor executor)
    {
        Preconditions.checkNotNull(function);
        function = new ChainingFuture(listenablefuture, function);
        listenablefuture.addListener(function, rejectionPropagatingExecutor(executor, function));
        return function;
    }

    public static ListenableFuture transform(ListenableFuture listenablefuture, AsyncFunction asyncfunction)
    {
        return transformAsync(listenablefuture, asyncfunction);
    }

    public static ListenableFuture transform(ListenableFuture listenablefuture, AsyncFunction asyncfunction, Executor executor)
    {
        return transformAsync(listenablefuture, asyncfunction, executor);
    }

    public static ListenableFuture transformAsync(ListenableFuture listenablefuture, AsyncFunction asyncfunction)
    {
        asyncfunction = new AsyncChainingFuture(listenablefuture, asyncfunction);
        listenablefuture.addListener(asyncfunction, MoreExecutors.directExecutor());
        return asyncfunction;
    }

    public static ListenableFuture transformAsync(ListenableFuture listenablefuture, AsyncFunction asyncfunction, Executor executor)
    {
        Preconditions.checkNotNull(executor);
        asyncfunction = new AsyncChainingFuture(listenablefuture, asyncfunction);
        listenablefuture.addListener(asyncfunction, rejectionPropagatingExecutor(executor, asyncfunction));
        return asyncfunction;
    }

    public static ListenableFuture withFallback(ListenableFuture listenablefuture, FutureFallback futurefallback)
    {
        return withFallback(listenablefuture, futurefallback, MoreExecutors.directExecutor());
    }

    public static ListenableFuture withFallback(ListenableFuture listenablefuture, FutureFallback futurefallback, Executor executor)
    {
        return catchingAsync(listenablefuture, java/lang/Throwable, asAsyncFunction(futurefallback), executor);
    }

    public static ListenableFuture withTimeout(ListenableFuture listenablefuture, long l, TimeUnit timeunit, ScheduledExecutorService scheduledexecutorservice)
    {
        TimeoutFuture timeoutfuture = new TimeoutFuture(listenablefuture);
        TimeoutFuture.Fire fire = new TimeoutFuture.Fire(timeoutfuture);
        timeoutfuture.timer = scheduledexecutorservice.schedule(fire, l, timeunit);
        listenablefuture.addListener(fire, MoreExecutors.directExecutor());
        return timeoutfuture;
    }

    private static void wrapAndThrowUnchecked(Throwable throwable)
    {
        if (throwable instanceof Error)
        {
            throw new ExecutionError((Error)throwable);
        } else
        {
            throw new UncheckedExecutionException(throwable);
        }
    }


    // Unreferenced inner class com/google/common/util/concurrent/Futures$NonCancellationPropagatingFuture$1

/* anonymous class */
    class NonCancellationPropagatingFuture._cls1
        implements Runnable
    {

        final NonCancellationPropagatingFuture this$0;
        final ListenableFuture val$delegate;

        public void run()
        {
            setFuture(delegate);
        }

            
            {
                this$0 = final_noncancellationpropagatingfuture;
                delegate = ListenableFuture.this;
                super();
            }
    }

}

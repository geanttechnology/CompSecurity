// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.apprupt.sdk:
//            Logger

public class Q
{
    private class BasePromise
        implements Promise
    {

        private Throwable error;
        private Object result;
        private final Task task;
        final Q this$0;

        public Throwable getError()
        {
            return error;
        }

        public Object getResult()
        {
            return result;
        }

        public boolean isError()
        {
            return error != null;
        }

        public void resolve(Throwable throwable, Object obj, Completion completion1)
        {
            Logger.log log1 = log;
            String s;
            if (throwable == null)
            {
                s = "[OK]";
            } else
            {
                s = "[E]";
            }
            log1.v(throwable, new Object[] {
                "Promise resolve", s, obj
            });
            if (throwable != null)
            {
                error = throwable;
            } else
            {
                Object obj1 = obj;
                if (obj != null)
                {
                    throwable = ((Throwable) (obj));
                    if (obj instanceof Task)
                    {
                        throwable = new BasePromise((Task)obj);
                    }
                    obj1 = throwable;
                    if (throwable instanceof Promise)
                    {
                        ((Promise)throwable).run(result, completion1);
                        return;
                    }
                }
                result = obj1;
            }
            completion1.complete(this);
        }

        public void run(Object obj, Completion completion1)
        {
            completion1 = new BaseResolver(this, completion1);
            try
            {
                task.run(obj, completion1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                completion1.fail(((Throwable) (obj)));
            }
        }

        private BasePromise(Task task1)
        {
            this$0 = Q.this;
            super();
            error = null;
            result = null;
            task = task1;
        }

    }

    private class BaseResolver
        implements Resolver
    {

        private final Completion completion;
        private final BasePromise promise;
        final Q this$0;

        public void fail(Throwable throwable)
        {
            fail(throwable, null);
        }

        public void fail(Throwable throwable, Object obj)
        {
            Object obj1 = throwable;
            if (throwable == null)
            {
                obj1 = new Exception("Unknown error!");
            }
            promise.resolve(((Throwable) (obj1)), obj, completion);
        }

        public void resolve(Object obj)
        {
            promise.resolve(null, obj, completion);
        }

        private BaseResolver(BasePromise basepromise, Completion completion1)
        {
            this$0 = Q.this;
            super();
            promise = basepromise;
            completion = completion1;
        }

    }

    public static interface Completion
    {

        public abstract void complete(Promise promise);
    }

    public static interface CompletionHandler
    {

        public abstract void onComplete(Throwable throwable, Object obj);
    }

    public static interface FailureHandler
    {

        public abstract void onFailure(Throwable throwable, Object obj);
    }

    public static interface Promise
    {

        public abstract Throwable getError();

        public abstract Object getResult();

        public abstract boolean isError();

        public abstract void run(Object obj, Completion completion1);
    }

    public static interface Resolver
    {

        public abstract void fail(Throwable throwable);

        public abstract void fail(Throwable throwable, Object obj);

        public abstract void resolve(Object obj);
    }

    public static interface SuccessHandler
    {

        public abstract void onSuccess(Object obj);
    }

    public static interface Task
    {

        public abstract void run(Object obj, Resolver resolver)
            throws Exception;
    }


    private static int identifierCounter = 0;
    private final ArrayList complete;
    private final Completion completion;
    private Throwable error;
    private final ArrayList failure;
    private volatile boolean finished;
    private final Handler handler;
    private final Logger.log log;
    private final ArrayList promises;
    private final ArrayList success;
    private Object value;

    public Q()
    {
        promises = new ArrayList();
        complete = new ArrayList();
        failure = new ArrayList();
        success = new ArrayList();
        value = null;
        error = null;
        finished = false;
        completion = new Completion() {

            final Q this$0;

            public void complete(Promise promise)
            {
            /* block-local class not found */
            class _cls1 {}

                handler.post(new _cls1(promise));
            }

            
            {
                this$0 = Q.this;
                super();
            }
        };
        StringBuilder stringbuilder = (new StringBuilder()).append("Q.");
        int i = identifierCounter + 1;
        identifierCounter = i;
        log = Logger.get(stringbuilder.append(i).toString());
        log.v(new Object[] {
            "intializing queue..."
        });
        handler = new Handler();
        log.v(new Object[] {
            "Creating initial task..."
        });
        handler.post(new Runnable() {

            final Q this$0;

            public void run()
            {
                log.v(new Object[] {
                    "Initial task start!"
                });
                next(null);
            }

            
            {
                this$0 = Q.this;
                super();
            }
        });
    }

    public Q(Promise promise)
    {
        this();
        then(promise);
    }

    public Q(Task task)
    {
        this();
        then(new BasePromise(task));
    }

    private void finish()
    {
        log.v(new Object[] {
            "tasks end, run final stuff"
        });
        if (finished)
        {
            throw new InternalError("Q tasks are over already!");
        }
        finished = true;
        if (error == null)
        {
            for (Iterator iterator = success.iterator(); iterator.hasNext(); ((SuccessHandler)iterator.next()).onSuccess(value)) { }
        } else
        {
            for (Iterator iterator1 = failure.iterator(); iterator1.hasNext(); ((FailureHandler)iterator1.next()).onFailure(error, value)) { }
        }
        for (Iterator iterator2 = complete.iterator(); iterator2.hasNext(); ((CompletionHandler)iterator2.next()).onComplete(error, value)) { }
        success.clear();
        failure.clear();
        complete.clear();
    }

    private void next(Promise promise)
    {
        log.v(new Object[] {
            "next task..."
        });
        if (promise != null)
        {
            value = promise.getResult();
            if (promise.isError())
            {
                error = promise.getError();
                finish();
                return;
            }
        }
        if (promises.size() > 0)
        {
            ((Promise)promises.remove(0)).run(value, completion);
            return;
        } else
        {
            finish();
            return;
        }
    }

    private void run(Runnable runnable)
    {
        run(runnable, null);
    }

    private void run(final Runnable tmp, final String finishedError)
    {
        Runnable runnable = tmp;
        if (finishedError != null)
        {
            runnable = new Runnable() {

                final Q this$0;
                final String val$finishedError;
                final Runnable val$tmp;

                public void run()
                {
                    if (finished)
                    {
                        throw new InternalError(finishedError);
                    } else
                    {
                        tmp.run();
                        return;
                    }
                }

            
            {
                this$0 = Q.this;
                finishedError = s;
                tmp = runnable;
                super();
            }
            };
        }
        if (handler.getLooper().equals(Looper.myLooper()))
        {
            runnable.run();
            return;
        } else
        {
            handler.post(runnable);
            return;
        }
    }

    public static Q take(Object obj)
    {
        return (new Q()).withValue(obj);
    }

    public static Q when(Task task)
    {
        return new Q(task);
    }

    public Q complete(final CompletionHandler handler)
    {
        log.v(new Object[] {
            "new completion handler..."
        });
        run(new Runnable() {

            final Q this$0;
            final CompletionHandler val$handler;

            public void run()
            {
                if (finished)
                {
                    handler.onComplete(error, value);
                    return;
                } else
                {
                    complete.add(handler);
                    return;
                }
            }

            
            {
                this$0 = Q.this;
                handler = completionhandler;
                super();
            }
        });
        return this;
    }

    public Q failure(final FailureHandler handler)
    {
        log.v(new Object[] {
            "new failure handler..."
        });
        run(new Runnable() {

            final Q this$0;
            final FailureHandler val$handler;

            public void run()
            {
                if (finished)
                {
                    handler.onFailure(error, value);
                    return;
                } else
                {
                    failure.add(handler);
                    return;
                }
            }

            
            {
                this$0 = Q.this;
                handler = failurehandler;
                super();
            }
        });
        return this;
    }

    public Q success(final SuccessHandler handler)
    {
        log.v(new Object[] {
            "new success handler..."
        });
        run(new Runnable() {

            final Q this$0;
            final SuccessHandler val$handler;

            public void run()
            {
                if (finished)
                {
                    handler.onSuccess(value);
                    return;
                } else
                {
                    success.add(handler);
                    return;
                }
            }

            
            {
                this$0 = Q.this;
                handler = successhandler;
                super();
            }
        });
        return this;
    }

    public Q then(Promise promise)
    {
        log.v(new Object[] {
            "new promise..."
        });
        promises.add(promise);
        return this;
    }

    public Q then(Task task)
    {
        return then(((Promise) (new BasePromise(task))));
    }

    public Q withValue(final Object value)
    {
        run(new Runnable() {

            final Q this$0;
            final Object val$value;

            public void run()
            {
                Q.this.value = value;
            }

            
            {
                this$0 = Q.this;
                value = obj;
                super();
            }
        }, "Cannot set initial value when task is done!");
        return this;
    }









/*
    static Object access$602(Q q, Object obj)
    {
        q.value = obj;
        return obj;
    }

*/



}

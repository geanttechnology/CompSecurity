// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit;

import e.a;
import e.j;
import java.util.concurrent.Executor;

// Referenced classes of package retrofit:
//            ErrorHandler, RequestInterceptor, RequestInterceptorTape

final class RxSupport
{

    private final ErrorHandler errorHandler;
    private final Executor executor;
    private final RequestInterceptor requestInterceptor;

    RxSupport(Executor executor1, ErrorHandler errorhandler, RequestInterceptor requestinterceptor)
    {
        executor = executor1;
        errorHandler = errorhandler;
        requestInterceptor = requestinterceptor;
    }

    private Runnable getRunnable(final j subscriber, final Invoker invoker, final RequestInterceptorTape interceptorTape)
    {
        return new _cls2();
    }

    final a createRequestObservable(final Invoker invoker)
    {
        return a.a(new _cls1());
    }





    private class _cls2
        implements Runnable
    {

        final RxSupport this$0;
        final RequestInterceptorTape val$interceptorTape;
        final Invoker val$invoker;
        final j val$subscriber;

        public void run()
        {
            if (subscriber.c())
            {
                return;
            }
            try
            {
                ResponseWrapper responsewrapper = invoker.invoke(interceptorTape);
                subscriber.a(responsewrapper.responseBody);
                subscriber.a();
                return;
            }
            catch (RetrofitError retrofiterror)
            {
                subscriber.a(errorHandler.handleError(retrofiterror));
            }
            return;
        }

        _cls2()
        {
            this$0 = RxSupport.this;
            subscriber = j1;
            invoker = invoker1;
            interceptorTape = requestinterceptortape;
            super();
        }

        private class Invoker
        {

            public abstract ResponseWrapper invoke(RequestInterceptor requestinterceptor);
        }

    }


    private class _cls1
        implements b
    {

        final RxSupport this$0;
        final Invoker val$invoker;

        public void call(j j1)
        {
            Object obj = new RequestInterceptorTape();
            requestInterceptor.intercept(((RequestInterceptor.RequestFacade) (obj)));
            obj = new FutureTask(getRunnable(j1, invoker, ((RequestInterceptorTape) (obj))), null);
            j1.a(e.a(((java.util.concurrent.Future) (obj))));
            executor.execute(((Runnable) (obj)));
        }

        public volatile void call(Object obj)
        {
            call((j)obj);
        }

        _cls1()
        {
            this$0 = RxSupport.this;
            invoker = invoker1;
            super();
        }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package roboguice.util:
//            AndroidCallableI

public class AndroidCallableWrapper
    implements Runnable
{

    static HashMap isPreCallOverriddenMap = new HashMap();
    protected AndroidCallableI _flddelegate;
    protected Handler handler;
    protected StackTraceElement launchLocation[];

    public AndroidCallableWrapper(Handler handler1, AndroidCallableI androidcallablei, StackTraceElement astacktraceelement[])
    {
        _flddelegate = androidcallablei;
        launchLocation = astacktraceelement;
        if (handler1 == null)
        {
            handler1 = new Handler(Looper.getMainLooper());
        }
        handler = handler1;
    }

    static boolean isPreCallOverriden(Class class1)
    {
        boolean flag = false;
        Boolean boolean1;
        try
        {
            boolean1 = (Boolean)isPreCallOverriddenMap.get(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException(class1);
        }
        if (boolean1 == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        return boolean1.booleanValue();
        if (class1.getMethod("onPreCall", new Class[0]).getDeclaringClass() != roboguice/util/AndroidCallableWrapper)
        {
            flag = true;
        }
        boolean1 = Boolean.valueOf(flag);
        isPreCallOverriddenMap.put(class1, boolean1);
        flag = boolean1.booleanValue();
        return flag;
    }

    void afterCall(final Object result, final Exception e)
    {
        handler.post(new Runnable() {

            final AndroidCallableWrapper this$0;
            final Exception val$e;
            final Object val$result;

            public void run()
            {
                if (e == null) goto _L2; else goto _L1
_L1:
                if (launchLocation != null)
                {
                    StackTraceElement astacktraceelement[] = e.getStackTrace();
                    StackTraceElement astacktraceelement1[] = new StackTraceElement[astacktraceelement.length + launchLocation.length];
                    System.arraycopy(astacktraceelement, 0, astacktraceelement1, 0, astacktraceelement.length);
                    System.arraycopy(launchLocation, 0, astacktraceelement1, astacktraceelement.length, launchLocation.length);
                    e.setStackTrace(astacktraceelement1);
                }
                doOnException(e);
_L4:
                doOnFinally();
                return;
_L2:
                doOnSuccess(result);
                if (true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                doOnFinally();
                throw exception;
            }

            
            {
                this$0 = AndroidCallableWrapper.this;
                e = exception;
                result = obj;
                super();
            }
        });
    }

    void beforeCall()
        throws Exception
    {
        final CountDownLatch latch = new CountDownLatch(1);
        final Exception exceptions[] = new Exception[1];
        handler.post(new Runnable() {

            final AndroidCallableWrapper this$0;
            final Exception val$exceptions[];
            final CountDownLatch val$latch;

            public void run()
            {
                (new Callable() {

                    final _cls1 this$1;

                    public Object call()
                        throws Exception
                    {
                        doOnPreCall();
                        return null;
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).call();
                latch.countDown();
                return;
                Object obj;
                obj;
                exceptions[0] = ((Exception) (obj));
                latch.countDown();
                return;
                obj;
                latch.countDown();
                throw obj;
            }

            
            {
                this$0 = AndroidCallableWrapper.this;
                exceptions = aexception;
                latch = countdownlatch;
                super();
            }
        });
        latch.await();
        if (exceptions[0] != null)
        {
            throw exceptions[0];
        } else
        {
            return;
        }
    }

    protected Object doDoInBackgroundThread()
        throws Exception
    {
        return _flddelegate.doInBackground();
    }

    protected void doOnException(Exception exception)
    {
        _flddelegate.onException(exception);
    }

    protected void doOnFinally()
    {
        _flddelegate.onFinally();
    }

    protected void doOnPreCall()
        throws Exception
    {
        _flddelegate.onPreCall();
    }

    protected void doOnSuccess(Object obj)
    {
        _flddelegate.onSuccess(obj);
    }

    public void run()
    {
        Exception exception1;
        Object obj;
        try
        {
            if (isPreCallOverriden(_flddelegate.getClass()))
            {
                beforeCall();
            }
            obj = doDoInBackgroundThread();
        }
        catch (Exception exception)
        {
            afterCall(null, exception);
            return;
        }
        finally
        {
            afterCall(null, null);
        }
        afterCall(obj, null);
        return;
        throw exception1;
    }

}

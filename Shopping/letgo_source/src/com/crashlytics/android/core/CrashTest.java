// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.os.AsyncTask;
import android.support.v7.alt;
import android.support.v7.amc;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

public class CrashTest
{

    public CrashTest()
    {
    }

    private void privateMethodThatThrowsException(String s)
    {
        throw new RuntimeException(s);
    }

    public void crashAsyncTask(final long delayMs)
    {
        TraceFieldInterface tracefieldinterface = new TraceFieldInterface() {

            public Trace _nr_trace;
            final CrashTest this$0;
            final long val$delayMs;

            public void _nr_setTrace(Trace trace)
            {
                try
                {
                    _nr_trace = trace;
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Trace trace)
                {
                    return;
                }
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                TraceMachine.enterMethod(_nr_trace, "CrashTest$1#doInBackground", null);
_L1:
                aobj = doInBackground((Void[])aobj);
                TraceMachine.exitMethod();
                TraceMachine.unloadTraceContext(this);
                return ((Object) (aobj));
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                TraceMachine.enterMethod(null, "CrashTest$1#doInBackground", null);
                  goto _L1
            }

            protected transient Void doInBackground(Void avoid1[])
            {
                try
                {
                    Thread.sleep(delayMs);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid1[]) { }
                throwRuntimeException("Background thread crash");
                return null;
            }

            
            {
                this$0 = CrashTest.this;
                delayMs = l;
                super();
            }
        };
        Void avoid[] = new Void[1];
        avoid[0] = (Void)null;
        if (!(tracefieldinterface instanceof AsyncTask))
        {
            tracefieldinterface.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)tracefieldinterface, avoid);
            return;
        }
    }

    public void indexOutOfBounds()
    {
        int i = (new int[2])[10];
        alt.h().a("CrashlyticsCore", (new StringBuilder()).append("Out of bounds value: ").append(i).toString());
    }

    public int stackOverflow()
    {
        return stackOverflow() + (int)Math.random();
    }

    public void throwFiveChainedExceptions()
    {
        try
        {
            privateMethodThatThrowsException("1");
            return;
        }
        catch (Exception exception)
        {
            try
            {
                throw new RuntimeException("2", exception);
            }
            catch (Exception exception1)
            {
                try
                {
                    throw new RuntimeException("3", exception1);
                }
                catch (Exception exception2)
                {
                    try
                    {
                        throw new RuntimeException("4", exception2);
                    }
                    catch (Exception exception3)
                    {
                        throw new RuntimeException("5", exception3);
                    }
                }
            }
        }
    }

    public void throwRuntimeException(String s)
    {
        throw new RuntimeException(s);
    }
}

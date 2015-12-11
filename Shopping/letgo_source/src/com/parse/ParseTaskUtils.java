// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cl;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            ParseException, ParseCallback1, ParseCallback2, ParseExecutors

class ParseTaskUtils
{

    ParseTaskUtils()
    {
    }

    static cu callbackOnMainThreadAsync(cu cu1, ParseCallback1 parsecallback1)
    {
        return callbackOnMainThreadAsync(cu1, parsecallback1, false);
    }

    static cu callbackOnMainThreadAsync(cu cu1, ParseCallback1 parsecallback1, boolean flag)
    {
        if (parsecallback1 == null)
        {
            return cu1;
        } else
        {
            return callbackOnMainThreadAsync(cu1, new ParseCallback2(parsecallback1) {

                final ParseCallback1 val$callback;

                public volatile void done(Object obj, Throwable throwable)
                {
                    done((Void)obj, (ParseException)throwable);
                }

                public void done(Void void1, ParseException parseexception)
                {
                    callback.done(parseexception);
                }

            
            {
                callback = parsecallback1;
                super();
            }
            }, flag);
        }
    }

    static cu callbackOnMainThreadAsync(cu cu1, ParseCallback2 parsecallback2)
    {
        return callbackOnMainThreadAsync(cu1, parsecallback2, false);
    }

    static cu callbackOnMainThreadAsync(cu cu1, ParseCallback2 parsecallback2, boolean flag)
    {
        if (parsecallback2 == null)
        {
            return cu1;
        } else
        {
            android.support.v7.cu.a a = cu.a();
            cu1.a(new ct(flag, a, parsecallback2) {

                final ParseCallback2 val$callback;
                final boolean val$reportCancellation;
                final android.support.v7.cu.a val$tcs;

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

                public Void then(cu cu2)
                    throws Exception
                {
                    if (cu2.c() && !reportCancellation)
                    {
                        tcs.c();
                        return null;
                    } else
                    {
                        ParseExecutors.main().execute(cu2. new Runnable() {

                            final _cls2 this$0;
                            final cu val$task;

                            public void run()
                            {
                                Object obj = task.f();
                                if (obj == null)
                                {
                                    break MISSING_BLOCK_LABEL_28;
                                }
                                if (!(obj instanceof ParseException))
                                {
                                    obj = new ParseException(((Throwable) (obj)));
                                }
                                callback.done(task.e(), (ParseException)obj);
                                if (task.c())
                                {
                                    tcs.c();
                                    return;
                                }
                                if (task.d())
                                {
                                    tcs.b(task.f());
                                    return;
                                } else
                                {
                                    tcs.b(task.e());
                                    return;
                                }
                                Exception exception;
                                exception;
                                if (task.c())
                                {
                                    tcs.c();
                                } else
                                if (task.d())
                                {
                                    tcs.b(task.f());
                                } else
                                {
                                    tcs.b(task.e());
                                }
                                throw exception;
                            }

            
            {
                this$0 = final__pcls2;
                task = cu.this;
                super();
            }
                        });
                        return null;
                    }
                }

            
            {
                reportCancellation = flag;
                tcs = a;
                callback = parsecallback2;
                super();
            }
            });
            return a.a();
        }
    }

    static Object wait(cu cu1)
        throws ParseException
    {
        try
        {
            cu1.g();
            if (!cu1.d())
            {
                break MISSING_BLOCK_LABEL_75;
            }
            cu1 = cu1.f();
            if (cu1 instanceof ParseException)
            {
                throw (ParseException)cu1;
            }
        }
        // Misplaced declaration of an exception variable
        catch (cu cu1)
        {
            throw new RuntimeException(cu1);
        }
        if (cu1 instanceof cl)
        {
            throw new ParseException(cu1);
        }
        if (cu1 instanceof RuntimeException)
        {
            throw (RuntimeException)cu1;
        } else
        {
            throw new RuntimeException(cu1);
        }
        if (cu1.c())
        {
            throw new RuntimeException(new CancellationException());
        }
        cu1 = ((cu) (cu1.e()));
        return cu1;
    }
}

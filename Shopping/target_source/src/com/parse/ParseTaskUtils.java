// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.a;
import a.i;
import a.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

// Referenced classes of package com.parse:
//            ParseException, ParseCallback1, ParseCallback2, ParseExecutors

class ParseTaskUtils
{

    ParseTaskUtils()
    {
    }

    static j callbackOnMainThreadAsync(j j1, ParseCallback1 parsecallback1)
    {
        return callbackOnMainThreadAsync(j1, parsecallback1, false);
    }

    static j callbackOnMainThreadAsync(j j1, ParseCallback1 parsecallback1, boolean flag)
    {
        if (parsecallback1 == null)
        {
            return j1;
        } else
        {
            return callbackOnMainThreadAsync(j1, new ParseCallback2(parsecallback1) {

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

    static j callbackOnMainThreadAsync(j j1, ParseCallback2 parsecallback2)
    {
        return callbackOnMainThreadAsync(j1, parsecallback2, false);
    }

    static j callbackOnMainThreadAsync(j j1, ParseCallback2 parsecallback2, boolean flag)
    {
        if (parsecallback2 == null)
        {
            return j1;
        } else
        {
            a.j.a a1 = j.a();
            j1.a(new i(flag, a1, parsecallback2) {

                final ParseCallback2 val$callback;
                final boolean val$reportCancellation;
                final a.j.a val$tcs;

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

                public Void then(j j2)
                    throws Exception
                {
                    if (j2.c() && !reportCancellation)
                    {
                        tcs.c();
                        return null;
                    } else
                    {
                        ParseExecutors.main().execute(j2. new Runnable() {

                            final _cls2 this$0;
                            final j val$task;

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
                task = j.this;
                super();
            }
                        });
                        return null;
                    }
                }

            
            {
                reportCancellation = flag;
                tcs = a1;
                callback = parsecallback2;
                super();
            }
            });
            return a1.a();
        }
    }

    static Object wait(j j1)
        throws ParseException
    {
        try
        {
            j1.g();
            if (!j1.d())
            {
                break MISSING_BLOCK_LABEL_75;
            }
            j1 = j1.f();
            if (j1 instanceof ParseException)
            {
                throw (ParseException)j1;
            }
        }
        // Misplaced declaration of an exception variable
        catch (j j1)
        {
            throw new RuntimeException(j1);
        }
        if (j1 instanceof a)
        {
            throw new ParseException(j1);
        }
        if (j1 instanceof RuntimeException)
        {
            throw (RuntimeException)j1;
        } else
        {
            throw new RuntimeException(j1);
        }
        if (j1.c())
        {
            throw new RuntimeException(new CancellationException());
        }
        j1 = ((j) (j1.e()));
        return j1;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser, ParseAnonymousUtils, TaskQueue, ParseException

static final class 
    implements i
{

    final Map val$authData;
    final String val$authType;
    final i val$logInWithTask;

    public j then(j j1)
        throws Exception
    {
        final Object user;
        user = (ParseUser)j1.e();
        if (user != null)
        {
label0:
            {
                synchronized (((ParseUser) (user)).mutex)
                {
                    if (!ParseAnonymousUtils.isLinked(((ParseUser) (user))))
                    {
                        break MISSING_BLOCK_LABEL_96;
                    }
                    if (!((ParseUser) (user)).isLazy())
                    {
                        break label0;
                    }
                    final Map oldAnonymousData = ParseUser.access$400(((ParseUser) (user)), "anonymous");
                    user = ((ParseUser) (user)).taskQueue.enqueue(new i() {

                        final ParseUser._cls12 this$0;
                        final Map val$oldAnonymousData;
                        final ParseUser val$user;

                        public j then(j j2)
                            throws Exception
                        {
                            return j2.b(new i() {

                                final _cls1 this$1;

                                public j then(j j1)
                                    throws Exception
                                {
                                    synchronized (user.mutex)
                                    {
                                        ParseUser.access$600(user);
                                        user.putAuthData(authType, authData);
                                        j1 = user.resolveLazinessAsync(j1);
                                    }
                                    return j1;
                                    j1;
                                    obj;
                                    JVM INSTR monitorexit ;
                                    throw j1;
                                }

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            }).b(new i() {

                                final _cls1 this$1;

                                public j then(j j1)
                                    throws Exception
                                {
label0:
                                    {
                                        synchronized (user.mutex)
                                        {
                                            if (!j1.d())
                                            {
                                                break label0;
                                            }
                                            ParseUser.access$500(user, authType);
                                            ParseUser.access$300(user, oldAnonymousData);
                                            j1 = j.a(j1.f());
                                        }
                                        return j1;
                                    }
                                    if (!j1.c())
                                    {
                                        break MISSING_BLOCK_LABEL_89;
                                    }
                                    j1 = j.h();
                                    obj;
                                    JVM INSTR monitorexit ;
                                    return j1;
                                    j1;
                                    obj;
                                    JVM INSTR monitorexit ;
                                    throw j1;
                                    j1 = j.a(user);
                                    obj;
                                    JVM INSTR monitorexit ;
                                    return j1;
                                }

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            });
                        }

                        public volatile Object then(j j2)
                            throws Exception
                        {
                            return then(j2);
                        }

            
            {
                this$0 = ParseUser._cls12.this;
                user = parseuser;
                oldAnonymousData = map;
                super();
            }
                    });
                }
                return ((j) (user));
            }
        }
          goto _L1
        user = ((ParseUser) (user)).linkWithInBackground(val$authType, val$authData).b(new i() {

            final ParseUser._cls12 this$0;
            final ParseUser val$user;

            public j then(j j2)
                throws Exception
            {
                if (j2.d())
                {
                    Exception exception1 = j2.f();
                    if ((exception1 instanceof ParseException) && ((ParseException)exception1).getCode() == 208)
                    {
                        return j.a(null).b(logInWithTask);
                    }
                }
                if (j2.c())
                {
                    return j.h();
                } else
                {
                    return j.a(user);
                }
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParseUser._cls12.this;
                user = parseuser;
                super();
            }
        });
        j1;
        JVM INSTR monitorexit ;
        return ((j) (user));
        exception;
        j1;
        JVM INSTR monitorexit ;
        throw exception;
        j1;
        JVM INSTR monitorexit ;
_L1:
        return j.a(null).b(val$logInWithTask);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    (String s, Map map, i k)
    {
        val$authType = s;
        val$authData = map;
        val$logInWithTask = k;
        super();
    }
}

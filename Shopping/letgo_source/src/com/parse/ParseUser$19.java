// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser, ParseAnonymousUtils, TaskQueue, ParseException

static final class 
    implements ct
{

    final Map val$authData;
    final String val$authType;
    final ct val$logInWithTask;

    public cu then(cu cu1)
        throws Exception
    {
        final Object user;
        user = (ParseUser)cu1.e();
        if (user != null)
        {
label0:
            {
                synchronized (((ParseUser) (user)).mutex)
                {
                    if (!ParseAnonymousUtils.isLinked(((ParseUser) (user))))
                    {
                        break MISSING_BLOCK_LABEL_100;
                    }
                    if (!((ParseUser) (user)).isLazy())
                    {
                        break label0;
                    }
                    final Map oldAnonymousData = ParseUser.access$1900(((ParseUser) (user)), "anonymous");
                    user = ((ParseUser) (user)).taskQueue.enqueue(new ct() {

                        final ParseUser._cls19 this$0;
                        final Map val$oldAnonymousData;
                        final ParseUser val$user;

                        public cu then(cu cu2)
                            throws Exception
                        {
                            return cu2.b(new ct() {

                                final _cls1 this$1;

                                public cu then(cu cu1)
                                    throws Exception
                                {
                                    synchronized (user.mutex)
                                    {
                                        ParseUser.access$2100(user);
                                        ParseUser.access$1800(user, authType, authData);
                                        cu1 = ParseUser.access$2200(user, cu1).j();
                                    }
                                    return cu1;
                                    cu1;
                                    obj;
                                    JVM INSTR monitorexit ;
                                    throw cu1;
                                }

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            }).b(new ct() {

                                final _cls1 this$1;

                                public cu then(cu cu1)
                                    throws Exception
                                {
label0:
                                    {
                                        synchronized (user.mutex)
                                        {
                                            if (!cu1.d())
                                            {
                                                break label0;
                                            }
                                            ParseUser.access$2000(user, authType);
                                            ParseUser.access$400(user, oldAnonymousData);
                                            cu1 = cu.a(cu1.f());
                                        }
                                        return cu1;
                                    }
                                    if (!cu1.c())
                                    {
                                        break MISSING_BLOCK_LABEL_89;
                                    }
                                    cu1 = cu.h();
                                    obj;
                                    JVM INSTR monitorexit ;
                                    return cu1;
                                    cu1;
                                    obj;
                                    JVM INSTR monitorexit ;
                                    throw cu1;
                                    cu1 = cu.a(user);
                                    obj;
                                    JVM INSTR monitorexit ;
                                    return cu1;
                                }

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            });
                        }

                        public volatile Object then(cu cu2)
                            throws Exception
                        {
                            return then(cu2);
                        }

            
            {
                this$0 = ParseUser._cls19.this;
                user = parseuser;
                oldAnonymousData = map;
                super();
            }
                    });
                }
                return ((cu) (user));
            }
        }
          goto _L1
        user = ((ParseUser) (user)).linkWithAsync(val$authType, val$authData, ((ParseUser) (user)).getSessionToken()).b(new ct() {

            final ParseUser._cls19 this$0;
            final ParseUser val$user;

            public cu then(cu cu2)
                throws Exception
            {
                if (cu2.d())
                {
                    Exception exception1 = cu2.f();
                    if ((exception1 instanceof ParseException) && ((ParseException)exception1).getCode() == 208)
                    {
                        return cu.a(null).b(logInWithTask);
                    }
                }
                if (cu2.c())
                {
                    return cu.h();
                } else
                {
                    return cu.a(user);
                }
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseUser._cls19.this;
                user = parseuser;
                super();
            }
        });
        cu1;
        JVM INSTR monitorexit ;
        return ((cu) (user));
        exception;
        cu1;
        JVM INSTR monitorexit ;
        throw exception;
        cu1;
        JVM INSTR monitorexit ;
_L1:
        return cu.a(null).b(val$logInWithTask);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    (String s, Map map, ct ct1)
    {
        val$authType = s;
        val$authData = map;
        val$logInWithTask = ct1;
        super();
    }
}

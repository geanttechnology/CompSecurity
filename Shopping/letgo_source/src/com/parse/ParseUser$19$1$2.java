// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser, ParseAnonymousUtils, TaskQueue, ParseException

class this._cls1
    implements ct
{

    final then this$1;

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

    logInWithTask()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$19

/* anonymous class */
    static final class ParseUser._cls19
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
                        Map map = ParseUser.access$1900(((ParseUser) (user)), "anonymous");
                        user = ((ParseUser) (user)).taskQueue.enqueue(map. new ParseUser._cls19._cls1());
                    }
                    return ((cu) (user));
                }
            }
              goto _L1
            user = ((ParseUser) (user)).linkWithAsync(authType, authData, ((ParseUser) (user)).getSessionToken()).b(new ParseUser._cls19._cls2());
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
            return cu.a(null).b(logInWithTask);
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                authType = s;
                authData = map;
                logInWithTask = ct1;
                super();
            }

        // Unreferenced inner class com/parse/ParseUser$19$2

/* anonymous class */
        class ParseUser._cls19._cls2
            implements ct
        {

            final ParseUser._cls19 this$0;
            final ParseUser val$user;

            public cu then(cu cu1)
                throws Exception
            {
                if (cu1.d())
                {
                    Exception exception = cu1.f();
                    if ((exception instanceof ParseException) && ((ParseException)exception).getCode() == 208)
                    {
                        return cu.a(null).b(logInWithTask);
                    }
                }
                if (cu1.c())
                {
                    return cu.h();
                } else
                {
                    return cu.a(user);
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$0 = ParseUser._cls19.this;
                        user = parseuser;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/parse/ParseUser$19$1

/* anonymous class */
    class ParseUser._cls19._cls1
        implements ct
    {

        final ParseUser._cls19 this$0;
        final Map val$oldAnonymousData;
        final ParseUser val$user;

        public cu then(cu cu1)
            throws Exception
        {
            return cu1.b(new ParseUser._cls19._cls1._cls2()).b(new ParseUser._cls19._cls1._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final__pcls19;
                user = parseuser;
                oldAnonymousData = Map.this;
                super();
            }

        // Unreferenced inner class com/parse/ParseUser$19$1$1

/* anonymous class */
        class ParseUser._cls19._cls1._cls1
            implements ct
        {

            final ParseUser._cls19._cls1 this$1;

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
                        this$1 = ParseUser._cls19._cls1.this;
                        super();
                    }
        }

    }

}

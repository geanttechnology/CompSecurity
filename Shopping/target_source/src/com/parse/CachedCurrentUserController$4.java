// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Arrays;

// Referenced classes of package com.parse:
//            CachedCurrentUserController, ParseObjectStore, ParseUser

class this._cls0
    implements i
{

    final CachedCurrentUserController this$0;

    public j then(j j1)
        throws Exception
    {
        final j userTask = getAsync(false);
        return j.a(Arrays.asList(new j[] {
            userTask, j1
        })).b(new i() {

            final CachedCurrentUserController._cls4 this$1;
            final j val$userTask;

            public j then(j j2)
                throws Exception
            {
                return j.a(Arrays.asList(new j[] {
                    userTask.d(new i() {

                        final _cls1 this$2;

                        public j then(j j1)
                            throws Exception
                        {
                            ParseUser parseuser = (ParseUser)j1.e();
                            if (parseuser == null)
                            {
                                return j1.i();
                            } else
                            {
                                return parseuser.logOutAsync();
                            }
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    }), CachedCurrentUserController.access$100(this$0).deleteAsync().a(new i() {

                        final _cls1 this$2;

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

                        public Void then(j j1)
                            throws Exception
                        {
                            boolean flag;
                            if (!j1.d())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            synchronized (CachedCurrentUserController.access$000(this$0))
                            {
                                currentUserMatchesDisk = flag;
                                currentUser = null;
                            }
                            return null;
                            exception;
                            j1;
                            JVM INSTR monitorexit ;
                            throw exception;
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    })
                }));
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = CachedCurrentUserController._cls4.this;
                userTask = j1;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.val.userTask()
    {
        this$0 = CachedCurrentUserController.this;
        super();
    }
}

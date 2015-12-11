// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            CachedCurrentUserController, ParseObjectStore, ParseUser

class this._cls1
    implements i
{

    final then this$1;

    public j then(j j1)
        throws Exception
    {
        return CachedCurrentUserController.access$100(_fld0).setAsync(user).a(new i() {

            final CachedCurrentUserController._cls1._cls1 this$2;

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            public Void then(j j2)
                throws Exception
            {
                Object obj = CachedCurrentUserController.access$000(this$0);
                obj;
                JVM INSTR monitorenter ;
                CachedCurrentUserController cachedcurrentusercontroller = this$0;
                boolean flag;
                if (!j2.d())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                cachedcurrentusercontroller.currentUserMatchesDisk = flag;
                currentUser = user;
                obj;
                JVM INSTR monitorexit ;
                return null;
                j2;
                obj;
                JVM INSTR monitorexit ;
                throw j2;
            }

            
            {
                this$2 = CachedCurrentUserController._cls1._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.user()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/CachedCurrentUserController$1

/* anonymous class */
    class CachedCurrentUserController._cls1
        implements i
    {

        final CachedCurrentUserController this$0;
        final ParseUser val$user;

        public j then(j j1)
            throws Exception
        {
            return j1.b(new CachedCurrentUserController._cls1._cls3()).d(new CachedCurrentUserController._cls1._cls2()).d(new CachedCurrentUserController._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_cachedcurrentusercontroller;
                user = ParseUser.this;
                super();
            }

        // Unreferenced inner class com/parse/CachedCurrentUserController$1$2

/* anonymous class */
        class CachedCurrentUserController._cls1._cls2
            implements i
        {

            final CachedCurrentUserController._cls1 this$1;

            public j then(j j1)
                throws Exception
            {
                user.setIsCurrentUser(true);
                return user.synchronizeAllAuthDataAsync();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$1 = CachedCurrentUserController._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/CachedCurrentUserController$1$3

/* anonymous class */
        class CachedCurrentUserController._cls1._cls3
            implements i
        {

            final CachedCurrentUserController._cls1 this$1;

            public j then(j j1)
                throws Exception
            {
                ParseUser parseuser;
                synchronized (CachedCurrentUserController.access$000(this$0))
                {
                    parseuser = currentUser;
                }
                obj = j1;
                if (parseuser != null)
                {
                    obj = j1;
                    if (parseuser != user)
                    {
                        obj = parseuser.logOutAsync(false).a(new CachedCurrentUserController._cls1._cls3._cls1());
                    }
                }
                return ((j) (obj));
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
                        this$1 = CachedCurrentUserController._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/CachedCurrentUserController$1$3$1

/* anonymous class */
        class CachedCurrentUserController._cls1._cls3._cls1
            implements i
        {

            final CachedCurrentUserController._cls1._cls3 this$2;

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            public Void then(j j1)
                throws Exception
            {
                return null;
            }

                    
                    {
                        this$2 = CachedCurrentUserController._cls1._cls3.this;
                        super();
                    }
        }

    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Arrays;

// Referenced classes of package com.parse:
//            ParseUser, CachedCurrentUserController, ParseObjectStore

class this._cls2
    implements i
{

    final then this$2;

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

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/parse/CachedCurrentUserController$4

/* anonymous class */
    class CachedCurrentUserController._cls4
        implements i
    {

        final CachedCurrentUserController this$0;

        public j then(j j1)
            throws Exception
        {
            j j2 = getAsync(false);
            return j.a(Arrays.asList(new j[] {
                j2, j1
            })).b(j2. new CachedCurrentUserController._cls4._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = CachedCurrentUserController.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/CachedCurrentUserController$4$1

/* anonymous class */
    class CachedCurrentUserController._cls4._cls1
        implements i
    {

        final CachedCurrentUserController._cls4 this$1;
        final j val$userTask;

        public j then(j j1)
            throws Exception
        {
            return j.a(Arrays.asList(new j[] {
                userTask.d(new CachedCurrentUserController._cls4._cls1._cls1()), CachedCurrentUserController.access$100(this$0).deleteAsync().a(new CachedCurrentUserController._cls4._cls1._cls2())
            }));
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$1 = final__pcls4;
                userTask = j.this;
                super();
            }

        // Unreferenced inner class com/parse/CachedCurrentUserController$4$1$2

/* anonymous class */
        class CachedCurrentUserController._cls4._cls1._cls2
            implements i
        {

            final CachedCurrentUserController._cls4._cls1 this$2;

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
                        this$2 = CachedCurrentUserController._cls4._cls1.this;
                        super();
                    }
        }

    }

}

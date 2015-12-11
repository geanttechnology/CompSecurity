// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseUser, CachedCurrentUserController, ParseObjectStore

class this._cls2
    implements i
{

    final then this$2;

    public ParseUser then(j j1)
        throws Exception
    {
        boolean flag = true;
        ParseUser parseuser = (ParseUser)j1.e();
        if (j1.d())
        {
            flag = false;
        }
        synchronized (CachedCurrentUserController.access$000(_fld0))
        {
            currentUser = parseuser;
            currentUserMatchesDisk = flag;
        }
        if (parseuser != null)
        {
            synchronized (parseuser.mutex)
            {
                parseuser.setIsCurrentUser(true);
            }
            return parseuser;
        }
        break MISSING_BLOCK_LABEL_98;
        exception;
        j1;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        j1;
        JVM INSTR monitorexit ;
        throw exception1;
        if (shouldAutoCreateUser)
        {
            return CachedCurrentUserController.access$200(_fld0);
        } else
        {
            return null;
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    shouldAutoCreateUser()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/parse/CachedCurrentUserController$5

/* anonymous class */
    class CachedCurrentUserController._cls5
        implements i
    {

        final CachedCurrentUserController this$0;
        final boolean val$shouldAutoCreateUser;

        public j then(j j1)
            throws Exception
        {
            return j1.b(new CachedCurrentUserController._cls5._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_cachedcurrentusercontroller;
                shouldAutoCreateUser = Z.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/CachedCurrentUserController$5$1

/* anonymous class */
    class CachedCurrentUserController._cls5._cls1
        implements i
    {

        final CachedCurrentUserController._cls5 this$1;

        public j then(j j1)
            throws Exception
        {
            boolean flag;
            ParseUser parseuser;
            synchronized (CachedCurrentUserController.access$000(this$0))
            {
                parseuser = currentUser;
                flag = currentUserMatchesDisk;
            }
            if (parseuser != null)
            {
                return j.a(parseuser);
            }
            break MISSING_BLOCK_LABEL_51;
            exception;
            j1;
            JVM INSTR monitorexit ;
            throw exception;
            if (flag)
            {
                if (shouldAutoCreateUser)
                {
                    return j.a(CachedCurrentUserController.access$200(this$0));
                } else
                {
                    return null;
                }
            } else
            {
                return CachedCurrentUserController.access$100(this$0).getAsync().a(new CachedCurrentUserController._cls5._cls1._cls1());
            }
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$1 = CachedCurrentUserController._cls5.this;
                super();
            }
    }

}

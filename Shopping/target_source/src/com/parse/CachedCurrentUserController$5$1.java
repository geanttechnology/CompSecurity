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
        boolean flag;
        ParseUser parseuser;
        synchronized (CachedCurrentUserController.access$000(_fld0))
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
                return j.a(CachedCurrentUserController.access$200(_fld0));
            } else
            {
                return null;
            }
        } else
        {
            return CachedCurrentUserController.access$100(_fld0).getAsync().a(new i() {

                final CachedCurrentUserController._cls5._cls1 this$2;

                public ParseUser then(j j2)
                    throws Exception
                {
                    boolean flag1 = true;
                    ParseUser parseuser1 = (ParseUser)j2.e();
                    if (j2.d())
                    {
                        flag1 = false;
                    }
                    synchronized (CachedCurrentUserController.access$000(this$0))
                    {
                        currentUser = parseuser1;
                        currentUserMatchesDisk = flag1;
                    }
                    if (parseuser1 != null)
                    {
                        synchronized (parseuser1.mutex)
                        {
                            parseuser1.setIsCurrentUser(true);
                        }
                        return parseuser1;
                    }
                    break MISSING_BLOCK_LABEL_98;
                    exception1;
                    j2;
                    JVM INSTR monitorexit ;
                    throw exception1;
                    exception2;
                    j2;
                    JVM INSTR monitorexit ;
                    throw exception2;
                    if (shouldAutoCreateUser)
                    {
                        return CachedCurrentUserController.access$200(this$0);
                    } else
                    {
                        return null;
                    }
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$2 = CachedCurrentUserController._cls5._cls1.this;
                super();
            }
            });
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.shouldAutoCreateUser()
    {
        this$1 = this._cls1.this;
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

}

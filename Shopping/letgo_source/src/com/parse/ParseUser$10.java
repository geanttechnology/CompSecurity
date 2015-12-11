// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseUser, ParseAnonymousUtils, Parse, ParseQuery, 
//            ParseObject

static final class 
    implements ct
{

    final boolean val$shouldAutoCreateUser;

    public cu then(cu cu1)
        throws Exception
    {
        boolean flag;
        ParseUser parseuser;
        synchronized (ParseUser.access$900())
        {
            parseuser = ParseUser.currentUser;
            flag = ParseUser.access$1000();
        }
        if (parseuser != null)
        {
            return cu.a(parseuser);
        }
        break MISSING_BLOCK_LABEL_30;
        exception;
        cu1;
        JVM INSTR monitorexit ;
        throw exception;
        if (flag)
        {
            if (val$shouldAutoCreateUser)
            {
                return cu.a(ParseAnonymousUtils.lazyLogIn());
            } else
            {
                return null;
            }
        }
        if (Parse.isLocalDatastoreEnabled())
        {
            cu1 = ParseQuery.getQuery(com/parse/ParseUser).fromPin("_currentUser").ignoreACLs().findInBackground().d(new ct() {

                final ParseUser._cls10 this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    cu2 = (List)cu2.e();
                    if (cu2 != null)
                    {
                        if (cu2.size() == 1)
                        {
                            return cu.a(cu2.get(0));
                        } else
                        {
                            return ParseObject.unpinAllInBackground("_currentUser").i();
                        }
                    } else
                    {
                        return cu.a(null);
                    }
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseUser._cls10.this;
                super();
            }
            }).d(new ct() {

                final ParseUser._cls10 this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    if ((ParseUser)cu2.e() != null)
                    {
                        return cu2;
                    } else
                    {
                        return ParseObject.migrateFromDiskToLDS("currentUser", "_currentUser").i();
                    }
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseUser._cls10.this;
                super();
            }
            });
        } else
        {
            cu1 = cu.a((ParseUser)ParseObject.getFromDisk("currentUser"));
        }
        return cu1.a(new ct() {

            final ParseUser._cls10 this$0;

            public ParseUser then(cu cu2)
                throws Exception
            {
                boolean flag1 = true;
                ParseUser parseuser1 = (ParseUser)cu2.e();
                if (cu2.d())
                {
                    flag1 = false;
                }
                synchronized (ParseUser.access$900())
                {
                    ParseUser.currentUser = parseuser1;
                    ParseUser.access$1002(flag1);
                }
                if (parseuser1 != null)
                {
                    synchronized (parseuser1.mutex)
                    {
                        ParseUser.access$1102(parseuser1, true);
                        ParseUser.access$702(parseuser1, ParseAnonymousUtils.isLinked(parseuser1));
                    }
                    return parseuser1;
                }
                break MISSING_BLOCK_LABEL_79;
                exception1;
                cu2;
                JVM INSTR monitorexit ;
                throw exception1;
                exception2;
                cu2;
                JVM INSTR monitorexit ;
                throw exception2;
                if (shouldAutoCreateUser)
                {
                    return ParseAnonymousUtils.lazyLogIn();
                } else
                {
                    return null;
                }
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseUser._cls10.this;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    (boolean flag)
    {
        val$shouldAutoCreateUser = flag;
        super();
    }
}

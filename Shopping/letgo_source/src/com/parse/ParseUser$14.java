// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseUser, Parse, ParseObject

static final class 
    implements ct
{

    final ParseUser val$user;

    public cu then(cu cu1)
        throws Exception
    {
        ParseUser parseuser;
        synchronized (ParseUser.access$900())
        {
            parseuser = ParseUser.currentUser;
        }
        if (parseuser != null && parseuser != val$user)
        {
            ParseUser.access$1300(parseuser);
        }
        synchronized (val$user.mutex)
        {
            ParseUser.access$1102(val$user, true);
            ParseUser.access$1400(val$user);
        }
        if (Parse.isLocalDatastoreEnabled())
        {
            return ParseObject.unpinAllInBackground("_currentUser").b(new ct() {

                final ParseUser._cls14 this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    return user.pinInBackground("_currentUser", false);
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseUser._cls14.this;
                super();
            }
            });
        } else
        {
            return cu.a(new Callable() {

                final ParseUser._cls14 this$0;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    user.saveToDisk("currentUser");
                    return null;
                }

            
            {
                this$0 = ParseUser._cls14.this;
                super();
            }
            }, cu.a);
        }
        exception;
        cu1;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        cu1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    (ParseUser parseuser)
    {
        val$user = parseuser;
        super();
    }
}

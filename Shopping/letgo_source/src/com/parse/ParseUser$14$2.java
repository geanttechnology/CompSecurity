// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseUser, Parse, ParseObject

class this._cls0
    implements Callable
{

    final oDisk this$0;

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

    l.user()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$14

/* anonymous class */
    static final class ParseUser._cls14
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
            if (parseuser != null && parseuser != user)
            {
                ParseUser.access$1300(parseuser);
            }
            synchronized (user.mutex)
            {
                ParseUser.access$1102(user, true);
                ParseUser.access$1400(user);
            }
            if (Parse.isLocalDatastoreEnabled())
            {
                return ParseObject.unpinAllInBackground("_currentUser").b(new ParseUser._cls14._cls1());
            } else
            {
                return cu.a(new ParseUser._cls14._cls2(), cu.a);
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

            
            {
                user = parseuser;
                super();
            }

        // Unreferenced inner class com/parse/ParseUser$14$1

/* anonymous class */
        class ParseUser._cls14._cls1
            implements ct
        {

            final ParseUser._cls14 this$0;

            public cu then(cu cu1)
                throws Exception
            {
                return user.pinInBackground("_currentUser", false);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$0 = ParseUser._cls14.this;
                        super();
                    }
        }

    }

}

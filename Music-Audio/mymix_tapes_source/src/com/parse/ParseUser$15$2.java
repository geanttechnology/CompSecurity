// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser

class this._cls0
    implements Continuation
{

    final then this$0;

    public Task then(Task task)
        throws Exception
    {
        synchronized (user.mutex)
        {
            ParseUser.access$1300(user);
            ParseUser.access$900(user).put(authType, authData);
            ParseUser.access$1000(user).add(authType);
            task = ParseUser.access$1400(user, task).makeVoid();
        }
        return task;
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.oldAnonymousData()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$15

/* anonymous class */
    static final class ParseUser._cls15
        implements Continuation
    {

        final JSONObject val$authData;
        final String val$authType;
        final JSONObject val$oldAnonymousData;
        final ParseUser val$user;

        public Task then(Task task)
            throws Exception
        {
            return Task.forResult(null).continueWithTask(new ParseUser._cls15._cls2()).continueWithTask(new ParseUser._cls15._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                user = parseuser;
                authType = s;
                authData = jsonobject;
                oldAnonymousData = jsonobject1;
                super();
            }

        // Unreferenced inner class com/parse/ParseUser$15$1

/* anonymous class */
        class ParseUser._cls15._cls1
            implements Continuation
        {

            final ParseUser._cls15 this$0;

            public Task then(Task task)
                throws Exception
            {
label0:
                {
                    synchronized (user.mutex)
                    {
                        if (!task.isFaulted())
                        {
                            break label0;
                        }
                        ParseUser.access$900(user).remove(authType);
                        ParseUser.access$1000(user).remove(authType);
                        ParseUser.access$1200(user, oldAnonymousData);
                        task = Task.forError(task.getError());
                    }
                    return task;
                }
                if (!task.isCancelled())
                {
                    break MISSING_BLOCK_LABEL_113;
                }
                task = Task.cancelled();
                obj;
                JVM INSTR monitorexit ;
                return task;
                task;
                obj;
                JVM INSTR monitorexit ;
                throw task;
                task = Task.forResult(user);
                obj;
                JVM INSTR monitorexit ;
                return task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$0 = ParseUser._cls15.this;
                        super();
                    }
        }

    }

}

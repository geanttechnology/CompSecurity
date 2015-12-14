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

static final class 
    implements Continuation
{

    final JSONObject val$authData;
    final String val$authType;
    final JSONObject val$oldAnonymousData;
    final ParseUser val$user;

    public Task then(Task task)
        throws Exception
    {
        return Task.forResult(null).continueWithTask(new Continuation() {

            final ParseUser._cls15 this$0;

            public Task then(Task task1)
                throws Exception
            {
                synchronized (user.mutex)
                {
                    ParseUser.access$1300(user);
                    ParseUser.access$900(user).put(authType, authData);
                    ParseUser.access$1000(user).add(authType);
                    task1 = ParseUser.access$1400(user, task1).makeVoid();
                }
                return task1;
                task1;
                obj;
                JVM INSTR monitorexit ;
                throw task1;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser._cls15.this;
                super();
            }
        }).continueWithTask(new Continuation() {

            final ParseUser._cls15 this$0;

            public Task then(Task task1)
                throws Exception
            {
label0:
                {
                    synchronized (user.mutex)
                    {
                        if (!task1.isFaulted())
                        {
                            break label0;
                        }
                        ParseUser.access$900(user).remove(authType);
                        ParseUser.access$1000(user).remove(authType);
                        ParseUser.access$1200(user, oldAnonymousData);
                        task1 = Task.forError(task1.getError());
                    }
                    return task1;
                }
                if (!task1.isCancelled())
                {
                    break MISSING_BLOCK_LABEL_113;
                }
                task1 = Task.cancelled();
                obj;
                JVM INSTR monitorexit ;
                return task1;
                task1;
                obj;
                JVM INSTR monitorexit ;
                throw task1;
                task1 = Task.forResult(user);
                obj;
                JVM INSTR monitorexit ;
                return task1;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseUser._cls15.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (ParseUser parseuser, String s, JSONObject jsonobject, JSONObject jsonobject1)
    {
        val$user = parseuser;
        val$authType = s;
        val$authData = jsonobject;
        val$oldAnonymousData = jsonobject1;
        super();
    }
}

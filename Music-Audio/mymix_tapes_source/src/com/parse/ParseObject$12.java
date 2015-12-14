// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject, ParseACL, ParseUser

class val.operations
    implements Continuation
{

    final ParseObject this$0;
    final Capture val$operations;

    public Task then(Task task)
        throws Exception
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        validateSave();
        val$operations.set(startSave());
        if (!ParseObject.access$500(ParseObject.this, "ACL") || ParseObject.access$600(ParseObject.this, false) == null || !ParseObject.access$600(ParseObject.this, false).hasUnresolvedUser())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        task = ParseUser.getCurrentUser().saveInBackground().onSuccess(new Continuation() {

            final ParseObject._cls12 this$1;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public Void then(Task task1)
                throws Exception
            {
                if (ParseObject.access$600(this$0, false).hasUnresolvedUser())
                {
                    throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
                } else
                {
                    return null;
                }
            }

            
            {
                this$1 = ParseObject._cls12.this;
                super();
            }
        });
        return task;
        obj;
        JVM INSTR monitorexit ;
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

    _cls1.this._cls1()
    {
        this$0 = final_parseobject;
        val$operations = Capture.this;
        super();
    }
}

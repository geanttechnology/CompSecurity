// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject, ParseACL, ParseUser

class this._cls1
    implements Continuation
{

    final tion this$1;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        if (ParseObject.access$600(_fld0, false).hasUnresolvedUser())
        {
            throw new IllegalStateException("ACL has an unresolved ParseUser. Save or sign up before attempting to serialize the ACL.");
        } else
        {
            return null;
        }
    }

    l.operations()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$12

/* anonymous class */
    class ParseObject._cls12
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
            operations.set(startSave());
            if (!ParseObject.access$500(ParseObject.this, "ACL") || ParseObject.access$600(ParseObject.this, false) == null || !ParseObject.access$600(ParseObject.this, false).hasUnresolvedUser())
            {
                break MISSING_BLOCK_LABEL_90;
            }
            task = ParseUser.getCurrentUser().saveInBackground().onSuccess(new ParseObject._cls12._cls1());
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

            
            {
                this$0 = final_parseobject;
                operations = Capture.this;
                super();
            }
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package com.parse:
//            ParseObject, ParseCommand

class this._cls0
    implements Continuation
{

    final then this$0;

    public Task then(Task task)
        throws Exception
    {
        return task.continueWithTask(new Continuation() {

            final ParseObject._cls34._cls1 this$1;

            public Task then(Task task1)
                throws Exception
            {
                task1 = new JSONArray();
                for (Iterator iterator = uniqueObjects.iterator(); iterator.hasNext(); task1.put(ParseObject.access$1200((ParseObject)iterator.next(), true, sessionToken).toJSONObject())) { }
                ParseCommand parsecommand = new ParseCommand("multi", sessionToken);
                parsecommand.put("commands", task1);
                return parsecommand.executeAsync().makeVoid();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParseObject._cls34._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.sessionToken()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseObject$34

/* anonymous class */
    static final class ParseObject._cls34
        implements Continuation
    {

        final String val$sessionToken;
        final List val$uniqueObjects;

        public Task then(Task task)
            throws Exception
        {
            if (uniqueObjects.size() == 0)
            {
                return Task.forResult(null);
            } else
            {
                return ParseObject.enqueueForAll(uniqueObjects, new ParseObject._cls34._cls1());
            }
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                uniqueObjects = list;
                sessionToken = s;
                super();
            }
    }

}

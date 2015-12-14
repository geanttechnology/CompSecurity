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

static final class val.sessionToken
    implements Continuation
{

    final String val$sessionToken;
    final List val$uniqueObjects;

    public Task then(Task task)
        throws Exception
    {
        if (val$uniqueObjects.size() == 0)
        {
            return Task.forResult(null);
        } else
        {
            return ParseObject.enqueueForAll(val$uniqueObjects, new Continuation() {

                final ParseObject._cls34 this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    return task1.continueWithTask(new Continuation() {

                        final _cls1 this$1;

                        public Task then(Task task)
                            throws Exception
                        {
                            task = new JSONArray();
                            for (Iterator iterator = uniqueObjects.iterator(); iterator.hasNext(); task.put(ParseObject.access$1200((ParseObject)iterator.next(), true, sessionToken).toJSONObject())) { }
                            ParseCommand parsecommand = new ParseCommand("multi", sessionToken);
                            parsecommand.put("commands", task);
                            return parsecommand.executeAsync().makeVoid();
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseObject._cls34.this;
                super();
            }
            });
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.this._cls0(List list, String s)
    {
        val$uniqueObjects = list;
        val$sessionToken = s;
        super();
    }
}

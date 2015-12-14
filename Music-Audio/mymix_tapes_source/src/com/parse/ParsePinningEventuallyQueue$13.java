// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin, ParseObject, ParseCommand, 
//            ParseOperationSet, ParseException

class val.operationSet
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;
    final ParseOperationSet val$operationSet;

    public Task then(Task task)
        throws Exception
    {
        final int type = val$eventuallyPin.getType();
        final ParseObject object = val$eventuallyPin.getObject();
        task = val$eventuallyPin.getSessionToken();
        if (type == 1)
        {
            task = object.saveAsync(val$operationSet, task);
        } else
        if (type == 2)
        {
            task = object.deleteAsync(task);
        } else
        {
            task = val$eventuallyPin.getCommand().executeAsync();
        }
        return task.continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue._cls13 this$1;
            final ParseObject val$object;
            final int val$type;

            public Task then(Task task1)
                throws Exception
            {
                Exception exception = task1.getError();
                if (exception != null && (exception instanceof ParseException) && ((ParseException)exception).getCode() == 100)
                {
                    setConnected(false);
                    notifyTestHelper(7);
                    return ParsePinningEventuallyQueue.access$1300(this$0, eventuallyPin, operationSet);
                } else
                {
                    return eventuallyPin.unpinInBackground("_eventuallyPin").continueWithTask(task1. new Continuation() {

                        final _cls1 this$2;
                        final Task val$saveTask;

                        public Task then(Task task)
                            throws Exception
                        {
                            Object obj = saveTask.getResult();
                            if (type == 1)
                            {
                                task = object.handleSaveEventuallyResultAsync((JSONObject)obj, operationSet);
                            } else
                            if (type == 2)
                            {
                                return object.handleDeleteEventuallyResultAsync(obj);
                            }
                            return task;
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$2 = final__pcls1;
                saveTask = Task.this;
                super();
            }
                    }).continueWithTask(task1. new Continuation() {

                        final _cls1 this$2;
                        final Task val$saveTask;

                        public Task then(Task task)
                            throws Exception
                        {
                            return saveTask;
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$2 = final__pcls1;
                saveTask = Task.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls13.this;
                type = i;
                object = parseobject;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.val.object()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$eventuallyPin = eventuallypin;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}

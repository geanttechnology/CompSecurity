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

class val.saveTask
    implements Continuation
{

    final then this$2;
    final Task val$saveTask;

    public Task then(Task task)
        throws Exception
    {
        return val$saveTask;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    operationSet()
    {
        this$2 = final_operationset;
        val$saveTask = Task.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$13

/* anonymous class */
    class ParsePinningEventuallyQueue._cls13
        implements Continuation
    {

        final ParsePinningEventuallyQueue this$0;
        final EventuallyPin val$eventuallyPin;
        final ParseOperationSet val$operationSet;

        public Task then(Task task)
            throws Exception
        {
            final int type = eventuallyPin.getType();
            ParseObject parseobject = eventuallyPin.getObject();
            task = eventuallyPin.getSessionToken();
            if (type == 1)
            {
                task = parseobject.saveAsync(operationSet, task);
            } else
            if (type == 2)
            {
                task = parseobject.deleteAsync(task);
            } else
            {
                task = eventuallyPin.getCommand().executeAsync();
            }
            return task.continueWithTask(parseobject. new ParsePinningEventuallyQueue._cls13._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                eventuallyPin = eventuallypin;
                operationSet = ParseOperationSet.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$13$1

/* anonymous class */
    class ParsePinningEventuallyQueue._cls13._cls1
        implements Continuation
    {

        final ParsePinningEventuallyQueue._cls13 this$1;
        final ParseObject val$object;
        final int val$type;

        public Task then(final Task saveTask)
            throws Exception
        {
            Exception exception = saveTask.getError();
            if (exception != null && (exception instanceof ParseException) && ((ParseException)exception).getCode() == 100)
            {
                setConnected(false);
                notifyTestHelper(7);
                return ParsePinningEventuallyQueue.access$1300(this$0, eventuallyPin, operationSet);
            } else
            {
                return eventuallyPin.unpinInBackground("_eventuallyPin").continueWithTask(new ParsePinningEventuallyQueue._cls13._cls1._cls2()).continueWithTask(saveTask. new ParsePinningEventuallyQueue._cls13._cls1._cls1());
            }
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$1 = final__pcls13;
                type = i;
                object = ParseObject.this;
                super();
            }

        // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$13$1$2

/* anonymous class */
        class ParsePinningEventuallyQueue._cls13._cls1._cls2
            implements Continuation
        {

            final ParsePinningEventuallyQueue._cls13._cls1 this$2;
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
                        this$2 = ParsePinningEventuallyQueue._cls13._cls1.this;
                        saveTask = task;
                        super();
                    }
        }

    }

}

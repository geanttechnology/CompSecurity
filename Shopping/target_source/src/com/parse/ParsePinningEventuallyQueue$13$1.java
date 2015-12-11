// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseException, ParsePinningEventuallyQueue, EventuallyPin, ParseObject, 
//            ParseRESTCommand, ParseOperationSet

class val.object
    implements i
{

    final then this$1;
    final ParseObject val$object;
    final int val$type;

    public j then(final j executeTask)
        throws Exception
    {
        Exception exception = executeTask.f();
        if (exception != null && (exception instanceof ParseException) && ((ParseException)exception).getCode() == 100)
        {
            setConnected(false);
            notifyTestHelper(7);
            return ParsePinningEventuallyQueue.access$1300(_fld0, eventuallyPin, operationSet);
        } else
        {
            return eventuallyPin.unpinInBackground("_eventuallyPin").b(new i() {

                final ParsePinningEventuallyQueue._cls13._cls1 this$2;
                final j val$executeTask;

                public j then(j j1)
                    throws Exception
                {
                    Object obj = (JSONObject)executeTask.e();
                    if (type == 1)
                    {
                        obj = object.handleSaveEventuallyResultAsync(((JSONObject) (obj)), operationSet);
                    } else
                    {
                        obj = j1;
                        if (type == 2)
                        {
                            obj = j1;
                            if (!executeTask.d())
                            {
                                return object.handleDeleteEventuallyResultAsync();
                            }
                        }
                    }
                    return ((j) (obj));
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$2 = ParsePinningEventuallyQueue._cls13._cls1.this;
                executeTask = j1;
                super();
            }
            }).b(new i() {

                final ParsePinningEventuallyQueue._cls13._cls1 this$2;
                final j val$executeTask;

                public j then(j j1)
                    throws Exception
                {
                    return executeTask;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$2 = ParsePinningEventuallyQueue._cls13._cls1.this;
                executeTask = j1;
                super();
            }
            });
        }
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    l.operationSet()
    {
        this$1 = final_operationset;
        val$type = k;
        val$object = ParseObject.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$13

/* anonymous class */
    class ParsePinningEventuallyQueue._cls13
        implements i
    {

        final ParsePinningEventuallyQueue this$0;
        final EventuallyPin val$eventuallyPin;
        final ParseOperationSet val$operationSet;

        public j then(j j1)
            throws Exception
        {
            final int type = eventuallyPin.getType();
            ParseObject parseobject = eventuallyPin.getObject();
            j1 = eventuallyPin.getSessionToken();
            if (type == 1)
            {
                j1 = parseobject.saveAsync(operationSet, j1);
            } else
            if (type == 2)
            {
                j1 = parseobject.deleteAsync(j1).i();
            } else
            {
                j1 = eventuallyPin.getCommand();
                if (j1 == null)
                {
                    j1 = j.a(null);
                    notifyTestHelper(8);
                } else
                {
                    j1 = j1.executeAsync();
                }
            }
            return j1.b(parseobject. new ParsePinningEventuallyQueue._cls13._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                eventuallyPin = eventuallypin;
                operationSet = ParseOperationSet.this;
                super();
            }
    }

}

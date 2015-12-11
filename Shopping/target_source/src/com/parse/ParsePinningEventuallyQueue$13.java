// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin, ParseObject, ParseRESTCommand, 
//            ParseOperationSet, ParseException

class val.operationSet
    implements i
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;
    final ParseOperationSet val$operationSet;

    public j then(j j1)
        throws Exception
    {
        final int type = val$eventuallyPin.getType();
        final ParseObject object = val$eventuallyPin.getObject();
        j1 = val$eventuallyPin.getSessionToken();
        if (type == 1)
        {
            j1 = object.saveAsync(val$operationSet, j1);
        } else
        if (type == 2)
        {
            j1 = object.deleteAsync(j1).i();
        } else
        {
            j1 = val$eventuallyPin.getCommand();
            if (j1 == null)
            {
                j1 = j.a(null);
                notifyTestHelper(8);
            } else
            {
                j1 = j1.executeAsync();
            }
        }
        return j1.b(new i() {

            final ParsePinningEventuallyQueue._cls13 this$1;
            final ParseObject val$object;
            final int val$type;

            public j then(j j2)
                throws Exception
            {
                Exception exception = j2.f();
                if (exception != null && (exception instanceof ParseException) && ((ParseException)exception).getCode() == 100)
                {
                    setConnected(false);
                    notifyTestHelper(7);
                    return ParsePinningEventuallyQueue.access$1300(this$0, eventuallyPin, operationSet);
                } else
                {
                    return eventuallyPin.unpinInBackground("_eventuallyPin").b(j2. new i() {

                        final _cls1 this$2;
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
                this$2 = final__pcls1;
                executeTask = j.this;
                super();
            }
                    }).b(j2. new i() {

                        final _cls1 this$2;
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
                this$2 = final__pcls1;
                executeTask = j.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls13.this;
                type = k;
                object = parseobject;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.val.object()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$eventuallyPin = eventuallypin;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}

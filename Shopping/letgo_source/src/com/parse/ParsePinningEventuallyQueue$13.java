// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin, ParseObject, ParseRESTCommand, 
//            ParseOperationSet, ParseException

class val.operationSet
    implements ct
{

    final ParsePinningEventuallyQueue this$0;
    final EventuallyPin val$eventuallyPin;
    final ParseOperationSet val$operationSet;

    public cu then(cu cu1)
        throws Exception
    {
        final int type = val$eventuallyPin.getType();
        final ParseObject object = val$eventuallyPin.getObject();
        cu1 = val$eventuallyPin.getSessionToken();
        if (type == 1)
        {
            cu1 = object.saveAsync(val$operationSet, cu1);
        } else
        if (type == 2)
        {
            cu1 = object.deleteAsync(cu1).i();
        } else
        {
            cu1 = val$eventuallyPin.getCommand();
            if (cu1 == null)
            {
                cu1 = cu.a(null);
                notifyTestHelper(8);
            } else
            {
                cu1 = cu1.executeAsync();
            }
        }
        return cu1.b(new ct() {

            final ParsePinningEventuallyQueue._cls13 this$1;
            final ParseObject val$object;
            final int val$type;

            public cu then(cu cu2)
                throws Exception
            {
                Exception exception = cu2.f();
                if (exception != null && (exception instanceof ParseException) && ((ParseException)exception).getCode() == 100)
                {
                    setConnected(false);
                    notifyTestHelper(7);
                    return ParsePinningEventuallyQueue.access$1300(this$0, eventuallyPin, operationSet);
                } else
                {
                    return eventuallyPin.unpinInBackground("_eventuallyPin").b(cu2. new ct() {

                        final _cls1 this$2;
                        final cu val$executeTask;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            Object obj = (JSONObject)executeTask.e();
                            if (type == 1)
                            {
                                obj = object.handleSaveEventuallyResultAsync(((JSONObject) (obj)), operationSet);
                            } else
                            {
                                obj = cu1;
                                if (type == 2)
                                {
                                    obj = cu1;
                                    if (!executeTask.d())
                                    {
                                        return object.handleDeleteEventuallyResultAsync();
                                    }
                                }
                            }
                            return ((cu) (obj));
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$2 = final__pcls1;
                executeTask = cu.this;
                super();
            }
                    }).b(cu2. new ct() {

                        final _cls1 this$2;
                        final cu val$executeTask;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            return executeTask;
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$2 = final__pcls1;
                executeTask = cu.this;
                super();
            }
                    });
                }
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls13.this;
                type = i;
                object = parseobject;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    _cls1.val.object()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$eventuallyPin = eventuallypin;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}

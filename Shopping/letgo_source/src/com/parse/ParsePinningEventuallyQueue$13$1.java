// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseException, ParsePinningEventuallyQueue, EventuallyPin, ParseObject, 
//            ParseRESTCommand, ParseOperationSet

class val.object
    implements ct
{

    final then this$1;
    final ParseObject val$object;
    final int val$type;

    public cu then(final cu executeTask)
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
            return eventuallyPin.unpinInBackground("_eventuallyPin").b(new ct() {

                final ParsePinningEventuallyQueue._cls13._cls1 this$2;
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
                this$2 = ParsePinningEventuallyQueue._cls13._cls1.this;
                executeTask = cu1;
                super();
            }
            }).b(new ct() {

                final ParsePinningEventuallyQueue._cls13._cls1 this$2;
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
                this$2 = ParsePinningEventuallyQueue._cls13._cls1.this;
                executeTask = cu1;
                super();
            }
            });
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    l.operationSet()
    {
        this$1 = final_operationset;
        val$type = i;
        val$object = ParseObject.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$13

/* anonymous class */
    class ParsePinningEventuallyQueue._cls13
        implements ct
    {

        final ParsePinningEventuallyQueue this$0;
        final EventuallyPin val$eventuallyPin;
        final ParseOperationSet val$operationSet;

        public cu then(cu cu1)
            throws Exception
        {
            final int type = eventuallyPin.getType();
            ParseObject parseobject = eventuallyPin.getObject();
            cu1 = eventuallyPin.getSessionToken();
            if (type == 1)
            {
                cu1 = parseobject.saveAsync(operationSet, cu1);
            } else
            if (type == 2)
            {
                cu1 = parseobject.deleteAsync(cu1).i();
            } else
            {
                cu1 = eventuallyPin.getCommand();
                if (cu1 == null)
                {
                    cu1 = cu.a(null);
                    notifyTestHelper(8);
                } else
                {
                    cu1 = cu1.executeAsync();
                }
            }
            return cu1.b(parseobject. new ParsePinningEventuallyQueue._cls13._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                eventuallyPin = eventuallypin;
                operationSet = ParseOperationSet.this;
                super();
            }
    }

}

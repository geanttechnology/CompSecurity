// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseQuery, ParseUser, ParseCommand

class EventuallyPin extends ParseObject
{

    public static final String PIN_NAME = "_eventuallyPin";
    public static final int TYPE_COMMAND = 3;
    public static final int TYPE_DELETE = 2;
    public static final int TYPE_SAVE = 1;

    public EventuallyPin()
    {
        super("_EventuallyPin");
    }

    public static Task findAllPinned()
    {
        return findAllPinned(null);
    }

    public static Task findAllPinned(Collection collection)
    {
        ParseQuery parsequery = (new ParseQuery(com/parse/EventuallyPin)).fromPin("_eventuallyPin", true).orderByAscending("time");
        if (collection != null)
        {
            parsequery.whereNotContainedIn("uuid", collection);
        }
        return parsequery.findInBackground((ParseUser)null).continueWithTask(new Continuation() {

            public Task then(Task task)
                throws Exception
            {
                task = (List)task.getResult();
                ArrayList arraylist = new ArrayList();
                Iterator iterator = task.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    ParseObject parseobject = ((EventuallyPin)iterator.next()).getObject();
                    if (parseobject != null)
                    {
                        arraylist.add(parseobject.fetchFromLocalDatastoreAsync().makeVoid());
                    }
                } while (true);
                return Task.whenAll(arraylist).continueWithTask(task. new Continuation() {

                    final _cls2 this$0;
                    final List val$pins;

                    public Task then(Task task)
                        throws Exception
                    {
                        return Task.forResult(pins);
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$0 = final__pcls2;
                pins = List.this;
                super();
            }
                });
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

        });
    }

    private static Task pinEventuallyCommand(int i, ParseObject parseobject, String s, String s1, JSONObject jsonobject)
    {
        EventuallyPin eventuallypin = new EventuallyPin();
        eventuallypin.put("uuid", UUID.randomUUID().toString());
        eventuallypin.put("time", new Date());
        eventuallypin.put("type", Integer.valueOf(i));
        if (parseobject != null)
        {
            eventuallypin.put("object", parseobject);
        }
        if (s != null)
        {
            eventuallypin.put("operationSetUUID", s);
        }
        if (s1 != null)
        {
            eventuallypin.put("sessionToken", s1);
        }
        if (jsonobject != null)
        {
            eventuallypin.put("command", jsonobject);
        }
        return eventuallypin.pinInBackground("_eventuallyPin").continueWith(new Continuation(eventuallypin) {

            final EventuallyPin val$pin;

            public EventuallyPin then(Task task)
                throws Exception
            {
                return pin;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                pin = eventuallypin;
                super();
            }
        });
    }

    public static Task pinEventuallyCommand(ParseObject parseobject, ParseCommand parsecommand)
    {
        String s = parsecommand.getOp();
        JSONObject jsonobject = null;
        int i;
        if (s.equals("create") || s.equals("update"))
        {
            i = 1;
        } else
        if (s.equals("delete"))
        {
            i = 2;
        } else
        {
            i = 3;
            jsonobject = parsecommand.toJSONObject();
        }
        return pinEventuallyCommand(i, parseobject, parsecommand.getOperationSetUUID(), parsecommand.getSessionToken(), jsonobject);
    }

    public ParseCommand getCommand()
        throws JSONException
    {
        return new ParseCommand(getJSONObject("command"));
    }

    public ParseObject getObject()
    {
        return getParseObject("object");
    }

    public String getOperationSetUUID()
    {
        return getString("operationSetUUID");
    }

    public String getSessionToken()
    {
        return getString("sessionToken");
    }

    public int getType()
    {
        return getInt("type");
    }

    public String getUUID()
    {
        return getString("uuid");
    }
}

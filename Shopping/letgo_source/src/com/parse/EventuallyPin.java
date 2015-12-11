// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseQuery, ParseRESTCommand

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

    public static cu findAllPinned()
    {
        return findAllPinned(null);
    }

    public static cu findAllPinned(Collection collection)
    {
        ParseQuery parsequery = (new ParseQuery(com/parse/EventuallyPin)).fromPin("_eventuallyPin").ignoreACLs().orderByAscending("time");
        if (collection != null)
        {
            parsequery.whereNotContainedIn("uuid", collection);
        }
        return parsequery.findInBackground().b(new ct() {

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (List)cu1.e();
                ArrayList arraylist = new ArrayList();
                Iterator iterator = cu1.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    ParseObject parseobject = ((EventuallyPin)iterator.next()).getObject();
                    if (parseobject != null)
                    {
                        arraylist.add(parseobject.fetchFromLocalDatastoreAsync().j());
                    }
                } while (true);
                return cu.a(arraylist).b(cu1. new ct() {

                    final _cls2 this$0;
                    final List val$pins;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return cu.a(pins);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$0 = final__pcls2;
                pins = List.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        });
    }

    private static cu pinEventuallyCommand(int i, ParseObject parseobject, String s, String s1, JSONObject jsonobject)
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
        return eventuallypin.pinInBackground("_eventuallyPin").a(new ct(eventuallypin) {

            final EventuallyPin val$pin;

            public EventuallyPin then(cu cu1)
                throws Exception
            {
                return pin;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                pin = eventuallypin;
                super();
            }
        });
    }

    public static cu pinEventuallyCommand(ParseObject parseobject, ParseRESTCommand parserestcommand)
    {
        Object obj;
        byte byte0;
        byte0 = 3;
        obj = null;
        if (!parserestcommand.httpPath.startsWith("classes")) goto _L2; else goto _L1
_L1:
        if (parserestcommand.method != ParseRequest.Method.POST && parserestcommand.method != ParseRequest.Method.PUT) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject;
        byte0 = 1;
        jsonobject = obj;
_L6:
        return pinEventuallyCommand(byte0, parseobject, parserestcommand.getOperationSetUUID(), parserestcommand.getSessionToken(), jsonobject);
_L4:
        jsonobject = obj;
        if (parserestcommand.method == ParseRequest.Method.DELETE)
        {
            byte0 = 2;
            jsonobject = obj;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        jsonobject = parserestcommand.toJSONObject();
        if (true) goto _L6; else goto _L5
_L5:
    }

    public ParseRESTCommand getCommand()
        throws JSONException
    {
        JSONObject jsonobject = getJSONObject("command");
        ParseRESTCommand parserestcommand = null;
        if (ParseRESTCommand.isValidCommandJSONObject(jsonobject))
        {
            parserestcommand = ParseRESTCommand.fromJSONObject(jsonobject);
        } else
        if (!ParseRESTCommand.isValidOldFormatCommandJSONObject(jsonobject))
        {
            throw new JSONException("Failed to load command from JSON.");
        }
        return parserestcommand;
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

    boolean needsDefaultACL()
    {
        return false;
    }
}

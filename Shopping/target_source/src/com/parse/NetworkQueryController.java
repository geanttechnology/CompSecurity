// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            AbstractQueryController, PLog, ParseObject, ParseRelation, 
//            ParseUser, ParseRESTQueryCommand, ParseRESTCommand, ParseHttpClient, 
//            ParseKeyValueCache

class NetworkQueryController extends AbstractQueryController
{

    private static final String TAG = "NetworkQueryController";
    private final ParseHttpClient restClient;

    public NetworkQueryController(ParseHttpClient parsehttpclient)
    {
        restClient = parsehttpclient;
    }

    List convertFindResponse(ParseQuery.State state, JSONObject jsonobject)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        JSONArray jsonarray = jsonobject.getJSONArray("results");
        if (jsonarray == null)
        {
            PLog.d("NetworkQueryController", "null results in find response");
        } else
        {
            jsonobject = jsonobject.optString("className", null);
            if (jsonobject == null)
            {
                jsonobject = state.className();
            }
            int i = 0;
            while (i < jsonarray.length()) 
            {
                Object obj = jsonarray.getJSONObject(i);
                ParseQuery.RelationConstraint relationconstraint;
                boolean flag;
                if (state.selectedKeys() == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj = ParseObject.fromJSON(((JSONObject) (obj)), jsonobject, flag);
                arraylist.add(obj);
                relationconstraint = (ParseQuery.RelationConstraint)state.constraints().get("$relatedTo");
                if (relationconstraint != null)
                {
                    relationconstraint.getRelation().addKnownObject(((ParseObject) (obj)));
                }
                i++;
            }
        }
        return arraylist;
    }

    public j countAsync(ParseQuery.State state, ParseUser parseuser, j j1)
    {
        if (parseuser != null)
        {
            parseuser = parseuser.getSessionToken();
        } else
        {
            parseuser = null;
        }
        return countAsync(state, ((String) (parseuser)), true, j1);
    }

    j countAsync(final ParseQuery.State state, final String command, boolean flag, j j1)
    {
        command = ParseRESTQueryCommand.countCommand(state, command);
        if (flag)
        {
            command.enableRetrying();
        }
        return command.executeAsync(restClient, j1).d(new i() {

            final NetworkQueryController this$0;
            final ParseRESTCommand val$command;
            final ParseQuery.State val$state;

            public j then(j j2)
                throws Exception
            {
                ParseQuery.CachePolicy cachepolicy = state.cachePolicy();
                if (cachepolicy != null && cachepolicy != ParseQuery.CachePolicy.IGNORE_CACHE)
                {
                    Object obj = (JSONObject)j2.e();
                    String s = command.getCacheKey();
                    if (!(obj instanceof JSONObject))
                    {
                        obj = ((JSONObject) (obj)).toString();
                    } else
                    {
                        obj = JSONObjectInstrumentation.toString((JSONObject)obj);
                    }
                    ParseKeyValueCache.saveToKeyValueCache(s, ((String) (obj)));
                }
                return j2;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = NetworkQueryController.this;
                state = state1;
                command = parserestcommand;
                super();
            }
        }, j.a).c(new i() {

            final NetworkQueryController this$0;

            public Integer then(j j2)
                throws Exception
            {
                return Integer.valueOf(((JSONObject)j2.e()).optInt("count"));
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = NetworkQueryController.this;
                super();
            }
        });
    }

    public j findAsync(ParseQuery.State state, ParseUser parseuser, j j1)
    {
        if (parseuser != null)
        {
            parseuser = parseuser.getSessionToken();
        } else
        {
            parseuser = null;
        }
        return findAsync(state, ((String) (parseuser)), true, j1);
    }

    j findAsync(final ParseQuery.State state, final String command, boolean flag, j j1)
    {
        final long queryStart = System.nanoTime();
        command = ParseRESTQueryCommand.findCommand(state, command);
        if (flag)
        {
            command.enableRetrying();
        }
        final long querySent = System.nanoTime();
        return command.executeAsync(restClient, j1).c(new i() {

            final NetworkQueryController this$0;
            final ParseRESTCommand val$command;
            final long val$querySent;
            final long val$queryStart;
            final ParseQuery.State val$state;

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            public List then(j j2)
                throws Exception
            {
                JSONObject jsonobject = (JSONObject)j2.e();
                ParseQuery.CachePolicy cachepolicy = state.cachePolicy();
                if (cachepolicy != null && cachepolicy != ParseQuery.CachePolicy.IGNORE_CACHE)
                {
                    String s = command.getCacheKey();
                    Object obj;
                    long l;
                    long l1;
                    if (!(jsonobject instanceof JSONObject))
                    {
                        obj = jsonobject.toString();
                    } else
                    {
                        obj = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
                    }
                    ParseKeyValueCache.saveToKeyValueCache(s, ((String) (obj)));
                }
                l = System.nanoTime();
                j2 = convertFindResponse(state, (JSONObject)j2.e());
                l1 = System.nanoTime();
                if (jsonobject.has("trace"))
                {
                    obj = jsonobject.get("trace");
                    PLog.d("ParseQuery", String.format("Query pre-processing took %f seconds\n%s\nClient side parsing took %f seconds\n", new Object[] {
                        Float.valueOf((float)(querySent - queryStart) / 1000000F), obj, Float.valueOf((float)(l1 - l) / 1000000F)
                    }));
                }
                return j2;
            }

            
            {
                this$0 = NetworkQueryController.this;
                state = state1;
                command = parserestcommand;
                querySent = l;
                queryStart = l1;
                super();
            }
        }, j.a);
    }
}

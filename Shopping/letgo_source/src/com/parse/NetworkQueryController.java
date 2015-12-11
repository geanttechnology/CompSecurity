// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
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

    public cu countAsync(ParseQuery.State state, ParseUser parseuser, cu cu1)
    {
        if (parseuser != null)
        {
            parseuser = parseuser.getSessionToken();
        } else
        {
            parseuser = null;
        }
        return countAsync(state, ((String) (parseuser)), true, cu1);
    }

    cu countAsync(final ParseQuery.State state, final String command, boolean flag, cu cu1)
    {
        command = ParseRESTQueryCommand.countCommand(state, command);
        if (flag)
        {
            command.enableRetrying();
        }
        return command.executeAsync(restClient, cu1).d(new ct() {

            final NetworkQueryController this$0;
            final ParseRESTCommand val$command;
            final ParseQuery.State val$state;

            public cu then(cu cu2)
                throws Exception
            {
                ParseQuery.CachePolicy cachepolicy = state.cachePolicy();
                if (cachepolicy != null && cachepolicy != ParseQuery.CachePolicy.IGNORE_CACHE)
                {
                    Object obj = (JSONObject)cu2.e();
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
                return cu2;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = NetworkQueryController.this;
                state = state1;
                command = parserestcommand;
                super();
            }
        }, cu.a).c(new ct() {

            final NetworkQueryController this$0;

            public Integer then(cu cu2)
                throws Exception
            {
                return Integer.valueOf(((JSONObject)cu2.e()).optInt("count"));
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = NetworkQueryController.this;
                super();
            }
        });
    }

    public cu findAsync(ParseQuery.State state, ParseUser parseuser, cu cu1)
    {
        if (parseuser != null)
        {
            parseuser = parseuser.getSessionToken();
        } else
        {
            parseuser = null;
        }
        return findAsync(state, ((String) (parseuser)), true, cu1);
    }

    cu findAsync(final ParseQuery.State state, final String command, boolean flag, cu cu1)
    {
        final long queryStart = System.nanoTime();
        command = ParseRESTQueryCommand.findCommand(state, command);
        if (flag)
        {
            command.enableRetrying();
        }
        final long querySent = System.nanoTime();
        return command.executeAsync(restClient, cu1).c(new ct() {

            final NetworkQueryController this$0;
            final ParseRESTCommand val$command;
            final long val$querySent;
            final long val$queryStart;
            final ParseQuery.State val$state;

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public List then(cu cu2)
                throws Exception
            {
                JSONObject jsonobject = (JSONObject)cu2.e();
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
                cu2 = convertFindResponse(state, (JSONObject)cu2.e());
                l1 = System.nanoTime();
                if (jsonobject.has("trace"))
                {
                    obj = jsonobject.get("trace");
                    PLog.d("ParseQuery", String.format("Query pre-processing took %f seconds\n%s\nClient side parsing took %f seconds\n", new Object[] {
                        Float.valueOf((float)(querySent - queryStart) / 1000000F), obj, Float.valueOf((float)(l1 - l) / 1000000F)
                    }));
                }
                return cu2;
            }

            
            {
                this$0 = NetworkQueryController.this;
                state = state1;
                command = parserestcommand;
                querySent = l;
                queryStart = l1;
                super();
            }
        }, cu.a);
    }
}

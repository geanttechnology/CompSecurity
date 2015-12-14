// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseException, Parse, ParseCommand, ParseUser, 
//            NoObjectsEncodingStrategy, ParseDecoder, FunctionCallback

public final class ParseCloud
{

    private ParseCloud()
    {
    }

    public static Object callFunction(String s, Map map)
        throws ParseException
    {
        return Parse.waitForTask(callFunctionInBackground(s, map));
    }

    public static Task callFunctionInBackground(String s, Map map)
    {
        return constructCallCommand(s, map).executeAsync().onSuccess(new Continuation() {

            public Object then(Task task)
                throws Exception
            {
                return ParseCloud.convertCloudResponse(task.getResult());
            }

        });
    }

    public static void callFunctionInBackground(String s, Map map, FunctionCallback functioncallback)
    {
        Parse.callbackOnMainThreadAsync(callFunctionInBackground(s, map), functioncallback);
    }

    private static ParseCommand constructCallCommand(String s, Map map)
    {
        ParseCommand parsecommand = new ParseCommand("client_function", ParseUser.getCurrentSessionToken());
        parsecommand.put("data", (JSONObject)Parse.encode(map, NoObjectsEncodingStrategy.get()));
        parsecommand.put("function", s);
        return parsecommand;
    }

    private static Object convertCloudResponse(Object obj)
    {
        Object obj1 = (new ParseDecoder()).decode(obj);
        if (obj1 == null)
        {
            return obj;
        } else
        {
            return obj1;
        }
    }

}

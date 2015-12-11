// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import com.parse.http.ParseHttpResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand, PointerEncoder, ProgressCallback

class ParseRESTUserCommand extends ParseRESTCommand
{

    private static final String HEADER_REVOCABLE_SESSION = "X-Parse-Revocable-Session";
    private static final String HEADER_TRUE = "1";
    private boolean isRevocableSessionEnabled;
    private int statusCode;

    private ParseRESTUserCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1)
    {
        this(s, method, map, s1, false);
    }

    private ParseRESTUserCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1, boolean flag)
    {
        super(s, method, map, s1);
        isRevocableSessionEnabled = flag;
    }

    private ParseRESTUserCommand(String s, com.parse.http.ParseHttpRequest.Method method, JSONObject jsonobject, String s1, boolean flag)
    {
        super(s, method, jsonobject, s1);
        isRevocableSessionEnabled = flag;
    }

    public static ParseRESTUserCommand getCurrentUserCommand(String s)
    {
        return new ParseRESTUserCommand("users/me", com.parse.http.ParseHttpRequest.Method.GET, null, s);
    }

    public static ParseRESTUserCommand logInUserCommand(String s, String s1, boolean flag)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("username", s);
        hashmap.put("password", s1);
        return new ParseRESTUserCommand("login", com.parse.http.ParseHttpRequest.Method.GET, hashmap, null, flag);
    }

    public static ParseRESTUserCommand resetPasswordResetCommand(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("email", s);
        return new ParseRESTUserCommand("requestPasswordReset", com.parse.http.ParseHttpRequest.Method.POST, hashmap, null);
    }

    public static ParseRESTUserCommand serviceLogInUserCommand(String s, Map map, boolean flag)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put(s, PointerEncoder.get().encode(map));
            s = new JSONObject();
            s.put("authData", jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("could not serialize object to JSON");
        }
        return serviceLogInUserCommand(((JSONObject) (s)), ((String) (null)), flag);
    }

    public static ParseRESTUserCommand serviceLogInUserCommand(JSONObject jsonobject, String s, boolean flag)
    {
        return new ParseRESTUserCommand("users", com.parse.http.ParseHttpRequest.Method.POST, jsonobject, s, flag);
    }

    public static ParseRESTUserCommand signUpUserCommand(JSONObject jsonobject, String s, boolean flag)
    {
        return new ParseRESTUserCommand("classes/_User", com.parse.http.ParseHttpRequest.Method.POST, jsonobject, s, flag);
    }

    protected void addAdditionalHeaders(com.parse.http.ParseHttpRequest.Builder builder)
    {
        super.addAdditionalHeaders(builder);
        if (isRevocableSessionEnabled)
        {
            builder.addHeader("X-Parse-Revocable-Session", "1");
        }
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    protected j onResponseAsync(ParseHttpResponse parsehttpresponse, ProgressCallback progresscallback)
    {
        statusCode = parsehttpresponse.getStatusCode();
        return super.onResponseAsync(parsehttpresponse, progresscallback);
    }
}

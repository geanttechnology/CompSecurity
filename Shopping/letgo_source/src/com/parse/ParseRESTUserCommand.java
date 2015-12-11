// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand, PointerEncoder, ParseHttpResponse, ProgressCallback

class ParseRESTUserCommand extends ParseRESTCommand
{

    private static final String HEADER_REVOCABLE_SESSION = "X-Parse-Revocable-Session";
    private static final String HEADER_TRUE = "1";
    private boolean isRevocableSessionEnabled;
    private int statusCode;

    private ParseRESTUserCommand(String s, ParseRequest.Method method, Map map, String s1)
    {
        this(s, method, map, s1, false);
    }

    private ParseRESTUserCommand(String s, ParseRequest.Method method, Map map, String s1, boolean flag)
    {
        super(s, method, map, s1);
        isRevocableSessionEnabled = flag;
    }

    private ParseRESTUserCommand(String s, ParseRequest.Method method, JSONObject jsonobject, String s1)
    {
        this(s, method, jsonobject, s1, false);
    }

    private ParseRESTUserCommand(String s, ParseRequest.Method method, JSONObject jsonobject, String s1, boolean flag)
    {
        super(s, method, jsonobject, s1);
        isRevocableSessionEnabled = flag;
    }

    public static ParseRESTUserCommand getCurrentUserCommand(String s)
    {
        return new ParseRESTUserCommand("users/me", ParseRequest.Method.GET, (Map)null, s);
    }

    public static ParseRESTUserCommand logInUserCommand(String s, String s1, boolean flag)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("username", s);
        hashmap.put("password", s1);
        return new ParseRESTUserCommand("login", ParseRequest.Method.GET, hashmap, null, flag);
    }

    public static ParseRESTUserCommand logOutUserCommand(String s)
    {
        return new ParseRESTUserCommand("logout", ParseRequest.Method.POST, new JSONObject(), s);
    }

    public static ParseRESTUserCommand resetUserPasswordCommand(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("email", s);
        return new ParseRESTUserCommand("requestPasswordReset", ParseRequest.Method.POST, hashmap, null);
    }

    public static ParseRESTUserCommand serviceLogInUserCommand(String s, Map map, boolean flag)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put(s, PointerEncoder.get().encode(map));
        s = new JSONObject();
        s.put("authData", jsonobject);
        return serviceLogInUserCommand(((JSONObject) (s)), ((String) (null)), flag);
    }

    public static ParseRESTUserCommand serviceLogInUserCommand(JSONObject jsonobject, String s, boolean flag)
    {
        return new ParseRESTUserCommand("users", ParseRequest.Method.POST, jsonobject, s, flag);
    }

    public static ParseRESTUserCommand signUpUserCommand(JSONObject jsonobject, String s, boolean flag)
    {
        return new ParseRESTUserCommand("classes/_User", ParseRequest.Method.POST, jsonobject, s, flag);
    }

    public static ParseRESTUserCommand upgradeRevocableSessionCommand(String s)
    {
        return new ParseRESTUserCommand("upgradeToRevocableSession", ParseRequest.Method.POST, new JSONObject(), s);
    }

    protected void addAdditionalHeaders(ParseHttpRequest.Builder builder)
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

    protected cu onResponseAsync(ParseHttpResponse parsehttpresponse, ProgressCallback progresscallback)
    {
        statusCode = parsehttpresponse.getStatusCode();
        return super.onResponseAsync(parsehttpresponse, progresscallback);
    }
}

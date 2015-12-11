// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JwtSigner
{

    static final String ALG = "alg";
    static final int BASE64_URL_SAFE_NO_WRAP_NO_PADDING = 11;
    static final String TYP = "typ";
    static final String UTF_8 = "UTF-8";

    public JwtSigner()
    {
    }

    static String encodeAsBase64(JSONObject jsonobject)
    {
        try
        {
            jsonobject = Base64.encodeToString(jsonobject.toString().getBytes("UTF-8"), 11);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new RuntimeException(jsonobject);
        }
        return jsonobject;
    }

    abstract void addHeaderFields(JSONObject jsonobject)
        throws JSONException;

    abstract byte[] sign(byte abyte0[]);

    public final String signJwt(String s, JSONObject jsonobject)
    {
        JSONObject jsonobject1 = new JSONObject();
        try
        {
            jsonobject1.put("typ", s);
            addHeaderFields(jsonobject1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        s = (new StringBuilder()).append(encodeAsBase64(jsonobject1)).append(".").append(encodeAsBase64(jsonobject)).toString();
        try
        {
            jsonobject = sign(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return (new StringBuilder()).append(s).append(".").append(Base64.encodeToString(jsonobject, 11)).toString();
    }
}

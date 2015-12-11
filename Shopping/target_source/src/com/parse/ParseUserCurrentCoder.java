// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObjectCurrentCoder, ParseDecoder, ParseEncoder, ParseOperationSet

class ParseUserCurrentCoder extends ParseObjectCurrentCoder
{

    private static final ParseUserCurrentCoder INSTANCE = new ParseUserCurrentCoder();
    private static final String KEY_AUTH_DATA = "auth_data";
    private static final String KEY_SESSION_TOKEN = "session_token";

    ParseUserCurrentCoder()
    {
    }

    public static ParseUserCurrentCoder get()
    {
        return INSTANCE;
    }

    public ParseObject.State.Init decode(ParseObject.State.Init init, JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        ParseUser.State.Builder builder = (ParseUser.State.Builder)init;
        Object obj = jsonobject.optString("session_token", null);
        if (obj != null)
        {
            builder.sessionToken(((String) (obj)));
            jsonobject.remove("session_token");
        }
        obj = jsonobject.optJSONObject("auth_data");
        if (obj != null)
        {
            try
            {
                Iterator iterator = ((JSONObject) (obj)).keys();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    if (!((JSONObject) (obj)).isNull(s))
                    {
                        builder.putAuthData(s, (Map)ParseDecoder.get().decode(((JSONObject) (obj)).getJSONObject(s)));
                    }
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (ParseObject.State.Init init)
            {
                throw new RuntimeException(init);
            }
            jsonobject.remove("auth_data");
        }
        return super.decode(init, jsonobject, parsedecoder);
    }

    public JSONObject encode(ParseObject.State state, ParseOperationSet parseoperationset, ParseEncoder parseencoder)
    {
        parseoperationset = super.encode(state, parseoperationset, parseencoder);
        String s = ((ParseUser.State)state).sessionToken();
        if (s != null)
        {
            try
            {
                parseoperationset.put("session_token", s);
            }
            // Misplaced declaration of an exception variable
            catch (ParseObject.State state)
            {
                throw new RuntimeException("could not encode value for key: session_token");
            }
        }
        state = ((ParseUser.State)state).authData();
        if (state.size() > 0)
        {
            try
            {
                parseoperationset.put("auth_data", parseencoder.encode(state));
            }
            // Misplaced declaration of an exception variable
            catch (ParseObject.State state)
            {
                throw new RuntimeException("could not attach key: auth_data");
            }
        }
        return parseoperationset;
    }

}

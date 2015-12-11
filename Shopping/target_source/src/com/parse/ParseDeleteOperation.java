// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperation, ParseEncoder

class ParseDeleteOperation
    implements ParseFieldOperation
{

    private static final ParseDeleteOperation defaultInstance = new ParseDeleteOperation();

    private ParseDeleteOperation()
    {
    }

    public static ParseDeleteOperation getInstance()
    {
        return defaultInstance;
    }

    public Object apply(Object obj, String s)
    {
        return null;
    }

    public volatile Object encode(ParseEncoder parseencoder)
        throws JSONException
    {
        return encode(parseencoder);
    }

    public JSONObject encode(ParseEncoder parseencoder)
        throws JSONException
    {
        parseencoder = new JSONObject();
        parseencoder.put("__op", "Delete");
        return parseencoder;
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parsefieldoperation)
    {
        return this;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperation, ParseObject, ParseObjectEncodingStrategy

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

    public Object apply(Object obj, ParseObject parseobject, String s)
    {
        return null;
    }

    public volatile Object encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        return encode(parseobjectencodingstrategy);
    }

    public JSONObject encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        parseobjectencodingstrategy = new JSONObject();
        parseobjectencodingstrategy.put("__op", "Delete");
        return parseobjectencodingstrategy;
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parsefieldoperation)
    {
        return this;
    }

}

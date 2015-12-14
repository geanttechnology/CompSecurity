// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperation, Parse, ParseDeleteOperation, ParseSetOperation, 
//            ParseObject, ParseObjectEncodingStrategy

class ParseIncrementOperation
    implements ParseFieldOperation
{

    private Number amount;

    public ParseIncrementOperation(Number number)
    {
        amount = number;
    }

    public Object apply(Object obj, ParseObject parseobject, String s)
    {
        if (obj == null)
        {
            return amount;
        }
        if (obj instanceof Number)
        {
            return Parse.addNumbers((Number)obj, amount);
        } else
        {
            throw new IllegalArgumentException("You cannot increment a non-number.");
        }
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
        parseobjectencodingstrategy.put("__op", "Increment");
        parseobjectencodingstrategy.put("amount", amount);
        return parseobjectencodingstrategy;
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parsefieldoperation)
    {
        if (parsefieldoperation == null)
        {
            return this;
        }
        if (parsefieldoperation instanceof ParseDeleteOperation)
        {
            return new ParseSetOperation(amount);
        }
        if (parsefieldoperation instanceof ParseSetOperation)
        {
            parsefieldoperation = ((ParseFieldOperation) (((ParseSetOperation)parsefieldoperation).getValue()));
            if (parsefieldoperation instanceof Number)
            {
                return new ParseSetOperation(Parse.addNumbers((Number)parsefieldoperation, amount));
            } else
            {
                throw new IllegalArgumentException("You cannot increment a non-number.");
            }
        }
        if (parsefieldoperation instanceof ParseIncrementOperation)
        {
            return new ParseIncrementOperation(Parse.addNumbers(((ParseIncrementOperation)parsefieldoperation).amount, amount));
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}

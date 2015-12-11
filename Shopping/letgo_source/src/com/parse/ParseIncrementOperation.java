// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperation, Numbers, ParseDeleteOperation, ParseSetOperation, 
//            ParseEncoder

class ParseIncrementOperation
    implements ParseFieldOperation
{

    private Number amount;

    public ParseIncrementOperation(Number number)
    {
        amount = number;
    }

    public Object apply(Object obj, String s)
    {
        if (obj == null)
        {
            return amount;
        }
        if (obj instanceof Number)
        {
            return Numbers.add((Number)obj, amount);
        } else
        {
            throw new IllegalArgumentException("You cannot increment a non-number.");
        }
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
        parseencoder.put("__op", "Increment");
        parseencoder.put("amount", amount);
        return parseencoder;
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
                return new ParseSetOperation(Numbers.add((Number)parsefieldoperation, amount));
            } else
            {
                throw new IllegalArgumentException("You cannot increment a non-number.");
            }
        }
        if (parsefieldoperation instanceof ParseIncrementOperation)
        {
            return new ParseIncrementOperation(Numbers.add(((ParseIncrementOperation)parsefieldoperation).amount, amount));
        } else
        {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}

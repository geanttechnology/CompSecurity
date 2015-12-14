// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseFieldOperation, Parse, ParseObject, ParseObjectEncodingStrategy

class ParseSetOperation
    implements ParseFieldOperation
{

    private Object value;

    public ParseSetOperation(Object obj)
    {
        value = obj;
    }

    public Object apply(Object obj, ParseObject parseobject, String s)
    {
        return value;
    }

    public Object encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        return Parse.encode(value, parseobjectencodingstrategy);
    }

    public Object getValue()
    {
        return value;
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation parsefieldoperation)
    {
        return this;
    }
}

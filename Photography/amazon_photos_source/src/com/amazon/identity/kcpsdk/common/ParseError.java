// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;


public final class ParseError extends Enum
{

    private static final ParseError $VALUES[];
    public static final ParseError ParseErrorHttpError;
    public static final ParseError ParseErrorIllegalOperation;
    public static final ParseError ParseErrorInvalidParameters;
    public static final ParseError ParseErrorMalformedBody;
    public static final ParseError ParseErrorNoError;

    private ParseError(String s, int i)
    {
        super(s, i);
    }

    public static ParseError valueOf(String s)
    {
        return (ParseError)Enum.valueOf(com/amazon/identity/kcpsdk/common/ParseError, s);
    }

    public static ParseError[] values()
    {
        return (ParseError[])$VALUES.clone();
    }

    static 
    {
        ParseErrorNoError = new ParseError("ParseErrorNoError", 0);
        ParseErrorInvalidParameters = new ParseError("ParseErrorInvalidParameters", 1);
        ParseErrorHttpError = new ParseError("ParseErrorHttpError", 2);
        ParseErrorMalformedBody = new ParseError("ParseErrorMalformedBody", 3);
        ParseErrorIllegalOperation = new ParseError("ParseErrorIllegalOperation", 4);
        $VALUES = (new ParseError[] {
            ParseErrorNoError, ParseErrorInvalidParameters, ParseErrorHttpError, ParseErrorMalformedBody, ParseErrorIllegalOperation
        });
    }
}

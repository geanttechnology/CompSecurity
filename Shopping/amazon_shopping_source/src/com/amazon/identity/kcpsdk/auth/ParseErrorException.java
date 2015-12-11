// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.ParseError;

public class ParseErrorException extends Exception
{

    final ParseError mError;

    public ParseErrorException(ParseError parseerror)
    {
        mError = parseerror;
    }

    public ParseError getError()
    {
        return mError;
    }
}

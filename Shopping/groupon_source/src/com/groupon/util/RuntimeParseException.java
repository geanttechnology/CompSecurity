// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.ParseException;

public class RuntimeParseException extends RuntimeException
{

    public RuntimeParseException(ParseException parseexception)
    {
        super(parseexception);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.xml;


public class ParserException extends Exception
{

    public ParserException(Exception exception)
    {
        super(exception);
    }

    public ParserException(String s)
    {
        super(s);
    }
}

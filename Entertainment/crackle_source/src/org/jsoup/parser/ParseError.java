// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


public class ParseError
{

    private String errorMsg;
    private int pos;

    ParseError(int i, String s)
    {
        pos = i;
        errorMsg = s;
    }

    transient ParseError(int i, String s, Object aobj[])
    {
        errorMsg = String.format(s, aobj);
        pos = i;
    }

    public String getErrorMessage()
    {
        return errorMsg;
    }

    public int getPosition()
    {
        return pos;
    }

    public String toString()
    {
        return (new StringBuilder()).append(pos).append(": ").append(errorMsg).toString();
    }
}

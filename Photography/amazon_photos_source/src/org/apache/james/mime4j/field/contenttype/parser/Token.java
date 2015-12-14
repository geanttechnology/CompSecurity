// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field.contenttype.parser;


public class Token
{

    public int beginColumn;
    public int beginLine;
    public int endColumn;
    public int endLine;
    public String image;
    public int kind;
    public Token next;
    public Token specialToken;

    public Token()
    {
    }

    public static final Token newToken(int i)
    {
        return new Token();
    }

    public String toString()
    {
        return image;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            Token

static class e.Comment extends Token
{

    final StringBuilder data = new StringBuilder();

    String getData()
    {
        return data.toString();
    }

    public String toString()
    {
        return (new StringBuilder()).append("<!--").append(getData()).append("-->").toString();
    }

    e()
    {
        super(null);
        type = e.Comment;
    }
}

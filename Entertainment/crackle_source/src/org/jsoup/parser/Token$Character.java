// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            Token

static class data extends Token
{

    private final String data;

    String getData()
    {
        return data;
    }

    public String toString()
    {
        return getData();
    }

    (String s)
    {
        super(null);
        type = Character;
        data = s;
    }
}

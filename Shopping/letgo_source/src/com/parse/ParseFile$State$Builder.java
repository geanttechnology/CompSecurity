// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseFile

static class url
{

    private String mimeType;
    private String name;
    private String url;

    public url build()
    {
        return new url(this, null);
    }

    public url mimeType(String s)
    {
        mimeType = s;
        return this;
    }

    public mimeType name(String s)
    {
        name = s;
        return this;
    }

    public name url(String s)
    {
        url = s;
        return this;
    }




    public ()
    {
    }

    public ( )
    {
        name = .name();
        mimeType = .();
        url = .url();
    }
}

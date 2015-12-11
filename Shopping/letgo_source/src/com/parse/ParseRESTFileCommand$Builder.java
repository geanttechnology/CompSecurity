// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseRESTFileCommand

public static class method extends method
{

    private String contentType;
    private byte data[];

    public ParseRESTFileCommand build()
    {
        return new ParseRESTFileCommand(this);
    }

    public method contentType(String s)
    {
        contentType = s;
        return this;
    }

    public contentType data(byte abyte0[])
    {
        data = abyte0;
        return this;
    }

    public data fileName(String s)
    {
        return (data)httpPath(String.format("files/%s", new Object[] {
            s
        }));
    }

    volatile httpPath self()
    {
        return self();
    }

    self self()
    {
        return this;
    }



    public ()
    {
        data = null;
        contentType = null;
        method(method);
    }
}

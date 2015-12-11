// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;

// Referenced classes of package com.parse:
//            ParseRESTFileCommand

public static class POST extends POST
{

    private String contentType;
    private byte data[];
    private File file;

    public ParseRESTFileCommand build()
    {
        return new ParseRESTFileCommand(this);
    }

    public POST contentType(String s)
    {
        contentType = s;
        return this;
    }

    public contentType data(byte abyte0[])
    {
        data = abyte0;
        return this;
    }

    public data file(File file1)
    {
        file = file1;
        return this;
    }

    public file fileName(String s)
    {
        return (file)httpPath(String.format("files/%s", new Object[] {
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
        method(com.parse.http.d);
    }
}

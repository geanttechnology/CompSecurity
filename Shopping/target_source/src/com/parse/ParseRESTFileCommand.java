// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.http.ParseHttpBody;
import java.io.File;

// Referenced classes of package com.parse:
//            ParseRESTCommand, ParseByteArrayHttpBody, ParseFileHttpBody, ParseCountingByteArrayHttpBody, 
//            ParseCountingFileHttpBody, ProgressCallback

class ParseRESTFileCommand extends ParseRESTCommand
{
    public static class Builder extends ParseRESTCommand.Init
    {

        private String contentType;
        private byte data[];
        private File file;

        public ParseRESTFileCommand build()
        {
            return new ParseRESTFileCommand(this);
        }

        public Builder contentType(String s)
        {
            contentType = s;
            return this;
        }

        public Builder data(byte abyte0[])
        {
            data = abyte0;
            return this;
        }

        public Builder file(File file1)
        {
            file = file1;
            return this;
        }

        public Builder fileName(String s)
        {
            return (Builder)httpPath(String.format("files/%s", new Object[] {
                s
            }));
        }

        volatile ParseRESTCommand.Init self()
        {
            return self();
        }

        Builder self()
        {
            return this;
        }




        public Builder()
        {
            data = null;
            contentType = null;
            method(com.parse.http.ParseHttpRequest.Method.POST);
        }
    }


    private final String contentType;
    private final byte data[];
    private final File file;

    public ParseRESTFileCommand(Builder builder)
    {
        super(builder);
        if (builder.file != null && builder.data != null)
        {
            throw new IllegalArgumentException("File and data can not be set at the same time");
        } else
        {
            data = builder.data;
            contentType = builder.contentType;
            file = builder.file;
            return;
        }
    }

    protected ParseHttpBody newBody(ProgressCallback progresscallback)
    {
        if (progresscallback == null)
        {
            if (data != null)
            {
                return new ParseByteArrayHttpBody(data, contentType);
            } else
            {
                return new ParseFileHttpBody(file, contentType);
            }
        }
        if (data != null)
        {
            return new ParseCountingByteArrayHttpBody(data, contentType, progresscallback);
        } else
        {
            return new ParseCountingFileHttpBody(file, contentType, progresscallback);
        }
    }
}

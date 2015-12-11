// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseRESTCommand, ParseByteArrayHttpBody, ParseCountingByteArrayHttpBody, ProgressCallback, 
//            ParseHttpBody

class ParseRESTFileCommand extends ParseRESTCommand
{
    public static class Builder extends ParseRESTCommand.Init
    {

        private String contentType;
        private byte data[];

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
            method(ParseRequest.Method.POST);
        }
    }


    private final String contentType;
    private final byte data[];

    public ParseRESTFileCommand(Builder builder)
    {
        super(builder);
        data = builder.data;
        contentType = builder.contentType;
    }

    protected ParseHttpBody newBody(ProgressCallback progresscallback)
    {
        if (progresscallback == null)
        {
            return new ParseByteArrayHttpBody(data, contentType);
        } else
        {
            return new ParseCountingByteArrayHttpBody(data, contentType, progresscallback);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseFile

static class Builder
{
    static class Builder
    {

        private String mimeType;
        private String name;
        private String url;

        public ParseFile.State build()
        {
            return new ParseFile.State(this, null);
        }

        public Builder mimeType(String s)
        {
            mimeType = s;
            return this;
        }

        public Builder name(String s)
        {
            name = s;
            return this;
        }

        public Builder url(String s)
        {
            url = s;
            return this;
        }




        public Builder()
        {
        }

        public Builder(ParseFile.State state)
        {
            name = state.name();
            mimeType = state.mimeType();
            url = state.url();
        }
    }


    private final String contentType;
    private final String name;
    private final String url;

    public String mimeType()
    {
        return contentType;
    }

    public String name()
    {
        return name;
    }

    public String url()
    {
        return url;
    }

    private Builder(Builder builder)
    {
        String s;
        if (builder.name != null)
        {
            s = builder.name;
        } else
        {
            s = "file";
        }
        name = s;
        contentType = builder.mimeType;
        url = builder.url;
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }
}

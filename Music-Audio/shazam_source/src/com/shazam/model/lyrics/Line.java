// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.lyrics;

import java.io.Serializable;

public class Line
    implements Serializable
{
    public static class Builder
    {

        public float lenght;
        public float offset;
        public String text;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.text;
        }

        static float b(Builder builder)
        {
            return builder.lenght;
        }

        static float c(Builder builder)
        {
            return builder.offset;
        }

        public Builder()
        {
        }
    }


    public float lenght;
    public float offset;
    public String text;

    private Line()
    {
    }

    private Line(Builder builder)
    {
        text = Builder.a(builder);
        lenght = Builder.b(builder);
        offset = Builder.c(builder);
    }

}

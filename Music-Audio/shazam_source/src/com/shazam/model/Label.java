// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;


public class Label
{
    public static class Builder
    {

        public String id;
        public String name;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.id;
        }

        static String b(Builder builder)
        {
            return builder.name;
        }

        public final Label b()
        {
            return new Label(this, null);
        }

        private Builder()
        {
        }
    }


    public final String id;
    public final String name;

    private Label(Builder builder)
    {
        id = Builder.a(builder);
        name = Builder.b(builder);
    }

    Label(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}

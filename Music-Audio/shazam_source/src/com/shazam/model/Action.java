// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;


// Referenced classes of package com.shazam.model:
//            ActionType

public class Action
{
    public static class Builder
    {

        public String artist;
        public String coverArt;
        public String href;
        public String id;
        public String key;
        public boolean panel;
        public String trackTitle;
        public ActionType type;
        public String uri;

        public static Builder a()
        {
            return new Builder();
        }

        static ActionType a(Builder builder)
        {
            return builder.type;
        }

        static String b(Builder builder)
        {
            return builder.id;
        }

        static String c(Builder builder)
        {
            return builder.uri;
        }

        static boolean d(Builder builder)
        {
            return builder.panel;
        }

        static String e(Builder builder)
        {
            return builder.href;
        }

        static String f(Builder builder)
        {
            return builder.key;
        }

        static String g(Builder builder)
        {
            return builder.artist;
        }

        static String h(Builder builder)
        {
            return builder.trackTitle;
        }

        static String i(Builder builder)
        {
            return builder.coverArt;
        }

        public final Action b()
        {
            return new Action(this, null);
        }

        public Builder()
        {
        }
    }


    public String artist;
    public String coverArt;
    public String href;
    public String id;
    public String key;
    public boolean panel;
    public String trackTitle;
    public ActionType type;
    public String uri;

    private Action()
    {
    }

    private Action(Builder builder)
    {
        type = Builder.a(builder);
        id = Builder.b(builder);
        uri = Builder.c(builder);
        panel = Builder.d(builder);
        href = Builder.e(builder);
        key = Builder.f(builder);
        artist = Builder.g(builder);
        trackTitle = Builder.h(builder);
        coverArt = Builder.i(builder);
    }

    Action(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}

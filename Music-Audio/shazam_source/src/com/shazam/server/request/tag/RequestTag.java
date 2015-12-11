// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.tag;


// Referenced classes of package com.shazam.server.request.tag:
//            Coordinates, TagMatch

public class RequestTag
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type AUDIO;
        public static final Type BEAM;
        public static final Type CONTEXT;
        public static final Type FBDEEPLINK;
        public static final Type PLAYER;
        public static final Type SEARCH;
        public static final Type SHARE;
        public static final Type WEB;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/shazam/server/request/tag/RequestTag$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            AUDIO = new Type("AUDIO", 0);
            SEARCH = new Type("SEARCH", 1);
            SHARE = new Type("SHARE", 2);
            BEAM = new Type("BEAM", 3);
            WEB = new Type("WEB", 4);
            FBDEEPLINK = new Type("FBDEEPLINK", 5);
            CONTEXT = new Type("CONTEXT", 6);
            PLAYER = new Type("PLAYER", 7);
            $VALUES = (new Type[] {
                AUDIO, SEARCH, SHARE, BEAM, WEB, FBDEEPLINK, CONTEXT, PLAYER
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public final Client client;
    public final Coordinates geolocation;
    public final TagMatch match[];
    public final Source source;
    public final Status status;
    public final long timestamp;
    public final String timezone;
    public final Type type;

    private RequestTag(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        timestamp = Builder.access._mth000(builder);
        status = Builder.access._mth100(builder);
        type = Builder.access._mth200(builder);
        client = Builder.access._mth300(builder);
        source = Builder.access._mth400(builder);
        timezone = Builder.access._mth500(builder);
        match = Builder.access._mth600(builder);
        geolocation = Builder.access._mth700(builder);
    }

    RequestTag(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    // Unreferenced inner class com/shazam/server/request/tag/RequestTag$Client
    /* block-local class not found */
    class Client {}


    // Unreferenced inner class com/shazam/server/request/tag/RequestTag$Source
    /* block-local class not found */
    class Source {}


    // Unreferenced inner class com/shazam/server/request/tag/RequestTag$Status
    /* block-local class not found */
    class Status {}

}

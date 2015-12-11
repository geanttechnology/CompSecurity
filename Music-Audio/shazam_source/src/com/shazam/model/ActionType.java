// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

public final class ActionType extends Enum
{
    public static class Deserializer
        implements k
    {

        public Object deserialize(l l1, Type type, j j)
        {
            return ActionType.fromString(l1.h().b());
        }

        public Deserializer()
        {
        }
    }

    public static class Serializer
        implements t
    {

        public l serialize(Object obj, Type type, s s)
        {
            return new r(((ActionType)obj).jsonValue);
        }

        public Serializer()
        {
        }
    }


    private static final ActionType $VALUES[];
    public static final ActionType ARTIST;
    public static final ActionType CAST;
    public static final ActionType DESERIALIZATION_FAILURE;
    public static final ActionType DETAILS;
    public static final ActionType DISCOGRAPHY;
    public static final ActionType INTENT;
    public static final ActionType RDIO_CONNECT;
    public static final ActionType RDIO_PLAY;
    public static final ActionType SPOTIFY_PLAY;
    public static final ActionType TRACK;
    public static final ActionType URI;
    public static final ActionType VIDEO;
    public static final ActionType WEBVIEW;
    public static final ActionType YOUTUBE_PLAY;
    private final String jsonValue;

    private ActionType(String s, int i, String s1)
    {
        super(s, i);
        jsonValue = s1;
    }

    public static ActionType fromString(String s)
    {
        ActionType aactiontype[] = values();
        int j = aactiontype.length;
        for (int i = 0; i < j; i++)
        {
            ActionType actiontype = aactiontype[i];
            if (actiontype.jsonValue.equals(s))
            {
                return actiontype;
            }
        }

        return DESERIALIZATION_FAILURE;
    }

    public static ActionType valueOf(String s)
    {
        return (ActionType)Enum.valueOf(com/shazam/model/ActionType, s);
    }

    public static ActionType[] values()
    {
        return (ActionType[])$VALUES.clone();
    }

    public final String getJsonValue()
    {
        return jsonValue;
    }

    static 
    {
        TRACK = new ActionType("TRACK", 0, "track");
        WEBVIEW = new ActionType("WEBVIEW", 1, "webview");
        URI = new ActionType("URI", 2, "uri");
        DISCOGRAPHY = new ActionType("DISCOGRAPHY", 3, "discography");
        DETAILS = new ActionType("DETAILS", 4, "details");
        INTENT = new ActionType("INTENT", 5, "intent");
        DESERIALIZATION_FAILURE = new ActionType("DESERIALIZATION_FAILURE", 6, "unknown action");
        VIDEO = new ActionType("VIDEO", 7, "video");
        RDIO_PLAY = new ActionType("RDIO_PLAY", 8, "rdioplay");
        RDIO_CONNECT = new ActionType("RDIO_CONNECT", 9, "rdioconnect");
        CAST = new ActionType("CAST", 10, "cast");
        YOUTUBE_PLAY = new ActionType("YOUTUBE_PLAY", 11, "youtubeplay");
        SPOTIFY_PLAY = new ActionType("SPOTIFY_PLAY", 12, "spotifyplay");
        ARTIST = new ActionType("ARTIST", 13, "artist");
        $VALUES = (new ActionType[] {
            TRACK, WEBVIEW, URI, DISCOGRAPHY, DETAILS, INTENT, DESERIALIZATION_FAILURE, VIDEO, RDIO_PLAY, RDIO_CONNECT, 
            CAST, YOUTUBE_PLAY, SPOTIFY_PLAY, ARTIST
        });
    }

}

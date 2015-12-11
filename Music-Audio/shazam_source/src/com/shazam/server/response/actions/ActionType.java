// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.actions;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import java.io.Serializable;
import java.lang.reflect.Type;

public final class ActionType extends Enum
    implements Serializable
{
    public static class Deserializer
        implements k
    {

        public ActionType deserialize(l l1, Type type, j j)
        {
            return ActionType.fromString(l1.h().b());
        }

        public volatile Object deserialize(l l1, Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public Deserializer()
        {
        }
    }

    public static class Serializer
        implements t
    {

        public l serialize(ActionType actiontype, Type type, s s)
        {
            return new r(actiontype.jsonValue);
        }

        public volatile l serialize(Object obj, Type type, s s)
        {
            return serialize((ActionType)obj, type, s);
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
        return (ActionType)Enum.valueOf(com/shazam/server/response/actions/ActionType, s);
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
        ARTIST = new ActionType("ARTIST", 6, "artist");
        DESERIALIZATION_FAILURE = new ActionType("DESERIALIZATION_FAILURE", 7, "unknown action");
        VIDEO = new ActionType("VIDEO", 8, "video");
        RDIO_PLAY = new ActionType("RDIO_PLAY", 9, "rdioplay");
        RDIO_CONNECT = new ActionType("RDIO_CONNECT", 10, "rdioconnect");
        CAST = new ActionType("CAST", 11, "cast");
        YOUTUBE_PLAY = new ActionType("YOUTUBE_PLAY", 12, "youtubeplay");
        SPOTIFY_PLAY = new ActionType("SPOTIFY_PLAY", 13, "spotifyplay");
        $VALUES = (new ActionType[] {
            TRACK, WEBVIEW, URI, DISCOGRAPHY, DETAILS, INTENT, ARTIST, DESERIALIZATION_FAILURE, VIDEO, RDIO_PLAY, 
            RDIO_CONNECT, CAST, YOUTUBE_PLAY, SPOTIFY_PLAY
        });
    }

}

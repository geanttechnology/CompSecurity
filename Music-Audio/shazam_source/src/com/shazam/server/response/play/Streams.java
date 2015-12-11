// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.play;


// Referenced classes of package com.shazam.server.response.play:
//            Stream

public class Streams
{

    public static final Streams EMPTY = new Streams(((Stream) (null)), ((Stream) (null)));
    public final Stream rdioStream;
    public final Stream spotifyStream;

    private Streams(Stream stream, Stream stream1)
    {
        rdioStream = stream;
        spotifyStream = stream1;
    }

    private Streams(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        rdioStream = Builder.access._mth000(builder);
        spotifyStream = Builder.access._mth100(builder);
    }

    Streams(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

}

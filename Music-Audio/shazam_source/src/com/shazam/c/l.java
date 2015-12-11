// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import com.shazam.b.a.a;
import com.shazam.model.ActionType;
import com.shazam.model.news.TrackInfoCard;
import com.shazam.server.response.actions.Action;

public final class l
    implements a
{

    private final TrackInfoCard a;

    public l()
    {
        this(com.shazam.model.news.TrackInfoCard.Builder.a().b());
    }

    public l(TrackInfoCard trackinfocard)
    {
        a = trackinfocard;
    }

    public final Object a(Object obj)
    {
        Action action = (Action)obj;
        com.shazam.model.Action.Builder builder = com.shazam.model.Action.Builder.a();
        obj = action.type;
        if (obj == null)
        {
            obj = ActionType.DESERIALIZATION_FAILURE;
        } else
        {
            obj = ActionType.fromString(((com.shazam.server.response.actions.ActionType) (obj)).getJsonValue());
        }
        builder.type = ((ActionType) (obj));
        builder.id = action.id;
        builder.key = action.key;
        builder.uri = action.uri;
        builder.href = action.href;
        builder.panel = action.panel;
        builder.coverArt = a.coverArtUrl;
        builder.artist = a.trackArtist;
        builder.trackTitle = a.trackTitle;
        return builder.b();
    }
}

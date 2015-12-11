// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.q;
import com.shazam.android.an.r;
import com.shazam.b.e.a;
import com.shazam.model.Track;
import com.shazam.o.b;
import com.shazam.server.response.actions.Action;
import com.shazam.server.response.actions.ActionType;
import com.shazam.server.response.play.Stream;
import com.shazam.server.response.play.Streams;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class w
    implements q
{

    public w()
    {
    }

    public final void a(r r1, Track track)
    {
        track = track.c().spotifyStream;
        if (track == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        track = ((Stream) (track)).actions;
        if (b.a(track))
        {
            break MISSING_BLOCK_LABEL_79;
        }
        track = track.iterator();
        Action action;
        do
        {
            if (!track.hasNext())
            {
                break MISSING_BLOCK_LABEL_79;
            }
            action = (Action)track.next();
        } while (action.type != ActionType.SPOTIFY_PLAY);
        track = action.uri;
_L1:
        if (com.shazam.b.e.a.a(track))
        {
            r1.c();
            return;
        } else
        {
            r1.a(Collections.singletonList(track));
            return;
        }
        track = null;
          goto _L1
    }
}

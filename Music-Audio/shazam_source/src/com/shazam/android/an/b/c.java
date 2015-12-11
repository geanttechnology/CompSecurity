// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.a.g;
import com.shazam.android.an.a;
import com.shazam.android.an.r;
import com.shazam.g.e;
import com.shazam.g.f;
import com.shazam.model.configuration.StreamingTrackMappingsUrlConfiguration;
import com.shazam.model.myshazam.MyShazamTag;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.o.b;
import com.shazam.server.response.actions.Action;
import com.shazam.server.response.actions.ActionType;
import com.shazam.server.response.play.Stream;
import com.shazam.server.response.play.Streams;
import com.shazam.server.response.streaming.StreamingProviderTrackMapping;
import com.shazam.server.response.streaming.StreamingProviderTrackMappings;
import com.shazam.server.response.streaming.spotify.SpotifyTrackMapping;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.shazam.android.an.b:
//            x

public final class c
    implements a, f
{

    private final e a;
    private final x b;
    private r c;
    private Set d;

    public c(e e1, x x1)
    {
        a = e1;
        b = x1;
    }

    public final void a(r r1, Set set)
    {
        c = r1;
        d = set;
        a.a(this);
        a.a();
    }

    public final void onDataFailedToLoad()
    {
        c.c();
    }

    public final void onDataFetched(Object obj)
    {
        r r1;
        x x1;
        Set set;
        Iterator iterator;
        obj = (List)obj;
        x1 = b;
        r1 = c;
        set = d;
        iterator = ((List) (obj)).iterator();
_L8:
        MyShazamTag myshazamtag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_177;
        }
        myshazamtag = (MyShazamTag)iterator.next();
        obj = myshazamtag.previewViewData.playlistItem;
        if (obj == null || ((PlaylistItem) (obj)).streams == null) goto _L2; else goto _L1
_L1:
        obj = ((PlaylistItem) (obj)).streams.spotifyStream;
        if (obj == null) goto _L2; else goto _L3
_L3:
        obj = ((Stream) (obj)).actions;
        if (com.shazam.o.b.a(((java.util.Collection) (obj)))) goto _L2; else goto _L4
_L4:
        obj = ((List) (obj)).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L5
_L5:
        Action action = (Action)((Iterator) (obj)).next();
        if (action.type != ActionType.SPOTIFY_PLAY) goto _L7; else goto _L6
_L6:
        obj = action.uri;
_L9:
        if (com.shazam.b.e.a.a(((String) (obj))))
        {
            x1.d.add(myshazamtag.trackId);
        } else
        {
            x1.a(((String) (obj)), set);
        }
        if (true) goto _L8; else goto _L2
_L2:
        obj = null;
          goto _L9
        if (x1.d.isEmpty())
        {
            break MISSING_BLOCK_LABEL_323;
        }
        obj = com.shazam.b.e.a.a(x1.d);
        obj = x1.a.a(x1.b.a(), ((String) (obj)));
        if (((StreamingProviderTrackMappings) (obj)).streamingProviderTrackMappings != null) goto _L11; else goto _L10
_L10:
        obj = Collections.emptyList();
_L17:
        iterator = ((List) (obj)).iterator();
_L16:
        if (!iterator.hasNext()) goto _L13; else goto _L12
_L12:
        obj = (StreamingProviderTrackMapping)iterator.next();
        if (((StreamingProviderTrackMapping) (obj)).spotifyTrackMapping != null) goto _L15; else goto _L14
_L14:
        obj = SpotifyTrackMapping.EMPTY;
_L18:
        obj = ((SpotifyTrackMapping) (obj)).uri;
        if (com.shazam.b.e.a.c(((String) (obj))))
        {
            x1.a(((String) (obj)), set);
        }
          goto _L16
_L11:
        try
        {
            obj = ((StreamingProviderTrackMappings) (obj)).streamingProviderTrackMappings;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            r1.c();
            return;
        }
          goto _L17
_L15:
        obj = ((StreamingProviderTrackMapping) (obj)).spotifyTrackMapping;
          goto _L18
_L13:
        r1.a(x1.c);
        return;
        r1.a(x1.c);
        return;
          goto _L16
    }
}

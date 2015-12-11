// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.a.g;
import com.shazam.android.an.q;
import com.shazam.android.an.r;
import com.shazam.model.AddOn;
import com.shazam.model.Track;
import com.shazam.model.configuration.StreamingTrackMappingsUrlConfiguration;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.an.a:
//            b

public final class l
    implements q
{

    private b a;
    private final g b;
    private final StreamingTrackMappingsUrlConfiguration c;

    public l(g g, StreamingTrackMappingsUrlConfiguration streamingtrackmappingsurlconfiguration)
    {
        b = g;
        c = streamingtrackmappingsurlconfiguration;
    }

    public final void a(r r1, Track track)
    {
        for (Iterator iterator = track.addOns.iterator(); iterator.hasNext();)
        {
            AddOn addon = (AddOn)iterator.next();
            if (addon.providerName.equals("RdioListen"))
            {
                r1.a(Collections.singletonList(addon.id));
                return;
            }
        }

        if (a != null && a.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            a.cancel(true);
        }
        a = new b(r1, b, c.a());
        a.execute(new String[] {
            track.id
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.tag;

import com.shazam.b.e.a;
import com.shazam.model.AddOn;
import com.shazam.model.Track;
import com.shazam.model.gimbal.AlternativeTrack;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.model.tag:
//            AddOnFinder

public class AlternativeTrackAddOnFinder
    implements AddOnFinder
{

    public AlternativeTrackAddOnFinder()
    {
    }

    public final AlternativeTrack a(Track track)
    {
        if (track == null) goto _L2; else goto _L1
_L1:
        if (track == null) goto _L4; else goto _L3
_L3:
        Iterator iterator = track.addOns.iterator();
_L7:
        if (!iterator.hasNext()) goto _L4; else goto _L5
_L5:
        track = (AddOn)iterator.next();
        if (!"AlternativeResult".equals(((AddOn) (track)).providerName) || !com.shazam.b.e.a.a(((AddOn) (track)).moduleOrder)) goto _L7; else goto _L6
_L6:
        if (track != null)
        {
            AlternativeTrack alternativetrack = ((AddOn) (track)).alternativeTrack;
            if (alternativetrack != null && com.shazam.b.e.a.c(alternativetrack.title))
            {
                return ((AddOn) (track)).alternativeTrack;
            }
        }
        break; /* Loop/switch isn't completed */
_L4:
        track = null;
        if (true) goto _L6; else goto _L2
_L2:
        return null;
    }
}

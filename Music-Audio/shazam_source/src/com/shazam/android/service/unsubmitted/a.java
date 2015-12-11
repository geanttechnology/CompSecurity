// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.unsubmitted;

import com.shazam.android.analytics.TaggedBeacon;
import com.shazam.android.analytics.TaggingOutcome;
import com.shazam.android.analytics.TaggingStatus;
import com.shazam.android.p.e;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.TrackCategory;

// Referenced classes of package com.shazam.android.service.unsubmitted:
//            j

public final class a
    implements j
{

    private final TaggingStatus a;
    private final e b;

    public a(TaggingStatus taggingstatus, e e1)
    {
        a = taggingstatus;
        b = e1;
    }

    private void c(Tag tag)
    {
        TaggedBeacon taggedbeacon = a.getTaggedBeacon();
        if (taggedbeacon != null)
        {
            taggedbeacon.setUnsubmittedTag();
            taggedbeacon.setRequestId(tag.requestId);
            taggedbeacon.setLocation(tag.location);
            tag = tag.track;
            if (tag != null)
            {
                taggedbeacon.setTrackId(((Track) (tag)).id);
                taggedbeacon.setBeaconKey(((Track) (tag)).beaconKey);
                taggedbeacon.setCampaign(((Track) (tag)).campaign);
                taggedbeacon.setCategory(((Track) (tag)).category.toString());
                taggedbeacon.setOutcome(TaggingOutcome.MATCH);
            } else
            {
                taggedbeacon.setOutcome(TaggingOutcome.NO_MATCH);
            }
            taggedbeacon.setNetworkTypeName(b.a());
            taggedbeacon.setRecognitionType("network");
        }
        a.sendBeaconIfAvailable();
    }

    public final void a(Tag tag)
    {
        c(tag);
    }

    public final void b(Tag tag)
    {
        c(tag);
    }
}

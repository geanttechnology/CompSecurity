// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.a;

import com.shazam.android.analytics.LegacyTaggedBeaconSender;
import com.shazam.android.analytics.TaggingStatus;
import com.shazam.i.b.g.b;
import com.shazam.model.analytics.TaggedBeaconSender;

public final class a
{

    public static TaggedBeaconSender a()
    {
        TaggingStatus taggingstatus = b.a();
        com.shazam.android.analytics.TaggedBeacon taggedbeacon = taggingstatus.getTaggedBeacon();
        if (taggedbeacon != null)
        {
            return new LegacyTaggedBeaconSender(taggingstatus, taggedbeacon);
        } else
        {
            return TaggedBeaconSender.NO_OP;
        }
    }
}

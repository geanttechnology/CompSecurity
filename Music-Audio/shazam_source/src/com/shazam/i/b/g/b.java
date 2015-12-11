// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.g;

import com.shazam.android.analytics.AutoTaggedBeaconTaggingStatus;
import com.shazam.android.analytics.TaggedBeaconTaggingStatus;
import com.shazam.android.analytics.TaggedBeaconTaggingStatusFactory;
import com.shazam.android.analytics.TaggingStatus;
import com.shazam.i.b.at.a;
import com.shazam.model.analytics.BeaconEventKey;

public final class b
{

    static final TaggingStatus a;
    static final TaggingStatus b;
    static final TaggingStatus c;
    static final AutoTaggedBeaconTaggingStatus d;

    public static TaggingStatus a()
    {
        return a;
    }

    public static TaggingStatus b()
    {
        return b;
    }

    public static TaggingStatus c()
    {
        return c;
    }

    public static AutoTaggedBeaconTaggingStatus d()
    {
        return d;
    }

    static 
    {
        a = new TaggedBeaconTaggingStatus(com.shazam.i.p.b.b(), com.shazam.i.b.at.a.a(), com.shazam.i.b.g.b.a.a(), BeaconEventKey.TAGGED);
        b = new TaggedBeaconTaggingStatus(com.shazam.i.p.b.b(), com.shazam.i.b.at.a.a(), com.shazam.i.b.g.b.a.a(), BeaconEventKey.TAGGED);
        c = new TaggedBeaconTaggingStatus(com.shazam.i.p.b.b(), com.shazam.i.b.at.a.a(), com.shazam.i.b.g.b.a.a(), BeaconEventKey.TAGGED);
        d = new AutoTaggedBeaconTaggingStatus(new TaggedBeaconTaggingStatusFactory(com.shazam.i.p.b.b(), com.shazam.i.b.at.a.a(), com.shazam.i.b.g.b.a.a(), BeaconEventKey.AUTO_TAG));
    }
}

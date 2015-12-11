// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.news;

import com.shazam.server.response.follow.FollowData;
import com.shazam.server.response.like.Like;
import com.shazam.server.response.news.card.Media;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.server.response.news:
//            Content

public class FeedCard
{

    public final List actions;
    public final Map beaconData;
    public final Content content;
    public final FollowData followKey;
    public final String id;
    public final Like like;
    public final Media media;
    public final String providerName;
    public final String siteKey;
    public final long timestamp;
    public final String type;
    public final Map urlParams;
}

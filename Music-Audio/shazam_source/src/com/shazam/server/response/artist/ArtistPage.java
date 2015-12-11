// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.artist;

import com.shazam.server.response.details.Share;
import com.shazam.server.response.follow.Avatar;
import com.shazam.server.response.follow.FollowData;
import java.util.List;

// Referenced classes of package com.shazam.server.response.artist:
//            ArtistPageAdvertising

public class ArtistPage
{

    public final ArtistPageAdvertising advertising;
    public final Avatar avatar;
    public final String biography;
    public final FollowData followKey;
    public final List footNotes;
    public final String id;
    public final String name;
    public final Share share;
    public final boolean verified;
}

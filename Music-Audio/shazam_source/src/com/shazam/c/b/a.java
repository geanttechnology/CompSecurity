// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.b;

import com.shazam.model.artist.ArtistProfile;
import com.shazam.model.share.ShareData;
import com.shazam.server.response.artist.ArtistPage;
import com.shazam.server.response.artist.ArtistPageAdvertising;
import com.shazam.server.response.details.Share;
import com.shazam.server.response.follow.Avatar;
import com.shazam.server.response.follow.FollowData;
import java.util.Collections;

public final class a
    implements com.shazam.b.a.a
{

    private final com.shazam.b.a.a a;
    private final com.shazam.b.a.a b;

    public a(com.shazam.b.a.a a1, com.shazam.b.a.a a2)
    {
        a = a1;
        b = a2;
    }

    public final Object a(Object obj)
    {
        ArtistPage artistpage = (ArtistPage)obj;
        com.shazam.model.artist.ArtistProfile.Builder builder = com.shazam.model.artist.ArtistProfile.Builder.a();
        builder.name = artistpage.name;
        com.shazam.b.a.a a1;
        if (artistpage.avatar == null)
        {
            obj = null;
        } else
        {
            obj = artistpage.avatar.defaultUrl;
        }
        builder.defaultAvatar = ((String) (obj));
        builder.biography = artistpage.biography;
        builder.id = artistpage.id;
        a1 = a;
        if (artistpage.share == null)
        {
            obj = Share.EMPTY;
        } else
        {
            obj = artistpage.share;
        }
        builder.shareData = (ShareData)a1.a(obj);
        if (artistpage.followKey == null)
        {
            obj = FollowData.EMPTY;
        } else
        {
            obj = artistpage.followKey;
        }
        builder.followKey = ((FollowData) (obj));
        a1 = b;
        if (artistpage.footNotes == null)
        {
            obj = Collections.emptyList();
        } else
        {
            obj = artistpage.footNotes;
        }
        builder.footNotes = (String)a1.a(obj);
        if (artistpage.advertising == null)
        {
            obj = null;
        } else
        {
            obj = artistpage.advertising.parameters;
        }
        builder.adParams = ((java.util.Map) (obj));
        builder.verified = artistpage.verified;
        return new ArtistProfile(builder, null);
    }
}

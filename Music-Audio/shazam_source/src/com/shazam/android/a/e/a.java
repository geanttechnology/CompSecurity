// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.e;

import android.content.Context;
import android.view.ViewGroup;
import com.shazam.android.widget.button.follow.CompactFollowButton;
import com.shazam.android.widget.button.follow.FollowButton;
import com.shazam.android.widget.image.UrlCachingImageView;
import com.shazam.android.widget.image.d;
import com.shazam.android.widget.text.ArtistNameTextView;
import com.shazam.model.follow.Follow;
import java.util.List;

// Referenced classes of package com.shazam.android.a.e:
//            b

public final class com.shazam.android.a.e.a extends com.shazam.android.aw.a.a.a
{
    private final class a
        implements com.shazam.android.widget.button.follow.a
    {

        final com.shazam.android.a.e.a a;
        private final int c;
        private final Follow d;

        public final void a()
        {
            com.shazam.android.a.e.a a1 = a;
            int i = c;
            Object obj = com.shazam.model.follow.Follow.Builder.a(d);
            boolean flag;
            if (!d.isFollowing)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj.isFollowing = flag;
            obj = ((com.shazam.model.follow.Follow.Builder) (obj)).b();
            ((com.shazam.android.aw.a.a.a) (a1)).d.set(i, obj);
            ((android.support.v7.widget.RecyclerView.a) (a1)).a.a(i, 1);
        }

        public a(int i, Follow follow)
        {
            a = com.shazam.android.a.e.a.this;
            super();
            c = i;
            d = follow;
        }
    }


    public com.shazam.android.a.e.a(Context context)
    {
        super(context);
    }

    public final android.support.v7.widget.RecyclerView.u a(ViewGroup viewgroup, int i)
    {
        return new b(new com.shazam.android.widget.f.a(super.c));
    }

    public final void a(android.support.v7.widget.RecyclerView.u u, int i)
    {
        u = (b)u;
        Follow follow = (Follow)super.d.get(i);
        ((b) (u)).l.c.a = com.shazam.android.widget.button.follow.a.b;
        com.shazam.android.widget.f.a a1 = ((b) (u)).l;
        a1.d = follow;
        Object obj = a1.a.a(follow.defaultAvatar);
        obj.e = 0x7f020197;
        obj.g = 0x7f020197;
        obj.f = d.a;
        obj.j = true;
        ((com.shazam.android.widget.image.UrlCachingImageView.a) (obj)).c();
        a1.b.setText(follow.name);
        a1.b.setVerified(follow.verified);
        obj = com.shazam.model.follow.FollowData.Builder.a();
        obj.followKey = follow.followKey;
        obj.artistId = follow.id;
        obj = ((com.shazam.model.follow.FollowData.Builder) (obj)).b();
        a1.c.a(((com.shazam.model.follow.FollowData) (obj)), false);
        a1.c.setExtraAnalyticsParams(com.shazam.android.analytics.event.factory.FollowButtonEventFactory.Origin.FOLLOWING_LIST);
        a1.c.b(follow.isFollowing);
        ((b) (u)).l.setFollowButtonStateListener(new a(i, follow));
    }
}

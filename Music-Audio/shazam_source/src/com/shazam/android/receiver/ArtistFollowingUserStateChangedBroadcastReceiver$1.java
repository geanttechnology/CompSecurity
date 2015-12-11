// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.Context;
import android.net.Uri;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.FollowButtonEventFactory;
import com.shazam.android.k.a.a;
import com.shazam.android.k.f;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.f.a.i;
import com.shazam.model.follow.FollowAction;
import com.shazam.model.follow.FollowData;

// Referenced classes of package com.shazam.android.receiver:
//            ArtistFollowingUserStateChangedBroadcastReceiver

final class b
    implements Runnable
{

    final FollowAction a;
    final Context b;
    final ArtistFollowingUserStateChangedBroadcastReceiver c;

    public final void run()
    {
        String s1 = a.a().artistId;
        Object obj = a.a().followKey;
        android.net.dcastReceiver dcastreceiver = com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.m, new Object[] {
            s1
        }).buildUpon();
        if (a.following)
        {
            obj = com.shazam.i.b.o.b.a.b(((String) (obj)));
        } else
        {
            obj = com.shazam.i.b.o.b.a.a(((String) (obj)));
            dcastreceiver.a("shouldDisplayFollowingToast", "ok");
        }
        try
        {
            ((f) (obj)).a();
            com.shazam.android.receiver.ArtistFollowingUserStateChangedBroadcastReceiver.a(c).logEvent(FollowButtonEventFactory.followSuccessEvent(a.following, a.a()));
        }
        catch (i j)
        {
            com.shazam.android.receiver.ArtistFollowingUserStateChangedBroadcastReceiver.a(c).logEvent(FollowButtonEventFactory.followErrorEvent(a.following, a.a(), true));
            return;
        }
        catch (a a1)
        {
            com.shazam.android.receiver.ArtistFollowingUserStateChangedBroadcastReceiver.a(c).logEvent(FollowButtonEventFactory.followErrorEvent(a.following, a.a(), false));
            ArtistFollowingUserStateChangedBroadcastReceiver.b(c).a(r.a());
        }
        if (com.shazam.b.e.a.c(s1))
        {
            ArtistFollowingUserStateChangedBroadcastReceiver.c(c).a(b, dcastreceiver.b());
        }
    }

    (ArtistFollowingUserStateChangedBroadcastReceiver artistfollowinguserstatechangedbroadcastreceiver, FollowAction followaction, Context context)
    {
        c = artistfollowinguserstatechangedbroadcastreceiver;
        a = followaction;
        b = context;
        super();
    }
}

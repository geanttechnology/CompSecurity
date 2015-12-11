// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.FollowButtonEventFactory;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.android.widget.c.f;
import com.shazam.f.a.i;
import com.shazam.i.b.au.d;
import com.shazam.i.k.a.b;
import com.shazam.i.l.e;
import com.shazam.i.o.a;
import com.shazam.k.p;
import com.shazam.model.account.UserStateDecider;
import com.shazam.model.follow.FollowAction;
import com.shazam.model.follow.FollowData;
import java.util.concurrent.ExecutorService;

public class ArtistFollowingUserStateChangedBroadcastReceiver extends BroadcastReceiver
{

    private final UserStateDecider a = com.shazam.i.k.a.b.a();
    private final ExecutorService b = com.shazam.i.o.a.a();
    private final p c = com.shazam.i.l.e.a();
    private final s d = com.shazam.i.b.au.d.b();
    private final f e = com.shazam.i.b.ay.a.a.b();
    private final EventAnalytics f = com.shazam.i.b.g.b.a.a();

    public ArtistFollowingUserStateChangedBroadcastReceiver()
    {
    }

    static EventAnalytics a(ArtistFollowingUserStateChangedBroadcastReceiver artistfollowinguserstatechangedbroadcastreceiver)
    {
        return artistfollowinguserstatechangedbroadcastreceiver.f;
    }

    static s b(ArtistFollowingUserStateChangedBroadcastReceiver artistfollowinguserstatechangedbroadcastreceiver)
    {
        return artistfollowinguserstatechangedbroadcastreceiver.d;
    }

    static f c(ArtistFollowingUserStateChangedBroadcastReceiver artistfollowinguserstatechangedbroadcastreceiver)
    {
        return artistfollowinguserstatechangedbroadcastreceiver.e;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (a.f() && c.a())
        {
            intent = c.b();
            c.c();
            b.execute(new Runnable(intent, context) {

                final FollowAction a;
                final Context b;
                final ArtistFollowingUserStateChangedBroadcastReceiver c;

                public final void run()
                {
                    String s1 = a.a().artistId;
                    Object obj = a.a().followKey;
                    android.net.Uri.Builder builder = com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.m, new Object[] {
                        s1
                    }).buildUpon();
                    if (a.following)
                    {
                        obj = com.shazam.i.b.o.b.a.b(((String) (obj)));
                    } else
                    {
                        obj = com.shazam.i.b.o.b.a.a(((String) (obj)));
                        builder.appendQueryParameter("shouldDisplayFollowingToast", "ok");
                    }
                    try
                    {
                        ((com.shazam.android.k.f) (obj)).a();
                        com.shazam.android.receiver.ArtistFollowingUserStateChangedBroadcastReceiver.a(c).logEvent(FollowButtonEventFactory.followSuccessEvent(a.following, a.a()));
                    }
                    catch (i j)
                    {
                        com.shazam.android.receiver.ArtistFollowingUserStateChangedBroadcastReceiver.a(c).logEvent(FollowButtonEventFactory.followErrorEvent(a.following, a.a(), true));
                        return;
                    }
                    catch (com.shazam.android.k.a.a a1)
                    {
                        com.shazam.android.receiver.ArtistFollowingUserStateChangedBroadcastReceiver.a(c).logEvent(FollowButtonEventFactory.followErrorEvent(a.following, a.a(), false));
                        com.shazam.android.receiver.ArtistFollowingUserStateChangedBroadcastReceiver.b(c).a(r.a());
                    }
                    if (com.shazam.b.e.a.c(s1))
                    {
                        ArtistFollowingUserStateChangedBroadcastReceiver.c(c).a(b, builder.build());
                    }
                }

            
            {
                c = ArtistFollowingUserStateChangedBroadcastReceiver.this;
                a = followaction;
                b = context;
                super();
            }
            });
        }
    }
}

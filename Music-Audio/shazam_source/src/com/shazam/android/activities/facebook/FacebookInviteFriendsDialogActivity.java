// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.facebook;

import android.os.Bundle;
import android.view.View;
import com.facebook.share.model.AppInviteContent;
import com.shazam.android.activities.b;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.FacebookInviteFriendsEventFactory;
import com.shazam.i.b.g.b.a;

public class FacebookInviteFriendsDialogActivity extends com.shazam.android.activities.b
    implements com.shazam.p.g.b
{
    private final class a
        implements com.shazam.android.activities.b.a
    {

        final FacebookInviteFriendsDialogActivity b;

        public final void a()
        {
            FacebookInviteFriendsDialogActivity.c(b);
        }

        private a()
        {
            b = FacebookInviteFriendsDialogActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.view.View.OnClickListener
    {

        final FacebookInviteFriendsDialogActivity a;

        public final void onClick(View view)
        {
            view = com.shazam.android.activities.facebook.FacebookInviteFriendsDialogActivity.a(a);
            ((com.shazam.l.g.b) (view)).a.a();
            ((com.shazam.l.g.b) (view)).a.b();
            com.shazam.android.activities.facebook.FacebookInviteFriendsDialogActivity.b(a).logEvent(FacebookInviteFriendsEventFactory.createFacebookInviteFriendsInviteEvent());
        }

        private b()
        {
            a = FacebookInviteFriendsDialogActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c
        implements android.view.View.OnClickListener
    {

        final FacebookInviteFriendsDialogActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.facebook.FacebookInviteFriendsDialogActivity.a(a).a.b();
            FacebookInviteFriendsDialogActivity.c(a);
        }

        private c()
        {
            a = FacebookInviteFriendsDialogActivity.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }


    private final EventAnalytics g = com.shazam.i.b.g.b.a.a();
    private com.shazam.l.g.b h;

    public FacebookInviteFriendsDialogActivity()
    {
    }

    static com.shazam.l.g.b a(FacebookInviteFriendsDialogActivity facebookinvitefriendsdialogactivity)
    {
        return facebookinvitefriendsdialogactivity.h;
    }

    static EventAnalytics b(FacebookInviteFriendsDialogActivity facebookinvitefriendsdialogactivity)
    {
        return facebookinvitefriendsdialogactivity.g;
    }

    static void c(FacebookInviteFriendsDialogActivity facebookinvitefriendsdialogactivity)
    {
        facebookinvitefriendsdialogactivity.g.logEvent(FacebookInviteFriendsEventFactory.createFacebookInviteFriendsSkipEvent());
    }

    public final void a()
    {
        com.facebook.share.model.AppInviteContent.a a1 = new com.facebook.share.model.AppInviteContent.a();
        a1.a = "http://www.shazam.com";
        com.facebook.share.b.a.a(this, new AppInviteContent(a1, (byte)0));
    }

    public final void b()
    {
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a(0x7f0900a7);
        b(0x7f030020);
        d(0x7f090092);
        c(0x7f0900be);
        a(new b((byte)0));
        b(new c((byte)0));
        super.f = new a((byte)0);
        super.e = false;
        h = new com.shazam.l.g.b(this);
    }

    protected void onStart()
    {
        super.onStart();
        g.logEvent(FacebookInviteFriendsEventFactory.createFacebookInviteFriendsImpressionEvent());
    }
}

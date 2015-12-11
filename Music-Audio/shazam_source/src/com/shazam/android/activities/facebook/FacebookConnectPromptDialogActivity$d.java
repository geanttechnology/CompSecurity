// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.facebook;

import com.shazam.android.activities.b.b;
import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.l.a.c;
import com.shazam.p.i.a;

// Referenced classes of package com.shazam.android.activities.facebook:
//            FacebookConnectPromptDialogActivity

private final class <init> extends a
{

    final FacebookConnectPromptDialogActivity a;

    public final void a()
    {
        FacebookConnectPromptDialogActivity.h(a).c();
    }

    public final void g()
    {
        FacebookConnectPromptDialogActivity.g(a);
    }

    public final void h()
    {
        com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.roviderName.FACEBOOK, BeaconErrorCode.FAILED, "likepopupfb", "socialsignup"));
        FacebookConnectPromptDialogActivity.f(a);
    }

    public final void i()
    {
        com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.roviderName.FACEBOOK, BeaconErrorCode.FACEBOOK_ACCESS_TOKEN_MISSING, "socialsignup"));
        FacebookConnectPromptDialogActivity.f(a);
    }

    public final void j()
    {
        com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.success(com.shazam.android.analytics.event.factory.roviderName.FACEBOOK, "likepopupfb"));
        FacebookConnectPromptDialogActivity.i(a);
    }

    public final void k()
    {
        com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.c(a);
        FacebookConnectPromptDialogActivity.d(a);
    }

    public final void l()
    {
        com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.roviderName.FACEBOOK, BeaconErrorCode.UNAUTHORIZED, "likepopupfb", "socialsignup"));
        b.a(a, "", false);
        a.finish();
    }

    public final void m()
    {
        FacebookConnectPromptDialogActivity.h(a).d();
    }

    private ginProviderName(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        a = facebookconnectpromptdialogactivity;
        super();
    }

    a(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity, byte byte0)
    {
        this(facebookconnectpromptdialogactivity);
    }
}

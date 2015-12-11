// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.facebook;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.FacebookLogInEventFactory;
import com.shazam.l.g.a;
import com.shazam.model.facebook.FacebookLoginErrorSource;
import com.shazam.p.g.c;

// Referenced classes of package com.shazam.android.activities.facebook:
//            FacebookConnectPromptDialogActivity

private final class <init> extends c
{

    final FacebookConnectPromptDialogActivity a;

    public final void a()
    {
        com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.nActions.CONNECT_SUCCESS, "likepopupfb", null));
        FacebookConnectPromptDialogActivity.e(a);
    }

    public final void a(FacebookLoginErrorSource facebookloginerrorsource)
    {
        com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(FacebookLogInEventFactory.createFacebookErrorUserEvent(com.shazam.android.analytics.event.factory.nActions.CONNECT_ERROR, facebookloginerrorsource, "likepopupfb", null));
        FacebookConnectPromptDialogActivity.f(a);
    }

    public final void b()
    {
        com.shazam.android.activities.facebook.FacebookConnectPromptDialogActivity.a(a).logEvent(FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.nActions.CONNECT_CANCEL, "likepopupfb", null));
        FacebookConnectPromptDialogActivity.d(a);
    }

    public final void c()
    {
        FacebookConnectPromptDialogActivity.g(a);
    }

    public final void d()
    {
        FacebookConnectPromptDialogActivity.b(a).c();
        FacebookConnectPromptDialogActivity.h(a).a();
    }

    private LoginActions(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity)
    {
        a = facebookconnectpromptdialogactivity;
        super();
    }

    a(FacebookConnectPromptDialogActivity facebookconnectpromptdialogactivity, byte byte0)
    {
        this(facebookconnectpromptdialogactivity);
    }
}

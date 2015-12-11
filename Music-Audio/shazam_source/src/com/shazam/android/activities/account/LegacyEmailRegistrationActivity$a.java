// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.content.Intent;
import android.view.View;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.RegistrationEventFactory;

// Referenced classes of package com.shazam.android.activities.account:
//            LegacyEmailRegistrationActivity

private final class <init>
    implements android.view.ilRegistrationActivity.a
{

    final LegacyEmailRegistrationActivity a;

    public final void onClick(View view)
    {
        LegacyEmailRegistrationActivity.c(a).logEvent(RegistrationEventFactory.createRegistrationEvent(com.shazam.android.analytics.event.factory.ionAction.CHOOSE_ACCOUNT));
        if (LegacyEmailRegistrationActivity.d(a))
        {
            view = LegacyEmailRegistrationActivity.a();
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
            intent.setPackage("com.google.android.gms");
            intent.putExtra("allowableAccounts", null);
            intent.putExtra("allowableAccountTypes", view);
            intent.putExtra("addAccountOptions", null);
            intent.putExtra("selectedAccount", null);
            intent.putExtra("alwaysPromptForAccount", true);
            intent.putExtra("descriptionTextOverride", null);
            intent.putExtra("authTokenType", null);
            intent.putExtra("addAccountRequiredFeatures", null);
            intent.putExtra("setGmsCoreAccount", false);
            intent.putExtra("overrideTheme", 0);
            intent.putExtra("overrideCustomTheme", 0);
            a.startActivityForResult(intent, 123);
        }
    }

    private strationAction(LegacyEmailRegistrationActivity legacyemailregistrationactivity)
    {
        a = legacyemailregistrationactivity;
        super();
    }

    a(LegacyEmailRegistrationActivity legacyemailregistrationactivity, byte byte0)
    {
        this(legacyemailregistrationactivity);
    }
}

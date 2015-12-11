// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.content.DialogInterface;
import android.os.Bundle;
import com.poshmark.analytics.Analytics;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PartyFragment;

// Referenced classes of package com.poshmark.notifications:
//            PartyAlert

static final class val.bundle
    implements android.content.ce.OnClickListener
{

    final Bundle val$bundle;
    final PMActivity val$topActivity;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Analytics.getInstance().trackEvent(null, "party", "join_party_notification_clicked", null);
        val$topActivity.launchFragmentInNewActivity(val$bundle, com/poshmark/ui/fragments/PartyFragment, null);
    }

    istener(PMActivity pmactivity, Bundle bundle1)
    {
        val$topActivity = pmactivity;
        val$bundle = bundle1;
        super();
    }
}

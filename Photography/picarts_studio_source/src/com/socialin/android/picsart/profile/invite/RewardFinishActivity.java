// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.invite;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.EventParam;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            i

public class RewardFinishActivity extends Activity
{

    public RewardFinishActivity()
    {
    }

    static void a(RewardFinishActivity rewardfinishactivity)
    {
        if (i.o(rewardfinishactivity))
        {
            Utils.b(rewardfinishactivity, rewardfinishactivity.getString(0x7f0803c1));
            return;
        }
        if (i.n(rewardfinishactivity) || i.o(rewardfinishactivity))
        {
            Utils.b(rewardfinishactivity, rewardfinishactivity.getString(0x7f0803c1));
            return;
        } else
        {
            i.a(rewardfinishactivity, "ad_remover", EventParam.ENJOY_DIALOG.getName());
            rewardfinishactivity.setResult(-1, rewardfinishactivity.getIntent());
            rewardfinishactivity.finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030143);
        i.a(getApplicationContext()).edit().putBoolean("invite.enjoy.dialog.is.shown", true).apply();
        bundle = getIntent().getStringExtra("from");
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowInviteEnjoyScreenOpenEvent(bundle));
        findViewById(0x7f1006a9).setOnClickListener(new android.view.View.OnClickListener(bundle) {

            private String a;
            private RewardFinishActivity b;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(b).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowInviteScreenCancelEvent(a));
                b.setResult(0, b.getIntent());
                b.finish();
            }

            
            {
                b = RewardFinishActivity.this;
                a = s;
                super();
            }
        });
        bundle = findViewById(0x7f1006ab);
        findViewById(0x7f1006aa).setVisibility(0);
        bundle.setVisibility(0);
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            private RewardFinishActivity a;

            public final void onClick(View view)
            {
                RewardFinishActivity.a(a);
            }

            
            {
                a = RewardFinishActivity.this;
                super();
            }
        });
    }
}

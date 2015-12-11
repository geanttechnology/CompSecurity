// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity, PartageAppsFragment

class this._cls0
    implements android.view.
{

    final GameOverActivity this$0;

    public void onClick(View view)
    {
        if (isFound() || isInfo())
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            layoutPartage.setVisibility(0);
            return;
        }
        disableAdOneTime();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        view = getIntent().getStringExtra("keyAcceptance");
        java.util.List list;
        if (view == null)
        {
            view = (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("J_AI_PIEGE_AKINATOR_EN_PENSANT_A")).append(" ").append(SessionFactory.sharedInstance().getSession().getCurrentProposedObject().getName()).toString();
        } else
        {
            view = (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("J_AI_PIEGE_AKINATOR_EN_PENSANT_A")).append(" ").append(view).toString();
        }
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append("#Akinator ").append(view).append(" ").append(getResources().getString(0x7f07005f)).toString());
        list = getPackageManager().queryIntentActivities(intent, 0);
        GameOverActivity.access$1102(GameOverActivity.this, new PartageAppsFragment());
        GameOverActivity.access$1100(GameOverActivity.this).setModePerdu(true);
        GameOverActivity.access$1100(GameOverActivity.this).setFacebookDesc(view);
        GameOverActivity.access$1100(GameOverActivity.this).build(intent, list);
        view = getFragmentManager().beginTransaction();
        view.add(0x7f0d00e0, GameOverActivity.access$1100(GameOverActivity.this));
        view.commit();
    }

    dsBinder()
    {
        this$0 = GameOverActivity.this;
        super();
    }
}

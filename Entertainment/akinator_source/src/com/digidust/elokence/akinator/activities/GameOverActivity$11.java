// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import com.digidust.elokence.akinator.activities.transitions.GameOverTransition;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity, AjoutModifPersoMBActivity, CustomizeActivity

class this._cls0
    implements android.view.
{

    final GameOverActivity this$0;

    public void onClick(View view)
    {
        disableAdOneTime();
        if (moreAlertDialog != null && moreAlertDialog.isShowing())
        {
            moreAlertDialog.dismiss();
        }
        BackgroundSoundsBinder.sharedInstance().playBip();
        if (!GameOverActivity.access$700(GameOverActivity.this)) goto _L2; else goto _L1
_L1:
        view = new Intent(GameOverActivity.this, com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity);
        view.putExtra("ActivityMode", false);
        view.putExtra("minibaseCharacterToModify", GameOverActivity.access$900(GameOverActivity.this));
        if (!isFound()) goto _L4; else goto _L3
_L3:
        view.putExtra("ActivityCaller", 2);
_L5:
        startActivity(view);
        finish();
        return;
_L4:
        if (isLost())
        {
            view.putExtra("ActivityCaller", 3);
        } else
        if (isInfo())
        {
            view.putExtra("ActivityCaller", 6);
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked())
        {
            GameOverActivity.access$1000(GameOverActivity.this).displayUltimatePotion();
            return;
        } else
        {
            view = new Intent(GameOverActivity.this, com/digidust/elokence/akinator/activities/CustomizeActivity);
            startActivity(view);
            finish();
            return;
        }
    }

    Transition()
    {
        this$0 = GameOverActivity.this;
        super();
    }
}

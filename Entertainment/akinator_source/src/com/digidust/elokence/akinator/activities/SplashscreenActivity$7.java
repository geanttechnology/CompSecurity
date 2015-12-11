// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.elokence.limuleapi.MinibaseFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity, SelectLanguageActivity, HomeActivity

class this._cls0
    implements Runnable
{

    final SplashscreenActivity this$0;

    public void run()
    {
        if (!SplashscreenActivity.access$500(SplashscreenActivity.this)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (SplashscreenActivity.access$000(SplashscreenActivity.this) || SplashscreenActivity.access$100(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$600(SplashscreenActivity.this).setVisibility(0);
        }
        if (SplashscreenActivity.access$400(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$700(SplashscreenActivity.this).setVisibility(0);
        }
        if (SplashscreenActivity.access$800(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$900(SplashscreenActivity.this).setVisibility(0);
        }
        if (SplashscreenActivity.access$1000(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1100(SplashscreenActivity.this).setVisibility(0);
        }
        if (SplashscreenActivity.access$1200(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1300(SplashscreenActivity.this).setVisibility(0);
        }
        if (SplashscreenActivity.access$200(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1400(SplashscreenActivity.this).setVisibility(0);
        }
        if (SplashscreenActivity.access$1500(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1600(SplashscreenActivity.this).setVisibility(0);
        }
        if (!SplashscreenActivity.access$1700(SplashscreenActivity.this)[0] && (SplashscreenActivity.access$000(SplashscreenActivity.this) || SplashscreenActivity.access$100(SplashscreenActivity.this)))
        {
            SplashscreenActivity.access$1700(SplashscreenActivity.this)[0] = true;
            SplashscreenActivity.access$1900(SplashscreenActivity.this).setProgress(SplashscreenActivity.access$1804(SplashscreenActivity.this));
        }
        if (!SplashscreenActivity.access$1700(SplashscreenActivity.this)[1] && SplashscreenActivity.access$400(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1700(SplashscreenActivity.this)[1] = true;
            SplashscreenActivity.access$1900(SplashscreenActivity.this).setProgress(SplashscreenActivity.access$1804(SplashscreenActivity.this));
        }
        if (!SplashscreenActivity.access$1700(SplashscreenActivity.this)[2] && SplashscreenActivity.access$800(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1700(SplashscreenActivity.this)[2] = true;
            SplashscreenActivity.access$1900(SplashscreenActivity.this).setProgress(SplashscreenActivity.access$1804(SplashscreenActivity.this));
        }
        if (!SplashscreenActivity.access$1700(SplashscreenActivity.this)[3] && SplashscreenActivity.access$1000(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1700(SplashscreenActivity.this)[3] = true;
            SplashscreenActivity.access$1900(SplashscreenActivity.this).setProgress(SplashscreenActivity.access$1804(SplashscreenActivity.this));
        }
        if (!SplashscreenActivity.access$1700(SplashscreenActivity.this)[4] && SplashscreenActivity.access$1200(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1700(SplashscreenActivity.this)[4] = true;
            SplashscreenActivity.access$1900(SplashscreenActivity.this).setProgress(SplashscreenActivity.access$1804(SplashscreenActivity.this));
        }
        if (!SplashscreenActivity.access$1700(SplashscreenActivity.this)[5] && SplashscreenActivity.access$200(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1700(SplashscreenActivity.this)[5] = true;
            SplashscreenActivity.access$1900(SplashscreenActivity.this).setProgress(SplashscreenActivity.access$1804(SplashscreenActivity.this));
        }
        if (!SplashscreenActivity.access$1700(SplashscreenActivity.this)[6] && SplashscreenActivity.access$1500(SplashscreenActivity.this))
        {
            SplashscreenActivity.access$1700(SplashscreenActivity.this)[6] = true;
            SplashscreenActivity.access$1900(SplashscreenActivity.this).setProgress(SplashscreenActivity.access$1804(SplashscreenActivity.this));
        }
        if (!SplashscreenActivity.access$2000(SplashscreenActivity.this) || !SplashscreenActivity.access$000(SplashscreenActivity.this) && !SplashscreenActivity.access$100(SplashscreenActivity.this) || !SplashscreenActivity.access$400(SplashscreenActivity.this) || !SplashscreenActivity.access$800(SplashscreenActivity.this) || !SplashscreenActivity.access$1000(SplashscreenActivity.this) || !SplashscreenActivity.access$1200(SplashscreenActivity.this) || !SplashscreenActivity.access$200(SplashscreenActivity.this) || !SplashscreenActivity.access$1500(SplashscreenActivity.this)) goto _L1; else goto _L3
_L3:
        Object obj = AkApplication.getAppContext().getSharedPreferences("settings", 0);
        if (obj != null && MinibaseFactory.sharedInstance().getMinibid() == -1 && ((SharedPreferences) (obj)).getInt("minibid", -1) != -1)
        {
            MinibaseFactory.sharedInstance().setMinibid(((SharedPreferences) (obj)).getInt("minibid", -1));
            MinibaseFactory.sharedInstance().setMBPrivateKey(((SharedPreferences) (obj)).getString("background_colors", ""));
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.r) (obj)).putInt("minibid", -1);
            ((android.content.r) (obj)).putString("background_colors", "");
            ((android.content.r) (obj)).commit();
        }
        SplashscreenActivity.access$502(SplashscreenActivity.this, true);
        if (SplashscreenActivity.access$100(SplashscreenActivity.this))
        {
            AkLog.d("SplashscreenActivity", "GO TO LANGUAGE SELECTION");
            Intent intent = new Intent(SplashscreenActivity.this, com/digidust/elokence/akinator/activities/SelectLanguageActivity);
            intent.putExtra("canShowCenteredAd", true);
            startActivity(intent);
            finish();
            return;
        }
        break MISSING_BLOCK_LABEL_780;
    /* block-local class not found */
    class _cls1 {}

        Intent intent1;
        if (!AkConfigFactory.sharedInstance().isPaid() && !AkGameFactory.sharedInstance().isUnlocked());
        AkConfigFactory.sharedInstance().setFirstLaunch(false);
        (new Thread(new _cls1())).start();
        AkLog.d("SplashscreenActivity", "GO TO HOME");
        intent1 = new Intent(SplashscreenActivity.this, com/digidust/elokence/akinator/activities/HomeActivity);
        intent1.putExtra("canShowCenteredAd", true);
        intent1.putExtra("ShowAdOnGameOver", false);
        startActivity(intent1);
        return;
    }

    _cls1()
    {
        this$0 = SplashscreenActivity.this;
        super();
    }
}

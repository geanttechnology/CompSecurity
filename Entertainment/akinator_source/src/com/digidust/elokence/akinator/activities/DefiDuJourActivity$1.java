// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.elokence.analytics.MetricsSetAdapter;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            DefiDuJourActivity

class this._cls0
    implements android.view.animation.stener
{

    final DefiDuJourActivity this$0;

    public void onAnimationEnd(Animation animation)
    {
        layoutFireworks.setVisibility(8);
        layoutFireworks.setClickable(false);
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricCompteur("gz_gain_playing", 1000);
        AkPlayerBelongingsFactory.sharedInstance().depositGenizWithoutNotif(1000);
        AkGameFactory.sharedInstance().setCharacterScreenshotDefi(screenShot(findViewById(0x7f0d0085)));
        DefiDuJourActivity.access$000(DefiDuJourActivity.this).setEnabled(true);
    /* block-local class not found */
    class _cls1 {}

        (new _cls1()).start();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls1()
    {
        this$0 = DefiDuJourActivity.this;
        super();
    }
}

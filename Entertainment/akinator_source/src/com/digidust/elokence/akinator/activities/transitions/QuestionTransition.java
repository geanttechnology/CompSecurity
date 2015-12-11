// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.transitions;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.activities.FreemiumPopularityActivity;
import com.digidust.elokence.akinator.activities.OneCharacterProposalActivity;
import com.digidust.elokence.akinator.activities.ProposeAjoutMBActivity;
import com.digidust.elokence.akinator.activities.QuestionActivity;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;

public class QuestionTransition
{

    QuestionActivity activity;
    private ImageView uiBoutonOverlayAcheter;
    private ImageView uiBoutonOverlayNonMerci;
    private Button uiImageCroixFermetureBanner;
    private RelativeLayout uiLayoutBannerAd;
    private RelativeLayout uiLayoutOverlayPotion;
    private TextView uiTexteOverlay1;
    private TextView uiTexteOverlayAcheter;
    private TextView uiTexteOverlayDesc;
    private TextView uiTexteOverlayNonMerci;

    public QuestionTransition(QuestionActivity questionactivity)
    {
        activity = questionactivity;
    }

    public void listWsTransition()
    {
        if (AkGameFactory.sharedInstance().isUnlocked() || ((com.elokence.limuleapi.Session.ProposedLimuleObject)SessionFactory.sharedInstance().getSession().getCurrentProposedObject()).getRankingLimit() < AkConfigFactory.sharedInstance().getMaxRanking() || !AkGameFactory.sharedInstance().isPopularityLimited())
        {
            int i = AkConfigFactory.sharedInstance().getMaxRanking();
            AkLog.d("Akinator", (new StringBuilder()).append("Old max ranking ").append(i).toString());
            i = (int)((double)i * ((100D - (double)AkConfigFactory.sharedInstance().getPopDownRate()) / 100D));
            AkConfigFactory.sharedInstance().setMaxRanking(i);
            AkLog.d("Akinator", (new StringBuilder()).append("New max ranking (downed) ").append(i).toString());
            Intent intent;
            if (AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated() || SessionFactory.sharedInstance().getSession().getNbPertinentObjects() > 0)
            {
                intent = new Intent(activity, com/digidust/elokence/akinator/activities/OneCharacterProposalActivity);
            } else
            {
                intent = new Intent(activity, com/digidust/elokence/akinator/activities/ProposeAjoutMBActivity);
                intent.putExtra("gagne_ou_perdu", true);
            }
            activity.closeOptionsMenu();
            activity.startActivity(intent);
            AkLog.i("Akinator", "QUESTION ACTIVITY FINISH");
            activity.finish();
            return;
        }
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("last_game", "B");
        Intent intent1 = new Intent(activity, com/digidust/elokence/akinator/activities/FreemiumPopularityActivity);
        int j = AkConfigFactory.sharedInstance().getMaxRanking();
        AkLog.d("Akinator", (new StringBuilder()).append("Old max ranking ").append(j).toString());
        int k = (int)((double)j * (((double)AkConfigFactory.sharedInstance().getPopUpRate() + 100D) / 100D));
        j = k;
        if (k > AkConfigFactory.sharedInstance().getOriginalMaxRanking() * 10)
        {
            j = AkConfigFactory.sharedInstance().getOriginalMaxRanking() * 10;
        }
        AkConfigFactory.sharedInstance().setMaxRanking(j);
        AkLog.d("Akinator", (new StringBuilder()).append("New max ranking (upped) ").append(j).toString());
        activity.closeOptionsMenu();
        activity.startActivity(intent1);
        activity.finish();
    }
}

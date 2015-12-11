// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.db.AkDBAdapter;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.elokence.analytics.AnalyticsCenter;
import com.elokence.analytics.MetricsSetAdapter;
import com.facebook.AccessToken;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, StoreItemsFragment

class this._cls0
    implements Runnable
{

    final AkActivity this$0;

    public void run()
    {
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("xp", String.valueOf(AkPlayerBelongingsFactory.sharedInstance().getXp()));
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("gz_counter", String.valueOf(AkPlayerBelongingsFactory.sharedInstance().getGenizBalance()));
        String as[];
        int l;
        int l1;
        try
        {
            AkDBAdapter akdbadapter = new AkDBAdapter(AkApplication.getAppContext());
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("badges_standard", String.valueOf(akdbadapter.getNbCharactersPlayedForAwardLevel(1)));
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("badges_bronze", String.valueOf(akdbadapter.getNbCharactersPlayedForAwardLevel(2)));
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("badges_silver", String.valueOf(akdbadapter.getNbCharactersPlayedForAwardLevel(3)));
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("badges_gold", String.valueOf(akdbadapter.getNbCharactersPlayedForAwardLevel(4)));
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("badges_platinum", String.valueOf(akdbadapter.getNbCharactersPlayedForAwardLevel(5)));
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("badges_black", String.valueOf(akdbadapter.getNbCharactersPlayedForAwardLevel(6)));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        if (AccessToken.getCurrentAccessToken() != null)
        {
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("leaderboard", "1");
        } else
        {
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("leaderboard", "0");
        }
        l = 0;
        as = StoreItemsFragment.mHatNames;
        l1 = as.length;
        for (int i = 0; i < l1;)
        {
            String s1 = as[i];
            int i1 = l;
            if (AkPlayerBelongingsFactory.sharedInstance().isItemBought("hat", s1))
            {
                i1 = l + 1;
            }
            i++;
            l = i1;
        }

        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("unlocked_hats", String.valueOf(l - 1));
        l = 0;
        exception = StoreItemsFragment.mClothNames;
        l1 = exception.length;
        for (int j = 0; j < l1;)
        {
            String s2 = exception[j];
            int j1 = l;
            if (AkPlayerBelongingsFactory.sharedInstance().isItemBought("cloth", s2))
            {
                j1 = l + 1;
            }
            j++;
            l = j1;
        }

        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("unlocked_clothes", String.valueOf(l - 2));
        l = 0;
        exception = StoreItemsFragment.mBackgroundNames;
        l1 = exception.length;
        for (int k = 0; k < l1;)
        {
            String s3 = exception[k];
            int k1 = l;
            if (AkPlayerBelongingsFactory.sharedInstance().isItemBought("bg", s3))
            {
                k1 = l + 1;
            }
            k++;
            l = k1;
        }

        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("unlocked_backgrounds", String.valueOf(l - 2));
        AkPlayerBelongingsFactory.sharedInstance().getCurrentBackgroundIndex();
        JVM INSTR tableswitch 0 4: default 432
    //                   0 927
    //                   1 940
    //                   2 954
    //                   3 968
    //                   4 982;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_background", "OR");
_L37:
        AkPlayerBelongingsFactory.sharedInstance().getCurrentHatIndex();
        JVM INSTR tableswitch 0 10: default 508
    //                   0 996
    //                   1 1009
    //                   2 1023
    //                   3 1037
    //                   4 1051
    //                   5 1065
    //                   6 1079
    //                   7 1093
    //                   8 1107
    //                   9 1121
    //                   10 1135;
           goto _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L7:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "TU");
_L33:
        AkPlayerBelongingsFactory.sharedInstance().getCurrentClothIndex();
        JVM INSTR tableswitch 0 12: default 592
    //                   0 1149
    //                   1 1162
    //                   2 1176
    //                   3 1190
    //                   4 1204
    //                   5 1218
    //                   6 1232
    //                   7 1246
    //                   8 1260
    //                   9 1274
    //                   10 1288
    //                   11 1302
    //                   12 1316;
           goto _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32
_L19:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "TU");
_L34:
        MetricsSetAdapter metricssetadapter = MetricsSetAdapter.sharedInstance();
        String s;
        if (AkConfigFactory.sharedInstance().isMusicEnabled())
        {
            s = "1";
        } else
        {
            s = "0";
        }
        metricssetadapter.createOrUpdateMetricValeur("music", s);
        metricssetadapter = MetricsSetAdapter.sharedInstance();
        if (AkConfigFactory.sharedInstance().isSoundEnabled())
        {
            s = "1";
        } else
        {
            s = "0";
        }
        metricssetadapter.createOrUpdateMetricValeur("sounds", s);
        metricssetadapter = MetricsSetAdapter.sharedInstance();
        if (AkConfigFactory.sharedInstance().isChildProtectEnabled())
        {
            s = "1";
        } else
        {
            s = "0";
        }
        metricssetadapter.createOrUpdateMetricValeur("child_filter_activated", s);
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("mw_credit", String.valueOf(AkPlayerBelongingsFactory.sharedInstance().getFacesBalance()));
        s = (new AkDBAdapter(AkActivity.this)).getAllBaseIdAndBaseLogiqueId();
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("played_characters", s);
_L35:
        Object obj;
        if (AkConfigFactory.sharedInstance().isWifiConnected())
        {
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("reseau", "WIFI");
        } else
        {
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("reseau", "GSM");
        }
        try
        {
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("shop_click");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("mw_inapp_purchased");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("how_to_get_geniz");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("popu_block");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("popu_unlockable");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("popu_unlocked");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("pub_close");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("gz_gain_offer_walls");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("gz_gain_inapp");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("sharing_bd");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("sharing_badge");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("sharing_fb");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("sharing_character");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("sharing_twitter");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("sharing_unguessed");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("rating_app");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("added_questions");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("added_photo");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("nb_jours");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("enigmes_hits");
            MetricsSetAdapter.sharedInstance().initCompteurToZeroIfNotExist("enigmes_completes");
        }
        catch (Exception exception1) { }
        AkLog.d("analytics", "send analytics!");
        AnalyticsCenter.getInstance().push(getApplicationContext());
        AkSessionFactory.sharedInstance().setAnalyticsSend(true);
        return;
_L2:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_background", "OR");
        continue; /* Loop/switch isn't completed */
_L3:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_background", "JP");
        continue; /* Loop/switch isn't completed */
_L4:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_background", "FW");
        continue; /* Loop/switch isn't completed */
_L5:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_background", "MA");
        continue; /* Loop/switch isn't completed */
_L6:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_background", "HW");
        continue; /* Loop/switch isn't completed */
_L8:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "TU");
          goto _L33
_L9:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "RP");
          goto _L33
_L10:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "SB");
          goto _L33
_L11:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "CH");
          goto _L33
_L12:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "EL");
          goto _L33
_L13:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "CB");
          goto _L33
_L14:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "MX");
          goto _L33
_L15:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "DI");
          goto _L33
_L16:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "IN");
          goto _L33
_L17:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "PU");
          goto _L33
_L18:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "PT");
          goto _L33
_L20:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "TU");
          goto _L34
_L21:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "YK");
          goto _L34
_L22:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "RP");
          goto _L34
_L23:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "CH");
          goto _L34
_L24:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "SB");
          goto _L34
_L25:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "MX");
          goto _L34
_L26:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "CB");
          goto _L34
_L27:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "DI");
          goto _L34
_L28:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "CA");
          goto _L34
_L29:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "IN");
          goto _L34
_L30:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "DR");
          goto _L34
_L31:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "SH");
          goto _L34
_L32:
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_cloth", "PT");
          goto _L34
        obj;
        ((Exception) (obj)).printStackTrace();
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("played_characters", "");
          goto _L35
        obj;
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("played_characters", "");
        throw obj;
        if (true) goto _L37; else goto _L36
_L36:
    }

    y()
    {
        this$0 = AkActivity.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.externalprocessing.AkProcessing;
import com.digidust.elokence.akinator.billing.AkInappListener;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.db.AkDBAdapter;
import com.digidust.elokence.akinator.db.DefiSetAdapter;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundMusicBinder;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.digidust.elokence.akinator.webservices.AkDefiWS;
import com.elokence.analytics.AnalyticsCenter;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.tapjoy.Tapjoy;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity, StoreActivity, SplashscreenActivity, SelectLanguageActivity, 
//            StoreItemsFragment, PostHomeActivity

public class AkActivity extends Activity
    implements com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory.Listener, AkInappListener, com.digidust.elokence.akinator.db.DefiSetAdapter.Listener, com.elokence.limuleapi.SessionFactory.Listener
{
    public static interface PublishScoreListener
    {

        public abstract void onScorePublished(boolean flag);
    }


    public static final int AK_RESULT = 5;
    public static final int FROM_GAME_OVER = 1;
    public static final int FROM_HOME = 0;
    public static final int MSG_BACK_HOME = 1;
    public static final int MSG_BACK_TO_SPLASHSCREEN = 3;
    public static final int MSG_CLOSE_APPLICATION = 0;
    public static final int MSG_RESTART_GAME = 2;
    public static final String PUBLISH_PERMISSION = "publish_actions";
    public static final String PULL_PERMISSION = "user_friends";
    public static final String SHOW_AD_ON_GAMEOVER = "ShowAdOnHome";
    public static final String SHOW_AD_ON_HOME = "ShowAdOnGameOver";
    protected static final int SeuilBlanc = 0;
    protected static final int SeuilBleu = 0x15f90;
    protected static final int SeuilJaune = 3500;
    protected static final int SeuilMarron = 0x6ddd0;
    protected static final int SeuilNoir = 0xdbba0;
    protected static final int SeuilOrange = 20000;
    protected static final int SeuilRouge = 0x1e8480;
    protected static final int SeuilVert = 45000;
    protected static final int SeuilViolet = 0x23280;
    private static long _30MinInMillis = 0L;
    public static boolean initialized = false;
    protected static boolean mMusicMustBePaused = false;
    private static Timer mTimer = null;
    private static TimerTask mTimerTask = null;
    public static int nbActivities = 0;
    public static final int refreshPauseMs = 20;
    public static final int refreshRate = 50;
    protected AudioManager audio;
    protected int currentSeuil;
    AkProcessing generalProcessing;
    private ArrayList mBitmapsToRecycle;
    private int mFacesDisplayed;
    private boolean mFirstLoad;
    private int mGzDisplayed;
    protected final Handler mHandler = new Handler() {

        final AkActivity this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 0: // '\0'
                AkLog.e("Akinator", "****** CLOSE!! ******");
                BackgroundMusicBinder.sharedInstance().doUnbindService();
                BackgroundSoundsBinder.sharedInstance().doUnbindService();
                message = new Intent(AkActivity.this, com/digidust/elokence/akinator/activities/SplashscreenActivity);
                message.setFlags(0x4000000);
                message.putExtra("closeApp", true);
                startActivity(message);
                finish();
                return;

            case 1: // '\001'
                AkLog.d("Akinator", "ERREUR TECHNIQUE!! -> BACK HOME");
                mHandler.removeMessages(message.what);
                goToHome();
                return;

            case 2: // '\002'
                AkLog.d("Akinator", "MSG_RESTART_GAME");
                message = new Intent(AkActivity.this, com/digidust/elokence/akinator/activities/PostHomeActivity);
                startActivity(message);
                overridePendingTransition(0x7f04001a, 0x7f04001b);
                finish();
                return;

            case 3: // '\003'
                AkLog.d("Akinator", "MSG_BACK_TO_SPLASHSCREEN");
                break;
            }
            message = new Intent(AkActivity.this, com/digidust/elokence/akinator/activities/SplashscreenActivity);
            message.setFlags(0x4000000);
            startActivity(message);
            overridePendingTransition(0x7f04001a, 0x7f04001b);
            finish();
        }

            
            {
                this$0 = AkActivity.this;
                super();
            }
    };
    private android.view.View.OnClickListener mHomeButtonClickListener;
    protected boolean mIsRebooting;
    protected com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType mMusicType;
    protected ArrayList mTextViews;
    private HashSet publishScoreListener;
    protected Typeface tf;
    protected ImageView uiHomeButton;
    protected ImageView uiImageHat;
    protected View uiMainLayout;
    protected ProgressBar uiPbXp;
    protected TextView uiTextNbFaces;
    protected TextView uiTextScoreGz;
    protected TextView uiTextScoreXp;
    protected TextView uiTextXp;

    public AkActivity()
    {
        mIsRebooting = false;
        tf = AkApplication.getTypeFace();
        mFirstLoad = true;
        publishScoreListener = new HashSet();
        mGzDisplayed = 0;
        mFacesDisplayed = 0;
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.SHORT_MUSIC;
        generalProcessing = new AkProcessing(this);
        mHomeButtonClickListener = new android.view.View.OnClickListener() {

            final AkActivity this$0;

            public void onClick(View view)
            {
                if ((AkActivity.this instanceof StoreActivity) || (AkActivity.this instanceof PostHomeActivity))
                {
                    goToHome(false);
                    return;
                } else
                {
                    goToHome(true);
                    return;
                }
            }

            
            {
                this$0 = AkActivity.this;
                super();
            }
        };
    }

    private void sendAnalytics()
    {
        (new Thread(new Runnable() {

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
            //                           0 927
            //                           1 940
            //                           2 954
            //                           3 968
            //                           4 982;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_background", "OR");
_L37:
                AkPlayerBelongingsFactory.sharedInstance().getCurrentHatIndex();
                JVM INSTR tableswitch 0 10: default 508
            //                           0 996
            //                           1 1009
            //                           2 1023
            //                           3 1037
            //                           4 1051
            //                           5 1065
            //                           6 1079
            //                           7 1093
            //                           8 1107
            //                           9 1121
            //                           10 1135;
                   goto _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L7:
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("active_hat", "TU");
_L33:
                AkPlayerBelongingsFactory.sharedInstance().getCurrentClothIndex();
                JVM INSTR tableswitch 0 12: default 592
            //                           0 1149
            //                           1 1162
            //                           2 1176
            //                           3 1190
            //                           4 1204
            //                           5 1218
            //                           6 1232
            //                           7 1246
            //                           8 1260
            //                           9 1274
            //                           10 1288
            //                           11 1302
            //                           12 1316;
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

            
            {
                this$0 = AkActivity.this;
                super();
            }
        })).start();
    }

    private void unbindDrawables(View view)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (view.getBackground() != null)
        {
            view.getBackground().setCallback(null);
            view.setBackgroundDrawable(null);
        }
        if (view.getClass() == android/widget/ImageView)
        {
            ((ImageView)view).setImageBitmap(null);
        }
        if (!(view instanceof ViewGroup))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++)
        {
            unbindDrawables(((ViewGroup)view).getChildAt(i));
        }

        ((ViewGroup)view).removeAllViews();
        return;
        view;
    }

    public void addBitmapToRecycle(Bitmap bitmap)
    {
        mBitmapsToRecycle.add(bitmap);
    }

    public void addPublishListener(PublishScoreListener publishscorelistener)
    {
        synchronized (publishScoreListener)
        {
            publishScoreListener.add(publishscorelistener);
        }
        return;
        publishscorelistener;
        hashset;
        JVM INSTR monitorexit ;
        throw publishscorelistener;
    }

    public void addTextView(TextView textview)
    {
        mTextViews.add(textview);
    }

    public void disableAdOneTime()
    {
        generalProcessing.disableAdOneTime();
    }

    protected Intent findTwitterClient()
    {
        String as[] = new String[4];
        as[0] = "com.twitter.android";
        as[1] = "com.twidroid";
        as[2] = "com.handmark.tweetcaster";
        as[3] = "com.thedeck.android";
        Intent intent = new Intent();
        intent.setType("text/plain");
        List list = getPackageManager().queryIntentActivities(intent, 0x10000);
        int i = 0;
        do
        {
            if (i >= as.length)
            {
                break;
            }
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                String s = ((ResolveInfo)iterator.next()).activityInfo.packageName;
                if (s != null && s.startsWith(as[i]))
                {
                    intent.setPackage(s);
                    return intent;
                }
            }

            i++;
        } while (true);
        return null;
    }

    public String getApplicationUrlOnMarket()
    {
        return (new StringBuilder()).append("https://market.android.com/details?id=").append(getPackageName()).toString();
    }

    public int getScreenHeight()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    public int getScreenWidth()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    protected void goToHome()
    {
        goToHome(true);
    }

    public void goToHome(boolean flag)
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        generalProcessing.processGoToHome();
        Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/HomeActivity);
        intent.setFlags(0x4000000);
        if (!flag)
        {
            intent.putExtra("ShowAdOnGameOver", false);
        }
        (new AsyncTask() {

            final AkActivity this$0;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(SessionFactory.sharedInstance().cancelSession());
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            
            {
                this$0 = AkActivity.this;
                super();
            }
        }).execute(new Void[0]);
        startActivity(intent);
        overridePendingTransition(0x7f04001a, 0x7f04001b);
        finish();
    }

    protected void goToStore()
    {
        Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/StoreActivity);
        if (AkConfigFactory.sharedInstance().isFreemium())
        {
            intent.putExtra("TabToDisplay", 0);
        } else
        {
            intent.putExtra("TabToDisplay", 1);
        }
        intent.putExtra("displayOtherTabs", true);
        intent.putExtra("STORE_FOR_RESULT", false);
        startActivity(intent);
        finish();
    }

    protected void goToStoreFaces()
    {
        goToStoreFaces(false);
    }

    protected void goToStoreFaces(boolean flag)
    {
        Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/StoreActivity);
        intent.putExtra("TabToDisplay", 2);
        intent.putExtra("displayOtherTabs", false);
        startActivity(intent);
        finish();
    }

    protected void goToStoreItems()
    {
        Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/StoreActivity);
        intent.putExtra("TabToDisplay", 1);
        intent.putExtra("displayOtherTabs", false);
        startActivity(intent);
        finish();
    }

    protected boolean isANewVersionExists()
    {
        boolean flag1 = false;
        float f;
        float f1;
        Float float1;
        Object obj;
        boolean flag;
        try
        {
            float1 = new Float(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            obj = AkSessionFactory.sharedInstance().getVersionRequired();
            AkConfigFactory.sharedInstance().setLastVersion(((String) (obj)));
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        catch (NumberFormatException numberformatexception)
        {
            return false;
        }
        flag = flag1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        obj = new Float(((String) (obj)));
        AkLog.i("Akinator", (new StringBuilder()).append("VERSION ACTUELLE : ").append(float1).append(" VERSION REQUISE : ").append(obj).toString());
        f = float1.floatValue();
        f1 = ((Float) (obj)).floatValue();
        flag = flag1;
        if (f < f1)
        {
            flag = true;
        }
        return flag;
    }

    public boolean isTablet()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i = (int)((double)((float)displaymetrics.widthPixels / displaymetrics.xdpi) * 160D);
        AkLog.d("AkIsTablet", (new StringBuilder()).append("widthP = ").append(displaymetrics.widthPixels).toString());
        AkLog.d("AkIsTablet", (new StringBuilder()).append("Xdpi = ").append(displaymetrics.xdpi).toString());
        AkLog.d("AkIsTablet", (new StringBuilder()).append("X sze = ").append(i).toString());
        return i >= 728;
    }

    public void itemPurchased(String s)
    {
    }

    public void onAllPurchasesRestored()
    {
        if (AkConfigFactory.sharedInstance().canDisplayRestoreOk())
        {
            AkConfigFactory.sharedInstance().displayRestoreOk(false);
            runOnUiThread(new Runnable() {

                final AkActivity this$0;

                public void run()
                {
                    Toast.makeText(getApplicationContext(), TraductionFactory.sharedInstance().getTraductionFromToken("RESTAURATION_ACHATS_EFFECTUEE"), 1).show();
                }

            
            {
                this$0 = AkActivity.this;
                super();
            }
            });
        }
        boolean flag = AkConfigFactory.sharedInstance().isPrio();
        SessionFactory.sharedInstance().setMediaFootprint(AkConfigFactory.sharedInstance().getMediaFootprint());
        SessionFactory.sharedInstance().setMediaId(Integer.parseInt(AkConfigFactory.sharedInstance().getMediaId()));
        SessionFactory.sharedInstance().setPartnerId(AkConfigFactory.sharedInstance().getPartnerId(isTablet()));
        SessionFactory.sharedInstance().setPrio(flag);
    }

    public void onAwardAwarded(int i)
    {
    }

    public void onBackPressed()
    {
        AkGameFactory.sharedInstance().setCanShowAd(false);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        AkLog.d("SplashscreenActivity", (new StringBuilder()).append("").append(this).toString());
        if (!(this instanceof SplashscreenActivity) && !initialized)
        {
            initialized = true;
            mIsRebooting = true;
            AkLog.d("SplashscreenActivity", "must restart app");
            bundle = new Intent(this, com/digidust/elokence/akinator/activities/SplashscreenActivity);
            bundle.setFlags(0x4000000);
            startActivity(bundle);
            finish();
        }
        initialized = true;
        mBitmapsToRecycle = new ArrayList();
        mTextViews = new ArrayList();
        audio = (AudioManager)getSystemService("audio");
        generalProcessing.processOnCreate();
    }

    public void onDefiDuJourModified()
    {
        if (!(this instanceof SplashscreenActivity) && !(this instanceof SelectLanguageActivity))
        {
            final com.digidust.elokence.akinator.db.DefiSetAdapter.DefiInfos infos = DefiSetAdapter.sharedInstance().getDefiDuJourInfos();
            if (infos != null)
            {
                runOnUiThread(new Runnable() {

                    final AkActivity this$0;
                    final com.digidust.elokence.akinator.db.DefiSetAdapter.DefiInfos val$infos;

                    public void run()
                    {
                        View view = getLayoutInflater().inflate(0x7f03004f, null);
                        Object obj = (TextView)view.findViewById(0x7f0d021d);
                        ((TextView) (obj)).setTypeface(AkApplication.getTypeFace());
                        ((TextView) (obj)).setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TITRE"));
                        obj = (TextView)view.findViewById(0x7f0d00cf);
                        ((TextView) (obj)).setTypeface(AkApplication.getTypeFace());
                        ((TextView) (obj)).setText(infos.getTitle());
                        obj = new Toast(getApplicationContext());
                        ((Toast) (obj)).setGravity(49, 0, 0);
                        ((Toast) (obj)).setDuration(1);
                        ((Toast) (obj)).setView(view);
                        ((Toast) (obj)).show();
                    }

            
            {
                this$0 = AkActivity.this;
                infos = defiinfos;
                super();
            }
                });
            }
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mIsRebooting)
        {
            return;
        } else
        {
            recycleBitmaps();
            unbindDrawables(getWindow().getDecorView().getRootView());
            System.gc();
            return;
        }
    }

    public void onFacesAwarded(int i)
    {
        runOnUiThread(new Runnable() {

            final AkActivity this$0;

            public void run()
            {
                if (uiTextNbFaces != null)
                {
                    uiTextNbFaces.setText(NumberFormat.getInstance().format(mFacesDisplayed = AkPlayerBelongingsFactory.sharedInstance().getFacesBalance()));
                }
            }

            
            {
                this$0 = AkActivity.this;
                super();
            }
        });
    }

    public void onGenizAwarded(final int amountGz)
    {
        runOnUiThread(new Runnable() {

            final AkActivity this$0;
            final int val$amountGz;

            public void run()
            {
            /* block-local class not found */
            class _cls1 {}

                if (uiTextScoreGz != null)
                {
                    (new Thread(new _cls1(new Handler()))).start();
                }
            }

            
            {
                this$0 = AkActivity.this;
                amountGz = i;
                super();
            }
        });
    }

    public void onInitialization(boolean flag)
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return super.onKeyDown(i, keyevent);

        case 24: // '\030'
            audio.adjustStreamVolume(3, 1, 1);
            return true;

        case 25: // '\031'
            audio.adjustStreamVolume(3, -1, 1);
            break;
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return true;
    }

    protected void onPause()
    {
        nbActivities--;
        if (!mIsRebooting)
        {
            SessionFactory.sharedInstance().onActivityPause();
            DefiSetAdapter.sharedInstance().removeListener(this);
            AkPlayerBelongingsFactory.sharedInstance().removeListener(this);
            AkInappManager.getInstance().removeListener(this);
            long l = Calendar.getInstance().getTimeInMillis();
            AkSessionFactory.sharedInstance().setTimeOfLastScreenOnPause(l);
            generalProcessing.processOnPause();
        }
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        AkLog.i("Akinator", "CALL CREATE OPTIONS MENU");
        menu.clear();
        return true;
    }

    protected void onResume()
    {
        nbActivities++;
        if (!mIsRebooting)
        {
            SessionFactory.sharedInstance().onActivityResume();
            AkConfigFactory.sharedInstance().setCanSendAnalytics(true);
            DefiSetAdapter.sharedInstance().addListener(this);
            if (!(this instanceof SplashscreenActivity) && mTimer == null)
            {
                (new Thread() {

                    final AkActivity this$0;

                    public void run()
                    {
                        (new AkDefiWS()).call();
                    }

            
            {
                this$0 = AkActivity.this;
                super();
            }
                }).start();
                if (!AkSessionFactory.sharedInstance().areAnalyticsSendLastTime())
                {
                    AkLog.d("analytics", "need to send analytics because not send last time");
                    sendAnalytics();
                } else
                {
                    AkLog.d("analytics", "no need to send analytics");
                    AkSessionFactory.sharedInstance().setAnalyticsSend(false);
                }
                mTimer = new Timer();
                mTimerTask = new TimerTask() {

                    private int counterInactivity;
                    final AkActivity this$0;

                    public void run()
                    {
                        if (AkActivity.nbActivities == 0)
                        {
                            counterInactivity = counterInactivity + 1;
                        } else
                        {
                            counterInactivity = 0;
                        }
                        if (AkConfigFactory.sharedInstance().canSendAnalytics() && counterInactivity >= 2)
                        {
                            AkLog.d("Akinator", "Send Push");
                            AkActivity.mTimer.cancel();
                            AkActivity.mTimer = null;
                            cancel();
                            sendAnalytics();
                        }
                    }

            
            {
                this$0 = AkActivity.this;
                super();
                counterInactivity = 0;
            }
                };
                mTimer.scheduleAtFixedRate(mTimerTask, 2000L, 1000L);
            }
        }
        super.onResume();
        if (!mIsRebooting) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l;
        Calendar calendar1;
        long l2;
label0:
        {
            String s;
            int i;
            int i1;
            long l1;
label1:
            {
                calendar1 = Calendar.getInstance();
                l1 = calendar1.getTimeInMillis();
                l2 = AkSessionFactory.sharedInstance().getTimeOfLastScreenOnPause();
                if (l2 == 0x7fffffffffffffffL)
                {
                    AkSessionFactory.sharedInstance().setTimeOfCurrentSessionStart(l1);
                }
                if (l2 == 0x7fffffffffffffffL || l1 < _30MinInMillis + l2)
                {
                    break label0;
                }
                i = (int)((l2 - AkSessionFactory.sharedInstance().getTimeOfCurrentSessionStart()) / 1000L);
                String s1 = MetricsSetAdapter.sharedInstance().getMetricValeur("delai_session");
                i1 = MetricsSetAdapter.sharedInstance().getMetricCompteur("nb_sessions");
                if (s1 != null)
                {
                    s = s1;
                    if (!s1.equals(""))
                    {
                        break label1;
                    }
                }
                s = "0";
            }
            float f = Integer.parseInt(s) * i1;
            int j1 = (int)(((float)i + f) / (float)(MetricsSetAdapter.sharedInstance().getMetricCompteur("nb_sessions") + 1));
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("delai_session", String.valueOf(j1));
            AkSessionFactory.sharedInstance().setTimeOfCurrentSessionStart(l1);
            AkSessionFactory.sharedInstance().setTimeOfLastScreenOnPause(-1L);
            if (i1 == 0)
            {
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("delai_session_1", String.valueOf(i));
            }
            MetricsSetAdapter.sharedInstance().incMetricCompteur("nb_sessions");
        }
        if (l2 != 0x7fffffffffffffffL)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(l2);
            if (calendar.get(6) != calendar1.get(6))
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("nb_jours");
            }
        }
        AkPlayerBelongingsFactory.sharedInstance().addListener(this);
        AkInappManager.getInstance().addListener(this);
        if (mMusicType != com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.NO_CHANGE)
        {
            BackgroundMusicBinder.sharedInstance(mMusicType).startMusic(mMusicType);
        }
        if (mFirstLoad)
        {
            mFirstLoad = false;
            uiHomeButton = (ImageView)findViewById(0x7f0d028b);
            if (uiHomeButton != null)
            {
                uiHomeButton.setOnClickListener(mHomeButtonClickListener);
            }
            uiTextScoreGz = (TextView)findViewById(0x7f0d0289);
            if (uiTextScoreGz != null)
            {
                uiTextScoreGz.setTypeface(tf);
                addTextView(uiTextScoreGz);
                TextView textview = uiTextScoreGz;
                NumberFormat numberformat = NumberFormat.getInstance();
                int j = AkPlayerBelongingsFactory.sharedInstance().getGenizBalance();
                mGzDisplayed = j;
                textview.setText(numberformat.format(j));
            }
            uiTextNbFaces = (TextView)findViewById(0x7f0d0287);
            if (uiTextNbFaces != null)
            {
                uiTextNbFaces.setTypeface(tf);
                addTextView(uiTextNbFaces);
                TextView textview1 = uiTextNbFaces;
                NumberFormat numberformat1 = NumberFormat.getInstance();
                int k = AkPlayerBelongingsFactory.sharedInstance().getFacesBalance();
                mFacesDisplayed = k;
                textview1.setText(numberformat1.format(k));
            }
            uiTextScoreXp = (TextView)findViewById(0x7f0d00af);
            uiPbXp = (ProgressBar)findViewById(0x7f0d00b3);
            uiImageHat = (ImageView)findViewById(0x7f0d00b1);
            uiTextXp = (TextView)findViewById(0x7f0d00b0);
            if (uiTextScoreXp != null && uiPbXp != null && uiImageHat != null && uiTextXp != null)
            {
                uiTextScoreXp.setTypeface(tf);
                uiTextXp.setTypeface(tf);
                uiTextXp.setText(TraductionFactory.sharedInstance().getTraductionFromToken("POINT_EXPERIENCE"));
                uiTextScoreXp.setText(NumberFormat.getInstance().format(AkPlayerBelongingsFactory.sharedInstance().getXp()));
                addTextView(uiTextScoreXp);
                addTextView(uiTextXp);
            }
            updateTextViewsSize();
        }
        if (uiTextScoreGz != null)
        {
            l = AkPlayerBelongingsFactory.sharedInstance().getGenizBalance();
            android.app.AlertDialog.Builder builder;
            if (mGzDisplayed != l)
            {
                onGenizAwarded(l - mGzDisplayed);
            } else
            {
                uiTextScoreGz.setText(NumberFormat.getInstance().format(mGzDisplayed));
            }
        }
        if (uiTextNbFaces != null)
        {
            l = AkPlayerBelongingsFactory.sharedInstance().getFacesBalance();
            if (mFacesDisplayed != l)
            {
                onFacesAwarded(l - mFacesDisplayed);
            } else
            {
                uiTextNbFaces.setText(NumberFormat.getInstance().format(AkPlayerBelongingsFactory.sharedInstance().getFacesBalance()));
            }
        }
        if (uiTextScoreXp != null && uiPbXp != null && uiImageHat != null && uiTextXp != null)
        {
            l = AkPlayerBelongingsFactory.sharedInstance().getXp();
            uiTextScoreXp.setText(NumberFormat.getInstance().format(l));
            if (l >= 3500)
            {
                break; /* Loop/switch isn't completed */
            }
            uiImageHat.setImageResource(0x7f020284);
            uiPbXp.setMax(3500);
            uiPbXp.setProgress(l);
            currentSeuil = 0;
        }
_L4:
        generalProcessing.processOnResume();
        l = AkPlayerBelongingsFactory.sharedInstance().getAlertGz();
        if (l > 0)
        {
            builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("BRAVO_TU_AS_GAGNE_GENIZ").replace("[NB_GENIZ]", (new StringBuilder()).append("").append(l).toString()));
            builder.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                final AkActivity this$0;

                public void onClick(DialogInterface dialoginterface, int k1)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = AkActivity.this;
                super();
            }
            });
            builder.create().show();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (l >= 3500 && l < 20000)
        {
            uiImageHat.setImageResource(0x7f02028c);
            uiPbXp.setMax(16500);
            uiPbXp.setProgress(l - 3500);
            currentSeuil = 3500;
        } else
        if (l >= 20000 && l < 45000)
        {
            uiImageHat.setImageResource(0x7f020298);
            uiPbXp.setMax(25000);
            uiPbXp.setProgress(l - 20000);
            currentSeuil = 20000;
        } else
        if (l >= 45000 && l < 0x15f90)
        {
            uiImageHat.setImageResource(0x7f0202a0);
            uiPbXp.setMax(45000);
            uiPbXp.setProgress(l - 45000);
            currentSeuil = 45000;
        } else
        if (l >= 0x15f90 && l < 0x23280)
        {
            uiImageHat.setImageResource(0x7f020288);
            uiPbXp.setMax(54000);
            uiPbXp.setProgress(l - 0x15f90);
            currentSeuil = 0x15f90;
        } else
        if (l >= 0x23280 && l < 0x6ddd0)
        {
            uiImageHat.setImageResource(0x7f0202a4);
            uiPbXp.setMax(0x4ab50);
            uiPbXp.setProgress(l - 0x23280);
            currentSeuil = 0x23280;
        } else
        if (l >= 0x6ddd0 && l < 0xdbba0)
        {
            uiImageHat.setImageResource(0x7f020290);
            uiPbXp.setMax(0x6ddd0);
            uiPbXp.setProgress(l - 0x6ddd0);
            currentSeuil = 0x6ddd0;
        } else
        if (l >= 0xdbba0 && l < 0x1e8480)
        {
            uiImageHat.setImageResource(0x7f020294);
            uiPbXp.setMax(0x10c8e0);
            uiPbXp.setProgress(l - 0xdbba0);
            currentSeuil = 0xdbba0;
        } else
        if (l >= 0x1e8480)
        {
            uiImageHat.setImageResource(0x7f02029c);
            uiPbXp.setMax(1);
            uiPbXp.setProgress(1);
            currentSeuil = 0x1e8480;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onStart()
    {
        super.onStart();
        try
        {
            Tapjoy.onActivityStart(this);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected void onStop()
    {
        try
        {
            Tapjoy.onActivityStop(this);
        }
        catch (Exception exception) { }
        super.onStop();
    }

    public void onWebServiceReload(int i)
    {
        if (i != 500) goto _L2; else goto _L1
_L1:
        AkConfigFactory.sharedInstance().setCanPlay(-1);
_L4:
        AkConfigFactory.sharedInstance().setCanPlay(1);
        return;
_L2:
        if (i == 510)
        {
            AkConfigFactory.sharedInstance().setCanPlay(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onXpAwarded(final int XpAdded)
    {
        if (uiTextScoreXp != null)
        {
            (new Thread(new Runnable() {

                private int mStartXp;
                private int mTotalXp;
                final AkActivity this$0;
                private final long tranche;
                final int val$XpAdded;
                final Handler val$handlerXp;

                public void run()
                {
                    while (mStartXp < mTotalXp) 
                    {
                /* block-local class not found */
                class _cls1 {}

                        try
                        {
                            Thread.sleep(20L);
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            interruptedexception.printStackTrace();
                        }
                        handlerXp.post(new _cls1());
                        mStartXp = (int)((long)mStartXp + tranche);
                    }
                /* block-local class not found */
                class _cls2 {}

                    handlerXp.post(new _cls2());
                }



            
            {
                this$0 = AkActivity.this;
                XpAdded = i;
                handlerXp = handler;
                super();
                mTotalXp = AkPlayerBelongingsFactory.sharedInstance().getXp();
                mStartXp = mTotalXp - XpAdded;
                tranche = (mTotalXp - mStartXp) / 50;
            }
            })).start();
        }
    }

    protected void recycleBitmaps()
    {
        for (int i = 0; i < mBitmapsToRecycle.size(); i++)
        {
            Bitmap bitmap = (Bitmap)mBitmapsToRecycle.get(i);
            if (bitmap != null && !bitmap.isRecycled())
            {
                bitmap.recycle();
            }
        }

        mBitmapsToRecycle.clear();
    }

    public void removePublishListener(PublishScoreListener publishscorelistener)
    {
        synchronized (publishScoreListener)
        {
            publishScoreListener.remove(publishscorelistener);
        }
        return;
        publishscorelistener;
        hashset;
        JVM INSTR monitorexit ;
        throw publishscorelistener;
    }

    protected Bitmap screenShot()
    {
        return screenShot(getWindow().getDecorView().getRootView());
    }

    protected Bitmap screenShot(View view)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap1));
        Bitmap bitmap = bitmap1;
        if (view.getMeasuredHeight() > 1024)
        {
            double d = 1024D / (double)view.getMeasuredHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap1, (int)((double)view.getMeasuredWidth() * d), 1024, false);
        }
        return bitmap;
    }

    protected void sendMyScore()
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("score", AkPlayerBelongingsFactory.sharedInstance().getXp());
            GraphRequest.newPostRequest(AccessToken.getCurrentAccessToken(), "/me/scores", jsonobject, new com.facebook.GraphRequest.Callback() {

                final AkActivity this$0;

                public void onCompleted(GraphResponse graphresponse)
                {
                    graphresponse = graphresponse.getError();
                    if (graphresponse != null)
                    {
                        Log.e("AkActivity", graphresponse.toString());
                        signalScorePublished(false);
                        return;
                    } else
                    {
                        AkLog.d("AkActivity", "sendMyScore Ok !");
                        signalScorePublished(true);
                        return;
                    }
                }

            
            {
                this$0 = AkActivity.this;
                super();
            }
            }).executeAsync();
            return;
        }
        catch (JSONException jsonexception)
        {
            AkLog.d("akActivity", (new StringBuilder()).append("sendMyScore error : ").append(jsonexception.toString()).toString());
        }
        signalScorePublished(false);
    }

    protected boolean setBackgroundImage(int i, Bitmap bitmap, Bitmap bitmap1)
    {
        uiMainLayout = findViewById(i);
        if (uiMainLayout == null) goto _L2; else goto _L1
_L1:
        ImageView imageview;
        addBitmapToRecycle(bitmap);
        double d = (double)bitmap.getHeight() / (double)bitmap.getWidth();
        int k = getScreenWidth();
        int j = k;
        if (bitmap.getHeight() - getScreenHeight() < 0)
        {
            j = k + (getScreenHeight() - bitmap.getHeight());
        }
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(j, (int)((double)j * d));
        imageview = new ImageView(this);
        imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        imageview.setLayoutParams(layoutparams);
        imageview.setImageBitmap(bitmap);
        if (bitmap1 == null) goto _L4; else goto _L3
_L3:
        addBitmapToRecycle(bitmap1);
        android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(getScreenWidth(), getScreenHeight());
        bitmap = new ImageView(this);
        bitmap.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        bitmap.setLayoutParams(layoutparams1);
        bitmap.setImageBitmap(bitmap1);
        bitmap1 = (RelativeLayout)findViewById(i);
        if (bitmap1 != null)
        {
            bitmap1.addView(imageview, 0);
            bitmap1.addView(bitmap, 1);
        }
_L5:
        return true;
_L4:
        bitmap = (RelativeLayout)findViewById(i);
        if (bitmap != null)
        {
            bitmap.addView(imageview, 0);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    protected boolean setBackgroundImage(int i, Bitmap bitmap, boolean flag)
    {
        Bitmap bitmap1 = null;
        if (false)
        {
            try
            {
                bitmap1 = BitmapFactory.decodeStream(new BufferedInputStream(getResources().getAssets().open("drawable/ak_cadre.png"), 32768));
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                AkLog.e("Akinator", "Impossible de charger l'image ak_cadre");
                return false;
            }
        }
        return setBackgroundImage(i, bitmap, bitmap1);
    }

    protected boolean setBackgroundImage(int i, String s)
    {
        uiMainLayout = findViewById(i);
        if (uiMainLayout == null)
        {
            return false;
        }
        Bitmap bitmap = null;
        Object obj = null;
        if (uiMainLayout != null)
        {
            try
            {
                obj = getResources().getAssets();
                bitmap = BitmapFactory.decodeStream(new BufferedInputStream(((AssetManager) (obj)).open((new StringBuilder()).append("drawable/").append(s).append(".png").toString()), 32768));
                obj = BitmapFactory.decodeStream(new BufferedInputStream(((AssetManager) (obj)).open("drawable/ak_cadre.png"), 32768));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
                return false;
            }
            catch (IOException ioexception)
            {
                AkLog.e("Akinator", (new StringBuilder()).append("Impossible de charger l'image ").append(s).toString());
                return false;
            }
        }
        return setBackgroundImage(i, bitmap, ((Bitmap) (obj)));
    }

    protected boolean setImage(int i, Bitmap bitmap)
    {
        ImageView imageview = (ImageView)findViewById(i);
        if (imageview != null)
        {
            Object obj = imageview.getDrawable();
            if (obj instanceof BitmapDrawable)
            {
                obj = ((BitmapDrawable)obj).getBitmap();
                mBitmapsToRecycle.remove(obj);
                try
                {
                    ((Bitmap) (obj)).recycle();
                    AkLog.d("Akinator", "Nettoyage d'une bitmap");
                }
                catch (Exception exception) { }
            }
            try
            {
                addBitmapToRecycle(bitmap);
                imageview.setImageBitmap(bitmap);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
                return false;
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean setImage(int i, String s)
    {
        if ((ImageView)findViewById(i) == null)
        {
            return false;
        }
        Bitmap bitmap;
        try
        {
            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(getResources().getAssets().open((new StringBuilder()).append("drawable/").append(s).append(".png").toString()), 32768));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
            return false;
        }
        catch (IOException ioexception)
        {
            AkLog.e("Akinator", (new StringBuilder()).append("Impossible de charger l'image ").append(s).toString());
            return false;
        }
        return setImage(i, bitmap);
    }

    protected void signalScorePublished(boolean flag)
    {
        HashSet hashset = publishScoreListener;
        hashset;
        JVM INSTR monitorenter ;
        for (Iterator iterator = publishScoreListener.iterator(); iterator.hasNext(); ((PublishScoreListener)iterator.next()).onScorePublished(flag)) { }
        break MISSING_BLOCK_LABEL_47;
        Exception exception;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
        AkSessionFactory.sharedInstance().setMustPublishScore(false);
        return;
    }

    public void skuDetailsUpdated()
    {
    }

    public void updateTextViewsSize()
    {
        TextView textview;
        for (Iterator iterator = mTextViews.iterator(); iterator.hasNext(); textview.setTextSize(0, textview.getTextSize() * AkApplication.getCoeffFont()))
        {
            textview = (TextView)iterator.next();
        }

        mTextViews.clear();
    }

    static 
    {
        initialized = false;
        _30MinInMillis = 0x1b7740L;
        mMusicMustBePaused = false;
        nbActivities = 0;
    }



/*
    static Timer access$002(Timer timer)
    {
        mTimer = timer;
        return timer;
    }

*/



/*
    static int access$402(AkActivity akactivity, int i)
    {
        akactivity.mGzDisplayed = i;
        return i;
    }

*/


/*
    static int access$502(AkActivity akactivity, int i)
    {
        akactivity.mFacesDisplayed = i;
        return i;
    }

*/
}

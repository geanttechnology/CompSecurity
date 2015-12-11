// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.externalprocessing.HomeProcessing;
import com.digidust.elokence.akinator.activities.transitions.HomeTransition;
import com.digidust.elokence.akinator.backup.AkBackupManager;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundMusicBinder;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.digidust.elokence.akinator.webservices.AkHomeBannerWS;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.MinibaseListener;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.widget.AppInviteDialog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, PostHomeActivity, SelectLanguageActivity, WebviewCGV, 
//            SplashscreenActivity, AwardsActivity, MinibaseActivity, LeaderboardActivity, 
//            FacebookConnexionActivity

public class HomeActivity extends AkActivity
    implements android.view.View.OnClickListener, MinibaseListener
{
    private class AsynchronousOneFlagLoader extends AsyncTask
    {

        String mFlagUrl;
        ImageView mImageView;
        final HomeActivity this$0;

        protected transient Bitmap doInBackground(Void avoid[])
        {
            return downloadFlag(mFlagUrl);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public Bitmap downloadFlag(String s)
        {
            try
            {
                s = (HttpURLConnection)(new URL(s)).openConnection();
                s.setDoInput(true);
                s.connect();
                s = BitmapFactory.decodeStream(s.getInputStream());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
            return s;
        }

        protected void onPostExecute(Bitmap bitmap)
        {
            try
            {
                mImageView.setImageBitmap(bitmap);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Bitmap)obj);
        }

        public AsynchronousOneFlagLoader(String s, ImageView imageview)
        {
            this$0 = HomeActivity.this;
            super();
            mFlagUrl = s;
            mImageView = imageview;
        }
    }


    private static final String TAG = "HomeActivity";
    private boolean adShown;
    private ImageView buttonOpenSlide;
    private CallbackManager callbackManager;
    private DrawerLayout drawerLayout;
    private ImageView imageTrapYourFriends;
    private RelativeLayout layoutFacebook;
    private RelativeLayout layoutTwitter;
    android.view.View.OnClickListener mAccessoriesClickListener;
    android.view.View.OnClickListener mCloseBannerButtonClickListener;
    android.view.View.OnClickListener mFacebookClassementListener;
    private ArrayList mListViewSlideToDisplayInDarkGreyOrLightGrey1;
    private ArrayList mListViewSlideToDisplayInDarkGreyOrLightGrey2;
    android.view.View.OnClickListener mMyWorldClickListener;
    android.view.View.OnClickListener mOpenBannerButtonClickListener;
    android.view.View.OnClickListener mPlayButtonClickListener;
    android.view.View.OnClickListener mRankingButtonClickListener;
    android.view.View.OnClickListener mStoreButtonListener;
    android.view.View.OnClickListener mTextBannerClickListener;
    private HomeProcessing processing;
    private HomeTransition transition;
    private ImageView uiAkinatorTete;
    private ImageView uiCloseBanner;
    private TextView uiFacebook;
    private Button uiFacebookClassement;
    private TextView uiFlag;
    private TextView uiLanguage;
    private RelativeLayout uiLayoutChildProtection;
    private RelativeLayout uiLayoutLanguage;
    private RelativeLayout uiLayoutTrapYourFriends;
    private Button uiMusicButton;
    private Button uiMyWorldButton;
    private TextView uiNoteApp;
    private ImageView uiOpenBannerButton;
    private LinearLayout uiOverlayBanner;
    private Button uiPartageButton;
    private Button uiPlayButton;
    private Button uiRankingButtonImage;
    private TextView uiRecommander;
    private Button uiSoundButton;
    private TextView uiTextCGU;
    private TextView uiTextCharactersPictures;
    private TextView uiTextChildProtection;
    private ImageView uiTextChildProtectionImage;
    private TextView uiTextChoixBase;
    private TextView uiTextInBanner;
    private TextView uiTextPrivacy;
    private TextView uiTextRestorePurchases;
    private TextView uiTextTrapYourFriends;
    private TextView uiTwitter;

    public HomeActivity()
    {
        adShown = false;
        processing = new HomeProcessing(this);
        transition = new HomeTransition(this);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1 = new ArrayList();
        mListViewSlideToDisplayInDarkGreyOrLightGrey2 = new ArrayList();
        mPlayButtonClickListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                adShown = true;
                goToPostHome();
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        mRankingButtonClickListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                disableAdOneTime();
                view = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/AwardsActivity);
                startActivity(view);
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        mMyWorldClickListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                view = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/MinibaseActivity);
                AkGameFactory.sharedInstance().setComeFrom(0);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        mFacebookClassementListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                AkGameFactory.sharedInstance().setComeFrom(0);
                if (AccessToken.getCurrentAccessToken() != null)
                {
                    boolean flag = AccessToken.getCurrentAccessToken().getPermissions().contains("user_friends");
                    boolean flag1 = AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions");
                    if (flag && flag1)
                    {
                        view = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/LeaderboardActivity);
                        startActivity(view);
                        finish();
                    }
                }
                view = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/FacebookConnexionActivity);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        mOpenBannerButtonClickListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                uiOverlayBanner.setVisibility(0);
                uiOpenBannerButton.setVisibility(8);
                AkConfigFactory.sharedInstance().setHomeBannerOpened(true);
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        mCloseBannerButtonClickListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                uiOverlayBanner.setVisibility(8);
                uiOpenBannerButton.setVisibility(0);
                AkConfigFactory.sharedInstance().setHomeBannerOpened(false);
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        mTextBannerClickListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    view = new Intent("android.intent.action.VIEW", Uri.parse(AkGameFactory.sharedInstance().getHomeBannerUrl()));
                    startActivity(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        mAccessoriesClickListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (!AkConfigFactory.sharedInstance().isFreemium())
                {
                    if (AkConfigFactory.sharedInstance().isPaid())
                    {
                        goToStore();
                        MetricsSetAdapter.sharedInstance().incMetricCompteur("shop_click");
                    }
                    return;
                } else
                {
                    goToStoreItems();
                    return;
                }
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        mStoreButtonListener = new android.view.View.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                goToStore();
                MetricsSetAdapter.sharedInstance().incMetricCompteur("shop_click");
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
    }

    public static Intent getOpenFacebookIntent(Context context)
    {
        try
        {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            context = new Intent("android.intent.action.VIEW", Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/Akinator"));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/Akinator"));
        }
        return context;
    }

    private void updateHomeBannerGraphicConf()
    {
        if (AkConfigFactory.sharedInstance().isHomeBannerAvailable())
        {
            uiTextInBanner.setText(AkGameFactory.sharedInstance().getHomeBannerText());
            if (AkConfigFactory.sharedInstance().isHomeBannerOpened())
            {
                uiOverlayBanner.setVisibility(0);
                uiOpenBannerButton.setVisibility(8);
                return;
            } else
            {
                uiOverlayBanner.setVisibility(8);
                uiOpenBannerButton.setVisibility(0);
                return;
            }
        } else
        {
            uiOverlayBanner.setVisibility(8);
            uiOpenBannerButton.setVisibility(8);
            return;
        }
    }

    public void contentChanged()
    {
    }

    public void errorLoading(int i)
    {
        AkLog.d("HomeActivity", "LoadMinibase Error");
        runOnUiThread(new Runnable() {

            final HomeActivity this$0;

            public void run()
            {
                uiMyWorldButton.setBackgroundResource(0x7f0200fe);
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        });
    }

    public void goToPostHome()
    {
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/PostHomeActivity));
        finish();
    }

    public void isLoading()
    {
        AkLog.d("HomeActivity", "LoadMinibase Loading");
        runOnUiThread(new Runnable() {

            final HomeActivity this$0;

            public void run()
            {
                uiMyWorldButton.setBackgroundResource(0x7f0200ff);
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        });
    }

    public void itemPurchased(String s)
    {
        AkLog.d("HomeActivity", (new StringBuilder()).append("Item purchased : ").append(s).toString());
        if ((s.equals(AkInappManager.getInstance().getSkuInappUltime()) || s.equals(AkInappManager.getInstance().getSkuInappPopu())) && AkConfigFactory.sharedInstance().canPlay() == 0 && AkConfigFactory.sharedInstance().canCheckFull())
        {
            s = new android.app.AlertDialog.Builder(this);
            s.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_FULL_ACHETE"));
            android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                final HomeActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Message();
                    dialoginterface.what = 0;
                    mHandler.sendMessage(dialoginterface);
                }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
            };
            s.setCancelable(false);
            s.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), onclicklistener);
            s.create().show();
        }
    }

    public void loadingComplete()
    {
        AkLog.d("HomeActivity", "LoadMinibase Complete");
        runOnUiThread(new Runnable() {

            final HomeActivity this$0;

            public void run()
            {
                uiMyWorldButton.setBackgroundResource(0x7f020100);
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        });
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        callbackManager.onActivityResult(i, j, intent);
    }

    public void onAllPurchasesRestored()
    {
        super.onAllPurchasesRestored();
    }

    public void onBackPressed()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ETES_VOUS_SUR_DE_VOULOIR_QUITTER"));
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -1)
                {
                    BackgroundMusicBinder.sharedInstance().doUnbindService();
                    BackgroundSoundsBinder.sharedInstance().doUnbindService();
                    dialoginterface = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/SplashscreenActivity);
                    dialoginterface.setFlags(0x4000000);
                    dialoginterface.putExtra("closeApp", true);
                    startActivity(dialoginterface);
                    finish();
                } else
                if (i == -2)
                {
                    dialoginterface.dismiss();
                    return;
                }
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"), onclicklistener);
        builder.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON"), onclicklistener);
        builder.create().show();
    }

    public void onClick(View view)
    {
        if (view != buttonOpenSlide) goto _L2; else goto _L1
_L1:
        drawerLayout.openDrawer(0x800003);
_L4:
        return;
_L2:
        if (view == uiMusicButton)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            boolean flag;
            if (!AkConfigFactory.sharedInstance().isMusicEnabled())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            AkConfigFactory.sharedInstance().setMusicEnabled(flag);
            if (flag)
            {
                BackgroundMusicBinder.sharedInstance().resumeMusic();
            } else
            {
                BackgroundMusicBinder.sharedInstance().pauseMusic();
            }
            if (AkConfigFactory.sharedInstance().isMusicEnabled())
            {
                uiMusicButton.setBackgroundResource(0x7f0201ed);
                return;
            } else
            {
                uiMusicButton.setBackgroundResource(0x7f0201e9);
                return;
            }
        }
        if (view == uiSoundButton)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            view = AkConfigFactory.sharedInstance();
            boolean flag1;
            if (!AkConfigFactory.sharedInstance().isSoundEnabled())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            view.setSoundEnabled(flag1);
            if (AkConfigFactory.sharedInstance().isSoundEnabled())
            {
                uiSoundButton.setBackgroundResource(0x7f020247);
                return;
            } else
            {
                uiSoundButton.setBackgroundResource(0x7f020243);
                return;
            }
        }
        if (view == uiNoteApp)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            view = new Intent("android.intent.action.VIEW");
            view.setData(Uri.parse("market://details?id=com.digidust.elokence.akinator.freemium"));
            startActivity(view);
            disableAdOneTime();
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("rating_app", "1");
            return;
        }
        if (view != uiRecommander)
        {
            break; /* Loop/switch isn't completed */
        }
        MetricsSetAdapter.sharedInstance().incMetricCompteur("recommandation_demande");
        (new AppInviteDialog(this)).registerCallback(callbackManager, new FacebookCallback() {

            final HomeActivity this$0;

            public void onCancel()
            {
                Log.i("HomeActivity", "InviteCallback - CANCEL!");
            }

            public void onError(FacebookException facebookexception)
            {
                Log.e("HomeActivity", (new StringBuilder()).append("InviteCallback - ERROR! ").append(facebookexception.getMessage()).toString());
            }

            public void onSuccess(com.facebook.share.widget.AppInviteDialog.Result result)
            {
                Log.d("HomeActivity", (new StringBuilder()).append("InviteCallback onSuccess result = ").append(result.getData().toString()).toString());
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((com.facebook.share.widget.AppInviteDialog.Result)obj);
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        });
        if (AppInviteDialog.canShow())
        {
            disableAdOneTime();
            view = getString(0x7f07005b);
            AppInviteDialog.show(this, (new com.facebook.share.model.AppInviteContent.Builder()).setApplinkUrl(view).build());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (view == layoutFacebook)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            startActivity(getOpenFacebookIntent(this));
            disableAdOneTime();
            return;
        }
        if (view == layoutTwitter)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            try
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("twitter://user?screen_name=akinator_team")));
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/#!/akinator_team")));
            }
            disableAdOneTime();
            return;
        }
        if (view == uiPartageButton)
        {
            view = new Intent();
            view.setAction("android.intent.action.SEND");
            view.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("JE_TE_RECOMMANDE_AKINATOR_AMAZON_PASTRAMI")).append(" https://www.amazon.fr/gp/mas/get/android/ref=mas_apk_fr_elokence?appName=snuffy&appVersion=fr_stable&campaign=AU_FR_Akinator&channel=ch4&asin=B00ZY5MYHI").toString());
            view.setType("text/plain");
            startActivity(view);
            disableAdOneTime();
            return;
        }
        if (view == uiLayoutLanguage)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            view = new Intent(this, com/digidust/elokence/akinator/activities/SelectLanguageActivity);
            view.putExtra("openDrawer", true);
            startActivity(view);
            finish();
            return;
        }
        if (view == uiLayoutChildProtection)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            view = AkConfigFactory.sharedInstance();
            boolean flag2;
            if (!AkConfigFactory.sharedInstance().isChildProtectEnabled())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            view.setChildProtectEnabled(flag2);
            SessionFactory.sharedInstance().SetChildrenProtect(AkConfigFactory.sharedInstance().isChildProtectEnabled());
            if (AkConfigFactory.sharedInstance().isChildProtectEnabled())
            {
                uiTextChildProtectionImage.setImageResource(0x7f0201d9);
                return;
            } else
            {
                uiTextChildProtectionImage.setImageResource(0x7f0201da);
                return;
            }
        }
        if (view == uiLayoutTrapYourFriends)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            if (AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked())
            {
                transition.displayAchatPotion();
            } else
            {
                view = AkConfigFactory.sharedInstance();
                boolean flag3;
                if (!AkConfigFactory.sharedInstance().isCustomizeEnabled())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                view.setCustomizeEnabled(flag3);
            }
            uiTextTrapYourFriends.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("PERSONNALISER_2")).append(": ").toString());
            if (AkConfigFactory.sharedInstance().isCustomizeEnabled())
            {
                imageTrapYourFriends.setImageResource(0x7f02021c);
                return;
            } else
            {
                imageTrapYourFriends.setImageResource(0x7f02021d);
                return;
            }
        }
        if (view != uiTextChoixBase) goto _L6; else goto _L5
_L5:
        String s;
        String s2;
        String s4;
        byte byte0;
        boolean flag4;
        boolean flag5;
        view = new android.app.AlertDialog.Builder(this);
        view.setCancelable(false);
        s = TraductionFactory.sharedInstance().getTraductionFromToken("AKI_ANDROID_TOUS_LES_PERSONNAGES");
        s2 = TraductionFactory.sharedInstance().getTraductionFromToken("LES_PERSONNAGES_CELEBRES");
        s4 = TraductionFactory.sharedInstance().getTraductionFromToken("LES_PERSONNAGES_MY_WORLD");
        flag4 = AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated();
        flag5 = AkConfigFactory.sharedInstance().isPlayWithMyworldActivated();
        byte0 = -1;
        if (!flag4 || !flag5) goto _L8; else goto _L7
_L7:
        byte0 = 0;
_L9:
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                if (j == 0)
                {
                    AkConfigFactory.sharedInstance().setPlayWithCelebrities(true);
                    AkConfigFactory.sharedInstance().setPlayWithMyworld(true);
                } else
                {
                    if (j == 1)
                    {
                        AkConfigFactory.sharedInstance().setPlayWithCelebrities(true);
                        AkConfigFactory.sharedInstance().setPlayWithMyworld(false);
                        return;
                    }
                    if (j == 2)
                    {
                        AkConfigFactory.sharedInstance().setPlayWithCelebrities(false);
                        AkConfigFactory.sharedInstance().setPlayWithMyworld(true);
                        return;
                    }
                }
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        view.setSingleChoiceItems(new CharSequence[] {
            s, s2, s4
        }, byte0, onclicklistener);
        view.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        });
        view.create().show();
        return;
_L8:
        if (flag4)
        {
            byte0 = 1;
        } else
        if (flag5)
        {
            byte0 = 2;
        }
        if (true) goto _L9; else goto _L6
_L6:
        if (view == uiTextCharactersPictures)
        {
            view = new android.app.AlertDialog.Builder(this);
            view.setCancelable(false);
            String s1 = TraductionFactory.sharedInstance().getTraductionFromToken("TOUT_LE_TEMPS");
            String s3 = TraductionFactory.sharedInstance().getTraductionFromToken("UNIQUEMENT_EN_WIFI");
            String s5 = TraductionFactory.sharedInstance().getTraductionFromToken("JAMAIS");
            int i = AkConfigFactory.sharedInstance().getPictureMode();
            android.content.DialogInterface.OnClickListener onclicklistener1 = new android.content.DialogInterface.OnClickListener() {

                final HomeActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    AkConfigFactory.sharedInstance().setPictureMode(j);
                }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
            };
            view.setSingleChoiceItems(new CharSequence[] {
                s1, s3, s5
            }, i, onclicklistener1);
            view.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                final HomeActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
            });
            view.create().show();
            return;
        }
        if (view == uiTextCGU)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            disableAdOneTime();
            view = new Intent(this, com/digidust/elokence/akinator/activities/WebviewCGV);
            view.putExtra("url", "http://cgu.akinator.com/mobile/content");
            startActivity(view);
            return;
        }
        if (view == uiTextPrivacy)
        {
            disableAdOneTime();
            BackgroundSoundsBinder.sharedInstance().playBip();
            view = new Intent(this, com/digidust/elokence/akinator/activities/WebviewCGV);
            view.putExtra("url", "http://cgu.akinator.com/mobile/privacy");
            startActivity(view);
            return;
        }
        if (view == uiTextRestorePurchases)
        {
            AkLog.d("HomeActivity", "Restore purchases button");
            runOnUiThread(new Runnable() {

                final HomeActivity this$0;

                public void run()
                {
                    Toast.makeText(HomeActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("RESTAURATION_ACHATS_EN_COURS"), 1).show();
                }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
            });
            AkConfigFactory.sharedInstance().displayRestoreOk(true);
            AkInappManager.getInstance().init();
            return;
        }
        if (true) goto _L4; else goto _L10
_L10:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030024);
        if (mIsRebooting)
        {
            return;
        }
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.FULL_MUSIC;
        if (AkBackupManager.getInstance().canSave())
        {
            AkBackupManager.getInstance().saveBackup();
            AkBackupManager.getInstance().setCanSave(false);
        }
        if (AkConfigFactory.sharedInstance().canPlay() != -1 && (AkConfigFactory.sharedInstance().canPlay() != 0 || AkConfigFactory.sharedInstance().isPrio())) goto _L2; else goto _L1
_L1:
        bundle = "";
        if (AkConfigFactory.sharedInstance().canPlay() != 0 || AkConfigFactory.sharedInstance().isPrio()) goto _L4; else goto _L3
_L3:
        bundle = (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_POTION_ULTIMATE_1")).append("\n").append(TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_POTION_ULTIMATE_2")).toString();
_L6:
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(bundle);
        bundle = new android.content.DialogInterface.OnClickListener() {

            final HomeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (AkConfigFactory.sharedInstance().canPlay() == 0 && !AkConfigFactory.sharedInstance().isPrio())
                {
                    disableAdOneTime();
                    AkAnalyticsFactory.sharedInstance().logDebutAchatInApp(AkInappManager.getInstance().getSkuInappUltime());
                    AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappUltime(), HomeActivity.this);
                } else
                if (AkConfigFactory.sharedInstance().canPlay() == -1)
                {
                    dialoginterface = new Message();
                    dialoginterface.what = 0;
                    mHandler.sendMessage(dialoginterface);
                    return;
                }
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        };
        builder.setCancelable(false);
        builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), bundle);
        builder.create().show();
_L2:
        getIntent().getBooleanExtra("canShowCenteredAd", false);
        uiPlayButton = (Button)findViewById(0x7f0d0104);
        uiRankingButtonImage = (Button)findViewById(0x7f0d0280);
        uiMyWorldButton = (Button)findViewById(0x7f0d0281);
        uiFacebookClassement = (Button)findViewById(0x7f0d0282);
        uiOpenBannerButton = (ImageView)findViewById(0x7f0d0105);
        uiOverlayBanner = (LinearLayout)findViewById(0x7f0d0106);
        uiCloseBanner = (ImageView)findViewById(0x7f0d0109);
        uiTextInBanner = (TextView)findViewById(0x7f0d0108);
        uiAkinatorTete = (ImageView)findViewById(0x7f0d0107);
        callbackManager = com.facebook.CallbackManager.Factory.create();
        drawerLayout = (DrawerLayout)findViewById(0x7f0d0100);
        buttonOpenSlide = (ImageView)findViewById(0x7f0d0102);
        uiMusicButton = (Button)findViewById(0x7f0d010c);
        uiSoundButton = (Button)findViewById(0x7f0d010d);
        uiNoteApp = (TextView)findViewById(0x7f0d010e);
        uiRecommander = (TextView)findViewById(0x7f0d010f);
        layoutFacebook = (RelativeLayout)findViewById(0x7f0d0110);
        uiFacebook = (TextView)findViewById(0x7f0d0111);
        layoutTwitter = (RelativeLayout)findViewById(0x7f0d0113);
        uiTwitter = (TextView)findViewById(0x7f0d0114);
        uiPartageButton = (Button)findViewById(0x7f0d00d4);
        uiLayoutLanguage = (RelativeLayout)findViewById(0x7f0d0116);
        uiLanguage = (TextView)findViewById(0x7f0d0117);
        uiFlag = (TextView)findViewById(0x7f0d0118);
        uiLayoutChildProtection = (RelativeLayout)findViewById(0x7f0d0119);
        uiTextChildProtection = (TextView)findViewById(0x7f0d011a);
        uiTextChildProtectionImage = (ImageView)findViewById(0x7f0d011b);
        uiLayoutTrapYourFriends = (RelativeLayout)findViewById(0x7f0d011c);
        uiTextTrapYourFriends = (TextView)findViewById(0x7f0d011d);
        imageTrapYourFriends = (ImageView)findViewById(0x7f0d011e);
        uiTextChoixBase = (TextView)findViewById(0x7f0d011f);
        uiTextCharactersPictures = (TextView)findViewById(0x7f0d0120);
        uiTextCGU = (TextView)findViewById(0x7f0d0121);
        uiTextPrivacy = (TextView)findViewById(0x7f0d0122);
        uiTextRestorePurchases = (TextView)findViewById(0x7f0d0123);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiNoteApp);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiRecommander);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(layoutFacebook);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(layoutTwitter);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiLayoutLanguage);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiLayoutChildProtection);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiLayoutTrapYourFriends);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiTextChoixBase);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiTextCharactersPictures);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiTextCGU);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiTextPrivacy);
        mListViewSlideToDisplayInDarkGreyOrLightGrey1.add(uiTextRestorePurchases);
        if (AkConfigFactory.sharedInstance().isMusicEnabled())
        {
            uiMusicButton.setBackgroundResource(0x7f0201ed);
        } else
        {
            uiMusicButton.setBackgroundResource(0x7f0201e9);
        }
        if (AkConfigFactory.sharedInstance().isSoundEnabled())
        {
            uiSoundButton.setBackgroundResource(0x7f020247);
        } else
        {
            uiSoundButton.setBackgroundResource(0x7f020243);
        }
        uiNoteApp.setOnClickListener(this);
        uiPartageButton.setVisibility(8);
        buttonOpenSlide.setOnClickListener(this);
        uiMusicButton.setOnClickListener(this);
        uiSoundButton.setOnClickListener(this);
        uiNoteApp.setOnClickListener(this);
        uiRecommander.setOnClickListener(this);
        layoutFacebook.setOnClickListener(this);
        layoutTwitter.setOnClickListener(this);
        uiPartageButton.setOnClickListener(this);
        uiLayoutLanguage.setOnClickListener(this);
        uiLayoutChildProtection.setOnClickListener(this);
        uiLayoutTrapYourFriends.setOnClickListener(this);
        uiTextChoixBase.setOnClickListener(this);
        uiTextCharactersPictures.setOnClickListener(this);
        uiTextCGU.setOnClickListener(this);
        uiTextPrivacy.setOnClickListener(this);
        uiTextRestorePurchases.setOnClickListener(this);
        uiNoteApp.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NOTER_APP"));
        uiRecommander.setText(TraductionFactory.sharedInstance().getTraductionFromToken("RECOMMANDER"));
        uiFacebook.setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEVENIR_FAN_FACEBOOK"));
        uiTwitter.setText(TraductionFactory.sharedInstance().getTraductionFromToken("SUIVEZ_NOUS_SUR_TWITTER"));
        bundle = TraductionFactory.sharedInstance().getListOfLanguages().iterator();
        do
        {
            if (!bundle.hasNext())
            {
                break;
            }
            com.elokence.limuleapi.TraductionFactory.Language language = (com.elokence.limuleapi.TraductionFactory.Language)bundle.next();
            if (!language.getCode().equals(TraductionFactory.sharedInstance().getApplicationLanguage()))
            {
                continue;
            }
            uiFlag.setText(language.getLabel());
            uiFlag.setTypeface(tf);
            break;
        } while (true);
        uiLanguage.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("LANGUE")).append(" : ").toString());
        uiTextChildProtection.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("PROTECTION_ENFANT")).append(" : ").toString());
        if (AkConfigFactory.sharedInstance().isChildProtectEnabled())
        {
            uiTextChildProtectionImage.setImageResource(0x7f0201d9);
        } else
        {
            uiTextChildProtectionImage.setImageResource(0x7f0201da);
        }
        uiTextTrapYourFriends.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("PERSONNALISER_2")).append(" : ").toString());
        if (AkConfigFactory.sharedInstance().isCustomizeEnabled())
        {
            imageTrapYourFriends.setImageResource(0x7f02021c);
        } else
        {
            imageTrapYourFriends.setImageResource(0x7f02021d);
        }
        uiTextChoixBase.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CHOIX_DE_LA_BASE"));
        uiTextCharactersPictures.setText(TraductionFactory.sharedInstance().getTraductionFromToken("IMAGES_PERSONNAGES"));
        uiTextCGU.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CGU"));
        uiTextPrivacy.setText(TraductionFactory.sharedInstance().getTraductionFromToken("POLITIQUE_DE_CONFIDENTIALITE_TITRE"));
        uiTextRestorePurchases.setText(TraductionFactory.sharedInstance().getTraductionFromToken("RESTAURER_LES_ACHATS"));
        uiNoteApp.setTypeface(tf);
        uiRecommander.setTypeface(tf);
        uiFacebook.setTypeface(tf);
        uiTwitter.setTypeface(tf);
        uiLanguage.setTypeface(tf);
        uiTextChildProtection.setTypeface(tf);
        uiTextTrapYourFriends.setTypeface(tf);
        uiTextChoixBase.setTypeface(tf);
        uiTextCharactersPictures.setTypeface(tf);
        uiTextCGU.setTypeface(tf);
        uiTextPrivacy.setTypeface(tf);
        uiTextRestorePurchases.setTypeface(tf);
        addTextView(uiFlag);
        addTextView(uiNoteApp);
        addTextView(uiRecommander);
        addTextView(uiFacebook);
        addTextView(uiTwitter);
        addTextView(uiLanguage);
        addTextView(uiTextChildProtection);
        addTextView(uiTextTrapYourFriends);
        addTextView(uiTextChoixBase);
        addTextView(uiTextCharactersPictures);
        addTextView(uiTextCGU);
        addTextView(uiTextPrivacy);
        addTextView(uiTextRestorePurchases);
        updateTextViewsSize();
        uiPlayButton.setTypeface(tf);
        addTextView(uiTextInBanner);
        addTextView(uiPlayButton);
        updateTextViewsSize();
        uiPlayButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JOUER"));
        uiPlayButton.setOnClickListener(mPlayButtonClickListener);
        uiRankingButtonImage.setOnClickListener(mRankingButtonClickListener);
        uiMyWorldButton.setOnClickListener(mMyWorldClickListener);
        uiFacebookClassement.setOnClickListener(mFacebookClassementListener);
        uiOpenBannerButton.setOnClickListener(mOpenBannerButtonClickListener);
        uiCloseBanner.setOnClickListener(mCloseBannerButtonClickListener);
        uiTextInBanner.setOnClickListener(mTextBannerClickListener);
        AkGameFactory.sharedInstance().setAkinatorStatus(0);
        if (!AkConfigFactory.sharedInstance().isFacesDistribues() && AkPlayerBelongingsFactory.sharedInstance().getFacesBalance() == 0)
        {
            if (AkConfigFactory.sharedInstance().isPaid())
            {
                AkPlayerBelongingsFactory.sharedInstance().depositFaces(100);
            } else
            {
                AkPlayerBelongingsFactory.sharedInstance().depositFaces(50);
            }
            AkConfigFactory.sharedInstance().setFacesDistribues();
        }
        if (AkConfigFactory.sharedInstance().isFirstLaunchMB())
        {
            AkConfigFactory.sharedInstance().setFirstLaunchMB(false);
        }
        ((Button)findViewById(0x7f0d0284)).setOnClickListener(mAccessoriesClickListener);
        bundle = (Button)findViewById(0x7f0d0285);
        bundle.setOnClickListener(mStoreButtonListener);
        if (!AkConfigFactory.sharedInstance().isPaid())
        {
            bundle.setVisibility(0);
        } else
        {
            bundle.setVisibility(8);
        }
        uiAkinatorTete.startAnimation(AnimationUtils.loadAnimation(this, 0x7f040019));
        if (getIntent().getBooleanExtra("openDrawer", false))
        {
            drawerLayout.openDrawer(0x800003);
        }
        processing.processOnCreate();
        return;
_L4:
        if (AkConfigFactory.sharedInstance().canPlay() == -1)
        {
            bundle = TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD");
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onInitialization(boolean flag)
    {
        AkLog.d("HomeActivity", (new StringBuilder()).append("OnInitialization : ").append(flag).toString());
        if (flag)
        {
            AkInappManager.getInstance().requestInappDetailsUpdate();
            if (!AkInappManager.getInstance().requestAllPurchases())
            {
                runOnUiThread(new Runnable() {

                    final HomeActivity this$0;

                    public void run()
                    {
                        Toast.makeText(HomeActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_RESTAURATION_ACHATS"), 1).show();
                    }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
                });
            }
            return;
        } else
        {
            runOnUiThread(new Runnable() {

                final HomeActivity this$0;

                public void run()
                {
                    Toast.makeText(HomeActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR_CONNEXION_GOOGLE_PLAY"), 1).show();
                }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onPause()
    {
        if (!mIsRebooting)
        {
            MinibaseFactory.sharedInstance().unsubscribe(this);
        }
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (!mIsRebooting)
        {
            processing.processOnResume();
            MinibaseFactory.sharedInstance().subscribe(this);
            Object obj;
            if (!MinibaseFactory.sharedInstance().isLoaded())
            {
                AkLog.d("HomeActivity", "LoadMinibase starting...");
                (new Thread() {

                    final HomeActivity this$0;

                    public void run()
                    {
                        MinibaseFactory.sharedInstance().loadMinibase(true);
                    }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
                }).start();
            } else
            {
                uiMyWorldButton.setBackgroundResource(0x7f020100);
            }
            obj = MinibaseFactory.sharedInstance().getAllCharacters();
            if (obj == null || ((ArrayList) (obj)).size() == 0)
            {
                uiTextChoixBase.setVisibility(8);
                uiMyWorldButton.setVisibility(4);
            }
            mListViewSlideToDisplayInDarkGreyOrLightGrey2.clear();
            obj = mListViewSlideToDisplayInDarkGreyOrLightGrey1.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                View view = (View)((Iterator) (obj)).next();
                if (view.getVisibility() == 0)
                {
                    mListViewSlideToDisplayInDarkGreyOrLightGrey2.add(view);
                }
            } while (true);
            for (int i = 0; i < mListViewSlideToDisplayInDarkGreyOrLightGrey2.size(); i++)
            {
                if (i % 2 == 0)
                {
                    ((View)mListViewSlideToDisplayInDarkGreyOrLightGrey2.get(i)).setBackgroundResource(0x7f0c0055);
                }
            }

            (new AsyncTask() {

                final HomeActivity this$0;

                protected transient Integer doInBackground(Void avoid[])
                {
                    return Integer.valueOf((new AkHomeBannerWS()).call());
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(Integer integer)
                {
                    updateHomeBannerGraphicConf();
                }

                protected volatile void onPostExecute(Object obj1)
                {
                    onPostExecute((Integer)obj1);
                }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
            }).execute(new Void[0]);
            if (AkConfigFactory.sharedInstance().canPlay() == 0 && !AkConfigFactory.sharedInstance().isPrio())
            {
                AkInappManager.getInstance().requestAllPurchases();
                AkConfigFactory.sharedInstance().setCanCheckFull(true);
            }
            if (AkConfigFactory.sharedInstance().canDisplayCookieAlert())
            {
                (new android.app.AlertDialog.Builder(this)).setCancelable(false).setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("COOKIES_ALERT")).setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                    final HomeActivity this$0;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        AkConfigFactory.sharedInstance().updateCookieAlertStatus(false);
                    }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
                }).show();
                return;
            }
        }
    }

    public void resynchronized()
    {
        AkLog.d("HomeActivity", "LoadMinibase Sync");
        runOnUiThread(new Runnable() {

            final HomeActivity this$0;

            public void run()
            {
                uiMyWorldButton.setBackgroundResource(0x7f020100);
            }

            
            {
                this$0 = HomeActivity.this;
                super();
            }
        });
    }



/*
    static boolean access$102(HomeActivity homeactivity, boolean flag)
    {
        homeactivity.adShown = flag;
        return flag;
    }

*/



}

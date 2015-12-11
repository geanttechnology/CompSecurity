// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.externalprocessing.PopPedagogiqueProcessing;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.TraductionFactory;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.supersonicads.sdk.SSAFactory;
import com.supersonicads.sdk.SSAPublisher;
import com.supersonicads.sdk.listeners.OnOfferWallListener;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.Tapjoy;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, WebviewCGV

public class PopPedagogiqueActivity extends AkActivity
    implements android.view.View.OnClickListener, OnOfferWallListener, TJPlacementListener
{

    public static final String PopPedagogiqueActivityModeGz = "PostPedagogiqueActivityModeGz";
    public static final String TAG = "AkinatorUnlock";
    private static boolean showVeuillezPatienter = false;
    android.view.View.OnClickListener itemGzClickListener;
    SSAPublisher mSSAPublisher;
    boolean modeGz;
    private PopPedagogiqueProcessing processing;
    TJPlacement tjPlacement;
    private Button uiButtonBuyGz1;
    private Button uiButtonBuyGz2;
    private Button uiButtonBuyGz3;
    private Button uiButtonBuyGz4;
    private Button uiButtonBuyGz5;
    private ImageView uiCloseMiniPopUp;
    private ImageView uiClosePopUp;
    private ImageView uiImageOfferWallTapJoy;
    private ImageView uiImageRewardedVideo;
    private LinearLayout uiLayoutGetGz;
    private LinearLayout uiLayoutGetGzInapp;
    private LinearLayout uiLayoutGetGzTapjoy;
    private RelativeLayout uiLayoutMessageAlertGz;
    private TextView uiTextAccepteCGV;
    private TextView uiTextAkiAward;
    private TextView uiTextAwardBlack;
    private TextView uiTextAwardBlackGz;
    private TextView uiTextAwardBronze;
    private TextView uiTextAwardBronzeGz;
    private TextView uiTextAwardGold;
    private TextView uiTextAwardGoldGz;
    private TextView uiTextAwardPlatinum;
    private TextView uiTextAwardPlatinumGz;
    private TextView uiTextAwardSilver;
    private TextView uiTextAwardSilverGz;
    private TextView uiTextAwardStandard;
    private TextView uiTextAwardStandardGz;
    private TextView uiTextBuyPack;
    private TextView uiTextDescription;
    private TextView uiTextGz1;
    private TextView uiTextGz2;
    private TextView uiTextGz3;
    private TextView uiTextGz4;
    private TextView uiTextGz5;
    private TextView uiTextMessageAlert;
    private TextView uiTextObtenirAk;
    private TextView uiTextOtherAction;
    private TextView uiTextPersoPlayed;
    private TextView uiTextTimeBlack;
    private TextView uiTextTimeBronze;
    private TextView uiTextTimeGold;
    private TextView uiTextTimePlatinum;
    private TextView uiTextTimeSilver;
    private TextView uiTextTimeStandard;
    private TextView uiTextWatchVideo;
    private TextView uiTextWinAward;
    private View uiViewCancel;

    public PopPedagogiqueActivity()
    {
        modeGz = false;
        processing = new PopPedagogiqueProcessing(this);
        itemGzClickListener = new android.view.View.OnClickListener() {

            final PopPedagogiqueActivity this$0;

            public void onClick(View view)
            {
                int i = 0;
                if (view == uiButtonBuyGz1)
                {
                    i = 0;
                } else
                if (view == uiButtonBuyGz2)
                {
                    i = 1;
                } else
                if (view == uiButtonBuyGz3)
                {
                    i = 2;
                } else
                if (view == uiButtonBuyGz4)
                {
                    i = 3;
                } else
                if (view == uiButtonBuyGz5)
                {
                    i = 4;
                }
                AkLog.d("AkinatorUnlock", (new StringBuilder()).append("item gz selected : ").append(i).toString());
                try
                {
                    disableAdOneTime();
                    AkAnalyticsFactory.sharedInstance().logDebutAchatInApp(AkInappManager.getInstance().getSkuInappGeniz(i));
                    AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappGeniz(AkInappManager.getInstance().getListIdInappGeniz()[i]), PopPedagogiqueActivity.this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    closeWithError();
                }
            }

            
            {
                this$0 = PopPedagogiqueActivity.this;
                super();
            }
        };
    }

    public void addGenizAndAlert(int i)
    {
        AkPlayerBelongingsFactory.sharedInstance().depositGeniz(i);
    }

    public void closeWithError()
    {
        runOnUiThread(new Runnable() {

            final PopPedagogiqueActivity this$0;

            public void run()
            {
                Toast.makeText(getApplicationContext(), TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR_CONNEXION_GOOGLE_PLAY"), 1).show();
            }

            
            {
                this$0 = PopPedagogiqueActivity.this;
                super();
            }
        });
    }

    public void goToOffers()
    {
        MetricsSetAdapter.sharedInstance().incMetricCompteur("offer_wall_display");
        int j = (int)Math.ceil(Math.random() * 2D);
        int i = j;
        if (j == 0)
        {
            i = 1;
        }
        AkLog.d("AkinatorUnlock", (new StringBuilder()).append("Choix de l'offerwall").append(i).toString());
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            AkLog.d("AkinatorUnlock", "TapJoy");
            Tapjoy.showOffers();
            return;

        case 2: // '\002'
            AkLog.d("AkinatorUnlock", "SuperSonic");
            break;
        }
        (new AsyncTask() {

            final String applicationKey;
            String applicationUserId;
            Map paramsSSA;
            final PopPedagogiqueActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                AkLog.d("AkinatorUnlock", "Supersonic background");
                paramsSSA.put("useClientSideCallbacks", "true");
                applicationUserId = android.provider.Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
                try
                {
                    applicationUserId = AdvertisingIdClient.getAdvertisingIdInfo(PopPedagogiqueActivity.this).getId();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    AkLog.e("AkinatorUnlock", (new StringBuilder()).append("Google AdvertisingId pas r\351cup\351r\351 (IOE) : ").append(avoid).toString());
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    AkLog.e("AkinatorUnlock", (new StringBuilder()).append("Google AdvertisingId pas r\351cup\351r\351 (ISE) : ").append(avoid).toString());
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    AkLog.e("AkinatorUnlock", (new StringBuilder()).append("Google AdvertisingId pas r\351cup\351r\351 (notAvailable) : ").append(avoid).toString());
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    AkLog.e("AkinatorUnlock", (new StringBuilder()).append("Google AdvertisingId pas r\351cup\351r\351 (repairable) : ").append(avoid).toString());
                }
                return null;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                AkLog.d("AkinatorUnlock", "Supersonic PostExec");
                mSSAPublisher.showOfferWall(applicationKey, applicationUserId, paramsSSA, PopPedagogiqueActivity.this);
            }

            
            {
                this$0 = PopPedagogiqueActivity.this;
                super();
                paramsSSA = new TreeMap();
                if (AkConfigFactory.sharedInstance().isPaid())
                {
                    poppedagogiqueactivity = "39253b09";
                } else
                {
                    poppedagogiqueactivity = "2c86277d";
                }
                applicationKey = PopPedagogiqueActivity.this;
            }
        }).execute(new Void[0]);
    }

    public void itemPurchased(String s)
    {
    }

    public void onAllPurchasesRestored()
    {
        super.onAllPurchasesRestored();
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    public void onClick(View view)
    {
        if (view == uiClosePopUp)
        {
            finish();
        } else
        {
            if (view == uiImageRewardedVideo)
            {
                processing.processRewardedVideo();
                return;
            }
            if (view == uiImageOfferWallTapJoy)
            {
                AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
                showVeuillezPatienter = true;
                goToOffers();
                return;
            }
            if (view == uiTextAccepteCGV)
            {
                disableAdOneTime();
                view = new Intent(this, com/digidust/elokence/akinator/activities/WebviewCGV);
                view.putExtra("url", "http://cgu.akinator.com/mobile/content#cgv");
                startActivity(view);
                return;
            }
            if (view == uiViewCancel || view == uiCloseMiniPopUp)
            {
                showVeuillezPatienter = false;
                uiLayoutMessageAlertGz.setVisibility(8);
                return;
            }
        }
    }

    public void onContentDismiss(TJPlacement tjplacement)
    {
        Tapjoy.getCurrencyBalance(AkPlayerBelongingsFactory.sharedInstance());
        tjplacement.requestContent();
        AkLog.d("PopPedagogique", "TJ on content dismiss");
    }

    public void onContentReady(TJPlacement tjplacement)
    {
        AkLog.d("PopPedagogique", "TJ on content ready");
    }

    public void onContentShow(TJPlacement tjplacement)
    {
        AkLog.d("PopPedagogique", "TJ on content show");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002b);
        AkLog.i("PopPeda", "oncreate");
        mSSAPublisher = null;
        uiLayoutGetGz = (LinearLayout)findViewById(0x7f0d0145);
        uiLayoutGetGzInapp = (LinearLayout)findViewById(0x7f0d0146);
        uiLayoutGetGzTapjoy = (LinearLayout)findViewById(0x7f0d0148);
        uiTextObtenirAk = (TextView)findViewById(0x7f0d0144);
        if (getIntent().getBooleanExtra("PostPedagogiqueActivityModeGz", true))
        {
            modeGz = true;
            MetricsSetAdapter.sharedInstance().incMetricCompteur("how_to_get_geniz");
            mSSAPublisher = SSAFactory.getPublisherInstance(this);
            uiTextBuyPack = (TextView)findViewById(0x7f0d0147);
            uiTextGz1 = (TextView)findViewById(0x7f0d0291);
            uiTextGz2 = (TextView)findViewById(0x7f0d0293);
            uiTextGz3 = (TextView)findViewById(0x7f0d0295);
            uiTextGz4 = (TextView)findViewById(0x7f0d0297);
            uiTextGz5 = (TextView)findViewById(0x7f0d0299);
            uiButtonBuyGz1 = (Button)findViewById(0x7f0d0292);
            uiButtonBuyGz2 = (Button)findViewById(0x7f0d0294);
            uiButtonBuyGz3 = (Button)findViewById(0x7f0d0296);
            uiButtonBuyGz4 = (Button)findViewById(0x7f0d0298);
            uiButtonBuyGz5 = (Button)findViewById(0x7f0d029a);
            uiTextWatchVideo = (TextView)findViewById(0x7f0d0149);
            uiTextOtherAction = (TextView)findViewById(0x7f0d014b);
            uiTextWinAward = (TextView)findViewById(0x7f0d014d);
            uiImageRewardedVideo = (ImageView)findViewById(0x7f0d014a);
            uiImageOfferWallTapJoy = (ImageView)findViewById(0x7f0d014c);
            uiLayoutMessageAlertGz = (RelativeLayout)findViewById(0x7f0d0163);
            uiViewCancel = findViewById(0x7f0d00b5);
            uiViewCancel.setOnClickListener(this);
            uiCloseMiniPopUp = (ImageView)findViewById(0x7f0d0164);
            uiCloseMiniPopUp.setOnClickListener(this);
            uiTextMessageAlert = (TextView)findViewById(0x7f0d0165);
            uiTextObtenirAk.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BESOIN_DE_GENIZ"));
            uiTextBuyPack.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ACCROCHE_PACK_GZ"));
            uiTextWatchVideo.setText(TraductionFactory.sharedInstance().getTraductionFromToken("REGARDER_UNE_VIDEO"));
            uiTextOtherAction.setText(TraductionFactory.sharedInstance().getTraductionFromToken("REMPLIR_UN_FORMULAIRE"));
            uiTextWinAward.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JOUER_UNE_PARTIE"));
            uiTextMessageAlert.setText(TraductionFactory.sharedInstance().getTraductionFromToken("VEUILLEZ_PATIENTER"));
            uiTextBuyPack.setTypeface(tf);
            uiButtonBuyGz1.setTypeface(tf);
            uiButtonBuyGz2.setTypeface(tf);
            uiButtonBuyGz3.setTypeface(tf);
            uiButtonBuyGz4.setTypeface(tf);
            uiButtonBuyGz5.setTypeface(tf);
            uiTextMessageAlert.setTypeface(tf);
            uiTextGz1.setTypeface(tf);
            uiTextGz2.setTypeface(tf);
            uiTextGz3.setTypeface(tf);
            uiTextGz4.setTypeface(tf);
            uiTextGz5.setTypeface(tf);
            uiTextWatchVideo.setTypeface(tf);
            uiTextOtherAction.setTypeface(tf);
            uiTextWinAward.setTypeface(tf);
            addTextView(uiTextBuyPack);
            addTextView(uiTextGz1);
            addTextView(uiTextGz2);
            addTextView(uiTextGz3);
            addTextView(uiTextGz4);
            addTextView(uiTextGz5);
            addTextView(uiTextWatchVideo);
            addTextView(uiTextOtherAction);
            addTextView(uiTextWinAward);
            addTextView(uiTextMessageAlert);
            updateTextViewsSize();
            updateUI();
            uiImageRewardedVideo.setOnClickListener(this);
            uiImageOfferWallTapJoy.setOnClickListener(this);
            uiButtonBuyGz1.setOnClickListener(itemGzClickListener);
            uiButtonBuyGz2.setOnClickListener(itemGzClickListener);
            uiButtonBuyGz3.setOnClickListener(itemGzClickListener);
            uiButtonBuyGz4.setOnClickListener(itemGzClickListener);
            uiButtonBuyGz5.setOnClickListener(itemGzClickListener);
        } else
        {
            modeGz = false;
            uiTextObtenirAk.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CONSIGNES_REGLES"));
            uiLayoutGetGz.setVisibility(8);
        }
        uiTextAccepteCGV = (TextView)findViewById(0x7f0d029f);
        uiClosePopUp = (ImageView)findViewById(0x7f0d00b7);
        uiTextDescription = (TextView)findViewById(0x7f0d014e);
        uiTextAkiAward = (TextView)findViewById(0x7f0d014f);
        uiTextPersoPlayed = (TextView)findViewById(0x7f0d0150);
        uiTextAwardStandard = (TextView)findViewById(0x7f0d0151);
        uiTextAwardStandardGz = (TextView)findViewById(0x7f0d0152);
        uiTextTimeStandard = (TextView)findViewById(0x7f0d0153);
        uiTextAwardBronze = (TextView)findViewById(0x7f0d0154);
        uiTextAwardBronzeGz = (TextView)findViewById(0x7f0d0155);
        uiTextTimeBronze = (TextView)findViewById(0x7f0d0156);
        uiTextAwardSilver = (TextView)findViewById(0x7f0d0157);
        uiTextAwardSilverGz = (TextView)findViewById(0x7f0d0158);
        uiTextTimeSilver = (TextView)findViewById(0x7f0d0159);
        uiTextAwardGold = (TextView)findViewById(0x7f0d015a);
        uiTextAwardGoldGz = (TextView)findViewById(0x7f0d015b);
        uiTextTimeGold = (TextView)findViewById(0x7f0d015c);
        uiTextAwardPlatinum = (TextView)findViewById(0x7f0d015d);
        uiTextAwardPlatinumGz = (TextView)findViewById(0x7f0d015e);
        uiTextTimePlatinum = (TextView)findViewById(0x7f0d015f);
        uiTextAwardBlack = (TextView)findViewById(0x7f0d0160);
        uiTextAwardBlackGz = (TextView)findViewById(0x7f0d0161);
        uiTextTimeBlack = (TextView)findViewById(0x7f0d0162);
        uiTextAccepteCGV.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CGV"));
        uiTextDescription.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("ACCROCHE_AWARD_1")).append(" ").append(TraductionFactory.sharedInstance().getTraductionFromToken("ACCROCHE_AWARD_2")).append(" ").append(TraductionFactory.sharedInstance().getTraductionFromToken("ACCROCHE_AWARD_3")).append(" ").append(TraductionFactory.sharedInstance().getTraductionFromToken("ACCROCHE_AWARD_4")).toString());
        uiTextAkiAward.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AKI_AWARD_GENERIQUE"));
        uiTextPersoPlayed.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JUSTIFICATION_AWARD"));
        uiTextAwardStandard.setText(TraductionFactory.sharedInstance().getTraductionFromToken("STANDARD_TITRE"));
        uiTextTimeStandard.setText(TraductionFactory.sharedInstance().getTraductionFromToken("STANDARD_DESC"));
        uiTextAwardBronze.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BRONZE_TITRE"));
        uiTextTimeBronze.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BRONZE_DESC"));
        uiTextAwardSilver.setText(TraductionFactory.sharedInstance().getTraductionFromToken("SILVER_TITRE"));
        uiTextTimeSilver.setText(TraductionFactory.sharedInstance().getTraductionFromToken("SILVER_DESC"));
        uiTextAwardGold.setText(TraductionFactory.sharedInstance().getTraductionFromToken("GOLD_TITRE"));
        uiTextTimeGold.setText(TraductionFactory.sharedInstance().getTraductionFromToken("GOLD_DESC"));
        uiTextAwardPlatinum.setText(TraductionFactory.sharedInstance().getTraductionFromToken("PLATINUM_TITRE"));
        uiTextTimePlatinum.setText(TraductionFactory.sharedInstance().getTraductionFromToken("PLATINUM_DESC"));
        uiTextAwardBlack.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BLACK_TITRE"));
        uiTextTimeBlack.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BLACK_DESC"));
        uiTextAccepteCGV.setTypeface(tf);
        uiTextDescription.setTypeface(tf);
        uiTextAkiAward.setTypeface(tf);
        uiTextPersoPlayed.setTypeface(tf);
        uiTextObtenirAk.setTypeface(tf);
        uiTextAwardStandard.setTypeface(tf);
        uiTextAwardStandardGz.setTypeface(tf);
        uiTextTimeStandard.setTypeface(tf);
        uiTextAwardBronze.setTypeface(tf);
        uiTextAwardBronzeGz.setTypeface(tf);
        uiTextTimeBronze.setTypeface(tf);
        uiTextAwardSilver.setTypeface(tf);
        uiTextAwardSilverGz.setTypeface(tf);
        uiTextTimeSilver.setTypeface(tf);
        uiTextAwardGold.setTypeface(tf);
        uiTextAwardGoldGz.setTypeface(tf);
        uiTextTimeGold.setTypeface(tf);
        uiTextAwardPlatinum.setTypeface(tf);
        uiTextAwardPlatinumGz.setTypeface(tf);
        uiTextTimePlatinum.setTypeface(tf);
        uiTextAwardBlack.setTypeface(tf);
        uiTextAwardBlackGz.setTypeface(tf);
        uiTextTimeBlack.setTypeface(tf);
        addTextView(uiTextAccepteCGV);
        addTextView(uiTextObtenirAk);
        addTextView(uiTextAwardStandard);
        addTextView(uiTextTimeStandard);
        addTextView(uiTextAwardBronze);
        addTextView(uiTextTimeBronze);
        addTextView(uiTextAwardSilver);
        addTextView(uiTextTimeSilver);
        addTextView(uiTextAwardGold);
        addTextView(uiTextTimeGold);
        addTextView(uiTextAwardPlatinum);
        addTextView(uiTextTimePlatinum);
        addTextView(uiTextAwardSilver);
        addTextView(uiTextAwardBlack);
        addTextView(uiTextTimeBlack);
        updateTextViewsSize();
        uiClosePopUp.setOnClickListener(this);
        uiTextAccepteCGV.setOnClickListener(this);
        tjPlacement = new TJPlacement(this, "eventNameVideo", this);
        tjPlacement.requestContent();
    }

    public void onDestroy()
    {
        if (mSSAPublisher != null)
        {
            mSSAPublisher.release(this);
        }
        super.onDestroy();
    }

    public void onGetOWCreditsFailed(String s)
    {
        AkLog.d("AkinatorUnlock", (new StringBuilder()).append("SSA OW credits failed : ").append(s).toString());
    }

    public void onInitialization(boolean flag)
    {
        AkInappManager.getInstance().requestInappDetailsUpdate();
        AkInappManager.getInstance().requestAllPurchases();
    }

    public void onOWAdClosed()
    {
    }

    public boolean onOWAdCredited(int i, int j, boolean flag)
    {
        AkLog.d("AkinatorUnlock", (new StringBuilder()).append("SSA callback credited with params ").append(i).append(" ").append(j).append(" ").append(flag).toString());
        if (flag)
        {
            addGenizAndAlert(i);
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricCompteur("gz_gain_offer_walls", i);
        } else
        {
            addGenizAndAlert(5);
        }
        return true;
    }

    public void onOWGeneric(String s, String s1)
    {
        AkLog.d("AkinatorUnlock", (new StringBuilder()).append("SSA callback generic with params ").append(s).append(" ").append(s1).toString());
    }

    public void onOWShowFail(String s)
    {
        AkLog.e("AkinatorUnlock", "SSA offerwall failed to open. Retrying...");
        goToOffers();
    }

    public void onOWShowSuccess()
    {
        AkLog.d("AkinatorUnlock", "SSA offerwall opening ok.");
    }

    public void onPause()
    {
        if (modeGz && mSSAPublisher != null)
        {
            mSSAPublisher.onPause(this);
        }
        super.onPause();
    }

    public void onPurchaseRequest(TJPlacement tjplacement, TJActionRequest tjactionrequest, String s)
    {
        AkLog.d("PopPedagogique", "TJ on purchase request");
    }

    public void onRequestFailure(TJPlacement tjplacement, TJError tjerror)
    {
        AkLog.d("PopPedagogique", "TJ on request failure");
    }

    public void onRequestSuccess(TJPlacement tjplacement)
    {
        AkLog.d("PopPedagogique", "TJ on request successs");
    }

    public void onResume()
    {
        super.onResume();
        AkLog.i("PopPeda", "OnResume");
        if (modeGz)
        {
            if (!AkInappManager.getInstance().isInit())
            {
                AkInappManager.getInstance().init();
            }
            Tapjoy.getCurrencyBalance(AkPlayerBelongingsFactory.sharedInstance());
            if (mSSAPublisher != null)
            {
                mSSAPublisher.onResume(this);
            }
            if (showVeuillezPatienter)
            {
                uiLayoutMessageAlertGz.setVisibility(0);
            }
        }
    }

    public void onRewardRequest(TJPlacement tjplacement, TJActionRequest tjactionrequest, String s, int i)
    {
        AkLog.d("PopPedagogique", "TJ on reward request");
    }

    public void skuDetailsUpdated()
    {
        updateUI();
    }

    public void updateUI()
    {
        runOnUiThread(new Runnable() {

            final PopPedagogiqueActivity this$0;

            public void run()
            {
                uiTextGz1.setText(AkInappManager.getInstance().getNomInappGeniz(0));
                uiTextGz2.setText(AkInappManager.getInstance().getNomInappGeniz(1));
                uiTextGz3.setText(AkInappManager.getInstance().getNomInappGeniz(2));
                uiTextGz4.setText(AkInappManager.getInstance().getNomInappGeniz(3));
                uiTextGz5.setText(AkInappManager.getInstance().getNomInappGeniz(4));
                uiButtonBuyGz1.setText(AkInappManager.getInstance().getPriceInappGeniz(0));
                uiButtonBuyGz2.setText(AkInappManager.getInstance().getPriceInappGeniz(1));
                uiButtonBuyGz3.setText(AkInappManager.getInstance().getPriceInappGeniz(2));
                uiButtonBuyGz4.setText(AkInappManager.getInstance().getPriceInappGeniz(3));
                uiButtonBuyGz5.setText(AkInappManager.getInstance().getPriceInappGeniz(4));
            }

            
            {
                this$0 = PopPedagogiqueActivity.this;
                super();
            }
        });
    }











}

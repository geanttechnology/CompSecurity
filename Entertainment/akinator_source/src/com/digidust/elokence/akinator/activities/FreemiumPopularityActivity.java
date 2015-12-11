// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.transitions.TransitionToStore;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.text.NumberFormat;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, OneCharacterProposalActivity, ProposeAjoutMBActivity, PopPedagogiqueActivity, 
//            QuestionActivity

public class FreemiumPopularityActivity extends AkActivity
    implements android.view.View.OnClickListener
{

    private ProgressDialog mProgressDialog;
    private TransitionToStore transition2Store;
    private Button uiButton2hGz;
    private Button uiButtonInfinite;
    private Button uiButtonNo;
    private TextView uiFreemiumPopularityDescription;
    private TextView uiText2Hours;
    private TextView uiTextAllTheTime;

    public FreemiumPopularityActivity()
    {
        transition2Store = new TransitionToStore(this);
    }

    private void HideButtonsGz()
    {
        uiButton2hGz.setBackgroundResource(0x7f0200ed);
        uiButtonInfinite.setBackgroundResource(0x7f0200ed);
        uiButton2hGz.setEnabled(false);
        uiButtonInfinite.setEnabled(false);
    }

    private void goToResult()
    {
        Intent intent;
        if (AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated())
        {
            intent = new Intent(this, com/digidust/elokence/akinator/activities/OneCharacterProposalActivity);
        } else
        {
            intent = new Intent(this, com/digidust/elokence/akinator/activities/ProposeAjoutMBActivity);
            intent.putExtra("gagne_ou_perdu", true);
        }
        closeOptionsMenu();
        startActivity(intent);
        AkLog.i("Akinator", "QUESTION ACTIVITY FINISH");
        finish();
    }

    private void showPopPedagogiqueActivity()
    {
        disableAdOneTime();
        Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/PopPedagogiqueActivity);
        intent.putExtra("PostPedagogiqueActivityModeGz", true);
        startActivity(intent);
    }

    public void itemPurchased(String s)
    {
        if (s.equals(AkInappManager.getInstance().getSkuInappPopu()) || s.equals(AkInappManager.getInstance().getSkuInappUltime()))
        {
            if (AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated())
            {
                s = new Intent(this, com/digidust/elokence/akinator/activities/OneCharacterProposalActivity);
            } else
            {
                s = new Intent(this, com/digidust/elokence/akinator/activities/ProposeAjoutMBActivity);
                s.putExtra("gagne_ou_perdu", true);
            }
            closeOptionsMenu();
            startActivity(s);
            AkLog.i("Akinator", "QUESTION ACTIVITY FINISH");
            finish();
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        while (i != 667 || j == 0 || j != 1) 
        {
            return;
        }
        if (!AkGameFactory.sharedInstance().isPopularityLimited() || AkGameFactory.sharedInstance().isUnlocked())
        {
            goToResult();
            return;
        } else
        {
            AkInappManager.getInstance().requestAllPurchases();
            return;
        }
    }

    public void onClick(View view)
    {
        if (view == uiButtonInfinite)
        {
            disableAdOneTime();
            transition2Store.goToPotionPopu();
        } else
        {
            if (view == uiButton2hGz)
            {
                if (AkPlayerBelongingsFactory.sharedInstance().withdrawGeniz(AkPlayerBelongingsFactory.sharedInstance().getRemovePopularity2HoursCost()))
                {
                    AkGameFactory.sharedInstance().setUnlockedPopularity(0x6ddd00L);
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("popu_unlocked");
                    AkPlayerBelongingsFactory.sharedInstance().changeThresholdPopularity();
                    uiButton2hGz.setVisibility(4);
                    uiButtonInfinite.setVisibility(4);
                    goToResult();
                    return;
                } else
                {
                    showPopPedagogiqueActivity();
                    return;
                }
            }
            if (view == uiButtonNo)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                (new AsyncTask() {

                    private Dialog mProgressDialog;
                    final FreemiumPopularityActivity this$0;

                    protected transient Integer doInBackground(Void avoid[])
                    {
                        if (AkConfigFactory.sharedInstance().isPlayWithMyworldActivated())
                        {
                            avoid = SessionFactory.sharedInstance();
                            boolean flag;
                            if (!AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            return Integer.valueOf(avoid.startSessionWithMinibase(true, flag));
                        } else
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().startSession());
                        }
                    }

                    protected volatile Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected void onPostExecute(Integer integer)
                    {
                        if (mProgressDialog != null && mProgressDialog.isShowing())
                        {
                            mProgressDialog.dismiss();
                        }
                        if (integer.intValue() == 0 || integer.intValue() == 800)
                        {
                            integer = new Intent(FreemiumPopularityActivity.this, com/digidust/elokence/akinator/activities/QuestionActivity);
                            integer.putExtra("showAd", true);
                            startActivity(integer);
                            finish();
                            return;
                        }
                        if (integer.intValue() == 500)
                        {
                            Toast.makeText(FreemiumPopularityActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_RELANCE"), 1).show();
                            return;
                        } else
                        {
                            Toast.makeText(FreemiumPopularityActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
                            goToHome(false);
                            return;
                        }
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Integer)obj);
                    }

                    protected void onPreExecute()
                    {
                        mProgressDialog = CustomLoadingDialog.show(FreemiumPopularityActivity.this);
                    }

            
            {
                this$0 = FreemiumPopularityActivity.this;
                super();
                mProgressDialog = null;
            }
                }).execute(new Void[0]);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030022);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        MetricsSetAdapter.sharedInstance().incMetricCompteur("popu_block");
        uiButtonInfinite = (Button)findViewById(0x7f0d00ec);
        uiButton2hGz = (Button)findViewById(0x7f0d00ea);
        uiButtonNo = (Button)findViewById(0x7f0d00ed);
        uiText2Hours = (TextView)findViewById(0x7f0d00e9);
        uiTextAllTheTime = (TextView)findViewById(0x7f0d00eb);
        uiFreemiumPopularityDescription = (TextView)findViewById(0x7f0d00e8);
        uiButtonNo.setTypeface(tf);
        uiFreemiumPopularityDescription.setTypeface(tf);
        uiText2Hours.setTypeface(tf);
        uiTextAllTheTime.setTypeface(tf);
        uiButton2hGz.setTypeface(tf);
        if (AkPlayerBelongingsFactory.sharedInstance().getGenizBalance() >= AkPlayerBelongingsFactory.sharedInstance().getRemovePopularity2HoursCost())
        {
            MetricsSetAdapter.sharedInstance().incMetricCompteur("popu_unlockable");
        }
        uiButton2hGz.setText(NumberFormat.getInstance().format(AkPlayerBelongingsFactory.sharedInstance().getRemovePopularity2HoursCost()));
        uiText2Hours.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JE_DEBLOQUE_2H"));
        uiTextAllTheTime.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JE_DEBLOQUE_TOUT_LE_TEMPS"));
        uiButtonNo.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NON_MERCI"));
        uiFreemiumPopularityDescription.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_FREE_POPULARITE"));
        addTextView(uiButtonNo);
        addTextView(uiText2Hours);
        addTextView(uiTextAllTheTime);
        addTextView(uiFreemiumPopularityDescription);
        updateTextViewsSize();
        uiButton2hGz.setOnClickListener(this);
        uiButtonInfinite.setOnClickListener(this);
        uiButtonNo.setOnClickListener(this);
        AkGameFactory.sharedInstance().addOneGame();
        AkGameFactory.sharedInstance().addOneWonGame();
    }

    public void onInitialization(boolean flag)
    {
        AkInappManager.getInstance().requestInappDetailsUpdate();
        AkInappManager.getInstance().requestAllPurchases();
    }

    protected void onResume()
    {
        super.onResume();
        updateUI();
    }

    public void skuDetailsUpdated()
    {
    }

    public void updateUI()
    {
        if (!AkGameFactory.sharedInstance().isPopularityLimited())
        {
            HideButtonsGz();
        }
        if (AkGameFactory.sharedInstance().isUnlocked())
        {
            HideButtonsGz();
        }
    }
}

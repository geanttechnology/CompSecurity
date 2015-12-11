// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.digidust.elokence.akinator.activities.externalprocessing.AkProcessing;
import com.digidust.elokence.akinator.activities.transitions.SelectLanguageTransition;
import com.digidust.elokence.akinator.adapters.AkLanguageSelectionAdapter;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkPushFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.AnalyticsCenter;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, HomeActivity

public class SelectLanguageActivity extends AkActivity
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener
{

    private boolean WsUpdated;
    private int canPlay;
    private boolean canShowCenteredAd;
    private boolean changingLanguage;
    private boolean home;
    private String lang;
    private boolean langUpdated;
    private boolean languageChanged;
    private AkLanguageSelectionAdapter languageSelectionAdapter;
    private ImageView retourButton;
    private SelectLanguageTransition transition;
    private ListView uiLanguageList;
    private TextView uiTextLanguageSelection;
    private TextView uiTextScrollLanguage;

    public SelectLanguageActivity()
    {
        changingLanguage = false;
        WsUpdated = false;
        langUpdated = false;
        transition = new SelectLanguageTransition(this);
        canPlay = 1;
    }

    public void goToHomeScreen()
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        if (AkConfigFactory.sharedInstance().isFirstLaunch())
        {
            AkConfigFactory.sharedInstance().setFirstLaunch(false);
        }
        generalProcessing.processGoToHome();
        Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/HomeActivity);
        intent.setFlags(0x4000000);
        intent.putExtra("ShowAdOnGameOver", false);
        intent.putExtra("openDrawer", getIntent().getBooleanExtra("openDrawer", false));
        startActivity(intent);
        finish();
    }

    public void itemPurchased(String s)
    {
        super.itemPurchased(s);
        if ((s.equals(AkInappManager.getInstance().getSkuInappUltime()) || s.equals(AkInappManager.getInstance().getSkuInappPopu())) && AkConfigFactory.sharedInstance().canPlay() == 0 && AkConfigFactory.sharedInstance().canCheckFull())
        {
            s = new android.app.AlertDialog.Builder(this);
            s.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_FULL_ACHETE"));
            android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                final SelectLanguageActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Message();
                    dialoginterface.what = 0;
                    mHandler.sendMessage(dialoginterface);
                }

            
            {
                this$0 = SelectLanguageActivity.this;
                super();
            }
            };
            s.setCancelable(false);
            s.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), onclicklistener);
            s.create().show();
        }
    }

    public void onBackPressed()
    {
        if (!AkConfigFactory.sharedInstance().isFirstLaunch() && !changingLanguage)
        {
            super.onBackPressed();
            goToHomeScreen();
        }
    }

    public void onClick(View view)
    {
        if (view == retourButton)
        {
            goToHomeScreen();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030027);
        WsUpdated = false;
        langUpdated = false;
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.NO_CHANGE;
        bundle = getIntent();
        home = bundle.getBooleanExtra("home", false);
        languageChanged = bundle.getBooleanExtra("languageChanged", false);
        canShowCenteredAd = bundle.getBooleanExtra("canShowCenteredAd", false);
        uiTextLanguageSelection = (TextView)findViewById(0x7f0d0129);
        uiTextScrollLanguage = (TextView)findViewById(0x7f0d012a);
        uiLanguageList = (ListView)findViewById(0x7f0d012b);
        retourButton = (ImageView)findViewById(0x7f0d0133);
        uiTextLanguageSelection.setTypeface(tf);
        uiTextScrollLanguage.setTypeface(tf);
        addTextView(uiTextLanguageSelection);
        updateTextViewsSize();
        languageSelectionAdapter = new AkLanguageSelectionAdapter(this, TraductionFactory.sharedInstance().getListOfLanguages());
        uiLanguageList.setAdapter(languageSelectionAdapter);
        languageSelectionAdapter.notifyDataSetChanged();
        uiLanguageList.setOnItemClickListener(this);
        lang = TraductionFactory.sharedInstance().getApplicationLanguage();
        uiTextScrollLanguage.setText("Scroll to select your language");
        if (AkConfigFactory.sharedInstance().isFirstLaunch())
        {
            uiTextLanguageSelection.setText("Language selection");
            retourButton.setVisibility(8);
            return;
        } else
        {
            uiTextLanguageSelection.setText(TraductionFactory.sharedInstance().getTraductionFromToken("SELECTION_LANGUE"));
            retourButton.setOnClickListener(this);
            return;
        }
    }

    public void onDestroy()
    {
        languageSelectionAdapter.clear();
        super.onDestroy();
    }

    public void onItemClick(AdapterView adapterview, View view, final int position, long l)
    {
        adapterview = TraductionFactory.sharedInstance().getListOfLanguages();
        if (lang == null || ((com.elokence.limuleapi.TraductionFactory.Language)adapterview.get(position)).getCode().compareTo(lang) != 0)
        {
            languageChanged = true;
            changingLanguage = true;
            byte byte0;
            if (AkConfigFactory.sharedInstance().isPaid())
            {
                byte0 = 2;
            } else
            if (AkGameFactory.sharedInstance().isUnlocked())
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            AkConfigFactory.sharedInstance().changeLanguageManually(true);
            AnalyticsCenter.getInstance().boot(AkApplication.getAppContext(), AkConfigFactory.sharedInstance().getApplication(), ((com.elokence.limuleapi.TraductionFactory.Language)adapterview.get(position)).getCode(), AkPushFactory.getInstance().getRegistrationId(getApplicationContext()), byte0, AkAnalyticsFactory.sharedInstance());
        }
        (new AsyncTask() {

            private Dialog mProgressDialog;
            final SelectLanguageActivity this$0;
            final int val$position;

            protected transient Integer doInBackground(Void avoid[])
            {
                avoid = ((com.elokence.limuleapi.TraductionFactory.Language)languageSelectionAdapter.getItem(position)).getCode();
                int i = SessionFactory.sharedInstance().setLanguageWS(avoid);
                if (i == 0)
                {
                    return Integer.valueOf(TraductionFactory.sharedInstance().setApplicationLanguage(avoid));
                } else
                {
                    return Integer.valueOf(i);
                }
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Integer integer)
            {
            /* block-local class not found */
            class _cls1 {}

                android.app.AlertDialog.Builder builder;
                try
                {
                    if (mProgressDialog != null && mProgressDialog.isShowing())
                    {
                        mProgressDialog.dismiss();
                    }
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    mProgressDialog = null;
                }
                if (integer.intValue() == 500)
                {
                    canPlay = -1;
                } else
                if (integer.intValue() == 510 && !AkConfigFactory.sharedInstance().isPrio())
                {
                    canPlay = 0;
                } else
                {
                    canPlay = 1;
                }
                if (canPlay != -1 && (canPlay != 0 || AkConfigFactory.sharedInstance().isPrio())) goto _L2; else goto _L1
_L1:
                integer = "";
                if (canPlay != 0 || AkConfigFactory.sharedInstance().isPrio()) goto _L4; else goto _L3
_L3:
                integer = (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_POTION_ULTIMATE_1")).append("\n").append(TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_POTION_ULTIMATE_2")).toString();
_L5:
                builder = new android.app.AlertDialog.Builder(SelectLanguageActivity.this);
                builder.setMessage(integer);
                integer = new _cls1();
                builder.setCancelable(false);
                builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), integer);
                builder.create().show();
                return;
_L4:
                if (canPlay == -1)
                {
                    integer = TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_RELANCE");
                }
                if (true) goto _L5; else goto _L2
_L2:
                if (integer.intValue() == 0 || integer.intValue() == 320)
                {
                    AkApplication.setCoeffFont(Float.parseFloat(((com.elokence.limuleapi.TraductionFactory.Language)languageSelectionAdapter.getItem(position)).getFontCoeffAndroid()));
                    MinibaseFactory.sharedInstance().unload();
                }
            /* block-local class not found */
            class _cls2 {}

                (new _cls2()).start();
                goToHomeScreen();
                AkConfigFactory.sharedInstance().setCodeSubject("1");
                return;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Integer)obj);
            }

            protected void onPreExecute()
            {
                mProgressDialog = CustomLoadingDialog.show(SelectLanguageActivity.this);
            }

            
            {
                this$0 = SelectLanguageActivity.this;
                position = i;
                super();
                mProgressDialog = null;
            }
        }).execute(new Void[0]);
    }

    public void onResume()
    {
        super.onResume();
        if (canPlay == 0 && !AkConfigFactory.sharedInstance().isPrio())
        {
            AkInappManager.getInstance().requestAllPurchases();
            AkConfigFactory.sharedInstance().setCanCheckFull(true);
        }
    }




/*
    static int access$102(SelectLanguageActivity selectlanguageactivity, int i)
    {
        selectlanguageactivity.canPlay = i;
        return i;
    }

*/
}

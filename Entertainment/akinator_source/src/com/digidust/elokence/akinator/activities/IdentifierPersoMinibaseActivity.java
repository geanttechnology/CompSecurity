// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.adapters.AkIdentifierMinibaseCharacterAdapter;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, AjoutModifPersoMBActivity, QuestionActivity

public class IdentifierPersoMinibaseActivity extends AkActivity
{

    public static final String EXTRA_MODE_NAME = "ActivityMode";
    public static final int MODE_PERDU = 2;
    public static final int MODE_TROUVE = 1;
    private int activityMode;
    android.view.View.OnClickListener mAjouteClickListener;
    private AkIdentifierMinibaseCharacterAdapter mAkIdentifierMinibaseCharactersAdapter;
    ProgressDialog mProgressDialog;
    private android.view.View.OnClickListener mRejouerClickListener;
    Button uiAjouteButton;
    private ListView uiCharactersList;
    TextView uiInstructions;
    Button uiRejouerButton;
    TextView uiTitleText;

    public IdentifierPersoMinibaseActivity()
    {
        mAjouteClickListener = new android.view.View.OnClickListener() {

            final IdentifierPersoMinibaseActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(IdentifierPersoMinibaseActivity.this, com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity);
                view.putExtra("ActivityMode", true);
                view.putExtra("ActivityCaller", 4);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = IdentifierPersoMinibaseActivity.this;
                super();
            }
        };
        mRejouerClickListener = new android.view.View.OnClickListener() {

            final IdentifierPersoMinibaseActivity this$0;

            public void onClick(View view)
            {
                (new AsyncTask() {

                    private Dialog mProgressDialog;
                    final _cls3 this$1;

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
                        if (integer.intValue() == 0 || integer.intValue() == 800)
                        {
                            integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/QuestionActivity);
                            startActivity(integer);
                            finish();
                            return;
                        }
                        if (integer.intValue() == 500)
                        {
                            Toast.makeText(_fld0, TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_RELANCE"), 1).show();
                            return;
                        } else
                        {
                            Toast.makeText(_fld0, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
                        mProgressDialog = CustomLoadingDialog.show(_fld0);
                    }

            
            {
                this$1 = _cls3.this;
                super();
                mProgressDialog = null;
            }
                }).execute(new Void[0]);
            }

            
            {
                this$0 = IdentifierPersoMinibaseActivity.this;
                super();
            }
        };
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        goToHome();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030025);
        activityMode = getIntent().getExtras().getInt("ActivityMode");
        uiTitleText = (TextView)findViewById(0x7f0d0125);
        uiAjouteButton = (Button)findViewById(0x7f0d0128);
        uiRejouerButton = (Button)findViewById(0x7f0d00ef);
        uiCharactersList = (ListView)findViewById(0x7f0d0127);
        uiInstructions = (TextView)findViewById(0x7f0d0126);
        uiRejouerButton.setTypeface(tf);
        uiAjouteButton.setTypeface(tf);
        uiTitleText.setTypeface(tf);
        uiInstructions.setTypeface(tf);
        uiRejouerButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("REJOUER"));
        uiTitleText.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MY_WORLD"));
        uiAjouteButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER"));
        uiInstructions.setText(TraductionFactory.sharedInstance().getTraductionFromToken("LISTE_PERSONNAGE_MINIBASE"));
        addTextView(uiAjouteButton);
        addTextView(uiTitleText);
        addTextView(uiInstructions);
        addTextView(uiRejouerButton);
        updateTextViewsSize();
        uiAjouteButton.setOnClickListener(mAjouteClickListener);
        uiRejouerButton.setOnClickListener(mRejouerClickListener);
        AkAnalyticsFactory.sharedInstance().logAfficheListeIdentificationMW();
    }

    public void onResume()
    {
        super.onResume();
        updateGUI();
    }

    public void updateGUI()
    {
        runOnUiThread(new Runnable() {

            final IdentifierPersoMinibaseActivity this$0;

            public void run()
            {
            /* block-local class not found */
            class _cls1 {}

                (new _cls1()).execute(new Void[0]);
            }

            
            {
                this$0 = IdentifierPersoMinibaseActivity.this;
                super();
            }
        });
    }



/*
    static AkIdentifierMinibaseCharacterAdapter access$002(IdentifierPersoMinibaseActivity identifierpersominibaseactivity, AkIdentifierMinibaseCharacterAdapter akidentifierminibasecharacteradapter)
    {
        identifierpersominibaseactivity.mAkIdentifierMinibaseCharactersAdapter = akidentifierminibasecharacteradapter;
        return akidentifierminibasecharacteradapter;
    }

*/


}

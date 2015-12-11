// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity

public class Soundlike3Activity extends AkActivity
{

    private android.view.View.OnClickListener mValiderClickListener;
    private RelativeLayout mainLayout;
    private TextView uiSoundLike3FieldDescriptionText;
    private TextView uiSoundLike3FieldNameText;
    private TextView uiSoundlike3ContentText;
    private EditText uiSoundlike3FieldDescriptionValueEditText;
    private EditText uiSoundlike3FieldNameValueEditText;
    private Button uiValidNewCharacterButton;

    public Soundlike3Activity()
    {
        mValiderClickListener = new android.view.View.OnClickListener() {

            final Soundlike3Activity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (uiSoundlike3FieldNameValueEditText.getText().toString().trim().length() == 0 || uiSoundlike3FieldDescriptionValueEditText.getText().toString().trim().length() == 0)
                {
                    Toast.makeText(Soundlike3Activity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LES_CHAMPS_NE_PEUVENT_ETRE_VIDES"), 0).show();
                    return;
                }
                if (uiSoundlike3FieldNameValueEditText.getText().length() > 100)
                {
                    Toast.makeText(Soundlike3Activity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LE_NOM_NE_DOIT_PAS_DEPASSER_100_CHARACTERES"), 0).show();
                    return;
                }
                if (uiSoundlike3FieldDescriptionValueEditText.getText().length() > 255)
                {
                    Toast.makeText(Soundlike3Activity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LA_DECRIPTION_NE_DOIT_PAS_DEPASSER_255_CHARACTERES"), 0).show();
                    return;
                } else
                {
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        private String mSoundlile3FieldNameValueEditDesc;
                        private String mSoundlile3FieldNameValueEditText;
                        final _cls1 this$1;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().newElementWithNameAndDescription(mSoundlile3FieldNameValueEditText, mSoundlile3FieldNameValueEditDesc));
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
                            if (integer.intValue() == 0)
                            {
                                MetricsSetAdapter.sharedInstance().incMetricCompteur("added_characters");
                                AkGameFactory.sharedInstance().addOneLostGame();
                                AkGameFactory.sharedInstance().setAkinatorStatus(3);
                                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/GameOverActivity);
                                AkGameFactory.sharedInstance().setGameOverActivityState(11);
                                integer.putExtra("keyAcceptance", mSoundlile3FieldNameValueEditText);
                                startActivity(integer);
                                finish();
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
                            mSoundlile3FieldNameValueEditText = uiSoundlike3FieldNameValueEditText.getText().toString();
                            mSoundlile3FieldNameValueEditDesc = uiSoundlike3FieldDescriptionValueEditText.getText().toString();
                        }

            
            {
                this$1 = _cls1.this;
                super();
                mProgressDialog = null;
            }
                    }).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = Soundlike3Activity.this;
                super();
            }
        };
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 2 && j == 0)
        {
            goToHome();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        goToHome();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030037);
        mainLayout = (RelativeLayout)findViewById(0x7f0d0085);
        uiSoundlike3ContentText = (TextView)findViewById(0x7f0d01b0);
        uiSoundlike3FieldNameValueEditText = (EditText)findViewById(0x7f0d01b3);
        uiSoundlike3FieldDescriptionValueEditText = (EditText)findViewById(0x7f0d01b5);
        uiValidNewCharacterButton = (Button)findViewById(0x7f0d01b1);
        uiSoundLike3FieldNameText = (TextView)findViewById(0x7f0d01b2);
        uiSoundLike3FieldDescriptionText = (TextView)findViewById(0x7f0d01b4);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        uiValidNewCharacterButton.setTypeface(tf);
        uiSoundlike3ContentText.setTypeface(tf);
        uiSoundlike3FieldNameValueEditText.setTypeface(tf);
        uiSoundlike3FieldDescriptionValueEditText.setTypeface(tf);
        uiSoundLike3FieldNameText.setTypeface(tf);
        uiSoundLike3FieldDescriptionText.setTypeface(tf);
        addTextView(uiValidNewCharacterButton);
        addTextView(uiSoundlike3ContentText);
        addTextView(uiSoundlike3FieldNameValueEditText);
        addTextView(uiSoundlike3FieldDescriptionValueEditText);
        addTextView(uiSoundLike3FieldNameText);
        addTextView(uiSoundLike3FieldDescriptionText);
        updateTextViewsSize();
        uiSoundLike3FieldNameText.setText((new StringBuilder()).append(Character.toUpperCase(TraductionFactory.sharedInstance().getTraductionFromToken("NOM").charAt(0))).append(TraductionFactory.sharedInstance().getTraductionFromToken("NOM").substring(1)).append(":").toString());
        uiSoundlike3FieldNameValueEditText.setText(AkSessionFactory.sharedInstance().getCharacterNameProposed());
        uiSoundLike3FieldDescriptionText.setText((new StringBuilder()).append(Character.toUpperCase(TraductionFactory.sharedInstance().getTraductionFromToken("DESCRIPTION").charAt(0))).append(TraductionFactory.sharedInstance().getTraductionFromToken("DESCRIPTION").substring(1)).append(":").toString());
        uiSoundlike3ContentText.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("POUR_VALIDER_AJOUT_PERSONNAGE_VERIF_NOM")).append(". ").append(TraductionFactory.sharedInstance().getTraductionFromToken("DESCRIPTION_DOIT_PRECISER_CONTEXTE_POUR_EVITER_CONFUSION_HOMONYME")).append(".").toString());
        uiValidNewCharacterButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("VALIDER_LE_PERSONNAGE"));
        uiValidNewCharacterButton.setOnClickListener(mValiderClickListener);
    }


}

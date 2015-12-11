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
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, Soundlike2Activity, Soundlike3Activity

public class Soundlike1Activity extends AkActivity
{

    private android.view.View.OnClickListener mValiderClickListener;
    private TextView uiSoundlike1ContentText;
    private EditText uiSoundlike1FieldValue;
    private Button validateButton;

    public Soundlike1Activity()
    {
        mValiderClickListener = new android.view.View.OnClickListener() {

            final Soundlike1Activity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (uiSoundlike1FieldValue.getText().length() == 0)
                {
                    Toast.makeText(Soundlike1Activity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LES_CHAMPS_NE_PEUVENT_ETRE_VIDES"), 0).show();
                    return;
                }
                if (uiSoundlike1FieldValue.getText().length() > 100)
                {
                    Toast.makeText(Soundlike1Activity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LE_NOM_NE_DOIT_PAS_DEPASSER_100_CHARACTERES"), 0).show();
                    return;
                } else
                {
                    AkSessionFactory.sharedInstance().setCharacterNameProposed(uiSoundlike1FieldValue.getText().toString());
                    (new AsyncTask() {

                        private ArrayList mListOfObjects;
                        private Dialog mProgressDialog;
                        private String mSoundLikeFieldValue;
                        final _cls1 this$1;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().getObjectsFromString(mSoundLikeFieldValue, mListOfObjects));
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
                                if (mListOfObjects.size() > 0)
                                {
                                    integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/Soundlike2Activity);
                                    integer.putExtra("keyListSsl", mListOfObjects);
                                    startActivity(integer);
                                    finish();
                                    return;
                                } else
                                {
                                    integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/Soundlike3Activity);
                                    startActivity(integer);
                                    finish();
                                    return;
                                }
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
                            mSoundLikeFieldValue = uiSoundlike1FieldValue.getText().toString();
                        }

            
            {
                this$1 = _cls1.this;
                super();
                mListOfObjects = new ArrayList();
                mProgressDialog = null;
            }
                    }).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = Soundlike1Activity.this;
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
        setContentView(0x7f030035);
        uiSoundlike1ContentText = (TextView)findViewById(0x7f0d01ad);
        uiSoundlike1FieldValue = (EditText)findViewById(0x7f0d01ae);
        validateButton = (Button)findViewById(0x7f0d01ac);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        uiSoundlike1ContentText.setTypeface(tf);
        uiSoundlike1FieldValue.setTypeface(tf);
        validateButton.setTypeface(tf);
        addTextView(uiSoundlike1ContentText);
        addTextView(uiSoundlike1FieldValue);
        addTextView(validateButton);
        updateTextViewsSize();
        uiSoundlike1ContentText.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("VISIBLEMENT_JE_NE_CONNAIS_PAS_ENCORE_VOTRE_PERSONNAGE")).append(". ").append(TraductionFactory.sharedInstance().getTraductionFromToken("MERCI_DE_MINDIQUER_SON_NOM_DANS_LE_CHAMP_CI_DESSOUS")).append(" ").append(TraductionFactory.sharedInstance().getTraductionFromToken("POUR_ME_PERMETTRE_DEFFECTUER_UNE_RECHERCHE")).toString());
        validateButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("VALIDER"));
        validateButton.setOnClickListener(mValiderClickListener);
    }

}

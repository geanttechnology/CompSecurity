// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity, SoundlikeQuestionsActivity, AddQuestionActivity

public class SearchQuestionActivity extends AkActivity
{

    private android.view.View.OnClickListener mRetourClickListener;
    private android.view.View.OnClickListener mSearchQuestionButtonClickListener;
    private ImageView retourButton;
    private Button uiSearchQuestionButton;
    private TextView uiSearchQuestionContentText;
    private EditText uiSearchQuestionFieldValue;

    public SearchQuestionActivity()
    {
        mRetourClickListener = new android.view.View.OnClickListener() {

            final SearchQuestionActivity this$0;

            public void onClick(View view)
            {
                onBack();
            }

            
            {
                this$0 = SearchQuestionActivity.this;
                super();
            }
        };
        mSearchQuestionButtonClickListener = new android.view.View.OnClickListener() {

            final SearchQuestionActivity this$0;

            public void onClick(View view)
            {
                if (uiSearchQuestionFieldValue.getText().length() == 0)
                {
                    Toast.makeText(SearchQuestionActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LES_CHAMPS_NE_PEUVENT_ETRE_VIDES"), 0).show();
                    return;
                }
                view = uiSearchQuestionFieldValue.getText().toString();
                if (view.contains(" "))
                {
                    view = new android.app.AlertDialog.Builder(SearchQuestionActivity.this);
                    view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ESPACES_NON_AUTORISE_TAPE_MOT_PRINCIPAL_QUESTION"));
                    view.setCancelable(false);
                    view.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.create().show();
                    return;
                } else
                {
                    (view. new AsyncTask() {

                        private ArrayList mListOfQuestions;
                        private Dialog mProgressDialog;
                        final _cls2 this$1;
                        final String val$mSearchQuestionFieldValue;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            if (mSearchQuestionFieldValue.length() > 10)
                            {
                                return Integer.valueOf(SessionFactory.sharedInstance().getSession().getQuestionsFromString(mSearchQuestionFieldValue.substring(0, 10), mListOfQuestions));
                            } else
                            {
                                return Integer.valueOf(SessionFactory.sharedInstance().getSession().getQuestionsFromString(mSearchQuestionFieldValue, mListOfQuestions));
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
                            if (integer.intValue() == 0)
                            {
                                if (mListOfQuestions.size() > 0)
                                {
                                    integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/SoundlikeQuestionsActivity);
                                    startActivity(integer);
                                    finish();
                                    return;
                                } else
                                {
                                    nextCall();
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
                        }

            
            {
                this$1 = final__pcls2;
                mSearchQuestionFieldValue = String.this;
                super();
                mProgressDialog = null;
                mListOfQuestions = new ArrayList();
            }
                    }).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = SearchQuestionActivity.this;
                super();
            }
        };
    }

    private void nextCall()
    {
        (new AsyncTask() {

            private ArrayList mListOfObjects;
            private Dialog mProgressDialog;
            final SearchQuestionActivity this$0;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(SessionFactory.sharedInstance().getSession().getObjectsForQuestionWithListSize(10, mListOfObjects));
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
                    integer = new Intent(SearchQuestionActivity.this, com/digidust/elokence/akinator/activities/AddQuestionActivity);
                    startActivity(integer);
                    finish();
                    return;
                } else
                {
                    Toast.makeText(SearchQuestionActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
                mProgressDialog = CustomLoadingDialog.show(SearchQuestionActivity.this);
            }

            
            {
                this$0 = SearchQuestionActivity.this;
                super();
                mProgressDialog = null;
                mListOfObjects = new ArrayList();
            }
        }).execute(new Void[0]);
    }

    private void onBack()
    {
        super.onBackPressed();
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity));
        overridePendingTransition(0x7f04001a, 0x7f04001b);
        finish();
    }

    public void onBackPressed()
    {
        onBack();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030033);
        uiSearchQuestionButton = (Button)findViewById(0x7f0d01a8);
        uiSearchQuestionContentText = (TextView)findViewById(0x7f0d01a6);
        uiSearchQuestionFieldValue = (EditText)findViewById(0x7f0d01a7);
        retourButton = (ImageView)findViewById(0x7f0d0133);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        uiSearchQuestionContentText.setTypeface(tf);
        uiSearchQuestionButton.setTypeface(tf);
        addTextView(uiSearchQuestionContentText);
        addTextView(uiSearchQuestionButton);
        updateTextViewsSize();
        uiSearchQuestionButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ENVOYER"));
        uiSearchQuestionContentText.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("VERIFIONS_SI_UNE_QUESTION_SEMBLABLE_N_EXISTE_PAS")).append(".\n").append(TraductionFactory.sharedInstance().getTraductionFromToken("RECHERCHER_LES_QUESTIONS_CONTENANT_CETTE_SUITE_DE_CARACTERES")).append(".").toString());
        uiSearchQuestionButton.setOnClickListener(mSearchQuestionButtonClickListener);
        retourButton.setOnClickListener(mRetourClickListener);
    }



}

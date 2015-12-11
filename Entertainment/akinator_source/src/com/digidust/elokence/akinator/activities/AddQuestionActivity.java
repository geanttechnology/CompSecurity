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
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.adapters.AkCharacterAnswerAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, SoundlikeQuestionsActivity, SearchQuestionActivity, GameOverActivity

public class AddQuestionActivity extends AkActivity
{
    public class LimuleObjectAnswer
    {

        int answer;
        com.elokence.limuleapi.Session.LimuleObject oneObject;
        final AddQuestionActivity this$0;

        public int getAnswer()
        {
            return answer;
        }

        public com.elokence.limuleapi.Session.LimuleObject getObject()
        {
            return oneObject;
        }

        public void setAnswer(int i)
        {
            answer = i;
        }

        public LimuleObjectAnswer()
        {
            this$0 = AddQuestionActivity.this;
            super();
        }
    }


    AkCharacterAnswerAdapter akCharacterAnswerAdapter;
    private android.widget.AdapterView.OnItemClickListener mCharacterListClickListener;
    private ArrayList mLimuleObjectsAnswer;
    private com.elokence.limuleapi.Session.QuestionObject mQuestion;
    private android.view.View.OnClickListener mRetourClickListener;
    private android.view.View.OnClickListener mSendButtonClickListener;
    private ImageView retourButton;
    private Button uiAddQuestionButton;
    private ListView uiCharacterList;
    private EditText uiQuestionField;
    private TextView uiTitle;

    public AddQuestionActivity()
    {
        mLimuleObjectsAnswer = new ArrayList();
        mRetourClickListener = new android.view.View.OnClickListener() {

            final AddQuestionActivity this$0;

            public void onClick(View view)
            {
                onBack();
            }

            
            {
                this$0 = AddQuestionActivity.this;
                super();
            }
        };
        mSendButtonClickListener = new android.view.View.OnClickListener() {

            final AddQuestionActivity this$0;

            public void onClick(View view)
            {
                int i;
                BackgroundSoundsBinder.sharedInstance().playBip();
                view = new ArrayList();
                i = 0;
                if (mLimuleObjectsAnswer.size() != 1) goto _L2; else goto _L1
_L1:
                int j;
                j = 1;
                int k = ((LimuleObjectAnswer)mLimuleObjectsAnswer.get(0)).getAnswer();
                i = k;
                if (k == -2)
                {
                    i = -1;
                }
                view.add(new com.elokence.limuleapi.Session.ObjectAnswer(i, ""));
_L4:
                if (j == 0)
                {
                    break MISSING_BLOCK_LABEL_298;
                }
                if (mQuestion != null)
                {
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        final _cls2 this$1;

                        protected transient Integer doInBackground(ArrayList aarraylist[])
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().modifyQuestionWithId(mQuestion.getId(), mQuestion.getQuestion(), aarraylist[0]));
                        }

                        protected volatile Object doInBackground(Object aobj[])
                        {
                            return doInBackground((ArrayList[])aobj);
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
                                AkSessionFactory.sharedInstance().setQuestionAlreadyProposed(true);
                                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/GameOverActivity);
                                integer.putExtra("hasToDisplayQuestionValide", true);
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
                        }

            
            {
                this$1 = _cls2.this;
                super();
                mProgressDialog = null;
            }
                    }).execute(new ArrayList[] {
                        view
                    });
                    return;
                }
                break; /* Loop/switch isn't completed */
_L2:
                int l = -2;
                Iterator iterator = mLimuleObjectsAnswer.iterator();
                do
                {
                    j = i;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    LimuleObjectAnswer limuleobjectanswer = (LimuleObjectAnswer)iterator.next();
                    int i1 = limuleobjectanswer.getAnswer();
                    j = i;
                    if (l != -2)
                    {
                        j = i;
                        if (l != i1)
                        {
                            j = 1;
                        }
                    }
                    i = i1;
                    if (i1 == -2)
                    {
                        i = -1;
                    }
                    view.add(new com.elokence.limuleapi.Session.ObjectAnswer(i, ""));
                    l = limuleobjectanswer.getAnswer();
                    i = j;
                } while (true);
                if (true) goto _L4; else goto _L3
_L3:
                if (uiQuestionField.length() < 3)
                {
                    showTooSmallQuestionAlert();
                    return;
                }
                if (uiQuestionField.length() > 150)
                {
                    showTooLongQuestionAlert();
                    return;
                } else
                {
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        private String mQuestionText;
                        final _cls2 this$1;

                        protected transient Integer doInBackground(ArrayList aarraylist[])
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().addNewQuestionWithLabelAndAnswers(mQuestionText, aarraylist[0]));
                        }

                        protected volatile Object doInBackground(Object aobj[])
                        {
                            return doInBackground((ArrayList[])aobj);
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
                                MetricsSetAdapter.sharedInstance().incMetricCompteur("added_questions");
                                AkSessionFactory.sharedInstance().setQuestionAlreadyProposed(true);
                                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/GameOverActivity);
                                integer.putExtra("hasToDisplayQuestionValide", true);
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
                            mQuestionText = uiQuestionField.getText().toString();
                        }

            
            {
                this$1 = _cls2.this;
                super();
                mProgressDialog = null;
            }
                    }).execute(new ArrayList[] {
                        view
                    });
                    return;
                }
                showAtLeast2DifferentsAlert();
                return;
            }

            
            {
                this$0 = AddQuestionActivity.this;
                super();
            }
        };
        mCharacterListClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final AddQuestionActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                showAnswerSelector(i);
            }

            
            {
                this$0 = AddQuestionActivity.this;
                super();
            }
        };
    }

    private void onBack()
    {
        super.onBackPressed();
        if (SessionFactory.sharedInstance().getSession().getCurrentListofQuestions() != null && SessionFactory.sharedInstance().getSession().getCurrentListofQuestions().size() > 0)
        {
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/SoundlikeQuestionsActivity));
            overridePendingTransition(0x7f04001a, 0x7f04001b);
            finish();
            return;
        } else
        {
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/SearchQuestionActivity));
            overridePendingTransition(0x7f04001a, 0x7f04001b);
            finish();
            return;
        }
    }

    private void showTooLongQuestionAlert()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR"));
        builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("VOTRE_QUESTION_EST_TROP_LONGUE_MAXIMUM_150_CARACTERES"));
        builder.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), null);
        builder.show();
    }

    private void showTooSmallQuestionAlert()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR"));
        builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("VOTRE_QUESTION_EST_TROP_COURTE_MINIMUM_10_CARACTERES"));
        builder.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), null);
        builder.show();
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
        onBack();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (mIsRebooting)
        {
            return;
        }
        setContentView(0x7f03001a);
        uiTitle = (TextView)findViewById(0x7f0d005f);
        uiCharacterList = (ListView)findViewById(0x7f0d008b);
        uiAddQuestionButton = (Button)findViewById(0x7f0d008c);
        uiQuestionField = (EditText)findViewById(0x7f0d008a);
        retourButton = (ImageView)findViewById(0x7f0d0133);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        uiTitle.setTypeface(tf);
        uiAddQuestionButton.setTypeface(tf);
        addTextView(uiAddQuestionButton);
        updateTextViewsSize();
        mQuestion = (com.elokence.limuleapi.Session.QuestionObject)getIntent().getSerializableExtra("question");
        if (mQuestion != null)
        {
            uiQuestionField.setText(mQuestion.getQuestion());
            uiQuestionField.setKeyListener(null);
        }
        uiTitle.setText(TraductionFactory.sharedInstance().getTraductionFromToken("VOTRE_QUESTION"));
        uiAddQuestionButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ENVOYER"));
        uiCharacterList.setDivider(null);
        uiCharacterList.setDividerHeight(0);
        uiAddQuestionButton.setOnClickListener(mSendButtonClickListener);
        uiCharacterList.setOnItemClickListener(mCharacterListClickListener);
        LimuleObjectAnswer limuleobjectanswer;
        for (bundle = SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().iterator(); bundle.hasNext(); mLimuleObjectsAnswer.add(limuleobjectanswer))
        {
            com.elokence.limuleapi.Session.LimuleObject limuleobject = (com.elokence.limuleapi.Session.LimuleObject)bundle.next();
            limuleobjectanswer = new LimuleObjectAnswer();
            limuleobjectanswer.oneObject = limuleobject;
            limuleobjectanswer.answer = -2;
        }

        akCharacterAnswerAdapter = new AkCharacterAnswerAdapter(this, mLimuleObjectsAnswer);
        uiCharacterList.setAdapter(akCharacterAnswerAdapter);
        retourButton.setOnClickListener(mRetourClickListener);
    }

    public void showAnswerSelector(final int pos)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("REPONSE"));
        String s = TraductionFactory.sharedInstance().getTraductionFromToken("JE_NE_CONNAIS_PAS_LA_REPONSE");
        String s1 = TraductionFactory.sharedInstance().getTraductionFromToken("OUI");
        String s2 = TraductionFactory.sharedInstance().getTraductionFromToken("NON");
        String s3 = TraductionFactory.sharedInstance().getTraductionFromToken("NE_SAIS_PAS");
        String s4 = TraductionFactory.sharedInstance().getTraductionFromToken("PROBABLEMENT");
        String s5 = TraductionFactory.sharedInstance().getTraductionFromToken("PROBABLEMENT_PAS");
        int i = ((LimuleObjectAnswer)mLimuleObjectsAnswer.get(pos)).getAnswer();
        android.content.DialogInterface.OnClickListener onclicklistener;
        if (i == -2)
        {
            i = -1;
        } else
        {
            i++;
        }
        onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final AddQuestionActivity this$0;
            final int val$pos;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                ((LimuleObjectAnswer)mLimuleObjectsAnswer.get(pos)).setAnswer(j - 1);
            }

            
            {
                this$0 = AddQuestionActivity.this;
                pos = i;
                super();
            }
        };
        builder.setSingleChoiceItems(new CharSequence[] {
            s, s1, s2, s3, s4, s5
        }, i, onclicklistener);
        builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

            final AddQuestionActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                akCharacterAnswerAdapter.notifyDataSetChanged();
            }

            
            {
                this$0 = AddQuestionActivity.this;
                super();
            }
        });
        builder.create().show();
    }

    protected void showAtLeast2DifferentsAlert()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR"));
        builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("IL_FAUT_OBLIGATOIREMENT_AU_MOINS_DEUX_REPONSES_DIFFERENTES"));
        builder.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), null);
        builder.show();
    }






}

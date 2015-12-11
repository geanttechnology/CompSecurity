// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.externalprocessing.QuestionProcessing;
import com.digidust.elokence.akinator.activities.transitions.QuestionTransition;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.digidust.elokence.akinator.views.TileFloatView;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.Calendar;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

public class QuestionActivity extends AkActivity
    implements android.view.animation.Animation.AnimationListener
{

    public static final int DONT_KNOW = 2;
    public static final int NO = 1;
    public static final int PROBABLY = 3;
    public static final int PROBABLY_NOT = 4;
    private static final String TAG = "QuestionActivity";
    public static final int YES = 0;
    private LinearLayout buttonsProbably;
    private LinearLayout buttonsYesNoDontKnow;
    private Animation firstStepAnimation;
    private boolean hasAlreadyAnswered;
    private android.view.View.OnClickListener mBackClickListener;
    private com.digidust.elokence.akinator.factories.AkGameFactory.BestQuestion mBestQuestions[];
    private android.view.View.OnClickListener mDontknowClickListener;
    private int mLastAnswer;
    private android.view.View.OnClickListener mNoClickListener;
    private android.view.View.OnClickListener mProbablyClickListener;
    private android.view.View.OnClickListener mProbablyNotClickListener;
    private android.view.View.OnClickListener mYesClickListener;
    private QuestionProcessing processing;
    private Animation secondStepAnimation;
    private QuestionTransition transition;
    private ImageView uiBackButtonImage;
    private TileFloatView uiBackground1;
    private TileFloatView uiBackground2;
    private TileFloatView uiBackground3;
    private ImageView uiChildProtectionInGame;
    private Button uiDontknowQuestionButton;
    private RelativeLayout uiLayoutBulleQuestion;
    private ProgressBar uiLoadingBarQuestions;
    private Button uiNoQuestionButton;
    private Button uiProbablyNotQuestionButton;
    private Button uiProbablyQuestionButton;
    private TextView uiQuestionCounterText;
    private TextView uiQuestionTextView;
    private ImageView uiStar;
    private Button uiYesQuestionButton;
    private boolean upgradeView;

    public QuestionActivity()
    {
        upgradeView = false;
        hasAlreadyAnswered = false;
        processing = new QuestionProcessing(this);
        transition = new QuestionTransition(this);
        mBestQuestions = new com.digidust.elokence.akinator.factories.AkGameFactory.BestQuestion[3];
        mLastAnswer = -1;
        mBackClickListener = new android.view.View.OnClickListener() {

            final QuestionActivity this$0;

            public void onClick(View view)
            {
                cancelAnswer();
            }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
        };
        mYesClickListener = new android.view.View.OnClickListener() {

            final QuestionActivity this$0;

            public void onClick(View view)
            {
                selectAnswer(0);
            }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
        };
        mDontknowClickListener = new android.view.View.OnClickListener() {

            final QuestionActivity this$0;

            public void onClick(View view)
            {
                selectAnswer(2);
            }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
        };
        mNoClickListener = new android.view.View.OnClickListener() {

            final QuestionActivity this$0;

            public void onClick(View view)
            {
                selectAnswer(1);
            }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
        };
        mProbablyClickListener = new android.view.View.OnClickListener() {

            final QuestionActivity this$0;

            public void onClick(View view)
            {
                selectAnswer(3);
            }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
        };
        mProbablyNotClickListener = new android.view.View.OnClickListener() {

            final QuestionActivity this$0;

            public void onClick(View view)
            {
                selectAnswer(4);
            }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
        };
    }

    private void cancelAnswer()
    {
        if (!AkConfigFactory.sharedInstance().isOnline())
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("VERIFIEZ_VOTRE_CONNEXION_ET_REESSAYEZ"));
            builder.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("CONTINUER_LA_PARTIE"), new android.content.DialogInterface.OnClickListener() {

                final QuestionActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    cancelAnswer();
                }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
            });
            builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("COMMENCER_UNE_NOUVELLE_PARTIE"), new android.content.DialogInterface.OnClickListener() {

                final QuestionActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    goToHome(false);
                }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
            });
            builder.setCancelable(false);
            builder.show();
        } else
        if (!hasAlreadyAnswered)
        {
            hasAlreadyAnswered = true;
            BackgroundSoundsBinder.sharedInstance().playBip();
            (new AsyncTask() {

                private Dialog mProgressDialog;
                private com.elokence.limuleapi.Session.QuestionProgression questionProgression;
                final QuestionActivity this$0;

                protected transient Integer doInBackground(Void avoid[])
                {
                    return Integer.valueOf(SessionFactory.sharedInstance().getSession().cancelAnswer(questionProgression));
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
                        updateQuestionUI();
                        return;
                    }
                    if (integer.intValue() == 600 || integer.intValue() == 610)
                    {
                        hasAlreadyAnswered = false;
                        integer = new android.app.AlertDialog.Builder(QuestionActivity.this);
                        integer.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_QUE_VEUX_TU_FAIRE"));
                /* block-local class not found */
                class _cls1 {}

                        integer.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("CONTINUER_LA_PARTIE"), new _cls1());
                /* block-local class not found */
                class _cls2 {}

                        integer.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("COMMENCER_UNE_NOUVELLE_PARTIE"), new _cls2());
                        integer.setCancelable(false);
                        integer.show();
                        return;
                    } else
                    {
                        hasAlreadyAnswered = false;
                        Toast.makeText(QuestionActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
                    mProgressDialog = CustomLoadingDialog.show(QuestionActivity.this);
                }

            
            {
                this$0 = QuestionActivity.this;
                super();
                mProgressDialog = null;
                questionProgression = new com.elokence.limuleapi.Session.QuestionProgression();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    private String getAkinatorAttitude()
    {
        float f = 0.0F;
        com.elokence.limuleapi.Session.QuestionProgression questionprogression = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression();
        if (questionprogression.getStep() == 0)
        {
            return "akinator_defi";
        }
        if (questionprogression.getProgression() >= 80F)
        {
            return "akinator_mobile";
        }
        if (AkSessionFactory.sharedInstance().getLastProgression() < 50F && questionprogression.getProgression() >= 50F)
        {
            return "akinator_inspiration_forte";
        }
        if (questionprogression.getProgression() >= 50F)
        {
            return "akinator_confiant";
        }
        if (AkSessionFactory.sharedInstance().getLastProgression() - questionprogression.getProgression() > 16F)
        {
            return "akinator_surprise";
        }
        if (AkSessionFactory.sharedInstance().getLastProgression() - questionprogression.getProgression() > 8F)
        {
            return "akinator_etonnement";
        }
        float f1 = questionprogression.getStep() * 4;
        if (questionprogression.getStep() <= 10)
        {
            f = ((float)questionprogression.getStep() * questionprogression.getProgression() + (float)(10 - questionprogression.getStep()) * f1) / 10F;
        }
        if (f >= f1)
        {
            return "akinator_inspiration_legere";
        }
        if ((double)f >= (double)f1 * 0.80000000000000004D)
        {
            return "akinator_serein";
        }
        if ((double)f >= (double)f1 * 0.59999999999999998D)
        {
            return "akinator_concentration_intense";
        }
        if ((double)f >= (double)f1 * 0.40000000000000002D)
        {
            return "akinator_leger_decouragement";
        }
        if ((double)f >= (double)f1 * 0.20000000000000001D)
        {
            return "akinator_tension";
        } else
        {
            return "akinator_vrai_decouragement";
        }
    }

    private void selectAnswer(final int answerIdx)
    {
        mLastAnswer = answerIdx;
        if (!AkConfigFactory.sharedInstance().isOnline())
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("VERIFIEZ_VOTRE_CONNEXION_ET_REESSAYEZ"));
            builder.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("CONTINUER_LA_PARTIE"), new android.content.DialogInterface.OnClickListener() {

                final QuestionActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    selectAnswer(mLastAnswer);
                }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
            });
            builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("COMMENCER_UNE_NOUVELLE_PARTIE"), new android.content.DialogInterface.OnClickListener() {

                final QuestionActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    goToHome(false);
                }

            
            {
                this$0 = QuestionActivity.this;
                super();
            }
            });
            builder.setCancelable(false);
            builder.show();
        } else
        if (!hasAlreadyAnswered)
        {
            BackgroundSoundsBinder.sharedInstance().playReponse();
            hasAlreadyAnswered = true;
            AkSessionFactory.sharedInstance().setLastProgression(SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getProgression());
            AkSessionFactory.sharedInstance().setLastQuestion(SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getQuestion());
            (new AsyncTask() {

                long mMilliStartBegin;
                long mMilliStartEnd;
                private com.elokence.limuleapi.Session.QuestionProgression mProgress;
                private Dialog mProgressDialog;
                final QuestionActivity this$0;
                final int val$answerIdx;

                protected transient Integer doInBackground(Void avoid[])
                {
                    return Integer.valueOf(SessionFactory.sharedInstance().getSession().answerQuestionWithTag(answerIdx));
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(Integer integer)
                {
                    mMilliStartEnd = Calendar.getInstance().getTimeInMillis();
                    long l = mMilliStartEnd;
                    long l1 = mMilliStartBegin;
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
                    if (integer.intValue() == 0 || integer.intValue() == 300)
                    {
                /* block-local class not found */
                class _cls2 {}

                /* block-local class not found */
                class _cls3 {}

                        float f;
                        try
                        {
                            long l2 = AkGameFactory.sharedInstance().getDelaiMoyen();
                            long l3 = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() - 1;
                            AkGameFactory.sharedInstance().setDelaiMoyen((int)((l2 * l3 + (l - l1)) / (long)SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep()));
                        }
                        catch (Exception exception) { }
                        if (integer.intValue() == 300)
                        {
                            AkSessionFactory.sharedInstance().noMoreQuestions(true);
                        }
                        f = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getProgression() - AkSessionFactory.sharedInstance().getLastProgression();
                        if (f > 0.0F)
                        {
                            if (f > mBestQuestions[0].mDiffTrouvitude)
                            {
                                mBestQuestions[2].copy(mBestQuestions[1]);
                                mBestQuestions[1].copy(mBestQuestions[0]);
                                mBestQuestions[0].mIndice = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() - 1;
                                mBestQuestions[0].mDiffTrouvitude = f;
                                mBestQuestions[0].mQuestion = AkSessionFactory.sharedInstance().getLastQuestion();
                            } else
                            if (f <= mBestQuestions[0].mDiffTrouvitude && f > mBestQuestions[1].mDiffTrouvitude)
                            {
                                mBestQuestions[2].copy(mBestQuestions[1]);
                                mBestQuestions[1].mIndice = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() - 1;
                                mBestQuestions[1].mDiffTrouvitude = f;
                                mBestQuestions[1].mQuestion = AkSessionFactory.sharedInstance().getLastQuestion();
                            } else
                            if (f <= mBestQuestions[1].mDiffTrouvitude && f > mBestQuestions[2].mDiffTrouvitude)
                            {
                                mBestQuestions[2].mIndice = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() - 1;
                                mBestQuestions[2].mDiffTrouvitude = f;
                                mBestQuestions[2].mQuestion = AkSessionFactory.sharedInstance().getLastQuestion();
                            }
                        }
                        AkGameFactory.sharedInstance().updateBestQuestion1(mBestQuestions[0]);
                        AkGameFactory.sharedInstance().updateBestQuestion2(mBestQuestions[1]);
                        AkGameFactory.sharedInstance().updateBestQuestion3(mBestQuestions[2]);
                        if (AkSessionFactory.sharedInstance().isAbleToFind())
                        {
                            uiHomeButton.setEnabled(false);
                            uiYesQuestionButton.setEnabled(false);
                            uiNoQuestionButton.setEnabled(false);
                            uiDontknowQuestionButton.setEnabled(false);
                            uiProbablyNotQuestionButton.setEnabled(false);
                            uiProbablyQuestionButton.setEnabled(false);
                            uiBackButtonImage.setEnabled(false);
                /* block-local class not found */
                class _cls1 {}

                            updateAkinatorUI(new _cls1());
                            return;
                        } else
                        {
                            updateQuestionUI();
                            return;
                        }
                    } else
                    if (integer.intValue() == 600 || integer.intValue() == 610)
                    {
                        hasAlreadyAnswered = false;
                        integer = new android.app.AlertDialog.Builder(QuestionActivity.this);
                        integer.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_QUE_VEUX_TU_FAIRE"));
                        integer.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("CONTINUER_LA_PARTIE"), new _cls2());
                        integer.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("COMMENCER_UNE_NOUVELLE_PARTIE"), new _cls3());
                        integer.setCancelable(false);
                        integer.show();
                        return;
                    } else
                    {
                        hasAlreadyAnswered = false;
                        Toast.makeText(QuestionActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
                    mProgressDialog = CustomLoadingDialog.show(QuestionActivity.this);
                    mMilliStartBegin = Calendar.getInstance().getTimeInMillis();
                }

            
            {
                this$0 = QuestionActivity.this;
                answerIdx = i;
                super();
                mProgressDialog = null;
                mProgress = new com.elokence.limuleapi.Session.QuestionProgression();
                mMilliStartBegin = 0L;
                mMilliStartEnd = 0L;
            }
            }).execute(new Void[0]);
            return;
        }
    }

    private void updateAkinatorUI()
    {
        updateAkinatorUI(null);
    }

    private void updateAkinatorUI(android.view.animation.Animation.AnimationListener animationlistener)
    {
        com.elokence.limuleapi.Session.QuestionProgression questionprogression = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression();
        if (questionprogression.getProgression() - AkSessionFactory.sharedInstance().getLastProgression() <= 30F) goto _L2; else goto _L1
_L1:
        BackgroundSoundsBinder.sharedInstance().playMonte();
_L8:
        String s = getAkinatorAttitude();
        AkConfigFactory.sharedInstance().getBackground();
        if (!setImage(0x7f0d00c5, AkSceneryFactory.sharedInstance().getAkiBitmap(s)))
        {
            uiBackground1.recycleAllBitmaps();
            setImage(0x7f0d00c5, (new StringBuilder()).append("/").append(AkSceneryFactory.sharedInstance().getAkiBitmap(s)).toString());
        }
        if (!setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(AkConfigFactory.sharedInstance().getCloth(), s)))
        {
            uiBackground1.recycleAllBitmaps();
            setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(AkConfigFactory.sharedInstance().getCloth(), s));
        }
        if (!setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(AkConfigFactory.sharedInstance().getHat(), s)))
        {
            uiBackground1.recycleAllBitmaps();
            setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(AkConfigFactory.sharedInstance().getHat(), s));
        }
        AkLog.d("QuestionActivity", (new StringBuilder()).append("Trouvitude ").append(questionprogression.getProgression()).toString());
        if (uiBackground1 != null)
        {
            uiBackground1.updatePosition(animationlistener);
        }
        if (uiBackground2 != null)
        {
            uiBackground2.updatePosition();
        }
        if (uiBackground3 != null)
        {
            uiBackground3.updatePosition();
        }
        System.gc();
        if (uiLoadingBarQuestions == null) goto _L4; else goto _L3
_L3:
        if (!AkSessionFactory.sharedInstance().isAbleToFind()) goto _L6; else goto _L5
_L5:
        animationlistener = ObjectAnimator.ofInt(uiLoadingBarQuestions, "progress", new int[] {
            100
        });
        animationlistener.setDuration(300L);
        animationlistener.start();
_L4:
        AkSessionFactory.sharedInstance().setLastProgression(questionprogression.getProgression());
        return;
_L2:
        if (questionprogression.getProgression() - AkSessionFactory.sharedInstance().getLastProgression() >= 0.0F) goto _L8; else goto _L7
_L7:
        BackgroundSoundsBinder.sharedInstance().playDescente();
          goto _L8
_L6:
label0:
        {
            if (!upgradeView)
            {
                break label0;
            }
            uiLoadingBarQuestions.setProgress(Math.round(questionprogression.getProgression()));
        }
          goto _L4
        try
        {
            animationlistener = ObjectAnimator.ofInt(uiLoadingBarQuestions, "progress", new int[] {
                Math.round(questionprogression.getProgression())
            });
            animationlistener.setDuration(300L);
            animationlistener.start();
        }
        // Misplaced declaration of an exception variable
        catch (android.view.animation.Animation.AnimationListener animationlistener)
        {
            Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
            animationlistener = new Message();
            animationlistener.what = 1;
            mHandler.sendMessage(animationlistener);
            return;
        }
          goto _L4
    }

    private void updateQuestionUI()
    {
        String s6;
        String s8;
        com.elokence.limuleapi.Session.QuestionProgression questionprogression = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression();
        if (questionprogression == null || questionprogression.getQuestion() == null || questionprogression.getAnswers() == null)
        {
            Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
            goToHome(false);
        }
        uiQuestionTextView.setText(questionprogression.getQuestion());
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s7;
        String s9;
        try
        {
            uiQuestionCounterText.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("QUESTION_N")).append(" ").append(questionprogression.getStep() + 1).toString());
        }
        catch (NumberFormatException numberformatexception)
        {
            Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
            Message message = new Message();
            message.what = 1;
            mHandler.sendMessage(message);
            return;
        }
        s1 = "";
        s5 = "";
        s4 = "";
        s7 = "";
        s8 = "";
        s3 = s4;
        s2 = s5;
        s = s7;
        s6 = ((com.elokence.limuleapi.Session.ObjectAnswer)questionprogression.getAnswers().get(0)).getValue();
        s3 = s4;
        s2 = s5;
        s = s7;
        s1 = s6;
        s4 = ((com.elokence.limuleapi.Session.ObjectAnswer)questionprogression.getAnswers().get(2)).getValue();
        s3 = s4;
        s2 = s5;
        s = s7;
        s1 = s6;
        s5 = ((com.elokence.limuleapi.Session.ObjectAnswer)questionprogression.getAnswers().get(1)).getValue();
        s3 = s4;
        s2 = s5;
        s = s7;
        s1 = s6;
        s7 = ((com.elokence.limuleapi.Session.ObjectAnswer)questionprogression.getAnswers().get(3)).getValue();
        s3 = s4;
        s2 = s5;
        s = s7;
        s1 = s6;
        s9 = ((com.elokence.limuleapi.Session.ObjectAnswer)questionprogression.getAnswers().get(4)).getValue();
        s2 = s9;
        s1 = s6;
        s = s7;
        s6 = s2;
        s2 = s5;
        s3 = s4;
_L1:
        uiYesQuestionButton.setText(s1);
        uiDontknowQuestionButton.setText(s3);
        uiNoQuestionButton.setText(s2);
        uiProbablyQuestionButton.setText(s);
        uiProbablyNotQuestionButton.setText(s6);
        Exception exception;
        if (questionprogression.getStep() == 0)
        {
            uiBackButtonImage.setVisibility(4);
        } else
        {
            uiBackButtonImage.setVisibility(0);
        }
        updateAkinatorUI();
        hasAlreadyAnswered = false;
        return;
        exception;
        exception.printStackTrace();
        s6 = s8;
          goto _L1
    }

    private void winAnimation()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.5F);
        alphaanimation.setFillAfter(true);
        alphaanimation.setDuration(1000L);
        uiHomeButton.startAnimation(alphaanimation);
        buttonsYesNoDontKnow.startAnimation(alphaanimation);
        buttonsProbably.startAnimation(alphaanimation);
        uiBackButtonImage.startAnimation(alphaanimation);
        BackgroundSoundsBinder.sharedInstance().playPropose();
        uiLayoutBulleQuestion.setVisibility(8);
        uiStar.startAnimation(firstStepAnimation);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 2 && j == 0)
        {
            goToHome();
        }
    }

    public void onAnimationEnd(Animation animation)
    {
        if (animation == firstStepAnimation)
        {
            uiStar.startAnimation(secondStepAnimation);
        } else
        if (animation == secondStepAnimation)
        {
            System.gc();
            (new AsyncTask() {

                private Dialog mProgressDialog;
                private com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase mProposedObject;
                final QuestionActivity this$0;

                protected transient Integer doInBackground(Void avoid[])
                {
                    if (AkConfigFactory.sharedInstance().isPlayWithMyworldActivated())
                    {
                        return Integer.valueOf(SessionFactory.sharedInstance().getSession().getObjectForPropositionWithMinibaseEnabled(mProposedObject));
                    } else
                    {
                        return Integer.valueOf(SessionFactory.sharedInstance().getSession().getObjectForProposition(mProposedObject));
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
                        transition.listWsTransition();
                        return;
                    } else
                    {
                        Toast.makeText(QuestionActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
                    mProgressDialog = CustomLoadingDialog.show(QuestionActivity.this);
                }

            
            {
                this$0 = QuestionActivity.this;
                super();
                mProgressDialog = null;
                mProposedObject = new com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        uiStar.setVisibility(0);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        super.goToHome();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (mIsRebooting)
        {
            return;
        }
        setContentView(0x7f030030);
        uiMainLayout = findViewById(0x7f0d0085);
        buttonsYesNoDontKnow = (LinearLayout)findViewById(0x7f0d0198);
        buttonsProbably = (LinearLayout)findViewById(0x7f0d019a);
        uiBackButtonImage = (ImageView)findViewById(0x7f0d00ba);
        uiYesQuestionButton = (Button)findViewById(0x7f0d019b);
        uiDontknowQuestionButton = (Button)findViewById(0x7f0d019c);
        uiNoQuestionButton = (Button)findViewById(0x7f0d019d);
        uiProbablyQuestionButton = (Button)findViewById(0x7f0d019f);
        uiProbablyNotQuestionButton = (Button)findViewById(0x7f0d01a0);
        uiQuestionTextView = (TextView)findViewById(0x7f0d00ca);
        uiQuestionCounterText = (TextView)findViewById(0x7f0d0199);
        uiChildProtectionInGame = (ImageView)findViewById(0x7f0d0196);
        Object obj;
        com.digidust.elokence.akinator.factories.AkGameFactory.BestQuestion bestquestion;
        if (AkConfigFactory.sharedInstance().isChildProtectEnabled())
        {
            uiChildProtectionInGame.setImageResource(0x7f0201db);
        } else
        {
            uiChildProtectionInGame.setImageResource(0x7f0201dc);
        }
        uiLayoutBulleQuestion = (RelativeLayout)findViewById(0x7f0d0181);
        firstStepAnimation = AnimationUtils.loadAnimation(this, 0x7f04001c);
        secondStepAnimation = AnimationUtils.loadAnimation(this, 0x7f04001f);
        AkSessionFactory.sharedInstance().noMoreQuestions(false);
        firstStepAnimation.setAnimationListener(this);
        secondStepAnimation.setAnimationListener(this);
        upgradeView = getIntent().getBooleanExtra("upgradeView", false);
        uiYesQuestionButton.setTypeface(tf);
        uiDontknowQuestionButton.setTypeface(tf);
        uiNoQuestionButton.setTypeface(tf);
        uiProbablyQuestionButton.setTypeface(tf);
        uiProbablyNotQuestionButton.setTypeface(tf);
        uiQuestionTextView.setTypeface(tf);
        uiQuestionCounterText.setTypeface(tf);
        addTextView(uiYesQuestionButton);
        addTextView(uiDontknowQuestionButton);
        addTextView(uiNoQuestionButton);
        addTextView(uiProbablyQuestionButton);
        addTextView(uiProbablyNotQuestionButton);
        addTextView(uiQuestionTextView);
        addTextView(uiQuestionCounterText);
        updateTextViewsSize();
        try
        {
            if (SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() == 0)
            {
                AkSessionFactory.sharedInstance().setCharacterNameProposed("");
                AkGameFactory.sharedInstance().setWinFirstTry(true);
                AkSessionFactory.sharedInstance().setCharacterAlreadyProposed(false);
                AkSessionFactory.sharedInstance().setPhotoAlreadyProposed(false);
                AkSessionFactory.sharedInstance().setQuestionAlreadyProposed(false);
                AkSessionFactory.sharedInstance().setStepOfLastProp(0);
                AkSessionFactory.sharedInstance().setLastQuestion(null);
                AkGameFactory.sharedInstance().resetBestQuestions();
                AkGameFactory.sharedInstance().canShareAwardImage(false);
                AkGameFactory.sharedInstance().setFirstGameOverCreation(true);
                AkGameFactory.sharedInstance().setDelaiMoyen(0);
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("last_game", "N");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
            goToHome(false);
            return;
        }
        bundle = AkGameFactory.sharedInstance().getBestQuestion1();
        obj = AkGameFactory.sharedInstance().getBestQuestion2();
        bestquestion = AkGameFactory.sharedInstance().getBestQuestion3();
        mBestQuestions[0] = bundle;
        mBestQuestions[1] = ((com.digidust.elokence.akinator.factories.AkGameFactory.BestQuestion) (obj));
        mBestQuestions[2] = bestquestion;
        try
        {
            uiQuestionCounterText.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("QUESTION_N")).append(" ").append(SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() + 1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
            bundle = new Message();
            bundle.what = 1;
            mHandler.sendMessage(bundle);
        }
        uiBackButtonImage.setOnClickListener(mBackClickListener);
        uiYesQuestionButton.setOnClickListener(mYesClickListener);
        uiDontknowQuestionButton.setOnClickListener(mDontknowClickListener);
        uiNoQuestionButton.setOnClickListener(mNoClickListener);
        uiProbablyQuestionButton.setOnClickListener(mProbablyClickListener);
        uiProbablyNotQuestionButton.setOnClickListener(mProbablyNotClickListener);
        bundle = AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground());
        setImage(0x7f0d00c5, AkSceneryFactory.sharedInstance().getAkiBitmap("akinator_defi"));
        setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(AkConfigFactory.sharedInstance().getHat(), "akinator_defi"));
        setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(AkConfigFactory.sharedInstance().getCloth(), "akinator_defi"));
        getResources().getDimensionPixelSize(0x7f09014d);
        uiBackground1 = new TileFloatView(0, this, ((com.digidust.elokence.akinator.factories.AkSceneryFactory.BackgroundSet) (bundle)).background1, getScreenWidth(), false, true, true, -1);
        uiBackground2 = new TileFloatView(1, this, ((com.digidust.elokence.akinator.factories.AkSceneryFactory.BackgroundSet) (bundle)).background2, getScreenWidth(), false, false, true, -1);
        uiBackground3 = new TileFloatView(2, this, ((com.digidust.elokence.akinator.factories.AkSceneryFactory.BackgroundSet) (bundle)).background3, getScreenWidth(), false, true, true, -1);
        uiLoadingBarQuestions = (ProgressBar)findViewById(0x7f0d019e);
        obj = LayoutInflater.from(getApplicationContext()).inflate(0x7f03006d, null);
        ((View) (obj)).setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        uiStar = (ImageView)((View) (obj)).findViewById(0x7f0d029e);
        uiStar.setImageBitmap(((com.digidust.elokence.akinator.factories.AkSceneryFactory.BackgroundSet) (bundle)).star);
        uiStar.setVisibility(4);
        if (uiBackground1 != null)
        {
            ((RelativeLayout)uiMainLayout).addView(uiBackground1, 0);
        }
        if (uiBackground2 != null)
        {
            ((RelativeLayout)uiMainLayout).addView(uiBackground2, 0);
        }
        if (uiBackground3 != null)
        {
            ((RelativeLayout)uiMainLayout).addView(uiBackground3, 0);
        }
        ((RelativeLayout)uiMainLayout).addView(((View) (obj)), 1);
        updateQuestionUI();
        processing.processOnCreate();
    }

    protected void onDestroy()
    {
        if (!mIsRebooting)
        {
            if (uiBackground1 != null)
            {
                uiBackground1.recycleAllBitmaps();
            }
            if (uiBackground2 != null)
            {
                uiBackground2.recycleAllBitmaps();
            }
            if (uiBackground3 != null)
            {
                uiBackground3.recycleAllBitmaps();
            }
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        if (!mIsRebooting)
        {
            processing.processOnPause();
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (mIsRebooting)
        {
            return;
        }
        if (upgradeView)
        {
            upgradeView = false;
            if (uiBackground1 != null)
            {
                uiBackground1.measureAll();
            }
            if (uiBackground2 != null)
            {
                uiBackground2.measureAll();
            }
            if (uiBackground3 != null)
            {
                uiBackground3.measureAll();
            }
        }
        processing.processOnResume();
    }









/*
    static boolean access$202(QuestionActivity questionactivity, boolean flag)
    {
        questionactivity.hasAlreadyAnswered = flag;
        return flag;
    }

*/







}

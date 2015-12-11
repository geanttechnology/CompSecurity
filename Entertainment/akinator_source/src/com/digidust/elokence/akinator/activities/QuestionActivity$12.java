// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.Calendar;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            QuestionActivity

class mMilliStartEnd extends AsyncTask
{

    long mMilliStartBegin;
    long mMilliStartEnd;
    private com.elokence.limuleapi.ression mProgress;
    private Dialog mProgressDialog;
    final QuestionActivity this$0;
    final int val$answerIdx;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().answerQuestionWithTag(val$answerIdx));
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
                if (f > QuestionActivity.access$500(QuestionActivity.this)[0].mDiffTrouvitude)
                {
                    QuestionActivity.access$500(QuestionActivity.this)[2].copy(QuestionActivity.access$500(QuestionActivity.this)[1]);
                    QuestionActivity.access$500(QuestionActivity.this)[1].copy(QuestionActivity.access$500(QuestionActivity.this)[0]);
                    QuestionActivity.access$500(QuestionActivity.this)[0].mIndice = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() - 1;
                    QuestionActivity.access$500(QuestionActivity.this)[0].mDiffTrouvitude = f;
                    QuestionActivity.access$500(QuestionActivity.this)[0].mQuestion = AkSessionFactory.sharedInstance().getLastQuestion();
                } else
                if (f <= QuestionActivity.access$500(QuestionActivity.this)[0].mDiffTrouvitude && f > QuestionActivity.access$500(QuestionActivity.this)[1].mDiffTrouvitude)
                {
                    QuestionActivity.access$500(QuestionActivity.this)[2].copy(QuestionActivity.access$500(QuestionActivity.this)[1]);
                    QuestionActivity.access$500(QuestionActivity.this)[1].mIndice = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() - 1;
                    QuestionActivity.access$500(QuestionActivity.this)[1].mDiffTrouvitude = f;
                    QuestionActivity.access$500(QuestionActivity.this)[1].mQuestion = AkSessionFactory.sharedInstance().getLastQuestion();
                } else
                if (f <= QuestionActivity.access$500(QuestionActivity.this)[1].mDiffTrouvitude && f > QuestionActivity.access$500(QuestionActivity.this)[2].mDiffTrouvitude)
                {
                    QuestionActivity.access$500(QuestionActivity.this)[2].mIndice = SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() - 1;
                    QuestionActivity.access$500(QuestionActivity.this)[2].mDiffTrouvitude = f;
                    QuestionActivity.access$500(QuestionActivity.this)[2].mQuestion = AkSessionFactory.sharedInstance().getLastQuestion();
                }
            }
            AkGameFactory.sharedInstance().updateBestQuestion1(QuestionActivity.access$500(QuestionActivity.this)[0]);
            AkGameFactory.sharedInstance().updateBestQuestion2(QuestionActivity.access$500(QuestionActivity.this)[1]);
            AkGameFactory.sharedInstance().updateBestQuestion3(QuestionActivity.access$500(QuestionActivity.this)[2]);
            if (AkSessionFactory.sharedInstance().isAbleToFind())
            {
                uiHomeButton.setEnabled(false);
                QuestionActivity.access$600(QuestionActivity.this).setEnabled(false);
                QuestionActivity.access$700(QuestionActivity.this).setEnabled(false);
                QuestionActivity.access$800(QuestionActivity.this).setEnabled(false);
                QuestionActivity.access$900(QuestionActivity.this).setEnabled(false);
                QuestionActivity.access$1000(QuestionActivity.this).setEnabled(false);
                QuestionActivity.access$1100(QuestionActivity.this).setEnabled(false);
    /* block-local class not found */
    class _cls1 {}

                QuestionActivity.access$1300(QuestionActivity.this, new _cls1());
                return;
            } else
            {
                QuestionActivity.access$100(QuestionActivity.this);
                return;
            }
        } else
        if (integer.intValue() == 600 || integer.intValue() == 610)
        {
            QuestionActivity.access$202(QuestionActivity.this, false);
            integer = new android.app.<init>(QuestionActivity.this);
            integer.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_QUE_VEUX_TU_FAIRE"));
            integer.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("CONTINUER_LA_PARTIE"), new _cls2());
            integer.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("COMMENCER_UNE_NOUVELLE_PARTIE"), new _cls3());
            integer.setCancelable(false);
            integer.show();
            return;
        } else
        {
            QuestionActivity.access$202(QuestionActivity.this, false);
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

    _cls3()
    {
        this$0 = final_questionactivity;
        val$answerIdx = I.this;
        super();
        mProgressDialog = null;
        mProgress = new com.elokence.limuleapi.ression();
        mMilliStartBegin = 0L;
        mMilliStartEnd = 0L;
    }
}

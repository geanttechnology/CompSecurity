// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.os.AsyncTask;
import android.widget.Toast;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            QuestionActivity

class questionProgression extends AsyncTask
{

    private Dialog mProgressDialog;
    private com.elokence.limuleapi.gression questionProgression;
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
            QuestionActivity.access$100(QuestionActivity.this);
            return;
        }
        if (integer.intValue() == 600 || integer.intValue() == 610)
        {
            QuestionActivity.access$202(QuestionActivity.this, false);
            integer = new android.app.(QuestionActivity.this);
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
    }

    _cls2()
    {
        this$0 = QuestionActivity.this;
        super();
        mProgressDialog = null;
        questionProgression = new com.elokence.limuleapi.gression();
    }
}

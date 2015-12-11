// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.os.AsyncTask;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.transitions.QuestionTransition;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            QuestionActivity

class nit> extends AsyncTask
{

    private Dialog mProgressDialog;
    private com.elokence.limuleapi.leObjectMinibase mProposedObject;
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
            QuestionActivity.access$1400(QuestionActivity.this).listWsTransition();
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

    Transition()
    {
        this$0 = QuestionActivity.this;
        super();
        mProgressDialog = null;
        mProposedObject = new com.elokence.limuleapi.leObjectMinibase();
    }
}

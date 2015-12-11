// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            FreemiumPopularityActivity, QuestionActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    final FreemiumPopularityActivity this$0;

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
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
        }
        if (integer.intValue() == 0 || integer.intValue() == 800)
        {
            integer = new Intent(FreemiumPopularityActivity.this, com/digidust/elokence/akinator/activities/QuestionActivity);
            integer.putExtra("showAd", true);
            startActivity(integer);
            finish();
            return;
        }
        if (integer.intValue() == 500)
        {
            Toast.makeText(FreemiumPopularityActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_RELANCE"), 1).show();
            return;
        } else
        {
            Toast.makeText(FreemiumPopularityActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
        mProgressDialog = CustomLoadingDialog.show(FreemiumPopularityActivity.this);
    }

    ()
    {
        this$0 = FreemiumPopularityActivity.this;
        super();
        mProgressDialog = null;
    }
}

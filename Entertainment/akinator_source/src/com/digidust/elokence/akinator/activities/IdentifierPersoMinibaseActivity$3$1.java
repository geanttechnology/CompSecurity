// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            QuestionActivity, IdentifierPersoMinibaseActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    final is._cls0 this$1;

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

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
        mProgressDialog = null;
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/IdentifierPersoMinibaseActivity$3

/* anonymous class */
    class IdentifierPersoMinibaseActivity._cls3
        implements android.view.View.OnClickListener
    {

        final IdentifierPersoMinibaseActivity this$0;

        public void onClick(View view)
        {
            (new IdentifierPersoMinibaseActivity._cls3._cls1()).execute(new Void[0]);
        }

            
            {
                this$0 = IdentifierPersoMinibaseActivity.this;
                super();
            }
    }

}

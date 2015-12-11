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
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity, ProposeAjoutMBActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    final is._cls0 this$1;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().validateObjectWithId(((com.elokence.limuleapi.t)SessionFactory.sharedInstance().getSession().getCurrentProposedObject()).getIdSession()));
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
            integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/GameOverActivity);
            if (AkGameFactory.sharedInstance().getAkinatorStatus() == 2)
            {
                AkGameFactory.sharedInstance().setGameOverActivityState(1);
            } else
            {
                AkGameFactory.sharedInstance().setGameOverActivityState(11);
            }
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

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
        mProgressDialog = null;
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/ProposeAjoutMBActivity$2

/* anonymous class */
    class ProposeAjoutMBActivity._cls2
        implements android.view.View.OnClickListener
    {

        final ProposeAjoutMBActivity this$0;

        public void onClick(View view)
        {
            if (!AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated())
            {
                view = new Intent(ProposeAjoutMBActivity.this, com/digidust/elokence/akinator/activities/GameOverActivity);
                AkGameFactory.sharedInstance().setGameOverActivityState(11);
                startActivity(view);
                finish();
                return;
            } else
            {
                (new ProposeAjoutMBActivity._cls2._cls1()).execute(new Void[0]);
                return;
            }
        }

            
            {
                this$0 = ProposeAjoutMBActivity.this;
                super();
            }
    }

}

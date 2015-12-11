// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            QuestionActivity, ContinueProcessActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    final is._cls0 this$1;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().excludeProposition());
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
            integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/QuestionActivity);
            integer.putExtra("upgradeView", true);
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

    // Unreferenced inner class com/digidust/elokence/akinator/activities/ContinueProcessActivity$1

/* anonymous class */
    class ContinueProcessActivity._cls1
        implements android.view.View.OnClickListener
    {

        final ContinueProcessActivity this$0;

        public void onClick(View view)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            (new ContinueProcessActivity._cls1._cls1()).execute(new Void[0]);
        }

            
            {
                this$0 = ContinueProcessActivity.this;
                super();
            }
    }

}

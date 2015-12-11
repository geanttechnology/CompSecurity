// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            OneCharacterProposalActivity

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
            if (AkConfigFactory.sharedInstance().isPaid() || AkConfigFactory.sharedInstance().isFreemium() && AkGameFactory.sharedInstance().isUnlocked() || canGoToQuestion)
            {
                OneCharacterProposalActivity.access$200(_fld0);
                return;
            } else
            {
                canGoToQuestion = true;
                return;
            }
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

    // Unreferenced inner class com/digidust/elokence/akinator/activities/OneCharacterProposalActivity$5

/* anonymous class */
    class OneCharacterProposalActivity._cls5
        implements android.view.View.OnClickListener
    {

        final OneCharacterProposalActivity this$0;

        public void onClick(View view)
        {
            AkConfigFactory.sharedInstance().setCanReShowAlert(true);
            BackgroundSoundsBinder.sharedInstance().playBip();
            (new OneCharacterProposalActivity._cls5._cls1()).execute(new Void[0]);
            canGoToQuestion = true;
        }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super();
            }
    }

}

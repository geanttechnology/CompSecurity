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
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            QuestionActivity, PostHomeActivity

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
            AkGameFactory.sharedInstance().setAkinatorStatus(0);
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

    // Unreferenced inner class com/digidust/elokence/akinator/activities/PostHomeActivity$5

/* anonymous class */
    class PostHomeActivity._cls5
        implements android.view.View.OnClickListener
    {

        final PostHomeActivity this$0;

        public void onClick(View view)
        {
            if (!AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated() && !AkConfigFactory.sharedInstance().isPlayWithMyworldActivated())
            {
                Toast.makeText(getApplicationContext(), TraductionFactory.sharedInstance().getTraductionFromToken("SELECTIONNER_UNE_BASE"), 1).show();
            }
            AkConfigFactory.sharedInstance().setCanReShowAlert(true);
            BackgroundSoundsBinder.sharedInstance().playStartPlaying();
            if (!AkConfigFactory.sharedInstance().isOnline())
            {
                Toast.makeText(PostHomeActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("VERIFIEZ_VOTRE_CONNEXION_ET_REESSAYEZ"), 0).show();
                return;
            } else
            {
                (new PostHomeActivity._cls5._cls1()).execute(new Void[0]);
                return;
            }
        }

            
            {
                this$0 = PostHomeActivity.this;
                super();
            }
    }

}

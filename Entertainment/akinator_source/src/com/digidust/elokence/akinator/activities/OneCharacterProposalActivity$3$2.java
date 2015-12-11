// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.digidust.elokence.akinator.db.AkDBAdapter;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            OneCharacterProposalActivity, ProposeAjoutMBActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    final is._cls0 this$1;
    final boolean val$finalIsAwardAlreadyWon;

    protected transient Integer doInBackground(Void avoid[])
    {
        if (val$finalIsAwardAlreadyWon)
        {
            return Integer.valueOf(SessionFactory.sharedInstance().getSession().validateObjectWithId(OneCharacterProposalActivity.access$100(_fld0).getIdSession()));
        } else
        {
            return Integer.valueOf(SessionFactory.sharedInstance().getSession().validateObjectWithIdWithJackpot(OneCharacterProposalActivity.access$100(_fld0).getIdSession()));
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
            goToCharacterFound();
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
        this$1 = final__pcls0;
        val$finalIsAwardAlreadyWon = Z.this;
        super();
        mProgressDialog = null;
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/OneCharacterProposalActivity$3

/* anonymous class */
    class OneCharacterProposalActivity._cls3
        implements android.view.View.OnClickListener
    {

        final OneCharacterProposalActivity this$0;

        public void onClick(View view)
        {
            com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase;
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("delai_question", String.valueOf(AkGameFactory.sharedInstance().getDelaiMoyen()));
            AkGameFactory.sharedInstance().setDelaiMoyen(0);
            AkGameFactory.sharedInstance().setAkinatorStatus(2);
            AkGameFactory.sharedInstance().addOneWonGame();
            BackgroundSoundsBinder.sharedInstance().playWin();
            proposedlimuleobjectminibase = OneCharacterProposalActivity.access$100(OneCharacterProposalActivity.this);
            AkSessionFactory.sharedInstance().setCharacterNameProposed(proposedlimuleobjectminibase.getName());
            if (AkGameFactory.sharedInstance().winFirstTry())
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("succes_games");
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("last_game", "S");
            }
            if (OneCharacterProposalActivity.access$100(OneCharacterProposalActivity.this).getElementMinibaseId() != -1)
            {
                AkAnalyticsFactory.sharedInstance().logAccepteProcheMW();
                (new OneCharacterProposalActivity._cls3._cls1()).execute(new Void[0]);
                return;
            }
            if (OneCharacterProposalActivity.access$100(OneCharacterProposalActivity.this).isMyWorldAddable() && AkConfigFactory.sharedInstance().isPlayWithMyworldActivated()) goto _L2; else goto _L1
_L1:
            Object obj2;
            boolean flag;
            boolean flag1;
            flag1 = true;
            flag = flag1;
            if (!AkGameFactory.sharedInstance().winFirstTry())
            {
                break MISSING_BLOCK_LABEL_216;
            }
            view = null;
            obj2 = null;
            Object obj = new AkDBAdapter(OneCharacterProposalActivity.this);
            flag = ((AkDBAdapter) (obj)).isAwardAlreadyWonForCharacter(TraductionFactory.sharedInstance().getApplicationLanguage(), proposedlimuleobjectminibase.getIdBase());
            flag1 = flag;
            flag = flag1;
            if (obj != null)
            {
                ((AkDBAdapter) (obj)).close();
                flag = flag1;
            }
_L3:
            (flag. new OneCharacterProposalActivity._cls3._cls2()).execute(new Void[0]);
            AkGameFactory.sharedInstance().addOneCelebCharacterPlayed();
            return;
            Object obj1;
            obj1;
            obj = obj2;
_L6:
            view = ((View) (obj));
            ((Exception) (obj1)).printStackTrace();
            flag = flag1;
            if (obj != null)
            {
                ((AkDBAdapter) (obj)).close();
                flag = flag1;
            }
              goto _L3
            obj;
_L5:
            if (view != null)
            {
                view.close();
            }
            throw obj;
_L2:
            view = new Intent(OneCharacterProposalActivity.this, com/digidust/elokence/akinator/activities/ProposeAjoutMBActivity);
            startActivity(view);
            finish();
            return;
            obj1;
            view = ((View) (obj));
            obj = obj1;
            if (true) goto _L5; else goto _L4
_L4:
            obj1;
              goto _L6
        }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super();
            }

        // Unreferenced inner class com/digidust/elokence/akinator/activities/OneCharacterProposalActivity$3$1

/* anonymous class */
        class OneCharacterProposalActivity._cls3._cls1 extends AsyncTask
        {

            private Dialog mProgressDialog;
            final OneCharacterProposalActivity._cls3 this$1;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(MinibaseFactory.sharedInstance().validateMBCharacter(OneCharacterProposalActivity.access$100(this$0).getElementMinibaseId()));
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
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("mw_guessed");
                    goToCharacterFound();
                    return;
                } else
                {
                    Toast.makeText(this$0, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
                mProgressDialog = CustomLoadingDialog.show(this$0);
            }

                    
                    {
                        this$1 = OneCharacterProposalActivity._cls3.this;
                        super();
                        mProgressDialog = null;
                    }
        }

    }

}

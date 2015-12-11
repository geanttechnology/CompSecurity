// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            IdentifierPersoMinibaseActivity, ContinueProcessActivity, Soundlike1Activity, SeveralCharactersProposalActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    private ArrayList mProposedObjectList;
    final is._cls0 this$1;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().getObjectsWithListSize(15, mProposedObjectList));
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
            if (mProposedObjectList.size() > 0 && ((com.elokence.limuleapi.Minibase)mProposedObjectList.get(0)).isMyWorldAddable() || ((com.elokence.limuleapi.Minibase)mProposedObjectList.get(0)).getElementMinibaseId() != -1)
            {
                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/IdentifierPersoMinibaseActivity);
                integer.putExtra("ActivityMode", 2);
            } else
            if (mProposedObjectList.size() == 1)
            {
                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/Soundlike1Activity);
            } else
            {
                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/SeveralCharactersProposalActivity);
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
        mProposedObjectList = new ArrayList();
        mProgressDialog = null;
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/ContinueProcessActivity$2

/* anonymous class */
    class ContinueProcessActivity._cls2
        implements android.view.View.OnClickListener
    {

        final ContinueProcessActivity this$0;

        public void onClick(View view)
        {
            AkGameFactory.sharedInstance().setAkinatorStatus(1);
            BackgroundSoundsBinder.sharedInstance().playBip();
            if (SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects() != null && SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().size() > 0 && (((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().get(0)).isMyWorldAddable() || ((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().get(0)).getElementMinibaseId() != -1))
            {
                view = new Intent(ContinueProcessActivity.this, com/digidust/elokence/akinator/activities/IdentifierPersoMinibaseActivity);
                view.putExtra("ActivityMode", 2);
                startActivity(view);
                finish();
                return;
            } else
            {
                (new ContinueProcessActivity._cls2._cls1()).execute(new Void[0]);
                return;
            }
        }

            
            {
                this$0 = ContinueProcessActivity.this;
                super();
            }
    }

}

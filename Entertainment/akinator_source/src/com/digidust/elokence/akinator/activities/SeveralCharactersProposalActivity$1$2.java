// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.digidust.elokence.akinator.adapters.AkCharacterAdapter;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SeveralCharactersProposalActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    final is._cls0 this$1;
    final int val$positionOfFirstSelectedElement;

    protected transient Integer doInBackground(Void avoid[])
    {
        int i = ((com.elokence.limuleapi.oposalActivity)SeveralCharactersProposalActivity.access$000(_fld0).getItem(val$positionOfFirstSelectedElement)).ion();
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().validateObjectWithId(i));
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
            BackgroundSoundsBinder.sharedInstance().playWin();
            SeveralCharactersProposalActivity.access$100(_fld0);
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
        val$positionOfFirstSelectedElement = I.this;
        super();
        mProgressDialog = null;
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/SeveralCharactersProposalActivity$1

/* anonymous class */
    class SeveralCharactersProposalActivity._cls1
        implements android.view.View.OnClickListener
    {

        final SeveralCharactersProposalActivity this$0;

        public void onClick(final View listOfIdBase)
        {
            if (SeveralCharactersProposalActivity.access$000(SeveralCharactersProposalActivity.this).getSelectedItemsIndex().size() >= 1)
            {
                listOfIdBase = new ArrayList();
                Integer integer;
                for (Iterator iterator = SeveralCharactersProposalActivity.access$000(SeveralCharactersProposalActivity.this).getSelectedItemsIndex().iterator(); iterator.hasNext(); listOfIdBase.add(Integer.valueOf(((com.elokence.limuleapi.Session.LimuleObject)SeveralCharactersProposalActivity.access$000(SeveralCharactersProposalActivity.this).getItem(integer.intValue())).getIdBase())))
                {
                    integer = (Integer)iterator.next();
                }

                if (SeveralCharactersProposalActivity.access$000(SeveralCharactersProposalActivity.this).getSelectedItemsIndex().size() > 1)
                {
                    (new SeveralCharactersProposalActivity._cls1._cls1()).execute(new Void[0]);
                }
                (((Integer)SeveralCharactersProposalActivity.access$000(SeveralCharactersProposalActivity.this).getSelectedItemsIndex().iterator().next()).intValue(). new SeveralCharactersProposalActivity._cls1._cls2()).execute(new Void[0]);
            }
        }

            
            {
                this$0 = SeveralCharactersProposalActivity.this;
                super();
            }

        // Unreferenced inner class com/digidust/elokence/akinator/activities/SeveralCharactersProposalActivity$1$1

/* anonymous class */
        class SeveralCharactersProposalActivity._cls1._cls1 extends AsyncTask
        {

            final SeveralCharactersProposalActivity._cls1 this$1;
            final ArrayList val$listOfIdBase;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(SessionFactory.sharedInstance().getSession().reportDuplicatesWithArray(listOfIdBase, false));
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

                    
                    {
                        this$1 = SeveralCharactersProposalActivity._cls1.this;
                        listOfIdBase = arraylist;
                        super();
                    }
        }

    }

}

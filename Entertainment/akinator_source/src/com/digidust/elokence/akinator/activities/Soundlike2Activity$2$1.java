// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.digidust.elokence.akinator.adapters.AkSoundlikeAdapter;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            Soundlike2Activity, GameOverActivity

class val.listOfIdBase extends AsyncTask
{

    final doInBackground this$1;
    final ArrayList val$listOfIdBase;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().reportDuplicatesWithArray(val$listOfIdBase, true));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$listOfIdBase = ArrayList.this;
        super();
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/Soundlike2Activity$2

/* anonymous class */
    class Soundlike2Activity._cls2
        implements android.view.View.OnClickListener
    {

        final Soundlike2Activity this$0;

        public void onClick(View view)
        {
            if (Soundlike2Activity.access$000(Soundlike2Activity.this).getSelectedItemsIndex().size() > 0)
            {
                if (Soundlike2Activity.access$000(Soundlike2Activity.this).getSelectedItemsIndex().size() > 1)
                {
                    view = new ArrayList();
                    for (Iterator iterator = Soundlike2Activity.access$000(Soundlike2Activity.this).getSelectedItemsIndex().iterator(); iterator.hasNext(); view.add(Integer.valueOf(((com.elokence.limuleapi.Session.LimuleObject)Soundlike2Activity.access$000(Soundlike2Activity.this).getItem(((Integer)iterator.next()).intValue())).getIdBase()))) { }
                    (view. new Soundlike2Activity._cls2._cls1()).execute(new Void[0]);
                }
                (new Soundlike2Activity._cls2._cls2()).execute(new Void[0]);
            }
        }

            
            {
                this$0 = Soundlike2Activity.this;
                super();
            }

        // Unreferenced inner class com/digidust/elokence/akinator/activities/Soundlike2Activity$2$2

/* anonymous class */
        class Soundlike2Activity._cls2._cls2 extends AsyncTask
        {

            private Dialog mProgressDialog;
            final Soundlike2Activity._cls2 this$1;
            final int val$positionOfFirstSelectedElement;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(SessionFactory.sharedInstance().getSession().soundlikeAcceptanceObjectAtIndex(positionOfFirstSelectedElement));
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
                    integer = (com.elokence.limuleapi.Session.LimuleObject)Soundlike2Activity.access$100(this$0).get(positionOfFirstSelectedElement);
                    AkGameFactory.sharedInstance().addOneLostGame();
                    AkGameFactory.sharedInstance().setAkinatorStatus(1);
                    Intent intent = new Intent(this$0, com/digidust/elokence/akinator/activities/GameOverActivity);
                    AkGameFactory.sharedInstance().setGameOverActivityState(11);
                    intent.putExtra("keyAcceptance", integer.getName());
                    startActivity(intent);
                    finish();
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
                        this$1 = Soundlike2Activity._cls2.this;
                        positionOfFirstSelectedElement = i;
                        super();
                        mProgressDialog = null;
                    }
        }

    }

}

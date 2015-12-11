// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            Soundlike2Activity, Soundlike1Activity, Soundlike3Activity

class mProgressDialog extends AsyncTask
{

    private ArrayList mListOfObjects;
    private Dialog mProgressDialog;
    private String mSoundLikeFieldValue;
    final is._cls0 this$1;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().getObjectsFromString(mSoundLikeFieldValue, mListOfObjects));
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
            if (mListOfObjects.size() > 0)
            {
                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/Soundlike2Activity);
                integer.putExtra("keyListSsl", mListOfObjects);
                startActivity(integer);
                finish();
                return;
            } else
            {
                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/Soundlike3Activity);
                startActivity(integer);
                finish();
                return;
            }
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
        mSoundLikeFieldValue = Soundlike1Activity.access$000(_fld0).getText().toString();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
        mListOfObjects = new ArrayList();
        mProgressDialog = null;
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/Soundlike1Activity$1

/* anonymous class */
    class Soundlike1Activity._cls1
        implements android.view.View.OnClickListener
    {

        final Soundlike1Activity this$0;

        public void onClick(View view)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            if (Soundlike1Activity.access$000(Soundlike1Activity.this).getText().length() == 0)
            {
                Toast.makeText(Soundlike1Activity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LES_CHAMPS_NE_PEUVENT_ETRE_VIDES"), 0).show();
                return;
            }
            if (Soundlike1Activity.access$000(Soundlike1Activity.this).getText().length() > 100)
            {
                Toast.makeText(Soundlike1Activity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LE_NOM_NE_DOIT_PAS_DEPASSER_100_CHARACTERES"), 0).show();
                return;
            } else
            {
                AkSessionFactory.sharedInstance().setCharacterNameProposed(Soundlike1Activity.access$000(Soundlike1Activity.this).getText().toString());
                (new Soundlike1Activity._cls1._cls1()).execute(new Void[0]);
                return;
            }
        }

            
            {
                this$0 = Soundlike1Activity.this;
                super();
            }
    }

}

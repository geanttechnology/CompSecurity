// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AddPhotoActivity, GameOverActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    final AddPhotoActivity this$0;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().addPhotoToObjectWithId(mSelectedCharacter.getIdBase(), AddPhotoActivity.access$200(AddPhotoActivity.this)));
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
            MetricsSetAdapter.sharedInstance().incMetricCompteur("added_photo");
            AkSessionFactory.sharedInstance().setPhotoAlreadyProposed(true);
            integer = new Intent(AddPhotoActivity.this, com/digidust/elokence/akinator/activities/GameOverActivity);
            integer.putExtra("hasToDisplayPhotoAdded", true);
            startActivity(integer);
            finish();
            return;
        }
        if (integer.intValue() == 110)
        {
            integer = new android.app.(AddPhotoActivity.this);
            integer.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR"));
            integer.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("L_EXTENSION_NE_SEMBLE_PAS_CORRESPONDRE_A_UNE_IMAGE_VALIDE"));
    /* block-local class not found */
    class _cls1 {}

            integer.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new _cls1());
            integer.create().show();
            return;
        }
        if (integer.intValue() == 130)
        {
            integer = new android.app.(AddPhotoActivity.this);
            integer.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR"));
            integer.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("IMAGE_EN_COURS_DE_VALIDATION"));
    /* block-local class not found */
    class _cls2 {}

            integer.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new _cls2());
            integer.create().show();
            return;
        } else
        {
            Toast.makeText(AddPhotoActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
        mProgressDialog = CustomLoadingDialog.show(AddPhotoActivity.this);
    }

    _cls2()
    {
        this$0 = AddPhotoActivity.this;
        super();
        mProgressDialog = null;
    }
}

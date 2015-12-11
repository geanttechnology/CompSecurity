// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SearchQuestionActivity, AddQuestionActivity

class mListOfObjects extends AsyncTask
{

    private ArrayList mListOfObjects;
    private Dialog mProgressDialog;
    final SearchQuestionActivity this$0;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().getObjectsForQuestionWithListSize(10, mListOfObjects));
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
            integer = new Intent(SearchQuestionActivity.this, com/digidust/elokence/akinator/activities/AddQuestionActivity);
            startActivity(integer);
            finish();
            return;
        } else
        {
            Toast.makeText(SearchQuestionActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
        mProgressDialog = CustomLoadingDialog.show(SearchQuestionActivity.this);
    }

    ()
    {
        this$0 = SearchQuestionActivity.this;
        super();
        mProgressDialog = null;
        mListOfObjects = new ArrayList();
    }
}

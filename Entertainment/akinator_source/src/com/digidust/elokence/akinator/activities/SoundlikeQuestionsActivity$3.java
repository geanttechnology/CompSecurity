// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SoundlikeQuestionsActivity, AddQuestionActivity

class this._cls0
    implements android.widget.er
{

    final SoundlikeQuestionsActivity this$0;

    public void onItemClick(AdapterView adapterview, final View view, int i, long l)
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        (new AsyncTask() {

            private ArrayList mListOfObjects;
            private Dialog mProgressDialog;
            final SoundlikeQuestionsActivity._cls3 this$1;
            final com.elokence.limuleapi.Session.QuestionObject val$akQuestion;
            final View val$view;

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
                    integer = new Intent(this$0, com/digidust/elokence/akinator/activities/AddQuestionActivity);
                    integer.putExtra("question", akQuestion);
                    startActivity(integer);
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
                view.setBackgroundResource(0x7f02026a);
                mProgressDialog = CustomLoadingDialog.show(this$0);
            }

            
            {
                this$1 = SoundlikeQuestionsActivity._cls3.this;
                view = view1;
                akQuestion = questionobject;
                super();
                mProgressDialog = null;
                mListOfObjects = new ArrayList();
            }
        }).execute(new Void[0]);
    }

    _cls1.mListOfObjects()
    {
        this$0 = SoundlikeQuestionsActivity.this;
        super();
    }
}

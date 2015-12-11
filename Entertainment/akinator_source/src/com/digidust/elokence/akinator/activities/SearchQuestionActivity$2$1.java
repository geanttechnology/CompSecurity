// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SearchQuestionActivity, SoundlikeQuestionsActivity

class this._cls1
    implements android.content.ener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/SearchQuestionActivity$2

/* anonymous class */
    class SearchQuestionActivity._cls2
        implements android.view.View.OnClickListener
    {

        final SearchQuestionActivity this$0;

        public void onClick(final View mSearchQuestionFieldValue)
        {
            if (SearchQuestionActivity.access$100(SearchQuestionActivity.this).getText().length() == 0)
            {
                Toast.makeText(SearchQuestionActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("LES_CHAMPS_NE_PEUVENT_ETRE_VIDES"), 0).show();
                return;
            }
            mSearchQuestionFieldValue = SearchQuestionActivity.access$100(SearchQuestionActivity.this).getText().toString();
            if (mSearchQuestionFieldValue.contains(" "))
            {
                mSearchQuestionFieldValue = new android.app.AlertDialog.Builder(SearchQuestionActivity.this);
                mSearchQuestionFieldValue.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ESPACES_NON_AUTORISE_TAPE_MOT_PRINCIPAL_QUESTION"));
                mSearchQuestionFieldValue.setCancelable(false);
                mSearchQuestionFieldValue.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new SearchQuestionActivity._cls2._cls1());
                mSearchQuestionFieldValue.create().show();
                return;
            } else
            {
                (new SearchQuestionActivity._cls2._cls2()).execute(new Void[0]);
                return;
            }
        }

            
            {
                this$0 = SearchQuestionActivity.this;
                super();
            }

        // Unreferenced inner class com/digidust/elokence/akinator/activities/SearchQuestionActivity$2$2

/* anonymous class */
        class SearchQuestionActivity._cls2._cls2 extends AsyncTask
        {

            private ArrayList mListOfQuestions;
            private Dialog mProgressDialog;
            final SearchQuestionActivity._cls2 this$1;
            final String val$mSearchQuestionFieldValue;

            protected transient Integer doInBackground(Void avoid[])
            {
                if (mSearchQuestionFieldValue.length() > 10)
                {
                    return Integer.valueOf(SessionFactory.sharedInstance().getSession().getQuestionsFromString(mSearchQuestionFieldValue.substring(0, 10), mListOfQuestions));
                } else
                {
                    return Integer.valueOf(SessionFactory.sharedInstance().getSession().getQuestionsFromString(mSearchQuestionFieldValue, mListOfQuestions));
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
                    if (mListOfQuestions.size() > 0)
                    {
                        integer = new Intent(this$0, com/digidust/elokence/akinator/activities/SoundlikeQuestionsActivity);
                        startActivity(integer);
                        finish();
                        return;
                    } else
                    {
                        SearchQuestionActivity.access$200(this$0);
                        return;
                    }
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
                        this$1 = SearchQuestionActivity._cls2.this;
                        mSearchQuestionFieldValue = s;
                        super();
                        mProgressDialog = null;
                        mListOfQuestions = new ArrayList();
                    }
        }

    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity, AddQuestionActivity

class mProgressDialog extends AsyncTask
{

    private Dialog mProgressDialog;
    private String mQuestionText;
    final is._cls0 this$1;

    protected transient Integer doInBackground(ArrayList aarraylist[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().getSession().addNewQuestionWithLabelAndAnswers(mQuestionText, aarraylist[0]));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((ArrayList[])aobj);
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
            MetricsSetAdapter.sharedInstance().incMetricCompteur("added_questions");
            AkSessionFactory.sharedInstance().setQuestionAlreadyProposed(true);
            integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/GameOverActivity);
            integer.putExtra("hasToDisplayQuestionValide", true);
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
        mQuestionText = AddQuestionActivity.access$300(_fld0).getText().toString();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
        mProgressDialog = null;
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/AddQuestionActivity$2

/* anonymous class */
    class AddQuestionActivity._cls2
        implements android.view.View.OnClickListener
    {

        final AddQuestionActivity this$0;

        public void onClick(View view)
        {
            int i;
            BackgroundSoundsBinder.sharedInstance().playBip();
            view = new ArrayList();
            i = 0;
            if (AddQuestionActivity.access$100(AddQuestionActivity.this).size() != 1) goto _L2; else goto _L1
_L1:
            int j;
            j = 1;
            int k = ((AddQuestionActivity.LimuleObjectAnswer)AddQuestionActivity.access$100(AddQuestionActivity.this).get(0)).getAnswer();
            i = k;
            if (k == -2)
            {
                i = -1;
            }
            view.add(new com.elokence.limuleapi.Session.ObjectAnswer(i, ""));
_L4:
            if (j == 0)
            {
                break MISSING_BLOCK_LABEL_298;
            }
            if (AddQuestionActivity.access$200(AddQuestionActivity.this) != null)
            {
                (new AddQuestionActivity._cls2._cls1()).execute(new ArrayList[] {
                    view
                });
                return;
            }
            break; /* Loop/switch isn't completed */
_L2:
            int l = -2;
            Iterator iterator = AddQuestionActivity.access$100(AddQuestionActivity.this).iterator();
            do
            {
                j = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                AddQuestionActivity.LimuleObjectAnswer limuleobjectanswer = (AddQuestionActivity.LimuleObjectAnswer)iterator.next();
                int i1 = limuleobjectanswer.getAnswer();
                j = i;
                if (l != -2)
                {
                    j = i;
                    if (l != i1)
                    {
                        j = 1;
                    }
                }
                i = i1;
                if (i1 == -2)
                {
                    i = -1;
                }
                view.add(new com.elokence.limuleapi.Session.ObjectAnswer(i, ""));
                l = limuleobjectanswer.getAnswer();
                i = j;
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
            if (AddQuestionActivity.access$300(AddQuestionActivity.this).length() < 3)
            {
                AddQuestionActivity.access$400(AddQuestionActivity.this);
                return;
            }
            if (AddQuestionActivity.access$300(AddQuestionActivity.this).length() > 150)
            {
                AddQuestionActivity.access$500(AddQuestionActivity.this);
                return;
            } else
            {
                (new AddQuestionActivity._cls2._cls2()).execute(new ArrayList[] {
                    view
                });
                return;
            }
            showAtLeast2DifferentsAlert();
            return;
        }

            
            {
                this$0 = AddQuestionActivity.this;
                super();
            }

        // Unreferenced inner class com/digidust/elokence/akinator/activities/AddQuestionActivity$2$1

/* anonymous class */
        class AddQuestionActivity._cls2._cls1 extends AsyncTask
        {

            private Dialog mProgressDialog;
            final AddQuestionActivity._cls2 this$1;

            protected transient Integer doInBackground(ArrayList aarraylist[])
            {
                return Integer.valueOf(SessionFactory.sharedInstance().getSession().modifyQuestionWithId(AddQuestionActivity.access$200(this$0).getId(), AddQuestionActivity.access$200(this$0).getQuestion(), aarraylist[0]));
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((ArrayList[])aobj);
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
                    AkSessionFactory.sharedInstance().setQuestionAlreadyProposed(true);
                    integer = new Intent(this$0, com/digidust/elokence/akinator/activities/GameOverActivity);
                    integer.putExtra("hasToDisplayQuestionValide", true);
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
                mProgressDialog = CustomLoadingDialog.show(this$0);
            }

                    
                    {
                        this$1 = AddQuestionActivity._cls2.this;
                        super();
                        mProgressDialog = null;
                    }
        }

    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity, ReportActivity

class this._cls0
    implements android.view.
{

    final GameOverActivity this$0;

    public void onClick(View view)
    {
        if (moreAlertDialog != null && moreAlertDialog.isShowing())
        {
            moreAlertDialog.dismiss();
        }
        if (view == GameOverActivity.access$300(GameOverActivity.this))
        {
            (new AsyncTask() {

                private Dialog mProgressDialog;
                private ArrayList mReport;
                final GameOverActivity._cls16 this$1;

                protected transient Integer doInBackground(Void avoid[])
                {
                    return Integer.valueOf(SessionFactory.sharedInstance().getSession().getReport(mReport));
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
                        MetricsSetAdapter.sharedInstance().incMetricCompteur("game_reports");
                        integer = new Intent(this$0, com/digidust/elokence/akinator/activities/ReportActivity);
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
                this$1 = GameOverActivity._cls16.this;
                super();
                mProgressDialog = null;
                mReport = new ArrayList();
            }
            }).execute(new Void[0]);
        } else
        {
            if (view == GameOverActivity.access$400(GameOverActivity.this))
            {
                GameOverActivity.access$1300(GameOverActivity.this);
                return;
            }
            if (view == GameOverActivity.access$500(GameOverActivity.this))
            {
                if (AkSessionFactory.sharedInstance().hasAlreadyProposedQuestion())
                {
                    GameOverActivity.access$1400(GameOverActivity.this);
                    return;
                } else
                {
                    GameOverActivity.access$1500(GameOverActivity.this);
                    return;
                }
            }
        }
    }

    _cls1.mReport()
    {
        this$0 = GameOverActivity.this;
        super();
    }
}

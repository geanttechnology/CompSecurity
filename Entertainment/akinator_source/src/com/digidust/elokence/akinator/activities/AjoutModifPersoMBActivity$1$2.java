// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkFacesFactory;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AjoutModifPersoMBActivity

class this._cls1
    implements android.content.r
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity$1

/* anonymous class */
    class AjoutModifPersoMBActivity._cls1
        implements android.view.View.OnClickListener
    {

        final AjoutModifPersoMBActivity this$0;

        public void onClick(View view)
        {
            if (AjoutModifPersoMBActivity.access$000(AjoutModifPersoMBActivity.this).getText().length() == 0)
            {
                Toast.makeText(getApplicationContext(), TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER_DANS_MY_WORLD_DESCRIPTION"), 1).show();
            } else
            {
                AkConfigFactory.sharedInstance().setPlayWithMyworld(true);
                if (activityMode)
                {
                    if (AkFacesFactory.sharedInstance().getBalance() <= 0)
                    {
                        view = new android.app.AlertDialog.Builder(AjoutModifPersoMBActivity.this);
                        AkAnalyticsFactory.sharedInstance().logAffichagePropositionAchatCredits();
                        view.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_2_MY_WORLD_TITRE"));
                        view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_2_MY_WORLD_DESCRIPTION"));
                        view.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"), new AjoutModifPersoMBActivity._cls1._cls1());
                        view.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON_MERCI"), new AjoutModifPersoMBActivity._cls1._cls2());
                        view.create().show();
                        return;
                    }
                    if (MinibaseFactory.sharedInstance().hasMinibid())
                    {
                        (new AjoutModifPersoMBActivity._cls1._cls3()).execute(new Void[0]);
                        return;
                    } else
                    {
                        (new AjoutModifPersoMBActivity._cls1._cls4()).execute(new Void[0]);
                        return;
                    }
                }
                if (!activityMode)
                {
                    (new AjoutModifPersoMBActivity._cls1._cls5()).execute(new Void[0]);
                    return;
                }
            }
        }

            
            {
                this$0 = AjoutModifPersoMBActivity.this;
                super();
            }

        // Unreferenced inner class com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity$1$1

/* anonymous class */
        class AjoutModifPersoMBActivity._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final AjoutModifPersoMBActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                goToStoreFaces(true);
            }

                    
                    {
                        this$1 = AjoutModifPersoMBActivity._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity$1$3

/* anonymous class */
        class AjoutModifPersoMBActivity._cls1._cls3 extends AsyncTask
        {

            private String mNomEdit;
            private Dialog mProgressDialog;
            final AjoutModifPersoMBActivity._cls1 this$1;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(MinibaseFactory.sharedInstance().addCharacterToMinibase(mNomEdit, AjoutModifPersoMBActivity.access$100(this$0)));
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Integer integer)
            {
                boolean flag = false;
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
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("mw_added");
                    AkPlayerBelongingsFactory.sharedInstance().withdrawFaces();
                    integer = AkAnalyticsFactory.sharedInstance();
                    if (AjoutModifPersoMBActivity.access$100(this$0) != null)
                    {
                        flag = true;
                    }
                    integer.logAjoutProcheMW(flag);
                    AjoutModifPersoMBActivity.access$200(this$0);
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
                mNomEdit = AjoutModifPersoMBActivity.access$000(this$0).getText().toString();
            }

                    
                    {
                        this$1 = AjoutModifPersoMBActivity._cls1.this;
                        super();
                        mProgressDialog = null;
                    }
        }


        // Unreferenced inner class com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity$1$4

/* anonymous class */
        class AjoutModifPersoMBActivity._cls1._cls4 extends AsyncTask
        {

            private String mNomEdit;
            private Dialog mProgressDialog;
            final AjoutModifPersoMBActivity._cls1 this$1;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(MinibaseFactory.sharedInstance().createMiniBase(mNomEdit, AjoutModifPersoMBActivity.access$100(this$0)));
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Integer integer)
            {
                boolean flag = false;
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
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("mw_added");
                    AkPlayerBelongingsFactory.sharedInstance().withdrawFaces();
                    integer = AkAnalyticsFactory.sharedInstance();
                    if (AjoutModifPersoMBActivity.access$100(this$0) != null)
                    {
                        flag = true;
                    }
                    integer.logAjoutProcheMW(flag);
                    AjoutModifPersoMBActivity.access$200(this$0);
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
                mNomEdit = AjoutModifPersoMBActivity.access$000(this$0).getText().toString();
            }

                    
                    {
                        this$1 = AjoutModifPersoMBActivity._cls1.this;
                        super();
                        mProgressDialog = null;
                    }
        }


        // Unreferenced inner class com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity$1$5

/* anonymous class */
        class AjoutModifPersoMBActivity._cls1._cls5 extends AsyncTask
        {

            private String mNomEdit;
            private Dialog mProgressDialog;
            final AjoutModifPersoMBActivity._cls1 this$1;

            protected transient Integer doInBackground(Void avoid[])
            {
                return Integer.valueOf(MinibaseFactory.sharedInstance().modifyCharacterMinibase(AjoutModifPersoMBActivity.access$300(this$0).getElementMinibaseId(), mNomEdit, AjoutModifPersoMBActivity.access$100(this$0)));
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
                AjoutModifPersoMBActivity.access$300(this$0).setName(mNomEdit);
                if (integer.intValue() == 0)
                {
                    appelRetourModif();
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
                mNomEdit = AjoutModifPersoMBActivity.access$000(this$0).getText().toString();
            }

                    
                    {
                        this$1 = AjoutModifPersoMBActivity._cls1.this;
                        super();
                        mProgressDialog = null;
                    }
        }

    }

}

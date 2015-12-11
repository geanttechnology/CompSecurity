// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.transitions.ContinueProcessTransition;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, QuestionActivity, IdentifierPersoMinibaseActivity, Soundlike1Activity, 
//            SeveralCharactersProposalActivity

public class ContinueProcessActivity extends AkActivity
{

    private android.view.View.OnClickListener mNoClickListener;
    private android.view.View.OnClickListener mYesClickListener;
    private ContinueProcessTransition transition;
    private TextView uiBulleText;
    private Button uiNoContinueButton;
    private Button uiYesContinueButton;

    public ContinueProcessActivity()
    {
        transition = new ContinueProcessTransition(this);
        mYesClickListener = new android.view.View.OnClickListener() {

            final ContinueProcessActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                (new AsyncTask() {

                    private Dialog mProgressDialog;
                    final _cls1 this$1;

                    protected transient Integer doInBackground(Void avoid[])
                    {
                        return Integer.valueOf(SessionFactory.sharedInstance().getSession().excludeProposition());
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
                            integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/QuestionActivity);
                            integer.putExtra("upgradeView", true);
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
                    }

            
            {
                this$1 = _cls1.this;
                super();
                mProgressDialog = null;
            }
                }).execute(new Void[0]);
            }

            
            {
                this$0 = ContinueProcessActivity.this;
                super();
            }
        };
        mNoClickListener = new android.view.View.OnClickListener() {

            final ContinueProcessActivity this$0;

            public void onClick(View view)
            {
                AkGameFactory.sharedInstance().setAkinatorStatus(1);
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects() != null && SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().size() > 0 && (((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().get(0)).isMyWorldAddable() || ((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().get(0)).getElementMinibaseId() != -1))
                {
                    view = new Intent(ContinueProcessActivity.this, com/digidust/elokence/akinator/activities/IdentifierPersoMinibaseActivity);
                    view.putExtra("ActivityMode", 2);
                    startActivity(view);
                    finish();
                    return;
                } else
                {
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        private ArrayList mProposedObjectList;
                        final _cls2 this$1;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().getObjectsWithListSize(15, mProposedObjectList));
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
                                if (mProposedObjectList.size() > 0 && ((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)mProposedObjectList.get(0)).isMyWorldAddable() || ((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)mProposedObjectList.get(0)).getElementMinibaseId() != -1)
                                {
                                    integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/IdentifierPersoMinibaseActivity);
                                    integer.putExtra("ActivityMode", 2);
                                } else
                                if (mProposedObjectList.size() == 1)
                                {
                                    integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/Soundlike1Activity);
                                } else
                                {
                                    integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/SeveralCharactersProposalActivity);
                                }
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
                        }

            
            {
                this$1 = _cls2.this;
                super();
                mProposedObjectList = new ArrayList();
                mProgressDialog = null;
            }
                    }).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = ContinueProcessActivity.this;
                super();
            }
        };
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 2 && j == 0)
        {
            goToHome();
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        goToHome();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001e);
        uiBulleText = (TextView)findViewById(0x7f0d00ca);
        uiYesContinueButton = (Button)findViewById(0x7f0d00c2);
        uiNoContinueButton = (Button)findViewById(0x7f0d00c3);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        setImage(0x7f0d00c5, AkSceneryFactory.sharedInstance().getAkiBitmap("akinator_etonnement"));
        setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(AkConfigFactory.sharedInstance().getHat(), "akinator_etonnement"));
        setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(AkConfigFactory.sharedInstance().getCloth(), "akinator_etonnement"));
        uiYesContinueButton.setTypeface(tf);
        uiNoContinueButton.setTypeface(tf);
        uiBulleText.setTypeface(tf);
        addTextView(uiYesContinueButton);
        addTextView(uiNoContinueButton);
        addTextView(uiBulleText);
        updateTextViewsSize();
        uiYesContinueButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"));
        uiNoContinueButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NON"));
        uiBulleText.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ON_CONTINUE"));
        uiYesContinueButton.setOnClickListener(mYesClickListener);
        uiNoContinueButton.setOnClickListener(mNoClickListener);
    }
}

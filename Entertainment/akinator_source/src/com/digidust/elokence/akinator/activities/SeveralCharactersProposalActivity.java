// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.transitions.SeveralCharactersProposalTransition;
import com.digidust.elokence.akinator.adapters.AkCharacterAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity, Soundlike1Activity

public class SeveralCharactersProposalActivity extends AkActivity
{

    private AkCharacterAdapter akCharacterAdapter;
    private android.widget.AdapterView.OnItemClickListener mCharacterItemClickListener;
    private android.view.View.OnClickListener mCharacterNotInListButtonClickListener;
    private android.view.View.OnClickListener mValidateClickListener;
    private SeveralCharactersProposalTransition transition;
    private Button uiCharacterNotInListButton;
    private ListView uiCharactersList;
    private TextView uiListCharactersTitleText;
    private Button uiValidateButton;

    public SeveralCharactersProposalActivity()
    {
        transition = new SeveralCharactersProposalTransition(this);
        akCharacterAdapter = null;
        mValidateClickListener = new android.view.View.OnClickListener() {

            final SeveralCharactersProposalActivity this$0;

            public void onClick(View view)
            {
                if (akCharacterAdapter.getSelectedItemsIndex().size() >= 1)
                {
                    view = new ArrayList();
                    Integer integer;
                    for (Iterator iterator = akCharacterAdapter.getSelectedItemsIndex().iterator(); iterator.hasNext(); view.add(Integer.valueOf(((com.elokence.limuleapi.Session.LimuleObject)akCharacterAdapter.getItem(integer.intValue())).getIdBase())))
                    {
                        integer = (Integer)iterator.next();
                    }

                    if (akCharacterAdapter.getSelectedItemsIndex().size() > 1)
                    {
                        (view. new AsyncTask() {

                            final _cls1 this$1;
                            final ArrayList val$listOfIdBase;

                            protected transient Integer doInBackground(Void avoid[])
                            {
                                return Integer.valueOf(SessionFactory.sharedInstance().getSession().reportDuplicatesWithArray(listOfIdBase, false));
                            }

                            protected volatile Object doInBackground(Object aobj[])
                            {
                                return doInBackground((Void[])aobj);
                            }

            
            {
                this$1 = final__pcls1;
                listOfIdBase = ArrayList.this;
                super();
            }
                        }).execute(new Void[0]);
                    }
                    (((Integer)akCharacterAdapter.getSelectedItemsIndex().iterator().next()).intValue(). new AsyncTask() {

                        private Dialog mProgressDialog;
                        final _cls1 this$1;
                        final int val$positionOfFirstSelectedElement;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            int i = ((com.elokence.limuleapi.Session.ProposedLimuleObject)akCharacterAdapter.getItem(positionOfFirstSelectedElement)).getIdSession();
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().validateObjectWithId(i));
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
                                BackgroundSoundsBinder.sharedInstance().playWin();
                                goToLost();
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
                this$1 = final__pcls1;
                positionOfFirstSelectedElement = I.this;
                super();
                mProgressDialog = null;
            }
                    }).execute(new Void[0]);
                }
            }

            
            {
                this$0 = SeveralCharactersProposalActivity.this;
                super();
            }
        };
        mCharacterItemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final SeveralCharactersProposalActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (akCharacterAdapter.getSelectedItemsIndex().contains(Integer.valueOf(i)))
                {
                    akCharacterAdapter.removeSelectedItems(Integer.valueOf(i));
                    return;
                } else
                {
                    akCharacterAdapter.addSelectedItems(Integer.valueOf(i));
                    return;
                }
            }

            
            {
                this$0 = SeveralCharactersProposalActivity.this;
                super();
            }
        };
        mCharacterNotInListButtonClickListener = new android.view.View.OnClickListener() {

            final SeveralCharactersProposalActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                view = new Intent(SeveralCharactersProposalActivity.this, com/digidust/elokence/akinator/activities/Soundlike1Activity);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = SeveralCharactersProposalActivity.this;
                super();
            }
        };
    }

    private void goToLost()
    {
        AkGameFactory.sharedInstance().addOneLostGame();
        AkGameFactory.sharedInstance().setAkinatorStatus(1);
        Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
        AkGameFactory.sharedInstance().setGameOverActivityState(11);
        startActivity(intent);
        finish();
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
        if (mIsRebooting)
        {
            return;
        }
        setContentView(0x7f030034);
        if (SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects() != null && SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().size() > 0)
        {
            if (!AkSessionFactory.sharedInstance().isCharacterAlreadyProposed())
            {
                AkGameFactory.sharedInstance().addOneGame();
                AkSessionFactory.sharedInstance().setCharacterAlreadyProposed(true);
            }
            uiCharactersList = (ListView)findViewById(0x7f0d01ab);
            uiListCharactersTitleText = (TextView)findViewById(0x7f0d01aa);
            uiCharacterNotInListButton = (Button)findViewById(0x7f0d01a9);
            uiValidateButton = (Button)findViewById(0x7f0d01ac);
            setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
            uiCharacterNotInListButton.setTypeface(tf);
            uiValidateButton.setTypeface(tf);
            uiListCharactersTitleText.setTypeface(tf);
            addTextView(uiCharacterNotInListButton);
            addTextView(uiValidateButton);
            addTextView(uiListCharactersTitleText);
            updateTextViewsSize();
            uiCharacterNotInListButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MON_PERSONNAGE_NEST_PAS_DANS_LA_LISTE"));
            uiValidateButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("VALIDER"));
            uiListCharactersTitleText.setText(TraductionFactory.sharedInstance().getTraductionFromToken("SI_VOUS_VOYEZ_LE_PERSONNAGE_AUQUEL_VOUS_PENSIEZ_DANS_LA_LISTE_SUIVANTE_CLIQUEZ_SUR_SON_NOM"));
            bundle = SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects();
            if (bundle != null && bundle.size() > 1)
            {
                bundle.remove(0);
                akCharacterAdapter = new AkCharacterAdapter(this, bundle);
                uiCharactersList.setAdapter(akCharacterAdapter);
                akCharacterAdapter.notifyDataSetChanged();
                uiCharactersList.setDivider(null);
                uiCharactersList.setDividerHeight(0);
                uiValidateButton.setOnClickListener(mValidateClickListener);
                uiCharacterNotInListButton.setOnClickListener(mCharacterNotInListButtonClickListener);
                uiCharactersList.setOnItemClickListener(mCharacterItemClickListener);
                return;
            } else
            {
                Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
                bundle = new Message();
                bundle.what = 1;
                mHandler.sendMessage(bundle);
                return;
            }
        } else
        {
            Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
            bundle = new Message();
            bundle.what = 1;
            mHandler.sendMessage(bundle);
            return;
        }
    }


}

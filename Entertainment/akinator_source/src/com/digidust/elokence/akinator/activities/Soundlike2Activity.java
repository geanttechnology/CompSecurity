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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.adapters.AkSoundlikeAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, Soundlike3Activity, GameOverActivity

public class Soundlike2Activity extends AkActivity
{

    private AkSoundlikeAdapter akSoundlikeAdapter;
    private ArrayList mListOfObjects;
    private android.widget.AdapterView.OnItemClickListener mSoundlikeItemClickListener;
    private android.view.View.OnClickListener mSoundlikeNotInListButtonClickListener;
    private android.view.View.OnClickListener mValiderClickListener;
    private Button uiCharacterNotInListButton;
    private TextView uiListCharactersTitleText;
    private ListView uiSoundlikesList;
    private Button validateButton;

    public Soundlike2Activity()
    {
        mListOfObjects = new ArrayList();
        mSoundlikeNotInListButtonClickListener = new android.view.View.OnClickListener() {

            final Soundlike2Activity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                view = new Intent(Soundlike2Activity.this, com/digidust/elokence/akinator/activities/Soundlike3Activity);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = Soundlike2Activity.this;
                super();
            }
        };
        mValiderClickListener = new android.view.View.OnClickListener() {

            final Soundlike2Activity this$0;

            public void onClick(View view)
            {
                if (akSoundlikeAdapter.getSelectedItemsIndex().size() > 0)
                {
                    if (akSoundlikeAdapter.getSelectedItemsIndex().size() > 1)
                    {
                        view = new ArrayList();
                        for (Iterator iterator = akSoundlikeAdapter.getSelectedItemsIndex().iterator(); iterator.hasNext(); view.add(Integer.valueOf(((com.elokence.limuleapi.Session.LimuleObject)akSoundlikeAdapter.getItem(((Integer)iterator.next()).intValue())).getIdBase()))) { }
                        (view. new AsyncTask() {

                            final _cls2 this$1;
                            final ArrayList val$listOfIdBase;

                            protected transient Integer doInBackground(Void avoid[])
                            {
                                return Integer.valueOf(SessionFactory.sharedInstance().getSession().reportDuplicatesWithArray(listOfIdBase, true));
                            }

                            protected volatile Object doInBackground(Object aobj[])
                            {
                                return doInBackground((Void[])aobj);
                            }

            
            {
                this$1 = final__pcls2;
                listOfIdBase = ArrayList.this;
                super();
            }
                        }).execute(new Void[0]);
                    }
                    (((Integer)akSoundlikeAdapter.getSelectedItemsIndex().iterator().next()).intValue(). new AsyncTask() {

                        private Dialog mProgressDialog;
                        final _cls2 this$1;
                        final int val$positionOfFirstSelectedElement;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().soundlikeAcceptanceObjectAtIndex(positionOfFirstSelectedElement));
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
                                integer = (com.elokence.limuleapi.Session.LimuleObject)mListOfObjects.get(positionOfFirstSelectedElement);
                                AkGameFactory.sharedInstance().addOneLostGame();
                                AkGameFactory.sharedInstance().setAkinatorStatus(1);
                                Intent intent = new Intent(_fld0, com/digidust/elokence/akinator/activities/GameOverActivity);
                                AkGameFactory.sharedInstance().setGameOverActivityState(11);
                                intent.putExtra("keyAcceptance", integer.getName());
                                startActivity(intent);
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
                this$1 = final__pcls2;
                positionOfFirstSelectedElement = I.this;
                super();
                mProgressDialog = null;
            }
                    }).execute(new Void[0]);
                }
            }

            
            {
                this$0 = Soundlike2Activity.this;
                super();
            }
        };
        mSoundlikeItemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final Soundlike2Activity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (akSoundlikeAdapter.getSelectedItemsIndex().contains(Integer.valueOf(i)))
                {
                    akSoundlikeAdapter.removeSelectedItems(Integer.valueOf(i));
                    return;
                } else
                {
                    akSoundlikeAdapter.addSelectedItems(Integer.valueOf(i));
                    return;
                }
            }

            
            {
                this$0 = Soundlike2Activity.this;
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
        setContentView(0x7f030036);
        uiSoundlikesList = (ListView)findViewById(0x7f0d01ab);
        uiListCharactersTitleText = (TextView)findViewById(0x7f0d01aa);
        uiCharacterNotInListButton = (Button)findViewById(0x7f0d01a9);
        validateButton = (Button)findViewById(0x7f0d01ac);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        uiCharacterNotInListButton.setTypeface(tf);
        validateButton.setTypeface(tf);
        uiListCharactersTitleText.setTypeface(tf);
        addTextView(uiCharacterNotInListButton);
        addTextView(uiListCharactersTitleText);
        addTextView(validateButton);
        updateTextViewsSize();
        uiCharacterNotInListButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MON_PERSONNAGE_NEST_PAS_DANS_LA_LISTE"));
        uiListCharactersTitleText.setText(TraductionFactory.sharedInstance().getTraductionFromToken("SI_VOUS_VOYEZ_LE_PERSONNAGE_AUQUEL_VOUS_PENSIEZ_DANS_LA_LISTE_SUIVANTE_CLIQUEZ_SUR_SON_NOM"));
        validateButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("VALIDER"));
        mListOfObjects = (ArrayList)getIntent().getSerializableExtra("keyListSsl");
        akSoundlikeAdapter = new AkSoundlikeAdapter(this, mListOfObjects);
        uiSoundlikesList.setAdapter(akSoundlikeAdapter);
        akSoundlikeAdapter.notifyDataSetChanged();
        uiSoundlikesList.setDivider(null);
        uiSoundlikesList.setDividerHeight(0);
        uiCharacterNotInListButton.setOnClickListener(mSoundlikeNotInListButtonClickListener);
        uiSoundlikesList.setOnItemClickListener(mSoundlikeItemClickListener);
        validateButton.setOnClickListener(mValiderClickListener);
    }


}

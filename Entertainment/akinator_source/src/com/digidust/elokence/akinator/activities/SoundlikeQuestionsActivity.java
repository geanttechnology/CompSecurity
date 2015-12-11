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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.digidust.elokence.akinator.adapters.AkSoundlikeQuestionAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, SearchQuestionActivity, AddQuestionActivity

public class SoundlikeQuestionsActivity extends AkActivity
{

    private android.view.View.OnClickListener mAddQuestionClickListener;
    private android.view.View.OnClickListener mRetourClickListener;
    private android.widget.AdapterView.OnItemClickListener mSoundlikeItemClickListener;
    private ImageView retourButton;
    private Button uiAddQuestionButton;
    private Button uiNewSearchButton;
    private ListView uiSoundlikesList;

    public SoundlikeQuestionsActivity()
    {
        mRetourClickListener = new android.view.View.OnClickListener() {

            final SoundlikeQuestionsActivity this$0;

            public void onClick(View view)
            {
                onBack();
            }

            
            {
                this$0 = SoundlikeQuestionsActivity.this;
                super();
            }
        };
        mAddQuestionClickListener = new android.view.View.OnClickListener() {

            final SoundlikeQuestionsActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                (new AsyncTask() {

                    private ArrayList mListOfObjects;
                    private Dialog mProgressDialog;
                    final _cls2 this$1;

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
                            integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/AddQuestionActivity);
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
                mProgressDialog = null;
                mListOfObjects = new ArrayList();
            }
                }).execute(new Void[0]);
            }

            
            {
                this$0 = SoundlikeQuestionsActivity.this;
                super();
            }
        };
        mSoundlikeItemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final SoundlikeQuestionsActivity this$0;

            public void onItemClick(AdapterView adapterview, final View view, int i, long l)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                (((com.elokence.limuleapi.Session.QuestionObject)adapterview.getItemAtPosition(i)). new AsyncTask() {

                    private ArrayList mListOfObjects;
                    private Dialog mProgressDialog;
                    final _cls3 this$1;
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
                            integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/AddQuestionActivity);
                            integer.putExtra("question", akQuestion);
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
                        view.setBackgroundResource(0x7f02026a);
                        mProgressDialog = CustomLoadingDialog.show(_fld0);
                    }

            
            {
                this$1 = final__pcls3;
                view = view1;
                akQuestion = com.elokence.limuleapi.Session.QuestionObject.this;
                super();
                mProgressDialog = null;
                mListOfObjects = new ArrayList();
            }
                }).execute(new Void[0]);
            }

            
            {
                this$0 = SoundlikeQuestionsActivity.this;
                super();
            }
        };
    }

    private void onBack()
    {
        super.onBackPressed();
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/SearchQuestionActivity));
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
        onBack();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (mIsRebooting)
        {
            return;
        } else
        {
            setContentView(0x7f030038);
            uiSoundlikesList = (ListView)findViewById(0x7f0d01b6);
            uiAddQuestionButton = (Button)findViewById(0x7f0d008c);
            retourButton = (ImageView)findViewById(0x7f0d0133);
            setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
            uiAddQuestionButton.setTypeface(tf);
            addTextView(uiAddQuestionButton);
            updateTextViewsSize();
            uiAddQuestionButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER_UNE_QUESTION"));
            bundle = new AkSoundlikeQuestionAdapter(this, SessionFactory.sharedInstance().getSession().getCurrentListofQuestions());
            uiSoundlikesList.setAdapter(bundle);
            uiSoundlikesList.setDivider(null);
            uiSoundlikesList.setDividerHeight(0);
            uiAddQuestionButton.setOnClickListener(mAddQuestionClickListener);
            uiSoundlikesList.setOnItemClickListener(mSoundlikeItemClickListener);
            retourButton.setOnClickListener(mRetourClickListener);
            return;
        }
    }

}

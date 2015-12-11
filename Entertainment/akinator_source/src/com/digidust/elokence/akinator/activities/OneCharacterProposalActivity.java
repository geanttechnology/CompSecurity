// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.externalprocessing.OneCharacterProposalProcessing;
import com.digidust.elokence.akinator.activities.transitions.OneCharacterProposalTransition;
import com.digidust.elokence.akinator.adapters.AkPartageAppsAdapter;
import com.digidust.elokence.akinator.db.AkDBAdapter;
import com.digidust.elokence.akinator.db.DefiSetAdapter;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.AsynchronousCharacterPictureLoader;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, QuestionActivity, PartageAppsFragment, GameOverActivity, 
//            PostProposeActivity, ProposeAjoutMBActivity, ContinueProcessActivity, IdentifierPersoMinibaseActivity, 
//            Soundlike1Activity, SeveralCharactersProposalActivity, WebviewCGV, DefiDuJourActivity

public class OneCharacterProposalActivity extends AkActivity
{

    private static final String TAG = "OneCharacterProposalActivity";
    boolean canGoToQuestion;
    private boolean cancelled;
    private Timer delayDismissAdTimer;
    private PartageAppsFragment fragmentPartage;
    private RelativeLayout layoutOneCharacterFound;
    private AkPartageAppsAdapter mAdapter;
    private com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase mCharacter;
    private android.view.View.OnClickListener mCopyrightClickListener;
    private android.view.View.OnClickListener mNoClickListener;
    android.view.View.OnClickListener mPartageButtonClickListener;
    private android.view.View.OnClickListener mReplayClickListener;
    private android.view.View.OnClickListener mYesClickListener;
    private OneCharacterProposalProcessing processing;
    private OneCharacterProposalTransition transition;
    private ImageView uiBulleProposalImage;
    private RelativeLayout uiBulleProposalLayout;
    private TextView uiBulleProposalText1;
    private TextView uiBulleProposalText2;
    private TextView uiBulleProposalText3;
    private TextView uiBulleProposalText4;
    private TextView uiCopyrightLabel;
    private Button uiNoProposalButton;
    private Button uiPartageButton;
    private ImageView uiProposalImage;
    private Button uiReplayButton;
    private Button uiYesProposalButton;

    public OneCharacterProposalActivity()
    {
        canGoToQuestion = false;
        cancelled = false;
        mAdapter = null;
        fragmentPartage = null;
        processing = new OneCharacterProposalProcessing(this);
        transition = new OneCharacterProposalTransition(this);
        mYesClickListener = new android.view.View.OnClickListener() {

            final OneCharacterProposalActivity this$0;

            public void onClick(View view)
            {
                com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase;
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("delai_question", String.valueOf(AkGameFactory.sharedInstance().getDelaiMoyen()));
                AkGameFactory.sharedInstance().setDelaiMoyen(0);
                AkGameFactory.sharedInstance().setAkinatorStatus(2);
                AkGameFactory.sharedInstance().addOneWonGame();
                BackgroundSoundsBinder.sharedInstance().playWin();
                proposedlimuleobjectminibase = mCharacter;
                AkSessionFactory.sharedInstance().setCharacterNameProposed(proposedlimuleobjectminibase.getName());
                if (AkGameFactory.sharedInstance().winFirstTry())
                {
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("succes_games");
                    MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("last_game", "S");
                }
                if (mCharacter.getElementMinibaseId() != -1)
                {
                    AkAnalyticsFactory.sharedInstance().logAccepteProcheMW();
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        final _cls3 this$1;

                        protected transient Integer doInBackground(Void avoid[])
                        {
                            return Integer.valueOf(MinibaseFactory.sharedInstance().validateMBCharacter(mCharacter.getElementMinibaseId()));
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
                                MetricsSetAdapter.sharedInstance().incMetricCompteur("mw_guessed");
                                goToCharacterFound();
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
                this$1 = _cls3.this;
                super();
                mProgressDialog = null;
            }
                    }).execute(new Void[0]);
                    return;
                }
                if (mCharacter.isMyWorldAddable() && AkConfigFactory.sharedInstance().isPlayWithMyworldActivated()) goto _L2; else goto _L1
_L1:
                Object obj2;
                boolean flag;
                boolean flag1;
                flag1 = true;
                flag = flag1;
                if (!AkGameFactory.sharedInstance().winFirstTry())
                {
                    break MISSING_BLOCK_LABEL_216;
                }
                view = null;
                obj2 = null;
                Object obj = new AkDBAdapter(OneCharacterProposalActivity.this);
                flag = ((AkDBAdapter) (obj)).isAwardAlreadyWonForCharacter(TraductionFactory.sharedInstance().getApplicationLanguage(), proposedlimuleobjectminibase.getIdBase());
                flag1 = flag;
                flag = flag1;
                if (obj != null)
                {
                    ((AkDBAdapter) (obj)).close();
                    flag = flag1;
                }
_L3:
                (flag. new AsyncTask() {

                    private Dialog mProgressDialog;
                    final _cls3 this$1;
                    final boolean val$finalIsAwardAlreadyWon;

                    protected transient Integer doInBackground(Void avoid[])
                    {
                        if (finalIsAwardAlreadyWon)
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().validateObjectWithId(mCharacter.getIdSession()));
                        } else
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().getSession().validateObjectWithIdWithJackpot(mCharacter.getIdSession()));
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
                            goToCharacterFound();
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
                this$1 = final__pcls3;
                finalIsAwardAlreadyWon = Z.this;
                super();
                mProgressDialog = null;
            }
                }).execute(new Void[0]);
                AkGameFactory.sharedInstance().addOneCelebCharacterPlayed();
                return;
                Object obj1;
                obj1;
                obj = obj2;
_L6:
                view = ((View) (obj));
                ((Exception) (obj1)).printStackTrace();
                flag = flag1;
                if (obj != null)
                {
                    ((AkDBAdapter) (obj)).close();
                    flag = flag1;
                }
                  goto _L3
                obj;
_L5:
                if (view != null)
                {
                    view.close();
                }
                throw obj;
_L2:
                view = new Intent(OneCharacterProposalActivity.this, com/digidust/elokence/akinator/activities/ProposeAjoutMBActivity);
                startActivity(view);
                finish();
                return;
                obj1;
                view = ((View) (obj));
                obj = obj1;
                if (true) goto _L5; else goto _L4
_L4:
                obj1;
                  goto _L6
            }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super();
            }
        };
        mNoClickListener = new android.view.View.OnClickListener() {

            final OneCharacterProposalActivity this$0;

            public void onClick(View view)
            {
                AkGameFactory.sharedInstance().setWinFirstTry(false);
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("last_game", "E");
                AkGameFactory.sharedInstance().setAkinatorStatus(1);
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (SessionFactory.sharedInstance().getSession().getCurrentSessionProgression().getStep() < 80 && !AkSessionFactory.sharedInstance().getNoMoreQuestionsStatus())
                {
                    if (AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated() || SessionFactory.sharedInstance().getSession().getNbPertinentObjects() != 1)
                    {
                        view = new Intent(OneCharacterProposalActivity.this, com/digidust/elokence/akinator/activities/ContinueProcessActivity);
                        startActivity(view);
                        finish();
                        return;
                    } else
                    {
                        view = new Intent(OneCharacterProposalActivity.this, com/digidust/elokence/akinator/activities/ProposeAjoutMBActivity);
                        view.putExtra("gagne_ou_perdu", true);
                        startActivity(view);
                        finish();
                        return;
                    }
                } else
                {
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        private ArrayList mProposedObjectList;
                        final _cls4 this$1;

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
                                if (((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)mProposedObjectList.get(0)).isMyWorldAddable() || ((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)mProposedObjectList.get(0)).getElementMinibaseId() != -1)
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
                this$1 = _cls4.this;
                super();
                mProgressDialog = null;
                mProposedObjectList = new ArrayList();
            }
                    }).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super();
            }
        };
        mReplayClickListener = new android.view.View.OnClickListener() {

            final OneCharacterProposalActivity this$0;

            public void onClick(View view)
            {
                AkConfigFactory.sharedInstance().setCanReShowAlert(true);
                BackgroundSoundsBinder.sharedInstance().playBip();
                (new AsyncTask() {

                    private Dialog mProgressDialog;
                    final _cls5 this$1;

                    protected transient Integer doInBackground(Void avoid[])
                    {
                        if (AkConfigFactory.sharedInstance().isPlayWithMyworldActivated())
                        {
                            avoid = SessionFactory.sharedInstance();
                            boolean flag;
                            if (!AkConfigFactory.sharedInstance().isPlayWithCelebritiesActivated())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            return Integer.valueOf(avoid.startSessionWithMinibase(true, flag));
                        } else
                        {
                            return Integer.valueOf(SessionFactory.sharedInstance().startSession());
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
                        if (integer.intValue() == 0 || integer.intValue() == 800)
                        {
                            if (AkConfigFactory.sharedInstance().isPaid() || AkConfigFactory.sharedInstance().isFreemium() && AkGameFactory.sharedInstance().isUnlocked() || canGoToQuestion)
                            {
                                goToQuestion();
                                return;
                            } else
                            {
                                canGoToQuestion = true;
                                return;
                            }
                        }
                        if (integer.intValue() == 500)
                        {
                            Toast.makeText(_fld0, TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_RELANCE"), 1).show();
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
                this$1 = _cls5.this;
                super();
                mProgressDialog = null;
            }
                }).execute(new Void[0]);
                canGoToQuestion = true;
            }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super();
            }
        };
        mCopyrightClickListener = new android.view.View.OnClickListener() {

            final OneCharacterProposalActivity this$0;

            public void onClick(View view)
            {
                disableAdOneTime();
                view = (new StringBuilder()).append("http://www.akinator.com/ippolicy.php?name=").append(mCharacter.getName()).append("&id=").append(String.valueOf(mCharacter.getIdBase())).toString();
                Intent intent = new Intent(OneCharacterProposalActivity.this, com/digidust/elokence/akinator/activities/WebviewCGV);
                intent.putExtra("url", view);
                startActivity(intent);
            }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super();
            }
        };
        mPartageButtonClickListener = new android.view.View.OnClickListener() {

            final OneCharacterProposalActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (android.os.Build.VERSION.SDK_INT >= 23)
                {
                    if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
                    {
                        AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
                        requestPermissions(new String[] {
                            "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"
                        }, 666);
                        return;
                    } else
                    {
                        doShare();
                        return;
                    }
                } else
                {
                    doShare();
                    return;
                }
            }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super();
            }
        };
    }

    private void goToQuestion()
    {
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/QuestionActivity));
        finish();
    }

    protected void doShare()
    {
        try
        {
            disableAdOneTime();
            Object obj = AkGameFactory.sharedInstance().getCharacterScreenshot();
            Object obj1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/temp").toString());
            if (!((File) (obj1)).exists())
            {
                ((File) (obj1)).mkdirs();
            }
            obj1 = new File(((File) (obj1)), "temp.jpg");
            FileOutputStream fileoutputstream = new FileOutputStream(((File) (obj1)));
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, fileoutputstream);
            fileoutputstream.flush();
            fileoutputstream.close();
            obj1 = Uri.fromFile(((File) (obj1)));
            obj = new Intent();
            ((Intent) (obj)).setAction("android.intent.action.SEND");
            ((Intent) (obj)).putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("AKINATOR_VIENS_DE_DEVINER_QUE_JE_PENSAIS_A")).append(" ").append(mCharacter.getName()).append(" ").append(getResources().getString(0x7f07005f)).toString());
            ((Intent) (obj)).setType("image/jpeg");
            ((Intent) (obj)).putExtra("android.intent.extra.STREAM", ((android.os.Parcelable) (obj1)));
            obj1 = getPackageManager().queryIntentActivities(((Intent) (obj)), 0);
            fragmentPartage = new PartageAppsFragment();
            fragmentPartage.setPartageIndex(1);
            fragmentPartage.build(((Intent) (obj)), ((java.util.List) (obj1)));
            obj = getFragmentManager().beginTransaction();
            ((FragmentTransaction) (obj)).add(0x7f0d00e0, fragmentPartage);
            ((FragmentTransaction) (obj)).commit();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void goToCharacterFound()
    {
        Object obj = (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentProposedObject();
        if (((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase) (obj)).getElementMinibaseId() != -1)
        {
            Intent intent = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            intent.putExtra("ShowAdOnHome", true);
            if (((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase) (obj)).getNbPlayed() > 3)
            {
                AkGameFactory.sharedInstance().setGameOverActivityState(1);
                startActivity(intent);
                finish();
                return;
            } else
            {
                obj = TraductionFactory.sharedInstance().getTraductionFromToken((new StringBuilder()).append("TIP_SUITE_REJOUE_").append(AkGameFactory.sharedInstance().getNextVarianteTextAugmenteTaBase() + 1).toString());
                AkGameFactory.sharedInstance().setGameOverActivityState(21);
                AkGameFactory.sharedInstance().setGameOverActivityInfo(((String) (obj)));
                startActivity(intent);
                finish();
                return;
            }
        }
        if (((com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase) (obj)).isMyWorldAddable())
        {
            Intent intent1 = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            intent1.putExtra("ShowAdOnHome", true);
            AkGameFactory.sharedInstance().setGameOverActivityState(1);
            startActivity(intent1);
            finish();
            return;
        }
        final int idBase = mCharacter.getIdBase();
        if (DefiSetAdapter.sharedInstance().isDefiPersoExist(idBase))
        {
            if (DefiSetAdapter.sharedInstance().isPersoAlreadyFound(idBase))
            {
                startActivity(new Intent(this, com/digidust/elokence/akinator/activities/PostProposeActivity));
                finish();
                return;
            } else
            {
                layoutOneCharacterFound = (RelativeLayout)findViewById(0x7f0d00d6);
                layoutOneCharacterFound.setVisibility(0);
                AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation.setDuration(500L);
                alphaanimation.setFillAfter(true);
                alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                    final OneCharacterProposalActivity this$0;
                    final int val$idBase;

                    public void onAnimationEnd(Animation animation)
                    {
                        animation = new Intent(OneCharacterProposalActivity.this, com/digidust/elokence/akinator/activities/DefiDuJourActivity);
                        animation.putExtra("keyPersoTrouve", idBase);
                        Bitmap bitmap = Bitmap.createBitmap(((BitmapDrawable)uiProposalImage.getDrawable()).getBitmap());
                        AkSessionFactory.sharedInstance().setImageDefi(bitmap);
                        startActivity(animation);
                        finish();
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                idBase = i;
                super();
            }
                });
                layoutOneCharacterFound.startAnimation(alphaanimation);
                return;
            }
        } else
        {
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/PostProposeActivity));
            finish();
            return;
        }
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
        if (fragmentPartage != null && fragmentPartage.isVisible())
        {
            fragmentPartage.hide();
            return;
        } else
        {
            goToHome();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        Object obj2;
        boolean flag;
        boolean flag1;
        super.onCreate(bundle);
        if (mIsRebooting)
        {
            return;
        }
        StringBuffer stringbuffer;
        StringBuffer stringbuffer1;
        try
        {
            setContentView(0x7f03002a);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            AkLog.e("OneCharacterProposalActivity", "ERREUR  DE MEMOIRE A LA CREATION DE LA VUE OneCharacterProposalActivity");
        }
        if (SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects() == null || SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().size() <= 0) goto _L2; else goto _L1
_L1:
        mCharacter = (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentListofProposedObjects().get(0);
        (new Thread() {

            final OneCharacterProposalActivity this$0;

            public void run()
            {
                try
                {
                    Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(getAssets().open("drawable/BD.jpg")), 1000, 1000, false);
                    com.digidust.elokence.akinator.factories.AkGameFactory.BestQuestion abestquestion[] = new com.digidust.elokence.akinator.factories.AkGameFactory.BestQuestion[3];
                    abestquestion[0] = AkGameFactory.sharedInstance().getBestQuestion1();
                    abestquestion[1] = AkGameFactory.sharedInstance().getBestQuestion2();
                    abestquestion[2] = AkGameFactory.sharedInstance().getBestQuestion3();
                    Arrays.sort(abestquestion);
                    Object obj4 = new TextPaint();
                    ((TextPaint) (obj4)).setAntiAlias(true);
                    ((TextPaint) (obj4)).setTypeface(tf);
                    ((TextPaint) (obj4)).setTextSize(24F);
                    ((TextPaint) (obj4)).setColor(0xff000000);
                    Object obj3 = new TextPaint();
                    ((TextPaint) (obj3)).setAntiAlias(true);
                    ((TextPaint) (obj3)).setTypeface(tf);
                    ((TextPaint) (obj3)).setTextSize(24F);
                    ((TextPaint) (obj3)).setColor(0xffff0000);
                    StaticLayout staticlayout = new StaticLayout(abestquestion[0].mQuestion, ((TextPaint) (obj4)), 220, android.text.Layout.Alignment.ALIGN_CENTER, 1.0F, 1.0F, false);
                    StaticLayout staticlayout1 = new StaticLayout(abestquestion[1].mQuestion, ((TextPaint) (obj4)), 220, android.text.Layout.Alignment.ALIGN_CENTER, 1.0F, 1.0F, false);
                    StaticLayout staticlayout2 = new StaticLayout(abestquestion[2].mQuestion, ((TextPaint) (obj4)), 220, android.text.Layout.Alignment.ALIGN_CENTER, 1.0F, 1.0F, false);
                    obj4 = new StaticLayout(TraductionFactory.sharedInstance().getTraductionFromToken("JE_PENSE_A"), ((TextPaint) (obj4)), 220, android.text.Layout.Alignment.ALIGN_CENTER, 1.0F, 1.0F, false);
                    obj3 = new StaticLayout(SessionFactory.sharedInstance().getSession().getCurrentProposedObject().getName(), ((TextPaint) (obj3)), 220, android.text.Layout.Alignment.ALIGN_CENTER, 1.0F, 1.0F, false);
                    Canvas canvas = new Canvas(bitmap);
                    canvas.save();
                    canvas.translate(100F, 120F);
                    staticlayout.draw(canvas);
                    canvas.restore();
                    canvas.save();
                    canvas.translate(570F, 120F);
                    staticlayout1.draw(canvas);
                    canvas.restore();
                    canvas.save();
                    canvas.translate(100F, 590F);
                    staticlayout2.draw(canvas);
                    canvas.restore();
                    canvas.save();
                    canvas.translate(570F, 590F);
                    ((StaticLayout) (obj4)).draw(canvas);
                    canvas.restore();
                    canvas.save();
                    canvas.translate(570F, 630F);
                    ((StaticLayout) (obj3)).draw(canvas);
                    canvas.restore();
                    AkGameFactory.sharedInstance().setBd(bitmap);
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super();
            }
        }).start();
        AkLog.d("OneCharacterProposalActivity", mCharacter.toString());
        if (!AkSessionFactory.sharedInstance().isCharacterAlreadyProposed())
        {
            AkGameFactory.sharedInstance().addOneGame();
            AkSessionFactory.sharedInstance().setCharacterAlreadyProposed(true);
        }
        uiBulleProposalText1 = (TextView)findViewById(0x7f0d013a);
        uiProposalImage = (ImageView)findViewById(0x7f0d013b);
        uiBulleProposalText2 = (TextView)findViewById(0x7f0d013c);
        uiBulleProposalText3 = (TextView)findViewById(0x7f0d013d);
        uiBulleProposalText4 = (TextView)findViewById(0x7f0d013f);
        uiYesProposalButton = (Button)findViewById(0x7f0d0140);
        uiNoProposalButton = (Button)findViewById(0x7f0d0141);
        uiReplayButton = (Button)findViewById(0x7f0d0142);
        uiCopyrightLabel = (TextView)findViewById(0x7f0d013e);
        uiPartageButton = (Button)findViewById(0x7f0d00d4);
        uiBulleProposalImage = (ImageView)findViewById(0x7f0d0138);
        uiBulleProposalLayout = (RelativeLayout)findViewById(0x7f0d0137);
        uiBulleProposalLayout.setVisibility(4);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
        uiYesProposalButton.setTypeface(tf);
        uiNoProposalButton.setTypeface(tf);
        uiReplayButton.setTypeface(tf);
        uiBulleProposalText1.setTypeface(tf);
        uiBulleProposalText2.setTypeface(tf);
        uiBulleProposalText3.setTypeface(tf);
        uiBulleProposalText4.setTypeface(tf);
        uiCopyrightLabel.setTypeface(tf);
        addTextView(uiYesProposalButton);
        addTextView(uiNoProposalButton);
        addTextView(uiReplayButton);
        addTextView(uiBulleProposalText1);
        addTextView(uiBulleProposalText2);
        addTextView(uiBulleProposalText3);
        addTextView(uiBulleProposalText4);
        addTextView(uiCopyrightLabel);
        updateTextViewsSize();
        flag1 = false;
        stringbuffer = new StringBuffer();
        stringbuffer1 = new StringBuffer();
        flag = flag1;
        if (!AkConfigFactory.sharedInstance().isCustomizeEnabled())
        {
            break MISSING_BLOCK_LABEL_555;
        }
        bundle = null;
        obj2 = null;
        obj = new AkDBAdapter(this);
        flag = ((AkDBAdapter) (obj)).getCustomNameAndUrlFromDB(mCharacter, stringbuffer, stringbuffer1);
        flag1 = flag;
        flag = flag1;
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
            flag = flag1;
        }
_L3:
        Object obj1;
        uiYesProposalButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"));
        uiNoProposalButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("NON"));
        uiReplayButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("REJOUER"));
        uiBulleProposalText1.setText(TraductionFactory.sharedInstance().getTraductionFromToken("JE_PENSE_A"));
        uiBulleProposalText2.setText(mCharacter.getName());
        if (flag)
        {
            MetricsSetAdapter.sharedInstance().incMetricCompteur("tyf_used");
            uiBulleProposalText3.setText("");
        } else
        {
            uiBulleProposalText3.setText(mCharacter.getDescription());
        }
        bundle = TraductionFactory.sharedInstance().getTraductionFromToken("PROPOSE_EST_CE_BIEN").replace("[NOM]", mCharacter.getName());
        uiBulleProposalText4.setText(bundle);
        if (mCharacter.getElementMinibaseId() >= 0)
        {
            uiBulleProposalText4.setVisibility(0);
        } else
        {
            uiBulleProposalText4.setVisibility(8);
        }
        System.gc();
        if (mCharacter.isValidateConstraint())
        {
            int i;
            if (mCharacter.getElementMinibaseId() != -1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                bundle = null;
            } else
            {
                bundle = uiProposalImage;
            }
            if (i != 0)
            {
                obj = null;
            } else
            {
                obj = mCharacter.getPicturePath();
            }
            (new AsynchronousCharacterPictureLoader(this, bundle, ((String) (obj))) {

                final OneCharacterProposalActivity this$0;

                public volatile void onPostExecute(Object obj3)
                {
                    onPostExecute((Void)obj3);
                }

                public void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    uiBulleProposalLayout.setVisibility(0);
                    AkGameFactory.sharedInstance().setCharacterScreenShot(screenShot(findViewById(0x7f0d0085)));
                }

            
            {
                this$0 = OneCharacterProposalActivity.this;
                super(context, imageview, s);
            }
            }).execute(new Void[0]);
            uiYesProposalButton.setOnClickListener(mYesClickListener);
            uiNoProposalButton.setOnClickListener(mNoClickListener);
            uiCopyrightLabel.setOnClickListener(mCopyrightClickListener);
            uiPartageButton.setOnClickListener(mPartageButtonClickListener);
            if (i != 0)
            {
                uiCopyrightLabel.setVisibility(4);
            }
        } else
        {
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("last_game", "C");
            uiProposalImage.setImageResource(0x7f0202e6);
            uiYesProposalButton.setVisibility(8);
            uiNoProposalButton.setVisibility(8);
            uiPartageButton.setVisibility(4);
            uiCopyrightLabel.setVisibility(4);
            uiReplayButton.setVisibility(0);
            uiBulleProposalText1.setVisibility(4);
            uiBulleProposalLayout.setVisibility(0);
            uiBulleProposalText2.setText(TraductionFactory.sharedInstance().getTraductionFromToken("FILTRE_ENFANT"));
            uiBulleProposalText3.setText("");
            uiReplayButton.setOnClickListener(mReplayClickListener);
            MetricsSetAdapter.sharedInstance().incMetricCompteur("child_filter_used");
        }
        if (mCharacter.getElementMinibaseId() != -1)
        {
            bundle = MinibaseFactory.sharedInstance().getCharacter(mCharacter.getElementMinibaseId());
            AkAnalyticsFactory.sharedInstance().logTrouveProcheMW();
        } else
        {
            bundle = null;
        }
        if (!AkSessionFactory.sharedInstance().isCharacterAlreadyProposed())
        {
            i = AkGameFactory.sharedInstance().getNbGames() + 1;
            if (i == 1 || i == 3 || i % 10 == 0)
            {
                AkAnalyticsFactory.sharedInstance().logPartieJouee();
            }
        }
        if (bundle != null)
        {
            bundle = MinibaseFactory.sharedInstance().getMBCharacterPicture(this, bundle);
            if (bundle != null)
            {
                uiProposalImage.setImageBitmap(bundle);
                uiProposalImage.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            } else
            {
                uiProposalImage.setImageResource(0x7f0201f9);
                uiProposalImage.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            }
        }
        processing.processOnCreate(uiProposalImage);
        return;
        obj1;
        obj = obj2;
_L6:
        bundle = ((Bundle) (obj));
        ((Exception) (obj1)).printStackTrace();
        flag = flag1;
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
            flag = flag1;
        }
          goto _L3
        obj;
_L5:
        if (bundle != null)
        {
            bundle.close();
        }
        throw obj;
_L2:
        Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
        bundle = new Message();
        bundle.what = 1;
        mHandler.sendMessage(bundle);
        return;
        obj1;
        bundle = ((Bundle) (obj));
        obj = obj1;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
          goto _L6
    }

    protected void onPostResume()
    {
        super.onPostResume();
    }

    public void onRequestPermissionsResult(int i, String as[], int ai[])
    {
        if (i != 666) goto _L2; else goto _L1
_L1:
        int j;
        j = ai.length;
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (ai[i] == 0) goto _L3; else goto _L2
_L2:
        return;
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        doShare();
        return;
    }




}

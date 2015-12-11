// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.externalprocessing.GameOverProcessing;
import com.digidust.elokence.akinator.activities.transitions.GameOverTransition;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.loaders.CustomLoadingDialog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.MinibaseFactory;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.widget.GameRequestDialog;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, AddPhotoActivity, QuestionActivity, SearchQuestionActivity, 
//            PartageAppsFragment, PartageFinDePartieFragment, AwardsActivity, AjoutModifPersoMBActivity, 
//            CustomizeActivity, MinibaseActivity, ReportActivity, LeaderboardActivity, 
//            FacebookConnexionActivity

public class GameOverActivity extends AkActivity
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{
    private class SharingFragmentAdapter extends FragmentPagerAdapter
    {

        private HashSet mListOfPartage;
        final GameOverActivity this$0;

        public boolean closePartageIfVisible()
        {
            for (Iterator iterator = mListOfPartage.iterator(); iterator.hasNext();)
            {
                if (((PartageFinDePartieFragment)iterator.next()).checkPartageHasClosed())
                {
                    return true;
                }
            }

            return false;
        }

        public int getCount()
        {
            return !AkGameFactory.sharedInstance().canShareAwardImage() ? 2 : 3;
        }

        public Fragment getItem(int i)
        {
            PartageFinDePartieFragment partagefindepartiefragment = new PartageFinDePartieFragment();
            partagefindepartiefragment.setIndex(i);
            mListOfPartage.add(partagefindepartiefragment);
            return partagefindepartiefragment;
        }

        public SharingFragmentAdapter(FragmentManager fragmentmanager)
        {
            this$0 = GameOverActivity.this;
            super(fragmentmanager);
            mListOfPartage = new HashSet();
        }
    }


    public static final String EXTRA_AFFICHE_TIP_MYWORLD_OPTIONS = "AfficheTipOptions";
    public static final String EXTRA_DEMANDE_DESACTIVATION_CELEBRITES = "DemandeDesaCeleb";
    private static final int GPLUS_REQUEST_CODE = 666;
    public static final String KEY_ACCEPTANCE = "keyAcceptance";
    public static final int MODE_FOUND = 1;
    public static final int MODE_INFORMATION = 21;
    public static final int MODE_LOST = 11;
    private static final long MS15D = 0x4d3f6400L;
    private static final long MS24H = 0x5265c00L;
    private static final long MS30D = 0x9a7ec800L;
    private static final long MS48H = 0xa4cb800L;
    private static final long MS7D = 0x240c8400L;
    private static final String NB_GENIZ = "[NB_GENIZ]";
    private static final int NB_SHARING_MAX = 2;
    private static final int NB_SHARING_MAX_WITH_AWARD = 3;
    private static final int SEUIL = 1000;
    private static final String TAG = "GameOverActivity";
    protected int activityMode;
    private Button addPhotoButton;
    private Button addQuestionButton;
    private com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase akSelectedCharacter;
    private CallbackManager callbackManager;
    private TextView closePopUp;
    private ImageView dots[];
    private PartageAppsFragment fragmentPartage;
    protected String infoText;
    private LinearLayout layoutDots;
    protected RelativeLayout layoutPartage;
    android.view.View.OnClickListener mAccessoriesClickListener;
    private android.view.View.OnClickListener mDetailsClickListener;
    android.view.View.OnClickListener mFacebookClassementListener;
    private HashSet mFbUIDsToDefi;
    private android.view.View.OnClickListener mHideSharingClickListener;
    android.view.View.OnClickListener mMoreDialogButtonClickListener;
    android.view.View.OnClickListener mMyWorldClickListener;
    private ViewPager mPager;
    private SharingFragmentAdapter mPagerAdapter;
    android.view.View.OnClickListener mPartageButtonClickListener;
    private android.view.View.OnClickListener mPersonnalisationClickListener;
    android.view.View.OnClickListener mRankClickListener;
    private android.view.View.OnClickListener mRejouerClickListener;
    android.view.View.OnClickListener mShopButtonClickListener;
    AlertDialog moreAlertDialog;
    private Button personalisationButton;
    private GameOverProcessing processing;
    private Button reportButton;
    private GameRequestDialog requestDialog;
    private TextView textChooseSharing;
    private GameOverTransition transition;
    private Button uiAccessoriesButton;
    private LinearLayout uiAlert1000GzOverlay;
    private Button uiAwardsButton;
    private TextView uiContentText1;
    private TextView uiContentText2;
    private TextView uiContentTextPlus;
    private Button uiFacebookClassement;
    private RelativeLayout uiLayoutBulleGo;
    private RelativeLayout uiLayoutBulleGoPlus;
    private Button uiMoreOptions;
    private Button uiMyWorldButton;
    private Button uiPartageButton;
    private Button uiRejouerButton;
    private Button uiStoreButton;
    private TextView uiTextGzUnlock;

    public GameOverActivity()
    {
        fragmentPartage = null;
        mPagerAdapter = null;
        processing = new GameOverProcessing(this);
        transition = new GameOverTransition(this);
        callbackManager = com.facebook.CallbackManager.Factory.create();
        requestDialog = new GameRequestDialog(this);
        mFbUIDsToDefi = new HashSet();
        mFacebookClassementListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                AkGameFactory.sharedInstance().setComeFrom(1);
                if (AccessToken.getCurrentAccessToken() != null)
                {
                    boolean flag = AccessToken.getCurrentAccessToken().getPermissions().contains("user_friends");
                    boolean flag1 = AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions");
                    if (flag && flag1)
                    {
                        view = new Intent(GameOverActivity.this, com/digidust/elokence/akinator/activities/LeaderboardActivity);
                        startActivity(view);
                        finish();
                    }
                }
                view = new Intent(GameOverActivity.this, com/digidust/elokence/akinator/activities/FacebookConnexionActivity);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mHideSharingClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                layoutPartage.setVisibility(8);
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mRejouerClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                AkConfigFactory.sharedInstance().setCanReShowAlert(true);
                BackgroundSoundsBinder.sharedInstance().playBip();
                AkSessionFactory.sharedInstance().setStepOfLastProp(0);
                goToNewGame();
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mDetailsClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                view = new android.app.AlertDialog.Builder(GameOverActivity.this);
                view.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("PLUS"));
                RelativeLayout relativelayout = (RelativeLayout)LayoutInflater.from(GameOverActivity.this).inflate(0x7f030069, null);
                reportButton = (Button)relativelayout.findViewById(0x7f0d028d);
                addPhotoButton = (Button)relativelayout.findViewById(0x7f0d028e);
                addQuestionButton = (Button)relativelayout.findViewById(0x7f0d028f);
                personalisationButton = (Button)relativelayout.findViewById(0x7f0d0290);
                reportButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("RAPPORT_DE_PARTIE"));
                reportButton.setOnClickListener(mMoreDialogButtonClickListener);
                if (SessionFactory.sharedInstance().getSession().isActive() || isMyWorld())
                {
                    reportButton.setVisibility(8);
                }
                addPhotoButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER_UNE_PHOTO"));
                addPhotoButton.setOnClickListener(mMoreDialogButtonClickListener);
                boolean flag;
                if (SessionFactory.sharedInstance().getSession().getCurrentStats().getFlagPhoto() == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag || AkSessionFactory.sharedInstance().hasAlreadyProposedPhoto() || isMyWorld())
                {
                    addPhotoButton.setVisibility(8);
                } else
                {
                    addPhotoButton.setOnClickListener(mMoreDialogButtonClickListener);
                }
                if (isMyWorld())
                {
                    addQuestionButton.setVisibility(8);
                } else
                {
                    addQuestionButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER_UNE_QUESTION"));
                    addQuestionButton.setOnClickListener(mMoreDialogButtonClickListener);
                }
                if (!isMyWorld()) goto _L2; else goto _L1
_L1:
                personalisationButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MODIFIER_DANS_MY_WORLD"));
_L4:
                personalisationButton.setOnClickListener(mPersonnalisationClickListener);
                view.setView(relativelayout);
                view.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("ANNULER"), new android.content.DialogInterface.OnClickListener() {

                    final _cls9 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                });
                moreAlertDialog = view.show();
                return;
_L2:
                personalisationButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("PERSONNALISER_2"));
                if (AkConfigFactory.sharedInstance().isFreemium())
                {
                    if (!AkGameFactory.sharedInstance().isUnlocked() || AkGameFactory.sharedInstance().isUnlocked() && AkConfigFactory.sharedInstance().isCustomizeEnabled())
                    {
                        personalisationButton.setVisibility(0);
                    } else
                    if (AkConfigFactory.sharedInstance().isCustomizeEnabled())
                    {
                        personalisationButton.setVisibility(8);
                    }
                } else
                if (AkConfigFactory.sharedInstance().isCustomizeEnabled())
                {
                    personalisationButton.setVisibility(0);
                } else
                {
                    personalisationButton.setVisibility(8);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mRankClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                disableAdOneTime();
                BackgroundSoundsBinder.sharedInstance().playBip();
                view = new Intent(GameOverActivity.this, com/digidust/elokence/akinator/activities/AwardsActivity);
                startActivity(view);
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mPersonnalisationClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                disableAdOneTime();
                if (moreAlertDialog != null && moreAlertDialog.isShowing())
                {
                    moreAlertDialog.dismiss();
                }
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (!isMyWorld()) goto _L2; else goto _L1
_L1:
                view = new Intent(GameOverActivity.this, com/digidust/elokence/akinator/activities/AjoutModifPersoMBActivity);
                view.putExtra("ActivityMode", false);
                view.putExtra("minibaseCharacterToModify", akSelectedCharacter);
                if (!isFound()) goto _L4; else goto _L3
_L3:
                view.putExtra("ActivityCaller", 2);
_L5:
                startActivity(view);
                finish();
                return;
_L4:
                if (isLost())
                {
                    view.putExtra("ActivityCaller", 3);
                } else
                if (isInfo())
                {
                    view.putExtra("ActivityCaller", 6);
                }
                if (true) goto _L5; else goto _L2
_L2:
                if (AkConfigFactory.sharedInstance().isFreemium() && !AkGameFactory.sharedInstance().isUnlocked())
                {
                    transition.displayUltimatePotion();
                    return;
                } else
                {
                    view = new Intent(GameOverActivity.this, com/digidust/elokence/akinator/activities/CustomizeActivity);
                    startActivity(view);
                    finish();
                    return;
                }
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mPartageButtonClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                if (isFound() || isInfo())
                {
                    BackgroundSoundsBinder.sharedInstance().playBip();
                    layoutPartage.setVisibility(0);
                    return;
                }
                disableAdOneTime();
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                view = getIntent().getStringExtra("keyAcceptance");
                java.util.List list;
                if (view == null)
                {
                    view = (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("J_AI_PIEGE_AKINATOR_EN_PENSANT_A")).append(" ").append(SessionFactory.sharedInstance().getSession().getCurrentProposedObject().getName()).toString();
                } else
                {
                    view = (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("J_AI_PIEGE_AKINATOR_EN_PENSANT_A")).append(" ").append(view).toString();
                }
                intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append("#Akinator ").append(view).append(" ").append(getResources().getString(0x7f07005f)).toString());
                list = getPackageManager().queryIntentActivities(intent, 0);
                fragmentPartage = new PartageAppsFragment();
                fragmentPartage.setModePerdu(true);
                fragmentPartage.setFacebookDesc(view);
                fragmentPartage.build(intent, list);
                view = getFragmentManager().beginTransaction();
                view.add(0x7f0d00e0, fragmentPartage);
                view.commit();
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mMyWorldClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                view = new Intent(GameOverActivity.this, com/digidust/elokence/akinator/activities/MinibaseActivity);
                AkGameFactory.sharedInstance().setComeFrom(1);
                startActivity(view);
                finish();
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mAccessoriesClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (!AkConfigFactory.sharedInstance().isFreemium())
                {
                    if (AkConfigFactory.sharedInstance().isPaid())
                    {
                        goToStore();
                    }
                    return;
                } else
                {
                    goToStoreItems();
                    return;
                }
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mShopButtonClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                if (uiAlert1000GzOverlay.getVisibility() == 0)
                {
                    goToStoreItems();
                    return;
                } else
                {
                    goToStore();
                    return;
                }
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
        mMoreDialogButtonClickListener = new android.view.View.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(View view)
            {
                if (moreAlertDialog != null && moreAlertDialog.isShowing())
                {
                    moreAlertDialog.dismiss();
                }
                if (view == reportButton)
                {
                    (new AsyncTask() {

                        private Dialog mProgressDialog;
                        private ArrayList mReport;
                        final _cls16 this$1;

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
                                integer = new Intent(_fld0, com/digidust/elokence/akinator/activities/ReportActivity);
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
                this$1 = _cls16.this;
                super();
                mProgressDialog = null;
                mReport = new ArrayList();
            }
                    }).execute(new Void[0]);
                } else
                {
                    if (view == addPhotoButton)
                    {
                        goToAddPhoto();
                        return;
                    }
                    if (view == addQuestionButton)
                    {
                        if (AkSessionFactory.sharedInstance().hasAlreadyProposedQuestion())
                        {
                            showAlertAlreadyProposedQuestion();
                            return;
                        } else
                        {
                            goToSearchQuestion();
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        };
    }

    private void getScoresOfEverybody()
    {
        Object obj = getString(0x7f07005a);
        Bundle bundle = new Bundle();
        bundle.putString("fields", "score");
        try
        {
            obj = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), (new StringBuilder()).append("/").append(((String) (obj))).append("/scores").toString(), new com.facebook.GraphRequest.Callback() {

                final GameOverActivity this$0;

                public void onCompleted(GraphResponse graphresponse)
                {
                    Object obj1 = graphresponse.getError();
                    if (obj1 == null) goto _L2; else goto _L1
_L1:
                    AkLog.e("GameOverActivity", ((FacebookRequestError) (obj1)).toString());
_L4:
                    return;
_L2:
                    boolean flag;
                    boolean flag1;
                    graphresponse = graphresponse.getJSONObject();
                    flag1 = false;
                    flag = false;
                    Object obj2 = TraductionFactory.sharedInstance().getTraductionFromToken("DEFIE_TES_AMIS_MESSAGE");
                    obj1 = "";
                    String s;
                    JSONArray jsonarray;
                    int j;
                    j = AkPlayerBelongingsFactory.sharedInstance().getXp();
                    s = ((String) (obj2)).replace("[NB_XP]", (new StringBuilder()).append(String.valueOf(j)).append(TraductionFactory.sharedInstance().getTraductionFromToken("POINT_EXPERIENCE")).toString());
                    jsonarray = graphresponse.getJSONArray("data");
                    graphresponse = s;
                    if (jsonarray.length() <= 0)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    int i = 0;
_L5:
                    if (i >= jsonarray.length())
                    {
                        break MISSING_BLOCK_LABEL_363;
                    }
                    obj2 = jsonarray.optJSONObject(i);
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    int k = Integer.parseInt(((JSONObject) (obj2)).getString("score"));
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    obj2 = ((JSONObject) (obj2)).getJSONObject("user");
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    String s1 = ((JSONObject) (obj2)).getString("id");
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    String s2 = ((JSONObject) (obj2)).getString("name");
                    boolean flag2;
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    flag2 = flag;
                    obj2 = obj1;
                    if (AccessToken.getCurrentAccessToken().getUserId().equals(s1))
                    {
                        break MISSING_BLOCK_LABEL_420;
                    }
                    if (j <= k)
                    {
                        break MISSING_BLOCK_LABEL_294;
                    }
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    if (AkSessionFactory.sharedInstance().isFacebookRequestAlreadySend(s1))
                    {
                        break MISSING_BLOCK_LABEL_294;
                    }
                    flag2 = true;
                    flag = true;
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    obj2 = (new StringBuilder()).append(((String) (obj1))).append(s2).append(", ").toString();
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj2));
                    mFbUIDsToDefi.add(s1);
                    break MISSING_BLOCK_LABEL_420;
                    flag2 = flag;
                    obj2 = obj1;
                    if (j >= k)
                    {
                        break MISSING_BLOCK_LABEL_420;
                    }
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    flag2 = flag;
                    obj2 = obj1;
                    if (!AkSessionFactory.sharedInstance().isFacebookRequestAlreadySend(s1))
                    {
                        break MISSING_BLOCK_LABEL_420;
                    }
                    flag1 = flag;
                    graphresponse = ((GraphResponse) (obj1));
                    AkSessionFactory.sharedInstance().removeFacebookIdForRequest(s1);
                    flag2 = flag;
                    obj2 = obj1;
                    break MISSING_BLOCK_LABEL_420;
                    obj1;
                    flag2 = flag1;
                    obj2 = graphresponse;
                    break MISSING_BLOCK_LABEL_420;
                    flag1 = flag;
                    graphresponse = s;
                    if (!flag)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    graphresponse = s.replace("[USER_NAME]", ((String) (obj1)).substring(0, ((String) (obj1)).length() - 2));
                    flag1 = flag;
                    if (!flag1) goto _L4; else goto _L3
_L3:
                    try
                    {
                        onUpdateScores(graphresponse);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (GraphResponse graphresponse)
                    {
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (GraphResponse graphresponse)
                    {
                        graphresponse.printStackTrace();
                    }
                    return;
                    i++;
                    flag = flag2;
                    obj1 = obj2;
                      goto _L5
                }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
            });
            ((GraphRequest) (obj)).setParameters(bundle);
            ((GraphRequest) (obj)).executeAsync();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void goToAddPhoto()
    {
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/AddPhotoActivity));
        finish();
    }

    private void goToNewGame()
    {
        (new AsyncTask() {

            private Dialog mProgressDialog;
            final GameOverActivity this$0;

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
                    goToQuestion();
                    return;
                }
                if (integer.intValue() == 500)
                {
                    Toast.makeText(GameOverActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("TROP_NOMBREUX_A_JOUER_RELANCE"), 1).show();
                    return;
                } else
                {
                    Toast.makeText(GameOverActivity.this, TraductionFactory.sharedInstance().getTraductionFromToken("PROBLEME_TECHNIQUE_REESSAYER_PLUS_TARD"), 0).show();
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
                mProgressDialog = CustomLoadingDialog.show(GameOverActivity.this);
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
                mProgressDialog = null;
            }
        }).execute(new Void[0]);
    }

    private void goToQuestion()
    {
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/QuestionActivity));
        finish();
    }

    private void goToSearchQuestion()
    {
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/SearchQuestionActivity));
        finish();
    }

    private boolean isMyWorld()
    {
        return isInfo() || akSelectedCharacter.getElementMinibaseId() != -1;
    }

    private void onUpdateScores(String s)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(s);
        builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    dialoginterface = (new com.facebook.share.model.GameRequestContent.Builder()).setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TES_AMIS")).setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ESSAIE_DE_ME_BATTRE")).setTo(TextUtils.join(",", mFbUIDsToDefi)).setActionType(com.facebook.share.model.GameRequestContent.ActionType.TURN).build();
                    requestDialog.show(dialoginterface);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
                }
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        });
        builder.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON_MERCI"), new android.content.DialogInterface.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        });
        builder.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("NE_PLUS_ME_LE_RAPPELER"), new android.content.DialogInterface.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AkSessionFactory.sharedInstance().doNotDisplayFacebookAlertAnymore();
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        });
        builder.create().show();
    }

    private void showAlertAlreadyProposedQuestion()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR"));
        builder.setMessage((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("VOUS_NE_POUVEZ_AJOUTER_QUNE_QUESTION")).append(".").toString());
        builder.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

            final GameOverActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        });
        builder.create().show();
    }

    public boolean isFound()
    {
        return activityMode == 1;
    }

    public boolean isInfo()
    {
        return activityMode == 21;
    }

    public boolean isLost()
    {
        return activityMode == 11;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 1000)
        {
            if (j == 1)
            {
                AkInappManager.getInstance().requestAllPurchases();
            } else
            if (j != 0);
        }
        callbackManager.onActivityResult(i, j, intent);
    }

    public void onBackPressed()
    {
        if (uiAlert1000GzOverlay.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!isFound() && !isMyWorld())
        {
            break; /* Loop/switch isn't completed */
        }
        if (mPagerAdapter == null || !mPagerAdapter.closePartageIfVisible())
        {
            if (layoutPartage != null && layoutPartage.getVisibility() == 0)
            {
                layoutPartage.setVisibility(8);
                return;
            }
            break MISSING_BLOCK_LABEL_101;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (isLost() && fragmentPartage != null && fragmentPartage.isVisible())
        {
            fragmentPartage.hide();
            return;
        }
        super.onBackPressed();
        goToHome();
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!mIsRebooting) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (getIntent().getBooleanExtra("hasToDisplayQuestionValide", false))
        {
            bundle = new android.app.AlertDialog.Builder(this);
            bundle.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("MERCI"));
            bundle.setMessage((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("MERCI_VOTRE_QUESTION_A_ETE_AJOUTEE_ET_JE_COMMENCERAIS_A_LA_POSER_DES_SA_VALIDATION")).append(".").toString());
            bundle.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                final GameOverActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
            });
            bundle.show();
        }
        if (getIntent().getBooleanExtra("hasToDisplayPhotoAdded", false))
        {
            bundle = new android.app.AlertDialog.Builder(this);
            bundle.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("MERCI"));
            bundle.setMessage((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("VOTRE_PHOTO_SERA_VISIBLE_APRES_VALIDATION")).append(".").toString());
            bundle.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                final GameOverActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
            });
            bundle.show();
        }
        requestDialog.registerCallback(callbackManager, new FacebookCallback() {

            final GameOverActivity this$0;

            public void onCancel()
            {
                AkLog.d("GameOverActivity", "cancel");
            }

            public void onError(FacebookException facebookexception)
            {
                AkLog.e("GameOverActivity", facebookexception.toString());
            }

            public void onSuccess(com.facebook.share.widget.GameRequestDialog.Result result)
            {
                AkLog.d("GameOverActivity", "ok");
                String s;
                for (result = mFbUIDsToDefi.iterator(); result.hasNext(); AkSessionFactory.sharedInstance().addFacebookIdForRequest(s))
                {
                    s = (String)result.next();
                }

            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((com.facebook.share.widget.GameRequestDialog.Result)obj);
            }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
        });
        setContentView(0x7f030023);
        if (AkGameFactory.sharedInstance().isFirstGameOverCreation())
        {
            AkGameFactory.sharedInstance().setFirstGameOverCreation(false);
            MetricsSetAdapter.sharedInstance().incMetricCompteur("total_games");
            if (AkConfigFactory.sharedInstance().isChildProtectEnabled())
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("child_filter_used");
            }
            long l = Calendar.getInstance().getTimeInMillis();
            long l1 = MetricsSetAdapter.sharedInstance().getStartDateOpening();
            if (l < 0x9a7ec800L + l1)
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("games_30d");
                if (l < 0x4d3f6400L + l1)
                {
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("games_15d");
                    if (l < 0x240c8400L + l1)
                    {
                        MetricsSetAdapter.sharedInstance().incMetricCompteur("games_7d");
                        if (l < 0xa4cb800L + l1)
                        {
                            MetricsSetAdapter.sharedInstance().incMetricCompteur("games_48h");
                            if (l < 0x5265c00L + l1)
                            {
                                MetricsSetAdapter.sharedInstance().incMetricCompteur("games_24h");
                            }
                        }
                    }
                }
            }
        }
        akSelectedCharacter = (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentProposedObject();
        activityMode = AkGameFactory.sharedInstance().getGameOverActivityState();
        if (isInfo())
        {
            infoText = AkGameFactory.sharedInstance().getGameOverActivityInfo();
            if (infoText != null)
            {
                infoText = infoText.replace("[IDMW]", akSelectedCharacter.getName());
            }
        }
        AkGameFactory.sharedInstance().setLastIdBasePlayed(akSelectedCharacter.getIdBase());
        if (isFound() || isMyWorld())
        {
            mPager = (ViewPager)findViewById(0x7f0d00fe);
            mPager.addOnPageChangeListener(this);
            mPagerAdapter = new SharingFragmentAdapter(getFragmentManager());
            mPager.setAdapter(mPagerAdapter);
            layoutPartage = (RelativeLayout)findViewById(0x7f0d00fc);
            closePopUp = (TextView)findViewById(0x7f0d00b7);
            closePopUp.setOnClickListener(mHideSharingClickListener);
            textChooseSharing = (TextView)findViewById(0x7f0d00fd);
            textChooseSharing.setTypeface(tf);
            textChooseSharing.setText(TraductionFactory.sharedInstance().getTraductionFromToken("CHOISIS_CONTENU_A_PARTAGER"));
            layoutDots = (LinearLayout)findViewById(0x7f0d00ff);
            int i;
            if (AkGameFactory.sharedInstance().canShareAwardImage())
            {
                dots = new ImageView[3];
            } else
            {
                dots = new ImageView[2];
            }
            for (i = 0; i < dots.length; i++)
            {
                dots[i] = new ImageView(this);
                dots[i].setImageResource(0x7f02022d);
                if (i != 0)
                {
                    bundle = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    bundle.setMargins(5, 0, 0, 0);
                    dots[i].setLayoutParams(bundle);
                }
                layoutDots.addView(dots[i]);
            }

            dots[0].setImageResource(0x7f02022c);
        }
        AkGameFactory.sharedInstance().setGameOverActivityState(activityMode);
        uiAlert1000GzOverlay = (LinearLayout)findViewById(0x7f0d00f9);
        uiContentTextPlus = (TextView)findViewById(0x7f0d00f3);
        uiContentText1 = (TextView)findViewById(0x7f0d00f7);
        uiContentText2 = (TextView)findViewById(0x7f0d00f8);
        uiLayoutBulleGoPlus = (RelativeLayout)findViewById(0x7f0d00f1);
        uiLayoutBulleGo = (RelativeLayout)findViewById(0x7f0d00f4);
        uiMoreOptions = (Button)findViewById(0x7f0d00f0);
        uiPartageButton = (Button)findViewById(0x7f0d00d4);
        if (isMyWorld())
        {
            uiPartageButton.setVisibility(4);
        }
        uiRejouerButton = (Button)findViewById(0x7f0d00ef);
        uiAwardsButton = (Button)findViewById(0x7f0d0280);
        uiMyWorldButton = (Button)findViewById(0x7f0d0281);
        bundle = MinibaseFactory.sharedInstance().getAllCharacters();
        if (bundle == null || bundle.size() == 0)
        {
            uiMyWorldButton.setVisibility(4);
        }
        uiFacebookClassement = (Button)findViewById(0x7f0d0282);
        uiAccessoriesButton = (Button)findViewById(0x7f0d0284);
        uiStoreButton = (Button)findViewById(0x7f0d0285);
        setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), false);
        boolean flag;
        boolean flag1;
        if (isFound())
        {
            setImage(0x7f0d00c5, AkSceneryFactory.sharedInstance().getAkiBitmap("akinator_triomphe"));
            setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(AkConfigFactory.sharedInstance().getHat(), "akinator_triomphe"));
            setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(AkConfigFactory.sharedInstance().getCloth(), "akinator_triomphe"));
            uiLayoutBulleGo.setVisibility(0);
        } else
        if (isLost())
        {
            setImage(0x7f0d00c5, AkSceneryFactory.sharedInstance().getAkiBitmap("akinator_deception"));
            setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(AkConfigFactory.sharedInstance().getHat(), "akinator_deception"));
            setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(AkConfigFactory.sharedInstance().getCloth(), "akinator_deception"));
            uiLayoutBulleGo.setVisibility(0);
            uiMoreOptions.setVisibility(4);
        } else
        if (isInfo())
        {
            setImage(0x7f0d00c5, AkSceneryFactory.sharedInstance().getAkiBitmap("akinator_inspiration_forte"));
            setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(AkConfigFactory.sharedInstance().getHat(), "akinator_inspiration_forte"));
            setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(AkConfigFactory.sharedInstance().getCloth(), "akinator_inspiration_forte"));
            uiLayoutBulleGoPlus.setVisibility(0);
        }
        processing.processOnCreate();
        if (!isFound()) goto _L4; else goto _L3
_L3:
        uiContentText1.setText(TraductionFactory.sharedInstance().getTraductionFromToken("ENCORE_TROUVE"));
        if (akSelectedCharacter != null && akSelectedCharacter.getElementMinibaseId() == -1)
        {
            uiContentText2.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("PERSONNAGE_DEJA_JOUE")).append(" ").append(NumberFormat.getInstance().format(SessionFactory.sharedInstance().getSession().getCurrentStats().getNbPlayed())).append(" ").append(TraductionFactory.sharedInstance().getTraductionFromToken("FOIS")).toString());
        } else
        if (akSelectedCharacter != null && akSelectedCharacter.getElementMinibaseId() > 0)
        {
            uiContentText2.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("PERSONNAGE_DEJA_JOUE")).append(" ").append(NumberFormat.getInstance().format(akSelectedCharacter.getNbPlayed())).append(" ").append(TraductionFactory.sharedInstance().getTraductionFromToken("FOIS")).toString());
        } else
        {
            uiContentText2.setText("");
        }
        if (AccessToken.getCurrentAccessToken() != null && AkSessionFactory.sharedInstance().canDisplayAlertFacebookScore())
        {
            flag = AccessToken.getCurrentAccessToken().getPermissions().contains("user_friends");
            flag1 = AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions");
            if (flag && flag1)
            {
                getScoresOfEverybody();
            }
        }
_L5:
        uiRejouerButton.setText(TraductionFactory.sharedInstance().getTraductionFromToken("REJOUER"));
        uiRejouerButton.setTypeface(tf);
        uiContentTextPlus.setTypeface(tf);
        uiContentText1.setTypeface(tf, 1);
        uiContentText2.setTypeface(tf);
        addTextView(uiRejouerButton);
        addTextView(uiContentTextPlus);
        addTextView(uiContentText1);
        addTextView(uiContentText2);
        updateTextViewsSize();
        uiRejouerButton.setOnClickListener(mRejouerClickListener);
        uiMoreOptions.setOnClickListener(mDetailsClickListener);
        uiAwardsButton.setOnClickListener(mRankClickListener);
        uiFacebookClassement.setOnClickListener(mFacebookClassementListener);
        uiPartageButton.setOnClickListener(mPartageButtonClickListener);
        uiMyWorldButton.setOnClickListener(mMyWorldClickListener);
        uiMyWorldButton.setBackgroundResource(0x7f0200ff);
        uiAccessoriesButton.setOnClickListener(mAccessoriesClickListener);
        uiStoreButton.setOnClickListener(mShopButtonClickListener);
        if (AkConfigFactory.sharedInstance().isPaid() || isMyWorld())
        {
            uiStoreButton.setVisibility(8);
        } else
        {
            uiStoreButton.setVisibility(0);
        }
        if (getIntent().getBooleanExtra("displayCustomizeAlert", false))
        {
            bundle = new android.app.AlertDialog.Builder(this);
            bundle.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("VOTRE_PERSONNAGE_A_ETE_MODIFIE"));
            bundle.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                final GameOverActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
            });
            bundle.create().show();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (isLost())
        {
            uiContentText1.setText(TraductionFactory.sharedInstance().getTraductionFromToken("BRAVO"));
            uiContentText2.setText((new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("VOUS_M_AVEZ_POSE_UNE_COLLE")).append(".").toString());
            BackgroundSoundsBinder.sharedInstance().playClap();
        } else
        if (isInfo())
        {
            uiAwardsButton.setVisibility(4);
            uiFacebookClassement.setVisibility(4);
            uiAccessoriesButton.setVisibility(4);
            uiStoreButton.setVisibility(4);
            uiContentTextPlus.setText(infoText);
        }
          goto _L5
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        if (AkGameFactory.sharedInstance().canShareAwardImage())
        {
            for (int j = 0; j < 3; j++)
            {
                dots[j].setImageResource(0x7f02022d);
            }

        } else
        {
            for (int k = 0; k < 2; k++)
            {
                dots[k].setImageResource(0x7f02022d);
            }

        }
        dots[i].setImageResource(0x7f02022c);
    }

    public void onResume()
    {
        super.onResume();
        if (mIsRebooting)
        {
            return;
        }
        int i = AkPlayerBelongingsFactory.sharedInstance().getGenizBalance();
        if (AkPlayerBelongingsFactory.sharedInstance().canDisplayScreenShopAfterGameOver() && i >= 1000)
        {
            AkLog.d("GameOverActivity", "Display 1000gz");
            AkPlayerBelongingsFactory.sharedInstance().doNotDisplayScreenShopAnymore();
            uiTextGzUnlock = (TextView)findViewById(0x7f0d00fb);
            String s = TraductionFactory.sharedInstance().getTraductionFromToken("DEPENSE_TES_GENIZ").replace("[NB_GENIZ]", String.valueOf(1000));
            uiTextGzUnlock.setText(s);
            uiTextGzUnlock.setTypeface(tf);
            addTextView(uiTextGzUnlock);
            updateTextViewsSize();
            uiRejouerButton.setEnabled(false);
            uiMoreOptions.setEnabled(false);
            uiPartageButton.setEnabled(false);
            uiHomeButton.setEnabled(false);
            uiAwardsButton.setEnabled(false);
            uiMyWorldButton.setEnabled(false);
            uiFacebookClassement.setEnabled(false);
            uiAlert1000GzOverlay.setVisibility(0);
            findViewById(0x7f0d00ee).bringToFront();
            uiAwardsButton.setAlpha(0.2F);
            uiMyWorldButton.setAlpha(0.2F);
            uiFacebookClassement.setAlpha(0.2F);
            if (AkConfigFactory.sharedInstance().isFreemium())
            {
                uiAccessoriesButton.setEnabled(false);
                uiAccessoriesButton.setAlpha(0.2F);
            }
        }
        processing.processOnResume();
    }






/*
    static PartageAppsFragment access$1102(GameOverActivity gameoveractivity, PartageAppsFragment partageappsfragment)
    {
        gameoveractivity.fragmentPartage = partageappsfragment;
        return partageappsfragment;
    }

*/










/*
    static Button access$302(GameOverActivity gameoveractivity, Button button)
    {
        gameoveractivity.reportButton = button;
        return button;
    }

*/



/*
    static Button access$402(GameOverActivity gameoveractivity, Button button)
    {
        gameoveractivity.addPhotoButton = button;
        return button;
    }

*/



/*
    static Button access$502(GameOverActivity gameoveractivity, Button button)
    {
        gameoveractivity.addQuestionButton = button;
        return button;
    }

*/



/*
    static Button access$602(GameOverActivity gameoveractivity, Button button)
    {
        gameoveractivity.personalisationButton = button;
        return button;
    }

*/



}

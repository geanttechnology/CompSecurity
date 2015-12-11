// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.digidust.elokence.akinator.adapters.AkFacebookInviteAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.widget.AppInviteDialog;
import com.facebook.share.widget.GameRequestDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity, FacebookConnexionActivity

public class LeaderboardActivity extends AkActivity
    implements android.view.View.OnClickListener, AkActivity.PublishScoreListener
{

    private static final String PULL_PERMISSION = "user_friends";
    private static final String TAG = "LeaderboardActivity";
    private AkFacebookInviteAdapter akFacebookInviteAdapter;
    private CallbackManager callbackManager;
    private boolean canContinue;
    protected LoginButton loginButton;
    private ProgressBar mProgressBar;
    private GameRequestDialog requestDialog;
    private ImageView uiBackButtonImage;
    private Button uiButtonDefis;
    private Button uiButtonGetRequests;
    private Button uiButtonRecommander;
    private GridView uiLayoutFriends;
    private TextView uiTextLeaderboard;

    public LeaderboardActivity()
    {
        canContinue = true;
        akFacebookInviteAdapter = null;
        mProgressBar = null;
    }

    private void fetchScoreboardEntries()
    {
        Object obj = getString(0x7f07005a);
        Bundle bundle = new Bundle();
        bundle.putString("fields", "score");
        try
        {
            obj = GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), (new StringBuilder()).append("/").append(((String) (obj))).append("/scores").toString(), new com.facebook.GraphRequest.Callback() {

                final LeaderboardActivity this$0;

                public void onCompleted(GraphResponse graphresponse)
                {
                    Object obj1;
                    JSONException jsonexception;
                    int i;
                    try
                    {
                        obj1 = graphresponse.getError();
                    }
                    // Misplaced declaration of an exception variable
                    catch (GraphResponse graphresponse)
                    {
                        mProgressBar.setVisibility(8);
                        return;
                    }
                    finally
                    {
                        mProgressBar.setVisibility(8);
                    }
                    if (obj1 == null) goto _L2; else goto _L1
_L1:
                    AkLog.e("LeaderboardActivity", ((FacebookRequestError) (obj1)).toString());
_L7:
                    mProgressBar.setVisibility(8);
                    return;
_L2:
                    obj1 = graphresponse.getJSONObject();
                    graphresponse = new ArrayList();
                    obj1 = ((JSONObject) (obj1)).getJSONArray("data");
                    if (((JSONArray) (obj1)).length() <= 0) goto _L4; else goto _L3
_L3:
                    i = 0;
_L5:
                    if (i >= ((JSONArray) (obj1)).length())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    graphresponse.add(((JSONArray) (obj1)).optJSONObject(i));
                    i++;
                    if (true) goto _L5; else goto _L4
                    jsonexception;
                    jsonexception.printStackTrace();
_L4:
                    if (!AkConfigFactory.sharedInstance().isTablet())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    uiLayoutFriends.setNumColumns(2);
_L8:
                    akFacebookInviteAdapter = new AkFacebookInviteAdapter(LeaderboardActivity.this, graphresponse);
                    uiLayoutFriends.setAdapter(akFacebookInviteAdapter);
                    akFacebookInviteAdapter.notifyDataSetChanged();
                /* block-local class not found */
                class _cls1 {}

                    uiLayoutFriends.setOnItemClickListener(new _cls1(graphresponse));
                    if (true) goto _L7; else goto _L6
_L6:
                    uiLayoutFriends.setNumColumns(1);
                      goto _L8
                    throw graphresponse;
                }

            
            {
                this$0 = LeaderboardActivity.this;
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

    private void getDirectRequest()
    {
        if (AccessToken.getCurrentAccessToken() != null)
        {
            GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "/me/apprequests", new com.facebook.GraphRequest.Callback() {

                final LeaderboardActivity this$0;

                public void onCompleted(GraphResponse graphresponse)
                {
                    Object obj;
                    obj = graphresponse.getError();
                    if (obj != null)
                    {
                        AkLog.e("LeaderboardActivity", ((FacebookRequestError) (obj)).toString());
                        return;
                    }
                    obj = "";
                    JSONArray jsonarray = graphresponse.getJSONObject().getJSONArray("data");
                    int i;
                    i = 0;
                    graphresponse = ((GraphResponse) (obj));
_L2:
                    obj = graphresponse;
                    JSONObject jsonobject;
                    if (i >= jsonarray.length())
                    {
                        break MISSING_BLOCK_LABEL_147;
                    }
                    jsonobject = jsonarray.optJSONObject(i);
                    obj = "";
                    if (!jsonobject.isNull("from"))
                    {
                        obj = jsonobject.optJSONObject("from").getString("name");
                    }
                    String s = "";
                    if (!jsonobject.isNull("message"))
                    {
                        s = jsonobject.getString("message");
                    }
                    graphresponse = (new StringBuilder()).append(graphresponse).append(((String) (obj))).append(" : ").append(s).append("\n").toString();
                    if (i <= 3)
                    {
                        break MISSING_BLOCK_LABEL_208;
                    }
                    obj = graphresponse;
                    try
                    {
                        graphresponse = new android.app.AlertDialog.Builder(LeaderboardActivity.this);
                        graphresponse.setMessage(((CharSequence) (obj)));
                /* block-local class not found */
                class _cls1 {}

                        obj = new _cls1();
                        graphresponse.setCancelable(false);
                        graphresponse.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), ((android.content.DialogInterface.OnClickListener) (obj)));
                        graphresponse.create().show();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (GraphResponse graphresponse)
                    {
                        graphresponse.printStackTrace();
                    }
                    return;
                    i++;
                    if (true) goto _L2; else goto _L1
_L1:
                }

            
            {
                this$0 = LeaderboardActivity.this;
                super();
            }
            }).executeAsync();
        }
    }

    private void onBack()
    {
        if (AkGameFactory.sharedInstance().comeFrom() == 0)
        {
            goToHome(false);
            return;
        }
        if (AkGameFactory.sharedInstance().comeFrom() == 1)
        {
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity));
            finish();
            return;
        } else
        {
            goToHome(false);
            return;
        }
    }

    private void sendDirectedRequest(List list)
    {
        disableAdOneTime();
        try
        {
            list = (new com.facebook.share.model.GameRequestContent.Builder()).setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TES_AMIS")).setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ESSAIE_DE_ME_BATTRE")).setTo(TextUtils.join(",", list)).setActionType(com.facebook.share.model.GameRequestContent.ActionType.TURN).build();
            requestDialog.show(list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        callbackManager.onActivityResult(i, j, intent);
    }

    public void onBackPressed()
    {
        onBack();
    }

    public void onClick(View view)
    {
        if (view != uiBackButtonImage) goto _L2; else goto _L1
_L1:
        onBack();
_L4:
        return;
_L2:
        if (view != uiButtonDefis)
        {
            break; /* Loop/switch isn't completed */
        }
        if (akFacebookInviteAdapter != null && akFacebookInviteAdapter.getIdToInvite().size() != 0)
        {
            view = MetricsSetAdapter.sharedInstance().getIdsAlreadyInvite();
            for (Iterator iterator = akFacebookInviteAdapter.getIdToInvite().iterator(); iterator.hasNext(); view.add((String)iterator.next())) { }
            MetricsSetAdapter.sharedInstance().setIds(view);
            MetricsSetAdapter.sharedInstance().createOrUpdateMetricValeur("recommandation_people", String.valueOf(view.size()));
            sendDirectedRequest(akFacebookInviteAdapter.getIdToInvite());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (view == uiButtonGetRequests)
        {
            getDirectRequest();
            return;
        }
        if (view == loginButton)
        {
            disableAdOneTime();
            AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
            return;
        }
        if (view == uiButtonRecommander)
        {
            MetricsSetAdapter.sharedInstance().incMetricCompteur("recommandation_demande");
            (new AppInviteDialog(this)).registerCallback(callbackManager, new FacebookCallback() {

                final LeaderboardActivity this$0;

                public void onCancel()
                {
                    Log.i("LeaderboardActivity", "InviteCallback - CANCEL!");
                }

                public void onError(FacebookException facebookexception)
                {
                    Log.e("LeaderboardActivity", (new StringBuilder()).append("InviteCallback - ERROR! ").append(facebookexception.getMessage()).toString());
                }

                public void onSuccess(com.facebook.share.widget.AppInviteDialog.Result result)
                {
                    Log.d("LeaderboardActivity", (new StringBuilder()).append("InviteCallback onSuccess result = ").append(result.getData().toString()).toString());
                }

                public volatile void onSuccess(Object obj)
                {
                    onSuccess((com.facebook.share.widget.AppInviteDialog.Result)obj);
                }

            
            {
                this$0 = LeaderboardActivity.this;
                super();
            }
            });
            if (AppInviteDialog.canShow())
            {
                disableAdOneTime();
                view = getString(0x7f07005b);
                AppInviteDialog.show(this, (new com.facebook.share.model.AppInviteContent.Builder()).setApplinkUrl(view).build());
                return;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030028);
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.NO_CHANGE;
        mProgressBar = (ProgressBar)findViewById(0x7f0d012e);
        uiTextLeaderboard = (TextView)findViewById(0x7f0d012c);
        uiTextLeaderboard.setTypeface(tf);
        uiButtonDefis = (Button)findViewById(0x7f0d0130);
        uiButtonDefis.setOnClickListener(this);
        uiButtonDefis.setTypeface(tf);
        uiButtonDefis.setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TES_AMIS"));
        uiButtonRecommander = (Button)findViewById(0x7f0d0131);
        uiButtonRecommander.setOnClickListener(this);
        uiButtonRecommander.setTypeface(tf);
        uiButtonRecommander.setText(TraductionFactory.sharedInstance().getTraductionFromToken("RECOMMANDER"));
        uiButtonGetRequests = (Button)findViewById(0x7f0d0132);
        uiButtonGetRequests.setOnClickListener(this);
        uiButtonGetRequests.setTypeface(tf);
        uiButtonGetRequests.setText(TraductionFactory.sharedInstance().getTraductionFromToken("GET_REQUESTS"));
        uiLayoutFriends = (GridView)findViewById(0x7f0d012f);
        uiTextLeaderboard.setText(TraductionFactory.sharedInstance().getTraductionFromToken("MEILLEURS_SCORES"));
        loginButton = (LoginButton)findViewById(0x7f0d00e6);
        loginButton.setOnClickListener(this);
        loginButton.clearPermissions();
        loginButton.setReadPermissions(new String[] {
            "user_friends"
        });
        callbackManager = com.facebook.CallbackManager.Factory.create();
        requestDialog = new GameRequestDialog(this);
        requestDialog.registerCallback(callbackManager, new FacebookCallback() {

            final LeaderboardActivity this$0;

            public void onCancel()
            {
                AkLog.d("LeaderboardActivity", "cancel");
            }

            public void onError(FacebookException facebookexception)
            {
                AkLog.e("LeaderboardActivity", facebookexception.toString());
            }

            public void onSuccess(com.facebook.share.widget.GameRequestDialog.Result result)
            {
                AkLog.d("LeaderboardActivity", "ok");
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((com.facebook.share.widget.GameRequestDialog.Result)obj);
            }

            
            {
                this$0 = LeaderboardActivity.this;
                super();
            }
        });
        new AccessTokenTracker() {

            final LeaderboardActivity this$0;

            protected void onCurrentAccessTokenChanged(AccessToken accesstoken, AccessToken accesstoken1)
            {
                if (accesstoken1 == null && uiLayoutFriends != null)
                {
                    uiLayoutFriends.setAdapter(null);
                    akFacebookInviteAdapter = null;
                    accesstoken = new Intent(LeaderboardActivity.this, com/digidust/elokence/akinator/activities/FacebookConnexionActivity);
                    startActivity(accesstoken);
                    finish();
                }
            }

            
            {
                this$0 = LeaderboardActivity.this;
                super();
            }
        };
        loginButton.registerCallback(callbackManager, new FacebookCallback() {

            final LeaderboardActivity this$0;

            public void onCancel()
            {
                disableAdOneTime();
                AkLog.d("LeaderboardActivity", "Facebook log cancel");
                canContinue = false;
            }

            public void onError(FacebookException facebookexception)
            {
                disableAdOneTime();
                AkLog.d("LeaderboardActivity", (new StringBuilder()).append("Facebook log error  : ").append(facebookexception.toString()).toString());
                canContinue = false;
            }

            public void onSuccess(LoginResult loginresult)
            {
                disableAdOneTime();
                AkLog.d("LeaderboardActivity", "Facebook log Ok");
                canContinue = true;
                loginresult = new Bundle();
                loginresult.putString("fields", "birthday, gender");
            /* block-local class not found */
            class _cls1 {}

                GraphRequest graphrequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new _cls1());
                graphrequest.setParameters(loginresult);
                graphrequest.executeAsync();
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((LoginResult)obj);
            }

            
            {
                this$0 = LeaderboardActivity.this;
                super();
            }
        });
        uiBackButtonImage = (ImageView)findViewById(0x7f0d00ba);
        uiBackButtonImage.setOnClickListener(this);
        addTextView(uiTextLeaderboard);
        addTextView(uiButtonDefis);
        addTextView(uiButtonGetRequests);
        addTextView(uiButtonRecommander);
        updateTextViewsSize();
    }

    public void onPause()
    {
        super.onPause();
        removePublishListener(this);
    }

    public void onResume()
    {
        super.onResume();
        addPublishListener(this);
        if (AccessToken.getCurrentAccessToken() != null)
        {
            if (AkSessionFactory.sharedInstance().hasToPublishedScore())
            {
                sendMyScore();
            } else
            if (akFacebookInviteAdapter == null)
            {
                fetchScoreboardEntries();
                return;
            }
        }
    }

    public void onScorePublished(boolean flag)
    {
        fetchScoreboardEntries();
    }




/*
    static AkFacebookInviteAdapter access$102(LeaderboardActivity leaderboardactivity, AkFacebookInviteAdapter akfacebookinviteadapter)
    {
        leaderboardactivity.akFacebookInviteAdapter = akfacebookinviteadapter;
        return akfacebookinviteadapter;
    }

*/


/*
    static boolean access$202(LeaderboardActivity leaderboardactivity, boolean flag)
    {
        leaderboardactivity.canContinue = flag;
        return flag;
    }

*/

}

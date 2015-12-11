// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.util.LinkProperties;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            PrefHelper, BranchRemoteInterface, SystemObserver, ServerRequestQueue, 
//            Base64, ServerRequestRegisterInstall, ServerRequestRegisterOpen, ServerRequestRegisterClose, 
//            ServerRequestCreateUrl, ServerRequest, ServerResponse, BranchUtil, 
//            BranchApp, ServerRequestInitSession, ServerRequestLogout, BranchUniversalReferralInitWrapper, 
//            BranchError, InstallListener, ShareLinkManager, ServerRequestApplyReferralCode, 
//            ServerRequestGetRewardHistory, ServerRequestGetReferralCode, ServerRequestGetReferralCount, ServerRequestGetRewards, 
//            ServerRequestRedeemRewards, ServerRequestRegisterView, ServerRequestIdentifyUserRequest, ServerRequestActionCompleted, 
//            ServerRequestValidateReferralCode, BranchShortLinkBuilder, ServerRequestSendAppList

public class Branch
{
    class KeepDebugConnectionTask extends TimerTask
    {

        final _cls1 this$1;

        public void run()
        {
            class _cls1
                implements android.view.View.OnTouchListener
            {

                Runnable _longPressed;
                final Branch this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    int i = motionevent.getPointerCount();
                    motionevent.getAction() & 0xff;
                    JVM INSTR tableswitch 0 5: default 52
                //                               0 54
                //                               1 105
                //                               2 52
                //                               3 88
                //                               4 52
                //                               5 127;
                       goto _L1 _L2 _L3 _L1 _L4 _L1 _L5
_L1:
                    return true;
_L2:
                    if (systemObserver_.isSimulator())
                    {
                        debugHandler_.postDelayed(_longPressed, 3000L);
                    }
                    continue; /* Loop/switch isn't completed */
_L4:
                    debugHandler_.removeCallbacks(_longPressed);
                    continue; /* Loop/switch isn't completed */
_L3:
                    view.performClick();
                    debugHandler_.removeCallbacks(_longPressed);
                    continue; /* Loop/switch isn't completed */
_L5:
                    if (i == 4)
                    {
                        debugHandler_.postDelayed(_longPressed, 3000L);
                    }
                    if (true) goto _L1; else goto _L6
_L6:
                }

            
            {
                this$0 = Branch.this;
                super();
                _longPressed = new _cls1();
            }
            }

            if (!prefHelper_.keepDebugConnection())
            {
                debugHandler_.post(_longPressed);
            }
        }

        KeepDebugConnectionTask()
        {
            this$1 = _cls1.this;
            super();
        }
    }

    private class BranchActivityLifeCycleObserver
        implements android.app.Application.ActivityLifecycleCallbacks
    {

        private int activityCnt_;
        final Branch this$0;

        public void onActivityCreated(Activity activity, Bundle bundle)
        {
        }

        public void onActivityDestroyed(Activity activity)
        {
            if (currentActivity_ == activity)
            {
                currentActivity_ = null;
            }
        }

        public void onActivityPaused(Activity activity)
        {
            clearTouchDebugInternal(activity);
            if (shareLinkManager_ != null)
            {
                shareLinkManager_.cancelShareLinkDialog(true);
            }
        }

        public void onActivityResumed(Activity activity)
        {
            currentActivity_ = activity;
            if (prefHelper_.getTouchDebugging())
            {
                setTouchDebugInternal(activity);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
        {
        }

        public void onActivityStarted(Activity activity)
        {
            if (activityCnt_ < 1)
            {
                if (BranchUtil.isTestModeEnabled(context_))
                {
                    setDebug();
                }
                Uri uri = null;
                if (activity.getIntent() != null)
                {
                    uri = activity.getIntent().getData();
                }
                initSessionWithData(uri, activity);
            }
            activityCnt_ = activityCnt_ + 1;
        }

        public void onActivityStopped(Activity activity)
        {
            activityCnt_ = activityCnt_ - 1;
            if (activityCnt_ < 1)
            {
                closeSessionInternal();
            }
        }

        private BranchActivityLifeCycleObserver()
        {
            this$0 = Branch.this;
            super();
            activityCnt_ = 0;
        }

    }

    public static interface BranchLinkCreateListener
    {

        public abstract void onLinkCreate(String s, BranchError brancherror);
    }

    public static interface BranchLinkShareListener
    {

        public abstract void onChannelSelected(String s);

        public abstract void onLinkShareResponse(String s, String s1, BranchError brancherror);

        public abstract void onShareLinkDialogDismissed();

        public abstract void onShareLinkDialogLaunched();
    }

    public static interface BranchListResponseListener
    {

        public abstract void onReceivingResponse(JSONArray jsonarray, BranchError brancherror);
    }

    private class BranchPostTask extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final Branch this$0;
        ServerRequest thisReq_;
        int timeOut_;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient ServerResponse doInBackground(Void avoid[])
        {
            if ((thisReq_ instanceof ServerRequestInitSession) || (thisReq_ instanceof ServerRequestRegisterView))
            {
                thisReq_.updateGAdsParams(systemObserver_);
            }
            if (thisReq_.isGetRequest())
            {
                return kRemoteInterface_.make_restful_get(thisReq_.getRequestUrl(), thisReq_.getRequestPath(), timeOut_);
            } else
            {
                return kRemoteInterface_.make_restful_post(thisReq_.getPost(), thisReq_.getRequestUrl(), thisReq_.getRequestPath(), timeOut_);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "Branch$BranchPostTask#doInBackground", null);
_L1:
            aobj = doInBackground((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "Branch$BranchPostTask#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(ServerResponse serverresponse)
        {
            int j;
            super.onPostExecute(serverresponse);
            if (serverresponse == null)
            {
                break MISSING_BLOCK_LABEL_746;
            }
            try
            {
                j = serverresponse.getStatusCode();
                hasNetwork_ = true;
            }
            // Misplaced declaration of an exception variable
            catch (ServerResponse serverresponse)
            {
                serverresponse.printStackTrace();
                return;
            }
            if (j == 200) goto _L2; else goto _L1
_L1:
            if (thisReq_ instanceof ServerRequestInitSession)
            {
                initState_ = SESSION_STATE.UNINITIALISED;
            }
            if (j != 409) goto _L4; else goto _L3
_L3:
            requestQueue_.remove(thisReq_);
            if (!(thisReq_ instanceof ServerRequestCreateUrl)) goto _L6; else goto _L5
_L5:
            ((ServerRequestCreateUrl)thisReq_).handleDuplicateURLError();
_L7:
            networkCount_ = 0;
            if (hasNetwork_ && initState_ != SESSION_STATE.UNINITIALISED)
            {
                processNextQueueItem();
                return;
            }
            break MISSING_BLOCK_LABEL_746;
_L6:
            Log.i("BranchSDK", "Branch API Error: Conflicting resource error code from API");
            handleFailure(0, j);
              goto _L7
_L4:
            Object obj;
            hasNetwork_ = false;
            obj = new ArrayList();
            int i = 0;
_L9:
            if (i >= requestQueue_.getSize())
            {
                break; /* Loop/switch isn't completed */
            }
            ((ArrayList) (obj)).add(requestQueue_.peekAt(i));
            i++;
            if (true) goto _L9; else goto _L8
_L8:
            Object obj1 = ((ArrayList) (obj)).iterator();
_L12:
            ServerRequest serverrequest;
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_278;
            }
            serverrequest = (ServerRequest)((Iterator) (obj1)).next();
            if (serverrequest == null) goto _L11; else goto _L10
_L10:
            if (serverrequest.shouldRetryOnFail()) goto _L12; else goto _L11
_L11:
            requestQueue_.remove(serverrequest);
              goto _L12
            networkCount_ = 0;
            obj = ((ArrayList) (obj)).iterator();
_L15:
            if (!((Iterator) (obj)).hasNext()) goto _L7; else goto _L13
_L13:
            obj1 = (ServerRequest)((Iterator) (obj)).next();
            if (obj1 == null) goto _L15; else goto _L14
_L14:
            ((ServerRequest) (obj1)).handleFailure(j, serverresponse.getFailReason());
            if (((ServerRequest) (obj1)).shouldRetryOnFail())
            {
                ((ServerRequest) (obj1)).clearCallbacks();
            }
              goto _L15
_L2:
            hasNetwork_ = true;
            if (!(thisReq_ instanceof ServerRequestCreateUrl)) goto _L17; else goto _L16
_L16:
            if (serverresponse.getObject() != null)
            {
                obj = serverresponse.getObject().getString("url");
                linkCache_.put(serverresponse.getLinkData(), obj);
            }
_L20:
            requestQueue_.dequeue();
            if (!(thisReq_ instanceof ServerRequestInitSession) && !(thisReq_ instanceof ServerRequestIdentifyUserRequest))
            {
                break MISSING_BLOCK_LABEL_732;
            }
            if (serverresponse.getObject() == null) goto _L7; else goto _L18
_L18:
            i = 0;
            if (!serverresponse.getObject().has(Defines.Jsonkey.SessionID.getKey()))
            {
                break MISSING_BLOCK_LABEL_476;
            }
            prefHelper_.setSessionID(serverresponse.getObject().getString(Defines.Jsonkey.SessionID.getKey()));
            i = 1;
            j = i;
            if (!serverresponse.getObject().has(Defines.Jsonkey.IdentityID.getKey()))
            {
                break MISSING_BLOCK_LABEL_569;
            }
            obj = serverresponse.getObject().getString(Defines.Jsonkey.IdentityID.getKey());
            j = i;
            if (prefHelper_.getIdentityID().equals(obj))
            {
                break MISSING_BLOCK_LABEL_569;
            }
            linkCache_.clear();
            prefHelper_.setIdentityID(serverresponse.getObject().getString(Defines.Jsonkey.IdentityID.getKey()));
            j = 1;
            if (!serverresponse.getObject().has(Defines.Jsonkey.DeviceFingerprintID.getKey()))
            {
                break MISSING_BLOCK_LABEL_611;
            }
            prefHelper_.setDeviceFingerPrintID(serverresponse.getObject().getString(Defines.Jsonkey.DeviceFingerprintID.getKey()));
            j = 1;
            if (!j)
            {
                break MISSING_BLOCK_LABEL_623;
            }
            updateAllRequestsInQueue();
            if (!(thisReq_ instanceof ServerRequestInitSession))
            {
                break MISSING_BLOCK_LABEL_718;
            }
            initState_ = SESSION_STATE.INITIALISED;
            thisReq_.onRequestSucceeded(serverresponse, Branch.branchReferral_);
            isInitReportedThroughCallBack = ((ServerRequestInitSession)thisReq_).hasCallBack();
            checkForAutoDeepLinkConfiguration();
              goto _L7
_L17:
            if (!(thisReq_ instanceof ServerRequestLogout)) goto _L20; else goto _L19
_L19:
            linkCache_.clear();
            requestQueue_.clear();
              goto _L20
            thisReq_.onRequestSucceeded(serverresponse, Branch.branchReferral_);
              goto _L7
            thisReq_.onRequestSucceeded(serverresponse, Branch.branchReferral_);
              goto _L7
        }

        protected volatile void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "Branch$BranchPostTask#onPostExecute", null);
_L1:
            onPostExecute((ServerResponse)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "Branch$BranchPostTask#onPostExecute", null);
              goto _L1
        }

        public BranchPostTask(ServerRequest serverrequest)
        {
            this$0 = Branch.this;
            super();
            timeOut_ = 0;
            thisReq_ = serverrequest;
            timeOut_ = prefHelper_.getTimeout();
        }
    }

    public static interface BranchReferralInitListener
    {

        public abstract void onInitFinished(JSONObject jsonobject, BranchError brancherror);
    }

    public static interface BranchReferralStateChangedListener
    {

        public abstract void onStateChanged(boolean flag, BranchError brancherror);
    }

    public static interface BranchUniversalReferralInitListener
    {

        public abstract void onInitFinished(BranchUniversalObject branchuniversalobject, LinkProperties linkproperties, BranchError brancherror);
    }

    public class BranchWindowCallback
        implements android.view.Window.Callback
    {

        private android.view.Window.Callback callback_;
        private Runnable longPressed_;
        final Branch this$0;

        public boolean dispatchGenericMotionEvent(MotionEvent motionevent)
        {
            return callback_.dispatchGenericMotionEvent(motionevent);
        }

        public boolean dispatchKeyEvent(KeyEvent keyevent)
        {
            return callback_.dispatchKeyEvent(keyevent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
        {
            return callback_.dispatchKeyShortcutEvent(keyevent);
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
        {
            return callback_.dispatchPopulateAccessibilityEvent(accessibilityevent);
        }

        public boolean dispatchTouchEvent(MotionEvent motionevent)
        {
            motionevent.getAction() & 0xff;
            JVM INSTR tableswitch 0 5: default 48
        //                       0 59
        //                       1 110
        //                       2 48
        //                       3 93
        //                       4 48
        //                       5 127;
               goto _L1 _L2 _L3 _L1 _L4 _L1 _L5
_L1:
            return callback_.dispatchTouchEvent(motionevent);
_L2:
            if (systemObserver_.isSimulator())
            {
                debugHandler_.postDelayed(longPressed_, 3000L);
            }
            continue; /* Loop/switch isn't completed */
_L4:
            debugHandler_.removeCallbacks(longPressed_);
            continue; /* Loop/switch isn't completed */
_L3:
            debugHandler_.removeCallbacks(longPressed_);
            continue; /* Loop/switch isn't completed */
_L5:
            if (motionevent.getPointerCount() == 4)
            {
                debugHandler_.postDelayed(longPressed_, 3000L);
            }
            if (true) goto _L1; else goto _L6
_L6:
        }

        public boolean dispatchTrackballEvent(MotionEvent motionevent)
        {
            return callback_.dispatchTrackballEvent(motionevent);
        }

        public void onActionModeFinished(ActionMode actionmode)
        {
            callback_.onActionModeFinished(actionmode);
        }

        public void onActionModeStarted(ActionMode actionmode)
        {
            callback_.onActionModeStarted(actionmode);
        }

        public void onAttachedToWindow()
        {
            callback_.onAttachedToWindow();
        }

        public void onContentChanged()
        {
            callback_.onContentChanged();
        }

        public boolean onCreatePanelMenu(int i, Menu menu)
        {
            return callback_.onCreatePanelMenu(i, menu);
        }

        public View onCreatePanelView(int i)
        {
            return callback_.onCreatePanelView(i);
        }

        public void onDetachedFromWindow()
        {
            callback_.onDetachedFromWindow();
        }

        public boolean onMenuItemSelected(int i, MenuItem menuitem)
        {
            return callback_.onMenuItemSelected(i, menuitem);
        }

        public boolean onMenuOpened(int i, Menu menu)
        {
            return callback_.onMenuOpened(i, menu);
        }

        public void onPanelClosed(int i, Menu menu)
        {
            callback_.onPanelClosed(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu)
        {
            return callback_.onPreparePanel(i, view, menu);
        }

        public boolean onSearchRequested()
        {
            return callback_.onSearchRequested();
        }

        public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutparams)
        {
            callback_.onWindowAttributesChanged(layoutparams);
        }

        public void onWindowFocusChanged(boolean flag)
        {
            callback_.onWindowFocusChanged(flag);
        }

        public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback)
        {
            return callback_.onWindowStartingActionMode(callback);
        }



        public BranchWindowCallback(android.view.Window.Callback callback)
        {
            this$0 = Branch.this;
            super();
            callback_ = callback;
            if (longPressed_ == null)
            {
                longPressed_ = new _cls1();
            }
        }
    }

    class BranchWindowCallback.KeepDebugConnectionTask extends TimerTask
    {

        final BranchWindowCallback this$1;

        public void run()
        {
            if (debugStarted_ && !prefHelper_.keepDebugConnection() && longPressed_ != null)
            {
                debugHandler_.post(longPressed_);
            }
        }

        BranchWindowCallback.KeepDebugConnectionTask()
        {
            this$1 = BranchWindowCallback.this;
            super();
        }
    }

    private static final class CUSTOM_REFERRABLE_SETTINGS extends Enum
    {

        private static final CUSTOM_REFERRABLE_SETTINGS $VALUES[];
        public static final CUSTOM_REFERRABLE_SETTINGS NON_REFERRABLE;
        public static final CUSTOM_REFERRABLE_SETTINGS REFERRABLE;
        public static final CUSTOM_REFERRABLE_SETTINGS USE_DEFAULT;

        public static CUSTOM_REFERRABLE_SETTINGS valueOf(String s)
        {
            return (CUSTOM_REFERRABLE_SETTINGS)Enum.valueOf(io/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS, s);
        }

        public static CUSTOM_REFERRABLE_SETTINGS[] values()
        {
            return (CUSTOM_REFERRABLE_SETTINGS[])$VALUES.clone();
        }

        static 
        {
            USE_DEFAULT = new CUSTOM_REFERRABLE_SETTINGS("USE_DEFAULT", 0);
            REFERRABLE = new CUSTOM_REFERRABLE_SETTINGS("REFERRABLE", 1);
            NON_REFERRABLE = new CUSTOM_REFERRABLE_SETTINGS("NON_REFERRABLE", 2);
            $VALUES = (new CUSTOM_REFERRABLE_SETTINGS[] {
                USE_DEFAULT, REFERRABLE, NON_REFERRABLE
            });
        }

        private CUSTOM_REFERRABLE_SETTINGS(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class CreditHistoryOrder extends Enum
    {

        private static final CreditHistoryOrder $VALUES[];
        public static final CreditHistoryOrder kLeastRecentFirst;
        public static final CreditHistoryOrder kMostRecentFirst;

        public static CreditHistoryOrder valueOf(String s)
        {
            return (CreditHistoryOrder)Enum.valueOf(io/branch/referral/Branch$CreditHistoryOrder, s);
        }

        public static CreditHistoryOrder[] values()
        {
            return (CreditHistoryOrder[])$VALUES.clone();
        }

        static 
        {
            kMostRecentFirst = new CreditHistoryOrder("kMostRecentFirst", 0);
            kLeastRecentFirst = new CreditHistoryOrder("kLeastRecentFirst", 1);
            $VALUES = (new CreditHistoryOrder[] {
                kMostRecentFirst, kLeastRecentFirst
            });
        }

        private CreditHistoryOrder(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface LogoutStatusListener
    {

        public abstract void onLogoutFinished(boolean flag, BranchError brancherror);
    }

    private static final class SESSION_STATE extends Enum
    {

        private static final SESSION_STATE $VALUES[];
        public static final SESSION_STATE INITIALISED;
        public static final SESSION_STATE INITIALISING;
        public static final SESSION_STATE UNINITIALISED;

        public static SESSION_STATE valueOf(String s)
        {
            return (SESSION_STATE)Enum.valueOf(io/branch/referral/Branch$SESSION_STATE, s);
        }

        public static SESSION_STATE[] values()
        {
            return (SESSION_STATE[])$VALUES.clone();
        }

        static 
        {
            INITIALISED = new SESSION_STATE("INITIALISED", 0);
            INITIALISING = new SESSION_STATE("INITIALISING", 1);
            UNINITIALISED = new SESSION_STATE("UNINITIALISED", 2);
            $VALUES = (new SESSION_STATE[] {
                INITIALISED, INITIALISING, UNINITIALISED
            });
        }

        private SESSION_STATE(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ShareLinkBuilder
    {

        private final Activity activity_;
        private final Branch branch_;
        private BranchLinkShareListener callback_;
        private String copyURlText_;
        private Drawable copyUrlIcon_;
        private String defaultURL_;
        private Drawable moreOptionIcon_;
        private String moreOptionText_;
        private ArrayList preferredOptions_;
        private String shareMsg_;
        private String shareSub_;
        BranchShortLinkBuilder shortLinkBuilder_;
        private String urlCopiedMessage_;

        public ShareLinkBuilder addParam(String s, String s1)
        {
            try
            {
                shortLinkBuilder_.addParameters(s, s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return this;
            }
            return this;
        }

        public ShareLinkBuilder addPreferredSharingOption(SharingHelper.SHARE_WITH share_with)
        {
            preferredOptions_.add(share_with);
            return this;
        }

        public ShareLinkBuilder addPreferredSharingOptions(ArrayList arraylist)
        {
            preferredOptions_.addAll(arraylist);
            return this;
        }

        public ShareLinkBuilder addTag(String s)
        {
            shortLinkBuilder_.addTag(s);
            return this;
        }

        public ShareLinkBuilder addTags(ArrayList arraylist)
        {
            shortLinkBuilder_.addTags(arraylist);
            return this;
        }

        public Activity getActivity()
        {
            return activity_;
        }

        public Branch getBranch()
        {
            return branch_;
        }

        public BranchLinkShareListener getCallback()
        {
            return callback_;
        }

        public String getCopyURlText()
        {
            return copyURlText_;
        }

        public Drawable getCopyUrlIcon()
        {
            return copyUrlIcon_;
        }

        public String getDefaultURL()
        {
            return defaultURL_;
        }

        public Drawable getMoreOptionIcon()
        {
            return moreOptionIcon_;
        }

        public String getMoreOptionText()
        {
            return moreOptionText_;
        }

        public ArrayList getPreferredOptions()
        {
            return preferredOptions_;
        }

        public String getShareMsg()
        {
            return shareMsg_;
        }

        public String getShareSub()
        {
            return shareSub_;
        }

        public BranchShortLinkBuilder getShortLinkBuilder()
        {
            return shortLinkBuilder_;
        }

        public String getUrlCopiedMessage()
        {
            return urlCopiedMessage_;
        }

        public ShareLinkBuilder setAlias(String s)
        {
            shortLinkBuilder_.setAlias(s);
            return this;
        }

        public ShareLinkBuilder setCallback(BranchLinkShareListener branchlinksharelistener)
        {
            callback_ = branchlinksharelistener;
            return this;
        }

        public ShareLinkBuilder setCopyUrlStyle(int i, int j, int k)
        {
            copyUrlIcon_ = BranchUtil.getDrawable(activity_.getApplicationContext(), i);
            copyURlText_ = activity_.getResources().getString(j);
            urlCopiedMessage_ = activity_.getResources().getString(k);
            return this;
        }

        public ShareLinkBuilder setCopyUrlStyle(Drawable drawable, String s, String s1)
        {
            copyUrlIcon_ = drawable;
            copyURlText_ = s;
            urlCopiedMessage_ = s1;
            return this;
        }

        public ShareLinkBuilder setDefaultURL(String s)
        {
            defaultURL_ = s;
            return this;
        }

        public ShareLinkBuilder setFeature(String s)
        {
            shortLinkBuilder_.setFeature(s);
            return this;
        }

        public ShareLinkBuilder setMatchDuration(int i)
        {
            shortLinkBuilder_.setDuration(i);
            return this;
        }

        public ShareLinkBuilder setMessage(String s)
        {
            shareMsg_ = s;
            return this;
        }

        public ShareLinkBuilder setMoreOptionStyle(int i, int j)
        {
            moreOptionIcon_ = BranchUtil.getDrawable(activity_.getApplicationContext(), i);
            moreOptionText_ = activity_.getResources().getString(j);
            return this;
        }

        public ShareLinkBuilder setMoreOptionStyle(Drawable drawable, String s)
        {
            moreOptionIcon_ = drawable;
            moreOptionText_ = s;
            return this;
        }

        public void setShortLinkBuilderInternal(BranchShortLinkBuilder branchshortlinkbuilder)
        {
            shortLinkBuilder_ = branchshortlinkbuilder;
        }

        public ShareLinkBuilder setStage(String s)
        {
            shortLinkBuilder_.setStage(s);
            return this;
        }

        public ShareLinkBuilder setSubject(String s)
        {
            shareSub_ = s;
            return this;
        }

        public void shareLink()
        {
            Branch.branchReferral_.shareLink(this);
        }

        public ShareLinkBuilder(Activity activity, BranchShortLinkBuilder branchshortlinkbuilder)
        {
            this(activity, new JSONObject());
            shortLinkBuilder_ = branchshortlinkbuilder;
        }

        public ShareLinkBuilder(Activity activity, JSONObject jsonobject)
        {
            callback_ = null;
            activity_ = activity;
            branch_ = Branch.branchReferral_;
            shortLinkBuilder_ = new BranchShortLinkBuilder(activity);
            try
            {
                String s;
                for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); shortLinkBuilder_.addParameters(s, (String)jsonobject.get(s)))
                {
                    s = (String)iterator.next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
            shareMsg_ = "";
            callback_ = null;
            preferredOptions_ = new ArrayList();
            defaultURL_ = null;
            moreOptionIcon_ = BranchUtil.getDrawable(activity.getApplicationContext(), 0x1080045);
            moreOptionText_ = "More...";
            copyUrlIcon_ = BranchUtil.getDrawable(activity.getApplicationContext(), 0x108004e);
            copyURlText_ = "Copy link";
            urlCopiedMessage_ = "Copied link to clipboard!";
        }
    }

    private class getShortLinkTask extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final Branch this$0;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient ServerResponse doInBackground(ServerRequest aserverrequest[])
        {
            return kRemoteInterface_.createCustomUrlSync(aserverrequest[0].getPost());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "Branch$getShortLinkTask#doInBackground", null);
_L1:
            aobj = doInBackground((ServerRequest[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "Branch$getShortLinkTask#doInBackground", null);
              goto _L1
        }

        private getShortLinkTask()
        {
            this$0 = Branch.this;
            super();
        }

    }


    public static final String ALWAYS_DEEPLINK = "$always_deeplink";
    private static final String AUTO_DEEP_LINKED = "io.branch.sdk.auto_linked";
    private static final String AUTO_DEEP_LINK_DISABLE = "io.branch.sdk.auto_link_disable";
    private static final String AUTO_DEEP_LINK_KEY = "io.branch.sdk.auto_link_keys";
    private static final String AUTO_DEEP_LINK_PATH = "io.branch.sdk.auto_link_path";
    private static final String AUTO_DEEP_LINK_REQ_CODE = "io.branch.sdk.auto_link_request_code";
    public static final String DEEPLINK_PATH = "$deeplink_path";
    private static final int DEF_AUTO_DEEP_LINK_REQ_CODE = 1501;
    public static final String FEATURE_TAG_DEAL = "deal";
    public static final String FEATURE_TAG_GIFT = "gift";
    public static final String FEATURE_TAG_INVITE = "invite";
    public static final String FEATURE_TAG_REFERRAL = "referral";
    public static final String FEATURE_TAG_SHARE = "share";
    public static final int LINK_TYPE_ONE_TIME_USE = 1;
    public static final int LINK_TYPE_UNLIMITED_USE = 0;
    public static final String OG_APP_ID = "$og_app_id";
    public static final String OG_DESC = "$og_description";
    public static final String OG_IMAGE_URL = "$og_image_url";
    public static final String OG_TITLE = "$og_title";
    public static final String OG_URL = "$og_url";
    public static final String OG_VIDEO = "$og_video";
    private static final int PREVENT_CLOSE_TIMEOUT = 500;
    public static final String REDEEM_CODE = "$redeem_code";
    public static final String REDIRECT_ANDROID_URL = "$android_url";
    public static final String REDIRECT_BLACKBERRY_URL = "$blackberry_url";
    public static final String REDIRECT_DESKTOP_URL = "$desktop_url";
    public static final String REDIRECT_FIRE_URL = "$fire_url";
    public static final String REDIRECT_IOS_URL = "$ios_url";
    public static final String REDIRECT_IPAD_URL = "$ipad_url";
    public static final String REDIRECT_WINDOWS_PHONE_URL = "$windows_phone_url";
    public static final String REFERRAL_BUCKET_DEFAULT = "default";
    public static final String REFERRAL_CODE = "referral_code";
    public static final int REFERRAL_CODE_AWARD_UNIQUE = 0;
    public static final int REFERRAL_CODE_AWARD_UNLIMITED = 1;
    public static final int REFERRAL_CODE_LOCATION_BOTH = 3;
    public static final int REFERRAL_CODE_LOCATION_REFERREE = 0;
    public static final int REFERRAL_CODE_LOCATION_REFERRING_USER = 2;
    public static final String REFERRAL_CODE_TYPE = "credit";
    public static final int REFERRAL_CREATION_SOURCE_SDK = 2;
    private static final int SESSION_KEEPALIVE = 2000;
    private static final String TAG = "BranchSDK";
    private static Branch branchReferral_;
    private static CUSTOM_REFERRABLE_SETTINGS customReferrableSettings_;
    private static boolean isActivityLifeCycleCallbackRegistered_ = false;
    private static boolean isAutoSessionMode_ = false;
    private ScheduledFuture appListingSchedule_;
    private Timer closeTimer;
    private Context context_;
    private Activity currentActivity_;
    private Handler debugHandler_;
    private SparseArray debugListenerInitHistory_;
    private android.view.View.OnTouchListener debugOnTouchListener_;
    private boolean debugStarted_;
    private boolean hasNetwork_;
    private SESSION_STATE initState_;
    private boolean isInitReportedThroughCallBack;
    private BranchRemoteInterface kRemoteInterface_;
    private boolean keepAlive_;
    private Map linkCache_;
    final Object lock = new Object();
    private int networkCount_;
    private PrefHelper prefHelper_;
    private ServerRequestQueue requestQueue_;
    private Timer rotateCloseTimer;
    private Semaphore serverSema_;
    private ShareLinkManager shareLinkManager_;
    private SystemObserver systemObserver_;

    private Branch(Context context)
    {
        initState_ = SESSION_STATE.UNINITIALISED;
        isInitReportedThroughCallBack = false;
        prefHelper_ = PrefHelper.getInstance(context);
        kRemoteInterface_ = new BranchRemoteInterface(context);
        systemObserver_ = new SystemObserver(context);
        requestQueue_ = ServerRequestQueue.getInstance(context);
        serverSema_ = new Semaphore(1);
        closeTimer = new Timer();
        rotateCloseTimer = new Timer();
        keepAlive_ = false;
        networkCount_ = 0;
        hasNetwork_ = true;
        debugListenerInitHistory_ = new SparseArray();
        debugOnTouchListener_ = retrieveOnTouchListener();
        debugHandler_ = new Handler();
        debugStarted_ = false;
        linkCache_ = new HashMap();
    }

    private void checkForAutoDeepLinkConfiguration()
    {
        Object obj;
        Object obj2;
        Intent intent;
        JSONObject jsonobject;
        jsonobject = getLatestReferringParams();
        intent = null;
        obj2 = null;
        obj = intent;
        if (!jsonobject.has(Defines.Jsonkey.Clicked_Branch_Link.getKey())) goto _L2; else goto _L1
_L1:
        obj = intent;
        if (!jsonobject.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey()))
        {
            return;
        }
        obj = intent;
        if (jsonobject.length() <= 0) goto _L2; else goto _L3
_L3:
        obj = intent;
        Object obj1 = context_.getPackageManager().getApplicationInfo(context_.getPackageName(), 128);
        obj = intent;
        if (((ApplicationInfo) (obj1)).metaData == null) goto _L5; else goto _L4
_L4:
        obj = intent;
        if (((ApplicationInfo) (obj1)).metaData.getBoolean("io.branch.sdk.auto_link_disable", false)) goto _L2; else goto _L5
_L5:
        obj = intent;
        ActivityInfo aactivityinfo[] = context_.getPackageManager().getPackageInfo(context_.getPackageName(), 129).activities;
        int j;
        char c;
        c = '\u05DD';
        obj1 = obj2;
        j = c;
        if (aactivityinfo == null) goto _L7; else goto _L6
_L6:
        obj = intent;
        int k = aactivityinfo.length;
        int i = 0;
_L25:
        obj1 = obj2;
        j = c;
        if (i >= k) goto _L7; else goto _L8
_L8:
        ActivityInfo activityinfo = aactivityinfo[i];
        if (activityinfo == null) goto _L10; else goto _L9
_L9:
        obj = intent;
        if (activityinfo.metaData == null) goto _L10; else goto _L11
_L11:
        obj = intent;
        if (activityinfo.metaData.getString("io.branch.sdk.auto_link_keys") != null) goto _L13; else goto _L12
_L12:
        obj = intent;
        if (activityinfo.metaData.getString("io.branch.sdk.auto_link_path") == null) goto _L10; else goto _L13
_L13:
        obj = intent;
        if (checkForAutoDeepLinkKeys(jsonobject, activityinfo)) goto _L15; else goto _L14
_L14:
        obj = intent;
        if (!checkForAutoDeepLinkPath(jsonobject, activityinfo)) goto _L10; else goto _L15
_L15:
        obj = intent;
        obj1 = activityinfo.name;
        obj = obj1;
        j = activityinfo.metaData.getInt("io.branch.sdk.auto_link_request_code", 1501);
_L7:
        if (obj1 == null) goto _L2; else goto _L16
_L16:
        obj = obj1;
        if (currentActivity_ == null) goto _L2; else goto _L17
_L17:
        obj = obj1;
        intent = new Intent(currentActivity_, Class.forName(((String) (obj1))));
        obj = obj1;
        intent.putExtra("io.branch.sdk.auto_linked", "true");
        obj = obj1;
        String s = Defines.Jsonkey.ReferringData.getKey();
        obj = obj1;
        if (jsonobject instanceof JSONObject) goto _L19; else goto _L18
_L18:
        obj = obj1;
        obj2 = jsonobject.toString();
_L23:
        obj = obj1;
        intent.putExtra(s, ((String) (obj2)));
        obj = obj1;
        obj2 = jsonobject.keys();
_L21:
        obj = obj1;
        if (!((Iterator) (obj2)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        s = (String)((Iterator) (obj2)).next();
        obj = obj1;
        intent.putExtra(s, jsonobject.getString(s));
        if (true) goto _L21; else goto _L20
_L20:
        break; /* Loop/switch isn't completed */
_L10:
        i++;
        continue; /* Loop/switch isn't completed */
_L19:
        obj = obj1;
        obj2 = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        if (true) goto _L23; else goto _L22
_L22:
        obj = obj1;
        try
        {
            currentActivity_.startActivityForResult(intent, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.i("BranchSDK", "Branch Warning: Please make sure Activity names set for auto deep link are correct!");
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.i("BranchSDK", (new StringBuilder()).append("Branch Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity ").append(((String) (obj))).toString());
            return;
        }
        catch (JSONException jsonexception) { }
_L2:
        return;
        if (true) goto _L25; else goto _L24
_L24:
    }

    private boolean checkForAutoDeepLinkKeys(JSONObject jsonobject, ActivityInfo activityinfo)
    {
        if (activityinfo.metaData.getString("io.branch.sdk.auto_link_keys") != null)
        {
            activityinfo = activityinfo.metaData.getString("io.branch.sdk.auto_link_keys").split(",");
            int j = activityinfo.length;
            for (int i = 0; i < j; i++)
            {
                if (jsonobject.has(activityinfo[i]))
                {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean checkForAutoDeepLinkPath(JSONObject jsonobject, ActivityInfo activityinfo)
    {
        Object obj = null;
        if (!jsonobject.has(Defines.Jsonkey.AndroidDeepLinkPath.getKey())) goto _L2; else goto _L1
_L1:
        String s = jsonobject.getString(Defines.Jsonkey.AndroidDeepLinkPath.getKey());
_L7:
        if (activityinfo.metaData.getString("io.branch.sdk.auto_link_path") == null || s == null) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        jsonobject = activityinfo.metaData.getString("io.branch.sdk.auto_link_path").split(",");
        j = jsonobject.length;
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (pathMatch(jsonobject[i].trim(), s))
        {
            return true;
        }
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        s = obj;
        try
        {
            if (jsonobject.has(Defines.Jsonkey.DeepLinkPath.getKey()))
            {
                s = jsonobject.getString(Defines.Jsonkey.DeepLinkPath.getKey());
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            s = obj;
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L4
_L4:
        return false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void clearCloseTimer()
    {
        if (rotateCloseTimer == null)
        {
            return;
        } else
        {
            rotateCloseTimer.cancel();
            rotateCloseTimer.purge();
            rotateCloseTimer = new Timer();
            return;
        }
    }

    private void clearTimer()
    {
        if (closeTimer == null)
        {
            return;
        } else
        {
            closeTimer.cancel();
            closeTimer.purge();
            closeTimer = new Timer();
            return;
        }
    }

    private void clearTouchDebugInternal(Activity activity)
    {
        if (activity.getWindow().getCallback() instanceof BranchWindowCallback)
        {
            android.view.Window.Callback callback = ((BranchWindowCallback)activity.getWindow().getCallback()).callback_;
            activity.getWindow().setCallback(callback);
            debugListenerInitHistory_.remove(System.identityHashCode(activity));
            if (debugHandler_ != null)
            {
                debugHandler_.removeCallbacksAndMessages(null);
            }
        }
    }

    private void closeSessionInternal()
    {
        executeClose();
        if (prefHelper_.getExternAppListing() && appListingSchedule_ == null)
        {
            scheduleListOfApps();
        }
    }

    private String convertDate(Date date)
    {
        return DateFormat.format("yyyy-MM-dd", date).toString();
    }

    private JSONObject convertParamsStringToDictionary(String s)
    {
        if (s.equals("bnc_no_value"))
        {
            return new JSONObject();
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = JSONObjectInstrumentation.init(s);
        }
        catch (JSONException jsonexception)
        {
            s = Base64.decode(s.getBytes(), 2);
            try
            {
                s = JSONObjectInstrumentation.init(new String(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return new JSONObject();
            }
            return s;
        }
        return jsonobject;
    }

    private void executeClose()
    {
        if (initState_ == SESSION_STATE.UNINITIALISED) goto _L2; else goto _L1
_L1:
        if (hasNetwork_) goto _L4; else goto _L3
_L3:
        ServerRequest serverrequest = requestQueue_.peek();
        if (serverrequest != null && (serverrequest instanceof ServerRequestRegisterInstall) || (serverrequest instanceof ServerRequestRegisterOpen))
        {
            requestQueue_.dequeue();
        }
_L6:
        initState_ = SESSION_STATE.UNINITIALISED;
_L2:
        return;
_L4:
        if (!requestQueue_.containsClose())
        {
            handleNewRequest(new ServerRequestRegisterClose(context_));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private String generateShortLink(String s, int i, int j, Collection collection, String s1, String s2, String s3, 
            String s4, BranchLinkCreateListener branchlinkcreatelistener, boolean flag)
    {
label0:
        {
            s = new ServerRequestCreateUrl(context_, s, i, j, collection, s1, s2, s3, s4, branchlinkcreatelistener, flag);
            if (!((ServerRequestCreateUrl) (s)).constructError_ && !s.handleErrors(context_))
            {
                if (linkCache_.containsKey(s.getLinkPost()))
                {
                    s = (String)linkCache_.get(s.getLinkPost());
                    if (branchlinkcreatelistener != null)
                    {
                        branchlinkcreatelistener.onLinkCreate(s, null);
                    }
                    return s;
                }
                if (!flag)
                {
                    break label0;
                }
                generateShortLinkAsync(s);
            }
            return null;
        }
        return generateShortLinkSync(s);
    }

    private void generateShortLinkAsync(ServerRequest serverrequest)
    {
        handleNewRequest(serverrequest);
    }

    private String generateShortLinkSync(ServerRequestCreateUrl serverrequestcreateurl)
    {
        if (initState_ != SESSION_STATE.INITIALISED) goto _L2; else goto _L1
_L1:
        Object obj2 = null;
        Object obj;
        Object obj3;
        int i;
        i = prefHelper_.getTimeout();
        obj = new getShortLinkTask(null);
        obj3 = new ServerRequest[1];
        obj3[0] = serverrequestcreateurl;
        if (obj instanceof AsyncTask) goto _L4; else goto _L3
_L3:
        obj = ((getShortLinkTask) (obj)).execute(((Object []) (obj3)));
_L5:
        obj = (ServerResponse)((AsyncTask) (obj)).get(i + 2000, TimeUnit.MILLISECONDS);
_L6:
        obj2 = serverrequestcreateurl.getLongUrl();
        serverrequestcreateurl = ((ServerRequestCreateUrl) (obj2));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        serverrequestcreateurl = ((ServerRequestCreateUrl) (obj2));
        if (((ServerResponse) (obj)).getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        try
        {
            obj3 = ((ServerResponse) (obj)).getObject().getString("url");
        }
        // Misplaced declaration of an exception variable
        catch (ServerRequestCreateUrl serverrequestcreateurl)
        {
            serverrequestcreateurl.printStackTrace();
            return ((String) (obj2));
        }
        serverrequestcreateurl = ((ServerRequestCreateUrl) (obj3));
        obj2 = obj3;
        if (((ServerResponse) (obj)).getLinkData() == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        obj2 = obj3;
        linkCache_.put(((ServerResponse) (obj)).getLinkData(), obj3);
        serverrequestcreateurl = ((ServerRequestCreateUrl) (obj3));
        return serverrequestcreateurl;
_L4:
        obj = AsyncTaskInstrumentation.execute((AsyncTask)obj, ((Object []) (obj3)));
          goto _L5
_L2:
        Log.i("BranchSDK", "Branch Warning: User session has not been initialized");
        return null;
        Object obj1;
        obj1;
        obj1 = obj2;
          goto _L6
        obj1;
        obj1 = obj2;
          goto _L6
        obj1;
        obj1 = obj2;
          goto _L6
    }

    public static Branch getAutoInstance(Context context)
    {
        boolean flag = true;
        isAutoSessionMode_ = true;
        customReferrableSettings_ = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
        if (BranchUtil.isTestModeEnabled(context))
        {
            flag = false;
        }
        getBranchInstance(context, flag);
        branchReferral_.setActivityLifeCycleObserver((Application)context);
        return branchReferral_;
    }

    public static Branch getAutoInstance(Context context, boolean flag)
    {
        isAutoSessionMode_ = true;
        CUSTOM_REFERRABLE_SETTINGS custom_referrable_settings;
        if (flag)
        {
            custom_referrable_settings = CUSTOM_REFERRABLE_SETTINGS.REFERRABLE;
        } else
        {
            custom_referrable_settings = CUSTOM_REFERRABLE_SETTINGS.NON_REFERRABLE;
        }
        customReferrableSettings_ = custom_referrable_settings;
        if (!BranchUtil.isTestModeEnabled(context))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        getBranchInstance(context, flag);
        branchReferral_.setActivityLifeCycleObserver((Application)context);
        return branchReferral_;
    }

    public static Branch getAutoTestInstance(Context context)
    {
        isAutoSessionMode_ = true;
        customReferrableSettings_ = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
        getBranchInstance(context, false);
        branchReferral_.setActivityLifeCycleObserver((Application)context);
        return branchReferral_;
    }

    public static Branch getAutoTestInstance(Context context, boolean flag)
    {
        isAutoSessionMode_ = true;
        CUSTOM_REFERRABLE_SETTINGS custom_referrable_settings;
        if (flag)
        {
            custom_referrable_settings = CUSTOM_REFERRABLE_SETTINGS.REFERRABLE;
        } else
        {
            custom_referrable_settings = CUSTOM_REFERRABLE_SETTINGS.NON_REFERRABLE;
        }
        customReferrableSettings_ = custom_referrable_settings;
        getBranchInstance(context, false);
        branchReferral_.setActivityLifeCycleObserver((Application)context);
        return branchReferral_;
    }

    private static Branch getBranchInstance(Context context, boolean flag)
    {
        if (branchReferral_ == null)
        {
            branchReferral_ = initInstance(context);
            String s = branchReferral_.prefHelper_.readBranchKey(flag);
            if (s == null || s.equalsIgnoreCase("bnc_no_value"))
            {
                Log.i("BranchSDK", "Branch Warning: Please enter your branch_key in your project's Manifest file!");
                flag = branchReferral_.prefHelper_.setBranchKey("bnc_no_value");
            } else
            {
                flag = branchReferral_.prefHelper_.setBranchKey(s);
            }
            if (flag)
            {
                branchReferral_.linkCache_.clear();
                branchReferral_.requestQueue_.clear();
            }
        }
        branchReferral_.context_ = context.getApplicationContext();
        if (context instanceof BranchApp)
        {
            isAutoSessionMode_ = true;
            branchReferral_.setActivityLifeCycleObserver((Application)context);
        }
        return branchReferral_;
    }

    public static Branch getInstance()
    {
        if (branchReferral_ != null) goto _L2; else goto _L1
_L1:
        Log.e("BranchSDK", "Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
_L4:
        return branchReferral_;
_L2:
        if (isAutoSessionMode_ && !isActivityLifeCycleCallbackRegistered_)
        {
            Log.e("BranchSDK", "Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Branch getInstance(Context context)
    {
        return getBranchInstance(context, true);
    }

    public static Branch getInstance(Context context, String s)
    {
        if (branchReferral_ == null)
        {
            branchReferral_ = initInstance(context);
        }
        branchReferral_.context_ = context.getApplicationContext();
        if (s.startsWith("key_"))
        {
            if (branchReferral_.prefHelper_.setBranchKey(s))
            {
                branchReferral_.linkCache_.clear();
                branchReferral_.requestQueue_.clear();
            }
        } else
        {
            branchReferral_.prefHelper_.setAppKey(s);
        }
        return branchReferral_;
    }

    public static Branch getTestInstance(Context context)
    {
        return getBranchInstance(context, false);
    }

    private void handleFailure(int i, int j)
    {
        ServerRequest serverrequest;
        if (i >= requestQueue_.getSize())
        {
            serverrequest = requestQueue_.peekAt(requestQueue_.getSize() - 1);
        } else
        {
            serverrequest = requestQueue_.peekAt(i);
        }
        handleFailure(serverrequest, j);
    }

    private void handleFailure(ServerRequest serverrequest, int i)
    {
        if (serverrequest == null)
        {
            return;
        } else
        {
            serverrequest.handleFailure(i, "");
            return;
        }
    }

    private void handleNewRequest(ServerRequest serverrequest)
    {
        boolean flag = true;
        if (initState_ != SESSION_STATE.INITIALISED && !(serverrequest instanceof ServerRequestInitSession))
        {
            if (serverrequest instanceof ServerRequestLogout)
            {
                serverrequest.handleFailure(-101, "");
                Log.i("BranchSDK", "Branch is not initialized, cannot logout");
                return;
            }
            if (serverrequest instanceof ServerRequestRegisterClose)
            {
                Log.i("BranchSDK", "Branch is not initialized, cannot close session");
                return;
            }
            if (customReferrableSettings_ == CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT)
            {
                initUserSessionInternal((BranchReferralInitListener)null, currentActivity_, true);
            } else
            {
                if (customReferrableSettings_ != CUSTOM_REFERRABLE_SETTINGS.REFERRABLE)
                {
                    flag = false;
                }
                initUserSessionInternal((BranchReferralInitListener)null, currentActivity_, flag);
            }
        }
        requestQueue_.enqueue(serverrequest);
        processNextQueueItem();
    }

    private boolean hasDeviceFingerPrint()
    {
        return !prefHelper_.getDeviceFingerPrintID().equals("bnc_no_value");
    }

    private boolean hasSession()
    {
        return !prefHelper_.getSessionID().equals("bnc_no_value");
    }

    private boolean hasUser()
    {
        return !prefHelper_.getIdentityID().equals("bnc_no_value");
    }

    private static Branch initInstance(Context context)
    {
        return new Branch(context.getApplicationContext());
    }

    private void initUserSessionInternal(BranchReferralInitListener branchreferralinitlistener, Activity activity, boolean flag)
    {
        currentActivity_ = activity;
        if (hasUser() && hasSession() && initState_ == SESSION_STATE.INITIALISED)
        {
            if (branchreferralinitlistener != null)
            {
                if (isAutoSessionMode_)
                {
                    if (!isInitReportedThroughCallBack)
                    {
                        branchreferralinitlistener.onInitFinished(getLatestReferringParams(), null);
                        isInitReportedThroughCallBack = true;
                    } else
                    {
                        branchreferralinitlistener.onInitFinished(new JSONObject(), null);
                    }
                } else
                {
                    branchreferralinitlistener.onInitFinished(new JSONObject(), null);
                }
            }
            clearCloseTimer();
            keepAlive();
        } else
        {
            if (flag)
            {
                prefHelper_.setIsReferrable();
            } else
            {
                prefHelper_.clearIsReferrable();
            }
            if (initState_ == SESSION_STATE.INITIALISING)
            {
                requestQueue_.setInstallOrOpenCallback(branchreferralinitlistener);
            } else
            {
                initState_ = SESSION_STATE.INITIALISING;
                initializeSession(branchreferralinitlistener);
            }
        }
        if (prefHelper_.getTouchDebugging() && activity != null && debugListenerInitHistory_.get(System.identityHashCode(activity)) == null)
        {
            debugListenerInitHistory_.put(System.identityHashCode(activity), "init");
            branchreferralinitlistener = activity.getWindow().getDecorView().findViewById(0x1020002);
            if (branchreferralinitlistener != null)
            {
                branchreferralinitlistener.setOnTouchListener(debugOnTouchListener_);
            }
        }
    }

    private void initUserSessionInternal(BranchUniversalReferralInitListener branchuniversalreferralinitlistener, Activity activity, boolean flag)
    {
        initUserSessionInternal(((BranchReferralInitListener) (new BranchUniversalReferralInitWrapper(branchuniversalreferralinitlistener))), activity, flag);
    }

    private void initializeSession(BranchReferralInitListener branchreferralinitlistener)
    {
        if ((prefHelper_.getBranchKey() == null || prefHelper_.getBranchKey().equalsIgnoreCase("bnc_no_value")) && (prefHelper_.getAppKey() == null || prefHelper_.getAppKey().equalsIgnoreCase("bnc_no_value")))
        {
            initState_ = SESSION_STATE.UNINITIALISED;
            if (branchreferralinitlistener != null)
            {
                branchreferralinitlistener.onInitFinished(null, new BranchError("Trouble initializing Branch.", -1234));
            }
            Log.i("BranchSDK", "Branch Warning: Please enter your branch_key in your project's res/values/strings.xml!");
            return;
        }
        if (prefHelper_.getBranchKey() != null && prefHelper_.getBranchKey().startsWith("key_test_"))
        {
            Log.i("BranchSDK", "Branch Warning: You are using your test app's Branch Key. Remember to change it to live Branch Key during deployment.");
        }
        if (hasUser())
        {
            registerInstallOrOpen(new ServerRequestRegisterOpen(context_, branchreferralinitlistener, kRemoteInterface_.getSystemObserver()), branchreferralinitlistener);
            return;
        } else
        {
            registerInstallOrOpen(new ServerRequestRegisterInstall(context_, branchreferralinitlistener, kRemoteInterface_.getSystemObserver(), InstallListener.getInstallationID()), branchreferralinitlistener);
            return;
        }
    }

    private void insertRequestAtFront(ServerRequest serverrequest)
    {
        if (networkCount_ == 0)
        {
            requestQueue_.insert(serverrequest, 0);
            return;
        } else
        {
            requestQueue_.insert(serverrequest, 1);
            return;
        }
    }

    public static boolean isAutoDeepLinkLaunch(Activity activity)
    {
        return activity.getIntent().getStringExtra("io.branch.sdk.auto_linked") != null;
    }

    private void keepAlive()
    {
        keepAlive_ = true;
        synchronized (lock)
        {
            clearTimer();
            closeTimer.schedule(new TimerTask() {

                final Branch this$0;

                public void run()
                {
                    (new Thread(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            keepAlive_ = false;
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    })).start();
                }

            
            {
                this$0 = Branch.this;
                super();
            }
            }, 2000L);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean pathMatch(String s, String s1)
    {
        boolean flag1 = true;
        s = s.split("\\?")[0].split("/");
        s1 = s1.split("\\?")[0].split("/");
        if (s.length != s1.length)
        {
            return false;
        }
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < s.length)
                {
                    flag = flag1;
                    if (i < s1.length)
                    {
                        String s2 = s[i];
                        if (s2.equals(s1[i]) || s2.contains("*"))
                        {
                            break label0;
                        }
                        flag = false;
                    }
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private void processNextQueueItem()
    {
        Object obj;
        serverSema_.acquire();
        if (networkCount_ != 0 || requestQueue_.getSize() <= 0)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        networkCount_ = 1;
        obj = requestQueue_.peek();
        serverSema_.release();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        try
        {
            if (!(obj instanceof ServerRequestRegisterInstall) && !hasUser())
            {
                Log.i("BranchSDK", "Branch Error: User session has not been initialized!");
                networkCount_ = 0;
                handleFailure(requestQueue_.getSize() - 1, -101);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return;
        }
        if (!(obj instanceof ServerRequestInitSession) && (!hasSession() || !hasDeviceFingerPrint()))
        {
            networkCount_ = 0;
            handleFailure(requestQueue_.getSize() - 1, -101);
            return;
        }
        Void avoid[];
        obj = new BranchPostTask(((ServerRequest) (obj)));
        avoid = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((BranchPostTask) (obj)).execute(avoid);
            return;
        }
        AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
        return;
        requestQueue_.remove(null);
        return;
        serverSema_.release();
        return;
    }

    private boolean readAndStripParam(Uri uri, Activity activity)
    {
        boolean flag1 = false;
        if (uri == null || !uri.isHierarchical() || activity == null) goto _L2; else goto _L1
_L1:
        if (uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey()) == null) goto _L4; else goto _L3
_L3:
        boolean flag;
        prefHelper_.setLinkClickIdentifier(uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey()));
        String s2 = (new StringBuilder()).append("link_click_id=").append(uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey())).toString();
        String s = activity.getIntent().getDataString();
        if (uri.getQuery().length() == s2.length())
        {
            uri = (new StringBuilder()).append("\\?").append(s2).toString();
        } else
        if (s.length() - s2.length() == s.indexOf(s2))
        {
            uri = (new StringBuilder()).append("&").append(s2).toString();
        } else
        {
            uri = (new StringBuilder()).append(s2).append("&").toString();
        }
        uri = Uri.parse(s.replaceFirst(uri, ""));
        activity.getIntent().setData(uri);
        flag = true;
_L6:
        return flag;
_L4:
        String s1 = uri.getScheme();
        if (s1 != null && (s1.equalsIgnoreCase("http") || s1.equalsIgnoreCase("https")) && uri.getHost() != null && uri.getHost().length() > 0)
        {
            prefHelper_.setAppLink(uri.toString());
            return false;
        }
_L2:
        Object obj;
        String s3;
        if (uri != null)
        {
            try
            {
                prefHelper_.setExternalIntentUri(uri.toString());
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                return false;
            }
        }
        flag = flag1;
        if (activity == null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (activity.getIntent() == null) goto _L6; else goto _L7
_L7:
        flag = flag1;
        if (activity.getIntent().getExtras() == null) goto _L6; else goto _L8
_L8:
        activity = activity.getIntent().getExtras();
        obj = activity.keySet();
        flag = flag1;
        if (((Set) (obj)).size() <= 0) goto _L6; else goto _L9
_L9:
        uri = new JSONObject();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); uri.put(s3, activity.get(s3)))
        {
            s3 = (String)((Iterator) (obj)).next();
        }

        activity = prefHelper_;
        if (uri instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        uri = uri.toString();
_L10:
        activity.setExternalIntentExtra(uri);
        return false;
        uri = JSONObjectInstrumentation.toString((JSONObject)uri);
          goto _L10
    }

    private void registerInstallOrOpen(ServerRequest serverrequest, BranchReferralInitListener branchreferralinitlistener)
    {
        if (!requestQueue_.containsInstallOrOpen())
        {
            insertRequestAtFront(serverrequest);
        } else
        {
            requestQueue_.setInstallOrOpenCallback(branchreferralinitlistener);
            requestQueue_.moveInstallOrOpenToFront(serverrequest, networkCount_, branchreferralinitlistener);
        }
        processNextQueueItem();
    }

    private android.view.View.OnTouchListener retrieveOnTouchListener()
    {
        if (debugOnTouchListener_ == null)
        {
            debugOnTouchListener_ = new _cls1();
        }
        return debugOnTouchListener_;
    }

    private void scheduleListOfApps()
    {
        ScheduledThreadPoolExecutor scheduledthreadpoolexecutor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runnable() {

            final Branch this$0;

            public void run()
            {
                ServerRequestSendAppList serverrequestsendapplist = new ServerRequestSendAppList(context_);
                if (!((ServerRequest) (serverrequestsendapplist)).constructError_ && !serverrequestsendapplist.handleErrors(context_))
                {
                    handleNewRequest(serverrequestsendapplist);
                }
            }

            
            {
                this$0 = Branch.this;
                super();
            }
        };
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int j = 7 - calendar.get(7);
        int k = 2 - calendar.get(11);
        int i = j;
        if (j == 0)
        {
            i = j;
            if (k < 0)
            {
                i = 7;
            }
        }
        appListingSchedule_ = scheduledthreadpoolexecutor.scheduleAtFixedRate(runnable, (i * 24 + k) * 60 * 60, 0x93a80, TimeUnit.SECONDS);
    }

    private void setActivityLifeCycleObserver(Application application)
    {
        try
        {
            BranchActivityLifeCycleObserver branchactivitylifecycleobserver = new BranchActivityLifeCycleObserver(null);
            application.unregisterActivityLifecycleCallbacks(branchactivitylifecycleobserver);
            application.registerActivityLifecycleCallbacks(branchactivitylifecycleobserver);
            isActivityLifeCycleCallbackRegistered_ = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application) { }
        // Misplaced declaration of an exception variable
        catch (Application application) { }
        isActivityLifeCycleCallbackRegistered_ = false;
        isAutoSessionMode_ = false;
        Log.w("BranchSDK", (new BranchError("", -108)).getMessage());
    }

    private void setTouchDebugInternal(Activity activity)
    {
        if (activity != null && debugListenerInitHistory_.get(System.identityHashCode(activity)) == null)
        {
            debugListenerInitHistory_.put(System.identityHashCode(activity), "init");
            activity.getWindow().setCallback(new BranchWindowCallback(activity.getWindow().getCallback()));
        }
    }

    private void shareLink(ShareLinkBuilder sharelinkbuilder)
    {
        if (shareLinkManager_ != null)
        {
            shareLinkManager_.cancelShareLinkDialog(true);
        }
        shareLinkManager_ = new ShareLinkManager();
        shareLinkManager_.shareLink(sharelinkbuilder);
    }

    private void updateAllRequestsInQueue()
    {
        int i = 0;
_L10:
        if (i >= requestQueue_.getSize()) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        obj = requestQueue_.peekAt(i);
        if (((ServerRequest) (obj)).getPost() == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        iterator = ((ServerRequest) (obj)).getPost().keys();
_L5:
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        s = (String)iterator.next();
        if (!s.equals(Defines.Jsonkey.SessionID.getKey())) goto _L4; else goto _L3
_L3:
        ((ServerRequest) (obj)).getPost().put(s, prefHelper_.getSessionID());
          goto _L5
        obj;
        ((JSONException) (obj)).printStackTrace();
_L2:
        return;
_L4:
        if (!s.equals(Defines.Jsonkey.IdentityID.getKey())) goto _L7; else goto _L6
_L6:
        ((ServerRequest) (obj)).getPost().put(s, prefHelper_.getIdentityID());
          goto _L5
_L7:
        if (!s.equals(Defines.Jsonkey.DeviceFingerprintID.getKey())) goto _L5; else goto _L8
_L8:
        ((ServerRequest) (obj)).getPost().put(s, prefHelper_.getDeviceFingerPrintID());
          goto _L5
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void applyReferralCode(String s, BranchReferralInitListener branchreferralinitlistener)
    {
        s = new ServerRequestApplyReferralCode(context_, branchreferralinitlistener, s);
        if (!((ServerRequest) (s)).constructError_ && !s.handleErrors(context_))
        {
            handleNewRequest(s);
        }
    }

    public void cancelShareLinkDialog(boolean flag)
    {
        if (shareLinkManager_ != null)
        {
            shareLinkManager_.cancelShareLinkDialog(flag);
        }
    }

    public void closeSession()
    {
        if (!isAutoSessionMode_) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!prefHelper_.getSmartSession())
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if (keepAlive_) goto _L1; else goto _L3
_L3:
        synchronized (lock)
        {
            clearCloseTimer();
            rotateCloseTimer.schedule(new TimerTask() {

                final Branch this$0;

                public void run()
                {
                    currentActivity_ = null;
                    executeClose();
                }

            
            {
                this$0 = Branch.this;
                super();
            }
            }, 500L);
        }
_L5:
        if (prefHelper_.getExternAppListing() && appListingSchedule_ == null)
        {
            scheduleListOfApps();
        }
        if (shareLinkManager_ == null) goto _L1; else goto _L4
_L4:
        shareLinkManager_.cancelShareLinkDialog(true);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        currentActivity_ = null;
        executeClose();
          goto _L5
    }

    public void disableAppList()
    {
        prefHelper_.disableExternAppListing();
    }

    public void disableSmartSession()
    {
        prefHelper_.disableSmartSession();
    }

    public void disableTouchDebugging()
    {
        prefHelper_.disableTouchDebugging();
    }

    public String generateShortLinkInternal(ServerRequestCreateUrl serverrequestcreateurl)
    {
label0:
        {
            if (!serverrequestcreateurl.constructError_ && !serverrequestcreateurl.handleErrors(context_))
            {
                if (linkCache_.containsKey(serverrequestcreateurl.getLinkPost()))
                {
                    String s = (String)linkCache_.get(serverrequestcreateurl.getLinkPost());
                    serverrequestcreateurl.onUrlAvailable(s);
                    return s;
                }
                if (!serverrequestcreateurl.isAsync())
                {
                    break label0;
                }
                generateShortLinkAsync(serverrequestcreateurl);
            }
            return null;
        }
        return generateShortLinkSync(serverrequestcreateurl);
    }

    public void getContentUrl(String s, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, 0, null, s, "share", null, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getContentUrl(Collection collection, String s, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, 0, collection, s, "share", null, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public String getContentUrlSync(String s, JSONObject jsonobject)
    {
        return generateShortLink(null, 0, 0, null, s, "share", null, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getContentUrlSync(Collection collection, String s, JSONObject jsonobject)
    {
        return generateShortLink(null, 0, 0, collection, s, "share", null, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public void getCreditHistory(BranchListResponseListener branchlistresponselistener)
    {
        getCreditHistory(null, null, 100, CreditHistoryOrder.kMostRecentFirst, branchlistresponselistener);
    }

    public void getCreditHistory(String s, int i, CreditHistoryOrder credithistoryorder, BranchListResponseListener branchlistresponselistener)
    {
        getCreditHistory(null, s, i, credithistoryorder, branchlistresponselistener);
    }

    public void getCreditHistory(String s, BranchListResponseListener branchlistresponselistener)
    {
        getCreditHistory(s, null, 100, CreditHistoryOrder.kMostRecentFirst, branchlistresponselistener);
    }

    public void getCreditHistory(String s, String s1, int i, CreditHistoryOrder credithistoryorder, BranchListResponseListener branchlistresponselistener)
    {
        s = new ServerRequestGetRewardHistory(context_, s, s1, i, credithistoryorder, branchlistresponselistener);
        if (!((ServerRequest) (s)).constructError_ && !s.handleErrors(context_))
        {
            handleNewRequest(s);
        }
    }

    public int getCredits()
    {
        return prefHelper_.getCreditCount();
    }

    public int getCreditsForBucket(String s)
    {
        return prefHelper_.getCreditCount(s);
    }

    public JSONObject getFirstReferringParams()
    {
        return convertParamsStringToDictionary(prefHelper_.getInstallParams());
    }

    public JSONObject getLatestReferringParams()
    {
        return convertParamsStringToDictionary(prefHelper_.getSessionParams());
    }

    public void getReferralCode(int i, BranchReferralInitListener branchreferralinitlistener)
    {
        getReferralCode(null, i, null, "default", 1, 2, branchreferralinitlistener);
    }

    public void getReferralCode(int i, Date date, BranchReferralInitListener branchreferralinitlistener)
    {
        getReferralCode(null, i, date, "default", 1, 2, branchreferralinitlistener);
    }

    public void getReferralCode(BranchReferralInitListener branchreferralinitlistener)
    {
        branchreferralinitlistener = new ServerRequestGetReferralCode(context_, branchreferralinitlistener);
        if (!((ServerRequest) (branchreferralinitlistener)).constructError_ && !branchreferralinitlistener.handleErrors(context_))
        {
            handleNewRequest(branchreferralinitlistener);
        }
    }

    public void getReferralCode(String s, int i, int j, int k, BranchReferralInitListener branchreferralinitlistener)
    {
        getReferralCode(s, i, null, "default", j, k, branchreferralinitlistener);
    }

    public void getReferralCode(String s, int i, BranchReferralInitListener branchreferralinitlistener)
    {
        getReferralCode(s, i, null, "default", 1, 2, branchreferralinitlistener);
    }

    public void getReferralCode(String s, int i, Date date, BranchReferralInitListener branchreferralinitlistener)
    {
        getReferralCode(s, i, date, "default", 1, 2, branchreferralinitlistener);
    }

    public void getReferralCode(String s, int i, Date date, String s1, int j, int k, BranchReferralInitListener branchreferralinitlistener)
    {
        String s2 = null;
        if (date != null)
        {
            s2 = convertDate(date);
        }
        s = new ServerRequestGetReferralCode(context_, s, i, s2, s1, j, k, branchreferralinitlistener);
        if (!((ServerRequest) (s)).constructError_ && !s.handleErrors(context_))
        {
            handleNewRequest(s);
        }
    }

    public void getReferralUrl(String s, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, 0, null, s, "referral", null, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getReferralUrl(Collection collection, String s, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, 0, collection, s, "referral", null, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public String getReferralUrlSync(String s, JSONObject jsonobject)
    {
        return generateShortLink(null, 0, 0, null, s, "referral", null, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getReferralUrlSync(Collection collection, String s, JSONObject jsonobject)
    {
        return generateShortLink(null, 0, 0, collection, s, "referral", null, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public void getShortUrl(int i, String s, String s1, String s2, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, i, 0, null, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getShortUrl(int i, Collection collection, String s, String s1, String s2, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, i, 0, collection, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getShortUrl(BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, 0, null, null, null, null, BranchUtil.stringifyAndAddSource(new JSONObject()), branchlinkcreatelistener, true);
    }

    public void getShortUrl(String s, String s1, String s2, String s3, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(s, 0, 0, null, s1, s2, s3, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getShortUrl(String s, String s1, String s2, JSONObject jsonobject, int i, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, i, null, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getShortUrl(String s, String s1, String s2, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, 0, null, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getShortUrl(String s, Collection collection, String s1, String s2, String s3, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(s, 0, 0, collection, s1, s2, s3, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getShortUrl(Collection collection, String s, String s1, String s2, JSONObject jsonobject, int i, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, i, collection, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getShortUrl(Collection collection, String s, String s1, String s2, JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, 0, collection, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public void getShortUrl(JSONObject jsonobject, BranchLinkCreateListener branchlinkcreatelistener)
    {
        generateShortLink(null, 0, 0, null, null, null, null, BranchUtil.formatAndStringifyLinkParam(jsonobject), branchlinkcreatelistener, true);
    }

    public String getShortUrlSync()
    {
        return generateShortLink(null, 0, 0, null, null, null, null, BranchUtil.stringifyAndAddSource(new JSONObject()), null, false);
    }

    public String getShortUrlSync(int i, String s, String s1, String s2, JSONObject jsonobject)
    {
        return generateShortLink(null, i, 0, null, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getShortUrlSync(int i, Collection collection, String s, String s1, String s2, JSONObject jsonobject)
    {
        return generateShortLink(null, i, 0, collection, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getShortUrlSync(String s, String s1, String s2, String s3, JSONObject jsonobject)
    {
        return generateShortLink(s, 0, 0, null, s1, s2, s3, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getShortUrlSync(String s, String s1, String s2, JSONObject jsonobject)
    {
        return generateShortLink(null, 0, 0, null, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getShortUrlSync(String s, String s1, String s2, JSONObject jsonobject, int i)
    {
        return generateShortLink(null, 0, i, null, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getShortUrlSync(String s, Collection collection, String s1, String s2, String s3, JSONObject jsonobject)
    {
        return generateShortLink(s, 0, 0, collection, s1, s2, s3, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getShortUrlSync(Collection collection, String s, String s1, String s2, JSONObject jsonobject)
    {
        return generateShortLink(null, 0, 0, collection, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getShortUrlSync(Collection collection, String s, String s1, String s2, JSONObject jsonobject, int i)
    {
        return generateShortLink(null, 0, i, collection, s, s1, s2, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public String getShortUrlSync(JSONObject jsonobject)
    {
        return generateShortLink(null, 0, 0, null, null, null, null, BranchUtil.formatAndStringifyLinkParam(jsonobject), null, false);
    }

    public int getTotalCountsForAction(String s)
    {
        return prefHelper_.getActionTotalCount(s);
    }

    public int getUniqueCountsForAction(String s)
    {
        return prefHelper_.getActionUniqueCount(s);
    }

    public boolean initSession()
    {
        return initSession((Activity)null);
    }

    public boolean initSession(Activity activity)
    {
        return initSession((BranchReferralInitListener)null, activity);
    }

    public boolean initSession(BranchReferralInitListener branchreferralinitlistener)
    {
        initSession(branchreferralinitlistener, (Activity)null);
        return false;
    }

    public boolean initSession(BranchReferralInitListener branchreferralinitlistener, Activity activity)
    {
        boolean flag = true;
        if (customReferrableSettings_ == CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT)
        {
            initUserSessionInternal(branchreferralinitlistener, activity, true);
            return false;
        }
        if (customReferrableSettings_ != CUSTOM_REFERRABLE_SETTINGS.REFERRABLE)
        {
            flag = false;
        }
        initUserSessionInternal(branchreferralinitlistener, activity, flag);
        return false;
    }

    public boolean initSession(BranchReferralInitListener branchreferralinitlistener, Uri uri)
    {
        return initSession(branchreferralinitlistener, uri, ((Activity) (null)));
    }

    public boolean initSession(BranchReferralInitListener branchreferralinitlistener, Uri uri, Activity activity)
    {
        boolean flag = readAndStripParam(uri, activity);
        initSession(branchreferralinitlistener, activity);
        return flag;
    }

    public boolean initSession(BranchReferralInitListener branchreferralinitlistener, boolean flag)
    {
        return initSession(branchreferralinitlistener, flag, (Activity)null);
    }

    public boolean initSession(BranchReferralInitListener branchreferralinitlistener, boolean flag, Activity activity)
    {
        initUserSessionInternal(branchreferralinitlistener, activity, flag);
        return false;
    }

    public boolean initSession(BranchReferralInitListener branchreferralinitlistener, boolean flag, Uri uri)
    {
        return initSession(branchreferralinitlistener, flag, uri, null);
    }

    public boolean initSession(BranchReferralInitListener branchreferralinitlistener, boolean flag, Uri uri, Activity activity)
    {
        boolean flag1 = readAndStripParam(uri, activity);
        initSession(branchreferralinitlistener, flag, activity);
        return flag1;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchuniversalreferralinitlistener)
    {
        initSession(branchuniversalreferralinitlistener, (Activity)null);
        return false;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchuniversalreferralinitlistener, Activity activity)
    {
        boolean flag = true;
        if (customReferrableSettings_ == CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT)
        {
            initUserSessionInternal(branchuniversalreferralinitlistener, activity, true);
            return false;
        }
        if (customReferrableSettings_ != CUSTOM_REFERRABLE_SETTINGS.REFERRABLE)
        {
            flag = false;
        }
        initUserSessionInternal(branchuniversalreferralinitlistener, activity, flag);
        return false;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchuniversalreferralinitlistener, Uri uri)
    {
        return initSession(branchuniversalreferralinitlistener, uri, ((Activity) (null)));
    }

    public boolean initSession(BranchUniversalReferralInitListener branchuniversalreferralinitlistener, Uri uri, Activity activity)
    {
        boolean flag = readAndStripParam(uri, activity);
        initSession(branchuniversalreferralinitlistener, activity);
        return flag;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchuniversalreferralinitlistener, boolean flag)
    {
        return initSession(branchuniversalreferralinitlistener, flag, (Activity)null);
    }

    public boolean initSession(BranchUniversalReferralInitListener branchuniversalreferralinitlistener, boolean flag, Activity activity)
    {
        initUserSessionInternal(branchuniversalreferralinitlistener, activity, flag);
        return false;
    }

    public boolean initSession(BranchUniversalReferralInitListener branchuniversalreferralinitlistener, boolean flag, Uri uri)
    {
        return initSession(branchuniversalreferralinitlistener, flag, uri, null);
    }

    public boolean initSession(BranchUniversalReferralInitListener branchuniversalreferralinitlistener, boolean flag, Uri uri, Activity activity)
    {
        boolean flag1 = readAndStripParam(uri, activity);
        initSession(branchuniversalreferralinitlistener, flag, activity);
        return flag1;
    }

    public boolean initSession(boolean flag)
    {
        return initSession((BranchReferralInitListener)null, flag, (Activity)null);
    }

    public boolean initSession(boolean flag, Activity activity)
    {
        return initSession((BranchReferralInitListener)null, flag, activity);
    }

    public boolean initSessionWithData(Uri uri)
    {
        return initSessionWithData(uri, null);
    }

    public boolean initSessionWithData(Uri uri, Activity activity)
    {
        boolean flag = readAndStripParam(uri, activity);
        initSession((BranchReferralInitListener)null, activity);
        return flag;
    }

    public boolean isUserIdentified()
    {
        return !prefHelper_.getIdentity().equals("bnc_no_value");
    }

    public void loadActionCounts()
    {
        loadActionCounts(null);
    }

    public void loadActionCounts(BranchReferralStateChangedListener branchreferralstatechangedlistener)
    {
        branchreferralstatechangedlistener = new ServerRequestGetReferralCount(context_, branchreferralstatechangedlistener);
        if (!((ServerRequest) (branchreferralstatechangedlistener)).constructError_ && !branchreferralstatechangedlistener.handleErrors(context_))
        {
            handleNewRequest(branchreferralstatechangedlistener);
        }
    }

    public void loadRewards()
    {
        loadRewards(null);
    }

    public void loadRewards(BranchReferralStateChangedListener branchreferralstatechangedlistener)
    {
        branchreferralstatechangedlistener = new ServerRequestGetRewards(context_, branchreferralstatechangedlistener);
        if (!((ServerRequest) (branchreferralstatechangedlistener)).constructError_ && !branchreferralstatechangedlistener.handleErrors(context_))
        {
            handleNewRequest(branchreferralstatechangedlistener);
        }
    }

    public void logout()
    {
        logout(null);
    }

    public void logout(LogoutStatusListener logoutstatuslistener)
    {
        logoutstatuslistener = new ServerRequestLogout(context_, logoutstatuslistener);
        if (!((ServerRequest) (logoutstatuslistener)).constructError_ && !logoutstatuslistener.handleErrors(context_))
        {
            handleNewRequest(logoutstatuslistener);
        }
    }

    public void redeemRewards(int i)
    {
        redeemRewards(Defines.Jsonkey.DefaultBucket.getKey(), i, null);
    }

    public void redeemRewards(int i, BranchReferralStateChangedListener branchreferralstatechangedlistener)
    {
        redeemRewards(Defines.Jsonkey.DefaultBucket.getKey(), i, branchreferralstatechangedlistener);
    }

    public void redeemRewards(String s, int i)
    {
        redeemRewards(s, i, null);
    }

    public void redeemRewards(String s, int i, BranchReferralStateChangedListener branchreferralstatechangedlistener)
    {
        s = new ServerRequestRedeemRewards(context_, s, i, branchreferralstatechangedlistener);
        if (!((ServerRequestRedeemRewards) (s)).constructError_ && !s.handleErrors(context_))
        {
            handleNewRequest(s);
        }
    }

    public void registerView(BranchUniversalObject branchuniversalobject, io.branch.indexing.BranchUniversalObject.RegisterViewStatusListener registerviewstatuslistener)
    {
        branchuniversalobject = new ServerRequestRegisterView(currentActivity_, branchuniversalobject, systemObserver_, registerviewstatuslistener);
        if (!((ServerRequest) (branchuniversalobject)).constructError_ && !branchuniversalobject.handleErrors(context_))
        {
            handleNewRequest(branchuniversalobject);
        }
    }

    public void resetUserSession()
    {
        initState_ = SESSION_STATE.UNINITIALISED;
    }

    public void setDebug()
    {
        prefHelper_.setExternDebug();
    }

    public void setIdentity(String s)
    {
        setIdentity(s, null);
    }

    public void setIdentity(String s, BranchReferralInitListener branchreferralinitlistener)
    {
        s = new ServerRequestIdentifyUserRequest(context_, branchreferralinitlistener, s);
        if (!((ServerRequest) (s)).constructError_ && !s.handleErrors(context_))
        {
            handleNewRequest(s);
        } else
        if (((ServerRequestIdentifyUserRequest)s).isExistingID())
        {
            ((ServerRequestIdentifyUserRequest)s).handleUserExist(branchReferral_);
            return;
        }
    }

    public void setNetworkTimeout(int i)
    {
        if (prefHelper_ != null && i > 0)
        {
            prefHelper_.setTimeout(i);
        }
    }

    public void setRetryCount(int i)
    {
        if (prefHelper_ != null && i > 0)
        {
            prefHelper_.setRetryCount(i);
        }
    }

    public void setRetryInterval(int i)
    {
        if (prefHelper_ != null && i > 0)
        {
            prefHelper_.setRetryInterval(i);
        }
    }

    public void userCompletedAction(String s)
    {
        userCompletedAction(s, null);
    }

    public void userCompletedAction(String s, JSONObject jsonobject)
    {
        JSONObject jsonobject1 = jsonobject;
        if (jsonobject != null)
        {
            jsonobject1 = BranchUtil.filterOutBadCharacters(jsonobject);
        }
        s = new ServerRequestActionCompleted(context_, s, jsonobject1);
        if (!((ServerRequest) (s)).constructError_ && !s.handleErrors(context_))
        {
            handleNewRequest(s);
        }
    }

    public void validateReferralCode(String s, BranchReferralInitListener branchreferralinitlistener)
    {
        s = new ServerRequestValidateReferralCode(context_, branchreferralinitlistener, s);
        if (!((ServerRequest) (s)).constructError_ && !s.handleErrors(context_))
        {
            handleNewRequest(s);
        }
    }

    static 
    {
        customReferrableSettings_ = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
    }









/*
    static boolean access$1602(Branch branch, boolean flag)
    {
        branch.hasNetwork_ = flag;
        return flag;
    }

*/



/*
    static SESSION_STATE access$1702(Branch branch, SESSION_STATE session_state)
    {
        branch.initState_ = session_state;
        return session_state;
    }

*/





/*
    static int access$2002(Branch branch, int i)
    {
        branch.networkCount_ = i;
        return i;
    }

*/





/*
    static boolean access$2402(Branch branch, boolean flag)
    {
        branch.isInitReportedThroughCallBack = flag;
        return flag;
    }

*/





/*
    static boolean access$2802(Branch branch, boolean flag)
    {
        branch.debugStarted_ = flag;
        return flag;
    }

*/





/*
    static Activity access$402(Branch branch, Activity activity)
    {
        branch.currentActivity_ = activity;
        return activity;
    }

*/





/*
    static boolean access$902(Branch branch, boolean flag)
    {
        branch.keepAlive_ = flag;
        return flag;
    }

*/

    // Unreferenced inner class io/branch/referral/Branch$1$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        private boolean started;
        final _cls1 this$1;
        private Timer timer;

        public void run()
        {
            debugHandler_.removeCallbacks(_longPressed);
            boolean flag;
            if (!started)
            {
                Log.i("Branch Debug", "======= Start Debug Session =======");
                prefHelper_.setDebug();
                timer = new Timer();
                timer.scheduleAtFixedRate(new KeepDebugConnectionTask(), new Date(), 20000L);
            } else
            {
                Log.i("Branch Debug", "======= End Debug Session =======");
                prefHelper_.clearDebug();
                timer.cancel();
                timer = null;
            }
            if (!started)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            started = flag;
        }

            
            {
                this$1 = _cls1.this;
                super();
                started = false;
            }
    }


    // Unreferenced inner class io/branch/referral/Branch$BranchWindowCallback$1

/* anonymous class */
    class BranchWindowCallback._cls1
        implements Runnable
    {

        final BranchWindowCallback this$1;
        private Timer timer;
        final Branch val$this$0;

        public void run()
        {
            debugHandler_.removeCallbacks(longPressed_);
            Branch branch;
            boolean flag;
            if (!debugStarted_)
            {
                Log.i("Branch Debug", "======= Start Debug Session =======");
                prefHelper_.setDebug();
                timer = new Timer();
                timer.scheduleAtFixedRate(new BranchWindowCallback.KeepDebugConnectionTask(), new Date(), 20000L);
            } else
            {
                Log.i("Branch Debug", "======= End Debug Session =======");
                prefHelper_.clearDebug();
                if (timer != null)
                {
                    timer.cancel();
                    timer = null;
                }
            }
            branch = _fld0;
            if (!debugStarted_)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            branch.debugStarted_ = flag;
        }

            
            {
                this$1 = final_branchwindowcallback;
                this$0 = Branch.this;
                super();
            }
    }

}

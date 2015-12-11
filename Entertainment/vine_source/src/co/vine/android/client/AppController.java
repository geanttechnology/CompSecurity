// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import co.vine.android.AppImpl;
import co.vine.android.LoginTwitterActivity;
import co.vine.android.Settings;
import co.vine.android.StartActivity;
import co.vine.android.VineLoggingException;
import co.vine.android.api.ServerStatus;
import co.vine.android.api.TwitterUser;
import co.vine.android.api.VineClientFlags;
import co.vine.android.api.VineComment;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VineLoopSubmissionResponse;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VinePost;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.api.VineRecipient;
import co.vine.android.api.VineRepost;
import co.vine.android.api.VineSingleNotification;
import co.vine.android.api.VineUser;
import co.vine.android.network.HttpResult;
import co.vine.android.player.SaveVideoClicker;
import co.vine.android.provider.SettingsManager;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.service.GCMRegistrationService;
import co.vine.android.service.VineService;
import co.vine.android.service.VineServiceConnection;
import co.vine.android.util.ClientFlagsHelper;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.LoopManager;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.ImageUtils;
import co.vine.android.util.image.PhotoImagesCache;
import co.vine.android.util.image.PhotoImagesListener;
import co.vine.android.util.video.VideoCache;
import co.vine.android.util.video.VideoKey;
import co.vine.android.util.video.VideoListener;
import com.edisonwang.android.slog.SLog;
import com.facebook.AuthorizationClient;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.SharedPreferencesTokenCachingStrategy;
import com.flurry.android.FlurryAgent;
import com.twitter.android.sdk.Twitter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package co.vine.android.client:
//            TwitterVineApp, VineAccountHelper, Session, AppSessionListener, 
//            VineAPI

public class AppController
    implements PhotoImagesListener, VideoListener, com.facebook.Session.StatusCallback, co.vine.android.service.VineServiceConnection.ServiceResponseHandler
{
    class LoopCountRunnable
        implements Runnable
    {

        final AppController this$0;

        public void run()
        {
            sendLoopCounts();
        }

        LoopCountRunnable()
        {
            this$0 = AppController.this;
            super();
        }
    }

    class ServerStatusRunnable
        implements Runnable
    {

        final AppController this$0;

        public void run()
        {
            determineServerStatus();
        }

        ServerStatusRunnable()
        {
            this$0 = AppController.this;
            super();
        }
    }


    public static final String ACTION_ABORT_ALL_REQUESTS = "abort_all_requests";
    private static final String ACTION_EDITION_UPDATED = "action_edition_updated";
    public static final IntentFilter ACTION_UPDATED_FILTER = new IntentFilter("action_edition_updated");
    private static final long CLEANUP_INTERVAL = 0x36ee80L;
    private static final IntentFilter INVALIDATE_CACHE_FILTER;
    private static final String KEY_FACEBOOK_TOKEN = "KEY_FACEBOOK_TOKEN";
    private static final long MIN_LOOP_COUNT_INTERVAL = 60000L;
    private static final String PREF_LAST_USER_ID = "last_user_id";
    public static final String PUBLISH_ACTIONS = "publish_actions";
    public static final int REQUEST_CODE_TWITTER_SDK = 1;
    public static final int REQUEST_CODE_TWITTER_XAUTH = 2;
    private static final long SERVER_REFRESH_INTERVAL = 0x36ee80L;
    public static final boolean SINGLE_FACEBOOK_DIALOG;
    public static final int STATUS_CODE_CAPTCHA_FAIL = 455;
    private static final int TYPEAHEAD_DEFAULT_FETCH_THRESHOLD = 2;
    private static final int TYPEAHEAD_DEFAULT_MAX_COMPOSE = 50;
    public static final long TYPEAHEAD_DEFAULT_THROTTLE = 300L;
    private static final int TYPEAHEAD_TAGS_FETCH_THRESHOLD = 3;
    private static AppController sInstance;
    final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final BroadcastReceiver mInvalidateCacheReceiver = new BroadcastReceiver() {

        final AppController this$0;

        public void onReceive(Context context1, Intent intent)
        {
            SLog.d("Received invalidate cache broadcast");
            VideoCache.invalidateCache();
            PhotoImagesCache.invalidateCache();
        }

            
            {
                this$0 = AppController.this;
                super();
            }
    };
    private ArrayList mListeners;
    private LoopCountRunnable mLoopCountRunnable;
    private long mLoopCountSubmissionInterval;
    private final PhotoImagesCache mPhotoImagesCache;
    private ServerStatusRunnable mServerStatusRunnable;
    private final VineServiceConnection mServiceConnection;
    private final Twitter mTwitter;
    private final VideoCache mVideoCache;

    private AppController(Context context)
    {
        mContext = context;
        mLoopCountSubmissionInterval = 60000L;
        mListeners = new ArrayList();
        Point point = SystemUtil.getDisplaySize(context);
        mPhotoImagesCache = new PhotoImagesCache(context, Math.max(point.x, point.y), 0x1e00000);
        mPhotoImagesCache.addListener(this);
        mVideoCache = new VideoCache(context, 0);
        mVideoCache.addListener(this);
        mTwitter = new Twitter(TwitterVineApp.API_KEY, TwitterVineApp.API_SECRET);
        mServerStatusRunnable = new ServerStatusRunnable();
        mLoopCountRunnable = new LoopCountRunnable();
        SLog.i("App Controller pid: {}", Integer.valueOf(Process.myPid()));
        mServiceConnection = new VineServiceConnection(mContext, this);
        context.bindService(new Intent(context, co/vine/android/service/VineService), mServiceConnection, 1);
        context.registerReceiver(mInvalidateCacheReceiver, INVALIDATE_CACHE_FILTER, "co.vine.android.BROADCAST", null);
    }

    private String clearAccount()
    {
        return executeServiceAction(115, createServiceBundle());
    }

    public static void clearFileCache(Context context)
    {
        Util.removeCache(context);
        ImageUtils.removeFiles(context);
    }

    private Bundle createServiceBundle()
    {
        return createServiceBundle(getActiveSession());
    }

    private Bundle createServiceBundle(co.vine.android.client.Session session)
    {
        return injectServiceBundle(new Bundle(), session);
    }

    private Bundle createServiceBundleReadOnly()
    {
        return createServiceBundle(getActiveSessionReadOnly());
    }

    private String executeServiceAction(int i, Bundle bundle)
    {
        CrashUtil.set("Last Service Action Code", i);
        return mServiceConnection.queueAndExecute(i, bundle);
    }

    private co.vine.android.client.Session getActiveSession(boolean flag)
    {
        return VineAccountHelper.getActiveSession(mContext, flag);
    }

    public static AppController getInstance(Context context)
    {
        co/vine/android/client/AppController;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new AppController(context.getApplicationContext());
        }
        context = sInstance;
        co/vine/android/client/AppController;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static Bundle injectServiceBundle(Bundle bundle, co.vine.android.client.Session session)
    {
        bundle.putString("s_key", session.getSessionKey());
        bundle.putLong("s_owner_id", session.getUserId());
        bundle.putString("a_name", session.getName());
        bundle.putString("email", session.getLoginEmail());
        return bundle;
    }

    private void onLogout()
    {
        if (getLoginStatus().equals(Session.LoginStatus.LOGGED_OUT))
        {
            return;
        }
        Object obj = getActiveSession().getSessionKey();
        Util.getDefaultSharedPrefs(mContext).edit().clear().commit();
        clearDbAll();
        clearFileCache();
        clearAccount();
        mContext.startService(GCMRegistrationService.getUnregisterIntent(mContext, getActiveId(), ((String) (obj))));
        Util.getDefaultSharedPrefs(mContext).edit().putLong("last_user_id", getActiveId()).commit();
        obj = VineAccountHelper.getCachedActiveSession();
        VineAccountHelper.removeAccount(mContext, ((co.vine.android.client.Session) (obj)).getLoginEmail());
        if (obj != null)
        {
            ((co.vine.android.client.Session) (obj)).logout();
        }
        obj = new Intent("co.vine.android.session.logout");
        mContext.sendBroadcast(((Intent) (obj)), "co.vine.android.BROADCAST");
        obj = AppImpl.getInstance().getClearNotificationsIntent(mContext);
        if (obj != null)
        {
            mContext.startService(((Intent) (obj)));
        }
        StartActivity.toStart(mContext);
    }

    private String performCleanup(co.vine.android.client.Session session, long l)
    {
        session = createServiceBundle(session);
        session.putLong("time", l);
        return executeServiceAction(29, session);
    }

    public static void setPendingFacebookToken(Context context, String s)
    {
        Util.getDefaultSharedPrefs(context).edit().putString("KEY_FACEBOOK_TOKEN", s).commit();
    }

    public static void startTwitterAuthWithFinish(Twitter twitter, Activity activity)
    {
        try
        {
            if (!twitter.startAuthActivityForResult(activity, 1))
            {
                activity.startActivityForResult(LoginTwitterActivity.getIntentWithFinish(activity), 2);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Twitter twitter)
        {
            activity.startActivityForResult(LoginTwitterActivity.getIntentWithFinish(activity), 2);
        }
    }

    public void abortAllRequests()
    {
        mServiceConnection.cancelAll();
        executeServiceAction(112, createServiceBundle());
    }

    public String acceptFollowRequest(co.vine.android.client.Session session, long l)
    {
        session = createServiceBundle(session);
        session.putLong("user_id", l);
        session.putBoolean("accept", true);
        return executeServiceAction(50, session);
    }

    public String acceptRejectRequest(co.vine.android.client.Session session, long l)
    {
        session = createServiceBundle(session);
        session.putLong("user_id", l);
        session.putBoolean("accept", false);
        return executeServiceAction(50, session);
    }

    public void addListener(AppSessionListener appsessionlistener)
    {
        if (mListeners.contains(appsessionlistener))
        {
            return;
        } else
        {
            mListeners.add(appsessionlistener);
            return;
        }
    }

    public boolean attemptCancelVideoFetchRequest(VideoKey videokey)
    {
        return mVideoCache.cancel(videokey) > 0;
    }

    public String blockUser(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("user_id", getActiveId());
        bundle.putLong("block_user_id", l);
        return executeServiceAction(47, bundle);
    }

    public String bulkFollowUsers(co.vine.android.client.Session session, ArrayList arraylist)
    {
        session = injectServiceBundle(new Bundle(), session);
        session.putStringArrayList("follow_ids", arraylist);
        return executeServiceAction(107, session);
    }

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        SLog.d("Session state has changed: {}.", session.getState().name(), exception);
        ArrayList arraylist = mListeners;
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            ((AppSessionListener)arraylist.get(i)).onFacebookSessionChanged(session, sessionstate, exception);
        }

    }

    public String clearDbAll()
    {
        return executeServiceAction(59, createServiceBundle());
    }

    public String clearDbCache(boolean flag)
    {
        Bundle bundle = createServiceBundle();
        bundle.putBoolean("notify", flag);
        return executeServiceAction(58, bundle);
    }

    public void clearFacebookToken()
    {
        Session session1 = Session.getActiveSession();
        Session session = session1;
        if (session1 == null)
        {
            session = Session.openActiveSessionFromCache(mContext);
        }
        if (session != null)
        {
            session.closeAndClearTokenInformation();
        }
    }

    public void clearFileCache()
    {
        clearFileCache(mContext);
    }

    public String clearGcmRegId(String s, long l, String s1)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("gcmRegId", s);
        bundle.putLong("user_id", l);
        bundle.putString("s_key", s1);
        return executeServiceAction(61, bundle);
    }

    public void clearImageCacheFromMemory()
    {
        mPhotoImagesCache.clearMemory();
    }

    public void clearInboxPageCursors()
    {
        executeServiceAction(104, createServiceBundle());
    }

    public void clearPushNotifications(int i)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("notification_display_id", i);
        executeServiceAction(62, bundle);
    }

    public void clearUnreadMessageCount(long l)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("conversation_row_id", l);
        executeServiceAction(94, bundle);
        fetchActivityCounts();
    }

    public void connectToFacebookInitialize(Fragment fragment)
    {
        if (SINGLE_FACEBOOK_DIALOG)
        {
            connectToFacebookPublish(fragment);
        } else
        {
            AuthorizationClient.CLEAR_COOKIE = true;
            Object obj = mContext;
            obj = (new com.facebook.Session.Builder(((Context) (obj)))).setApplicationId(((Context) (obj)).getString(0x7f0e00d6)).setTokenCachingStrategy(new SharedPreferencesTokenCachingStrategy(((Context) (obj)))).build();
            Session.setActiveSession(((Session) (obj)));
            if (!((Session) (obj)).isOpened())
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add("basic_info");
                fragment = new com.facebook.Session.OpenRequest(fragment);
                fragment.setPermissions(arraylist);
                fragment.setLoginBehavior(SessionLoginBehavior.SSO_WITH_FALLBACK);
                ((Session) (obj)).openForRead(fragment);
                return;
            }
        }
    }

    public void connectToFacebookPublish(Fragment fragment)
    {
        Object obj = mContext;
        obj = (new com.facebook.Session.Builder(((Context) (obj)))).setApplicationId(((Context) (obj)).getString(0x7f0e00d6)).setTokenCachingStrategy(new SharedPreferencesTokenCachingStrategy(((Context) (obj)))).build();
        Session.setActiveSession(((Session) (obj)));
        if (!((Session) (obj)).isOpened())
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add("publish_actions");
            fragment = new com.facebook.Session.OpenRequest(fragment);
            fragment.setDefaultAudience(SessionDefaultAudience.FRIENDS);
            fragment.setPermissions(arraylist);
            fragment.setLoginBehavior(SessionLoginBehavior.SSO_WITH_FALLBACK);
            ((Session) (obj)).openForPublish(fragment);
        }
    }

    public String connectTwitter(co.vine.android.client.Session session, String s, String s1, String s2, long l)
    {
        session = createServiceBundle(session);
        session.putString("username", s);
        session.putString("key", s1);
        session.putString("secret", s2);
        session.putLong("user_id", l);
        return executeServiceAction(32, session);
    }

    public String deactivateAccount()
    {
        return executeServiceAction(67, createServiceBundle());
    }

    public String deleteComment(long l, String s)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("post_id", l);
        bundle.putString("comment_id", s);
        return executeServiceAction(30, bundle);
    }

    public String deleteConversation(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("conversation_row_id", l);
        return executeServiceAction(80, bundle);
    }

    public void deleteMessage(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("message_id", l);
        executeServiceAction(95, bundle);
    }

    public String deletePost(co.vine.android.client.Session session, long l)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        return executeServiceAction(31, session);
    }

    public String deleteSession(String s)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("s_key", s);
        return executeServiceAction(64, bundle);
    }

    public void determineCleanup(co.vine.android.client.Session session)
    {
        SharedPreferences sharedpreferences = Util.getSharedPrefs(mContext, "last_cleanup");
        long l = sharedpreferences.getLong("last_cleanup", 0L);
        if (l > 0L)
        {
            if (System.currentTimeMillis() - l > 0x36ee80L)
            {
                performCleanup(session, l);
            }
            return;
        } else
        {
            session = sharedpreferences.edit();
            session.putLong("last_cleanup", System.currentTimeMillis());
            session.commit();
            return;
        }
    }

    public void determineServerStatus()
    {
        SharedPreferences sharedpreferences = Util.getDefaultSharedPrefs(mContext);
        long l1 = sharedpreferences.getLong("server_upload_last_refresh", 0L);
        long l2 = System.currentTimeMillis() - l1;
        long l = System.currentTimeMillis() - l2;
        if (l1 <= 0L || l2 > 0x36ee80L)
        {
            fetchServerStatus();
            sharedpreferences.edit().putLong("server_upload_last_refresh", System.currentTimeMillis()).commit();
            if (mHandler != null)
            {
                mHandler.removeCallbacks(mServerStatusRunnable);
                mHandler.postDelayed(mServerStatusRunnable, 0x36ee80L);
            }
        } else
        if (mHandler != null)
        {
            mHandler.removeCallbacks(mServerStatusRunnable);
            Handler handler = mHandler;
            ServerStatusRunnable serverstatusrunnable = mServerStatusRunnable;
            if (l <= 0L)
            {
                l = 0x36ee80L;
            }
            handler.postDelayed(serverstatusrunnable, l);
            return;
        }
    }

    public String disableReposts(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("user_id", l);
        return executeServiceAction(69, bundle);
    }

    public String disconnectTwitter(co.vine.android.client.Session session)
    {
        return executeServiceAction(33, createServiceBundle(session));
    }

    public String enableReposts(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("user_id", l);
        return executeServiceAction(68, bundle);
    }

    public void executeServiceRequest(int i, Bundle bundle)
    {
        executeServiceAction(i, bundle);
    }

    public String expireTimeline(boolean flag, int i, String s)
    {
        Bundle bundle = createServiceBundle();
        bundle.putBoolean("also_fetch_posts", flag);
        bundle.putInt("type", i);
        bundle.putString("tag_name", s);
        return executeServiceAction(45, bundle);
    }

    public void failRequest(String s, int i, Bundle bundle)
    {
        bundle.putString("rid", s);
        notifyListeners(s, i, 455, null, bundle);
    }

    public String fetchActivity(co.vine.android.client.Session session, int i, long l, boolean flag, boolean flag1)
    {
        session = createServiceBundle(session);
        session.putInt("page", i);
        session.putBoolean("follow_reqs", flag);
        session.putBoolean("clear", flag1);
        session.putLong("time", l);
        return executeServiceAction(20, session);
    }

    public String fetchActivityCounts()
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("s_owner_id", getActiveId());
        return executeServiceAction(81, bundle);
    }

    public String fetchAddressFriends(co.vine.android.client.Session session)
    {
        return executeServiceAction(16, createServiceBundle(session));
    }

    public String fetchChannels(int i)
    {
        Bundle bundle = createServiceBundle();
        bundle.putInt("page_type", i);
        return executeServiceAction(53, bundle);
    }

    public void fetchClientFlags(boolean flag)
    {
        createServiceBundle().putBoolean("abort_requests", flag);
        executeServiceAction(111, createServiceBundle());
    }

    public String fetchComments(long l, int i, long l1, int j)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("post_id", l);
        bundle.putInt("page", i);
        bundle.putLong("time", l1);
        bundle.putInt("size", j);
        return executeServiceAction(12, bundle);
    }

    public String fetchConversation(int i, boolean flag, long l, long l1, boolean flag1)
    {
        Bundle bundle = createServiceBundleReadOnly();
        bundle.putInt("page_type", i);
        bundle.putBoolean("user_init", flag);
        bundle.putLong("conversation_id", l);
        bundle.putLong("conversation_row_id", l1);
        bundle.putBoolean("prefetch", flag1);
        return executeServiceAction(76, bundle);
    }

    public void fetchConversationRowIdFromSingleRecipient(VineRecipient vinerecipient, int i)
    {
        Bundle bundle = createServiceBundle();
        bundle.putInt("network", i);
        bundle.putParcelable("recipient", vinerecipient);
        bundle.putLong("recipient_id", vinerecipient.contactId);
        executeServiceAction(91, bundle);
    }

    public void fetchConversationRowIdFromUserRemoteId(long l, int i)
    {
        Bundle bundle = createServiceBundle();
        bundle.putInt("network", i);
        bundle.putParcelable("recipient", VineRecipient.fromUser(l));
        bundle.putLong("recipient_id", l);
        executeServiceAction(91, bundle);
    }

    public String fetchConversations(int i, boolean flag, int j)
    {
        Bundle bundle = createServiceBundleReadOnly();
        bundle.putInt("page_type", i);
        bundle.putBoolean("user_init", flag);
        bundle.putInt("network", j);
        return executeServiceAction(74, bundle);
    }

    public String fetchFollowers(long l, int i, long l1)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("profile_id", l);
        bundle.putInt("page", i);
        bundle.putLong("time", l1);
        return executeServiceAction(22, bundle);
    }

    public String fetchFollowing(long l, int i, long l1)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("profile_id", l);
        bundle.putInt("page", i);
        bundle.putLong("time", l1);
        return executeServiceAction(23, bundle);
    }

    public String fetchFriends(int i, int j)
    {
        Bundle bundle = createServiceBundle();
        bundle.putInt("page_type", i);
        bundle.putInt("type", j);
        return executeServiceAction(82, bundle);
    }

    public String fetchFriendsTypeAhead(String s)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("q", s);
        return executeServiceAction(99, bundle);
    }

    public String fetchNotificationSettings()
    {
        return executeServiceAction(113, createServiceBundle());
    }

    public String fetchNotificationUsers(co.vine.android.client.Session session, long l, int i, long l1)
    {
        session = createServiceBundle(session);
        session.putLong("notification_id", l);
        session.putInt("page", i);
        session.putLong("time", l1);
        return executeServiceAction(110, session);
    }

    public String fetchPendingNotificationCount(co.vine.android.client.Session session)
    {
        return executeServiceAction(65, createServiceBundle(session));
    }

    public String fetchPost(co.vine.android.client.Session session, long l)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        return executeServiceAction(28, session);
    }

    public String fetchPostId(co.vine.android.client.Session session, String s)
    {
        session = createServiceBundle(session);
        session.putString("post_share_id", s);
        return executeServiceAction(36, session);
    }

    public String fetchPostLikers(co.vine.android.client.Session session, long l, int i, long l1)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        session.putInt("page", i);
        session.putLong("time", l1);
        return executeServiceAction(11, session);
    }

    public String fetchPosts(co.vine.android.client.Session session, int i, long l, int j, int k, long l1, boolean flag, String s, String s1, Uri uri)
    {
        session = createServiceBundle(session);
        session.putInt("size", i);
        session.putInt("type", j);
        session.putInt("page", k);
        session.putLong("time", l1);
        session.putLong("profile_id", l);
        session.putBoolean("user_init", flag);
        if (s != null)
        {
            session.putString("tag_name", s);
        }
        if (s1 != null)
        {
            session.putString("sort", s1);
        }
        session.putParcelable("data", uri);
        return executeServiceAction(13, session);
    }

    public String fetchReviners(co.vine.android.client.Session session, long l, int i, long l1)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        session.putInt("page", i);
        session.putLong("time", l1);
        return executeServiceAction(56, session);
    }

    public String fetchServerStatus()
    {
        return executeServiceAction(38, createServiceBundle());
    }

    public String fetchTagTypeahead(String s)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("q", s);
        return executeServiceAction(40, bundle);
    }

    public String fetchTwitterFriends(co.vine.android.client.Session session, String s, String s1)
    {
        session = createServiceBundle(session);
        session.putString("key", s);
        session.putString("secret", s1);
        return executeServiceAction(15, session);
    }

    public String fetchTwitterUser(VineLogin vinelogin)
    {
        Bundle bundle = createServiceBundle();
        bundle.putParcelable("login", vinelogin);
        return executeServiceAction(7, bundle);
    }

    public String fetchUser(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("user_id", l);
        return executeServiceAction(21, bundle);
    }

    public String fetchUserId(ArrayList arraylist)
    {
        Bundle bundle = createServiceBundle();
        bundle.putStringArrayList("vanity_url", arraylist);
        return executeServiceAction(86, bundle);
    }

    public String fetchUserTypeahead(String s)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("q", s);
        return executeServiceAction(39, bundle);
    }

    public String fetchUsersMe(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("s_owner_id", l);
        return executeServiceAction(10, bundle);
    }

    public void followEditorsPicks(boolean flag)
    {
        Bundle bundle = createServiceBundle(getActiveSession());
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        bundle.putInt("should_follow_editors_picks", i);
        executeServiceAction(44, bundle);
    }

    public String followUser(co.vine.android.client.Session session, long l, boolean flag)
    {
        session = createServiceBundle(session);
        session.putLong("follow_id", l);
        session.putBoolean("notify", flag);
        return executeServiceAction(18, session);
    }

    public String generateReqIdForCanceledCaptcha()
    {
        return mServiceConnection.generateRequestId();
    }

    public long getActiveId()
    {
        return getActiveSessionReadOnly().getUserId();
    }

    public co.vine.android.client.Session getActiveSession()
    {
        return getActiveSession(false);
    }

    public co.vine.android.client.Session getActiveSessionReadOnly()
    {
        return getActiveSession(true);
    }

    public String getBlockedUsers()
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("user_id", getActiveId());
        return executeServiceAction(46, bundle);
    }

    public String getConversationRemoteId(long l)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("conversation_row_id", l);
        return executeServiceAction(77, bundle);
    }

    public void getEditions()
    {
        executeServiceAction(70, createServiceBundle());
    }

    public Session.LoginStatus getLoginStatus()
    {
        return getActiveSession().getLoginStatus();
    }

    public String getPendingFacebookToken()
    {
        return Util.getDefaultSharedPrefs(mContext).getString("KEY_FACEBOOK_TOKEN", null);
    }

    public Bitmap getPhotoBitmap(ImageKey imagekey)
    {
        if (!Util.isUrlLocal(imagekey.url))
        {
            return mPhotoImagesCache.getBitmap(getActiveId(), imagekey);
        } else
        {
            return BitmapFactory.decodeFile(Uri.parse(imagekey.url).getPath());
        }
    }

    public co.vine.android.client.Session getSession(String s)
    {
        return VineAccountHelper.getSession(mContext, s);
    }

    public Twitter getTwitter()
    {
        return mTwitter;
    }

    public String getTwitterAuth(String s, String s1, String s2)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("uri", s);
        bundle.putString("key", s1);
        bundle.putString("secret", s2);
        return executeServiceAction(5, bundle);
    }

    public int getTypeaheadFetchThreshold(String s)
    {
        return !"tag".equals(s) ? 2 : 3;
    }

    public int getTypeaheadMaxCompose()
    {
        return 50;
    }

    public long getTypeaheadThrottle()
    {
        return 300L;
    }

    public Session getValidFacebookSession(Activity activity, boolean flag)
    {
        Session session = Session.getActiveSession();
        boolean flag1;
        if (session != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            session = Session.openActiveSession(activity, false, this);
        }
        if (session == null || session.getState().isClosed())
        {
            SLog.d("There were no Facebook session.");
            activity = null;
        } else
        {
            Session.setActiveSession(session);
            activity = session.getState();
            SLog.d("Old Facebook Session state : {}", activity);
            if (activity == SessionState.CREATED_TOKEN_LOADED || activity.isOpened())
            {
                SLog.d("State is created or opened.");
                if (session.getPermissions().contains("publish_actions"))
                {
                    SLog.d("Permission is good.");
                    activity = session;
                    if (!flag1)
                    {
                        activity = session;
                        if (flag)
                        {
                            session.close();
                            return session;
                        }
                    }
                } else
                {
                    session.closeAndClearTokenInformation();
                    SLog.d("Permission missing.");
                    return null;
                }
            } else
            {
                session.close();
                SLog.d("Session state is invalid.");
                return null;
            }
        }
        return activity;
    }

    public String getVideoFilePath(VideoKey videokey)
    {
        if (!Util.isUrlLocal(videokey.url))
        {
            return mVideoCache.getFile(getActiveId(), videokey, false);
        } else
        {
            return Uri.parse(videokey.url).getPath();
        }
    }

    public void handleServiceResponse(int i, int j, String s, Bundle bundle)
    {
        String s1 = bundle.getString("rid");
        co.vine.android.service.PendingAction pendingaction = mServiceConnection.remove(s1);
        if (bundle.getBoolean("logged_out") && i != 6)
        {
            onLogout();
        } else
        {
            if (bundle.getBoolean("refresh_session", false))
            {
                refreshSessionKey(bundle.getString("s_key"));
            }
            String s2 = bundle.getString("captcha_url");
            bundle.remove("captcha_url");
            if (s2 != null)
            {
                s = mListeners.iterator();
                while (s.hasNext()) 
                {
                    ((AppSessionListener)s.next()).onCaptchaRequired(s1, s2, pendingaction);
                }
            } else
            {
                notifyListeners(s1, i, j, s, bundle);
                return;
            }
        }
    }

    public String ignoreConversation(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("conversation_row_id", l);
        return executeServiceAction(79, bundle);
    }

    public boolean isConnectedToFacebook(Activity activity)
    {
        return getValidFacebookSession(activity, true) != null;
    }

    public boolean isLoggedIn()
    {
        return VineAccountHelper.isLoggedIn(mContext, false);
    }

    public boolean isLoggedInReadOnly()
    {
        return VineAccountHelper.isLoggedIn(mContext, true);
    }

    public boolean isPendingRequest(String s)
    {
        return mServiceConnection.isPending(s);
    }

    public String likePost(String s, co.vine.android.client.Session session, long l, long l1, String s1, 
            boolean flag)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        session.putLong("user_id", l1);
        session.putString("username", s1);
        session.putBoolean("notify", flag);
        FlurryUtils.trackLikePost(l, s);
        return executeServiceAction(24, session);
    }

    public String login(co.vine.android.client.Session session, VineLogin vinelogin, String s, boolean flag)
    {
        session.setLoginStatus(Session.LoginStatus.LOGGING_IN);
        session = createServiceBundle(session);
        session.putParcelable("login", vinelogin);
        session.putString("pass", s);
        session.putBoolean("reactivate", flag);
        return executeServiceAction(2, session);
    }

    public String loginCheckTwitter(String s, String s1, String s2, long l, boolean flag)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("username", s);
        bundle.putString("key", s1);
        bundle.putString("secret", s2);
        bundle.putLong("t_id", l);
        bundle.putBoolean("reactivate", flag);
        return executeServiceAction(6, bundle);
    }

    public VineLogin loginComplete(co.vine.android.client.Session session, int i, Bundle bundle)
        throws VineLoggingException
    {
        if ((VineLogin)bundle.getParcelable("login") != null)
        {
            return loginComplete(session, i, bundle.getString("a_name"), bundle.getString("pass"), (VineLogin)bundle.getParcelable("login"), bundle.getString("avatar_url"));
        } else
        {
            return null;
        }
    }

    public VineLogin loginComplete(co.vine.android.client.Session session, int i, String s, String s1, VineLogin vinelogin, String s2)
        throws VineLoggingException
    {
        if (i != 200) goto _L2; else goto _L1
_L1:
        session.setLoginStatus(Session.LoginStatus.LOGGED_IN);
        vinelogin.loginType;
        JVM INSTR tableswitch 1 2: default 40
    //                   1 226
    //                   2 51;
           goto _L3 _L4 _L5
_L3:
        throw new UnsupportedOperationException("Unsupported login type.");
_L5:
        String s3 = s;
_L6:
        session.setUserId(vinelogin.userId);
        session.setName(s);
        session.setSessionKey(vinelogin.key);
        session.setLoginEmail(s3);
        session.setAvatarUrl(s2);
        VineAccountHelper.createAccount(mContext, s3, vinelogin, s1, s2, s);
        SettingsManager.setCurrentAccount(mContext, s3, s, vinelogin.userId);
        if (Util.getDefaultSharedPrefs(mContext).getLong("last_user_id", 0L) != vinelogin.userId)
        {
            clearFacebookToken();
            session = AppImpl.getInstance().getDiscardAllIntent(mContext);
            if (session != null)
            {
                mContext.startService(session);
            }
        }
        if (vinelogin.edition != null)
        {
            Util.getDefaultSharedPrefs(mContext).edit().putString("settings_edition", vinelogin.edition).commit();
        }
        FlurryAgent.setUserId(String.valueOf(vinelogin.userId));
        return vinelogin;
_L4:
        s3 = vinelogin.username;
        if (true) goto _L6; else goto _L2
_L2:
        return null;
    }

    public String loginWithxAuth(String s, String s1)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("username", s);
        bundle.putString("pass", s1);
        return executeServiceAction(8, bundle);
    }

    public String logout(co.vine.android.client.Session session)
    {
        if (session.getLoginStatus() == Session.LoginStatus.LOGGED_IN || session.getLoginStatus() == Session.LoginStatus.LOGGING_IN)
        {
            session.setLoginStatus(Session.LoginStatus.LOGGING_OUT);
            return executeServiceAction(3, createServiceBundle(session));
        } else
        {
            return null;
        }
    }

    public void markMessageLoopViewed(VinePrivateMessage vineprivatemessage)
    {
        Bundle bundle = createServiceBundle();
        bundle.putParcelable("message", vineprivatemessage);
        executeServiceAction(84, bundle);
    }

    public void mergePushNotification(VineSingleNotification vinesinglenotification, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("notification", vinesinglenotification);
        bundle.putString("message", s);
        executeServiceAction(97, bundle);
    }

    public void mergeSinglePost(Bundle bundle)
    {
        if (isLoggedInReadOnly())
        {
            executeServiceAction(57, injectServiceBundle(bundle, getActiveSession()));
        }
    }

    void notifyListeners(String s, int i, int j, String s1, Bundle bundle)
    {
        Object obj = mContext;
        i;
        JVM INSTR tableswitch 2 114: default 472
    //                   2 473
    //                   3 580
    //                   4 585
    //                   5 1057
    //                   6 1101
    //                   7 1202
    //                   8 1263
    //                   9 1317
    //                   10 2199
    //                   11 1450
    //                   12 1766
    //                   13 1554
    //                   14 1902
    //                   15 2772
    //                   16 2834
    //                   17 3491
    //                   18 2896
    //                   19 3062
    //                   20 3287
    //                   21 3527
    //                   22 1450
    //                   23 1450
    //                   24 4079
    //                   25 4187
    //                   26 3581
    //                   27 1980
    //                   28 4527
    //                   29 3916
    //                   30 2145
    //                   31 2031
    //                   32 3953
    //                   33 4040
    //                   34 472
    //                   35 472
    //                   36 4425
    //                   37 4577
    //                   38 4741
    //                   39 4888
    //                   40 5014
    //                   41 4812
    //                   42 5127
    //                   43 472
    //                   44 3187
    //                   45 5203
    //                   46 5308
    //                   47 5359
    //                   48 5411
    //                   49 5463
    //                   50 5606
    //                   51 5669
    //                   52 5720
    //                   53 5771
    //                   54 4308
    //                   55 4374
    //                   56 1450
    //                   57 472
    //                   58 5997
    //                   59 472
    //                   60 4616
    //                   61 4667
    //                   62 472
    //                   63 5822
    //                   64 472
    //                   65 5914
    //                   66 6264
    //                   67 5256
    //                   68 5502
    //                   69 5554
    //                   70 6040
    //                   71 3632
    //                   72 472
    //                   73 472
    //                   74 5077
    //                   75 472
    //                   76 1839
    //                   77 845
    //                   78 472
    //                   79 1356
    //                   80 1403
    //                   81 3356
    //                   82 1450
    //                   83 472
    //                   84 472
    //                   85 472
    //                   86 4476
    //                   87 472
    //                   88 794
    //                   89 6084
    //                   90 6174
    //                   91 976
    //                   92 6213
    //                   93 472
    //                   94 472
    //                   95 472
    //                   96 5900
    //                   97 4681
    //                   98 5861
    //                   99 4951
    //                   100 472
    //                   101 472
    //                   102 472
    //                   103 472
    //                   104 472
    //                   105 3753
    //                   106 3804
    //                   107 3023
    //                   108 3855
    //                   109 6135
    //                   110 1450
    //                   111 6369
    //                   112 6556
    //                   113 889
    //                   114 937;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L11 _L11 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L1 _L1 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L1 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L11 _L1 _L51 _L1 _L52 _L53 _L1 _L54 _L1 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L1 _L1 _L62 _L1 _L63 _L64 _L1 _L65 _L66 _L67 _L11 _L1 _L1 _L1 _L68 _L1 _L69 _L70 _L71 _L72 _L73 _L1 _L1 _L1 _L74 _L75 _L76 _L77 _L1 _L1 _L1 _L1 _L1 _L78 _L79 _L80 _L81 _L82 _L11 _L83 _L84 _L85 _L86
_L1:
        return;
_L2:
        VineLogin vinelogin;
        try
        {
            vinelogin = loginComplete(VineAccountHelper.getCachedActiveSession(), j, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Util.showCenteredToast(mContext, 0x7f0e00d7);
            CrashUtil.logException(s);
            return;
        }
        i = bundle.getInt("error_code", -1);
        bundle = new Intent("co.vine.android.session.login");
        mContext.sendBroadcast(bundle, "co.vine.android.BROADCAST");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onLoginComplete(VineAccountHelper.getCachedActiveSession(), s, j, s1, i, vinelogin);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        onLogout();
        return;
_L4:
        VineLogin vinelogin1 = (VineLogin)bundle.getParcelable("login");
        obj = bundle.getString("pass");
        String s7 = bundle.getString("a_name");
        String s9 = bundle.getString("avatar_url");
        Uri uri = (Uri)bundle.getParcelable("uri");
        String s10 = bundle.getString("s_key");
        long l4 = bundle.getLong("s_owner_id");
        i = 0;
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onSignUpComplete(s, j, s1, vinelogin1, s7, ((String) (obj)), s9);
            int k = i;
            if (j == 200)
            {
                k = i;
                if (i == 0)
                {
                    k = i;
                    if (uri != null)
                    {
                        k = 1;
                        co.vine.android.client.Session session = getActiveSession();
                        session.setSessionKey(s10);
                        session.setUserId(l4);
                        updateProfilePhoto(session, uri);
                    }
                }
            }
            Intent intent = new Intent("co.vine.android.session.login");
            mContext.sendBroadcast(intent, "co.vine.android.BROADCAST");
            i = k;
        }
        if (true) goto _L1; else goto _L69
_L69:
        bundle = bundle.getString("avatar_url");
        Iterator iterator = mListeners.iterator();
        while (iterator.hasNext()) 
        {
            ((AppSessionListener)iterator.next()).onProfilePhotoUpdatedComplete(s, j, s1, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L64:
        long l5 = bundle.getLong("conversation_id");
        s = mListeners.iterator();
        while (s.hasNext()) 
        {
            ((AppSessionListener)s.next()).onGetConversationRemoteIdComplete(l5);
        }
        if (true) goto _L1; else goto _L85
_L85:
        s1 = bundle.getParcelableArrayList("notificationSettings");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onGetNotificationSettingsComplete(s, s1);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L86:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onSaveNotificationSettingsComplete(s, j, s1);
        }
        if (true) goto _L1; else goto _L72
_L72:
        long l6 = bundle.getLong("conversation_row_id");
        long l27 = bundle.getLong("recipient_id");
        s = bundle.getString("username");
        boolean flag = bundle.getBoolean("am_following");
        s1 = mListeners.iterator();
        while (s1.hasNext()) 
        {
            ((AppSessionListener)s1.next()).onGetConversationRowIdComplete(l27, l6, s, flag);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        s1 = mListeners.iterator();
        while (s1.hasNext()) 
        {
            ((AppSessionListener)s1.next()).onGetTwitterAuthUrlComplete(s, bundle.getString("load_url"));
        }
        if (true) goto _L1; else goto _L6
_L6:
        for (Iterator iterator1 = mListeners.iterator(); iterator1.hasNext(); ((AppSessionListener)iterator1.next()).onCheckTwitterComplete(s, j, s1, bundle.getInt("error_code", -1), bundle.getBoolean("a_exists"), (VineUser)bundle.getParcelable("user"), (VineLogin)bundle.getParcelable("login"))) { }
        s = new Intent("co.vine.android.session.login");
        mContext.sendBroadcast(s, "co.vine.android.BROADCAST");
        return;
_L7:
        Iterator iterator2 = mListeners.iterator();
        while (iterator2.hasNext()) 
        {
            ((AppSessionListener)iterator2.next()).onGetTwitterUserComplete(s, j, s1, (TwitterUser)bundle.getParcelable("t_user"), (VineLogin)bundle.getParcelable("login"));
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L8:
        bundle = (VineLogin)bundle.getParcelable("login");
        Iterator iterator3 = mListeners.iterator();
        while (iterator3.hasNext()) 
        {
            ((AppSessionListener)iterator3.next()).onTwitterxAuthComplete(s, j, s1, bundle);
        }
        if (true) goto _L1; else goto _L9
_L9:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onResetPasswordComplete(s, j, s1);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L65:
        Iterator iterator4 = mListeners.iterator();
        while (iterator4.hasNext()) 
        {
            ((AppSessionListener)iterator4.next()).onIgnoreConversationComplete(s, j, s1, bundle.getLong("conversation_row_id"));
        }
        if (true) goto _L1; else goto _L66
_L66:
        Iterator iterator5 = mListeners.iterator();
        while (iterator5.hasNext()) 
        {
            ((AppSessionListener)iterator5.next()).onDeleteConversationComplete(s, j, s1, bundle.getLong("conversation_row_id"));
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L11:
        i = bundle.getInt("count", 0);
        int l = bundle.getInt("next_page", 0);
        int i2 = bundle.getInt("previous_page", 0);
        long l7 = bundle.getLong("time", 0L);
        bundle = bundle.getParcelableArrayList("users");
        Iterator iterator6 = mListeners.iterator();
        while (iterator6.hasNext()) 
        {
            ((AppSessionListener)iterator6.next()).onGetUsersComplete(VineAccountHelper.getCachedActiveSession(), s, j, s1, i, bundle, l, i2, l7);
        }
        if (true) goto _L1; else goto _L13
_L13:
        i = bundle.getInt("type", -1);
        int i1 = bundle.getInt("count", 0);
        int j2 = bundle.getInt("size", 0);
        String s2 = bundle.getString("tag_name");
        int j3 = bundle.getInt("page_type");
        int k3 = bundle.getInt("next_page");
        int l3 = bundle.getInt("previous_page");
        long l8 = bundle.getLong("time");
        obj = bundle.getString("title");
        boolean flag1 = bundle.getBoolean("user_init");
        boolean flag16 = bundle.getBoolean("in_memory", false);
        Iterator iterator21;
        if (flag16)
        {
            bundle = bundle.getParcelableArrayList("posts");
        } else
        {
            bundle = null;
        }
        for (iterator21 = mListeners.iterator(); iterator21.hasNext(); ((AppSessionListener)iterator21.next()).onGetTimeLineComplete(s, j, s1, i, i1, flag16, bundle, s2, j3, k3, l3, l8, flag1, j2, ((String) (obj)))) { }
        if (j == 200)
        {
            determineCleanup(getActiveSession());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        i = bundle.getInt("next_page");
        long l9 = bundle.getLong("time");
        bundle = bundle.getParcelableArrayList("comments");
        Iterator iterator7 = mListeners.iterator();
        while (iterator7.hasNext()) 
        {
            ((AppSessionListener)iterator7.next()).onGetCommentsComplete(s, j, s1, i, l9, bundle);
        }
        if (true) goto _L1; else goto _L63
_L63:
        Iterator iterator8 = mListeners.iterator();
        while (iterator8.hasNext()) 
        {
            ((AppSessionListener)iterator8.next()).onGetConversationComplete(s, j, s1, bundle.getLong("conversation_row_id"), bundle.getInt("resp_code"), bundle.getBoolean("empty"));
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L14:
        long l10 = bundle.getLong("post_id");
        VineComment vinecomment = (VineComment)bundle.getParcelable("comment_obj");
        bundle = bundle.getString("comment");
        obj = mListeners.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            ((AppSessionListener)((Iterator) (obj)).next()).onPostCommentComplete(s, j, s1, l10, bundle, vinecomment);
        }
        if (true) goto _L1; else goto _L25
_L25:
        long l11 = bundle.getLong("post_id");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onReportPostComplete(s, j, s1, l11);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L29:
        SharedPreferences sharedpreferences = Util.getDefaultSharedPrefs(mContext);
        obj = sharedpreferences.edit();
        i = sharedpreferences.getInt("profile_post_count", 0);
        long l12 = bundle.getLong("post_id");
        if (i > 0)
        {
            i--;
        } else
        {
            i = 0;
        }
        ((android.content.SharedPreferences.Editor) (obj)).putInt("profile_post_count", i);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onDeletePostComplete(s, l12, j, s1);
        }
        if (true) goto _L1; else goto _L28
_L28:
        long l13 = Long.parseLong(bundle.getString("comment_id"));
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onDeleteCommentComplete(s, j, s1, l13);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L10:
        VineUser vineuser = (VineUser)bundle.getParcelable("user");
        long l14 = bundle.getLong("s_owner_id");
        if (vineuser != null)
        {
            bundle = Util.getDefaultSharedPrefs(mContext).edit();
            bundle.putString("settings_profile_name", vineuser.username);
            bundle.putString("settings_profile_description", vineuser.description);
            bundle.putString("settings_profile_location", vineuser.location);
            bundle.putString("settings_profile_phone", vineuser.phoneNumber);
            bundle.putString("settings_profile_email", vineuser.email);
            bundle.putString("settings_profile_avatar_url", vineuser.avatarUrl);
            bundle.putInt("profile_follow_count", vineuser.followingCount);
            bundle.putInt("profile_follower_count", vineuser.followerCount);
            bundle.putInt("profile_authored_post_count", vineuser.authoredPostCount);
            bundle.putInt("profile_post_count", vineuser.postCount);
            bundle.putInt("profile_like_count", vineuser.likeCount);
            bundle.putLong("profile_loop_count", vineuser.loopCount);
            boolean flag2;
            if (vineuser.twitterConnected == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            bundle.putBoolean("settings_twitter_connected", flag2);
            if (vineuser.includePromoted == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            bundle.putBoolean("settings_follow_editors_picks", flag2);
            bundle.putBoolean("settings_private", vineuser.isPrivate());
            bundle.putBoolean("profile_email_verified", vineuser.isEmailVerified());
            bundle.putBoolean("profile_phone_verified", vineuser.isPhoneVerified());
            bundle.putLong("pref_user_row_id", vineuser.id);
            if (vineuser.edition != null)
            {
                bundle.putString("settings_edition", vineuser.edition);
            }
            bundle.putBoolean("accept_out_of_network_messages", vineuser.acceptsOutOfNetworkConversations);
            if (!vineuser.disableAddressBook)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            bundle.putBoolean("enable_address_book", flag2);
            if (!vineuser.hiddenEmail)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            bundle.putBoolean("email_discoverable", flag2);
            if (!vineuser.hiddenPhoneNumber)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            bundle.putBoolean("phone_discoverable", flag2);
            if (vineuser.profileBackground < 0)
            {
                i = Settings.DEFAULT_PROFILE_COLOR;
            } else
            {
                i = vineuser.profileBackground;
            }
            bundle.putInt("profile_background", i);
            bundle.apply();
        }
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onGetUsersMeComplete(s, j, s1, l14, vineuser);
        }
        if (true) goto _L1; else goto _L15
_L15:
        i = bundle.getInt("count", 0);
        bundle = bundle.getParcelableArrayList("users");
        Iterator iterator9 = mListeners.iterator();
        while (iterator9.hasNext()) 
        {
            ((AppSessionListener)iterator9.next()).onGetTwitterFriendsComplete(s, j, s1, i, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L16:
        i = bundle.getInt("count", 0);
        bundle = bundle.getParcelableArrayList("users");
        Iterator iterator10 = mListeners.iterator();
        while (iterator10.hasNext()) 
        {
            ((AppSessionListener)iterator10.next()).onGetAddressFriendsComplete(s, j, s1, i, bundle);
        }
        if (true) goto _L1; else goto _L18
_L18:
        long l15 = bundle.getLong("follow_id");
        fetchPosts(getActiveSession(), 10, l15, 1, 1, 0L, false, String.valueOf(getActiveId()), null, null);
        bundle = Util.getDefaultSharedPrefs(mContext);
        android.content.SharedPreferences.Editor editor = bundle.edit();
        editor.putInt("profile_follow_count", bundle.getInt("profile_follow_count", 0) + 1);
        editor.commit();
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onFollowComplete(s, j, s1, l15);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L80:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onBulkFollowComplete(s, j, s1);
        }
        if (true) goto _L1; else goto _L19
_L19:
        long l16 = bundle.getLong("follow_id");
        removeFollowPosts(getActiveSession(), l16);
        bundle = Util.getDefaultSharedPrefs(mContext);
        android.content.SharedPreferences.Editor editor1 = bundle.edit();
        i = bundle.getInt("profile_follow_count", 0);
        if (i > 0)
        {
            i--;
        } else
        {
            i = 0;
        }
        editor1.putInt("profile_follow_count", i);
        editor1.commit();
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUnFollowComplete(s, j, s1, l16);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L39:
        boolean flag3 = bundle.getBoolean("should_follow_editors_picks");
        if (!flag3)
        {
            expireTimeline(true, 1, String.valueOf(VineAccountHelper.getCachedActiveSession().getUserId()));
        } else
        {
            fetchPosts(getActiveSession(), 10, 0L, 1, 1, 0L, true, String.valueOf(getActiveId()), null, null);
        }
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUpdateFollowEditorsPicksComplete(s, j, s1, flag3);
        }
        if (true) goto _L1; else goto _L20
_L20:
        VinePagedData vinepageddata = (VinePagedData)bundle.getParcelable("notifications");
        bundle = (VinePagedData)bundle.getParcelable("follow_requests");
        obj = mListeners.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            ((AppSessionListener)((Iterator) (obj)).next()).onGetActivityComplete(s, j, s1, vinepageddata, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L67:
        i = bundle.getInt("count");
        int j1 = bundle.getInt("messages_count");
        int k2 = bundle.getInt("follow_reqs_c", 0);
        bundle = Util.getDefaultSharedPrefs(mContext).edit();
        bundle.putInt("settings_follow_pref_count", k2);
        bundle.putInt("settings_unread_messages_count", j1);
        bundle.commit();
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            AppSessionListener appsessionlistener = (AppSessionListener)bundle.next();
            appsessionlistener.onGetActivityCountComplete(s, j, s1, i, k2);
            appsessionlistener.onGetMessageCountComplete(s, j, s1, j1);
        }
        if (true) goto _L1; else goto _L17
_L17:
        s1 = mListeners.iterator();
        while (s1.hasNext()) 
        {
            ((AppSessionListener)s1.next()).onRemoveUsersComplete(s);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L21:
        bundle = (VineUser)bundle.getParcelable("user");
        Iterator iterator11 = mListeners.iterator();
        while (iterator11.hasNext()) 
        {
            ((AppSessionListener)iterator11.next()).onGetUserComplete(s, j, s1, bundle);
        }
        if (true) goto _L1; else goto _L24
_L24:
        bundle = bundle.getString("avatar_url");
        Iterator iterator12 = mListeners.iterator();
        while (iterator12.hasNext()) 
        {
            ((AppSessionListener)iterator12.next()).onUpdateProfileComplete(s, j, s1, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L61:
        bundle = bundle.getString("edition");
        SLog.d("Edition update success. New edition is {}", bundle);
        if (j == 200)
        {
            android.content.SharedPreferences.Editor editor2 = Util.getDefaultSharedPrefs(mContext).edit();
            editor2.putString("settings_edition", bundle);
            editor2.commit();
        }
        for (Iterator iterator13 = mListeners.iterator(); iterator13.hasNext(); ((AppSessionListener)iterator13.next()).onUpdateEditionComplete(s, j, s1, bundle)) { }
        mContext.sendBroadcast(new Intent("action_edition_updated"), "co.vine.android.BROADCAST");
        return;
_L78:
        boolean flag4 = bundle.getBoolean("accept_oon");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUpdateAcceptOonComplete(s, j, s1, flag4);
        }
        if (true) goto _L1; else goto _L79
_L79:
        boolean flag5 = bundle.getBoolean("enable");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUpdateEnableAddressBookComplete(s, j, s1, flag5);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L81:
        boolean flag6 = bundle.getBoolean("enable");
        i = bundle.getInt("type");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUpdateDiscoverability(s, j, s1, i, flag6);
        }
        if (true) goto _L1; else goto _L27
_L27:
        s = Util.getSharedPrefs(mContext, "last_cleanup").edit();
        s.putLong("last_cleanup", System.currentTimeMillis());
        s.commit();
        return;
_L30:
        String s3 = bundle.getString("username");
        obj = bundle.getString("key");
        String s8 = bundle.getString("secret");
        long l17 = bundle.getLong("user_id");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onConnectTwitterComplete(s, j, s1, s3, ((String) (obj)), s8, l17);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L31:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onDisconnectTwitterComplete(s, j, s1);
        }
        if (true) goto _L1; else goto _L22
_L22:
        long l18 = bundle.getLong("post_id");
        if (j == 200)
        {
            bundle = Util.getDefaultSharedPrefs(mContext);
            android.content.SharedPreferences.Editor editor3 = bundle.edit();
            editor3.putInt("profile_like_count", bundle.getInt("profile_like_count", 0) + 1);
            editor3.commit();
        }
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onLikePost(s, j, s1, l18);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L23:
        long l19 = bundle.getLong("post_id");
        if (j == 200)
        {
            bundle = Util.getDefaultSharedPrefs(mContext);
            android.content.SharedPreferences.Editor editor4 = bundle.edit();
            i = bundle.getInt("profile_like_count", 0);
            if (i > 0)
            {
                i--;
            } else
            {
                i = 0;
            }
            editor4.putInt("profile_like_count", i);
            editor4.commit();
        }
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUnlikePost(s, j, s1, l19);
        }
        if (true) goto _L1; else goto _L49
_L49:
        long l20 = bundle.getLong("post_id");
        bundle = (VineRepost)bundle.getSerializable("repost");
        Iterator iterator14 = mListeners.iterator();
        while (iterator14.hasNext()) 
        {
            ((AppSessionListener)iterator14.next()).onRevine(s, j, s1, l20, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L50:
        long l21 = bundle.getLong("post_id");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUnrevine(s, j, s1, l21);
        }
        if (true) goto _L1; else goto _L32
_L32:
        long l22 = bundle.getLong("post_id");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onGetPostIdComplete(s, j, s1, l22);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L68:
        long l23 = bundle.getLong("user_id");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onGetUserIdComplete(s, j, s1, l23);
        }
        if (true) goto _L1; else goto _L26
_L26:
        Iterator iterator15 = mListeners.iterator();
        while (iterator15.hasNext()) 
        {
            ((AppSessionListener)iterator15.next()).onGetSinglePostComplete(s, j, s1, (VinePost)bundle.getParcelable("post"));
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L33:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onConnectFacebookComplete(s, j, s1);
        }
        if (true) goto _L1; else goto _L52
_L52:
        long l24 = bundle.getLong("user_id");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onGcmRegistrationComplete(s, j, s1, l24);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L53:
        deleteSession(bundle.getString("s_key"));
        return;
_L75:
        s = bundle.getParcelableArrayList("notifications");
        s1 = (VineSingleNotification)bundle.getParcelable("notification");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onMergeNotificationComplete(s1, s);
        }
        if (true) goto _L1; else goto _L34
_L34:
        s = (ServerStatus)bundle.getParcelable("server_status");
        if (j == 200 && s != null && !TextUtils.isEmpty(((ServerStatus) (s)).uploadType))
        {
            s1 = Util.getDefaultSharedPrefs(mContext).edit();
            s1.putString("server_upload_type", ((ServerStatus) (s)).uploadType);
            s1.commit();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L37:
        i = bundle.getInt("count", 0);
        int k1 = bundle.getInt("next_page", 0);
        int l2 = bundle.getInt("previous_page", 0);
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUserSearchComplete(s, j, s1, i, k1, l2);
        }
        if (true) goto _L1; else goto _L35
_L35:
        String s4 = bundle.getString("q");
        bundle = bundle.getParcelableArrayList("users");
        obj = mListeners.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            ((AppSessionListener)((Iterator) (obj)).next()).onGetUserTypeAheadComplete(s, j, s1, s4, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L77:
        String s5 = bundle.getString("q");
        bundle = bundle.getParcelableArrayList("users");
        obj = mListeners.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            ((AppSessionListener)((Iterator) (obj)).next()).onGetFriendsTypeAheadComplete(s, j, s1, s5, bundle);
        }
        if (true) goto _L1; else goto _L36
_L36:
        String s6 = bundle.getString("q");
        bundle = bundle.getParcelableArrayList("tags");
        obj = mListeners.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            ((AppSessionListener)((Iterator) (obj)).next()).onGetTagTypeAheadComplete(s, j, s1, s6, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L62:
        i = bundle.getInt("count", 0);
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onGetMessageInboxComplete(s, j, s1, i);
        }
        if (true) goto _L1; else goto _L38
_L38:
        i = bundle.getInt("count", 0);
        int l1 = bundle.getInt("next_page", 0);
        int i3 = bundle.getInt("previous_page", 0);
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onTagSearchComplete(s, j, s1, i, l1, i3);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L40:
        i = bundle.getInt("type");
        s = bundle.getString("tag_name");
        if (bundle.getBoolean("also_fetch_posts", false))
        {
            fetchPosts(getActiveSession(), 10, getActiveId(), i, 1, 0L, true, s, null, null);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L57:
        boolean flag7 = bundle.getBoolean("response_success", false);
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onDeactivateAccountComplete(s, j, s1, flag7);
        }
        if (true) goto _L1; else goto _L41
_L41:
        bundle = bundle.getParcelableArrayList("blocked_users");
        Iterator iterator16 = mListeners.iterator();
        while (iterator16.hasNext()) 
        {
            ((AppSessionListener)iterator16.next()).onGetBlockedUsersComplete(s, j, s1, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L42:
        boolean flag8 = bundle.getBoolean("response_success", false);
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onBlockUserComplete(s, j, s1, flag8);
        }
        if (true) goto _L1; else goto _L43
_L43:
        boolean flag9 = bundle.getBoolean("response_success", false);
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUnblockUserComplete(s, j, s1, flag9);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L44:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onReportUserComplete(s, j, s1);
        }
        if (true) goto _L1; else goto _L58
_L58:
        boolean flag10 = bundle.getBoolean("response_success", false);
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onEnableUserRepostsComplete(s, j, s1, flag10);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L59:
        boolean flag11 = bundle.getBoolean("response_success", false);
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onDisableUserRepostsComplete(s, j, s1, flag11);
        }
        if (true) goto _L1; else goto _L45
_L45:
        long l25 = bundle.getLong("user_id");
        boolean flag12 = bundle.getBoolean("accept");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onRespondFollowRequestComplete(s, j, s1, flag12, l25);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L46:
        boolean flag13 = bundle.getBoolean("explicit");
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onUpdateExplicitComplete(s, j, s1, flag13);
        }
        if (true) goto _L1; else goto _L47
_L47:
        boolean flag14 = bundle.getBoolean("priv");
        for (Iterator iterator17 = mListeners.iterator(); iterator17.hasNext(); ((AppSessionListener)iterator17.next()).onUpdatePrivateComplete(s, j, s1, flag14)) { }
_L48:
        bundle = bundle.getParcelableArrayList("channels");
        Iterator iterator18 = mListeners.iterator();
        while (iterator18.hasNext()) 
        {
            ((AppSessionListener)iterator18.next()).onGetChannelsComplete(s, j, s1, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L54:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onSharePostComplete(s, j, s1);
        }
        if (true) goto _L1; else goto _L76
_L76:
        for (bundle = mListeners.iterator(); bundle.hasNext(); ((AppSessionListener)bundle.next()).onPostVideoComplete(s, j, s1)) { }
_L74:
        SLog.d("Share as a vm : {} {} {}.", s, Integer.valueOf(j), s1);
        return;
_L55:
        i = bundle.getInt("count");
        if (j == 200)
        {
            Util.getDefaultSharedPrefs(mContext).edit().putInt("unread_notification_count", i).commit();
        }
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onGetPendingNotificationCountComplete(s, j, s1, i);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L51:
        clearFileCache();
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onClearCacheComplete(s, j, s1);
        }
        if (true) goto _L1; else goto _L60
_L60:
        s = mListeners.iterator();
        while (s.hasNext()) 
        {
            ((AppSessionListener)s.next()).onGetEditionsComplete(j, (ArrayList)bundle.getSerializable("editions"));
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L70:
        bundle = bundle.getString("phone");
        Iterator iterator19 = mListeners.iterator();
        while (iterator19.hasNext()) 
        {
            ((AppSessionListener)iterator19.next()).onRequestPhoneVerificationComplete(s, j, s1, bundle);
        }
        if (true) goto _L1; else goto _L82
_L82:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onVerifyEmailComplete(s, j, s1);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L71:
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onVerifyPhoneNumberComplete(s, j, s1);
        }
        if (true) goto _L1; else goto _L73
_L73:
        bundle = bundle.getString("email");
        Iterator iterator20 = mListeners.iterator();
        while (iterator20.hasNext()) 
        {
            ((AppSessionListener)iterator20.next()).onRequestEmailVerificationComplete(s, j, s1, bundle);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L56:
        s = (VineLoopSubmissionResponse)bundle.getParcelable("loop_submission");
        if (j == 200 && s != null)
        {
            long l26 = (long)((VineLoopSubmissionResponse) (s)).submissionInterval * 1000L;
            SLog.d("Changing loop interval from {} to {}", Long.valueOf(mLoopCountSubmissionInterval), Long.valueOf(l26));
            mLoopCountSubmissionInterval = Math.max(l26, 60000L);
            scheduleLoopCounts();
            return;
        } else
        {
            s = bundle.getParcelableArrayList("loops");
            SLog.d("Loop submission failed; re-saving {} pending loops", Integer.valueOf(s.size()));
            LoopManager.get(mContext).undoPopPendingLoops(s);
            return;
        }
_L83:
        boolean flag15;
        VineClientFlags vineclientflags;
        try
        {
            ClientFlagsHelper.setLastCheckMillis(((Context) (obj)));
            vineclientflags = (VineClientFlags)bundle.getParcelable("client_flags");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            CrashUtil.logException(s);
            return;
        }
        if (j != 200 || vineclientflags == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ClientFlagsHelper.updateClientFlags(((Context) (obj)), vineclientflags);
        VineAPI.getInstance(((Context) (obj))).refreshHostUrls(vineclientflags, ((Context) (obj)).getResources());
        flag15 = bundle.getBoolean("abort_requests", true);
        if (!ClientFlagsHelper.hostsDidChange(((Context) (obj)), vineclientflags))
        {
            break MISSING_BLOCK_LABEL_6470;
        }
        if (!flag15)
        {
            break MISSING_BLOCK_LABEL_6451;
        }
        abortAllRequests();
        if (!TextUtils.isEmpty(vineclientflags.apiHost))
        {
            flag15 = true;
        } else
        {
            flag15 = false;
        }
        FlurryUtils.trackZeroRatedSessionStarted(flag15);
        if (TextUtils.isEmpty(vineclientflags.messageTitle) && TextUtils.isEmpty(vineclientflags.messageText))
        {
            flag15 = false;
        } else
        {
            flag15 = true;
        }
        bundle = mListeners.iterator();
        while (bundle.hasNext()) 
        {
            ((AppSessionListener)bundle.next()).onFetchClientFlagsComplete(s, j, s1, vineclientflags, flag15);
        }
        if (true) goto _L1; else goto _L84
_L84:
        ((Context) (obj)).sendBroadcast(new Intent("abort_all_requests"), "co.vine.android.BROADCAST");
        s = mListeners.iterator();
        while (s.hasNext()) 
        {
            ((AppSessionListener)s.next()).onAbortAllRequestsComplete();
        }
        if (true) goto _L1; else goto _L87
_L87:
    }

    public void onLowMemory()
    {
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((AppSessionListener)iterator.next()).onLowMemory()) { }
    }

    public void onMobileDataNetworkActivated()
    {
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((AppSessionListener)iterator.next()).onMobileDataNetworkActivated()) { }
    }

    public void onPhotoImageError(PhotoImagesCache photoimagescache, ImageKey imagekey, HttpResult httpresult)
    {
        photoimagescache = mListeners;
        for (int i = photoimagescache.size() - 1; i >= 0; i--)
        {
            ((AppSessionListener)photoimagescache.get(i)).onPhotoImageError(imagekey, httpresult);
        }

    }

    public void onPhotoImageLoaded(PhotoImagesCache photoimagescache, HashMap hashmap)
    {
        SLog.d("Image has loaded.");
        photoimagescache = mListeners;
        for (int i = photoimagescache.size() - 1; i >= 0; i--)
        {
            ((AppSessionListener)photoimagescache.get(i)).onPhotoImageLoaded(hashmap);
        }

    }

    public void onTrimMemory(int i)
    {
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((AppSessionListener)iterator.next()).onTrimMemory(i)) { }
    }

    public void onVideoPathError(VideoCache videocache, VideoKey videokey, HttpResult httpresult)
    {
        videocache = mListeners;
        for (int i = videocache.size() - 1; i >= 0; i--)
        {
            ((AppSessionListener)videocache.get(i)).onVideoPathError(videokey, httpresult);
        }

    }

    public void onVideoPathObtained(VideoCache videocache, HashMap hashmap)
    {
        videocache = mListeners;
        for (int i = videocache.size() - 1; i >= 0; i--)
        {
            ((AppSessionListener)videocache.get(i)).onVideoPathObtained(hashmap);
        }

    }

    public String peekVideoFilePath(VideoKey videokey)
    {
        return mVideoCache.getFile(getActiveId(), videokey, true);
    }

    public String postComment(long l, co.vine.android.client.Session session, String s, ArrayList arraylist)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("post_id", l);
        bundle.putLong("user_id", session.getUserId());
        bundle.putString("username", session.getName());
        bundle.putString("comment", Util.cleanse(s));
        bundle.putString("avatar_url", session.getAvatarUrl());
        bundle.putParcelableArrayList("entities", arraylist);
        return executeServiceAction(14, bundle);
    }

    public void refreshSessionKey(String s)
    {
        co.vine.android.client.Session session = VineAccountHelper.getCachedActiveSession();
        if (session != null)
        {
            session.setSessionKey(s);
        }
    }

    public String removeFollowPosts(co.vine.android.client.Session session, long l)
    {
        session = createServiceBundle(session);
        session.putLong("user_id", l);
        return executeServiceAction(34, session);
    }

    public void removeFromVideoCache(VideoKey videokey)
    {
        mVideoCache.remove(videokey);
    }

    public void removeListener(AppSessionListener appsessionlistener)
    {
        mListeners.remove(appsessionlistener);
    }

    public void removeNotification(int i, long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putInt("notification_id", i);
        bundle.putLong("conversation_row_id", l);
        executeServiceAction(102, bundle);
    }

    public String removeUsers(co.vine.android.client.Session session, int i)
    {
        session = createServiceBundle(session);
        session.putInt("type", i);
        return executeServiceAction(17, session);
    }

    public String reportPerson(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("user_id", l);
        return executeServiceAction(49, bundle);
    }

    public String reportPost(co.vine.android.client.Session session, long l)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        return executeServiceAction(27, session);
    }

    public String requestEmailVerification(co.vine.android.client.Session session, String s, long l)
    {
        session = createServiceBundle(session);
        session.putString("email", s);
        session.putLong("user_id", l);
        return executeServiceAction(92, session);
    }

    public String requestPhoneVerification(co.vine.android.client.Session session, String s, long l)
    {
        session = createServiceBundle(session);
        session.putString("phone", s);
        session.putLong("user_id", l);
        return executeServiceAction(89, session);
    }

    public String resetPassword(String s)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("login", s);
        return executeServiceAction(9, bundle);
    }

    public void retryMessagesInConversationRowId(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("conversation_row_id", l);
        executeServiceAction(103, bundle);
    }

    public String retryRequest(int i, Bundle bundle)
    {
        injectServiceBundle(bundle, getActiveSession());
        bundle.remove("captcha_url");
        return executeServiceAction(i, bundle);
    }

    public String revine(String s, co.vine.android.client.Session session, long l, String s1)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        session.putString("username", s1);
        FlurryUtils.trackRevine(l, s);
        return executeServiceAction(54, session);
    }

    public String saveLoadedPosts(ArrayList arraylist, int i, String s, int j, int k, int l, long l1, boolean flag)
    {
        Bundle bundle = createServiceBundle();
        bundle.putParcelableArrayList("posts", arraylist);
        bundle.putInt("type", i);
        bundle.putString("tag_name", s);
        bundle.putInt("page_type", j);
        bundle.putInt("next_page", k);
        bundle.putInt("previous_page", l);
        bundle.putLong("time", l1);
        bundle.putBoolean("user_init", flag);
        return executeServiceAction(43, bundle);
    }

    public String saveNotificationSettings(HashMap hashmap)
    {
        Bundle bundle = createServiceBundle();
        bundle.putSerializable("notificationSettings", hashmap);
        return executeServiceAction(114, bundle);
    }

    public void scheduleLoopCounts()
    {
        if (mHandler != null)
        {
            mHandler.removeCallbacks(mLoopCountRunnable);
            mHandler.postDelayed(mLoopCountRunnable, mLoopCountSubmissionInterval);
        }
    }

    public String searchTags(String s, int i)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("q", s);
        bundle.putInt("page_type", i);
        return executeServiceAction(42, bundle);
    }

    public String searchUsers(String s, int i)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("q", s);
        bundle.putInt("page_type", i);
        return executeServiceAction(41, bundle);
    }

    public String sendAddressBook()
    {
        return executeServiceAction(101, createServiceBundle());
    }

    public String sendFacebookToken()
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("facebook_token", getPendingFacebookToken());
        return executeServiceAction(37, bundle);
    }

    public String sendGcmRegId(String s, long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("gcmRegId", s);
        bundle.putLong("user_id", l);
        return executeServiceAction(60, bundle);
    }

    public String sendLoopCounts()
    {
        scheduleLoopCounts();
        Object obj = LoopManager.get(mContext);
        Bundle bundle = createServiceBundle();
        obj = new ArrayList(((LoopManager) (obj)).popPendingLoops());
        if (((ArrayList) (obj)).isEmpty())
        {
            return "";
        } else
        {
            bundle.putParcelableArrayList("loops", ((ArrayList) (obj)));
            return executeServiceAction(66, bundle);
        }
    }

    public void sendViewedVines()
    {
        executeServiceAction(85, createServiceBundle());
    }

    public String setHideProfileReposts(long l, boolean flag)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("user_id", l);
        bundle.putBoolean("block_profile_reposts", flag);
        return executeServiceAction(87, bundle);
    }

    public void setSessionKey(String s)
    {
        co.vine.android.client.Session session = VineAccountHelper.getCachedActiveSession();
        if (session != null)
        {
            session.setSessionKey(s);
        }
    }

    public void shareAsVM(ArrayList arraylist, long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putParcelableArrayList("recipients", arraylist);
        bundle.putLong("post_id", l);
        executeServiceAction(96, bundle);
    }

    public void sharePost(String s, String s1, long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("network", s);
        bundle.putString("message", s1);
        bundle.putLong("post_id", l);
        executeServiceAction(63, bundle);
    }

    public String signUp(String s, String s1, String s2, String s3, Uri uri, TwitterUser twitteruser, VineLogin vinelogin)
    {
        Bundle bundle = createServiceBundle();
        bundle.putString("login", s);
        bundle.putString("pass", s1);
        bundle.putString("a_name", s2);
        bundle.putString("phone", s3);
        bundle.putParcelable("uri", uri);
        bundle.putParcelable("t_user", twitteruser);
        if (vinelogin != null)
        {
            bundle.putString("key", vinelogin.twitterToken);
            bundle.putString("secret", vinelogin.twitterSecret);
        }
        return executeServiceAction(4, bundle);
    }

    public String unRevine(String s, co.vine.android.client.Session session, long l, long l1, boolean flag, 
            long l2, boolean flag1)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        session.putLong("repost_id", l1);
        session.putBoolean("notify", flag1);
        session.putBoolean("following", flag);
        FlurryUtils.trackUnRevine(s);
        return executeServiceAction(55, session);
    }

    public String unblockUser(long l)
    {
        Bundle bundle = createServiceBundle();
        bundle.putLong("user_id", getActiveId());
        bundle.putLong("block_user_id", l);
        return executeServiceAction(48, bundle);
    }

    public String unfollowUser(co.vine.android.client.Session session, long l, boolean flag)
    {
        return unfollowUser(session, l, flag, -1L);
    }

    public String unfollowUser(co.vine.android.client.Session session, long l, boolean flag, long l1)
    {
        session = createServiceBundle(session);
        session.putLong("follow_id", l);
        session.putLong("profile_id", l1);
        session.putLong("user_id", getActiveId());
        session.putBoolean("notify", flag);
        return executeServiceAction(19, session);
    }

    public String unlikePost(String s, co.vine.android.client.Session session, long l, boolean flag)
    {
        session = createServiceBundle(session);
        session.putLong("post_id", l);
        session.putBoolean("notify", flag);
        FlurryUtils.trackUnLikePost(s);
        return executeServiceAction(25, session);
    }

    public String updateAcceptOon(boolean flag)
    {
        Bundle bundle = createServiceBundle();
        bundle.putBoolean("accept_oon", flag);
        return executeServiceAction(105, bundle);
    }

    public String updateClientProfile()
    {
        SLog.d("Update Client Profile.");
        return executeServiceAction(35, new Bundle());
    }

    public void updateCredentials(String s)
    {
        getActiveSession().setSessionKey(s);
    }

    public String updateDiscoverability(int i, boolean flag)
    {
        Bundle bundle = createServiceBundle();
        bundle.putBoolean("enable", flag);
        bundle.putInt("type", i);
        return executeServiceAction(108, bundle);
    }

    public String updateEdition(co.vine.android.client.Session session, String s)
    {
        session = createServiceBundle(session);
        session.putString("edition", s);
        SLog.d("Updating edition code to {}", s);
        return executeServiceAction(71, session);
    }

    public String updateEnableAddressBook(boolean flag)
    {
        Bundle bundle = createServiceBundle();
        bundle.putBoolean("enable", flag);
        return executeServiceAction(106, bundle);
    }

    public String updateExplicit(co.vine.android.client.Session session, boolean flag)
    {
        session = createServiceBundle(session);
        session.putBoolean("explicit", flag);
        return executeServiceAction(51, session);
    }

    public String updatePrivate(co.vine.android.client.Session session, boolean flag)
    {
        session = createServiceBundle(session);
        session.putBoolean("priv", flag);
        return executeServiceAction(52, session);
    }

    public String updateProfile(co.vine.android.client.Session session, String s, String s1, String s2, String s3, String s4, Uri uri, 
            int i)
    {
        session = createServiceBundle(session);
        session.putString("a_name", s);
        session.putString("desc", Util.cleanse(s1));
        session.putString("location", Util.cleanse(s2));
        session.putString("email", s3);
        session.putString("phone", s4);
        session.putInt("color_int", i);
        if (uri != null)
        {
            session.putParcelable("uri", uri);
        }
        return executeServiceAction(26, session);
    }

    public String updateProfilePhoto(co.vine.android.client.Session session, Uri uri)
    {
        session = createServiceBundle(session);
        session.putParcelable("uri", uri);
        return executeServiceAction(88, session);
    }

    public String verifyEmail(co.vine.android.client.Session session, String s)
    {
        session = createServiceBundle(session);
        session.putString("key", s);
        return executeServiceAction(109, session);
    }

    public String verifyPhoneNumber(co.vine.android.client.Session session, String s)
    {
        session = createServiceBundle(session);
        session.putString("key", s);
        return executeServiceAction(90, session);
    }

    static 
    {
        boolean flag;
        if (Build.MODEL.length() == "SM-C115".length() && Build.MODEL.contains("SM-C11"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SINGLE_FACEBOOK_DIALOG = flag;
        INVALIDATE_CACHE_FILTER = new IntentFilter();
        INVALIDATE_CACHE_FILTER.addAction("co.vine.android.invalidateCache");
        if (SLog.sLogsOn)
        {
            RecordConfigUtils.FOLDER_ROOT_DIRECT_UPLOAD.mkdirs();
            SaveVideoClicker.setLongPressSaveDir(RecordConfigUtils.FOLDER_ROOT_DIRECT_UPLOAD);
        }
    }
}

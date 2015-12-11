// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import co.vine.android.AppImpl;
import co.vine.android.StartActivity;
import co.vine.android.api.ServerStatus;
import co.vine.android.api.TwitterUser;
import co.vine.android.api.VineActivityCounts;
import co.vine.android.api.VineClientFlags;
import co.vine.android.api.VineComment;
import co.vine.android.api.VineConversation;
import co.vine.android.api.VineEntity;
import co.vine.android.api.VineError;
import co.vine.android.api.VineLike;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VineLoopSubmissionResponse;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VineParserReader;
import co.vine.android.api.VineParsers;
import co.vine.android.api.VinePost;
import co.vine.android.api.VinePostResponse;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.api.VinePrivateMessagePostResponseWithUsers;
import co.vine.android.api.VinePrivateMessageResponse;
import co.vine.android.api.VineRecipient;
import co.vine.android.api.VineRepost;
import co.vine.android.api.VineSingleNotification;
import co.vine.android.api.VineTag;
import co.vine.android.api.VineTypeAhead;
import co.vine.android.api.VineUpload;
import co.vine.android.api.VineUser;
import co.vine.android.client.Amazon;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.client.TwitterVineApp;
import co.vine.android.client.VineAPI;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.network.HttpOperation;
import co.vine.android.network.ThreadedHttpOperationClient;
import co.vine.android.provider.Vine;
import co.vine.android.provider.VineDatabaseHelper;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.CrossAnalytics;
import co.vine.android.util.DateTimeUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.LongSparseArray;
import co.vine.android.util.MediaUtility;
import co.vine.android.util.SMSUtil;
import co.vine.android.util.StringAnchorManager;
import co.vine.android.util.UploadManager;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.video.VideoKey;
import com.edisonwang.android.slog.SLog;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.VineTwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.BasicAuthorization;
import twitter4j.conf.ConfigurationBuilder;

// Referenced classes of package co.vine.android.service:
//            VineUploadService, VineServiceCallback, VineServiceResponder

public class VineService extends Service
{
    private class ExecutionRunnable
        implements Runnable
    {

        private final int mActionCode;
        private final Bundle mBundle;
        private final Messenger mMessenger;
        private final VineServiceResponder mResponder;
        private final int mStartId;
        final VineService this$0;

        public void run()
        {
            Object obj;
            Process.setThreadPriority(10);
            obj = executeAction(mActionCode, mBundle);
            ((Bundle) (obj)).getInt("executionCode");
            JVM INSTR tableswitch 2 4: default 52
        //                       2 120
        //                       3 371
        //                       4 348;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_371;
_L6:
            int i = ((Bundle) (obj)).getInt("statusCode");
            obj = ((Bundle) (obj)).getString("reasonPhrase");
            Bundle bundle;
            if (mResponder != null)
            {
                obj = new ResponderRunnable(mResponder, mActionCode, i, ((String) (obj)), mBundle, mStartId);
            } else
            if (mMessenger != null)
            {
                obj = new MessengerResponderRunnable(mMessenger, mActionCode, i, ((String) (obj)), mBundle, mStartId);
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                mMainHandler.post(((Runnable) (obj)));
            }
            return;
_L2:
            SLog.d("Session key was invalid. Refreshing session key and then will try again");
            obj = executeAction(1000, mBundle);
            switch (((Bundle) (obj)).getInt("executionCode"))
            {
            default:
                SLog.d((new StringBuilder()).append("Session key successfully refreshed. Trying original action of ").append(mActionCode).append(" again").toString());
                bundle = executeAction(mActionCode, mBundle);
                switch (bundle.getInt("executionCode"))
                {
                default:
                    obj = bundle;
                    if (VineService.LOGGABLE)
                    {
                        mBundle.putBoolean("refresh_session", true);
                        SLog.d("Session key refresh and retry complete.");
                        obj = bundle;
                    }
                    break;

                case 2: // '\002'
                    SLog.d("Session key is still invalid. Aborting.");
                    mBundle.putBoolean("logged_out", true);
                    obj = bundle;
                    break;

                case 3: // '\003'
                    SLog.d("Session was logged out.");
                    mBundle.putBoolean("logged_out", true);
                    obj = bundle;
                    break;
                }
                break;

            case 2: // '\002'
                SLog.d("Session key could not be refreshed. Aborting.");
                mBundle.putBoolean("logged_out", true);
                break;

            case 3: // '\003'
                SLog.d("Session was logged out.");
                mBundle.putBoolean("logged_out", true);
                break;
            }
            if (true) goto _L6; else goto _L5
_L5:
_L4:
            SLog.d("Captcha triggered");
            mBundle.putString("captcha_url", ((Bundle) (obj)).getString("captcha_url"));
              goto _L6
            SLog.d("Session was logged out.");
            mBundle.putBoolean("logged_out", true);
              goto _L6
        }

        public ExecutionRunnable(int i, int j, Bundle bundle, VineServiceResponder vineserviceresponder, Messenger messenger)
        {
            this$0 = VineService.this;
            super();
            mStartId = i;
            mActionCode = j;
            mBundle = bundle;
            mResponder = vineserviceresponder;
            mMessenger = messenger;
        }
    }

    private class MessengerResponderRunnable
        implements Runnable
    {

        private final int mActionCode;
        private final Bundle mBundle;
        private final String mReasonPhrase;
        private final Messenger mResponder;
        private final int mStartId;
        private final int mStatusCode;
        final VineService this$0;

        public void run()
        {
            if (mResponder != null)
            {
                Message message = new Message();
                message.what = mActionCode;
                message.arg1 = mStatusCode;
                Bundle bundle = message.getData();
                bundle.putString("reason_phrase", mReasonPhrase);
                bundle.putAll(mBundle);
                try
                {
                    mResponder.send(message);
                }
                catch (Exception exception)
                {
                    CrashUtil.logException(exception, "Error sending service response", new Object[0]);
                }
            }
            if (mStartId > 0)
            {
                attemptStop(mStartId);
            }
        }

        public MessengerResponderRunnable(Messenger messenger, int i, int j, String s, Bundle bundle, int k)
        {
            this$0 = VineService.this;
            super();
            mResponder = messenger;
            mActionCode = i;
            mStatusCode = j;
            mReasonPhrase = s;
            mBundle = bundle;
            mStartId = k;
        }
    }

    private class ResponderRunnable
        implements Runnable
    {

        private final int mActionCode;
        private final Bundle mBundle;
        private final String mReasonPhrase;
        private final VineServiceResponder mResponder;
        private final int mStartId;
        private final int mStatusCode;
        final VineService this$0;

        public void run()
        {
            if (mResponder != null)
            {
                mResponder.onServiceResponse(mActionCode, mStatusCode, mReasonPhrase, mBundle);
            }
            if (mStartId > 0)
            {
                attemptStop(mStartId);
            }
        }

        public ResponderRunnable(VineServiceResponder vineserviceresponder, int i, int j, String s, Bundle bundle, int k)
        {
            this$0 = VineService.this;
            super();
            mResponder = vineserviceresponder;
            mActionCode = i;
            mStatusCode = j;
            mReasonPhrase = s;
            mBundle = bundle;
            mStartId = k;
        }
    }

    class VineServiceHandler extends Handler
    {

        final VineService this$0;

        public void handleMessage(Message message)
        {
            message.getData().setClassLoader(getClassLoader());
            mExecutor.execute(new ExecutionRunnable(0, message.arg1, message.getData(), null, message.replyTo));
        }

        VineServiceHandler()
        {
            this$0 = VineService.this;
            super();
        }
    }


    public static final int ACTION_CODE_ABORT_ALL_REQUESTS = 112;
    public static final int ACTION_CODE_BLOCK_USER = 47;
    public static final int ACTION_CODE_BULK_FOLLOW = 107;
    public static final int ACTION_CODE_CHECK_LOGIN_TWITTER = 6;
    public static final int ACTION_CODE_CLEANUP = 29;
    public static final int ACTION_CODE_CLEAR_DB_ALL = 59;
    public static final int ACTION_CODE_CLEAR_DB_CACHE = 58;
    public static final int ACTION_CODE_CLEAR_GCM_REG_ID = 61;
    public static final int ACTION_CODE_CLEAR_INBOX_PAGE_CURSORS = 104;
    public static final int ACTION_CODE_CLEAR_NOTIFICATION = 102;
    public static final int ACTION_CODE_CLEAR_UNREAD_COUNT = 94;
    public static final int ACTION_CODE_CLIENT_PROFILE = 35;
    public static final int ACTION_CODE_CONNECT_TWITTER = 32;
    public static final int ACTION_CODE_DEACTIVATE_ACCOUNT = 67;
    public static final int ACTION_CODE_DELETE_COMMENT = 30;
    public static final int ACTION_CODE_DELETE_CONVERSATION = 80;
    public static final int ACTION_CODE_DELETE_MESSAGE = 95;
    public static final int ACTION_CODE_DELETE_POST = 31;
    public static final int ACTION_CODE_DELETE_PUSH_NOTIFICATIONS = 62;
    public static final int ACTION_CODE_DELETE_SESSION = 64;
    public static final int ACTION_CODE_DISABLE_USER_REPOSTS = 69;
    public static final int ACTION_CODE_DISCONNECT_TWITTER = 33;
    public static final int ACTION_CODE_ENABLE_USER_REPOSTS = 68;
    public static final int ACTION_CODE_EXPIRE_TIMELINE = 45;
    public static final int ACTION_CODE_FETCH_CLIENT_FLAGS = 111;
    public static final int ACTION_CODE_FETCH_FRIENDS_TYPEAHEAD = 99;
    public static final int ACTION_CODE_FETCH_SERVER_STATUS = 38;
    public static final int ACTION_CODE_FETCH_USERS_TYPEAHEAD = 39;
    public static final int ACTION_CODE_FOLLOW = 18;
    public static final int ACTION_CODE_FOLLOW_EDITORS_PICKS = 44;
    public static final int ACTION_CODE_GET_ACTIVITY = 20;
    public static final int ACTION_CODE_GET_ACTIVITY_COUNTS = 81;
    public static final int ACTION_CODE_GET_ADDRESS_FRIENDS = 16;
    public static final int ACTION_CODE_GET_BLOCKED_USERS = 46;
    public static final int ACTION_CODE_GET_CHANNELS = 53;
    public static final int ACTION_CODE_GET_COMMENTS = 12;
    public static final int ACTION_CODE_GET_CONVERSATION = 76;
    public static final int ACTION_CODE_GET_CONVERSATION_REMOTE_ID = 77;
    public static final int ACTION_CODE_GET_CONVERSATION_ROW_ID_FROM_SINGLE_RECIPIENT = 91;
    public static final int ACTION_CODE_GET_EDITIONS = 70;
    public static final int ACTION_CODE_GET_FOLLOWERS = 22;
    public static final int ACTION_CODE_GET_FOLLOWING = 23;
    public static final int ACTION_CODE_GET_FRIENDS = 82;
    public static final int ACTION_CODE_GET_INBOX = 74;
    public static final int ACTION_CODE_GET_NOTIFICATION_SETTINGS = 113;
    public static final int ACTION_CODE_GET_NOTIFICATION_USERS = 110;
    public static final int ACTION_CODE_GET_NOTIF_COUNT = 65;
    public static final int ACTION_CODE_GET_POSTS = 13;
    public static final int ACTION_CODE_GET_POST_ID = 36;
    public static final int ACTION_CODE_GET_POST_LIKERS = 11;
    public static final int ACTION_CODE_GET_POST_SINGLE = 28;
    public static final int ACTION_CODE_GET_REVINERS = 56;
    public static final int ACTION_CODE_GET_TAGS_TYPEAHEAD = 40;
    public static final int ACTION_CODE_GET_TWITTER_AUTH = 5;
    public static final int ACTION_CODE_GET_TWITTER_FRIENDS = 15;
    public static final int ACTION_CODE_GET_TWITTER_USER = 7;
    public static final int ACTION_CODE_GET_USER = 21;
    public static final int ACTION_CODE_GET_USERS_ME = 10;
    public static final int ACTION_CODE_GET_USER_ID = 86;
    public static final int ACTION_CODE_IGNORE_CONVERSATION = 79;
    public static final int ACTION_CODE_LIKE_POST = 24;
    public static final int ACTION_CODE_LOGIN = 2;
    public static final int ACTION_CODE_LOGOUT = 3;
    public static final int ACTION_CODE_MARK_MESSAGE_UPLOAD_FAILED = 100;
    public static final int ACTION_CODE_MERGE_PUSH_NOTIFICATION = 97;
    public static final int ACTION_CODE_MERGE_SINGLE_POST = 57;
    public static final int ACTION_CODE_MESSAGE_LOOP_VIEWED = 84;
    public static final int ACTION_CODE_MESSAGE_LOOP_VIEWED_BATCH = 85;
    public static final int ACTION_CODE_POST = 98;
    public static final int ACTION_CODE_POST_COMMENT = 14;
    public static final int ACTION_CODE_PRE_MERGE_MESSAGE = 93;
    public static final int ACTION_CODE_REFRESH_SESSION_KEY = 1000;
    public static final int ACTION_CODE_REMOVE_ACCOUNT = 115;
    public static final int ACTION_CODE_REMOVE_FOLLOW_POSTS = 34;
    public static final int ACTION_CODE_REMOVE_USERS_BY_GROUP = 17;
    public static final int ACTION_CODE_REPORT_POST = 27;
    public static final int ACTION_CODE_REPORT_USER = 49;
    public static final int ACTION_CODE_REQUEST_EMAIL_VERIFICATION = 92;
    public static final int ACTION_CODE_REQUEST_PHONE_VERIFICATION = 89;
    public static final int ACTION_CODE_RESET_PASSWORD = 9;
    public static final int ACTION_CODE_RESPOND_FOLLOW_REQUEST = 50;
    public static final int ACTION_CODE_RESTART_CONNECTION_MANAGER = 1;
    public static final int ACTION_CODE_RETRY_ALL_IN_CONVERSATION = 103;
    public static final int ACTION_CODE_REVINE = 54;
    public static final int ACTION_CODE_SAVE_NOTIFICATION_SETTINGS = 114;
    public static final int ACTION_CODE_SAVE_POSTS = 43;
    public static final int ACTION_CODE_SEARCH_TAGS = 42;
    public static final int ACTION_CODE_SEARCH_USERS = 41;
    public static final int ACTION_CODE_SEND_ADDRESS_BOOK = 101;
    public static final int ACTION_CODE_SEND_FACEBOOK_TOKEN = 37;
    public static final int ACTION_CODE_SEND_GCM_REG_ID = 60;
    public static final int ACTION_CODE_SEND_LOOP_COUNTS = 66;
    public static final int ACTION_CODE_SET_BLOCK_PROFILE_REPOSTS = 87;
    public static final int ACTION_CODE_SHARE_AS_VM = 96;
    public static final int ACTION_CODE_SHARE_POST = 63;
    public static final int ACTION_CODE_SIGNUP = 4;
    public static final int ACTION_CODE_TWITTER_XAUTH = 8;
    public static final int ACTION_CODE_UNBLOCK_USER = 48;
    public static final int ACTION_CODE_UNFOLLOW = 19;
    public static final int ACTION_CODE_UNLIKE_POST = 25;
    public static final int ACTION_CODE_UNREVINE = 55;
    public static final int ACTION_CODE_UPDATE_ACCEPT_OON = 105;
    public static final int ACTION_CODE_UPDATE_DISCOVERABILITY = 108;
    public static final int ACTION_CODE_UPDATE_EDITION = 71;
    public static final int ACTION_CODE_UPDATE_ENABLE_ADDRESS_BOOK = 106;
    public static final int ACTION_CODE_UPDATE_EXPLICIT = 51;
    public static final int ACTION_CODE_UPDATE_PRIVATE = 52;
    public static final int ACTION_CODE_UPDATE_PROFILE = 26;
    public static final int ACTION_CODE_UPDATE_PROFILE_PHOTO = 88;
    public static final int ACTION_CODE_VERIFY_EMAIL = 109;
    public static final int ACTION_CODE_VERIFY_PHONE_NUMBER = 90;
    public static final String ACTION_LOGIN = "LOGIN";
    public static final String ACTION_PROFILE_COLOR_CHANGED = "co.vine.android.profileColor";
    public static final String ACTION_RESTART_CONNECTION_MANAGER = "RESTART_CM";
    public static final String ACTION_SESSION_LOGIN = "co.vine.android.session.login";
    public static final String ACTION_SESSION_LOGOUT = "co.vine.android.session.logout";
    public static final int AMAZON_ERROR_CODE = 900;
    private static final String BADGER_ARGS[] = {
        "co.vine.android"
    };
    private static final String BADGER_SELECTION = "package=?";
    private static final String BADGE_COUNT = "badgecount";
    public static final String BC_ACTION_ALERT_RTC_NEW_MESSAGE = "co.vine.android.service.mergeSelfNewMessage";
    public static final String BC_ACTION_FETCH_AND_MERGE_POST = "co.vine.android.service.mergePost";
    public static final String BC_ACTION_MERGE_POST_INTO_FEED = "co.vine.android.service.mergePostFeed";
    public static final String BC_ACTIVITY_COUNTS = "co.vine.android.service.activityCounts";
    private static final String CLASS = "class";
    public static final int ERROR_CODE_UNKNOWN = -1;
    public static final int ERROR_CODE_UPLOAD_FAILED = -2;
    private static final int EXECUTION_CAPTCHA_REQUIRED = 4;
    private static final String EXECUTION_CODE = "executionCode";
    private static final int EXECUTION_COMPLETE = 1;
    private static final int EXECUTION_LOGGED_OUT = 3;
    private static final int EXECUTION_SESSION_KEY_INVALID = 2;
    public static final String EXTRA_ABORT_REQUESTS = "abort_requests";
    public static final String EXTRA_ACCEPT = "accept";
    public static final String EXTRA_ACCEPT_OON = "accept_oon";
    public static final String EXTRA_ACCOUNT_EXISTS = "a_exists";
    public static final String EXTRA_ACCOUNT_NAME = "a_name";
    public static final String EXTRA_ACTION_CODE = "action_code";
    public static final String EXTRA_ALSO_FETCH_POSTS = "also_fetch_posts";
    public static final String EXTRA_AM_FOLLOWING = "am_following";
    public static final String EXTRA_ANCHOR = "time";
    public static final String EXTRA_AVATAR_URL = "avatar_url";
    public static final String EXTRA_BLOCKED_USERS = "blocked_users";
    public static final String EXTRA_BLOCK_USER_ID = "block_user_id";
    public static final String EXTRA_CALLBACK = "ibinder";
    public static final String EXTRA_CAPTCHA_URL = "captcha_url";
    public static final String EXTRA_CHANNELS = "channels";
    public static final String EXTRA_CLEAR = "clear";
    public static final String EXTRA_CLIENT_FLAGS = "client_flags";
    public static final String EXTRA_COLOR_INT = "color_int";
    public static final String EXTRA_COMMENT = "comment";
    public static final String EXTRA_COMMENTS = "comments";
    public static final String EXTRA_COMMENT_ID = "comment_id";
    public static final String EXTRA_COMMENT_OBJ = "comment_obj";
    public static final String EXTRA_CONVERSATION_ID = "conversation_id";
    public static final String EXTRA_CONVERSATION_ROW_ID = "conversation_row_id";
    public static final String EXTRA_COUNT = "count";
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_DESCRIPTION = "desc";
    public static final String EXTRA_DIRECT_USER_ID = "direct_user_id";
    public static final String EXTRA_EDITIONS_LIST = "editions";
    public static final String EXTRA_EDITION_CODE = "edition";
    public static final String EXTRA_EMAIL = "email";
    public static final String EXTRA_EMPTY = "empty";
    public static final String EXTRA_ENABLE = "enable";
    public static final String EXTRA_ENTITIES = "entities";
    public static final String EXTRA_ERROR_CODE = "error_code";
    public static final String EXTRA_EXPLICIT = "explicit";
    public static final String EXTRA_FACEBOOK_TOKEN = "facebook_token";
    public static final String EXTRA_FOLLOWING = "following";
    public static final String EXTRA_FOLLOW_ID = "follow_id";
    public static final String EXTRA_FOLLOW_IDS = "follow_ids";
    public static final String EXTRA_FOLLOW_REQUESTS = "follow_requests";
    public static final String EXTRA_FOLLOW_REQUEST_COUNT = "follow_reqs_c";
    public static final String EXTRA_GCM_REG_ID = "gcmRegId";
    public static final String EXTRA_GET_FOLLOW_REQUESTS = "follow_reqs";
    public static final String EXTRA_HIDE_PROFILE_REPOSTS = "block_profile_reposts";
    public static final String EXTRA_HIDE_REPOSTS = "hide_reposts";
    public static final String EXTRA_IN_MEMORY = "in_memory";
    public static final String EXTRA_KEEP_UPLOAD = "should_delete_upload";
    public static final String EXTRA_KEY = "key";
    public static final String EXTRA_LOAD_URL = "load_url";
    public static final String EXTRA_LOCATION = "location";
    public static final String EXTRA_LOGGED_OUT = "logged_out";
    public static final String EXTRA_LOGIN = "login";
    public static final String EXTRA_LOOPS = "loops";
    public static final String EXTRA_LOOP_SUBMISSION_RESULT = "loop_submission";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_MESSAGES_COUNT = "messages_count";
    public static final String EXTRA_MESSAGE_ID = "message_id";
    public static final String EXTRA_NETWORK = "network";
    public static final String EXTRA_NEXT_PAGE = "next_page";
    public static final String EXTRA_NOTIFICATION = "notification";
    public static final String EXTRA_NOTIFICATIONS = "notifications";
    public static final String EXTRA_NOTIFICATIONS_COUNT = "notifications_count";
    public static final String EXTRA_NOTIFICATION_DISPLAY_ID = "notification_display_id";
    public static final String EXTRA_NOTIFICATION_ID = "notification_id";
    public static final String EXTRA_NOTIFICATION_SETTINGS = "notificationSettings";
    public static final String EXTRA_NOTIFY = "notify";
    public static final String EXTRA_PAGE = "page";
    public static final String EXTRA_PAGE_TYPE = "page_type";
    public static final String EXTRA_PASSWORD = "pass";
    public static final String EXTRA_PHONE = "phone";
    public static final String EXTRA_POST = "post";
    public static final String EXTRA_POSTS = "posts";
    public static final String EXTRA_POST_ID = "post_id";
    public static final String EXTRA_POST_SHARE_ID = "post_share_id";
    public static final String EXTRA_PREFETCH = "prefetch";
    public static final String EXTRA_PREMERGED_MESSAGE_ID = "premerged_message_id";
    public static final String EXTRA_PREVIOUS_PAGE = "previous_page";
    public static final String EXTRA_PRIVATE = "priv";
    public static final String EXTRA_PROFILE_ID = "profile_id";
    public static final String EXTRA_QUERY = "q";
    public static final String EXTRA_REACTIVATE = "reactivate";
    public static final String EXTRA_REASON_PHRASE = "reason_phrase";
    public static final String EXTRA_RECIPIENT = "recipient";
    public static final String EXTRA_RECIPIENTS = "recipients";
    public static final String EXTRA_RECIPIENT_ID = "recipient_id";
    public static final String EXTRA_REFRESH_SESSION = "refresh_session";
    public static final String EXTRA_REPOST = "repost";
    public static final String EXTRA_REPOST_ID = "repost_id";
    public static final String EXTRA_REQUEST_ID = "rid";
    public static final String EXTRA_RESPONSE_CODE = "resp_code";
    public static final String EXTRA_RESPONSE_SUCCESS = "response_success";
    public static final String EXTRA_SECRET = "secret";
    public static final String EXTRA_SERVER_STATUS = "server_status";
    public static final String EXTRA_SESSION_KEY = "s_key";
    public static final String EXTRA_SESSION_OWNER_ID = "s_owner_id";
    public static final String EXTRA_SHOULD_FOLLOW_EDITORS_PICKS = "should_follow_editors_picks";
    public static final String EXTRA_SIZE = "size";
    public static final String EXTRA_SORT = "sort";
    public static final String EXTRA_TAGS = "tags";
    public static final String EXTRA_TAG_NAME = "tag_name";
    public static final String EXTRA_THUMBNAIL_URL = "thumbnail_url";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_TWITTER_ID = "t_id";
    public static final String EXTRA_TWITTER_USER = "t_user";
    public static final String EXTRA_TYPE = "type";
    public static final String EXTRA_UPLOAD = "upload";
    public static final String EXTRA_UPLOAD_PATH = "upload_path";
    public static final String EXTRA_URI = "uri";
    public static final String EXTRA_USER = "user";
    public static final String EXTRA_USERNAME = "username";
    public static final String EXTRA_USERS = "users";
    public static final String EXTRA_USER_ID = "user_id";
    public static final String EXTRA_USER_INITIATED = "user_init";
    public static final String EXTRA_VANITY_URL = "vanity_url";
    public static final String EXTRA_VIDEO_URL = "post_url";
    private static final boolean LOGGABLE;
    private static final String PACKAGE = "package";
    private static final int PAGE_SIZE_SEARCH = 50;
    private static final String PARAM_ACCEPTS_OUT_OF_NETWORK_CONVERSATIONS = "acceptsOutOfNetworkConversations";
    private static final String PARAM_ADDRESS_BOOK = "addressBook";
    private static final String PARAM_ANCHOR = "anchor";
    private static final String PARAM_AUTHENTICATE = "authenticate";
    private static final String PARAM_AVATAR = "avatarUrl";
    private static final String PARAM_COLOR = "profileBackground";
    private static final String PARAM_COMMENT_MAX = "c_max";
    private static final String PARAM_COMMENT_OVERFLOW = "c_overflow";
    private static final String PARAM_CREATED = "created";
    private static final String PARAM_DATE = "date";
    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_DEVICE_TOKEN = "deviceToken";
    private static final String PARAM_DISABLE_ADDRESS_BOOK = "disableAddressBook";
    private static final String PARAM_EDITION = "edition";
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_FACEBOOK_AUTH_TOKEN = "facebookOauthToken";
    private static final String PARAM_HIDDEN_EMAIL = "hiddenEmail";
    private static final String PARAM_HIDDEN_PHONE_NUMBER = "hiddenPhoneNumber";
    private static final String PARAM_INBOX = "inbox";
    private static final String PARAM_INCLUDE_PROMOTED = "includePromoted";
    private static final String PARAM_LAST_MESSAGE_ID = "lastMessageId";
    private static final String PARAM_LIKE_MAX = "l_max";
    private static final String PARAM_LOCALE = "locale";
    private static final String PARAM_LOCATION = "location";
    private static final String PARAM_MESSAGE = "message";
    private static final String PARAM_NAME = "username";
    private static final String PARAM_PAGE = "page";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_PHONE = "phoneNumber";
    private static final String PARAM_PREFETCH = "prefetch";
    private static final String PARAM_PREINSTALL_TARGET = "preinstallTarget";
    private static final String PARAM_REPOSTS = "reposts";
    private static final String PARAM_SEARCH_TERM = "st";
    private static final String PARAM_SIZE = "size";
    private static final String PARAM_TWITTER_ID = "twitterId";
    private static final String PARAM_TWITTER_SECRET = "twitterOauthSecret";
    private static final String PARAM_TWITTER_TOKEN = "twitterOauthToken";
    private static final String PARAM_USERNAME = "username";
    private static final String PARAM_USER_IDS = "userIds[]";
    private static final String PARAM_VERIFY_EMAIL = "verifyEmail";
    private static final String PARAM_VERIFY_PHONE_NUMBER = "verifyPhoneNumber";
    private static final String PARAM_WITH_FAVORITES = "withFavorites";
    private static final String REASON_PHRASE = "reasonPhrase";
    private static final Uri SAMSUNG_BADGER_URI = Uri.parse("content://com.sec.badge/apps");
    public static final IntentFilter SERVICE_INTENT_FILTER = new IntentFilter("co.vine.android.service.mergePost");
    public static final IntentFilter SHOW_POST_FILTER = new IntentFilter("co.vine.android.service.mergePostFeed");
    private static final String START_CLASS_NAME = co/vine/android/StartActivity.getCanonicalName();
    private static final String STATUS_CODE = "statusCode";
    private static final String TAG = "VineService";
    private static final HashMap sActionMap;
    private String mAmazonBucket;
    private VineAPI mApi;
    private ExecutorService mExecutor;
    private final ConcurrentHashMap mHttpRequests = new ConcurrentHashMap();
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private MediaUtility mMediaUtility;
    private final Messenger mMessenger = new Messenger(new VineServiceHandler());
    private final BroadcastReceiver mServiceBroadCastReceiver = new BroadcastReceiver() {

        final VineService this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (intent != null && "co.vine.android.service.mergePost".equals(intent.getAction()))
            {
                SLog.d("Received broadcasted intent to merge a single post.");
                AppController.getInstance(VineService.this).mergeSinglePost(intent.getExtras());
            }
        }

            
            {
                this$0 = VineService.this;
                super();
            }
    };
    private LinkedHashMap mStartIds;

    public VineService()
    {
    }

    private HttpOperation deleteComment(long l, String s, VineDatabaseHelper vinedatabasehelper)
    {
        s = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l), "comments", s
        });
        vinedatabasehelper = VineParserReader.createParserReader(7);
        return HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), s, mApi, vinedatabasehelper).execute();
    }

    private HttpOperation getClientProfile()
    {
        Object obj1 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "clientprofiles"
        });
        SLog.w("Updating device profile for {} {} {}.", new Object[] {
            Build.MODEL, Build.DEVICE, Integer.valueOf(android.os.Build.VERSION.SDK_INT)
        });
        VineAPI.addParam(((StringBuilder) (obj1)), "model", Build.MODEL);
        VineAPI.addParam(((StringBuilder) (obj1)), "device", Build.DEVICE);
        VineAPI.addParam(((StringBuilder) (obj1)), "sdkVersion", android.os.Build.VERSION.SDK_INT);
        VineAPI.addParam(((StringBuilder) (obj1)), "memory", ((ActivityManager)getSystemService("activity")).getLargeMemoryClass());
        Object obj = VineParserReader.createParserReader(13);
        obj1 = HttpOperation.createGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj1)), ((co.vine.android.network.HttpOperationReader) (obj)), mApi);
        if (((HttpOperation) (obj1)).isOK())
        {
            obj = (JSONObject)((VineParserReader) (obj)).getParsedObject();
            if (obj != null)
            {
                SLog.d("Got client profile {}.", obj);
                AppImpl.getInstance().updateRecordConfigs(getApplicationContext(), ((JSONObject) (obj)));
                return ((HttpOperation) (obj1));
            } else
            {
                SLog.d("Error getting client profile.");
                return ((HttpOperation) (obj1));
            }
        }
        int i;
        if (obj1 != null)
        {
            i = ((HttpOperation) (obj1)).statusCode;
        } else
        {
            i = 0;
        }
        SLog.d("Failed to update client profile: {}.", Integer.valueOf(i));
        return ((HttpOperation) (obj1));
    }

    private HttpOperation getComments(long l, int i, long l1, int j, String s, 
            Bundle bundle, VineDatabaseHelper vinedatabasehelper)
    {
        vinedatabasehelper = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l), "comments"
        });
        VineAPI.addParam(vinedatabasehelper, "page", i);
        if (l1 > 0L)
        {
            VineAPI.addParam(vinedatabasehelper, "anchor", l1);
        }
        VineAPI.addParam(vinedatabasehelper, "size", j);
        s = VineParserReader.createParserReader(6);
        vinedatabasehelper = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), vinedatabasehelper, mApi, s).execute();
        if (vinedatabasehelper.isOK())
        {
            s = (VinePagedData)s.getParsedObject();
            bundle.putInt("next_page", ((VinePagedData) (s)).nextPage);
            bundle.putLong("time", ((VinePagedData) (s)).anchor);
            bundle.putInt("previous_page", ((VinePagedData) (s)).previousPage);
            bundle.putParcelableArrayList("comments", ((VinePagedData) (s)).items);
        }
        return vinedatabasehelper;
    }

    private VineConversation getConversationWithRemoteId(long l, long l1, int i, VineDatabaseHelper vinedatabasehelper, boolean flag, 
            int j)
    {
        Object obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "conversations", Long.valueOf(l1)
        });
        i;
        JVM INSTR tableswitch 1 3: default 56
    //                   1 216
    //                   2 216
    //                   3 228;
           goto _L1 _L2 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_228;
_L4:
        Object obj1;
        long l2;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        VineAPI.addParam(((StringBuilder) (obj)), "prefetch", i);
        obj1 = VineParserReader.createParserReader(22);
        if (!HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj1))).execute().isOK())
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj = (co.vine.android.api.VineParsers.VinePagedConversation)((VineParserReader) (obj1)).getParsedObject();
        if (obj == null || ((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).items == null || ((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).items.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj1 = new VineConversation(l1, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).lastMessage, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).items, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).unreadMessageCount);
        l = vinedatabasehelper.mergeConversation(l, ((VineConversation) (obj1)), j, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).nextPage, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).previousPage, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).anchor);
        if (((co.vine.android.api.VineParsers.VinePagedConversation) (obj)).nextPage <= 0)
        {
            vinedatabasehelper.markLastMessage(l);
        }
        obj1.conversationObjectId = l;
        return ((VineConversation) (obj1));
_L2:
        VineAPI.addParam(((StringBuilder) (obj)), "page", 1);
          goto _L4
        l2 = vinedatabasehelper.getNextPageCursor(7, 0, String.valueOf(l1), false);
        if (l2 > 0L)
        {
            VineAPI.addParam(((StringBuilder) (obj)), "page", l2);
        }
          goto _L4
        vinedatabasehelper;
        if (LOGGABLE)
        {
            vinedatabasehelper.printStackTrace();
        }
        return null;
    }

    private HttpOperation getInbox(long l, int i, int j, String s, VineDatabaseHelper vinedatabasehelper, Bundle bundle)
        throws IOException
    {
        int i1;
        i1 = bundle.getInt("network", -1);
        j = 1;
        i;
        JVM INSTR tableswitch 1 3: default 40
    //                   1 82
    //                   2 82
    //                   3 87;
           goto _L1 _L2 _L2 _L3
_L1:
        i = j;
_L5:
        StringBuilder stringbuilder;
        stringbuilder = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "conversations"
        });
        if (i1 == -1)
        {
            throw new IllegalArgumentException("Invalid network type.");
        }
        break; /* Loop/switch isn't completed */
_L2:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        int k = vinedatabasehelper.getPreviousPageCursor(6, i1, null, true);
        i = j;
        if (k > 0)
        {
            i = k;
        }
        if (true) goto _L5; else goto _L4
_L4:
        Object obj = VineParserReader.createParserReader(25);
        if (1 == i1)
        {
            j = 10;
        } else
        {
            VineAPI.addParam(stringbuilder, "inbox", "other");
            j = 11;
        }
        VineAPI.addParam(stringbuilder, "page", i);
        VineAPI.addParam(stringbuilder, "size", 10);
        s = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), stringbuilder, mApi, ((co.vine.android.network.HttpOperationReader) (obj)), s).execute();
        if (s.isOK())
        {
            obj = (co.vine.android.api.VineParsers.VinePagedInbox)((VineParserReader) (obj)).getParsedObject();
            if (((co.vine.android.api.VineParsers.VinePagedInbox) (obj)).items != null && !((co.vine.android.api.VineParsers.VinePagedInbox) (obj)).items.isEmpty())
            {
                vinedatabasehelper.mergeInbox(l, ((co.vine.android.api.VineParsers.VinePagedInbox) (obj)), ((co.vine.android.api.VineParsers.VinePagedInbox) (obj)).nextPage, ((co.vine.android.api.VineParsers.VinePagedInbox) (obj)).previousPage, ((co.vine.android.api.VineParsers.VinePagedInbox) (obj)).anchor, i1, j);
                bundle.putInt("count", ((co.vine.android.api.VineParsers.VinePagedInbox) (obj)).items.size());
                if (((co.vine.android.api.VineParsers.VinePagedInbox) (obj)).nextPage <= 0)
                {
                    vinedatabasehelper.markLastConversation(i1);
                }
            }
        }
        return s;
    }

    private HttpOperation getPosts(long l, int i, int j, VineDatabaseHelper vinedatabasehelper, long l1, 
            int k, long l2, Bundle bundle)
    {
        Object obj;
        String s1;
        s1 = mApi.getBaseUrl();
        String s = bundle.getString("tag_name");
        obj = s;
        if (s == null)
        {
            obj = s;
            if (i != 6)
            {
                obj = String.valueOf(l);
                bundle.putString("tag_name", ((String) (obj)));
            }
        }
        i;
        JVM INSTR tableswitch 1 11: default 112
    //                   1 140
    //                   2 351
    //                   3 448
    //                   4 488
    //                   5 520
    //                   6 546
    //                   7 112
    //                   8 577
    //                   9 577
    //                   10 405
    //                   11 625;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L1 _L8 _L8 _L9 _L10
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Tried to fetch timeline with unsupported type ").append(i).toString());
_L2:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines", "graph"
        });
_L12:
        Object obj1;
        VineAPI.addParam(((StringBuilder) (obj)), "page", k);
        VineAPI.addParam(((StringBuilder) (obj)), "anchor", l2);
        VineAPI.addParam(((StringBuilder) (obj)), "size", j);
        limitCommentAndLikesIfNeeded(((StringBuilder) (obj)));
        obj1 = VineParserReader.createParserReader(8);
        obj = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        if (!((HttpOperation) (obj)).isOK())
        {
            break MISSING_BLOCK_LABEL_826;
        }
        obj1 = (VinePagedData)((VineParserReader) (obj1)).getParsedObject();
        if (Util.isPopularTimeline(i))
        {
            k = 1;
            j = 1;
            vinedatabasehelper = vinedatabasehelper.getOldestSortId(i);
            i = k;
            if (vinedatabasehelper != null)
            {
                i = j;
                if (vinedatabasehelper.moveToFirst())
                {
                    i = vinedatabasehelper.getInt(0) + 1;
                }
                vinedatabasehelper.close();
            }
            for (vinedatabasehelper = ((VinePagedData) (obj1)).items.iterator(); vinedatabasehelper.hasNext();)
            {
                ((VinePost)vinedatabasehelper.next()).orderId = String.valueOf(i);
                i++;
            }

        }
        break; /* Loop/switch isn't completed */
_L3:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines", "users", Long.valueOf(l1)
        });
        VineAPI.addParam(((StringBuilder) (obj)), "reposts", 1);
        VineAPI.addParam(((StringBuilder) (obj)), "c_overflow", "trunc");
        continue; /* Loop/switch isn't completed */
_L9:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines", "users", Long.valueOf(l1)
        });
        VineAPI.addParam(((StringBuilder) (obj)), "reposts", 0);
        continue; /* Loop/switch isn't completed */
_L4:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines", "users", Long.valueOf(l1), "likes"
        });
        continue; /* Loop/switch isn't completed */
_L5:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines", "users", "trending"
        });
        continue; /* Loop/switch isn't completed */
_L6:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines", "popular"
        });
        continue; /* Loop/switch isn't completed */
_L7:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines", "tags", obj
        });
        continue; /* Loop/switch isn't completed */
_L8:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines", "channels", bundle.getString("tag_name"), bundle.getString("sort")
        });
        continue; /* Loop/switch isn't completed */
_L10:
        obj = VineAPI.buildUponUrl(s1, new Object[] {
            "timelines"
        });
        obj1 = (Uri)bundle.getParcelable("data");
        for (Iterator iterator = ((Uri) (obj1)).getPathSegments().iterator(); iterator.hasNext();)
        {
            String s2 = (String)iterator.next();
            obj = VineAPI.buildUponUrl(((StringBuilder) (obj)).toString(), new Object[] {
                s2
            });
        }

        Uri.encode(((Uri) (obj1)).getPath());
        if (true) goto _L12; else goto _L11
_L11:
        bundle.putInt("count", ((VinePagedData) (obj1)).items.size());
        bundle.putInt("size", ((VinePagedData) (obj1)).count);
        bundle.putParcelableArrayList("posts", ((VinePagedData) (obj1)).items);
        bundle.putBoolean("in_memory", true);
        bundle.putInt("next_page", ((VinePagedData) (obj1)).nextPage);
        bundle.putInt("previous_page", ((VinePagedData) (obj1)).previousPage);
        bundle.putLong("time", ((VinePagedData) (obj1)).anchor);
        bundle.putString("title", ((VinePagedData) (obj1)).title);
        return ((HttpOperation) (obj));
    }

    private HttpOperation getUsersMe(String s, Bundle bundle)
    {
        Object obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "me"
        });
        s = VineParserReader.createParserReader(2);
        obj = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, s).execute();
        if (((HttpOperation) (obj)).isOK())
        {
            s = (VineUser)s.getParsedObject();
            s.id = VineDatabaseHelper.getDatabaseHelper(this).mergeUserAndGetResultingRowId(s);
            bundle.putParcelable("user", s);
        }
        return ((HttpOperation) (obj));
    }

    private void handleSingleVinePrivateMessageResponse(Context context, VineDatabaseHelper vinedatabasehelper, VinePrivateMessageResponse vineprivatemessageresponse, co.vine.android.api.VineUpload.PostInfo postinfo, long l, long l1)
    {
        long l2 = vinedatabasehelper.getUserRowIdForUserRemoteId(AppController.getInstance(context).getActiveSessionReadOnly().getUserId());
        String s;
        String s1;
        String s2;
        String s3;
        int i;
        int j;
        long l3;
        long l4;
        long l5;
        boolean flag;
        if (vineprivatemessageresponse.error != null)
        {
            i = vineprivatemessageresponse.error.errorCode;
            s = vineprivatemessageresponse.error.message;
        } else
        {
            i = 0;
            s = null;
        }
        l3 = vineprivatemessageresponse.conversationId;
        l4 = vineprivatemessageresponse.messageId;
        l5 = postinfo.created;
        s1 = postinfo.message;
        s2 = vineprivatemessageresponse.videoUrl;
        s3 = vineprivatemessageresponse.thumbnailUrl;
        j = postinfo.maxLoops;
        if (postinfo.maxLoops > 0 && postinfo.maxLoops < 0x7fffffff)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        postinfo = new VinePrivateMessage(-1L, l3, l4, l2, l5, s1, s2, s3, 1, false, false, j, 0L, flag, 0L, postinfo.postId, i, s);
        if (l > 0L)
        {
            vinedatabasehelper.updateConversationWithLastMessage(l1, vinedatabasehelper.mergeMessageWithMessageRow(l, l1, postinfo), ((VinePrivateMessage) (postinfo)).created);
        } else
        {
            HashSet hashset = new HashSet();
            hashset.add(Long.valueOf(vineprivatemessageresponse.recipient.recipientId));
            if (vineprivatemessageresponse.conversationId > 0L)
            {
                l = vinedatabasehelper.getConversationRowId(vineprivatemessageresponse.conversationId);
            } else
            {
                l = vinedatabasehelper.determineBestConversationRowIdForUserRowId(vineprivatemessageresponse.recipient.recipientId);
            }
            l1 = l;
            if (l <= 0L)
            {
                l1 = vinedatabasehelper.createConversationRowId(hashset, 1);
                vinedatabasehelper.mergeConversationWithLocalId(l1, vineprivatemessageresponse.conversationId, 1);
            }
            vinedatabasehelper.updateConversationWithLastMessage(l1, vinedatabasehelper.mergeMessage(l1, postinfo), ((VinePrivateMessage) (postinfo)).created);
        }
        SLog.d("VM post successful, sending merge broadcast now");
        vinedatabasehelper = new Intent("co.vine.android.service.mergeSelfNewMessage");
        vinedatabasehelper.putExtra("conversation_id", ((VinePrivateMessage) (postinfo)).conversationId);
        vinedatabasehelper.putExtra("message_id", ((VinePrivateMessage) (postinfo)).messageId);
        context.sendBroadcast(vinedatabasehelper, "co.vine.android.BROADCAST");
    }

    private void handleVinePrivateMessageResponses(Context context, VineUpload vineupload, co.vine.android.api.VineUpload.PostInfo postinfo, VineParserReader vineparserreader, Bundle bundle)
    {
        Object obj1 = (VinePrivateMessagePostResponseWithUsers)vineparserreader.getParsedObject();
        vineparserreader = ((VinePrivateMessagePostResponseWithUsers) (obj1)).responses;
        Object obj = ((VinePrivateMessagePostResponseWithUsers) (obj1)).users;
        obj1 = ((VinePrivateMessagePostResponseWithUsers) (obj1)).recipients;
        VineDatabaseHelper vinedatabasehelper = VineDatabaseHelper.getDatabaseHelper(context);
        VinePrivateMessage vineprivatemessage = vinedatabasehelper.getMessageFromMessageRow(vineupload.mergedMessageId);
        if (vineupload.mergedMessageId <= 0L || vineprivatemessage == null)
        {
            CrashUtil.log("No local message to merge with.");
            return;
        }
        if (obj != null)
        {
            vinedatabasehelper.mergeRecipientsWithUsersAndRemoveUnusedRecipients(vineprivatemessage.conversationRowId, ((ArrayList) (obj1)), ((ArrayList) (obj)));
        }
        long l = -1L;
        if (vineparserreader == null || vineparserreader.size() < 1)
        {
            boolean flag;
            if (vineparserreader == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            CrashUtil.log("No vine private message responses, deleting the conversation and bailing. Response is null: {}", new Object[] {
                Boolean.valueOf(flag)
            });
            vinedatabasehelper.deleteConversation(-1L, vineprivatemessage.conversationRowId);
            return;
        }
        String s;
        Iterator iterator;
        if (vineparserreader.size() == 1)
        {
            if (vineprivatemessage.conversationId <= 0L)
            {
                vineprivatemessage.conversationRowId = vinedatabasehelper.mergeConversationWithLocalId(vineprivatemessage.conversationRowId, ((VinePrivateMessageResponse)vineparserreader.get(0)).conversationId, vineprivatemessage.networkType);
            }
            l = vineupload.mergedMessageId;
        } else
        {
            vinedatabasehelper.deleteConversation(-1L, vineprivatemessage.conversationRowId);
        }
        obj = null;
        vineupload = null;
        s = null;
        obj1 = null;
        iterator = vineparserreader.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VinePrivateMessageResponse vineprivatemessageresponse = (VinePrivateMessageResponse)iterator.next();
            if (vineprivatemessageresponse != null)
            {
                Object obj2 = vineupload;
                vineparserreader = ((VineParserReader) (obj));
                if (vineprivatemessageresponse.recipient != null)
                {
                    obj2 = vineupload;
                    vineparserreader = ((VineParserReader) (obj));
                    if (vineprivatemessageresponse.recipient.key.equals("phoneNumber"))
                    {
                        obj2 = vineupload;
                        vineparserreader = ((VineParserReader) (obj));
                        if (vineprivatemessageresponse.shareUrl != null)
                        {
                            vineparserreader = ((VineParserReader) (obj));
                            if (obj == null)
                            {
                                vineparserreader = getString(0x7f0e0229);
                            }
                            obj = vineupload;
                            if (vineupload == null)
                            {
                                obj = getString(0x7f0e0228);
                            }
                            String s1;
                            String s2;
                            if (TextUtils.isEmpty(postinfo.message) || postinfo.maxLoops > 0)
                            {
                                vineupload = String.format(vineparserreader, new Object[] {
                                    vineprivatemessageresponse.shareUrl
                                });
                            } else
                            {
                                vineupload = (new StringBuilder()).append(postinfo.message).append(": ").append(vineprivatemessageresponse.shareUrl).toString();
                            }
                            vineupload = (new StringBuilder()).append(vineupload).append(((String) (obj))).toString();
                            SLog.d("Send SMS to {} with text {}", vineprivatemessageresponse.recipient.value, vineupload);
                            SMSUtil.sendSMS(vineprivatemessageresponse.recipient.value, vineupload);
                            obj2 = obj;
                        }
                    }
                }
                s1 = s;
                if (vineprivatemessageresponse.videoUrl != null)
                {
                    s1 = vineprivatemessageresponse.videoUrl;
                }
                s2 = ((String) (obj1));
                if (vineprivatemessageresponse.thumbnailUrl != null)
                {
                    s2 = vineprivatemessageresponse.thumbnailUrl;
                }
                handleSingleVinePrivateMessageResponse(context, vinedatabasehelper, vineprivatemessageresponse, postinfo, l, vineprivatemessage.conversationRowId);
                vineupload = ((VineUpload) (obj2));
                obj = vineparserreader;
                obj1 = s2;
                s = s1;
                if (vineprivatemessageresponse.error != null)
                {
                    bundle.putBoolean("should_delete_upload", true);
                    vineupload = ((VineUpload) (obj2));
                    obj = vineparserreader;
                    obj1 = s2;
                    s = s1;
                }
            }
        } while (true);
        bundle.putString("post_url", s);
        bundle.putString("thumbnail_url", ((String) (obj1)));
    }

    private void init()
    {
        this;
        JVM INSTR monitorenter ;
        if (mApi == null)
        {
            mApi = VineAPI.getInstance(this);
        }
        if (mMediaUtility == null)
        {
            mMediaUtility = new MediaUtility(this);
        }
        if (mAmazonBucket == null)
        {
            mAmazonBucket = Amazon.getBucket(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void insertVineMessageBody(HashMap hashmap, co.vine.android.api.VineUpload.PostInfo postinfo, long l)
    {
        if (postinfo != null)
        {
            if (!TextUtils.isEmpty(postinfo.message))
            {
                hashmap.put("message", postinfo.message);
            }
            if (postinfo.postId > 0L)
            {
                hashmap.put("postId", Long.valueOf(postinfo.postId));
            }
            hashmap.put("created", Long.valueOf(postinfo.created));
            if (postinfo.maxLoops > 0 && postinfo.maxLoops < 0x7fffffff)
            {
                hashmap.put("maxLoops", Integer.valueOf(postinfo.maxLoops));
            }
            if (postinfo.recipients != null && !postinfo.recipients.isEmpty())
            {
                hashmap.put("to", co.vine.android.api.VineUpload.PostInfo.recipientsToMaps(postinfo.recipients));
            } else
            if (l <= 0L)
            {
                SLog.dWithTag("VineService", "VM post failed: The recipients array is empty and no conversation id");
                return;
            }
        }
    }

    private void insertVinePostBody(HashMap hashmap, co.vine.android.api.VineUpload.PostInfo postinfo)
    {
        if (postinfo != null)
        {
            String s;
            if (!postinfo.caption.isEmpty())
            {
                SLog.d("Added description: {}.", postinfo.caption);
                hashmap.put("description", Util.cleanse(postinfo.caption));
                if (postinfo.entities != null && !postinfo.entities.isEmpty())
                {
                    hashmap.put("entities", co.vine.android.api.VineUpload.PostInfo.entitiesToMaps(postinfo.entities));
                }
            } else
            {
                SLog.d("empty description.");
            }
            if (postinfo.channelId > 0L)
            {
                hashmap.put("channelId", String.valueOf(postinfo.channelId));
            }
            if (postinfo.postToTwitter)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            hashmap.put("postToTwitter", s);
            if (postinfo.postToFacebook)
            {
                postinfo = "1";
            } else
            {
                postinfo = "0";
            }
            hashmap.put("postToFacebook", postinfo);
        }
    }

    private HttpOperation postComment(long l, long l1, String s, String s1, String s2, 
            ArrayList arraylist, VineDatabaseHelper vinedatabasehelper, Bundle bundle)
    {
        Object obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l), "comments"
        });
        Object obj1 = new ArrayList();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((ArrayList) (obj1)).add(((VineEntity)iterator.next()).toMap())) { }
        HashMap hashmap = new HashMap();
        hashmap.put("comment", s1);
        if (!((ArrayList) (obj1)).isEmpty())
        {
            hashmap.put("entities", obj1);
        }
        obj1 = VineParserReader.createParserReader(7);
        obj = HttpOperation.createBasicAuthJsonPostRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, hashmap, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        if (((HttpOperation) (obj)).isOK())
        {
            obj1 = (VineComment)((VineParserReader) (obj1)).getParsedObject();
            obj1.postId = l;
            obj1.userId = l1;
            obj1.username = s;
            obj1.avatarUrl = s2;
            int i = 0;
            for (s2 = arraylist.iterator(); s2.hasNext();)
            {
                VineEntity vineentity = (VineEntity)s2.next();
                vineentity.start = vineentity.start - i;
                int j = i;
                s = s1;
                if ("tag".equals(vineentity.type))
                {
                    j = i + 1;
                    String s3 = VineTypeAhead.getPlainTag(vineentity.title);
                    s = s1.replaceFirst(vineentity.title, s3);
                    vineentity.title = s3;
                    vinedatabasehelper.mergeSuggestedTag(new VineTag(s3, vineentity.id));
                }
                vineentity.end = vineentity.end - j;
                i = j;
                s1 = s;
            }

            obj1.comment = s1;
            obj1.entities = arraylist;
            obj1.timestamp = System.currentTimeMillis();
            bundle.putParcelable("comment_obj", ((Parcelable) (obj1)));
        }
        return ((HttpOperation) (obj));
    }

    private void updateBadgeCount(int i)
    {
        Object obj = getContentResolver();
        obj = ((ContentResolver) (obj)).query(SAMSUNG_BADGER_URI, new String[] {
            "package", "badgecount"
        }, null, null, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("package", "co.vine.android");
        contentvalues.put("class", START_CLASS_NAME);
        contentvalues.put("badgecount", Integer.valueOf(i));
        if (((Cursor) (obj)).getCount() > 0)
        {
            getContentResolver().update(SAMSUNG_BADGER_URI, contentvalues, "package=?", BADGER_ARGS);
            return;
        }
        try
        {
            getContentResolver().insert(SAMSUNG_BADGER_URI, contentvalues);
            return;
        }
        catch (Exception exception)
        {
            SLog.e("Ignore samsung error.", exception);
        }
    }

    public void addCountryParam(ArrayList arraylist)
    {
        arraylist.add(new BasicNameValuePair("locale", Util.getCountryCode()));
    }

    public void addCountryParam(HashMap hashmap)
    {
        hashmap.put("locale", Util.getCountryCode());
    }

    void attemptStop(int i)
    {
        mStartIds.put(Integer.valueOf(i), Boolean.valueOf(true));
        for (Iterator iterator = mStartIds.entrySet().iterator(); iterator.hasNext();)
        {
            if (!((Boolean)((java.util.Map.Entry)iterator.next()).getValue()).booleanValue())
            {
                return;
            }
        }

        for (Iterator iterator1 = mStartIds.keySet().iterator(); iterator1.hasNext(); stopSelf(((Integer)iterator1.next()).intValue())) { }
        mStartIds.clear();
    }

    Bundle executeAction(int i, Bundle bundle)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj4;
        VineError vineerror;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        int l;
        long l58;
        if (LOGGABLE)
        {
            Log.d("VineService", (new StringBuilder()).append("Running VineService action: ").append(i).toString());
        }
        init();
        obj10 = bundle.getString("s_key");
        obj2 = bundle.getString("a_name");
        l58 = bundle.getLong("s_owner_id", 0L);
        obj9 = VineDatabaseHelper.getDatabaseHelper(this);
        obj8 = getApplicationContext();
        l = 0;
        obj5 = null;
        obj4 = null;
        obj = null;
        obj7 = null;
        vineerror = null;
        obj1 = null;
        obj6 = null;
        i;
        JVM INSTR lookupswitch 110: default 992
    //                   2: 1172
    //                   3: 1734
    //                   4: 1761
    //                   5: 4204
    //                   6: 4302
    //                   7: 4867
    //                   8: 5297
    //                   9: 5566
    //                   10: 8213
    //                   11: 5652
    //                   12: 7918
    //                   13: 7540
    //                   14: 8086
    //                   15: 8249
    //                   16: 8485
    //                   17: 9009
    //                   18: 9043
    //                   19: 9207
    //                   20: 10527
    //                   21: 11103
    //                   22: 6003
    //                   23: 6003
    //                   24: 9534
    //                   25: 9739
    //                   26: 11368
    //                   27: 11931
    //                   28: 7614
    //                   29: 12023
    //                   30: 8165
    //                   31: 12058
    //                   32: 12175
    //                   33: 12341
    //                   34: 12477
    //                   35: 12518
    //                   36: 12542
    //                   37: 12722
    //                   38: 12911
    //                   39: 17024
    //                   40: 17279
    //                   41: 13015
    //                   42: 13602
    //                   43: 13402
    //                   44: 3444
    //                   45: 3624
    //                   46: 14043
    //                   47: 14182
    //                   48: 14344
    //                   49: 14503
    //                   50: 14595
    //                   51: 14742
    //                   52: 14857
    //                   53: 14978
    //                   54: 9877
    //                   55: 10050
    //                   56: 10215
    //                   57: 15213
    //                   58: 13979
    //                   59: 14015
    //                   60: 15579
    //                   61: 15705
    //                   62: 16490
    //                   63: 16527
    //                   64: 16809
    //                   65: 16895
    //                   66: 17463
    //                   67: 17724
    //                   68: 17844
    //                   69: 17992
    //                   70: 7988
    //                   71: 11259
    //                   74: 18142
    //                   76: 19021
    //                   77: 18980
    //                   79: 19597
    //                   80: 19704
    //                   81: 10883
    //                   82: 6879
    //                   84: 19867
    //                   85: 20071
    //                   86: 20303
    //                   87: 19825
    //                   88: 2545
    //                   89: 20496
    //                   90: 20631
    //                   91: 3213
    //                   92: 20845
    //                   93: 18296
    //                   94: 20978
    //                   95: 18946
    //                   96: 16669
    //                   97: 15929
    //                   98: 21012
    //                   99: 17024
    //                   100: 18875
    //                   101: 8812
    //                   102: 15843
    //                   103: 5160
    //                   104: 18246
    //                   105: 21062
    //                   106: 21184
    //                   107: 9400
    //                   108: 21312
    //                   109: 20738
    //                   110: 6441
    //                   111: 21465
    //                   112: 21577
    //                   113: 3078
    //                   114: 2907
    //                   115: 20276
    //                   1000: 3658;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L79 _L80 _L81 _L82 _L83 _L84 _L85 _L86 _L87 _L88 _L89 _L90 _L91 _L92 _L38 _L93 _L94 _L95 _L96 _L97 _L98 _L99 _L100 _L101 _L102 _L103 _L104 _L105 _L106 _L107 _L108 _L109
_L1:
        Object obj3;
        int j;
        j = l;
        obj2 = obj5;
        obj = obj7;
        obj3 = vineerror;
        obj1 = obj6;
        break; /* Loop/switch isn't completed */
_L2:
        obj1 = (VineLogin)bundle.getParcelable("login");
        obj = bundle.getString("pass");
        obj2 = VineParserReader.createLoginReader();
        obj3 = new ArrayList();
        if (!TextUtils.isEmpty(((VineLogin) (obj1)).username) && !TextUtils.isEmpty(((CharSequence) (obj))))
        {
            ((ArrayList) (obj3)).add(new BasicNameValuePair("username", ((VineLogin) (obj1)).username));
            ((ArrayList) (obj3)).add(new BasicNameValuePair("password", ((String) (obj))));
        }
        boolean flag;
        if (!TextUtils.isEmpty(((VineLogin) (obj1)).twitterToken) && !TextUtils.isEmpty(((VineLogin) (obj1)).twitterSecret) && ((VineLogin) (obj1)).twitterUserId > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((ArrayList) (obj3)).add(new BasicNameValuePair("twitterOauthToken", ((VineLogin) (obj1)).twitterToken));
            ((ArrayList) (obj3)).add(new BasicNameValuePair("twitterOauthSecret", ((VineLogin) (obj1)).twitterSecret));
            ((ArrayList) (obj3)).add(new BasicNameValuePair("twitterId", String.valueOf(((VineLogin) (obj1)).twitterUserId)));
        }
        if (bundle.getBoolean("reactivate", false))
        {
            obj = "reactivate";
        } else
        {
            obj = "authenticate";
        }
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", obj
        });
        obj = HttpOperation.createPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), ((ArrayList) (obj3)), ((co.vine.android.network.HttpOperationReader) (obj2)), mApi).execute();
        if (((HttpOperation) (obj)).isOK())
        {
            obj = (VineLogin)((VineParserReader) (obj2)).getParsedObject();
            obj.name = ((VineLogin) (obj)).username;
            obj.username = ((VineLogin) (obj1)).username;
            bundle.putString("a_name", ((VineLogin) (obj)).name);
            bundle.putParcelable("login", ((Parcelable) (obj)));
            FlurryUtils.trackLoginSuccess(flag);
            obj1 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "users", "me"
            });
            obj4 = VineParserReader.createParserReader(2);
            obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj1)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4)), ((VineLogin) (obj)).key).execute();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((HttpOperation) (obj6)).isOK())
            {
                obj = (VineUser)((VineParserReader) (obj4)).getParsedObject();
                bundle.putString("avatar_url", ((VineUser) (obj)).avatarUrl);
                bundle.putString("desc", ((VineUser) (obj)).description);
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
        } else
        {
            obj1 = new Bundle();
            ((Bundle) (obj1)).putInt("statusCode", ((HttpOperation) (obj)).statusCode);
            FlurryUtils.trackLoginFailure(flag, ((HttpOperation) (obj)).statusCode);
            obj = (VineError)((VineParserReader) (obj2)).getParsedObject();
            if (obj != null)
            {
                ((Bundle) (obj1)).putString("reasonPhrase", ((VineError) (obj)).message);
                bundle.putInt("error_code", ((VineError) (obj)).errorCode);
            } else
            {
                ((Bundle) (obj1)).putString("reasonPhrase", getString(0x7f0e00cf));
            }
            ((Bundle) (obj1)).putInt("executionCode", 1);
            return ((Bundle) (obj1));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        ((VineDatabaseHelper) (obj9)).clearAllData();
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L4:
        obj2 = bundle.getString("a_name");
        obj3 = bundle.getString("login");
        String s = bundle.getString("pass");
        String s1 = bundle.getString("phone");
        obj = (TwitterUser)bundle.getParcelable("t_user");
        obj10 = (new StringBuilder(mApi.getBaseUrl())).append("/users");
        obj4 = VineParserReader.createParserReader(5);
        obj9 = new ArrayList();
        boolean flag1;
        if (obj != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj1 = bundle.getString("key");
        obj6 = bundle.getString("secret");
        obj7 = CrossAnalytics.getInstance(this).get("pre_install_sign up");
        if (flag1)
        {
            if (!TextUtils.isEmpty(((TwitterUser) (obj)).name))
            {
                ((ArrayList) (obj9)).add(new BasicNameValuePair("username", ((TwitterUser) (obj)).name));
            }
            ((ArrayList) (obj9)).add(new BasicNameValuePair("location", ((TwitterUser) (obj)).location));
            ((ArrayList) (obj9)).add(new BasicNameValuePair("description", ((TwitterUser) (obj)).description));
            ((ArrayList) (obj9)).add(new BasicNameValuePair("twitterId", String.valueOf(((TwitterUser) (obj)).userId)));
            ((ArrayList) (obj9)).add(new BasicNameValuePair("twitterOauthToken", ((String) (obj1))));
            ((ArrayList) (obj9)).add(new BasicNameValuePair("twitterOauthSecret", ((String) (obj6))));
            if (!TextUtils.isEmpty(s1))
            {
                ((ArrayList) (obj9)).add(new BasicNameValuePair("phoneNumber", s1));
            }
        } else
        {
            ((ArrayList) (obj9)).add(new BasicNameValuePair("username", ((String) (obj2))));
            ((ArrayList) (obj9)).add(new BasicNameValuePair("email", ((String) (obj3))));
            ((ArrayList) (obj9)).add(new BasicNameValuePair("password", s));
            if (!TextUtils.isEmpty(s1))
            {
                ((ArrayList) (obj9)).add(new BasicNameValuePair("phoneNumber", s1));
            }
        }
        ((ArrayList) (obj9)).add(new BasicNameValuePair("authenticate", "true"));
        if (obj7 != null)
        {
            ((ArrayList) (obj9)).add(new BasicNameValuePair("preinstallTarget", ((String) (obj7))));
        }
        obj9 = HttpOperation.createPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj10)), ((ArrayList) (obj9)), ((co.vine.android.network.HttpOperationReader) (obj4)), mApi).execute();
        if (((HttpOperation) (obj9)).isOK())
        {
            FlurryUtils.onSignupSuccess(flag1);
            if (obj7 != null)
            {
                FlurryUtils.onSignupWithPreinstallSuccess(((String) (obj7)));
                CrossAnalytics.getInstance(this).clear("pre_install_sign up");
            }
            obj7 = (VineLogin)((VineParserReader) (obj4)).getParsedObject();
            if (flag1)
            {
                obj7.twitterToken = ((String) (obj1));
                obj7.twitterSecret = ((String) (obj6));
                obj7.twitterUserId = ((TwitterUser) (obj)).userId;
                obj7.loginType = 2;
            } else
            {
                obj7.username = ((String) (obj3));
            }
            bundle.putParcelable("login", ((Parcelable) (obj7)));
            bundle.putString("a_name", ((String) (obj2)));
            obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "users", "me"
            });
            obj4 = VineParserReader.createParserReader(2);
            obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4)), ((VineLogin) (obj7)).key).execute();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((HttpOperation) (obj6)).isOK())
            {
                obj = (VineUser)((VineParserReader) (obj4)).getParsedObject();
                bundle.putString("avatar_url", ((VineUser) (obj)).avatarUrl);
                bundle.putString("desc", ((VineUser) (obj)).description);
                bundle.putString("s_key", ((VineLogin) (obj7)).key);
                bundle.putLong("s_owner_id", ((VineLogin) (obj7)).userId);
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
        } else
        {
            bundle = new Bundle();
            bundle.putInt("statusCode", ((HttpOperation) (obj9)).statusCode);
            obj = (VineError)((VineParserReader) (obj4)).getParsedObject();
            FlurryUtils.onSignupFailure(flag1, ((VineError) (obj)), ((HttpOperation) (obj9)).statusCode);
            if (obj != null)
            {
                bundle.putString("reasonPhrase", ((VineError) (obj)).message);
            } else
            {
                bundle.putString("reasonPhrase", getString(0x7f0e00cf));
            }
            bundle.putInt("executionCode", 1);
            return bundle;
        }
        continue; /* Loop/switch isn't completed */
_L82:
        obj2 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58)
        });
        obj9 = (Uri)bundle.getParcelable("uri");
        obj = null;
        if (mAmazonBucket != null)
        {
            obj1 = mAmazonBucket;
        } else
        {
            obj1 = Amazon.getBucket(((Context) (obj8)));
        }
        if (obj9 != null)
        {
            try
            {
                obj = mMediaUtility.getPhotoUri(((Uri) (obj9)), ((String) (obj1)), ((Context) (obj8)));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                j = 900;
                obj2 = bundle.getMessage();
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj7;
                continue; /* Loop/switch isn't completed */
            }
        }
        if (obj9 == null || !TextUtils.isEmpty(((Uri) (obj9)).toString())) goto _L111; else goto _L110
_L110:
        obj4 = "";
_L113:
        obj = new ArrayList(1);
        if (obj9 != null)
        {
            ((ArrayList) (obj)).add(new BasicNameValuePair("avatarUrl", ((String) (obj4))));
        }
        obj6 = VineParserReader.createParserReader(2);
        obj7 = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj2)), mApi, ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj6))).execute();
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj7)).isOK())
        {
            if (obj9 == null)
            {
                bundle.putString("avatar_url", "");
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj7;
                obj2 = obj5;
                j = l;
            } else
            {
                bundle.putString("avatar_url", ((String) (obj4)));
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj7;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L111:
        switch (MediaUtility.getUploadType(((Context) (obj8))))
        {
        default:
            obj4 = obj;
            break;

        case 1: // '\001'
            obj4 = (new StringBuilder()).append(mApi.getAmazonUrl()).append("/").append(((String) (obj1))).append("/").append(((String) (obj))).toString();
            break;
        }
        if (true) goto _L113; else goto _L112
_L112:
_L107:
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "notifications", "settings"
        });
        obj1 = (HashMap)bundle.getSerializable("notificationSettings");
        bundle = new ArrayList();
        for (obj1 = ((HashMap) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); bundle.add(new BasicNameValuePair((String)((java.util.Map.Entry) (obj2)).getKey(), (String)((java.util.Map.Entry) (obj2)).getValue())))
        {
            obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
        }

        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, bundle, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L106:
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "notifications", "settings"
        });
        obj4 = VineParserReader.createParserReader(30);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putParcelableArrayList("notificationSettings", ((VinePagedData)((VineParserReader) (obj4)).getParsedObject()).items);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L85:
        i = bundle.getInt("network", 1);
        obj = (VineRecipient)bundle.getParcelable("recipient");
        if (obj == null)
        {
            throw new IllegalArgumentException("You must provide a recipient if you want to get the conversation id for it");
        }
        long l2;
        if (((VineRecipient) (obj)).isFromUser())
        {
            long l42;
            boolean flag2;
            if (((VineRecipient) (obj)).recipientId <= 0L)
            {
                obj.recipientId = ((VineDatabaseHelper) (obj9)).getUserRowIdForUserRemoteId(((VineRecipient) (obj)).userId);
            } else
            if (((VineRecipient) (obj)).userId < 0L)
            {
                obj.userId = ((VineDatabaseHelper) (obj9)).getUserRemoteIdForUserRowId(((VineRecipient) (obj)).recipientId);
            }
            l2 = ((VineDatabaseHelper) (obj9)).determineBestConversationRowIdForUserRemoteId(((VineRecipient) (obj)).userId);
        } else
        {
            obj1 = new ArrayList();
            ((ArrayList) (obj1)).add(obj);
            l2 = ((VineDatabaseHelper) (obj9)).determineOrCreateBestConversationRowIdForRecipients(((List) (obj1)), i);
        }
        l42 = l2;
        if (l2 <= 0L)
        {
            obj1 = new ArrayList();
            ((ArrayList) (obj1)).add(obj);
            l42 = ((VineDatabaseHelper) (obj9)).createPreMergeConversationIdAndRecipientsIfNecessary(((List) (obj1)), i);
        }
        if (TextUtils.isEmpty(((VineRecipient) (obj)).display))
        {
            obj.display = ((VineDatabaseHelper) (obj9)).getDisplayForUser(((VineRecipient) (obj)).recipientId);
        }
        flag2 = ((VineDatabaseHelper) (obj9)).amFollowingUser(((VineRecipient) (obj)).recipientId);
        bundle.putLong("conversation_row_id", l42);
        bundle.putBoolean("am_following", flag2);
        bundle.putString("username", ((VineRecipient) (obj)).display);
        return bundle;
_L43:
        obj = new ArrayList();
        ((ArrayList) (obj)).add(new BasicNameValuePair("includePromoted", String.valueOf(bundle.getInt("should_follow_editors_picks"))));
        obj1 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "preferences"
        });
        obj4 = VineParserReader.createParserReader(1);
        obj6 = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj1)), mApi, ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        boolean flag3;
        if (bundle.getInt("should_follow_editors_picks") == 1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        bundle.putBoolean("should_follow_editors_picks", flag3);
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (!flag3)
        {
            bundle.putBoolean("also_fetch_posts", true);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L44:
        ((VineDatabaseHelper) (obj9)).expireTimeline(bundle.getInt("type"));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L109:
        obj = VineAccountHelper.getAccount(((Context) (obj8)), ((String) (obj2)));
        obj4 = obj;
        if (obj == null)
        {
            obj4 = VineAccountHelper.getAccount(((Context) (obj8)), bundle.getString("email"));
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            if (obj4 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        obj9 = AccountManager.get(((Context) (obj8)));
        switch (VineAccountHelper.getLoginType(((AccountManager) (obj9)), ((Account) (obj4))))
        {
        default:
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            break;

        case 1: // '\001'
            obj2 = ((Account) (obj4)).name;
            obj1 = VineAccountHelper.getPassword(((AccountManager) (obj9)), ((Account) (obj4)), ((Context) (obj8)));
            obj6 = VineParserReader.createLoginReader();
            obj = new ArrayList();
            ((ArrayList) (obj)).add(new BasicNameValuePair("username", ((String) (obj2))));
            ((ArrayList) (obj)).add(new BasicNameValuePair("password", ((String) (obj1))));
            obj1 = (new StringBuilder(mApi.getBaseUrl())).append("/users/authenticate");
            obj7 = HttpOperation.createPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj1)), ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj6)), mApi).execute();
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            if (((HttpOperation) (obj7)).isOK())
            {
                obj = (VineLogin)((VineParserReader) (obj6)).getParsedObject();
                VineAccountHelper.setSessionKey(((AccountManager) (obj9)), ((Account) (obj4)), ((VineLogin) (obj)).key);
                bundle.putString("s_key", ((VineLogin) (obj)).key);
                AppController.getInstance(((Context) (obj8))).setSessionKey(((VineLogin) (obj)).key);
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj7;
                obj2 = obj5;
                j = l;
            }
            break;

        case 2: // '\002'
            obj2 = VineAccountHelper.getTwitterToken(((AccountManager) (obj9)), ((Account) (obj4)));
            obj = VineAccountHelper.getTwitterSecret(((AccountManager) (obj9)), ((Account) (obj4)));
            obj6 = VineParserReader.createLoginReader();
            obj1 = new ArrayList();
            ((ArrayList) (obj1)).add(new BasicNameValuePair("twitterOauthToken", ((String) (obj2))));
            ((ArrayList) (obj1)).add(new BasicNameValuePair("twitterOauthSecret", ((String) (obj))));
            if (bundle.getBoolean("reactivate", false))
            {
                obj = "reactivate";
            } else
            {
                obj = "authenticate";
            }
            obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "users", obj, "twitter"
            });
            obj7 = HttpOperation.createPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), ((ArrayList) (obj1)), ((co.vine.android.network.HttpOperationReader) (obj6)), mApi).execute();
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            if (((HttpOperation) (obj7)).isOK())
            {
                obj = (VineLogin)((VineParserReader) (obj6)).getParsedObject();
                VineAccountHelper.setSessionKey(((AccountManager) (obj9)), ((Account) (obj4)), ((VineLogin) (obj)).key);
                bundle.putString("s_key", ((VineLogin) (obj)).key);
                AppController.getInstance(((Context) (obj8))).setSessionKey(((VineLogin) (obj)).key);
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj7;
                obj2 = obj5;
                j = l;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        obj2 = bundle.getString("key");
        obj1 = bundle.getString("secret");
        obj = bundle.getString("uri");
        obj = (new ServiceBuilder()).provider(org/scribe/builder/api/TwitterApi).apiKey(((String) (obj2))).apiSecret(((String) (obj1))).callback(((String) (obj))).build();
        bundle.putString("load_url", ((OAuthService) (obj)).getAuthorizationUrl(((OAuthService) (obj)).getRequestToken()));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L6:
        obj10 = bundle.getString("username");
        obj9 = bundle.getString("key");
        obj4 = bundle.getString("secret");
        long l3 = bundle.getLong("t_id");
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (!TextUtils.isEmpty(((CharSequence) (obj9))))
        {
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            if (!TextUtils.isEmpty(((CharSequence) (obj4))))
            {
                obj2 = ThreadedHttpOperationClient.getInstance(((Context) (obj8)));
                if (bundle.getBoolean("reactivate", false))
                {
                    obj = "reactivate";
                } else
                {
                    obj = "authenticate";
                }
                obj3 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                    "users", obj, "twitter"
                });
                obj = new ArrayList(2);
                ((ArrayList) (obj)).add(new BasicNameValuePair("twitterOauthToken", ((String) (obj9))));
                ((ArrayList) (obj)).add(new BasicNameValuePair("twitterOauthSecret", ((String) (obj4))));
                obj1 = VineParserReader.createParserReader(5);
                obj = HttpOperation.createPostRequest(((co.vine.android.network.HttpOperationClient) (obj2)), ((StringBuilder) (obj3)), ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj1)), mApi).execute();
                if (((HttpOperation) (obj)).isOK())
                {
                    bundle.putBoolean("a_exists", true);
                    obj = (VineLogin)((VineParserReader) (obj1)).getParsedObject();
                    obj.twitterUsername = ((String) (obj10));
                    obj.twitterToken = ((String) (obj9));
                    obj.twitterSecret = ((String) (obj4));
                    obj.twitterUserId = l3;
                    obj.loginType = 2;
                    bundle.putParcelable("login", ((Parcelable) (obj)));
                    obj1 = (new StringBuilder()).append(mApi.getBaseUrl()).append("/users/me").toString();
                    obj4 = VineParserReader.createParserReader(2);
                    obj6 = HttpOperation.createBasicAuthGetRequest(((co.vine.android.network.HttpOperationClient) (obj2)), new StringBuilder(((String) (obj1))), mApi, ((co.vine.android.network.HttpOperationReader) (obj4)), ((VineLogin) (obj)).key).execute();
                    obj1 = obj4;
                    obj3 = vineerror;
                    obj = obj6;
                    obj2 = obj5;
                    j = l;
                    if (((HttpOperation) (obj6)).isOK())
                    {
                        bundle.putParcelable("user", (VineUser)((VineParserReader) (obj4)).getParsedObject());
                        obj1 = obj4;
                        obj3 = vineerror;
                        obj = obj6;
                        obj2 = obj5;
                        j = l;
                    }
                } else
                {
                    obj3 = (VineError)((VineParserReader) (obj1)).getParsedObject();
                    if (obj3 == null)
                    {
                        obj2 = getString(0x7f0e00cb);
                        j = l;
                    } else
                    {
                        SLog.d("Got error: {} {}", Integer.valueOf(((VineError) (obj3)).errorCode), ((VineError) (obj3)).message);
                        j = ((VineError) (obj3)).errorCode;
                        if (co.vine.android.api.VineError.VineKnownErrors.BAD_CREDENTIALS.code == j || co.vine.android.api.VineError.VineKnownErrors.RECORD_DOES_NOT_EXIST.code == j || co.vine.android.api.VineError.VineKnownErrors.ACCOUNT_DEACTIVATED.code == j)
                        {
                            bundle.putParcelable("login", new VineLogin(null, ((String) (obj10)), ((String) (obj9)), ((String) (obj4)), l3, null));
                            bundle.putBoolean("a_exists", false);
                            bundle.putInt("error_code", ((VineError) (obj3)).errorCode);
                            obj2 = obj5;
                            j = l;
                        } else
                        {
                            obj2 = ((VineError) (obj3)).message;
                            j = l;
                        }
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        obj1 = (VineLogin)bundle.getParcelable("login");
        obj = (new ServiceBuilder()).provider(org/scribe/builder/api/TwitterApi).apiKey(TwitterVineApp.API_KEY).apiSecret(TwitterVineApp.API_SECRET).build();
        obj2 = (new StringBuilder()).append(mApi.getTwitterUrl()).append("/users/show.json?id=").append(((VineLogin) (obj1)).twitterUserId).toString();
        obj2 = new OAuthRequest(Verb.GET, ((String) (obj2)));
        ((OAuthService) (obj)).signRequest(new Token(((VineLogin) (obj1)).twitterToken, ((VineLogin) (obj1)).twitterSecret), ((OAuthRequest) (obj2)));
        boolean flag4;
        try
        {
            obj4 = ((OAuthRequest) (obj2)).send();
            flag4 = ((Response) (obj4)).isSuccessful();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            SLog.d("Failed to connect.", bundle);
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            continue; /* Loop/switch isn't completed */
        }
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (!flag4)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (new JsonFactory()).createJsonParser(((Response) (obj4)).getBody());
        ((JsonParser) (obj)).nextToken();
        bundle.putParcelable("t_user", VineParsers.parseTwitterUser(((JsonParser) (obj))));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
        bundle;
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (!LOGGABLE)
        {
            continue; /* Loop/switch isn't completed */
        }
        SLog.d("Failed to parse.", bundle);
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L96:
        bundle = ((VineDatabaseHelper) (obj9)).getMessagesForConversationRowId(bundle.getLong("conversation_row_id"));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (bundle == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        for (; bundle.moveToNext(); startService(VineUploadService.getVMPostIntent(this, ((VinePrivateMessage) (obj)).uploadPath, true, ((VinePrivateMessage) (obj)).messageRowId, ((VinePrivateMessage) (obj)).conversationRowId, null, ((VinePrivateMessage) (obj)).message, ((VinePrivateMessage) (obj)).postId, ((VinePrivateMessage) (obj)).videoUrl, ((VinePrivateMessage) (obj)).thumbnailUrl, ((VinePrivateMessage) (obj)).maxLoops)))
        {
            obj = new VinePrivateMessage(bundle);
        }

        break MISSING_BLOCK_LABEL_5269;
        obj;
        bundle.close();
        throw obj;
        bundle.close();
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L8:
        obj2 = bundle.getString("username");
        obj = bundle.getString("pass");
        obj1 = new ConfigurationBuilder();
        ((ConfigurationBuilder) (obj1)).setOAuthConsumerKey(TwitterVineApp.API_KEY);
        ((ConfigurationBuilder) (obj1)).setOAuthConsumerSecret(TwitterVineApp.API_SECRET);
        obj = (new VineTwitterFactory(((ConfigurationBuilder) (obj1)).build())).getInstance(new BasicAuthorization(((String) (obj2)), ((String) (obj))));
        obj = ((Twitter) (obj)).getOAuthAccessToken();
        bundle.putParcelable("login", new VineLogin(null, ((AccessToken) (obj)).getScreenName(), ((AccessToken) (obj)).getToken(), ((AccessToken) (obj)).getTokenSecret(), ((AccessToken) (obj)).getUserId(), null));
        j = 200;
        bundle.putString("pass", null);
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        continue; /* Loop/switch isn't completed */
        obj;
        obj1 = ((Context) (obj8)).getResources();
        if (((TwitterException) (obj)).getStatusCode() != 401) goto _L115; else goto _L114
_L114:
        j = 401;
        if (!Util.isXauth2FactorError(((TwitterException) (obj)))) goto _L117; else goto _L116
_L116:
        obj2 = ((Resources) (obj1)).getString(0x7f0e00c7);
_L118:
        bundle.putString("pass", null);
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        continue; /* Loop/switch isn't completed */
_L117:
        obj2 = ((Resources) (obj1)).getString(0x7f0e00c9);
          goto _L118
_L115:
        if (!((TwitterException) (obj)).isCausedByNetworkIssue())
        {
            break MISSING_BLOCK_LABEL_5537;
        }
        j = 500;
        obj2 = ((Resources) (obj1)).getString(0x7f0e00c8);
          goto _L118
        j = 500;
        obj2 = ((Resources) (obj1)).getString(0x7f0e00d0);
          goto _L118
        obj;
        bundle.putString("pass", null);
        throw obj;
_L9:
        FlurryUtils.trackResetPassword();
        obj = bundle.getString("login");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "forgotPassword"
        });
        VineAPI.addParam(bundle, "email", ((String) (obj)));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, ((co.vine.android.network.HttpOperationReader) (obj1)), mApi).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L11:
        long l43 = bundle.getLong("post_id", 0L);
        j = bundle.getInt("page", 1);
        long l4 = bundle.getLong("time", 0L);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l43), "likes"
        });
        VineAPI.addParam(((StringBuilder) (obj)), "page", j);
        if (l4 > 0L)
        {
            VineAPI.addParam(((StringBuilder) (obj)), "anchor", l4);
        }
        VineAPI.addParam(((StringBuilder) (obj)), "size", 20);
        obj4 = VineParserReader.createParserReader(11);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj7 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
            ((VineDatabaseHelper) (obj9)).mergeLikes(((VinePagedData) (obj7)).items, l43, ((VinePagedData) (obj7)).nextPage, ((VinePagedData) (obj7)).previousPage);
            bundle.putInt("count", ((VinePagedData) (obj7)).count);
            bundle.putInt("next_page", ((VinePagedData) (obj7)).nextPage);
            bundle.putInt("previous_page", ((VinePagedData) (obj7)).previousPage);
            bundle.putLong("time", ((VinePagedData) (obj7)).anchor);
            obj = new ArrayList();
            for (obj1 = ((VinePagedData) (obj7)).items.iterator(); ((Iterator) (obj1)).hasNext(); ((ArrayList) (obj)).add(((VineLike)((Iterator) (obj1)).next()).user)) { }
            bundle.putParcelableArrayList("users", ((ArrayList) (obj)));
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((VinePagedData) (obj7)).nextPage <= 0)
            {
                ((VineDatabaseHelper) (obj9)).markLastUser(5, String.valueOf(l43));
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L22:
        k = 2;
        obj4 = "followers";
        if (i == 23)
        {
            k = 1;
            obj4 = "following";
        }
        long l44 = bundle.getLong("profile_id", 0L);
        int i1 = bundle.getInt("page", 1);
        long l5 = bundle.getLong("time", 0L);
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (l44 > 0L)
        {
            obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "users", Long.valueOf(l44), obj4
            });
            VineAPI.addParam(((StringBuilder) (obj)), "page", i1);
            if (l5 > 0L)
            {
                VineAPI.addParam(((StringBuilder) (obj)), "anchor", l5);
            }
            VineAPI.addParam(((StringBuilder) (obj)), "size", 10);
            obj4 = VineParserReader.createParserReader(3);
            obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((HttpOperation) (obj6)).isOK())
            {
                obj7 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
                if (((VinePagedData) (obj7)).items != null)
                {
                    obj = new LongSparseArray(((VinePagedData) (obj7)).items.size());
                    for (obj2 = ((VinePagedData) (obj7)).items.iterator(); ((Iterator) (obj2)).hasNext(); ((LongSparseArray) (obj)).put(((VineUser) (obj1)).userId, Long.valueOf(((VineUser) (obj1)).orderId)))
                    {
                        obj1 = (VineUser)((Iterator) (obj2)).next();
                    }

                    ((VineDatabaseHelper) (obj9)).mergeUsers(((VinePagedData) (obj7)).items, k, String.valueOf(l44), ((VinePagedData) (obj7)).nextPage, ((VinePagedData) (obj7)).previousPage, ((LongSparseArray) (obj)));
                    bundle.putInt("count", ((VinePagedData) (obj7)).count);
                    bundle.putInt("next_page", ((VinePagedData) (obj7)).nextPage);
                    bundle.putInt("previous_page", ((VinePagedData) (obj7)).previousPage);
                    bundle.putLong("time", ((VinePagedData) (obj7)).anchor);
                    bundle.putParcelableArrayList("users", ((VinePagedData) (obj7)).items);
                }
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
                if (((VinePagedData) (obj7)).nextPage <= 0)
                {
                    ((VineDatabaseHelper) (obj9)).markLastUser(k, String.valueOf(l44), "_id DESC");
                    obj1 = obj4;
                    obj3 = vineerror;
                    obj = obj6;
                    obj2 = obj5;
                    j = l;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L103:
        k = bundle.getInt("page", 1);
        long l45 = bundle.getLong("time", 0L);
        long l6 = bundle.getLong("notification_id", 0L);
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (l58 > 0L)
        {
            obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "users", Long.valueOf(l58), "notifications", "grouped", Long.valueOf(l6), "users"
            });
            VineAPI.addParam(((StringBuilder) (obj)), "page", k);
            if (l45 > 0L)
            {
                VineAPI.addParam(((StringBuilder) (obj)), "anchor", l45);
            }
            VineAPI.addParam(((StringBuilder) (obj)), "size", 10);
            obj4 = VineParserReader.createParserReader(3);
            obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((HttpOperation) (obj6)).isOK())
            {
                obj7 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
                if (((VinePagedData) (obj7)).items != null)
                {
                    obj2 = new LongSparseArray(((VinePagedData) (obj7)).items.size());
                    for (obj1 = ((VinePagedData) (obj7)).items.iterator(); ((Iterator) (obj1)).hasNext(); ((LongSparseArray) (obj2)).put(((VineUser) (obj)).userId, Long.valueOf(((VineUser) (obj)).orderId)))
                    {
                        obj = (VineUser)((Iterator) (obj1)).next();
                    }

                    ((VineDatabaseHelper) (obj9)).mergeUsers(((VinePagedData) (obj7)).items, 12, String.valueOf(l6), ((VinePagedData) (obj7)).nextPage, ((VinePagedData) (obj7)).previousPage, ((LongSparseArray) (obj2)));
                    bundle.putInt("count", ((VinePagedData) (obj7)).count);
                    bundle.putInt("next_page", ((VinePagedData) (obj7)).nextPage);
                    bundle.putInt("previous_page", ((VinePagedData) (obj7)).previousPage);
                    bundle.putLong("time", ((VinePagedData) (obj7)).anchor);
                    bundle.putParcelableArrayList("users", ((VinePagedData) (obj7)).items);
                }
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
                if (((VinePagedData) (obj7)).nextPage <= 0)
                {
                    ((VineDatabaseHelper) (obj9)).markLastUser(12, String.valueOf(l58), "_id DESC");
                    obj1 = obj4;
                    obj3 = vineerror;
                    obj = obj6;
                    obj2 = obj5;
                    j = l;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L77:
        l58 = bundle.getLong("s_owner_id", 0L);
        j = bundle.getInt("type", 0);
        k = bundle.getInt("page_type", 1);
        l7 = -1L;
        obj = null;
        obj8 = Vine.getUserSectionsAnchorManager(this, j);
        k;
        JVM INSTR tableswitch 1 3: default 6952
    //                   1 7274
    //                   2 7284
    //                   3 7295;
           goto _L119 _L120 _L121 _L122
_L119:
        obj1 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "friends"
        });
        if (j == 1)
        {
            VineAPI.addParam(((StringBuilder) (obj1)), "withFavorites", String.valueOf(0));
        }
        if (obj != null)
        {
            VineAPI.addParam(((StringBuilder) (obj1)), "anchor", ((String) (obj)));
        } else
        if (k != 1 && l7 == -1L)
        {
            bundle.putBoolean("empty", true);
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            continue; /* Loop/switch isn't completed */
        }
        VineAPI.addParam(((StringBuilder) (obj1)), "size", 10);
        obj3 = VineParserReader.createParserReader(3);
        ((VineParserReader) (obj3)).getExtraBundle().putLong("friend_index", ((StringAnchorManager) (obj8)).getIndex());
        obj4 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj1)), mApi, ((co.vine.android.network.HttpOperationReader) (obj3)), ((String) (obj10))).execute();
        obj2 = obj4;
        obj1 = obj3;
        if (((HttpOperation) (obj4)).isOK())
        {
            obj1 = ((StringAnchorManager) (obj8)).edit();
            if (obj == null)
            {
                ((VineDatabaseHelper) (obj9)).removeUserSectionsWithType(j);
                ((co.vine.android.util.StringAnchorManager.Editor) (obj1)).setRefreshTime(l7);
            }
            obj = (VinePagedData)((VineParserReader) (obj3)).getParsedObject();
            if (((VinePagedData) (obj)).stringAnchor != null)
            {
                ((co.vine.android.util.StringAnchorManager.Editor) (obj1)).setAnchor(((VinePagedData) (obj)).stringAnchor);
                if (((VinePagedData) (obj)).items != null && !((VinePagedData) (obj)).items.isEmpty())
                {
                    ((co.vine.android.util.StringAnchorManager.Editor) (obj1)).setIndex(((VineUser)((VinePagedData) (obj)).items.get(((VinePagedData) (obj)).items.size() - 1)).friendIndex);
                }
            }
            if (((VinePagedData) (obj)).items != null)
            {
                long l46 = 0L;
                if (!((VinePagedData) (obj)).items.isEmpty())
                {
                    obj2 = new LongSparseArray(((VinePagedData) (obj)).items.size());
                    for (obj7 = ((VinePagedData) (obj)).items.iterator(); ((Iterator) (obj7)).hasNext(); ((LongSparseArray) (obj2)).put(((VineUser) (obj6)).userId, Long.valueOf(((VineUser) (obj6)).orderId)))
                    {
                        obj6 = (VineUser)((Iterator) (obj7)).next();
                    }

                    obj6 = ((VinePagedData) (obj)).items;
                    int j1 = ((VinePagedData) (obj)).nextPage;
                    k = ((VinePagedData) (obj)).previousPage;
                    if (l7 == -1L)
                    {
                        l7 = -1L;
                    }
                    ((VineDatabaseHelper) (obj9)).mergeUsers(((Collection) (obj6)), 10, String.valueOf(l58), j1, k, ((LongSparseArray) (obj2)), l7, j);
                    bundle.putInt("count", ((VinePagedData) (obj)).count);
                    bundle.putInt("next_page", ((VinePagedData) (obj)).nextPage);
                    bundle.putInt("previous_page", ((VinePagedData) (obj)).previousPage);
                    bundle.putParcelableArrayList("users", ((VinePagedData) (obj)).items);
                    l46 = ((VineUser)((VinePagedData) (obj)).items.get(((VinePagedData) (obj)).items.size() - 1)).userId;
                }
                if (((VinePagedData) (obj)).stringAnchor == null)
                {
                    l46 = 0L;
                }
                ((co.vine.android.util.StringAnchorManager.Editor) (obj1)).setLastId(l46);
            }
            ((co.vine.android.util.StringAnchorManager.Editor) (obj1)).commit();
            obj1 = obj3;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
            continue; /* Loop/switch isn't completed */
        }
          goto _L123
_L120:
        obj = null;
        l7 = System.currentTimeMillis();
          goto _L119
_L121:
        throw new IllegalArgumentException("Invalid page type.");
_L122:
        obj1 = ((StringAnchorManager) (obj8)).getStringAnchor();
        obj = obj1;
        if (obj1 != null)
        {
            l7 = ((StringAnchorManager) (obj8)).getRefreshTime();
            obj = obj1;
        }
          goto _L119
_L13:
        obj = getPosts(l58, bundle.getInt("type", -1), bundle.getInt("size", 10), ((VineDatabaseHelper) (obj9)), bundle.getLong("profile_id"), bundle.getInt("page", 1), bundle.getLong("time", 0L), bundle);
        obj1 = (VineParserReader)((HttpOperation) (obj)).getReader();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L27:
        long l8 = bundle.getLong("post_id");
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (l8 <= 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "timelines", "posts", Long.valueOf(l8)
        });
        limitCommentAndLikesIfNeeded(((StringBuilder) (obj)));
        obj4 = VineParserReader.createParserReader(8);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (!((HttpOperation) (obj6)).isOK())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj7 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
        try
        {
            ((VineDatabaseHelper) (obj9)).mergePosts(((VinePagedData) (obj7)).items, 7, "", 0, 0, 0, 0L, true);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (LOGGABLE)
            {
                bundle.printStackTrace();
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
            continue; /* Loop/switch isn't completed */
        }
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (obj7 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((VinePagedData) (obj7)).items == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        bundle.putParcelable("post", (Parcelable)((VinePagedData) (obj7)).items.get(0));
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L12:
        obj = getComments(bundle.getLong("post_id", 0L), bundle.getInt("page", 1), bundle.getLong("time", 0L), bundle.getInt("size", 10), ((String) (obj10)), bundle, ((VineDatabaseHelper) (obj9)));
        obj1 = (VineParserReader)((HttpOperation) (obj)).getReader();
        FlurryUtils.trackGetComments();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L69:
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "editions"
        });
        obj1 = VineParserReader.createParserReader(20);
        obj = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        if (((HttpOperation) (obj)).isOK())
        {
            obj2 = (ArrayList)((VineParserReader) (obj1)).getParsedObject();
            ((VineDatabaseHelper) (obj9)).mergeEditions(((ArrayList) (obj2)));
            bundle.putSerializable("editions", ((java.io.Serializable) (obj2)));
        }
        FlurryUtils.trackGetEditions();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L14:
        obj = bundle.getParcelableArrayList("entities");
        obj = postComment(bundle.getLong("post_id"), bundle.getLong("user_id"), bundle.getString("username"), bundle.getString("comment"), bundle.getString("avatar_url"), ((ArrayList) (obj)), ((VineDatabaseHelper) (obj9)), bundle);
        obj1 = (VineParserReader)((HttpOperation) (obj)).getReader();
        FlurryUtils.trackPostComment();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L29:
        obj = deleteComment(bundle.getLong("post_id"), bundle.getString("comment_id"), ((VineDatabaseHelper) (obj9)));
        obj1 = (VineParserReader)((HttpOperation) (obj)).getReader();
        FlurryUtils.trackDeleteComment();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L10:
        obj = getUsersMe(((String) (obj10)), bundle);
        obj1 = (VineParserReader)((HttpOperation) (obj)).getReader();
        FlurryUtils.trackGetUser(true);
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L15:
        obj1 = bundle.getString("key");
        obj3 = bundle.getString("secret");
        obj2 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "following", "suggested", "twitter"
        });
        obj = VineParserReader.createParserReader(3);
        obj4 = new ArrayList(2);
        ((ArrayList) (obj4)).add(new BasicNameValuePair("twitterOauthToken", ((String) (obj1))));
        ((ArrayList) (obj4)).add(new BasicNameValuePair("twitterOauthSecret", ((String) (obj3))));
        obj4 = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj2)), mApi, ((ArrayList) (obj4)), ((co.vine.android.network.HttpOperationReader) (obj))).execute();
        obj2 = obj4;
        obj1 = obj;
        if (((HttpOperation) (obj4)).isOK())
        {
            obj1 = (ArrayList)((VineParserReader) (obj)).getParsedObject();
            if (obj1 != null && !((ArrayList) (obj1)).isEmpty())
            {
                ((VineDatabaseHelper) (obj9)).mergeUsers(((Collection) (obj1)), 6, String.valueOf(l58), 0, 0, null);
                bundle.putInt("count", ((ArrayList) (obj1)).size());
                bundle.putParcelableArrayList("users", ((ArrayList) (obj1)));
            }
            obj1 = obj;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
            continue; /* Loop/switch isn't completed */
        }
          goto _L123
_L16:
        obj = null;
        obj1 = Util.getAddressBookJson(getContentResolver());
        obj = obj1;
_L125:
        if (obj != null || true)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = new VineError(1000, "Could not create json.");
        obj1 = obj6;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
        obj1;
        ((IOException) (obj1)).printStackTrace();
        if (true) goto _L125; else goto _L124
_L124:
        obj2 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "following", "suggested", "contacts"
        });
        obj4 = VineParserReader.createParserReader(3);
        obj1 = new ArrayList();
        ((ArrayList) (obj1)).add(new BasicNameValuePair("addressBook", ((String) (obj))));
        addCountryParam(((ArrayList) (obj1)));
        obj6 = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj2)), mApi, ((ArrayList) (obj1)), ((co.vine.android.network.HttpOperationReader) (obj4)), new String[0]).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj7 = (ArrayList)((VineParserReader) (obj4)).getParsedObject();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (obj7 != null)
            {
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
                if (!((ArrayList) (obj7)).isEmpty())
                {
                    ((VineDatabaseHelper) (obj9)).mergeUsers(((Collection) (obj7)), 7, String.valueOf(l58), 0, 0, null);
                    bundle.putInt("count", ((ArrayList) (obj7)).size());
                    bundle.putParcelableArrayList("users", ((ArrayList) (obj7)));
                    obj1 = obj4;
                    obj3 = vineerror;
                    obj = obj6;
                    obj2 = obj5;
                    j = l;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L94:
        bundle = null;
        obj = Util.getAddressBookJson(getContentResolver());
        bundle = ((Bundle) (obj));
_L126:
        if (bundle == null && false)
        {
            obj3 = new VineError(1000, "Could not create json.");
            obj1 = obj6;
            obj = obj7;
            obj2 = obj5;
            j = l;
        } else
        {
            obj2 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "users", Long.valueOf(l58), "following", "suggested", "contacts"
            });
            obj1 = VineParserReader.createParserReader(3);
            obj = new ArrayList();
            ((ArrayList) (obj)).add(new BasicNameValuePair("addressBook", bundle));
            ((ArrayList) (obj)).add(new BasicNameValuePair("locale", Util.getLocale()));
            obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj2)), mApi, ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]).execute();
            obj3 = vineerror;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
        obj;
        ((IOException) (obj)).printStackTrace();
          goto _L126
_L17:
        ((VineDatabaseHelper) (obj9)).removeUsersByGroup(bundle.getInt("type"));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L18:
        long l9 = bundle.getLong("follow_id");
        boolean flag5 = bundle.getBoolean("notify");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l9), "followers"
        });
        bundle = VineParserReader.createParserReader(1);
        obj4 = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, null, bundle, new String[0]).execute();
        obj1 = bundle;
        obj3 = vineerror;
        obj = obj4;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj4)).isOK())
        {
            ((VineDatabaseHelper) (obj9)).updateUserFollowingFlag(l9, true);
            ((VineDatabaseHelper) (obj9)).addFollow(l9, l58, 0L, flag5);
            ((VineDatabaseHelper) (obj9)).markLastUser(1, String.valueOf(l58), "order_id ASC");
            obj1 = bundle;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L19:
        long l47 = bundle.getLong("follow_id");
        long l59 = bundle.getLong("profile_id");
        long l10 = bundle.getLong("user_id");
        boolean flag21 = bundle.getBoolean("notify");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l47), "followers"
        });
        bundle = VineParserReader.createParserReader(1);
        obj4 = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, bundle).execute();
        obj1 = bundle;
        obj3 = vineerror;
        obj = obj4;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj4)).isOK())
        {
            boolean flag6;
            if (l59 == l10)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            ((VineDatabaseHelper) (obj9)).updateUserFollowingFlag(l47, false);
            ((VineDatabaseHelper) (obj9)).removeFollow(l47, flag6, flag21);
            ((VineDatabaseHelper) (obj9)).markLastUser(1, String.valueOf(l58), "order_id ASC");
            obj1 = bundle;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L100:
        obj1 = bundle.getStringArrayList("follow_ids");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "followers"
        });
        obj = new ArrayList();
        for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((ArrayList) (obj)).add(new BasicNameValuePair("userIds[]", (String)((Iterator) (obj1)).next()))) { }
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L23:
        long l48 = bundle.getLong("post_id");
        boolean flag7 = bundle.getBoolean("notify", true);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l48), "likes"
        });
        obj4 = VineParserReader.createParserReader(10);
        obj6 = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, null, ((co.vine.android.network.HttpOperationReader) (obj4)), new String[0]).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj = (Long)((VineParserReader) (obj4)).getParsedObject();
            long l11 = bundle.getLong("user_id");
            obj1 = bundle.getString("username");
            bundle = new VineLike();
            bundle.likeId = ((Long) (obj)).longValue();
            bundle.userId = l11;
            bundle.username = ((String) (obj1));
            bundle.postId = l48;
            ((VineDatabaseHelper) (obj9)).addLike(bundle, flag7);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L24:
        long l12 = bundle.getLong("post_id");
        boolean flag8 = bundle.getBoolean("notify", true);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l12), "likes"
        });
        bundle = VineParserReader.createParserReader(10);
        obj4 = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, bundle).execute();
        obj1 = bundle;
        obj3 = vineerror;
        obj = obj4;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj4)).isOK())
        {
            ((VineDatabaseHelper) (obj9)).removeLike(l12, l58, flag8);
            obj1 = bundle;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L53:
        long l13 = bundle.getLong("post_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l13), "repost"
        });
        obj4 = VineParserReader.createParserReader(19);
        obj6 = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, null, ((co.vine.android.network.HttpOperationReader) (obj4)), new String[0]).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj = (VineRepost)((VineParserReader) (obj4)).getParsedObject();
            obj1 = bundle.getString("username");
            obj.userId = l58;
            obj.username = ((String) (obj1));
            bundle.putSerializable("repost", ((java.io.Serializable) (obj)));
            ((VineDatabaseHelper) (obj9)).revine(((VineRepost) (obj)), l58, false);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L54:
        boolean flag9 = bundle.getBoolean("following");
        long l14 = bundle.getLong("post_id");
        long l49 = bundle.getLong("repost_id");
        boolean flag22 = bundle.getBoolean("notify", true);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l14), "repost", Long.valueOf(l49)
        });
        bundle = VineParserReader.createParserReader(1);
        obj4 = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, bundle).execute();
        obj1 = bundle;
        obj3 = vineerror;
        obj = obj4;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj4)).isOK())
        {
            ((VineDatabaseHelper) (obj9)).unRevine(l14, l58, flag9, flag22);
            obj1 = bundle;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L55:
        long l15 = bundle.getLong("post_id", 0L);
        j = bundle.getInt("page", 1);
        long l50 = bundle.getLong("time", 0L);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l15), "reposts"
        });
        VineAPI.addParam(((StringBuilder) (obj)), "page", j);
        if (l50 > 0L)
        {
            VineAPI.addParam(((StringBuilder) (obj)), "anchor", l50);
        }
        VineAPI.addParam(((StringBuilder) (obj)), "size", 20);
        obj4 = VineParserReader.createParserReader(3);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj7 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
            ((VineDatabaseHelper) (obj9)).mergeUsers(((VinePagedData) (obj7)).items, 9, String.valueOf(l15), ((VinePagedData) (obj7)).nextPage, ((VinePagedData) (obj7)).previousPage, null);
            bundle.putInt("count", ((VinePagedData) (obj7)).count);
            bundle.putInt("next_page", ((VinePagedData) (obj7)).nextPage);
            bundle.putInt("previous_page", ((VinePagedData) (obj7)).previousPage);
            bundle.putLong("time", ((VinePagedData) (obj7)).anchor);
            bundle.putParcelableArrayList("users", ((VinePagedData) (obj7)).items);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((VinePagedData) (obj7)).nextPage <= 0)
            {
                ((VineDatabaseHelper) (obj9)).markLastUser(9, String.valueOf(l15));
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L20:
        k = bundle.getInt("page", 1);
        long l16 = bundle.getLong("time", 0L);
        boolean flag10 = bundle.getBoolean("follow_reqs", false);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "notifications", "grouped"
        });
        if (bundle.getBoolean("clear"))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        VineAPI.addParam(((StringBuilder) (obj)), "clear", j);
        VineAPI.addParam(((StringBuilder) (obj)), "page", k);
        if (l16 > 0L)
        {
            VineAPI.addParam(((StringBuilder) (obj)), "anchor", l16);
        }
        VineAPI.addParam(((StringBuilder) (obj)), "size", 20);
        obj4 = VineParserReader.createParserReader(28);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putParcelable("notifications", (VinePagedData)((VineParserReader) (obj4)).getParsedObject());
        }
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (flag10)
        {
            obj9 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "users", Long.valueOf(l58), "notifications", "followRequests"
            });
            VineAPI.addParam(((StringBuilder) (obj9)), "page", 1);
            VineAPI.addParam(((StringBuilder) (obj9)), "size", 20);
            obj7 = VineParserReader.createParserReader(9);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj9)), mApi, ((co.vine.android.network.HttpOperationReader) (obj7))).execute().isOK())
            {
                bundle.putParcelable("follow_requests", (VinePagedData)((VineParserReader) (obj7)).getParsedObject());
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L76:
        long l17 = bundle.getLong("s_owner_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l17), "activityCounts"
        });
        VineAPI.addParam(((StringBuilder) (obj)), "grouped", 1);
        obj4 = VineParserReader.createParserReader(26);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj = (VineActivityCounts)((VineParserReader) (obj4)).getParsedObject();
            bundle.putInt("messages_count", ((VineActivityCounts) (obj)).messages);
            bundle.putInt("notifications_count", ((VineActivityCounts) (obj)).notifications);
            bundle = new Intent();
            bundle.putExtra("messages_count", ((VineActivityCounts) (obj)).messages);
            bundle.putExtra("notifications_count", ((VineActivityCounts) (obj)).notifications);
            bundle.setAction("co.vine.android.service.activityCounts");
            sendBroadcast(bundle, "co.vine.android.BROADCAST");
            updateBadgeCount(((VineActivityCounts) (obj)).messages + ((VineActivityCounts) (obj)).notifications);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L21:
        long l18 = bundle.getLong("user_id");
        boolean flag11;
        if (l18 != l58)
        {
            flag11 = true;
        } else
        {
            flag11 = false;
        }
        FlurryUtils.trackGetUser(flag11);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "profiles", Long.valueOf(l18)
        });
        obj4 = VineParserReader.createParserReader(2);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putParcelable("user", (VineUser)((VineParserReader) (obj4)).getParsedObject());
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L70:
        obj2 = new ArrayList(1);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "edition"
        });
        ((ArrayList) (obj2)).add(new BasicNameValuePair("edition", bundle.getString("edition")));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(this), ((StringBuilder) (obj)), mApi, ((ArrayList) (obj2)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L25:
        obj9 = (Uri)bundle.getParcelable("uri");
        obj = null;
        if (mAmazonBucket != null)
        {
            obj1 = mAmazonBucket;
        } else
        {
            obj1 = Amazon.getBucket(((Context) (obj8)));
        }
        if (obj9 != null)
        {
            try
            {
                obj = mMediaUtility.getPhotoUri(((Uri) (obj9)), ((String) (obj1)), ((Context) (obj8)));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                j = 900;
                obj2 = bundle.getMessage();
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj7;
                continue; /* Loop/switch isn't completed */
            }
        }
        obj3 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58)
        });
        if (obj9 == null)
        {
            j = 5;
        } else
        {
            j = 6;
        }
        obj2 = new ArrayList(j);
        ((ArrayList) (obj2)).add(new BasicNameValuePair("username", bundle.getString("a_name")));
        ((ArrayList) (obj2)).add(new BasicNameValuePair("description", bundle.getString("desc")));
        ((ArrayList) (obj2)).add(new BasicNameValuePair("location", bundle.getString("location")));
        if (obj9 == null || !TextUtils.isEmpty(((Uri) (obj9)).toString())) goto _L128; else goto _L127
_L127:
        obj4 = "";
_L130:
        if (obj9 != null)
        {
            ((ArrayList) (obj2)).add(new BasicNameValuePair("avatarUrl", ((String) (obj4))));
        }
        obj = bundle.getString("email");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            ((ArrayList) (obj2)).add(new BasicNameValuePair("email", ((String) (obj))));
        }
        if (!TextUtils.isEmpty(bundle.getString("phone")))
        {
            ((ArrayList) (obj2)).add(new BasicNameValuePair("phoneNumber", bundle.getString("phone")));
        }
        if (bundle.containsKey("color_int") && bundle.getInt("color_int") > 0)
        {
            ((ArrayList) (obj2)).add(new BasicNameValuePair("profileBackground", String.valueOf(bundle.getInt("color_int"))));
        }
        obj6 = VineParserReader.createParserReader(2);
        obj7 = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj3)), mApi, ((ArrayList) (obj2)), ((co.vine.android.network.HttpOperationReader) (obj6))).execute();
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj7)).isOK())
        {
            if (obj9 == null)
            {
                bundle.putString("avatar_url", "");
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj7;
                obj2 = obj5;
                j = l;
            } else
            {
                bundle.putString("avatar_url", ((String) (obj4)));
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj7;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L128:
        switch (MediaUtility.getUploadType(((Context) (obj8))))
        {
        default:
            obj4 = obj;
            break;

        case 1: // '\001'
            obj4 = (new StringBuilder()).append(mApi.getAmazonUrl()).append("/").append(((String) (obj1))).append("/").append(((String) (obj))).toString();
            break;
        }
        if (true) goto _L130; else goto _L129
_L129:
_L26:
        FlurryUtils.trackReportPost();
        long l19 = bundle.getLong("post_id");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l19), "complaints"
        });
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, null, ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L28:
        ((VineDatabaseHelper) (obj9)).cleanUp(bundle.getLong("time"));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L30:
        long l20 = bundle.getLong("post_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l20)
        });
        bundle = VineParserReader.createParserReader(1);
        obj4 = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, bundle).execute();
        obj1 = bundle;
        obj3 = vineerror;
        obj = obj4;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj4)).isOK())
        {
            ((VineDatabaseHelper) (obj9)).deletePost(l20);
            obj1 = bundle;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L31:
        FlurryUtils.trackConnectTwitter();
        obj = bundle.getString("key");
        obj1 = bundle.getString("secret");
        long l21 = bundle.getLong("user_id");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58)
        });
        obj2 = new ArrayList(3);
        ((ArrayList) (obj2)).add(new BasicNameValuePair("twitterOauthToken", ((String) (obj))));
        ((ArrayList) (obj2)).add(new BasicNameValuePair("twitterOauthSecret", ((String) (obj1))));
        ((ArrayList) (obj2)).add(new BasicNameValuePair("twitterId", String.valueOf(l21)));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, ((ArrayList) (obj2)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L32:
        FlurryUtils.trackDisConnectTwitter();
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58)
        });
        obj = new ArrayList(3);
        ((ArrayList) (obj)).add(new BasicNameValuePair("twitterOauthToken", ""));
        ((ArrayList) (obj)).add(new BasicNameValuePair("twitterOauthSecret", ""));
        ((ArrayList) (obj)).add(new BasicNameValuePair("twitterId", ""));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L33:
        ((VineDatabaseHelper) (obj9)).removePostsFromGroupByUser(bundle.getLong("user_id"), 1, String.valueOf(l58));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L34:
        obj = getClientProfile();
        obj1 = obj6;
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L35:
        obj = bundle.getString("post_share_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "timelines", "posts", "s", obj
        });
        obj4 = VineParserReader.createParserReader(8);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj7 = ((VinePagedData)((VineParserReader) (obj4)).getParsedObject()).items;
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (!((ArrayList) (obj7)).isEmpty())
            {
                bundle.putLong("post_id", ((VinePost)((ArrayList) (obj7)).get(0)).postId);
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L36:
        FlurryUtils.trackConnectFacebook();
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58)
        });
        obj1 = new ArrayList(3);
        ((ArrayList) (obj1)).add(new BasicNameValuePair("facebookOauthToken", bundle.getString("facebook_token")));
        obj4 = VineParserReader.createParserReader(1);
        bundle = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((ArrayList) (obj1)), ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        if (bundle != null)
        {
            obj = Integer.valueOf(((HttpOperation) (bundle)).statusCode);
        } else
        {
            obj = bundle;
        }
        SLog.d("Send facebook token result {}.", obj);
        obj1 = obj4;
        obj3 = vineerror;
        obj = bundle;
        obj2 = obj5;
        j = l;
        if (bundle != null)
        {
            obj1 = obj4;
            obj3 = vineerror;
            obj = bundle;
            obj2 = obj5;
            j = l;
            if (bundle.isOK())
            {
                AppController.setPendingFacebookToken(this, null);
                obj1 = obj4;
                obj3 = vineerror;
                obj = bundle;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L37:
        obj = new StringBuilder(BuildUtil.getStatusUrl(((Context) (obj8))));
        obj4 = VineParserReader.createParserReader(15);
        obj6 = HttpOperation.createGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), ((co.vine.android.network.HttpOperationReader) (obj4)), mApi).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putParcelable("server_status", (ServerStatus)((VineParserReader) (obj4)).getParsedObject());
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L40:
        obj4 = bundle.getString("q");
        j = bundle.getInt("page_type", 1);
        k = bundle.getInt("page", 1);
        j;
        JVM INSTR tableswitch 1 3: default 13072
    //                   1 13348
    //                   2 13354
    //                   3 13378;
           goto _L131 _L132 _L133 _L134
_L131:
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (!TextUtils.isEmpty(((CharSequence) (obj4))))
        {
            FlurryUtils.trackSearchUsers();
            obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "users", "search", obj4
            });
            VineAPI.addParam(((StringBuilder) (obj)), "page", k);
            VineAPI.addParam(((StringBuilder) (obj)), "size", 50);
            obj4 = VineParserReader.createParserReader(3);
            obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4)), ((String) (obj10))).execute();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((HttpOperation) (obj6)).isOK())
            {
                obj7 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
                if (((VinePagedData) (obj7)).items != null)
                {
                    ((VineDatabaseHelper) (obj9)).mergeUsers(((VinePagedData) (obj7)).items, 8, null, ((VinePagedData) (obj7)).nextPage, ((VinePagedData) (obj7)).previousPage, null);
                    bundle.putInt("count", ((VinePagedData) (obj7)).count);
                    bundle.putInt("next_page", ((VinePagedData) (obj7)).nextPage);
                    bundle.putInt("previous_page", ((VinePagedData) (obj7)).previousPage);
                }
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
                if (((VinePagedData) (obj7)).nextPage <= 0)
                {
                    ((VineDatabaseHelper) (obj9)).markLastUser(8, null, "_id DESC");
                    obj1 = obj4;
                    obj3 = vineerror;
                    obj = obj6;
                    obj2 = obj5;
                    j = l;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L132:
        k = 1;
        continue; /* Loop/switch isn't completed */
_L133:
        j = ((VineDatabaseHelper) (obj9)).getNextPageCursor(1, 8, null, true);
        if (j > 0)
        {
            k = j;
        }
        continue; /* Loop/switch isn't completed */
_L134:
        j = ((VineDatabaseHelper) (obj9)).getPreviousPageCursor(1, 8, null, true);
        if (j > 0)
        {
            k = j;
        }
        if (true) goto _L131; else goto _L42
_L42:
        obj8 = bundle.getParcelableArrayList("posts");
        k = bundle.getInt("type");
        obj4 = bundle.getString("tag_name");
        int j2 = bundle.getInt("page_type");
        int k1 = bundle.getInt("next_page");
        int k2 = bundle.getInt("previous_page");
        long l22 = bundle.getLong("time");
        boolean flag12 = bundle.getBoolean("user_init");
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (obj8 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            ((VineDatabaseHelper) (obj9)).mergePosts(((Collection) (obj8)), k, ((String) (obj4)), j2, k1, k2, l22, flag12);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            continue; /* Loop/switch isn't completed */
        }
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (k1 > 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((VineDatabaseHelper) (obj9)).markLastPost(k, ((String) (obj4)));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L41:
        obj4 = bundle.getString("q");
        j = bundle.getInt("page_type", 1);
        k = bundle.getInt("page", 1);
        j;
        JVM INSTR tableswitch 1 3: default 13660
    //                   1 13927
    //                   2 13933
    //                   3 13956;
           goto _L135 _L136 _L137 _L138
_L135:
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (!TextUtils.isEmpty(((CharSequence) (obj4))))
        {
            FlurryUtils.trackSearchTags();
            obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "tags", "search", obj4
            });
            VineAPI.addParam(((StringBuilder) (obj)), "page", k);
            VineAPI.addParam(((StringBuilder) (obj)), "size", 50);
            obj4 = VineParserReader.createParserReader(14);
            obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4)), ((String) (obj10))).execute();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((HttpOperation) (obj6)).isOK())
            {
                obj7 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
                if (((VinePagedData) (obj7)).items != null)
                {
                    ((VineDatabaseHelper) (obj9)).mergeSearchedTags(((VinePagedData) (obj7)).items, ((VinePagedData) (obj7)).nextPage, ((VinePagedData) (obj7)).previousPage);
                    bundle.putInt("count", ((VinePagedData) (obj7)).count);
                    bundle.putInt("next_page", ((VinePagedData) (obj7)).nextPage);
                    bundle.putInt("previous_page", ((VinePagedData) (obj7)).previousPage);
                }
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
                if (((VinePagedData) (obj7)).nextPage <= 0)
                {
                    ((VineDatabaseHelper) (obj9)).markLastTag();
                    obj1 = obj4;
                    obj3 = vineerror;
                    obj = obj6;
                    obj2 = obj5;
                    j = l;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L136:
        k = 1;
        continue; /* Loop/switch isn't completed */
_L137:
        j = ((VineDatabaseHelper) (obj9)).getNextPageCursor(4, 0, null, true);
        if (j > 0)
        {
            k = j;
        }
        continue; /* Loop/switch isn't completed */
_L138:
        j = ((VineDatabaseHelper) (obj9)).getPreviousPageCursor(4, 0, null, true);
        if (j > 0)
        {
            k = j;
        }
        if (true) goto _L135; else goto _L57
_L57:
        ((VineDatabaseHelper) (obj9)).clearCachedData(bundle.getBoolean("notify", false));
        j = 200;
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        continue; /* Loop/switch isn't completed */
_L58:
        ((VineDatabaseHelper) (obj9)).clearAllData();
        j = 200;
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        continue; /* Loop/switch isn't completed */
_L45:
        long l23 = bundle.getLong("user_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l23), "blocked"
        });
        obj4 = VineParserReader.createParserReader(17);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4)), ((String) (obj10))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putParcelableArrayList("blocked_users", (ArrayList)((VineParserReader) (obj4)).getParsedObject());
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L46:
        FlurryUtils.trackBlockUser();
        long l51 = bundle.getLong("user_id");
        long l24 = bundle.getLong("block_user_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l51), "blocked", Long.valueOf(l24)
        });
        obj4 = VineParserReader.createParserReader(1);
        obj6 = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, null, ((co.vine.android.network.HttpOperationReader) (obj4)), new String[0]).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putBoolean("response_success", co.vine.android.api.VineParsers.API_RESPONSE.SUCCESS.equals(((VineParserReader) (obj4)).getParsedObject()));
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L47:
        FlurryUtils.trackUnBlockUser();
        long l52 = bundle.getLong("user_id");
        long l25 = bundle.getLong("block_user_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l52), "blocked", Long.valueOf(l25)
        });
        obj4 = VineParserReader.createParserReader(1);
        obj6 = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putBoolean("response_success", co.vine.android.api.VineParsers.API_RESPONSE.SUCCESS.equals(((VineParserReader) (obj4)).getParsedObject()));
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L48:
        FlurryUtils.trackReportUser();
        long l26 = bundle.getLong("user_id");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l26), "complaints"
        });
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, null, ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L49:
        long l27 = bundle.getLong("user_id");
        boolean flag13 = bundle.getBoolean("accept");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "followers", "requests", Long.valueOf(l27)
        });
        obj1 = VineParserReader.createParserReader(1);
        if (flag13)
        {
            obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, null, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
            obj3 = vineerror;
            obj2 = obj5;
            j = l;
        } else
        {
            obj = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
            obj3 = vineerror;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L50:
        boolean flag14 = bundle.getBoolean("explicit");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "explicit"
        });
        obj1 = VineParserReader.createParserReader(1);
        if (flag14)
        {
            obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, null, ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]);
        } else
        {
            obj = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, ((co.vine.android.network.HttpOperationReader) (obj1)));
        }
        ((HttpOperation) (obj)).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L51:
        boolean flag15 = bundle.getBoolean("priv");
        obj2 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58)
        });
        obj1 = VineParserReader.createParserReader(1);
        obj = new ArrayList(1);
        if (flag15)
        {
            bundle = "1";
        } else
        {
            bundle = "0";
        }
        ((ArrayList) (obj)).add(new BasicNameValuePair("private", bundle));
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(this), ((StringBuilder) (obj2)), mApi, ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L52:
        k = bundle.getInt("page_type", 1);
        j = 1;
        k;
        JVM INSTR tableswitch 1 3: default 15020
    //                   1 15184
    //                   2 15184
    //                   3 15190;
           goto _L139 _L140 _L140 _L141
_L139:
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "channels", "featured"
        });
        VineAPI.addParam(((StringBuilder) (obj)), "page", j);
        obj4 = VineParserReader.createParserReader(18);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
            obj1 = ((VinePagedData) (obj)).items;
            ((VineDatabaseHelper) (obj9)).mergeChannels(((Collection) (obj1)), ((VinePagedData) (obj)).nextPage, ((VinePagedData) (obj)).previousPage);
            if (((VinePagedData) (obj)).nextPage <= 0)
            {
                ((VineDatabaseHelper) (obj9)).markLastChannel();
            }
            bundle.putParcelableArrayList("channels", ((ArrayList) (obj1)));
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L140:
        j = 1;
        continue; /* Loop/switch isn't completed */
_L141:
        k = ((VineDatabaseHelper) (obj9)).getPreviousPageCursor(2, 0, null, true);
        if (k > 0)
        {
            j = k;
        }
        if (true) goto _L139; else goto _L56
_L56:
        bundle = (VinePostResponse)bundle.getParcelable("post");
        obj = VineAPI.getInstance(this);
        obj2 = VineAPI.buildUponUrl(((VineAPI) (obj)).getBaseUrl(), new Object[] {
            "timelines", "posts", Long.valueOf(((VinePostResponse) (bundle)).postId)
        });
        obj1 = ThreadedHttpOperationClient.getInstance(this);
        bundle = VineParserReader.createParserReader(8);
        obj4 = HttpOperation.createBasicAuthGetRequest(((co.vine.android.network.HttpOperationClient) (obj1)), ((StringBuilder) (obj2)), ((VineAPI) (obj)), bundle, ((String) (obj10))).execute();
        if (((HttpOperation) (obj4)).isOK())
        {
            obj6 = (VinePagedData)bundle.getParsedObject();
            obj1 = bundle;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
            if (obj6 != null)
            {
                obj1 = bundle;
                obj3 = vineerror;
                obj = obj4;
                obj2 = obj5;
                j = l;
                if (!((VinePagedData) (obj6)).items.isEmpty())
                {
                    obj = VineDatabaseHelper.getDatabaseHelper(this);
                    try
                    {
                        ((VineDatabaseHelper) (obj)).mergePosts(((VinePagedData) (obj6)).items, 1, String.valueOf(l58), 0, 0, 0, 0L, true);
                        ((VineDatabaseHelper) (obj)).mergePosts(((VinePagedData) (obj6)).items, 2, String.valueOf(l58), 0, 0, 0, 0L, true);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        SLog.e("Error writing uploaded post to db", ((Throwable) (obj)));
                    }
                    obj = new Intent();
                    ((Intent) (obj)).setAction("co.vine.android.service.mergePostFeed");
                    ((Intent) (obj)).putExtra("post", (Parcelable)((VinePagedData) (obj6)).items.get(0));
                    sendBroadcast(((Intent) (obj)), "co.vine.android.BROADCAST");
                    obj1 = bundle;
                    obj3 = vineerror;
                    obj = obj4;
                    obj2 = obj5;
                    j = l;
                }
            }
        } else
        {
            vineerror = (VineError)bundle.getParsedObject();
            obj1 = bundle;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
            if (obj4 != null)
            {
                obj1 = bundle;
                obj3 = vineerror;
                obj = obj4;
                obj2 = obj5;
                j = l;
                if (vineerror != null)
                {
                    SLog.e("Error retrieving uploaded post from server: {} {}", Integer.valueOf(((HttpOperation) (obj4)).statusCode), vineerror.message);
                    obj1 = bundle;
                    obj3 = vineerror;
                    obj = obj4;
                    obj2 = obj5;
                    j = l;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L59:
        obj1 = bundle.getString("gcmRegId");
        obj = obj1;
        if (obj1 == null)
        {
            obj = "";
        }
        long l28 = bundle.getLong("user_id");
        obj2 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l28)
        });
        bundle = new ArrayList();
        bundle.add(new BasicNameValuePair("deviceToken", ((String) (obj))));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj2)), mApi, bundle, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L60:
        obj1 = bundle.getString("gcmRegId");
        obj = obj1;
        if (obj1 == null)
        {
            obj = "";
        }
        long l29 = bundle.getLong("user_id");
        obj1 = bundle.getString("s_key");
        bundle = ((Bundle) (obj1));
        if (obj1 == null)
        {
            bundle = "";
        }
        obj2 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l29), "deviceToken"
        });
        VineAPI.addParam(((StringBuilder) (obj2)), "deviceToken", ((String) (obj)));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj2)), mApi, ((co.vine.android.network.HttpOperationReader) (obj1)), bundle).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L95:
        j = bundle.getInt("notification_id");
        long l30 = bundle.getLong("conversation_row_id", -1L);
        if (l30 >= 0L)
        {
            ((VineDatabaseHelper) (obj9)).removeNotificationForConversation(l30);
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
        } else
        {
            ((VineDatabaseHelper) (obj9)).removeNotificationsForNotificationId(j);
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L91:
        obj = (VineSingleNotification)bundle.getParcelable("notification");
        if (((VineSingleNotification) (obj)).isMessaging())
        {
            obj.notificationType = 18;
            obj1 = getConversationWithRemoteId(l58, ((VineSingleNotification) (obj)).conversationId, 1, ((VineDatabaseHelper) (obj9)), true, 1);
            if (obj1 != null)
            {
                obj.conversationRowId = ((VineConversation) (obj1)).conversationObjectId;
                obj1 = ((VineConversation) (obj1)).lastMessage();
                if (obj1 != null && ((VinePrivateMessage) (obj1)).thumbnailUrl != null && ((VinePrivateMessage) (obj1)).videoUrl != null)
                {
                    ((VineSingleNotification) (obj)).imageKeys.add(new ImageKey(((VinePrivateMessage) (obj1)).thumbnailUrl));
                    ((VineSingleNotification) (obj)).videoKeys.add(new VideoKey(((VinePrivateMessage) (obj1)).videoUrl));
                }
            }
        }
        obj1 = bundle.getString("message");
        obj2 = ((VineDatabaseHelper) (obj9)).mergePushNotification(((VineSingleNotification) (obj)), ((String) (obj1)), ((VineSingleNotification) (obj)).notificationType);
        if (obj2 == null || !((VineSingleNotification) (obj)).isMessaging()) goto _L143; else goto _L142
_L142:
        obj3 = new ArrayList(((Collection) (obj2)));
        obj2 = new LongSparseArray();
        if (((ArrayList) (obj3)).size() > 1)
        {
            for (obj8 = ((ArrayList) (obj3)).iterator(); ((Iterator) (obj8)).hasNext();)
            {
                obj10 = (VineSingleNotification)((Iterator) (obj8)).next();
                obj4 = (VineSingleNotification)((LongSparseArray) (obj2)).get(((VineSingleNotification) (obj10)).conversationRowId);
                if (obj4 != null)
                {
                    obj4.messageCount = ((VineSingleNotification) (obj4)).messageCount + 1;
                } else
                {
                    ((LongSparseArray) (obj2)).put(((VineSingleNotification) (obj10)).conversationRowId, obj10);
                    obj10.messageCount = 1;
                }
            }

            ((ArrayList) (obj3)).clear();
            k = ((LongSparseArray) (obj2)).size();
            for (j = 0; j < k; j++)
            {
                obj4 = (VineSingleNotification)((LongSparseArray) (obj2)).valueAt(j);
                if (((VineSingleNotification) (obj4)).messageCount > 1)
                {
                    obj4.comment = getString(0x7f0e013f, new Object[] {
                        Util.getUsernameFromActivity(((VineSingleNotification) (obj4)).comment), Integer.valueOf(((VineSingleNotification) (obj4)).messageCount)
                    });
                }
                ((ArrayList) (obj3)).add(obj4);
                if (((VineSingleNotification) (obj4)).conversationRowId == ((VineSingleNotification) (obj)).conversationRowId)
                {
                    obj.messageCount = ((VineSingleNotification) (obj4)).messageCount;
                }
                if (j <= 0)
                {
                    continue;
                }
                SLog.i("Prefetching message headers...");
                obj4 = getConversationWithRemoteId(l58, ((VineSingleNotification) (obj)).conversationId, 1, ((VineDatabaseHelper) (obj9)), true, 1);
                if (obj4 == null)
                {
                    continue;
                }
                obj4 = ((VineConversation) (obj4)).lastMessage();
                if (obj1 != null && j < 4 && ((VinePrivateMessage) (obj4)).thumbnailUrl != null && ((VinePrivateMessage) (obj4)).videoUrl != null)
                {
                    ((VineSingleNotification) (obj)).imageKeys.add(new ImageKey(((VinePrivateMessage) (obj4)).thumbnailUrl));
                    ((VineSingleNotification) (obj)).videoKeys.add(new VideoKey(((VinePrivateMessage) (obj4)).videoUrl));
                }
            }

        }
        bundle.putParcelableArrayList("notifications", ((ArrayList) (obj3)));
_L144:
        bundle.putParcelable("notification", ((Parcelable) (obj)));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L143:
        obj.comment = ((String) (obj1));
        if (obj2 != null)
        {
            bundle.putParcelableArrayList("notifications", ((ArrayList) (obj2)));
        }
        if (true) goto _L144; else goto _L61
_L61:
        ((VineDatabaseHelper) (obj9)).deletePushNotifications(bundle.getInt("notification_display_id", 1));
        j = 200;
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        continue; /* Loop/switch isn't completed */
_L62:
        long l31 = bundle.getLong("post_id");
        obj = bundle.getString("network");
        bundle = bundle.getString("message");
        FlurryUtils.trackSharePost(((String) (obj)), l31);
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "posts", Long.valueOf(l31), "share", obj
        });
        obj2 = new ArrayList();
        ((ArrayList) (obj2)).add(new BasicNameValuePair("message", bundle));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((ArrayList) (obj2)), ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L90:
        long l53 = bundle.getLong("post_id");
        long l32 = System.currentTimeMillis();
        obj = new HashMap();
        obj1 = bundle.getParcelableArrayList("recipients");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "conversations"
        });
        ((HashMap) (obj)).put("postId", Long.valueOf(l53));
        ((HashMap) (obj)).put("to", co.vine.android.api.VineUpload.PostInfo.recipientsToMaps(((ArrayList) (obj1))));
        ((HashMap) (obj)).put("created", Long.valueOf(l32));
        addCountryParam(((HashMap) (obj)));
        obj1 = VineParserReader.createParserReader(12);
        obj = HttpOperation.createBasicAuthJsonPostRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), bundle, mApi, ((HashMap) (obj)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L63:
        obj = bundle.getString("s_key");
        bundle = ((Bundle) (obj));
        if (obj == null)
        {
            bundle = "";
        }
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "authenticate"
        });
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj1)), bundle).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L64:
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "pendingNotificationsCount"
        });
        obj4 = VineParserReader.createParserReader(21);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putInt("count", ((Integer)((VineParserReader) (obj4)).getParsedObject()).intValue());
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L38:
        obj7 = bundle.getString("q");
        obj = VineAPI.encode(((String) (obj7)).trim());
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "search", obj
        });
        i;
        JVM INSTR lookupswitch 2: default 17100
    //                   39: 17266
    //                   99: 17253;
           goto _L145 _L146 _L147
_L145:
        obj4 = VineParserReader.createParserReader(3);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4)), ((String) (obj10))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj8 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((VinePagedData) (obj8)).items != null)
            {
                ((VineDatabaseHelper) (obj9)).mergeUsers(((VinePagedData) (obj8)).items, 0, null, 0, 0, null);
                bundle.putString("q", ((String) (obj7)));
                bundle.putParcelableArrayList("users", ((VinePagedData) (obj8)).items);
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L147:
        VineAPI.addParam(((StringBuilder) (obj)), "st", "message");
        continue; /* Loop/switch isn't completed */
_L146:
        VineAPI.addParam(((StringBuilder) (obj)), "st", "mention");
        if (true) goto _L145; else goto _L39
_L39:
        obj7 = bundle.getString("q");
        obj = VineAPI.encode(((String) (obj7)));
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "tags", "search", obj
        });
        obj4 = VineParserReader.createParserReader(14);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4)), ((String) (obj10))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            obj8 = (VinePagedData)((VineParserReader) (obj4)).getParsedObject();
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            if (((VinePagedData) (obj8)).items != null)
            {
                bundle.putString("q", ((String) (obj7)));
                bundle.putParcelableArrayList("tags", ((VinePagedData) (obj8)).items);
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
            }
        }
        continue; /* Loop/switch isn't completed */
_L65:
        obj3 = bundle.getParcelableArrayList("loops");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "loops"
        });
        obj2 = new LinkedList();
        obj1 = new HashMap();
        ((HashMap) (obj1)).put("loops", obj2);
        for (obj4 = ((List) (obj3)).iterator(); ((Iterator) (obj4)).hasNext(); ((List) (obj2)).add(obj3))
        {
            obj6 = (co.vine.android.util.LoopManager.Record)((Iterator) (obj4)).next();
            obj3 = new HashMap();
            ((HashMap) (obj3)).put("postId", Long.valueOf(((co.vine.android.util.LoopManager.Record) (obj6)).postId));
            ((HashMap) (obj3)).put("count", Integer.valueOf(((co.vine.android.util.LoopManager.Record) (obj6)).loopCount));
            ((HashMap) (obj3)).put("ts", Double.valueOf((double)((co.vine.android.util.LoopManager.Record) (obj6)).timeStamp / 1000D));
        }

        obj4 = VineParserReader.createParserReader(27);
        obj6 = HttpOperation.createBasicAuthJsonPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((HashMap) (obj1)), ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putParcelable("loop_submission", (VineLoopSubmissionResponse)((VineParserReader) (obj4)).getParsedObject());
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L66:
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "me"
        });
        obj4 = VineParserReader.createParserReader(1);
        obj6 = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putBoolean("response_success", co.vine.android.api.VineParsers.API_RESPONSE.SUCCESS.equals(((VineParserReader) (obj4)).getParsedObject()));
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L67:
        long l33 = bundle.getLong("user_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l33), "followers", "reposts"
        });
        obj4 = VineParserReader.createParserReader(1);
        obj6 = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, null, ((co.vine.android.network.HttpOperationReader) (obj4)), new String[0]).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putBoolean("response_success", co.vine.android.api.VineParsers.API_RESPONSE.SUCCESS.equals(((VineParserReader) (obj4)).getParsedObject()));
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L68:
        long l34 = bundle.getLong("user_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l34), "followers", "reposts"
        });
        obj4 = VineParserReader.createParserReader(1);
        obj6 = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            ((VineDatabaseHelper) (obj9)).removePostsByReposterId(l34);
            bundle.putBoolean("response_success", co.vine.android.api.VineParsers.API_RESPONSE.SUCCESS.equals(((VineParserReader) (obj4)).getParsedObject()));
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L71:
        j = bundle.getInt("page_type", 1);
        try
        {
            obj = getInbox(l58, j, i, ((String) (obj10)), ((VineDatabaseHelper) (obj9)), bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
            if (LOGGABLE)
            {
                bundle.printStackTrace();
                obj1 = obj6;
                obj3 = vineerror;
                obj = obj4;
                obj2 = obj5;
                j = l;
            }
            continue; /* Loop/switch isn't completed */
        }
        obj4 = obj;
        obj1 = (VineParserReader)((HttpOperation) (obj)).getReader();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L97:
        ((VineDatabaseHelper) (obj9)).savePageCursor(6, 1, null, 0, 0, 0L, true);
        ((VineDatabaseHelper) (obj9)).savePageCursor(6, 2, null, 0, 0, 0L, true);
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L87:
        j = bundle.getInt("network", 1);
        VineUpload vineupload = (VineUpload)bundle.getParcelable("upload");
        co.vine.android.api.VineUpload.PostInfo postinfo = vineupload.getPostInfo();
        obj = postinfo.recipients;
        long l54 = vineupload.conversationRowId;
        if (obj == null && l54 > 0L)
        {
            ((VineDatabaseHelper) (obj9)).getConversationRecipientsFromConversationRowId(l54);
        }
        if (obj != null)
        {
            obj1 = ((ArrayList) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                obj2 = (VineRecipient)((Iterator) (obj1)).next();
                if (((VineRecipient) (obj2)).isFromUser())
                {
                    if (((VineRecipient) (obj2)).recipientId <= 0L)
                    {
                        obj2.recipientId = ((VineDatabaseHelper) (obj9)).getUserRowIdForUserRemoteId(((VineRecipient) (obj2)).userId);
                    } else
                    if (((VineRecipient) (obj2)).userId < 0L)
                    {
                        obj2.userId = ((VineDatabaseHelper) (obj9)).getUserRemoteIdForUserRowId(((VineRecipient) (obj2)).recipientId);
                    }
                }
            } while (true);
        }
        l58 = ((VineDatabaseHelper) (obj9)).getUserRowIdForUserRemoteId(l58);
        long l35 = l54;
        if (l54 <= 0L)
        {
            l35 = ((VineDatabaseHelper) (obj9)).determineOrCreateBestConversationRowIdForRecipients(((List) (obj)), j);
        }
        vineupload.conversationRowId = l35;
        l54 = System.currentTimeMillis();
        obj1 = null;
        obj = null;
        obj4 = null;
        k = 0;
        j = k;
        obj3 = obj4;
        boolean flag16;
        if (vineupload.path != null)
        {
            obj = UploadManager.getVersionFromPath(vineupload.path);
            long l60;
            if ((new File((new StringBuilder()).append(vineupload.path).append(((RecordSessionVersion) (obj)).videoOutputExtension).toString())).exists())
            {
                obj2 = (new StringBuilder()).append("file://").append(vineupload.path).append(((RecordSessionVersion) (obj)).videoOutputExtension).toString();
            } else
            {
                obj2 = (new StringBuilder()).append("file://").append(vineupload.path).toString();
            }
            obj8 = (new StringBuilder()).append("file://").append(RecordConfigUtils.getThumbnailPath(vineupload.path)).toString();
            obj1 = obj2;
            obj = obj8;
            j = k;
            obj3 = obj4;
            if (vineupload.status == 2)
            {
                obj3 = getString(0x7f0e013b);
                j = -2;
                obj = obj8;
                obj1 = obj2;
            }
        }
        l60 = ((VineDatabaseHelper) (obj9)).getNewMessageId();
        if (postinfo.postId > 0L)
        {
            obj1 = postinfo.sharedPostVideoUrl;
            obj = postinfo.sharedPostThumbUrl;
        }
        obj2 = postinfo.message;
        if (postinfo.maxLoops > 0)
        {
            flag16 = true;
        } else
        {
            flag16 = false;
        }
        l58 = ((VineDatabaseHelper) (obj9)).mergeMessage(l35, new VinePrivateMessage(-1L, l35, l60, l58, l54, ((String) (obj2)), ((String) (obj1)), ((String) (obj)), 1, false, false, 0x7fffffff, 0L, flag16, 0L, postinfo.postId, j, ((String) (obj3)), vineupload.path));
        ((VineDatabaseHelper) (obj9)).updateConversationWithLastMessage(l35, l58, l54);
        vineupload.postInfo = postinfo.toString();
        bundle.putParcelable("upload", vineupload);
        bundle.putLong("premerged_message_id", l58);
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L93:
        bundle = bundle.getString("upload_path");
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (!TextUtils.isEmpty(bundle))
        {
            ((VineDatabaseHelper) (obj9)).setMessageError(bundle, -2, getString(0x7f0e013b));
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L89:
        ((VineDatabaseHelper) (obj9)).deleteMessage(bundle.getLong("message_id"));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L73:
        bundle.putLong("conversation_id", ((VineDatabaseHelper) (obj9)).getConversationRemoteId(bundle.getLong("conversation_row_id")));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L72:
        l55 = bundle.getLong("conversation_row_id");
        int l1;
        long l36;
        boolean flag17;
        if (l55 > 0L)
        {
            l36 = ((VineDatabaseHelper) (obj9)).getConversationRemoteId(l55);
        } else
        {
            l36 = bundle.getLong("conversation_id");
        }
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        if (l36 == -1L)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag17 = bundle.getBoolean("prefetch");
        l1 = bundle.getInt("page_type");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "conversations", Long.valueOf(l36)
        });
        k = 1;
        j = k;
        l1;
        JVM INSTR tableswitch 1 3: default 19156
    //                   1 19160
    //                   2 19362
    //                   3 19394;
           goto _L148 _L149 _L150 _L151
_L149:
        break; /* Loop/switch isn't completed */
_L148:
        j = k;
_L152:
        if (flag17)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        VineAPI.addParam(((StringBuilder) (obj)), "prefetch", k);
        VineAPI.addParam(((StringBuilder) (obj)), "page", j);
        obj4 = VineParserReader.createParserReader(22);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(getApplicationContext()), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (!((HttpOperation) (obj6)).isOK())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = (co.vine.android.api.VineParsers.VinePagedConversation)((VineParserReader) (obj4)).getParsedObject();
        if (obj2 != null && ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).items != null && !((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).items.isEmpty())
        {
            obj1 = new VineConversation(l36, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).lastMessage, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).items, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).unreadMessageCount);
            obj1.networkType = ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).networkType;
            int i2;
            for (obj = ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).items.iterator(); ((Iterator) (obj)).hasNext();)
            {
                ((VinePrivateMessage)((Iterator) (obj)).next()).networkType = ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).networkType;
            }

            bundle.putBoolean("empty", false);
            try
            {
                long l37 = ((VineDatabaseHelper) (obj9)).mergeConversation(l58, ((VineConversation) (obj1)), ((VineConversation) (obj1)).networkType, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).nextPage, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).previousPage, ((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).anchor);
                if (((co.vine.android.api.VineParsers.VinePagedConversation) (obj2)).nextPage <= 0)
                {
                    ((VineDatabaseHelper) (obj9)).markLastMessage(l37);
                }
                ((VineDatabaseHelper) (obj9)).clearUnreadCount(l55);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                obj1 = obj4;
                obj3 = vineerror;
                obj = obj6;
                obj2 = obj5;
                j = l;
                if (LOGGABLE)
                {
                    bundle.printStackTrace();
                    obj1 = obj4;
                    obj3 = vineerror;
                    obj = obj6;
                    obj2 = obj5;
                    j = l;
                }
                continue; /* Loop/switch isn't completed */
            }
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            continue; /* Loop/switch isn't completed */
        } else
        {
            bundle.putBoolean("empty", true);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
            continue; /* Loop/switch isn't completed */
        }
_L150:
        i2 = ((VineDatabaseHelper) (obj9)).getPreviousPageCursor(7, 0, String.valueOf(l55), false);
        j = k;
        if (i2 > 0)
        {
            j = i2;
        }
          goto _L152
_L151:
        i2 = ((VineDatabaseHelper) (obj9)).getNextPageCursor(7, 0, String.valueOf(l55), false);
        j = k;
        if (i2 > 0)
        {
            j = i2;
        }
          goto _L152
_L74:
        long l38 = bundle.getLong("conversation_row_id");
        long l56 = ((VineDatabaseHelper) (obj9)).getConversationRemoteId(l38);
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "conversations", Long.valueOf(l56), "ignored"
        });
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, null, ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]).execute();
        ((VineDatabaseHelper) (obj9)).deleteConversation(l56, l38);
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L75:
        long l57 = bundle.getLong("conversation_row_id");
        long l39 = ((VineDatabaseHelper) (obj9)).getConversationRemoteId(l57);
        l58 = ((VineDatabaseHelper) (obj9)).getLastMessageIdInConversation(l57);
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "conversations", Long.valueOf(l39)
        });
        if (l58 > 0L)
        {
            VineAPI.addParam(bundle, "lastMessageId", l58);
        }
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthDeleteRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        ((VineDatabaseHelper) (obj9)).deleteConversation(l39, l57);
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L81:
        ((VineDatabaseHelper) (obj9)).setShouldHideProfileRevines(bundle.getLong("user_id"), bundle.getBoolean("block_profile_reposts"));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L78:
        obj6 = (VinePrivateMessage)bundle.getParcelable("message");
        obj = new ArrayList();
        ((ArrayList) (obj)).add(new BasicNameValuePair("date", DateTimeUtil.getTimeInStringFromMs(((VinePrivateMessage) (obj6)).localStartTime, "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")));
        obj1 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "conversations", Long.valueOf(((VinePrivateMessage) (obj6)).conversationId), "messages", Long.valueOf(((VinePrivateMessage) (obj6)).messageId), "viewed"
        });
        bundle = VineParserReader.createParserReader(1);
        obj4 = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj1)), mApi, ((ArrayList) (obj)), bundle).execute();
        obj1 = bundle;
        obj3 = vineerror;
        obj = obj4;
        obj2 = obj5;
        j = l;
        if (!((HttpOperation) (obj4)).isOK())
        {
            SLog.e("Failed to send view receipt for {}.", Long.valueOf(((VinePrivateMessage) (obj6)).messageId));
            ((VineDatabaseHelper) (obj9)).updateMessageLoopStartTime(((VinePrivateMessage) (obj6)).localStartTime, ((VinePrivateMessage) (obj6)).messageId);
            obj1 = bundle;
            obj3 = vineerror;
            obj = obj4;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L79:
        obj2 = ((VineDatabaseHelper) (obj9)).getMessagesThatWereViewed();
        bundle = new ArrayList();
        obj4 = ((ArrayList) (obj2)).iterator();
        do
        {
            obj3 = vineerror;
            obj2 = obj5;
            j = l;
            if (!((Iterator) (obj4)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj2 = (co.vine.android.provider.VineDatabaseHelper.VineViewedMessage)((Iterator) (obj4)).next();
            bundle.clear();
            bundle.add(new BasicNameValuePair("date", DateTimeUtil.getTimeInStringFromMs(((co.vine.android.provider.VineDatabaseHelper.VineViewedMessage) (obj2)).localStartTime, "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")));
            obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
                "conversations", Long.valueOf(((co.vine.android.provider.VineDatabaseHelper.VineViewedMessage) (obj2)).conversationId), "messages", Long.valueOf(((co.vine.android.provider.VineDatabaseHelper.VineViewedMessage) (obj2)).messageId), "viewed"
            });
            obj1 = VineParserReader.createParserReader(1);
            obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, bundle, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
            if (((HttpOperation) (obj)).isOK())
            {
                ((VineDatabaseHelper) (obj9)).updateMessageLoopStartTime(0L, ((co.vine.android.provider.VineDatabaseHelper.VineViewedMessage) (obj2)).messageId);
            } else
            {
                SLog.e("Failed to send view receipt for {}.", Long.valueOf(((co.vine.android.provider.VineDatabaseHelper.VineViewedMessage) (obj2)).messageId));
            }
        } while (true);
_L108:
        ((VineDatabaseHelper) (obj9)).removeAccount();
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L80:
        obj1 = bundle.getStringArrayList("vanity_url");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "profiles", "vanity"
        });
        for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            obj2 = (String)((Iterator) (obj1)).next();
            obj = VineAPI.buildUponUrl(((StringBuilder) (obj)).toString(), new Object[] {
                ((String) (obj2)).replaceAll(" ", "%20")
            });
        }

        obj4 = VineParserReader.createParserReader(2);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putLong("user_id", ((VineUser)((VineParserReader) (obj4)).getParsedObject()).userId);
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L83:
        obj = bundle.getString("phone");
        long l40 = bundle.getLong("user_id");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l40)
        });
        obj1 = VineParserReader.createParserReader(1);
        obj2 = new ArrayList(2);
        ((ArrayList) (obj2)).add(new BasicNameValuePair("phoneNumber", ((String) (obj))));
        ((ArrayList) (obj2)).add(new BasicNameValuePair("verifyPhoneNumber", String.valueOf(1)));
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, ((ArrayList) (obj2)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L84:
        obj2 = bundle.getString("key");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "verifyPhoneNumber"
        });
        obj1 = VineParserReader.createParserReader(1);
        bundle = new ArrayList(1);
        bundle.add(new BasicNameValuePair("t", ((String) (obj2))));
        obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, bundle, ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L102:
        obj2 = bundle.getString("key");
        bundle = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", "verifyEmail"
        });
        obj1 = VineParserReader.createParserReader(1);
        obj = new ArrayList(1);
        ((ArrayList) (obj)).add(new BasicNameValuePair("t", ((String) (obj2))));
        obj = HttpOperation.createBasicAuthPostRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), bundle, mApi, ((ArrayList) (obj)), ((co.vine.android.network.HttpOperationReader) (obj1)), new String[0]).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L86:
        obj1 = bundle.getString("email");
        long l41 = bundle.getLong("user_id");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l41)
        });
        bundle = new ArrayList(2);
        bundle.add(new BasicNameValuePair("email", ((String) (obj1))));
        bundle.add(new BasicNameValuePair("verifyEmail", String.valueOf(1)));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, bundle, ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L88:
        ((VineDatabaseHelper) (obj9)).clearUnreadCount(bundle.getLong("conversation_row_id"));
        obj1 = obj6;
        obj3 = vineerror;
        obj = obj7;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L92:
        obj1 = (VineUpload)bundle.getParcelable("upload");
        obj = post(((Context) (obj8)), ((VineUpload) (obj1)), bundle);
        bundle.putParcelable("upload", ((Parcelable) (obj1)));
        obj1 = obj6;
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L98:
        boolean flag18 = bundle.getBoolean("accept_oon");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58)
        });
        obj2 = new ArrayList();
        if (flag18)
        {
            bundle = "1";
        } else
        {
            bundle = "0";
        }
        ((ArrayList) (obj2)).add(new BasicNameValuePair("acceptsOutOfNetworkConversations", bundle));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((ArrayList) (obj2)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L99:
        boolean flag19 = bundle.getBoolean("enable");
        obj = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "preferences"
        });
        obj2 = new ArrayList();
        if (flag19)
        {
            bundle = "0";
        } else
        {
            bundle = "1";
        }
        ((ArrayList) (obj2)).add(new BasicNameValuePair("disableAddressBook", bundle));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((ArrayList) (obj2)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L101:
        boolean flag20 = bundle.getBoolean("enable");
        j = bundle.getInt("type");
        obj2 = VineAPI.buildUponUrl(mApi.getBaseUrl(), new Object[] {
            "users", Long.valueOf(l58), "preferences"
        });
        if (j == 0)
        {
            bundle = "hiddenEmail";
        } else
        {
            bundle = "hiddenPhoneNumber";
        }
        obj3 = new ArrayList();
        if (flag20)
        {
            obj = "0";
        } else
        {
            obj = "1";
        }
        ((ArrayList) (obj3)).add(new BasicNameValuePair(bundle, ((String) (obj))));
        obj1 = VineParserReader.createParserReader(1);
        obj = HttpOperation.createBasicAuthPutRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj2)), mApi, ((ArrayList) (obj3)), ((co.vine.android.network.HttpOperationReader) (obj1))).execute();
        obj3 = vineerror;
        obj2 = obj5;
        j = l;
        continue; /* Loop/switch isn't completed */
_L104:
        obj = VineAPI.buildUponUrl(mApi.getConfigUrl(), new Object[] {
            "clientflags"
        });
        obj4 = VineParserReader.createParserReader(29);
        obj6 = HttpOperation.createBasicAuthGetRequest(ThreadedHttpOperationClient.getInstance(((Context) (obj8))), ((StringBuilder) (obj)), mApi, ((co.vine.android.network.HttpOperationReader) (obj4))).execute();
        obj1 = obj4;
        obj3 = vineerror;
        obj = obj6;
        obj2 = obj5;
        j = l;
        if (((HttpOperation) (obj6)).isOK())
        {
            bundle.putParcelable("client_flags", (VineClientFlags)((VineParserReader) (obj4)).getParsedObject());
            obj1 = obj4;
            obj3 = vineerror;
            obj = obj6;
            obj2 = obj5;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L105:
        bundle = mHttpRequests.values().iterator();
        do
        {
            obj1 = obj6;
            obj3 = vineerror;
            obj = obj7;
            obj2 = obj5;
            j = l;
            if (!bundle.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (HttpRequestBase)bundle.next();
            if (obj != null && !((HttpRequestBase) (obj)).isAborted())
            {
                ((HttpRequestBase) (obj)).abort();
            }
            bundle.remove();
        } while (true);
_L154:
        obj4 = new Bundle();
        int k;
        if (obj != null)
        {
            bundle = ((HttpOperation) (obj)).getHttpRequest();
            if (bundle != null && !bundle.isAborted())
            {
                mHttpRequests.put(Integer.valueOf(bundle.hashCode()), bundle);
            }
            j = ((HttpOperation) (obj)).statusCode;
            ((Bundle) (obj4)).putInt("statusCode", j);
            bundle = ((Bundle) (obj3));
            if (!((HttpOperation) (obj)).isOK())
            {
                bundle = ((Bundle) (obj3));
                if (obj1 != null)
                {
                    bundle = ((Bundle) (obj3));
                    if (obj3 == null)
                    {
                        bundle = (VineError)((VineParserReader) (obj1)).getParsedObject();
                    }
                }
            }
            obj = obj2;
            k = j;
            if (bundle != null)
            {
                obj = ((VineError) (bundle)).message;
                ((Bundle) (obj4)).putString("reasonPhrase", ((String) (obj)));
                l = ((VineError) (bundle)).errorCode;
                long l7;
                long l55;
                if (l == co.vine.android.api.VineError.VineKnownErrors.BAD_CREDENTIALS.code || l == co.vine.android.api.VineError.VineKnownErrors.REQUIRES_LOGIN.code)
                {
                    ((Bundle) (obj4)).putInt("executionCode", 3);
                    return ((Bundle) (obj4));
                }
                if (l == co.vine.android.api.VineError.VineKnownErrors.INVALID_SESSION.code || l == co.vine.android.api.VineError.VineKnownErrors.EXPIRED_SESSION.code)
                {
                    ((Bundle) (obj4)).putInt("executionCode", 2);
                    return ((Bundle) (obj4));
                }
                k = j;
                if (l == co.vine.android.api.VineError.VineKnownErrors.CAPTCHA.code)
                {
                    ((Bundle) (obj4)).putInt("executionCode", 4);
                    ((Bundle) (obj4)).putString("captcha_url", ((VineError) (bundle)).data);
                    return ((Bundle) (obj4));
                }
            }
        } else
        {
            ((Bundle) (obj4)).putInt("statusCode", j);
            obj = obj2;
            k = j;
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                ((Bundle) (obj4)).putString("reasonPhrase", ((String) (obj2)));
                k = j;
                obj = obj2;
            }
        }
        if (LOGGABLE)
        {
            SLog.i("{} complete {}, {}", Integer.valueOf(i), Integer.valueOf(k), obj);
        }
        ((Bundle) (obj4)).putInt("executionCode", 1);
        return ((Bundle) (obj4));
_L123:
        obj3 = vineerror;
        obj = obj2;
        obj2 = obj5;
        j = l;
        if (true) goto _L154; else goto _L153
_L153:
    }

    public void limitCommentAndLikesIfNeeded(StringBuilder stringbuilder)
    {
        if (BuildUtil.isOldDeviceOrLowEndDevice(this))
        {
            VineAPI.addParam(stringbuilder, "c_max", 0);
            VineAPI.addParam(stringbuilder, "l_max", 0);
        }
    }

    public IBinder onBind(Intent intent)
    {
        return mMessenger.getBinder();
    }

    public void onCreate()
    {
        super.onCreate();
        mExecutor = Executors.newCachedThreadPool();
        mStartIds = new LinkedHashMap(50, 50F);
        registerReceiver(mServiceBroadCastReceiver, SERVICE_INTENT_FILTER, "co.vine.android.BROADCAST", null);
    }

    public void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(mServiceBroadCastReceiver);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        init();
        Bundle bundle = intent.getExtras();
        Object obj = (VineServiceCallback)intent.getParcelableExtra("ibinder");
        Integer integer;
        if (obj != null)
        {
            obj = ((VineServiceCallback) (obj)).getResponder();
        } else
        {
            obj = null;
        }
        integer = (Integer)sActionMap.get(intent.getAction());
        if (integer == null)
        {
            if (LOGGABLE)
            {
                Log.d("VineService", (new StringBuilder()).append("Unknown action: ").append(intent.getAction()).toString());
            }
        } else
        {
            if (bundle == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Intent must contain extras: ").append(intent).toString());
            }
            mExecutor.execute(new ExecutionRunnable(j, integer.intValue(), bundle, ((VineServiceResponder) (obj)), null));
            mStartIds.put(Integer.valueOf(j), Boolean.valueOf(false));
        }
        return 2;
    }

    public HttpOperation post(Context context, VineUpload vineupload, Bundle bundle)
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        co.vine.android.api.VineUpload.PostInfo postinfo;
        VineAPI vineapi;
        HashMap hashmap;
        boolean flag;
        vineapi = VineAPI.getInstance(context);
        hashmap = new HashMap();
        postinfo = vineupload.getPostInfo();
        s = vineupload.path;
        flag = vineupload.isPrivate;
        if (vineupload != null) goto _L2; else goto _L1
_L1:
        SLog.dWithTag("VineService", (new StringBuilder()).append("Post failed: UploadManager returned a null upload for path=").append(s).toString());
        context = null;
_L17:
        this;
        JVM INSTR monitorexit ;
        return context;
_L2:
        String as[] = vineupload.getUris();
        MediaUtility.getUploadType(context);
        JVM INSTR tableswitch 1 1: default 821
    //                   1 358;
           goto _L3 _L4
_L20:
        if (vineupload.path == null) goto _L6; else goto _L5
_L5:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj = UploadManager.getVersionFromPath(vineupload.path);
        obj2 = (new StringBuilder()).append(((String) (obj1))).append(as[0]).toString();
        obj3 = (new StringBuilder()).append(((String) (obj1))).append(as[1]).toString();
        if (obj != RecordSessionVersion.SW_WEBM) goto _L8; else goto _L7
_L7:
        hashmap.put("videoWebmUrl", obj2);
_L22:
        hashmap.put("thumbnailUrl", obj3);
        hashmap.put("model", Build.MODEL);
        hashmap.put("device", Build.DEVICE);
        long l;
        try
        {
            hashmap.put("version", String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        }
        catch (Exception exception) { }
_L6:
        if (flag) goto _L10; else goto _L9
_L9:
        obj = VineAPI.buildUponUrl(vineapi.getBaseUrl(), new Object[] {
            "posts"
        });
        obj2 = VineParserReader.createParserReader(12);
        insertVinePostBody(hashmap, postinfo);
_L25:
        SLog.d("Prefix {}", obj1);
        SLog.d("Adding URI Params: {}, {}.", as[0], as[1]);
        obj = HttpOperation.createBasicAuthJsonPostRequest(ThreadedHttpOperationClient.getInstance(context), ((StringBuilder) (obj)), vineapi, hashmap, ((co.vine.android.network.HttpOperationReader) (obj2))).execute();
        if (!((HttpOperation) (obj)).isOK()) goto _L12; else goto _L11
_L11:
        if (flag) goto _L14; else goto _L13
_L13:
        vineupload = (VinePostResponse)((VineParserReader) (obj2)).getParsedObject();
        if (vineupload != null) goto _L16; else goto _L15
_L15:
        context = null;
          goto _L17
_L4:
        obj1 = (new StringBuilder()).append(vineapi.getAmazonUrl()).append("/");
        if (mAmazonBucket == null) goto _L19; else goto _L18
_L18:
        obj = mAmazonBucket;
_L21:
        obj1 = ((StringBuilder) (obj1)).append(((String) (obj))).append("/").toString();
          goto _L20
_L19:
        obj = Amazon.getBucket(context);
          goto _L21
_L8:
        hashmap.put("videoUrl", obj2);
          goto _L22
        context;
        throw context;
_L10:
        obj2 = VineAPI.buildUponUrl(vineapi.getBaseUrl(), new Object[] {
            "conversations"
        });
        obj3 = VineDatabaseHelper.getDatabaseHelper(context);
        l = ((VineDatabaseHelper) (obj3)).getConversationRemoteId(vineupload.conversationRowId);
        if (l <= 0L) goto _L24; else goto _L23
_L23:
        obj = VineAPI.buildUponUrl(((StringBuilder) (obj2)).toString(), new Object[] {
            Long.valueOf(l)
        });
_L27:
        obj2 = VineParserReader.createParserReader(24);
        insertVineMessageBody(hashmap, postinfo, l);
        addCountryParam(hashmap);
          goto _L25
_L24:
        obj = obj2;
        if (postinfo.recipients != null) goto _L27; else goto _L26
_L26:
        obj = obj2;
        if (vineupload.conversationRowId <= 0L) goto _L27; else goto _L28
_L28:
        postinfo.recipients = ((VineDatabaseHelper) (obj3)).getConversationRecipientsFromConversationRowId(vineupload.conversationRowId);
        obj = obj2;
          goto _L27
_L16:
        bundle = new Intent("co.vine.android.service.mergePost");
        bundle.putExtra("post", vineupload);
        SLog.d("Regular video post successful, sending merge broadcast now");
        context.sendBroadcast(bundle, "co.vine.android.BROADCAST");
        context = ((Context) (obj));
          goto _L17
_L14:
        handleVinePrivateMessageResponses(context, vineupload, postinfo, ((VineParserReader) (obj2)), bundle);
        context = ((Context) (obj));
          goto _L17
_L12:
        bundle = (VineError)((VineParserReader) (obj2)).getParsedObject();
        if (bundle == null) goto _L30; else goto _L29
_L29:
        SLog.e("ERROR POSTING: {} {}", Integer.valueOf(((HttpOperation) (obj)).statusCode), ((VineError) (bundle)).message);
        if (((VineError) (bundle)).errorCode == co.vine.android.api.VineError.VineKnownErrors.CAPTCHA.code)
        {
            vineupload.captchaUrl = ((VineError) (bundle)).data;
            if (vineupload.isPrivate)
            {
                VineDatabaseHelper.getDatabaseHelper(this).setMessageError(vineupload.mergedMessageId, ((VineError) (bundle)).errorCode, getString(0x7f0e013b));
            }
        }
        context = ((Context) (obj));
        if (!vineupload.isPrivate) goto _L17; else goto _L31
_L31:
        VineDatabaseHelper.getDatabaseHelper(this).setMessageError(vineupload.mergedMessageId, ((VineError) (bundle)).errorCode, getString(0x7f0e013b));
        context = ((Context) (obj));
          goto _L17
_L30:
        if (vineupload.isPrivate)
        {
            VineDatabaseHelper.getDatabaseHelper(this).setMessageError(vineupload.mergedMessageId, -1, getString(0x7f0e013b));
        }
        SLog.dWithTag("VineService", (new StringBuilder()).append("Post failed: Unknown error while posting path=").append(s).toString());
        context = ((Context) (obj));
          goto _L17
_L3:
        obj1 = "";
          goto _L20
    }

    static 
    {
        boolean flag;
        if (BuildUtil.isLogsOn() || Log.isLoggable("VineService", 3))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        LOGGABLE = flag;
        sActionMap = new HashMap(3);
        sActionMap.put("RESTART_CM", Integer.valueOf(1));
        sActionMap.put("co.vine.android.session.login", Integer.valueOf(2));
    }



}

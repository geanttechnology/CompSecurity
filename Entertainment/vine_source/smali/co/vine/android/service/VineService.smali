.class public Lco/vine/android/service/VineService;
.super Landroid/app/Service;
.source "VineService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/service/VineService$ExecutionRunnable;,
        Lco/vine/android/service/VineService$MessengerResponderRunnable;,
        Lco/vine/android/service/VineService$ResponderRunnable;,
        Lco/vine/android/service/VineService$VineServiceHandler;
    }
.end annotation


# static fields
.field public static final ACTION_CODE_ABORT_ALL_REQUESTS:I = 0x70

.field public static final ACTION_CODE_BLOCK_USER:I = 0x2f

.field public static final ACTION_CODE_BULK_FOLLOW:I = 0x6b

.field public static final ACTION_CODE_CHECK_LOGIN_TWITTER:I = 0x6

.field public static final ACTION_CODE_CLEANUP:I = 0x1d

.field public static final ACTION_CODE_CLEAR_DB_ALL:I = 0x3b

.field public static final ACTION_CODE_CLEAR_DB_CACHE:I = 0x3a

.field public static final ACTION_CODE_CLEAR_GCM_REG_ID:I = 0x3d

.field public static final ACTION_CODE_CLEAR_INBOX_PAGE_CURSORS:I = 0x68

.field public static final ACTION_CODE_CLEAR_NOTIFICATION:I = 0x66

.field public static final ACTION_CODE_CLEAR_UNREAD_COUNT:I = 0x5e

.field public static final ACTION_CODE_CLIENT_PROFILE:I = 0x23

.field public static final ACTION_CODE_CONNECT_TWITTER:I = 0x20

.field public static final ACTION_CODE_DEACTIVATE_ACCOUNT:I = 0x43

.field public static final ACTION_CODE_DELETE_COMMENT:I = 0x1e

.field public static final ACTION_CODE_DELETE_CONVERSATION:I = 0x50

.field public static final ACTION_CODE_DELETE_MESSAGE:I = 0x5f

.field public static final ACTION_CODE_DELETE_POST:I = 0x1f

.field public static final ACTION_CODE_DELETE_PUSH_NOTIFICATIONS:I = 0x3e

.field public static final ACTION_CODE_DELETE_SESSION:I = 0x40

.field public static final ACTION_CODE_DISABLE_USER_REPOSTS:I = 0x45

.field public static final ACTION_CODE_DISCONNECT_TWITTER:I = 0x21

.field public static final ACTION_CODE_ENABLE_USER_REPOSTS:I = 0x44

.field public static final ACTION_CODE_EXPIRE_TIMELINE:I = 0x2d

.field public static final ACTION_CODE_FETCH_CLIENT_FLAGS:I = 0x6f

.field public static final ACTION_CODE_FETCH_FRIENDS_TYPEAHEAD:I = 0x63

.field public static final ACTION_CODE_FETCH_SERVER_STATUS:I = 0x26

.field public static final ACTION_CODE_FETCH_USERS_TYPEAHEAD:I = 0x27

.field public static final ACTION_CODE_FOLLOW:I = 0x12

.field public static final ACTION_CODE_FOLLOW_EDITORS_PICKS:I = 0x2c

.field public static final ACTION_CODE_GET_ACTIVITY:I = 0x14

.field public static final ACTION_CODE_GET_ACTIVITY_COUNTS:I = 0x51

.field public static final ACTION_CODE_GET_ADDRESS_FRIENDS:I = 0x10

.field public static final ACTION_CODE_GET_BLOCKED_USERS:I = 0x2e

.field public static final ACTION_CODE_GET_CHANNELS:I = 0x35

.field public static final ACTION_CODE_GET_COMMENTS:I = 0xc

.field public static final ACTION_CODE_GET_CONVERSATION:I = 0x4c

.field public static final ACTION_CODE_GET_CONVERSATION_REMOTE_ID:I = 0x4d

.field public static final ACTION_CODE_GET_CONVERSATION_ROW_ID_FROM_SINGLE_RECIPIENT:I = 0x5b

.field public static final ACTION_CODE_GET_EDITIONS:I = 0x46

.field public static final ACTION_CODE_GET_FOLLOWERS:I = 0x16

.field public static final ACTION_CODE_GET_FOLLOWING:I = 0x17

.field public static final ACTION_CODE_GET_FRIENDS:I = 0x52

.field public static final ACTION_CODE_GET_INBOX:I = 0x4a

.field public static final ACTION_CODE_GET_NOTIFICATION_SETTINGS:I = 0x71

.field public static final ACTION_CODE_GET_NOTIFICATION_USERS:I = 0x6e

.field public static final ACTION_CODE_GET_NOTIF_COUNT:I = 0x41

.field public static final ACTION_CODE_GET_POSTS:I = 0xd

.field public static final ACTION_CODE_GET_POST_ID:I = 0x24

.field public static final ACTION_CODE_GET_POST_LIKERS:I = 0xb

.field public static final ACTION_CODE_GET_POST_SINGLE:I = 0x1c

.field public static final ACTION_CODE_GET_REVINERS:I = 0x38

.field public static final ACTION_CODE_GET_TAGS_TYPEAHEAD:I = 0x28

.field public static final ACTION_CODE_GET_TWITTER_AUTH:I = 0x5

.field public static final ACTION_CODE_GET_TWITTER_FRIENDS:I = 0xf

.field public static final ACTION_CODE_GET_TWITTER_USER:I = 0x7

.field public static final ACTION_CODE_GET_USER:I = 0x15

.field public static final ACTION_CODE_GET_USERS_ME:I = 0xa

.field public static final ACTION_CODE_GET_USER_ID:I = 0x56

.field public static final ACTION_CODE_IGNORE_CONVERSATION:I = 0x4f

.field public static final ACTION_CODE_LIKE_POST:I = 0x18

.field public static final ACTION_CODE_LOGIN:I = 0x2

.field public static final ACTION_CODE_LOGOUT:I = 0x3

.field public static final ACTION_CODE_MARK_MESSAGE_UPLOAD_FAILED:I = 0x64

.field public static final ACTION_CODE_MERGE_PUSH_NOTIFICATION:I = 0x61

.field public static final ACTION_CODE_MERGE_SINGLE_POST:I = 0x39

.field public static final ACTION_CODE_MESSAGE_LOOP_VIEWED:I = 0x54

.field public static final ACTION_CODE_MESSAGE_LOOP_VIEWED_BATCH:I = 0x55

.field public static final ACTION_CODE_POST:I = 0x62

.field public static final ACTION_CODE_POST_COMMENT:I = 0xe

.field public static final ACTION_CODE_PRE_MERGE_MESSAGE:I = 0x5d

.field public static final ACTION_CODE_REFRESH_SESSION_KEY:I = 0x3e8

.field public static final ACTION_CODE_REMOVE_ACCOUNT:I = 0x73

.field public static final ACTION_CODE_REMOVE_FOLLOW_POSTS:I = 0x22

.field public static final ACTION_CODE_REMOVE_USERS_BY_GROUP:I = 0x11

.field public static final ACTION_CODE_REPORT_POST:I = 0x1b

.field public static final ACTION_CODE_REPORT_USER:I = 0x31

.field public static final ACTION_CODE_REQUEST_EMAIL_VERIFICATION:I = 0x5c

.field public static final ACTION_CODE_REQUEST_PHONE_VERIFICATION:I = 0x59

.field public static final ACTION_CODE_RESET_PASSWORD:I = 0x9

.field public static final ACTION_CODE_RESPOND_FOLLOW_REQUEST:I = 0x32

.field public static final ACTION_CODE_RESTART_CONNECTION_MANAGER:I = 0x1

.field public static final ACTION_CODE_RETRY_ALL_IN_CONVERSATION:I = 0x67

.field public static final ACTION_CODE_REVINE:I = 0x36

.field public static final ACTION_CODE_SAVE_NOTIFICATION_SETTINGS:I = 0x72

.field public static final ACTION_CODE_SAVE_POSTS:I = 0x2b

.field public static final ACTION_CODE_SEARCH_TAGS:I = 0x2a

.field public static final ACTION_CODE_SEARCH_USERS:I = 0x29

.field public static final ACTION_CODE_SEND_ADDRESS_BOOK:I = 0x65

.field public static final ACTION_CODE_SEND_FACEBOOK_TOKEN:I = 0x25

.field public static final ACTION_CODE_SEND_GCM_REG_ID:I = 0x3c

.field public static final ACTION_CODE_SEND_LOOP_COUNTS:I = 0x42

.field public static final ACTION_CODE_SET_BLOCK_PROFILE_REPOSTS:I = 0x57

.field public static final ACTION_CODE_SHARE_AS_VM:I = 0x60

.field public static final ACTION_CODE_SHARE_POST:I = 0x3f

.field public static final ACTION_CODE_SIGNUP:I = 0x4

.field public static final ACTION_CODE_TWITTER_XAUTH:I = 0x8

.field public static final ACTION_CODE_UNBLOCK_USER:I = 0x30

.field public static final ACTION_CODE_UNFOLLOW:I = 0x13

.field public static final ACTION_CODE_UNLIKE_POST:I = 0x19

.field public static final ACTION_CODE_UNREVINE:I = 0x37

.field public static final ACTION_CODE_UPDATE_ACCEPT_OON:I = 0x69

.field public static final ACTION_CODE_UPDATE_DISCOVERABILITY:I = 0x6c

.field public static final ACTION_CODE_UPDATE_EDITION:I = 0x47

.field public static final ACTION_CODE_UPDATE_ENABLE_ADDRESS_BOOK:I = 0x6a

.field public static final ACTION_CODE_UPDATE_EXPLICIT:I = 0x33

.field public static final ACTION_CODE_UPDATE_PRIVATE:I = 0x34

.field public static final ACTION_CODE_UPDATE_PROFILE:I = 0x1a

.field public static final ACTION_CODE_UPDATE_PROFILE_PHOTO:I = 0x58

.field public static final ACTION_CODE_VERIFY_EMAIL:I = 0x6d

.field public static final ACTION_CODE_VERIFY_PHONE_NUMBER:I = 0x5a

.field public static final ACTION_LOGIN:Ljava/lang/String; = "LOGIN"

.field public static final ACTION_PROFILE_COLOR_CHANGED:Ljava/lang/String; = "co.vine.android.profileColor"

.field public static final ACTION_RESTART_CONNECTION_MANAGER:Ljava/lang/String; = "RESTART_CM"

.field public static final ACTION_SESSION_LOGIN:Ljava/lang/String; = "co.vine.android.session.login"

.field public static final ACTION_SESSION_LOGOUT:Ljava/lang/String; = "co.vine.android.session.logout"

.field public static final AMAZON_ERROR_CODE:I = 0x384

.field private static final BADGER_ARGS:[Ljava/lang/String;

.field private static final BADGER_SELECTION:Ljava/lang/String; = "package=?"

.field private static final BADGE_COUNT:Ljava/lang/String; = "badgecount"

.field public static final BC_ACTION_ALERT_RTC_NEW_MESSAGE:Ljava/lang/String; = "co.vine.android.service.mergeSelfNewMessage"

.field public static final BC_ACTION_FETCH_AND_MERGE_POST:Ljava/lang/String; = "co.vine.android.service.mergePost"

.field public static final BC_ACTION_MERGE_POST_INTO_FEED:Ljava/lang/String; = "co.vine.android.service.mergePostFeed"

.field public static final BC_ACTIVITY_COUNTS:Ljava/lang/String; = "co.vine.android.service.activityCounts"

.field private static final CLASS:Ljava/lang/String; = "class"

.field public static final ERROR_CODE_UNKNOWN:I = -0x1

.field public static final ERROR_CODE_UPLOAD_FAILED:I = -0x2

.field private static final EXECUTION_CAPTCHA_REQUIRED:I = 0x4

.field private static final EXECUTION_CODE:Ljava/lang/String; = "executionCode"

.field private static final EXECUTION_COMPLETE:I = 0x1

.field private static final EXECUTION_LOGGED_OUT:I = 0x3

.field private static final EXECUTION_SESSION_KEY_INVALID:I = 0x2

.field public static final EXTRA_ABORT_REQUESTS:Ljava/lang/String; = "abort_requests"

.field public static final EXTRA_ACCEPT:Ljava/lang/String; = "accept"

.field public static final EXTRA_ACCEPT_OON:Ljava/lang/String; = "accept_oon"

.field public static final EXTRA_ACCOUNT_EXISTS:Ljava/lang/String; = "a_exists"

.field public static final EXTRA_ACCOUNT_NAME:Ljava/lang/String; = "a_name"

.field public static final EXTRA_ACTION_CODE:Ljava/lang/String; = "action_code"

.field public static final EXTRA_ALSO_FETCH_POSTS:Ljava/lang/String; = "also_fetch_posts"

.field public static final EXTRA_AM_FOLLOWING:Ljava/lang/String; = "am_following"

.field public static final EXTRA_ANCHOR:Ljava/lang/String; = "time"

.field public static final EXTRA_AVATAR_URL:Ljava/lang/String; = "avatar_url"

.field public static final EXTRA_BLOCKED_USERS:Ljava/lang/String; = "blocked_users"

.field public static final EXTRA_BLOCK_USER_ID:Ljava/lang/String; = "block_user_id"

.field public static final EXTRA_CALLBACK:Ljava/lang/String; = "ibinder"

.field public static final EXTRA_CAPTCHA_URL:Ljava/lang/String; = "captcha_url"

.field public static final EXTRA_CHANNELS:Ljava/lang/String; = "channels"

.field public static final EXTRA_CLEAR:Ljava/lang/String; = "clear"

.field public static final EXTRA_CLIENT_FLAGS:Ljava/lang/String; = "client_flags"

.field public static final EXTRA_COLOR_INT:Ljava/lang/String; = "color_int"

.field public static final EXTRA_COMMENT:Ljava/lang/String; = "comment"

.field public static final EXTRA_COMMENTS:Ljava/lang/String; = "comments"

.field public static final EXTRA_COMMENT_ID:Ljava/lang/String; = "comment_id"

.field public static final EXTRA_COMMENT_OBJ:Ljava/lang/String; = "comment_obj"

.field public static final EXTRA_CONVERSATION_ID:Ljava/lang/String; = "conversation_id"

.field public static final EXTRA_CONVERSATION_ROW_ID:Ljava/lang/String; = "conversation_row_id"

.field public static final EXTRA_COUNT:Ljava/lang/String; = "count"

.field public static final EXTRA_DATA:Ljava/lang/String; = "data"

.field public static final EXTRA_DESCRIPTION:Ljava/lang/String; = "desc"

.field public static final EXTRA_DIRECT_USER_ID:Ljava/lang/String; = "direct_user_id"

.field public static final EXTRA_EDITIONS_LIST:Ljava/lang/String; = "editions"

.field public static final EXTRA_EDITION_CODE:Ljava/lang/String; = "edition"

.field public static final EXTRA_EMAIL:Ljava/lang/String; = "email"

.field public static final EXTRA_EMPTY:Ljava/lang/String; = "empty"

.field public static final EXTRA_ENABLE:Ljava/lang/String; = "enable"

.field public static final EXTRA_ENTITIES:Ljava/lang/String; = "entities"

.field public static final EXTRA_ERROR_CODE:Ljava/lang/String; = "error_code"

.field public static final EXTRA_EXPLICIT:Ljava/lang/String; = "explicit"

.field public static final EXTRA_FACEBOOK_TOKEN:Ljava/lang/String; = "facebook_token"

.field public static final EXTRA_FOLLOWING:Ljava/lang/String; = "following"

.field public static final EXTRA_FOLLOW_ID:Ljava/lang/String; = "follow_id"

.field public static final EXTRA_FOLLOW_IDS:Ljava/lang/String; = "follow_ids"

.field public static final EXTRA_FOLLOW_REQUESTS:Ljava/lang/String; = "follow_requests"

.field public static final EXTRA_FOLLOW_REQUEST_COUNT:Ljava/lang/String; = "follow_reqs_c"

.field public static final EXTRA_GCM_REG_ID:Ljava/lang/String; = "gcmRegId"

.field public static final EXTRA_GET_FOLLOW_REQUESTS:Ljava/lang/String; = "follow_reqs"

.field public static final EXTRA_HIDE_PROFILE_REPOSTS:Ljava/lang/String; = "block_profile_reposts"

.field public static final EXTRA_HIDE_REPOSTS:Ljava/lang/String; = "hide_reposts"

.field public static final EXTRA_IN_MEMORY:Ljava/lang/String; = "in_memory"

.field public static final EXTRA_KEEP_UPLOAD:Ljava/lang/String; = "should_delete_upload"

.field public static final EXTRA_KEY:Ljava/lang/String; = "key"

.field public static final EXTRA_LOAD_URL:Ljava/lang/String; = "load_url"

.field public static final EXTRA_LOCATION:Ljava/lang/String; = "location"

.field public static final EXTRA_LOGGED_OUT:Ljava/lang/String; = "logged_out"

.field public static final EXTRA_LOGIN:Ljava/lang/String; = "login"

.field public static final EXTRA_LOOPS:Ljava/lang/String; = "loops"

.field public static final EXTRA_LOOP_SUBMISSION_RESULT:Ljava/lang/String; = "loop_submission"

.field public static final EXTRA_MESSAGE:Ljava/lang/String; = "message"

.field public static final EXTRA_MESSAGES_COUNT:Ljava/lang/String; = "messages_count"

.field public static final EXTRA_MESSAGE_ID:Ljava/lang/String; = "message_id"

.field public static final EXTRA_NETWORK:Ljava/lang/String; = "network"

.field public static final EXTRA_NEXT_PAGE:Ljava/lang/String; = "next_page"

.field public static final EXTRA_NOTIFICATION:Ljava/lang/String; = "notification"

.field public static final EXTRA_NOTIFICATIONS:Ljava/lang/String; = "notifications"

.field public static final EXTRA_NOTIFICATIONS_COUNT:Ljava/lang/String; = "notifications_count"

.field public static final EXTRA_NOTIFICATION_DISPLAY_ID:Ljava/lang/String; = "notification_display_id"

.field public static final EXTRA_NOTIFICATION_ID:Ljava/lang/String; = "notification_id"

.field public static final EXTRA_NOTIFICATION_SETTINGS:Ljava/lang/String; = "notificationSettings"

.field public static final EXTRA_NOTIFY:Ljava/lang/String; = "notify"

.field public static final EXTRA_PAGE:Ljava/lang/String; = "page"

.field public static final EXTRA_PAGE_TYPE:Ljava/lang/String; = "page_type"

.field public static final EXTRA_PASSWORD:Ljava/lang/String; = "pass"

.field public static final EXTRA_PHONE:Ljava/lang/String; = "phone"

.field public static final EXTRA_POST:Ljava/lang/String; = "post"

.field public static final EXTRA_POSTS:Ljava/lang/String; = "posts"

.field public static final EXTRA_POST_ID:Ljava/lang/String; = "post_id"

.field public static final EXTRA_POST_SHARE_ID:Ljava/lang/String; = "post_share_id"

.field public static final EXTRA_PREFETCH:Ljava/lang/String; = "prefetch"

.field public static final EXTRA_PREMERGED_MESSAGE_ID:Ljava/lang/String; = "premerged_message_id"

.field public static final EXTRA_PREVIOUS_PAGE:Ljava/lang/String; = "previous_page"

.field public static final EXTRA_PRIVATE:Ljava/lang/String; = "priv"

.field public static final EXTRA_PROFILE_ID:Ljava/lang/String; = "profile_id"

.field public static final EXTRA_QUERY:Ljava/lang/String; = "q"

.field public static final EXTRA_REACTIVATE:Ljava/lang/String; = "reactivate"

.field public static final EXTRA_REASON_PHRASE:Ljava/lang/String; = "reason_phrase"

.field public static final EXTRA_RECIPIENT:Ljava/lang/String; = "recipient"

.field public static final EXTRA_RECIPIENTS:Ljava/lang/String; = "recipients"

.field public static final EXTRA_RECIPIENT_ID:Ljava/lang/String; = "recipient_id"

.field public static final EXTRA_REFRESH_SESSION:Ljava/lang/String; = "refresh_session"

.field public static final EXTRA_REPOST:Ljava/lang/String; = "repost"

.field public static final EXTRA_REPOST_ID:Ljava/lang/String; = "repost_id"

.field public static final EXTRA_REQUEST_ID:Ljava/lang/String; = "rid"

.field public static final EXTRA_RESPONSE_CODE:Ljava/lang/String; = "resp_code"

.field public static final EXTRA_RESPONSE_SUCCESS:Ljava/lang/String; = "response_success"

.field public static final EXTRA_SECRET:Ljava/lang/String; = "secret"

.field public static final EXTRA_SERVER_STATUS:Ljava/lang/String; = "server_status"

.field public static final EXTRA_SESSION_KEY:Ljava/lang/String; = "s_key"

.field public static final EXTRA_SESSION_OWNER_ID:Ljava/lang/String; = "s_owner_id"

.field public static final EXTRA_SHOULD_FOLLOW_EDITORS_PICKS:Ljava/lang/String; = "should_follow_editors_picks"

.field public static final EXTRA_SIZE:Ljava/lang/String; = "size"

.field public static final EXTRA_SORT:Ljava/lang/String; = "sort"

.field public static final EXTRA_TAGS:Ljava/lang/String; = "tags"

.field public static final EXTRA_TAG_NAME:Ljava/lang/String; = "tag_name"

.field public static final EXTRA_THUMBNAIL_URL:Ljava/lang/String; = "thumbnail_url"

.field public static final EXTRA_TITLE:Ljava/lang/String; = "title"

.field public static final EXTRA_TWITTER_ID:Ljava/lang/String; = "t_id"

.field public static final EXTRA_TWITTER_USER:Ljava/lang/String; = "t_user"

.field public static final EXTRA_TYPE:Ljava/lang/String; = "type"

.field public static final EXTRA_UPLOAD:Ljava/lang/String; = "upload"

.field public static final EXTRA_UPLOAD_PATH:Ljava/lang/String; = "upload_path"

.field public static final EXTRA_URI:Ljava/lang/String; = "uri"

.field public static final EXTRA_USER:Ljava/lang/String; = "user"

.field public static final EXTRA_USERNAME:Ljava/lang/String; = "username"

.field public static final EXTRA_USERS:Ljava/lang/String; = "users"

.field public static final EXTRA_USER_ID:Ljava/lang/String; = "user_id"

.field public static final EXTRA_USER_INITIATED:Ljava/lang/String; = "user_init"

.field public static final EXTRA_VANITY_URL:Ljava/lang/String; = "vanity_url"

.field public static final EXTRA_VIDEO_URL:Ljava/lang/String; = "post_url"

.field private static final LOGGABLE:Z

.field private static final PACKAGE:Ljava/lang/String; = "package"

.field private static final PAGE_SIZE_SEARCH:I = 0x32

.field private static final PARAM_ACCEPTS_OUT_OF_NETWORK_CONVERSATIONS:Ljava/lang/String; = "acceptsOutOfNetworkConversations"

.field private static final PARAM_ADDRESS_BOOK:Ljava/lang/String; = "addressBook"

.field private static final PARAM_ANCHOR:Ljava/lang/String; = "anchor"

.field private static final PARAM_AUTHENTICATE:Ljava/lang/String; = "authenticate"

.field private static final PARAM_AVATAR:Ljava/lang/String; = "avatarUrl"

.field private static final PARAM_COLOR:Ljava/lang/String; = "profileBackground"

.field private static final PARAM_COMMENT_MAX:Ljava/lang/String; = "c_max"

.field private static final PARAM_COMMENT_OVERFLOW:Ljava/lang/String; = "c_overflow"

.field private static final PARAM_CREATED:Ljava/lang/String; = "created"

.field private static final PARAM_DATE:Ljava/lang/String; = "date"

.field private static final PARAM_DESCRIPTION:Ljava/lang/String; = "description"

.field private static final PARAM_DEVICE_TOKEN:Ljava/lang/String; = "deviceToken"

.field private static final PARAM_DISABLE_ADDRESS_BOOK:Ljava/lang/String; = "disableAddressBook"

.field private static final PARAM_EDITION:Ljava/lang/String; = "edition"

.field private static final PARAM_EMAIL:Ljava/lang/String; = "email"

.field private static final PARAM_FACEBOOK_AUTH_TOKEN:Ljava/lang/String; = "facebookOauthToken"

.field private static final PARAM_HIDDEN_EMAIL:Ljava/lang/String; = "hiddenEmail"

.field private static final PARAM_HIDDEN_PHONE_NUMBER:Ljava/lang/String; = "hiddenPhoneNumber"

.field private static final PARAM_INBOX:Ljava/lang/String; = "inbox"

.field private static final PARAM_INCLUDE_PROMOTED:Ljava/lang/String; = "includePromoted"

.field private static final PARAM_LAST_MESSAGE_ID:Ljava/lang/String; = "lastMessageId"

.field private static final PARAM_LIKE_MAX:Ljava/lang/String; = "l_max"

.field private static final PARAM_LOCALE:Ljava/lang/String; = "locale"

.field private static final PARAM_LOCATION:Ljava/lang/String; = "location"

.field private static final PARAM_MESSAGE:Ljava/lang/String; = "message"

.field private static final PARAM_NAME:Ljava/lang/String; = "username"

.field private static final PARAM_PAGE:Ljava/lang/String; = "page"

.field private static final PARAM_PASSWORD:Ljava/lang/String; = "password"

.field private static final PARAM_PHONE:Ljava/lang/String; = "phoneNumber"

.field private static final PARAM_PREFETCH:Ljava/lang/String; = "prefetch"

.field private static final PARAM_PREINSTALL_TARGET:Ljava/lang/String; = "preinstallTarget"

.field private static final PARAM_REPOSTS:Ljava/lang/String; = "reposts"

.field private static final PARAM_SEARCH_TERM:Ljava/lang/String; = "st"

.field private static final PARAM_SIZE:Ljava/lang/String; = "size"

.field private static final PARAM_TWITTER_ID:Ljava/lang/String; = "twitterId"

.field private static final PARAM_TWITTER_SECRET:Ljava/lang/String; = "twitterOauthSecret"

.field private static final PARAM_TWITTER_TOKEN:Ljava/lang/String; = "twitterOauthToken"

.field private static final PARAM_USERNAME:Ljava/lang/String; = "username"

.field private static final PARAM_USER_IDS:Ljava/lang/String; = "userIds[]"

.field private static final PARAM_VERIFY_EMAIL:Ljava/lang/String; = "verifyEmail"

.field private static final PARAM_VERIFY_PHONE_NUMBER:Ljava/lang/String; = "verifyPhoneNumber"

.field private static final PARAM_WITH_FAVORITES:Ljava/lang/String; = "withFavorites"

.field private static final REASON_PHRASE:Ljava/lang/String; = "reasonPhrase"

.field private static final SAMSUNG_BADGER_URI:Landroid/net/Uri;

.field public static final SERVICE_INTENT_FILTER:Landroid/content/IntentFilter;

.field public static final SHOW_POST_FILTER:Landroid/content/IntentFilter;

.field private static final START_CLASS_NAME:Ljava/lang/String;

.field private static final STATUS_CODE:Ljava/lang/String; = "statusCode"

.field private static final TAG:Ljava/lang/String; = "VineService"

.field private static final sActionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mAmazonBucket:Ljava/lang/String;

.field private mApi:Lco/vine/android/client/VineAPI;

.field private mExecutor:Ljava/util/concurrent/ExecutorService;

.field private final mHttpRequests:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lorg/apache/http/client/methods/HttpRequestBase;",
            ">;"
        }
    .end annotation
.end field

.field private final mMainHandler:Landroid/os/Handler;

.field private mMediaUtility:Lco/vine/android/util/MediaUtility;

.field private final mMessenger:Landroid/os/Messenger;

.field private final mServiceBroadCastReceiver:Landroid/content/BroadcastReceiver;

.field private mStartIds:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x3

    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 143
    new-instance v0, Landroid/content/IntentFilter;

    const-string v3, "co.vine.android.service.mergePost"

    invoke-direct {v0, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    sput-object v0, Lco/vine/android/service/VineService;->SERVICE_INTENT_FILTER:Landroid/content/IntentFilter;

    .line 144
    new-instance v0, Landroid/content/IntentFilter;

    const-string v3, "co.vine.android.service.mergePostFeed"

    invoke-direct {v0, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    sput-object v0, Lco/vine/android/service/VineService;->SHOW_POST_FILTER:Landroid/content/IntentFilter;

    .line 432
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "VineService"

    invoke-static {v0, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v2

    :goto_0
    sput-boolean v0, Lco/vine/android/service/VineService;->LOGGABLE:Z

    .line 441
    const-string v0, "content://com.sec.badge/apps"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/VineService;->SAMSUNG_BADGER_URI:Landroid/net/Uri;

    .line 443
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, v4}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lco/vine/android/service/VineService;->sActionMap:Ljava/util/HashMap;

    .line 459
    sget-object v0, Lco/vine/android/service/VineService;->sActionMap:Ljava/util/HashMap;

    const-string v3, "RESTART_CM"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 461
    sget-object v0, Lco/vine/android/service/VineService;->sActionMap:Ljava/util/HashMap;

    const-string v3, "co.vine.android.session.login"

    const/4 v4, 0x2

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3228
    const-class v0, Lco/vine/android/StartActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/VineService;->START_CLASS_NAME:Ljava/lang/String;

    .line 3230
    new-array v0, v2, [Ljava/lang/String;

    const-string v2, "co.vine.android"

    aput-object v2, v0, v1

    sput-object v0, Lco/vine/android/service/VineService;->BADGER_ARGS:[Ljava/lang/String;

    return-void

    :cond_1
    move v0, v1

    .line 432
    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 133
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 447
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/service/VineService;->mMainHandler:Landroid/os/Handler;

    .line 455
    new-instance v0, Landroid/os/Messenger;

    new-instance v1, Lco/vine/android/service/VineService$VineServiceHandler;

    invoke-direct {v1, p0}, Lco/vine/android/service/VineService$VineServiceHandler;-><init>(Lco/vine/android/service/VineService;)V

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lco/vine/android/service/VineService;->mMessenger:Landroid/os/Messenger;

    .line 456
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/VineService;->mHttpRequests:Ljava/util/concurrent/ConcurrentHashMap;

    .line 464
    new-instance v0, Lco/vine/android/service/VineService$1;

    invoke-direct {v0, p0}, Lco/vine/android/service/VineService$1;-><init>(Lco/vine/android/service/VineService;)V

    iput-object v0, p0, Lco/vine/android/service/VineService;->mServiceBroadCastReceiver:Landroid/content/BroadcastReceiver;

    .line 4049
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/service/VineService;)Ljava/util/concurrent/ExecutorService;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/VineService;

    .prologue
    .line 133
    iget-object v0, p0, Lco/vine/android/service/VineService;->mExecutor:Ljava/util/concurrent/ExecutorService;

    return-object v0
.end method

.method static synthetic access$100()Z
    .locals 1

    .prologue
    .line 133
    sget-boolean v0, Lco/vine/android/service/VineService;->LOGGABLE:Z

    return v0
.end method

.method static synthetic access$200(Lco/vine/android/service/VineService;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/VineService;

    .prologue
    .line 133
    iget-object v0, p0, Lco/vine/android/service/VineService;->mMainHandler:Landroid/os/Handler;

    return-object v0
.end method

.method private deleteComment(JLjava/lang/String;Lco/vine/android/provider/VineDatabaseHelper;)Lco/vine/android/network/HttpOperation;
    .locals 7
    .param p1, "postId"    # J
    .param p3, "commentId"    # Ljava/lang/String;
    .param p4, "dbHelper"    # Lco/vine/android/provider/VineDatabaseHelper;

    .prologue
    .line 3877
    iget-object v3, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v3}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string v6, "posts"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-string v6, "comments"

    aput-object v6, v4, v5

    const/4 v5, 0x3

    aput-object p3, v4, v5

    invoke-static {v3, v4}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 3879
    .local v1, "url":Ljava/lang/StringBuilder;
    const/4 v3, 0x7

    invoke-static {v3}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v2

    .line 3881
    .local v2, "vp":Lco/vine/android/api/VineParserReader;
    invoke-virtual {p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-static {v3, v1, v4, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v0

    .line 3885
    .local v0, "op":Lco/vine/android/network/HttpOperation;
    return-object v0
.end method

.method private getClientProfile()Lco/vine/android/network/HttpOperation;
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v5, 0x0

    .line 3889
    iget-object v4, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v4}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v4

    new-array v6, v8, [Ljava/lang/Object;

    const-string v7, "clientprofiles"

    aput-object v7, v6, v5

    invoke-static {v4, v6}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 3891
    .local v2, "url":Ljava/lang/StringBuilder;
    const-string v4, "Updating device profile for {} {} {}."

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    sget-object v7, Landroid/os/Build;->MODEL:Ljava/lang/String;

    aput-object v7, v6, v5

    sget-object v7, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    aput-object v7, v6, v8

    const/4 v7, 0x2

    sget v8, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v6}, Lcom/edisonwang/android/slog/SLog;->w(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 3892
    const-string v4, "model"

    sget-object v6, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-static {v2, v4, v6}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 3893
    const-string v4, "device"

    sget-object v6, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-static {v2, v4, v6}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 3894
    const-string v4, "sdkVersion"

    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-static {v2, v4, v6}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3895
    const-string v6, "memory"

    const-string v4, "activity"

    invoke-virtual {p0, v4}, Lco/vine/android/service/VineService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/app/ActivityManager;

    invoke-virtual {v4}, Landroid/app/ActivityManager;->getLargeMemoryClass()I

    move-result v4

    invoke-static {v2, v6, v4}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3897
    const/16 v4, 0xd

    invoke-static {v4}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v3

    .line 3899
    .local v3, "vp":Lco/vine/android/api/VineParserReader;
    invoke-virtual {p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v4

    iget-object v6, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-static {v4, v2, v3, v6}, Lco/vine/android/network/HttpOperation;->createGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v1

    .line 3901
    .local v1, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {v1}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 3902
    invoke-virtual {v3}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    .line 3903
    .local v0, "object":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 3904
    const-string v4, "Got client profile {}."

    invoke-static {v4, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 3905
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v4

    invoke-virtual {p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v4, v5, v0}, Lco/vine/android/AppImpl;->updateRecordConfigs(Landroid/content/Context;Lorg/json/JSONObject;)V

    .line 3912
    .end local v0    # "object":Lorg/json/JSONObject;
    :goto_0
    return-object v1

    .line 3907
    .restart local v0    # "object":Lorg/json/JSONObject;
    :cond_0
    const-string v4, "Error getting client profile."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 3910
    .end local v0    # "object":Lorg/json/JSONObject;
    :cond_1
    const-string v6, "Failed to update client profile: {}."

    if-eqz v1, :cond_2

    iget v4, v1, Lco/vine/android/network/HttpOperation;->statusCode:I

    :goto_1
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v6, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    :cond_2
    move v4, v5

    goto :goto_1
.end method

.method private getComments(JIJILjava/lang/String;Landroid/os/Bundle;Lco/vine/android/provider/VineDatabaseHelper;)Lco/vine/android/network/HttpOperation;
    .locals 9
    .param p1, "postId"    # J
    .param p3, "page"    # I
    .param p4, "anchor"    # J
    .param p6, "size"    # I
    .param p7, "key"    # Ljava/lang/String;
    .param p8, "b"    # Landroid/os/Bundle;
    .param p9, "dbHelper"    # Lco/vine/android/provider/VineDatabaseHelper;

    .prologue
    .line 3917
    iget-object v5, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v5}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string v8, "posts"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-string v8, "comments"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 3920
    .local v3, "url":Ljava/lang/StringBuilder;
    const-string v5, "page"

    invoke-static {v3, v5, p3}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3921
    const-wide/16 v5, 0x0

    cmp-long v5, p4, v5

    if-lez v5, :cond_0

    .line 3922
    const-string v5, "anchor"

    invoke-static {v3, v5, p4, p5}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    .line 3924
    :cond_0
    const-string v5, "size"

    invoke-static {v3, v5, p6}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3926
    const/4 v5, 0x6

    invoke-static {v5}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v4

    .line 3928
    .local v4, "vp":Lco/vine/android/api/VineParserReader;
    invoke-virtual {p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-static {v5, v3, v6, v4}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v2

    .line 3931
    .local v2, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {v2}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 3932
    invoke-virtual {v4}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VinePagedData;

    .line 3933
    .local v1, "comments":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineComment;>;"
    const-string v5, "next_page"

    iget v6, v1, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, p8

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3934
    const-string v5, "time"

    iget-wide v6, v1, Lco/vine/android/api/VinePagedData;->anchor:J

    move-object/from16 v0, p8

    invoke-virtual {v0, v5, v6, v7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 3935
    const-string v5, "previous_page"

    iget v6, v1, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, p8

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3936
    const-string v5, "comments"

    iget-object v6, v1, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, p8

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 3938
    .end local v1    # "comments":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineComment;>;"
    :cond_1
    return-object v2
.end method

.method private getConversationWithRemoteId(JJILco/vine/android/provider/VineDatabaseHelper;ZI)Lco/vine/android/api/VineConversation;
    .locals 22
    .param p1, "sessionOwnerId"    # J
    .param p3, "conversationId"    # J
    .param p5, "pageType"    # I
    .param p6, "dbHelper"    # Lco/vine/android/provider/VineDatabaseHelper;
    .param p7, "prefetch"    # Z
    .param p8, "networkTYpe"    # I

    .prologue
    .line 3696
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v4}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    const-string v7, "conversations"

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v20

    .line 3699
    .local v20, "url":Ljava/lang/StringBuilder;
    packed-switch p5, :pswitch_data_0

    .line 3714
    :cond_0
    :goto_0
    const-string v5, "prefetch"

    if-eqz p7, :cond_2

    const/4 v4, 0x1

    :goto_1
    move-object/from16 v0, v20

    invoke-static {v0, v5, v4}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3716
    const/16 v4, 0x16

    invoke-static {v4}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v21

    .line 3717
    .local v21, "vp":Lco/vine/android/api/VineParserReader;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-static {v4, v0, v5, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v17

    .line 3722
    .local v17, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual/range {v17 .. v17}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 3723
    invoke-virtual/range {v21 .. v21}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lco/vine/android/api/VineParsers$VinePagedConversation;

    .line 3724
    .local v15, "data":Lco/vine/android/api/VineParsers$VinePagedConversation;
    if-eqz v15, :cond_3

    iget-object v4, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    if-eqz v4, :cond_3

    iget-object v4, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_3

    .line 3725
    new-instance v3, Lco/vine/android/api/VineConversation;

    iget-wide v6, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->lastMessage:J

    iget-object v8, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    iget-wide v9, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->unreadMessageCount:J

    move-wide/from16 v4, p3

    invoke-direct/range {v3 .. v10}, Lco/vine/android/api/VineConversation;-><init>(JJLjava/util/ArrayList;J)V

    .line 3728
    .local v3, "conversation":Lco/vine/android/api/VineConversation;
    :try_start_0
    iget v9, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->nextPage:I

    iget v10, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->previousPage:I

    iget-wide v11, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->anchor:J

    move-object/from16 v4, p6

    move-wide/from16 v5, p1

    move-object v7, v3

    move/from16 v8, p8

    invoke-virtual/range {v4 .. v12}, Lco/vine/android/provider/VineDatabaseHelper;->mergeConversation(JLco/vine/android/api/VineConversation;IIIJ)J

    move-result-wide v13

    .line 3731
    .local v13, "conversationLocalObjectId":J
    iget v4, v15, Lco/vine/android/api/VineParsers$VinePagedConversation;->nextPage:I

    if-gtz v4, :cond_1

    .line 3732
    move-object/from16 v0, p6

    invoke-virtual {v0, v13, v14}, Lco/vine/android/provider/VineDatabaseHelper;->markLastMessage(J)V

    .line 3734
    :cond_1
    iput-wide v13, v3, Lco/vine/android/api/VineConversation;->conversationObjectId:J
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 3743
    .end local v3    # "conversation":Lco/vine/android/api/VineConversation;
    .end local v13    # "conversationLocalObjectId":J
    .end local v15    # "data":Lco/vine/android/api/VineParsers$VinePagedConversation;
    :goto_2
    return-object v3

    .line 3702
    .end local v17    # "op":Lco/vine/android/network/HttpOperation;
    .end local v21    # "vp":Lco/vine/android/api/VineParserReader;
    :pswitch_0
    const-string v4, "page"

    const/4 v5, 0x1

    move-object/from16 v0, v20

    invoke-static {v0, v4, v5}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    goto :goto_0

    .line 3705
    :pswitch_1
    const/4 v4, 0x7

    const/4 v5, 0x0

    invoke-static/range {p3 .. p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    move-object/from16 v0, p6

    invoke-virtual {v0, v4, v5, v6, v7}, Lco/vine/android/provider/VineDatabaseHelper;->getNextPageCursor(IILjava/lang/String;Z)I

    move-result v4

    int-to-long v0, v4

    move-wide/from16 v18, v0

    .line 3707
    .local v18, "page":J
    const-wide/16 v4, 0x0

    cmp-long v4, v18, v4

    if-lez v4, :cond_0

    .line 3708
    const-string v4, "page"

    move-object/from16 v0, v20

    move-wide/from16 v1, v18

    invoke-static {v0, v4, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    goto/16 :goto_0

    .line 3714
    .end local v18    # "page":J
    :cond_2
    const/4 v4, 0x0

    goto/16 :goto_1

    .line 3736
    .restart local v3    # "conversation":Lco/vine/android/api/VineConversation;
    .restart local v15    # "data":Lco/vine/android/api/VineParsers$VinePagedConversation;
    .restart local v17    # "op":Lco/vine/android/network/HttpOperation;
    .restart local v21    # "vp":Lco/vine/android/api/VineParserReader;
    :catch_0
    move-exception v16

    .line 3737
    .local v16, "e":Ljava/io/IOException;
    sget-boolean v4, Lco/vine/android/service/VineService;->LOGGABLE:Z

    if-eqz v4, :cond_3

    .line 3738
    invoke-virtual/range {v16 .. v16}, Ljava/io/IOException;->printStackTrace()V

    .line 3743
    .end local v3    # "conversation":Lco/vine/android/api/VineConversation;
    .end local v15    # "data":Lco/vine/android/api/VineParsers$VinePagedConversation;
    .end local v16    # "e":Ljava/io/IOException;
    :cond_3
    const/4 v3, 0x0

    goto :goto_2

    .line 3699
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private getInbox(JIILjava/lang/String;Lco/vine/android/provider/VineDatabaseHelper;Landroid/os/Bundle;)Lco/vine/android/network/HttpOperation;
    .locals 16
    .param p1, "sessionOwnerId"    # J
    .param p3, "pageType"    # I
    .param p4, "actionCode"    # I
    .param p5, "key"    # Ljava/lang/String;
    .param p6, "dbHelper"    # Lco/vine/android/provider/VineDatabaseHelper;
    .param p7, "b"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 3749
    const-string v1, "network"

    const/4 v2, -0x1

    move-object/from16 v0, p7

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v9

    .line 3751
    .local v9, "networkType":I
    const/4 v12, 0x1

    .line 3752
    .local v12, "page":I
    packed-switch p3, :pswitch_data_0

    .line 3774
    :cond_0
    :goto_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v1}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const-string v5, "conversations"

    aput-object v5, v2, v3

    invoke-static {v1, v2}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    .line 3777
    .local v14, "url":Ljava/lang/StringBuilder;
    const/4 v1, -0x1

    if-ne v9, v1, :cond_1

    .line 3778
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Invalid network type."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 3755
    .end local v14    # "url":Ljava/lang/StringBuilder;
    :pswitch_0
    const/4 v12, 0x1

    .line 3756
    goto :goto_0

    .line 3759
    :pswitch_1
    const/4 v1, 0x6

    const/4 v2, 0x0

    const/4 v3, 0x1

    move-object/from16 v0, p6

    invoke-virtual {v0, v1, v9, v2, v3}, Lco/vine/android/provider/VineDatabaseHelper;->getPreviousPageCursor(IILjava/lang/String;Z)I

    move-result v13

    .line 3761
    .local v13, "previous":I
    if-lez v13, :cond_0

    .line 3762
    move v12, v13

    goto :goto_0

    .line 3781
    .end local v13    # "previous":I
    .restart local v14    # "url":Ljava/lang/StringBuilder;
    :cond_1
    const/16 v1, 0x19

    invoke-static {v1}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v15

    .line 3783
    .local v15, "vp":Lco/vine/android/api/VineParserReader;
    const/4 v1, 0x1

    if-ne v1, v9, :cond_3

    .line 3784
    const/16 v10, 0xa

    .line 3790
    .local v10, "userGroup":I
    :goto_1
    const-string v1, "page"

    invoke-static {v14, v1, v12}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3791
    const-string v1, "size"

    const/16 v2, 0xa

    invoke-static {v14, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3793
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, p5

    invoke-static {v1, v14, v2, v15, v0}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v11

    .line 3797
    .local v11, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {v11}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 3798
    invoke-virtual {v15}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VineParsers$VinePagedInbox;

    .line 3800
    .local v4, "data":Lco/vine/android/api/VineParsers$VinePagedInbox;
    iget-object v1, v4, Lco/vine/android/api/VineParsers$VinePagedInbox;->items:Ljava/util/ArrayList;

    if-eqz v1, :cond_2

    iget-object v1, v4, Lco/vine/android/api/VineParsers$VinePagedInbox;->items:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 3801
    iget v5, v4, Lco/vine/android/api/VineParsers$VinePagedInbox;->nextPage:I

    iget v6, v4, Lco/vine/android/api/VineParsers$VinePagedInbox;->previousPage:I

    iget-wide v7, v4, Lco/vine/android/api/VineParsers$VinePagedInbox;->anchor:J

    move-object/from16 v1, p6

    move-wide/from16 v2, p1

    invoke-virtual/range {v1 .. v10}, Lco/vine/android/provider/VineDatabaseHelper;->mergeInbox(JLco/vine/android/api/VineParsers$VinePagedInbox;IIJII)V

    .line 3804
    const-string v1, "count"

    iget-object v2, v4, Lco/vine/android/api/VineParsers$VinePagedInbox;->items:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    move-object/from16 v0, p7

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3805
    iget v1, v4, Lco/vine/android/api/VineParsers$VinePagedInbox;->nextPage:I

    if-gtz v1, :cond_2

    .line 3806
    move-object/from16 v0, p6

    invoke-virtual {v0, v9}, Lco/vine/android/provider/VineDatabaseHelper;->markLastConversation(I)V

    .line 3811
    .end local v4    # "data":Lco/vine/android/api/VineParsers$VinePagedInbox;
    :cond_2
    return-object v11

    .line 3786
    .end local v10    # "userGroup":I
    .end local v11    # "op":Lco/vine/android/network/HttpOperation;
    :cond_3
    const-string v1, "inbox"

    const-string v2, "other"

    invoke-static {v14, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 3787
    const/16 v10, 0xb

    .restart local v10    # "userGroup":I
    goto :goto_1

    .line 3752
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private getPosts(JIILco/vine/android/provider/VineDatabaseHelper;JIJLandroid/os/Bundle;)Lco/vine/android/network/HttpOperation;
    .locals 23
    .param p1, "sessionOwnerId"    # J
    .param p3, "type"    # I
    .param p4, "size"    # I
    .param p5, "dbHelper"    # Lco/vine/android/provider/VineDatabaseHelper;
    .param p6, "userId"    # J
    .param p8, "page"    # I
    .param p9, "anchor"    # J
    .param p11, "b"    # Landroid/os/Bundle;

    .prologue
    .line 3573
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v4

    .line 3575
    .local v4, "base":Ljava/lang/String;
    const-string v20, "tag_name"

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 3577
    .local v17, "tag":Ljava/lang/String;
    if-nez v17, :cond_0

    const/16 v20, 0x6

    move/from16 v0, p3

    move/from16 v1, v20

    if-eq v0, v1, :cond_0

    .line 3578
    invoke-static/range {p1 .. p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v17

    .line 3579
    const-string v20, "tag_name"

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move-object/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 3581
    :cond_0
    packed-switch p3, :pswitch_data_0

    .line 3648
    :pswitch_0
    new-instance v20, Ljava/lang/IllegalArgumentException;

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Tried to fetch timeline with unsupported type "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    move/from16 v1, p3

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-direct/range {v20 .. v21}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v20

    .line 3583
    :pswitch_1
    const/16 v20, 0x2

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    const-string v22, "graph"

    aput-object v22, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3585
    .local v18, "url":Ljava/lang/StringBuilder;
    const/4 v13, 0x2

    .line 3653
    .local v13, "pageCursorKind":I
    :goto_0
    const-string v20, "page"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move/from16 v2, p8

    invoke-static {v0, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3654
    const-string v20, "anchor"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move-wide/from16 v2, p9

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    .line 3656
    const-string v20, "size"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move/from16 v2, p4

    invoke-static {v0, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3658
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineService;->limitCommentAndLikesIfNeeded(Ljava/lang/StringBuilder;)V

    .line 3660
    const/16 v20, 0x8

    invoke-static/range {v20 .. v20}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v19

    .line 3662
    .local v19, "vp":Lco/vine/android/api/VineParserReader;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v21, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    move-object/from16 v2, v21

    move-object/from16 v3, v19

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v12

    .line 3666
    .local v12, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {v12}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v20

    if-eqz v20, :cond_5

    .line 3667
    invoke-virtual/range {v19 .. v19}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lco/vine/android/api/VinePagedData;

    .line 3669
    .local v10, "feedItems":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    invoke-static/range {p3 .. p3}, Lco/vine/android/util/Util;->isPopularTimeline(I)Z

    move-result v20

    if-eqz v20, :cond_4

    .line 3670
    const/4 v7, 0x1

    .line 3671
    .local v7, "count":I
    move-object/from16 v0, p5

    move/from16 v1, p3

    invoke-virtual {v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getOldestSortId(I)Landroid/database/Cursor;

    move-result-object v5

    .line 3672
    .local v5, "c":Landroid/database/Cursor;
    if-eqz v5, :cond_2

    .line 3673
    invoke-interface {v5}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v20

    if-eqz v20, :cond_1

    .line 3674
    const/16 v20, 0x0

    move/from16 v0, v20

    invoke-interface {v5, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v20

    add-int/lit8 v7, v20, 0x1

    .line 3676
    :cond_1
    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    .line 3678
    :cond_2
    iget-object v0, v10, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_4

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lco/vine/android/api/VinePost;

    .line 3679
    .local v15, "post":Lco/vine/android/api/VinePost;
    add-int/lit8 v8, v7, 0x1

    .end local v7    # "count":I
    .local v8, "count":I
    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    iput-object v0, v15, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    move v7, v8

    .line 3680
    .end local v8    # "count":I
    .restart local v7    # "count":I
    goto :goto_1

    .line 3589
    .end local v5    # "c":Landroid/database/Cursor;
    .end local v7    # "count":I
    .end local v10    # "feedItems":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    .end local v11    # "i$":Ljava/util/Iterator;
    .end local v12    # "op":Lco/vine/android/network/HttpOperation;
    .end local v13    # "pageCursorKind":I
    .end local v15    # "post":Lco/vine/android/api/VinePost;
    .end local v18    # "url":Ljava/lang/StringBuilder;
    .end local v19    # "vp":Lco/vine/android/api/VineParserReader;
    :pswitch_2
    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    const-string v22, "users"

    aput-object v22, v20, v21

    const/16 v21, 0x2

    invoke-static/range {p6 .. p7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    aput-object v22, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3591
    .restart local v18    # "url":Ljava/lang/StringBuilder;
    const/4 v13, 0x2

    .line 3592
    .restart local v13    # "pageCursorKind":I
    const-string v20, "reposts"

    const/16 v21, 0x1

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3593
    const-string v20, "c_overflow"

    const-string v21, "trunc"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    invoke-static {v0, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 3597
    .end local v13    # "pageCursorKind":I
    .end local v18    # "url":Ljava/lang/StringBuilder;
    :pswitch_3
    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    const-string v22, "users"

    aput-object v22, v20, v21

    const/16 v21, 0x2

    invoke-static/range {p6 .. p7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    aput-object v22, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3599
    .restart local v18    # "url":Ljava/lang/StringBuilder;
    const/4 v13, 0x2

    .line 3600
    .restart local v13    # "pageCursorKind":I
    const-string v20, "reposts"

    const/16 v21, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 3604
    .end local v13    # "pageCursorKind":I
    .end local v18    # "url":Ljava/lang/StringBuilder;
    :pswitch_4
    const/16 v20, 0x4

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    const-string v22, "users"

    aput-object v22, v20, v21

    const/16 v21, 0x2

    invoke-static/range {p6 .. p7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v22

    aput-object v22, v20, v21

    const/16 v21, 0x3

    const-string v22, "likes"

    aput-object v22, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3606
    .restart local v18    # "url":Ljava/lang/StringBuilder;
    const/4 v13, 0x1

    .line 3607
    .restart local v13    # "pageCursorKind":I
    goto/16 :goto_0

    .line 3610
    .end local v13    # "pageCursorKind":I
    .end local v18    # "url":Ljava/lang/StringBuilder;
    :pswitch_5
    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    const-string v22, "users"

    aput-object v22, v20, v21

    const/16 v21, 0x2

    const-string v22, "trending"

    aput-object v22, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3612
    .restart local v18    # "url":Ljava/lang/StringBuilder;
    const/4 v13, 0x2

    .line 3614
    .restart local v13    # "pageCursorKind":I
    goto/16 :goto_0

    .line 3617
    .end local v13    # "pageCursorKind":I
    .end local v18    # "url":Ljava/lang/StringBuilder;
    :pswitch_6
    const/16 v20, 0x2

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    const-string v22, "popular"

    aput-object v22, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3619
    .restart local v18    # "url":Ljava/lang/StringBuilder;
    const/4 v13, 0x2

    .line 3620
    .restart local v13    # "pageCursorKind":I
    goto/16 :goto_0

    .line 3623
    .end local v13    # "pageCursorKind":I
    .end local v18    # "url":Ljava/lang/StringBuilder;
    :pswitch_7
    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    const-string v22, "tags"

    aput-object v22, v20, v21

    const/16 v21, 0x2

    aput-object v17, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3625
    .restart local v18    # "url":Ljava/lang/StringBuilder;
    const/4 v13, 0x2

    .line 3626
    .restart local v13    # "pageCursorKind":I
    goto/16 :goto_0

    .line 3630
    .end local v13    # "pageCursorKind":I
    .end local v18    # "url":Ljava/lang/StringBuilder;
    :pswitch_8
    const-string v20, "tag_name"

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 3631
    .local v6, "channelId":Ljava/lang/String;
    const-string v20, "sort"

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 3632
    .local v16, "sort":Ljava/lang/String;
    const/16 v20, 0x4

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    const-string v22, "channels"

    aput-object v22, v20, v21

    const/16 v21, 0x2

    aput-object v6, v20, v21

    const/16 v21, 0x3

    aput-object v16, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3634
    .restart local v18    # "url":Ljava/lang/StringBuilder;
    const/4 v13, 0x2

    .line 3635
    .restart local v13    # "pageCursorKind":I
    goto/16 :goto_0

    .line 3638
    .end local v6    # "channelId":Ljava/lang/String;
    .end local v13    # "pageCursorKind":I
    .end local v16    # "sort":Ljava/lang/String;
    .end local v18    # "url":Ljava/lang/StringBuilder;
    :pswitch_9
    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string v22, "timelines"

    aput-object v22, v20, v21

    move-object/from16 v0, v20

    invoke-static {v4, v0}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3639
    .restart local v18    # "url":Ljava/lang/StringBuilder;
    const-string v20, "data"

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v9

    check-cast v9, Landroid/net/Uri;

    .line 3640
    .local v9, "data":Landroid/net/Uri;
    invoke-virtual {v9}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .restart local v11    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_3

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    .line 3641
    .local v14, "pathSegment":Ljava/lang/String;
    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    const/16 v21, 0x1

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    const/16 v22, 0x0

    aput-object v14, v21, v22

    invoke-static/range {v20 .. v21}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 3642
    goto :goto_2

    .line 3643
    .end local v14    # "pathSegment":Ljava/lang/String;
    :cond_3
    invoke-virtual {v9}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 3644
    const/4 v13, 0x2

    .line 3645
    .restart local v13    # "pageCursorKind":I
    goto/16 :goto_0

    .line 3683
    .end local v9    # "data":Landroid/net/Uri;
    .end local v11    # "i$":Ljava/util/Iterator;
    .restart local v10    # "feedItems":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    .restart local v12    # "op":Lco/vine/android/network/HttpOperation;
    .restart local v19    # "vp":Lco/vine/android/api/VineParserReader;
    :cond_4
    const-string v20, "count"

    iget-object v0, v10, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/util/ArrayList;->size()I

    move-result v21

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3684
    const-string v20, "size"

    iget v0, v10, Lco/vine/android/api/VinePagedData;->count:I

    move/from16 v21, v0

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3685
    const-string v20, "posts"

    iget-object v0, v10, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v21, v0

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 3686
    const-string v20, "in_memory"

    const/16 v21, 0x1

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 3687
    const-string v20, "next_page"

    iget v0, v10, Lco/vine/android/api/VinePagedData;->nextPage:I

    move/from16 v21, v0

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3688
    const-string v20, "previous_page"

    iget v0, v10, Lco/vine/android/api/VinePagedData;->previousPage:I

    move/from16 v21, v0

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3689
    const-string v20, "time"

    iget-wide v0, v10, Lco/vine/android/api/VinePagedData;->anchor:J

    move-wide/from16 v21, v0

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move-wide/from16 v2, v21

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 3690
    const-string v20, "title"

    iget-object v0, v10, Lco/vine/android/api/VinePagedData;->title:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, p11

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 3692
    .end local v10    # "feedItems":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    :cond_5
    return-object v12

    .line 3581
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_0
        :pswitch_8
        :pswitch_8
        :pswitch_3
        :pswitch_9
    .end packed-switch
.end method

.method private getUsersMe(Ljava/lang/String;Landroid/os/Bundle;)Lco/vine/android/network/HttpOperation;
    .locals 10
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "b"    # Landroid/os/Bundle;

    .prologue
    const/4 v9, 0x2

    .line 3942
    iget-object v5, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v5}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v5

    new-array v6, v9, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string v8, "users"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string v8, "me"

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 3945
    .local v2, "url":Ljava/lang/StringBuilder;
    invoke-static {v9}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v4

    .line 3947
    .local v4, "vp":Lco/vine/android/api/VineParserReader;
    invoke-virtual {p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-static {v5, v2, v6, v4}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v1

    .line 3950
    .local v1, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {v1}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 3951
    invoke-virtual {v4}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/api/VineUser;

    .line 3952
    .local v3, "user":Lco/vine/android/api/VineUser;
    invoke-static {p0}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v0

    .line 3953
    .local v0, "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    invoke-virtual {v0, v3}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUserAndGetResultingRowId(Lco/vine/android/api/VineUser;)J

    move-result-wide v5

    iput-wide v5, v3, Lco/vine/android/api/VineUser;->id:J

    .line 3954
    const-string v5, "user"

    invoke-virtual {p2, v5, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 3956
    .end local v0    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .end local v3    # "user":Lco/vine/android/api/VineUser;
    :cond_0
    return-object v1
.end method

.method private handleSingleVinePrivateMessageResponse(Landroid/content/Context;Lco/vine/android/provider/VineDatabaseHelper;Lco/vine/android/api/VinePrivateMessageResponse;Lco/vine/android/api/VineUpload$PostInfo;JJ)V
    .locals 31
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dbHelper"    # Lco/vine/android/provider/VineDatabaseHelper;
    .param p3, "vpmr"    # Lco/vine/android/api/VinePrivateMessageResponse;
    .param p4, "info"    # Lco/vine/android/api/VineUpload$PostInfo;
    .param p5, "messageIdToMerge"    # J
    .param p7, "conversationRowIdToMerge"    # J

    .prologue
    .line 3508
    invoke-static/range {p1 .. p1}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v6

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v7}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v9

    .line 3512
    .local v9, "userRowId":J
    move-object/from16 v0, p3

    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessageResponse;->error:Lco/vine/android/api/VineError;

    if-eqz v3, :cond_0

    .line 3513
    move-object/from16 v0, p3

    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessageResponse;->error:Lco/vine/android/api/VineError;

    iget v0, v3, Lco/vine/android/api/VineError;->errorCode:I

    move/from16 v27, v0

    .line 3514
    .local v27, "errorCode":I
    move-object/from16 v0, p3

    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessageResponse;->error:Lco/vine/android/api/VineError;

    iget-object v0, v3, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    move-object/from16 v28, v0

    .line 3520
    .local v28, "errorReason":Ljava/lang/String;
    :goto_0
    new-instance v2, Lco/vine/android/api/VinePrivateMessage;

    const-wide/16 v3, -0x1

    move-object/from16 v0, p3

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessageResponse;->conversationId:J

    move-object/from16 v0, p3

    iget-wide v7, v0, Lco/vine/android/api/VinePrivateMessageResponse;->messageId:J

    move-object/from16 v0, p4

    iget-wide v11, v0, Lco/vine/android/api/VineUpload$PostInfo;->created:J

    move-object/from16 v0, p4

    iget-object v13, v0, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    move-object/from16 v0, p3

    iget-object v14, v0, Lco/vine/android/api/VinePrivateMessageResponse;->videoUrl:Ljava/lang/String;

    move-object/from16 v0, p3

    iget-object v15, v0, Lco/vine/android/api/VinePrivateMessageResponse;->thumbnailUrl:Ljava/lang/String;

    const/16 v16, 0x1

    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v0, p4

    iget v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    move/from16 v19, v0

    const-wide/16 v20, 0x0

    move-object/from16 v0, p4

    iget v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    move/from16 v22, v0

    if-lez v22, :cond_1

    move-object/from16 v0, p4

    iget v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    move/from16 v22, v0

    const v23, 0x7fffffff

    move/from16 v0, v22

    move/from16 v1, v23

    if-ge v0, v1, :cond_1

    const/16 v22, 0x1

    :goto_1
    const-wide/16 v23, 0x0

    move-object/from16 v0, p4

    iget-wide v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->postId:J

    move-wide/from16 v25, v0

    invoke-direct/range {v2 .. v28}, Lco/vine/android/api/VinePrivateMessage;-><init>(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIJZJJILjava/lang/String;)V

    .line 3527
    .local v2, "vpm":Lco/vine/android/api/VinePrivateMessage;
    const-wide/16 v6, 0x0

    cmp-long v3, p5, v6

    if-lez v3, :cond_2

    move-object/from16 v3, p2

    move-wide/from16 v4, p5

    move-wide/from16 v6, p7

    move-object v8, v2

    .line 3528
    invoke-virtual/range {v3 .. v8}, Lco/vine/android/provider/VineDatabaseHelper;->mergeMessageWithMessageRow(JJLco/vine/android/api/VinePrivateMessage;)J

    move-result-wide v14

    .line 3530
    .local v14, "finalMessageRowId":J
    iget-wide v0, v2, Lco/vine/android/api/VinePrivateMessage;->created:J

    move-wide/from16 v16, v0

    move-object/from16 v11, p2

    move-wide/from16 v12, p7

    invoke-virtual/range {v11 .. v17}, Lco/vine/android/provider/VineDatabaseHelper;->updateConversationWithLastMessage(JJJ)V

    .line 3556
    .end local v14    # "finalMessageRowId":J
    :goto_2
    const-string v3, "VM post successful, sending merge broadcast now"

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 3557
    new-instance v29, Landroid/content/Intent;

    const-string v3, "co.vine.android.service.mergeSelfNewMessage"

    move-object/from16 v0, v29

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 3558
    .local v29, "intent":Landroid/content/Intent;
    const-string v3, "conversation_id"

    iget-wide v6, v2, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    move-object/from16 v0, v29

    invoke-virtual {v0, v3, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 3559
    const-string v3, "message_id"

    iget-wide v6, v2, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    move-object/from16 v0, v29

    invoke-virtual {v0, v3, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 3560
    const-string v3, "co.vine.android.BROADCAST"

    move-object/from16 v0, p1

    move-object/from16 v1, v29

    invoke-virtual {v0, v1, v3}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 3561
    return-void

    .line 3516
    .end local v2    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    .end local v27    # "errorCode":I
    .end local v28    # "errorReason":Ljava/lang/String;
    .end local v29    # "intent":Landroid/content/Intent;
    :cond_0
    const/16 v27, 0x0

    .line 3517
    .restart local v27    # "errorCode":I
    const/16 v28, 0x0

    .restart local v28    # "errorReason":Ljava/lang/String;
    goto/16 :goto_0

    .line 3520
    :cond_1
    const/16 v22, 0x0

    goto :goto_1

    .line 3533
    .restart local v2    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    :cond_2
    new-instance v30, Ljava/util/HashSet;

    invoke-direct/range {v30 .. v30}, Ljava/util/HashSet;-><init>()V

    .line 3535
    .local v30, "userRowIds":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Long;>;"
    move-object/from16 v0, p3

    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessageResponse;->recipient:Lco/vine/android/api/VineRecipient;

    iget-wide v6, v3, Lco/vine/android/api/VineRecipient;->recipientId:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v30

    invoke-virtual {v0, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 3537
    const-wide/16 v4, -0x1

    .line 3538
    .local v4, "conversationRowId":J
    move-object/from16 v0, p3

    iget-wide v6, v0, Lco/vine/android/api/VinePrivateMessageResponse;->conversationId:J

    const-wide/16 v11, 0x0

    cmp-long v3, v6, v11

    if-lez v3, :cond_4

    .line 3540
    move-object/from16 v0, p3

    iget-wide v6, v0, Lco/vine/android/api/VinePrivateMessageResponse;->conversationId:J

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v7}, Lco/vine/android/provider/VineDatabaseHelper;->getConversationRowId(J)J

    move-result-wide v4

    .line 3547
    :goto_3
    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-gtz v3, :cond_3

    .line 3548
    const/4 v3, 0x1

    move-object/from16 v0, p2

    move-object/from16 v1, v30

    invoke-virtual {v0, v1, v3}, Lco/vine/android/provider/VineDatabaseHelper;->createConversationRowId(Ljava/util/HashSet;I)J

    move-result-wide v4

    .line 3549
    move-object/from16 v0, p3

    iget-wide v6, v0, Lco/vine/android/api/VinePrivateMessageResponse;->conversationId:J

    const/4 v8, 0x1

    move-object/from16 v3, p2

    invoke-virtual/range {v3 .. v8}, Lco/vine/android/provider/VineDatabaseHelper;->mergeConversationWithLocalId(JJI)J

    .line 3552
    :cond_3
    move-object/from16 v0, p2

    invoke-virtual {v0, v4, v5, v2}, Lco/vine/android/provider/VineDatabaseHelper;->mergeMessage(JLco/vine/android/api/VinePrivateMessage;)J

    move-result-wide v19

    .line 3553
    .local v19, "messageId":J
    iget-wide v0, v2, Lco/vine/android/api/VinePrivateMessage;->created:J

    move-wide/from16 v21, v0

    move-object/from16 v16, p2

    move-wide/from16 v17, v4

    invoke-virtual/range {v16 .. v22}, Lco/vine/android/provider/VineDatabaseHelper;->updateConversationWithLastMessage(JJJ)V

    goto/16 :goto_2

    .line 3542
    .end local v19    # "messageId":J
    :cond_4
    move-object/from16 v0, p3

    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessageResponse;->recipient:Lco/vine/android/api/VineRecipient;

    iget-wide v6, v3, Lco/vine/android/api/VineRecipient;->recipientId:J

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v7}, Lco/vine/android/provider/VineDatabaseHelper;->determineBestConversationRowIdForUserRowId(J)J

    move-result-wide v4

    goto :goto_3
.end method

.method private handleVinePrivateMessageResponses(Landroid/content/Context;Lco/vine/android/api/VineUpload;Lco/vine/android/api/VineUpload$PostInfo;Lco/vine/android/api/VineParserReader;Landroid/os/Bundle;)V
    .locals 23
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "upload"    # Lco/vine/android/api/VineUpload;
    .param p3, "info"    # Lco/vine/android/api/VineUpload$PostInfo;
    .param p4, "vp"    # Lco/vine/android/api/VineParserReader;
    .param p5, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 3415
    invoke-virtual/range {p4 .. p4}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;

    .line 3416
    .local v16, "serverResponse":Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;
    move-object/from16 v0, v16

    iget-object v13, v0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->responses:Ljava/util/ArrayList;

    .line 3417
    .local v13, "messageResponses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePrivateMessageResponse;>;"
    move-object/from16 v0, v16

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->users:Ljava/util/ArrayList;

    move-object/from16 v21, v0

    .line 3418
    .local v21, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v16

    iget-object v15, v0, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;->recipients:Ljava/util/ArrayList;

    .line 3420
    .local v15, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    invoke-static/range {p1 .. p1}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v2

    .line 3421
    .local v2, "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    move-object/from16 v0, p2

    iget-wide v3, v0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    invoke-virtual {v2, v3, v4}, Lco/vine/android/provider/VineDatabaseHelper;->getMessageFromMessageRow(J)Lco/vine/android/api/VinePrivateMessage;

    move-result-object v14

    .line 3423
    .local v14, "premergedMessage":Lco/vine/android/api/VinePrivateMessage;
    move-object/from16 v0, p2

    iget-wide v3, v0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    const-wide/16 v10, 0x0

    cmp-long v3, v3, v10

    if-lez v3, :cond_0

    if-nez v14, :cond_1

    .line 3424
    :cond_0
    const-string v3, "No local message to merge with."

    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 3503
    :goto_0
    return-void

    .line 3428
    :cond_1
    if-eqz v21, :cond_2

    .line 3429
    iget-wide v3, v14, Lco/vine/android/api/VinePrivateMessage;->conversationRowId:J

    move-object/from16 v0, v21

    invoke-virtual {v2, v3, v4, v15, v0}, Lco/vine/android/provider/VineDatabaseHelper;->mergeRecipientsWithUsersAndRemoveUnusedRecipients(JLjava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 3436
    :cond_2
    const-wide/16 v8, -0x1

    .line 3438
    .local v8, "messageIdToMerge":J
    if-eqz v13, :cond_3

    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v3

    const/4 v4, 0x1

    if-ge v3, v4, :cond_5

    .line 3440
    :cond_3
    const-string v4, "No vine private message responses, deleting the conversation and bailing. Response is null: {}"

    const/4 v3, 0x1

    new-array v5, v3, [Ljava/lang/Object;

    const/4 v7, 0x0

    if-nez v13, :cond_4

    const/4 v3, 0x1

    :goto_1
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 3441
    const-wide/16 v3, -0x1

    iget-wide v10, v14, Lco/vine/android/api/VinePrivateMessage;->conversationRowId:J

    invoke-virtual {v2, v3, v4, v10, v11}, Lco/vine/android/provider/VineDatabaseHelper;->deleteConversation(JJ)V

    goto :goto_0

    .line 3440
    :cond_4
    const/4 v3, 0x0

    goto :goto_1

    .line 3443
    :cond_5
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_e

    .line 3445
    iget-wide v3, v14, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    const-wide/16 v10, 0x0

    cmp-long v3, v3, v10

    if-gtz v3, :cond_6

    .line 3446
    iget-wide v3, v14, Lco/vine/android/api/VinePrivateMessage;->conversationRowId:J

    const/4 v5, 0x0

    invoke-virtual {v13, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/api/VinePrivateMessageResponse;

    iget-wide v5, v5, Lco/vine/android/api/VinePrivateMessageResponse;->conversationId:J

    iget v7, v14, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    invoke-virtual/range {v2 .. v7}, Lco/vine/android/provider/VineDatabaseHelper;->mergeConversationWithLocalId(JJI)J

    move-result-wide v3

    iput-wide v3, v14, Lco/vine/android/api/VinePrivateMessage;->conversationRowId:J

    .line 3450
    :cond_6
    move-object/from16 v0, p2

    iget-wide v8, v0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    .line 3456
    :goto_2
    const/16 v18, 0x0

    .line 3457
    .local v18, "smsFormatter":Ljava/lang/String;
    const/16 v17, 0x0

    .line 3458
    .local v17, "smsFooter":Ljava/lang/String;
    const/16 v22, 0x0

    .line 3459
    .local v22, "videoUrl":Ljava/lang/String;
    const/16 v20, 0x0

    .line 3460
    .local v20, "thumbnailUrl":Ljava/lang/String;
    invoke-virtual {v13}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .local v12, "i$":Ljava/util/Iterator;
    :cond_7
    :goto_3
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_10

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/api/VinePrivateMessageResponse;

    .line 3461
    .local v6, "vpmr":Lco/vine/android/api/VinePrivateMessageResponse;
    if-eqz v6, :cond_7

    .line 3464
    iget-object v3, v6, Lco/vine/android/api/VinePrivateMessageResponse;->recipient:Lco/vine/android/api/VineRecipient;

    if-eqz v3, :cond_b

    iget-object v3, v6, Lco/vine/android/api/VinePrivateMessageResponse;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v3, v3, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    const-string v4, "phoneNumber"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_b

    iget-object v3, v6, Lco/vine/android/api/VinePrivateMessageResponse;->shareUrl:Ljava/lang/String;

    if-eqz v3, :cond_b

    .line 3467
    if-nez v18, :cond_8

    .line 3468
    const v3, 0x7f0e0229

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v18

    .line 3471
    :cond_8
    if-nez v17, :cond_9

    .line 3472
    const v3, 0x7f0e0228

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v17

    .line 3476
    :cond_9
    move-object/from16 v0, p3

    iget-object v3, v0, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_a

    move-object/from16 v0, p3

    iget v3, v0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    if-lez v3, :cond_f

    .line 3477
    :cond_a
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, v6, Lco/vine/android/api/VinePrivateMessageResponse;->shareUrl:Ljava/lang/String;

    aput-object v5, v3, v4

    move-object/from16 v0, v18

    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    .line 3482
    .local v19, "text":Ljava/lang/String;
    :goto_4
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    .line 3484
    const-string v3, "Send SMS to {} with text {}"

    iget-object v4, v6, Lco/vine/android/api/VinePrivateMessageResponse;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v4, v4, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-static {v3, v4, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 3485
    iget-object v3, v6, Lco/vine/android/api/VinePrivateMessageResponse;->recipient:Lco/vine/android/api/VineRecipient;

    iget-object v3, v3, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-static {v3, v0}, Lco/vine/android/util/SMSUtil;->sendSMS(Ljava/lang/String;Ljava/lang/String;)Z

    .line 3488
    .end local v19    # "text":Ljava/lang/String;
    :cond_b
    iget-object v3, v6, Lco/vine/android/api/VinePrivateMessageResponse;->videoUrl:Ljava/lang/String;

    if-eqz v3, :cond_c

    .line 3489
    iget-object v0, v6, Lco/vine/android/api/VinePrivateMessageResponse;->videoUrl:Ljava/lang/String;

    move-object/from16 v22, v0

    .line 3491
    :cond_c
    iget-object v3, v6, Lco/vine/android/api/VinePrivateMessageResponse;->thumbnailUrl:Ljava/lang/String;

    if-eqz v3, :cond_d

    .line 3492
    iget-object v0, v6, Lco/vine/android/api/VinePrivateMessageResponse;->thumbnailUrl:Ljava/lang/String;

    move-object/from16 v20, v0

    .line 3495
    :cond_d
    iget-wide v10, v14, Lco/vine/android/api/VinePrivateMessage;->conversationRowId:J

    move-object/from16 v3, p0

    move-object/from16 v4, p1

    move-object v5, v2

    move-object/from16 v7, p3

    invoke-direct/range {v3 .. v11}, Lco/vine/android/service/VineService;->handleSingleVinePrivateMessageResponse(Landroid/content/Context;Lco/vine/android/provider/VineDatabaseHelper;Lco/vine/android/api/VinePrivateMessageResponse;Lco/vine/android/api/VineUpload$PostInfo;JJ)V

    .line 3497
    iget-object v3, v6, Lco/vine/android/api/VinePrivateMessageResponse;->error:Lco/vine/android/api/VineError;

    if-eqz v3, :cond_7

    .line 3498
    const-string v3, "should_delete_upload"

    const/4 v4, 0x1

    move-object/from16 v0, p5

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_3

    .line 3453
    .end local v6    # "vpmr":Lco/vine/android/api/VinePrivateMessageResponse;
    .end local v12    # "i$":Ljava/util/Iterator;
    .end local v17    # "smsFooter":Ljava/lang/String;
    .end local v18    # "smsFormatter":Ljava/lang/String;
    .end local v20    # "thumbnailUrl":Ljava/lang/String;
    .end local v22    # "videoUrl":Ljava/lang/String;
    :cond_e
    const-wide/16 v3, -0x1

    iget-wide v10, v14, Lco/vine/android/api/VinePrivateMessage;->conversationRowId:J

    invoke-virtual {v2, v3, v4, v10, v11}, Lco/vine/android/provider/VineDatabaseHelper;->deleteConversation(JJ)V

    goto/16 :goto_2

    .line 3479
    .restart local v6    # "vpmr":Lco/vine/android/api/VinePrivateMessageResponse;
    .restart local v12    # "i$":Ljava/util/Iterator;
    .restart local v17    # "smsFooter":Ljava/lang/String;
    .restart local v18    # "smsFormatter":Ljava/lang/String;
    .restart local v20    # "thumbnailUrl":Ljava/lang/String;
    .restart local v22    # "videoUrl":Ljava/lang/String;
    :cond_f
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p3

    iget-object v4, v0, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v6, Lco/vine/android/api/VinePrivateMessageResponse;->shareUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    .restart local v19    # "text":Ljava/lang/String;
    goto :goto_4

    .line 3501
    .end local v6    # "vpmr":Lco/vine/android/api/VinePrivateMessageResponse;
    .end local v19    # "text":Ljava/lang/String;
    :cond_10
    const-string v3, "post_url"

    move-object/from16 v0, p5

    move-object/from16 v1, v22

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 3502
    const-string v3, "thumbnail_url"

    move-object/from16 v0, p5

    move-object/from16 v1, v20

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private declared-synchronized init()V
    .locals 1

    .prologue
    .line 508
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    if-nez v0, :cond_0

    .line 509
    invoke-static {p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    .line 511
    :cond_0
    iget-object v0, p0, Lco/vine/android/service/VineService;->mMediaUtility:Lco/vine/android/util/MediaUtility;

    if-nez v0, :cond_1

    .line 512
    new-instance v0, Lco/vine/android/util/MediaUtility;

    invoke-direct {v0, p0}, Lco/vine/android/util/MediaUtility;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lco/vine/android/service/VineService;->mMediaUtility:Lco/vine/android/util/MediaUtility;

    .line 514
    :cond_1
    iget-object v0, p0, Lco/vine/android/service/VineService;->mAmazonBucket:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 515
    invoke-static {p0}, Lco/vine/android/client/Amazon;->getBucket(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/VineService;->mAmazonBucket:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 517
    :cond_2
    monitor-exit p0

    return-void

    .line 508
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private insertVineMessageBody(Ljava/util/HashMap;Lco/vine/android/api/VineUpload$PostInfo;J)V
    .locals 5
    .param p2, "info"    # Lco/vine/android/api/VineUpload$PostInfo;
    .param p3, "conversationId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lco/vine/android/api/VineUpload$PostInfo;",
            "J)V"
        }
    .end annotation

    .prologue
    .local p1, "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-wide/16 v3, 0x0

    .line 3394
    if-eqz p2, :cond_3

    .line 3395
    iget-object v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3396
    const-string v0, "message"

    iget-object v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3398
    :cond_0
    iget-wide v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->postId:J

    cmp-long v0, v0, v3

    if-lez v0, :cond_1

    .line 3399
    const-string v0, "postId"

    iget-wide v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->postId:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3401
    :cond_1
    const-string v0, "created"

    iget-wide v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->created:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3402
    iget v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    if-lez v0, :cond_2

    iget v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    const v1, 0x7fffffff

    if-ge v0, v1, :cond_2

    .line 3403
    const-string v0, "maxLoops"

    iget v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3405
    :cond_2
    iget-object v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    iget-object v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 3406
    const-string v0, "to"

    iget-object v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    invoke-static {v1}, Lco/vine/android/api/VineUpload$PostInfo;->recipientsToMaps(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3412
    :cond_3
    :goto_0
    return-void

    .line 3407
    :cond_4
    cmp-long v0, p3, v3

    if-gtz v0, :cond_3

    .line 3408
    const-string v0, "VineService"

    const-string v1, "VM post failed: The recipients array is empty and no conversation id"

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private insertVinePostBody(Ljava/util/HashMap;Lco/vine/android/api/VineUpload$PostInfo;)V
    .locals 4
    .param p2, "info"    # Lco/vine/android/api/VineUpload$PostInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lco/vine/android/api/VineUpload$PostInfo;",
            ")V"
        }
    .end annotation

    .prologue
    .line 3375
    .local p1, "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p2, :cond_2

    .line 3376
    iget-object v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->caption:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 3377
    const-string v0, "Added description: {}."

    iget-object v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->caption:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 3378
    const-string v0, "description"

    iget-object v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->caption:Ljava/lang/String;

    invoke-static {v1}, Lco/vine/android/util/Util;->cleanse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3379
    iget-object v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 3380
    const-string v0, "entities"

    iget-object v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->entities:Ljava/util/ArrayList;

    invoke-static {v1}, Lco/vine/android/api/VineUpload$PostInfo;->entitiesToMaps(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3385
    :cond_0
    :goto_0
    iget-wide v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->channelId:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 3386
    const-string v0, "channelId"

    iget-wide v1, p2, Lco/vine/android/api/VineUpload$PostInfo;->channelId:J

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3388
    :cond_1
    const-string v1, "postToTwitter"

    iget-boolean v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->postToTwitter:Z

    if-eqz v0, :cond_4

    const-string v0, "1"

    :goto_1
    invoke-virtual {p1, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3389
    const-string v1, "postToFacebook"

    iget-boolean v0, p2, Lco/vine/android/api/VineUpload$PostInfo;->postToFacebook:Z

    if-eqz v0, :cond_5

    const-string v0, "1"

    :goto_2
    invoke-virtual {p1, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3391
    :cond_2
    return-void

    .line 3383
    :cond_3
    const-string v0, "empty description."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 3388
    :cond_4
    const-string v0, "0"

    goto :goto_1

    .line 3389
    :cond_5
    const-string v0, "0"

    goto :goto_2
.end method

.method private postComment(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lco/vine/android/provider/VineDatabaseHelper;Landroid/os/Bundle;)Lco/vine/android/network/HttpOperation;
    .locals 16
    .param p1, "postId"    # J
    .param p3, "userId"    # J
    .param p5, "username"    # Ljava/lang/String;
    .param p6, "comment"    # Ljava/lang/String;
    .param p7, "avatarUrl"    # Ljava/lang/String;
    .param p9, "dbHelper"    # Lco/vine/android/provider/VineDatabaseHelper;
    .param p10, "b"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;",
            "Lco/vine/android/provider/VineDatabaseHelper;",
            "Landroid/os/Bundle;",
            ")",
            "Lco/vine/android/network/HttpOperation;"
        }
    .end annotation

    .prologue
    .line 3827
    .local p8, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    move-object/from16 v0, p0

    iget-object v12, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v12}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v12

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    const-string v15, "posts"

    aput-object v15, v13, v14

    const/4 v14, 0x1

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x2

    const-string v15, "comments"

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 3829
    .local v9, "url":Ljava/lang/StringBuilder;
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 3830
    .local v4, "jsonEntities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-virtual/range {p8 .. p8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineEntity;

    .line 3831
    .local v2, "entity":Lco/vine/android/api/VineEntity;
    invoke-virtual {v2}, Lco/vine/android/api/VineEntity;->toMap()Ljava/util/HashMap;

    move-result-object v12

    invoke-virtual {v4, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 3834
    .end local v2    # "entity":Lco/vine/android/api/VineEntity;
    :cond_0
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 3835
    .local v8, "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v12, "comment"

    move-object/from16 v0, p6

    invoke-virtual {v8, v12, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3836
    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v12

    if-nez v12, :cond_1

    .line 3837
    const-string v12, "entities"

    invoke-virtual {v8, v12, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3840
    :cond_1
    const/4 v12, 0x7

    invoke-static {v12}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v11

    .line 3841
    .local v11, "vp":Lco/vine/android/api/VineParserReader;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v12

    invoke-static {v12}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v12

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-static {v12, v9, v13, v8, v11}, Lco/vine/android/network/HttpOperation;->createBasicAuthJsonPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/HashMap;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v12

    invoke-virtual {v12}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v6

    .line 3846
    .local v6, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v12

    if-eqz v12, :cond_4

    .line 3847
    invoke-virtual {v11}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lco/vine/android/api/VineComment;

    .line 3848
    .local v10, "vc":Lco/vine/android/api/VineComment;
    move-wide/from16 v0, p1

    iput-wide v0, v10, Lco/vine/android/api/VineComment;->postId:J

    .line 3849
    move-wide/from16 v0, p3

    iput-wide v0, v10, Lco/vine/android/api/VineComment;->userId:J

    .line 3850
    move-object/from16 v0, p5

    iput-object v0, v10, Lco/vine/android/api/VineComment;->username:Ljava/lang/String;

    .line 3851
    move-object/from16 v0, p7

    iput-object v0, v10, Lco/vine/android/api/VineComment;->avatarUrl:Ljava/lang/String;

    .line 3853
    const/4 v5, 0x0

    .line 3854
    .local v5, "offsetCount":I
    invoke-virtual/range {p8 .. p8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VineEntity;

    .line 3855
    .restart local v2    # "entity":Lco/vine/android/api/VineEntity;
    iget v12, v2, Lco/vine/android/api/VineEntity;->start:I

    sub-int/2addr v12, v5

    iput v12, v2, Lco/vine/android/api/VineEntity;->start:I

    .line 3858
    const-string v12, "tag"

    iget-object v13, v2, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 3859
    add-int/lit8 v5, v5, 0x1

    .line 3860
    iget-object v12, v2, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-static {v12}, Lco/vine/android/api/VineTypeAhead;->getPlainTag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 3861
    .local v7, "plainTitle":Ljava/lang/String;
    iget-object v12, v2, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    move-object/from16 v0, p6

    invoke-virtual {v0, v12, v7}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p6

    .line 3862
    iput-object v7, v2, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    .line 3863
    new-instance v12, Lco/vine/android/api/VineTag;

    iget-wide v13, v2, Lco/vine/android/api/VineEntity;->id:J

    invoke-direct {v12, v7, v13, v14}, Lco/vine/android/api/VineTag;-><init>(Ljava/lang/String;J)V

    move-object/from16 v0, p9

    invoke-virtual {v0, v12}, Lco/vine/android/provider/VineDatabaseHelper;->mergeSuggestedTag(Lco/vine/android/api/VineTag;)Landroid/net/Uri;

    .line 3865
    .end local v7    # "plainTitle":Ljava/lang/String;
    :cond_2
    iget v12, v2, Lco/vine/android/api/VineEntity;->end:I

    sub-int/2addr v12, v5

    iput v12, v2, Lco/vine/android/api/VineEntity;->end:I

    goto :goto_1

    .line 3867
    .end local v2    # "entity":Lco/vine/android/api/VineEntity;
    :cond_3
    move-object/from16 v0, p6

    iput-object v0, v10, Lco/vine/android/api/VineComment;->comment:Ljava/lang/String;

    .line 3868
    move-object/from16 v0, p8

    iput-object v0, v10, Lco/vine/android/api/VineComment;->entities:Ljava/util/ArrayList;

    .line 3869
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    iput-wide v12, v10, Lco/vine/android/api/VineComment;->timestamp:J

    .line 3870
    const-string v12, "comment_obj"

    move-object/from16 v0, p10

    invoke-virtual {v0, v12, v10}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 3872
    .end local v5    # "offsetCount":I
    .end local v10    # "vc":Lco/vine/android/api/VineComment;
    :cond_4
    return-object v6
.end method

.method private updateBadgeCount(I)V
    .locals 9
    .param p1, "count"    # I

    .prologue
    .line 3232
    invoke-virtual {p0}, Lco/vine/android/service/VineService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 3234
    .local v0, "resolver":Landroid/content/ContentResolver;
    :try_start_0
    sget-object v1, Lco/vine/android/service/VineService;->SAMSUNG_BADGER_URI:Landroid/net/Uri;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "package"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "badgecount"

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 3236
    .local v6, "c":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    .line 3238
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 3239
    .local v7, "cv":Landroid/content/ContentValues;
    const-string v1, "package"

    const-string v2, "co.vine.android"

    invoke-virtual {v7, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3240
    const-string v1, "class"

    sget-object v2, Lco/vine/android/service/VineService;->START_CLASS_NAME:Ljava/lang/String;

    invoke-virtual {v7, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3241
    const-string v1, "badgecount"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 3243
    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_1

    .line 3244
    invoke-virtual {p0}, Lco/vine/android/service/VineService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lco/vine/android/service/VineService;->SAMSUNG_BADGER_URI:Landroid/net/Uri;

    const-string v3, "package=?"

    sget-object v4, Lco/vine/android/service/VineService;->BADGER_ARGS:[Ljava/lang/String;

    invoke-virtual {v1, v2, v7, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 3253
    .end local v6    # "c":Landroid/database/Cursor;
    .end local v7    # "cv":Landroid/content/ContentValues;
    :cond_0
    :goto_0
    return-void

    .line 3246
    .restart local v6    # "c":Landroid/database/Cursor;
    .restart local v7    # "cv":Landroid/content/ContentValues;
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/service/VineService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lco/vine/android/service/VineService;->SAMSUNG_BADGER_URI:Landroid/net/Uri;

    invoke-virtual {v1, v2, v7}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 3249
    .end local v6    # "c":Landroid/database/Cursor;
    .end local v7    # "cv":Landroid/content/ContentValues;
    :catch_0
    move-exception v8

    .line 3250
    .local v8, "e":Ljava/lang/Exception;
    const-string v1, "Ignore samsung error."

    invoke-static {v1, v8}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public addCountryParam(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 3815
    .local p1, "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string v1, "locale"

    invoke-static {}, Lco/vine/android/util/Util;->getCountryCode()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3816
    return-void
.end method

.method public addCountryParam(Ljava/util/HashMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 3819
    .local p1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v0, "locale"

    invoke-static {}, Lco/vine/android/util/Util;->getCountryCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3820
    return-void
.end method

.method attemptStop(I)V
    .locals 6
    .param p1, "startId"    # I

    .prologue
    .line 3967
    iget-object v3, p0, Lco/vine/android/service/VineService;->mStartIds:Ljava/util/LinkedHashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3970
    iget-object v3, p0, Lco/vine/android/service/VineService;->mStartIds:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 3971
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Ljava/lang/Boolean;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    .line 3981
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Ljava/lang/Boolean;>;"
    :goto_0
    return-void

    .line 3977
    :cond_1
    iget-object v3, p0, Lco/vine/android/service/VineService;->mStartIds:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    .line 3978
    .local v2, "key":Ljava/lang/Integer;
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {p0, v3}, Lco/vine/android/service/VineService;->stopSelf(I)V

    goto :goto_1

    .line 3980
    .end local v2    # "key":Ljava/lang/Integer;
    :cond_2
    iget-object v3, p0, Lco/vine/android/service/VineService;->mStartIds:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clear()V

    goto :goto_0
.end method

.method executeAction(ILandroid/os/Bundle;)Landroid/os/Bundle;
    .locals 282
    .param p1, "actionCode"    # I
    .param p2, "b"    # Landroid/os/Bundle;

    .prologue
    .line 552
    sget-boolean v6, Lco/vine/android/service/VineService;->LOGGABLE:Z

    if-eqz v6, :cond_0

    .line 553
    const-string v6, "VineService"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Running VineService action: "

    move-object/from16 v0, v16

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    move/from16 v0, p1

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v6, v13}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 555
    :cond_0
    invoke-direct/range {p0 .. p0}, Lco/vine/android/service/VineService;->init()V

    .line 557
    const-string v6, "s_key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v43

    .line 558
    .local v43, "key":Ljava/lang/String;
    const-string v6, "a_name"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v107

    .line 559
    .local v107, "accountName":Ljava/lang/String;
    const-string v6, "s_owner_id"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v34

    .line 560
    .local v34, "sessionOwnerId":J
    invoke-static/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v12

    .line 562
    .local v12, "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v127

    .line 564
    .local v127, "context":Landroid/content/Context;
    const/16 v245, 0x0

    .line 565
    .local v245, "statusCode":I
    const/16 v221, 0x0

    .line 566
    .local v221, "reasonPhrase":Ljava/lang/String;
    const/16 v202, 0x0

    .line 567
    .local v202, "op":Lco/vine/android/network/HttpOperation;
    const/16 v148, 0x0

    .line 568
    .local v148, "error":Lco/vine/android/api/VineError;
    const/16 v29, 0x0

    .line 570
    .local v29, "vp":Lco/vine/android/api/VineParserReader;
    move/from16 v0, p1

    sparse-switch v0, :sswitch_data_0

    .line 3176
    .end local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .end local v43    # "key":Ljava/lang/String;
    :cond_1
    :goto_0
    new-instance v239, Landroid/os/Bundle;

    invoke-direct/range {v239 .. v239}, Landroid/os/Bundle;-><init>()V

    .line 3177
    .local v239, "ret":Landroid/os/Bundle;
    if-eqz v202, :cond_88

    .line 3178
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->getHttpRequest()Lorg/apache/http/client/methods/HttpRequestBase;

    move-result-object v231

    .line 3179
    .local v231, "request":Lorg/apache/http/client/methods/HttpRequestBase;
    if-eqz v231, :cond_2

    invoke-virtual/range {v231 .. v231}, Lorg/apache/http/client/methods/HttpRequestBase;->isAborted()Z

    move-result v6

    if-nez v6, :cond_2

    .line 3180
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mHttpRequests:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual/range {v231 .. v231}, Ljava/lang/Object;->hashCode()I

    move-result v13

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    move-object/from16 v0, v231

    invoke-virtual {v6, v13, v0}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3183
    :cond_2
    move-object/from16 v0, v202

    iget v0, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    move/from16 v245, v0

    .line 3184
    const-string v6, "statusCode"

    move-object/from16 v0, v239

    move/from16 v1, v245

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3185
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-nez v6, :cond_3

    if-eqz v29, :cond_3

    if-nez v148, :cond_3

    .line 3186
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v148

    .end local v148    # "error":Lco/vine/android/api/VineError;
    check-cast v148, Lco/vine/android/api/VineError;

    .line 3188
    .restart local v148    # "error":Lco/vine/android/api/VineError;
    :cond_3
    if-eqz v148, :cond_89

    .line 3189
    move-object/from16 v0, v148

    iget-object v0, v0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    move-object/from16 v221, v0

    .line 3190
    const-string v6, "reasonPhrase"

    move-object/from16 v0, v239

    move-object/from16 v1, v221

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 3193
    move-object/from16 v0, v148

    iget v0, v0, Lco/vine/android/api/VineError;->errorCode:I

    move/from16 v89, v0

    .line 3194
    .local v89, "errorCode":I
    sget-object v6, Lco/vine/android/api/VineError$VineKnownErrors;->BAD_CREDENTIALS:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v6, v6, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    move/from16 v0, v89

    if-eq v0, v6, :cond_4

    sget-object v6, Lco/vine/android/api/VineError$VineKnownErrors;->REQUIRES_LOGIN:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v6, v6, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    move/from16 v0, v89

    if-ne v0, v6, :cond_85

    .line 3196
    :cond_4
    const-string v6, "executionCode"

    const/4 v13, 0x3

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3222
    .end local v89    # "errorCode":I
    .end local v231    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    .end local v239    # "ret":Landroid/os/Bundle;
    :goto_1
    return-object v239

    .line 572
    .restart local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .restart local v43    # "key":Ljava/lang/String;
    :sswitch_0
    const-string v6, "login"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Lco/vine/android/api/VineLogin;

    .line 573
    .local v5, "login":Lco/vine/android/api/VineLogin;
    const-string v6, "pass"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v209

    .line 574
    .local v209, "password":Ljava/lang/String;
    invoke-static {}, Lco/vine/android/api/VineParserReader;->createLoginReader()Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 575
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 576
    .local v28, "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    iget-object v6, v5, Lco/vine/android/api/VineLogin;->username:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_5

    invoke-static/range {v209 .. v209}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_5

    .line 577
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "username"

    iget-object v0, v5, Lco/vine/android/api/VineLogin;->username:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 578
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "password"

    move-object/from16 v0, v209

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 580
    :cond_5
    iget-object v6, v5, Lco/vine/android/api/VineLogin;->twitterToken:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_7

    iget-object v6, v5, Lco/vine/android/api/VineLogin;->twitterSecret:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_7

    iget-wide v0, v5, Lco/vine/android/api/VineLogin;->twitterUserId:J

    move-wide/from16 v16, v0

    const-wide/16 v19, 0x0

    cmp-long v6, v16, v19

    if-lez v6, :cond_7

    const/16 v166, 0x1

    .line 583
    .local v166, "isTwitter":Z
    :goto_2
    if-eqz v166, :cond_6

    .line 584
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthToken"

    iget-object v0, v5, Lco/vine/android/api/VineLogin;->twitterToken:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 585
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthSecret"

    iget-object v0, v5, Lco/vine/android/api/VineLogin;->twitterSecret:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 586
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterId"

    iget-wide v0, v5, Lco/vine/android/api/VineLogin;->twitterUserId:J

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 590
    :cond_6
    const-string v6, "reactivate"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    if-eqz v6, :cond_8

    const-string v174, "reactivate"

    .line 592
    .local v174, "lastPathSegment":Ljava/lang/String;
    :goto_3
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    aput-object v174, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 595
    .local v26, "url":Ljava/lang/StringBuilder;
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v1, v2, v13}, Lco/vine/android/network/HttpOperation;->createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 599
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_9

    .line 600
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v279, v0

    move-object/from16 v0, v279

    check-cast v0, Lco/vine/android/api/VineLogin;

    move-object/16 v279, v0

    .line 601
    .local v279, "vl":Lco/vine/android/api/VineLogin;
    move-object/from16 v0, v279

    iget-object v6, v0, Lco/vine/android/api/VineLogin;->username:Ljava/lang/String;

    move-object/from16 v0, v279

    iput-object v6, v0, Lco/vine/android/api/VineLogin;->name:Ljava/lang/String;

    .line 602
    iget-object v6, v5, Lco/vine/android/api/VineLogin;->username:Ljava/lang/String;

    move-object/from16 v0, v279

    iput-object v6, v0, Lco/vine/android/api/VineLogin;->username:Ljava/lang/String;

    .line 603
    const-string v6, "a_name"

    move-object/from16 v0, v279

    iget-object v13, v0, Lco/vine/android/api/VineLogin;->name:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 604
    const-string v6, "login"

    move-object/from16 v0, p2

    move-object/from16 v1, v279

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 606
    invoke-static/range {v166 .. v166}, Lco/vine/android/util/FlurryUtils;->trackLoginSuccess(Z)V

    .line 609
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "me"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    move-object/16 v275, v0

    .line 611
    .local v275, "usersMeUrl":Ljava/lang/StringBuilder;
    const/4 v6, 0x2

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 612
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v279

    iget-object v0, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v275

    move-object/from16 v1, v29

    move-object/from16 v2, v16

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 615
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 616
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v181

    check-cast v181, Lco/vine/android/api/VineUser;

    .line 617
    .local v181, "me":Lco/vine/android/api/VineUser;
    const-string v6, "avatar_url"

    move-object/from16 v0, v181

    iget-object v13, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 618
    const-string v6, "desc"

    move-object/from16 v0, v181

    iget-object v13, v0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 580
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v166    # "isTwitter":Z
    .end local v174    # "lastPathSegment":Ljava/lang/String;
    .end local v181    # "me":Lco/vine/android/api/VineUser;
    .end local v275    # "usersMeUrl":Ljava/lang/StringBuilder;
    .end local v279    # "vl":Lco/vine/android/api/VineLogin;
    :cond_7
    const/16 v166, 0x0

    goto/16 :goto_2

    .line 590
    .restart local v166    # "isTwitter":Z
    :cond_8
    const-string v174, "authenticate"

    goto/16 :goto_3

    .line 621
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    .restart local v174    # "lastPathSegment":Ljava/lang/String;
    :cond_9
    new-instance v239, Landroid/os/Bundle;

    invoke-direct/range {v239 .. v239}, Landroid/os/Bundle;-><init>()V

    .line 622
    .restart local v239    # "ret":Landroid/os/Bundle;
    const-string v6, "statusCode"

    move-object/from16 v0, v202

    iget v13, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 623
    move-object/from16 v0, v202

    iget v6, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    move/from16 v0, v166

    invoke-static {v0, v6}, Lco/vine/android/util/FlurryUtils;->trackLoginFailure(ZI)V

    .line 624
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v148

    .end local v148    # "error":Lco/vine/android/api/VineError;
    check-cast v148, Lco/vine/android/api/VineError;

    .line 625
    .restart local v148    # "error":Lco/vine/android/api/VineError;
    if-eqz v148, :cond_a

    .line 626
    const-string v6, "reasonPhrase"

    move-object/from16 v0, v148

    iget-object v13, v0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 627
    const-string v6, "error_code"

    move-object/from16 v0, v148

    iget v13, v0, Lco/vine/android/api/VineError;->errorCode:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 631
    :goto_4
    const-string v6, "executionCode"

    const/4 v13, 0x1

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto/16 :goto_1

    .line 629
    :cond_a
    const-string v6, "reasonPhrase"

    const v13, 0x7f0e00cf

    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    .line 637
    .end local v5    # "login":Lco/vine/android/api/VineLogin;
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v166    # "isTwitter":Z
    .end local v174    # "lastPathSegment":Ljava/lang/String;
    .end local v209    # "password":Ljava/lang/String;
    .end local v239    # "ret":Landroid/os/Bundle;
    :sswitch_1
    invoke-virtual {v12}, Lco/vine/android/provider/VineDatabaseHelper;->clearAllData()V

    goto/16 :goto_0

    .line 641
    :sswitch_2
    const-string v6, "a_name"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v189

    .line 642
    .local v189, "name":Ljava/lang/String;
    const-string v6, "login"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v143

    .line 643
    .local v143, "email":Ljava/lang/String;
    const-string v6, "pass"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v209

    .line 644
    .restart local v209    # "password":Ljava/lang/String;
    const-string v6, "phone"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v211

    .line 645
    .local v211, "phone":Ljava/lang/String;
    const-string v6, "t_user"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v254

    check-cast v254, Lco/vine/android/api/TwitterUser;

    .line 647
    .local v254, "twitterUser":Lco/vine/android/api/TwitterUser;
    new-instance v6, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v13}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v6, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, "/users"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 649
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x5

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 651
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 653
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    if-eqz v254, :cond_f

    const/16 v253, 0x1

    .line 654
    .local v253, "twitterSignup":Z
    :goto_5
    const-string v6, "key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v249

    .line 655
    .local v249, "token":Ljava/lang/String;
    const-string v6, "secret"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v240

    .line 656
    .local v240, "secret":Ljava/lang/String;
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/CrossAnalytics;->getInstance(Landroid/content/Context;)Lco/vine/android/util/CrossAnalytics;

    move-result-object v6

    const-string v13, "pre_install_sign up"

    invoke-virtual {v6, v13}, Lco/vine/android/util/CrossAnalytics;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v217

    .line 657
    .local v217, "preinstallKey":Ljava/lang/String;
    if-eqz v253, :cond_10

    .line 658
    move-object/from16 v0, v254

    iget-object v6, v0, Lco/vine/android/api/TwitterUser;->name:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_b

    .line 659
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "username"

    move-object/from16 v0, v254

    iget-object v0, v0, Lco/vine/android/api/TwitterUser;->name:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 661
    :cond_b
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "location"

    move-object/from16 v0, v254

    iget-object v0, v0, Lco/vine/android/api/TwitterUser;->location:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 662
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "description"

    move-object/from16 v0, v254

    iget-object v0, v0, Lco/vine/android/api/TwitterUser;->description:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 663
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterId"

    move-object/from16 v0, v254

    iget-wide v0, v0, Lco/vine/android/api/TwitterUser;->userId:J

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 665
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthToken"

    move-object/from16 v0, v249

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 666
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthSecret"

    move-object/from16 v0, v240

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 667
    invoke-static/range {v211 .. v211}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_c

    .line 668
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "phoneNumber"

    move-object/from16 v0, v211

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 678
    :cond_c
    :goto_6
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "authenticate"

    const-string v16, "true"

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 680
    if-eqz v217, :cond_d

    .line 681
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "preinstallTarget"

    move-object/from16 v0, v217

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 684
    :cond_d
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v1, v2, v13}, Lco/vine/android/network/HttpOperation;->createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 688
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_12

    .line 689
    invoke-static/range {v253 .. v253}, Lco/vine/android/util/FlurryUtils;->onSignupSuccess(Z)V

    .line 690
    if-eqz v217, :cond_e

    .line 691
    invoke-static/range {v217 .. v217}, Lco/vine/android/util/FlurryUtils;->onSignupWithPreinstallSuccess(Ljava/lang/String;)V

    .line 692
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/CrossAnalytics;->getInstance(Landroid/content/Context;)Lco/vine/android/util/CrossAnalytics;

    move-result-object v6

    const-string v13, "pre_install_sign up"

    invoke-virtual {v6, v13}, Lco/vine/android/util/CrossAnalytics;->clear(Ljava/lang/String;)V

    .line 694
    :cond_e
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v279, v0

    move-object/from16 v0, v279

    check-cast v0, Lco/vine/android/api/VineLogin;

    move-object/16 v279, v0

    .line 695
    .restart local v279    # "vl":Lco/vine/android/api/VineLogin;
    if-eqz v253, :cond_11

    .line 696
    move-object/from16 v0, v249

    move-object/from16 v1, v279

    iput-object v0, v1, Lco/vine/android/api/VineLogin;->twitterToken:Ljava/lang/String;

    .line 697
    move-object/from16 v0, v240

    move-object/from16 v1, v279

    iput-object v0, v1, Lco/vine/android/api/VineLogin;->twitterSecret:Ljava/lang/String;

    .line 698
    move-object/from16 v0, v254

    iget-wide v0, v0, Lco/vine/android/api/TwitterUser;->userId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    move-object/from16 v2, v279

    iput-wide v0, v2, Lco/vine/android/api/VineLogin;->twitterUserId:J

    .line 699
    const/4 v6, 0x2

    move-object/from16 v0, v279

    iput v6, v0, Lco/vine/android/api/VineLogin;->loginType:I

    .line 703
    :goto_7
    const-string v6, "login"

    move-object/from16 v0, p2

    move-object/from16 v1, v279

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 704
    const-string v6, "a_name"

    move-object/from16 v0, p2

    move-object/from16 v1, v189

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 707
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "me"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    move-object/16 v275, v0

    .line 709
    .restart local v275    # "usersMeUrl":Ljava/lang/StringBuilder;
    const/4 v6, 0x2

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 710
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v279

    iget-object v0, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v275

    move-object/from16 v1, v29

    move-object/from16 v2, v16

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 713
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 714
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v181

    check-cast v181, Lco/vine/android/api/VineUser;

    .line 715
    .restart local v181    # "me":Lco/vine/android/api/VineUser;
    const-string v6, "avatar_url"

    move-object/from16 v0, v181

    iget-object v13, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 716
    const-string v6, "desc"

    move-object/from16 v0, v181

    iget-object v13, v0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 717
    const-string v6, "s_key"

    move-object/from16 v0, v279

    iget-object v13, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 718
    const-string v6, "s_owner_id"

    move-object/from16 v0, v279

    iget-wide v0, v0, Lco/vine/android/api/VineLogin;->userId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto/16 :goto_0

    .line 653
    .end local v181    # "me":Lco/vine/android/api/VineUser;
    .end local v217    # "preinstallKey":Ljava/lang/String;
    .end local v240    # "secret":Ljava/lang/String;
    .end local v249    # "token":Ljava/lang/String;
    .end local v253    # "twitterSignup":Z
    .end local v275    # "usersMeUrl":Ljava/lang/StringBuilder;
    .end local v279    # "vl":Lco/vine/android/api/VineLogin;
    :cond_f
    const/16 v253, 0x0

    goto/16 :goto_5

    .line 671
    .restart local v217    # "preinstallKey":Ljava/lang/String;
    .restart local v240    # "secret":Ljava/lang/String;
    .restart local v249    # "token":Ljava/lang/String;
    .restart local v253    # "twitterSignup":Z
    :cond_10
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "username"

    move-object/from16 v0, v189

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 672
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "email"

    move-object/from16 v0, v143

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 673
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "password"

    move-object/from16 v0, v209

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 674
    invoke-static/range {v211 .. v211}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_c

    .line 675
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "phoneNumber"

    move-object/from16 v0, v211

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_6

    .line 701
    .restart local v279    # "vl":Lco/vine/android/api/VineLogin;
    :cond_11
    move-object/from16 v0, v143

    move-object/from16 v1, v279

    iput-object v0, v1, Lco/vine/android/api/VineLogin;->username:Ljava/lang/String;

    goto/16 :goto_7

    .line 721
    .end local v279    # "vl":Lco/vine/android/api/VineLogin;
    :cond_12
    new-instance v239, Landroid/os/Bundle;

    invoke-direct/range {v239 .. v239}, Landroid/os/Bundle;-><init>()V

    .line 722
    .restart local v239    # "ret":Landroid/os/Bundle;
    const-string v6, "statusCode"

    move-object/from16 v0, v202

    iget v13, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 723
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v148

    .end local v148    # "error":Lco/vine/android/api/VineError;
    check-cast v148, Lco/vine/android/api/VineError;

    .line 724
    .restart local v148    # "error":Lco/vine/android/api/VineError;
    move-object/from16 v0, v202

    iget v6, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    move/from16 v0, v253

    move-object/from16 v1, v148

    invoke-static {v0, v1, v6}, Lco/vine/android/util/FlurryUtils;->onSignupFailure(ZLco/vine/android/api/VineError;I)V

    .line 725
    if-eqz v148, :cond_13

    .line 726
    const-string v6, "reasonPhrase"

    move-object/from16 v0, v148

    iget-object v13, v0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 730
    :goto_8
    const-string v6, "executionCode"

    const/4 v13, 0x1

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto/16 :goto_1

    .line 728
    :cond_13
    const-string v6, "reasonPhrase"

    const v13, 0x7f0e00cf

    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_8

    .line 736
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v143    # "email":Ljava/lang/String;
    .end local v189    # "name":Ljava/lang/String;
    .end local v209    # "password":Ljava/lang/String;
    .end local v211    # "phone":Ljava/lang/String;
    .end local v217    # "preinstallKey":Ljava/lang/String;
    .end local v239    # "ret":Landroid/os/Bundle;
    .end local v240    # "secret":Ljava/lang/String;
    .end local v249    # "token":Ljava/lang/String;
    .end local v253    # "twitterSignup":Z
    .end local v254    # "twitterUser":Lco/vine/android/api/TwitterUser;
    :sswitch_3
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 738
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "uri"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v116

    check-cast v116, Landroid/net/Uri;

    .line 740
    .local v116, "avatarUri":Landroid/net/Uri;
    const/16 v150, 0x0

    .line 742
    .local v150, "f":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mAmazonBucket:Ljava/lang/String;

    if-eqz v6, :cond_16

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mAmazonBucket:Ljava/lang/String;

    move-object/from16 v212, v0

    .line 743
    .local v212, "pictureBucket":Ljava/lang/String;
    :goto_9
    if-eqz v116, :cond_14

    .line 745
    :try_start_0
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mMediaUtility:Lco/vine/android/util/MediaUtility;

    move-object/from16 v0, v116

    move-object/from16 v1, v212

    move-object/from16 v2, v127

    invoke-virtual {v6, v0, v1, v2}, Lco/vine/android/util/MediaUtility;->getPhotoUri(Landroid/net/Uri;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v150

    .line 753
    :cond_14
    if-eqz v116, :cond_17

    invoke-virtual/range {v116 .. v116}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_17

    .line 754
    const-string v151, ""

    .line 769
    .local v151, "finalAvatarUrl":Ljava/lang/String;
    :goto_a
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x1

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 771
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    if-eqz v116, :cond_15

    .line 772
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "avatarUrl"

    move-object/from16 v0, v151

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 775
    :cond_15
    const/4 v6, 0x2

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 776
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 780
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 781
    if-nez v116, :cond_18

    .line 782
    const-string v6, "avatar_url"

    const-string v13, ""

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 742
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v151    # "finalAvatarUrl":Ljava/lang/String;
    .end local v212    # "pictureBucket":Ljava/lang/String;
    :cond_16
    invoke-static/range {v127 .. v127}, Lco/vine/android/client/Amazon;->getBucket(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v212

    goto :goto_9

    .line 746
    .restart local v212    # "pictureBucket":Ljava/lang/String;
    :catch_0
    move-exception v139

    .line 747
    .local v139, "e":Ljava/lang/Exception;
    const/16 v245, 0x384

    .line 748
    invoke-virtual/range {v139 .. v139}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v221

    .line 749
    goto/16 :goto_0

    .line 756
    .end local v139    # "e":Ljava/lang/Exception;
    :cond_17
    invoke-static/range {v127 .. v127}, Lco/vine/android/util/MediaUtility;->getUploadType(Landroid/content/Context;)I

    move-result v186

    .line 757
    .local v186, "mode":I
    packed-switch v186, :pswitch_data_0

    .line 764
    move-object/from16 v151, v150

    .restart local v151    # "finalAvatarUrl":Ljava/lang/String;
    goto :goto_a

    .line 759
    .end local v151    # "finalAvatarUrl":Ljava/lang/String;
    :pswitch_0
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v13}, Lco/vine/android/client/VineAPI;->getAmazonUrl()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v13, "/"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v212

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v13, "/"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v150

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v151

    .line 760
    .restart local v151    # "finalAvatarUrl":Ljava/lang/String;
    goto/16 :goto_a

    .line 784
    .end local v186    # "mode":I
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    :cond_18
    const-string v6, "avatar_url"

    move-object/from16 v0, p2

    move-object/from16 v1, v151

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 790
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v116    # "avatarUri":Landroid/net/Uri;
    .end local v150    # "f":Ljava/lang/String;
    .end local v151    # "finalAvatarUrl":Ljava/lang/String;
    .end local v212    # "pictureBucket":Ljava/lang/String;
    :sswitch_4
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "notifications"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "settings"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 793
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "notificationSettings"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v208

    check-cast v208, Ljava/util/HashMap;

    .line 794
    .local v208, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v206, Ljava/util/ArrayList;

    invoke-direct/range {v206 .. v206}, Ljava/util/ArrayList;-><init>()V

    .line 795
    .local v206, "pairs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    invoke-virtual/range {v208 .. v208}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .local v162, "i$":Ljava/util/Iterator;
    :goto_b
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_19

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v147

    check-cast v147, Ljava/util/Map$Entry;

    .line 796
    .local v147, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v205, Lorg/apache/http/message/BasicNameValuePair;

    invoke-interface/range {v147 .. v147}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-interface/range {v147 .. v147}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    move-object/from16 v0, v205

    invoke-direct {v0, v6, v13}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 797
    .local v205, "pair":Lorg/apache/http/message/BasicNameValuePair;
    move-object/from16 v0, v206

    move-object/from16 v1, v205

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_b

    .line 799
    .end local v147    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v205    # "pair":Lorg/apache/http/message/BasicNameValuePair;
    :cond_19
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 800
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v206

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 802
    goto/16 :goto_0

    .line 805
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v206    # "pairs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v208    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :sswitch_5
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "notifications"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "settings"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 807
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0x1e

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 808
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 811
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 812
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v195

    check-cast v195, Lco/vine/android/api/VinePagedData;

    .line 813
    .local v195, "notifSettings":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineNotificationSetting;>;"
    const-string v6, "notificationSettings"

    move-object/from16 v0, v195

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 818
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v195    # "notifSettings":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineNotificationSetting;>;"
    :sswitch_6
    const-string v6, "network"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v191

    .line 820
    .local v191, "networkType":I
    const-string v6, "recipient"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v222

    check-cast v222, Lco/vine/android/api/VineRecipient;

    .line 821
    .local v222, "recipient":Lco/vine/android/api/VineRecipient;
    if-nez v222, :cond_1a

    .line 822
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v13, "You must provide a recipient if you want to get the conversation id for it"

    invoke-direct {v6, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 825
    :cond_1a
    const-wide/16 v67, -0x1

    .line 828
    .local v67, "conversationRowId":J
    invoke-virtual/range {v222 .. v222}, Lco/vine/android/api/VineRecipient;->isFromUser()Z

    move-result v6

    if-eqz v6, :cond_1f

    .line 830
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    move-wide/from16 v16, v0

    const-wide/16 v19, 0x0

    cmp-long v6, v16, v19

    if-gtz v6, :cond_1e

    .line 831
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->userId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v16

    move-wide/from16 v0, v16

    move-object/from16 v2, v222

    iput-wide v0, v2, Lco/vine/android/api/VineRecipient;->recipientId:J

    .line 835
    :cond_1b
    :goto_c
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->userId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->determineBestConversationRowIdForUserRemoteId(J)J

    move-result-wide v67

    .line 845
    :goto_d
    const-wide/16 v16, 0x0

    cmp-long v6, v67, v16

    if-gtz v6, :cond_1c

    .line 846
    new-instance v223, Ljava/util/ArrayList;

    invoke-direct/range {v223 .. v223}, Ljava/util/ArrayList;-><init>()V

    .line 847
    .local v223, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    move-object/from16 v0, v223

    move-object/from16 v1, v222

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 848
    move-object/from16 v0, v223

    move/from16 v1, v191

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->createPreMergeConversationIdAndRecipientsIfNecessary(Ljava/util/List;I)J

    move-result-wide v67

    .line 852
    .end local v223    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    :cond_1c
    move-object/from16 v0, v222

    iget-object v6, v0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_1d

    .line 853
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getDisplayForUser(J)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v222

    iput-object v6, v0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    .line 856
    :cond_1d
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->amFollowingUser(J)Z

    move-result v113

    .line 858
    .local v113, "amFollowing":Z
    const-string v6, "conversation_row_id"

    move-object/from16 v0, p2

    move-wide/from16 v1, v67

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 859
    const-string v6, "am_following"

    move-object/from16 v0, p2

    move/from16 v1, v113

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 860
    const-string v6, "username"

    move-object/from16 v0, v222

    iget-object v13, v0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v239, p2

    .line 861
    goto/16 :goto_1

    .line 832
    .end local v113    # "amFollowing":Z
    :cond_1e
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->userId:J

    move-wide/from16 v16, v0

    const-wide/16 v19, 0x0

    cmp-long v6, v16, v19

    if-gez v6, :cond_1b

    .line 833
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRemoteIdForUserRowId(J)J

    move-result-wide v16

    move-wide/from16 v0, v16

    move-object/from16 v2, v222

    iput-wide v0, v2, Lco/vine/android/api/VineRecipient;->userId:J

    goto/16 :goto_c

    .line 838
    :cond_1f
    new-instance v223, Ljava/util/ArrayList;

    invoke-direct/range {v223 .. v223}, Ljava/util/ArrayList;-><init>()V

    .line 839
    .restart local v223    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    move-object/from16 v0, v223

    move-object/from16 v1, v222

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 840
    move-object/from16 v0, v223

    move/from16 v1, v191

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->determineOrCreateBestConversationRowIdForRecipients(Ljava/util/List;I)J

    move-result-wide v67

    goto/16 :goto_d

    .line 864
    .end local v67    # "conversationRowId":J
    .end local v191    # "networkType":I
    .end local v222    # "recipient":Lco/vine/android/api/VineRecipient;
    .end local v223    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    :sswitch_7
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 866
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "includePromoted"

    const-string v16, "should_follow_editors_picks"

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v16

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 868
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "preferences"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 872
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 873
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 876
    const-string v6, "should_follow_editors_picks"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    const/4 v13, 0x1

    if-ne v6, v13, :cond_20

    const/16 v242, 0x1

    .line 877
    .local v242, "shouldFollow":Z
    :goto_e
    const-string v6, "should_follow_editors_picks"

    move-object/from16 v0, p2

    move/from16 v1, v242

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 878
    if-nez v242, :cond_1

    .line 879
    const-string v6, "also_fetch_posts"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 876
    .end local v242    # "shouldFollow":Z
    :cond_20
    const/16 v242, 0x0

    goto :goto_e

    .line 884
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    :sswitch_8
    const-string v6, "type"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v255

    .line 885
    .local v255, "type":I
    move/from16 v0, v255

    invoke-virtual {v12, v0}, Lco/vine/android/provider/VineDatabaseHelper;->expireTimeline(I)V

    goto/16 :goto_0

    .line 889
    .end local v255    # "type":I
    :sswitch_9
    move-object/from16 v0, v127

    move-object/from16 v1, v107

    invoke-static {v0, v1}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v106

    .line 890
    .local v106, "account":Landroid/accounts/Account;
    if-nez v106, :cond_21

    .line 891
    const-string v6, "email"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v127

    invoke-static {v0, v6}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v106

    .line 892
    if-eqz v106, :cond_1

    .line 897
    :cond_21
    invoke-static/range {v127 .. v127}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v112

    .line 898
    .local v112, "am":Landroid/accounts/AccountManager;
    move-object/from16 v0, v112

    move-object/from16 v1, v106

    invoke-static {v0, v1}, Lco/vine/android/client/VineAccountHelper;->getLoginType(Landroid/accounts/AccountManager;Landroid/accounts/Account;)I

    move-result v178

    .line 899
    .local v178, "loginType":I
    packed-switch v178, :pswitch_data_1

    goto/16 :goto_0

    .line 901
    :pswitch_1
    move-object/from16 v0, v106

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object/from16 v143, v0

    .line 902
    .restart local v143    # "email":Ljava/lang/String;
    move-object/from16 v0, v112

    move-object/from16 v1, v106

    move-object/from16 v2, v127

    invoke-static {v0, v1, v2}, Lco/vine/android/client/VineAccountHelper;->getPassword(Landroid/accounts/AccountManager;Landroid/accounts/Account;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v209

    .line 903
    .restart local v209    # "password":Ljava/lang/String;
    invoke-static {}, Lco/vine/android/api/VineParserReader;->createLoginReader()Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 905
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 908
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "username"

    move-object/from16 v0, v143

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 909
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "password"

    move-object/from16 v0, v209

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 911
    new-instance v6, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v13}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v6, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v13, "/users/authenticate"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 914
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v1, v2, v13}, Lco/vine/android/network/HttpOperation;->createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 918
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 919
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v279, v0

    move-object/from16 v0, v279

    check-cast v0, Lco/vine/android/api/VineLogin;

    move-object/16 v279, v0

    .line 920
    .restart local v279    # "vl":Lco/vine/android/api/VineLogin;
    move-object/from16 v0, v279

    iget-object v6, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    move-object/from16 v0, v112

    move-object/from16 v1, v106

    invoke-static {v0, v1, v6}, Lco/vine/android/client/VineAccountHelper;->setSessionKey(Landroid/accounts/AccountManager;Landroid/accounts/Account;Ljava/lang/String;)V

    .line 921
    const-string v6, "s_key"

    move-object/from16 v0, v279

    iget-object v13, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 922
    invoke-static/range {v127 .. v127}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v6

    move-object/from16 v0, v279

    iget-object v13, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    invoke-virtual {v6, v13}, Lco/vine/android/client/AppController;->setSessionKey(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 927
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v143    # "email":Ljava/lang/String;
    .end local v209    # "password":Ljava/lang/String;
    .end local v279    # "vl":Lco/vine/android/api/VineLogin;
    :pswitch_2
    move-object/from16 v0, v112

    move-object/from16 v1, v106

    invoke-static {v0, v1}, Lco/vine/android/client/VineAccountHelper;->getTwitterToken(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v249

    .line 928
    .restart local v249    # "token":Ljava/lang/String;
    move-object/from16 v0, v112

    move-object/from16 v1, v106

    invoke-static {v0, v1}, Lco/vine/android/client/VineAccountHelper;->getTwitterSecret(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v240

    .line 929
    .restart local v240    # "secret":Ljava/lang/String;
    invoke-static {}, Lco/vine/android/api/VineParserReader;->createLoginReader()Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 931
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 934
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthToken"

    move-object/from16 v0, v249

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 935
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthSecret"

    move-object/from16 v0, v240

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 937
    const-string v6, "reactivate"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    if-eqz v6, :cond_22

    const-string v210, "reactivate"

    .line 939
    .local v210, "pathSegment":Ljava/lang/String;
    :goto_f
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    aput-object v210, v13, v16

    const/16 v16, 0x2

    const-string v17, "twitter"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 942
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v1, v2, v13}, Lco/vine/android/network/HttpOperation;->createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 946
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 947
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v279, v0

    move-object/from16 v0, v279

    check-cast v0, Lco/vine/android/api/VineLogin;

    move-object/16 v279, v0

    .line 948
    .restart local v279    # "vl":Lco/vine/android/api/VineLogin;
    move-object/from16 v0, v279

    iget-object v6, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    move-object/from16 v0, v112

    move-object/from16 v1, v106

    invoke-static {v0, v1, v6}, Lco/vine/android/client/VineAccountHelper;->setSessionKey(Landroid/accounts/AccountManager;Landroid/accounts/Account;Ljava/lang/String;)V

    .line 949
    const-string v6, "s_key"

    move-object/from16 v0, v279

    iget-object v13, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 950
    invoke-static/range {v127 .. v127}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v6

    move-object/from16 v0, v279

    iget-object v13, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    invoke-virtual {v6, v13}, Lco/vine/android/client/AppController;->setSessionKey(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 937
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v210    # "pathSegment":Ljava/lang/String;
    .end local v279    # "vl":Lco/vine/android/api/VineLogin;
    :cond_22
    const-string v210, "authenticate"

    goto :goto_f

    .line 958
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v106    # "account":Landroid/accounts/Account;
    .end local v112    # "am":Landroid/accounts/AccountManager;
    .end local v178    # "loginType":I
    .end local v240    # "secret":Ljava/lang/String;
    .end local v249    # "token":Ljava/lang/String;
    :sswitch_a
    const-string v6, "key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 959
    .local v8, "tokenKey":Ljava/lang/String;
    const-string v6, "secret"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 960
    .local v9, "tokenSecret":Ljava/lang/String;
    const-string v6, "uri"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v121

    .line 961
    .local v121, "callback":Ljava/lang/String;
    new-instance v6, Lorg/scribe/builder/ServiceBuilder;

    invoke-direct {v6}, Lorg/scribe/builder/ServiceBuilder;-><init>()V

    const-class v13, Lorg/scribe/builder/api/TwitterApi;

    invoke-virtual {v6, v13}, Lorg/scribe/builder/ServiceBuilder;->provider(Ljava/lang/Class;)Lorg/scribe/builder/ServiceBuilder;

    move-result-object v6

    invoke-virtual {v6, v8}, Lorg/scribe/builder/ServiceBuilder;->apiKey(Ljava/lang/String;)Lorg/scribe/builder/ServiceBuilder;

    move-result-object v6

    invoke-virtual {v6, v9}, Lorg/scribe/builder/ServiceBuilder;->apiSecret(Ljava/lang/String;)Lorg/scribe/builder/ServiceBuilder;

    move-result-object v6

    move-object/from16 v0, v121

    invoke-virtual {v6, v0}, Lorg/scribe/builder/ServiceBuilder;->callback(Ljava/lang/String;)Lorg/scribe/builder/ServiceBuilder;

    move-result-object v6

    invoke-virtual {v6}, Lorg/scribe/builder/ServiceBuilder;->build()Lorg/scribe/oauth/OAuthService;

    move-result-object v241

    .line 968
    .local v241, "service":Lorg/scribe/oauth/OAuthService;
    invoke-interface/range {v241 .. v241}, Lorg/scribe/oauth/OAuthService;->getRequestToken()Lorg/scribe/model/Token;

    move-result-object v249

    .line 969
    .local v249, "token":Lorg/scribe/model/Token;
    move-object/from16 v0, v241

    move-object/from16 v1, v249

    invoke-interface {v0, v1}, Lorg/scribe/oauth/OAuthService;->getAuthorizationUrl(Lorg/scribe/model/Token;)Ljava/lang/String;

    move-result-object v115

    .line 970
    .local v115, "authUrl":Ljava/lang/String;
    const-string v6, "load_url"

    move-object/from16 v0, p2

    move-object/from16 v1, v115

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 974
    .end local v8    # "tokenKey":Ljava/lang/String;
    .end local v9    # "tokenSecret":Ljava/lang/String;
    .end local v115    # "authUrl":Ljava/lang/String;
    .end local v121    # "callback":Ljava/lang/String;
    .end local v241    # "service":Lorg/scribe/oauth/OAuthService;
    .end local v249    # "token":Lorg/scribe/model/Token;
    :sswitch_b
    const-string v6, "username"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 975
    .local v7, "username":Ljava/lang/String;
    const-string v6, "key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 976
    .restart local v8    # "tokenKey":Ljava/lang/String;
    const-string v6, "secret"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 977
    .restart local v9    # "tokenSecret":Ljava/lang/String;
    const-string v6, "t_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 978
    .local v10, "userId":J
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 979
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v123

    .line 983
    .local v123, "client":Lco/vine/android/network/ThreadedHttpOperationClient;
    const-string v6, "reactivate"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    if-eqz v6, :cond_23

    const-string v210, "reactivate"

    .line 985
    .restart local v210    # "pathSegment":Ljava/lang/String;
    :goto_10
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    aput-object v210, v13, v16

    const/16 v16, 0x2

    const-string v17, "twitter"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 988
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x2

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 990
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthToken"

    invoke-direct {v6, v13, v8}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 991
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthSecret"

    invoke-direct {v6, v13, v9}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 992
    const/4 v6, 0x5

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 993
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v123

    move-object/from16 v1, v26

    move-object/from16 v2, v28

    move-object/from16 v3, v29

    invoke-static {v0, v1, v2, v3, v6}, Lco/vine/android/network/HttpOperation;->createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 994
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_24

    .line 995
    const-string v6, "a_exists"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 999
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v279, v0

    move-object/from16 v0, v279

    check-cast v0, Lco/vine/android/api/VineLogin;

    move-object/16 v279, v0

    .line 1000
    .restart local v279    # "vl":Lco/vine/android/api/VineLogin;
    move-object/from16 v0, v279

    iput-object v7, v0, Lco/vine/android/api/VineLogin;->twitterUsername:Ljava/lang/String;

    .line 1001
    move-object/from16 v0, v279

    iput-object v8, v0, Lco/vine/android/api/VineLogin;->twitterToken:Ljava/lang/String;

    .line 1002
    move-object/from16 v0, v279

    iput-object v9, v0, Lco/vine/android/api/VineLogin;->twitterSecret:Ljava/lang/String;

    .line 1003
    move-object/from16 v0, v279

    iput-wide v10, v0, Lco/vine/android/api/VineLogin;->twitterUserId:J

    .line 1004
    const/4 v6, 0x2

    move-object/from16 v0, v279

    iput v6, v0, Lco/vine/android/api/VineLogin;->loginType:I

    .line 1005
    const-string v6, "login"

    move-object/from16 v0, p2

    move-object/from16 v1, v279

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1008
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v13}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v13, "/users/me"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object/16 v274, v0

    .line 1009
    .local v274, "usersMe":Ljava/lang/String;
    const/4 v6, 0x2

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1010
    new-instance v6, Ljava/lang/StringBuilder;

    move-object/from16 v0, v274

    invoke-direct {v6, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v279

    iget-object v0, v0, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v123

    move-object/from16 v1, v29

    move-object/from16 v2, v16

    invoke-static {v0, v6, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1012
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1013
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v261, v0

    move-object/from16 v0, v261

    check-cast v0, Lco/vine/android/api/VineUser;

    move-object/16 v261, v0

    .line 1014
    .local v261, "user":Lco/vine/android/api/VineUser;
    const-string v6, "user"

    move-object/from16 v0, p2

    move-object/from16 v1, v261

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 983
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v210    # "pathSegment":Ljava/lang/String;
    .end local v261    # "user":Lco/vine/android/api/VineUser;
    .end local v274    # "usersMe":Ljava/lang/String;
    .end local v279    # "vl":Lco/vine/android/api/VineLogin;
    :cond_23
    const-string v210, "authenticate"

    goto/16 :goto_10

    .line 1019
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .restart local v210    # "pathSegment":Ljava/lang/String;
    :cond_24
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v148

    .end local v148    # "error":Lco/vine/android/api/VineError;
    check-cast v148, Lco/vine/android/api/VineError;

    .line 1020
    .restart local v148    # "error":Lco/vine/android/api/VineError;
    if-nez v148, :cond_25

    .line 1021
    const v6, 0x7f0e00cb

    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v221

    .line 1022
    goto/16 :goto_0

    .line 1024
    :cond_25
    const-string v6, "Got error: {} {}"

    move-object/from16 v0, v148

    iget v13, v0, Lco/vine/android/api/VineError;->errorCode:I

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    move-object/from16 v0, v148

    iget-object v0, v0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-static {v6, v13, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1026
    move-object/from16 v0, v148

    iget v0, v0, Lco/vine/android/api/VineError;->errorCode:I

    move/from16 v125, v0

    .line 1027
    .local v125, "code":I
    sget-object v6, Lco/vine/android/api/VineError$VineKnownErrors;->BAD_CREDENTIALS:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v6, v6, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    move/from16 v0, v125

    if-eq v6, v0, :cond_26

    sget-object v6, Lco/vine/android/api/VineError$VineKnownErrors;->RECORD_DOES_NOT_EXIST:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v6, v6, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    move/from16 v0, v125

    if-eq v6, v0, :cond_26

    sget-object v6, Lco/vine/android/api/VineError$VineKnownErrors;->ACCOUNT_DEACTIVATED:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v6, v6, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    move/from16 v0, v125

    if-ne v6, v0, :cond_27

    .line 1030
    :cond_26
    new-instance v5, Lco/vine/android/api/VineLogin;

    const/4 v6, 0x0

    const/4 v12, 0x0

    invoke-direct/range {v5 .. v12}, Lco/vine/android/api/VineLogin;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V

    .line 1032
    .end local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .restart local v5    # "login":Lco/vine/android/api/VineLogin;
    const-string v6, "login"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v5}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1033
    const-string v6, "a_exists"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1034
    const-string v6, "error_code"

    move-object/from16 v0, v148

    iget v13, v0, Lco/vine/android/api/VineError;->errorCode:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 1036
    .end local v5    # "login":Lco/vine/android/api/VineLogin;
    .restart local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    :cond_27
    move-object/from16 v0, v148

    iget-object v0, v0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    move-object/from16 v221, v0

    goto/16 :goto_0

    .line 1043
    .end local v7    # "username":Ljava/lang/String;
    .end local v8    # "tokenKey":Ljava/lang/String;
    .end local v9    # "tokenSecret":Ljava/lang/String;
    .end local v10    # "userId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v123    # "client":Lco/vine/android/network/ThreadedHttpOperationClient;
    .end local v125    # "code":I
    .end local v210    # "pathSegment":Ljava/lang/String;
    :sswitch_c
    const-string v6, "login"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    move-object/16 v276, v0

    move-object/from16 v0, v276

    check-cast v0, Lco/vine/android/api/VineLogin;

    move-object/16 v276, v0

    .line 1044
    .local v276, "v":Lco/vine/android/api/VineLogin;
    new-instance v6, Lorg/scribe/builder/ServiceBuilder;

    invoke-direct {v6}, Lorg/scribe/builder/ServiceBuilder;-><init>()V

    const-class v13, Lorg/scribe/builder/api/TwitterApi;

    invoke-virtual {v6, v13}, Lorg/scribe/builder/ServiceBuilder;->provider(Ljava/lang/Class;)Lorg/scribe/builder/ServiceBuilder;

    move-result-object v6

    sget-object v13, Lco/vine/android/client/TwitterVineApp;->API_KEY:Ljava/lang/String;

    invoke-virtual {v6, v13}, Lorg/scribe/builder/ServiceBuilder;->apiKey(Ljava/lang/String;)Lorg/scribe/builder/ServiceBuilder;

    move-result-object v6

    sget-object v13, Lco/vine/android/client/TwitterVineApp;->API_SECRET:Ljava/lang/String;

    invoke-virtual {v6, v13}, Lorg/scribe/builder/ServiceBuilder;->apiSecret(Ljava/lang/String;)Lorg/scribe/builder/ServiceBuilder;

    move-result-object v6

    invoke-virtual {v6}, Lorg/scribe/builder/ServiceBuilder;->build()Lorg/scribe/oauth/OAuthService;

    move-result-object v241

    .line 1050
    .restart local v241    # "service":Lorg/scribe/oauth/OAuthService;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v13}, Lco/vine/android/client/VineAPI;->getTwitterUrl()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v13, "/users/show.json?id="

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v276

    iget-wide v0, v0, Lco/vine/android/api/VineLogin;->twitterUserId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v6, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    .line 1051
    .local v26, "url":Ljava/lang/String;
    new-instance v231, Lorg/scribe/model/OAuthRequest;

    sget-object v6, Lorg/scribe/model/Verb;->GET:Lorg/scribe/model/Verb;

    move-object/from16 v0, v231

    move-object/from16 v1, v26

    invoke-direct {v0, v6, v1}, Lorg/scribe/model/OAuthRequest;-><init>(Lorg/scribe/model/Verb;Ljava/lang/String;)V

    .line 1052
    .local v231, "request":Lorg/scribe/model/OAuthRequest;
    new-instance v249, Lorg/scribe/model/Token;

    move-object/from16 v0, v276

    iget-object v6, v0, Lco/vine/android/api/VineLogin;->twitterToken:Ljava/lang/String;

    move-object/from16 v0, v276

    iget-object v13, v0, Lco/vine/android/api/VineLogin;->twitterSecret:Ljava/lang/String;

    move-object/from16 v0, v249

    invoke-direct {v0, v6, v13}, Lorg/scribe/model/Token;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1053
    .restart local v249    # "token":Lorg/scribe/model/Token;
    move-object/from16 v0, v241

    move-object/from16 v1, v249

    move-object/from16 v2, v231

    invoke-interface {v0, v1, v2}, Lorg/scribe/oauth/OAuthService;->signRequest(Lorg/scribe/model/Token;Lorg/scribe/model/OAuthRequest;)V

    .line 1056
    :try_start_1
    invoke-virtual/range {v231 .. v231}, Lorg/scribe/model/OAuthRequest;->send()Lorg/scribe/model/Response;

    move-result-object v235

    .line 1058
    .local v235, "response":Lorg/scribe/model/Response;
    invoke-virtual/range {v235 .. v235}, Lorg/scribe/model/Response;->isSuccessful()Z
    :try_end_1
    .catch Lorg/scribe/exceptions/OAuthException; {:try_start_1 .. :try_end_1} :catch_2

    move-result v6

    if-eqz v6, :cond_1

    .line 1060
    :try_start_2
    new-instance v6, Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-direct {v6}, Lcom/fasterxml/jackson/core/JsonFactory;-><init>()V

    invoke-virtual/range {v235 .. v235}, Lorg/scribe/model/Response;->getBody()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonParser(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v203

    .line 1061
    .local v203, "p":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-virtual/range {v203 .. v203}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 1062
    invoke-static/range {v203 .. v203}, Lco/vine/android/api/VineParsers;->parseTwitterUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/TwitterUser;

    move-result-object v247

    .line 1064
    .local v247, "tUser":Lco/vine/android/api/TwitterUser;
    const-string v6, "t_user"

    move-object/from16 v0, p2

    move-object/from16 v1, v247

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lorg/scribe/exceptions/OAuthException; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_0

    .line 1065
    .end local v203    # "p":Lcom/fasterxml/jackson/core/JsonParser;
    .end local v247    # "tUser":Lco/vine/android/api/TwitterUser;
    :catch_1
    move-exception v139

    .line 1066
    .local v139, "e":Ljava/io/IOException;
    :try_start_3
    sget-boolean v6, Lco/vine/android/service/VineService;->LOGGABLE:Z

    if-eqz v6, :cond_1

    .line 1067
    const-string v6, "Failed to parse."

    move-object/from16 v0, v139

    invoke-static {v6, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catch Lorg/scribe/exceptions/OAuthException; {:try_start_3 .. :try_end_3} :catch_2

    goto/16 :goto_0

    .line 1072
    .end local v139    # "e":Ljava/io/IOException;
    .end local v235    # "response":Lorg/scribe/model/Response;
    :catch_2
    move-exception v200

    .line 1073
    .local v200, "oAuthException":Lorg/scribe/exceptions/OAuthException;
    const-string v6, "Failed to connect."

    move-object/from16 v0, v200

    invoke-static {v6, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1079
    .end local v26    # "url":Ljava/lang/String;
    .end local v200    # "oAuthException":Lorg/scribe/exceptions/OAuthException;
    .end local v231    # "request":Lorg/scribe/model/OAuthRequest;
    .end local v241    # "service":Lorg/scribe/oauth/OAuthService;
    .end local v249    # "token":Lorg/scribe/model/Token;
    .end local v276    # "v":Lco/vine/android/api/VineLogin;
    :sswitch_d
    const-string v6, "conversation_row_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v67

    .line 1080
    .restart local v67    # "conversationRowId":J
    move-wide/from16 v0, v67

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getMessagesForConversationRowId(J)Landroid/database/Cursor;

    move-result-object v119

    .line 1081
    .local v119, "c":Landroid/database/Cursor;
    if-eqz v119, :cond_1

    .line 1083
    .end local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    :goto_11
    :try_start_4
    invoke-interface/range {v119 .. v119}, Landroid/database/Cursor;->moveToNext()Z

    move-result v6

    if-eqz v6, :cond_28

    .line 1084
    new-instance v64, Lco/vine/android/api/VinePrivateMessage;

    move-object/from16 v0, v64

    move-object/from16 v1, v119

    invoke-direct {v0, v1}, Lco/vine/android/api/VinePrivateMessage;-><init>(Landroid/database/Cursor;)V

    .line 1085
    .local v64, "vpm":Lco/vine/android/api/VinePrivateMessage;
    move-object/from16 v0, v64

    iget-object v13, v0, Lco/vine/android/api/VinePrivateMessage;->uploadPath:Ljava/lang/String;

    const/4 v14, 0x1

    move-object/from16 v0, v64

    iget-wide v15, v0, Lco/vine/android/api/VinePrivateMessage;->messageRowId:J

    move-object/from16 v0, v64

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->conversationRowId:J

    move-wide/from16 v17, v0

    const/16 v19, 0x0

    move-object/from16 v0, v64

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    move-object/from16 v20, v0

    move-object/from16 v0, v64

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    move-wide/from16 v21, v0

    move-object/from16 v0, v64

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    move-object/from16 v23, v0

    move-object/from16 v0, v64

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v64

    iget v0, v0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    move/from16 v25, v0

    move-object/from16 v12, p0

    invoke-static/range {v12 .. v25}, Lco/vine/android/service/VineUploadService;->getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJJLjava/util/ArrayList;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v6

    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lco/vine/android/service/VineService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_11

    .line 1089
    .end local v64    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    :catchall_0
    move-exception v6

    invoke-interface/range {v119 .. v119}, Landroid/database/Cursor;->close()V

    throw v6

    :cond_28
    invoke-interface/range {v119 .. v119}, Landroid/database/Cursor;->close()V

    goto/16 :goto_0

    .line 1095
    .end local v67    # "conversationRowId":J
    .end local v119    # "c":Landroid/database/Cursor;
    .restart local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    :sswitch_e
    const-string v6, "username"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 1096
    .restart local v7    # "username":Ljava/lang/String;
    const-string v6, "pass"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v209

    .line 1098
    .restart local v209    # "password":Ljava/lang/String;
    new-instance v118, Ltwitter4j/conf/ConfigurationBuilder;

    invoke-direct/range {v118 .. v118}, Ltwitter4j/conf/ConfigurationBuilder;-><init>()V

    .line 1099
    .local v118, "builder":Ltwitter4j/conf/ConfigurationBuilder;
    sget-object v6, Lco/vine/android/client/TwitterVineApp;->API_KEY:Ljava/lang/String;

    move-object/from16 v0, v118

    invoke-virtual {v0, v6}, Ltwitter4j/conf/ConfigurationBuilder;->setOAuthConsumerKey(Ljava/lang/String;)Ltwitter4j/conf/ConfigurationBuilder;

    .line 1100
    sget-object v6, Lco/vine/android/client/TwitterVineApp;->API_SECRET:Ljava/lang/String;

    move-object/from16 v0, v118

    invoke-virtual {v0, v6}, Ltwitter4j/conf/ConfigurationBuilder;->setOAuthConsumerSecret(Ljava/lang/String;)Ltwitter4j/conf/ConfigurationBuilder;

    .line 1102
    new-instance v6, Ltwitter4j/VineTwitterFactory;

    invoke-virtual/range {v118 .. v118}, Ltwitter4j/conf/ConfigurationBuilder;->build()Ltwitter4j/conf/Configuration;

    move-result-object v13

    invoke-direct {v6, v13}, Ltwitter4j/VineTwitterFactory;-><init>(Ltwitter4j/conf/Configuration;)V

    new-instance v13, Ltwitter4j/auth/BasicAuthorization;

    move-object/from16 v0, v209

    invoke-direct {v13, v7, v0}, Ltwitter4j/auth/BasicAuthorization;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v6, v13}, Ltwitter4j/VineTwitterFactory;->getInstance(Ltwitter4j/auth/Authorization;)Ltwitter4j/Twitter;

    move-result-object v250

    .line 1106
    .local v250, "twitter":Ltwitter4j/Twitter;
    :try_start_5
    invoke-interface/range {v250 .. v250}, Ltwitter4j/Twitter;->getOAuthAccessToken()Ltwitter4j/auth/AccessToken;

    move-result-object v103

    .line 1107
    .local v103, "aToken":Ltwitter4j/auth/AccessToken;
    new-instance v5, Lco/vine/android/api/VineLogin;

    const/4 v13, 0x0

    invoke-virtual/range {v103 .. v103}, Ltwitter4j/auth/AccessToken;->getScreenName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual/range {v103 .. v103}, Ltwitter4j/auth/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v15

    invoke-virtual/range {v103 .. v103}, Ltwitter4j/auth/AccessToken;->getTokenSecret()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v103 .. v103}, Ltwitter4j/auth/AccessToken;->getUserId()J

    move-result-wide v17

    const/16 v19, 0x0

    move-object v12, v5

    invoke-direct/range {v12 .. v19}, Lco/vine/android/api/VineLogin;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V

    .line 1109
    .end local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .restart local v5    # "login":Lco/vine/android/api/VineLogin;
    const-string v6, "login"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v5}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V
    :try_end_5
    .catch Ltwitter4j/TwitterException; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 1110
    const/16 v245, 0xc8

    .line 1129
    const-string v6, "pass"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1111
    .end local v5    # "login":Lco/vine/android/api/VineLogin;
    .end local v103    # "aToken":Ltwitter4j/auth/AccessToken;
    :catch_3
    move-exception v139

    .line 1112
    .local v139, "e":Ltwitter4j/TwitterException;
    :try_start_6
    invoke-virtual/range {v127 .. v127}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v232

    .line 1113
    .local v232, "res":Landroid/content/res/Resources;
    invoke-virtual/range {v139 .. v139}, Ltwitter4j/TwitterException;->getStatusCode()I

    move-result v6

    const/16 v13, 0x191

    if-ne v6, v13, :cond_2a

    .line 1114
    const/16 v245, 0x191

    .line 1115
    invoke-static/range {v139 .. v139}, Lco/vine/android/util/Util;->isXauth2FactorError(Ltwitter4j/TwitterException;)Z

    move-result v6

    if-eqz v6, :cond_29

    .line 1116
    const v6, 0x7f0e00c7

    move-object/from16 v0, v232

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    move-result-object v221

    .line 1129
    :goto_12
    const-string v6, "pass"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1118
    :cond_29
    const v6, 0x7f0e00c9

    :try_start_7
    move-object/from16 v0, v232

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v221

    goto :goto_12

    .line 1120
    :cond_2a
    invoke-virtual/range {v139 .. v139}, Ltwitter4j/TwitterException;->isCausedByNetworkIssue()Z

    move-result v6

    if-eqz v6, :cond_2b

    .line 1121
    const/16 v245, 0x1f4

    .line 1122
    const v6, 0x7f0e00c8

    move-object/from16 v0, v232

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v221

    goto :goto_12

    .line 1124
    :cond_2b
    const/16 v245, 0x1f4

    .line 1125
    const v6, 0x7f0e00d0

    move-object/from16 v0, v232

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    move-result-object v221

    goto :goto_12

    .line 1129
    .end local v139    # "e":Ltwitter4j/TwitterException;
    .end local v232    # "res":Landroid/content/res/Resources;
    :catchall_1
    move-exception v6

    const-string v13, "pass"

    const/16 v16, 0x0

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v13, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    throw v6

    .line 1135
    .end local v7    # "username":Ljava/lang/String;
    .end local v118    # "builder":Ltwitter4j/conf/ConfigurationBuilder;
    .end local v209    # "password":Ljava/lang/String;
    .end local v250    # "twitter":Ltwitter4j/Twitter;
    .restart local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    :sswitch_f
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackResetPassword()V

    .line 1136
    const-string v6, "login"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v143

    .line 1137
    .restart local v143    # "email":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "forgotPassword"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1139
    .local v26, "url":Ljava/lang/StringBuilder;
    const-string v6, "email"

    move-object/from16 v0, v26

    move-object/from16 v1, v143

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 1140
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1141
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v1, v13}, Lco/vine/android/network/HttpOperation;->createGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1145
    goto/16 :goto_0

    .line 1148
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v143    # "email":Ljava/lang/String;
    :sswitch_10
    const-string v6, "post_id"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v14

    .line 1149
    .local v14, "postId":J
    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v204

    .line 1150
    .local v204, "page":I
    const-string v6, "time"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v60

    .line 1152
    .local v60, "anchor":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "likes"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1155
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1156
    const-wide/16 v16, 0x0

    cmp-long v6, v60, v16

    if-lez v6, :cond_2c

    .line 1157
    const-string v6, "anchor"

    move-object/from16 v0, v26

    move-wide/from16 v1, v60

    invoke-static {v0, v6, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    .line 1159
    :cond_2c
    const-string v6, "size"

    const/16 v13, 0x14

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1161
    const/16 v6, 0xb

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1162
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1166
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1167
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v177

    check-cast v177, Lco/vine/android/api/VinePagedData;

    .line 1168
    .local v177, "likes":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineLike;>;"
    move-object/from16 v0, v177

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, v177

    iget v0, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move/from16 v16, v0

    move-object/from16 v0, v177

    iget v0, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move/from16 v17, v0

    invoke-virtual/range {v12 .. v17}, Lco/vine/android/provider/VineDatabaseHelper;->mergeLikes(Ljava/util/Collection;JII)I

    .line 1169
    const-string v6, "count"

    move-object/from16 v0, v177

    iget v13, v0, Lco/vine/android/api/VinePagedData;->count:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1170
    const-string v6, "next_page"

    move-object/from16 v0, v177

    iget v13, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1171
    const-string v6, "previous_page"

    move-object/from16 v0, v177

    iget v13, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1172
    const-string v6, "time"

    move-object/from16 v0, v177

    iget-wide v0, v0, Lco/vine/android/api/VinePagedData;->anchor:J

    move-wide/from16 v16, v0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1174
    new-instance v24, Ljava/util/ArrayList;

    invoke-direct/range {v24 .. v24}, Ljava/util/ArrayList;-><init>()V

    .line 1175
    .local v24, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v177

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_13
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2d

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v175

    check-cast v175, Lco/vine/android/api/VineLike;

    .line 1176
    .local v175, "like":Lco/vine/android/api/VineLike;
    move-object/from16 v0, v175

    iget-object v6, v0, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    move-object/from16 v0, v24

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_13

    .line 1178
    .end local v175    # "like":Lco/vine/android/api/VineLike;
    :cond_2d
    const-string v6, "users"

    move-object/from16 v0, p2

    move-object/from16 v1, v24

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1180
    move-object/from16 v0, v177

    iget v6, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    if-gtz v6, :cond_1

    .line 1181
    const/4 v6, 0x5

    invoke-static {v14, v15}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v6, v13}, Lco/vine/android/provider/VineDatabaseHelper;->markLastUser(ILjava/lang/String;)V

    goto/16 :goto_0

    .line 1189
    .end local v14    # "postId":J
    .end local v24    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v60    # "anchor":J
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v177    # "likes":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineLike;>;"
    .end local v204    # "page":I
    :sswitch_11
    const/16 v18, 0x2

    .line 1190
    .local v18, "userGroupsType":I
    const-string v233, "followers"

    .line 1191
    .local v233, "resourceFollowType":Ljava/lang/String;
    const/16 v6, 0x17

    move/from16 v0, p1

    if-ne v0, v6, :cond_2e

    .line 1192
    const/16 v18, 0x1

    .line 1193
    const-string v233, "following"

    .line 1195
    :cond_2e
    const-string v6, "profile_id"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v10

    .line 1196
    .restart local v10    # "userId":J
    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v204

    .line 1197
    .restart local v204    # "page":I
    const-string v6, "time"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v60

    .line 1199
    .restart local v60    # "anchor":J
    const-wide/16 v16, 0x0

    cmp-long v6, v10, v16

    if-lez v6, :cond_1

    .line 1200
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    aput-object v233, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1202
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1203
    const-wide/16 v16, 0x0

    cmp-long v6, v60, v16

    if-lez v6, :cond_2f

    .line 1204
    const-string v6, "anchor"

    move-object/from16 v0, v26

    move-wide/from16 v1, v60

    invoke-static {v0, v6, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    .line 1206
    :cond_2f
    const-string v6, "size"

    const/16 v13, 0xa

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1207
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1209
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1212
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1213
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v273, v0

    move-object/from16 v0, v273

    check-cast v0, Lco/vine/android/api/VinePagedData;

    move-object/16 v273, v0

    .line 1214
    .local v273, "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_31

    .line 1215
    new-instance v22, Lco/vine/android/util/LongSparseArray;

    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    move-object/from16 v0, v22

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 1217
    .local v22, "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_14
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_30

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v256, v0

    move-object/from16 v0, v256

    check-cast v0, Lco/vine/android/api/VineUser;

    move-object/16 v256, v0

    .line 1218
    .local v256, "u":Lco/vine/android/api/VineUser;
    move-object/from16 v0, v256

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->userId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v256

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->orderId:J

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    move-object/from16 v0, v22

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2, v6}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    goto :goto_14

    .line 1220
    .end local v256    # "u":Lco/vine/android/api/VineUser;
    :cond_30
    move-object/from16 v0, v273

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move/from16 v20, v0

    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move/from16 v21, v0

    move-object/from16 v16, v12

    invoke-virtual/range {v16 .. v22}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 1223
    const-string v6, "count"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->count:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1224
    const-string v6, "next_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1225
    const-string v6, "previous_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1226
    const-string v6, "time"

    move-object/from16 v0, v273

    iget-wide v0, v0, Lco/vine/android/api/VinePagedData;->anchor:J

    move-wide/from16 v16, v0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1227
    const-string v6, "users"

    move-object/from16 v0, v273

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1229
    .end local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .end local v162    # "i$":Ljava/util/Iterator;
    :cond_31
    move-object/from16 v0, v273

    iget v6, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    if-gtz v6, :cond_1

    .line 1230
    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    const-string v13, "_id DESC"

    move/from16 v0, v18

    invoke-virtual {v12, v0, v6, v13}, Lco/vine/android/provider/VineDatabaseHelper;->markLastUser(ILjava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1239
    .end local v10    # "userId":J
    .end local v18    # "userGroupsType":I
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v60    # "anchor":J
    .end local v204    # "page":I
    .end local v233    # "resourceFollowType":Ljava/lang/String;
    .end local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    :sswitch_12
    const/16 v18, 0xc

    .line 1240
    .restart local v18    # "userGroupsType":I
    move-wide/from16 v10, v34

    .line 1241
    .restart local v10    # "userId":J
    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v204

    .line 1242
    .restart local v204    # "page":I
    const-string v6, "time"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v60

    .line 1243
    .restart local v60    # "anchor":J
    const-string v6, "notification_id"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v197

    .line 1245
    .local v197, "notificationId":J
    const-wide/16 v16, 0x0

    cmp-long v6, v10, v16

    if-lez v6, :cond_1

    .line 1246
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x6

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "notifications"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "grouped"

    aput-object v17, v13, v16

    const/16 v16, 0x4

    invoke-static/range {v197 .. v198}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x5

    const-string v17, "users"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1249
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1250
    const-wide/16 v16, 0x0

    cmp-long v6, v60, v16

    if-lez v6, :cond_32

    .line 1251
    const-string v6, "anchor"

    move-object/from16 v0, v26

    move-wide/from16 v1, v60

    invoke-static {v0, v6, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    .line 1253
    :cond_32
    const-string v6, "size"

    const/16 v13, 0xa

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1254
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1256
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1259
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1260
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v273, v0

    move-object/from16 v0, v273

    check-cast v0, Lco/vine/android/api/VinePagedData;

    move-object/16 v273, v0

    .line 1261
    .restart local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_34

    .line 1262
    new-instance v22, Lco/vine/android/util/LongSparseArray;

    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    move-object/from16 v0, v22

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 1264
    .restart local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_15
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_33

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v256, v0

    move-object/from16 v0, v256

    check-cast v0, Lco/vine/android/api/VineUser;

    move-object/16 v256, v0

    .line 1265
    .restart local v256    # "u":Lco/vine/android/api/VineUser;
    move-object/from16 v0, v256

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->userId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v256

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->orderId:J

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    move-object/from16 v0, v22

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2, v6}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    goto :goto_15

    .line 1267
    .end local v256    # "u":Lco/vine/android/api/VineUser;
    :cond_33
    move-object/from16 v0, v273

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    invoke-static/range {v197 .. v198}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move/from16 v20, v0

    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move/from16 v21, v0

    move-object/from16 v16, v12

    invoke-virtual/range {v16 .. v22}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 1270
    const-string v6, "count"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->count:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1271
    const-string v6, "next_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1272
    const-string v6, "previous_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1273
    const-string v6, "time"

    move-object/from16 v0, v273

    iget-wide v0, v0, Lco/vine/android/api/VinePagedData;->anchor:J

    move-wide/from16 v16, v0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1274
    const-string v6, "users"

    move-object/from16 v0, v273

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1276
    .end local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .end local v162    # "i$":Ljava/util/Iterator;
    :cond_34
    move-object/from16 v0, v273

    iget v6, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    if-gtz v6, :cond_1

    .line 1277
    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    const-string v13, "_id DESC"

    move/from16 v0, v18

    invoke-virtual {v12, v0, v6, v13}, Lco/vine/android/provider/VineDatabaseHelper;->markLastUser(ILjava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1286
    .end local v10    # "userId":J
    .end local v18    # "userGroupsType":I
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v60    # "anchor":J
    .end local v197    # "notificationId":J
    .end local v204    # "page":I
    .end local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    :sswitch_13
    const-string v6, "s_owner_id"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v10

    .line 1287
    .restart local v10    # "userId":J
    const-string v6, "type"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v32

    .line 1288
    .local v32, "sectionType":I
    const-string v6, "page_type"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v57

    .line 1289
    .local v57, "pageType":I
    const-wide/16 v225, -0x1

    .line 1290
    .local v225, "refreshTime":J
    const/16 v60, 0x0

    .line 1292
    .local v60, "anchor":Ljava/lang/String;
    move-object/from16 v0, p0

    move/from16 v1, v32

    invoke-static {v0, v1}, Lco/vine/android/provider/Vine;->getUserSectionsAnchorManager(Landroid/content/Context;I)Lco/vine/android/util/StringAnchorManager;

    move-result-object v243

    .line 1294
    .local v243, "sm":Lco/vine/android/util/StringAnchorManager;
    packed-switch v57, :pswitch_data_2

    .line 1315
    :cond_35
    :goto_16
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "friends"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1318
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    move/from16 v0, v32

    if-ne v0, v6, :cond_36

    .line 1319
    const-string v6, "withFavorites"

    const/4 v13, 0x0

    invoke-static {v13}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 1323
    :cond_36
    if-eqz v60, :cond_3a

    .line 1324
    const-string v6, "anchor"

    move-object/from16 v0, v26

    move-object/from16 v1, v60

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 1333
    :cond_37
    const-string v6, "size"

    const/16 v13, 0xa

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1335
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v0

    move-object/16 v280, v0

    .line 1336
    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    .local v280, "vp":Lco/vine/android/api/VineParserReader;
    invoke-virtual/range {v280 .. v280}, Lco/vine/android/api/VineParserReader;->getExtraBundle()Landroid/os/Bundle;

    move-result-object v6

    const-string v13, "friend_index"

    invoke-virtual/range {v243 .. v243}, Lco/vine/android/util/StringAnchorManager;->getIndex()J

    move-result-wide v16

    move-wide/from16 v0, v16

    invoke-virtual {v6, v13, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1337
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v280

    move-object/from16 v2, v43

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1341
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_8b

    .line 1342
    invoke-virtual/range {v243 .. v243}, Lco/vine/android/util/StringAnchorManager;->edit()Lco/vine/android/util/StringAnchorManager$Editor;

    move-result-object v140

    .line 1343
    .local v140, "edit":Lco/vine/android/util/StringAnchorManager$Editor;
    if-nez v60, :cond_38

    .line 1344
    move/from16 v0, v32

    invoke-virtual {v12, v0}, Lco/vine/android/provider/VineDatabaseHelper;->removeUserSectionsWithType(I)V

    .line 1345
    move-object/from16 v0, v140

    move-wide/from16 v1, v225

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/StringAnchorManager$Editor;->setRefreshTime(J)V

    .line 1347
    :cond_38
    invoke-virtual/range {v280 .. v280}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v273, v0

    move-object/from16 v0, v273

    check-cast v0, Lco/vine/android/api/VinePagedData;

    move-object/16 v273, v0

    .line 1348
    .restart local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->stringAnchor:Ljava/lang/String;

    if-eqz v6, :cond_39

    .line 1349
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->stringAnchor:Ljava/lang/String;

    move-object/from16 v0, v140

    invoke-virtual {v0, v6}, Lco/vine/android/util/StringAnchorManager$Editor;->setAnchor(Ljava/lang/String;)V

    .line 1350
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_39

    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_39

    .line 1351
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, v273

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v13

    add-int/lit8 v13, v13, -0x1

    invoke-virtual {v6, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/api/VineUser;

    iget-wide v0, v6, Lco/vine/android/api/VineUser;->friendIndex:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v140

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/StringAnchorManager$Editor;->setIndex(J)V

    .line 1354
    :cond_39
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_3e

    .line 1355
    const-wide/16 v171, 0x0

    .line 1356
    .local v171, "lastId":J
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_3c

    .line 1357
    new-instance v22, Lco/vine/android/util/LongSparseArray;

    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    move-object/from16 v0, v22

    invoke-direct {v0, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 1359
    .restart local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_17
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3b

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v256, v0

    move-object/from16 v0, v256

    check-cast v0, Lco/vine/android/api/VineUser;

    move-object/16 v256, v0

    .line 1360
    .restart local v256    # "u":Lco/vine/android/api/VineUser;
    move-object/from16 v0, v256

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->userId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v256

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->orderId:J

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    move-object/from16 v0, v22

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2, v6}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    goto :goto_17

    .line 1296
    .end local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v140    # "edit":Lco/vine/android/util/StringAnchorManager$Editor;
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v171    # "lastId":J
    .end local v256    # "u":Lco/vine/android/api/VineUser;
    .end local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    .end local v280    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    :pswitch_3
    const/16 v60, 0x0

    .line 1297
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v225

    .line 1298
    goto/16 :goto_16

    .line 1301
    :pswitch_4
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v13, "Invalid page type."

    invoke-direct {v6, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 1304
    :pswitch_5
    invoke-virtual/range {v243 .. v243}, Lco/vine/android/util/StringAnchorManager;->getStringAnchor()Ljava/lang/String;

    move-result-object v60

    .line 1305
    if-eqz v60, :cond_35

    .line 1306
    invoke-virtual/range {v243 .. v243}, Lco/vine/android/util/StringAnchorManager;->getRefreshTime()J

    move-result-wide v225

    goto/16 :goto_16

    .line 1326
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    :cond_3a
    const/4 v6, 0x1

    move/from16 v0, v57

    if-eq v0, v6, :cond_37

    const-wide/16 v16, -0x1

    cmp-long v6, v225, v16

    if-nez v6, :cond_37

    .line 1328
    const-string v6, "empty"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 1362
    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .restart local v140    # "edit":Lco/vine/android/util/StringAnchorManager$Editor;
    .restart local v162    # "i$":Ljava/util/Iterator;
    .restart local v171    # "lastId":J
    .restart local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    .restart local v280    # "vp":Lco/vine/android/api/VineParserReader;
    :cond_3b
    move-object/from16 v0, v273

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v24, v0

    const/16 v25, 0xa

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v26

    .end local v26    # "url":Ljava/lang/StringBuilder;
    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move/from16 v27, v0

    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move/from16 v28, v0

    const-wide/16 v16, -0x1

    cmp-long v6, v225, v16

    if-eqz v6, :cond_3f

    move-wide/from16 v30, v225

    :goto_18
    move-object/from16 v23, v12

    move-object/from16 v29, v22

    invoke-virtual/range {v23 .. v32}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;JI)I

    .line 1365
    const-string v6, "count"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->count:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1366
    const-string v6, "next_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1367
    const-string v6, "previous_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1368
    const-string v6, "users"

    move-object/from16 v0, v273

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1369
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, v273

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v13

    add-int/lit8 v13, v13, -0x1

    invoke-virtual {v6, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/api/VineUser;

    iget-wide v0, v6, Lco/vine/android/api/VineUser;->userId:J

    move-wide/from16 v171, v0

    .line 1372
    .end local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .end local v162    # "i$":Ljava/util/Iterator;
    :cond_3c
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->stringAnchor:Ljava/lang/String;

    if-nez v6, :cond_3d

    .line 1373
    const-wide/16 v171, 0x0

    .line 1376
    :cond_3d
    move-object/from16 v0, v140

    move-wide/from16 v1, v171

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/StringAnchorManager$Editor;->setLastId(J)V

    .line 1379
    .end local v171    # "lastId":J
    :cond_3e
    invoke-virtual/range {v140 .. v140}, Lco/vine/android/util/StringAnchorManager$Editor;->commit()V

    move-object/from16 v29, v280

    .line 1380
    .end local v280    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    goto/16 :goto_0

    .line 1362
    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .restart local v162    # "i$":Ljava/util/Iterator;
    .restart local v171    # "lastId":J
    .restart local v280    # "vp":Lco/vine/android/api/VineParserReader;
    :cond_3f
    const-wide/16 v30, -0x1

    goto :goto_18

    .line 1384
    .end local v10    # "userId":J
    .end local v22    # "orderMap":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Long;>;"
    .end local v32    # "sectionType":I
    .end local v57    # "pageType":I
    .end local v60    # "anchor":Ljava/lang/String;
    .end local v140    # "edit":Lco/vine/android/util/StringAnchorManager$Editor;
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v171    # "lastId":J
    .end local v225    # "refreshTime":J
    .end local v243    # "sm":Lco/vine/android/util/StringAnchorManager;
    .end local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    .end local v280    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    :sswitch_14
    const-string v6, "type"

    const/4 v13, -0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v36

    const-string v6, "size"

    const/16 v13, 0xa

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v37

    const-string v6, "profile_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v39

    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v41

    const-string v6, "time"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v42

    move-object/from16 v33, p0

    move-object/from16 v38, v12

    move-object/from16 v44, p2

    invoke-direct/range {v33 .. v44}, Lco/vine/android/service/VineService;->getPosts(JIILco/vine/android/provider/VineDatabaseHelper;JIJLandroid/os/Bundle;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1388
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->getReader()Lco/vine/android/network/HttpOperationReader;

    move-result-object v29

    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    check-cast v29, Lco/vine/android/api/VineParserReader;

    .line 1389
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    goto/16 :goto_0

    .line 1392
    :sswitch_15
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 1393
    .restart local v14    # "postId":J
    const-wide/16 v16, 0x0

    cmp-long v6, v14, v16

    if-lez v6, :cond_1

    .line 1394
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "timelines"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1396
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineService;->limitCommentAndLikesIfNeeded(Ljava/lang/StringBuilder;)V

    .line 1397
    const/16 v6, 0x8

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1398
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1400
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1401
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v236

    check-cast v236, Lco/vine/android/api/VinePagedData;

    .line 1403
    .local v236, "response":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    :try_start_8
    move-object/from16 v0, v236

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v37, v0

    const/16 v38, 0x7

    const-string v39, ""

    const/16 v40, 0x0

    const/16 v41, 0x0

    const/16 v42, 0x0

    const-wide/16 v43, 0x0

    const/16 v45, 0x1

    move-object/from16 v36, v12

    invoke-virtual/range {v36 .. v45}, Lco/vine/android/provider/VineDatabaseHelper;->mergePosts(Ljava/util/Collection;ILjava/lang/String;IIIJZ)Lco/vine/android/provider/DbResponse;

    .end local v43    # "key":Ljava/lang/String;
    move-result-object v234

    .line 1406
    .local v234, "resp":Lco/vine/android/provider/DbResponse;
    if-eqz v236, :cond_1

    move-object/from16 v0, v236

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_1

    .line 1407
    const-string v13, "post"

    move-object/from16 v0, v236

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/os/Parcelable;

    move-object/from16 v0, p2

    invoke-virtual {v0, v13, v6}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_4

    goto/16 :goto_0

    .line 1409
    .end local v234    # "resp":Lco/vine/android/provider/DbResponse;
    :catch_4
    move-exception v139

    .line 1410
    .local v139, "e":Ljava/io/IOException;
    sget-boolean v6, Lco/vine/android/service/VineService;->LOGGABLE:Z

    if-eqz v6, :cond_1

    .line 1411
    invoke-virtual/range {v139 .. v139}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_0

    .line 1419
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v139    # "e":Ljava/io/IOException;
    .end local v236    # "response":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    .restart local v43    # "key":Ljava/lang/String;
    :sswitch_16
    const-string v6, "post_id"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v37

    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v39

    const-string v6, "time"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v40

    const-string v6, "size"

    const/16 v13, 0xa

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v42

    move-object/from16 v36, p0

    move-object/from16 v44, p2

    move-object/from16 v45, v12

    invoke-direct/range {v36 .. v45}, Lco/vine/android/service/VineService;->getComments(JIJILjava/lang/String;Landroid/os/Bundle;Lco/vine/android/provider/VineDatabaseHelper;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1424
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->getReader()Lco/vine/android/network/HttpOperationReader;

    move-result-object v29

    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    check-cast v29, Lco/vine/android/api/VineParserReader;

    .line 1425
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackGetComments()V

    goto/16 :goto_0

    .line 1429
    :sswitch_17
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "editions"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1432
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0x14

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1433
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1437
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_40

    .line 1438
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v142

    check-cast v142, Ljava/util/ArrayList;

    .line 1439
    .local v142, "editions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    move-object/from16 v0, v142

    invoke-virtual {v12, v0}, Lco/vine/android/provider/VineDatabaseHelper;->mergeEditions(Ljava/util/ArrayList;)V

    .line 1440
    const-string v6, "editions"

    move-object/from16 v0, p2

    move-object/from16 v1, v142

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 1442
    .end local v142    # "editions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_40
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackGetEditions()V

    goto/16 :goto_0

    .line 1446
    .end local v26    # "url":Ljava/lang/StringBuilder;
    :sswitch_18
    const-string v6, "entities"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v52

    .line 1447
    .local v52, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v45

    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v47

    const-string v6, "username"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v49

    const-string v6, "comment"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v50

    const-string v6, "avatar_url"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v51

    move-object/from16 v44, p0

    move-object/from16 v53, v12

    move-object/from16 v54, p2

    invoke-direct/range {v44 .. v54}, Lco/vine/android/service/VineService;->postComment(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lco/vine/android/provider/VineDatabaseHelper;Landroid/os/Bundle;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1450
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->getReader()Lco/vine/android/network/HttpOperationReader;

    move-result-object v29

    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    check-cast v29, Lco/vine/android/api/VineParserReader;

    .line 1451
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackPostComment()V

    goto/16 :goto_0

    .line 1455
    .end local v52    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :sswitch_19
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v16

    const-string v6, "comment_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, p0

    move-wide/from16 v1, v16

    invoke-direct {v0, v1, v2, v6, v12}, Lco/vine/android/service/VineService;->deleteComment(JLjava/lang/String;Lco/vine/android/provider/VineDatabaseHelper;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1457
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->getReader()Lco/vine/android/network/HttpOperationReader;

    move-result-object v29

    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    check-cast v29, Lco/vine/android/api/VineParserReader;

    .line 1458
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackDeleteComment()V

    goto/16 :goto_0

    .line 1462
    :sswitch_1a
    move-object/from16 v0, p0

    move-object/from16 v1, v43

    move-object/from16 v2, p2

    invoke-direct {v0, v1, v2}, Lco/vine/android/service/VineService;->getUsersMe(Ljava/lang/String;Landroid/os/Bundle;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1463
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->getReader()Lco/vine/android/network/HttpOperationReader;

    move-result-object v29

    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    check-cast v29, Lco/vine/android/api/VineParserReader;

    .line 1464
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/util/FlurryUtils;->trackGetUser(Z)V

    goto/16 :goto_0

    .line 1468
    :sswitch_1b
    const-string v6, "key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v251

    .line 1469
    .local v251, "twitterKey":Ljava/lang/String;
    const-string v6, "secret"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v252

    .line 1471
    .local v252, "twitterSecret":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x5

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "following"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "suggested"

    aput-object v17, v13, v16

    const/16 v16, 0x4

    const-string v17, "twitter"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1478
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v0

    move-object/16 v280, v0

    .line 1480
    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v280    # "vp":Lco/vine/android/api/VineParserReader;
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x2

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 1481
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthToken"

    move-object/from16 v0, v251

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1482
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthSecret"

    move-object/from16 v0, v252

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1484
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v280

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1487
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_8b

    .line 1488
    invoke-virtual/range {v280 .. v280}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/util/ArrayList;

    .line 1489
    .restart local v24    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    if-eqz v24, :cond_41

    invoke-virtual/range {v24 .. v24}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_41

    .line 1490
    const/16 v25, 0x6

    invoke-static/range {v34 .. v35}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v26

    .end local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v27, 0x0

    const/16 v28, 0x0

    const/16 v29, 0x0

    move-object/from16 v23, v12

    invoke-virtual/range {v23 .. v29}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 1492
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    const-string v6, "count"

    invoke-virtual/range {v24 .. v24}, Ljava/util/ArrayList;->size()I

    move-result v13

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1493
    const-string v6, "users"

    move-object/from16 v0, p2

    move-object/from16 v1, v24

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    :cond_41
    move-object/from16 v29, v280

    .line 1495
    .end local v280    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    goto/16 :goto_0

    .line 1500
    .end local v24    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v251    # "twitterKey":Ljava/lang/String;
    .end local v252    # "twitterSecret":Ljava/lang/String;
    :sswitch_1c
    const/16 v111, 0x0

    .line 1502
    .local v111, "addressBook":Ljava/lang/String;
    :try_start_9
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/util/Util;->getAddressBookJson(Landroid/content/ContentResolver;)Ljava/lang/String;
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_5

    move-result-object v111

    .line 1507
    :goto_19
    if-nez v111, :cond_42

    if-eqz v202, :cond_42

    .line 1508
    const/16 v6, 0x3e8

    move-object/from16 v0, v202

    iput v6, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    .line 1509
    new-instance v148, Lco/vine/android/api/VineError;

    .end local v148    # "error":Lco/vine/android/api/VineError;
    const/16 v6, 0x3e8

    const-string v13, "Could not create json."

    move-object/from16 v0, v148

    invoke-direct {v0, v6, v13}, Lco/vine/android/api/VineError;-><init>(ILjava/lang/String;)V

    .line 1510
    .restart local v148    # "error":Lco/vine/android/api/VineError;
    goto/16 :goto_0

    .line 1503
    :catch_5
    move-exception v139

    .line 1504
    .restart local v139    # "e":Ljava/io/IOException;
    invoke-virtual/range {v139 .. v139}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_19

    .line 1513
    .end local v139    # "e":Ljava/io/IOException;
    :cond_42
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x5

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "following"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "suggested"

    aput-object v17, v13, v16

    const/16 v16, 0x4

    const-string v17, "contacts"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1520
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1522
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 1523
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "addressBook"

    move-object/from16 v0, v111

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1524
    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineService;->addCountryParam(Ljava/util/ArrayList;)V

    .line 1526
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v27, v0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v25 .. v30}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1530
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1531
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/util/ArrayList;

    .line 1532
    .restart local v24    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    if-eqz v24, :cond_1

    invoke-virtual/range {v24 .. v24}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_1

    .line 1533
    const/16 v38, 0x7

    invoke-static/range {v34 .. v35}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v39

    const/16 v40, 0x0

    const/16 v41, 0x0

    const/16 v42, 0x0

    move-object/from16 v36, v12

    move-object/from16 v37, v24

    invoke-virtual/range {v36 .. v42}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 1535
    const-string v6, "count"

    invoke-virtual/range {v24 .. v24}, Ljava/util/ArrayList;->size()I

    move-result v13

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1536
    const-string v6, "users"

    move-object/from16 v0, p2

    move-object/from16 v1, v24

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 1543
    .end local v24    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v111    # "addressBook":Ljava/lang/String;
    :sswitch_1d
    const/16 v111, 0x0

    .line 1545
    .restart local v111    # "addressBook":Ljava/lang/String;
    :try_start_a
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/util/Util;->getAddressBookJson(Landroid/content/ContentResolver;)Ljava/lang/String;
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_6

    move-result-object v111

    .line 1550
    :goto_1a
    if-nez v111, :cond_43

    if-eqz v202, :cond_43

    .line 1551
    const/16 v6, 0x3e8

    move-object/from16 v0, v202

    iput v6, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    .line 1552
    new-instance v148, Lco/vine/android/api/VineError;

    .end local v148    # "error":Lco/vine/android/api/VineError;
    const/16 v6, 0x3e8

    const-string v13, "Could not create json."

    move-object/from16 v0, v148

    invoke-direct {v0, v6, v13}, Lco/vine/android/api/VineError;-><init>(ILjava/lang/String;)V

    .line 1553
    .restart local v148    # "error":Lco/vine/android/api/VineError;
    goto/16 :goto_0

    .line 1546
    :catch_6
    move-exception v139

    .line 1547
    .restart local v139    # "e":Ljava/io/IOException;
    invoke-virtual/range {v139 .. v139}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1a

    .line 1556
    .end local v139    # "e":Ljava/io/IOException;
    :cond_43
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x5

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "following"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "suggested"

    aput-object v17, v13, v16

    const/16 v16, 0x4

    const-string v17, "contacts"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1563
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1565
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 1566
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "addressBook"

    move-object/from16 v0, v111

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1567
    invoke-static {}, Lco/vine/android/util/Util;->getLocale()Ljava/lang/String;

    move-result-object v170

    .line 1568
    .local v170, "language":Ljava/lang/String;
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "locale"

    move-object/from16 v0, v170

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1570
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v27, v0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v25 .. v30}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1573
    goto/16 :goto_0

    .line 1576
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v111    # "addressBook":Ljava/lang/String;
    .end local v170    # "language":Ljava/lang/String;
    :sswitch_1e
    const-string v6, "type"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v12, v6}, Lco/vine/android/provider/VineDatabaseHelper;->removeUsersByGroup(I)V

    goto/16 :goto_0

    .line 1580
    :sswitch_1f
    const-string v6, "follow_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v45

    .line 1581
    .local v45, "userIdToFollow":J
    const-string v6, "notify"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v51

    .line 1582
    .local v51, "notify":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v45 .. v46}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "followers"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1585
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1587
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v36

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v38, v0

    const/16 v39, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v41, v0

    move-object/from16 v37, v26

    move-object/from16 v40, v29

    invoke-static/range {v36 .. v41}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1591
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1592
    const/4 v6, 0x1

    move-wide/from16 v0, v45

    invoke-virtual {v12, v0, v1, v6}, Lco/vine/android/provider/VineDatabaseHelper;->updateUserFollowingFlag(JZ)V

    .line 1593
    const-wide/16 v49, 0x0

    move-object/from16 v44, v12

    move-wide/from16 v47, v34

    invoke-virtual/range {v44 .. v51}, Lco/vine/android/provider/VineDatabaseHelper;->addFollow(JJJZ)I

    .line 1594
    const/4 v6, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    const-string v16, "order_id ASC"

    move-object/from16 v0, v16

    invoke-virtual {v12, v6, v13, v0}, Lco/vine/android/provider/VineDatabaseHelper;->markLastUser(ILjava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1601
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v45    # "userIdToFollow":J
    .end local v51    # "notify":Z
    :sswitch_20
    const-string v6, "follow_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    move-wide/16 v270, v0

    .line 1602
    .local v270, "userToUnfollow":J
    const-string v6, "profile_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v133

    .line 1603
    .local v133, "currentProfileId":J
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v108

    .line 1604
    .local v108, "activeUserId":J
    const-string v6, "notify"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v51

    .line 1605
    .restart local v51    # "notify":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v270 .. v271}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "followers"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1608
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1610
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1614
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1615
    cmp-long v6, v133, v108

    if-nez v6, :cond_44

    const/16 v138, 0x1

    .line 1616
    .local v138, "deleteRow":Z
    :goto_1b
    const/4 v6, 0x0

    move-wide/from16 v0, v270

    invoke-virtual {v12, v0, v1, v6}, Lco/vine/android/provider/VineDatabaseHelper;->updateUserFollowingFlag(JZ)V

    .line 1617
    move-wide/from16 v0, v270

    move/from16 v2, v138

    move/from16 v3, v51

    invoke-virtual {v12, v0, v1, v2, v3}, Lco/vine/android/provider/VineDatabaseHelper;->removeFollow(JZZ)I

    .line 1618
    const/4 v6, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    const-string v16, "order_id ASC"

    move-object/from16 v0, v16

    invoke-virtual {v12, v6, v13, v0}, Lco/vine/android/provider/VineDatabaseHelper;->markLastUser(ILjava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1615
    .end local v138    # "deleteRow":Z
    :cond_44
    const/16 v138, 0x0

    goto :goto_1b

    .line 1625
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v51    # "notify":Z
    .end local v108    # "activeUserId":J
    .end local v133    # "currentProfileId":J
    .end local v270    # "userToUnfollow":J
    :sswitch_21
    const-string v6, "follow_ids"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    move-object/16 v263, v0

    .line 1626
    .local v263, "userIdsToFollow":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "followers"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1628
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 1629
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    invoke-virtual/range {v263 .. v263}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_1c
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_45

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 1630
    .local v10, "userId":Ljava/lang/String;
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "userIds[]"

    invoke-direct {v6, v13, v10}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1c

    .line 1633
    .end local v10    # "userId":Ljava/lang/String;
    :cond_45
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1634
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v27, v0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v25 .. v30}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1638
    goto/16 :goto_0

    .line 1641
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v263    # "userIdsToFollow":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :sswitch_22
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 1642
    .restart local v14    # "postId":J
    const-string v6, "notify"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v51

    .line 1643
    .restart local v51    # "notify":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "likes"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1645
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0xa

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1646
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v36

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v38, v0

    const/16 v39, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v41, v0

    move-object/from16 v37, v26

    move-object/from16 v40, v29

    invoke-static/range {v36 .. v41}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1649
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1650
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v176

    check-cast v176, Ljava/lang/Long;

    .line 1652
    .local v176, "likeId":Ljava/lang/Long;
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v182

    .line 1653
    .local v182, "meUserId":J
    const-string v6, "username"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 1655
    .restart local v7    # "username":Ljava/lang/String;
    new-instance v175, Lco/vine/android/api/VineLike;

    invoke-direct/range {v175 .. v175}, Lco/vine/android/api/VineLike;-><init>()V

    .line 1656
    .restart local v175    # "like":Lco/vine/android/api/VineLike;
    invoke-virtual/range {v176 .. v176}, Ljava/lang/Long;->longValue()J

    move-result-wide v16

    move-wide/from16 v0, v16

    move-object/from16 v2, v175

    iput-wide v0, v2, Lco/vine/android/api/VineLike;->likeId:J

    .line 1657
    move-wide/from16 v0, v182

    move-object/from16 v2, v175

    iput-wide v0, v2, Lco/vine/android/api/VineLike;->userId:J

    .line 1658
    move-object/from16 v0, v175

    iput-object v7, v0, Lco/vine/android/api/VineLike;->username:Ljava/lang/String;

    .line 1659
    move-object/from16 v0, v175

    iput-wide v14, v0, Lco/vine/android/api/VineLike;->postId:J

    .line 1661
    move-object/from16 v0, v175

    move/from16 v1, v51

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->addLike(Lco/vine/android/api/VineLike;Z)I

    goto/16 :goto_0

    .line 1666
    .end local v7    # "username":Ljava/lang/String;
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v51    # "notify":Z
    .end local v175    # "like":Lco/vine/android/api/VineLike;
    .end local v176    # "likeId":Ljava/lang/Long;
    .end local v182    # "meUserId":J
    :sswitch_23
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 1667
    .restart local v14    # "postId":J
    const-string v6, "notify"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v51

    .line 1668
    .restart local v51    # "notify":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "likes"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1670
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0xa

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1671
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1674
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    move-object/from16 v36, v12

    move-wide/from16 v37, v14

    move-wide/from16 v39, v34

    move/from16 v41, v51

    .line 1675
    invoke-virtual/range {v36 .. v41}, Lco/vine/android/provider/VineDatabaseHelper;->removeLike(JJZ)I

    goto/16 :goto_0

    .line 1680
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v51    # "notify":Z
    :sswitch_24
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 1681
    .restart local v14    # "postId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "repost"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1683
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0x13

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1684
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v36

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v38, v0

    const/16 v39, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v41, v0

    move-object/from16 v37, v26

    move-object/from16 v40, v29

    invoke-static/range {v36 .. v41}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1687
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1688
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v228

    check-cast v228, Lco/vine/android/api/VineRepost;

    .line 1689
    .local v228, "repost":Lco/vine/android/api/VineRepost;
    const-string v6, "username"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 1691
    .restart local v7    # "username":Ljava/lang/String;
    move-wide/from16 v0, v34

    move-object/from16 v2, v228

    iput-wide v0, v2, Lco/vine/android/api/VineRepost;->userId:J

    .line 1692
    move-object/from16 v0, v228

    iput-object v7, v0, Lco/vine/android/api/VineRepost;->username:Ljava/lang/String;

    .line 1694
    const-string v6, "repost"

    move-object/from16 v0, p2

    move-object/from16 v1, v228

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 1696
    const/4 v6, 0x0

    move-object/from16 v0, v228

    move-wide/from16 v1, v34

    invoke-virtual {v12, v0, v1, v2, v6}, Lco/vine/android/provider/VineDatabaseHelper;->revine(Lco/vine/android/api/VineRepost;JZ)I

    goto/16 :goto_0

    .line 1701
    .end local v7    # "username":Ljava/lang/String;
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v228    # "repost":Lco/vine/android/api/VineRepost;
    :sswitch_25
    const-string v6, "following"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v41

    .line 1702
    .local v41, "following":Z
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 1703
    .restart local v14    # "postId":J
    const-string v6, "repost_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v229

    .line 1704
    .local v229, "repostId":J
    const-string v6, "notify"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v51

    .line 1705
    .restart local v51    # "notify":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "repost"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    invoke-static/range {v229 .. v230}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1707
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1709
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1712
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    move-object/from16 v36, v12

    move-wide/from16 v37, v14

    move-wide/from16 v39, v34

    move/from16 v42, v51

    .line 1713
    invoke-virtual/range {v36 .. v42}, Lco/vine/android/provider/VineDatabaseHelper;->unRevine(JJZZ)I

    goto/16 :goto_0

    .line 1718
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v41    # "following":Z
    .end local v51    # "notify":Z
    .end local v229    # "repostId":J
    :sswitch_26
    const-string v6, "post_id"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v14

    .line 1719
    .restart local v14    # "postId":J
    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v204

    .line 1720
    .restart local v204    # "page":I
    const-string v6, "time"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v60

    .line 1722
    .local v60, "anchor":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "reposts"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1725
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1726
    const-wide/16 v16, 0x0

    cmp-long v6, v60, v16

    if-lez v6, :cond_46

    .line 1727
    const-string v6, "anchor"

    move-object/from16 v0, v26

    move-wide/from16 v1, v60

    invoke-static {v0, v6, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    .line 1729
    :cond_46
    const-string v6, "size"

    const/16 v13, 0x14

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1731
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1732
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1736
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1737
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v273, v0

    move-object/from16 v0, v273

    check-cast v0, Lco/vine/android/api/VinePagedData;

    move-object/16 v273, v0

    .line 1738
    .restart local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v273

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v54, v0

    const/16 v55, 0x9

    invoke-static {v14, v15}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v56

    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move/from16 v57, v0

    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move/from16 v58, v0

    const/16 v59, 0x0

    move-object/from16 v53, v12

    invoke-virtual/range {v53 .. v59}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 1740
    const-string v6, "count"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->count:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1741
    const-string v6, "next_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1742
    const-string v6, "previous_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1743
    const-string v6, "time"

    move-object/from16 v0, v273

    iget-wide v0, v0, Lco/vine/android/api/VinePagedData;->anchor:J

    move-wide/from16 v16, v0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1744
    const-string v6, "users"

    move-object/from16 v0, v273

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1746
    move-object/from16 v0, v273

    iget v6, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    if-gtz v6, :cond_1

    .line 1747
    const/16 v6, 0x9

    invoke-static {v14, v15}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v6, v13}, Lco/vine/android/provider/VineDatabaseHelper;->markLastUser(ILjava/lang/String;)V

    goto/16 :goto_0

    .line 1754
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v60    # "anchor":J
    .end local v204    # "page":I
    .end local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    :sswitch_27
    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v204

    .line 1755
    .restart local v204    # "page":I
    const-string v6, "time"

    const-wide/16 v16, 0x0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v60

    .line 1756
    .restart local v60    # "anchor":J
    const-string v6, "follow_reqs"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v158

    .line 1758
    .local v158, "getFollowRequests":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "notifications"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "grouped"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1761
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v13, "clear"

    const-string v6, "clear"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_49

    const/4 v6, 0x1

    :goto_1d
    move-object/from16 v0, v26

    invoke-static {v0, v13, v6}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1762
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1763
    const-wide/16 v16, 0x0

    cmp-long v6, v60, v16

    if-lez v6, :cond_47

    .line 1764
    const-string v6, "anchor"

    move-object/from16 v0, v26

    move-wide/from16 v1, v60

    invoke-static {v0, v6, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    .line 1766
    :cond_47
    const-string v6, "size"

    const/16 v13, 0x14

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1768
    const/16 v6, 0x1c

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1770
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1773
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_48

    .line 1774
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v238

    check-cast v238, Lco/vine/android/api/VinePagedData;

    .line 1775
    .local v238, "results":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineEverydayNotification;>;"
    const-string v6, "notifications"

    move-object/from16 v0, p2

    move-object/from16 v1, v238

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1778
    .end local v238    # "results":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineEverydayNotification;>;"
    :cond_48
    if-eqz v158, :cond_1

    .line 1779
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "notifications"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "followRequests"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v154

    .line 1783
    .local v154, "followUrl":Ljava/lang/StringBuilder;
    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, v154

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1784
    const-string v6, "size"

    const/16 v13, 0x14

    move-object/from16 v0, v154

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1786
    const/16 v6, 0x9

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v155

    .line 1789
    .local v155, "followVp":Lco/vine/android/api/VineParserReader;
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v154

    move-object/from16 v1, v155

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v153

    .line 1793
    .local v153, "followOp":Lco/vine/android/network/HttpOperation;
    invoke-virtual/range {v153 .. v153}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1794
    invoke-virtual/range {v155 .. v155}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v152

    check-cast v152, Lco/vine/android/api/VinePagedData;

    .line 1796
    .local v152, "followNotifs":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineSingleNotification;>;"
    const-string v6, "follow_requests"

    move-object/from16 v0, p2

    move-object/from16 v1, v152

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 1761
    .end local v152    # "followNotifs":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineSingleNotification;>;"
    .end local v153    # "followOp":Lco/vine/android/network/HttpOperation;
    .end local v154    # "followUrl":Ljava/lang/StringBuilder;
    .end local v155    # "followVp":Lco/vine/android/api/VineParserReader;
    :cond_49
    const/4 v6, 0x0

    goto/16 :goto_1d

    .line 1802
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v60    # "anchor":J
    .end local v158    # "getFollowRequests":Z
    .end local v204    # "page":I
    :sswitch_28
    const-string v6, "s_owner_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 1803
    .local v10, "userId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "activityCounts"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1805
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "grouped"

    const/4 v13, 0x1

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 1807
    const/16 v6, 0x1a

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1808
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1812
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1813
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v110

    check-cast v110, Lco/vine/android/api/VineActivityCounts;

    .line 1814
    .local v110, "activityCounts":Lco/vine/android/api/VineActivityCounts;
    const-string v6, "messages_count"

    move-object/from16 v0, v110

    iget v13, v0, Lco/vine/android/api/VineActivityCounts;->messages:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1815
    const-string v6, "notifications_count"

    move-object/from16 v0, v110

    iget v13, v0, Lco/vine/android/api/VineActivityCounts;->notifications:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1816
    new-instance v132, Landroid/content/Intent;

    invoke-direct/range {v132 .. v132}, Landroid/content/Intent;-><init>()V

    .line 1817
    .local v132, "countIntent":Landroid/content/Intent;
    const-string v6, "messages_count"

    move-object/from16 v0, v110

    iget v13, v0, Lco/vine/android/api/VineActivityCounts;->messages:I

    move-object/from16 v0, v132

    invoke-virtual {v0, v6, v13}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1818
    const-string v6, "notifications_count"

    move-object/from16 v0, v110

    iget v13, v0, Lco/vine/android/api/VineActivityCounts;->notifications:I

    move-object/from16 v0, v132

    invoke-virtual {v0, v6, v13}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1819
    const-string v6, "co.vine.android.service.activityCounts"

    move-object/from16 v0, v132

    invoke-virtual {v0, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1820
    const-string v6, "co.vine.android.BROADCAST"

    move-object/from16 v0, p0

    move-object/from16 v1, v132

    invoke-virtual {v0, v1, v6}, Lco/vine/android/service/VineService;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 1822
    move-object/from16 v0, v110

    iget v6, v0, Lco/vine/android/api/VineActivityCounts;->messages:I

    move-object/from16 v0, v110

    iget v13, v0, Lco/vine/android/api/VineActivityCounts;->notifications:I

    add-int/2addr v6, v13

    move-object/from16 v0, p0

    invoke-direct {v0, v6}, Lco/vine/android/service/VineService;->updateBadgeCount(I)V

    goto/16 :goto_0

    .line 1828
    .end local v10    # "userId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v110    # "activityCounts":Lco/vine/android/api/VineActivityCounts;
    .end local v132    # "countIntent":Landroid/content/Intent;
    :sswitch_29
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 1829
    .restart local v10    # "userId":J
    cmp-long v6, v10, v34

    if-eqz v6, :cond_4a

    const/4 v6, 0x1

    :goto_1e
    invoke-static {v6}, Lco/vine/android/util/FlurryUtils;->trackGetUser(Z)V

    .line 1830
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "profiles"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1833
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x2

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1834
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1837
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1838
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v261, v0

    move-object/from16 v0, v261

    check-cast v0, Lco/vine/android/api/VineUser;

    move-object/16 v261, v0

    .line 1839
    .restart local v261    # "user":Lco/vine/android/api/VineUser;
    const-string v6, "user"

    move-object/from16 v0, p2

    move-object/from16 v1, v261

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 1829
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v261    # "user":Lco/vine/android/api/VineUser;
    :cond_4a
    const/4 v6, 0x0

    goto :goto_1e

    .line 1844
    .end local v10    # "userId":J
    :sswitch_2a
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x1

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 1846
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "edition"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1848
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "edition"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v141

    .line 1849
    .local v141, "edition":Ljava/lang/String;
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "edition"

    move-object/from16 v0, v141

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1850
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1851
    invoke-static/range {p0 .. p0}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1854
    goto/16 :goto_0

    .line 1857
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v141    # "edition":Ljava/lang/String;
    :sswitch_2b
    const-string v6, "uri"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v116

    check-cast v116, Landroid/net/Uri;

    .line 1858
    .restart local v116    # "avatarUri":Landroid/net/Uri;
    const/16 v150, 0x0

    .line 1859
    .restart local v150    # "f":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mAmazonBucket:Ljava/lang/String;

    if-eqz v6, :cond_50

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mAmazonBucket:Ljava/lang/String;

    move-object/from16 v212, v0

    .line 1860
    .restart local v212    # "pictureBucket":Ljava/lang/String;
    :goto_1f
    if-eqz v116, :cond_4b

    .line 1862
    :try_start_b
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mMediaUtility:Lco/vine/android/util/MediaUtility;

    move-object/from16 v0, v116

    move-object/from16 v1, v212

    move-object/from16 v2, v127

    invoke-virtual {v6, v0, v1, v2}, Lco/vine/android/util/MediaUtility;->getPhotoUri(Landroid/net/Uri;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_7

    move-result-object v150

    .line 1870
    :cond_4b
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1873
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    if-nez v116, :cond_51

    const/4 v6, 0x5

    :goto_20
    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 1876
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "username"

    const-string v16, "a_name"

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1877
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "description"

    const-string v16, "desc"

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1879
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "location"

    const-string v16, "location"

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1882
    if-eqz v116, :cond_52

    invoke-virtual/range {v116 .. v116}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_52

    .line 1883
    const-string v151, ""

    .line 1900
    .restart local v151    # "finalAvatarUrl":Ljava/lang/String;
    :goto_21
    if-eqz v116, :cond_4c

    .line 1901
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "avatarUrl"

    move-object/from16 v0, v151

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1904
    :cond_4c
    const-string v6, "email"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v143

    .line 1905
    .restart local v143    # "email":Ljava/lang/String;
    invoke-static/range {v143 .. v143}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_4d

    .line 1906
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "email"

    move-object/from16 v0, v143

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1909
    :cond_4d
    const-string v6, "phone"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v211

    .line 1910
    .restart local v211    # "phone":Ljava/lang/String;
    invoke-static/range {v211 .. v211}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_4e

    .line 1911
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "phoneNumber"

    const-string v16, "phone"

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1914
    :cond_4e
    const-string v6, "color_int"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4f

    .line 1915
    const-string v6, "color_int"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v126

    .line 1916
    .local v126, "color":I
    if-lez v126, :cond_4f

    .line 1917
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "profileBackground"

    const-string v16, "color_int"

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v16

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1921
    .end local v126    # "color":I
    :cond_4f
    const/4 v6, 0x2

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1922
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1925
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1926
    if-nez v116, :cond_53

    .line 1927
    const-string v6, "avatar_url"

    const-string v13, ""

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1859
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v143    # "email":Ljava/lang/String;
    .end local v151    # "finalAvatarUrl":Ljava/lang/String;
    .end local v211    # "phone":Ljava/lang/String;
    .end local v212    # "pictureBucket":Ljava/lang/String;
    :cond_50
    invoke-static/range {v127 .. v127}, Lco/vine/android/client/Amazon;->getBucket(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v212

    goto/16 :goto_1f

    .line 1863
    .restart local v212    # "pictureBucket":Ljava/lang/String;
    :catch_7
    move-exception v139

    .line 1864
    .local v139, "e":Ljava/lang/Exception;
    const/16 v245, 0x384

    .line 1865
    invoke-virtual/range {v139 .. v139}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v221

    .line 1866
    goto/16 :goto_0

    .line 1873
    .end local v139    # "e":Ljava/lang/Exception;
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    :cond_51
    const/4 v6, 0x6

    goto/16 :goto_20

    .line 1885
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    :cond_52
    invoke-static/range {v127 .. v127}, Lco/vine/android/util/MediaUtility;->getUploadType(Landroid/content/Context;)I

    move-result v186

    .line 1886
    .restart local v186    # "mode":I
    packed-switch v186, :pswitch_data_3

    .line 1894
    move-object/from16 v151, v150

    .restart local v151    # "finalAvatarUrl":Ljava/lang/String;
    goto/16 :goto_21

    .line 1888
    .end local v151    # "finalAvatarUrl":Ljava/lang/String;
    :pswitch_6
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v13}, Lco/vine/android/client/VineAPI;->getAmazonUrl()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v13, "/"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v212

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v13, "/"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v150

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v151

    .line 1890
    .restart local v151    # "finalAvatarUrl":Ljava/lang/String;
    goto/16 :goto_21

    .line 1929
    .end local v186    # "mode":I
    .restart local v143    # "email":Ljava/lang/String;
    .restart local v211    # "phone":Ljava/lang/String;
    :cond_53
    const-string v6, "avatar_url"

    move-object/from16 v0, p2

    move-object/from16 v1, v151

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1935
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v116    # "avatarUri":Landroid/net/Uri;
    .end local v143    # "email":Ljava/lang/String;
    .end local v150    # "f":Ljava/lang/String;
    .end local v151    # "finalAvatarUrl":Ljava/lang/String;
    .end local v211    # "phone":Ljava/lang/String;
    .end local v212    # "pictureBucket":Ljava/lang/String;
    :sswitch_2c
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackReportPost()V

    .line 1936
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 1937
    .restart local v14    # "postId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "complaints"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1939
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1941
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v53

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v55, v0

    const/16 v56, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v58, v0

    move-object/from16 v54, v26

    move-object/from16 v57, v29

    invoke-static/range {v53 .. v58}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1944
    goto/16 :goto_0

    .line 1947
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    :sswitch_2d
    const-string v6, "time"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v16

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->cleanUp(J)I

    goto/16 :goto_0

    .line 1951
    :sswitch_2e
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 1952
    .restart local v14    # "postId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1954
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1955
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1958
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1959
    invoke-virtual {v12, v14, v15}, Lco/vine/android/provider/VineDatabaseHelper;->deletePost(J)I

    goto/16 :goto_0

    .line 1964
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    :sswitch_2f
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackConnectTwitter()V

    .line 1965
    const-string v6, "key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v249

    .line 1966
    .local v249, "token":Ljava/lang/String;
    const-string v6, "secret"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v240

    .line 1967
    .restart local v240    # "secret":Ljava/lang/String;
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 1968
    .restart local v10    # "userId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1970
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x3

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 1971
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthToken"

    move-object/from16 v0, v249

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1972
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthSecret"

    move-object/from16 v0, v240

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1973
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterId"

    invoke-static {v10, v11}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1974
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1976
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1978
    goto/16 :goto_0

    .line 1981
    .end local v10    # "userId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v240    # "secret":Ljava/lang/String;
    .end local v249    # "token":Ljava/lang/String;
    :sswitch_30
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackDisConnectTwitter()V

    .line 1982
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 1984
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x3

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 1985
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthToken"

    const-string v16, ""

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1986
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterOauthSecret"

    const-string v16, ""

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1987
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "twitterId"

    const-string v16, ""

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1988
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 1989
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 1991
    goto/16 :goto_0

    .line 1994
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    :sswitch_31
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 1995
    .restart local v10    # "userId":J
    const/4 v6, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v10, v11, v6, v13}, Lco/vine/android/provider/VineDatabaseHelper;->removePostsFromGroupByUser(JILjava/lang/String;)I

    goto/16 :goto_0

    .line 2000
    .end local v10    # "userId":J
    :sswitch_32
    invoke-direct/range {p0 .. p0}, Lco/vine/android/service/VineService;->getClientProfile()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2001
    goto/16 :goto_0

    .line 2004
    :sswitch_33
    const-string v6, "post_share_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v214

    .line 2005
    .local v214, "postShareId":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "timelines"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "s"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    aput-object v214, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2008
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0x8

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2009
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2013
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2014
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v236

    check-cast v236, Lco/vine/android/api/VinePagedData;

    .line 2015
    .restart local v236    # "response":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    move-object/from16 v0, v236

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v168, v0

    .line 2016
    .local v168, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    invoke-virtual/range {v168 .. v168}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_1

    .line 2017
    const-string v13, "post_id"

    const/4 v6, 0x0

    move-object/from16 v0, v168

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/api/VinePost;

    iget-wide v0, v6, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v13, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto/16 :goto_0

    .line 2023
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v168    # "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    .end local v214    # "postShareId":Ljava/lang/String;
    .end local v236    # "response":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    :sswitch_34
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackConnectFacebook()V

    .line 2024
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2027
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x3

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 2028
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "facebookOauthToken"

    const-string v16, "facebook_token"

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2031
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2032
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2036
    const-string v13, "Send facebook token result {}."

    if-eqz v202, :cond_54

    move-object/from16 v0, v202

    iget v6, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    :goto_22
    invoke-static {v13, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 2038
    if-eqz v202, :cond_1

    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2039
    const/4 v6, 0x0

    move-object/from16 v0, p0

    invoke-static {v0, v6}, Lco/vine/android/client/AppController;->setPendingFacebookToken(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_54
    move-object/from16 v6, v202

    .line 2036
    goto :goto_22

    .line 2044
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    :sswitch_35
    new-instance v26, Ljava/lang/StringBuilder;

    invoke-static/range {v127 .. v127}, Lco/vine/android/util/BuildUtil;->getStatusUrl(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v26

    invoke-direct {v0, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2045
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0xf

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2046
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v1, v13}, Lco/vine/android/network/HttpOperation;->createGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2048
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2049
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v244

    check-cast v244, Lco/vine/android/api/ServerStatus;

    .line 2050
    .local v244, "ss":Lco/vine/android/api/ServerStatus;
    const-string v6, "server_status"

    move-object/from16 v0, p2

    move-object/from16 v1, v244

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 2055
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v244    # "ss":Lco/vine/android/api/ServerStatus;
    :sswitch_36
    const-string v6, "q"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v219

    .line 2056
    .local v219, "query":Ljava/lang/String;
    const-string v6, "page_type"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v57

    .line 2057
    .restart local v57    # "pageType":I
    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v204

    .line 2059
    .restart local v204    # "page":I
    packed-switch v57, :pswitch_data_4

    .line 2085
    :cond_55
    :goto_23
    invoke-static/range {v219 .. v219}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 2087
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackSearchUsers()V

    .line 2089
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "search"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    aput-object v219, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2091
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 2092
    const-string v6, "size"

    const/16 v13, 0x32

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 2094
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2095
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    move-object/from16 v2, v43

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2099
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2100
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v273, v0

    move-object/from16 v0, v273

    check-cast v0, Lco/vine/android/api/VinePagedData;

    move-object/16 v273, v0

    .line 2101
    .restart local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_56

    .line 2102
    move-object/from16 v0, v273

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v54, v0

    const/16 v55, 0x8

    const/16 v56, 0x0

    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move/from16 v57, v0

    .end local v57    # "pageType":I
    move-object/from16 v0, v273

    iget v0, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move/from16 v58, v0

    const/16 v59, 0x0

    move-object/from16 v53, v12

    invoke-virtual/range {v53 .. v59}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 2104
    const-string v6, "count"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->count:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2105
    const-string v6, "next_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2106
    const-string v6, "previous_page"

    move-object/from16 v0, v273

    iget v13, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2108
    :cond_56
    move-object/from16 v0, v273

    iget v6, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    if-gtz v6, :cond_1

    .line 2109
    const/16 v6, 0x8

    const/4 v13, 0x0

    const-string v16, "_id DESC"

    move-object/from16 v0, v16

    invoke-virtual {v12, v6, v13, v0}, Lco/vine/android/provider/VineDatabaseHelper;->markLastUser(ILjava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 2061
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    .restart local v57    # "pageType":I
    :pswitch_7
    const/16 v204, 0x1

    .line 2062
    goto/16 :goto_23

    .line 2065
    :pswitch_8
    const/4 v6, 0x1

    const/16 v13, 0x8

    const/16 v16, 0x0

    const/16 v17, 0x1

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v12, v6, v13, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getNextPageCursor(IILjava/lang/String;Z)I

    move-result v193

    .line 2067
    .local v193, "nextPage":I
    if-lez v193, :cond_55

    .line 2068
    move/from16 v204, v193

    goto/16 :goto_23

    .line 2073
    .end local v193    # "nextPage":I
    :pswitch_9
    const/4 v6, 0x1

    const/16 v13, 0x8

    const/16 v16, 0x0

    const/16 v17, 0x1

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v12, v6, v13, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getPreviousPageCursor(IILjava/lang/String;Z)I

    move-result v59

    .line 2075
    .local v59, "previous":I
    if-lez v59, :cond_55

    .line 2076
    move/from16 v204, v59

    goto/16 :goto_23

    .line 2116
    .end local v57    # "pageType":I
    .end local v59    # "previous":I
    .end local v204    # "page":I
    .end local v219    # "query":Ljava/lang/String;
    :sswitch_37
    const-string v6, "posts"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v54

    .line 2117
    .local v54, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    const-string v6, "type"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v55

    .line 2118
    .local v55, "groupType":I
    const-string v6, "tag_name"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v56

    .line 2119
    .local v56, "tag":Ljava/lang/String;
    const-string v6, "page_type"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v57

    .line 2120
    .restart local v57    # "pageType":I
    const-string v6, "next_page"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v58

    .line 2121
    .local v58, "next":I
    const-string v6, "previous_page"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v59

    .line 2122
    .restart local v59    # "previous":I
    const-string v6, "time"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v60

    .line 2123
    .restart local v60    # "anchor":J
    const-string v6, "user_init"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v62

    .line 2124
    .local v62, "userInitiated":Z
    if-eqz v54, :cond_1

    move-object/from16 v53, v12

    .line 2126
    :try_start_c
    invoke-virtual/range {v53 .. v62}, Lco/vine/android/provider/VineDatabaseHelper;->mergePosts(Ljava/util/Collection;ILjava/lang/String;IIIJZ)Lco/vine/android/provider/DbResponse;

    .line 2128
    if-gtz v58, :cond_1

    .line 2129
    move/from16 v0, v55

    move-object/from16 v1, v56

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->markLastPost(ILjava/lang/String;)V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_8

    goto/16 :goto_0

    .line 2131
    :catch_8
    move-exception v139

    .line 2132
    .local v139, "e":Ljava/io/IOException;
    invoke-virtual/range {v139 .. v139}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_0

    .line 2138
    .end local v54    # "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    .end local v55    # "groupType":I
    .end local v56    # "tag":Ljava/lang/String;
    .end local v57    # "pageType":I
    .end local v58    # "next":I
    .end local v59    # "previous":I
    .end local v60    # "anchor":J
    .end local v62    # "userInitiated":Z
    .end local v139    # "e":Ljava/io/IOException;
    :sswitch_38
    const-string v6, "q"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v219

    .line 2139
    .restart local v219    # "query":Ljava/lang/String;
    const-string v6, "page_type"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v57

    .line 2140
    .restart local v57    # "pageType":I
    const-string v6, "page"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v204

    .line 2142
    .restart local v204    # "page":I
    packed-switch v57, :pswitch_data_5

    .line 2166
    :cond_57
    :goto_24
    invoke-static/range {v219 .. v219}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 2168
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackSearchTags()V

    .line 2170
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "tags"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "search"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    aput-object v219, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2172
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 2173
    const-string v6, "size"

    const/16 v13, 0x32

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 2175
    const/16 v6, 0xe

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2176
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    move-object/from16 v2, v43

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2180
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2181
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v248

    check-cast v248, Lco/vine/android/api/VinePagedData;

    .line 2182
    .local v248, "tags":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineTag;>;"
    move-object/from16 v0, v248

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_58

    .line 2183
    move-object/from16 v0, v248

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, v248

    iget v13, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, v248

    iget v0, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move/from16 v16, v0

    move/from16 v0, v16

    invoke-virtual {v12, v6, v13, v0}, Lco/vine/android/provider/VineDatabaseHelper;->mergeSearchedTags(Ljava/util/Collection;II)I

    .line 2184
    const-string v6, "count"

    move-object/from16 v0, v248

    iget v13, v0, Lco/vine/android/api/VinePagedData;->count:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2185
    const-string v6, "next_page"

    move-object/from16 v0, v248

    iget v13, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2186
    const-string v6, "previous_page"

    move-object/from16 v0, v248

    iget v13, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2188
    :cond_58
    move-object/from16 v0, v248

    iget v6, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    if-gtz v6, :cond_1

    .line 2189
    invoke-virtual {v12}, Lco/vine/android/provider/VineDatabaseHelper;->markLastTag()V

    goto/16 :goto_0

    .line 2144
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v248    # "tags":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineTag;>;"
    :pswitch_a
    const/16 v204, 0x1

    .line 2145
    goto/16 :goto_24

    .line 2148
    :pswitch_b
    const/4 v6, 0x4

    const/4 v13, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x1

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v12, v6, v13, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getNextPageCursor(IILjava/lang/String;Z)I

    move-result v193

    .line 2149
    .restart local v193    # "nextPage":I
    if-lez v193, :cond_57

    .line 2150
    move/from16 v204, v193

    goto/16 :goto_24

    .line 2155
    .end local v193    # "nextPage":I
    :pswitch_c
    const/4 v6, 0x4

    const/4 v13, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x1

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v12, v6, v13, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getPreviousPageCursor(IILjava/lang/String;Z)I

    move-result v59

    .line 2156
    .restart local v59    # "previous":I
    if-lez v59, :cond_57

    .line 2157
    move/from16 v204, v59

    goto/16 :goto_24

    .line 2195
    .end local v57    # "pageType":I
    .end local v59    # "previous":I
    .end local v204    # "page":I
    .end local v219    # "query":Ljava/lang/String;
    :sswitch_39
    const-string v6, "notify"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v51

    .line 2196
    .restart local v51    # "notify":Z
    move/from16 v0, v51

    invoke-virtual {v12, v0}, Lco/vine/android/provider/VineDatabaseHelper;->clearCachedData(Z)V

    .line 2197
    const/16 v245, 0xc8

    .line 2198
    goto/16 :goto_0

    .line 2201
    .end local v51    # "notify":Z
    :sswitch_3a
    invoke-virtual {v12}, Lco/vine/android/provider/VineDatabaseHelper;->clearAllData()V

    .line 2202
    const/16 v245, 0xc8

    .line 2203
    goto/16 :goto_0

    .line 2206
    :sswitch_3b
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 2207
    .restart local v10    # "userId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "blocked"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2210
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0x11

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2211
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    move-object/from16 v2, v43

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2215
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2216
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v117

    check-cast v117, Ljava/util/ArrayList;

    .line 2217
    .local v117, "blockedUsers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    const-string v6, "blocked_users"

    move-object/from16 v0, p2

    move-object/from16 v1, v117

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 2223
    .end local v10    # "userId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v117    # "blockedUsers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    :sswitch_3c
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackBlockUser()V

    .line 2224
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v135

    .line 2225
    .local v135, "currentUserId":J
    const-string v6, "block_user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    move-wide/16 v264, v0

    .line 2226
    .local v264, "userToBlock":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v135 .. v136}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "blocked"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    invoke-static/range {v264 .. v265}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2229
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2230
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v63

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v65, v0

    const/16 v66, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v68, v0

    move-object/from16 v64, v26

    move-object/from16 v67, v29

    invoke-static/range {v63 .. v68}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2234
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2235
    sget-object v6, Lco/vine/android/api/VineParsers$API_RESPONSE;->SUCCESS:Lco/vine/android/api/VineParsers$API_RESPONSE;

    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v13

    invoke-virtual {v6, v13}, Lco/vine/android/api/VineParsers$API_RESPONSE;->equals(Ljava/lang/Object;)Z

    move-result v0

    move/16 v262, v0

    .line 2236
    .local v262, "userBlocked":Z
    const-string v6, "response_success"

    move-object/from16 v0, p2

    move/from16 v1, v262

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 2241
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v135    # "currentUserId":J
    .end local v262    # "userBlocked":Z
    .end local v264    # "userToBlock":J
    :sswitch_3d
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackUnBlockUser()V

    .line 2242
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v135

    .line 2243
    .restart local v135    # "currentUserId":J
    const-string v6, "block_user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    move-wide/16 v268, v0

    .line 2244
    .local v268, "userToUnblock":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v135 .. v136}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "blocked"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    invoke-static/range {v268 .. v269}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2247
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2248
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2252
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2253
    sget-object v6, Lco/vine/android/api/VineParsers$API_RESPONSE;->SUCCESS:Lco/vine/android/api/VineParsers$API_RESPONSE;

    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v13

    invoke-virtual {v6, v13}, Lco/vine/android/api/VineParsers$API_RESPONSE;->equals(Ljava/lang/Object;)Z

    move-result v0

    move/16 v272, v0

    .line 2254
    .local v272, "userUnblocked":Z
    const-string v6, "response_success"

    move-object/from16 v0, p2

    move/from16 v1, v272

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 2259
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v135    # "currentUserId":J
    .end local v268    # "userToUnblock":J
    .end local v272    # "userUnblocked":Z
    :sswitch_3e
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackReportUser()V

    .line 2260
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    move-wide/16 v266, v0

    .line 2261
    .local v266, "userToReport":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v266 .. v267}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "complaints"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2264
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2265
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v63

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v65, v0

    const/16 v66, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v68, v0

    move-object/from16 v64, v26

    move-object/from16 v67, v29

    invoke-static/range {v63 .. v68}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2268
    goto/16 :goto_0

    .line 2271
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v266    # "userToReport":J
    :sswitch_3f
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v156

    .line 2272
    .local v156, "followerId":J
    const-string v6, "accept"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v104

    .line 2273
    .local v104, "accept":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x5

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "followers"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "requests"

    aput-object v17, v13, v16

    const/16 v16, 0x4

    invoke-static/range {v156 .. v157}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2276
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2277
    if-eqz v104, :cond_59

    .line 2278
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    const/16 v16, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v16

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    goto/16 :goto_0

    .line 2282
    :cond_59
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2286
    goto/16 :goto_0

    .line 2289
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v104    # "accept":Z
    .end local v156    # "followerId":J
    :sswitch_40
    const-string v6, "explicit"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v149

    .line 2290
    .local v149, "explicit":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "explicit"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2292
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2294
    if-eqz v149, :cond_5a

    .line 2295
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v63

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v65, v0

    const/16 v66, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v68, v0

    move-object/from16 v64, v26

    move-object/from16 v67, v29

    invoke-static/range {v63 .. v68}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2302
    :goto_25
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    goto/16 :goto_0

    .line 2299
    :cond_5a
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    goto :goto_25

    .line 2306
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v149    # "explicit":Z
    :sswitch_41
    const-string v6, "priv"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v218

    .line 2307
    .local v218, "priv":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2309
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2310
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x1

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 2312
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v13, Lorg/apache/http/message/BasicNameValuePair;

    const-string v16, "private"

    if-eqz v218, :cond_5b

    const-string v6, "1"

    :goto_26
    move-object/from16 v0, v16

    invoke-direct {v13, v0, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2313
    invoke-static/range {p0 .. p0}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2316
    goto/16 :goto_0

    .line 2312
    :cond_5b
    const-string v6, "0"

    goto :goto_26

    .line 2319
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v218    # "priv":Z
    :sswitch_42
    const-string v6, "page_type"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v57

    .line 2320
    .restart local v57    # "pageType":I
    const/16 v204, 0x1

    .line 2321
    .restart local v204    # "page":I
    packed-switch v57, :pswitch_data_6

    .line 2340
    :cond_5c
    :goto_27
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "channels"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "featured"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2342
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 2344
    const/16 v6, 0x12

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2345
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2348
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2349
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v237

    check-cast v237, Lco/vine/android/api/VinePagedData;

    .line 2350
    .local v237, "results":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineChannel;>;"
    move-object/from16 v0, v237

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v122, v0

    .line 2351
    .local v122, "channels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineChannel;>;"
    move-object/from16 v0, v237

    iget v6, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    move-object/from16 v0, v237

    iget v13, v0, Lco/vine/android/api/VinePagedData;->previousPage:I

    move-object/from16 v0, v122

    invoke-virtual {v12, v0, v6, v13}, Lco/vine/android/provider/VineDatabaseHelper;->mergeChannels(Ljava/util/Collection;II)I

    .line 2353
    move-object/from16 v0, v237

    iget v6, v0, Lco/vine/android/api/VinePagedData;->nextPage:I

    if-gtz v6, :cond_5d

    .line 2354
    invoke-virtual {v12}, Lco/vine/android/provider/VineDatabaseHelper;->markLastChannel()V

    .line 2356
    :cond_5d
    const-string v6, "channels"

    move-object/from16 v0, p2

    move-object/from16 v1, v122

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 2324
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v122    # "channels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineChannel;>;"
    .end local v237    # "results":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineChannel;>;"
    :pswitch_d
    const/16 v204, 0x1

    .line 2325
    goto :goto_27

    .line 2328
    :pswitch_e
    const/4 v6, 0x2

    const/4 v13, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x1

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v12, v6, v13, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getPreviousPageCursor(IILjava/lang/String;Z)I

    move-result v59

    .line 2330
    .restart local v59    # "previous":I
    if-lez v59, :cond_5c

    .line 2331
    move/from16 v204, v59

    goto/16 :goto_27

    .line 2361
    .end local v57    # "pageType":I
    .end local v59    # "previous":I
    .end local v204    # "page":I
    :sswitch_43
    const-string v6, "post"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    move-object/16 v281, v0

    move-object/from16 v0, v281

    check-cast v0, Lco/vine/android/api/VinePostResponse;

    move-object/16 v281, v0

    .line 2362
    .local v281, "vpr":Lco/vine/android/api/VinePostResponse;
    invoke-static/range {p0 .. p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v114

    .line 2363
    .local v114, "api":Lco/vine/android/client/VineAPI;
    invoke-virtual/range {v114 .. v114}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "timelines"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    move-object/from16 v0, v281

    iget-wide v0, v0, Lco/vine/android/api/VinePostResponse;->postId:J

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v159

    .line 2365
    .local v159, "getPostUrl":Ljava/lang/StringBuilder;
    invoke-static/range {p0 .. p0}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v123

    .line 2366
    .restart local v123    # "client":Lco/vine/android/network/ThreadedHttpOperationClient;
    const/16 v6, 0x8

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2367
    move-object/from16 v0, v123

    move-object/from16 v1, v159

    move-object/from16 v2, v114

    move-object/from16 v3, v29

    move-object/from16 v4, v43

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2369
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_5e

    .line 2370
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v215

    check-cast v215, Lco/vine/android/api/VinePagedData;

    .line 2371
    .local v215, "posts":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    if-eqz v215, :cond_1

    move-object/from16 v0, v215

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_1

    .line 2372
    invoke-static/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v63

    .line 2374
    .local v63, "db":Lco/vine/android/provider/VineDatabaseHelper;
    :try_start_d
    move-object/from16 v0, v215

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v64, v0

    const/16 v65, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v66

    const/16 v67, 0x0

    const/16 v68, 0x0

    const/16 v69, 0x0

    const-wide/16 v70, 0x0

    const/16 v72, 0x1

    invoke-virtual/range {v63 .. v72}, Lco/vine/android/provider/VineDatabaseHelper;->mergePosts(Ljava/util/Collection;ILjava/lang/String;IIIJZ)Lco/vine/android/provider/DbResponse;

    .line 2376
    move-object/from16 v0, v215

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v64, v0

    const/16 v65, 0x2

    invoke-static/range {v34 .. v35}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v66

    const/16 v67, 0x0

    const/16 v68, 0x0

    const/16 v69, 0x0

    const-wide/16 v70, 0x0

    const/16 v72, 0x1

    invoke-virtual/range {v63 .. v72}, Lco/vine/android/provider/VineDatabaseHelper;->mergePosts(Ljava/util/Collection;ILjava/lang/String;IIIJZ)Lco/vine/android/provider/DbResponse;
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_9

    .line 2381
    :goto_28
    new-instance v161, Landroid/content/Intent;

    invoke-direct/range {v161 .. v161}, Landroid/content/Intent;-><init>()V

    .line 2382
    .local v161, "i":Landroid/content/Intent;
    const-string v6, "co.vine.android.service.mergePostFeed"

    move-object/from16 v0, v161

    invoke-virtual {v0, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 2383
    const-string v13, "post"

    move-object/from16 v0, v215

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/os/Parcelable;

    move-object/from16 v0, v161

    invoke-virtual {v0, v13, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 2384
    const-string v6, "co.vine.android.BROADCAST"

    move-object/from16 v0, p0

    move-object/from16 v1, v161

    invoke-virtual {v0, v1, v6}, Lco/vine/android/service/VineService;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 2378
    .end local v161    # "i":Landroid/content/Intent;
    :catch_9
    move-exception v139

    .line 2379
    .restart local v139    # "e":Ljava/io/IOException;
    const-string v6, "Error writing uploaded post to db"

    move-object/from16 v0, v139

    invoke-static {v6, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_28

    .line 2387
    .end local v63    # "db":Lco/vine/android/provider/VineDatabaseHelper;
    .end local v139    # "e":Ljava/io/IOException;
    .end local v215    # "posts":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VinePost;>;"
    :cond_5e
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v148

    .end local v148    # "error":Lco/vine/android/api/VineError;
    check-cast v148, Lco/vine/android/api/VineError;

    .line 2388
    .restart local v148    # "error":Lco/vine/android/api/VineError;
    if-eqz v202, :cond_1

    if-eqz v148, :cond_1

    .line 2389
    const-string v6, "Error retrieving uploaded post from server: {} {}"

    move-object/from16 v0, v202

    iget v13, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    move-object/from16 v0, v148

    iget-object v0, v0, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-static {v6, v13, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 2396
    .end local v114    # "api":Lco/vine/android/client/VineAPI;
    .end local v123    # "client":Lco/vine/android/network/ThreadedHttpOperationClient;
    .end local v159    # "getPostUrl":Ljava/lang/StringBuilder;
    .end local v281    # "vpr":Lco/vine/android/api/VinePostResponse;
    :sswitch_44
    const-string v6, "gcmRegId"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v227

    .line 2397
    .local v227, "regId":Ljava/lang/String;
    if-nez v227, :cond_5f

    .line 2398
    const-string v227, ""

    .line 2400
    :cond_5f
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 2402
    .restart local v10    # "userId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2404
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 2405
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "deviceToken"

    move-object/from16 v0, v227

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2407
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2408
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2412
    goto/16 :goto_0

    .line 2415
    .end local v10    # "userId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v227    # "regId":Ljava/lang/String;
    :sswitch_45
    const-string v6, "gcmRegId"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v227

    .line 2416
    .restart local v227    # "regId":Ljava/lang/String;
    if-nez v227, :cond_60

    .line 2417
    const-string v227, ""

    .line 2419
    :cond_60
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 2420
    .restart local v10    # "userId":J
    const-string v6, "s_key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v120

    .line 2421
    .local v120, "cachedKey":Ljava/lang/String;
    if-nez v120, :cond_61

    .line 2422
    const-string v120, ""

    .line 2425
    :cond_61
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "deviceToken"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2427
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "deviceToken"

    move-object/from16 v0, v26

    move-object/from16 v1, v227

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 2429
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2430
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    move-object/from16 v2, v120

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2434
    goto/16 :goto_0

    .line 2437
    .end local v10    # "userId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v120    # "cachedKey":Ljava/lang/String;
    .end local v227    # "regId":Ljava/lang/String;
    :sswitch_46
    const-string v6, "notification_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v197

    .line 2438
    .local v197, "notificationId":I
    const-string v6, "conversation_row_id"

    const-wide/16 v16, -0x1

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v67

    .line 2439
    .restart local v67    # "conversationRowId":J
    const-wide/16 v16, 0x0

    cmp-long v6, v67, v16

    if-ltz v6, :cond_62

    .line 2440
    move-wide/from16 v0, v67

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->removeNotificationForConversation(J)V

    goto/16 :goto_0

    .line 2442
    :cond_62
    move/from16 v0, v197

    invoke-virtual {v12, v0}, Lco/vine/android/provider/VineDatabaseHelper;->removeNotificationsForNotificationId(I)V

    goto/16 :goto_0

    .line 2447
    .end local v67    # "conversationRowId":J
    .end local v197    # "notificationId":I
    :sswitch_47
    const-string v6, "notification"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v196

    check-cast v196, Lco/vine/android/api/VineSingleNotification;

    .line 2448
    .local v196, "notification":Lco/vine/android/api/VineSingleNotification;
    invoke-virtual/range {v196 .. v196}, Lco/vine/android/api/VineSingleNotification;->isMessaging()Z

    move-result v6

    if-eqz v6, :cond_63

    .line 2449
    const/16 v6, 0x12

    move-object/from16 v0, v196

    iput v6, v0, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    .line 2450
    move-object/from16 v0, v196

    iget-wide v0, v0, Lco/vine/android/api/VineSingleNotification;->conversationId:J

    move-wide/from16 v67, v0

    const/16 v69, 0x1

    const/16 v71, 0x1

    const/16 v72, 0x1

    move-object/from16 v64, p0

    move-wide/from16 v65, v34

    move-object/from16 v70, v12

    invoke-direct/range {v64 .. v72}, Lco/vine/android/service/VineService;->getConversationWithRemoteId(JJILco/vine/android/provider/VineDatabaseHelper;ZI)Lco/vine/android/api/VineConversation;

    move-result-object v91

    .line 2452
    .local v91, "conversation":Lco/vine/android/api/VineConversation;
    if-eqz v91, :cond_63

    .line 2453
    move-object/from16 v0, v91

    iget-wide v0, v0, Lco/vine/android/api/VineConversation;->conversationObjectId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    move-object/from16 v2, v196

    iput-wide v0, v2, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    .line 2454
    invoke-virtual/range {v91 .. v91}, Lco/vine/android/api/VineConversation;->lastMessage()Lco/vine/android/api/VinePrivateMessage;

    move-result-object v184

    .line 2455
    .local v184, "message":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v184, :cond_63

    .line 2456
    move-object/from16 v0, v184

    iget-object v6, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    if-eqz v6, :cond_63

    move-object/from16 v0, v184

    iget-object v6, v0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    if-eqz v6, :cond_63

    .line 2457
    move-object/from16 v0, v196

    iget-object v6, v0, Lco/vine/android/api/VineSingleNotification;->imageKeys:Ljava/util/ArrayList;

    new-instance v13, Lco/vine/android/util/image/ImageKey;

    move-object/from16 v0, v184

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v13, v0}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2458
    move-object/from16 v0, v196

    iget-object v6, v0, Lco/vine/android/api/VineSingleNotification;->videoKeys:Ljava/util/ArrayList;

    new-instance v13, Lco/vine/android/util/video/VideoKey;

    move-object/from16 v0, v184

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v13, v0}, Lco/vine/android/util/video/VideoKey;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2463
    .end local v91    # "conversation":Lco/vine/android/api/VineConversation;
    .end local v184    # "message":Lco/vine/android/api/VinePrivateMessage;
    :cond_63
    const-string v6, "message"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v184

    .line 2464
    .local v184, "message":Ljava/lang/String;
    move-object/from16 v0, v196

    iget v6, v0, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    move-object/from16 v0, v196

    move-object/from16 v1, v184

    invoke-virtual {v12, v0, v1, v6}, Lco/vine/android/provider/VineDatabaseHelper;->mergePushNotification(Lco/vine/android/api/VineSingleNotification;Ljava/lang/String;I)Ljava/util/ArrayList;

    move-result-object v199

    .line 2467
    .local v199, "notifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    if-eqz v199, :cond_6b

    invoke-virtual/range {v196 .. v196}, Lco/vine/android/api/VineSingleNotification;->isMessaging()Z

    move-result v6

    if-eqz v6, :cond_6b

    .line 2468
    new-instance v0, Ljava/util/ArrayList;

    move-object/16 v257, v0

    move-object/from16 v0, v257

    move-object/from16 v1, v199

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 2469
    .local v257, "unclearedNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    new-instance v0, Lco/vine/android/util/LongSparseArray;

    move-object/16 v258, v0

    invoke-direct/range {v258 .. v258}, Lco/vine/android/util/LongSparseArray;-><init>()V

    .line 2471
    .local v258, "uniqueNotifications":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineSingleNotification;>;"
    invoke-virtual/range {v257 .. v257}, Ljava/util/ArrayList;->size()I

    move-result v6

    const/4 v13, 0x1

    if-le v6, v13, :cond_69

    .line 2472
    invoke-virtual/range {v257 .. v257}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_29
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_65

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v188

    check-cast v188, Lco/vine/android/api/VineSingleNotification;

    .line 2473
    .local v188, "n":Lco/vine/android/api/VineSingleNotification;
    move-object/from16 v0, v188

    iget-wide v0, v0, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v258

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v194

    check-cast v194, Lco/vine/android/api/VineSingleNotification;

    .line 2474
    .local v194, "notif":Lco/vine/android/api/VineSingleNotification;
    if-eqz v194, :cond_64

    .line 2475
    move-object/from16 v0, v194

    iget v6, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, v194

    iput v6, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    goto :goto_29

    .line 2477
    :cond_64
    move-object/from16 v0, v188

    iget-wide v0, v0, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v258

    move-wide/from16 v1, v16

    move-object/from16 v3, v188

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 2478
    const/4 v6, 0x1

    move-object/from16 v0, v188

    iput v6, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    goto :goto_29

    .line 2481
    .end local v188    # "n":Lco/vine/android/api/VineSingleNotification;
    .end local v194    # "notif":Lco/vine/android/api/VineSingleNotification;
    :cond_65
    invoke-virtual/range {v257 .. v257}, Ljava/util/ArrayList;->clear()V

    .line 2482
    invoke-virtual/range {v258 .. v258}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v188

    .line 2483
    .local v188, "n":I
    const/16 v161, 0x0

    .local v161, "i":I
    :goto_2a
    move/from16 v0, v161

    move/from16 v1, v188

    if-ge v0, v1, :cond_69

    .line 2484
    move-object/from16 v0, v258

    move/from16 v1, v161

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v194

    check-cast v194, Lco/vine/android/api/VineSingleNotification;

    .line 2485
    .restart local v194    # "notif":Lco/vine/android/api/VineSingleNotification;
    move-object/from16 v0, v194

    iget v6, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    const/4 v13, 0x1

    if-le v6, v13, :cond_66

    .line 2486
    const v6, 0x7f0e013f

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, v194

    iget-object v0, v0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Lco/vine/android/util/Util;->getUsernameFromActivity(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x1

    move-object/from16 v0, v194

    iget v0, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v13, v16

    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v13}, Lco/vine/android/service/VineService;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v194

    iput-object v6, v0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    .line 2488
    :cond_66
    move-object/from16 v0, v257

    move-object/from16 v1, v194

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2489
    move-object/from16 v0, v194

    iget-wide v0, v0, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v196

    iget-wide v0, v0, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    move-wide/from16 v19, v0

    cmp-long v6, v16, v19

    if-nez v6, :cond_67

    .line 2490
    move-object/from16 v0, v194

    iget v6, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    move-object/from16 v0, v196

    iput v6, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    .line 2492
    :cond_67
    if-lez v161, :cond_68

    .line 2493
    const-string v6, "Prefetching message headers..."

    invoke-static {v6}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 2494
    move-object/from16 v0, v196

    iget-wide v0, v0, Lco/vine/android/api/VineSingleNotification;->conversationId:J

    move-wide/from16 v67, v0

    const/16 v69, 0x1

    const/16 v71, 0x1

    const/16 v72, 0x1

    move-object/from16 v64, p0

    move-wide/from16 v65, v34

    move-object/from16 v70, v12

    invoke-direct/range {v64 .. v72}, Lco/vine/android/service/VineService;->getConversationWithRemoteId(JJILco/vine/android/provider/VineDatabaseHelper;ZI)Lco/vine/android/api/VineConversation;

    move-result-object v91

    .line 2496
    .restart local v91    # "conversation":Lco/vine/android/api/VineConversation;
    if-eqz v91, :cond_68

    .line 2497
    invoke-virtual/range {v91 .. v91}, Lco/vine/android/api/VineConversation;->lastMessage()Lco/vine/android/api/VinePrivateMessage;

    move-result-object v173

    .line 2498
    .local v173, "lastMessage":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v184, :cond_68

    const/4 v6, 0x4

    move/from16 v0, v161

    if-ge v0, v6, :cond_68

    .line 2499
    move-object/from16 v0, v173

    iget-object v6, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    if-eqz v6, :cond_68

    move-object/from16 v0, v173

    iget-object v6, v0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    if-eqz v6, :cond_68

    .line 2500
    move-object/from16 v0, v196

    iget-object v6, v0, Lco/vine/android/api/VineSingleNotification;->imageKeys:Ljava/util/ArrayList;

    new-instance v13, Lco/vine/android/util/image/ImageKey;

    move-object/from16 v0, v173

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v13, v0}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2501
    move-object/from16 v0, v196

    iget-object v6, v0, Lco/vine/android/api/VineSingleNotification;->videoKeys:Ljava/util/ArrayList;

    new-instance v13, Lco/vine/android/util/video/VideoKey;

    move-object/from16 v0, v173

    iget-object v0, v0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-direct {v13, v0}, Lco/vine/android/util/video/VideoKey;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2483
    .end local v91    # "conversation":Lco/vine/android/api/VineConversation;
    .end local v173    # "lastMessage":Lco/vine/android/api/VinePrivateMessage;
    :cond_68
    add-int/lit8 v161, v161, 0x1

    goto/16 :goto_2a

    .line 2508
    .end local v161    # "i":I
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v188    # "n":I
    .end local v194    # "notif":Lco/vine/android/api/VineSingleNotification;
    :cond_69
    const-string v6, "notifications"

    move-object/from16 v0, p2

    move-object/from16 v1, v257

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 2515
    .end local v257    # "unclearedNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    .end local v258    # "uniqueNotifications":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Lco/vine/android/api/VineSingleNotification;>;"
    :cond_6a
    :goto_2b
    const-string v6, "notification"

    move-object/from16 v0, p2

    move-object/from16 v1, v196

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 2510
    :cond_6b
    move-object/from16 v0, v184

    move-object/from16 v1, v196

    iput-object v0, v1, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    .line 2511
    if-eqz v199, :cond_6a

    .line 2512
    const-string v6, "notifications"

    move-object/from16 v0, p2

    move-object/from16 v1, v199

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_2b

    .line 2519
    .end local v184    # "message":Ljava/lang/String;
    .end local v196    # "notification":Lco/vine/android/api/VineSingleNotification;
    .end local v199    # "notifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :sswitch_48
    const-string v6, "notification_display_id"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v6

    invoke-virtual {v12, v6}, Lco/vine/android/provider/VineDatabaseHelper;->deletePushNotifications(I)I

    .line 2520
    const/16 v245, 0xc8

    .line 2521
    goto/16 :goto_0

    .line 2524
    :sswitch_49
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 2525
    .restart local v14    # "postId":J
    const-string v6, "network"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v190

    .line 2526
    .local v190, "network":Ljava/lang/String;
    const-string v6, "message"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v184

    .line 2528
    .restart local v184    # "message":Ljava/lang/String;
    move-object/from16 v0, v190

    invoke-static {v0, v14, v15}, Lco/vine/android/util/FlurryUtils;->trackSharePost(Ljava/lang/String;J)V

    .line 2530
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "posts"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "share"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    aput-object v190, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2532
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 2533
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "message"

    move-object/from16 v0, v184

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2535
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2536
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v27, v0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v25 .. v30}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2540
    goto/16 :goto_0

    .line 2543
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v184    # "message":Ljava/lang/String;
    .end local v190    # "network":Ljava/lang/String;
    :sswitch_4a
    const-string v6, "post_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v14

    .line 2544
    .restart local v14    # "postId":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v73

    .line 2545
    .local v73, "created":J
    new-instance v213, Ljava/util/HashMap;

    invoke-direct/range {v213 .. v213}, Ljava/util/HashMap;-><init>()V

    .line 2546
    .local v213, "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v6, "recipients"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v223

    .line 2547
    .restart local v223    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "conversations"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2549
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-string v6, "postId"

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    move-object/from16 v0, v213

    invoke-virtual {v0, v6, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2550
    const-string v6, "to"

    invoke-static/range {v223 .. v223}, Lco/vine/android/api/VineUpload$PostInfo;->recipientsToMaps(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v13

    move-object/from16 v0, v213

    invoke-virtual {v0, v6, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2551
    const-string v6, "created"

    invoke-static/range {v73 .. v74}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    move-object/from16 v0, v213

    invoke-virtual {v0, v6, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2552
    move-object/from16 v0, p0

    move-object/from16 v1, v213

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineService;->addCountryParam(Ljava/util/HashMap;)V

    .line 2553
    const/16 v6, 0xc

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2554
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v213

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthJsonPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/HashMap;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2557
    goto/16 :goto_0

    .line 2560
    .end local v14    # "postId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v73    # "created":J
    .end local v213    # "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v223    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    :sswitch_4b
    const-string v6, "s_key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v120

    .line 2561
    .restart local v120    # "cachedKey":Ljava/lang/String;
    if-nez v120, :cond_6c

    .line 2562
    const-string v120, ""

    .line 2564
    :cond_6c
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "authenticate"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2566
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2567
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    move-object/from16 v2, v120

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2570
    goto/16 :goto_0

    .line 2573
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v120    # "cachedKey":Ljava/lang/String;
    :sswitch_4c
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "pendingNotificationsCount"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2576
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0x15

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2578
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2581
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2582
    const-string v13, "count"

    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    move-object/from16 v0, p2

    invoke-virtual {v0, v13, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 2588
    .end local v26    # "url":Ljava/lang/StringBuilder;
    :sswitch_4d
    const-string v6, "q"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v219

    .line 2589
    .restart local v219    # "query":Ljava/lang/String;
    invoke-virtual/range {v219 .. v219}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/client/VineAPI;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v146

    .line 2590
    .local v146, "encodedQuery":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "search"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    aput-object v146, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2593
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    move/from16 v0, p1

    sparse-switch v0, :sswitch_data_1

    .line 2604
    :goto_2c
    const/4 v6, 0x3

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2605
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    move-object/from16 v2, v43

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2609
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2610
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v273, v0

    move-object/from16 v0, v273

    check-cast v0, Lco/vine/android/api/VinePagedData;

    move-object/16 v273, v0

    .line 2611
    .restart local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, v273

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_1

    .line 2612
    move-object/from16 v0, v273

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v65, v0

    const/16 v66, 0x0

    const/16 v67, 0x0

    const/16 v68, 0x0

    const/16 v69, 0x0

    const/16 v70, 0x0

    move-object/from16 v64, v12

    invoke-virtual/range {v64 .. v70}, Lco/vine/android/provider/VineDatabaseHelper;->mergeUsers(Ljava/util/Collection;ILjava/lang/String;IILco/vine/android/util/LongSparseArray;)I

    .line 2613
    const-string v6, "q"

    move-object/from16 v0, p2

    move-object/from16 v1, v219

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2614
    const-string v6, "users"

    move-object/from16 v0, v273

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 2595
    .end local v273    # "users":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineUser;>;"
    :sswitch_4e
    const-string v6, "st"

    const-string v13, "message"

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2c

    .line 2599
    :sswitch_4f
    const-string v6, "st"

    const-string v13, "mention"

    move-object/from16 v0, v26

    invoke-static {v0, v6, v13}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2c

    .line 2620
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v146    # "encodedQuery":Ljava/lang/String;
    .end local v219    # "query":Ljava/lang/String;
    :sswitch_50
    const-string v6, "q"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v219

    .line 2621
    .restart local v219    # "query":Ljava/lang/String;
    invoke-static/range {v219 .. v219}, Lco/vine/android/client/VineAPI;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v146

    .line 2622
    .restart local v146    # "encodedQuery":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "tags"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "search"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    aput-object v146, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2625
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0xe

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2626
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    move-object/from16 v2, v43

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2630
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2631
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v248

    check-cast v248, Lco/vine/android/api/VinePagedData;

    .line 2632
    .restart local v248    # "tags":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineTag;>;"
    move-object/from16 v0, v248

    iget-object v6, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_1

    .line 2633
    const-string v6, "q"

    move-object/from16 v0, p2

    move-object/from16 v1, v219

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2634
    const-string v6, "tags"

    move-object/from16 v0, v248

    iget-object v13, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_0

    .line 2641
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v146    # "encodedQuery":Ljava/lang/String;
    .end local v219    # "query":Ljava/lang/String;
    .end local v248    # "tags":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineTag;>;"
    :sswitch_51
    const-string v6, "loops"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v224

    .line 2642
    .local v224, "records":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/util/LoopManager$Record;>;"
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "loops"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2645
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v180, Ljava/util/LinkedList;

    invoke-direct/range {v180 .. v180}, Ljava/util/LinkedList;-><init>()V

    .line 2646
    .local v180, "loopsList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    new-instance v213, Ljava/util/HashMap;

    invoke-direct/range {v213 .. v213}, Ljava/util/HashMap;-><init>()V

    .line 2647
    .restart local v213    # "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v6, "loops"

    move-object/from16 v0, v213

    move-object/from16 v1, v180

    invoke-virtual {v0, v6, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2649
    invoke-interface/range {v224 .. v224}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_2d
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_6d

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v220

    check-cast v220, Lco/vine/android/util/LoopManager$Record;

    .line 2650
    .local v220, "r":Lco/vine/android/util/LoopManager$Record;
    new-instance v179, Ljava/util/HashMap;

    invoke-direct/range {v179 .. v179}, Ljava/util/HashMap;-><init>()V

    .line 2651
    .local v179, "loopBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v6, "postId"

    move-object/from16 v0, v220

    iget-wide v0, v0, Lco/vine/android/util/LoopManager$Record;->postId:J

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    move-object/from16 v0, v179

    invoke-virtual {v0, v6, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2652
    const-string v6, "count"

    move-object/from16 v0, v220

    iget v13, v0, Lco/vine/android/util/LoopManager$Record;->loopCount:I

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    move-object/from16 v0, v179

    invoke-virtual {v0, v6, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2653
    const-string v6, "ts"

    move-object/from16 v0, v220

    iget-wide v0, v0, Lco/vine/android/util/LoopManager$Record;->timeStamp:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    long-to-double v0, v0

    move-wide/from16 v16, v0

    const-wide v19, 0x408f400000000000L    # 1000.0

    div-double v16, v16, v19

    invoke-static/range {v16 .. v17}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v13

    move-object/from16 v0, v179

    invoke-virtual {v0, v6, v13}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2654
    move-object/from16 v0, v180

    move-object/from16 v1, v179

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2d

    .line 2657
    .end local v179    # "loopBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v220    # "r":Lco/vine/android/util/LoopManager$Record;
    :cond_6d
    const/16 v6, 0x1b

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2658
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v213

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthJsonPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/HashMap;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2661
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2662
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v235

    check-cast v235, Lco/vine/android/api/VineLoopSubmissionResponse;

    .line 2663
    .local v235, "response":Lco/vine/android/api/VineLoopSubmissionResponse;
    const-string v6, "loop_submission"

    move-object/from16 v0, p2

    move-object/from16 v1, v235

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 2668
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v180    # "loopsList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Object;>;"
    .end local v213    # "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v224    # "records":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/util/LoopManager$Record;>;"
    .end local v235    # "response":Lco/vine/android/api/VineLoopSubmissionResponse;
    :sswitch_52
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "me"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2672
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2673
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2677
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2678
    sget-object v6, Lco/vine/android/api/VineParsers$API_RESPONSE;->SUCCESS:Lco/vine/android/api/VineParsers$API_RESPONSE;

    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v13

    invoke-virtual {v6, v13}, Lco/vine/android/api/VineParsers$API_RESPONSE;->equals(Ljava/lang/Object;)Z

    move-result v246

    .line 2679
    .local v246, "success":Z
    const-string v6, "response_success"

    move-object/from16 v0, p2

    move/from16 v1, v246

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 2684
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v246    # "success":Z
    :sswitch_53
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 2685
    .restart local v10    # "userId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "followers"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "reposts"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2691
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2692
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v64

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v66, v0

    const/16 v67, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v69, v0

    move-object/from16 v65, v26

    move-object/from16 v68, v29

    invoke-static/range {v64 .. v69}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2696
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2697
    sget-object v6, Lco/vine/android/api/VineParsers$API_RESPONSE;->SUCCESS:Lco/vine/android/api/VineParsers$API_RESPONSE;

    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v13

    invoke-virtual {v6, v13}, Lco/vine/android/api/VineParsers$API_RESPONSE;->equals(Ljava/lang/Object;)Z

    move-result v246

    .line 2698
    .restart local v246    # "success":Z
    const-string v6, "response_success"

    move-object/from16 v0, p2

    move/from16 v1, v246

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 2703
    .end local v10    # "userId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v246    # "success":Z
    :sswitch_54
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 2704
    .restart local v10    # "userId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x4

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "followers"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    const-string v17, "reposts"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2710
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2711
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2715
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2716
    invoke-virtual {v12, v10, v11}, Lco/vine/android/provider/VineDatabaseHelper;->removePostsByReposterId(J)V

    .line 2718
    sget-object v6, Lco/vine/android/api/VineParsers$API_RESPONSE;->SUCCESS:Lco/vine/android/api/VineParsers$API_RESPONSE;

    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v13

    invoke-virtual {v6, v13}, Lco/vine/android/api/VineParsers$API_RESPONSE;->equals(Ljava/lang/Object;)Z

    move-result v246

    .line 2719
    .restart local v246    # "success":Z
    const-string v6, "response_success"

    move-object/from16 v0, p2

    move/from16 v1, v246

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 2724
    .end local v10    # "userId":J
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v246    # "success":Z
    :sswitch_55
    const-string v6, "page_type"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v57

    .restart local v57    # "pageType":I
    move-object/from16 v33, p0

    move/from16 v36, v57

    move/from16 v37, p1

    move-object/from16 v38, v43

    move-object/from16 v39, v12

    move-object/from16 v40, p2

    .line 2726
    :try_start_e
    invoke-direct/range {v33 .. v40}, Lco/vine/android/service/VineService;->getInbox(JIILjava/lang/String;Lco/vine/android/provider/VineDatabaseHelper;Landroid/os/Bundle;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2727
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->getReader()Lco/vine/android/network/HttpOperationReader;

    move-result-object v6

    move-object v0, v6

    check-cast v0, Lco/vine/android/api/VineParserReader;

    move-object/from16 v29, v0
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_a

    goto/16 :goto_0

    .line 2728
    :catch_a
    move-exception v139

    .line 2729
    .restart local v139    # "e":Ljava/io/IOException;
    sget-boolean v6, Lco/vine/android/service/VineService;->LOGGABLE:Z

    if-eqz v6, :cond_1

    .line 2730
    invoke-virtual/range {v139 .. v139}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_0

    .line 2736
    .end local v57    # "pageType":I
    .end local v139    # "e":Ljava/io/IOException;
    :sswitch_56
    const/16 v65, 0x6

    const/16 v66, 0x1

    const/16 v67, 0x0

    const/16 v68, 0x0

    const/16 v69, 0x0

    const-wide/16 v70, 0x0

    const/16 v72, 0x1

    move-object/from16 v64, v12

    invoke-virtual/range {v64 .. v72}, Lco/vine/android/provider/VineDatabaseHelper;->savePageCursor(IILjava/lang/String;IIJZ)I

    .line 2737
    const/16 v65, 0x6

    const/16 v66, 0x2

    const/16 v67, 0x0

    const/16 v68, 0x0

    const/16 v69, 0x0

    const-wide/16 v70, 0x0

    const/16 v72, 0x1

    move-object/from16 v64, v12

    invoke-virtual/range {v64 .. v72}, Lco/vine/android/provider/VineDatabaseHelper;->savePageCursor(IILjava/lang/String;IIJZ)I

    goto/16 :goto_0

    .line 2741
    :sswitch_57
    const-string v6, "network"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v191

    .line 2743
    .restart local v191    # "networkType":I
    const-string v6, "upload"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    move-object/16 v259, v0

    move-object/from16 v0, v259

    check-cast v0, Lco/vine/android/api/VineUpload;

    move-object/16 v259, v0

    .line 2744
    .local v259, "upload":Lco/vine/android/api/VineUpload;
    invoke-virtual/range {v259 .. v259}, Lco/vine/android/api/VineUpload;->getPostInfo()Lco/vine/android/api/VineUpload$PostInfo;

    move-result-object v165

    .line 2746
    .local v165, "info":Lco/vine/android/api/VineUpload$PostInfo;
    move-object/from16 v0, v165

    iget-object v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    move-object/from16 v223, v0

    .line 2747
    .restart local v223    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    move-object/from16 v0, v259

    iget-wide v0, v0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    move-wide/from16 v67, v0

    .line 2749
    .restart local v67    # "conversationRowId":J
    if-nez v223, :cond_6e

    const-wide/16 v16, 0x0

    cmp-long v6, v67, v16

    if-lez v6, :cond_6e

    .line 2750
    move-wide/from16 v0, v67

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getConversationRecipientsFromConversationRowId(J)Ljava/util/ArrayList;

    .line 2753
    :cond_6e
    if-eqz v223, :cond_71

    .line 2754
    invoke-virtual/range {v223 .. v223}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :cond_6f
    :goto_2e
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_71

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v222

    check-cast v222, Lco/vine/android/api/VineRecipient;

    .line 2756
    .restart local v222    # "recipient":Lco/vine/android/api/VineRecipient;
    invoke-virtual/range {v222 .. v222}, Lco/vine/android/api/VineRecipient;->isFromUser()Z

    move-result v6

    if-eqz v6, :cond_6f

    .line 2757
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    move-wide/from16 v16, v0

    const-wide/16 v19, 0x0

    cmp-long v6, v16, v19

    if-gtz v6, :cond_70

    .line 2758
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->userId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v16

    move-wide/from16 v0, v16

    move-object/from16 v2, v222

    iput-wide v0, v2, Lco/vine/android/api/VineRecipient;->recipientId:J

    goto :goto_2e

    .line 2759
    :cond_70
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->userId:J

    move-wide/from16 v16, v0

    const-wide/16 v19, 0x0

    cmp-long v6, v16, v19

    if-gez v6, :cond_6f

    .line 2760
    move-object/from16 v0, v222

    iget-wide v0, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRemoteIdForUserRowId(J)J

    move-result-wide v16

    move-wide/from16 v0, v16

    move-object/from16 v2, v222

    iput-wide v0, v2, Lco/vine/android/api/VineRecipient;->userId:J

    goto :goto_2e

    .line 2766
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v222    # "recipient":Lco/vine/android/api/VineRecipient;
    :cond_71
    move-wide/from16 v0, v34

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getUserRowIdForUserRemoteId(J)J

    move-result-wide v71

    .line 2770
    .local v71, "myUserId":J
    const-wide/16 v16, 0x0

    cmp-long v6, v67, v16

    if-gtz v6, :cond_72

    .line 2773
    move-object/from16 v0, v223

    move/from16 v1, v191

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->determineOrCreateBestConversationRowIdForRecipients(Ljava/util/List;I)J

    move-result-wide v67

    .line 2775
    :cond_72
    move-wide/from16 v0, v67

    move-object/from16 v2, v259

    iput-wide v0, v2, Lco/vine/android/api/VineUpload;->conversationRowId:J

    .line 2777
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v73

    .line 2782
    .restart local v73    # "created":J
    const/16 v76, 0x0

    .line 2783
    .local v76, "videoPath":Ljava/lang/String;
    const/16 v77, 0x0

    .line 2784
    .local v77, "thumbPath":Ljava/lang/String;
    const/16 v90, 0x0

    .line 2785
    .local v90, "errorReason":Ljava/lang/String;
    const/16 v89, 0x0

    .line 2786
    .restart local v89    # "errorCode":I
    move-object/from16 v0, v259

    iget-object v6, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    if-eqz v6, :cond_73

    .line 2787
    move-object/from16 v0, v259

    iget-object v6, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-static {v6}, Lco/vine/android/util/UploadManager;->getVersionFromPath(Ljava/lang/String;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v0

    move-object/16 v278, v0

    .line 2788
    .local v278, "version":Lco/vine/android/recorder/RecordSessionVersion;
    new-instance v6, Ljava/io/File;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v259

    iget-object v0, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    move-object/from16 v0, v278

    iget-object v0, v0, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v6, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_75

    .line 2789
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "file://"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v259

    iget-object v13, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v278

    iget-object v13, v0, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v76

    .line 2793
    :goto_2f
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "file://"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v259

    iget-object v13, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-static {v13}, Lco/vine/android/recorder/RecordConfigUtils;->getThumbnailPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v77

    .line 2794
    move-object/from16 v0, v259

    iget v6, v0, Lco/vine/android/api/VineUpload;->status:I

    const/4 v13, 0x2

    if-ne v6, v13, :cond_73

    .line 2795
    const v6, 0x7f0e013b

    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v90

    .line 2796
    const/16 v89, -0x2

    .line 2800
    .end local v278    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    :cond_73
    invoke-virtual {v12}, Lco/vine/android/provider/VineDatabaseHelper;->getNewMessageId()J

    move-result-wide v69

    .line 2801
    .local v69, "messageId":J
    move-object/from16 v0, v165

    iget-wide v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->postId:J

    move-wide/from16 v16, v0

    const-wide/16 v19, 0x0

    cmp-long v6, v16, v19

    if-lez v6, :cond_74

    .line 2802
    move-object/from16 v0, v165

    iget-object v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostVideoUrl:Ljava/lang/String;

    move-object/from16 v76, v0

    .line 2803
    move-object/from16 v0, v165

    iget-object v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->sharedPostThumbUrl:Ljava/lang/String;

    move-object/from16 v77, v0

    .line 2806
    :cond_74
    new-instance v64, Lco/vine/android/api/VinePrivateMessage;

    const-wide/16 v65, -0x1

    move-object/from16 v0, v165

    iget-object v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->message:Ljava/lang/String;

    move-object/from16 v75, v0

    const/16 v78, 0x1

    const/16 v79, 0x0

    const/16 v80, 0x0

    const v81, 0x7fffffff

    const-wide/16 v82, 0x0

    move-object/from16 v0, v165

    iget v6, v0, Lco/vine/android/api/VineUpload$PostInfo;->maxLoops:I

    if-lez v6, :cond_76

    const/16 v84, 0x1

    :goto_30
    const-wide/16 v85, 0x0

    move-object/from16 v0, v165

    iget-wide v0, v0, Lco/vine/android/api/VineUpload$PostInfo;->postId:J

    move-wide/from16 v87, v0

    move-object/from16 v0, v259

    iget-object v0, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    move-object/from16 v91, v0

    invoke-direct/range {v64 .. v91}, Lco/vine/android/api/VinePrivateMessage;-><init>(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIJZJJILjava/lang/String;Ljava/lang/String;)V

    .line 2811
    .restart local v64    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    move-wide/from16 v0, v67

    move-object/from16 v2, v64

    invoke-virtual {v12, v0, v1, v2}, Lco/vine/android/provider/VineDatabaseHelper;->mergeMessage(JLco/vine/android/api/VinePrivateMessage;)J

    move-result-wide v81

    .local v81, "messageRowId":J
    move-object/from16 v78, v12

    move-wide/from16 v79, v67

    move-wide/from16 v83, v73

    .line 2812
    invoke-virtual/range {v78 .. v84}, Lco/vine/android/provider/VineDatabaseHelper;->updateConversationWithLastMessage(JJJ)V

    .line 2816
    invoke-virtual/range {v165 .. v165}, Lco/vine/android/api/VineUpload$PostInfo;->toString()Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, v259

    iput-object v6, v0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    .line 2817
    const-string v6, "upload"

    move-object/from16 v0, p2

    move-object/from16 v1, v259

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 2818
    const-string v6, "premerged_message_id"

    move-object/from16 v0, p2

    move-wide/from16 v1, v81

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto/16 :goto_0

    .line 2791
    .end local v64    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    .end local v69    # "messageId":J
    .end local v81    # "messageRowId":J
    .restart local v278    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    :cond_75
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "file://"

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, v259

    iget-object v13, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v76

    goto/16 :goto_2f

    .line 2806
    .end local v278    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    .restart local v69    # "messageId":J
    :cond_76
    const/16 v84, 0x0

    goto :goto_30

    .line 2822
    .end local v67    # "conversationRowId":J
    .end local v69    # "messageId":J
    .end local v71    # "myUserId":J
    .end local v73    # "created":J
    .end local v76    # "videoPath":Ljava/lang/String;
    .end local v77    # "thumbPath":Ljava/lang/String;
    .end local v89    # "errorCode":I
    .end local v90    # "errorReason":Ljava/lang/String;
    .end local v165    # "info":Lco/vine/android/api/VineUpload$PostInfo;
    .end local v191    # "networkType":I
    .end local v223    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .end local v259    # "upload":Lco/vine/android/api/VineUpload;
    :sswitch_58
    const-string v6, "upload_path"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    move-object/16 v260, v0

    .line 2823
    .local v260, "uploadPath":Ljava/lang/String;
    invoke-static/range {v260 .. v260}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 2824
    const/4 v6, -0x2

    const v13, 0x7f0e013b

    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, v260

    invoke-virtual {v12, v0, v6, v13}, Lco/vine/android/provider/VineDatabaseHelper;->setMessageError(Ljava/lang/String;ILjava/lang/String;)V

    goto/16 :goto_0

    .line 2829
    .end local v260    # "uploadPath":Ljava/lang/String;
    :sswitch_59
    const-string v6, "message_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v69

    .line 2830
    .restart local v69    # "messageId":J
    move-wide/from16 v0, v69

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->deleteMessage(J)V

    goto/16 :goto_0

    .line 2834
    .end local v69    # "messageId":J
    :sswitch_5a
    const-string v6, "conversation_row_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v130

    .line 2835
    .local v130, "conversationObjectId":J
    move-wide/from16 v0, v130

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getConversationRemoteId(J)J

    move-result-wide v92

    .line 2836
    .local v92, "conversationId":J
    const-string v6, "conversation_id"

    move-object/from16 v0, p2

    move-wide/from16 v1, v92

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto/16 :goto_0

    .line 2842
    .end local v92    # "conversationId":J
    .end local v130    # "conversationObjectId":J
    :sswitch_5b
    const-string v6, "conversation_row_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v67

    .line 2843
    .restart local v67    # "conversationRowId":J
    const-wide/16 v16, 0x0

    cmp-long v6, v67, v16

    if-lez v6, :cond_78

    .line 2844
    move-wide/from16 v0, v67

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getConversationRemoteId(J)J

    move-result-wide v92

    .line 2848
    .restart local v92    # "conversationId":J
    :goto_31
    const-wide/16 v16, -0x1

    cmp-long v6, v92, v16

    if-eqz v6, :cond_1

    .line 2851
    const-string v6, "prefetch"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v216

    .line 2852
    .local v216, "prefetch":Z
    const-string v6, "page_type"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v57

    .line 2854
    .restart local v57    # "pageType":I
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "conversations"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v92 .. v93}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2857
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v204, 0x1

    .line 2858
    .restart local v204    # "page":I
    packed-switch v57, :pswitch_data_7

    .line 2876
    :cond_77
    :goto_32
    :pswitch_f
    const-string v13, "prefetch"

    if-eqz v216, :cond_79

    const/4 v6, 0x1

    :goto_33
    move-object/from16 v0, v26

    invoke-static {v0, v13, v6}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 2877
    const-string v6, "page"

    move-object/from16 v0, v26

    move/from16 v1, v204

    invoke-static {v0, v6, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 2879
    const/16 v6, 0x16

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2880
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/service/VineService;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2885
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2886
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v137

    check-cast v137, Lco/vine/android/api/VineParsers$VinePagedConversation;

    .line 2887
    .local v137, "data":Lco/vine/android/api/VineParsers$VinePagedConversation;
    if-eqz v137, :cond_7c

    move-object/from16 v0, v137

    iget-object v6, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    if-eqz v6, :cond_7c

    move-object/from16 v0, v137

    iget-object v6, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_7c

    .line 2888
    new-instance v91, Lco/vine/android/api/VineConversation;

    move-object/from16 v0, v137

    iget-wide v0, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->lastMessage:J

    move-wide/from16 v94, v0

    move-object/from16 v0, v137

    iget-object v0, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    move-object/from16 v96, v0

    move-object/from16 v0, v137

    iget-wide v0, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->unreadMessageCount:J

    move-wide/from16 v97, v0

    invoke-direct/range {v91 .. v98}, Lco/vine/android/api/VineConversation;-><init>(JJLjava/util/ArrayList;J)V

    .line 2890
    .restart local v91    # "conversation":Lco/vine/android/api/VineConversation;
    move-object/from16 v0, v137

    iget v6, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->networkType:I

    move-object/from16 v0, v91

    iput v6, v0, Lco/vine/android/api/VineConversation;->networkType:I

    .line 2892
    move-object/from16 v0, v137

    iget-object v6, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_34
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_7a

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v167

    check-cast v167, Lco/vine/android/api/VinePrivateMessage;

    .line 2893
    .local v167, "item":Lco/vine/android/api/VinePrivateMessage;
    move-object/from16 v0, v137

    iget v6, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->networkType:I

    move-object/from16 v0, v167

    iput v6, v0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    goto :goto_34

    .line 2846
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v57    # "pageType":I
    .end local v91    # "conversation":Lco/vine/android/api/VineConversation;
    .end local v92    # "conversationId":J
    .end local v137    # "data":Lco/vine/android/api/VineParsers$VinePagedConversation;
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v167    # "item":Lco/vine/android/api/VinePrivateMessage;
    .end local v204    # "page":I
    .end local v216    # "prefetch":Z
    :cond_78
    const-string v6, "conversation_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v92

    .restart local v92    # "conversationId":J
    goto/16 :goto_31

    .line 2862
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    .restart local v57    # "pageType":I
    .restart local v204    # "page":I
    .restart local v216    # "prefetch":Z
    :pswitch_10
    const/4 v6, 0x7

    const/4 v13, 0x0

    invoke-static/range {v67 .. v68}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v16

    const/16 v17, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v12, v6, v13, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getPreviousPageCursor(IILjava/lang/String;Z)I

    move-result v192

    .line 2863
    .local v192, "newer":I
    if-lez v192, :cond_77

    .line 2864
    move/from16 v204, v192

    goto/16 :goto_32

    .line 2868
    .end local v192    # "newer":I
    :pswitch_11
    const/4 v6, 0x7

    const/4 v13, 0x0

    invoke-static/range {v67 .. v68}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v16

    const/16 v17, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v12, v6, v13, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getNextPageCursor(IILjava/lang/String;Z)I

    move-result v201

    .line 2869
    .local v201, "older":I
    if-lez v201, :cond_77

    .line 2870
    move/from16 v204, v201

    goto/16 :goto_32

    .line 2876
    .end local v201    # "older":I
    :cond_79
    const/4 v6, 0x0

    goto/16 :goto_33

    .line 2896
    .restart local v91    # "conversation":Lco/vine/android/api/VineConversation;
    .restart local v137    # "data":Lco/vine/android/api/VineParsers$VinePagedConversation;
    .restart local v162    # "i$":Ljava/util/Iterator;
    :cond_7a
    const-string v6, "empty"

    const/4 v13, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2898
    :try_start_f
    move-object/from16 v0, v91

    iget v0, v0, Lco/vine/android/api/VineConversation;->networkType:I

    move/from16 v98, v0

    move-object/from16 v0, v137

    iget v0, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->nextPage:I

    move/from16 v99, v0

    move-object/from16 v0, v137

    iget v0, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->previousPage:I

    move/from16 v100, v0

    move-object/from16 v0, v137

    iget-wide v0, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->anchor:J

    move-wide/from16 v101, v0

    move-object/from16 v94, v12

    move-wide/from16 v95, v34

    move-object/from16 v97, v91

    invoke-virtual/range {v94 .. v102}, Lco/vine/android/provider/VineDatabaseHelper;->mergeConversation(JLco/vine/android/api/VineConversation;IIIJ)J

    move-result-wide v128

    .line 2901
    .local v128, "conversationLocalObjectId":J
    move-object/from16 v0, v137

    iget v6, v0, Lco/vine/android/api/VineParsers$VinePagedConversation;->nextPage:I

    if-gtz v6, :cond_7b

    .line 2902
    move-wide/from16 v0, v128

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->markLastMessage(J)V

    .line 2904
    :cond_7b
    move-wide/from16 v0, v67

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->clearUnreadCount(J)V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_b

    goto/16 :goto_0

    .line 2905
    .end local v128    # "conversationLocalObjectId":J
    :catch_b
    move-exception v139

    .line 2906
    .restart local v139    # "e":Ljava/io/IOException;
    sget-boolean v6, Lco/vine/android/service/VineService;->LOGGABLE:Z

    if-eqz v6, :cond_1

    .line 2907
    invoke-virtual/range {v139 .. v139}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_0

    .line 2911
    .end local v91    # "conversation":Lco/vine/android/api/VineConversation;
    .end local v139    # "e":Ljava/io/IOException;
    .end local v162    # "i$":Ljava/util/Iterator;
    :cond_7c
    const-string v6, "empty"

    const/4 v13, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 2918
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v57    # "pageType":I
    .end local v67    # "conversationRowId":J
    .end local v92    # "conversationId":J
    .end local v137    # "data":Lco/vine/android/api/VineParsers$VinePagedConversation;
    .end local v204    # "page":I
    .end local v216    # "prefetch":Z
    :sswitch_5c
    const-string v6, "conversation_row_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v130

    .line 2919
    .restart local v130    # "conversationObjectId":J
    move-wide/from16 v0, v130

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getConversationRemoteId(J)J

    move-result-wide v92

    .line 2920
    .restart local v92    # "conversationId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "conversations"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v92 .. v93}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "ignored"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2925
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2926
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v83

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v85, v0

    const/16 v86, 0x0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v88, v0

    move-object/from16 v84, v26

    move-object/from16 v87, v29

    invoke-static/range {v83 .. v88}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2928
    move-wide/from16 v0, v92

    move-wide/from16 v2, v130

    invoke-virtual {v12, v0, v1, v2, v3}, Lco/vine/android/provider/VineDatabaseHelper;->deleteConversation(JJ)V

    goto/16 :goto_0

    .line 2932
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v92    # "conversationId":J
    .end local v130    # "conversationObjectId":J
    :sswitch_5d
    const-string v6, "conversation_row_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v130

    .line 2933
    .restart local v130    # "conversationObjectId":J
    move-wide/from16 v0, v130

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getConversationRemoteId(J)J

    move-result-wide v92

    .line 2934
    .restart local v92    # "conversationId":J
    move-wide/from16 v0, v130

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->getLastMessageIdInConversation(J)J

    move-result-wide v69

    .line 2935
    .restart local v69    # "messageId":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "conversations"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v92 .. v93}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2939
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const-wide/16 v16, 0x0

    cmp-long v6, v69, v16

    if-lez v6, :cond_7d

    .line 2940
    const-string v6, "lastMessageId"

    move-object/from16 v0, v26

    move-wide/from16 v1, v69

    invoke-static {v0, v6, v1, v2}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;J)V

    .line 2942
    :cond_7d
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2943
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2945
    move-wide/from16 v0, v92

    move-wide/from16 v2, v130

    invoke-virtual {v12, v0, v1, v2, v3}, Lco/vine/android/provider/VineDatabaseHelper;->deleteConversation(JJ)V

    goto/16 :goto_0

    .line 2949
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v69    # "messageId":J
    .end local v92    # "conversationId":J
    .end local v130    # "conversationObjectId":J
    :sswitch_5e
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 2950
    .restart local v10    # "userId":J
    const-string v6, "block_profile_reposts"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v160

    .line 2951
    .local v160, "hide":Z
    move/from16 v0, v160

    invoke-virtual {v12, v10, v11, v0}, Lco/vine/android/provider/VineDatabaseHelper;->setShouldHideProfileRevines(JZ)Z

    goto/16 :goto_0

    .line 2955
    .end local v10    # "userId":J
    .end local v160    # "hide":Z
    :sswitch_5f
    const-string v6, "message"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v64

    check-cast v64, Lco/vine/android/api/VinePrivateMessage;

    .line 2956
    .restart local v64    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 2957
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "date"

    move-object/from16 v0, v64

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    move-wide/from16 v16, v0

    const-string v19, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    move-wide/from16 v0, v16

    move-object/from16 v2, v19

    invoke-static {v0, v1, v2}, Lco/vine/android/util/DateTimeUtil;->getTimeInStringFromMs(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2958
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x5

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "conversations"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    move-object/from16 v0, v64

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "messages"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    move-object/from16 v0, v64

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x4

    const-string v17, "viewed"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2964
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2965
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2968
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-nez v6, :cond_1

    .line 2969
    const-string v6, "Failed to send view receipt for {}."

    move-object/from16 v0, v64

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    invoke-static {v6, v13}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    .line 2970
    move-object/from16 v0, v64

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v64

    iget-wide v0, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    move-wide/from16 v19, v0

    move-wide/from16 v0, v16

    move-wide/from16 v2, v19

    invoke-virtual {v12, v0, v1, v2, v3}, Lco/vine/android/provider/VineDatabaseHelper;->updateMessageLoopStartTime(JJ)V

    goto/16 :goto_0

    .line 2975
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v64    # "vpm":Lco/vine/android/api/VinePrivateMessage;
    :sswitch_60
    invoke-virtual {v12}, Lco/vine/android/provider/VineDatabaseHelper;->getMessagesThatWereViewed()Ljava/util/ArrayList;

    move-result-object v185

    .line 2976
    .local v185, "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;>;"
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 2977
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    invoke-virtual/range {v185 .. v185}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_35
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v187

    check-cast v187, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;

    .line 2978
    .local v187, "msg":Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;
    invoke-virtual/range {v28 .. v28}, Ljava/util/ArrayList;->clear()V

    .line 2979
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "date"

    move-object/from16 v0, v187

    iget-wide v0, v0, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;->localStartTime:J

    move-wide/from16 v16, v0

    const-string v19, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    move-wide/from16 v0, v16

    move-object/from16 v2, v19

    invoke-static {v0, v1, v2}, Lco/vine/android/util/DateTimeUtil;->getTimeInStringFromMs(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2980
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x5

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "conversations"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    move-object/from16 v0, v187

    iget-wide v0, v0, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;->conversationId:J

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "messages"

    aput-object v17, v13, v16

    const/16 v16, 0x3

    move-object/from16 v0, v187

    iget-wide v0, v0, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;->messageId:J

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x4

    const-string v17, "viewed"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 2986
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 2987
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 2990
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_7e

    .line 2991
    const-wide/16 v16, 0x0

    move-object/from16 v0, v187

    iget-wide v0, v0, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;->messageId:J

    move-wide/from16 v19, v0

    move-wide/from16 v0, v16

    move-wide/from16 v2, v19

    invoke-virtual {v12, v0, v1, v2, v3}, Lco/vine/android/provider/VineDatabaseHelper;->updateMessageLoopStartTime(JJ)V

    goto/16 :goto_35

    .line 2993
    :cond_7e
    const-string v6, "Failed to send view receipt for {}."

    move-object/from16 v0, v187

    iget-wide v0, v0, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;->messageId:J

    move-wide/from16 v16, v0

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    invoke-static {v6, v13}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    goto/16 :goto_35

    .line 2999
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v185    # "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;>;"
    .end local v187    # "msg":Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;
    :sswitch_61
    invoke-virtual {v12}, Lco/vine/android/provider/VineDatabaseHelper;->removeAccount()V

    goto/16 :goto_0

    .line 3003
    :sswitch_62
    const-string v6, "vanity_url"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    move-object/16 v277, v0

    .line 3004
    .local v277, "vanityUrlSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "profiles"

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "vanity"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3010
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    invoke-virtual/range {v277 .. v277}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v162

    .restart local v162    # "i$":Ljava/util/Iterator;
    :goto_36
    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_7f

    invoke-interface/range {v162 .. v162}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v210

    check-cast v210, Ljava/lang/String;

    .line 3011
    .restart local v210    # "pathSegment":Ljava/lang/String;
    invoke-virtual/range {v26 .. v26}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, " "

    const-string v19, "%20"

    move-object/from16 v0, v210

    move-object/from16 v1, v17

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3012
    goto :goto_36

    .line 3014
    .end local v210    # "pathSegment":Ljava/lang/String;
    :cond_7f
    const/4 v6, 0x2

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3015
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3019
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 3020
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v0

    move-object/16 v261, v0

    move-object/from16 v0, v261

    check-cast v0, Lco/vine/android/api/VineUser;

    move-object/16 v261, v0

    .line 3021
    .restart local v261    # "user":Lco/vine/android/api/VineUser;
    const-string v6, "user_id"

    move-object/from16 v0, v261

    iget-wide v0, v0, Lco/vine/android/api/VineUser;->userId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, p2

    move-wide/from16 v1, v16

    invoke-virtual {v0, v6, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto/16 :goto_0

    .line 3026
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v162    # "i$":Ljava/util/Iterator;
    .end local v261    # "user":Lco/vine/android/api/VineUser;
    .end local v277    # "vanityUrlSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :sswitch_63
    const-string v6, "phone"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v211

    .line 3027
    .restart local v211    # "phone":Ljava/lang/String;
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v163

    .line 3028
    .local v163, "id":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v163 .. v164}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3031
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3033
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x2

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 3034
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "phoneNumber"

    move-object/from16 v0, v211

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3035
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "verifyPhoneNumber"

    const/16 v16, 0x1

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3037
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3040
    goto/16 :goto_0

    .line 3043
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v163    # "id":J
    .end local v211    # "phone":Ljava/lang/String;
    :sswitch_64
    const-string v6, "key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v125

    .line 3044
    .local v125, "code":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "verifyPhoneNumber"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3047
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3049
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x1

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 3050
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "t"

    move-object/from16 v0, v125

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3052
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v27, v0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v25 .. v30}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3054
    goto/16 :goto_0

    .line 3057
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v125    # "code":Ljava/lang/String;
    :sswitch_65
    const-string v6, "key"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v125

    .line 3058
    .restart local v125    # "code":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    const-string v17, "verifyEmail"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3061
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3063
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x1

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 3064
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "t"

    move-object/from16 v0, v125

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3066
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v25

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v27, v0

    const/4 v6, 0x0

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v25 .. v30}, Lco/vine/android/network/HttpOperation;->createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3068
    goto/16 :goto_0

    .line 3071
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v125    # "code":Ljava/lang/String;
    :sswitch_66
    const-string v6, "email"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v143

    .line 3072
    .restart local v143    # "email":Ljava/lang/String;
    const-string v6, "user_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v163

    .line 3073
    .restart local v163    # "id":J
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v163 .. v164}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3076
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    const/4 v6, 0x2

    move-object/from16 v0, v28

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 3077
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "email"

    move-object/from16 v0, v143

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3078
    new-instance v6, Lorg/apache/http/message/BasicNameValuePair;

    const-string v13, "verifyEmail"

    const/16 v16, 0x1

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v13, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3080
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3082
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3084
    goto/16 :goto_0

    .line 3087
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v143    # "email":Ljava/lang/String;
    .end local v163    # "id":J
    :sswitch_67
    const-string v6, "conversation_row_id"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v16

    move-wide/from16 v0, v16

    invoke-virtual {v12, v0, v1}, Lco/vine/android/provider/VineDatabaseHelper;->clearUnreadCount(J)V

    goto/16 :goto_0

    .line 3091
    :sswitch_68
    const-string v6, "upload"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    move-object/16 v259, v0

    move-object/from16 v0, v259

    check-cast v0, Lco/vine/android/api/VineUpload;

    move-object/16 v259, v0

    .line 3092
    .restart local v259    # "upload":Lco/vine/android/api/VineUpload;
    move-object/from16 v0, p0

    move-object/from16 v1, v127

    move-object/from16 v2, v259

    move-object/from16 v3, p2

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/service/VineService;->post(Landroid/content/Context;Lco/vine/android/api/VineUpload;Landroid/os/Bundle;)Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3093
    const-string v6, "upload"

    move-object/from16 v0, p2

    move-object/from16 v1, v259

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 3097
    .end local v259    # "upload":Lco/vine/android/api/VineUpload;
    :sswitch_69
    const-string v6, "accept_oon"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v105

    .line 3098
    .local v105, "acceptOon":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3101
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 3102
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v13, Lorg/apache/http/message/BasicNameValuePair;

    const-string v16, "acceptsOutOfNetworkConversations"

    if-eqz v105, :cond_80

    const-string v6, "1"

    :goto_37
    move-object/from16 v0, v16

    invoke-direct {v13, v0, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3105
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3106
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3108
    goto/16 :goto_0

    .line 3102
    :cond_80
    const-string v6, "0"

    goto :goto_37

    .line 3111
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v105    # "acceptOon":Z
    :sswitch_6a
    const-string v6, "enable"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v145

    .line 3112
    .local v145, "enableAddressBook":Z
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "preferences"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3115
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 3116
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v13, Lorg/apache/http/message/BasicNameValuePair;

    const-string v16, "disableAddressBook"

    if-eqz v145, :cond_81

    const-string v6, "0"

    :goto_38
    move-object/from16 v0, v16

    invoke-direct {v13, v0, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3119
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3120
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3122
    goto/16 :goto_0

    .line 3116
    :cond_81
    const-string v6, "1"

    goto :goto_38

    .line 3125
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v145    # "enableAddressBook":Z
    :sswitch_6b
    const-string v6, "enable"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v144

    .line 3126
    .local v144, "enable":Z
    const-string v6, "type"

    move-object/from16 v0, p2

    invoke-virtual {v0, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v255

    .line 3127
    .restart local v255    # "type":I
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "users"

    aput-object v17, v13, v16

    const/16 v16, 0x1

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    aput-object v17, v13, v16

    const/16 v16, 0x2

    const-string v17, "preferences"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3131
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    if-nez v255, :cond_82

    .line 3132
    const-string v207, "hiddenEmail"

    .line 3137
    .local v207, "param":Ljava/lang/String;
    :goto_39
    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    .line 3138
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v13, Lorg/apache/http/message/BasicNameValuePair;

    if-eqz v144, :cond_83

    const-string v6, "0"

    :goto_3a
    move-object/from16 v0, v207

    invoke-direct {v13, v0, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v28

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3140
    const/4 v6, 0x1

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3141
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move-object/from16 v2, v29

    invoke-static {v6, v0, v13, v1, v2}, Lco/vine/android/network/HttpOperation;->createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3143
    goto/16 :goto_0

    .line 3134
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v207    # "param":Ljava/lang/String;
    :cond_82
    const-string v207, "hiddenPhoneNumber"

    .restart local v207    # "param":Ljava/lang/String;
    goto :goto_39

    .line 3138
    .restart local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    :cond_83
    const-string v6, "1"

    goto :goto_3a

    .line 3146
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v28    # "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    .end local v144    # "enable":Z
    .end local v207    # "param":Ljava/lang/String;
    .end local v255    # "type":I
    :sswitch_6c
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getConfigUrl()Ljava/lang/String;

    move-result-object v6

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/16 v16, 0x0

    const-string v17, "clientflags"

    aput-object v17, v13, v16

    invoke-static {v6, v13}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v26

    .line 3149
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    const/16 v6, 0x1d

    invoke-static {v6}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v29

    .line 3150
    invoke-static/range {v127 .. v127}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/service/VineService;->mApi:Lco/vine/android/client/VineAPI;

    move-object/from16 v0, v26

    move-object/from16 v1, v29

    invoke-static {v6, v0, v13, v1}, Lco/vine/android/network/HttpOperation;->createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v202

    .line 3153
    invoke-virtual/range {v202 .. v202}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 3154
    invoke-virtual/range {v29 .. v29}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v124

    check-cast v124, Lco/vine/android/api/VineClientFlags;

    .line 3155
    .local v124, "clientFlags":Lco/vine/android/api/VineClientFlags;
    const-string v6, "client_flags"

    move-object/from16 v0, p2

    move-object/from16 v1, v124

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 3161
    .end local v26    # "url":Ljava/lang/StringBuilder;
    .end local v124    # "clientFlags":Lco/vine/android/api/VineClientFlags;
    :sswitch_6d
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/service/VineService;->mHttpRequests:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v6}, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v169

    .line 3162
    .local v169, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lorg/apache/http/client/methods/HttpRequestBase;>;"
    :goto_3b
    invoke-interface/range {v169 .. v169}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 3163
    invoke-interface/range {v169 .. v169}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v231

    check-cast v231, Lorg/apache/http/client/methods/HttpRequestBase;

    .line 3164
    .local v231, "request":Lorg/apache/http/client/methods/HttpRequestBase;
    if-eqz v231, :cond_84

    invoke-virtual/range {v231 .. v231}, Lorg/apache/http/client/methods/HttpRequestBase;->isAborted()Z

    move-result v6

    if-nez v6, :cond_84

    .line 3165
    invoke-virtual/range {v231 .. v231}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 3167
    :cond_84
    invoke-interface/range {v169 .. v169}, Ljava/util/Iterator;->remove()V

    goto :goto_3b

    .line 3199
    .end local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .end local v43    # "key":Ljava/lang/String;
    .end local v169    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lorg/apache/http/client/methods/HttpRequestBase;>;"
    .restart local v89    # "errorCode":I
    .restart local v239    # "ret":Landroid/os/Bundle;
    :cond_85
    sget-object v6, Lco/vine/android/api/VineError$VineKnownErrors;->INVALID_SESSION:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v6, v6, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    move/from16 v0, v89

    if-eq v0, v6, :cond_86

    sget-object v6, Lco/vine/android/api/VineError$VineKnownErrors;->EXPIRED_SESSION:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v6, v6, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    move/from16 v0, v89

    if-ne v0, v6, :cond_87

    .line 3201
    :cond_86
    const-string v6, "executionCode"

    const/4 v13, 0x2

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto/16 :goto_1

    .line 3204
    :cond_87
    sget-object v6, Lco/vine/android/api/VineError$VineKnownErrors;->CAPTCHA:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v6, v6, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    move/from16 v0, v89

    if-ne v0, v6, :cond_89

    .line 3205
    const-string v6, "executionCode"

    const/4 v13, 0x4

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3206
    const-string v6, "captcha_url"

    move-object/from16 v0, v148

    iget-object v13, v0, Lco/vine/android/api/VineError;->data:Ljava/lang/String;

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 3211
    .end local v89    # "errorCode":I
    .end local v231    # "request":Lorg/apache/http/client/methods/HttpRequestBase;
    :cond_88
    const-string v6, "statusCode"

    move-object/from16 v0, v239

    move/from16 v1, v245

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 3212
    invoke-static/range {v221 .. v221}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_89

    .line 3213
    const-string v6, "reasonPhrase"

    move-object/from16 v0, v239

    move-object/from16 v1, v221

    invoke-virtual {v0, v6, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 3217
    :cond_89
    sget-boolean v6, Lco/vine/android/service/VineService;->LOGGABLE:Z

    if-eqz v6, :cond_8a

    .line 3218
    const-string v6, "{} complete {}, {}"

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-static/range {v245 .. v245}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v16

    move-object/from16 v0, v16

    move-object/from16 v1, v221

    invoke-static {v6, v13, v0, v1}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 3221
    :cond_8a
    const-string v6, "executionCode"

    const/4 v13, 0x1

    move-object/from16 v0, v239

    invoke-virtual {v0, v6, v13}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto/16 :goto_1

    .end local v29    # "vp":Lco/vine/android/api/VineParserReader;
    .end local v239    # "ret":Landroid/os/Bundle;
    .restart local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .restart local v26    # "url":Ljava/lang/StringBuilder;
    .restart local v43    # "key":Ljava/lang/String;
    .restart local v280    # "vp":Lco/vine/android/api/VineParserReader;
    :cond_8b
    move-object/from16 v29, v280

    .end local v280    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v29    # "vp":Lco/vine/android/api/VineParserReader;
    goto/16 :goto_0

    .line 570
    :sswitch_data_0
    .sparse-switch
        0x2 -> :sswitch_0
        0x3 -> :sswitch_1
        0x4 -> :sswitch_2
        0x5 -> :sswitch_a
        0x6 -> :sswitch_b
        0x7 -> :sswitch_c
        0x8 -> :sswitch_e
        0x9 -> :sswitch_f
        0xa -> :sswitch_1a
        0xb -> :sswitch_10
        0xc -> :sswitch_16
        0xd -> :sswitch_14
        0xe -> :sswitch_18
        0xf -> :sswitch_1b
        0x10 -> :sswitch_1c
        0x11 -> :sswitch_1e
        0x12 -> :sswitch_1f
        0x13 -> :sswitch_20
        0x14 -> :sswitch_27
        0x15 -> :sswitch_29
        0x16 -> :sswitch_11
        0x17 -> :sswitch_11
        0x18 -> :sswitch_22
        0x19 -> :sswitch_23
        0x1a -> :sswitch_2b
        0x1b -> :sswitch_2c
        0x1c -> :sswitch_15
        0x1d -> :sswitch_2d
        0x1e -> :sswitch_19
        0x1f -> :sswitch_2e
        0x20 -> :sswitch_2f
        0x21 -> :sswitch_30
        0x22 -> :sswitch_31
        0x23 -> :sswitch_32
        0x24 -> :sswitch_33
        0x25 -> :sswitch_34
        0x26 -> :sswitch_35
        0x27 -> :sswitch_4d
        0x28 -> :sswitch_50
        0x29 -> :sswitch_36
        0x2a -> :sswitch_38
        0x2b -> :sswitch_37
        0x2c -> :sswitch_7
        0x2d -> :sswitch_8
        0x2e -> :sswitch_3b
        0x2f -> :sswitch_3c
        0x30 -> :sswitch_3d
        0x31 -> :sswitch_3e
        0x32 -> :sswitch_3f
        0x33 -> :sswitch_40
        0x34 -> :sswitch_41
        0x35 -> :sswitch_42
        0x36 -> :sswitch_24
        0x37 -> :sswitch_25
        0x38 -> :sswitch_26
        0x39 -> :sswitch_43
        0x3a -> :sswitch_39
        0x3b -> :sswitch_3a
        0x3c -> :sswitch_44
        0x3d -> :sswitch_45
        0x3e -> :sswitch_48
        0x3f -> :sswitch_49
        0x40 -> :sswitch_4b
        0x41 -> :sswitch_4c
        0x42 -> :sswitch_51
        0x43 -> :sswitch_52
        0x44 -> :sswitch_53
        0x45 -> :sswitch_54
        0x46 -> :sswitch_17
        0x47 -> :sswitch_2a
        0x4a -> :sswitch_55
        0x4c -> :sswitch_5b
        0x4d -> :sswitch_5a
        0x4f -> :sswitch_5c
        0x50 -> :sswitch_5d
        0x51 -> :sswitch_28
        0x52 -> :sswitch_13
        0x54 -> :sswitch_5f
        0x55 -> :sswitch_60
        0x56 -> :sswitch_62
        0x57 -> :sswitch_5e
        0x58 -> :sswitch_3
        0x59 -> :sswitch_63
        0x5a -> :sswitch_64
        0x5b -> :sswitch_6
        0x5c -> :sswitch_66
        0x5d -> :sswitch_57
        0x5e -> :sswitch_67
        0x5f -> :sswitch_59
        0x60 -> :sswitch_4a
        0x61 -> :sswitch_47
        0x62 -> :sswitch_68
        0x63 -> :sswitch_4d
        0x64 -> :sswitch_58
        0x65 -> :sswitch_1d
        0x66 -> :sswitch_46
        0x67 -> :sswitch_d
        0x68 -> :sswitch_56
        0x69 -> :sswitch_69
        0x6a -> :sswitch_6a
        0x6b -> :sswitch_21
        0x6c -> :sswitch_6b
        0x6d -> :sswitch_65
        0x6e -> :sswitch_12
        0x6f -> :sswitch_6c
        0x70 -> :sswitch_6d
        0x71 -> :sswitch_5
        0x72 -> :sswitch_4
        0x73 -> :sswitch_61
        0x3e8 -> :sswitch_9
    .end sparse-switch

    .line 757
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch

    .line 899
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
    .end packed-switch

    .line 1294
    :pswitch_data_2
    .packed-switch 0x1
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch

    .line 1886
    :pswitch_data_3
    .packed-switch 0x1
        :pswitch_6
    .end packed-switch

    .line 2059
    :pswitch_data_4
    .packed-switch 0x1
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch

    .line 2142
    :pswitch_data_5
    .packed-switch 0x1
        :pswitch_a
        :pswitch_b
        :pswitch_c
    .end packed-switch

    .line 2321
    :pswitch_data_6
    .packed-switch 0x1
        :pswitch_d
        :pswitch_d
        :pswitch_e
    .end packed-switch

    .line 2593
    :sswitch_data_1
    .sparse-switch
        0x27 -> :sswitch_4f
        0x63 -> :sswitch_4e
    .end sparse-switch

    .line 2858
    :pswitch_data_7
    .packed-switch 0x1
        :pswitch_f
        :pswitch_10
        :pswitch_11
    .end packed-switch
.end method

.method public limitCommentAndLikesIfNeeded(Ljava/lang/StringBuilder;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/StringBuilder;

    .prologue
    const/4 v1, 0x0

    .line 3564
    invoke-static {p0}, Lco/vine/android/util/BuildUtil;->isOldDeviceOrLowEndDevice(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3565
    const-string v0, "c_max"

    invoke-static {p1, v0, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3566
    const-string v0, "l_max"

    invoke-static {p1, v0, v1}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;I)V

    .line 3568
    :cond_0
    return-void
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 490
    iget-object v0, p0, Lco/vine/android/service/VineService;->mMessenger:Landroid/os/Messenger;

    invoke-virtual {v0}, Landroid/os/Messenger;->getBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()V
    .locals 4

    .prologue
    .line 495
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 496
    invoke-static {}, Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/VineService;->mExecutor:Ljava/util/concurrent/ExecutorService;

    .line 497
    new-instance v0, Ljava/util/LinkedHashMap;

    const/16 v1, 0x32

    const/high16 v2, 0x42480000    # 50.0f

    invoke-direct {v0, v1, v2}, Ljava/util/LinkedHashMap;-><init>(IF)V

    iput-object v0, p0, Lco/vine/android/service/VineService;->mStartIds:Ljava/util/LinkedHashMap;

    .line 498
    iget-object v0, p0, Lco/vine/android/service/VineService;->mServiceBroadCastReceiver:Landroid/content/BroadcastReceiver;

    sget-object v1, Lco/vine/android/service/VineService;->SERVICE_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v2, "co.vine.android.BROADCAST"

    const/4 v3, 0x0

    invoke-virtual {p0, v0, v1, v2, v3}, Lco/vine/android/service/VineService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 499
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 503
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 504
    iget-object v0, p0, Lco/vine/android/service/VineService;->mServiceBroadCastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lco/vine/android/service/VineService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 505
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 10
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 521
    invoke-direct {p0}, Lco/vine/android/service/VineService;->init()V

    .line 522
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 523
    .local v4, "bundle":Landroid/os/Bundle;
    const-string v0, "ibinder"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v8

    check-cast v8, Lco/vine/android/service/VineServiceCallback;

    .line 525
    .local v8, "cb":Lco/vine/android/service/VineServiceCallback;
    if-eqz v8, :cond_1

    .line 526
    invoke-virtual {v8}, Lco/vine/android/service/VineServiceCallback;->getResponder()Lco/vine/android/service/VineServiceResponder;

    move-result-object v5

    .line 530
    .local v5, "responder":Lco/vine/android/service/VineServiceResponder;
    :goto_0
    sget-object v0, Lco/vine/android/service/VineService;->sActionMap:Ljava/util/HashMap;

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    .line 531
    .local v7, "action":Ljava/lang/Integer;
    if-nez v7, :cond_2

    .line 532
    sget-boolean v0, Lco/vine/android/service/VineService;->LOGGABLE:Z

    if-eqz v0, :cond_0

    .line 533
    const-string v0, "VineService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown action: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 541
    :cond_0
    :goto_1
    const/4 v0, 0x2

    return v0

    .line 528
    .end local v5    # "responder":Lco/vine/android/service/VineServiceResponder;
    .end local v7    # "action":Ljava/lang/Integer;
    :cond_1
    const/4 v5, 0x0

    .restart local v5    # "responder":Lco/vine/android/service/VineServiceResponder;
    goto :goto_0

    .line 535
    .restart local v7    # "action":Ljava/lang/Integer;
    :cond_2
    if-nez v4, :cond_3

    .line 536
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Intent must contain extras: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 538
    :cond_3
    iget-object v9, p0, Lco/vine/android/service/VineService;->mExecutor:Ljava/util/concurrent/ExecutorService;

    new-instance v0, Lco/vine/android/service/VineService$ExecutionRunnable;

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v3

    const/4 v6, 0x0

    move-object v1, p0

    move v2, p3

    invoke-direct/range {v0 .. v6}, Lco/vine/android/service/VineService$ExecutionRunnable;-><init>(Lco/vine/android/service/VineService;IILandroid/os/Bundle;Lco/vine/android/service/VineServiceResponder;Landroid/os/Messenger;)V

    invoke-interface {v9, v0}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 539
    iget-object v0, p0, Lco/vine/android/service/VineService;->mStartIds:Ljava/util/LinkedHashMap;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method

.method public declared-synchronized post(Landroid/content/Context;Lco/vine/android/api/VineUpload;Landroid/os/Bundle;)Lco/vine/android/network/HttpOperation;
    .locals 29
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "upload"    # Lco/vine/android/api/VineUpload;
    .param p3, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 3257
    monitor-enter p0

    :try_start_0
    invoke-static/range {p1 .. p1}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v8

    .line 3258
    .local v8, "api":Lco/vine/android/client/VineAPI;
    new-instance v18, Ljava/util/HashMap;

    invoke-direct/range {v18 .. v18}, Ljava/util/HashMap;-><init>()V

    .line 3259
    .local v18, "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual/range {p2 .. p2}, Lco/vine/android/api/VineUpload;->getPostInfo()Lco/vine/android/api/VineUpload$PostInfo;

    move-result-object v5

    .line 3260
    .local v5, "info":Lco/vine/android/api/VineUpload$PostInfo;
    move-object/from16 v0, p2

    iget-object v0, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    move-object/from16 v17, v0

    .line 3261
    .local v17, "path":Ljava/lang/String;
    move-object/from16 v0, p2

    iget-boolean v15, v0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    .line 3263
    .local v15, "isPrivate":Z
    if-nez p2, :cond_1

    .line 3264
    const-string v2, "VineService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Post failed: UploadManager returned a null upload for path="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3265
    const/16 v16, 0x0

    .line 3371
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v16

    .line 3268
    :cond_1
    :try_start_1
    invoke-virtual/range {p2 .. p2}, Lco/vine/android/api/VineUpload;->getUris()[Ljava/lang/String;

    move-result-object v22

    .line 3270
    .local v22, "uris":[Ljava/lang/String;
    invoke-static/range {p1 .. p1}, Lco/vine/android/util/MediaUtility;->getUploadType(Landroid/content/Context;)I

    move-result v21

    .line 3272
    .local v21, "uploadType":I
    packed-switch v21, :pswitch_data_0

    .line 3279
    const-string v19, ""

    .line 3285
    .local v19, "prefix":Ljava/lang/String;
    :goto_1
    move-object/from16 v0, p2

    iget-object v2, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 3286
    move-object/from16 v0, p2

    iget-object v2, v0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-static {v2}, Lco/vine/android/util/UploadManager;->getVersionFromPath(Ljava/lang/String;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v24

    .line 3287
    .local v24, "version":Lco/vine/android/recorder/RecordSessionVersion;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x0

    aget-object v3, v22, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 3288
    .local v25, "videoUrl":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x1

    aget-object v3, v22, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    .line 3289
    .local v20, "thumbnailUrl":Ljava/lang/String;
    sget-object v2, Lco/vine/android/recorder/RecordSessionVersion;->SW_WEBM:Lco/vine/android/recorder/RecordSessionVersion;

    move-object/from16 v0, v24

    if-ne v0, v2, :cond_4

    .line 3290
    const-string v2, "videoWebmUrl"

    move-object/from16 v0, v18

    move-object/from16 v1, v25

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3294
    :goto_2
    const-string v2, "thumbnailUrl"

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3295
    const-string v2, "model"

    sget-object v3, Landroid/os/Build;->MODEL:Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3296
    const-string v2, "device"

    sget-object v3, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3298
    :try_start_2
    const-string v2, "version"

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v7, 0x0

    invoke-virtual {v3, v4, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget v3, v3, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 3306
    .end local v20    # "thumbnailUrl":Ljava/lang/String;
    .end local v24    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    .end local v25    # "videoUrl":Ljava/lang/String;
    :cond_2
    :goto_3
    if-nez v15, :cond_5

    .line 3307
    :try_start_3
    invoke-virtual {v8}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v7, "posts"

    aput-object v7, v3, v4

    invoke-static {v2, v3}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 3308
    .local v23, "url":Ljava/lang/StringBuilder;
    const/16 v2, 0xc

    invoke-static {v2}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v6

    .line 3309
    .local v6, "vp":Lco/vine/android/api/VineParserReader;
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-direct {v0, v1, v5}, Lco/vine/android/service/VineService;->insertVinePostBody(Ljava/util/HashMap;Lco/vine/android/api/VineUpload$PostInfo;)V

    .line 3328
    :goto_4
    const-string v2, "Prefix {}"

    move-object/from16 v0, v19

    invoke-static {v2, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 3329
    const-string v2, "Adding URI Params: {}, {}."

    const/4 v3, 0x0

    aget-object v3, v22, v3

    const/4 v4, 0x1

    aget-object v4, v22, v4

    invoke-static {v2, v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 3330
    invoke-static/range {p1 .. p1}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v9

    .line 3331
    .local v9, "client":Lco/vine/android/network/ThreadedHttpOperationClient;
    move-object/from16 v0, v23

    move-object/from16 v1, v18

    invoke-static {v9, v0, v8, v1, v6}, Lco/vine/android/network/HttpOperation;->createBasicAuthJsonPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/HashMap;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v16

    .line 3333
    .local v16, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual/range {v16 .. v16}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v2

    if-eqz v2, :cond_a

    .line 3334
    if-nez v15, :cond_9

    .line 3335
    invoke-virtual {v6}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Lco/vine/android/api/VinePostResponse;

    .line 3337
    .local v26, "vpr":Lco/vine/android/api/VinePostResponse;
    if-nez v26, :cond_8

    .line 3338
    const/16 v16, 0x0

    goto/16 :goto_0

    .line 3274
    .end local v6    # "vp":Lco/vine/android/api/VineParserReader;
    .end local v9    # "client":Lco/vine/android/network/ThreadedHttpOperationClient;
    .end local v16    # "op":Lco/vine/android/network/HttpOperation;
    .end local v19    # "prefix":Ljava/lang/String;
    .end local v23    # "url":Ljava/lang/StringBuilder;
    .end local v26    # "vpr":Lco/vine/android/api/VinePostResponse;
    :pswitch_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8}, Lco/vine/android/client/VineAPI;->getAmazonUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/service/VineService;->mAmazonBucket:Ljava/lang/String;

    if-eqz v2, :cond_3

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/service/VineService;->mAmazonBucket:Ljava/lang/String;

    :goto_5
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    .line 3275
    .restart local v19    # "prefix":Ljava/lang/String;
    goto/16 :goto_1

    .line 3274
    .end local v19    # "prefix":Ljava/lang/String;
    :cond_3
    invoke-static/range {p1 .. p1}, Lco/vine/android/client/Amazon;->getBucket(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    goto :goto_5

    .line 3292
    .restart local v19    # "prefix":Ljava/lang/String;
    .restart local v20    # "thumbnailUrl":Ljava/lang/String;
    .restart local v24    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    .restart local v25    # "videoUrl":Ljava/lang/String;
    :cond_4
    const-string v2, "videoUrl"

    move-object/from16 v0, v18

    move-object/from16 v1, v25

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_2

    .line 3257
    .end local v5    # "info":Lco/vine/android/api/VineUpload$PostInfo;
    .end local v8    # "api":Lco/vine/android/client/VineAPI;
    .end local v15    # "isPrivate":Z
    .end local v17    # "path":Ljava/lang/String;
    .end local v18    # "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v19    # "prefix":Ljava/lang/String;
    .end local v20    # "thumbnailUrl":Ljava/lang/String;
    .end local v21    # "uploadType":I
    .end local v22    # "uris":[Ljava/lang/String;
    .end local v24    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    .end local v25    # "videoUrl":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 3311
    .restart local v5    # "info":Lco/vine/android/api/VineUpload$PostInfo;
    .restart local v8    # "api":Lco/vine/android/client/VineAPI;
    .restart local v15    # "isPrivate":Z
    .restart local v17    # "path":Ljava/lang/String;
    .restart local v18    # "postBody":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local v19    # "prefix":Ljava/lang/String;
    .restart local v21    # "uploadType":I
    .restart local v22    # "uris":[Ljava/lang/String;
    :cond_5
    :try_start_4
    invoke-virtual {v8}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v7, "conversations"

    aput-object v7, v3, v4

    invoke-static {v2, v3}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 3312
    .restart local v23    # "url":Ljava/lang/StringBuilder;
    invoke-static/range {p1 .. p1}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v12

    .line 3313
    .local v12, "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    move-object/from16 v0, p2

    iget-wide v2, v0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    invoke-virtual {v12, v2, v3}, Lco/vine/android/provider/VineDatabaseHelper;->getConversationRemoteId(J)J

    move-result-wide v10

    .line 3315
    .local v10, "conversationId":J
    const-wide/16 v2, 0x0

    cmp-long v2, v10, v2

    if-lez v2, :cond_7

    .line 3316
    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v3, v4

    invoke-static {v2, v3}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 3323
    :cond_6
    :goto_6
    const/16 v2, 0x18

    invoke-static {v2}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v6

    .line 3324
    .restart local v6    # "vp":Lco/vine/android/api/VineParserReader;
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-direct {v0, v1, v5, v10, v11}, Lco/vine/android/service/VineService;->insertVineMessageBody(Ljava/util/HashMap;Lco/vine/android/api/VineUpload$PostInfo;J)V

    .line 3325
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineService;->addCountryParam(Ljava/util/HashMap;)V

    goto/16 :goto_4

    .line 3317
    .end local v6    # "vp":Lco/vine/android/api/VineParserReader;
    :cond_7
    iget-object v2, v5, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    if-nez v2, :cond_6

    .line 3318
    move-object/from16 v0, p2

    iget-wide v2, v0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    const-wide/16 v27, 0x0

    cmp-long v2, v2, v27

    if-lez v2, :cond_6

    .line 3319
    move-object/from16 v0, p2

    iget-wide v2, v0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    invoke-virtual {v12, v2, v3}, Lco/vine/android/provider/VineDatabaseHelper;->getConversationRecipientsFromConversationRowId(J)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v5, Lco/vine/android/api/VineUpload$PostInfo;->recipients:Ljava/util/ArrayList;

    goto :goto_6

    .line 3341
    .end local v10    # "conversationId":J
    .end local v12    # "dbHelper":Lco/vine/android/provider/VineDatabaseHelper;
    .restart local v6    # "vp":Lco/vine/android/api/VineParserReader;
    .restart local v9    # "client":Lco/vine/android/network/ThreadedHttpOperationClient;
    .restart local v16    # "op":Lco/vine/android/network/HttpOperation;
    .restart local v26    # "vpr":Lco/vine/android/api/VinePostResponse;
    :cond_8
    new-instance v14, Landroid/content/Intent;

    const-string v2, "co.vine.android.service.mergePost"

    invoke-direct {v14, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 3342
    .local v14, "intent":Landroid/content/Intent;
    const-string v2, "post"

    move-object/from16 v0, v26

    invoke-virtual {v14, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 3343
    const-string v2, "Regular video post successful, sending merge broadcast now"

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 3344
    const-string v2, "co.vine.android.BROADCAST"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto/16 :goto_0

    .end local v14    # "intent":Landroid/content/Intent;
    .end local v26    # "vpr":Lco/vine/android/api/VinePostResponse;
    :cond_9
    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v7, p3

    .line 3346
    invoke-direct/range {v2 .. v7}, Lco/vine/android/service/VineService;->handleVinePrivateMessageResponses(Landroid/content/Context;Lco/vine/android/api/VineUpload;Lco/vine/android/api/VineUpload$PostInfo;Lco/vine/android/api/VineParserReader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 3349
    :cond_a
    invoke-virtual {v6}, Lco/vine/android/api/VineParserReader;->getParsedObject()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lco/vine/android/api/VineError;

    .line 3350
    .local v13, "error":Lco/vine/android/api/VineError;
    if-eqz v13, :cond_c

    .line 3351
    const-string v2, "ERROR POSTING: {} {}"

    move-object/from16 v0, v16

    iget v3, v0, Lco/vine/android/network/HttpOperation;->statusCode:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iget-object v4, v13, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    invoke-static {v2, v3, v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 3352
    iget v2, v13, Lco/vine/android/api/VineError;->errorCode:I

    sget-object v3, Lco/vine/android/api/VineError$VineKnownErrors;->CAPTCHA:Lco/vine/android/api/VineError$VineKnownErrors;

    iget v3, v3, Lco/vine/android/api/VineError$VineKnownErrors;->code:I

    if-ne v2, v3, :cond_b

    .line 3353
    iget-object v2, v13, Lco/vine/android/api/VineError;->data:Ljava/lang/String;

    move-object/from16 v0, p2

    iput-object v2, v0, Lco/vine/android/api/VineUpload;->captchaUrl:Ljava/lang/String;

    .line 3354
    move-object/from16 v0, p2

    iget-boolean v2, v0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    if-eqz v2, :cond_b

    .line 3355
    invoke-static/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v2

    move-object/from16 v0, p2

    iget-wide v3, v0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    iget v7, v13, Lco/vine/android/api/VineError;->errorCode:I

    const v27, 0x7f0e013b

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v27

    invoke-virtual {v2, v3, v4, v7, v0}, Lco/vine/android/provider/VineDatabaseHelper;->setMessageError(JILjava/lang/String;)V

    .line 3359
    :cond_b
    move-object/from16 v0, p2

    iget-boolean v2, v0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    if-eqz v2, :cond_0

    .line 3360
    invoke-static/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v2

    move-object/from16 v0, p2

    iget-wide v3, v0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    iget v7, v13, Lco/vine/android/api/VineError;->errorCode:I

    const v27, 0x7f0e013b

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v27

    invoke-virtual {v2, v3, v4, v7, v0}, Lco/vine/android/provider/VineDatabaseHelper;->setMessageError(JILjava/lang/String;)V

    goto/16 :goto_0

    .line 3364
    :cond_c
    move-object/from16 v0, p2

    iget-boolean v2, v0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    if-eqz v2, :cond_d

    .line 3365
    invoke-static/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineDatabaseHelper;

    move-result-object v2

    move-object/from16 v0, p2

    iget-wide v3, v0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    const/4 v7, -0x1

    const v27, 0x7f0e013b

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineService;->getString(I)Ljava/lang/String;

    move-result-object v27

    move-object/from16 v0, v27

    invoke-virtual {v2, v3, v4, v7, v0}, Lco/vine/android/provider/VineDatabaseHelper;->setMessageError(JILjava/lang/String;)V

    .line 3368
    :cond_d
    const-string v2, "VineService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Post failed: Unknown error while posting path="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_0

    .line 3299
    .end local v6    # "vp":Lco/vine/android/api/VineParserReader;
    .end local v9    # "client":Lco/vine/android/network/ThreadedHttpOperationClient;
    .end local v13    # "error":Lco/vine/android/api/VineError;
    .end local v16    # "op":Lco/vine/android/network/HttpOperation;
    .end local v23    # "url":Ljava/lang/StringBuilder;
    .restart local v20    # "thumbnailUrl":Ljava/lang/String;
    .restart local v24    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    .restart local v25    # "videoUrl":Ljava/lang/String;
    :catch_0
    move-exception v2

    goto/16 :goto_3

    .line 3272
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

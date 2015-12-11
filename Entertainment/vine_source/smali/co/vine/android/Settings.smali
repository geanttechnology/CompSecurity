.class public Lco/vine/android/Settings;
.super Ljava/lang/Object;
.source "Settings.java"


# static fields
.field public static final ABOUT:Ljava/lang/String; = "about"

.field public static final ATTRIBUTION:Ljava/lang/String; = "attribution"

.field public static final CLEAR_CACHE:Ljava/lang/String; = "cache"

.field public static final DEFAULT_PROFILE_COLOR:I

.field public static final FEEDBACK:Ljava/lang/String; = "feedback"

.field public static final LOGOUT:Ljava/lang/String; = "logout"

.field public static final PASSWORD:Ljava/lang/String; = "password"

.field public static final PP:Ljava/lang/String; = "pp"

.field public static final PREF_ACCEPT_OON:Ljava/lang/String; = "accept_out_of_network_messages"

.field public static final PREF_AUTHORED_POST_COUNT:Ljava/lang/String; = "profile_authored_post_count"

.field public static final PREF_AVATAR_URL:Ljava/lang/String; = "settings_profile_avatar_url"

.field public static final PREF_COLOR_INDEX:Ljava/lang/String; = "color_index"

.field public static final PREF_CUSTOME_LOCALE_COUNTRY:Ljava/lang/String; = "pref_custom_locale_country"

.field public static final PREF_CUSTOM_LOCALE:Ljava/lang/String; = "pref_custom_locale"

.field public static final PREF_CUSTOM_LOCALE_ENABLED:Ljava/lang/String; = "pref_custom_locale_enabled"

.field public static final PREF_DESCRIPTION:Ljava/lang/String; = "settings_profile_description"

.field public static final PREF_EDITION:Ljava/lang/String; = "settings_edition"

.field public static final PREF_EMAIL:Ljava/lang/String; = "settings_profile_email"

.field public static final PREF_EMAIL_DISCOVERABLE:Ljava/lang/String; = "email_discoverable"

.field public static final PREF_EMAIL_VERIFIED:Ljava/lang/String; = "profile_email_verified"

.field public static final PREF_ENABLE_ADDRESS_BOOK:Ljava/lang/String; = "enable_address_book"

.field public static final PREF_EXPLICIT:Ljava/lang/String; = "settings_explicit"

.field public static final PREF_FOLLOWER_COUNT:Ljava/lang/String; = "profile_follower_count"

.field public static final PREF_FOLLOWING_COUNT:Ljava/lang/String; = "profile_follow_count"

.field public static final PREF_FOLLOW_EDITORS_PICKS:Ljava/lang/String; = "settings_follow_editors_picks"

.field public static final PREF_FOLLOW_REQUEST_COUNT:Ljava/lang/String; = "settings_follow_pref_count"

.field public static final PREF_GINGERBREAD_NOTIF_DISMISSED:Ljava/lang/String; = "pref_gb_notif_dismissed"

.field public static final PREF_HIDE_PROFILE_REPOSTS:Ljava/lang/String; = "profile_hide_reposts"

.field public static final PREF_LAST_CLEANUP:Ljava/lang/String; = "last_cleanup"

.field public static final PREF_LAST_SERVER_STATUS_REFRESH:Ljava/lang/String; = "server_upload_last_refresh"

.field public static final PREF_LIKE_COUNT:Ljava/lang/String; = "profile_like_count"

.field public static final PREF_LOCATION:Ljava/lang/String; = "settings_profile_location"

.field public static final PREF_LOOP_COUNT:Ljava/lang/String; = "profile_loop_count"

.field public static final PREF_LOOP_COUNT_RECORDS:Ljava/lang/String; = "pref_loop_count_records"

.field public static final PREF_MOST_RECENT_UNREAD_MESSAGES_COUNT:Ljava/lang/String; = "pref_mrumc"

.field public static final PREF_NAME:Ljava/lang/String; = "settings_profile_name"

.field public static final PREF_NOTIFICATIONS_ENABLED:Ljava/lang/String; = "pref_notifications_enabled"

.field public static final PREF_NOTIFICATIONS_LIGHT:Ljava/lang/String; = "pref_notifications_light"

.field public static final PREF_NOTIFICATIONS_RINGTONE:Ljava/lang/String; = "pref_notifications_ringtone"

.field public static final PREF_NOTIFICATIONS_SOUND:Ljava/lang/String; = "pref_notifications_sound"

.field public static final PREF_NOTIFICATIONS_VIBRATE:Ljava/lang/String; = "pref_notifications_vibrate"

.field public static final PREF_PHONE:Ljava/lang/String; = "settings_profile_phone"

.field public static final PREF_PHONE_DISCOVERABLE:Ljava/lang/String; = "phone_discoverable"

.field public static final PREF_PHONE_VERIFIED:Ljava/lang/String; = "profile_phone_verified"

.field public static final PREF_POST_COUNT:Ljava/lang/String; = "profile_post_count"

.field public static final PREF_POST_HOME_TIMELINE:Ljava/lang/String; = "post_home_timeline"

.field public static final PREF_POST_HOME_TIMELINE_OFFSET:Ljava/lang/String; = "post_home_timeline_offset"

.field public static final PREF_PRIVATE:Ljava/lang/String; = "settings_private"

.field public static final PREF_PROFILE_BACKGROUND:Ljava/lang/String; = "profile_background"

.field public static final PREF_SAVED_STATE_DATA:Ljava/lang/String; = "pref_saved_state_data"

.field public static final PREF_SERVER_UPLOAD_TYPE:Ljava/lang/String; = "server_upload_type"

.field public static final PREF_TWITTER_CONNECTED:Ljava/lang/String; = "settings_twitter_connected"

.field public static final PREF_UNREAD_MESSAGES_DISMISSED:Ljava/lang/String; = "pref_dismissed"

.field public static final PREF_UNREAD_MESSAGE_COUNT:Ljava/lang/String; = "settings_unread_messages_count"

.field public static final PREF_UNREAD_NOTIFICATION_COUNT:Ljava/lang/String; = "unread_notification_count"

.field public static final PREF_USER_ROW_ID:Ljava/lang/String; = "pref_user_row_id"

.field public static final PROFILE_BACKGROUND_COLORS:[I

.field public static final PROFILE_BACKGROUND_COLOR_DEFAULT_INDEX:I = 0x0

.field public static final TOS:Ljava/lang/String; = "tos"

.field public static final TWITTER:Ljava/lang/String; = "twitter"


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 126
    const/16 v0, 0xa

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    .line 141
    sget-object v0, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    const/4 v1, 0x0

    aget v0, v0, v1

    sput v0, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    return-void

    .line 126
    nop

    :array_0
    .array-data 4
        0x333333
        0xff5967
        0xff794d
        0xffaf40
        0x68bf60
        0x33ccbf
        0x6db0f2
        0x5082e5
        0x7870cc
        0xf279ac
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isNotificationEnabled(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 149
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "pref_notifications_enabled"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

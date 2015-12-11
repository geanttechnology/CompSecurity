.class public Lco/vine/android/client/AppController;
.super Ljava/lang/Object;
.source "AppController.java"

# interfaces
.implements Lco/vine/android/util/image/PhotoImagesListener;
.implements Lco/vine/android/util/video/VideoListener;
.implements Lcom/facebook/Session$StatusCallback;
.implements Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/client/AppController$LoopCountRunnable;,
        Lco/vine/android/client/AppController$ServerStatusRunnable;
    }
.end annotation


# static fields
.field public static final ACTION_ABORT_ALL_REQUESTS:Ljava/lang/String; = "abort_all_requests"

.field private static final ACTION_EDITION_UPDATED:Ljava/lang/String; = "action_edition_updated"

.field public static final ACTION_UPDATED_FILTER:Landroid/content/IntentFilter;

.field private static final CLEANUP_INTERVAL:J = 0x36ee80L

.field private static final INVALIDATE_CACHE_FILTER:Landroid/content/IntentFilter;

.field private static final KEY_FACEBOOK_TOKEN:Ljava/lang/String; = "KEY_FACEBOOK_TOKEN"

.field private static final MIN_LOOP_COUNT_INTERVAL:J = 0xea60L

.field private static final PREF_LAST_USER_ID:Ljava/lang/String; = "last_user_id"

.field public static final PUBLISH_ACTIONS:Ljava/lang/String; = "publish_actions"

.field public static final REQUEST_CODE_TWITTER_SDK:I = 0x1

.field public static final REQUEST_CODE_TWITTER_XAUTH:I = 0x2

.field private static final SERVER_REFRESH_INTERVAL:J = 0x36ee80L

.field public static final SINGLE_FACEBOOK_DIALOG:Z

.field public static final STATUS_CODE_CAPTCHA_FAIL:I = 0x1c7

.field private static final TYPEAHEAD_DEFAULT_FETCH_THRESHOLD:I = 0x2

.field private static final TYPEAHEAD_DEFAULT_MAX_COMPOSE:I = 0x32

.field public static final TYPEAHEAD_DEFAULT_THROTTLE:J = 0x12cL

.field private static final TYPEAHEAD_TAGS_FETCH_THRESHOLD:I = 0x3

.field private static sInstance:Lco/vine/android/client/AppController;


# instance fields
.field final mContext:Landroid/content/Context;

.field private final mHandler:Landroid/os/Handler;

.field private final mInvalidateCacheReceiver:Landroid/content/BroadcastReceiver;

.field private mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/client/AppSessionListener;",
            ">;"
        }
    .end annotation
.end field

.field private mLoopCountRunnable:Lco/vine/android/client/AppController$LoopCountRunnable;

.field private mLoopCountSubmissionInterval:J

.field private final mPhotoImagesCache:Lco/vine/android/util/image/PhotoImagesCache;

.field private mServerStatusRunnable:Lco/vine/android/client/AppController$ServerStatusRunnable;

.field private final mServiceConnection:Lco/vine/android/service/VineServiceConnection;

.field private final mTwitter:Lcom/twitter/android/sdk/Twitter;

.field private final mVideoCache:Lco/vine/android/util/video/VideoCache;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 94
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const-string v1, "SM-C115"

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-ne v0, v1, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v1, "SM-C11"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lco/vine/android/client/AppController;->SINGLE_FACEBOOK_DIALOG:Z

    .line 104
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "action_edition_updated"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    sput-object v0, Lco/vine/android/client/AppController;->ACTION_UPDATED_FILTER:Landroid/content/IntentFilter;

    .line 133
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sput-object v0, Lco/vine/android/client/AppController;->INVALIDATE_CACHE_FILTER:Landroid/content/IntentFilter;

    .line 136
    sget-object v0, Lco/vine/android/client/AppController;->INVALIDATE_CACHE_FILTER:Landroid/content/IntentFilter;

    const-string v1, "co.vine.android.invalidateCache"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 149
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 150
    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_DIRECT_UPLOAD:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 151
    sget-object v0, Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_DIRECT_UPLOAD:Ljava/io/File;

    invoke-static {v0}, Lco/vine/android/player/SaveVideoClicker;->setLongPressSaveDir(Ljava/io/File;)V

    .line 153
    :cond_0
    return-void

    .line 94
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 168
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 139
    new-instance v2, Lco/vine/android/client/AppController$1;

    invoke-direct {v2, p0}, Lco/vine/android/client/AppController$1;-><init>(Lco/vine/android/client/AppController;)V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mInvalidateCacheReceiver:Landroid/content/BroadcastReceiver;

    .line 169
    iput-object p1, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    .line 170
    const-wide/32 v2, 0xea60

    iput-wide v2, p0, Lco/vine/android/client/AppController;->mLoopCountSubmissionInterval:J

    .line 171
    new-instance v2, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    .line 172
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    .line 174
    invoke-static {p1}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/content/Context;)Landroid/graphics/Point;

    move-result-object v1

    .line 175
    .local v1, "p":Landroid/graphics/Point;
    iget v2, v1, Landroid/graphics/Point;->x:I

    iget v3, v1, Landroid/graphics/Point;->y:I

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 176
    .local v0, "maxImageSize":I
    new-instance v2, Lco/vine/android/util/image/PhotoImagesCache;

    const/high16 v3, 0x1e00000

    invoke-direct {v2, p1, v0, v3}, Lco/vine/android/util/image/PhotoImagesCache;-><init>(Landroid/content/Context;II)V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mPhotoImagesCache:Lco/vine/android/util/image/PhotoImagesCache;

    .line 177
    iget-object v2, p0, Lco/vine/android/client/AppController;->mPhotoImagesCache:Lco/vine/android/util/image/PhotoImagesCache;

    invoke-virtual {v2, p0}, Lco/vine/android/util/image/PhotoImagesCache;->addListener(Lco/vine/android/util/image/PhotoImagesListener;)V

    .line 178
    new-instance v2, Lco/vine/android/util/video/VideoCache;

    const/4 v3, 0x0

    invoke-direct {v2, p1, v3}, Lco/vine/android/util/video/VideoCache;-><init>(Landroid/content/Context;I)V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mVideoCache:Lco/vine/android/util/video/VideoCache;

    .line 179
    iget-object v2, p0, Lco/vine/android/client/AppController;->mVideoCache:Lco/vine/android/util/video/VideoCache;

    invoke-virtual {v2, p0}, Lco/vine/android/util/video/VideoCache;->addListener(Lco/vine/android/util/video/VideoListener;)V

    .line 180
    new-instance v2, Lcom/twitter/android/sdk/Twitter;

    sget-object v3, Lco/vine/android/client/TwitterVineApp;->API_KEY:Ljava/lang/String;

    sget-object v4, Lco/vine/android/client/TwitterVineApp;->API_SECRET:Ljava/lang/String;

    invoke-direct {v2, v3, v4}, Lcom/twitter/android/sdk/Twitter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mTwitter:Lcom/twitter/android/sdk/Twitter;

    .line 181
    new-instance v2, Lco/vine/android/client/AppController$ServerStatusRunnable;

    invoke-direct {v2, p0}, Lco/vine/android/client/AppController$ServerStatusRunnable;-><init>(Lco/vine/android/client/AppController;)V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mServerStatusRunnable:Lco/vine/android/client/AppController$ServerStatusRunnable;

    .line 182
    new-instance v2, Lco/vine/android/client/AppController$LoopCountRunnable;

    invoke-direct {v2, p0}, Lco/vine/android/client/AppController$LoopCountRunnable;-><init>(Lco/vine/android/client/AppController;)V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mLoopCountRunnable:Lco/vine/android/client/AppController$LoopCountRunnable;

    .line 183
    const-string v2, "App Controller pid: {}"

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 184
    new-instance v2, Lco/vine/android/service/VineServiceConnection;

    iget-object v3, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-direct {v2, v3, p0}, Lco/vine/android/service/VineServiceConnection;-><init>(Landroid/content/Context;Lco/vine/android/service/VineServiceConnection$ServiceResponseHandler;)V

    iput-object v2, p0, Lco/vine/android/client/AppController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    .line 185
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lco/vine/android/service/VineService;

    invoke-direct {v2, p1, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v3, p0, Lco/vine/android/client/AppController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    const/4 v4, 0x1

    invoke-virtual {p1, v2, v3, v4}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 187
    iget-object v2, p0, Lco/vine/android/client/AppController;->mInvalidateCacheReceiver:Landroid/content/BroadcastReceiver;

    sget-object v3, Lco/vine/android/client/AppController;->INVALIDATE_CACHE_FILTER:Landroid/content/IntentFilter;

    const-string v4, "co.vine.android.BROADCAST"

    const/4 v5, 0x0

    invoke-virtual {p1, v2, v3, v4, v5}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 188
    return-void
.end method

.method private clearAccount()Ljava/lang/String;
    .locals 2

    .prologue
    .line 324
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 325
    .local v0, "b":Landroid/os/Bundle;
    const/16 v1, 0x73

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static clearFileCache(Landroid/content/Context;)V
    .locals 0
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 2139
    invoke-static {p0}, Lco/vine/android/util/Util;->removeCache(Landroid/content/Context;)V

    .line 2140
    invoke-static {p0}, Lco/vine/android/util/image/ImageUtils;->removeFiles(Landroid/content/Context;)V

    .line 2141
    return-void
.end method

.method private createServiceBundle()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 2208
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method private createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;

    .prologue
    .line 2224
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 2225
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-static {v0, p1}, Lco/vine/android/client/AppController;->injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v1

    return-object v1
.end method

.method private createServiceBundleReadOnly()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 2212
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method private executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;
    .locals 1
    .param p1, "actionCode"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 2203
    const-string v0, "Last Service Action Code"

    invoke-static {v0, p1}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;I)V

    .line 2204
    iget-object v0, p0, Lco/vine/android/client/AppController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/service/VineServiceConnection;->queueAndExecute(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getActiveSession(Z)Lco/vine/android/client/Session;
    .locals 1
    .param p1, "readOnly"    # Z

    .prologue
    .line 1543
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lco/vine/android/client/VineAccountHelper;->getActiveSession(Landroid/content/Context;Z)Lco/vine/android/client/Session;

    move-result-object v0

    return-object v0
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 162
    const-class v1, Lco/vine/android/client/AppController;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lco/vine/android/client/AppController;->sInstance:Lco/vine/android/client/AppController;

    if-nez v0, :cond_0

    .line 163
    new-instance v0, Lco/vine/android/client/AppController;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lco/vine/android/client/AppController;-><init>(Landroid/content/Context;)V

    sput-object v0, Lco/vine/android/client/AppController;->sInstance:Lco/vine/android/client/AppController;

    .line 165
    :cond_0
    sget-object v0, Lco/vine/android/client/AppController;->sInstance:Lco/vine/android/client/AppController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 162
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;
    .locals 3
    .param p0, "bundle"    # Landroid/os/Bundle;
    .param p1, "session"    # Lco/vine/android/client/Session;

    .prologue
    .line 2216
    const-string v0, "s_key"

    invoke-virtual {p1}, Lco/vine/android/client/Session;->getSessionKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2217
    const-string v0, "s_owner_id"

    invoke-virtual {p1}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v1

    invoke-virtual {p0, v0, v1, v2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2218
    const-string v0, "a_name"

    invoke-virtual {p1}, Lco/vine/android/client/Session;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2219
    const-string v0, "email"

    invoke-virtual {p1}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2220
    return-object p0
.end method

.method private onLogout()V
    .locals 8

    .prologue
    .line 286
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getLoginStatus()Lco/vine/android/client/Session$LoginStatus;

    move-result-object v4

    sget-object v5, Lco/vine/android/client/Session$LoginStatus;->LOGGED_OUT:Lco/vine/android/client/Session$LoginStatus;

    invoke-virtual {v4, v5}, Lco/vine/android/client/Session$LoginStatus;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 321
    :goto_0
    return-void

    .line 289
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/client/Session;->getSessionKey()Ljava/lang/String;

    move-result-object v1

    .line 292
    .local v1, "cachedKey":Ljava/lang/String;
    iget-object v4, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 293
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->clearDbAll()Ljava/lang/String;

    .line 294
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->clearFileCache()V

    .line 295
    invoke-direct {p0}, Lco/vine/android/client/AppController;->clearAccount()Ljava/lang/String;

    .line 298
    iget-object v4, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    iget-object v5, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v6

    invoke-static {v5, v6, v7, v1}, Lco/vine/android/service/GCMRegistrationService;->getUnregisterIntent(Landroid/content/Context;JLjava/lang/String;)Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 302
    iget-object v4, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    const-string v5, "last_user_id"

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v6

    invoke-interface {v4, v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 305
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->getCachedActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    .line 306
    .local v0, "activeSession":Lco/vine/android/client/Session;
    iget-object v4, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lco/vine/android/client/VineAccountHelper;->removeAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/AccountManagerFuture;

    .line 307
    if-eqz v0, :cond_1

    .line 308
    invoke-virtual {v0}, Lco/vine/android/client/Session;->logout()V

    .line 312
    :cond_1
    new-instance v3, Landroid/content/Intent;

    const-string v4, "co.vine.android.session.logout"

    invoke-direct {v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 313
    .local v3, "logoutIntent":Landroid/content/Intent;
    iget-object v4, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const-string v5, "co.vine.android.BROADCAST"

    invoke-virtual {v4, v3, v5}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 314
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-virtual {v4, v5}, Lco/vine/android/AppImpl;->getClearNotificationsIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    .line 315
    .local v2, "i":Landroid/content/Intent;
    if-eqz v2, :cond_2

    .line 316
    iget-object v4, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-virtual {v4, v2}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 320
    :cond_2
    iget-object v4, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lco/vine/android/StartActivity;->toStart(Landroid/content/Context;)V

    goto :goto_0
.end method

.method private performCleanup(Lco/vine/android/client/Session;J)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "timeAnchor"    # J

    .prologue
    .line 2088
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 2089
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "time"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2090
    const/16 v1, 0x1d

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static setPendingFacebookToken(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 1735
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "KEY_FACEBOOK_TOKEN"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1736
    return-void
.end method

.method public static startTwitterAuthWithFinish(Lcom/twitter/android/sdk/Twitter;Landroid/app/Activity;)V
    .locals 4
    .param p0, "twitter"    # Lcom/twitter/android/sdk/Twitter;
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v3, 0x2

    .line 1757
    const/4 v1, 0x1

    :try_start_0
    invoke-virtual {p0, p1, v1}, Lcom/twitter/android/sdk/Twitter;->startAuthActivityForResult(Landroid/app/Activity;I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1759
    invoke-static {p1}, Lco/vine/android/LoginTwitterActivity;->getIntentWithFinish(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {p1, v1, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1766
    :cond_0
    :goto_0
    return-void

    .line 1762
    :catch_0
    move-exception v0

    .line 1763
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-static {p1}, Lco/vine/android/LoginTwitterActivity;->getIntentWithFinish(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p1, v1, v3}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0
.end method


# virtual methods
.method public abortAllRequests()V
    .locals 2

    .prologue
    .line 2453
    iget-object v0, p0, Lco/vine/android/client/AppController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    invoke-virtual {v0}, Lco/vine/android/service/VineServiceConnection;->cancelAll()V

    .line 2454
    const/16 v0, 0x70

    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2455
    return-void
.end method

.method public acceptFollowRequest(Lco/vine/android/client/Session;J)Ljava/lang/String;
    .locals 3
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "userId"    # J

    .prologue
    .line 1854
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1855
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1856
    const-string v1, "accept"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1857
    const/16 v1, 0x32

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public acceptRejectRequest(Lco/vine/android/client/Session;J)Ljava/lang/String;
    .locals 3
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "userId"    # J

    .prologue
    .line 1862
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1863
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1864
    const-string v1, "accept"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1865
    const/16 v1, 0x32

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public addListener(Lco/vine/android/client/AppSessionListener;)V
    .locals 1
    .param p1, "listener"    # Lco/vine/android/client/AppSessionListener;

    .prologue
    .line 2118
    iget-object v0, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2122
    :goto_0
    return-void

    .line 2121
    :cond_0
    iget-object v0, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public attemptCancelVideoFetchRequest(Lco/vine/android/util/video/VideoKey;)Z
    .locals 1
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;

    .prologue
    .line 1242
    iget-object v0, p0, Lco/vine/android/client/AppController;->mVideoCache:Lco/vine/android/util/video/VideoCache;

    invoke-virtual {v0, p1}, Lco/vine/android/util/video/VideoCache;->cancel(Ljava/lang/Object;)I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public blockUser(J)Ljava/lang/String;
    .locals 4
    .param p1, "userToBlock"    # J

    .prologue
    .line 2312
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2313
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2314
    const-string v1, "block_user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2315
    const/16 v1, 0x2f

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public bulkFollowUsers(Lco/vine/android/client/Session;Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/client/Session;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 1445
    .local p2, "userIdsToFollow":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    invoke-static {v1, p1}, Lco/vine/android/client/AppController;->injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1446
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "follow_ids"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1447
    const/16 v1, 0x6b

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public call(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 4
    .param p1, "session"    # Lcom/facebook/Session;
    .param p2, "state"    # Lcom/facebook/SessionState;
    .param p3, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 278
    const-string v2, "Session state has changed: {}."

    invoke-virtual {p1}, Lcom/facebook/Session;->getState()Lcom/facebook/SessionState;

    move-result-object v3

    invoke-virtual {v3}, Lcom/facebook/SessionState;->name()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, p3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 279
    iget-object v1, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    .line 280
    .local v1, "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/client/AppSessionListener;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 281
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v2, p1, p2, p3}, Lco/vine/android/client/AppSessionListener;->onFacebookSessionChanged(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    .line 280
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 283
    :cond_0
    return-void
.end method

.method public clearDbAll()Ljava/lang/String;
    .locals 2

    .prologue
    .line 2169
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2170
    .local v0, "bundle":Landroid/os/Bundle;
    const/16 v1, 0x3b

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public clearDbCache(Z)Ljava/lang/String;
    .locals 2
    .param p1, "notify"    # Z

    .prologue
    .line 2155
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2156
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "notify"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2157
    const/16 v1, 0x3a

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public clearFacebookToken()V
    .locals 2

    .prologue
    .line 1739
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v0

    .line 1740
    .local v0, "fbSession":Lcom/facebook/Session;
    if-nez v0, :cond_0

    .line 1741
    iget-object v1, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/facebook/Session;->openActiveSessionFromCache(Landroid/content/Context;)Lcom/facebook/Session;

    move-result-object v0

    .line 1743
    :cond_0
    if-eqz v0, :cond_1

    .line 1744
    invoke-virtual {v0}, Lcom/facebook/Session;->closeAndClearTokenInformation()V

    .line 1746
    :cond_1
    return-void
.end method

.method public clearFileCache()V
    .locals 1

    .prologue
    .line 2147
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lco/vine/android/client/AppController;->clearFileCache(Landroid/content/Context;)V

    .line 2148
    return-void
.end method

.method public clearGcmRegId(Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "regId"    # Ljava/lang/String;
    .param p2, "userId"    # J
    .param p4, "key"    # Ljava/lang/String;

    .prologue
    .line 1710
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1711
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "gcmRegId"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1712
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1713
    const-string v1, "s_key"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1714
    const/16 v1, 0x3d

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public clearImageCacheFromMemory()V
    .locals 1

    .prologue
    .line 2030
    iget-object v0, p0, Lco/vine/android/client/AppController;->mPhotoImagesCache:Lco/vine/android/util/image/PhotoImagesCache;

    invoke-virtual {v0}, Lco/vine/android/util/image/PhotoImagesCache;->clearMemory()V

    .line 2031
    return-void
.end method

.method public clearInboxPageCursors()V
    .locals 2

    .prologue
    .line 2025
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2026
    .local v0, "b":Landroid/os/Bundle;
    const/16 v1, 0x68

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2027
    return-void
.end method

.method public clearPushNotifications(I)V
    .locals 2
    .param p1, "notificationDisplayId"    # I

    .prologue
    .line 1725
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1726
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "notification_display_id"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1727
    const/16 v1, 0x3e

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1728
    return-void
.end method

.method public clearUnreadMessageCount(J)V
    .locals 2
    .param p1, "conversationRowId"    # J

    .prologue
    .line 2440
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 2441
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2442
    const/16 v1, 0x5e

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2443
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->fetchActivityCounts()Ljava/lang/String;

    .line 2444
    return-void
.end method

.method public connectToFacebookInitialize(Landroid/support/v4/app/Fragment;)V
    .locals 6
    .param p1, "fragment"    # Landroid/support/v4/app/Fragment;

    .prologue
    .line 241
    sget-boolean v4, Lco/vine/android/client/AppController;->SINGLE_FACEBOOK_DIALOG:Z

    if-eqz v4, :cond_1

    .line 242
    invoke-virtual {p0, p1}, Lco/vine/android/client/AppController;->connectToFacebookPublish(Landroid/support/v4/app/Fragment;)V

    .line 258
    :cond_0
    :goto_0
    return-void

    .line 244
    :cond_1
    const/4 v4, 0x1

    sput-boolean v4, Lcom/facebook/AuthorizationClient;->CLEAR_COOKIE:Z

    .line 245
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    .line 246
    .local v0, "context":Landroid/content/Context;
    new-instance v4, Lcom/facebook/Session$Builder;

    invoke-direct {v4, v0}, Lcom/facebook/Session$Builder;-><init>(Landroid/content/Context;)V

    const v5, 0x7f0e00d6

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/facebook/Session$Builder;->setApplicationId(Ljava/lang/String;)Lcom/facebook/Session$Builder;

    move-result-object v4

    new-instance v5, Lcom/facebook/SharedPreferencesTokenCachingStrategy;

    invoke-direct {v5, v0}, Lcom/facebook/SharedPreferencesTokenCachingStrategy;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, v5}, Lcom/facebook/Session$Builder;->setTokenCachingStrategy(Lcom/facebook/TokenCachingStrategy;)Lcom/facebook/Session$Builder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/facebook/Session$Builder;->build()Lcom/facebook/Session;

    move-result-object v3

    .line 248
    .local v3, "session":Lcom/facebook/Session;
    invoke-static {v3}, Lcom/facebook/Session;->setActiveSession(Lcom/facebook/Session;)V

    .line 249
    invoke-virtual {v3}, Lcom/facebook/Session;->isOpened()Z

    move-result v4

    if-nez v4, :cond_0

    .line 250
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 251
    .local v2, "permissions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v4, "basic_info"

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 252
    new-instance v1, Lcom/facebook/Session$OpenRequest;

    invoke-direct {v1, p1}, Lcom/facebook/Session$OpenRequest;-><init>(Landroid/support/v4/app/Fragment;)V

    .line 253
    .local v1, "openRequest":Lcom/facebook/Session$OpenRequest;
    invoke-virtual {v1, v2}, Lcom/facebook/Session$OpenRequest;->setPermissions(Ljava/util/List;)Lcom/facebook/Session$OpenRequest;

    .line 254
    sget-object v4, Lcom/facebook/SessionLoginBehavior;->SSO_WITH_FALLBACK:Lcom/facebook/SessionLoginBehavior;

    invoke-virtual {v1, v4}, Lcom/facebook/Session$OpenRequest;->setLoginBehavior(Lcom/facebook/SessionLoginBehavior;)Lcom/facebook/Session$OpenRequest;

    .line 255
    invoke-virtual {v3, v1}, Lcom/facebook/Session;->openForRead(Lcom/facebook/Session$OpenRequest;)V

    goto :goto_0
.end method

.method public connectToFacebookPublish(Landroid/support/v4/app/Fragment;)V
    .locals 6
    .param p1, "fragment"    # Landroid/support/v4/app/Fragment;

    .prologue
    .line 261
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    .line 262
    .local v0, "context":Landroid/content/Context;
    new-instance v4, Lcom/facebook/Session$Builder;

    invoke-direct {v4, v0}, Lcom/facebook/Session$Builder;-><init>(Landroid/content/Context;)V

    const v5, 0x7f0e00d6

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/facebook/Session$Builder;->setApplicationId(Ljava/lang/String;)Lcom/facebook/Session$Builder;

    move-result-object v4

    new-instance v5, Lcom/facebook/SharedPreferencesTokenCachingStrategy;

    invoke-direct {v5, v0}, Lcom/facebook/SharedPreferencesTokenCachingStrategy;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, v5}, Lcom/facebook/Session$Builder;->setTokenCachingStrategy(Lcom/facebook/TokenCachingStrategy;)Lcom/facebook/Session$Builder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/facebook/Session$Builder;->build()Lcom/facebook/Session;

    move-result-object v3

    .line 264
    .local v3, "session":Lcom/facebook/Session;
    invoke-static {v3}, Lcom/facebook/Session;->setActiveSession(Lcom/facebook/Session;)V

    .line 265
    invoke-virtual {v3}, Lcom/facebook/Session;->isOpened()Z

    move-result v4

    if-nez v4, :cond_0

    .line 266
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 267
    .local v2, "permissions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v4, "publish_actions"

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 268
    new-instance v1, Lcom/facebook/Session$OpenRequest;

    invoke-direct {v1, p1}, Lcom/facebook/Session$OpenRequest;-><init>(Landroid/support/v4/app/Fragment;)V

    .line 269
    .local v1, "openRequest":Lcom/facebook/Session$OpenRequest;
    sget-object v4, Lcom/facebook/SessionDefaultAudience;->FRIENDS:Lcom/facebook/SessionDefaultAudience;

    invoke-virtual {v1, v4}, Lcom/facebook/Session$OpenRequest;->setDefaultAudience(Lcom/facebook/SessionDefaultAudience;)Lcom/facebook/Session$OpenRequest;

    .line 270
    invoke-virtual {v1, v2}, Lcom/facebook/Session$OpenRequest;->setPermissions(Ljava/util/List;)Lcom/facebook/Session$OpenRequest;

    .line 271
    sget-object v4, Lcom/facebook/SessionLoginBehavior;->SSO_WITH_FALLBACK:Lcom/facebook/SessionLoginBehavior;

    invoke-virtual {v1, v4}, Lcom/facebook/Session$OpenRequest;->setLoginBehavior(Lcom/facebook/SessionLoginBehavior;)Lcom/facebook/Session$OpenRequest;

    .line 272
    invoke-virtual {v3, v1}, Lcom/facebook/Session;->openForPublish(Lcom/facebook/Session$OpenRequest;)V

    .line 274
    .end local v1    # "openRequest":Lcom/facebook/Session$OpenRequest;
    .end local v2    # "permissions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_0
    return-void
.end method

.method public connectTwitter(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "username"    # Ljava/lang/String;
    .param p3, "token"    # Ljava/lang/String;
    .param p4, "secret"    # Ljava/lang/String;
    .param p5, "userId"    # J

    .prologue
    .line 1825
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1826
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "username"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1827
    const-string v1, "key"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1828
    const-string v1, "secret"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1829
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p5, p6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1830
    const/16 v1, 0x20

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public deactivateAccount()Ljava/lang/String;
    .locals 2

    .prologue
    .line 2182
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2183
    .local v0, "bundle":Landroid/os/Bundle;
    const/16 v1, 0x43

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public deleteComment(JLjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "postId"    # J
    .param p3, "commentId"    # Ljava/lang/String;

    .prologue
    .line 1678
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1679
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1680
    const-string v1, "comment_id"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1681
    const/16 v1, 0x1e

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public deleteConversation(J)Ljava/lang/String;
    .locals 2
    .param p1, "conversationRowId"    # J

    .prologue
    .line 2380
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2381
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2382
    const/16 v1, 0x50

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public deleteMessage(J)V
    .locals 2
    .param p1, "id"    # J

    .prologue
    .line 2006
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2007
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "message_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2008
    const/16 v1, 0x5f

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2009
    return-void
.end method

.method public deletePost(Lco/vine/android/client/Session;J)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "postId"    # J

    .prologue
    .line 1691
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1692
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1693
    const/16 v1, 0x1f

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public deleteSession(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 1749
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1750
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "s_key"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1751
    const/16 v1, 0x40

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public determineCleanup(Lco/vine/android/client/Session;)V
    .locals 10
    .param p1, "session"    # Lco/vine/android/client/Session;

    .prologue
    const-wide/16 v8, 0x0

    .line 2063
    iget-object v6, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const-string v7, "last_cleanup"

    invoke-static {v6, v7}, Lco/vine/android/util/Util;->getSharedPrefs(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;

    move-result-object v5

    .line 2064
    .local v5, "prefs":Landroid/content/SharedPreferences;
    const-string v6, "last_cleanup"

    invoke-interface {v5, v6, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v3

    .line 2065
    .local v3, "lastCleanupTime":J
    cmp-long v6, v3, v8

    if-lez v6, :cond_1

    .line 2066
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long/2addr v6, v3

    const-wide/32 v8, 0x36ee80

    cmp-long v6, v6, v8

    if-lez v6, :cond_0

    .line 2067
    invoke-direct {p0, p1, v3, v4}, Lco/vine/android/client/AppController;->performCleanup(Lco/vine/android/client/Session;J)Ljava/lang/String;

    .line 2077
    :cond_0
    :goto_0
    return-void

    .line 2072
    :cond_1
    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 2073
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 2074
    .local v0, "cleanupTime":J
    const-string v6, "last_cleanup"

    invoke-interface {v2, v6, v0, v1}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 2075
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method

.method public determineServerStatus()V
    .locals 13

    .prologue
    const-wide/32 v7, 0x36ee80

    const-wide/16 v11, 0x0

    .line 1891
    iget-object v9, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v4

    .line 1892
    .local v4, "prefs":Landroid/content/SharedPreferences;
    const-string v9, "server_upload_last_refresh"

    invoke-interface {v4, v9, v11, v12}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    .line 1893
    .local v2, "lastRefresh":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    sub-long v0, v9, v2

    .line 1894
    .local v0, "elapsedTime":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    sub-long v5, v9, v0

    .line 1895
    .local v5, "remainingTime":J
    cmp-long v9, v2, v11

    if-lez v9, :cond_0

    cmp-long v9, v0, v7

    if-lez v9, :cond_2

    .line 1896
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->fetchServerStatus()Ljava/lang/String;

    .line 1897
    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v9

    const-string v10, "server_upload_last_refresh"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v11

    invoke-interface {v9, v10, v11, v12}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v9

    invoke-interface {v9}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1899
    iget-object v9, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    if-eqz v9, :cond_1

    .line 1900
    iget-object v9, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    iget-object v10, p0, Lco/vine/android/client/AppController;->mServerStatusRunnable:Lco/vine/android/client/AppController$ServerStatusRunnable;

    invoke-virtual {v9, v10}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1901
    iget-object v9, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    iget-object v10, p0, Lco/vine/android/client/AppController;->mServerStatusRunnable:Lco/vine/android/client/AppController$ServerStatusRunnable;

    invoke-virtual {v9, v10, v7, v8}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1910
    .end local v5    # "remainingTime":J
    :cond_1
    :goto_0
    return-void

    .line 1904
    .restart local v5    # "remainingTime":J
    :cond_2
    iget-object v9, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    if-eqz v9, :cond_1

    .line 1905
    iget-object v9, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    iget-object v10, p0, Lco/vine/android/client/AppController;->mServerStatusRunnable:Lco/vine/android/client/AppController$ServerStatusRunnable;

    invoke-virtual {v9, v10}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1906
    iget-object v9, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    iget-object v10, p0, Lco/vine/android/client/AppController;->mServerStatusRunnable:Lco/vine/android/client/AppController$ServerStatusRunnable;

    cmp-long v11, v5, v11

    if-lez v11, :cond_3

    .end local v5    # "remainingTime":J
    :goto_1
    invoke-virtual {v9, v10, v5, v6}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .restart local v5    # "remainingTime":J
    :cond_3
    move-wide v5, v7

    goto :goto_1
.end method

.method public disableReposts(J)Ljava/lang/String;
    .locals 2
    .param p1, "userId"    # J

    .prologue
    .line 2338
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2339
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2340
    const/16 v1, 0x45

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public disconnectTwitter(Lco/vine/android/client/Session;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;

    .prologue
    .line 1849
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1850
    .local v0, "b":Landroid/os/Bundle;
    const/16 v1, 0x21

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public enableReposts(J)Ljava/lang/String;
    .locals 2
    .param p1, "userId"    # J

    .prologue
    .line 2332
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2333
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2334
    const/16 v1, 0x44

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public executeServiceRequest(ILandroid/os/Bundle;)V
    .locals 0
    .param p1, "actionCode"    # I
    .param p2, "b"    # Landroid/os/Bundle;

    .prologue
    .line 2034
    invoke-direct {p0, p1, p2}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2035
    return-void
.end method

.method public expireTimeline(ZILjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "fetchPosts"    # Z
    .param p2, "type"    # I
    .param p3, "tag"    # Ljava/lang/String;

    .prologue
    .line 2174
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2175
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "also_fetch_posts"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2176
    const-string v1, "type"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2177
    const-string v1, "tag_name"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2178
    const/16 v1, 0x2d

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public failRequest(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 6
    .param p1, "requestId"    # Ljava/lang/String;
    .param p2, "actionCode"    # I
    .param p3, "b"    # Landroid/os/Bundle;

    .prologue
    .line 2428
    const-string v0, "rid"

    invoke-virtual {p3, v0, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2429
    const/16 v3, 0x1c7

    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v5, p3

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/client/AppController;->notifyListeners(Ljava/lang/String;IILjava/lang/String;Landroid/os/Bundle;)V

    .line 2430
    return-void
.end method

.method public fetchActivity(Lco/vine/android/client/Session;IJZZ)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "page"    # I
    .param p3, "anchor"    # J
    .param p5, "followRequests"    # Z
    .param p6, "clearPendingCount"    # Z

    .prologue
    .line 1423
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1424
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "page"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1425
    const-string v1, "follow_reqs"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1426
    const-string v1, "clear"

    invoke-virtual {v0, v1, p6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1427
    const-string v1, "time"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1428
    const/16 v1, 0x14

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchActivityCounts()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1432
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1433
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "s_owner_id"

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1434
    const/16 v1, 0x51

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchAddressFriends(Lco/vine/android/client/Session;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;

    .prologue
    .line 1808
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1809
    .local v0, "b":Landroid/os/Bundle;
    const/16 v1, 0x10

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchChannels(I)Ljava/lang/String;
    .locals 2
    .param p1, "pageType"    # I

    .prologue
    .line 2187
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2188
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "page_type"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2189
    const/16 v1, 0x35

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchClientFlags(Z)V
    .locals 3
    .param p1, "abortRequestsOnHostChange"    # Z

    .prologue
    .line 2447
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2448
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "abort_requests"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2449
    const/16 v1, 0x6f

    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2450
    return-void
.end method

.method public fetchComments(JIJI)Ljava/lang/String;
    .locals 2
    .param p1, "postId"    # J
    .param p3, "page"    # I
    .param p4, "anchor"    # J
    .param p6, "size"    # I

    .prologue
    .line 1652
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1653
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1654
    const-string v1, "page"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1655
    const-string v1, "time"

    invoke-virtual {v0, v1, p4, p5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1656
    const-string v1, "size"

    invoke-virtual {v0, v1, p6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1657
    const/16 v1, 0xc

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchConversation(IZJJZ)Ljava/lang/String;
    .locals 2
    .param p1, "pageType"    # I
    .param p2, "userInitiated"    # Z
    .param p3, "conversationId"    # J
    .param p5, "conversationRowId"    # J
    .param p7, "prefetch"    # Z

    .prologue
    .line 2358
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundleReadOnly()Landroid/os/Bundle;

    move-result-object v0

    .line 2359
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "page_type"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2360
    const-string v1, "user_init"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2361
    const-string v1, "conversation_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2362
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p5, p6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2363
    const-string v1, "prefetch"

    invoke-virtual {v0, v1, p7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2364
    const/16 v1, 0x4c

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchConversationRowIdFromSingleRecipient(Lco/vine/android/api/VineRecipient;I)V
    .locals 4
    .param p1, "recipient"    # Lco/vine/android/api/VineRecipient;
    .param p2, "networkType"    # I

    .prologue
    .line 1997
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1998
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "network"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1999
    const-string v1, "recipient"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 2000
    const-string v1, "recipient_id"

    iget-wide v2, p1, Lco/vine/android/api/VineRecipient;->contactId:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2001
    const/16 v1, 0x5b

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2002
    return-void
.end method

.method public fetchConversationRowIdFromUserRemoteId(JI)V
    .locals 3
    .param p1, "userId"    # J
    .param p3, "networkType"    # I

    .prologue
    .line 1989
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1990
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "network"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1991
    const-string v1, "recipient"

    invoke-static {p1, p2}, Lco/vine/android/api/VineRecipient;->fromUser(J)Lco/vine/android/api/VineRecipient;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1992
    const-string v1, "recipient_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1993
    const/16 v1, 0x5b

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1994
    return-void
.end method

.method public fetchConversations(IZI)Ljava/lang/String;
    .locals 2
    .param p1, "pageType"    # I
    .param p2, "userInitiated"    # Z
    .param p3, "networkType"    # I

    .prologue
    .line 2349
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundleReadOnly()Landroid/os/Bundle;

    move-result-object v0

    .line 2350
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "page_type"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2351
    const-string v1, "user_init"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2352
    const-string v1, "network"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2353
    const/16 v1, 0x4a

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchFollowers(JIJ)Ljava/lang/String;
    .locals 2
    .param p1, "userId"    # J
    .param p3, "page"    # I
    .param p4, "anchor"    # J

    .prologue
    .line 1364
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1365
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "profile_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1366
    const-string v1, "page"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1367
    const-string v1, "time"

    invoke-virtual {v0, v1, p4, p5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1368
    const/16 v1, 0x16

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchFollowing(JIJ)Ljava/lang/String;
    .locals 2
    .param p1, "userId"    # J
    .param p3, "page"    # I
    .param p4, "anchor"    # J

    .prologue
    .line 1372
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1373
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "profile_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1374
    const-string v1, "page"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1375
    const-string v1, "time"

    invoke-virtual {v0, v1, p4, p5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1376
    const/16 v1, 0x17

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchFriends(II)Ljava/lang/String;
    .locals 2
    .param p1, "pageType"    # I
    .param p2, "type"    # I

    .prologue
    .line 1385
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1386
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "page_type"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1387
    const-string v1, "type"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1388
    const/16 v1, 0x52

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchFriendsTypeAhead(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 1392
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1393
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "q"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1394
    const/16 v1, 0x63

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchNotificationSettings()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1380
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1381
    .local v0, "b":Landroid/os/Bundle;
    const/16 v1, 0x71

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchNotificationUsers(Lco/vine/android/client/Session;JIJ)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "notificationId"    # J
    .param p4, "page"    # I
    .param p5, "anchor"    # J

    .prologue
    .line 1406
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1407
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "notification_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1408
    const-string v1, "page"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1409
    const-string v1, "time"

    invoke-virtual {v0, v1, p5, p6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1410
    const/16 v1, 0x6e

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchPendingNotificationCount(Lco/vine/android/client/Session;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;

    .prologue
    .line 2344
    const/16 v0, 0x41

    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public fetchPost(Lco/vine/android/client/Session;J)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "postId"    # J

    .prologue
    .line 1640
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1641
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1642
    const/16 v1, 0x1c

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchPostId(Lco/vine/android/client/Session;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "shareId"    # Ljava/lang/String;

    .prologue
    .line 1646
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1647
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_share_id"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1648
    const/16 v1, 0x24

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchPostLikers(Lco/vine/android/client/Session;JIJ)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "postId"    # J
    .param p4, "page"    # I
    .param p5, "anchor"    # J

    .prologue
    .line 1398
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1399
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1400
    const-string v1, "page"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1401
    const-string v1, "time"

    invoke-virtual {v0, v1, p5, p6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1402
    const/16 v1, 0xb

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchPosts(Lco/vine/android/client/Session;IJIIJZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "size"    # I
    .param p3, "userId"    # J
    .param p5, "type"    # I
    .param p6, "page"    # I
    .param p7, "anchor"    # J
    .param p9, "userInitiated"    # Z
    .param p10, "tag"    # Ljava/lang/String;
    .param p11, "sort"    # Ljava/lang/String;
    .param p12, "data"    # Landroid/net/Uri;

    .prologue
    .line 1626
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1627
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "size"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1628
    const-string v1, "type"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1629
    const-string v1, "page"

    invoke-virtual {v0, v1, p6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1630
    const-string v1, "time"

    invoke-virtual {v0, v1, p7, p8}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1631
    const-string v1, "profile_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1632
    const-string v1, "user_init"

    invoke-virtual {v0, v1, p9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1633
    if-eqz p10, :cond_0

    const-string v1, "tag_name"

    invoke-virtual {v0, v1, p10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1634
    :cond_0
    if-eqz p11, :cond_1

    const-string v1, "sort"

    invoke-virtual {v0, v1, p11}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1635
    :cond_1
    const-string v1, "data"

    invoke-virtual {v0, v1, p12}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1636
    const/16 v1, 0xd

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchReviners(Lco/vine/android/client/Session;JIJ)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "postId"    # J
    .param p4, "page"    # I
    .param p5, "anchor"    # J

    .prologue
    .line 1414
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1415
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1416
    const-string v1, "page"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1417
    const-string v1, "time"

    invoke-virtual {v0, v1, p5, p6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1418
    const/16 v1, 0x38

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchServerStatus()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1511
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1512
    .local v0, "b":Landroid/os/Bundle;
    const/16 v1, 0x26

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchTagTypeahead(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 2286
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2287
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "q"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2288
    const/16 v1, 0x28

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchTwitterFriends(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "secret"    # Ljava/lang/String;

    .prologue
    .line 1801
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1802
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "key"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1803
    const-string v1, "secret"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1804
    const/16 v1, 0xf

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchTwitterUser(Lco/vine/android/api/VineLogin;)Ljava/lang/String;
    .locals 2
    .param p1, "mLogin"    # Lco/vine/android/api/VineLogin;

    .prologue
    .line 1609
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1610
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "login"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1611
    const/4 v1, 0x7

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchUser(J)Ljava/lang/String;
    .locals 2
    .param p1, "userId"    # J

    .prologue
    .line 1358
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1359
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1360
    const/16 v1, 0x15

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchUserId(Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 2386
    .local p1, "vanityUrlSegments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2387
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "vanity_url"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 2388
    const/16 v1, 0x56

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchUserTypeahead(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 2280
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2281
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "q"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2282
    const/16 v1, 0x27

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public fetchUsersMe(J)Ljava/lang/String;
    .locals 2
    .param p1, "userId"    # J

    .prologue
    .line 1312
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1313
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "s_owner_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1314
    const/16 v1, 0xa

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public followEditorsPicks(Z)V
    .locals 4
    .param p1, "shouldFollow"    # Z

    .prologue
    .line 1774
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    .line 1775
    .local v2, "session":Lco/vine/android/client/Session;
    invoke-direct {p0, v2}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1776
    .local v0, "bundle":Landroid/os/Bundle;
    if-eqz p1, :cond_0

    const/4 v1, 0x1

    .line 1777
    .local v1, "follow":I
    :goto_0
    const-string v3, "should_follow_editors_picks"

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1778
    const/16 v3, 0x2c

    invoke-direct {p0, v3, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1779
    return-void

    .line 1776
    .end local v1    # "follow":I
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public followUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "userIdToFollow"    # J
    .param p4, "notify"    # Z

    .prologue
    .line 1438
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1439
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "follow_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1440
    const-string v1, "notify"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1441
    const/16 v1, 0x12

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public generateReqIdForCanceledCaptcha()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2424
    iget-object v0, p0, Lco/vine/android/client/AppController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    invoke-virtual {v0}, Lco/vine/android/service/VineServiceConnection;->generateRequestId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getActiveId()J
    .locals 2

    .prologue
    .line 1524
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSessionReadOnly()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v0

    return-wide v0
.end method

.method public getActiveSession()Lco/vine/android/client/Session;
    .locals 1

    .prologue
    .line 1516
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/client/AppController;->getActiveSession(Z)Lco/vine/android/client/Session;

    move-result-object v0

    return-object v0
.end method

.method public getActiveSessionReadOnly()Lco/vine/android/client/Session;
    .locals 1

    .prologue
    .line 1520
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/client/AppController;->getActiveSession(Z)Lco/vine/android/client/Session;

    move-result-object v0

    return-object v0
.end method

.method public getBlockedUsers()Ljava/lang/String;
    .locals 4

    .prologue
    .line 2306
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2307
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2308
    const/16 v1, 0x2e

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getConversationRemoteId(J)Ljava/lang/String;
    .locals 2
    .param p1, "conversationRowId"    # J

    .prologue
    .line 2368
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 2369
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2370
    const/16 v1, 0x4d

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getEditions()V
    .locals 2

    .prologue
    .line 1964
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1965
    .local v0, "b":Landroid/os/Bundle;
    const/16 v1, 0x46

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1966
    return-void
.end method

.method public getLoginStatus()Lco/vine/android/client/Session$LoginStatus;
    .locals 1

    .prologue
    .line 2100
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/Session;->getLoginStatus()Lco/vine/android/client/Session$LoginStatus;

    move-result-object v0

    return-object v0
.end method

.method public getPendingFacebookToken()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1731
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "KEY_FACEBOOK_TOKEN"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;
    .locals 4
    .param p1, "key"    # Lco/vine/android/util/image/ImageKey;

    .prologue
    .line 1213
    iget-object v1, p1, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    invoke-static {v1}, Lco/vine/android/util/Util;->isUrlLocal(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1214
    iget-object v1, p0, Lco/vine/android/client/AppController;->mPhotoImagesCache:Lco/vine/android/util/image/PhotoImagesCache;

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3, p1}, Lco/vine/android/util/image/PhotoImagesCache;->getBitmap(JLco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 1217
    :goto_0
    return-object v1

    .line 1216
    :cond_0
    iget-object v1, p1, Lco/vine/android/util/image/ImageKey;->url:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 1217
    .local v0, "path":Ljava/lang/String;
    invoke-static {v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    goto :goto_0
.end method

.method public getSession(Ljava/lang/String;)Lco/vine/android/client/Session;
    .locals 1
    .param p1, "accountName"    # Ljava/lang/String;

    .prologue
    .line 1539
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lco/vine/android/client/VineAccountHelper;->getSession(Landroid/content/Context;Ljava/lang/String;)Lco/vine/android/client/Session;

    move-result-object v0

    return-object v0
.end method

.method public getTwitter()Lcom/twitter/android/sdk/Twitter;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lco/vine/android/client/AppController;->mTwitter:Lcom/twitter/android/sdk/Twitter;

    return-object v0
.end method

.method public getTwitterAuth(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "callback"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "secret"    # Ljava/lang/String;

    .prologue
    .line 1595
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1596
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "uri"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1597
    const-string v1, "key"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1598
    const-string v1, "secret"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1599
    const/4 v1, 0x5

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getTypeaheadFetchThreshold(Ljava/lang/String;)I
    .locals 1
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 2272
    const-string v0, "tag"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2273
    const/4 v0, 0x3

    .line 2275
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x2

    goto :goto_0
.end method

.method public getTypeaheadMaxCompose()I
    .locals 1

    .prologue
    .line 2268
    const/16 v0, 0x32

    return v0
.end method

.method public getTypeaheadThrottle()J
    .locals 2

    .prologue
    .line 2264
    const-wide/16 v0, 0x12c

    return-wide v0
.end method

.method public getValidFacebookSession(Landroid/app/Activity;Z)Lcom/facebook/Session;
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "closeAfterwards"    # Z

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 206
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v0

    .line 207
    .local v0, "session":Lcom/facebook/Session;
    if-eqz v0, :cond_3

    const/4 v2, 0x1

    .line 208
    .local v2, "wasOpen":Z
    :goto_0
    if-nez v2, :cond_0

    .line 209
    invoke-static {p1, v4, p0}, Lcom/facebook/Session;->openActiveSession(Landroid/app/Activity;ZLcom/facebook/Session$StatusCallback;)Lcom/facebook/Session;

    move-result-object v0

    .line 211
    :cond_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/facebook/Session;->getState()Lcom/facebook/SessionState;

    move-result-object v4

    invoke-virtual {v4}, Lcom/facebook/SessionState;->isClosed()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 212
    :cond_1
    const-string v4, "There were no Facebook session."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move-object v0, v3

    .line 235
    .end local v0    # "session":Lcom/facebook/Session;
    :cond_2
    :goto_1
    return-object v0

    .end local v2    # "wasOpen":Z
    .restart local v0    # "session":Lcom/facebook/Session;
    :cond_3
    move v2, v4

    .line 207
    goto :goto_0

    .line 215
    .restart local v2    # "wasOpen":Z
    :cond_4
    invoke-static {v0}, Lcom/facebook/Session;->setActiveSession(Lcom/facebook/Session;)V

    .line 216
    invoke-virtual {v0}, Lcom/facebook/Session;->getState()Lcom/facebook/SessionState;

    move-result-object v1

    .line 217
    .local v1, "state":Lcom/facebook/SessionState;
    const-string v4, "Old Facebook Session state : {}"

    invoke-static {v4, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 218
    sget-object v4, Lcom/facebook/SessionState;->CREATED_TOKEN_LOADED:Lcom/facebook/SessionState;

    if-eq v1, v4, :cond_5

    invoke-virtual {v1}, Lcom/facebook/SessionState;->isOpened()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 220
    :cond_5
    const-string v4, "State is created or opened."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 221
    invoke-virtual {v0}, Lcom/facebook/Session;->getPermissions()Ljava/util/List;

    move-result-object v4

    const-string v5, "publish_actions"

    invoke-interface {v4, v5}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 222
    const-string v3, "Permission is good."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 223
    if-nez v2, :cond_2

    if-eqz p2, :cond_2

    .line 224
    invoke-virtual {v0}, Lcom/facebook/Session;->close()V

    goto :goto_1

    .line 228
    :cond_6
    invoke-virtual {v0}, Lcom/facebook/Session;->closeAndClearTokenInformation()V

    .line 229
    const-string v4, "Permission missing."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move-object v0, v3

    .line 230
    goto :goto_1

    .line 233
    :cond_7
    invoke-virtual {v0}, Lcom/facebook/Session;->close()V

    .line 234
    const-string v4, "Session state is invalid."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move-object v0, v3

    .line 235
    goto :goto_1
.end method

.method public getVideoFilePath(Lco/vine/android/util/video/VideoKey;)Ljava/lang/String;
    .locals 4
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;

    .prologue
    .line 1222
    iget-object v0, p1, Lco/vine/android/util/video/VideoKey;->url:Ljava/lang/String;

    invoke-static {v0}, Lco/vine/android/util/Util;->isUrlLocal(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1223
    iget-object v0, p0, Lco/vine/android/client/AppController;->mVideoCache:Lco/vine/android/util/video/VideoCache;

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, p1, v3}, Lco/vine/android/util/video/VideoCache;->getFile(JLco/vine/android/util/video/VideoKey;Z)Ljava/lang/String;

    move-result-object v0

    .line 1225
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p1, Lco/vine/android/util/video/VideoKey;->url:Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public handleServiceResponse(IILjava/lang/String;Landroid/os/Bundle;)V
    .locals 10
    .param p1, "actionCode"    # I
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "b"    # Landroid/os/Bundle;

    .prologue
    .line 1187
    const-string v0, "rid"

    invoke-virtual {p4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1189
    .local v1, "reqId":Ljava/lang/String;
    iget-object v0, p0, Lco/vine/android/client/AppController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    invoke-virtual {v0, v1}, Lco/vine/android/service/VineServiceConnection;->remove(Ljava/lang/String;)Lco/vine/android/service/PendingAction;

    move-result-object v6

    .line 1191
    .local v6, "action":Lco/vine/android/service/PendingAction;
    const-string v0, "logged_out"

    invoke-virtual {p4, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x6

    if-eq p1, v0, :cond_1

    .line 1192
    invoke-direct {p0}, Lco/vine/android/client/AppController;->onLogout()V

    .line 1210
    :cond_0
    :goto_0
    return-void

    .line 1196
    :cond_1
    const-string v0, "refresh_session"

    const/4 v2, 0x0

    invoke-virtual {p4, v0, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1197
    const-string v0, "s_key"

    invoke-virtual {p4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/client/AppController;->refreshSessionKey(Ljava/lang/String;)V

    .line 1200
    :cond_2
    const-string v0, "captcha_url"

    invoke-virtual {p4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 1201
    .local v7, "captchaUrl":Ljava/lang/String;
    const-string v0, "captcha_url"

    invoke-virtual {p4, v0}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 1202
    if-eqz v7, :cond_3

    .line 1203
    iget-object v0, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lco/vine/android/client/AppSessionListener;

    .line 1204
    .local v9, "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v9, v1, v7, v6}, Lco/vine/android/client/AppSessionListener;->onCaptchaRequired(Ljava/lang/String;Ljava/lang/String;Lco/vine/android/service/PendingAction;)V

    goto :goto_1

    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v9    # "listener":Lco/vine/android/client/AppSessionListener;
    :cond_3
    move-object v0, p0

    move v2, p1

    move v3, p2

    move-object v4, p3

    move-object v5, p4

    .line 1209
    invoke-virtual/range {v0 .. v5}, Lco/vine/android/client/AppController;->notifyListeners(Ljava/lang/String;IILjava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public ignoreConversation(J)Ljava/lang/String;
    .locals 2
    .param p1, "conversationRowId"    # J

    .prologue
    .line 2374
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2375
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2376
    const/16 v1, 0x4f

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public isConnectedToFacebook(Landroid/app/Activity;)Z
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v0, 0x1

    .line 202
    invoke-virtual {p0, p1, v0}, Lco/vine/android/client/AppController;->getValidFacebookSession(Landroid/app/Activity;Z)Lcom/facebook/Session;

    move-result-object v1

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isLoggedIn()Z
    .locals 2

    .prologue
    .line 2110
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lco/vine/android/client/VineAccountHelper;->isLoggedIn(Landroid/content/Context;Z)Z

    move-result v0

    return v0
.end method

.method public isLoggedInReadOnly()Z
    .locals 2

    .prologue
    .line 2114
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lco/vine/android/client/VineAccountHelper;->isLoggedIn(Landroid/content/Context;Z)Z

    move-result v0

    return v0
.end method

.method public isPendingRequest(Ljava/lang/String;)Z
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 1534
    iget-object v0, p0, Lco/vine/android/client/AppController;->mServiceConnection:Lco/vine/android/service/VineServiceConnection;

    invoke-virtual {v0, p1}, Lco/vine/android/service/VineServiceConnection;->isPending(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public likePost(Ljava/lang/String;Lco/vine/android/client/Session;JJLjava/lang/String;Z)Ljava/lang/String;
    .locals 2
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "session"    # Lco/vine/android/client/Session;
    .param p3, "postToLike"    # J
    .param p5, "meUserId"    # J
    .param p7, "meUsername"    # Ljava/lang/String;
    .param p8, "notify"    # Z

    .prologue
    .line 1466
    invoke-direct {p0, p2}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1467
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1468
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p5, p6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1469
    const-string v1, "username"

    invoke-virtual {v0, v1, p7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1470
    const-string v1, "notify"

    invoke-virtual {v0, v1, p8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1471
    invoke-static {p3, p4, p1}, Lco/vine/android/util/FlurryUtils;->trackLikePost(JLjava/lang/String;)V

    .line 1472
    const/16 v1, 0x18

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public login(Lco/vine/android/client/Session;Lco/vine/android/api/VineLogin;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "login"    # Lco/vine/android/api/VineLogin;
    .param p3, "password"    # Ljava/lang/String;
    .param p4, "reactivate"    # Z

    .prologue
    .line 1553
    sget-object v1, Lco/vine/android/client/Session$LoginStatus;->LOGGING_IN:Lco/vine/android/client/Session$LoginStatus;

    invoke-virtual {p1, v1}, Lco/vine/android/client/Session;->setLoginStatus(Lco/vine/android/client/Session$LoginStatus;)V

    .line 1554
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1555
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "login"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1556
    const-string v1, "pass"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1557
    const-string v1, "reactivate"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1558
    const/4 v1, 0x2

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public loginCheckTwitter(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)Ljava/lang/String;
    .locals 2
    .param p1, "username"    # Ljava/lang/String;
    .param p2, "token"    # Ljava/lang/String;
    .param p3, "secret"    # Ljava/lang/String;
    .param p4, "twitterUserId"    # J
    .param p6, "reactivate"    # Z

    .prologue
    .line 1791
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1792
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "username"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1793
    const-string v1, "key"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1794
    const-string v1, "secret"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1795
    const-string v1, "t_id"

    invoke-virtual {v0, v1, p4, p5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1796
    const-string v1, "reactivate"

    invoke-virtual {v0, v1, p6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1797
    const/4 v1, 0x6

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public loginComplete(Lco/vine/android/client/Session;ILandroid/os/Bundle;)Lco/vine/android/api/VineLogin;
    .locals 8
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "responseCode"    # I
    .param p3, "b"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineLoggingException;
        }
    .end annotation

    .prologue
    .line 1299
    const-string v0, "login"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v7

    check-cast v7, Lco/vine/android/api/VineLogin;

    .line 1300
    .local v7, "vl":Lco/vine/android/api/VineLogin;
    if-eqz v7, :cond_0

    .line 1301
    const-string v0, "a_name"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v0, "pass"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v0, "login"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Lco/vine/android/api/VineLogin;

    const-string v0, "avatar_url"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->loginComplete(Lco/vine/android/client/Session;ILjava/lang/String;Ljava/lang/String;Lco/vine/android/api/VineLogin;Ljava/lang/String;)Lco/vine/android/api/VineLogin;

    move-result-object v0

    .line 1307
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public loginComplete(Lco/vine/android/client/Session;ILjava/lang/String;Ljava/lang/String;Lco/vine/android/api/VineLogin;Ljava/lang/String;)Lco/vine/android/api/VineLogin;
    .locals 7
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "responseCode"    # I
    .param p3, "accountName"    # Ljava/lang/String;
    .param p4, "password"    # Ljava/lang/String;
    .param p5, "login"    # Lco/vine/android/api/VineLogin;
    .param p6, "avatarUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineLoggingException;
        }
    .end annotation

    .prologue
    .line 1247
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_2

    .line 1248
    sget-object v0, Lco/vine/android/client/Session$LoginStatus;->LOGGED_IN:Lco/vine/android/client/Session$LoginStatus;

    invoke-virtual {p1, v0}, Lco/vine/android/client/Session;->setLoginStatus(Lco/vine/android/client/Session$LoginStatus;)V

    .line 1252
    iget v0, p5, Lco/vine/android/api/VineLogin;->loginType:I

    packed-switch v0, :pswitch_data_0

    .line 1262
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v2, "Unsupported login type."

    invoke-direct {v0, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1254
    :pswitch_0
    move-object v1, p3

    .line 1266
    .local v1, "uniqueLogin":Ljava/lang/String;
    :goto_0
    iget-wide v2, p5, Lco/vine/android/api/VineLogin;->userId:J

    invoke-virtual {p1, v2, v3}, Lco/vine/android/client/Session;->setUserId(J)V

    .line 1267
    invoke-virtual {p1, p3}, Lco/vine/android/client/Session;->setName(Ljava/lang/String;)V

    .line 1268
    iget-object v0, p5, Lco/vine/android/api/VineLogin;->key:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lco/vine/android/client/Session;->setSessionKey(Ljava/lang/String;)V

    .line 1269
    invoke-virtual {p1, v1}, Lco/vine/android/client/Session;->setLoginEmail(Ljava/lang/String;)V

    .line 1270
    invoke-virtual {p1, p6}, Lco/vine/android/client/Session;->setAvatarUrl(Ljava/lang/String;)V

    .line 1272
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    move-object v2, p5

    move-object v3, p4

    move-object v4, p6

    move-object v5, p3

    invoke-static/range {v0 .. v5}, Lco/vine/android/client/VineAccountHelper;->createAccount(Landroid/content/Context;Ljava/lang/String;Lco/vine/android/api/VineLogin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/accounts/Account;

    .line 1274
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    iget-wide v2, p5, Lco/vine/android/api/VineLogin;->userId:J

    invoke-static {v0, v1, p3, v2, v3}, Lco/vine/android/provider/SettingsManager;->setCurrentAccount(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)V

    .line 1278
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v2, "last_user_id"

    const-wide/16 v3, 0x0

    invoke-interface {v0, v2, v3, v4}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    iget-wide v4, p5, Lco/vine/android/api/VineLogin;->userId:J

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    .line 1279
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->clearFacebookToken()V

    .line 1280
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v0

    iget-object v2, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v2}, Lco/vine/android/AppImpl;->getDiscardAllIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v6

    .line 1281
    .local v6, "i":Landroid/content/Intent;
    if-eqz v6, :cond_0

    .line 1282
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v6}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1286
    .end local v6    # "i":Landroid/content/Intent;
    :cond_0
    iget-object v0, p5, Lco/vine/android/api/VineLogin;->edition:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 1287
    iget-object v0, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v2, "settings_edition"

    iget-object v3, p5, Lco/vine/android/api/VineLogin;->edition:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1291
    :cond_1
    iget-wide v2, p5, Lco/vine/android/api/VineLogin;->userId:J

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->setUserId(Ljava/lang/String;)V

    .line 1294
    .end local v1    # "uniqueLogin":Ljava/lang/String;
    .end local p5    # "login":Lco/vine/android/api/VineLogin;
    :goto_1
    return-object p5

    .line 1258
    .restart local p5    # "login":Lco/vine/android/api/VineLogin;
    :pswitch_1
    iget-object v1, p5, Lco/vine/android/api/VineLogin;->username:Ljava/lang/String;

    .line 1259
    .restart local v1    # "uniqueLogin":Ljava/lang/String;
    goto :goto_0

    .line 1294
    .end local v1    # "uniqueLogin":Ljava/lang/String;
    :cond_2
    const/4 p5, 0x0

    goto :goto_1

    .line 1252
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public loginWithxAuth(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "username"    # Ljava/lang/String;
    .param p2, "password"    # Ljava/lang/String;

    .prologue
    .line 1615
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1616
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "username"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1617
    const-string v1, "pass"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1618
    const/16 v1, 0x8

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public logout(Lco/vine/android/client/Session;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;

    .prologue
    .line 1568
    invoke-virtual {p1}, Lco/vine/android/client/Session;->getLoginStatus()Lco/vine/android/client/Session$LoginStatus;

    move-result-object v0

    sget-object v1, Lco/vine/android/client/Session$LoginStatus;->LOGGED_IN:Lco/vine/android/client/Session$LoginStatus;

    if-eq v0, v1, :cond_0

    invoke-virtual {p1}, Lco/vine/android/client/Session;->getLoginStatus()Lco/vine/android/client/Session$LoginStatus;

    move-result-object v0

    sget-object v1, Lco/vine/android/client/Session$LoginStatus;->LOGGING_IN:Lco/vine/android/client/Session$LoginStatus;

    if-ne v0, v1, :cond_1

    .line 1570
    :cond_0
    sget-object v0, Lco/vine/android/client/Session$LoginStatus;->LOGGING_OUT:Lco/vine/android/client/Session$LoginStatus;

    invoke-virtual {p1, v0}, Lco/vine/android/client/Session;->setLoginStatus(Lco/vine/android/client/Session$LoginStatus;)V

    .line 1571
    const/4 v0, 0x3

    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    .line 1574
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public markMessageLoopViewed(Lco/vine/android/api/VinePrivateMessage;)V
    .locals 2
    .param p1, "vpm"    # Lco/vine/android/api/VinePrivateMessage;

    .prologue
    .line 1958
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1959
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "message"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1960
    const/16 v1, 0x54

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1961
    return-void
.end method

.method public mergePushNotification(Lco/vine/android/api/VineSingleNotification;Ljava/lang/String;)V
    .locals 2
    .param p1, "notification"    # Lco/vine/android/api/VineSingleNotification;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 1718
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1719
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "notification"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1720
    const-string v1, "message"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1721
    const/16 v1, 0x61

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1722
    return-void
.end method

.method public mergeSinglePost(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 1933
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->isLoggedInReadOnly()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1934
    const/16 v0, 0x39

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-static {p1, v1}, Lco/vine/android/client/AppController;->injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1936
    :cond_0
    return-void
.end method

.method notifyListeners(Ljava/lang/String;IILjava/lang/String;Landroid/os/Bundle;)V
    .locals 169
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "actionCode"    # I
    .param p3, "statusCode"    # I
    .param p4, "reasonPhrase"    # Ljava/lang/String;
    .param p5, "b"    # Landroid/os/Bundle;

    .prologue
    .line 330
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    move-object/from16 v132, v0

    .line 331
    .local v132, "context":Landroid/content/Context;
    packed-switch p2, :pswitch_data_0

    .line 1184
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 335
    :pswitch_1
    :try_start_0
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->getCachedActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    move-object/from16 v0, p0

    move/from16 v1, p3

    move-object/from16 v2, p5

    invoke-virtual {v0, v5, v1, v2}, Lco/vine/android/client/AppController;->loginComplete(Lco/vine/android/client/Session;ILandroid/os/Bundle;)Lco/vine/android/api/VineLogin;
    :try_end_0
    .catch Lco/vine/android/VineLoggingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v10

    .line 341
    .local v10, "vl":Lco/vine/android/api/VineLogin;
    const-string v5, "error_code"

    const/4 v6, -0x1

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v9

    .line 343
    .local v9, "errorCode":I
    new-instance v150, Landroid/content/Intent;

    const-string v5, "co.vine.android.session.login"

    move-object/from16 v0, v150

    invoke-direct {v0, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 344
    .local v150, "loginIntent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const-string v6, "co.vine.android.BROADCAST"

    move-object/from16 v0, v150

    invoke-virtual {v5, v0, v6}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 346
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .local v143, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 347
    .local v4, "listener":Lco/vine/android/client/AppSessionListener;
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->getCachedActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    move-object/from16 v6, p1

    move/from16 v7, p3

    move-object/from16 v8, p4

    invoke-virtual/range {v4 .. v10}, Lco/vine/android/client/AppSessionListener;->onLoginComplete(Lco/vine/android/client/Session;Ljava/lang/String;ILjava/lang/String;ILco/vine/android/api/VineLogin;)V

    goto :goto_1

    .line 336
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v9    # "errorCode":I
    .end local v10    # "vl":Lco/vine/android/api/VineLogin;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v150    # "loginIntent":Landroid/content/Intent;
    :catch_0
    move-exception v135

    .line 337
    .local v135, "e":Lco/vine/android/VineLoggingException;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const v6, 0x7f0e00d7

    invoke-static {v5, v6}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 338
    invoke-static/range {v135 .. v135}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 353
    .end local v135    # "e":Lco/vine/android/VineLoggingException;
    :pswitch_2
    invoke-direct/range {p0 .. p0}, Lco/vine/android/client/AppController;->onLogout()V

    goto :goto_0

    .line 357
    :pswitch_3
    const-string v5, "login"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v15

    check-cast v15, Lco/vine/android/api/VineLogin;

    .line 358
    .local v15, "login":Lco/vine/android/api/VineLogin;
    const-string v5, "pass"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 359
    .local v17, "password":Ljava/lang/String;
    const-string v5, "a_name"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 360
    .local v16, "accountName":Ljava/lang/String;
    const-string v5, "avatar_url"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 361
    .local v18, "avatarUrl":Ljava/lang/String;
    const-string v5, "uri"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v129

    check-cast v129, Landroid/net/Uri;

    .line 362
    .local v129, "avatar":Landroid/net/Uri;
    const-string v5, "s_key"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v146

    .line 363
    .local v146, "key":Ljava/lang/String;
    const-string v5, "s_owner_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v86

    .line 364
    .local v86, "userId":J
    const/16 v165, 0x0

    .line 366
    .local v165, "uploaded":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object v11, v4

    move-object/from16 v12, p1

    move/from16 v13, p3

    move-object/from16 v14, p4

    .line 367
    invoke-virtual/range {v11 .. v18}, Lco/vine/android/client/AppSessionListener;->onSignUpComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineLogin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 373
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_1

    if-nez v165, :cond_1

    .line 374
    if-eqz v129, :cond_1

    .line 375
    const/16 v165, 0x1

    .line 376
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v161

    .line 377
    .local v161, "session":Lco/vine/android/client/Session;
    move-object/from16 v0, v161

    move-object/from16 v1, v146

    invoke-virtual {v0, v1}, Lco/vine/android/client/Session;->setSessionKey(Ljava/lang/String;)V

    .line 378
    move-object/from16 v0, v161

    move-wide/from16 v1, v86

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/Session;->setUserId(J)V

    .line 379
    move-object/from16 v0, p0

    move-object/from16 v1, v161

    move-object/from16 v2, v129

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->updateProfilePhoto(Lco/vine/android/client/Session;Landroid/net/Uri;)Ljava/lang/String;

    .line 382
    .end local v161    # "session":Lco/vine/android/client/Session;
    :cond_1
    new-instance v150, Landroid/content/Intent;

    const-string v5, "co.vine.android.session.login"

    move-object/from16 v0, v150

    invoke-direct {v0, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 383
    .restart local v150    # "loginIntent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const-string v6, "co.vine.android.BROADCAST"

    move-object/from16 v0, v150

    invoke-virtual {v5, v0, v6}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto :goto_2

    .line 388
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v15    # "login":Lco/vine/android/api/VineLogin;
    .end local v16    # "accountName":Ljava/lang/String;
    .end local v17    # "password":Ljava/lang/String;
    .end local v18    # "avatarUrl":Ljava/lang/String;
    .end local v86    # "userId":J
    .end local v129    # "avatar":Landroid/net/Uri;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v146    # "key":Ljava/lang/String;
    .end local v150    # "loginIntent":Landroid/content/Intent;
    .end local v165    # "uploaded":Z
    :pswitch_4
    const-string v5, "avatar_url"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 389
    .restart local v18    # "avatarUrl":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 390
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, v18

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onProfilePhotoUpdatedComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 396
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v18    # "avatarUrl":Ljava/lang/String;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_5
    const-string v5, "conversation_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v133

    .line 397
    .local v133, "conversationId":J
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 398
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-wide/from16 v0, v133

    invoke-virtual {v4, v0, v1}, Lco/vine/android/client/AppSessionListener;->onGetConversationRemoteIdComplete(J)V

    goto :goto_4

    .line 403
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v133    # "conversationId":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_6
    const-string v5, "notificationSettings"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v153

    .line 405
    .local v153, "notifSettings":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineNotificationSetting;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_5
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 406
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move-object/from16 v1, v153

    invoke-virtual {v4, v0, v1}, Lco/vine/android/client/AppSessionListener;->onGetNotificationSettingsComplete(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_5

    .line 411
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v153    # "notifSettings":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineNotificationSetting;>;"
    :pswitch_7
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_6
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 412
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onSaveNotificationSettingsComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_6

    .line 417
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_8
    const-string v5, "conversation_row_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v22

    .line 418
    .local v22, "objectId":J
    const-string v5, "recipient_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v20

    .line 419
    .local v20, "recipientId":J
    const-string v5, "username"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 420
    .local v24, "username":Ljava/lang/String;
    const-string v5, "am_following"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v25

    .line 421
    .local v25, "amFollowing":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_7
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v19, v4

    .line 422
    invoke-virtual/range {v19 .. v25}, Lco/vine/android/client/AppSessionListener;->onGetConversationRowIdComplete(JJLjava/lang/String;Z)V

    goto :goto_7

    .line 427
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v20    # "recipientId":J
    .end local v22    # "objectId":J
    .end local v24    # "username":Ljava/lang/String;
    .end local v25    # "amFollowing":Z
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_9
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_8
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 428
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    const-string v5, "load_url"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Lco/vine/android/client/AppSessionListener;->onGetTwitterAuthUrlComplete(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_8

    .line 434
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_a
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_9
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 435
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    const-string v5, "error_code"

    const/4 v6, -0x1

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v30

    const-string v5, "a_exists"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v31

    const-string v5, "user"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v32

    check-cast v32, Lco/vine/android/api/VineUser;

    const-string v5, "login"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v33

    check-cast v33, Lco/vine/android/api/VineLogin;

    move-object/from16 v26, v4

    move-object/from16 v27, p1

    move/from16 v28, p3

    move-object/from16 v29, p4

    invoke-virtual/range {v26 .. v33}, Lco/vine/android/client/AppSessionListener;->onCheckTwitterComplete(Ljava/lang/String;ILjava/lang/String;IZLco/vine/android/api/VineUser;Lco/vine/android/api/VineLogin;)V

    goto :goto_9

    .line 442
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    :cond_2
    new-instance v150, Landroid/content/Intent;

    const-string v5, "co.vine.android.session.login"

    move-object/from16 v0, v150

    invoke-direct {v0, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 443
    .restart local v150    # "loginIntent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const-string v6, "co.vine.android.BROADCAST"

    move-object/from16 v0, v150

    invoke-virtual {v5, v0, v6}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 447
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v150    # "loginIntent":Landroid/content/Intent;
    :pswitch_b
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_a
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 448
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    const-string v5, "t_user"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v30

    check-cast v30, Lco/vine/android/api/TwitterUser;

    const-string v5, "login"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v31

    check-cast v31, Lco/vine/android/api/VineLogin;

    move-object/from16 v26, v4

    move-object/from16 v27, p1

    move/from16 v28, p3

    move-object/from16 v29, p4

    invoke-virtual/range {v26 .. v31}, Lco/vine/android/client/AppSessionListener;->onGetTwitterUserComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/TwitterUser;Lco/vine/android/api/VineLogin;)V

    goto :goto_a

    .line 455
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_c
    const-string v5, "login"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v10

    check-cast v10, Lco/vine/android/api/VineLogin;

    .line 456
    .restart local v10    # "vl":Lco/vine/android/api/VineLogin;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_b
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 457
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2, v10}, Lco/vine/android/client/AppSessionListener;->onTwitterxAuthComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineLogin;)V

    goto :goto_b

    .line 462
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v10    # "vl":Lco/vine/android/api/VineLogin;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_d
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_c
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 463
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onResetPasswordComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_c

    .line 468
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_e
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_d
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 469
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    const-string v5, "conversation_row_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v30

    move-object/from16 v26, v4

    move-object/from16 v27, p1

    move/from16 v28, p3

    move-object/from16 v29, p4

    invoke-virtual/range {v26 .. v31}, Lco/vine/android/client/AppSessionListener;->onIgnoreConversationComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_d

    .line 475
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_f
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_e
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 476
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    const-string v5, "conversation_row_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v30

    move-object/from16 v26, v4

    move-object/from16 v27, p1

    move/from16 v28, p3

    move-object/from16 v29, p4

    invoke-virtual/range {v26 .. v31}, Lco/vine/android/client/AppSessionListener;->onDeleteConversationComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_e

    .line 487
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_10
    const-string v5, "count"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v31

    .line 488
    .local v31, "count":I
    const-string v5, "next_page"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v33

    .line 489
    .local v33, "nextPage":I
    const-string v5, "previous_page"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v34

    .line 490
    .local v34, "previousPage":I
    const-string v5, "time"

    const-wide/16 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v35

    .line 491
    .local v35, "anchor":J
    const-string v5, "users"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v32

    .line 492
    .local v32, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_f
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 493
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->getCachedActiveSession()Lco/vine/android/client/Session;

    move-result-object v27

    move-object/from16 v26, v4

    move-object/from16 v28, p1

    move/from16 v29, p3

    move-object/from16 v30, p4

    invoke-virtual/range {v26 .. v36}, Lco/vine/android/client/AppSessionListener;->onGetUsersComplete(Lco/vine/android/client/Session;Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;IIJ)V

    goto :goto_f

    .line 499
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v31    # "count":I
    .end local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v33    # "nextPage":I
    .end local v34    # "previousPage":I
    .end local v35    # "anchor":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_11
    const-string v5, "type"

    const/4 v6, -0x1

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v41

    .line 500
    .local v41, "type":I
    const-string v5, "count"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v31

    .line 501
    .restart local v31    # "count":I
    const-string v5, "size"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v52

    .line 502
    .local v52, "size":I
    const-string v5, "tag_name"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v45

    .line 503
    .local v45, "tag":Ljava/lang/String;
    const-string v5, "page_type"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v46

    .line 504
    .local v46, "pageType":I
    const-string v5, "next_page"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v47

    .line 505
    .local v47, "next":I
    const-string v5, "previous_page"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v48

    .line 506
    .local v48, "previous":I
    const-string v5, "time"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v35

    .line 507
    .restart local v35    # "anchor":J
    const-string v5, "title"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v53

    .line 508
    .local v53, "title":Ljava/lang/String;
    const-string v5, "user_init"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v51

    .line 509
    .local v51, "userInitiated":Z
    const-string v5, "in_memory"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v43

    .line 511
    .local v43, "memory":Z
    if-eqz v43, :cond_3

    .line 512
    const-string v5, "posts"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v44

    .line 516
    .local v44, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    :goto_10
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_11
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v37, v4

    move-object/from16 v38, p1

    move/from16 v39, p3

    move-object/from16 v40, p4

    move/from16 v42, v31

    move-wide/from16 v49, v35

    .line 517
    invoke-virtual/range {v37 .. v53}, Lco/vine/android/client/AppSessionListener;->onGetTimeLineComplete(Ljava/lang/String;ILjava/lang/String;IIZLjava/util/ArrayList;Ljava/lang/String;IIIJZILjava/lang/String;)V

    goto :goto_11

    .line 514
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v44    # "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    .end local v143    # "i$":Ljava/util/Iterator;
    :cond_3
    const/16 v44, 0x0

    .restart local v44    # "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    goto :goto_10

    .line 521
    .restart local v143    # "i$":Ljava/util/Iterator;
    :cond_4
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_0

    .line 522
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/client/AppController;->determineCleanup(Lco/vine/android/client/Session;)V

    goto/16 :goto_0

    .line 527
    .end local v31    # "count":I
    .end local v35    # "anchor":J
    .end local v41    # "type":I
    .end local v43    # "memory":Z
    .end local v44    # "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    .end local v45    # "tag":Ljava/lang/String;
    .end local v46    # "pageType":I
    .end local v47    # "next":I
    .end local v48    # "previous":I
    .end local v51    # "userInitiated":Z
    .end local v52    # "size":I
    .end local v53    # "title":Ljava/lang/String;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_12
    const-string v5, "next_page"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v47

    .line 528
    .restart local v47    # "next":I
    const-string v5, "time"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v35

    .line 529
    .restart local v35    # "anchor":J
    const-string v5, "comments"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v61

    .line 531
    .local v61, "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_12
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v54, v4

    move-object/from16 v55, p1

    move/from16 v56, p3

    move-object/from16 v57, p4

    move/from16 v58, v47

    move-wide/from16 v59, v35

    .line 532
    invoke-virtual/range {v54 .. v61}, Lco/vine/android/client/AppSessionListener;->onGetCommentsComplete(Ljava/lang/String;ILjava/lang/String;IJLjava/util/ArrayList;)V

    goto :goto_12

    .line 537
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v35    # "anchor":J
    .end local v47    # "next":I
    .end local v61    # "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_13
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_13
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 538
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    const-string v5, "conversation_row_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v66

    const-string v5, "resp_code"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v68

    const-string v5, "empty"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v69

    move-object/from16 v62, v4

    move-object/from16 v63, p1

    move/from16 v64, p3

    move-object/from16 v65, p4

    invoke-virtual/range {v62 .. v69}, Lco/vine/android/client/AppSessionListener;->onGetConversationComplete(Ljava/lang/String;ILjava/lang/String;JIZ)V

    goto :goto_13

    .line 546
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_14
    const-string v5, "post_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v66

    .line 547
    .local v66, "id":J
    const-string v5, "comment_obj"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v69

    check-cast v69, Lco/vine/android/api/VineComment;

    .line 548
    .local v69, "comment":Lco/vine/android/api/VineComment;
    const-string v5, "comment"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v68

    .line 549
    .local v68, "commentText":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_14
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v62, v4

    move-object/from16 v63, p1

    move/from16 v64, p3

    move-object/from16 v65, p4

    .line 550
    invoke-virtual/range {v62 .. v69}, Lco/vine/android/client/AppSessionListener;->onPostCommentComplete(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Lco/vine/android/api/VineComment;)V

    goto :goto_14

    .line 555
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v66    # "id":J
    .end local v68    # "commentText":Ljava/lang/String;
    .end local v69    # "comment":Lco/vine/android/api/VineComment;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_15
    const-string v5, "post_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v58

    .line 556
    .local v58, "postId":J
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_15
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v54, v4

    move-object/from16 v55, p1

    move/from16 v56, p3

    move-object/from16 v57, p4

    .line 557
    invoke-virtual/range {v54 .. v59}, Lco/vine/android/client/AppSessionListener;->onReportPostComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_15

    .line 562
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v58    # "postId":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_16
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v157

    .line 563
    .local v157, "prefs":Landroid/content/SharedPreferences;
    invoke-interface/range {v157 .. v157}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v135

    .line 564
    .local v135, "e":Landroid/content/SharedPreferences$Editor;
    const-string v5, "profile_post_count"

    const/4 v6, 0x0

    move-object/from16 v0, v157

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v155

    .line 565
    .local v155, "oldCount":I
    const-string v5, "post_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v58

    .line 566
    .restart local v58    # "postId":J
    const-string v6, "profile_post_count"

    if-lez v155, :cond_5

    add-int/lit8 v5, v155, -0x1

    :goto_16
    move-object/from16 v0, v135

    invoke-interface {v0, v6, v5}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 567
    invoke-interface/range {v135 .. v135}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 569
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_17
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v70, v4

    move-object/from16 v71, p1

    move-wide/from16 v72, v58

    move/from16 v74, p3

    move-object/from16 v75, p4

    .line 570
    invoke-virtual/range {v70 .. v75}, Lco/vine/android/client/AppSessionListener;->onDeletePostComplete(Ljava/lang/String;JILjava/lang/String;)V

    goto :goto_17

    .line 566
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :cond_5
    const/4 v5, 0x0

    goto :goto_16

    .line 575
    .end local v58    # "postId":J
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v155    # "oldCount":I
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    :pswitch_17
    const-string v5, "comment_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v74

    .line 576
    .local v74, "commentId":J
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_18
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v70, v4

    move-object/from16 v71, p1

    move/from16 v72, p3

    move-object/from16 v73, p4

    .line 577
    invoke-virtual/range {v70 .. v75}, Lco/vine/android/client/AppSessionListener;->onDeleteCommentComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_18

    .line 582
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v74    # "commentId":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_18
    const-string v5, "user"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v82

    check-cast v82, Lco/vine/android/api/VineUser;

    .line 583
    .local v82, "meUser":Lco/vine/android/api/VineUser;
    const-string v5, "s_owner_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v80

    .line 584
    .local v80, "ownerId":J
    if-eqz v82, :cond_7

    .line 585
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v157

    .line 586
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    invoke-interface/range {v157 .. v157}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v135

    .line 587
    .restart local v135    # "e":Landroid/content/SharedPreferences$Editor;
    const-string v5, "settings_profile_name"

    move-object/from16 v0, v82

    iget-object v6, v0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 588
    const-string v5, "settings_profile_description"

    move-object/from16 v0, v82

    iget-object v6, v0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 589
    const-string v5, "settings_profile_location"

    move-object/from16 v0, v82

    iget-object v6, v0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 590
    const-string v5, "settings_profile_phone"

    move-object/from16 v0, v82

    iget-object v6, v0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 591
    const-string v5, "settings_profile_email"

    move-object/from16 v0, v82

    iget-object v6, v0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 592
    const-string v5, "settings_profile_avatar_url"

    move-object/from16 v0, v82

    iget-object v6, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 593
    const-string v5, "profile_follow_count"

    move-object/from16 v0, v82

    iget v6, v0, Lco/vine/android/api/VineUser;->followingCount:I

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 594
    const-string v5, "profile_follower_count"

    move-object/from16 v0, v82

    iget v6, v0, Lco/vine/android/api/VineUser;->followerCount:I

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 595
    const-string v5, "profile_authored_post_count"

    move-object/from16 v0, v82

    iget v6, v0, Lco/vine/android/api/VineUser;->authoredPostCount:I

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 596
    const-string v5, "profile_post_count"

    move-object/from16 v0, v82

    iget v6, v0, Lco/vine/android/api/VineUser;->postCount:I

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 597
    const-string v5, "profile_like_count"

    move-object/from16 v0, v82

    iget v6, v0, Lco/vine/android/api/VineUser;->likeCount:I

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 598
    const-string v5, "profile_loop_count"

    move-object/from16 v0, v82

    iget-wide v6, v0, Lco/vine/android/api/VineUser;->loopCount:J

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 599
    const-string v6, "settings_twitter_connected"

    move-object/from16 v0, v82

    iget v5, v0, Lco/vine/android/api/VineUser;->twitterConnected:I

    const/4 v7, 0x1

    if-ne v5, v7, :cond_8

    const/4 v5, 0x1

    :goto_19
    move-object/from16 v0, v135

    invoke-interface {v0, v6, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 600
    const-string v6, "settings_follow_editors_picks"

    move-object/from16 v0, v82

    iget v5, v0, Lco/vine/android/api/VineUser;->includePromoted:I

    const/4 v7, 0x1

    if-ne v5, v7, :cond_9

    const/4 v5, 0x1

    :goto_1a
    move-object/from16 v0, v135

    invoke-interface {v0, v6, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 601
    const-string v5, "settings_private"

    invoke-virtual/range {v82 .. v82}, Lco/vine/android/api/VineUser;->isPrivate()Z

    move-result v6

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 602
    const-string v5, "profile_email_verified"

    invoke-virtual/range {v82 .. v82}, Lco/vine/android/api/VineUser;->isEmailVerified()Z

    move-result v6

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 603
    const-string v5, "profile_phone_verified"

    invoke-virtual/range {v82 .. v82}, Lco/vine/android/api/VineUser;->isPhoneVerified()Z

    move-result v6

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 604
    const-string v5, "pref_user_row_id"

    move-object/from16 v0, v82

    iget-wide v6, v0, Lco/vine/android/api/VineUser;->id:J

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 605
    move-object/from16 v0, v82

    iget-object v5, v0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    if-eqz v5, :cond_6

    .line 606
    const-string v5, "settings_edition"

    move-object/from16 v0, v82

    iget-object v6, v0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 608
    :cond_6
    const-string v5, "accept_out_of_network_messages"

    move-object/from16 v0, v82

    iget-boolean v6, v0, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 609
    const-string v6, "enable_address_book"

    move-object/from16 v0, v82

    iget-boolean v5, v0, Lco/vine/android/api/VineUser;->disableAddressBook:Z

    if-nez v5, :cond_a

    const/4 v5, 0x1

    :goto_1b
    move-object/from16 v0, v135

    invoke-interface {v0, v6, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 610
    const-string v6, "email_discoverable"

    move-object/from16 v0, v82

    iget-boolean v5, v0, Lco/vine/android/api/VineUser;->hiddenEmail:Z

    if-nez v5, :cond_b

    const/4 v5, 0x1

    :goto_1c
    move-object/from16 v0, v135

    invoke-interface {v0, v6, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 611
    const-string v6, "phone_discoverable"

    move-object/from16 v0, v82

    iget-boolean v5, v0, Lco/vine/android/api/VineUser;->hiddenPhoneNumber:Z

    if-nez v5, :cond_c

    const/4 v5, 0x1

    :goto_1d
    move-object/from16 v0, v135

    invoke-interface {v0, v6, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 613
    move-object/from16 v0, v82

    iget v5, v0, Lco/vine/android/api/VineUser;->profileBackground:I

    if-gez v5, :cond_d

    sget v159, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    .line 616
    .local v159, "profileBackground":I
    :goto_1e
    const-string v5, "profile_background"

    move-object/from16 v0, v135

    move/from16 v1, v159

    invoke-interface {v0, v5, v1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 617
    invoke-interface/range {v135 .. v135}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 619
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    .end local v159    # "profileBackground":I
    :cond_7
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_1f
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v76, v4

    move-object/from16 v77, p1

    move/from16 v78, p3

    move-object/from16 v79, p4

    .line 620
    invoke-virtual/range {v76 .. v82}, Lco/vine/android/client/AppSessionListener;->onGetUsersMeComplete(Ljava/lang/String;ILjava/lang/String;JLco/vine/android/api/VineUser;)V

    goto :goto_1f

    .line 599
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .restart local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    :cond_8
    const/4 v5, 0x0

    goto/16 :goto_19

    .line 600
    :cond_9
    const/4 v5, 0x0

    goto/16 :goto_1a

    .line 609
    :cond_a
    const/4 v5, 0x0

    goto :goto_1b

    .line 610
    :cond_b
    const/4 v5, 0x0

    goto :goto_1c

    .line 611
    :cond_c
    const/4 v5, 0x0

    goto :goto_1d

    .line 613
    :cond_d
    move-object/from16 v0, v82

    iget v0, v0, Lco/vine/android/api/VineUser;->profileBackground:I

    move/from16 v159, v0

    goto :goto_1e

    .line 625
    .end local v80    # "ownerId":J
    .end local v82    # "meUser":Lco/vine/android/api/VineUser;
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    :pswitch_19
    const-string v5, "count"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v31

    .line 626
    .restart local v31    # "count":I
    const-string v5, "users"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v32

    .line 627
    .restart local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_20
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v27, v4

    move-object/from16 v28, p1

    move/from16 v29, p3

    move-object/from16 v30, p4

    .line 628
    invoke-virtual/range {v27 .. v32}, Lco/vine/android/client/AppSessionListener;->onGetTwitterFriendsComplete(Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;)V

    goto :goto_20

    .line 633
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v31    # "count":I
    .end local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_1a
    const-string v5, "count"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v31

    .line 634
    .restart local v31    # "count":I
    const-string v5, "users"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v32

    .line 635
    .restart local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_21
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v27, v4

    move-object/from16 v28, p1

    move/from16 v29, p3

    move-object/from16 v30, p4

    .line 636
    invoke-virtual/range {v27 .. v32}, Lco/vine/android/client/AppSessionListener;->onGetAddressFriendsComplete(Ljava/lang/String;ILjava/lang/String;ILjava/util/ArrayList;)V

    goto :goto_21

    .line 642
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v31    # "count":I
    .end local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_1b
    const-string v5, "follow_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v86

    .line 644
    .restart local v86    # "userId":J
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v84

    const/16 v85, 0xa

    const/16 v88, 0x1

    const/16 v89, 0x1

    const-wide/16 v90, 0x0

    const/16 v92, 0x0

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v93

    const/16 v94, 0x0

    const/16 v95, 0x0

    move-object/from16 v83, p0

    invoke-virtual/range {v83 .. v95}, Lco/vine/android/client/AppController;->fetchPosts(Lco/vine/android/client/Session;IJIIJZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;

    .line 649
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v157

    .line 650
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    invoke-interface/range {v157 .. v157}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v135

    .line 651
    .restart local v135    # "e":Landroid/content/SharedPreferences$Editor;
    const-string v5, "profile_follow_count"

    const-string v6, "profile_follow_count"

    const/4 v7, 0x0

    move-object/from16 v0, v157

    invoke-interface {v0, v6, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 653
    invoke-interface/range {v135 .. v135}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 655
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_22
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v88, v4

    move-object/from16 v89, p1

    move/from16 v90, p3

    move-object/from16 v91, p4

    move-wide/from16 v92, v86

    .line 656
    invoke-virtual/range {v88 .. v93}, Lco/vine/android/client/AppSessionListener;->onFollowComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_22

    .line 661
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v86    # "userId":J
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    :pswitch_1c
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_23
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 662
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onBulkFollowComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_23

    .line 667
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_1d
    const-string v5, "follow_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v86

    .line 668
    .restart local v86    # "userId":J
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    move-object/from16 v0, p0

    move-wide/from16 v1, v86

    invoke-virtual {v0, v5, v1, v2}, Lco/vine/android/client/AppController;->removeFollowPosts(Lco/vine/android/client/Session;J)Ljava/lang/String;

    .line 671
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v157

    .line 672
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    invoke-interface/range {v157 .. v157}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v135

    .line 673
    .restart local v135    # "e":Landroid/content/SharedPreferences$Editor;
    const-string v5, "profile_follow_count"

    const/4 v6, 0x0

    move-object/from16 v0, v157

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v155

    .line 674
    .restart local v155    # "oldCount":I
    const-string v6, "profile_follow_count"

    if-lez v155, :cond_e

    add-int/lit8 v5, v155, -0x1

    :goto_24
    move-object/from16 v0, v135

    invoke-interface {v0, v6, v5}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 676
    invoke-interface/range {v135 .. v135}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 678
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_25
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v88, v4

    move-object/from16 v89, p1

    move/from16 v90, p3

    move-object/from16 v91, p4

    move-wide/from16 v92, v86

    .line 679
    invoke-virtual/range {v88 .. v93}, Lco/vine/android/client/AppSessionListener;->onUnFollowComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_25

    .line 674
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :cond_e
    const/4 v5, 0x0

    goto :goto_24

    .line 684
    .end local v86    # "userId":J
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v155    # "oldCount":I
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    :pswitch_1e
    const-string v5, "should_follow_editors_picks"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v162

    .line 685
    .local v162, "shouldFollow":Z
    if-nez v162, :cond_f

    .line 687
    const/4 v5, 0x1

    const/4 v6, 0x1

    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->getCachedActiveSession()Lco/vine/android/client/Session;

    move-result-object v7

    invoke-virtual {v7}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, p0

    invoke-virtual {v0, v5, v6, v7}, Lco/vine/android/client/AppController;->expireTimeline(ZILjava/lang/String;)Ljava/lang/String;

    .line 694
    :goto_26
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_27
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 695
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v162

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onUpdateFollowEditorsPicksComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_27

    .line 690
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :cond_f
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v89

    const/16 v90, 0xa

    const-wide/16 v91, 0x0

    const/16 v93, 0x1

    const/16 v94, 0x1

    const-wide/16 v95, 0x0

    const/16 v97, 0x1

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v98

    const/16 v99, 0x0

    const/16 v100, 0x0

    move-object/from16 v88, p0

    invoke-virtual/range {v88 .. v100}, Lco/vine/android/client/AppController;->fetchPosts(Lco/vine/android/client/Session;IJIIJZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;

    goto :goto_26

    .line 701
    .end local v162    # "shouldFollow":Z
    :pswitch_1f
    const-string v5, "notifications"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v92

    check-cast v92, Lco/vine/android/api/VinePagedData;

    .line 702
    .local v92, "notifications":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineEverydayNotification;>;"
    const-string v5, "follow_requests"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v93

    check-cast v93, Lco/vine/android/api/VinePagedData;

    .line 703
    .local v93, "followRequests":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineSingleNotification;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_28
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v88, v4

    move-object/from16 v89, p1

    move/from16 v90, p3

    move-object/from16 v91, p4

    .line 704
    invoke-virtual/range {v88 .. v93}, Lco/vine/android/client/AppSessionListener;->onGetActivityComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VinePagedData;Lco/vine/android/api/VinePagedData;)V

    goto :goto_28

    .line 710
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v92    # "notifications":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineEverydayNotification;>;"
    .end local v93    # "followRequests":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineSingleNotification;>;"
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_20
    const-string v5, "count"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v31

    .line 711
    .restart local v31    # "count":I
    const-string v5, "messages_count"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v152

    .line 712
    .local v152, "messagesCount":I
    const-string v5, "follow_reqs_c"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v99

    .line 713
    .local v99, "followRequestCount":I
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v137

    .line 714
    .local v137, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v5, "settings_follow_pref_count"

    move-object/from16 v0, v137

    move/from16 v1, v99

    invoke-interface {v0, v5, v1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 715
    const-string v5, "settings_unread_messages_count"

    move-object/from16 v0, v137

    move/from16 v1, v152

    invoke-interface {v0, v5, v1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 716
    invoke-interface/range {v137 .. v137}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 717
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_29
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v94, v4

    move-object/from16 v95, p1

    move/from16 v96, p3

    move-object/from16 v97, p4

    move/from16 v98, v31

    .line 718
    invoke-virtual/range {v94 .. v99}, Lco/vine/android/client/AppSessionListener;->onGetActivityCountComplete(Ljava/lang/String;ILjava/lang/String;II)V

    .line 720
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v152

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onGetMessageCountComplete(Ljava/lang/String;ILjava/lang/String;I)V

    goto :goto_29

    .line 726
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v31    # "count":I
    .end local v99    # "followRequestCount":I
    .end local v137    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v152    # "messagesCount":I
    :pswitch_21
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_2a
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 727
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Lco/vine/android/client/AppSessionListener;->onRemoveUsersComplete(Ljava/lang/String;)V

    goto :goto_2a

    .line 732
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_22
    const-string v5, "user"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v166

    check-cast v166, Lco/vine/android/api/VineUser;

    .line 733
    .local v166, "user":Lco/vine/android/api/VineUser;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_2b
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 734
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, v166

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onGetUserComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineUser;)V

    goto :goto_2b

    .line 739
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v166    # "user":Lco/vine/android/api/VineUser;
    :pswitch_23
    const-string v5, "avatar_url"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 740
    .restart local v18    # "avatarUrl":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_2c
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 741
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, v18

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onUpdateProfileComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_2c

    .line 746
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v18    # "avatarUrl":Ljava/lang/String;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_24
    const-string v5, "edition"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v136

    .line 747
    .local v136, "edition":Ljava/lang/String;
    const-string v5, "Edition update success. New edition is {}"

    move-object/from16 v0, v136

    invoke-static {v5, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 748
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_10

    .line 749
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v137

    .line 750
    .restart local v137    # "editor":Landroid/content/SharedPreferences$Editor;
    const-string v5, "settings_edition"

    move-object/from16 v0, v137

    move-object/from16 v1, v136

    invoke-interface {v0, v5, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 751
    invoke-interface/range {v137 .. v137}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 753
    .end local v137    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_10
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_2d
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 754
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, v136

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onUpdateEditionComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_2d

    .line 756
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    :cond_11
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    new-instance v6, Landroid/content/Intent;

    const-string v7, "action_edition_updated"

    invoke-direct {v6, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v7, "co.vine.android.BROADCAST"

    invoke-virtual {v5, v6, v7}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 760
    .end local v136    # "edition":Ljava/lang/String;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_25
    const-string v5, "accept_oon"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v127

    .line 761
    .local v127, "acceptOon":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_2e
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 762
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v127

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onUpdateAcceptOonComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_2e

    .line 767
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v127    # "acceptOon":Z
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_26
    const-string v5, "enable"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v139

    .line 768
    .local v139, "enableAddressBook":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_2f
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 769
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v139

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onUpdateEnableAddressBookComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_2f

    .line 775
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v139    # "enableAddressBook":Z
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_27
    const-string v5, "enable"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v42

    .line 776
    .local v42, "enable":Z
    const-string v5, "type"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v41

    .line 777
    .restart local v41    # "type":I
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_30
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v37, v4

    move-object/from16 v38, p1

    move/from16 v39, p3

    move-object/from16 v40, p4

    .line 778
    invoke-virtual/range {v37 .. v42}, Lco/vine/android/client/AppSessionListener;->onUpdateDiscoverability(Ljava/lang/String;ILjava/lang/String;IZ)V

    goto :goto_30

    .line 784
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v41    # "type":I
    .end local v42    # "enable":Z
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_28
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    const-string v6, "last_cleanup"

    invoke-static {v5, v6}, Lco/vine/android/util/Util;->getSharedPrefs(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;

    move-result-object v157

    .line 786
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    invoke-interface/range {v157 .. v157}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v137

    .line 787
    .restart local v137    # "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v147

    .line 788
    .local v147, "lastCleanupTime":J
    const-string v5, "last_cleanup"

    move-object/from16 v0, v137

    move-wide/from16 v1, v147

    invoke-interface {v0, v5, v1, v2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 789
    invoke-interface/range {v137 .. v137}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto/16 :goto_0

    .line 793
    .end local v137    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v147    # "lastCleanupTime":J
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    :pswitch_29
    const-string v5, "username"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 794
    .restart local v24    # "username":Ljava/lang/String;
    const-string v5, "key"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v105

    .line 795
    .local v105, "token":Ljava/lang/String;
    const-string v5, "secret"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v106

    .line 796
    .local v106, "secret":Ljava/lang/String;
    const-string v5, "user_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v86

    .line 797
    .restart local v86    # "userId":J
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_31
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v100, v4

    move-object/from16 v101, p1

    move/from16 v102, p3

    move-object/from16 v103, p4

    move-object/from16 v104, v24

    move-wide/from16 v107, v86

    .line 798
    invoke-virtual/range {v100 .. v108}, Lco/vine/android/client/AppSessionListener;->onConnectTwitterComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    goto :goto_31

    .line 804
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v24    # "username":Ljava/lang/String;
    .end local v86    # "userId":J
    .end local v105    # "token":Ljava/lang/String;
    .end local v106    # "secret":Ljava/lang/String;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_2a
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_32
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 805
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onDisconnectTwitterComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_32

    .line 810
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_2b
    const-string v5, "post_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v58

    .line 812
    .restart local v58    # "postId":J
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_12

    .line 814
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v157

    .line 815
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    invoke-interface/range {v157 .. v157}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v135

    .line 816
    .restart local v135    # "e":Landroid/content/SharedPreferences$Editor;
    const-string v5, "profile_like_count"

    const-string v6, "profile_like_count"

    const/4 v7, 0x0

    move-object/from16 v0, v157

    invoke-interface {v0, v6, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 817
    invoke-interface/range {v135 .. v135}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 820
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    :cond_12
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_33
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v54, v4

    move-object/from16 v55, p1

    move/from16 v56, p3

    move-object/from16 v57, p4

    .line 821
    invoke-virtual/range {v54 .. v59}, Lco/vine/android/client/AppSessionListener;->onLikePost(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_33

    .line 826
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v58    # "postId":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_2c
    const-string v5, "post_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v58

    .line 828
    .restart local v58    # "postId":J
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_13

    .line 830
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v157

    .line 831
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    invoke-interface/range {v157 .. v157}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v135

    .line 832
    .restart local v135    # "e":Landroid/content/SharedPreferences$Editor;
    const-string v5, "profile_like_count"

    const/4 v6, 0x0

    move-object/from16 v0, v157

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v155

    .line 833
    .restart local v155    # "oldCount":I
    const-string v6, "profile_like_count"

    if-lez v155, :cond_14

    add-int/lit8 v5, v155, -0x1

    :goto_34
    move-object/from16 v0, v135

    invoke-interface {v0, v6, v5}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 834
    invoke-interface/range {v135 .. v135}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 837
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v155    # "oldCount":I
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    :cond_13
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_35
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v54, v4

    move-object/from16 v55, p1

    move/from16 v56, p3

    move-object/from16 v57, p4

    .line 838
    invoke-virtual/range {v54 .. v59}, Lco/vine/android/client/AppSessionListener;->onUnlikePost(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_35

    .line 833
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .restart local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .restart local v155    # "oldCount":I
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    :cond_14
    const/4 v5, 0x0

    goto :goto_34

    .line 843
    .end local v58    # "postId":J
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v155    # "oldCount":I
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    :pswitch_2d
    const-string v5, "post_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v58

    .line 844
    .restart local v58    # "postId":J
    const-string v5, "repost"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v60

    check-cast v60, Lco/vine/android/api/VineRepost;

    .line 846
    .local v60, "repost":Lco/vine/android/api/VineRepost;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_36
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v54, v4

    move-object/from16 v55, p1

    move/from16 v56, p3

    move-object/from16 v57, p4

    .line 847
    invoke-virtual/range {v54 .. v60}, Lco/vine/android/client/AppSessionListener;->onRevine(Ljava/lang/String;ILjava/lang/String;JLco/vine/android/api/VineRepost;)V

    goto :goto_36

    .line 852
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v58    # "postId":J
    .end local v60    # "repost":Lco/vine/android/api/VineRepost;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_2e
    const-string v5, "post_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v58

    .line 853
    .restart local v58    # "postId":J
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_37
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v54, v4

    move-object/from16 v55, p1

    move/from16 v56, p3

    move-object/from16 v57, p4

    .line 854
    invoke-virtual/range {v54 .. v59}, Lco/vine/android/client/AppSessionListener;->onUnrevine(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_37

    .line 859
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v58    # "postId":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_2f
    const-string v5, "post_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v58

    .line 860
    .restart local v58    # "postId":J
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_38
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v54, v4

    move-object/from16 v55, p1

    move/from16 v56, p3

    move-object/from16 v57, p4

    .line 861
    invoke-virtual/range {v54 .. v59}, Lco/vine/android/client/AppSessionListener;->onGetPostIdComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_38

    .line 866
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v58    # "postId":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_30
    const-string v5, "user_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v86

    .line 867
    .restart local v86    # "userId":J
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_39
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v107, v4

    move-object/from16 v108, p1

    move/from16 v109, p3

    move-object/from16 v110, p4

    move-wide/from16 v111, v86

    .line 868
    invoke-virtual/range {v107 .. v112}, Lco/vine/android/client/AppSessionListener;->onGetUserIdComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_39

    .line 873
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v86    # "userId":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_31
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_3a
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 874
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    const-string v5, "post"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Lco/vine/android/api/VinePost;

    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2, v5}, Lco/vine/android/client/AppSessionListener;->onGetSinglePostComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VinePost;)V

    goto :goto_3a

    .line 880
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_32
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_3b
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 881
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onConnectFacebookComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_3b

    .line 886
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_33
    const-string v5, "user_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v86

    .line 887
    .restart local v86    # "userId":J
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_3c
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v107, v4

    move-object/from16 v108, p1

    move/from16 v109, p3

    move-object/from16 v110, p4

    move-wide/from16 v111, v86

    .line 888
    invoke-virtual/range {v107 .. v112}, Lco/vine/android/client/AppSessionListener;->onGcmRegistrationComplete(Ljava/lang/String;ILjava/lang/String;J)V

    goto :goto_3c

    .line 894
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v86    # "userId":J
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_34
    const-string v5, "s_key"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lco/vine/android/client/AppController;->deleteSession(Ljava/lang/String;)Ljava/lang/String;

    goto/16 :goto_0

    .line 898
    :pswitch_35
    const-string v5, "notifications"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v154

    .line 900
    .local v154, "notifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    const-string v5, "notification"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v149

    check-cast v149, Lco/vine/android/api/VineSingleNotification;

    .line 902
    .local v149, "lastNotification":Lco/vine/android/api/VineSingleNotification;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_3d
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 903
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, v149

    move-object/from16 v1, v154

    invoke-virtual {v4, v0, v1}, Lco/vine/android/client/AppSessionListener;->onMergeNotificationComplete(Lco/vine/android/api/VineSingleNotification;Ljava/util/ArrayList;)V

    goto :goto_3d

    .line 908
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v149    # "lastNotification":Lco/vine/android/api/VineSingleNotification;
    .end local v154    # "notifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :pswitch_36
    const-string v5, "server_status"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v163

    check-cast v163, Lco/vine/android/api/ServerStatus;

    .line 909
    .local v163, "ss":Lco/vine/android/api/ServerStatus;
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_0

    if-eqz v163, :cond_0

    move-object/from16 v0, v163

    iget-object v5, v0, Lco/vine/android/api/ServerStatus;->uploadType:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 910
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v157

    .line 911
    .restart local v157    # "prefs":Landroid/content/SharedPreferences;
    invoke-interface/range {v157 .. v157}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v135

    .line 912
    .restart local v135    # "e":Landroid/content/SharedPreferences$Editor;
    const-string v5, "server_upload_type"

    move-object/from16 v0, v163

    iget-object v6, v0, Lco/vine/android/api/ServerStatus;->uploadType:Ljava/lang/String;

    move-object/from16 v0, v135

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 913
    invoke-interface/range {v135 .. v135}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto/16 :goto_0

    .line 918
    .end local v135    # "e":Landroid/content/SharedPreferences$Editor;
    .end local v157    # "prefs":Landroid/content/SharedPreferences;
    .end local v163    # "ss":Lco/vine/android/api/ServerStatus;
    :pswitch_37
    const-string v5, "count"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v31

    .line 919
    .restart local v31    # "count":I
    const-string v5, "next_page"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v33

    .line 920
    .restart local v33    # "nextPage":I
    const-string v5, "previous_page"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v34

    .line 922
    .restart local v34    # "previousPage":I
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_3e
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v107, v4

    move-object/from16 v108, p1

    move/from16 v109, p3

    move-object/from16 v110, p4

    move/from16 v111, v31

    move/from16 v112, v33

    move/from16 v113, v34

    .line 923
    invoke-virtual/range {v107 .. v113}, Lco/vine/android/client/AppSessionListener;->onUserSearchComplete(Ljava/lang/String;ILjava/lang/String;III)V

    goto :goto_3e

    .line 929
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v31    # "count":I
    .end local v33    # "nextPage":I
    .end local v34    # "previousPage":I
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_38
    const-string v5, "q"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v111

    .line 930
    .local v111, "query":Ljava/lang/String;
    const-string v5, "users"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v32

    .line 931
    .restart local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_3f
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v107, v4

    move-object/from16 v108, p1

    move/from16 v109, p3

    move-object/from16 v110, p4

    move-object/from16 v112, v32

    .line 932
    invoke-virtual/range {v107 .. v112}, Lco/vine/android/client/AppSessionListener;->onGetUserTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_3f

    .line 937
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v111    # "query":Ljava/lang/String;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_39
    const-string v5, "q"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v111

    .line 938
    .restart local v111    # "query":Ljava/lang/String;
    const-string v5, "users"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v32

    .line 939
    .restart local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_40
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v107, v4

    move-object/from16 v108, p1

    move/from16 v109, p3

    move-object/from16 v110, p4

    move-object/from16 v112, v32

    .line 940
    invoke-virtual/range {v107 .. v112}, Lco/vine/android/client/AppSessionListener;->onGetFriendsTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_40

    .line 945
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v32    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v111    # "query":Ljava/lang/String;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_3a
    const-string v5, "q"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v111

    .line 946
    .restart local v111    # "query":Ljava/lang/String;
    const-string v5, "tags"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v112

    .line 947
    .local v112, "tags":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineTag;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_41
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v107, v4

    move-object/from16 v108, p1

    move/from16 v109, p3

    move-object/from16 v110, p4

    .line 948
    invoke-virtual/range {v107 .. v112}, Lco/vine/android/client/AppSessionListener;->onGetTagTypeAheadComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_41

    .line 953
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v111    # "query":Ljava/lang/String;
    .end local v112    # "tags":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineTag;>;"
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_3b
    const-string v5, "count"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v31

    .line 954
    .restart local v31    # "count":I
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_42
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 955
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v31

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onGetMessageInboxComplete(Ljava/lang/String;ILjava/lang/String;I)V

    goto :goto_42

    .line 960
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v31    # "count":I
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_3c
    const-string v5, "count"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v31

    .line 961
    .restart local v31    # "count":I
    const-string v5, "next_page"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v33

    .line 962
    .restart local v33    # "nextPage":I
    const-string v5, "previous_page"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v34

    .line 964
    .restart local v34    # "previousPage":I
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_43
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v113, v4

    move-object/from16 v114, p1

    move/from16 v115, p3

    move-object/from16 v116, p4

    move/from16 v117, v31

    move/from16 v118, v33

    move/from16 v119, v34

    .line 965
    invoke-virtual/range {v113 .. v119}, Lco/vine/android/client/AppSessionListener;->onTagSearchComplete(Ljava/lang/String;ILjava/lang/String;III)V

    goto :goto_43

    .line 971
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v31    # "count":I
    .end local v33    # "nextPage":I
    .end local v34    # "previousPage":I
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_3d
    const-string v5, "type"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v41

    .line 972
    .restart local v41    # "type":I
    const-string v5, "tag_name"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v45

    .line 973
    .restart local v45    # "tag":Ljava/lang/String;
    const-string v5, "also_fetch_posts"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v128

    .line 975
    .local v128, "alsoFetchPosts":Z
    if-eqz v128, :cond_0

    .line 976
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v114

    const/16 v115, 0xa

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v116

    const/16 v119, 0x1

    const-wide/16 v120, 0x0

    const/16 v122, 0x1

    const/16 v124, 0x0

    const/16 v125, 0x0

    move-object/from16 v113, p0

    move/from16 v118, v41

    move-object/from16 v123, v45

    invoke-virtual/range {v113 .. v125}, Lco/vine/android/client/AppController;->fetchPosts(Lco/vine/android/client/Session;IJIIJZLjava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;

    goto/16 :goto_0

    .line 982
    .end local v41    # "type":I
    .end local v45    # "tag":Ljava/lang/String;
    .end local v128    # "alsoFetchPosts":Z
    :pswitch_3e
    const-string v5, "response_success"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v164

    .line 983
    .local v164, "success":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_44
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 984
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v164

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onDeactivateAccountComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_44

    .line 989
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v164    # "success":Z
    :pswitch_3f
    const-string v5, "blocked_users"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v130

    .line 991
    .local v130, "blockedUsers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_45
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 992
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, v130

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onGetBlockedUsersComplete(Ljava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_45

    .line 997
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v130    # "blockedUsers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_40
    const-string v5, "response_success"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v167

    .line 998
    .local v167, "userBlocked":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_46
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 999
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v167

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onBlockUserComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_46

    .line 1004
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v167    # "userBlocked":Z
    :pswitch_41
    const-string v5, "response_success"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v168

    .line 1005
    .local v168, "userUnblocked":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_47
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1006
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v168

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onUnblockUserComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_47

    .line 1011
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v168    # "userUnblocked":Z
    :pswitch_42
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_48
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1012
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onReportUserComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_48

    .line 1017
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_43
    const-string v5, "response_success"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v164

    .line 1018
    .restart local v164    # "success":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_49
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1019
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v164

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onEnableUserRepostsComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_49

    .line 1024
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v164    # "success":Z
    :pswitch_44
    const-string v5, "response_success"

    const/4 v6, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v164

    .line 1025
    .restart local v164    # "success":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_4a
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1026
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v164

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onDisableUserRepostsComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_4a

    .line 1031
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v164    # "success":Z
    :pswitch_45
    const-string v5, "user_id"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v86

    .line 1032
    .restart local v86    # "userId":J
    const-string v5, "accept"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v117

    .line 1033
    .local v117, "accept":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_4b
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v113, v4

    move-object/from16 v114, p1

    move/from16 v115, p3

    move-object/from16 v116, p4

    move-wide/from16 v118, v86

    .line 1034
    invoke-virtual/range {v113 .. v119}, Lco/vine/android/client/AppSessionListener;->onRespondFollowRequestComplete(Ljava/lang/String;ILjava/lang/String;ZJ)V

    goto :goto_4b

    .line 1040
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v86    # "userId":J
    .end local v117    # "accept":Z
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_46
    const-string v5, "explicit"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v140

    .line 1041
    .local v140, "explicit":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_4c
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1042
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v140

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onUpdateExplicitComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_4c

    .line 1047
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v140    # "explicit":Z
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_47
    const-string v5, "priv"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v158

    .line 1048
    .local v158, "priv":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_4d
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_15

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1049
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v158

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onUpdatePrivateComplete(Ljava/lang/String;ILjava/lang/String;Z)V

    goto :goto_4d

    .line 1053
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v158    # "priv":Z
    :cond_15
    :pswitch_48
    const-string v5, "channels"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v131

    .line 1054
    .local v131, "channels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineChannel;>;"
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_4e
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1055
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, v131

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onGetChannelsComplete(Ljava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_4e

    .line 1060
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v131    # "channels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineChannel;>;"
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_49
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_4f
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1061
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onSharePostComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_4f

    .line 1066
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_4a
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_50
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_16

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1067
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onPostVideoComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_50

    .line 1071
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :cond_16
    :pswitch_4b
    const-string v5, "Share as a vm : {} {} {}."

    invoke-static/range {p3 .. p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    move-object/from16 v0, p1

    move-object/from16 v1, p4

    invoke-static {v5, v0, v6, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 1075
    :pswitch_4c
    const-string v5, "count"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v31

    .line 1076
    .restart local v31    # "count":I
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_17

    .line 1077
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "unread_notification_count"

    move/from16 v0, v31

    invoke-interface {v5, v6, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1080
    :cond_17
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_51
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1081
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move/from16 v3, v31

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onGetPendingNotificationCountComplete(Ljava/lang/String;ILjava/lang/String;I)V

    goto :goto_51

    .line 1087
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v31    # "count":I
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_4d
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->clearFileCache()V

    .line 1088
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_52
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1089
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onClearCacheComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_52

    .line 1094
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_4e
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_53
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1095
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    const-string v5, "editions"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v5

    check-cast v5, Ljava/util/ArrayList;

    move/from16 v0, p3

    invoke-virtual {v4, v0, v5}, Lco/vine/android/client/AppSessionListener;->onGetEditionsComplete(ILjava/util/ArrayList;)V

    goto :goto_53

    .line 1103
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_4f
    const-string v5, "phone"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v156

    .line 1104
    .local v156, "phone":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_54
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1105
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, v156

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onRequestPhoneVerificationComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_54

    .line 1110
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    .end local v156    # "phone":Ljava/lang/String;
    :pswitch_50
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_55
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1111
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onVerifyEmailComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_55

    .line 1116
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_51
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_56
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1117
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v0, v1, v2}, Lco/vine/android/client/AppSessionListener;->onVerifyPhoneNumberComplete(Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_56

    .line 1122
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_52
    const-string v5, "email"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v138

    .line 1123
    .local v138, "email":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_57
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1124
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v0, p1

    move/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, v138

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/client/AppSessionListener;->onRequestEmailVerificationComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_57

    .line 1130
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v138    # "email":Ljava/lang/String;
    .end local v143    # "i$":Ljava/util/Iterator;
    :pswitch_53
    const-string v5, "loop_submission"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v160

    check-cast v160, Lco/vine/android/api/VineLoopSubmissionResponse;

    .line 1131
    .local v160, "response":Lco/vine/android/api/VineLoopSubmissionResponse;
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_18

    if-eqz v160, :cond_18

    .line 1132
    move-object/from16 v0, v160

    iget v5, v0, Lco/vine/android/api/VineLoopSubmissionResponse;->submissionInterval:I

    int-to-long v5, v5

    const-wide/16 v7, 0x3e8

    mul-long v144, v5, v7

    .line 1133
    .local v144, "intervalMs":J
    const-string v5, "Changing loop interval from {} to {}"

    move-object/from16 v0, p0

    iget-wide v6, v0, Lco/vine/android/client/AppController;->mLoopCountSubmissionInterval:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static/range {v144 .. v145}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-static {v5, v6, v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1134
    const-wide/32 v5, 0xea60

    move-wide/from16 v0, v144

    invoke-static {v0, v1, v5, v6}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v5

    move-object/from16 v0, p0

    iput-wide v5, v0, Lco/vine/android/client/AppController;->mLoopCountSubmissionInterval:J

    .line 1135
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->scheduleLoopCounts()V

    goto/16 :goto_0

    .line 1137
    .end local v144    # "intervalMs":J
    :cond_18
    const-string v5, "loops"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v141

    .line 1138
    .local v141, "failedLoops":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/util/LoopManager$Record;>;"
    const-string v5, "Loop submission failed; re-saving {} pending loops"

    invoke-interface/range {v141 .. v141}, Ljava/util/List;->size()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1140
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/LoopManager;->get(Landroid/content/Context;)Lco/vine/android/util/LoopManager;

    move-result-object v151

    .line 1141
    .local v151, "loopManager":Lco/vine/android/util/LoopManager;
    move-object/from16 v0, v151

    move-object/from16 v1, v141

    invoke-virtual {v0, v1}, Lco/vine/android/util/LoopManager;->undoPopPendingLoops(Ljava/util/List;)V

    goto/16 :goto_0

    .line 1147
    .end local v141    # "failedLoops":Ljava/util/List;, "Ljava/util/List<Lco/vine/android/util/LoopManager$Record;>;"
    .end local v151    # "loopManager":Lco/vine/android/util/LoopManager;
    .end local v160    # "response":Lco/vine/android/api/VineLoopSubmissionResponse;
    :pswitch_54
    :try_start_1
    invoke-static/range {v132 .. v132}, Lco/vine/android/util/ClientFlagsHelper;->setLastCheckMillis(Landroid/content/Context;)V

    .line 1148
    const-string v5, "client_flags"

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v122

    check-cast v122, Lco/vine/android/api/VineClientFlags;

    .line 1149
    .local v122, "clientFlags":Lco/vine/android/api/VineClientFlags;
    const/16 v5, 0xc8

    move/from16 v0, p3

    if-ne v0, v5, :cond_0

    if-eqz v122, :cond_0

    .line 1150
    move-object/from16 v0, v132

    move-object/from16 v1, v122

    invoke-static {v0, v1}, Lco/vine/android/util/ClientFlagsHelper;->updateClientFlags(Landroid/content/Context;Lco/vine/android/api/VineClientFlags;)V

    .line 1151
    invoke-static/range {v132 .. v132}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v5

    invoke-virtual/range {v132 .. v132}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    move-object/from16 v0, v122

    invoke-virtual {v5, v0, v6}, Lco/vine/android/client/VineAPI;->refreshHostUrls(Lco/vine/android/api/VineClientFlags;Landroid/content/res/Resources;)V

    .line 1153
    const-string v5, "abort_requests"

    const/4 v6, 0x1

    move-object/from16 v0, p5

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v126

    .line 1154
    .local v126, "abortRequests":Z
    move-object/from16 v0, v132

    move-object/from16 v1, v122

    invoke-static {v0, v1}, Lco/vine/android/util/ClientFlagsHelper;->hostsDidChange(Landroid/content/Context;Lco/vine/android/api/VineClientFlags;)Z

    move-result v142

    .line 1155
    .local v142, "hostsDidChange":Z
    if-eqz v142, :cond_1a

    .line 1156
    if-eqz v126, :cond_19

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->abortAllRequests()V

    .line 1158
    :cond_19
    move-object/from16 v0, v122

    iget-object v5, v0, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1c

    const/4 v5, 0x1

    :goto_58
    invoke-static {v5}, Lco/vine/android/util/FlurryUtils;->trackZeroRatedSessionStarted(Z)V

    .line 1161
    :cond_1a
    move-object/from16 v0, v122

    iget-object v5, v0, Lco/vine/android/api/VineClientFlags;->messageTitle:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1b

    move-object/from16 v0, v122

    iget-object v5, v0, Lco/vine/android/api/VineClientFlags;->messageText:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1d

    :cond_1b
    const/16 v123, 0x1

    .line 1163
    .local v123, "showBanner":Z
    :goto_59
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_5a
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    move-object/from16 v118, v4

    move-object/from16 v119, p1

    move/from16 v120, p3

    move-object/from16 v121, p4

    .line 1164
    invoke-virtual/range {v118 .. v123}, Lco/vine/android/client/AppSessionListener;->onFetchClientFlagsComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineClientFlags;Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_5a

    .line 1168
    .end local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    .end local v122    # "clientFlags":Lco/vine/android/api/VineClientFlags;
    .end local v123    # "showBanner":Z
    .end local v126    # "abortRequests":Z
    .end local v142    # "hostsDidChange":Z
    .end local v143    # "i$":Ljava/util/Iterator;
    :catch_1
    move-exception v135

    .line 1169
    .local v135, "e":Ljava/lang/Exception;
    invoke-static/range {v135 .. v135}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 1158
    .end local v135    # "e":Ljava/lang/Exception;
    .restart local v122    # "clientFlags":Lco/vine/android/api/VineClientFlags;
    .restart local v126    # "abortRequests":Z
    .restart local v142    # "hostsDidChange":Z
    :cond_1c
    const/4 v5, 0x0

    goto :goto_58

    .line 1161
    :cond_1d
    const/16 v123, 0x0

    goto :goto_59

    .line 1174
    .end local v122    # "clientFlags":Lco/vine/android/api/VineClientFlags;
    .end local v126    # "abortRequests":Z
    .end local v142    # "hostsDidChange":Z
    :pswitch_55
    new-instance v5, Landroid/content/Intent;

    const-string v6, "abort_all_requests"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v6, "co.vine.android.BROADCAST"

    move-object/from16 v0, v132

    invoke-virtual {v0, v5, v6}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 1175
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v143

    .restart local v143    # "i$":Ljava/util/Iterator;
    :goto_5b
    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface/range {v143 .. v143}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/client/AppSessionListener;

    .line 1176
    .restart local v4    # "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v4}, Lco/vine/android/client/AppSessionListener;->onAbortAllRequestsComplete()V

    goto :goto_5b

    .line 331
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_18
        :pswitch_10
        :pswitch_12
        :pswitch_11
        :pswitch_14
        :pswitch_19
        :pswitch_1a
        :pswitch_21
        :pswitch_1b
        :pswitch_1d
        :pswitch_1f
        :pswitch_22
        :pswitch_10
        :pswitch_10
        :pswitch_2b
        :pswitch_2c
        :pswitch_23
        :pswitch_15
        :pswitch_31
        :pswitch_28
        :pswitch_17
        :pswitch_16
        :pswitch_29
        :pswitch_2a
        :pswitch_0
        :pswitch_0
        :pswitch_2f
        :pswitch_32
        :pswitch_36
        :pswitch_38
        :pswitch_3a
        :pswitch_37
        :pswitch_3c
        :pswitch_0
        :pswitch_1e
        :pswitch_3d
        :pswitch_3f
        :pswitch_40
        :pswitch_41
        :pswitch_42
        :pswitch_45
        :pswitch_46
        :pswitch_47
        :pswitch_48
        :pswitch_2d
        :pswitch_2e
        :pswitch_10
        :pswitch_0
        :pswitch_4d
        :pswitch_0
        :pswitch_33
        :pswitch_34
        :pswitch_0
        :pswitch_49
        :pswitch_0
        :pswitch_4c
        :pswitch_53
        :pswitch_3e
        :pswitch_43
        :pswitch_44
        :pswitch_4e
        :pswitch_24
        :pswitch_0
        :pswitch_0
        :pswitch_3b
        :pswitch_0
        :pswitch_13
        :pswitch_5
        :pswitch_0
        :pswitch_e
        :pswitch_f
        :pswitch_20
        :pswitch_10
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_30
        :pswitch_0
        :pswitch_4
        :pswitch_4f
        :pswitch_51
        :pswitch_8
        :pswitch_52
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_4b
        :pswitch_35
        :pswitch_4a
        :pswitch_39
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_25
        :pswitch_26
        :pswitch_1c
        :pswitch_27
        :pswitch_50
        :pswitch_10
        :pswitch_54
        :pswitch_55
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public onLowMemory()V
    .locals 3

    .prologue
    .line 1969
    iget-object v2, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/client/AppSessionListener;

    .line 1970
    .local v1, "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v1}, Lco/vine/android/client/AppSessionListener;->onLowMemory()V

    goto :goto_0

    .line 1972
    .end local v1    # "listener":Lco/vine/android/client/AppSessionListener;
    :cond_0
    return-void
.end method

.method public onMobileDataNetworkActivated()V
    .locals 3

    .prologue
    .line 2458
    iget-object v2, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/client/AppSessionListener;

    .line 2459
    .local v1, "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v1}, Lco/vine/android/client/AppSessionListener;->onMobileDataNetworkActivated()V

    goto :goto_0

    .line 2461
    .end local v1    # "listener":Lco/vine/android/client/AppSessionListener;
    :cond_0
    return-void
.end method

.method public onPhotoImageError(Lco/vine/android/util/image/PhotoImagesCache;Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V
    .locals 3
    .param p1, "cache"    # Lco/vine/android/util/image/PhotoImagesCache;
    .param p2, "key"    # Lco/vine/android/util/image/ImageKey;
    .param p3, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 2240
    iget-object v1, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    .line 2241
    .local v1, "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/client/AppSessionListener;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 2242
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v2, p2, p3}, Lco/vine/android/client/AppSessionListener;->onPhotoImageError(Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V

    .line 2241
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 2244
    :cond_0
    return-void
.end method

.method public onPhotoImageLoaded(Lco/vine/android/util/image/PhotoImagesCache;Ljava/util/HashMap;)V
    .locals 3
    .param p1, "cache"    # Lco/vine/android/util/image/PhotoImagesCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/util/image/PhotoImagesCache;",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2231
    .local p2, "image":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    const-string v2, "Image has loaded."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 2232
    iget-object v1, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    .line 2233
    .local v1, "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/client/AppSessionListener;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 2234
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v2, p2}, Lco/vine/android/client/AppSessionListener;->onPhotoImageLoaded(Ljava/util/HashMap;)V

    .line 2233
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 2236
    :cond_0
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 3
    .param p1, "level"    # I

    .prologue
    .line 1975
    iget-object v2, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/client/AppSessionListener;

    .line 1976
    .local v1, "listener":Lco/vine/android/client/AppSessionListener;
    invoke-virtual {v1, p1}, Lco/vine/android/client/AppSessionListener;->onTrimMemory(I)V

    goto :goto_0

    .line 1978
    .end local v1    # "listener":Lco/vine/android/client/AppSessionListener;
    :cond_0
    return-void
.end method

.method public onVideoPathError(Lco/vine/android/util/video/VideoCache;Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V
    .locals 3
    .param p1, "cache"    # Lco/vine/android/util/video/VideoCache;
    .param p2, "key"    # Lco/vine/android/util/video/VideoKey;
    .param p3, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 2257
    iget-object v1, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    .line 2258
    .local v1, "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/client/AppSessionListener;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 2259
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v2, p2, p3}, Lco/vine/android/client/AppSessionListener;->onVideoPathError(Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V

    .line 2258
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 2261
    :cond_0
    return-void
.end method

.method public onVideoPathObtained(Lco/vine/android/util/video/VideoCache;Ljava/util/HashMap;)V
    .locals 3
    .param p1, "cache"    # Lco/vine/android/util/video/VideoCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/util/video/VideoCache;",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Lco/vine/android/util/video/UrlVideo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2249
    .local p2, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    iget-object v1, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    .line 2250
    .local v1, "listeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/client/AppSessionListener;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 2251
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v2, p2}, Lco/vine/android/client/AppSessionListener;->onVideoPathObtained(Ljava/util/HashMap;)V

    .line 2250
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 2253
    :cond_0
    return-void
.end method

.method public peekVideoFilePath(Lco/vine/android/util/video/VideoKey;)Ljava/lang/String;
    .locals 4
    .param p1, "key"    # Lco/vine/android/util/video/VideoKey;

    .prologue
    .line 1230
    iget-object v0, p0, Lco/vine/android/client/AppController;->mVideoCache:Lco/vine/android/util/video/VideoCache;

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, p1, v3}, Lco/vine/android/util/video/VideoCache;->getFile(JLco/vine/android/util/video/VideoKey;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public postComment(JLco/vine/android/client/Session;Ljava/lang/String;Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 4
    .param p1, "postId"    # J
    .param p3, "session"    # Lco/vine/android/client/Session;
    .param p4, "comment"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Lco/vine/android/client/Session;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 1667
    .local p5, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1668
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1669
    const-string v1, "user_id"

    invoke-virtual {p3}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1670
    const-string v1, "username"

    invoke-virtual {p3}, Lco/vine/android/client/Session;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1671
    const-string v1, "comment"

    invoke-static {p4}, Lco/vine/android/util/Util;->cleanse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1672
    const-string v1, "avatar_url"

    invoke-virtual {p3}, Lco/vine/android/client/Session;->getAvatarUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1673
    const-string v1, "entities"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1674
    const/16 v1, 0xe

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public refreshSessionKey(Ljava/lang/String;)V
    .locals 1
    .param p1, "newSessionKey"    # Ljava/lang/String;

    .prologue
    .line 2129
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->getCachedActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    .line 2130
    .local v0, "activeSession":Lco/vine/android/client/Session;
    if-eqz v0, :cond_0

    .line 2131
    invoke-virtual {v0, p1}, Lco/vine/android/client/Session;->setSessionKey(Ljava/lang/String;)V

    .line 2133
    :cond_0
    return-void
.end method

.method public removeFollowPosts(Lco/vine/android/client/Session;J)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "userId"    # J

    .prologue
    .line 1505
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1506
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1507
    const/16 v1, 0x22

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public removeFromVideoCache(Lco/vine/android/util/video/VideoKey;)V
    .locals 1
    .param p1, "videoKey"    # Lco/vine/android/util/video/VideoKey;

    .prologue
    .line 1981
    iget-object v0, p0, Lco/vine/android/client/AppController;->mVideoCache:Lco/vine/android/util/video/VideoCache;

    invoke-virtual {v0, p1}, Lco/vine/android/util/video/VideoCache;->remove(Ljava/lang/Object;)Lco/vine/android/util/UrlResource;

    .line 1982
    return-void
.end method

.method public removeListener(Lco/vine/android/client/AppSessionListener;)V
    .locals 1
    .param p1, "listener"    # Lco/vine/android/client/AppSessionListener;

    .prologue
    .line 2125
    iget-object v0, p0, Lco/vine/android/client/AppController;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 2126
    return-void
.end method

.method public removeNotification(IJ)V
    .locals 2
    .param p1, "notificationId"    # I
    .param p2, "conversationRowId"    # J

    .prologue
    .line 2012
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2013
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "notification_id"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2014
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2015
    const/16 v1, 0x66

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2016
    return-void
.end method

.method public removeUsers(Lco/vine/android/client/Session;I)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "type"    # I

    .prologue
    .line 1818
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1819
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "type"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1820
    const/16 v1, 0x11

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public reportPerson(J)Ljava/lang/String;
    .locals 2
    .param p1, "userToReport"    # J

    .prologue
    .line 2326
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2327
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2328
    const/16 v1, 0x31

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public reportPost(Lco/vine/android/client/Session;J)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "postId"    # J

    .prologue
    .line 1685
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1686
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1687
    const/16 v1, 0x1b

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public requestEmailVerification(Lco/vine/android/client/Session;Ljava/lang/String;J)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "email"    # Ljava/lang/String;
    .param p3, "id"    # J

    .prologue
    .line 2399
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 2400
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "email"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2401
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2402
    const/16 v1, 0x5c

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public requestPhoneVerification(Lco/vine/android/client/Session;Ljava/lang/String;J)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "phone"    # Ljava/lang/String;
    .param p3, "id"    # J

    .prologue
    .line 2392
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 2393
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "phone"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2394
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2395
    const/16 v1, 0x59

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public resetPassword(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    .line 1603
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1604
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "login"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1605
    const/16 v1, 0x9

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public retryMessagesInConversationRowId(J)V
    .locals 2
    .param p1, "conversationRowId"    # J

    .prologue
    .line 2019
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2020
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2021
    const/16 v1, 0x67

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 2022
    return-void
.end method

.method public retryRequest(ILandroid/os/Bundle;)Ljava/lang/String;
    .locals 1
    .param p1, "actionCode"    # I
    .param p2, "b"    # Landroid/os/Bundle;

    .prologue
    .line 2418
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-static {p2, v0}, Lco/vine/android/client/AppController;->injectServiceBundle(Landroid/os/Bundle;Lco/vine/android/client/Session;)Landroid/os/Bundle;

    .line 2419
    const-string v0, "captcha_url"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 2420
    invoke-direct {p0, p1, p2}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public revine(Ljava/lang/String;Lco/vine/android/client/Session;JLjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "session"    # Lco/vine/android/client/Session;
    .param p3, "postToRevine"    # J
    .param p5, "meUsername"    # Ljava/lang/String;

    .prologue
    .line 1484
    invoke-direct {p0, p2}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1485
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1486
    const-string v1, "username"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1487
    invoke-static {p3, p4, p1}, Lco/vine/android/util/FlurryUtils;->trackRevine(JLjava/lang/String;)V

    .line 1488
    const/16 v1, 0x36

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public saveLoadedPosts(Ljava/util/ArrayList;ILjava/lang/String;IIIJZ)Ljava/lang/String;
    .locals 2
    .param p2, "groupType"    # I
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "pageType"    # I
    .param p5, "next"    # I
    .param p6, "previous"    # I
    .param p7, "anchor"    # J
    .param p9, "userInitiated"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;I",
            "Ljava/lang/String;",
            "IIIJZ)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 1836
    .local p1, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1837
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "posts"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1838
    const-string v1, "type"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1839
    const-string v1, "tag_name"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1840
    const-string v1, "page_type"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1841
    const-string v1, "next_page"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1842
    const-string v1, "previous_page"

    invoke-virtual {v0, v1, p6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1843
    const-string v1, "time"

    invoke-virtual {v0, v1, p7, p8}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1844
    const-string v1, "user_init"

    invoke-virtual {v0, v1, p9}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1845
    const/16 v1, 0x2b

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public saveNotificationSettings(Ljava/util/HashMap;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 2038
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2039
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "notificationSettings"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 2040
    const/16 v1, 0x72

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public scheduleLoopCounts()V
    .locals 4

    .prologue
    .line 1913
    iget-object v0, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    .line 1914
    iget-object v0, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/client/AppController;->mLoopCountRunnable:Lco/vine/android/client/AppController$LoopCountRunnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1915
    iget-object v0, p0, Lco/vine/android/client/AppController;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lco/vine/android/client/AppController;->mLoopCountRunnable:Lco/vine/android/client/AppController$LoopCountRunnable;

    iget-wide v2, p0, Lco/vine/android/client/AppController;->mLoopCountSubmissionInterval:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1917
    :cond_0
    return-void
.end method

.method public searchTags(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "pageType"    # I

    .prologue
    .line 2299
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2300
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "q"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2301
    const-string v1, "page_type"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2302
    const/16 v1, 0x2a

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public searchUsers(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "pageType"    # I

    .prologue
    .line 2292
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2293
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "q"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2294
    const-string v1, "page_type"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2295
    const/16 v1, 0x29

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public sendAddressBook()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1813
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1814
    .local v0, "b":Landroid/os/Bundle;
    const/16 v1, 0x65

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public sendFacebookToken()Ljava/lang/String;
    .locals 3

    .prologue
    .line 1697
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1698
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "facebook_token"

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getPendingFacebookToken()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1699
    const/16 v1, 0x25

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public sendGcmRegId(Ljava/lang/String;J)Ljava/lang/String;
    .locals 2
    .param p1, "regId"    # Ljava/lang/String;
    .param p2, "userId"    # J

    .prologue
    .line 1703
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1704
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "gcmRegId"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1705
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1706
    const/16 v1, 0x3c

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public sendLoopCounts()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1920
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->scheduleLoopCounts()V

    .line 1921
    iget-object v3, p0, Lco/vine/android/client/AppController;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lco/vine/android/util/LoopManager;->get(Landroid/content/Context;)Lco/vine/android/util/LoopManager;

    move-result-object v1

    .line 1923
    .local v1, "loopManager":Lco/vine/android/util/LoopManager;
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1924
    .local v0, "b":Landroid/os/Bundle;
    new-instance v2, Ljava/util/ArrayList;

    invoke-virtual {v1}, Lco/vine/android/util/LoopManager;->popPendingLoops()Ljava/util/List;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1925
    .local v2, "pendingLoops":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/util/LoopManager$Record;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1926
    const-string v3, ""

    .line 1929
    :goto_0
    return-object v3

    .line 1928
    :cond_0
    const-string v3, "loops"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1929
    const/16 v3, 0x42

    invoke-direct {p0, v3, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public sendViewedVines()V
    .locals 2

    .prologue
    .line 1985
    const/16 v0, 0x55

    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1986
    return-void
.end method

.method public setHideProfileReposts(JZ)Ljava/lang/String;
    .locals 2
    .param p1, "userId"    # J
    .param p3, "block"    # Z

    .prologue
    .line 2433
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2434
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2435
    const-string v1, "block_profile_reposts"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2436
    const/16 v1, 0x57

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public setSessionKey(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 191
    invoke-static {}, Lco/vine/android/client/VineAccountHelper;->getCachedActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    .line 192
    .local v0, "activeSession":Lco/vine/android/client/Session;
    if-eqz v0, :cond_0

    .line 193
    invoke-virtual {v0, p1}, Lco/vine/android/client/Session;->setSessionKey(Ljava/lang/String;)V

    .line 195
    :cond_0
    return-void
.end method

.method public shareAsVM(Ljava/util/ArrayList;J)V
    .locals 2
    .param p2, "postId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;J)V"
        }
    .end annotation

    .prologue
    .line 1939
    .local p1, "vineRecipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1940
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "recipients"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1941
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1942
    const/16 v1, 0x60

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1943
    return-void
.end method

.method public sharePost(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 2
    .param p1, "network"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "postId"    # J

    .prologue
    .line 1946
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1947
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "network"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1948
    const-string v1, "message"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1949
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1950
    const/16 v1, 0x3f

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 1951
    return-void
.end method

.method public signUp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Lco/vine/android/api/TwitterUser;Lco/vine/android/api/VineLogin;)Ljava/lang/String;
    .locals 3
    .param p1, "login"    # Ljava/lang/String;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "username"    # Ljava/lang/String;
    .param p4, "phoneNumber"    # Ljava/lang/String;
    .param p5, "profileUri"    # Landroid/net/Uri;
    .param p6, "twitterUser"    # Lco/vine/android/api/TwitterUser;
    .param p7, "vl"    # Lco/vine/android/api/VineLogin;

    .prologue
    .line 1580
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1581
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "login"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1582
    const-string v1, "pass"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1583
    const-string v1, "a_name"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1584
    const-string v1, "phone"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1585
    const-string v1, "uri"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1586
    const-string v1, "t_user"

    invoke-virtual {v0, v1, p6}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1587
    if-eqz p7, :cond_0

    .line 1588
    const-string v1, "key"

    iget-object v2, p7, Lco/vine/android/api/VineLogin;->twitterToken:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1589
    const-string v1, "secret"

    iget-object v2, p7, Lco/vine/android/api/VineLogin;->twitterSecret:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1591
    :cond_0
    const/4 v1, 0x4

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public unRevine(Ljava/lang/String;Lco/vine/android/client/Session;JJZJZ)Ljava/lang/String;
    .locals 2
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "session"    # Lco/vine/android/client/Session;
    .param p3, "postToUnrevine"    # J
    .param p5, "repostId"    # J
    .param p7, "following"    # Z
    .param p8, "userId"    # J
    .param p10, "notify"    # Z

    .prologue
    .line 1494
    invoke-direct {p0, p2}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1495
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1496
    const-string v1, "repost_id"

    invoke-virtual {v0, v1, p5, p6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1497
    const-string v1, "notify"

    invoke-virtual {v0, v1, p10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1498
    const-string v1, "following"

    invoke-virtual {v0, v1, p7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1499
    invoke-static {p1}, Lco/vine/android/util/FlurryUtils;->trackUnRevine(Ljava/lang/String;)V

    .line 1501
    const/16 v1, 0x37

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public unblockUser(J)Ljava/lang/String;
    .locals 4
    .param p1, "userToUnblock"    # J

    .prologue
    .line 2319
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 2320
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "user_id"

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2321
    const-string v1, "block_user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 2322
    const/16 v1, 0x30

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public unfollowUser(Lco/vine/android/client/Session;JZ)Ljava/lang/String;
    .locals 7
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "userIdToUnfollow"    # J
    .param p4, "notify"    # Z

    .prologue
    .line 1451
    const-wide/16 v5, -0x1

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move v4, p4

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->unfollowUser(Lco/vine/android/client/Session;JZJ)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public unfollowUser(Lco/vine/android/client/Session;JZJ)Ljava/lang/String;
    .locals 4
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "userIdToUnfollow"    # J
    .param p4, "notify"    # Z
    .param p5, "currentProfileId"    # J

    .prologue
    .line 1456
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1457
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "follow_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1458
    const-string v1, "profile_id"

    invoke-virtual {v0, v1, p5, p6}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1459
    const-string v1, "user_id"

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1460
    const-string v1, "notify"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1461
    const/16 v1, 0x13

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public unlikePost(Ljava/lang/String;Lco/vine/android/client/Session;JZ)Ljava/lang/String;
    .locals 2
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "session"    # Lco/vine/android/client/Session;
    .param p3, "postToUnlike"    # J
    .param p5, "notify"    # Z

    .prologue
    .line 1476
    invoke-direct {p0, p2}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1477
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "post_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 1478
    const-string v1, "notify"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1479
    invoke-static {p1}, Lco/vine/android/util/FlurryUtils;->trackUnLikePost(Ljava/lang/String;)V

    .line 1480
    const/16 v1, 0x19

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateAcceptOon(Z)Ljava/lang/String;
    .locals 2
    .param p1, "acceptOon"    # Z

    .prologue
    .line 1333
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1334
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "accept_oon"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1335
    const/16 v1, 0x69

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateClientProfile()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1661
    const-string v0, "Update Client Profile."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 1662
    const/16 v0, 0x23

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    invoke-direct {p0, v0, v1}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateCredentials(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 2199
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/client/Session;->setSessionKey(Ljava/lang/String;)V

    .line 2200
    return-void
.end method

.method public updateDiscoverability(IZ)Ljava/lang/String;
    .locals 2
    .param p1, "type"    # I
    .param p2, "enable"    # Z

    .prologue
    .line 1345
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1346
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "enable"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1347
    const-string v1, "type"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1348
    const/16 v1, 0x6c

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateEdition(Lco/vine/android/client/Session;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "editionCode"    # Ljava/lang/String;

    .prologue
    .line 1881
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1882
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "edition"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1883
    const-string v1, "Updating edition code to {}"

    invoke-static {v1, p2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1884
    const/16 v1, 0x47

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateEnableAddressBook(Z)Ljava/lang/String;
    .locals 2
    .param p1, "enable"    # Z

    .prologue
    .line 1339
    invoke-direct {p0}, Lco/vine/android/client/AppController;->createServiceBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 1340
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "enable"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1341
    const/16 v1, 0x6a

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateExplicit(Lco/vine/android/client/Session;Z)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "explicit"    # Z

    .prologue
    .line 1875
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1876
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "explicit"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1877
    const/16 v1, 0x33

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updatePrivate(Lco/vine/android/client/Session;Z)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "priv"    # Z

    .prologue
    .line 1869
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1870
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "priv"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1871
    const/16 v1, 0x34

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateProfile(Lco/vine/android/client/Session;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;I)Ljava/lang/String;
    .locals 3
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "location"    # Ljava/lang/String;
    .param p5, "email"    # Ljava/lang/String;
    .param p6, "phone"    # Ljava/lang/String;
    .param p7, "avatar"    # Landroid/net/Uri;
    .param p8, "profileBackgroundColor"    # I

    .prologue
    .line 1319
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1320
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "a_name"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1321
    const-string v1, "desc"

    invoke-static {p3}, Lco/vine/android/util/Util;->cleanse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1322
    const-string v1, "location"

    invoke-static {p4}, Lco/vine/android/util/Util;->cleanse(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1323
    const-string v1, "email"

    invoke-virtual {v0, v1, p5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1324
    const-string v1, "phone"

    invoke-virtual {v0, v1, p6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1325
    const-string v1, "color_int"

    invoke-virtual {v0, v1, p8}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1326
    if-eqz p7, :cond_0

    .line 1327
    const-string v1, "uri"

    invoke-virtual {v0, v1, p7}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1329
    :cond_0
    const/16 v1, 0x1a

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public updateProfilePhoto(Lco/vine/android/client/Session;Landroid/net/Uri;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "avatar"    # Landroid/net/Uri;

    .prologue
    .line 1352
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 1353
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "uri"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1354
    const/16 v1, 0x58

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public verifyEmail(Lco/vine/android/client/Session;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "code"    # Ljava/lang/String;

    .prologue
    .line 2412
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 2413
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "key"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2414
    const/16 v1, 0x6d

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public verifyPhoneNumber(Lco/vine/android/client/Session;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "session"    # Lco/vine/android/client/Session;
    .param p2, "code"    # Ljava/lang/String;

    .prologue
    .line 2406
    invoke-direct {p0, p1}, Lco/vine/android/client/AppController;->createServiceBundle(Lco/vine/android/client/Session;)Landroid/os/Bundle;

    move-result-object v0

    .line 2407
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "key"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2408
    const/16 v1, 0x5a

    invoke-direct {p0, v1, v0}, Lco/vine/android/client/AppController;->executeServiceAction(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

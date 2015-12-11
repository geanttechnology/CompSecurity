.class public Lco/vine/android/util/FlurryUtils;
.super Ljava/lang/Object;
.source "FlurryUtils.java"


# static fields
.field private static final LOADING_KEY:Ljava/lang/String; = "Loading"

.field private static isSignupFailed:Z

.field private static final mLoadingTime:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static sRecordingCamera:Z

.field private static sRecordingFocus:Z

.field private static sRecordingGhost:Z

.field private static sRecordingGrid:Z

.field private static sRecordingSession:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lco/vine/android/util/FlurryUtils;->mLoadingTime:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getBucketedTime(J)Ljava/lang/String;
    .locals 7
    .param p0, "time"    # J

    .prologue
    const-wide/16 v5, 0x1f4

    const-wide/16 v3, 0x64

    .line 84
    const-wide/16 v0, 0x3e8

    cmp-long v0, p0, v0

    if-gez v0, :cond_0

    .line 85
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    div-long v1, p0, v3

    mul-long/2addr v1, v3

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "ms"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 87
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    div-long v1, p0, v5

    mul-long/2addr v1, v5

    long-to-double v1, v1

    const-wide v3, 0x408f400000000000L    # 1000.0

    div-double/2addr v1, v3

    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->max(DD)D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "s"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static onSignupFailure(ZLco/vine/android/api/VineError;I)V
    .locals 4
    .param p0, "twitterSignup"    # Z
    .param p1, "error"    # Lco/vine/android/api/VineError;
    .param p2, "statusCode"    # I

    .prologue
    .line 124
    const/4 v1, 0x1

    sput-boolean v1, Lco/vine/android/util/FlurryUtils;->isSignupFailed:Z

    .line 125
    new-instance v0, Lco/vine/android/util/FlurryEvent;

    const-string v1, "SignupFailure"

    invoke-direct {v0, v1}, Lco/vine/android/util/FlurryEvent;-><init>(Ljava/lang/String;)V

    .line 126
    .local v0, "event":Lco/vine/android/util/FlurryEvent;
    if-eqz p1, :cond_0

    .line 127
    const-string v1, "errorCode"

    iget v2, p1, Lco/vine/android/api/VineError;->errorCode:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v1

    const-string v2, "message"

    iget-object v3, p1, Lco/vine/android/api/VineError;->message:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    .line 129
    :cond_0
    const-string v1, "isTwitter"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v1

    const-string v2, "statusCode"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/util/FlurryEvent;->log()V

    .line 130
    return-void
.end method

.method public static onSignupSuccess(Z)V
    .locals 3
    .param p0, "twitterSignup"    # Z

    .prologue
    .line 115
    const/4 v0, 0x0

    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->isSignupFailed:Z

    .line 116
    const-string v0, "SignupSuccess"

    const-string v1, "isTwitter"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 117
    return-void
.end method

.method public static onSignupWithPreinstallSuccess(Ljava/lang/String;)V
    .locals 2
    .param p0, "target"    # Ljava/lang/String;

    .prologue
    .line 120
    const-string v0, "SignUpWithPreinstall"

    const-string v1, "target"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 121
    return-void
.end method

.method public static start(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    :try_start_0
    const-string v3, "K5MVVCSN2MQ89JDRWKGY"

    invoke-static {p0, v3}, Lcom/flurry/android/FlurryAgent;->onStartSession(Landroid/content/Context;Ljava/lang/String;)V

    .line 25
    const/4 v3, 0x1

    invoke-static {v3}, Lcom/flurry/android/FlurryAgent;->setUseHttps(Z)V

    .line 26
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    .line 27
    .local v1, "userId":J
    const-wide/16 v3, 0x0

    cmp-long v3, v1, v3

    if-lez v3, :cond_0

    .line 28
    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/flurry/android/FlurryAgent;->setUserId(Ljava/lang/String;)V

    .line 30
    :cond_0
    const-string v3, "2.1.5"

    invoke-static {v3}, Lcom/flurry/android/FlurryAgent;->setVersionName(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 34
    .end local v1    # "userId":J
    :goto_0
    return-void

    .line 31
    :catch_0
    move-exception v0

    .line 32
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static stop(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    :try_start_0
    invoke-static {p0}, Lcom/flurry/android/FlurryAgent;->onEndSession(Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 42
    :goto_0
    return-void

    .line 39
    :catch_0
    move-exception v0

    .line 40
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static traceNotificationShown()V
    .locals 1

    .prologue
    .line 447
    const-string v0, "notificationShown"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 448
    return-void
.end method

.method public static trackAbandonedStage(Ljava/lang/String;)V
    .locals 2
    .param p0, "stage"    # Ljava/lang/String;

    .prologue
    .line 237
    const-string v0, "Abandon"

    const-string v1, "stage"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 238
    return-void
.end method

.method public static trackAbandonedTier(Ljava/lang/String;)V
    .locals 6
    .param p0, "tier"    # Ljava/lang/String;

    .prologue
    .line 241
    const-string v0, "Post abandoned for {}, had to wait {}ms and {}ms."

    sget-wide v1, Lco/vine/android/recorder/BasicVineRecorder;->sTimeTaken:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    sget-wide v2, Lco/vine/android/recorder/RecordController;->sMaxKnownStopTime:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v0, p0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 242
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Post_Abandon_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "waitOnCamera"

    sget-wide v2, Lco/vine/android/recorder/BasicVineRecorder;->sTimeTaken:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    const-string v3, "waitOnProcessing"

    sget-wide v4, Lco/vine/android/recorder/RecordController;->sMaxKnownStopTime:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V

    .line 243
    return-void
.end method

.method public static trackAddressNewFollowingCount(Ljava/lang/String;)V
    .locals 2
    .param p0, "count"    # Ljava/lang/String;

    .prologue
    .line 296
    const-string v0, "FindFriendsAddressNewFollowing"

    const-string v1, "Count"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 297
    return-void
.end method

.method public static trackAttribution()V
    .locals 1

    .prologue
    .line 377
    const-string v0, "Attribution"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 378
    return-void
.end method

.method public static trackBackFromPostScreen()V
    .locals 1

    .prologue
    .line 233
    const-string v0, "BackToPreviewFromPostScreen"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 234
    return-void
.end method

.method public static trackBlockUser()V
    .locals 1

    .prologue
    .line 201
    const-string v0, "BlockUser"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 202
    return-void
.end method

.method public static trackCameraSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p0, "v"    # Landroid/view/View;

    .prologue
    .line 335
    if-eqz p0, :cond_0

    sget-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingCamera:Z

    if-nez v0, :cond_0

    .line 336
    const/4 v0, 0x1

    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingCamera:Z

    .line 337
    const-string v0, "RecordingCamera"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 339
    :cond_0
    return-void
.end method

.method public static trackCameraWidgetAdded()V
    .locals 1

    .prologue
    .line 439
    const-string v0, "CameraWidgetAdded"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 440
    return-void
.end method

.method public static trackCameraWidgetRemoved()V
    .locals 1

    .prologue
    .line 443
    const-string v0, "CameraWidgetRemoved"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 444
    return-void
.end method

.method public static trackChangedDescription()V
    .locals 1

    .prologue
    .line 266
    const-string v0, "Settings_ChangedDescription"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 267
    return-void
.end method

.method public static trackChangedEdition()V
    .locals 1

    .prologue
    .line 189
    const-string v0, "ChangedEdition"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 190
    return-void
.end method

.method public static trackChangedEmail()V
    .locals 1

    .prologue
    .line 274
    const-string v0, "Settings_ChangedEmail"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 275
    return-void
.end method

.method public static trackChangedLocation()V
    .locals 1

    .prologue
    .line 270
    const-string v0, "Settings_ChangedLocation"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 271
    return-void
.end method

.method public static trackChangedName()V
    .locals 1

    .prologue
    .line 262
    const-string v0, "Settings_ChangedName"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 263
    return-void
.end method

.method public static trackChannelChange(Ljava/lang/String;)V
    .locals 2
    .param p0, "channelDetails"    # Ljava/lang/String;

    .prologue
    .line 229
    const-string v0, "PostChannelChange"

    const-string v1, "channelDetails"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 230
    return-void
.end method

.method public static trackConnectFacebook()V
    .locals 1

    .prologue
    .line 185
    const-string v0, "ConnectFacebook"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 186
    return-void
.end method

.method public static trackConnectTwitter()V
    .locals 1

    .prologue
    .line 157
    const-string v0, "ConnectTwitter"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 158
    return-void
.end method

.method public static trackContentControls()V
    .locals 1

    .prologue
    .line 397
    const-string v0, "ContentControls"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 398
    return-void
.end method

.method public static trackCreateProfileShortCut()V
    .locals 1

    .prologue
    .line 254
    const-string v0, "CreateProfileShortCut"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 255
    return-void
.end method

.method public static trackDeactivateAccount()V
    .locals 1

    .prologue
    .line 381
    const-string v0, "DeactivateAccount"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 382
    return-void
.end method

.method public static trackDeleteComment()V
    .locals 1

    .prologue
    .line 177
    const-string v0, "DeleteComment"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 178
    return-void
.end method

.method public static trackDisConnectTwitter()V
    .locals 1

    .prologue
    .line 181
    const-string v0, "DisconnectTwitter"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 182
    return-void
.end method

.method public static trackFilterProfileReposts(ZZZ)V
    .locals 5
    .param p0, "hideReposts"    # Z
    .param p1, "isFollowing"    # Z
    .param p2, "isMe"    # Z

    .prologue
    .line 434
    if-eqz p0, :cond_0

    const-string v0, "ProfileRepostsHidden"

    .line 435
    .local v0, "eventName":Ljava/lang/String;
    :goto_0
    const-string v1, "Is Following"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    const-string v3, "Is Me"

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V

    .line 436
    return-void

    .line 434
    .end local v0    # "eventName":Ljava/lang/String;
    :cond_0
    const-string v0, "ProfileRepostsShown"

    goto :goto_0
.end method

.method public static trackFindFriendsAddressCount(I)V
    .locals 3
    .param p0, "count"    # I

    .prologue
    .line 282
    const-string v0, "FindFriendsAddressResultsCount"

    const-string v1, "Result Count"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 283
    return-void
.end method

.method public static trackFindFriendsAddressFailure()V
    .locals 1

    .prologue
    .line 289
    const-string v0, "FindFriendsAddressFailure"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 290
    return-void
.end method

.method public static trackFindFriendsTabSelect(I)V
    .locals 3
    .param p0, "position"    # I

    .prologue
    .line 413
    const-string v0, "FindFriendsTabSelect"

    const-string v1, "Address/Twitter/Search"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 414
    return-void
.end method

.method public static trackFindFriendsTwitterCount(I)V
    .locals 3
    .param p0, "count"    # I

    .prologue
    .line 285
    const-string v0, "FindFriendsTwitterResultsCount"

    const-string v1, "Result Count"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 286
    return-void
.end method

.method public static trackFindFriendsTwitterFailure()V
    .locals 1

    .prologue
    .line 292
    const-string v0, "FindFriendsTwitterFailure"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 293
    return-void
.end method

.method public static trackFocusSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p0, "v"    # Landroid/view/View;

    .prologue
    .line 342
    if-eqz p0, :cond_0

    sget-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingFocus:Z

    if-nez v0, :cond_0

    .line 343
    const/4 v0, 0x1

    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingFocus:Z

    .line 344
    const-string v0, "RecordingFocus"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 346
    :cond_0
    return-void
.end method

.method public static trackFollow(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 421
    const-string v0, "Follow"

    const-string v1, "source"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 422
    return-void
.end method

.method public static trackGetComments()V
    .locals 1

    .prologue
    .line 165
    const-string v0, "GetComments"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 166
    return-void
.end method

.method public static trackGetEditions()V
    .locals 1

    .prologue
    .line 169
    const-string v0, "GetEditions"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 170
    return-void
.end method

.method public static trackGetUser(Z)V
    .locals 3
    .param p0, "self"    # Z

    .prologue
    .line 153
    const-string v0, "ProfileFetch"

    const-string v1, "self"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 154
    return-void
.end method

.method public static trackGhostSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p0, "v"    # Landroid/view/View;

    .prologue
    .line 356
    if-eqz p0, :cond_0

    sget-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingGhost:Z

    if-nez v0, :cond_0

    .line 357
    const/4 v0, 0x1

    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingGhost:Z

    .line 358
    const-string v0, "RecordingGhost"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 360
    :cond_0
    return-void
.end method

.method public static trackGraphTimelineRefreshNewCount(I)V
    .locals 3
    .param p0, "count"    # I

    .prologue
    .line 109
    const-string v0, "GraphRefreshNewVideoCount"

    const-string v1, "count"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 110
    return-void
.end method

.method public static trackGridSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p0, "v"    # Landroid/view/View;

    .prologue
    .line 349
    if-eqz p0, :cond_0

    sget-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingGrid:Z

    if-nez v0, :cond_0

    .line 350
    const/4 v0, 0x1

    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingGrid:Z

    .line 351
    const-string v0, "RecordingGrid"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 353
    :cond_0
    return-void
.end method

.method public static trackInvite(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "type"    # Ljava/lang/String;
    .param p1, "source"    # Ljava/lang/String;

    .prologue
    .line 389
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invite_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "source"

    invoke-static {v0, v1, p1}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 390
    return-void
.end method

.method public static trackInviteBannerViewed(J)V
    .locals 4
    .param p0, "viewCount"    # J

    .prologue
    .line 417
    const-string v0, "InviteBannerViews"

    const-string v1, "ViewCount"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ">"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0, p1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 418
    return-void
.end method

.method public static trackLikePost(JLjava/lang/String;)V
    .locals 4
    .param p0, "postId"    # J
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 133
    const-string v0, "Like"

    const-string v1, "postId"

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    const-string v3, "Source View"

    invoke-static {v0, v1, v2, v3, p2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V

    .line 134
    return-void
.end method

.method public static trackLoadingTime(Ljava/lang/String;J)V
    .locals 3
    .param p0, "loadingTimeTag"    # Ljava/lang/String;
    .param p1, "time"    # J

    .prologue
    .line 77
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isProduction()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    sget-object v0, Lco/vine/android/util/FlurryUtils;->mLoadingTime:Ljava/util/HashMap;

    const-string v1, "Loading"

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Loading_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lco/vine/android/util/FlurryUtils;->mLoadingTime:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 81
    :cond_0
    return-void
.end method

.method public static trackLockOutSessionCount()V
    .locals 1

    .prologue
    .line 45
    sget-boolean v0, Lco/vine/android/util/FlurryUtils;->isSignupFailed:Z

    if-eqz v0, :cond_0

    .line 46
    const/4 v0, 0x0

    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->isSignupFailed:Z

    .line 47
    const-string v0, "SignUpLockOut"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 49
    :cond_0
    return-void
.end method

.method public static trackLoginFailure(ZI)V
    .locals 5
    .param p0, "isTwitter"    # Z
    .param p1, "statusCode"    # I

    .prologue
    .line 101
    const-string v0, "LoginFailure"

    const-string v1, "isTwitter"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    const-string v3, "statusCode"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V

    .line 102
    return-void
.end method

.method public static trackLoginSuccess(Z)V
    .locals 3
    .param p0, "isTwitter"    # Z

    .prologue
    .line 97
    const-string v0, "LoginSuccess"

    const-string v1, "isTwitter"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 98
    return-void
.end method

.method public static trackLogout()V
    .locals 1

    .prologue
    .line 312
    const-string v0, "Logout"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 313
    return-void
.end method

.method public static trackNotificationClicked(Ljava/lang/String;)V
    .locals 2
    .param p0, "type"    # Ljava/lang/String;

    .prologue
    .line 451
    const-string v0, "notificationClicked"

    const-string v1, "type"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 452
    return-void
.end method

.method public static trackNotificationDisabled()V
    .locals 1

    .prologue
    .line 459
    const-string v0, "notificationDisabled"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 460
    return-void
.end method

.method public static trackNotificationReceived(Z)V
    .locals 3
    .param p0, "isDisabled"    # Z

    .prologue
    .line 455
    const-string v0, "notificationReceived"

    const-string v1, "isDisabled"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 456
    return-void
.end method

.method public static trackNotificationSettings()V
    .locals 1

    .prologue
    .line 401
    const-string v0, "NotificationSettings"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 402
    return-void
.end method

.method public static trackPost(Z)V
    .locals 3
    .param p0, "checked"    # Z

    .prologue
    .line 225
    const-string v0, "Post"

    const-string v1, "Vine"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 226
    return-void
.end method

.method public static trackPostComment()V
    .locals 1

    .prologue
    .line 173
    const-string v0, "PostComment"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 174
    return-void
.end method

.method public static trackPostTier(Ljava/lang/String;)V
    .locals 6
    .param p0, "tier"    # Ljava/lang/String;

    .prologue
    .line 246
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Post_Posted_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "waitOnCamera"

    sget-wide v2, Lco/vine/android/recorder/BasicVineRecorder;->sTimeTaken:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    const-string v3, "waitOnProcessing"

    sget-wide v4, Lco/vine/android/recorder/RecordController;->sMaxKnownStopTime:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v0, v1, v2, v3, v4}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V

    .line 247
    return-void
.end method

.method public static trackPreviewAction(Ljava/lang/String;)V
    .locals 2
    .param p0, "action"    # Ljava/lang/String;

    .prologue
    .line 409
    const-string v0, "PreviewAction"

    const-string v1, "action"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 410
    return-void
.end method

.method public static trackPrivacyPolicy()V
    .locals 1

    .prologue
    .line 393
    const-string v0, "PrivacyPolicy"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 394
    return-void
.end method

.method public static trackProfileImageClick(Z)V
    .locals 3
    .param p0, "self"    # Z

    .prologue
    .line 429
    const-string v0, "ProfileImageClick"

    const-string v1, "self"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 430
    return-void
.end method

.method public static trackRecordingDestroy()V
    .locals 0

    .prologue
    .line 332
    return-void
.end method

.method public static trackRecordingInfo(IJJI)V
    .locals 3
    .param p0, "phase"    # I
    .param p1, "total"    # J
    .param p3, "waitTime"    # J
    .param p5, "cuts"    # I

    .prologue
    .line 52
    new-instance v0, Lco/vine/android/util/FlurryEvent;

    const-string v1, "Recording"

    invoke-direct {v0, v1}, Lco/vine/android/util/FlurryEvent;-><init>(Ljava/lang/String;)V

    const-string v1, "Duration"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v0

    const-string v1, "Wait time"

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v0

    const-string v1, "Cuts"

    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v0

    const-string v1, "Phase"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/util/FlurryEvent;->log()V

    .line 58
    return-void
.end method

.method public static trackRecordingStart()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 322
    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingCamera:Z

    .line 323
    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingFocus:Z

    .line 324
    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingGrid:Z

    .line 325
    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingGhost:Z

    .line 326
    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingSession:Z

    .line 327
    const-string v0, "RecordingStart"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 328
    return-void
.end method

.method public static trackReportPost()V
    .locals 1

    .prologue
    .line 217
    const-string v0, "ReportPost"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 218
    return-void
.end method

.method public static trackReportUser()V
    .locals 1

    .prologue
    .line 209
    const-string v0, "ReportUser"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 210
    return-void
.end method

.method public static trackResetPassword()V
    .locals 1

    .prologue
    .line 161
    const-string v0, "ResetPassword"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 162
    return-void
.end method

.method public static trackRespondTime(Ljava/lang/String;Ljava/lang/String;JJZ)V
    .locals 4
    .param p0, "host"    # Ljava/lang/String;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "firstByte"    # J
    .param p4, "durationMs"    # J
    .param p6, "isVideo"    # Z

    .prologue
    .line 61
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isProduction()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 62
    new-instance v0, Lco/vine/android/util/FlurryEvent;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Response_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-eqz p6, :cond_1

    const-string v1, "video"

    :goto_0
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lco/vine/android/util/FlurryEvent;-><init>(Ljava/lang/String;)V

    .line 63
    .local v0, "event":Lco/vine/android/util/FlurryEvent;
    if-eqz p6, :cond_2

    .line 64
    const-string v1, "host"

    invoke-virtual {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    .line 68
    :goto_1
    const-string v1, "statusTime"

    invoke-static {p2, p3}, Lco/vine/android/util/FlurryUtils;->getBucketedTime(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v1

    const-string v2, "totalTime"

    invoke-static {p4, p5}, Lco/vine/android/util/FlurryUtils;->getBucketedTime(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/util/FlurryEvent;->log()V

    .line 71
    .end local v0    # "event":Lco/vine/android/util/FlurryEvent;
    :cond_0
    return-void

    .line 62
    :cond_1
    const-string v1, "generic"

    goto :goto_0

    .line 66
    .restart local v0    # "event":Lco/vine/android/util/FlurryEvent;
    :cond_2
    const-string v1, "host"

    invoke-virtual {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v1

    const-string v2, "path"

    invoke-virtual {v1, v2, p1}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    goto :goto_1
.end method

.method public static trackRevine(JLjava/lang/String;)V
    .locals 4
    .param p0, "postId"    # J
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 141
    const-string v0, "Revine"

    const-string v1, "postId"

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    const-string v3, "Source View"

    invoke-static {v0, v1, v2, v3, p2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V

    .line 142
    return-void
.end method

.method public static trackSaveSession(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 405
    const-string v0, "SaveSession"

    const-string v1, "source"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 406
    return-void
.end method

.method public static trackSearchTags()V
    .locals 1

    .prologue
    .line 197
    const-string v0, "SearchTags"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 198
    return-void
.end method

.method public static trackSearchUsers()V
    .locals 1

    .prologue
    .line 193
    const-string v0, "SearchUser"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 194
    return-void
.end method

.method public static trackSeeReviners()V
    .locals 1

    .prologue
    .line 149
    const-string v0, "SeeReviners"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 150
    return-void
.end method

.method public static trackSessionSwitchPressed(Landroid/view/View;)V
    .locals 1
    .param p0, "v"    # Landroid/view/View;

    .prologue
    .line 363
    sget-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingSession:Z

    if-nez v0, :cond_0

    .line 364
    const/4 v0, 0x1

    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingSession:Z

    .line 365
    const-string v0, "RecordingSession"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 367
    :cond_0
    return-void
.end method

.method public static trackSessionSwitchPressedOnDraftUpgrade(I)V
    .locals 3
    .param p0, "count"    # I

    .prologue
    .line 370
    sget-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingSession:Z

    if-nez v0, :cond_0

    .line 371
    const/4 v0, 0x1

    sput-boolean v0, Lco/vine/android/util/FlurryUtils;->sRecordingSession:Z

    .line 372
    const-string v0, "RecordingSessionDraftUpgrading"

    const-string v1, "count"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 374
    :cond_0
    return-void
.end method

.method public static trackSharePost(Ljava/lang/String;J)V
    .locals 3
    .param p0, "network"    # Ljava/lang/String;
    .param p1, "postId"    # J

    .prologue
    .line 213
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SharePost_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "postId"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 214
    return-void
.end method

.method public static trackShareProfile()V
    .locals 1

    .prologue
    .line 250
    const-string v0, "ShareProfile"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 251
    return-void
.end method

.method public static trackTabChange(Ljava/lang/String;)V
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;

    .prologue
    .line 221
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Page_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 222
    return-void
.end method

.method public static trackTimeLinePageScroll(Ljava/lang/String;I)V
    .locals 3
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "page"    # I

    .prologue
    .line 105
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "TimeLinePageScroll_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "page"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 106
    return-void
.end method

.method public static trackTos()V
    .locals 1

    .prologue
    .line 385
    const-string v0, "TermsOfServiceClicked"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 386
    return-void
.end method

.method public static trackTwitterNewFollowingCount(Ljava/lang/String;)V
    .locals 2
    .param p0, "count"    # Ljava/lang/String;

    .prologue
    .line 300
    const-string v0, "FindFriendsTwitterNewFollowing"

    const-string v1, "Count"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 301
    return-void
.end method

.method public static trackUnBlockUser()V
    .locals 1

    .prologue
    .line 205
    const-string v0, "UnBlockUser"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 206
    return-void
.end method

.method public static trackUnLikePost(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 137
    const-string v0, "UnLike"

    const-string v1, "Source View"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 138
    return-void
.end method

.method public static trackUnRevine(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 145
    const-string v0, "UnRevine"

    const-string v1, "Source View"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 146
    return-void
.end method

.method public static trackUnfollow(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 425
    const-string v0, "Unfollow"

    const-string v1, "source"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 426
    return-void
.end method

.method public static trackValidPullToRefreshRelease(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 93
    const-string v0, "ValidPullToRefreshRelease"

    const-string v1, "source"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 94
    return-void
.end method

.method public static trackVineLoopWatched()V
    .locals 1

    .prologue
    .line 469
    const-string v0, "VineLoopWatched"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 470
    return-void
.end method

.method public static trackVisitFindFriends(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 278
    const-string v0, "VisitFindFriends"

    const-string v1, "source"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 279
    return-void
.end method

.method public static trackVisitInbox(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 308
    const-string v0, "VisitInbox"

    const-string v1, "source"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 309
    return-void
.end method

.method public static trackVisitSearch(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 304
    const-string v0, "VisitSearch"

    const-string v1, "source"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 305
    return-void
.end method

.method public static trackVisitSettings(Ljava/lang/String;)V
    .locals 2
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 258
    const-string v0, "VisitSettings"

    const-string v1, "source"

    invoke-static {v0, v1, p0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 259
    return-void
.end method

.method public static trackZeroRatedSessionStarted(Z)V
    .locals 1
    .param p0, "wasStarted"    # Z

    .prologue
    .line 463
    if-eqz p0, :cond_0

    .line 464
    const-string v0, "ZeroRatedSessionStarted"

    invoke-static {v0}, Lco/vine/android/util/FlurryEvent;->log(Ljava/lang/String;)V

    .line 466
    :cond_0
    return-void
.end method

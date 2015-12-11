.class public Lco/vine/android/StartActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "StartActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/StartActivity$StartSessionListener;
    }
.end annotation


# static fields
.field public static final ACTION_ACTIVITY_NOTIFICATION_PRESSED:Ljava/lang/String; = "co.vine.android.ACTIVITY_NOTIFICATION_PRESSED"

.field public static final ACTION_MESSAGE_NOTIFICATION_PRESSED:Ljava/lang/String; = "co.vine.android.MESSAGE_NOTIFICATION_PRESSED"

.field public static final ACTION_RECORD:Ljava/lang/String; = "co.vine.android.RECORD"

.field public static final ACTION_VIEW_UPLOAD_LIST:Ljava/lang/String; = "co.vine.android.UPLOAD_LIST"

.field private static final DIALOG_ACTIVATE_ACCOUNT:I = 0x1

.field public static final EXTRA_IS_NEW_USER:Ljava/lang/String; = "is_new_user"

.field public static final EXTRA_LOGIN_REQUEST:Ljava/lang/String; = "login_request_start_activity"

.field private static final PREF_LOG_STARTUP_FAIL:Ljava/lang/String; = "pref_log_startup_fail"

.field private static final REQUEST_CODE_TWITTER_SDK:I = 0x1

.field private static final STATE_AUTH_INTENT:Ljava/lang/String; = "auth_intent"

.field private static final STATE_STOP_POSITION:Ljava/lang/String; = "state_p"


# instance fields
.field private mAuthIntent:Landroid/content/Intent;

.field private mHandler:Landroid/os/Handler;

.field private mLoginRequest:Z

.field private mStopPosition:I

.field private mTwitter:Lcom/twitter/android/sdk/Twitter;

.field private mVideoView:Lco/vine/android/player/VideoViewInterface;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 74
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lco/vine/android/StartActivity;->mHandler:Landroid/os/Handler;

    .line 467
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/StartActivity;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/StartActivity;

    .prologue
    .line 43
    invoke-direct {p0}, Lco/vine/android/StartActivity;->openStartVideo()V

    return-void
.end method

.method static synthetic access$100(Lco/vine/android/StartActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/StartActivity;

    .prologue
    .line 43
    iget-object v0, p0, Lco/vine/android/StartActivity;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/StartActivity;)Lco/vine/android/player/VideoViewInterface;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/StartActivity;

    .prologue
    .line 43
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/StartActivity;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/StartActivity;

    .prologue
    .line 43
    iget-boolean v0, p0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    return v0
.end method

.method private static broadcastFinish(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 362
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 363
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "co.vine.android.FINISH"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 364
    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 365
    return-void
.end method

.method public static getStartIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 368
    const-string v0, "android.intent.action.VIEW"

    invoke-static {p0, v0}, Lco/vine/android/StartActivity;->getStartIntent(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static getStartIntent(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 372
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/StartActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 373
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {v0, p1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 374
    const v1, 0x10008000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 375
    return-object v0
.end method

.method private loginCheckTwitter(Landroid/content/Intent;Z)V
    .locals 8
    .param p1, "data"    # Landroid/content/Intent;
    .param p2, "reactivate"    # Z

    .prologue
    .line 427
    if-nez p1, :cond_0

    .line 442
    :goto_0
    return-void

    .line 430
    :cond_0
    const-string v0, "screen_name"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 431
    .local v1, "username":Ljava/lang/String;
    const-string v0, "tk"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 432
    .local v2, "mToken":Ljava/lang/String;
    const-string v0, "ts"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 434
    .local v3, "mSecret":Ljava/lang/String;
    new-instance v7, Landroid/app/ProgressDialog;

    const v0, 0x7f0f0037

    invoke-direct {v7, p0, v0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 435
    .local v7, "dialog":Landroid/app/ProgressDialog;
    const/4 v0, 0x0

    invoke-virtual {v7, v0}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 436
    const v0, 0x7f0e021d

    invoke-virtual {p0, v0}, Lco/vine/android/StartActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 437
    invoke-virtual {v7}, Landroid/app/ProgressDialog;->show()V

    .line 438
    iput-object v7, p0, Lco/vine/android/StartActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 440
    iget-object v0, p0, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    const-string v4, "user_id"

    const-wide/16 v5, 0x0

    invoke-virtual {p1, v4, v5, v6}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v4

    move v6, p2

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/client/AppController;->loginCheckTwitter(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)Ljava/lang/String;

    goto :goto_0
.end method

.method private openStartVideo()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 289
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0, v1}, Lco/vine/android/player/VideoViewInterface;->setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V

    .line 290
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0, v1}, Lco/vine/android/player/VideoViewInterface;->setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V

    .line 291
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    const v1, 0x7f060001

    invoke-static {p0, v1}, Lco/vine/android/util/SystemUtil;->getPathFromResourceRaw(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lco/vine/android/player/VideoViewInterface;->setVideoPathDirect(Ljava/lang/String;)V

    .line 292
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    iget v1, p0, Lco/vine/android/StartActivity;->mStopPosition:I

    invoke-interface {v0, v1}, Lco/vine/android/player/VideoViewInterface;->seekTo(I)V

    .line 293
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0}, Lco/vine/android/player/VideoViewInterface;->start()V

    .line 294
    return-void
.end method

.method private processIntent(Landroid/content/Intent;)Z
    .locals 19
    .param p1, "i"    # Landroid/content/Intent;

    .prologue
    .line 83
    const/4 v3, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/StartActivity;->setRequestedOrientation(I)V

    .line 84
    invoke-static/range {p0 .. p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v12

    .line 86
    .local v12, "appController":Lco/vine/android/client/AppController;
    invoke-virtual {v12}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/client/Session;->isLoggedIn()Z

    move-result v3

    if-eqz v3, :cond_a

    .line 87
    if-eqz p1, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string v10, "com.facebook.application"

    invoke-virtual {v3, v10}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 88
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    .line 92
    :goto_0
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    if-eqz v3, :cond_3

    .line 93
    const/4 v3, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lco/vine/android/StartActivity;->setResult(I)V

    .line 148
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->finish()V

    .line 149
    const/4 v3, 0x1

    .line 153
    :goto_2
    return v3

    .line 90
    :cond_1
    if-eqz p1, :cond_2

    const-string v3, "login_request_start_activity"

    const/4 v10, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v10}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    if-eqz v3, :cond_2

    const/4 v3, 0x1

    :goto_3
    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    goto :goto_0

    :cond_2
    const/4 v3, 0x0

    goto :goto_3

    .line 95
    :cond_3
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v10

    if-eqz p1, :cond_7

    const-string v3, "co.vine.android.RECORD"

    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    const/4 v3, 0x1

    :goto_4
    move-object/from16 v0, p0

    invoke-virtual {v10, v0, v12, v3}, Lco/vine/android/AppImpl;->updateClientProfile(Landroid/content/Context;Lco/vine/android/client/AppController;Z)V

    .line 97
    if-eqz p1, :cond_0

    .line 98
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v11

    .line 99
    .local v11, "action":Ljava/lang/String;
    const-string v3, "co.vine.android.RECORD"

    invoke-virtual {v3, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v16

    .line 100
    .local v16, "record":Z
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v14

    .line 101
    .local v14, "impl":Lco/vine/android/AppInterface;
    const/4 v15, 0x0

    .line 102
    .local v15, "intent":Landroid/content/Intent;
    const-string v3, "co.vine.android.MESSAGE_NOTIFICATION_PRESSED"

    invoke-virtual {v3, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 103
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    const/4 v10, 0x2

    invoke-virtual {v3, v10}, Lco/vine/android/client/AppController;->clearPushNotifications(I)V

    .line 104
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v13

    .line 105
    .local v13, "dataString":Ljava/lang/String;
    const-string v3, "username"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 106
    .local v6, "username":Ljava/lang/String;
    const-string v3, "user_id"

    const-wide/16 v17, -0x1

    move-object/from16 v0, p1

    move-wide/from16 v1, v17

    invoke-virtual {v0, v3, v1, v2}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v7

    .line 107
    .local v7, "userId":J
    const-string v3, "am_following"

    const/4 v10, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v10}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v9

    .line 108
    .local v9, "amFollowing":Z
    if-eqz v13, :cond_8

    invoke-static {v13}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 109
    .local v4, "conversationObjectId":J
    :goto_5
    const-wide/16 v17, 0x0

    cmp-long v3, v4, v17

    if-lez v3, :cond_4

    .line 110
    const/4 v10, 0x0

    move-object/from16 v3, p0

    invoke-static/range {v3 .. v10}, Lco/vine/android/ConversationActivity;->getIntent(Landroid/content/Context;JLjava/lang/String;JZZ)Landroid/content/Intent;

    move-result-object v15

    .line 111
    invoke-virtual {v15, v11}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 114
    .end local v4    # "conversationObjectId":J
    .end local v6    # "username":Ljava/lang/String;
    .end local v7    # "userId":J
    .end local v9    # "amFollowing":Z
    .end local v13    # "dataString":Ljava/lang/String;
    :cond_4
    if-nez v15, :cond_6

    .line 115
    if-nez v16, :cond_9

    .line 116
    new-instance v15, Landroid/content/Intent;

    .end local v15    # "intent":Landroid/content/Intent;
    const-class v3, Lco/vine/android/HomeTabActivity;

    move-object/from16 v0, p0

    invoke-direct {v15, v0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 117
    .restart local v15    # "intent":Landroid/content/Intent;
    const/high16 v3, 0x14000000

    invoke-virtual {v15, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 118
    invoke-virtual {v15, v11}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 119
    if-eqz v11, :cond_6

    .line 120
    const/4 v3, -0x1

    invoke-virtual {v11}, Ljava/lang/String;->hashCode()I

    move-result v10

    sparse-switch v10, :sswitch_data_0

    :cond_5
    :goto_6
    packed-switch v3, :pswitch_data_0

    .line 143
    :cond_6
    :goto_7
    if-eqz v15, :cond_0

    .line 144
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 95
    .end local v11    # "action":Ljava/lang/String;
    .end local v14    # "impl":Lco/vine/android/AppInterface;
    .end local v15    # "intent":Landroid/content/Intent;
    .end local v16    # "record":Z
    :cond_7
    const/4 v3, 0x0

    goto/16 :goto_4

    .line 108
    .restart local v6    # "username":Ljava/lang/String;
    .restart local v7    # "userId":J
    .restart local v9    # "amFollowing":Z
    .restart local v11    # "action":Ljava/lang/String;
    .restart local v13    # "dataString":Ljava/lang/String;
    .restart local v14    # "impl":Lco/vine/android/AppInterface;
    .restart local v15    # "intent":Landroid/content/Intent;
    .restart local v16    # "record":Z
    :cond_8
    const-wide/16 v4, -0x1

    goto :goto_5

    .line 120
    .end local v6    # "username":Ljava/lang/String;
    .end local v7    # "userId":J
    .end local v9    # "amFollowing":Z
    .end local v13    # "dataString":Ljava/lang/String;
    :sswitch_0
    const-string v10, "android.intent.action.VIEW"

    invoke-virtual {v11, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_5

    const/4 v3, 0x0

    goto :goto_6

    :sswitch_1
    const-string v10, "co.vine.android.ACTIVITY_NOTIFICATION_PRESSED"

    invoke-virtual {v11, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_5

    const/4 v3, 0x1

    goto :goto_6

    :sswitch_2
    const-string v10, "co.vine.android.MESSAGE_NOTIFICATION_PRESSED"

    invoke-virtual {v11, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_5

    const/4 v3, 0x2

    goto :goto_6

    .line 122
    :pswitch_0
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v15, v3}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 123
    const-string v3, "is_new_user"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 124
    const-string v3, "is_new_user"

    const/4 v10, 0x1

    invoke-virtual {v15, v3, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    goto :goto_7

    .line 128
    :pswitch_1
    invoke-virtual {v15, v11}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 129
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    const/4 v10, 0x1

    invoke-virtual {v3, v10}, Lco/vine/android/client/AppController;->clearPushNotifications(I)V

    .line 130
    const/high16 v3, 0x4000000

    invoke-virtual {v15, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    goto :goto_7

    .line 133
    :pswitch_2
    invoke-virtual {v15, v11}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 134
    const/4 v3, 0x0

    invoke-virtual {v15, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    goto :goto_7

    .line 139
    :cond_9
    const/high16 v3, 0x20000

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "StartActivity: "

    move-object/from16 v0, v17

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getCallingActivity()Landroid/content/ComponentName;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p0

    invoke-interface {v14, v0, v3, v10}, Lco/vine/android/AppInterface;->getRecordingIntent(Landroid/app/Activity;ILjava/lang/String;)Landroid/content/Intent;

    move-result-object v15

    goto/16 :goto_7

    .line 152
    .end local v11    # "action":Ljava/lang/String;
    .end local v14    # "impl":Lco/vine/android/AppInterface;
    .end local v15    # "intent":Landroid/content/Intent;
    .end local v16    # "record":Z
    :cond_a
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    const/4 v10, 0x0

    invoke-virtual {v3, v10}, Lco/vine/android/client/AppController;->fetchClientFlags(Z)V

    .line 153
    const/4 v3, 0x0

    goto/16 :goto_2

    .line 120
    nop

    :sswitch_data_0
    .sparse-switch
        -0x45ed2f16 -> :sswitch_0
        -0x112543e3 -> :sswitch_1
        -0x7cefa19 -> :sswitch_2
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static toStart(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 347
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lco/vine/android/StartActivity;->toStart(Landroid/content/Context;Z)V

    .line 348
    return-void
.end method

.method public static toStart(Landroid/content/Context;Z)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "isFromNUX"    # Z

    .prologue
    .line 351
    invoke-static {p0}, Lco/vine/android/StartActivity;->getStartIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 352
    .local v0, "i":Landroid/content/Intent;
    if-eqz p1, :cond_0

    .line 353
    const-string v1, "is_new_user"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 355
    :cond_0
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 356
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v1

    if-eqz v1, :cond_1

    instance-of v1, p0, Lco/vine/android/StartActivity;

    if-nez v1, :cond_1

    .line 357
    invoke-static {p0}, Lco/vine/android/StartActivity;->broadcastFinish(Landroid/content/Context;)V

    .line 359
    :cond_1
    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 420
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 421
    const/4 v0, 0x0

    invoke-direct {p0, p3, v0}, Lco/vine/android/StartActivity;->loginCheckTwitter(Landroid/content/Intent;Z)V

    .line 422
    iput-object p3, p0, Lco/vine/android/StartActivity;->mAuthIntent:Landroid/content/Intent;

    .line 424
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    .line 380
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 416
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 382
    :pswitch_1
    iget-boolean v2, p0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    if-eqz v2, :cond_1

    .line 383
    invoke-static {p0}, Lco/vine/android/LoginActivity;->getIntentWithFinish(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 385
    :cond_1
    invoke-static {p0}, Lco/vine/android/LoginActivity;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 390
    :pswitch_2
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 391
    .local v1, "extras":Landroid/os/Bundle;
    iget-boolean v2, p0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    if-eqz v2, :cond_2

    .line 392
    const-string v2, "finish"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 394
    :cond_2
    invoke-static {p0, v1}, Lco/vine/android/SignUpPagerActivity;->getIntent(Landroid/content/Context;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 399
    .end local v1    # "extras":Landroid/os/Bundle;
    :pswitch_3
    :try_start_0
    iget-object v2, p0, Lco/vine/android/StartActivity;->mTwitter:Lcom/twitter/android/sdk/Twitter;

    const/4 v3, 0x1

    invoke-virtual {v2, p0, v3}, Lcom/twitter/android/sdk/Twitter;->startAuthActivityForResult(Landroid/app/Activity;I)Z

    move-result v2

    if-nez v2, :cond_0

    .line 400
    iget-boolean v2, p0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    if-eqz v2, :cond_3

    .line 401
    invoke-static {p0}, Lco/vine/android/LoginTwitterActivity;->getIntentWithFinish(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 406
    :catch_0
    move-exception v0

    .line 407
    .local v0, "e":Ljava/lang/SecurityException;
    iget-boolean v2, p0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    if-eqz v2, :cond_4

    .line 408
    invoke-static {p0}, Lco/vine/android/LoginTwitterActivity;->getIntentWithFinish(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 403
    .end local v0    # "e":Ljava/lang/SecurityException;
    :cond_3
    :try_start_1
    invoke-static {p0}, Lco/vine/android/LoginTwitterActivity;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 410
    .restart local v0    # "e":Ljava/lang/SecurityException;
    :cond_4
    invoke-static {p0}, Lco/vine/android/LoginTwitterActivity;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {p0, v2}, Lco/vine/android/StartActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 380
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0222
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 22
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 164
    const v17, 0x7f030098

    const/16 v18, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v17

    move/from16 v3, v18

    invoke-super {v0, v1, v2, v3}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 166
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getIntent()Landroid/content/Intent;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/content/Intent;->getFlags()I

    move-result v17

    const/high16 v18, 0x400000

    and-int v17, v17, v18

    if-eqz v17, :cond_1

    const-string v17, "android.intent.action.MAIN"

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_1

    .line 170
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->finish()V

    .line 286
    :cond_0
    :goto_0
    return-void

    .line 174
    :cond_1
    sget v17, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v18, 0xe

    move/from16 v0, v17

    move/from16 v1, v18

    if-gt v0, v1, :cond_2

    .line 175
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v4

    .line 176
    .local v4, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v4, :cond_2

    .line 177
    invoke-virtual {v4}, Landroid/support/v7/app/ActionBar;->hide()V

    .line 182
    .end local v4    # "ab":Landroid/support/v7/app/ActionBar;
    :cond_2
    if-eqz p1, :cond_3

    :try_start_0
    const-string v17, "auth_intent"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_3

    .line 183
    const-string v17, "auth_intent"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v17

    check-cast v17, Landroid/content/Intent;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/StartActivity;->mAuthIntent:Landroid/content/Intent;

    .line 184
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/StartActivity;->mAuthIntent:Landroid/content/Intent;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move/from16 v2, v18

    invoke-direct {v0, v1, v2}, Lco/vine/android/StartActivity;->loginCheckTwitter(Landroid/content/Intent;Z)V
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 189
    :cond_3
    :try_start_1
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getIntent()Landroid/content/Intent;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Lco/vine/android/StartActivity;->processIntent(Landroid/content/Intent;)Z
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v13

    .line 197
    .local v13, "processIntent":Z
    if-nez v13, :cond_0

    .line 198
    :try_start_2
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/Util;->getActiveNetworkType(Landroid/content/Context;)I

    move-result v17

    if-nez v17, :cond_4

    .line 199
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Lco/vine/android/client/AppController;->fetchClientFlags(Z)V

    .line 202
    :cond_4
    new-instance v5, Landroid/text/style/StyleSpan;

    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-direct {v5, v0}, Landroid/text/style/StyleSpan;-><init>(I)V

    .line 203
    .local v5, "boldSpan":Landroid/text/style/StyleSpan;
    const/16 v17, 0x1

    move/from16 v0, v17

    new-array v11, v0, [Landroid/text/style/StyleSpan;

    const/16 v17, 0x0

    aput-object v5, v11, v17

    .line 207
    .local v11, "mStyleSpanBoldSingle":[Landroid/text/style/StyleSpan;
    const v17, 0x7f0a0224

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/StartActivity;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/Button;

    .line 208
    .local v9, "mSignUpEmail":Landroid/widget/Button;
    const v17, 0x7f0e022c

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/StartActivity;->getString(I)Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x22

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-static {v11, v0, v1}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v9, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 210
    move-object/from16 v0, p0

    invoke-virtual {v9, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 212
    const v17, 0x7f0a0225

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/StartActivity;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/Button;

    .line 213
    .local v10, "mSignUpTwitter":Landroid/widget/Button;
    const v17, 0x7f0e022d

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/StartActivity;->getString(I)Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x22

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-static {v11, v0, v1}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v10, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 215
    move-object/from16 v0, p0

    invoke-virtual {v10, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 217
    const v17, 0x7f0a0222

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/StartActivity;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 218
    .local v8, "mSignIn":Landroid/widget/TextView;
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 220
    const v17, 0x7f0e022a

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/StartActivity;->getString(I)Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x22

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-static {v11, v0, v1}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v15

    .line 222
    .local v15, "spanned":Landroid/text/Spanned;
    invoke-virtual {v8, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 224
    invoke-virtual {v8}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v14

    check-cast v14, Landroid/text/Spannable;

    .line 225
    .local v14, "spannable":Landroid/text/Spannable;
    invoke-interface {v15, v5}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v16

    .line 226
    .local v16, "start":I
    invoke-interface {v15, v5}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v7

    .line 228
    .local v7, "end":I
    new-instance v17, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    const v19, 0x7f090083

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getColor(I)I

    move-result v18

    invoke-direct/range {v17 .. v18}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/16 v18, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v16

    move/from16 v2, v18

    invoke-static {v14, v0, v1, v7, v2}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 231
    move-object/from16 v0, p0

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lco/vine/android/client/AppController;->getTwitter()Lcom/twitter/android/sdk/Twitter;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/StartActivity;->mTwitter:Lcom/twitter/android/sdk/Twitter;

    .line 235
    const v17, 0x7f0a0221

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/StartActivity;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Lco/vine/android/player/VideoViewInterface;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    .line 236
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    move-object/from16 v17, v0

    const/16 v18, 0x1

    invoke-interface/range {v17 .. v18}, Lco/vine/android/player/VideoViewInterface;->setKeepScreenOn(Z)V

    .line 237
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    move-object/from16 v17, v0

    const/16 v18, 0x1

    invoke-interface/range {v17 .. v18}, Lco/vine/android/player/VideoViewInterface;->setLooping(Z)V

    .line 239
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/SystemUtil;->isNormalVideoPlayable(Landroid/content/Context;)Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-result-object v17

    sget-object v18, Lco/vine/android/util/SystemUtil$PrefBooleanState;->UNKNOWN:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-ne v0, v1, :cond_6

    .line 241
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    move-object/from16 v17, v0

    const v18, 0x7f060002

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-static {v0, v1}, Lco/vine/android/util/SystemUtil;->getPathFromResourceRaw(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v18

    invoke-interface/range {v17 .. v18}, Lco/vine/android/player/VideoViewInterface;->setVideoPathDirect(Ljava/lang/String;)V

    .line 242
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    move-object/from16 v17, v0

    new-instance v18, Lco/vine/android/StartActivity$1;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/StartActivity$1;-><init>(Lco/vine/android/StartActivity;)V

    invoke-interface/range {v17 .. v18}, Lco/vine/android/player/VideoViewInterface;->setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V

    .line 256
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    move-object/from16 v17, v0

    new-instance v18, Lco/vine/android/StartActivity$2;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/StartActivity$2;-><init>(Lco/vine/android/StartActivity;)V

    invoke-interface/range {v17 .. v18}, Lco/vine/android/player/VideoViewInterface;->setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V

    .line 268
    :goto_1
    if-eqz p1, :cond_5

    const-string v17, "state_p"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_5

    .line 270
    const-string v17, "state_p"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v17

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/StartActivity;->mStopPosition:I

    .line 272
    :cond_5
    new-instance v17, Lco/vine/android/StartActivity$StartSessionListener;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/StartActivity$StartSessionListener;-><init>(Lco/vine/android/StartActivity;)V

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/StartActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 273
    invoke-static/range {p0 .. p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    .line 274
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v17

    const-string v18, "pref_log_startup_fail"

    const/16 v19, 0x0

    invoke-interface/range {v17 .. v19}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 276
    .end local v5    # "boldSpan":Landroid/text/style/StyleSpan;
    .end local v7    # "end":I
    .end local v8    # "mSignIn":Landroid/widget/TextView;
    .end local v9    # "mSignUpEmail":Landroid/widget/Button;
    .end local v10    # "mSignUpTwitter":Landroid/widget/Button;
    .end local v11    # "mStyleSpanBoldSingle":[Landroid/text/style/StyleSpan;
    .end local v13    # "processIntent":Z
    .end local v14    # "spannable":Landroid/text/Spannable;
    .end local v15    # "spanned":Landroid/text/Spanned;
    .end local v16    # "start":I
    :catch_0
    move-exception v6

    .line 277
    .local v6, "e":Landroid/database/sqlite/SQLiteException;
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v12

    .line 278
    .local v12, "prefs":Landroid/content/SharedPreferences;
    const-string v17, "pref_log_startup_fail: {}."

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    const-string v20, "pref_log_startup_fail"

    const/16 v21, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v21

    invoke-interface {v12, v0, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v20

    invoke-static/range {v20 .. v20}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v20

    aput-object v20, v18, v19

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-static {v6, v0, v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 279
    const v17, 0x7f0e022e

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 280
    invoke-interface {v12}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v17

    const-string v18, "pref_log_startup_fail"

    const/16 v19, 0x1

    invoke-interface/range {v17 .. v19}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 281
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->finish()V

    goto/16 :goto_0

    .line 190
    .end local v6    # "e":Landroid/database/sqlite/SQLiteException;
    .end local v12    # "prefs":Landroid/content/SharedPreferences;
    :catch_1
    move-exception v6

    .line 191
    .local v6, "e":Ljava/lang/RuntimeException;
    :try_start_3
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Failed to process intent: "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getCallingPackage()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, " - "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, " - "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->getCallingActivity()Landroid/content/ComponentName;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x0

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-static {v6, v0, v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 192
    const v17, 0x7f0e022e

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 193
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/StartActivity;->finish()V

    goto/16 :goto_0

    .line 265
    .end local v6    # "e":Ljava/lang/RuntimeException;
    .restart local v5    # "boldSpan":Landroid/text/style/StyleSpan;
    .restart local v7    # "end":I
    .restart local v8    # "mSignIn":Landroid/widget/TextView;
    .restart local v9    # "mSignUpEmail":Landroid/widget/Button;
    .restart local v10    # "mSignUpTwitter":Landroid/widget/Button;
    .restart local v11    # "mStyleSpanBoldSingle":[Landroid/text/style/StyleSpan;
    .restart local v13    # "processIntent":Z
    .restart local v14    # "spannable":Landroid/text/Spannable;
    .restart local v15    # "spanned":Landroid/text/Spanned;
    .restart local v16    # "start":I
    :cond_6
    invoke-direct/range {p0 .. p0}, Lco/vine/android/StartActivity;->openStartVideo()V
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0

    goto/16 :goto_1
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 309
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onDestroy()V

    .line 310
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    if-eqz v0, :cond_0

    .line 311
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0}, Lco/vine/android/player/VideoViewInterface;->suspend()V

    .line 313
    :cond_0
    return-void
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 446
    packed-switch p2, :pswitch_data_0

    .line 465
    :cond_0
    :goto_0
    return-void

    .line 448
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 450
    :pswitch_1
    iget-object v0, p0, Lco/vine/android/StartActivity;->mAuthIntent:Landroid/content/Intent;

    if-eqz v0, :cond_0

    .line 451
    iget-object v0, p0, Lco/vine/android/StartActivity;->mAuthIntent:Landroid/content/Intent;

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lco/vine/android/StartActivity;->loginCheckTwitter(Landroid/content/Intent;Z)V

    goto :goto_0

    .line 446
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch

    .line 448
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_1
    .end packed-switch
.end method

.method public onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "i"    # Landroid/content/Intent;

    .prologue
    .line 159
    invoke-direct {p0, p1}, Lco/vine/android/StartActivity;->processIntent(Landroid/content/Intent;)Z

    .line 160
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 299
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onPause()V

    .line 300
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    if-eqz v0, :cond_0

    .line 301
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0}, Lco/vine/android/player/VideoViewInterface;->getCurrentPosition()I

    move-result v0

    iput v0, p0, Lco/vine/android/StartActivity;->mStopPosition:I

    .line 302
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0}, Lco/vine/android/player/VideoViewInterface;->pause()V

    .line 304
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/StartActivity;->dismissDialog()V

    .line 305
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 325
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onResume()V

    .line 326
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    if-eqz v0, :cond_0

    .line 327
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    iget v1, p0, Lco/vine/android/StartActivity;->mStopPosition:I

    invoke-interface {v0, v1}, Lco/vine/android/player/VideoViewInterface;->seekTo(I)V

    .line 328
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0}, Lco/vine/android/player/VideoViewInterface;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 329
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0}, Lco/vine/android/player/VideoViewInterface;->resume()V

    .line 334
    :cond_0
    :goto_0
    iget-object v0, p0, Lco/vine/android/StartActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lco/vine/android/StartActivity;->mLoginRequest:Z

    if-eqz v0, :cond_1

    .line 335
    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lco/vine/android/StartActivity;->setResult(I)V

    .line 336
    invoke-virtual {p0}, Lco/vine/android/StartActivity;->finish()V

    .line 338
    :cond_1
    return-void

    .line 331
    :cond_2
    iget-object v0, p0, Lco/vine/android/StartActivity;->mVideoView:Lco/vine/android/player/VideoViewInterface;

    invoke-interface {v0}, Lco/vine/android/player/VideoViewInterface;->start()V

    goto :goto_0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 317
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 318
    iget-object v0, p0, Lco/vine/android/StartActivity;->mAuthIntent:Landroid/content/Intent;

    if-eqz v0, :cond_0

    .line 319
    const-string v0, "auth_intent"

    iget-object v1, p0, Lco/vine/android/StartActivity;->mAuthIntent:Landroid/content/Intent;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 321
    :cond_0
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 78
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackLockOutSessionCount()V

    .line 79
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onStop()V

    .line 80
    return-void
.end method

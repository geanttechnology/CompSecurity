.class public Lcom/mixerbox/mixerbox3b/MixerBox;
.super Lcom/actionbarsherlock/app/SherlockActivity;
.source "SourceFile"


# static fields
.field private static final Msg_What_Animation_finish:I = 0x1

.field static bundle:Landroid/os/Bundle;

.field static count:I

.field static ctx:Landroid/content/Context;

.field static loginFlag:Z

.field static mp3Artist:Ljava/util/ArrayList;

.field static mp3ArtistId:Ljava/util/ArrayList;


# instance fields
.field SENDER_ID:Ljava/lang/String;

.field private callback:Lcom/facebook/Session$StatusCallback;

.field gcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

.field internetConnectedShouldResume:Z

.field public loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

.field msgId:Ljava/util/concurrent/atomic/AtomicInteger;

.field regid:Ljava/lang/String;

.field private uiHelper:Lcom/facebook/UiLifecycleHelper;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockActivity;-><init>()V

    .line 62
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->msgId:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 64
    const-string v0, "625063868019"

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->SENDER_ID:Ljava/lang/String;

    .line 78
    new-instance v0, Lcom/mixerbox/mixerbox3b/MixerBox$1;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MixerBox$1;-><init>(Lcom/mixerbox/mixerbox3b/MixerBox;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->callback:Lcom/facebook/Session$StatusCallback;

    .line 59
    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/MixerBox;Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0, p1, p2, p3}, Lcom/mixerbox/mixerbox3b/MixerBox;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    return-void
.end method

.method static synthetic access$100(Lcom/mixerbox/mixerbox3b/MixerBox;)Z
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->saveOldDB()Z

    move-result v0

    return v0
.end method

.method static synthetic access$200()V
    .locals 0

    .prologue
    .line 59
    invoke-static {}, Lcom/mixerbox/mixerbox3b/MixerBox;->getAllArtistsFromSDCard()V

    return-void
.end method

.method private checkPlayServices()Z
    .locals 2

    .prologue
    .line 439
    invoke-static {p0}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v0

    .line 440
    if-eqz v0, :cond_1

    .line 441
    invoke-static {v0}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isUserRecoverableError(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 442
    const/16 v1, 0x2328

    invoke-static {v0, p0, v1}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->getErrorDialog(ILandroid/app/Activity;I)Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 447
    :goto_0
    const/4 v0, 0x0

    .line 449
    :goto_1
    return v0

    .line 444
    :cond_0
    const-string v0, "This device is not supported."

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 445
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->finish()V

    goto :goto_0

    .line 449
    :cond_1
    const/4 v0, 0x1

    goto :goto_1
.end method

.method private static getAllArtistsFromSDCard()V
    .locals 8

    .prologue
    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 88
    const/4 v0, 0x1

    :try_start_0
    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "artist"

    aput-object v1, v2, v0

    .line 89
    const-string v3, "artist != 0"

    .line 90
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/MediaStore$Audio$Artists;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 92
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v2

    .line 93
    if-lez v2, :cond_1

    .line 94
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move v0, v7

    .line 95
    :goto_0
    if-ge v0, v2, :cond_1

    .line 96
    const/4 v3, 0x0

    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 97
    if-eqz v3, :cond_0

    sget-object v4, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3Artist:Ljava/util/ArrayList;

    sget-object v5, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v3, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_0

    .line 99
    sget-object v4, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3Artist:Ljava/util/ArrayList;

    sget-object v5, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v3, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 101
    :cond_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 95
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 107
    :cond_1
    if-eqz v1, :cond_2

    .line 108
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 112
    :cond_2
    :goto_1
    return-void

    .line 104
    :catch_0
    move-exception v0

    move-object v1, v6

    .line 105
    :goto_2
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 107
    if-eqz v1, :cond_2

    .line 108
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 107
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_3
    if-eqz v1, :cond_3

    .line 108
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 109
    :cond_3
    throw v0

    .line 107
    :catchall_1
    move-exception v0

    goto :goto_3

    .line 104
    :catch_1
    move-exception v0

    goto :goto_2
.end method

.method private static getAppVersion(Landroid/content/Context;)I
    .locals 4

    .prologue
    .line 454
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 455
    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    return v0

    .line 456
    :catch_0
    move-exception v0

    .line 457
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get package name: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private getRegistrationId(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 398
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getGCMId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 399
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 400
    const-string v0, "Registration not found."

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 401
    const-string v0, ""

    .line 412
    :cond_0
    :goto_0
    return-object v0

    .line 406
    :cond_1
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getPreVersion(Landroid/content/Context;)I

    move-result v1

    .line 407
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/MixerBox;->getAppVersion(Landroid/content/Context;)I

    move-result v2

    .line 408
    if-eq v1, v2, :cond_0

    .line 409
    const-string v0, "App version changed."

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 410
    const-string v0, ""

    goto :goto_0
.end method

.method private onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 1

    .prologue
    .line 530
    invoke-virtual {p2}, Lcom/facebook/SessionState;->isOpened()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 531
    const/4 v0, 0x1

    sput-boolean v0, Lcom/mixerbox/mixerbox3b/MixerBox;->loginFlag:Z

    .line 535
    :cond_0
    :goto_0
    return-void

    .line 532
    :cond_1
    invoke-virtual {p2}, Lcom/facebook/SessionState;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 533
    const/4 v0, 0x0

    sput-boolean v0, Lcom/mixerbox/mixerbox3b/MixerBox;->loginFlag:Z

    goto :goto_0
.end method

.method private registerGCM()V
    .locals 2

    .prologue
    .line 384
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->checkPlayServices()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 385
    invoke-static {p0}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->gcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    .line 386
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-direct {p0, v0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getRegistrationId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->regid:Ljava/lang/String;

    .line 388
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->regid:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->regid:Ljava/lang/String;

    const-string v1, "null"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 389
    :cond_0
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->registerInBackground()V

    .line 391
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "REGISTRATION ID = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->regid:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 395
    :goto_0
    return-void

    .line 393
    :cond_2
    const-string v0, "No valid Google Play Services APK found."

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private registerInBackground()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 416
    new-instance v0, Lcom/mixerbox/mixerbox3b/MixerBox$3;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MixerBox$3;-><init>(Lcom/mixerbox/mixerbox3b/MixerBox;)V

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Void;

    const/4 v2, 0x0

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object v3, v1, v2

    const/4 v2, 0x2

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MixerBox$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 436
    return-void
.end method

.method private saveOldDB()Z
    .locals 6

    .prologue
    .line 464
    :try_start_0
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    .line 465
    invoke-virtual {v1}, Ljava/io/File;->canWrite()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 466
    const-string v0, "mixerboxdb.db"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 468
    sget-boolean v0, Lcom/mixerbox/mixerbox3b/MixerBox;->loginFlag:Z

    if-eqz v0, :cond_1

    .line 469
    new-instance v0, Ljava/io/File;

    const-string v3, "//Download/mixerbox3b1db.db"

    invoke-direct {v0, v1, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 473
    :goto_0
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 474
    new-instance v1, Ljava/io/FileInputStream;

    invoke-direct {v1, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v1}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    .line 475
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, v0}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v2}, Ljava/io/FileOutputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    .line 476
    const-wide/16 v2, 0x0

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Ljava/nio/channels/FileChannel;->transferFrom(Ljava/nio/channels/ReadableByteChannel;JJ)J

    .line 477
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V

    .line 478
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V

    .line 481
    :cond_0
    const/4 v0, 0x1

    .line 484
    :goto_1
    return v0

    .line 471
    :cond_1
    new-instance v0, Ljava/io/File;

    const-string v3, "//Download/mixerbox3b0db.db"

    invoke-direct {v0, v1, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 482
    :catch_0
    move-exception v0

    .line 483
    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 484
    const/4 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method public cancelUpdate()V
    .locals 4

    .prologue
    .line 328
    new-instance v0, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;-><init>()V

    .line 329
    const/4 v1, 0x1

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 330
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1

    .prologue
    .line 539
    invoke-super {p0, p1, p2, p3}, Lcom/actionbarsherlock/app/SherlockActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 540
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1, p2, p3}, Lcom/facebook/UiLifecycleHelper;->onActivityResult(IILandroid/content/Intent;)V

    .line 541
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v0

    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/facebook/Session;->onActivityResult(Landroid/app/Activity;IILandroid/content/Intent;)Z

    .line 542
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 11

    .prologue
    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 116
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockActivity;->onCreate(Landroid/os/Bundle;)V

    .line 117
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MixerBox;->onNewIntent(Landroid/content/Intent;)V

    .line 119
    const-string v0, "AA463c18e8944e0e51392d903bbca65776e17a2065"

    invoke-static {v0}, Lcom/newrelic/agent/android/NewRelic;->withApplicationToken(Ljava/lang/String;)Lcom/newrelic/agent/android/NewRelic;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getApplication()Landroid/app/Application;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/newrelic/agent/android/NewRelic;->start(Landroid/content/Context;)V

    .line 121
    const v0, 0x7f030041

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MixerBox;->setContentView(I)V

    .line 122
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Lcom/actionbarsherlock/app/ActionBar;->hide()V

    .line 124
    new-instance v0, Lcom/facebook/UiLifecycleHelper;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->callback:Lcom/facebook/Session$StatusCallback;

    invoke-direct {v0, p0, v3}, Lcom/facebook/UiLifecycleHelper;-><init>(Landroid/app/Activity;Lcom/facebook/Session$StatusCallback;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    .line 125
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1}, Lcom/facebook/UiLifecycleHelper;->onCreate(Landroid/os/Bundle;)V

    .line 126
    const v0, 0x7f070090

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MixerBox;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    .line 127
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    new-array v3, v9, [Ljava/lang/String;

    const-string v4, "user_likes"

    aput-object v4, v3, v2

    const-string v4, "email"

    aput-object v4, v3, v1

    const-string v4, "read_stream"

    aput-object v4, v3, v8

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setReadPermissions(Ljava/util/List;)V

    .line 129
    sput-object p0, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    .line 130
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->internetConnectedShouldResume:Z

    .line 131
    sput-boolean v2, Lcom/mixerbox/mixerbox3b/MixerBox;->loginFlag:Z

    .line 132
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3Artist:Ljava/util/ArrayList;

    .line 134
    new-instance v0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    const v3, 0x7f020071

    invoke-virtual {v0, v3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageOnLoading(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    const v3, 0x7f020071

    invoke-virtual {v0, v3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageForEmptyUri(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    const v3, 0x7f020071

    invoke-virtual {v0, v3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageOnFail(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc(Z)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v0

    .line 136
    new-instance v3, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v3, v0}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->defaultDisplayImageOptions(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->build()Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    move-result-object v0

    .line 138
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->init(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;)V

    .line 140
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->registerGCM()V

    .line 142
    const-string v0, "DEFAULT"

    const-string v3, "font/Roboto-Light.ttf"

    invoke-static {p0, v0, v3}, Lcom/mixerbox/mixerbox3b/classes/FontsOverride;->setDefaultFont(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    const-string v0, "SANS_SERIF"

    const-string v3, "font/Roboto-Light.ttf"

    invoke-static {p0, v0, v3}, Lcom/mixerbox/mixerbox3b/classes/FontsOverride;->setDefaultFont(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    const-string v0, "SERIF"

    const-string v3, "font/Roboto-Light.ttf"

    invoke-static {p0, v0, v3}, Lcom/mixerbox/mixerbox3b/classes/FontsOverride;->setDefaultFont(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getOpenTimeCount(Landroid/content/Context;)I

    move-result v0

    .line 147
    sput v0, Lcom/mixerbox/mixerbox3b/MixerBox;->count:I

    const/4 v3, -0x1

    if-ne v0, v3, :cond_a

    .line 150
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 151
    const/16 v3, 0x80

    invoke-virtual {v0, v3}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 152
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ApplicationInfo;

    .line 153
    iget-object v4, v0, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v5, "com.mixerbox.mixerbox2"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    move v0, v1

    .line 167
    :goto_0
    if-nez v0, :cond_2

    .line 168
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    .line 169
    const/4 v3, 0x4

    invoke-virtual {v0, v3}, Ljava/util/Random;->nextInt(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    .line 170
    if-ne v0, v1, :cond_8

    .line 172
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putShouldSendServerNotification(Landroid/content/Context;Z)V

    .line 186
    :cond_1
    :goto_1
    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putUserType(Landroid/content/Context;I)V

    .line 189
    :cond_2
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putHasDayOne(Landroid/content/Context;Z)V

    .line 191
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 192
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    invoke-static {p0, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putFirstLaunchTime(Landroid/content/Context;J)V

    .line 194
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 195
    const-string v0, "http://bit.ly/MB3bAndroidInstall"

    new-instance v2, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v2}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v7, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 196
    const-string v0, "http://bit.ly/MBAndroidV307Launch"

    new-instance v2, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v2}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v7, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 199
    :cond_3
    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putOpenTimeCount(Landroid/content/Context;I)V

    .line 226
    :goto_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x13

    if-lt v0, v2, :cond_4

    .line 227
    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putEnableBackgroundPlay(Landroid/content/Context;Z)V

    .line 230
    :cond_4
    const/16 v1, 0x3e7

    .line 232
    :try_start_0
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 233
    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 234
    :try_start_1
    sget-object v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->MIXERBOX_URL_PARAMETER:Ljava/lang/String;

    const-string v2, "&appVer="

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 235
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->MIXERBOX_URL_PARAMETER:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&appVer="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->MIXERBOX_URL_PARAMETER:Ljava/lang/String;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 241
    :cond_5
    :goto_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 243
    sget-object v2, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-static {v2, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putLocale(Landroid/content/Context;Ljava/lang/String;)V

    .line 244
    sget-object v2, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFirstLaunchTime(Landroid/content/Context;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v2, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSysInfoUrl(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 245
    new-instance v2, Lcom/mixerbox/mixerbox3b/MixerBox$2;

    invoke-direct {v2, p0, p0, v0}, Lcom/mixerbox/mixerbox3b/MixerBox$2;-><init>(Lcom/mixerbox/mixerbox3b/MixerBox;Landroid/content/Context;I)V

    invoke-static {v1, v7, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 325
    return-void

    .line 157
    :cond_6
    iget-object v4, v0, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v5, "com.mixerbox.mixerbox2b"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    move v0, v1

    .line 159
    goto/16 :goto_0

    .line 161
    :cond_7
    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v4, "com.mixerbox.mixerbox"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    .line 163
    goto/16 :goto_0

    .line 174
    :cond_8
    if-ne v0, v8, :cond_9

    .line 175
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putShouldSendLocalNotification(Landroid/content/Context;Z)V

    goto/16 :goto_1

    .line 178
    :cond_9
    if-eq v0, v9, :cond_1

    .line 182
    const/4 v3, 0x4

    if-ne v0, v3, :cond_1

    .line 183
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putShouldSendLocalNotification(Landroid/content/Context;Z)V

    .line 184
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putShouldSendServerNotification(Landroid/content/Context;Z)V

    goto/16 :goto_1

    .line 202
    :cond_a
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getHasDayOne(Landroid/content/Context;)Z

    move-result v0

    .line 203
    if-nez v0, :cond_b

    .line 204
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 205
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 206
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFirstLaunchTime(Landroid/content/Context;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 207
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    sub-long/2addr v3, v5

    const-wide/32 v5, 0x5265c00

    cmp-long v3, v3, v5

    if-ltz v3, :cond_b

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    sub-long v2, v3, v5

    const-wide/32 v4, 0xa4cb800

    cmp-long v0, v2, v4

    if-gtz v0, :cond_b

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 208
    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putHasDayOne(Landroid/content/Context;Z)V

    .line 209
    const-string v0, "http://bit.ly/MBAndroidV307DayOne"

    new-instance v2, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v2}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v7, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 210
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getUserType(Landroid/content/Context;)I

    move-result v0

    .line 211
    if-ne v0, v1, :cond_c

    .line 212
    const-string v0, "http://bit.ly/androidv307_push_local"

    new-instance v2, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v2}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v7, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 223
    :cond_b
    :goto_4
    sget v0, Lcom/mixerbox/mixerbox3b/MixerBox;->count:I

    add-int/lit8 v0, v0, 0x1

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putOpenTimeCount(Landroid/content/Context;I)V

    goto/16 :goto_2

    .line 213
    :cond_c
    if-ne v0, v8, :cond_d

    .line 214
    const-string v0, "http://bit.ly/androidv307_push_server"

    new-instance v2, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v2}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v7, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_4

    .line 215
    :cond_d
    if-ne v0, v9, :cond_e

    .line 216
    const-string v0, "http://bit.ly/androidv307_push_local_and_server"

    new-instance v2, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v2}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v7, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_4

    .line 217
    :cond_e
    const/4 v2, 0x4

    if-ne v0, v2, :cond_b

    .line 218
    const-string v0, "http://bit.ly/androidv307_push_neither"

    new-instance v2, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v2}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v7, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_4

    .line 236
    :catch_0
    move-exception v0

    move-object v10, v0

    move v0, v1

    move-object v1, v10

    .line 237
    :goto_5
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_3

    .line 236
    :catch_1
    move-exception v1

    goto :goto_5

    :cond_f
    move v0, v2

    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 525
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockActivity;->onDestroy()V

    .line 526
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onDestroy()V

    .line 527
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 3

    .prologue
    .line 546
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 547
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 548
    sput-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    if-nez v0, :cond_0

    .line 549
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    .line 550
    :cond_0
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 551
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    const-string v1, "data"

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 553
    :cond_1
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 519
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockActivity;->onPause()V

    .line 520
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onPause()V

    .line 521
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 490
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockActivity;->onResume()V

    .line 491
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v0

    .line 492
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/facebook/Session;->isOpened()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/facebook/Session;->isClosed()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 493
    :cond_0
    invoke-virtual {v0}, Lcom/facebook/Session;->getState()Lcom/facebook/SessionState;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/mixerbox/mixerbox3b/MixerBox;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    .line 495
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onResume()V

    .line 496
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MixerBox;->checkPlayServices()Z

    .line 497
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 513
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 514
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1}, Lcom/facebook/UiLifecycleHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 515
    return-void
.end method

.method protected onStart()V
    .locals 1

    .prologue
    .line 501
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockActivity;->onStart()V

    .line 502
    const-string v0, "Z8QPYZT3PBG8R6ZNSDXQ"

    invoke-static {p0, v0}, Lcom/flurry/android/FlurryAgent;->onStartSession(Landroid/content/Context;Ljava/lang/String;)V

    .line 503
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 507
    invoke-static {p0}, Lcom/flurry/android/FlurryAgent;->onEndSession(Landroid/content/Context;)V

    .line 508
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockActivity;->onStop()V

    .line 509
    return-void
.end method

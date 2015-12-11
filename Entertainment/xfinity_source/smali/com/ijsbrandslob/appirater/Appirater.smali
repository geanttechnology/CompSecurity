.class public Lcom/ijsbrandslob/appirater/Appirater;
.super Ljava/lang/Object;
.source "Appirater.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/ijsbrandslob/appirater/Appirater$Configuration;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private config:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

.field private internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final isDebuggable:Z

.field private mContext:Landroid/content/Context;

.field private mCurrentVersion:I

.field private mDeclinedToRate:Z

.field private mFirstUseDate:Ljava/util/Date;

.field private mRatedCurrentVersion:Z

.field private mReminderRequestDate:Ljava/util/Date;

.field private mSignificantEventCount:I

.field private mUseCount:I

.field private rateDialog:Landroid/app/Dialog;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 68
    const-class v0, Lcom/ijsbrandslob/appirater/Appirater;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/ijsbrandslob/appirater/Appirater;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/ijsbrandslob/appirater/Appirater$Configuration;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;ZLcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "config"    # Lcom/ijsbrandslob/appirater/Appirater$Configuration;
    .param p3, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p4, "isDebuggable"    # Z
    .param p5, "device"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    iput-object p1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    .line 91
    iput-object p2, p0, Lcom/ijsbrandslob/appirater/Appirater;->config:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    .line 92
    iput-object p3, p0, Lcom/ijsbrandslob/appirater/Appirater;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 93
    iput-object p5, p0, Lcom/ijsbrandslob/appirater/Appirater;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 94
    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->loadSettings()V

    .line 95
    iput-boolean p4, p0, Lcom/ijsbrandslob/appirater/Appirater;->isDebuggable:Z

    .line 96
    return-void
.end method

.method static synthetic access$000(Lcom/ijsbrandslob/appirater/Appirater;)Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .locals 1
    .param p0, "x0"    # Lcom/ijsbrandslob/appirater/Appirater;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    return-object v0
.end method

.method static synthetic access$100(Lcom/ijsbrandslob/appirater/Appirater;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/ijsbrandslob/appirater/Appirater;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$202(Lcom/ijsbrandslob/appirater/Appirater;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/ijsbrandslob/appirater/Appirater;
    .param p1, "x1"    # Z

    .prologue
    .line 66
    iput-boolean p1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mRatedCurrentVersion:Z

    return p1
.end method

.method static synthetic access$300(Lcom/ijsbrandslob/appirater/Appirater;)V
    .locals 0
    .param p0, "x0"    # Lcom/ijsbrandslob/appirater/Appirater;

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->saveSettings()V

    return-void
.end method

.method static synthetic access$400(Lcom/ijsbrandslob/appirater/Appirater;)Z
    .locals 1
    .param p0, "x0"    # Lcom/ijsbrandslob/appirater/Appirater;

    .prologue
    .line 66
    iget-boolean v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->isDebuggable:Z

    return v0
.end method

.method static synthetic access$502(Lcom/ijsbrandslob/appirater/Appirater;Ljava/util/Date;)Ljava/util/Date;
    .locals 0
    .param p0, "x0"    # Lcom/ijsbrandslob/appirater/Appirater;
    .param p1, "x1"    # Ljava/util/Date;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;

    return-object p1
.end method

.method static synthetic access$602(Lcom/ijsbrandslob/appirater/Appirater;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/ijsbrandslob/appirater/Appirater;
    .param p1, "x1"    # Z

    .prologue
    .line 66
    iput-boolean p1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mDeclinedToRate:Z

    return p1
.end method

.method private getAppVersion()I
    .locals 5

    .prologue
    .line 324
    :try_start_0
    iget-object v2, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    iget-object v3, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    iget v1, v2, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 330
    .local v1, "version":I
    return v1

    .line 325
    .end local v1    # "version":I
    :catch_0
    move-exception v0

    .line 328
    .local v0, "ex":Landroid/content/pm/PackageManager$NameNotFoundException;
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "Everything we know is wrong"

    invoke-direct {v2, v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method private incrementAndRate(ZLandroid/app/Activity;)V
    .locals 1
    .param p1, "canPromptForRating"    # Z
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 149
    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->incrementUseCount()V

    .line 150
    if-eqz p1, :cond_0

    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->ratingConditionsHaveBeenMet()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 151
    invoke-direct {p0, p2}, Lcom/ijsbrandslob/appirater/Appirater;->showRatingAlert(Landroid/app/Activity;)V

    .line 153
    :cond_0
    return-void
.end method

.method private incrementSignificantEventAndRate(ZLandroid/app/Activity;)V
    .locals 1
    .param p1, "canPromptForRating"    # Z
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 156
    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->incrementSignificantEventCount()V

    .line 157
    if-eqz p1, :cond_0

    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->ratingConditionsHaveBeenMet()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 158
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 159
    invoke-direct {p0, p2}, Lcom/ijsbrandslob/appirater/Appirater;->showRatingAlert(Landroid/app/Activity;)V

    .line 161
    :cond_0
    return-void
.end method

.method private incrementSignificantEventCount()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 335
    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->getAppVersion()I

    move-result v0

    .line 338
    .local v0, "version":I
    iget v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 339
    iput v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    .line 342
    :cond_0
    sget-object v1, Lcom/ijsbrandslob/appirater/Appirater;->LOG:Lorg/slf4j/Logger;

    const-string v2, "APPIRATER Tracking version: %d"

    new-array v3, v6, [Ljava/lang/Object;

    iget v4, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 344
    iget v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    if-ne v1, v0, :cond_2

    .line 346
    iget-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    if-nez v1, :cond_1

    .line 347
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    iput-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    .line 351
    :cond_1
    iget v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mSignificantEventCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mSignificantEventCount:I

    .line 353
    sget-object v1, Lcom/ijsbrandslob/appirater/Appirater;->LOG:Lorg/slf4j/Logger;

    const-string v2, "APPIRATER Significant event count: %d"

    new-array v3, v6, [Ljava/lang/Object;

    iget v4, p0, Lcom/ijsbrandslob/appirater/Appirater;->mSignificantEventCount:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 364
    :goto_0
    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->saveSettings()V

    .line 365
    return-void

    .line 355
    :cond_2
    iput v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    .line 356
    iput-object v7, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    .line 357
    iput v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mUseCount:I

    .line 358
    iput v6, p0, Lcom/ijsbrandslob/appirater/Appirater;->mSignificantEventCount:I

    .line 359
    iput-boolean v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mRatedCurrentVersion:Z

    .line 360
    iput-boolean v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mDeclinedToRate:Z

    .line 361
    iput-object v7, p0, Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;

    goto :goto_0
.end method

.method private incrementUseCount()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 288
    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->getAppVersion()I

    move-result v0

    .line 291
    .local v0, "version":I
    iget v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 292
    iput v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    .line 295
    :cond_0
    sget-object v1, Lcom/ijsbrandslob/appirater/Appirater;->LOG:Lorg/slf4j/Logger;

    const-string v2, "APPIRATER Tracking version: %d"

    new-array v3, v6, [Ljava/lang/Object;

    iget v4, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 297
    iget v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    if-ne v1, v0, :cond_2

    .line 299
    iget-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    if-nez v1, :cond_1

    .line 300
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    iput-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    .line 304
    :cond_1
    iget v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mUseCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mUseCount:I

    .line 306
    sget-object v1, Lcom/ijsbrandslob/appirater/Appirater;->LOG:Lorg/slf4j/Logger;

    const-string v2, "APPIRATER Use count: %d"

    new-array v3, v6, [Ljava/lang/Object;

    iget v4, p0, Lcom/ijsbrandslob/appirater/Appirater;->mUseCount:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 318
    :goto_0
    invoke-direct {p0}, Lcom/ijsbrandslob/appirater/Appirater;->saveSettings()V

    .line 319
    return-void

    .line 309
    :cond_2
    iput v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    .line 310
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    iput-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    .line 311
    iput v6, p0, Lcom/ijsbrandslob/appirater/Appirater;->mUseCount:I

    .line 312
    iput v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mSignificantEventCount:I

    .line 313
    iput-boolean v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mRatedCurrentVersion:Z

    .line 314
    iput-boolean v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mDeclinedToRate:Z

    .line 315
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;

    goto :goto_0
.end method

.method private loadSettings()V
    .locals 10

    .prologue
    const-wide/16 v8, -0x1

    const/4 v7, 0x0

    .line 377
    iget-object v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6, v7}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    .line 380
    .local v4, "settings":Landroid/content/SharedPreferences;
    const-string v5, "APPIRATER_FIRST_USE_DATE"

    invoke-interface {v4, v5}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 381
    const-string v5, "APPIRATER_FIRST_USE_DATE"

    invoke-interface {v4, v5, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    .line 382
    .local v0, "firstUseDate":J
    cmp-long v5, v8, v0

    if-eqz v5, :cond_0

    .line 383
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5, v0, v1}, Ljava/util/Date;-><init>(J)V

    iput-object v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    .line 386
    :cond_0
    const-string v5, "APPIRATER_REMINDER_REQUEST_DATE"

    invoke-interface {v4, v5, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    .line 387
    .local v2, "reminderRequestDate":J
    cmp-long v5, v8, v2

    if-eqz v5, :cond_1

    .line 388
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;

    .line 391
    :cond_1
    const-string v5, "APPIRATER_USE_COUNT"

    invoke-interface {v4, v5, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    iput v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mUseCount:I

    .line 392
    const-string v5, "APPIRATER_SIG_EVENT_COUNT"

    invoke-interface {v4, v5, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    iput v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mSignificantEventCount:I

    .line 393
    const-string v5, "APPIRATER_CURRENT_VERSION"

    invoke-interface {v4, v5, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    iput v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    .line 394
    const-string v5, "APPIRATER_RATED_CURRENT_VERSION"

    invoke-interface {v4, v5, v7}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mRatedCurrentVersion:Z

    .line 395
    const-string v5, "APPIRATER_DECLINED_TO_RATE"

    invoke-interface {v4, v5, v7}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lcom/ijsbrandslob/appirater/Appirater;->mDeclinedToRate:Z

    .line 397
    .end local v0    # "firstUseDate":J
    .end local v2    # "reminderRequestDate":J
    :cond_2
    return-void
.end method

.method private ratingConditionsHaveBeenMet()Z
    .locals 12

    .prologue
    const/4 v1, 0x0

    .line 249
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 250
    .local v0, "now":Ljava/util/Date;
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    iget-object v10, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    invoke-virtual {v10}, Ljava/util/Date;->getTime()J

    move-result-wide v10

    sub-long v2, v8, v10

    .line 251
    .local v2, "timeSinceFirstLaunch":J
    const v8, 0x5265c00

    iget-object v9, p0, Lcom/ijsbrandslob/appirater/Appirater;->config:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    invoke-interface {v9}, Lcom/ijsbrandslob/appirater/Appirater$Configuration;->getDaysUntilPrompt()I

    move-result v9

    mul-int/2addr v8, v9

    int-to-long v6, v8

    .line 252
    .local v6, "timeUntilRate":J
    cmp-long v8, v2, v6

    if-gez v8, :cond_1

    .line 283
    :cond_0
    :goto_0
    return v1

    .line 257
    :cond_1
    iget v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->mUseCount:I

    iget-object v9, p0, Lcom/ijsbrandslob/appirater/Appirater;->config:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    invoke-interface {v9}, Lcom/ijsbrandslob/appirater/Appirater$Configuration;->getUsesUntilPrompt()I

    move-result v9

    if-lt v8, v9, :cond_0

    .line 262
    iget v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->mSignificantEventCount:I

    iget-object v9, p0, Lcom/ijsbrandslob/appirater/Appirater;->config:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    invoke-interface {v9}, Lcom/ijsbrandslob/appirater/Appirater$Configuration;->getSignificantEventsUntilPrompt()I

    move-result v9

    if-lt v8, v9, :cond_0

    .line 267
    iget-boolean v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->mDeclinedToRate:Z

    if-nez v8, :cond_0

    .line 272
    iget-boolean v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->mRatedCurrentVersion:Z

    if-nez v8, :cond_0

    .line 277
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;

    if-eqz v8, :cond_2

    .line 278
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    iget-object v10, p0, Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;

    invoke-virtual {v10}, Ljava/util/Date;->getTime()J

    move-result-wide v10

    sub-long v4, v8, v10

    .line 279
    .local v4, "timeSinceReminderRequest":J
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->config:Lcom/ijsbrandslob/appirater/Appirater$Configuration;

    invoke-interface {v8}, Lcom/ijsbrandslob/appirater/Appirater$Configuration;->getMillisBeforeReminding()I

    move-result v8

    int-to-long v8, v8

    cmp-long v8, v4, v8

    if-ltz v8, :cond_0

    .line 283
    .end local v4    # "timeSinceReminderRequest":J
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private saveSettings()V
    .locals 9

    .prologue
    .line 400
    iget-object v6, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    iget-object v7, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 401
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 403
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-wide/16 v2, -0x1

    .line 404
    .local v2, "firstUseDate":J
    iget-object v6, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    if-eqz v6, :cond_0

    .line 405
    iget-object v6, p0, Lcom/ijsbrandslob/appirater/Appirater;->mFirstUseDate:Ljava/util/Date;

    invoke-virtual {v6}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    .line 407
    :cond_0
    const-string v6, "APPIRATER_FIRST_USE_DATE"

    invoke-interface {v0, v6, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 409
    const-wide/16 v4, -0x1

    .line 410
    .local v4, "reminderRequestDate":J
    iget-object v6, p0, Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;

    if-eqz v6, :cond_1

    .line 411
    iget-object v6, p0, Lcom/ijsbrandslob/appirater/Appirater;->mReminderRequestDate:Ljava/util/Date;

    invoke-virtual {v6}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    .line 413
    :cond_1
    const-string v6, "APPIRATER_REMINDER_REQUEST_DATE"

    invoke-interface {v0, v6, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 415
    const-string v6, "APPIRATER_USE_COUNT"

    iget v7, p0, Lcom/ijsbrandslob/appirater/Appirater;->mUseCount:I

    invoke-interface {v0, v6, v7}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 416
    const-string v6, "APPIRATER_SIG_EVENT_COUNT"

    iget v7, p0, Lcom/ijsbrandslob/appirater/Appirater;->mSignificantEventCount:I

    invoke-interface {v0, v6, v7}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 417
    const-string v6, "APPIRATER_CURRENT_VERSION"

    iget v7, p0, Lcom/ijsbrandslob/appirater/Appirater;->mCurrentVersion:I

    invoke-interface {v0, v6, v7}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 418
    const-string v6, "APPIRATER_RATED_CURRENT_VERSION"

    iget-boolean v7, p0, Lcom/ijsbrandslob/appirater/Appirater;->mRatedCurrentVersion:Z

    invoke-interface {v0, v6, v7}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 419
    const-string v6, "APPIRATER_DECLINED_TO_RATE"

    iget-boolean v7, p0, Lcom/ijsbrandslob/appirater/Appirater;->mDeclinedToRate:Z

    invoke-interface {v0, v6, v7}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 421
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 422
    return-void
.end method

.method private showRatingAlert(Landroid/app/Activity;)V
    .locals 14
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 164
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    if-eqz v8, :cond_0

    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    invoke-virtual {v8}, Landroid/app/Dialog;->isShowing()Z

    move-result v8

    if-nez v8, :cond_1

    .line 165
    :cond_0
    new-instance v8, Landroid/app/Dialog;

    invoke-direct {v8, p1}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    iput-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    .line 166
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    .line 170
    .local v7, "res":Landroid/content/res/Resources;
    :try_start_0
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    iget-object v9, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    iget-object v10, p0, Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;

    invoke-virtual {v10}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 176
    .local v0, "appname":Ljava/lang/CharSequence;
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    sget v9, Lcom/xfinity/playerlib/R$string;->APPIRATER_MESSAGE_TITLE:I

    invoke-virtual {v7, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    new-array v10, v13, [Ljava/lang/Object;

    aput-object v0, v10, v12

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/app/Dialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 177
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    sget v9, Lcom/xfinity/playerlib/R$layout;->appirater:I

    invoke-virtual {v8, v9}, Landroid/app/Dialog;->setContentView(I)V

    .line 179
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    sget v9, Lcom/xfinity/playerlib/R$id;->appirater_message_area:I

    invoke-virtual {v8, v9}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 180
    .local v4, "messageArea":Landroid/widget/TextView;
    sget v8, Lcom/xfinity/playerlib/R$string;->APPIRATER_MESSAGE:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-array v9, v13, [Ljava/lang/Object;

    aput-object v0, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 182
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    sget v9, Lcom/xfinity/playerlib/R$id;->appirater_rate_button:I

    invoke-virtual {v8, v9}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    .line 183
    .local v5, "rateButton":Landroid/widget/Button;
    sget v8, Lcom/xfinity/playerlib/R$string;->APPIRATER_RATE_BUTTON:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    new-array v9, v13, [Ljava/lang/Object;

    aput-object v0, v9, v12

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 184
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    sget v9, Lcom/xfinity/playerlib/R$id;->appirater_rate_later_button:I

    invoke-virtual {v8, v9}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/Button;

    .line 185
    .local v6, "remindLaterButton":Landroid/widget/Button;
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    sget v9, Lcom/xfinity/playerlib/R$id;->appirater_cancel_button:I

    invoke-virtual {v8, v9}, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 187
    .local v1, "cancelButton":Landroid/widget/Button;
    iget-object v3, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    .line 188
    .local v3, "internalRateDialog":Landroid/app/Dialog;
    new-instance v8, Lcom/ijsbrandslob/appirater/Appirater$1;

    invoke-direct {v8, p0, p1, v3}, Lcom/ijsbrandslob/appirater/Appirater$1;-><init>(Lcom/ijsbrandslob/appirater/Appirater;Landroid/app/Activity;Landroid/app/Dialog;)V

    invoke-virtual {v5, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 209
    new-instance v8, Lcom/ijsbrandslob/appirater/Appirater$2;

    invoke-direct {v8, p0, v3}, Lcom/ijsbrandslob/appirater/Appirater$2;-><init>(Lcom/ijsbrandslob/appirater/Appirater;Landroid/app/Dialog;)V

    invoke-virtual {v6, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 227
    new-instance v8, Lcom/ijsbrandslob/appirater/Appirater$3;

    invoke-direct {v8, p0, v3}, Lcom/ijsbrandslob/appirater/Appirater$3;-><init>(Lcom/ijsbrandslob/appirater/Appirater;Landroid/app/Dialog;)V

    invoke-virtual {v1, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 236
    iget-object v8, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    new-instance v9, Lcom/ijsbrandslob/appirater/Appirater$4;

    invoke-direct {v9, p0}, Lcom/ijsbrandslob/appirater/Appirater$4;-><init>(Lcom/ijsbrandslob/appirater/Appirater;)V

    invoke-virtual {v8, v9}, Landroid/app/Dialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 244
    invoke-virtual {v3}, Landroid/app/Dialog;->show()V

    .line 246
    .end local v0    # "appname":Ljava/lang/CharSequence;
    .end local v1    # "cancelButton":Landroid/widget/Button;
    .end local v3    # "internalRateDialog":Landroid/app/Dialog;
    .end local v4    # "messageArea":Landroid/widget/TextView;
    .end local v5    # "rateButton":Landroid/widget/Button;
    .end local v6    # "remindLaterButton":Landroid/widget/Button;
    .end local v7    # "res":Landroid/content/res/Resources;
    :cond_1
    return-void

    .line 171
    .restart local v7    # "res":Landroid/content/res/Resources;
    :catch_0
    move-exception v2

    .line 174
    .local v2, "ex":Landroid/content/pm/PackageManager$NameNotFoundException;
    new-instance v8, Ljava/lang/RuntimeException;

    const-string v9, "Everything we know is wrong"

    invoke-direct {v8, v9, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8
.end method


# virtual methods
.method public appEnteredForeground(ZLandroid/app/Activity;)V
    .locals 0
    .param p1, "canPromptForRating"    # Z
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 127
    invoke-direct {p0, p1, p2}, Lcom/ijsbrandslob/appirater/Appirater;->incrementAndRate(ZLandroid/app/Activity;)V

    .line 128
    return-void
.end method

.method public dismiss()V
    .locals 1

    .prologue
    .line 425
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 426
    iget-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 428
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/ijsbrandslob/appirater/Appirater;->rateDialog:Landroid/app/Dialog;

    .line 430
    return-void
.end method

.method public userDidSignificantEvent(ZLandroid/app/Activity;)V
    .locals 0
    .param p1, "canPromptForRating"    # Z
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 145
    invoke-direct {p0, p1, p2}, Lcom/ijsbrandslob/appirater/Appirater;->incrementSignificantEventAndRate(ZLandroid/app/Activity;)V

    .line 146
    return-void
.end method

.class public final Lcom/amazon/device/crashmanager/CrashDetectionHelper;
.super Ljava/lang/Object;
.source "CrashDetectionHelper.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# static fields
.field private static final ANDROID_API_VERSION:I

.field private static final SINGLE_THREADED_EXECUTOR:Ljava/util/concurrent/ExecutorService;

.field private static final TAG:Ljava/lang/String;

.field private static sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;


# instance fields
.field private final mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

.field private final mAppFileArtifactSource:Lcom/amazon/device/crashmanager/AppFileArtifactSource;

.field private mCrashDescUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

.field private final mCrashDetailAggregator:Lcom/amazon/device/crashmanager/CrashDetailsAggregator;

.field private final mDeviceId:Ljava/lang/String;

.field private final mDeviceType:Ljava/lang/String;

.field private final mDomainChooser:Lcom/amazon/device/crashmanager/DomainChooser;

.field private final mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

.field private final mNetworkManager:Lcom/amazon/device/utils/NetworkManager;

.field private final mPreviousHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

.field private mRequestSigner:Lcom/amazon/communication/authentication/RequestSigner;

.field private final mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    .line 43
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->SINGLE_THREADED_EXECUTOR:Ljava/util/concurrent/ExecutorService;

    .line 45
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    .line 63
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    sput v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->ANDROID_API_VERSION:I

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/device/utils/OAuthHelper;Lcom/amazon/client/metrics/MetricsFactory;Lcom/amazon/device/crashmanager/AppFileArtifactSource;Lcom/amazon/device/crashmanager/AmazonPackageLookup;Lcom/amazon/device/crashmanager/DomainChooser;Lcom/amazon/device/utils/NetworkManager;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;Lcom/amazon/device/crashmanager/CrashDetailsAggregator;)V
    .locals 1
    .param p1, "deviceType"    # Ljava/lang/String;
    .param p2, "deviceId"    # Ljava/lang/String;
    .param p3, "oauthHelper"    # Lcom/amazon/device/utils/OAuthHelper;
    .param p4, "metricsFactory"    # Lcom/amazon/client/metrics/MetricsFactory;
    .param p5, "appFileArtifactSource"    # Lcom/amazon/device/crashmanager/AppFileArtifactSource;
    .param p6, "amazonPackageLookup"    # Lcom/amazon/device/crashmanager/AmazonPackageLookup;
    .param p7, "domainChooser"    # Lcom/amazon/device/crashmanager/DomainChooser;
    .param p8, "networkManager"    # Lcom/amazon/device/utils/NetworkManager;
    .param p9, "crashDescStorageUtil"    # Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;
    .param p10, "crashDetailsAggregator"    # Lcom/amazon/device/crashmanager/CrashDetailsAggregator;

    .prologue
    .line 210
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 211
    iput-object p5, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mAppFileArtifactSource:Lcom/amazon/device/crashmanager/AppFileArtifactSource;

    .line 212
    iput-object p6, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

    .line 213
    iput-object p4, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 214
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mPreviousHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 215
    new-instance v0, Lcom/amazon/device/crashmanager/OAuthRequestSigner;

    invoke-direct {v0, p3}, Lcom/amazon/device/crashmanager/OAuthRequestSigner;-><init>(Lcom/amazon/device/utils/OAuthHelper;)V

    iput-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mRequestSigner:Lcom/amazon/communication/authentication/RequestSigner;

    .line 216
    iput-object p7, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mDomainChooser:Lcom/amazon/device/crashmanager/DomainChooser;

    .line 217
    iput-object p1, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mDeviceType:Ljava/lang/String;

    .line 218
    iput-object p2, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mDeviceId:Ljava/lang/String;

    .line 219
    iput-object p8, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mNetworkManager:Lcom/amazon/device/utils/NetworkManager;

    .line 220
    iput-object p9, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mCrashDescUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    .line 221
    iput-object p10, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mCrashDetailAggregator:Lcom/amazon/device/crashmanager/CrashDetailsAggregator;

    .line 223
    new-instance v0, Lcom/amazon/device/utils/NullStatusNotifier;

    invoke-direct {v0}, Lcom/amazon/device/utils/NullStatusNotifier;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;

    .line 224
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    sget-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;
    .locals 2

    .prologue
    .line 196
    sget v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->ANDROID_API_VERSION:I

    const/16 v1, 0x9

    if-ge v0, v1, :cond_0

    .line 198
    sget-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not set up crash detection, android versions before Gingerbread <9 are known to crash."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 199
    const/4 v0, 0x0

    .line 204
    :goto_0
    return-object v0

    .line 201
    :cond_0
    sget-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    if-nez v0, :cond_1

    .line 202
    sget-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "CrashDetectionHelper.getInstance() called before CrashDetectionHelper.setUpCrashDetection()."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 204
    :cond_1
    sget-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    goto :goto_0
.end method

.method public static setUpCrashDetection(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/device/utils/OAuthHelper;Lcom/amazon/client/metrics/MetricsFactory;Lcom/amazon/device/crashmanager/DomainChooser;Landroid/content/Context;Z)Lcom/amazon/device/crashmanager/CrashDetectionHelper;
    .locals 17
    .param p0, "deviceType"    # Ljava/lang/String;
    .param p1, "deviceId"    # Ljava/lang/String;
    .param p2, "oauthHelper"    # Lcom/amazon/device/utils/OAuthHelper;
    .param p3, "metricsFactory"    # Lcom/amazon/client/metrics/MetricsFactory;
    .param p4, "domainChooser"    # Lcom/amazon/device/crashmanager/DomainChooser;
    .param p5, "context"    # Landroid/content/Context;
    .param p6, "setExceptionHandler"    # Z

    .prologue
    .line 117
    sget v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->ANDROID_API_VERSION:I

    const/16 v2, 0x9

    if-ge v1, v2, :cond_0

    .line 119
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not set up crash detection, android versions before Gingerbread <9 are known to crash."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    const/4 v1, 0x0

    .line 186
    :goto_0
    return-object v1

    .line 122
    :cond_0
    if-nez p0, :cond_1

    .line 123
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not set up crash detection, device type is null."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 124
    const/4 v1, 0x0

    goto :goto_0

    .line 126
    :cond_1
    if-nez p1, :cond_2

    .line 127
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not set up crash detection, device id is null."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 128
    const/4 v1, 0x0

    goto :goto_0

    .line 130
    :cond_2
    if-nez p2, :cond_3

    .line 131
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not set up crash detection, oauth helper is null."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 132
    const/4 v1, 0x0

    goto :goto_0

    .line 134
    :cond_3
    if-nez p3, :cond_4

    .line 135
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not set up crash detection, metrics factory is null."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 136
    const/4 v1, 0x0

    goto :goto_0

    .line 138
    :cond_4
    if-nez p5, :cond_5

    .line 139
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not set up crash detection, context is null."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 140
    const/4 v1, 0x0

    goto :goto_0

    .line 142
    :cond_5
    if-nez p4, :cond_6

    .line 143
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not set up crash detection, domainChooser is null."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 146
    :cond_6
    const-class v16, Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    monitor-enter v16

    .line 147
    :try_start_0
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    if-nez v1, :cond_7

    .line 148
    new-instance v11, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;

    invoke-direct {v11}, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;-><init>()V

    .line 150
    .local v11, "crashDetailsAggregator":Lcom/amazon/device/crashmanager/CrashDetailsAggregator;
    new-instance v14, Lcom/amazon/device/crashmanager/CrashDetailsCollector;

    move-object/from16 v0, p5

    invoke-direct {v14, v0}, Lcom/amazon/device/crashmanager/CrashDetailsCollector;-><init>(Landroid/content/Context;)V

    .line 152
    .local v14, "crashDetailsCollector":Lcom/amazon/device/crashmanager/CrashDetailsCollector;
    invoke-virtual {v11, v14}, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;->appendCollector(Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V

    .line 153
    new-instance v6, Lcom/amazon/device/crashmanager/AppFileArtifactSource;

    move-object/from16 v0, p5

    invoke-direct {v6, v0, v11}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;-><init>(Landroid/content/Context;Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V

    .line 155
    .local v6, "appFileArtifactSource":Lcom/amazon/device/crashmanager/AppFileArtifactSource;
    new-instance v7, Lcom/amazon/device/crashmanager/AmazonPackageLookup;

    move-object/from16 v0, p5

    invoke-direct {v7, v0}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;-><init>(Landroid/content/Context;)V

    .line 157
    .local v7, "amazonPackageLookup":Lcom/amazon/device/crashmanager/AmazonPackageLookup;
    invoke-static/range {p5 .. p5}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    .line 159
    .local v9, "networkManager":Lcom/amazon/device/utils/NetworkManager;
    const-string/jumbo v1, "CrashDetectionHelper.crashManager"

    const/4 v2, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v15

    .line 161
    .local v15, "sharedPreferences":Landroid/content/SharedPreferences;
    const-wide/32 v12, 0x5265c00

    .line 162
    .local v12, "cachExpirationTimeMs":J
    new-instance v10, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    const/16 v1, 0x32

    const-wide/32 v2, 0x5265c00

    invoke-direct {v10, v15, v1, v2, v3}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;-><init>(Landroid/content/SharedPreferences;IJ)V

    .line 166
    .local v10, "crashDescStorageUtil":Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;
    new-instance v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v8, p4

    invoke-direct/range {v1 .. v11}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/device/utils/OAuthHelper;Lcom/amazon/client/metrics/MetricsFactory;Lcom/amazon/device/crashmanager/AppFileArtifactSource;Lcom/amazon/device/crashmanager/AmazonPackageLookup;Lcom/amazon/device/crashmanager/DomainChooser;Lcom/amazon/device/utils/NetworkManager;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;Lcom/amazon/device/crashmanager/CrashDetailsAggregator;)V

    sput-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    .line 171
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    invoke-virtual {v1}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->uploadCrashReportAsync()V

    .line 173
    .end local v6    # "appFileArtifactSource":Lcom/amazon/device/crashmanager/AppFileArtifactSource;
    .end local v7    # "amazonPackageLookup":Lcom/amazon/device/crashmanager/AmazonPackageLookup;
    .end local v9    # "networkManager":Lcom/amazon/device/utils/NetworkManager;
    .end local v10    # "crashDescStorageUtil":Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;
    .end local v11    # "crashDetailsAggregator":Lcom/amazon/device/crashmanager/CrashDetailsAggregator;
    .end local v12    # "cachExpirationTimeMs":J
    .end local v14    # "crashDetailsCollector":Lcom/amazon/device/crashmanager/CrashDetailsCollector;
    .end local v15    # "sharedPreferences":Landroid/content/SharedPreferences;
    :cond_7
    monitor-exit v16
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 175
    if-eqz p6, :cond_9

    .line 176
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v1

    instance-of v1, v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    if-nez v1, :cond_8

    .line 177
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Installing crash detector as default exception handler."

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 178
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    invoke-static {v1}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 186
    :goto_1
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->sCrashDetectionHelper:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    goto/16 :goto_0

    .line 173
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v16
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 180
    :cond_8
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Crash detector already set up."

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 183
    :cond_9
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Caller opted out of installing uncaught exception handler."

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method


# virtual methods
.method public appendCrashDetailsCollector(Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V
    .locals 2
    .param p1, "crashDetailsCollector"    # Lcom/amazon/device/crashmanager/CrashDetailsCollectable;

    .prologue
    .line 273
    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mCrashDetailAggregator:Lcom/amazon/device/crashmanager/CrashDetailsAggregator;

    if-nez v0, :cond_0

    .line 274
    sget-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not set up additional crash detail collector. Initialize CrashDetectionHelper first."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    :goto_0
    return-void

    .line 277
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mCrashDetailAggregator:Lcom/amazon/device/crashmanager/CrashDetailsAggregator;

    invoke-virtual {v0, p1}, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;->appendCollector(Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V

    goto :goto_0
.end method

.method public reportCrash(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 369
    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mAppFileArtifactSource:Lcom/amazon/device/crashmanager/AppFileArtifactSource;

    invoke-virtual {v0, p1}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->saveCrash(Ljava/lang/Throwable;)V

    .line 370
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->uploadCrashReportAsync()V

    .line 371
    return-void
.end method

.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 237
    :try_start_0
    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mAppFileArtifactSource:Lcom/amazon/device/crashmanager/AppFileArtifactSource;

    invoke-virtual {v0, p2}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->saveCrash(Ljava/lang/Throwable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 241
    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mPreviousHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    if-eqz v0, :cond_0

    .line 242
    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mPreviousHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v0, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 245
    :cond_0
    return-void

    .line 241
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mPreviousHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    if-eqz v1, :cond_1

    .line 242
    iget-object v1, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mPreviousHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v1, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    :cond_1
    throw v0
.end method

.method uploadCrashReport()V
    .locals 19

    .prologue
    .line 313
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mNetworkManager:Lcom/amazon/device/utils/NetworkManager;

    invoke-virtual {v1}, Lcom/amazon/device/utils/NetworkManager;->isWifiConnected()Z

    move-result v1

    if-nez v1, :cond_0

    .line 314
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Skipping crash report upload. WiFi is not connected."

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 356
    :goto_0
    return-void

    .line 318
    :cond_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v3, "CrashManager"

    const-string/jumbo v4, "uploadCrashEntries"

    invoke-interface {v1, v3, v4}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v18

    .line 323
    .local v18, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    :try_start_0
    new-instance v2, Lcom/amazon/device/utils/DetUtil;

    invoke-direct {v2}, Lcom/amazon/device/utils/DetUtil;-><init>()V

    .line 325
    .local v2, "detUtil":Lcom/amazon/device/utils/DetUtil;
    new-instance v11, Ljava/util/LinkedList;

    invoke-direct {v11}, Ljava/util/LinkedList;-><init>()V

    .line 326
    .local v11, "artifactSources":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/crashmanager/ArtifactSource;>;"
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mAppFileArtifactSource:Lcom/amazon/device/crashmanager/AppFileArtifactSource;

    invoke-interface {v11, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 328
    new-instance v6, Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

    move-object/from16 v0, v18

    invoke-direct {v6, v1, v0}, Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;-><init>(Lcom/amazon/device/crashmanager/AmazonPackageLookup;Lcom/amazon/client/metrics/MetricEvent;)V

    .line 330
    .local v6, "metricsHeaderProcessorFactory":Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;
    new-instance v12, Ljava/util/LinkedList;

    invoke-direct {v12}, Ljava/util/LinkedList;-><init>()V

    .line 334
    .local v12, "artifactProcessors":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/crashmanager/ArtifactProcessor;>;"
    const/4 v5, 0x0

    .line 335
    .local v5, "extraInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v1, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mDeviceType:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mDeviceId:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mCrashDescUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-direct/range {v1 .. v7}, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;-><init>(Lcom/amazon/device/utils/DetUtil;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;)V

    invoke-interface {v12, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 338
    new-instance v7, Lcom/amazon/device/crashmanager/ArtifactUploader;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mDomainChooser:Lcom/amazon/device/crashmanager/DomainChooser;

    invoke-interface {v1}, Lcom/amazon/device/crashmanager/DomainChooser;->chooseDomain()Lcom/amazon/device/crashmanager/Domain;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/device/crashmanager/DetEndpointConfig;->getServiceEndpoint(Lcom/amazon/device/crashmanager/Domain;)Lamazon/communication/identity/EndpointIdentity;

    move-result-object v8

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mDeviceType:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mDeviceId:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mCrashDescUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mRequestSigner:Lcom/amazon/communication/authentication/RequestSigner;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mNetworkManager:Lcom/amazon/device/utils/NetworkManager;

    move-object/from16 v16, v0

    invoke-direct/range {v7 .. v16}, Lcom/amazon/device/crashmanager/ArtifactUploader;-><init>(Lamazon/communication/identity/EndpointIdentity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;Lcom/amazon/device/utils/StatusNotifier;Lcom/amazon/communication/authentication/RequestSigner;Lcom/amazon/device/utils/NetworkManager;)V

    .line 350
    .local v7, "artifactUploader":Lcom/amazon/device/crashmanager/ArtifactUploader;
    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Lcom/amazon/device/crashmanager/ArtifactUploader;->uploadArtifacts(Lcom/amazon/client/metrics/MetricEvent;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 354
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    move-object/from16 v0, v18

    invoke-interface {v1, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    goto :goto_0

    .line 351
    .end local v2    # "detUtil":Lcom/amazon/device/utils/DetUtil;
    .end local v5    # "extraInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "metricsHeaderProcessorFactory":Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;
    .end local v7    # "artifactUploader":Lcom/amazon/device/crashmanager/ArtifactUploader;
    .end local v11    # "artifactSources":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/crashmanager/ArtifactSource;>;"
    .end local v12    # "artifactProcessors":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/crashmanager/ArtifactProcessor;>;"
    :catch_0
    move-exception v17

    .line 352
    .local v17, "e":Ljava/lang/Exception;
    :try_start_1
    sget-object v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Exception thrown while uploading crash entries"

    move-object/from16 v0, v17

    invoke-static {v1, v3, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 354
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    move-object/from16 v0, v18

    invoke-interface {v1, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    goto/16 :goto_0

    .end local v17    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    move-object/from16 v0, v18

    invoke-interface {v3, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    throw v1
.end method

.method public uploadCrashReportAsync()V
    .locals 2

    .prologue
    .line 291
    sget-object v0, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->SINGLE_THREADED_EXECUTOR:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/amazon/device/crashmanager/CrashDetectionHelper$1;

    invoke-direct {v1, p0}, Lcom/amazon/device/crashmanager/CrashDetectionHelper$1;-><init>(Lcom/amazon/device/crashmanager/CrashDetectionHelper;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 301
    return-void
.end method

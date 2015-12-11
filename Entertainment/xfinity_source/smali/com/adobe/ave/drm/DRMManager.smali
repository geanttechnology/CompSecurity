.class public Lcom/adobe/ave/drm/DRMManager;
.super Ljava/lang/Object;
.source "DRMManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;,
        Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;,
        Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;,
        Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;,
        Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;
    }
.end annotation


# static fields
.field static final TAG:Ljava/lang/String; = "DRMManager(j)"

.field private static sEmbeddedMetadata:Lcom/adobe/ave/drm/DRMMetadata;

.field private static sManager:Lcom/adobe/ave/drm/DRMManager;


# instance fields
.field private mHandler:Landroid/os/Handler;

.field protected peerObject:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    const-string v0, "AVEAndroid"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 199
    const/4 v0, 0x0

    sput-object v0, Lcom/adobe/ave/drm/DRMManager;->sManager:Lcom/adobe/ave/drm/DRMManager;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 10
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v6, 0x0

    .line 174
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 175
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/adobe/ave/drm/DRMManager;->mHandler:Landroid/os/Handler;

    .line 178
    const-string v2, "/data/local"

    .line 179
    .local v2, "appStoragePath":Ljava/lang/String;
    const-string v3, "<default-pubid>"

    .line 180
    .local v3, "pubID":Ljava/lang/String;
    const-string v4, "<default-appid>"

    .line 181
    .local v4, "appID":Ljava/lang/String;
    const-string v5, "1.0"

    .line 183
    .local v5, "appVersion":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 184
    .local v8, "pkg":Landroid/content/pm/PackageManager;
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x40

    invoke-virtual {v8, v0, v1}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v7

    .line 185
    .local v7, "pi":Landroid/content/pm/PackageInfo;
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    .line 186
    iget-object v0, v7, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    const/4 v1, 0x0

    aget-object v9, v0, v1

    .line 187
    .local v9, "sig":Landroid/content/pm/Signature;
    invoke-virtual {v9}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/ave/drm/DRMManager;->toHexString([B)Ljava/lang/String;

    move-result-object v3

    .line 188
    iget-object v4, v7, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    .line 189
    iget-object v5, v7, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local v7    # "pi":Landroid/content/pm/PackageInfo;
    .end local v8    # "pkg":Landroid/content/pm/PackageManager;
    .end local v9    # "sig":Landroid/content/pm/Signature;
    :goto_0
    move-object v0, p0

    move-object v1, p1

    .line 196
    invoke-direct/range {v0 .. v6}, Lcom/adobe/ave/drm/DRMManager;->constructNative(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/ave/drm/DRMManager;->peerObject:J

    .line 197
    return-void

    .line 191
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/adobe/ave/drm/DRMManager;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/adobe/ave/drm/DRMManager;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMManager;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$100()Lcom/adobe/ave/drm/DRMManager;
    .locals 1

    .prologue
    .line 41
    sget-object v0, Lcom/adobe/ave/drm/DRMManager;->sManager:Lcom/adobe/ave/drm/DRMManager;

    return-object v0
.end method

.method static synthetic access$200(Lcom/adobe/ave/drm/DRMManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/adobe/ave/drm/DRMManager;

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/adobe/ave/drm/DRMManager;->needsCycles()V

    return-void
.end method

.method private native acquireLicenseNative(Lcom/adobe/ave/drm/DRMMetadata;ILcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V
.end method

.method private native acquirePreviewLicenseNative(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V
.end method

.method private native authenticateNative(Lcom/adobe/ave/drm/DRMMetadata;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMAuthenticationCompleteCallback;)V
.end method

.method private native constructNative(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)J
.end method

.method private native getEmbeddedLicense()[B
.end method

.method public static declared-synchronized getSharedManager(Landroid/content/Context;)Lcom/adobe/ave/drm/DRMManager;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 206
    const-class v1, Lcom/adobe/ave/drm/DRMManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/adobe/ave/drm/DRMManager;->sManager:Lcom/adobe/ave/drm/DRMManager;

    if-nez v0, :cond_0

    .line 207
    new-instance v0, Lcom/adobe/ave/drm/DRMManager;

    invoke-direct {v0, p0}, Lcom/adobe/ave/drm/DRMManager;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/adobe/ave/drm/DRMManager;->sManager:Lcom/adobe/ave/drm/DRMManager;

    .line 210
    :cond_0
    sget-object v0, Lcom/adobe/ave/drm/DRMManager;->sManager:Lcom/adobe/ave/drm/DRMManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 206
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static jobDoneNotify()V
    .locals 2

    .prologue
    .line 218
    const-string v0, "DRMManager(j)"

    const-string v1, "DRMManager.jobDoneNotify()"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 219
    sget-object v0, Lcom/adobe/ave/drm/DRMManager;->sManager:Lcom/adobe/ave/drm/DRMManager;

    if-nez v0, :cond_0

    .line 220
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 223
    :cond_0
    sget-object v0, Lcom/adobe/ave/drm/DRMManager;->sManager:Lcom/adobe/ave/drm/DRMManager;

    iget-object v0, v0, Lcom/adobe/ave/drm/DRMManager;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$1;

    invoke-direct {v1}, Lcom/adobe/ave/drm/DRMManager$1;-><init>()V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 231
    return-void
.end method

.method private native joinLicenseDomainNative(Lcom/adobe/ave/drm/DRMLicenseDomain;ZLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
.end method

.method private native leaveLicenseDomainNative(Lcom/adobe/ave/drm/DRMLicenseDomain;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
.end method

.method private native needsCycles()V
.end method

.method private native resetDRMNative(Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
.end method

.method private native returnLicenseNative(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;)V
.end method

.method private native setAuthenticationTokenNative(Lcom/adobe/ave/drm/DRMMetadata;Ljava/lang/String;[BLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
.end method

.method private native storeLicenseBytesNative([BLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
.end method

.method private static toHexString([B)Ljava/lang/String;
    .locals 5
    .param p0, "buf"    # [B

    .prologue
    .line 158
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 159
    .local v1, "hexString":Ljava/lang/StringBuffer;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v3, p0

    if-ge v2, v3, :cond_1

    .line 160
    aget-byte v3, p0, v2

    and-int/lit16 v3, v3, 0xff

    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    .line 161
    .local v0, "hex":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 162
    const/16 v3, 0x30

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 163
    :cond_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 159
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 166
    .end local v0    # "hex":Ljava/lang/String;
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method


# virtual methods
.method public acquireLicense(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V
    .locals 3
    .param p1, "contentData"    # Lcom/adobe/ave/drm/DRMMetadata;
    .param p2, "setting"    # Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;
    .param p3, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p4, "acquired"    # Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    .prologue
    .line 364
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-nez p4, :cond_1

    .line 365
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 366
    :cond_1
    invoke-virtual {p2}, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->ordinal()I

    move-result v0

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v1, p0, p3}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v2, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;

    invoke-direct {v2, p0, p4}, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/adobe/ave/drm/DRMManager;->acquireLicenseNative(Lcom/adobe/ave/drm/DRMMetadata;ILcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V

    .line 369
    return-void
.end method

.method public acquirePreviewLicense(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V
    .locals 2
    .param p1, "contentData"    # Lcom/adobe/ave/drm/DRMMetadata;
    .param p2, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p3, "acquired"    # Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;

    .prologue
    .line 336
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 337
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 338
    :cond_1
    new-instance v0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v0, p0, p2}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;

    invoke-direct {v1, p0, p3}, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseAcquiredCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V

    invoke-direct {p0, p1, v0, v1}, Lcom/adobe/ave/drm/DRMManager;->acquirePreviewLicenseNative(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V

    .line 341
    return-void
.end method

.method public authenticate(Lcom/adobe/ave/drm/DRMMetadata;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMAuthenticationCompleteCallback;)V
    .locals 8
    .param p1, "metadata"    # Lcom/adobe/ave/drm/DRMMetadata;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "authenticationDomain"    # Ljava/lang/String;
    .param p4, "user"    # Ljava/lang/String;
    .param p5, "password"    # Ljava/lang/String;
    .param p6, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p7, "complete"    # Lcom/adobe/ave/drm/DRMAuthenticationCompleteCallback;

    .prologue
    .line 319
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-eqz p4, :cond_0

    if-eqz p5, :cond_0

    if-eqz p6, :cond_0

    if-nez p7, :cond_1

    .line 320
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 321
    :cond_1
    new-instance v6, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v6, p0, p6}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v7, Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;

    invoke-direct {v7, p0, p7}, Lcom/adobe/ave/drm/DRMManager$UIThreadAuthCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMAuthenticationCompleteCallback;)V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v7}, Lcom/adobe/ave/drm/DRMManager;->authenticateNative(Lcom/adobe/ave/drm/DRMMetadata;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMAuthenticationCompleteCallback;)V

    .line 324
    return-void
.end method

.method public createMetadataFromBytes([BLcom/adobe/ave/drm/DRMOperationErrorCallback;)Lcom/adobe/ave/drm/DRMMetadata;
    .locals 1
    .param p1, "bytes"    # [B
    .param p2, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    .prologue
    .line 266
    invoke-static {p0, p1, p2}, Lcom/adobe/ave/drm/DRMMetadata;->createFromData(Lcom/adobe/ave/drm/DRMManager;[BLcom/adobe/ave/drm/DRMOperationErrorCallback;)Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v0

    return-object v0
.end method

.method public native getMaxOperationTime()J
.end method

.method public initialize(Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    .locals 3
    .param p1, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p2, "complete"    # Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .prologue
    .line 247
    sget-object v0, Lcom/adobe/ave/drm/DRMManager;->sEmbeddedMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    if-eqz v0, :cond_1

    .line 249
    invoke-interface {p2}, Lcom/adobe/ave/drm/DRMOperationCompleteCallback;->OperationComplete()V

    .line 262
    :cond_0
    :goto_0
    return-void

    .line 253
    :cond_1
    invoke-direct {p0}, Lcom/adobe/ave/drm/DRMManager;->getEmbeddedLicense()[B

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/adobe/ave/drm/DRMManager;->createMetadataFromBytes([BLcom/adobe/ave/drm/DRMOperationErrorCallback;)Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v0

    sput-object v0, Lcom/adobe/ave/drm/DRMManager;->sEmbeddedMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    .line 254
    sget-object v0, Lcom/adobe/ave/drm/DRMManager;->sEmbeddedMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    if-eqz v0, :cond_0

    .line 257
    sget-object v0, Lcom/adobe/ave/drm/DRMManager;->sEmbeddedMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    sget-object v1, Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;->LOCAL_ONLY:Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;

    new-instance v2, Lcom/adobe/ave/drm/DRMManager$2;

    invoke-direct {v2, p0, p2}, Lcom/adobe/ave/drm/DRMManager$2;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    invoke-virtual {p0, v0, v1, p1, v2}, Lcom/adobe/ave/drm/DRMManager;->acquireLicense(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/ave/drm/DRMAcquireLicenseSettings;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseAcquiredCallback;)V

    goto :goto_0
.end method

.method public joinLicenseDomain(Lcom/adobe/ave/drm/DRMLicenseDomain;ZLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    .locals 2
    .param p1, "licenseDomain"    # Lcom/adobe/ave/drm/DRMLicenseDomain;
    .param p2, "forceRefresh"    # Z
    .param p3, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p4, "complete"    # Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .prologue
    .line 421
    if-eqz p1, :cond_0

    if-eqz p3, :cond_0

    if-nez p4, :cond_1

    .line 422
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 423
    :cond_1
    new-instance v0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v0, p0, p3}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;

    invoke-direct {v1, p0, p4}, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/adobe/ave/drm/DRMManager;->joinLicenseDomainNative(Lcom/adobe/ave/drm/DRMLicenseDomain;ZLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    .line 426
    return-void
.end method

.method public leaveLicenseDomain(Lcom/adobe/ave/drm/DRMLicenseDomain;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    .locals 2
    .param p1, "licenseDomain"    # Lcom/adobe/ave/drm/DRMLicenseDomain;
    .param p2, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p3, "complete"    # Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .prologue
    .line 431
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 432
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 433
    :cond_1
    new-instance v0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v0, p0, p2}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;

    invoke-direct {v1, p0, p3}, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    invoke-direct {p0, p1, v0, v1}, Lcom/adobe/ave/drm/DRMManager;->leaveLicenseDomainNative(Lcom/adobe/ave/drm/DRMLicenseDomain;Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    .line 436
    return-void
.end method

.method public resetDRM(Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    .locals 2
    .param p1, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p2, "complete"    # Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .prologue
    .line 389
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 390
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 391
    :cond_1
    new-instance v0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v0, p0, p1}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;

    invoke-direct {v1, p0, p2}, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    invoke-direct {p0, v0, v1}, Lcom/adobe/ave/drm/DRMManager;->resetDRMNative(Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    .line 394
    return-void
.end method

.method public returnLicense(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;)V
    .locals 7
    .param p1, "serverURL"    # Ljava/lang/String;
    .param p2, "licenseID"    # Ljava/lang/String;
    .param p3, "policyID"    # Ljava/lang/String;
    .param p4, "commitImmediately"    # Z
    .param p5, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p6, "complete"    # Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;

    .prologue
    .line 409
    if-eqz p1, :cond_0

    if-eqz p5, :cond_0

    if-nez p6, :cond_1

    .line 410
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 412
    :cond_1
    new-instance v5, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v5, p0, p5}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v6, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;

    invoke-direct {v6, p0, p6}, Lcom/adobe/ave/drm/DRMManager$UIThreadLicenseReturnCompleteCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;)V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v6}, Lcom/adobe/ave/drm/DRMManager;->returnLicenseNative(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMLicenseReturnCompleteCallback;)V

    .line 416
    return-void
.end method

.method public setAuthenticationToken(Lcom/adobe/ave/drm/DRMMetadata;Ljava/lang/String;[BLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    .locals 6
    .param p1, "metadata"    # Lcom/adobe/ave/drm/DRMMetadata;
    .param p2, "authenticationDomain"    # Ljava/lang/String;
    .param p3, "token"    # [B
    .param p4, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p5, "complete"    # Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .prologue
    .line 292
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-eqz p4, :cond_0

    if-nez p5, :cond_1

    .line 293
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 294
    :cond_1
    new-instance v4, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v4, p0, p4}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v5, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;

    invoke-direct {v5, p0, p5}, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v5}, Lcom/adobe/ave/drm/DRMManager;->setAuthenticationTokenNative(Lcom/adobe/ave/drm/DRMMetadata;Ljava/lang/String;[BLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    .line 297
    return-void
.end method

.method public setMaxOperationTime(J)V
    .locals 3
    .param p1, "maxOperationTime"    # J

    .prologue
    .line 274
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    const-wide/32 v0, 0x7fffffff

    cmp-long v0, p1, v0

    if-lez v0, :cond_1

    .line 275
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 276
    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/adobe/ave/drm/DRMManager;->setMaxOperationTimeNative(J)V

    .line 277
    return-void
.end method

.method public native setMaxOperationTimeNative(J)V
.end method

.method public storeLicenseBytes([BLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V
    .locals 3
    .param p1, "licenseBytes"    # [B
    .param p2, "error"    # Lcom/adobe/ave/drm/DRMOperationErrorCallback;
    .param p3, "complete"    # Lcom/adobe/ave/drm/DRMOperationCompleteCallback;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 374
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    move v2, v0

    :goto_0
    if-nez p3, :cond_2

    :goto_1
    or-int/2addr v0, v2

    if-eqz v0, :cond_3

    .line 375
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_1
    move v2, v1

    .line 374
    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1

    .line 376
    :cond_3
    new-instance v0, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;

    invoke-direct {v0, p0, p2}, Lcom/adobe/ave/drm/DRMManager$UIThreadErrorCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationErrorCallback;)V

    new-instance v1, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;

    invoke-direct {v1, p0, p3}, Lcom/adobe/ave/drm/DRMManager$UIThreadCompleteCB;-><init>(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    invoke-direct {p0, p1, v0, v1}, Lcom/adobe/ave/drm/DRMManager;->storeLicenseBytesNative([BLcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    .line 379
    return-void
.end method

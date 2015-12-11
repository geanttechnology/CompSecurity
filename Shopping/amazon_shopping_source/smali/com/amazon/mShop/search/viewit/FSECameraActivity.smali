.class public abstract Lcom/amazon/mShop/search/viewit/FSECameraActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "FSECameraActivity.java"

# interfaces
.implements Lcom/a9/cameralibrary/CameraFrameListener;
.implements Lcom/a9/cameralibrary/NewCameraPreview;
.implements Lcom/flow/android/engine/library/FlowStateEngineInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;
    }
.end annotation


# static fields
.field private static mMaxFPS:F

.field private static sEngine:Lcom/flow/android/engine/library/FlowStateEngine;


# instance fields
.field private mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

.field private mCameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

.field private mCredentials:Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;

.field private mDeltaFPS:F

.field private mDeviceId:Ljava/lang/String;

.field protected mIsBarcodeScanOnly:Z

.field private mIsEnginePaused:Z

.field private mIsEngineStopped:Z

.field private mMaxHeight:I

.field private mMinHeight:I

.field private mModules:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;",
            ">;"
        }
    .end annotation
.end field

.field private mNextTimeAllowed:D

.field private mPlatformVersionString:Ljava/lang/String;

.field private mSensorManager:Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;

.field private mSessionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 44
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 65
    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEngineStopped:Z

    .line 66
    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEnginePaused:Z

    .line 76
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsBarcodeScanOnly:Z

    .line 554
    return-void
.end method

.method private getMaxImageHeightFromEngine()I
    .locals 1

    .prologue
    .line 245
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v0, :cond_0

    .line 246
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngine;->getMaxImageHeight()I

    move-result v0

    .line 248
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getMinImageHeightFromEngine()I
    .locals 1

    .prologue
    .line 237
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v0, :cond_0

    .line 238
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngine;->getMinImageHeight()I

    move-result v0

    .line 240
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private initDeviceParams()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 256
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getPreferences(I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 263
    .local v2, "settings":Landroid/content/SharedPreferences;
    const-string/jumbo v3, "DEVICE_ID"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeviceId:Ljava/lang/String;

    .line 266
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeviceId:Ljava/lang/String;

    if-nez v3, :cond_0

    .line 267
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeviceId:Ljava/lang/String;

    .line 268
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 269
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v3, "DEVICE_ID"

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeviceId:Ljava/lang/String;

    invoke-interface {v1, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 270
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 277
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mSessionId:Ljava/lang/String;

    .line 280
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mPlatformVersionString:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 284
    :goto_0
    return-void

    .line 281
    :catch_0
    move-exception v0

    .line 282
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string/jumbo v3, "1.0"

    iput-object v3, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mPlatformVersionString:Ljava/lang/String;

    goto :goto_0
.end method

.method public static final sendEngineMetrics()V
    .locals 1

    .prologue
    .line 303
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v0, :cond_0

    .line 304
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngine;->sendFSEMetrics()V

    .line 306
    :cond_0
    return-void
.end method

.method private startEngine()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 152
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-nez v2, :cond_0

    .line 155
    :try_start_0
    new-instance v1, Lcom/flow/android/engine/models/FlowStateEngineIO;

    invoke-direct {v1}, Lcom/flow/android/engine/models/FlowStateEngineIO;-><init>()V

    .line 156
    .local v1, "engineIO":Lcom/flow/android/engine/models/FlowStateEngineIO;
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCredentials:Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->getSecret()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setSecret(Ljava/lang/String;)V

    .line 157
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCredentials:Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->getApplicationKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setApplication(Ljava/lang/String;)V

    .line 158
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getDeviceId()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeviceId:Ljava/lang/String;

    .line 159
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeviceId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setClientDeviceID(Ljava/lang/String;)V

    .line 160
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getPlatformVersionString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setClientVersion(Ljava/lang/String;)V

    .line 161
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getSessionId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setClientSessionID(Ljava/lang/String;)V

    .line 162
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getImageMatchServer()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setImgServer(Ljava/lang/String;)V

    .line 163
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getTextMatchServer()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setTextServer(Ljava/lang/String;)V

    .line 164
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getErrorReportingServer()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setErrorReportingServer(Ljava/lang/String;)V

    .line 165
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setDataCollectionDisabled(Z)V

    .line 166
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setPrintToScreen(Z)V

    .line 167
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setUseLogFile(Z)V

    .line 168
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCredentials:Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->getUser()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/flow/android/engine/models/FlowStateEngineIO;->setUsername(Ljava/lang/String;)V

    .line 171
    new-instance v2, Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-direct {v2, p0, p0, v1}, Lcom/flow/android/engine/library/FlowStateEngine;-><init>(Lcom/flow/android/engine/library/FlowStateEngineInterface;Landroid/content/Context;Lcom/flow/android/engine/models/FlowStateEngineIO;)V

    sput-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 177
    .end local v1    # "engineIO":Lcom/flow/android/engine/models/FlowStateEngineIO;
    :cond_0
    :goto_0
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v2, :cond_5

    .line 178
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mModules:Ljava/util/Set;

    sget-object v3, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->BARCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 179
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    sget-object v3, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->BARCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-virtual {v2, v3}, Lcom/flow/android/engine/library/FlowStateEngine;->addFlowObjectModule(Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;)V

    .line 181
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mModules:Ljava/util/Set;

    sget-object v3, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->QRCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 182
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    sget-object v3, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->QRCODE:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-virtual {v2, v3}, Lcom/flow/android/engine/library/FlowStateEngine;->addFlowObjectModule(Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;)V

    .line 184
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mModules:Ljava/util/Set;

    sget-object v3, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->IMAGEMATCH:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 185
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    sget-object v3, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->IMAGEMATCH:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-virtual {v2, v3}, Lcom/flow/android/engine/library/FlowStateEngine;->addFlowObjectModule(Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;)V

    .line 187
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mModules:Ljava/util/Set;

    sget-object v3, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->TEXT:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 188
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    sget-object v3, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->TEXT:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-virtual {v2, v3}, Lcom/flow/android/engine/library/FlowStateEngine;->addFlowObjectModule(Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;)V

    .line 190
    :cond_4
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-virtual {v2, p0}, Lcom/flow/android/engine/library/FlowStateEngine;->start(Lcom/flow/android/engine/library/FlowStateEngineInterface;)V

    .line 192
    iput-boolean v4, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEngineStopped:Z

    .line 193
    iput-boolean v4, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEnginePaused:Z

    .line 194
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mNextTimeAllowed:D

    .line 196
    :cond_5
    return-void

    .line 172
    :catch_0
    move-exception v0

    .line 173
    .local v0, "e":Ljava/lang/UnsatisfiedLinkError;
    const/4 v2, 0x0

    sput-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    goto :goto_0
.end method

.method private stopEngine()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 199
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEngineStopped:Z

    if-nez v0, :cond_0

    .line 200
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngine;->stop()V

    .line 201
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEngineStopped:Z

    .line 202
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEnginePaused:Z

    .line 204
    :cond_0
    return-void
.end method


# virtual methods
.method public cameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V
    .locals 0
    .param p1, "a_reason"    # Lcom/a9/cameralibrary/CameraErrorReason;
    .param p2, "a_extraInfo"    # Ljava/lang/String;

    .prologue
    .line 547
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->handleCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 548
    return-void
.end method

.method public didReceiveFrame([BIIIIIIIIJ)V
    .locals 16
    .param p1, "a_image"    # [B
    .param p2, "a_height"    # I
    .param p3, "a_width"    # I
    .param p4, "a_channels"    # I
    .param p5, "a_cameraPreviewFormat"    # I
    .param p6, "a_roiX"    # I
    .param p7, "a_roiY"    # I
    .param p8, "a_roiWidth"    # I
    .param p9, "a_roiHeight"    # I
    .param p10, "a_timeSinceInit"    # J

    .prologue
    .line 536
    move-wide/from16 v0, p10

    long-to-double v2, v0

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v3}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->shouldProcess(D)Z

    move-result v2

    if-nez v2, :cond_1

    .line 543
    :cond_0
    :goto_0
    return-void

    .line 539
    :cond_1
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEngineStopped:Z

    if-nez v2, :cond_0

    .line 540
    sget-object v2, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->getOrientation(Landroid/content/Context;)I

    move-result v12

    const/4 v13, 0x0

    move-object/from16 v3, p1

    move/from16 v4, p2

    move/from16 v5, p3

    move/from16 v6, p4

    move/from16 v7, p5

    move/from16 v8, p6

    move/from16 v9, p7

    move/from16 v10, p8

    move/from16 v11, p9

    move-wide/from16 v14, p10

    invoke-virtual/range {v2 .. v15}, Lcom/flow/android/engine/library/FlowStateEngine;->process([BIIIIIIIIIZJ)V

    goto :goto_0
.end method

.method public getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    return-object v0
.end method

.method protected abstract getCameraFrameLayout()Landroid/widget/FrameLayout;
.end method

.method protected abstract getCredentials()Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;
.end method

.method protected getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 377
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeviceId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 378
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->initDeviceParams()V

    .line 380
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeviceId:Ljava/lang/String;

    return-object v0
.end method

.method protected getErrorReportingServer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 366
    const-string/jumbo v0, "http://ters.amazon.com/errorreport"

    return-object v0
.end method

.method protected getImageMatchServer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 357
    const-string/jumbo v0, "https://match-visualsearch.amazon.com/vsearch"

    return-object v0
.end method

.method protected abstract getModuleSet()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;",
            ">;"
        }
    .end annotation
.end method

.method protected abstract getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;
.end method

.method protected getPlatformVersionString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 384
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mPlatformVersionString:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 385
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->initDeviceParams()V

    .line 387
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mPlatformVersionString:Ljava/lang/String;

    return-object v0
.end method

.method protected getSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 370
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mSessionId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 371
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->initDeviceParams()V

    .line 373
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mSessionId:Ljava/lang/String;

    return-object v0
.end method

.method protected getTextMatchServer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 348
    const-string/jumbo v0, "https://match-visualsearch.amazon.com/textmatch"

    return-object v0
.end method

.method protected abstract handleCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V
.end method

.method protected abstract handleEngineError()V
.end method

.method protected initFPS()V
    .locals 2

    .prologue
    .line 449
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v0

    .line 450
    .local v0, "numberProcessors":I
    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    const/high16 v1, 0x41f00000    # 30.0f

    :goto_0
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->setMaxFPS(F)V

    .line 451
    return-void

    .line 450
    :cond_0
    const/high16 v1, 0x41c80000    # 25.0f

    goto :goto_0
.end method

.method protected abstract initLayout()V
.end method

.method protected initScreen()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 462
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    .line 464
    .local v1, "window":Landroid/view/Window;
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsBarcodeScanOnly:Z

    if-eqz v2, :cond_2

    .line 466
    const-string/jumbo v2, "scan_session"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 468
    invoke-static {p0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->getActivityOrientation(Lcom/amazon/mShop/AmazonActivity;)I

    move-result v0

    .line 471
    .local v0, "activityOrientation":I
    if-eq v0, v3, :cond_0

    const/16 v2, 0x9

    if-ne v0, v2, :cond_1

    .line 473
    :cond_0
    const-string/jumbo v2, "scan_open_port"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 478
    :goto_0
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->setRequestedOrientation(I)V

    .line 481
    const/16 v2, 0x400

    invoke-virtual {v1, v2}, Landroid/view/Window;->addFlags(I)V

    .line 487
    .end local v0    # "activityOrientation":I
    :goto_1
    const/16 v2, 0x80

    invoke-virtual {v1, v2}, Landroid/view/Window;->addFlags(I)V

    .line 488
    invoke-virtual {v1, v3}, Landroid/view/Window;->requestFeature(I)Z

    .line 489
    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 490
    return-void

    .line 475
    .restart local v0    # "activityOrientation":I
    :cond_1
    const-string/jumbo v2, "scan_open_land"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 484
    .end local v0    # "activityOrientation":I
    :cond_2
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->setRequestedOrientation(I)V

    goto :goto_1
.end method

.method protected isEnginePaused()Z
    .locals 1

    .prologue
    .line 229
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEnginePaused:Z

    return v0
.end method

.method protected isEngineStopped()Z
    .locals 1

    .prologue
    .line 233
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEngineStopped:Z

    return v0
.end method

.method public newCameraPreview()Lcom/a9/cameralibrary/A9CameraPreview;
    .locals 1

    .prologue
    .line 529
    new-instance v0, Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-direct {v0, p0, p0}, Lcom/a9/cameralibrary/A9CameraPreview;-><init>(Landroid/content/Context;Lcom/a9/cameralibrary/CameraFrameListener;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    .line 530
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v0, 0x0

    .line 90
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 91
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "MODULE_TYPE_IS_IMAGE_SEARCH"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsBarcodeScanOnly:Z

    .line 93
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->initScreen()V

    .line 94
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->initLayout()V

    .line 95
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getCredentials()Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCredentials:Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;

    .line 96
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getModuleSet()Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mModules:Ljava/util/Set;

    .line 97
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;-><init>(Lcom/amazon/mShop/search/viewit/FSECameraActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mSensorManager:Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;

    .line 98
    new-instance v0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;-><init>(Lcom/amazon/mShop/search/viewit/FSECameraActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    .line 100
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->initFPS()V

    .line 101
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v0, 0x0

    .line 105
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->setIntent(Landroid/content/Intent;)V

    .line 106
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 107
    const-string/jumbo v1, "MODULE_TYPE_IS_IMAGE_SEARCH"

    invoke-virtual {p1, v1, v0}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsBarcodeScanOnly:Z

    .line 108
    return-void
.end method

.method protected pauseEngine()V
    .locals 1

    .prologue
    .line 207
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v0, :cond_0

    .line 208
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngine;->pause()V

    .line 210
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEnginePaused:Z

    .line 212
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    if-eqz v0, :cond_1

    .line 213
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->pause()V

    .line 215
    :cond_1
    return-void
.end method

.method protected final setMaxFPS(F)V
    .locals 2
    .param p1, "a_fps"    # F

    .prologue
    .line 411
    sput p1, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMaxFPS:F

    .line 412
    const/high16 v0, 0x3f800000    # 1.0f

    sget v1, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMaxFPS:F

    div-float/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeltaFPS:F

    .line 413
    return-void
.end method

.method protected shouldProcess(D)Z
    .locals 5
    .param p1, "frame_timestamp"    # D

    .prologue
    .line 423
    sget v1, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMaxFPS:F

    const/high16 v2, 0x41f00000    # 30.0f

    cmpl-float v1, v1, v2

    if-nez v1, :cond_0

    .line 425
    const/4 v0, 0x1

    .line 439
    :goto_0
    return v0

    .line 427
    :cond_0
    const/4 v0, 0x1

    .line 428
    .local v0, "process":Z
    iget-wide v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mNextTimeAllowed:D

    const-wide/16 v3, 0x0

    cmpl-double v1, v1, v3

    if-nez v1, :cond_1

    .line 429
    iget v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeltaFPS:F

    float-to-double v1, v1

    add-double/2addr v1, p1

    iput-wide v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mNextTimeAllowed:D

    goto :goto_0

    .line 431
    :cond_1
    iget-wide v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mNextTimeAllowed:D

    cmpl-double v1, p1, v1

    if-lez v1, :cond_2

    .line 433
    iget-wide v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mNextTimeAllowed:D

    iget v3, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mDeltaFPS:F

    float-to-double v3, v3

    add-double/2addr v1, v3

    iput-wide v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mNextTimeAllowed:D

    goto :goto_0

    .line 436
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public start()V
    .locals 3

    .prologue
    .line 114
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsBarcodeScanOnly:Z

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mSensorManager:Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->start()V

    .line 118
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->startEngine()V

    .line 120
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v0, :cond_4

    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngine;->didLibrariesLoad()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    if-eqz v0, :cond_3

    .line 122
    iget v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMinHeight:I

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMaxHeight:I

    if-nez v0, :cond_2

    .line 123
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getMinImageHeightFromEngine()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMinHeight:I

    .line 124
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getMaxImageHeightFromEngine()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMaxHeight:I

    .line 126
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    iget v1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMinHeight:I

    iget v2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mMaxHeight:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->start(II)V

    .line 131
    :cond_3
    :goto_0
    return-void

    .line 129
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->handleEngineError()V

    goto :goto_0
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 137
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsBarcodeScanOnly:Z

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mSensorManager:Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->stop()V

    .line 141
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->stopEngine()V

    .line 143
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    if-eqz v0, :cond_1

    .line 144
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->stop()V

    .line 146
    :cond_1
    return-void
.end method

.method protected unpauseEngine()V
    .locals 2

    .prologue
    .line 217
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    if-eqz v0, :cond_0

    .line 218
    sget-object v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->sEngine:Lcom/flow/android/engine/library/FlowStateEngine;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngine;->resume()V

    .line 220
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsEnginePaused:Z

    .line 221
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mNextTimeAllowed:D

    .line 223
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    if-eqz v0, :cond_1

    .line 224
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mCameraBgHelper:Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->unpause()V

    .line 226
    :cond_1
    return-void
.end method

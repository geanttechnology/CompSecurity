.class public abstract Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;
.super Landroid/app/Activity;
.source "CreditCardReaderActivity.java"

# interfaces
.implements Lcom/a9/cameralibrary/CameraFrameListener;
.implements Lcom/a9/cameralibrary/NewCameraPreview;


# static fields
.field private static s_libraryLoaded:Z


# instance fields
.field private m_bottomLeft:Landroid/graphics/Point;

.field private m_bottomRight:Landroid/graphics/Point;

.field private m_cameraBgHelper:Lcom/a9/cameralibrary/CameraBgHelper;

.field private m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

.field private m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

.field private m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

.field private m_delegate:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;

.field private m_haveCollectedCreditCardRegion:Z

.field private m_isEnginePaused:Z

.field private m_maxHeight:I

.field private m_minHeight:I

.field private m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

.field private m_topLeft:Landroid/graphics/Point;

.field private m_topRight:Landroid/graphics/Point;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 90
    :try_start_0
    const-string/jumbo v1, "A9VSMobile"

    invoke-static {v1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 91
    const/4 v1, 0x1

    sput-boolean v1, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->s_libraryLoaded:Z
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 95
    .local v0, "e":Ljava/lang/UnsatisfiedLinkError;
    :goto_0
    return-void

    .line 92
    .end local v0    # "e":Ljava/lang/UnsatisfiedLinkError;
    :catch_0
    move-exception v0

    .line 93
    .restart local v0    # "e":Ljava/lang/UnsatisfiedLinkError;
    const/4 v1, 0x0

    sput-boolean v1, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->s_libraryLoaded:Z

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 57
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 68
    iput-boolean v1, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_isEnginePaused:Z

    .line 72
    const/16 v0, 0x140

    iput v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_minHeight:I

    .line 73
    const/16 v0, 0x300

    iput v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_maxHeight:I

    .line 82
    iput-boolean v1, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_haveCollectedCreditCardRegion:Z

    return-void
.end method

.method static synthetic access$000(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->setCreditCardRecognitionMetrics()V

    return-void
.end method

.method static synthetic access$100(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;
    .locals 1
    .param p0, "x0"    # Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topLeft:Landroid/graphics/Point;

    return-object v0
.end method

.method static synthetic access$200(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;
    .locals 1
    .param p0, "x0"    # Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topRight:Landroid/graphics/Point;

    return-object v0
.end method

.method static synthetic access$300(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;
    .locals 1
    .param p0, "x0"    # Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomLeft:Landroid/graphics/Point;

    return-object v0
.end method

.method static synthetic access$400(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;
    .locals 1
    .param p0, "x0"    # Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomRight:Landroid/graphics/Point;

    return-object v0
.end method

.method private getCameraMode()Lcom/a9/vs/mobile/library/impl/jni/CameraMode;
    .locals 2

    .prologue
    .line 369
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

    sget-object v1, Lcom/a9/cameralibrary/CameraOpenMode;->FIRST_BACK_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

    if-ne v0, v1, :cond_0

    .line 370
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/CameraMode;->REAR_FACING:Lcom/a9/vs/mobile/library/impl/jni/CameraMode;

    .line 372
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/CameraMode;->FRONT_FACING:Lcom/a9/vs/mobile/library/impl/jni/CameraMode;

    goto :goto_0
.end method

.method private initCreditCardReader()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 378
    invoke-direct {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getCameraMode()Lcom/a9/vs/mobile/library/impl/jni/CameraMode;

    move-result-object v1

    .line 379
    .local v1, "cameraMode":Lcom/a9/vs/mobile/library/impl/jni/CameraMode;
    new-instance v3, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    invoke-direct {v3}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;-><init>()V

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    .line 380
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getCreditCardOrientation()Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->setOrient(Lcom/a9/vs/mobile/library/impl/jni/Orientation;)V

    .line 381
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    invoke-virtual {v3, v1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->setCameraMode(Lcom/a9/vs/mobile/library/impl/jni/CameraMode;)V

    .line 382
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    sget-object v4, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->SINGLE_SCAN:Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    invoke-virtual {v3, v4}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->setScanMode(Lcom/a9/vs/mobile/library/impl/jni/ScanMode;)V

    .line 383
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    invoke-virtual {v3, v6}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->setMultiThread(Z)V

    .line 385
    sget-object v3, Lcom/a9/vs/mobile/library/impl/jni/CameraMode;->FRONT_FACING:Lcom/a9/vs/mobile/library/impl/jni/CameraMode;

    if-ne v1, v3, :cond_1

    .line 386
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    invoke-virtual {v3, v5}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->setReadDate(Z)V

    .line 390
    :goto_0
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    invoke-virtual {v3, v5}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->setAutoFlip(Z)V

    .line 391
    new-instance v3, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    iget-object v4, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    invoke-direct {v3, v4}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;-><init>(Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)V

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    .line 394
    new-instance v3, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;

    new-instance v4, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;

    invoke-direct {v4, p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;-><init>(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)V

    invoke-direct {v3, v4}, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;-><init>(Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;)V

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_delegate:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;

    .line 434
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    iget-object v4, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_delegate:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;

    invoke-virtual {v3, v4}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->setDelegate(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    .line 437
    const-string/jumbo v3, "creditCard"

    invoke-virtual {p0, v3, v5}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v0

    .line 438
    .local v0, "appPrivateDir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_0

    .line 439
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v3

    if-nez v3, :cond_0

    .line 443
    :cond_0
    sget v3, Lcom/a9/creditcardreaderlibrary/R$raw;->digit_model:I

    const-string/jumbo v4, "digit_model"

    invoke-direct {p0, v3, v0, v4}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->writeResourceToStorage(ILjava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 444
    .local v2, "digitModelFile":Ljava/lang/String;
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    invoke-virtual {v3, v2}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->loadDigitModel(Ljava/lang/String;)Z

    .line 445
    return-void

    .line 388
    .end local v0    # "appPrivateDir":Ljava/io/File;
    .end local v2    # "digitModelFile":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_processProperty:Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    invoke-virtual {v3, v6}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->setReadDate(Z)V

    goto :goto_0
.end method

.method private initMetricsManager()V
    .locals 4

    .prologue
    .line 110
    const/4 v0, 0x0

    .line 112
    .local v0, "deviceId":Ljava/lang/String;
    const-string/jumbo v3, "device_id"

    invoke-static {p0, v3}, Lcom/a9/creditcardreaderlibrary/utils/PreferenceUtil;->getPreference(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 113
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_1

    .line 114
    :cond_0
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 115
    const-string/jumbo v3, "device_id"

    invoke-static {p0, v3, v0}, Lcom/a9/creditcardreaderlibrary/utils/PreferenceUtil;->savePreference(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    :cond_1
    invoke-static {p0}, Lcom/a9/creditcardreaderlibrary/helpers/MetricsHelper;->getServiceName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 120
    .local v2, "serviceName":Ljava/lang/String;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_3

    .line 121
    :cond_2
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->labelRes:I

    invoke-virtual {p0, v3}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 124
    :cond_3
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getMarketPlace()Ljava/lang/String;

    move-result-object v1

    .line 125
    .local v1, "marketString":Ljava/lang/String;
    invoke-static {p0, v0, v2, v1}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->init(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    return-void
.end method

.method private setCreditCardRecognitionMetrics()V
    .locals 13

    .prologue
    .line 293
    new-instance v3, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;

    invoke-direct {v3}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;-><init>()V

    .line 294
    .local v3, "intMap":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;

    invoke-direct {v0}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;-><init>()V

    .line 295
    .local v0, "doubleMap":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;
    iget-object v9, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    invoke-virtual {v9, v3, v0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->generateReportAndClear(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)V

    .line 296
    invoke-static {v3}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;->getKeysForIntMap(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v4

    .line 297
    .local v4, "intMapKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->getKeysForDoubleMap(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v1

    .line 299
    .local v1, "doubleMapKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    int-to-long v9, v2

    invoke-virtual {v4}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v11

    cmp-long v9, v9, v11

    if-gez v9, :cond_0

    .line 300
    invoke-virtual {v4, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v6

    .line 301
    .local v6, "key":Ljava/lang/String;
    invoke-virtual {v3, v6}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;->get(Ljava/lang/String;)J

    move-result-wide v9

    long-to-int v7, v9

    .line 302
    .local v7, "val":I
    invoke-static {v6, v7}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->setCounterMetric(Ljava/lang/String;I)V

    .line 299
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 305
    .end local v6    # "key":Ljava/lang/String;
    .end local v7    # "val":I
    :cond_0
    const/4 v5, 0x0

    .local v5, "j":I
    :goto_1
    int-to-long v9, v5

    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v11

    cmp-long v9, v9, v11

    if-gez v9, :cond_1

    .line 306
    invoke-virtual {v1, v5}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v6

    .line 307
    .restart local v6    # "key":Ljava/lang/String;
    invoke-virtual {v0, v6}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->get(Ljava/lang/String;)D

    move-result-wide v7

    .line 308
    .local v7, "val":D
    invoke-static {v6, v7, v8}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->setTimingMetric(Ljava/lang/String;D)V

    .line 305
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 310
    .end local v6    # "key":Ljava/lang/String;
    .end local v7    # "val":D
    :cond_1
    return-void
.end method

.method private writeResourceToStorage(ILjava/io/File;Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p1, "a_id"    # I
    .param p2, "a_dir"    # Ljava/io/File;
    .param p3, "a_filename"    # Ljava/lang/String;

    .prologue
    .line 462
    :try_start_0
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, p1}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 463
    .local v3, "is":Ljava/io/InputStream;
    new-instance v5, Ljava/io/File;

    invoke-direct {v5, p2, p3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 466
    .local v5, "resFile":Ljava/io/File;
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 467
    .local v4, "os":Ljava/io/FileOutputStream;
    const/16 v6, 0x1000

    new-array v0, v6, [B

    .line 469
    .local v0, "buffer":[B
    :goto_0
    invoke-virtual {v3, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, "bytesRead":I
    const/4 v6, -0x1

    if-eq v1, v6, :cond_0

    .line 470
    const/4 v6, 0x0

    invoke-virtual {v4, v0, v6, v1}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 476
    .end local v0    # "buffer":[B
    .end local v1    # "bytesRead":I
    .end local v3    # "is":Ljava/io/InputStream;
    .end local v4    # "os":Ljava/io/FileOutputStream;
    .end local v5    # "resFile":Ljava/io/File;
    :catch_0
    move-exception v2

    .line 478
    .local v2, "e":Ljava/io/IOException;
    new-instance v6, Ljava/lang/UnsatisfiedLinkError;

    const-string/jumbo v7, "Couldn\'t write the output file for C++"

    invoke-direct {v6, v7}, Ljava/lang/UnsatisfiedLinkError;-><init>(Ljava/lang/String;)V

    throw v6

    .line 472
    .end local v2    # "e":Ljava/io/IOException;
    .restart local v0    # "buffer":[B
    .restart local v1    # "bytesRead":I
    .restart local v3    # "is":Ljava/io/InputStream;
    .restart local v4    # "os":Ljava/io/FileOutputStream;
    .restart local v5    # "resFile":Ljava/io/File;
    :cond_0
    :try_start_1
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V

    .line 473
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 475
    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v6

    return-object v6
.end method


# virtual methods
.method public cameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V
    .locals 0
    .param p1, "a_reason"    # Lcom/a9/cameralibrary/CameraErrorReason;
    .param p2, "a_extraInfo"    # Ljava/lang/String;

    .prologue
    .line 556
    invoke-virtual {p0, p1, p2}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->handleCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 557
    return-void
.end method

.method protected abstract didDetectGoodEdges(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/util/Pair",
            "<",
            "Landroid/graphics/Point;",
            "Landroid/graphics/Point;",
            ">;>;)V"
        }
    .end annotation
.end method

.method protected abstract didPromisingCardRecognition()V
.end method

.method public didReceiveFrame([BIIIIIIIIJ)V
    .locals 12
    .param p1, "a_image"    # [B
    .param p2, "a_height"    # I
    .param p3, "a_width"    # I
    .param p4, "a_channels"    # I
    .param p5, "a_cameraPreviewFormat"    # I
    .param p6, "a_roiX"    # I
    .param p7, "a_roiY"    # I
    .param p8, "a_roiWidth"    # I
    .param p9, "a_roiHeight"    # I
    .param p10, "a_msSinceUptime"    # J

    .prologue
    .line 530
    iget-boolean v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_haveCollectedCreditCardRegion:Z

    if-nez v2, :cond_0

    .line 531
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_haveCollectedCreditCardRegion:Z

    .line 532
    new-instance v11, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;

    invoke-direct {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;-><init>()V

    .line 533
    .local v11, "outputRegion":Lcom/a9/vs/mobile/library/impl/jni/CardRegion;
    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getCreditCardOrientation()Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->setOrientation(Lcom/a9/vs/mobile/library/impl/jni/Orientation;)V

    .line 534
    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    move/from16 v0, p8

    move/from16 v1, p9

    invoke-virtual {v2, v0, v1, v11}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->getOptimalSize(IILcom/a9/vs/mobile/library/impl/jni/CardRegion;)V

    .line 540
    new-instance v2, Landroid/graphics/Point;

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getLeft()I

    move-result v3

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getTop()I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/graphics/Point;-><init>(II)V

    iput-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topLeft:Landroid/graphics/Point;

    .line 541
    new-instance v2, Landroid/graphics/Point;

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getRight()I

    move-result v3

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getTop()I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/graphics/Point;-><init>(II)V

    iput-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topRight:Landroid/graphics/Point;

    .line 542
    new-instance v2, Landroid/graphics/Point;

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getLeft()I

    move-result v3

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getBottom()I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/graphics/Point;-><init>(II)V

    iput-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomLeft:Landroid/graphics/Point;

    .line 543
    new-instance v2, Landroid/graphics/Point;

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getRight()I

    move-result v3

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getBottom()I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/graphics/Point;-><init>(II)V

    iput-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomRight:Landroid/graphics/Point;

    .line 544
    new-instance v10, Ljava/util/ArrayList;

    const/4 v2, 0x4

    invoke-direct {v10, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 545
    .local v10, "initialRegionPoints":Ljava/util/List;, "Ljava/util/List<Landroid/graphics/Point;>;"
    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topLeft:Landroid/graphics/Point;

    invoke-interface {v10, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 546
    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topRight:Landroid/graphics/Point;

    invoke-interface {v10, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 547
    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomLeft:Landroid/graphics/Point;

    invoke-interface {v10, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 548
    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomRight:Landroid/graphics/Point;

    invoke-interface {v10, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 549
    invoke-virtual {p0, v10}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->initCardDetectionRegion(Ljava/util/List;)V

    .line 551
    .end local v10    # "initialRegionPoints":Ljava/util/List;, "Ljava/util/List<Landroid/graphics/Point;>;"
    .end local v11    # "outputRegion":Lcom/a9/vs/mobile/library/impl/jni/CardRegion;
    :cond_0
    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    move-object v3, p1

    move v4, p2

    move v5, p3

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    invoke-virtual/range {v2 .. v9}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->process([BIIIIII)V

    .line 552
    return-void
.end method

.method protected abstract didRecognizeCreditCard(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)V
.end method

.method protected abstract didStableCardRecognition()V
.end method

.method protected final getCameraPreview()Lcom/a9/cameralibrary/A9CameraPreview;
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    return-object v0
.end method

.method protected abstract getCameraViewHeight()I
.end method

.method protected abstract getCameraViewWidth()I
.end method

.method protected getCreditCardOrientation()Lcom/a9/vs/mobile/library/impl/jni/Orientation;
    .locals 1

    .prologue
    .line 272
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->PORTRAIT:Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    return-object v0
.end method

.method protected getMainLayout()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 284
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    return-object v0
.end method

.method protected abstract getMarketPlace()Ljava/lang/String;
.end method

.method protected getScreenOrientation()I
    .locals 1

    .prologue
    .line 268
    const/4 v0, 0x1

    return v0
.end method

.method protected abstract handleCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V
.end method

.method protected handleClickOnCameraPreview()V
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    if-eqz v0, :cond_0

    .line 214
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0}, Lcom/a9/cameralibrary/A9CameraPreview;->callFocus()V

    .line 216
    :cond_0
    return-void
.end method

.method protected handleTorchOff()V
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    if-eqz v0, :cond_0

    .line 247
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0}, Lcom/a9/cameralibrary/A9CameraPreview;->torchOff()V

    .line 249
    :cond_0
    return-void
.end method

.method protected handleTorchOn()V
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->supportsFlash()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 241
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0}, Lcom/a9/cameralibrary/A9CameraPreview;->torchOn()V

    .line 243
    :cond_0
    return-void
.end method

.method protected initCamera()V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 333
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getMainLayout()Landroid/view/ViewGroup;

    move-result-object v2

    .line 334
    .local v2, "mainLayout":Landroid/view/ViewGroup;
    new-instance v0, Landroid/widget/FrameLayout;

    invoke-direct {v0, p0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 335
    .local v0, "cameraFrameLayout":Landroid/widget/FrameLayout;
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v1, v3, v3}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 336
    .local v1, "lp":Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 337
    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    .line 338
    new-instance v3, Lcom/a9/cameralibrary/CameraBgHelper;

    invoke-direct {v3, p0, p0, v0}, Lcom/a9/cameralibrary/CameraBgHelper;-><init>(Landroid/app/Activity;Lcom/a9/cameralibrary/NewCameraPreview;Landroid/widget/FrameLayout;)V

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraBgHelper:Lcom/a9/cameralibrary/CameraBgHelper;

    .line 341
    invoke-static {}, Lcom/a9/cameralibrary/A9CameraUtils;->hasBackFacingCamera()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 342
    sget-object v3, Lcom/a9/cameralibrary/CameraOpenMode;->FIRST_BACK_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

    .line 353
    :cond_0
    :goto_0
    new-instance v3, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$1;

    invoke-direct {v3, p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$1;-><init>(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)V

    invoke-virtual {v0, v3}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 360
    return-void

    .line 343
    :cond_1
    invoke-static {}, Lcom/a9/cameralibrary/A9CameraUtils;->hasFrontFacingCamera()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 344
    sget-object v3, Lcom/a9/cameralibrary/CameraOpenMode;->FIRST_FRONT_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

    iput-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

    goto :goto_0
.end method

.method protected abstract initCardDetectionRegion(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/graphics/Point;",
            ">;)V"
        }
    .end annotation
.end method

.method protected abstract initLayout()V
.end method

.method protected initScreen()V
    .locals 2

    .prologue
    .line 320
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getScreenOrientation()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->setRequestedOrientation(I)V

    .line 321
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 322
    .local v0, "window":Landroid/view/Window;
    const/16 v1, 0x80

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 323
    const/16 v1, 0x400

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 324
    const/16 v1, 0x200

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 325
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/Window;->requestFeature(I)Z

    .line 326
    return-void
.end method

.method public newCameraPreview()Lcom/a9/cameralibrary/A9CameraPreview;
    .locals 1

    .prologue
    .line 523
    new-instance v0, Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-direct {v0, p0, p0}, Lcom/a9/cameralibrary/A9CameraPreview;-><init>(Landroid/content/Context;Lcom/a9/cameralibrary/CameraFrameListener;)V

    iput-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    .line 524
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 100
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 101
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->initScreen()V

    .line 102
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->initLayout()V

    .line 103
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->initCamera()V

    .line 104
    invoke-direct {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->initCreditCardReader()V

    .line 105
    invoke-direct {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->initMetricsManager()V

    .line 106
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 184
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 185
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->stop()V

    .line 186
    invoke-static {}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->stopSession()V

    .line 187
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->pauseCamera()V

    .line 188
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_haveCollectedCreditCardRegion:Z

    .line 189
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 173
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 174
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_haveCollectedCreditCardRegion:Z

    .line 175
    sget-boolean v0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->s_libraryLoaded:Z

    if-eqz v0, :cond_0

    .line 176
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->resumeCamera()V

    .line 178
    :cond_0
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_creditCardReader:Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->start()V

    .line 179
    invoke-static {}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->startSession()V

    .line 180
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 561
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 562
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/a9/creditcardreaderlibrary/metrics/MManager;->sendMetrics(Ljava/lang/String;Lcom/a9/creditcardreaderlibrary/metrics/MManager$MetricUploadListener;)V

    .line 563
    return-void
.end method

.method protected pauseCamera()V
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraBgHelper:Lcom/a9/cameralibrary/CameraBgHelper;

    if-eqz v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraBgHelper:Lcom/a9/cameralibrary/CameraBgHelper;

    invoke-virtual {v0}, Lcom/a9/cameralibrary/CameraBgHelper;->pause()V

    .line 195
    :cond_0
    return-void
.end method

.method protected resumeCamera()V
    .locals 6

    .prologue
    .line 198
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraBgHelper:Lcom/a9/cameralibrary/CameraBgHelper;

    if-eqz v0, :cond_0

    .line 199
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraBgHelper:Lcom/a9/cameralibrary/CameraBgHelper;

    iget v1, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_minHeight:I

    iget v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_maxHeight:I

    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getCameraViewWidth()I

    move-result v3

    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getCameraViewHeight()I

    move-result v4

    iget-object v5, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

    invoke-virtual/range {v0 .. v5}, Lcom/a9/cameralibrary/CameraBgHelper;->resume(IIIILcom/a9/cameralibrary/CameraOpenMode;)V

    .line 202
    :cond_0
    return-void
.end method

.method protected final setCameraPreview(Lcom/a9/cameralibrary/A9CameraPreview;)V
    .locals 0
    .param p1, "a_cameraPreview"    # Lcom/a9/cameralibrary/A9CameraPreview;

    .prologue
    .line 256
    iput-object p1, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    .line 257
    return-void
.end method

.method protected supportsFlash()Z
    .locals 2

    .prologue
    .line 230
    invoke-virtual {p0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 232
    .local v0, "packageManager":Landroid/content/pm/PackageManager;
    const-string/jumbo v1, "android.hardware.camera.flash"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 233
    const/4 v1, 0x1

    .line 235
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected final triggerFocus()V
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    if-eqz v0, :cond_0

    .line 220
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_cameraPreview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0}, Lcom/a9/cameralibrary/A9CameraPreview;->callFocus()V

    .line 222
    :cond_0
    return-void
.end method

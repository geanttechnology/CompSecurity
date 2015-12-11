.class public Lcom/flow/android/engine/library/FlowStateEngine;
.super Ljava/lang/Object;
.source "FlowStateEngine.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flow/android/engine/library/FlowStateEngine$1;,
        Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;
    }
.end annotation


# static fields
.field private static slibraryLoaded:Z


# instance fields
.field private mEmptySensorData:Lcom/a9/vs/mobile/library/impl/jni/SensorData;

.field private mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

.field private mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

.field private mInterface:Lcom/flow/android/engine/library/FlowStateEngineInterface;

.field private mLogFile:Ljava/io/File;

.field private mMaxImageHeight:I

.field private mMinImageHeight:I

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

.field private mPrintToScreen:Z

.field private mTessDir:Ljava/lang/String;

.field private mTextXMLInputFilename:Ljava/lang/String;

.field private mUseLogFile:Z

.field private mZipcodeFilename:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 54
    sput-boolean v2, Lcom/flow/android/engine/library/FlowStateEngine;->slibraryLoaded:Z

    .line 107
    :try_start_0
    const-string/jumbo v1, "A9VSMobile"

    invoke-static {v1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 108
    const/4 v1, 0x1

    sput-boolean v1, Lcom/flow/android/engine/library/FlowStateEngine;->slibraryLoaded:Z
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 112
    .local v0, "e":Ljava/lang/UnsatisfiedLinkError;
    :goto_0
    return-void

    .line 109
    .end local v0    # "e":Ljava/lang/UnsatisfiedLinkError;
    :catch_0
    move-exception v0

    .line 110
    .restart local v0    # "e":Ljava/lang/UnsatisfiedLinkError;
    sput-boolean v2, Lcom/flow/android/engine/library/FlowStateEngine;->slibraryLoaded:Z

    goto :goto_0
.end method

.method public constructor <init>(Lcom/flow/android/engine/library/FlowStateEngineInterface;Landroid/content/Context;Lcom/flow/android/engine/models/FlowStateEngineIO;)V
    .locals 5
    .param p1, "flowStateEngineInterface"    # Lcom/flow/android/engine/library/FlowStateEngineInterface;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "flowStateEngineIO"    # Lcom/flow/android/engine/models/FlowStateEngineIO;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsatisfiedLinkError;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    iput-object v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mModules:Ljava/util/Set;

    .line 89
    iput-boolean v3, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mPrintToScreen:Z

    .line 90
    iput-boolean v3, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mUseLogFile:Z

    .line 94
    iput-object v4, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mTextXMLInputFilename:Ljava/lang/String;

    .line 95
    iput-object v4, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mZipcodeFilename:Ljava/lang/String;

    .line 99
    iput-object v4, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mTessDir:Ljava/lang/String;

    .line 117
    sget-boolean v2, Lcom/flow/android/engine/library/FlowStateEngine;->slibraryLoaded:Z

    if-nez v2, :cond_0

    .line 118
    new-instance v2, Ljava/lang/UnsatisfiedLinkError;

    const-string/jumbo v3, "Couldn\'t load the A9VSMobile"

    invoke-direct {v2, v3}, Ljava/lang/UnsatisfiedLinkError;-><init>(Ljava/lang/String;)V

    throw v2

    .line 120
    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/SensorData;

    invoke-direct {v2}, Lcom/a9/vs/mobile/library/impl/jni/SensorData;-><init>()V

    iput-object v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEmptySensorData:Lcom/a9/vs/mobile/library/impl/jni/SensorData;

    .line 122
    invoke-virtual {p3}, Lcom/flow/android/engine/models/FlowStateEngineIO;->isUseLogFile()Z

    move-result v2

    iput-boolean v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mUseLogFile:Z

    .line 123
    invoke-virtual {p3}, Lcom/flow/android/engine/models/FlowStateEngineIO;->isPrintToScreen()Z

    move-result v2

    iput-boolean v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mPrintToScreen:Z

    .line 131
    const-string/jumbo v2, "fse"

    invoke-virtual {p2, v2, v3}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v1

    .line 132
    .local v1, "privateDir":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_1

    .line 133
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    move-result v2

    if-nez v2, :cond_1

    .line 139
    :cond_1
    iget-boolean v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mUseLogFile:Z

    if-nez v2, :cond_2

    iget-boolean v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mPrintToScreen:Z

    if-eqz v2, :cond_3

    .line 140
    :cond_2
    iget-boolean v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mUseLogFile:Z

    if-eqz v2, :cond_4

    .line 141
    new-instance v2, Ljava/io/File;

    const-string/jumbo v3, "FlowStateEngine.log"

    invoke-direct {v2, v1, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mLogFile:Ljava/io/File;

    .line 144
    iget-object v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mLogFile:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    iget-boolean v3, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mPrintToScreen:Z

    invoke-static {v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->setupLogging(Ljava/lang/String;Z)Z

    .line 151
    :cond_3
    :goto_0
    const-string/jumbo v2, "text"

    const-string/jumbo v3, "text.xml"

    invoke-direct {p0, p2, v2, v1, v3}, Lcom/flow/android/engine/library/FlowStateEngine;->writeRawFileToPrivateStorage(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mTextXMLInputFilename:Ljava/lang/String;

    .line 154
    const-string/jumbo v2, "zip_code_database_simple"

    const-string/jumbo v3, "zip_code_database_simple.txt"

    invoke-direct {p0, p2, v2, v1, v3}, Lcom/flow/android/engine/library/FlowStateEngine;->writeRawFileToPrivateStorage(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mZipcodeFilename:Ljava/lang/String;

    .line 183
    iput-object p1, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mInterface:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .line 184
    new-instance v0, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-direct {v0, p3}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;-><init>(Lcom/flow/android/engine/models/FlowStateEngineIO;)V

    .line 185
    .local v0, "clientInfo":Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;
    invoke-virtual {v0, p2}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->setContext(Landroid/content/Context;)V

    .line 186
    new-instance v2, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    iget-object v3, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mInterface:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-direct {v2, v3, v0}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;-><init>(Lcom/flow/android/engine/library/FlowStateEngineInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;)V

    iput-object v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    .line 187
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    iget-object v3, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v3}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->getEventCallback()Lcom/flow/android/engine/library/impl/FlowEventCallback;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;-><init>(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V

    iput-object v2, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    .line 188
    return-void

    .line 146
    .end local v0    # "clientInfo":Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;
    :cond_4
    const-string/jumbo v2, ""

    iget-boolean v3, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mPrintToScreen:Z

    invoke-static {v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->setupLogging(Ljava/lang/String;Z)Z

    goto :goto_0
.end method

.method private getImageFormat(I)Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    .locals 1
    .param p1, "cameraPreviewFormat"    # I

    .prologue
    .line 437
    sparse-switch p1, :sswitch_data_0

    .line 443
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->UNKNOWN_FORMAT:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    :goto_0
    return-object v0

    .line 439
    :sswitch_0
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->YUV420_NV21:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    goto :goto_0

    .line 441
    :sswitch_1
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->RGB565:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    goto :goto_0

    .line 437
    :sswitch_data_0
    .sparse-switch
        0x4 -> :sswitch_1
        0x11 -> :sswitch_0
    .end sparse-switch
.end method

.method private initModules()V
    .locals 9

    .prologue
    .line 295
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mModules:Ljava/util/Set;

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    .line 296
    .local v1, "m":Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;
    const/4 v6, 0x0

    .line 297
    .local v6, "type":Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    const/4 v5, 0x0

    .line 298
    .local v5, "serverCallback":Lcom/flow/android/engine/library/impl/FlowServerCallback;
    sget-object v7, Lcom/flow/android/engine/library/FlowStateEngine$1;->$SwitchMap$com$flow$android$engine$library$FlowStateEngine$FlowObjectModule:[I

    invoke-virtual {v1}, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    goto :goto_0

    .line 300
    :pswitch_0
    sget-object v6, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->BARCODE:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 301
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v7, v6, v5}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->addObjectModule(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;)V

    goto :goto_0

    .line 304
    :pswitch_1
    sget-object v6, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->IMGMATCHOBJ:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 305
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v7}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->getImageMatchServerCallback()Lcom/flow/android/engine/library/impl/FlowServerCallback;

    move-result-object v5

    .line 306
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    invoke-direct {v2}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;-><init>()V

    .line 307
    .local v2, "propsImageMatch":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    const-string/jumbo v7, "imageMatch"

    const-string/jumbo v8, "true"

    invoke-virtual {v2, v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    const-string/jumbo v7, "deepLearningRecognition"

    const-string/jumbo v8, "true"

    invoke-virtual {v2, v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 309
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mModules:Ljava/util/Set;

    sget-object v8, Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;->LOGO:Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    invoke-interface {v7, v8}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 310
    const-string/jumbo v7, "logoRecognition"

    const-string/jumbo v8, "true"

    invoke-virtual {v2, v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 312
    :cond_1
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v7, v6, v5, v2}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->addObjectModule(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V

    goto :goto_0

    .line 315
    .end local v2    # "propsImageMatch":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    :pswitch_2
    sget-object v6, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->TWOD_BARCODE:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 316
    new-instance v4, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    invoke-direct {v4}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;-><init>()V

    .line 317
    .local v4, "propsTwoBarcode":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    const-string/jumbo v7, "decodeDataMatrix"

    const-string/jumbo v8, "true"

    invoke-virtual {v4, v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 318
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v7, v6, v5, v4}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->addObjectModule(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V

    goto :goto_0

    .line 321
    .end local v4    # "propsTwoBarcode":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    :pswitch_3
    sget-object v6, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->TEXT:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 322
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v7}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->getTextServerCallback()Lcom/flow/android/engine/library/impl/FlowServerCallback;

    move-result-object v5

    .line 323
    new-instance v3, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    invoke-direct {v3}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;-><init>()V

    .line 324
    .local v3, "propsMap":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    const-string/jumbo v7, "text.detect.GlyphModelFile"

    iget-object v8, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mTextXMLInputFilename:Ljava/lang/String;

    invoke-virtual {v3, v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 325
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v7, v6, v5, v3}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->addObjectModule(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V

    .line 326
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mZipcodeFilename:Ljava/lang/String;

    if-eqz v7, :cond_0

    .line 327
    iget-object v7, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    iget-object v8, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mZipcodeFilename:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->setZipcodeDatabase(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 335
    .end local v1    # "m":Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;
    .end local v3    # "propsMap":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    .end local v5    # "serverCallback":Lcom/flow/android/engine/library/impl/FlowServerCallback;
    .end local v6    # "type":Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    :cond_2
    return-void

    .line 298
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private writeRawFileToPrivateStorage(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "readFromFileName"    # Ljava/lang/String;
    .param p3, "directory"    # Ljava/io/File;
    .param p4, "writeToFileName"    # Ljava/lang/String;

    .prologue
    .line 192
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 193
    .local v5, "res":Landroid/content/res/Resources;
    const/4 v3, 0x0

    .line 195
    .local v3, "is":Ljava/io/InputStream;
    :try_start_1
    const-string/jumbo v7, "raw"

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, p2, v7, v8}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v7

    invoke-virtual {v5, v7}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;
    :try_end_1
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v3

    .line 199
    :try_start_2
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, p3, p4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 200
    .local v6, "resFile":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-nez v7, :cond_1

    .line 202
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v6}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 203
    .local v4, "os":Ljava/io/FileOutputStream;
    const/16 v7, 0x1000

    new-array v0, v7, [B

    .line 205
    .local v0, "buffer":[B
    :goto_0
    invoke-virtual {v3, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, "bytesRead":I
    const/4 v7, -0x1

    if-eq v1, v7, :cond_0

    .line 206
    const/4 v7, 0x0

    invoke-virtual {v4, v0, v7, v1}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 212
    .end local v0    # "buffer":[B
    .end local v1    # "bytesRead":I
    .end local v3    # "is":Ljava/io/InputStream;
    .end local v4    # "os":Ljava/io/FileOutputStream;
    .end local v5    # "res":Landroid/content/res/Resources;
    .end local v6    # "resFile":Ljava/io/File;
    :catch_0
    move-exception v2

    .line 214
    .local v2, "e":Ljava/io/IOException;
    const-string/jumbo v7, ""

    .end local v2    # "e":Ljava/io/IOException;
    :goto_1
    return-object v7

    .line 196
    .restart local v3    # "is":Ljava/io/InputStream;
    .restart local v5    # "res":Landroid/content/res/Resources;
    :catch_1
    move-exception v2

    .line 197
    .local v2, "e":Landroid/content/res/Resources$NotFoundException;
    :try_start_3
    const-string/jumbo v7, ""

    goto :goto_1

    .line 208
    .end local v2    # "e":Landroid/content/res/Resources$NotFoundException;
    .restart local v0    # "buffer":[B
    .restart local v1    # "bytesRead":I
    .restart local v4    # "os":Ljava/io/FileOutputStream;
    .restart local v6    # "resFile":Ljava/io/File;
    :cond_0
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V

    .line 209
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 211
    .end local v0    # "buffer":[B
    .end local v1    # "bytesRead":I
    .end local v4    # "os":Ljava/io/FileOutputStream;
    :cond_1
    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    move-result-object v7

    goto :goto_1
.end method


# virtual methods
.method public addFlowObjectModule(Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;)V
    .locals 1
    .param p1, "module"    # Lcom/flow/android/engine/library/FlowStateEngine$FlowObjectModule;

    .prologue
    .line 291
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mModules:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 292
    return-void
.end method

.method public didLibrariesLoad()Z
    .locals 1

    .prologue
    .line 247
    sget-boolean v0, Lcom/flow/android/engine/library/FlowStateEngine;->slibraryLoaded:Z

    return v0
.end method

.method public getAndClearMetrics(Z)Lcom/flow/android/engine/library/FlowStateEngineMetrics;
    .locals 13
    .param p1, "onlyNonZeroes"    # Z

    .prologue
    .line 367
    new-instance v7, Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    invoke-direct {v7}, Lcom/flow/android/engine/library/FlowStateEngineMetrics;-><init>()V

    .line 368
    .local v7, "metrics":Lcom/flow/android/engine/library/FlowStateEngineMetrics;
    new-instance v1, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;

    invoke-direct {v1}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;-><init>()V

    .line 369
    .local v1, "cppCounters":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;

    invoke-direct {v2}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;-><init>()V

    .line 370
    .local v2, "cppTiming":Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;
    iget-object v9, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v9, v1, v2, p1}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->getAndClearMetrics(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Z)V

    .line 373
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 374
    .local v4, "javaCounters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-static {v1}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;->getKeysForIntMap(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v0

    .line 375
    .local v0, "counterKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    int-to-long v9, v3

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v11

    cmp-long v9, v9, v11

    if-gez v9, :cond_0

    .line 376
    invoke-virtual {v0, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v6

    .line 377
    .local v6, "key":Ljava/lang/String;
    invoke-virtual {v1, v6}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;->get(Ljava/lang/String;)J

    move-result-wide v9

    long-to-int v9, v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {v4, v6, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 375
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 379
    .end local v6    # "key":Ljava/lang/String;
    :cond_0
    invoke-virtual {v7, v4}, Lcom/flow/android/engine/library/FlowStateEngineMetrics;->setCounters(Ljava/util/Map;)V

    .line 382
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 383
    .local v5, "javaTiming":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Double;>;"
    invoke-static {v2}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->getKeysForDoubleMap(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v8

    .line 384
    .local v8, "timingKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    const/4 v3, 0x0

    :goto_1
    int-to-long v9, v3

    invoke-virtual {v8}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v11

    cmp-long v9, v9, v11

    if-gez v9, :cond_1

    .line 385
    invoke-virtual {v8, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v6

    .line 386
    .restart local v6    # "key":Ljava/lang/String;
    invoke-virtual {v2, v6}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->get(Ljava/lang/String;)D

    move-result-wide v9

    invoke-static {v9, v10}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v9

    invoke-interface {v5, v6, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 384
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 388
    .end local v6    # "key":Ljava/lang/String;
    :cond_1
    invoke-virtual {v7, v5}, Lcom/flow/android/engine/library/FlowStateEngineMetrics;->setTiming(Ljava/util/Map;)V

    .line 390
    return-object v7
.end method

.method public getMaxImageHeight()I
    .locals 1

    .prologue
    .line 259
    iget v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mMaxImageHeight:I

    return v0
.end method

.method public getMinImageHeight()I
    .locals 1

    .prologue
    .line 255
    iget v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mMinImageHeight:I

    return v0
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 281
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->shutdownServerDelegates()V

    .line 282
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->pauseEngine()V

    .line 283
    return-void
.end method

.method public process([BIIIIIIIIIZJ)V
    .locals 14
    .param p1, "image"    # [B
    .param p2, "height"    # I
    .param p3, "width"    # I
    .param p4, "channels"    # I
    .param p5, "cameraPreviewFormat"    # I
    .param p6, "roiX"    # I
    .param p7, "roiY"    # I
    .param p8, "roiWidth"    # I
    .param p9, "roiHeight"    # I
    .param p10, "orientation"    # I
    .param p11, "isFlat"    # Z
    .param p12, "timeSinceInit"    # J

    .prologue
    .line 338
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;

    move-wide/from16 v0, p12

    long-to-double v3, v0

    const-wide v5, 0x408f400000000000L    # 1000.0

    div-double v9, v3, v5

    move/from16 v3, p6

    move/from16 v4, p7

    move/from16 v5, p8

    move/from16 v6, p9

    move/from16 v7, p11

    move/from16 v8, p10

    invoke-direct/range {v2 .. v10}, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;-><init>(IIIIZID)V

    .line 339
    .local v2, "efd":Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;
    new-instance v12, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;

    invoke-direct {v12}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;-><init>()V

    .line 340
    .local v12, "ib":Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;
    sget-object v3, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->FULL_RES_COLOR:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    invoke-virtual {v12, v3}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->setDefinition(Lcom/a9/vs/mobile/library/impl/jni/ImageDef;)V

    .line 341
    move/from16 v0, p3

    invoke-virtual {v12, v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->setWidth(I)V

    .line 342
    move/from16 v0, p2

    invoke-virtual {v12, v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->setHeight(I)V

    .line 343
    move/from16 v0, p3

    invoke-virtual {v12, v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->setWidthStep(I)V

    .line 344
    move/from16 v0, p4

    invoke-virtual {v12, v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->setNumChannels(I)V

    .line 345
    move/from16 v0, p5

    invoke-direct {p0, v0}, Lcom/flow/android/engine/library/FlowStateEngine;->getImageFormat(I)Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    move-result-object v3

    invoke-virtual {v12, v3}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->setFormat(Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;)V

    .line 346
    new-instance v13, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;

    invoke-direct {v13}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;-><init>()V

    .line 347
    .local v13, "ibs":Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;
    invoke-virtual {v13, v12}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->add(Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)V

    .line 349
    new-instance v11, Lcom/a9/vs/mobile/library/impl/jni/FrameID;

    invoke-direct {v11}, Lcom/a9/vs/mobile/library/impl/jni/FrameID;-><init>()V

    .line 350
    .local v11, "frameId":Lcom/a9/vs/mobile/library/impl/jni/FrameID;
    iget-object v3, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v3, v13, v11}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->getRequestImageBuffers(Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;Lcom/a9/vs/mobile/library/impl/jni/FrameID;)V

    .line 351
    const/4 v3, 0x0

    invoke-virtual {v13, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->get(I)Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;

    move-result-object v3

    array-length v4, p1

    invoke-virtual {v3, p1, v4}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->fillBuffer([BI)I

    .line 352
    iget-object v3, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v11}, Lcom/a9/vs/mobile/library/impl/jni/FrameID;->getId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEmptySensorData:Lcom/a9/vs/mobile/library/impl/jni/SensorData;

    invoke-virtual {v3, v4, v13, v2, v5}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->process(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;Lcom/a9/vs/mobile/library/impl/jni/SensorData;)V

    .line 353
    return-void
.end method

.method public resume()V
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->resetServerDelegates()V

    .line 287
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->resumeEngine()V

    .line 288
    return-void
.end method

.method public sendFSEMetrics()V
    .locals 2

    .prologue
    .line 356
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/flow/android/engine/library/FlowStateEngine;->getAndClearMetrics(Z)Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    move-result-object v0

    .line 357
    .local v0, "engineMetrics":Lcom/flow/android/engine/library/FlowStateEngineMetrics;
    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngineMetrics;->getCounters()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v1

    if-gtz v1, :cond_0

    invoke-virtual {v0}, Lcom/flow/android/engine/library/FlowStateEngineMetrics;->getTiming()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 358
    :cond_0
    iget-object v1, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v1, v0}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->doMetricsReporting(Lcom/flow/android/engine/library/FlowStateEngineMetrics;)V

    .line 360
    :cond_1
    return-void
.end method

.method public start(Lcom/flow/android/engine/library/FlowStateEngineInterface;)V
    .locals 2
    .param p1, "flowStateEngineInterface"    # Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .prologue
    .line 263
    iget-object v1, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v1, p1}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->setInterface(Lcom/flow/android/engine/library/FlowStateEngineInterface;)V

    .line 264
    iget-object v1, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v1}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->resetServerDelegates()V

    .line 265
    invoke-direct {p0}, Lcom/flow/android/engine/library/FlowStateEngine;->initModules()V

    .line 266
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;

    invoke-direct {v0}, Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;-><init>()V

    .line 267
    .local v0, "resRequirement":Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;
    iget-object v1, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v1, v0}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->getCameraResRequirement(Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;)V

    .line 268
    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;->getMinHeight()I

    move-result v1

    iput v1, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mMinImageHeight:I

    .line 269
    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;->getMaxHeight()I

    move-result v1

    iput v1, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mMaxImageHeight:I

    .line 270
    iget-object v1, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->startEngine()V

    .line 271
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 274
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->shutdownServerDelegates()V

    .line 275
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->stopEngine()V

    .line 276
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mEngine:Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->removeAllObjectModules()V

    .line 277
    iget-object v0, p0, Lcom/flow/android/engine/library/FlowStateEngine;->mModules:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 278
    return-void
.end method

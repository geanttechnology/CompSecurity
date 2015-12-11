.class public Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;
.super Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;
.source "ImageServerMatch.java"


# static fields
.field protected static sLockObject:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->sLockObject:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V
    .locals 0
    .param p1, "httpManagerInterface"    # Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;
    .param p2, "threadPoolManagerInterface"    # Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;
    .param p3, "deviceInfo"    # Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;
    .param p4, "applicationURL"    # Ljava/lang/String;
    .param p5, "responseType"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .param p6, "inputStream"    # Ljava/io/ByteArrayInputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;",
            "Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;",
            "Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;",
            "Ljava/lang/String;",
            "Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;",
            "Ljava/io/ByteArrayInputStream;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p7, "customParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p8, "metadataParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct/range {p0 .. p8}, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;-><init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V

    .line 22
    return-void
.end method

.method private sendImageToServer()Ljava/lang/String;
    .locals 2

    .prologue
    .line 43
    const-string/jumbo v0, "GET"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->getResponseFromServer(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    .line 26
    iget-object v7, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->mThreadPoolManagerInterface:Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;

    iget v8, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->mId:I

    invoke-interface {v7, v8, p0}, Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;->onRun(ILcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;)V

    .line 27
    const/4 v4, 0x0

    .line 29
    .local v4, "serverResponse":Ljava/lang/String;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    .line 30
    .local v5, "startTime":J
    sget-object v8, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->sLockObject:Ljava/lang/Object;

    monitor-enter v8

    .line 31
    :try_start_0
    invoke-direct {p0}, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->sendImageToServer()Ljava/lang/String;

    move-result-object v4

    .line 32
    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 33
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    sub-long v0, v7, v5

    .line 34
    .local v0, "endTime":J
    long-to-double v7, v0

    const-wide v9, 0x408f400000000000L    # 1000.0

    div-double v2, v7, v9

    .line 36
    .local v2, "endTimeInSeconds":D
    iget-object v7, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->mHttpManagerInterface:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

    if-eqz v7, :cond_0

    iget-boolean v7, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->m_isCancelled:Z

    if-nez v7, :cond_0

    .line 37
    iget-object v7, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->mHttpManagerInterface:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

    iget-object v8, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->mResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    invoke-interface {v7, v4, v8, v2, v3}, Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;->didReceiveImageMatchResponse(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;D)V

    .line 39
    :cond_0
    iget-object v7, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->mThreadPoolManagerInterface:Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;

    iget v8, p0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;->mId:I

    invoke-interface {v7, v8}, Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;->onFinish(I)V

    .line 40
    return-void

    .line 32
    .end local v0    # "endTime":J
    .end local v2    # "endTimeInSeconds":D
    :catchall_0
    move-exception v7

    :try_start_1
    monitor-exit v8
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v7
.end method

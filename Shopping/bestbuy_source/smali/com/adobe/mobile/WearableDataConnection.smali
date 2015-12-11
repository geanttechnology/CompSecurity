.class final Lcom/adobe/mobile/WearableDataConnection;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Latt;
.implements Lqp;


# instance fields
.field protected mDataMap:Latz;

.field private final mGoogleApiClient:Lqm;

.field private mInTimeCountDownLatch:Ljava/util/concurrent/CountDownLatch;

.field protected requestID:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    new-instance v0, Lqn;

    invoke-direct {v0, p1}, Lqn;-><init>(Landroid/content/Context;)V

    .line 48
    invoke-virtual {v0, p0}, Lqn;->a(Lqp;)Lqn;

    move-result-object v0

    sget-object v1, Lauj;->g:Lpx;

    .line 49
    invoke-virtual {v0, v1}, Lqn;->a(Lpx;)Lqn;

    move-result-object v0

    .line 50
    invoke-virtual {v0}, Lqn;->b()Lqm;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    .line 51
    return-void
.end method

.method private connect(I)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 94
    iget-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1}, Lqm;->b()V

    .line 95
    invoke-direct {p0, p1}, Lcom/adobe/mobile/WearableDataConnection;->waitForConnect(I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 96
    const-string v1, "Wearable - Timeout setup connection"

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 104
    :goto_0
    return v0

    .line 99
    :cond_0
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataConnection;->hasNodes()Z

    move-result v1

    if-nez v1, :cond_1

    .line 100
    const-string v1, "Wearable - No connected Node found"

    new-array v2, v0, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 104
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private hasNodes()Z
    .locals 2

    .prologue
    .line 145
    sget-object v0, Lauj;->c:Lauf;

    iget-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v0, v1}, Lauf;->a(Lqm;)Lqq;

    move-result-object v0

    invoke-interface {v0}, Lqq;->b()Lqt;

    move-result-object v0

    check-cast v0, Laug;

    .line 146
    if-eqz v0, :cond_0

    invoke-interface {v0}, Laug;->a()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Laug;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private waitForConnect(I)Z
    .locals 4

    .prologue
    .line 137
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 138
    const/4 v0, 0x1

    .line 141
    :goto_0
    return v0

    .line 140
    :cond_0
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    int-to-long v2, p1

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, v2, v3, v1}, Lqm;->a(JLjava/util/concurrent/TimeUnit;)Lpp;

    move-result-object v0

    .line 141
    invoke-virtual {v0}, Lpp;->b()Z

    move-result v0

    goto :goto_0
.end method


# virtual methods
.method protected getResponse()Lcom/adobe/mobile/WearableDataResponse;
    .locals 2

    .prologue
    .line 150
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataConnection;->mDataMap:Latz;

    if-nez v0, :cond_0

    .line 151
    const/4 v0, 0x0

    .line 153
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataConnection;->mDataMap:Latz;

    iget-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-static {v0, v1}, Lcom/adobe/mobile/WearableDataResponse;->createResponseFromDataMap(Latz;Lqm;)Lcom/adobe/mobile/WearableDataResponse;

    move-result-object v0

    goto :goto_0
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 0

    .prologue
    .line 159
    return-void
.end method

.method public onDataChanged(Latw;)V
    .locals 4

    .prologue
    .line 110
    invoke-virtual {p1}, Latw;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Latv;

    .line 111
    invoke-interface {v0}, Latv;->c()I

    move-result v2

    const/4 v3, 0x1

    if-eq v2, v3, :cond_2

    .line 134
    :cond_1
    :goto_0
    return-void

    .line 114
    :cond_2
    invoke-interface {v0}, Latv;->b()Latx;

    move-result-object v2

    .line 116
    if-eqz v2, :cond_0

    .line 119
    invoke-interface {v2}, Latx;->b()Landroid/net/Uri;

    move-result-object v2

    .line 120
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    const-string v3, "/abdmobile/data/response"

    invoke-virtual {v2, v3}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_0

    .line 124
    invoke-interface {v0}, Latv;->b()Latx;

    move-result-object v0

    invoke-static {v0}, Laua;->a(Latx;)Laua;

    move-result-object v0

    invoke-virtual {v0}, Laua;->a()Latz;

    move-result-object v0

    .line 125
    if-eqz v0, :cond_0

    .line 128
    const-string v2, "ID"

    invoke-virtual {v0, v2}, Latz;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "ID"

    invoke-virtual {v0, v2}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mobile/WearableDataConnection;->requestID:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 129
    iput-object v0, p0, Lcom/adobe/mobile/WearableDataConnection;->mDataMap:Latz;

    .line 130
    iget-object v0, p0, Lcom/adobe/mobile/WearableDataConnection;->mInTimeCountDownLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0
.end method

.method protected send(Lcom/adobe/mobile/WearableDataRequest;)Lcom/adobe/mobile/WearableDataResponse;
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 54
    invoke-virtual {p1}, Lcom/adobe/mobile/WearableDataRequest;->getTimeOut()I

    move-result v1

    invoke-direct {p0, v1}, Lcom/adobe/mobile/WearableDataConnection;->connect(I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 89
    :goto_0
    return-object v0

    .line 58
    :cond_0
    sget-object v1, Lauj;->a:Latr;

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1, v2, p0}, Latr;->a(Lqm;Latt;)Lqq;

    .line 60
    invoke-virtual {p1}, Lcom/adobe/mobile/WearableDataRequest;->getUUID()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->requestID:Ljava/lang/String;

    .line 62
    const-string v1, "/abdmobile/data/request"

    invoke-static {v1}, Laui;->a(Ljava/lang/String;)Laui;

    move-result-object v1

    .line 63
    invoke-virtual {v1}, Laui;->a()Latz;

    move-result-object v2

    .line 65
    invoke-virtual {p1}, Lcom/adobe/mobile/WearableDataRequest;->getDataMap()Latz;

    move-result-object v3

    invoke-virtual {v2, v3}, Latz;->a(Latz;)V

    .line 66
    invoke-virtual {v1}, Laui;->b()Lcom/google/android/gms/wearable/PutDataRequest;

    move-result-object v1

    .line 69
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v2, p0, Lcom/adobe/mobile/WearableDataConnection;->mInTimeCountDownLatch:Ljava/util/concurrent/CountDownLatch;

    .line 70
    sget-object v2, Lauj;->a:Latr;

    iget-object v3, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v2, v3, v1}, Latr;->a(Lqm;Lcom/google/android/gms/wearable/PutDataRequest;)Lqq;

    .line 76
    :try_start_0
    iget-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->mInTimeCountDownLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {p1}, Lcom/adobe/mobile/WearableDataRequest;->getTimeOut()I

    move-result v2

    int-to-long v2, v2

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 77
    const-string v1, "Wearable - Failed to get data from handheld app"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 86
    sget-object v1, Lauj;->a:Latr;

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1, v2, p0}, Latr;->b(Lqm;Latt;)Lqq;

    .line 87
    iget-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1}, Lqm;->c()V

    goto :goto_0

    .line 80
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lcom/adobe/mobile/WearableDataConnection;->getResponse()Lcom/adobe/mobile/WearableDataResponse;
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    .line 86
    sget-object v1, Lauj;->a:Latr;

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1, v2, p0}, Latr;->b(Lqm;Latt;)Lqq;

    .line 87
    iget-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1}, Lqm;->c()V

    goto :goto_0

    .line 82
    :catch_0
    move-exception v1

    .line 83
    :try_start_2
    const-string v1, "Wearable - Failed to get data from handheld app"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 86
    sget-object v1, Lauj;->a:Latr;

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1, v2, p0}, Latr;->b(Lqm;Latt;)Lqq;

    .line 87
    iget-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1}, Lqm;->c()V

    goto :goto_0

    .line 86
    :catchall_0
    move-exception v0

    sget-object v1, Lauj;->a:Latr;

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1, v2, p0}, Latr;->b(Lqm;Latt;)Lqq;

    .line 87
    iget-object v1, p0, Lcom/adobe/mobile/WearableDataConnection;->mGoogleApiClient:Lqm;

    invoke-interface {v1}, Lqm;->c()V

    throw v0
.end method

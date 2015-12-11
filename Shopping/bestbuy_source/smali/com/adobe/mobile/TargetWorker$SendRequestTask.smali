.class public Lcom/adobe/mobile/TargetWorker$SendRequestTask;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private callback:Lcom/adobe/mobile/Target$TargetCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/adobe/mobile/Target$TargetCallback",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private lifetimeValue:Ljava/math/BigDecimal;

.field private request:Lcom/adobe/mobile/TargetLocationRequest;


# direct methods
.method private constructor <init>(Lcom/adobe/mobile/TargetLocationRequest;Lcom/adobe/mobile/Target$TargetCallback;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mobile/TargetLocationRequest;",
            "Lcom/adobe/mobile/Target$TargetCallback",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p1, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->request:Lcom/adobe/mobile/TargetLocationRequest;

    .line 86
    iput-object p2, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    .line 87
    invoke-static {}, Lcom/adobe/mobile/AnalyticsTrackLifetimeValueIncrease;->getLifetimeValue()Ljava/math/BigDecimal;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->lifetimeValue:Ljava/math/BigDecimal;

    .line 88
    return-void
.end method

.method synthetic constructor <init>(Lcom/adobe/mobile/TargetLocationRequest;Lcom/adobe/mobile/Target$TargetCallback;Lcom/adobe/mobile/TargetWorker$1;)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0, p1, p2}, Lcom/adobe/mobile/TargetWorker$SendRequestTask;-><init>(Lcom/adobe/mobile/TargetLocationRequest;Lcom/adobe/mobile/Target$TargetCallback;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 92
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->lifetimeValue:Ljava/math/BigDecimal;

    if-eqz v0, :cond_0

    .line 94
    const-string v0, "a.ltv.amount"

    iget-object v1, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->lifetimeValue:Ljava/math/BigDecimal;

    invoke-virtual {v1}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/adobe/mobile/TargetWorker;->addPersistentParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    :cond_0
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->request:Lcom/adobe/mobile/TargetLocationRequest;

    iget-object v0, v0, Lcom/adobe/mobile/TargetLocationRequest;->name:Ljava/lang/String;

    iget-object v1, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->request:Lcom/adobe/mobile/TargetLocationRequest;

    iget-object v1, v1, Lcom/adobe/mobile/TargetLocationRequest;->parameters:Ljava/util/HashMap;

    # invokes: Lcom/adobe/mobile/TargetWorker;->getURLRequestString(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/adobe/mobile/TargetWorker;->access$100(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 100
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-gtz v1, :cond_3

    .line 101
    :cond_1
    const-string v0, "Target - LocationRequest requires a name."

    new-array v1, v5, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 102
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    if-eqz v0, :cond_2

    .line 103
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    iget-object v1, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->request:Lcom/adobe/mobile/TargetLocationRequest;

    iget-object v1, v1, Lcom/adobe/mobile/TargetLocationRequest;->defaultContent:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/adobe/mobile/Target$TargetCallback;->call(Ljava/lang/Object;)V

    .line 148
    :cond_2
    :goto_0
    return-void

    .line 110
    :cond_3
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mobile/MobileConfig;->getDefaultLocationTimeout()I

    move-result v1

    mul-int/lit16 v1, v1, 0x3e8

    const-string v2, "Target"

    new-instance v3, Lcom/adobe/mobile/TargetWorker$SendRequestTask$1;

    invoke-direct {v3, p0}, Lcom/adobe/mobile/TargetWorker$SendRequestTask$1;-><init>(Lcom/adobe/mobile/TargetWorker$SendRequestTask;)V

    new-instance v4, Lcom/adobe/mobile/TargetWorker$SendRequestTask$2;

    invoke-direct {v4, p0}, Lcom/adobe/mobile/TargetWorker$SendRequestTask$2;-><init>(Lcom/adobe/mobile/TargetWorker$SendRequestTask;)V

    invoke-static {v0, v1, v2, v3, v4}, Lcom/adobe/mobile/RequestHandler;->retrieveData(Ljava/lang/String;ILjava/lang/String;Ljava/util/concurrent/Callable;Lcom/adobe/mobile/RequestHandler$HeaderCallback;)[B

    move-result-object v0

    .line 129
    if-eqz v0, :cond_4

    array-length v1, v0

    if-lez v1, :cond_4

    .line 130
    new-instance v1, Ljava/lang/String;

    const-string v2, "UTF-8"

    invoke-direct {v1, v0, v2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 131
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    if-eqz v0, :cond_2

    .line 132
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    invoke-interface {v0, v1}, Lcom/adobe/mobile/Target$TargetCallback;->call(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 140
    :catch_0
    move-exception v0

    .line 141
    throw v0

    .line 135
    :cond_4
    :try_start_1
    const-string v0, "Target - No content found or user didn\'t qualify for campaign for LocationRequest (%s)"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->request:Lcom/adobe/mobile/TargetLocationRequest;

    iget-object v3, v3, Lcom/adobe/mobile/TargetLocationRequest;->name:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 136
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    if-eqz v0, :cond_2

    .line 137
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    iget-object v1, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->request:Lcom/adobe/mobile/TargetLocationRequest;

    iget-object v1, v1, Lcom/adobe/mobile/TargetLocationRequest;->defaultContent:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/adobe/mobile/Target$TargetCallback;->call(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 142
    :catch_1
    move-exception v0

    .line 143
    const-string v1, "Target - Unable to retrieve content (%s)"

    new-array v2, v6, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v5

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 144
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    if-eqz v0, :cond_2

    .line 145
    iget-object v0, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->callback:Lcom/adobe/mobile/Target$TargetCallback;

    iget-object v1, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask;->request:Lcom/adobe/mobile/TargetLocationRequest;

    iget-object v1, v1, Lcom/adobe/mobile/TargetLocationRequest;->defaultContent:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/adobe/mobile/Target$TargetCallback;->call(Ljava/lang/Object;)V

    goto :goto_0
.end method

.class public final Lcom/adobe/adms/testandtarget/Mbox;
.super Ljava/lang/Object;
.source "Mbox.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/adms/testandtarget/Mbox$1;,
        Lcom/adobe/adms/testandtarget/Mbox$TimeoutTimerTask;
    }
.end annotation


# static fields
.field private static final DEFAULT_MAX_RESPONSE_TIME:J = 0x3a98L

.field private static final LOG_TAG:Ljava/lang/String; = "Mbox"

.field private static final MBOX_DEFAULT:Ljava/lang/String; = "/images/log.gif"

.field private static final OFFER_CONTENT_TYPE:Ljava/lang/String; = "text/plain; charset=utf-8"

.field private static volatile TargetLifecycleString_pred:Z

.field private static _lifecycleParamsString:Ljava/lang/String;


# instance fields
.field private defaultContent:Ljava/lang/String;

.field private maxOfferResponseTime:J

.field private mboxName:Ljava/lang/String;

.field private mboxParameterList:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private offerTimeoutTask:Lcom/adobe/adms/testandtarget/Mbox$TimeoutTimerTask;

.field private offerTimer:Ljava/util/Timer;

.field private onLoadConsumers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/adobe/adms/testandtarget/MboxContentConsumer;",
            ">;"
        }
    .end annotation
.end field

.field private onLoadConsumersCalled:Z

.field private parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 227
    const/4 v0, 0x1

    sput-boolean v0, Lcom/adobe/adms/testandtarget/Mbox;->TargetLifecycleString_pred:Z

    return-void
.end method

.method protected constructor <init>(Lcom/adobe/adms/testandtarget/MboxFactory;Ljava/lang/String;)V
    .locals 2
    .param p1, "parentFactory"    # Lcom/adobe/adms/testandtarget/MboxFactory;
    .param p2, "mboxName"    # Ljava/lang/String;

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    const-wide/16 v0, 0x3a98

    iput-wide v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->maxOfferResponseTime:J

    .line 52
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->mboxParameterList:Ljava/util/concurrent/ConcurrentHashMap;

    .line 56
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->onLoadConsumers:Ljava/util/Vector;

    .line 58
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->onLoadConsumersCalled:Z

    .line 71
    iput-object p1, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    .line 72
    iput-object p2, p0, Lcom/adobe/adms/testandtarget/Mbox;->mboxName:Ljava/lang/String;

    .line 73
    return-void
.end method

.method private GetLifecycleParamsString()Ljava/lang/String;
    .locals 7

    .prologue
    .line 229
    sget-boolean v4, Lcom/adobe/adms/testandtarget/Mbox;->TargetLifecycleString_pred:Z

    if-eqz v4, :cond_1

    .line 230
    const/4 v4, 0x0

    sput-boolean v4, Lcom/adobe/adms/testandtarget/Mbox;->TargetLifecycleString_pred:Z

    .line 232
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 234
    .local v3, "urlSb":Ljava/lang/StringBuilder;
    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Churn;->getLifecycleContextData()Ljava/util/HashMap;

    move-result-object v2

    .line 235
    .local v2, "lifecycleMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz v2, :cond_0

    .line 236
    invoke-virtual {v2}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 237
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v4, "&"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/adobe/adms/testandtarget/MboxFactory;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 244
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    sput-object v4, Lcom/adobe/adms/testandtarget/Mbox;->_lifecycleParamsString:Ljava/lang/String;

    .line 247
    .end local v2    # "lifecycleMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v3    # "urlSb":Ljava/lang/StringBuilder;
    :cond_1
    sget-object v4, Lcom/adobe/adms/testandtarget/Mbox;->_lifecycleParamsString:Ljava/lang/String;

    return-object v4
.end method

.method private buildMboxRequestURL()Ljava/lang/String;
    .locals 8

    .prologue
    .line 198
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    .line 199
    .local v3, "timeStamp":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    invoke-virtual {v5}, Lcom/adobe/adms/testandtarget/MboxFactory;->getBaseRequestURL()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 200
    .local v4, "url":Ljava/lang/StringBuilder;
    const-string v5, "mbox="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    iget-object v7, p0, Lcom/adobe/adms/testandtarget/Mbox;->mboxName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/adobe/adms/testandtarget/MboxFactory;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&mboxDefault="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    const-string v7, "/images/log.gif"

    invoke-virtual {v6, v7}, Lcom/adobe/adms/testandtarget/MboxFactory;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&mboxContentType="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    const-string v7, "text/plain; charset=utf-8"

    invoke-virtual {v6, v7}, Lcom/adobe/adms/testandtarget/MboxFactory;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "&mboxTime="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 208
    iget-object v5, p0, Lcom/adobe/adms/testandtarget/Mbox;->mboxParameterList:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v5}, Ljava/util/concurrent/ConcurrentHashMap;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 209
    .local v0, "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v5, "&"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v7, v5}, Lcom/adobe/adms/testandtarget/MboxFactory;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v7, v5}, Lcom/adobe/adms/testandtarget/MboxFactory;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 215
    .end local v0    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-direct {p0}, Lcom/adobe/adms/testandtarget/Mbox;->GetLifecycleParamsString()Ljava/lang/String;

    move-result-object v2

    .line 216
    .local v2, "lifecycleData":Ljava/lang/String;
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_1

    .line 217
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 220
    :cond_1
    const-string v5, "TARGET"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "request url: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 222
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method

.method private startOfferTimer()V
    .locals 4

    .prologue
    .line 254
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->offerTimer:Ljava/util/Timer;

    .line 255
    new-instance v0, Lcom/adobe/adms/testandtarget/Mbox$TimeoutTimerTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/adobe/adms/testandtarget/Mbox$TimeoutTimerTask;-><init>(Lcom/adobe/adms/testandtarget/Mbox;Lcom/adobe/adms/testandtarget/Mbox$1;)V

    iput-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->offerTimeoutTask:Lcom/adobe/adms/testandtarget/Mbox$TimeoutTimerTask;

    .line 256
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->offerTimer:Ljava/util/Timer;

    iget-object v1, p0, Lcom/adobe/adms/testandtarget/Mbox;->offerTimeoutTask:Lcom/adobe/adms/testandtarget/Mbox$TimeoutTimerTask;

    iget-wide v2, p0, Lcom/adobe/adms/testandtarget/Mbox;->maxOfferResponseTime:J

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 257
    return-void
.end method


# virtual methods
.method public addMboxParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "paramName"    # Ljava/lang/String;
    .param p2, "paramValue"    # Ljava/lang/String;

    .prologue
    .line 84
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 85
    :cond_0
    const-string v0, "TARGET"

    const-string v1, "Parameter \'paramName\' in addMboxParameter() cannot be null"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 90
    .end local p2    # "paramValue":Ljava/lang/String;
    :goto_0
    return-void

    .line 89
    .restart local p2    # "paramValue":Ljava/lang/String;
    :cond_1
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->mboxParameterList:Ljava/util/concurrent/ConcurrentHashMap;

    if-eqz p2, :cond_2

    .end local p2    # "paramValue":Ljava/lang/String;
    :goto_1
    invoke-virtual {v0, p1, p2}, Ljava/util/concurrent/ConcurrentHashMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .restart local p2    # "paramValue":Ljava/lang/String;
    :cond_2
    const-string p2, ""

    goto :goto_1
.end method

.method public addOnLoadConsumer(Lcom/adobe/adms/testandtarget/MboxContentConsumer;)V
    .locals 1
    .param p1, "consumer"    # Lcom/adobe/adms/testandtarget/MboxContentConsumer;

    .prologue
    .line 105
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->onLoadConsumers:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 106
    return-void
.end method

.method protected declared-synchronized callOnLoadConsumers(Ljava/lang/String;)V
    .locals 3
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 176
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/adobe/adms/testandtarget/Mbox;->offerTimer:Ljava/util/Timer;

    if-eqz v2, :cond_0

    .line 177
    iget-object v2, p0, Lcom/adobe/adms/testandtarget/Mbox;->offerTimer:Ljava/util/Timer;

    invoke-virtual {v2}, Ljava/util/Timer;->cancel()V

    .line 179
    :cond_0
    if-nez p1, :cond_1

    .line 180
    iget-object p1, p0, Lcom/adobe/adms/testandtarget/Mbox;->defaultContent:Ljava/lang/String;

    .line 182
    :cond_1
    iget-boolean v2, p0, Lcom/adobe/adms/testandtarget/Mbox;->onLoadConsumersCalled:Z

    if-nez v2, :cond_2

    .line 183
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/adobe/adms/testandtarget/Mbox;->onLoadConsumersCalled:Z

    .line 184
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/adobe/adms/testandtarget/Mbox;->onLoadConsumers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-ge v1, v2, :cond_2

    .line 186
    :try_start_1
    iget-object v2, p0, Lcom/adobe/adms/testandtarget/Mbox;->onLoadConsumers:Ljava/util/Vector;

    invoke-virtual {v2, v1}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/adms/testandtarget/MboxContentConsumer;

    invoke-interface {v2, p1}, Lcom/adobe/adms/testandtarget/MboxContentConsumer;->consume(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 184
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 187
    :catch_0
    move-exception v0

    .line 188
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 176
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "i":I
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 192
    :cond_2
    monitor-exit p0

    return-void
.end method

.method public getFactory()Lcom/adobe/adms/testandtarget/MboxFactory;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    return-object v0
.end method

.method public declared-synchronized load()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/adms/testandtarget/MissingDefaultContentException;,
            Lcom/adobe/adms/testandtarget/MissingOnLoadConsumerException;
        }
    .end annotation

    .prologue
    .line 126
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->defaultContent:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 127
    new-instance v0, Lcom/adobe/adms/testandtarget/MissingDefaultContentException;

    invoke-direct {v0}, Lcom/adobe/adms/testandtarget/MissingDefaultContentException;-><init>()V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 126
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 129
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->onLoadConsumers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 130
    new-instance v0, Lcom/adobe/adms/testandtarget/MissingOnLoadConsumerException;

    invoke-direct {v0}, Lcom/adobe/adms/testandtarget/MissingOnLoadConsumerException;-><init>()V

    throw v0

    .line 132
    :cond_1
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    invoke-virtual {v0}, Lcom/adobe/adms/testandtarget/MboxFactory;->isEnabled()Z

    move-result v0

    if-nez v0, :cond_2

    .line 133
    const-string v0, "Mbox"

    const-string v1, "WARNING: MboxFactory is disabled. Consuming default content."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 134
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->defaultContent:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/adobe/adms/testandtarget/Mbox;->callOnLoadConsumers(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 142
    :goto_0
    monitor-exit p0

    return-void

    .line 137
    :cond_2
    :try_start_2
    invoke-direct {p0}, Lcom/adobe/adms/testandtarget/Mbox;->startOfferTimer()V

    .line 140
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/Mbox;->parentFactory:Lcom/adobe/adms/testandtarget/MboxFactory;

    invoke-direct {p0}, Lcom/adobe/adms/testandtarget/Mbox;->buildMboxRequestURL()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Lcom/adobe/adms/testandtarget/MboxFactory;->getMboxResponse(Lcom/adobe/adms/testandtarget/Mbox;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public declared-synchronized setDefaultContent(Ljava/lang/String;)V
    .locals 1
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 155
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/adobe/adms/testandtarget/Mbox;->defaultContent:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 156
    monitor-exit p0

    return-void

    .line 155
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setMaxResponseTime(J)V
    .locals 1
    .param p1, "milliseconds"    # J

    .prologue
    .line 165
    iput-wide p1, p0, Lcom/adobe/adms/testandtarget/Mbox;->maxOfferResponseTime:J

    .line 166
    return-void
.end method

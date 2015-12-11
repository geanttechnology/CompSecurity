.class public Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;
.super Ljava/lang/Object;
.source "RtlaCrashDetailsCollectable.java"

# interfaces
.implements Lcom/amazon/device/crashmanager/CrashDetailsCollectable;


# instance fields
.field private final mRtlaCrashDetails:Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;


# direct methods
.method public constructor <init>(Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;)V
    .locals 0
    .param p1, "rtlaCrashDetails"    # Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->validateCrashDetails(Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;)V

    .line 28
    iput-object p1, p0, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->mRtlaCrashDetails:Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    .line 29
    return-void
.end method

.method private defaultOnNull(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 69
    if-nez p1, :cond_0

    .line 72
    .end local p2    # "defaultValue":Ljava/lang/String;
    :goto_0
    return-object p2

    .restart local p2    # "defaultValue":Ljava/lang/String;
    :cond_0
    move-object p2, p1

    goto :goto_0
.end method

.method private formatWebLabs(Ljava/util/List;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 76
    .local p1, "webLabs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 77
    const-string/jumbo v3, ""

    .line 84
    :goto_0
    return-object v3

    .line 80
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 81
    .local v2, "webLabString":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 82
    .local v1, "webLab":Ljava/lang/String;
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 84
    .end local v1    # "webLab":Ljava/lang/String;
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method private validateCrashDetails(Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;)V
    .locals 2
    .param p1, "rtlaCrashDetails"    # Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    .prologue
    .line 63
    if-nez p1, :cond_0

    .line 64
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "RtlaCrashDetails must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 66
    :cond_0
    return-void
.end method


# virtual methods
.method public collect(Ljava/lang/Throwable;)Ljava/util/Map;
    .locals 8
    .param p1, "ex"    # Ljava/lang/Throwable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 33
    iget-object v6, p0, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->mRtlaCrashDetails:Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    invoke-interface {v6}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;->getSessionId()Ljava/lang/String;

    move-result-object v3

    .line 34
    .local v3, "sessionId":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->mRtlaCrashDetails:Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    invoke-interface {v6}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;->getUserAgent()Ljava/lang/String;

    move-result-object v5

    .line 35
    .local v5, "userAgent":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->mRtlaCrashDetails:Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    invoke-interface {v6}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;->getPageType()Ljava/lang/String;

    move-result-object v2

    .line 36
    .local v2, "pageType":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->mRtlaCrashDetails:Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    invoke-interface {v6}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;->getSubPageType()Ljava/lang/String;

    move-result-object v4

    .line 37
    .local v4, "subPageType":Ljava/lang/String;
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 38
    .local v0, "activeWebLabs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v6, p0, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->mRtlaCrashDetails:Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    invoke-interface {v6}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;->getActiveWebLabs()Ljava/util/List;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 39
    iget-object v6, p0, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->mRtlaCrashDetails:Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;

    invoke-interface {v6}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;->getActiveWebLabs()Ljava/util/List;

    move-result-object v6

    invoke-interface {v0, v6}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 43
    :cond_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 45
    .local v1, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v6, "RtlaSessionId"

    const-string/jumbo v7, "000-0000000-0000000"

    invoke-direct {p0, v3, v7}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->defaultOnNull(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v1, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    if-eqz v5, :cond_1

    .line 47
    const-string/jumbo v6, "RtlaUserAgent"

    invoke-interface {v1, v6, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    :cond_1
    if-eqz v2, :cond_2

    .line 50
    const-string/jumbo v6, "RtlaPageType"

    invoke-interface {v1, v6, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    :cond_2
    if-eqz v4, :cond_3

    .line 53
    const-string/jumbo v6, "RtlaSubPageType"

    invoke-interface {v1, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    :cond_3
    if-eqz v0, :cond_4

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_4

    .line 56
    const-string/jumbo v6, "RtlaWebLabs"

    invoke-direct {p0, v0}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;->formatWebLabs(Ljava/util/List;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v1, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    :cond_4
    return-object v1
.end method

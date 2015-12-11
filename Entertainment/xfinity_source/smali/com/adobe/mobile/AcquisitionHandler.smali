.class final Lcom/adobe/mobile/AcquisitionHandler;
.super Ljava/lang/Object;
.source "AcquisitionHandler.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static campaignStartForApp(Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .param p0, "appId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 26
    .local p1, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1, p1}, Lcom/adobe/mobile/AcquisitionHandler;->constructURLForCampaignStartRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 27
    .local v0, "url":Ljava/lang/String;
    const-string v1, "Acquisition - Sending acquisition request  (%s)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 28
    const/4 v1, 0x0

    const/16 v2, 0x1388

    const-string v3, "Acquisition"

    invoke-static {v0, v1, v2, v3}, Lcom/adobe/mobile/RequestHandler;->sendGenericRequest(Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)V

    .line 29
    return-void
.end method

.method protected static constructURLForCampaignStartRequest(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    .locals 7
    .param p0, "appId"    # Ljava/lang/String;
    .param p1, "adid"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 32
    .local p2, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v5

    if-gtz v5, :cond_1

    .line 33
    :cond_0
    const-string v5, "Acquisition - Acquisition application identifier is blank"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 34
    const/4 v5, 0x0

    .line 61
    :goto_0
    return-object v5

    .line 36
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 37
    .local v3, "urlSb":Ljava/lang/StringBuilder;
    const-string v5, "http://c00.adobe.com/v3/"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "/start?"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 39
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 40
    .local v2, "querySb":Ljava/lang/StringBuilder;
    if-eqz p1, :cond_2

    .line 41
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    if-lez v5, :cond_4

    const-string v5, "&"

    :goto_1
    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 42
    const-string v5, "a_cid="

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {p1}, Lcom/adobe/mobile/StaticMethods;->URLEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 45
    :cond_2
    if-eqz p2, :cond_6

    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v5

    if-lez v5, :cond_6

    .line 46
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_3
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_6

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 47
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 48
    .local v1, "key":Ljava/lang/String;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    .line 50
    .local v4, "value":Ljava/lang/Object;
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    if-eqz v5, :cond_3

    if-eqz v4, :cond_3

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-eqz v5, :cond_3

    .line 53
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    if-lez v5, :cond_5

    const-string v5, "&"

    :goto_3
    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 54
    const-string v5, "ctx"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 55
    invoke-static {v1}, Lcom/adobe/mobile/StaticMethods;->URLEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    const-string v5, "="

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 57
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/adobe/mobile/StaticMethods;->URLEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 41
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v1    # "key":Ljava/lang/String;
    .end local v4    # "value":Ljava/lang/Object;
    :cond_4
    const-string v5, ""

    goto :goto_1

    .line 53
    .restart local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local v1    # "key":Ljava/lang/String;
    .restart local v4    # "value":Ljava/lang/Object;
    :cond_5
    const-string v5, ""

    goto :goto_3

    .line 61
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v1    # "key":Ljava/lang/String;
    .end local v4    # "value":Ljava/lang/Object;
    :cond_6
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_0
.end method

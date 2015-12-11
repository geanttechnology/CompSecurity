.class public Lcom/amazon/sdk/availability/Configuration;
.super Ljava/lang/Object;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;,
        Lcom/amazon/sdk/availability/Configuration$Policy;,
        Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    }
.end annotation


# instance fields
.field private collectionConfigMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;",
            ">;"
        }
    .end annotation
.end field

.field private sourceJson:Lorg/json/JSONObject;

.field private stateExpiry:Ljava/lang/Long;

.field private stateNextRefresh:Ljava/lang/Long;

.field private stateRetryInterval:Ljava/lang/Long;

.field private stateServerTime:Ljava/lang/Long;

.field private stateSubmissionInterval:Ljava/lang/Long;

.field private stateToken:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 10
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    const-wide/16 v8, 0x0

    .line 561
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 562
    iput-object p1, p0, Lcom/amazon/sdk/availability/Configuration;->sourceJson:Lorg/json/JSONObject;

    .line 563
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    iput-object v6, p0, Lcom/amazon/sdk/availability/Configuration;->collectionConfigMap:Ljava/util/Map;

    .line 564
    if-nez p1, :cond_1

    .line 594
    :cond_0
    :goto_0
    return-void

    .line 568
    :cond_1
    const-string/jumbo v6, "collection"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 569
    .local v1, "collectionMap":Lorg/json/JSONObject;
    if-eqz v1, :cond_3

    .line 570
    invoke-virtual {v1}, Lorg/json/JSONObject;->names()Lorg/json/JSONArray;

    move-result-object v4

    .line 571
    .local v4, "names":Lorg/json/JSONArray;
    if-eqz v4, :cond_3

    .line 572
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-ge v2, v6, :cond_3

    .line 573
    const/4 v6, 0x0

    invoke-virtual {v4, v2, v6}, Lorg/json/JSONArray;->optString(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 576
    .local v3, "name":Ljava/lang/String;
    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 577
    .local v0, "collection":Lorg/json/JSONObject;
    if-eqz v0, :cond_2

    .line 578
    iget-object v6, p0, Lcom/amazon/sdk/availability/Configuration;->collectionConfigMap:Ljava/util/Map;

    new-instance v7, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;

    invoke-direct {v7, v0}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;-><init>(Lorg/json/JSONObject;)V

    invoke-interface {v6, v3, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 572
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 585
    .end local v0    # "collection":Lorg/json/JSONObject;
    .end local v2    # "i":I
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "names":Lorg/json/JSONArray;
    :cond_3
    const-string/jumbo v6, "state"

    invoke-virtual {p1, v6}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 586
    .local v5, "state":Lorg/json/JSONObject;
    if-eqz v5, :cond_0

    .line 587
    const-string/jumbo v6, "expiry"

    invoke-virtual {v5, v6, v8, v9}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/sdk/availability/Configuration;->stateExpiry:Ljava/lang/Long;

    .line 588
    const-string/jumbo v6, "submissionInterval"

    invoke-virtual {v5, v6, v8, v9}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/sdk/availability/Configuration;->stateSubmissionInterval:Ljava/lang/Long;

    .line 589
    const-string/jumbo v6, "retryInterval"

    invoke-virtual {v5, v6, v8, v9}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/sdk/availability/Configuration;->stateRetryInterval:Ljava/lang/Long;

    .line 590
    const-string/jumbo v6, "nextRefresh"

    invoke-virtual {v5, v6, v8, v9}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/sdk/availability/Configuration;->stateNextRefresh:Ljava/lang/Long;

    .line 591
    const-string/jumbo v6, "serverTime"

    invoke-virtual {v5, v6, v8, v9}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v6

    const-wide/16 v8, 0x3e8

    mul-long/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/sdk/availability/Configuration;->stateServerTime:Ljava/lang/Long;

    .line 592
    const-string/jumbo v6, "token"

    const-string/jumbo v7, ""

    invoke-static {v5, v6, v7}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/sdk/availability/Configuration;->stateToken:Ljava/lang/String;

    goto/16 :goto_0
.end method

.method protected static optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "o"    # Lorg/json/JSONObject;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "d"    # Ljava/lang/String;

    .prologue
    .line 680
    const/4 v0, 0x0

    .line 681
    .local v0, "result":Ljava/lang/String;
    if-eqz p0, :cond_0

    .line 682
    invoke-virtual {p0, p1, p2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 684
    const-string/jumbo v1, "null"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 685
    move-object v0, p2

    .line 688
    :cond_0
    return-object v0
.end method


# virtual methods
.method public getClientIds()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 603
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration;->collectionConfigMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public getCollectionConfiguration(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
    .locals 1
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    .line 613
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration;->collectionConfigMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;

    return-object v0
.end method

.method public getJson()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 669
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration;->sourceJson:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getStateExpiry()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 621
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration;->stateExpiry:Ljava/lang/Long;

    return-object v0
.end method

.method public getStateNextRefresh()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 645
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration;->stateNextRefresh:Ljava/lang/Long;

    return-object v0
.end method

.method public getStateRetryInterval()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 637
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration;->stateRetryInterval:Ljava/lang/Long;

    return-object v0
.end method

.method public getStateServerTime()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 653
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration;->stateServerTime:Ljava/lang/Long;

    return-object v0
.end method

.method public getStateSubmissionInterval()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 629
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration;->stateSubmissionInterval:Ljava/lang/Long;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 696
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 697
    .local v2, "sb":Ljava/lang/StringBuffer;
    const-string/jumbo v3, "{\n\t\"collection\" : {"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 698
    iget-object v3, p0, Lcom/amazon/sdk/availability/Configuration;->collectionConfigMap:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 699
    .local v0, "clientId":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\" : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v3, p0, Lcom/amazon/sdk/availability/Configuration;->collectionConfigMap:Ljava/util/Map;

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;

    invoke-virtual {v3}, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 701
    .end local v0    # "clientId":Ljava/lang/String;
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "\n\t}\",\n\t\"stateExpiry\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration;->stateExpiry:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"stateSubmissionInterval\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration;->stateSubmissionInterval:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"stateRetryInterval\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration;->stateRetryInterval:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"stateNextRefresh\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration;->stateNextRefresh:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"stateServerTime\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration;->stateServerTime:Ljava/lang/Long;

    invoke-static {v4}, Lcom/amazon/sdk/availability/StringUtil;->dateToString(Ljava/lang/Long;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"stateToken\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration;->stateToken:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\"\n}"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 710
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

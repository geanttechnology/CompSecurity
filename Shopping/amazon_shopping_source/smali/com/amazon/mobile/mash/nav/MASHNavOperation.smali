.class public Lcom/amazon/mobile/mash/nav/MASHNavOperation;
.super Ljava/lang/Object;
.source "MASHNavOperation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;
    }
.end annotation


# instance fields
.field private mBackAmount:I

.field private mBookmark:Ljava/lang/String;

.field private mOperation:Ljava/lang/String;

.field private mRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 164
    return-void
.end method


# virtual methods
.method public getBackAmount()I
    .locals 1

    .prologue
    .line 90
    iget v0, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mBackAmount:I

    return v0
.end method

.method public getBookmark()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mBookmark:Ljava/lang/String;

    return-object v0
.end method

.method public getOperation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mOperation:Ljava/lang/String;

    return-object v0
.end method

.method public getRequest()Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    return-object v0
.end method

.method public setBackAmount(I)V
    .locals 0
    .param p1, "backAmount"    # I

    .prologue
    .line 97
    iput p1, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mBackAmount:I

    .line 98
    return-void
.end method

.method public setBookmark(Ljava/lang/String;)V
    .locals 0
    .param p1, "bookmark"    # Ljava/lang/String;

    .prologue
    .line 111
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mBookmark:Ljava/lang/String;

    .line 112
    return-void
.end method

.method public setOperation(Ljava/lang/String;)V
    .locals 0
    .param p1, "operation"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mOperation:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setRequest(Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V
    .locals 0
    .param p1, "request"    # Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    .line 126
    return-void
.end method

.method public toJSONString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 133
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 135
    .local v1, "navOperation":Lorg/json/JSONObject;
    :try_start_0
    const-string/jumbo v3, "op"

    iget-object v4, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mOperation:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 137
    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mBookmark:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 138
    const-string/jumbo v3, "bookmark"

    iget-object v4, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mBookmark:Ljava/lang/String;

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 141
    :cond_0
    iget v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mBackAmount:I

    if-lez v3, :cond_1

    .line 142
    const-string/jumbo v3, "backAmount"

    iget v4, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mBackAmount:I

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 145
    :cond_1
    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    if-eqz v3, :cond_3

    .line 146
    const-string/jumbo v3, "url"

    iget-object v4, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 147
    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getMethod()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 148
    const-string/jumbo v3, "method"

    iget-object v4, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getMethod()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 150
    :cond_2
    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->mRequest:Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->getParams()Lorg/json/JSONObject;

    move-result-object v2

    .line 151
    .local v2, "params":Lorg/json/JSONObject;
    if-eqz v2, :cond_3

    .line 152
    const-string/jumbo v3, "parameters"

    invoke-virtual {v1, v3, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    .end local v2    # "params":Lorg/json/JSONObject;
    :cond_3
    :goto_0
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 155
    :catch_0
    move-exception v0

    .line 156
    .local v0, "e":Lorg/json/JSONException;
    const-string/jumbo v3, "MASHNavOperation"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Created a bad JSON object. Error : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

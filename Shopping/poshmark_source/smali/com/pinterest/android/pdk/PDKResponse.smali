.class public Lcom/pinterest/android/pdk/PDKResponse;
.super Ljava/lang/Object;
.source "PDKResponse.java"


# instance fields
.field protected _cursor:Ljava/lang/String;

.field protected _data:Ljava/lang/Object;

.field protected _params:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected _path:Ljava/lang/String;

.field protected _statusCode:I


# direct methods
.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 3
    .param p1, "obj"    # Lorg/json/JSONObject;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/pinterest/android/pdk/PDKResponse;->_cursor:Ljava/lang/String;

    .line 17
    const/4 v2, -0x1

    iput v2, p0, Lcom/pinterest/android/pdk/PDKResponse;->_statusCode:I

    .line 20
    if-nez p1, :cond_1

    .line 41
    :cond_0
    :goto_0
    return-void

    .line 23
    :cond_1
    const-string v2, "data"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 25
    :try_start_0
    const-string v2, "data"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/pinterest/android/pdk/PDKResponse;->setData(Ljava/lang/Object;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 31
    :cond_2
    :goto_1
    const-string v2, "page"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 33
    :try_start_1
    const-string v2, "page"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 34
    .local v1, "pageObj":Lorg/json/JSONObject;
    const-string v2, "cursor"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 35
    const-string v2, "cursor"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/pinterest/android/pdk/PDKResponse;->_cursor:Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 37
    .end local v1    # "pageObj":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 38
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 26
    .end local v0    # "e":Lorg/json/JSONException;
    :catch_1
    move-exception v0

    .line 27
    .restart local v0    # "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method


# virtual methods
.method public getBoard()Lcom/pinterest/android/pdk/PDKBoard;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKBoard;->makeBoard(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKBoard;

    move-result-object v0

    return-object v0
.end method

.method public getBoardList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/pinterest/android/pdk/PDKBoard;",
            ">;"
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKBoard;->makeBoardList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getData()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    return-object v0
.end method

.method public getInterest()Lcom/pinterest/android/pdk/PDKInterest;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKInterest;->makeInterest(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKInterest;

    move-result-object v0

    return-object v0
.end method

.method public getInterestList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/pinterest/android/pdk/PDKInterest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKInterest;->makeInterestList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getPin()Lcom/pinterest/android/pdk/PDKPin;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKPin;->makePin(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKPin;

    move-result-object v0

    return-object v0
.end method

.method public getPinList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/pinterest/android/pdk/PDKPin;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKPin;->makePinList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public final getStatusCode()I
    .locals 1

    .prologue
    .line 102
    iget v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_statusCode:I

    return v0
.end method

.method public getUser()Lcom/pinterest/android/pdk/PDKUser;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKUser;->makeUser(Ljava/lang/Object;)Lcom/pinterest/android/pdk/PDKUser;

    move-result-object v0

    return-object v0
.end method

.method public getUserList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/pinterest/android/pdk/PDKUser;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKUser;->makeUserList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public hasNext()Z
    .locals 2

    .prologue
    .line 84
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_cursor:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_cursor:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_cursor:Ljava/lang/String;

    const-string v1, "null"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isValid()Z
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public loadNext(Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKResponse;->_params:Ljava/util/HashMap;

    const-string v1, "cursor"

    iget-object v2, p0, Lcom/pinterest/android/pdk/PDKResponse;->_cursor:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v0

    iget-object v1, p0, Lcom/pinterest/android/pdk/PDKResponse;->_path:Ljava/lang/String;

    iget-object v2, p0, Lcom/pinterest/android/pdk/PDKResponse;->_params:Ljava/util/HashMap;

    invoke-virtual {v0, v1, v2, p1}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 81
    return-void
.end method

.method public setData(Ljava/lang/Object;)V
    .locals 0
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 90
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKResponse;->_data:Ljava/lang/Object;

    .line 91
    return-void
.end method

.method public setParams(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 107
    .local p1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKResponse;->_params:Ljava/util/HashMap;

    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKResponse;->_path:Ljava/lang/String;

    return-void
.end method

.method public final setStatusCode(I)V
    .locals 0
    .param p1, "code"    # I

    .prologue
    .line 98
    iput p1, p0, Lcom/pinterest/android/pdk/PDKResponse;->_statusCode:I

    .line 99
    return-void
.end method

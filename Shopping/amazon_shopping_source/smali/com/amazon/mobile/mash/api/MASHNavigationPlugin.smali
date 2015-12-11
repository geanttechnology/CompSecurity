.class public Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHNavigationPlugin.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mNavStackSeqCallbackContext:Lorg/apache/cordova/CallbackContext;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Lorg/json/JSONArray;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    .param p1, "x1"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->getOperationList(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private createMASHNavOperation(Lorg/json/JSONObject;)Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    .locals 3
    .param p1, "operation"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 151
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    invoke-direct {v0}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;-><init>()V

    .line 153
    .local v0, "mashNavOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    const-string/jumbo v2, "op"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->setOperation(Ljava/lang/String;)V

    .line 155
    const-string/jumbo v2, "bookmark"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 156
    const-string/jumbo v2, "bookmark"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->setBookmark(Ljava/lang/String;)V

    .line 159
    :cond_0
    const-string/jumbo v2, "backAmount"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 160
    const-string/jumbo v2, "backAmount"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->setBackAmount(I)V

    .line 163
    :cond_1
    const/4 v1, 0x0

    .line 165
    .local v1, "request":Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;
    const-string/jumbo v2, "url"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 166
    new-instance v1, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;

    .end local v1    # "request":Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;
    invoke-direct {v1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;-><init>()V

    .line 167
    .restart local v1    # "request":Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;
    const-string/jumbo v2, "url"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->setUrl(Ljava/lang/String;)V

    .line 169
    const-string/jumbo v2, "method"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 170
    const-string/jumbo v2, "method"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->setMethod(Ljava/lang/String;)V

    .line 173
    :cond_2
    const-string/jumbo v2, "parameters"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 174
    const-string/jumbo v2, "parameters"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->setParams(Lorg/json/JSONObject;)V

    .line 178
    :cond_3
    invoke-virtual {v0, v1}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->setRequest(Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;)V

    .line 180
    return-object v0
.end method

.method private getOperationList(Lorg/json/JSONArray;)Ljava/util/List;
    .locals 4
    .param p1, "args"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mobile/mash/nav/MASHNavOperation;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 137
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 138
    .local v2, "operationList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/mobile/mash/nav/MASHNavOperation;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 139
    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 140
    .local v1, "operation":Lorg/json/JSONObject;
    invoke-direct {p0, v1}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->createMASHNavOperation(Lorg/json/JSONObject;)Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 138
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 142
    .end local v1    # "operation":Lorg/json/JSONObject;
    :cond_0
    return-object v2
.end method

.method private performNavigationStackSequence(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 79
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;-><init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 102
    return-void
.end method

.method private setBookmark(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 1
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 59
    new-instance v0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;-><init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 71
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Lorg/json/JSONArray;
    .param p3, "callbackContext"    # Lorg/apache/cordova/CallbackContext;

    .prologue
    .line 42
    const-string/jumbo v0, "SetBookmark"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 43
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->setBookmark(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 50
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0

    .line 44
    :cond_0
    const-string/jumbo v0, "PerformNavigationStackSequence"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 45
    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->mNavStackSeqCallbackContext:Lorg/apache/cordova/CallbackContext;

    .line 46
    invoke-direct {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->performNavigationStackSequence(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    goto :goto_0

    .line 48
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 8
    .param p1, "reqCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 106
    const/16 v5, 0x2713

    if-ne p1, v5, :cond_1

    .line 110
    const/16 v5, 0x2711

    if-ne p2, v5, :cond_1

    .line 112
    :try_start_0
    const-string/jumbo v5, "remainingOperations"

    invoke-virtual {p3, v5}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 113
    .local v4, "operations":[Ljava/lang/String;
    if-eqz v4, :cond_1

    .line 114
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 115
    .local v3, "operationArgs":Lorg/json/JSONArray;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v5, v4

    if-ge v1, v5, :cond_0

    .line 116
    new-instance v2, Lorg/json/JSONObject;

    aget-object v5, v4, v1

    invoke-direct {v2, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 117
    .local v2, "operation":Lorg/json/JSONObject;
    invoke-virtual {v3, v2}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 115
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 120
    .end local v2    # "operation":Lorg/json/JSONObject;
    :cond_0
    iget-object v5, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->mNavStackSeqCallbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0, v3, v5}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->performNavigationStackSequence(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 128
    .end local v1    # "i":I
    .end local v3    # "operationArgs":Lorg/json/JSONArray;
    .end local v4    # "operations":[Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 122
    :catch_0
    move-exception v0

    .line 123
    .local v0, "e":Lorg/json/JSONException;
    sget-object v5, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "MASH API can not do operation. Error: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 124
    iget-object v5, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->mNavStackSeqCallbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v6, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v6

    invoke-virtual {v5, v6}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_1
.end method

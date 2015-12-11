.class Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;
.super Ljava/lang/Object;
.source "MASHNavigationPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->performNavigationStackSequence(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

.field final synthetic val$args:Lorg/json/JSONArray;

.field final synthetic val$callbackContext:Lorg/apache/cordova/CallbackContext;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->val$args:Lorg/json/JSONArray;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 83
    :try_start_0
    iget-object v6, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    iget-object v7, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->val$args:Lorg/json/JSONArray;

    # invokes: Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->getOperationList(Lorg/json/JSONArray;)Ljava/util/List;
    invoke-static {v6, v7}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v4

    .line 84
    .local v4, "operationArrayList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mobile/mash/nav/MASHNavOperation;>;"
    const/4 v0, 0x0

    .line 85
    .local v0, "currentMashNavOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v6

    if-ge v3, v6, :cond_0

    .line 86
    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "currentMashNavOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    .line 87
    .restart local v0    # "currentMashNavOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    invoke-virtual {v0}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->getOperation()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->getMASHNavHandlerFactoryImpl(Ljava/lang/String;)Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->this$0:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    invoke-virtual {v6, v7, v4, v3}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->createOperationHandler(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)Lcom/amazon/mobile/mash/nav/MASHNavHandler;

    move-result-object v5

    .line 90
    .local v5, "operationHandler":Lcom/amazon/mobile/mash/nav/MASHNavHandler;
    invoke-virtual {v5}, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->navigate()V

    .line 85
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 92
    .end local v5    # "operationHandler":Lcom/amazon/mobile/mash/nav/MASHNavHandler;
    :cond_0
    iget-object v6, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v6}, Lorg/apache/cordova/CallbackContext;->success()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/amazon/mobile/mash/nav/MASHNavException; {:try_start_0 .. :try_end_0} :catch_1

    .line 100
    .end local v0    # "currentMashNavOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    .end local v3    # "i":I
    .end local v4    # "operationArrayList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mobile/mash/nav/MASHNavOperation;>;"
    :goto_1
    return-void

    .line 93
    :catch_0
    move-exception v1

    .line 94
    .local v1, "e":Lorg/json/JSONException;
    # getter for: Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->access$100()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "MASH API can not do operation. Error: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    iget-object v6, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v7, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v7}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v7

    invoke-virtual {v6, v7}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_1

    .line 96
    .end local v1    # "e":Lorg/json/JSONException;
    :catch_1
    move-exception v2

    .line 97
    .local v2, "ex":Lcom/amazon/mobile/mash/nav/MASHNavException;
    # getter for: Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->access$100()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "MASH API can not do operation. Error: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/nav/MASHNavException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 98
    iget-object v6, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$2;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v7, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v7}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v7

    invoke-virtual {v6, v7}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_1
.end method

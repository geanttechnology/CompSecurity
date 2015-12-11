.class Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;
.super Ljava/lang/Object;
.source "MASHNavigationPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->setBookmark(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
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
    .line 59
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;->val$args:Lorg/json/JSONArray;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 63
    :try_start_0
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;->val$args:Lorg/json/JSONArray;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 64
    .local v0, "bookmark":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    iget-object v2, v2, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    check-cast v2, Lcom/amazon/mobile/mash/MASHWebView;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/MASHWebView;->getMASHWebBackForwardList()Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->getCurrentItem()Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;->setBookmark(Ljava/lang/String;)V

    .line 65
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v2}, Lorg/apache/cordova/CallbackContext;->success()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    .end local v0    # "bookmark":Ljava/lang/String;
    :goto_0
    return-void

    .line 66
    :catch_0
    move-exception v1

    .line 67
    .local v1, "e":Lorg/json/JSONException;
    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHNavigationPlugin$1;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v3, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method

.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->showNotificationSettings(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$category:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 662
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;->val$category:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 665
    const-string/jumbo v0, "http://page?app-action=push-notification-settings"

    .line 666
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;->val$category:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z
    invoke-static {v1, v2}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 668
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "&category="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;->val$category:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 670
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mNavigationManager:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$500(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Lcom/amazon/mobile/mash/nav/MASHNavDelegate;->navigate(Ljava/lang/String;Landroid/content/Context;)Z

    .line 671
    return-void
.end method

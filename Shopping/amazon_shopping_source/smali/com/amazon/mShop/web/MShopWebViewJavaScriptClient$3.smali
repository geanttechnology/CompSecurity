.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->share(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$messagePlain:Ljava/lang/String;

.field final synthetic val$subject:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;->val$messagePlain:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;->val$subject:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/4 v1, 0x0

    .line 228
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v8

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;->val$messagePlain:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;->val$subject:Ljava/lang/String;

    move-object v2, v1

    move-object v3, v1

    move-object v6, v1

    move-object v7, v1

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->getShareChooserIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    invoke-static/range {v0 .. v7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$300(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 229
    return-void
.end method

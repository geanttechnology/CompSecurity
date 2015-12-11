.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->share_1_3_0(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$imageURL:Ljava/lang/String;

.field final synthetic val$messageHTML:Ljava/lang/String;

.field final synthetic val$messagePlain:Ljava/lang/String;

.field final synthetic val$messagePlain140:Ljava/lang/String;

.field final synthetic val$messagePlain160:Ljava/lang/String;

.field final synthetic val$subject:Ljava/lang/String;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$messagePlain160:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$messagePlain140:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$messageHTML:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$messagePlain:Ljava/lang/String;

    iput-object p6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$subject:Ljava/lang/String;

    iput-object p7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$imageURL:Ljava/lang/String;

    iput-object p8, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$url:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 253
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v8

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$messagePlain160:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$messagePlain140:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$messageHTML:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$messagePlain:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$subject:Ljava/lang/String;

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$imageURL:Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;->val$url:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->getShareChooserIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    invoke-static/range {v0 .. v7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$300(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 254
    return-void
.end method

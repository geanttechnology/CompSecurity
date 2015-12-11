.class Lcom/amazon/device/ads/AdWebViewClient$IntentExecutor;
.super Ljava/lang/Object;
.source "AdWebViewClient.java"

# interfaces
.implements Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdWebViewClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "IntentExecutor"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AdWebViewClient;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdWebViewClient;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/amazon/device/ads/AdWebViewClient$IntentExecutor;->this$0:Lcom/amazon/device/ads/AdWebViewClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;)Z
    .locals 7
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    .line 231
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 232
    .local v1, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 235
    :try_start_0
    iget-object v2, p0, Lcom/amazon/device/ads/AdWebViewClient$IntentExecutor;->this$0:Lcom/amazon/device/ads/AdWebViewClient;

    # getter for: Lcom/amazon/device/ads/AdWebViewClient;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/device/ads/AdWebViewClient;->access$000(Lcom/amazon/device/ads/AdWebViewClient;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 241
    :goto_0
    return v6

    .line 237
    :catch_0
    move-exception v0

    .line 239
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    # getter for: Lcom/amazon/device/ads/AdWebViewClient;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AdWebViewClient;->access$100()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Could not handle intent with URI: %s"

    new-array v4, v6, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

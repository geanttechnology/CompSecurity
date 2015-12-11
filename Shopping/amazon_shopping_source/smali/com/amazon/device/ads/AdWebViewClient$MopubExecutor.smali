.class Lcom/amazon/device/ads/AdWebViewClient$MopubExecutor;
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
    name = "MopubExecutor"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AdWebViewClient;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdWebViewClient;)V
    .locals 0

    .prologue
    .line 213
    iput-object p1, p0, Lcom/amazon/device/ads/AdWebViewClient$MopubExecutor;->this$0:Lcom/amazon/device/ads/AdWebViewClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 218
    const/4 v0, 0x1

    return v0
.end method

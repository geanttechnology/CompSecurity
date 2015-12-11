.class final Lcom/amazon/device/ads/WebRequest$1;
.super Ljava/lang/Object;
.source "WebRequest.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/WebRequest;->executeWebRequestInThread(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 800
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest$1;->val$url:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 804
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->createNewWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    .line 805
    .local v0, "request":Lcom/amazon/device/ads/WebRequest;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->enableLog(Z)V

    .line 806
    iget-object v1, p0, Lcom/amazon/device/ads/WebRequest$1;->val$url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setUrlString(Ljava/lang/String;)V

    .line 809
    :try_start_0
    invoke-virtual {v0}, Lcom/amazon/device/ads/WebRequest;->makeCall()Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_0
    .catch Lcom/amazon/device/ads/WebRequest$WebRequestException; {:try_start_0 .. :try_end_0} :catch_0

    .line 814
    :goto_0
    return-void

    .line 811
    :catch_0
    move-exception v1

    goto :goto_0
.end method

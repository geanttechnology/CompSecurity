.class Lcom/amazon/device/ads/WebRequest$WebRequestFactory;
.super Ljava/lang/Object;
.source "WebRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/WebRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "WebRequestFactory"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 1075
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createWebRequest()Lcom/amazon/device/ads/WebRequest;
    .locals 2

    .prologue
    .line 1083
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-ge v0, v1, :cond_0

    .line 1085
    new-instance v0, Lcom/amazon/device/ads/HttpClientWebRequest;

    invoke-direct {v0}, Lcom/amazon/device/ads/HttpClientWebRequest;-><init>()V

    .line 1089
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;

    invoke-direct {v0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;-><init>()V

    goto :goto_0
.end method

.class public Lcom/amazon/device/ads/AmazonOOAdResponse;
.super Ljava/lang/Object;
.source "AmazonOOAdResponse.java"


# instance fields
.field private ad_:Lcom/amazon/device/ads/AdData;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdData;)V
    .locals 0
    .param p1, "ad"    # Lcom/amazon/device/ads/AdData;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOAdResponse;->ad_:Lcom/amazon/device/ads/AdData;

    .line 14
    return-void
.end method


# virtual methods
.method public getCreative()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdResponse;->ad_:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getCreative()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

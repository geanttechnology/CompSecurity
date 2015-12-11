.class public Lcom/auditude/ads/network/NetworkAdLoaderFactory;
.super Ljava/lang/Object;
.source "NetworkAdLoaderFactory.java"


# direct methods
.method public static getLoaderForType(Ljava/lang/String;)Lcom/auditude/ads/network/INetworkAdLoader;
    .locals 3
    .param p0, "type"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 10
    invoke-static {p0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 22
    :cond_0
    :goto_0
    return-object v0

    .line 12
    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "vast"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 14
    new-instance v0, Lcom/auditude/ads/network/vast/VASTAdLoader;

    invoke-direct {v0}, Lcom/auditude/ads/network/vast/VASTAdLoader;-><init>()V

    goto :goto_0

    .line 16
    :cond_2
    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "vpaid"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0
.end method

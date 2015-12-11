.class Lcom/amazon/device/ads/MraidCommandPlayVideo;
.super Lcom/amazon/device/ads/MraidCommand;
.source "MraidCommand.java"


# direct methods
.method constructor <init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V
    .locals 0
    .param p2, "view"    # Lcom/amazon/device/ads/MraidView;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/device/ads/MraidView;",
            ")V"
        }
    .end annotation

    .prologue
    .line 111
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/MraidCommand;-><init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V

    return-void
.end method


# virtual methods
.method execute()V
    .locals 11

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 116
    const/4 v8, 0x0

    .line 117
    .local v8, "d":Lcom/amazon/device/ads/Controller$Dimensions;
    const-string/jumbo v1, "position"

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidCommandPlayVideo;->getIntArrayFromParamsForKey(Ljava/lang/String;)[Ljava/lang/Integer;

    move-result-object v9

    .line 118
    .local v9, "dims":[Ljava/lang/Integer;
    aget-object v1, v9, v3

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 120
    new-instance v8, Lcom/amazon/device/ads/Controller$Dimensions;

    .end local v8    # "d":Lcom/amazon/device/ads/Controller$Dimensions;
    invoke-direct {v8}, Lcom/amazon/device/ads/Controller$Dimensions;-><init>()V

    .line 121
    .restart local v8    # "d":Lcom/amazon/device/ads/Controller$Dimensions;
    aget-object v1, v9, v3

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iput v1, v8, Lcom/amazon/device/ads/Controller$Dimensions;->y:I

    .line 122
    aget-object v1, v9, v4

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iput v1, v8, Lcom/amazon/device/ads/Controller$Dimensions;->x:I

    .line 123
    const/4 v1, 0x2

    aget-object v1, v9, v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iput v1, v8, Lcom/amazon/device/ads/Controller$Dimensions;->width:I

    .line 124
    const/4 v1, 0x3

    aget-object v1, v9, v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iput v1, v8, Lcom/amazon/device/ads/Controller$Dimensions;->height:I

    .line 126
    :cond_0
    const-string/jumbo v1, "url"

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidCommandPlayVideo;->getStringFromParamsForKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 127
    .local v10, "url":Ljava/lang/String;
    new-instance v0, Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-direct {v0}, Lcom/amazon/device/ads/Controller$PlayerProperties;-><init>()V

    .line 128
    .local v0, "props":Lcom/amazon/device/ads/Controller$PlayerProperties;
    const-string/jumbo v1, "audioMuted"

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidCommandPlayVideo;->getBooleanFromParamsForKey(Ljava/lang/String;)Z

    move-result v1

    const-string/jumbo v2, "autoPlay"

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/MraidCommandPlayVideo;->getBooleanFromParamsForKey(Ljava/lang/String;)Z

    move-result v2

    const-string/jumbo v3, "controls"

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/MraidCommandPlayVideo;->getBooleanFromParamsForKey(Ljava/lang/String;)Z

    move-result v3

    const-string/jumbo v5, "loop"

    invoke-virtual {p0, v5}, Lcom/amazon/device/ads/MraidCommandPlayVideo;->getBooleanFromParamsForKey(Ljava/lang/String;)Z

    move-result v5

    const-string/jumbo v6, "startStyle"

    invoke-virtual {p0, v6}, Lcom/amazon/device/ads/MraidCommandPlayVideo;->getStringFromParamsForKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "stopStyle"

    invoke-virtual {p0, v7}, Lcom/amazon/device/ads/MraidCommandPlayVideo;->getStringFromParamsForKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual/range {v0 .. v7}, Lcom/amazon/device/ads/Controller$PlayerProperties;->setProperties(ZZZZZLjava/lang/String;Ljava/lang/String;)V

    .line 132
    iget-object v1, p0, Lcom/amazon/device/ads/MraidCommandPlayVideo;->mView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v1

    invoke-virtual {v1, v10, v8, v0}, Lcom/amazon/device/ads/MraidDisplayController;->playVideo(Ljava/lang/String;Lcom/amazon/device/ads/Controller$Dimensions;Lcom/amazon/device/ads/Controller$PlayerProperties;)V

    .line 133
    return-void
.end method

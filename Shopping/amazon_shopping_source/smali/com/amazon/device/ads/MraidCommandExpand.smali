.class Lcom/amazon/device/ads/MraidCommandExpand;
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
    .line 91
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/MraidCommand;-><init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V

    .line 92
    return-void
.end method


# virtual methods
.method execute()V
    .locals 6

    .prologue
    .line 95
    const-string/jumbo v0, "w"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidCommandExpand;->getIntFromParamsForKey(Ljava/lang/String;)I

    move-result v2

    .line 96
    .local v2, "width":I
    const-string/jumbo v0, "h"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidCommandExpand;->getIntFromParamsForKey(Ljava/lang/String;)I

    move-result v3

    .line 97
    .local v3, "height":I
    const-string/jumbo v0, "url"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidCommandExpand;->getStringFromParamsForKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 98
    .local v1, "url":Ljava/lang/String;
    const-string/jumbo v0, "shouldUseCustomClose"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidCommandExpand;->getBooleanFromParamsForKey(Ljava/lang/String;)Z

    move-result v4

    .line 99
    .local v4, "shouldUseCustomClose":Z
    const-string/jumbo v0, "lockOrientation"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidCommandExpand;->getBooleanFromParamsForKey(Ljava/lang/String;)Z

    move-result v5

    .line 101
    .local v5, "shouldLockOrientation":Z
    if-gtz v2, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/MraidCommandExpand;->mView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v0

    iget v2, v0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenWidth:I

    .line 102
    :cond_0
    if-gtz v3, :cond_1

    iget-object v0, p0, Lcom/amazon/device/ads/MraidCommandExpand;->mView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v0

    iget v3, v0, Lcom/amazon/device/ads/MraidDisplayController;->mScreenHeight:I

    .line 104
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/ads/MraidCommandExpand;->mView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v0

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/device/ads/MraidDisplayController;->expand(Ljava/lang/String;IIZZ)V

    .line 106
    return-void
.end method

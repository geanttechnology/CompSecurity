.class Lcom/amazon/device/ads/MraidCommandUseCustomClose;
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
    .line 139
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/MraidCommand;-><init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V

    .line 140
    return-void
.end method


# virtual methods
.method execute()V
    .locals 2

    .prologue
    .line 143
    const-string/jumbo v1, "shouldUseCustomClose"

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidCommandUseCustomClose;->getBooleanFromParamsForKey(Ljava/lang/String;)Z

    move-result v0

    .line 144
    .local v0, "shouldUseCustomClose":Z
    iget-object v1, p0, Lcom/amazon/device/ads/MraidCommandUseCustomClose;->mView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/device/ads/MraidDisplayController;->useCustomClose(Z)V

    .line 145
    return-void
.end method

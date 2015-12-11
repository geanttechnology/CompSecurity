.class Lcom/amazon/device/ads/MraidCommandOpen;
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
    .line 150
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/MraidCommand;-><init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V

    .line 151
    return-void
.end method


# virtual methods
.method execute()V
    .locals 2

    .prologue
    .line 154
    const-string/jumbo v1, "url"

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidCommandOpen;->getStringFromParamsForKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 155
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/device/ads/MraidCommandOpen;->mView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->getBrowserController()Lcom/amazon/device/ads/MraidBrowserController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/device/ads/MraidBrowserController;->open(Ljava/lang/String;)V

    .line 156
    return-void
.end method

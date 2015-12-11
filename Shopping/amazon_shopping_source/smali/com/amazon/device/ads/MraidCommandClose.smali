.class Lcom/amazon/device/ads/MraidCommandClose;
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
    .line 81
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/MraidCommand;-><init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V

    .line 82
    return-void
.end method


# virtual methods
.method execute()V
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/device/ads/MraidCommandClose;->mView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->close()V

    .line 86
    return-void
.end method

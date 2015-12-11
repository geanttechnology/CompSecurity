.class final Lcom/amazon/device/ads/MraidCommandRegistry$5;
.super Ljava/lang/Object;
.source "MraidCommandRegistry.java"

# interfaces
.implements Lcom/amazon/device/ads/MraidCommandRegistry$MraidCommandFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidCommandRegistry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)Lcom/amazon/device/ads/MraidCommand;
    .locals 1
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
            ")",
            "Lcom/amazon/device/ads/MraidCommand;"
        }
    .end annotation

    .prologue
    .line 45
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/amazon/device/ads/MraidCommandPlayVideo;

    invoke-direct {v0, p1, p2}, Lcom/amazon/device/ads/MraidCommandPlayVideo;-><init>(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)V

    return-object v0
.end method

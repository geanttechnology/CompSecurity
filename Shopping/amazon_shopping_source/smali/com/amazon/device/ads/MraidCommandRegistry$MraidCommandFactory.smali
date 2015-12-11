.class interface abstract Lcom/amazon/device/ads/MraidCommandRegistry$MraidCommandFactory;
.super Ljava/lang/Object;
.source "MraidCommandRegistry.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidCommandRegistry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x60a
    name = "MraidCommandFactory"
.end annotation


# virtual methods
.method public abstract create(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)Lcom/amazon/device/ads/MraidCommand;
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
.end method

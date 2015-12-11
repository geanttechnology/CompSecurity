.class Lcom/amazon/device/ads/MraidCommandRegistry;
.super Ljava/lang/Object;
.source "MraidCommandRegistry.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/MraidCommandRegistry$MraidCommandFactory;
    }
.end annotation


# static fields
.field private static commandMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/device/ads/MraidCommandRegistry$MraidCommandFactory;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 16
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/MraidCommandRegistry;->commandMap:Ljava/util/Map;

    .line 19
    sget-object v0, Lcom/amazon/device/ads/MraidCommandRegistry;->commandMap:Ljava/util/Map;

    const-string/jumbo v1, "close"

    new-instance v2, Lcom/amazon/device/ads/MraidCommandRegistry$1;

    invoke-direct {v2}, Lcom/amazon/device/ads/MraidCommandRegistry$1;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    sget-object v0, Lcom/amazon/device/ads/MraidCommandRegistry;->commandMap:Ljava/util/Map;

    const-string/jumbo v1, "expand"

    new-instance v2, Lcom/amazon/device/ads/MraidCommandRegistry$2;

    invoke-direct {v2}, Lcom/amazon/device/ads/MraidCommandRegistry$2;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    sget-object v0, Lcom/amazon/device/ads/MraidCommandRegistry;->commandMap:Ljava/util/Map;

    const-string/jumbo v1, "usecustomclose"

    new-instance v2, Lcom/amazon/device/ads/MraidCommandRegistry$3;

    invoke-direct {v2}, Lcom/amazon/device/ads/MraidCommandRegistry$3;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    sget-object v0, Lcom/amazon/device/ads/MraidCommandRegistry;->commandMap:Ljava/util/Map;

    const-string/jumbo v1, "open"

    new-instance v2, Lcom/amazon/device/ads/MraidCommandRegistry$4;

    invoke-direct {v2}, Lcom/amazon/device/ads/MraidCommandRegistry$4;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    sget-object v0, Lcom/amazon/device/ads/MraidCommandRegistry;->commandMap:Ljava/util/Map;

    const-string/jumbo v1, "playVideo"

    new-instance v2, Lcom/amazon/device/ads/MraidCommandRegistry$5;

    invoke-direct {v2}, Lcom/amazon/device/ads/MraidCommandRegistry$5;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    sget-object v0, Lcom/amazon/device/ads/MraidCommandRegistry;->commandMap:Ljava/util/Map;

    const-string/jumbo v1, "log"

    new-instance v2, Lcom/amazon/device/ads/MraidCommandRegistry$6;

    invoke-direct {v2}, Lcom/amazon/device/ads/MraidCommandRegistry$6;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    return-void
.end method

.method static createCommand(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)Lcom/amazon/device/ads/MraidCommand;
    .locals 2
    .param p0, "string"    # Ljava/lang/String;
    .param p2, "view"    # Lcom/amazon/device/ads/MraidView;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
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
    .line 57
    .local p1, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v1, Lcom/amazon/device/ads/MraidCommandRegistry;->commandMap:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/MraidCommandRegistry$MraidCommandFactory;

    .line 58
    .local v0, "factory":Lcom/amazon/device/ads/MraidCommandRegistry$MraidCommandFactory;
    if-eqz v0, :cond_0

    invoke-interface {v0, p1, p2}, Lcom/amazon/device/ads/MraidCommandRegistry$MraidCommandFactory;->create(Ljava/util/Map;Lcom/amazon/device/ads/MraidView;)Lcom/amazon/device/ads/MraidCommand;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

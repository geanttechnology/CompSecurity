.class public abstract Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
.super Ljava/lang/Object;
.source "AbstractPlayerPlatformAnalyticsEvent.java"

# interfaces
.implements Ljava/util/EventListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public messagesFailed(Ljava/lang/String;Ljava/util/Collection;)V
    .locals 0
    .param p1, "errorMessages"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 26
    .local p2, "messages":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    return-void
.end method

.method public messagesSent(Ljava/util/Collection;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p1, "messages":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    return-void
.end method

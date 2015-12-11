.class Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$7;
.super Ljava/lang/Object;
.source "AnalyticsProvider.java"

# interfaces
.implements Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener",
        "<",
        "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;


# virtual methods
.method public onError(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 512
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "onError"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 513
    return-void
.end method

.method public onItemsRead(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 505
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "onItemsRead"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 506
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " items read from disk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 507
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$7;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->addAll(Ljava/util/Collection;)Z

    .line 508
    return-void
.end method

.class Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;
.super Ljava/lang/Object;
.source "AnalyticsProvider.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->messagesSent(Ljava/util/Collection;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;)V
    .locals 0

    .prologue
    .line 438
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;->this$1:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 441
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;->this$1:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;

    iget-object v2, v2, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->maxSize()I

    move-result v2

    iget-object v3, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;->this$1:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;

    iget-object v3, v3, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v3}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->size()I

    move-result v3

    sub-int v0, v2, v3

    .line 442
    .local v0, "itemsToRemove":I
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;->this$1:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;

    iget-object v2, v2, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$100(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->size()I

    move-result v2

    invoke-static {v0, v2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 443
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;->this$1:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;

    iget-object v2, v2, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$100(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->removeItems(I)Ljava/util/List;

    move-result-object v1

    .line 444
    .local v1, "removedItems":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;>;"
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;->this$1:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;

    iget-object v2, v2, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->addAll(Ljava/util/Collection;)Z

    .line 445
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5$1;->this$1:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;

    iget-object v2, v2, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$5;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$100(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->save()V

    .line 446
    return-void
.end method

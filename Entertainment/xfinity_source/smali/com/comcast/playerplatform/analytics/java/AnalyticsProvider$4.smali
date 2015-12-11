.class Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$4;
.super Ljava/lang/Object;
.source "AnalyticsProvider.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->saveQueue()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)V
    .locals 0

    .prologue
    .line 393
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$4;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 396
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$4;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    invoke-static {v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$100(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    move-result-object v0

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$4;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v2}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->append(Ljava/util/List;)V

    .line 397
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$4;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->messageQueue:Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;
    invoke-static {v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$000(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue;->clear()V

    .line 398
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$4;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->xuaMessageFileIo:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
    invoke-static {v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$100(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->save()V

    .line 399
    return-void
.end method

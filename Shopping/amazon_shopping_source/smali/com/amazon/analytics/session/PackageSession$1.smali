.class Lcom/amazon/analytics/session/PackageSession$1;
.super Ljava/lang/Object;
.source "PackageSession.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/analytics/session/PackageSession;->scheduleTimerTask(Lcom/amazon/analytics/util/Message;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final m:Lcom/amazon/analytics/util/Message;

.field final runId:I

.field final synthetic this$0:Lcom/amazon/analytics/session/PackageSession;

.field final synthetic val$message:Lcom/amazon/analytics/util/Message;


# direct methods
.method constructor <init>(Lcom/amazon/analytics/session/PackageSession;Lcom/amazon/analytics/util/Message;)V
    .locals 4

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/analytics/session/PackageSession$1;->this$0:Lcom/amazon/analytics/session/PackageSession;

    iput-object p2, p0, Lcom/amazon/analytics/session/PackageSession$1;->val$message:Lcom/amazon/analytics/util/Message;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    new-instance v0, Lcom/amazon/analytics/util/Message;

    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSession$1;->val$message:Lcom/amazon/analytics/util/Message;

    invoke-virtual {v1}, Lcom/amazon/analytics/util/Message;->getType()I

    move-result v1

    new-instance v2, Ljava/util/HashMap;

    iget-object v3, p0, Lcom/amazon/analytics/session/PackageSession$1;->val$message:Lcom/amazon/analytics/util/Message;

    invoke-virtual {v3}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    invoke-direct {v0, v1, v2}, Lcom/amazon/analytics/util/Message;-><init>(ILjava/util/Map;)V

    iput-object v0, p0, Lcom/amazon/analytics/session/PackageSession$1;->m:Lcom/amazon/analytics/util/Message;

    .line 78
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSession$1;->this$0:Lcom/amazon/analytics/session/PackageSession;

    invoke-virtual {v0}, Lcom/amazon/analytics/session/PackageSession;->getRunId()I

    move-result v0

    iput v0, p0, Lcom/amazon/analytics/session/PackageSession$1;->runId:I

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSession$1;->m:Lcom/amazon/analytics/util/Message;

    invoke-virtual {v0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v0

    const-string/jumbo v1, "SessionFlag"

    const/4 v2, 0x2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSession$1;->m:Lcom/amazon/analytics/util/Message;

    invoke-virtual {v0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v0

    const-string/jumbo v1, "SessionRunId"

    iget v2, p0, Lcom/amazon/analytics/session/PackageSession$1;->runId:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSession$1;->this$0:Lcom/amazon/analytics/session/PackageSession;

    iget-object v0, v0, Lcom/amazon/analytics/session/PackageSession;->sessionObserver:Lcom/amazon/analytics/session/SessionObserver;

    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSession$1;->m:Lcom/amazon/analytics/util/Message;

    invoke-virtual {v0, v1}, Lcom/amazon/analytics/session/SessionObserver;->onUpdate(Lcom/amazon/analytics/util/Message;)V

    .line 84
    return-void
.end method

.class Lnet/singular/sdk/Controller$1;
.super Ljava/lang/Object;
.source "Controller.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/Controller;->initController(Lnet/singular/sdk/SessionManager;Lnet/singular/sdk/Collector;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/Controller;

.field final synthetic val$collector:Lnet/singular/sdk/Collector;


# direct methods
.method constructor <init>(Lnet/singular/sdk/Controller;Lnet/singular/sdk/Collector;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lnet/singular/sdk/Controller$1;->this$0:Lnet/singular/sdk/Controller;

    iput-object p2, p0, Lnet/singular/sdk/Controller$1;->val$collector:Lnet/singular/sdk/Collector;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 73
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Controller$1;->this$0:Lnet/singular/sdk/Controller;

    # getter for: Lnet/singular/sdk/Controller;->countersLogger:Lnet/singular/sdk/CountersLogger;
    invoke-static {v1}, Lnet/singular/sdk/Controller;->access$000(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/CountersLogger;

    move-result-object v1

    invoke-virtual {v1}, Lnet/singular/sdk/CountersLogger;->loadSavedCounters()V

    .line 74
    iget-object v1, p0, Lnet/singular/sdk/Controller$1;->val$collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v1}, Lnet/singular/sdk/Collector;->initializeIds()V

    .line 76
    iget-object v1, p0, Lnet/singular/sdk/Controller$1;->this$0:Lnet/singular/sdk/Controller;

    iget-object v1, v1, Lnet/singular/sdk/Controller;->senderPostable:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v1}, Lnet/singular/sdk/PostableWorker;->start()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    :goto_0
    return-void

    .line 77
    :catch_0
    move-exception v0

    .line 78
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/Controller$1;->this$0:Lnet/singular/sdk/Controller;

    const-string v2, "initController() runnable"

    # invokes: Lnet/singular/sdk/Controller;->logAndReportException(Ljava/lang/Exception;Ljava/lang/String;)V
    invoke-static {v1, v0, v2}, Lnet/singular/sdk/Controller;->access$100(Lnet/singular/sdk/Controller;Ljava/lang/Exception;Ljava/lang/String;)V

    goto :goto_0
.end method

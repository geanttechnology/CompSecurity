.class Lnet/singular/sdk/Controller$2;
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


# direct methods
.method constructor <init>(Lnet/singular/sdk/Controller;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lnet/singular/sdk/Controller$2;->this$0:Lnet/singular/sdk/Controller;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 87
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Controller$2;->this$0:Lnet/singular/sdk/Controller;

    iget-object v1, v1, Lnet/singular/sdk/Controller;->senderPostable:Lnet/singular/sdk/PostableWorker;

    iget-object v2, p0, Lnet/singular/sdk/Controller$2;->this$0:Lnet/singular/sdk/Controller;

    iget-object v2, v2, Lnet/singular/sdk/Controller;->senderRunnable:Ljava/lang/Runnable;

    invoke-virtual {v1, v2}, Lnet/singular/sdk/PostableWorker;->removeCallback(Ljava/lang/Runnable;)V

    .line 88
    iget-object v1, p0, Lnet/singular/sdk/Controller$2;->this$0:Lnet/singular/sdk/Controller;

    # invokes: Lnet/singular/sdk/Controller;->senderMethod()V
    invoke-static {v1}, Lnet/singular/sdk/Controller;->access$200(Lnet/singular/sdk/Controller;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 92
    :goto_0
    return-void

    .line 89
    :catch_0
    move-exception v0

    .line 90
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/Controller$2;->this$0:Lnet/singular/sdk/Controller;

    const-string v2, "senderMethod()"

    # invokes: Lnet/singular/sdk/Controller;->logException(Ljava/lang/Exception;Ljava/lang/String;)V
    invoke-static {v1, v0, v2}, Lnet/singular/sdk/Controller;->access$300(Lnet/singular/sdk/Controller;Ljava/lang/Exception;Ljava/lang/String;)V

    goto :goto_0
.end method

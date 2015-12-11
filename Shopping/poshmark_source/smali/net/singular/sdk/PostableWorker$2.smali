.class Lnet/singular/sdk/PostableWorker$2;
.super Ljava/lang/Object;
.source "PostableWorker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/PostableWorker;->blockThreadUntilStarted()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/PostableWorker;


# direct methods
.method constructor <init>(Lnet/singular/sdk/PostableWorker;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lnet/singular/sdk/PostableWorker$2;->this$0:Lnet/singular/sdk/PostableWorker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 45
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker$2;->this$0:Lnet/singular/sdk/PostableWorker;

    # getter for: Lnet/singular/sdk/PostableWorker;->runnable_semaphore:Ljava/util/concurrent/Semaphore;
    invoke-static {v0}, Lnet/singular/sdk/PostableWorker;->access$000(Lnet/singular/sdk/PostableWorker;)Ljava/util/concurrent/Semaphore;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/Semaphore;->acquire()V

    .line 46
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker$2;->this$0:Lnet/singular/sdk/PostableWorker;

    # getter for: Lnet/singular/sdk/PostableWorker;->runnable_semaphore:Ljava/util/concurrent/Semaphore;
    invoke-static {v0}, Lnet/singular/sdk/PostableWorker;->access$000(Lnet/singular/sdk/PostableWorker;)Ljava/util/concurrent/Semaphore;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/Semaphore;->release()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 48
    :goto_0
    return-void

    .line 47
    :catch_0
    move-exception v0

    goto :goto_0
.end method

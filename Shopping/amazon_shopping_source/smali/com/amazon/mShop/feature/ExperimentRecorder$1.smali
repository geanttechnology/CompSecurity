.class Lcom/amazon/mShop/feature/ExperimentRecorder$1;
.super Ljava/lang/Object;
.source "ExperimentRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/feature/ExperimentRecorder;->getTreatment(Ljava/lang/String;ZJ)Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/feature/ExperimentRecorder;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/ExperimentRecorder;)V
    .locals 0

    .prologue
    .line 151
    iput-object p1, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$1;->this$0:Lcom/amazon/mShop/feature/ExperimentRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 155
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$1;->this$0:Lcom/amazon/mShop/feature/ExperimentRecorder;

    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder;->running:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v1}, Lcom/amazon/mShop/feature/ExperimentRecorder;->access$400(Lcom/amazon/mShop/feature/ExperimentRecorder;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    .line 156
    iget-object v1, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$1;->this$0:Lcom/amazon/mShop/feature/ExperimentRecorder;

    # invokes: Lcom/amazon/mShop/feature/ExperimentRecorder;->sendEvents()V
    invoke-static {v1}, Lcom/amazon/mShop/feature/ExperimentRecorder;->access$500(Lcom/amazon/mShop/feature/ExperimentRecorder;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 160
    :goto_0
    return-void

    .line 157
    :catch_0
    move-exception v0

    .line 158
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/ExperimentRecorder;->access$600()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Failed to send events"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

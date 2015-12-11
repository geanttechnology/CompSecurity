.class Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;
.super Ljava/lang/Object;
.source "BoundServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RunnableBoundServiceCallback"
.end annotation


# instance fields
.field private final mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<TT;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 325
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;"
    .local p2, "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<TT;>;"
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 326
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    .line 327
    return-void
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;)Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;

    .prologue
    .line 320
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 333
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;"
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    monitor-enter v2

    .line 335
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBoundService:Ljava/lang/Object;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$000(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Ljava/lang/Object;

    move-result-object v0

    .line 336
    .local v0, "service":Ljava/lang/Object;, "TT;"
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 337
    if-nez v0, :cond_0

    .line 340
    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Service was disconnected before task could execute; re-enqueuing task to run after service re-connects."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    # invokes: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->callbackWhenServiceIsAvailable(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$600(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    .line 354
    :goto_0
    return-void

    .line 336
    .end local v0    # "service":Ljava/lang/Object;, "TT;"
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 348
    .restart local v0    # "service":Ljava/lang/Object;, "TT;"
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    invoke-virtual {v1, v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;->useService(Ljava/lang/Object;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 352
    :catch_0
    move-exception v1

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;->onError()V

    goto :goto_0
.end method

.class Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;
.super Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;
.source "SyncBoundServiceCaller.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;-><init>(Landroid/content/Context;Landroid/content/Intent;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;Landroid/content/Context;Landroid/content/Intent;I)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;
    .param p3, "x1"    # Landroid/content/Intent;
    .param p4, "x2"    # I

    .prologue
    .line 29
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;

    invoke-direct {p0, p2, p3, p4}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;-><init>(Landroid/content/Context;Landroid/content/Intent;I)V

    return-void
.end method


# virtual methods
.method protected useService(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 2
    .param p1, "componentName"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 35
    # getter for: Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->THREAD_POOL:Ljava/util/concurrent/Executor;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->access$000()Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;-><init>(Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;Landroid/content/ComponentName;Landroid/os/IBinder;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 43
    return-void
.end method

.method protected useService(Landroid/os/IBinder;)V
    .locals 0
    .param p1, "service"    # Landroid/os/IBinder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 49
    return-void
.end method

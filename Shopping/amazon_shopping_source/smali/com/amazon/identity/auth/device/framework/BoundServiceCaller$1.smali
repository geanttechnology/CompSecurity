.class Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;
.super Ljava/lang/Object;
.source "BoundServiceCaller.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;-><init>(Landroid/content/Context;Landroid/content/Intent;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 5
    .param p1, "componentName"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 51
    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$000()Ljava/lang/String;

    const-string/jumbo v0, "Connected to service: %s"

    new-array v1, v3, [Ljava/lang/Object;

    invoke-virtual {p1}, Landroid/content/ComponentName;->toString()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 53
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    # setter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceConnectionWasEstablished:Z
    invoke-static {v0, v3}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$102(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;Z)Z

    .line 57
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->useService(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 64
    :goto_0
    return-void

    .line 61
    :catch_0
    move-exception v0

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Service died: %s"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {p1}, Landroid/content/ComponentName;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->unbind()V

    goto :goto_0
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 4
    .param p1, "componentName"    # Landroid/content/ComponentName;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mLocker:[Ljava/lang/Object;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$200(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)[Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 71
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    const/4 v2, 0x0

    # setter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;
    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$302(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;Landroid/content/ServiceConnection;)Landroid/content/ServiceConnection;

    .line 72
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 73
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->serviceDisconnected()V

    .line 74
    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$000()Ljava/lang/String;

    const-string/jumbo v0, "Disconnected from service: %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/content/ComponentName;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 75
    return-void

    .line 72
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

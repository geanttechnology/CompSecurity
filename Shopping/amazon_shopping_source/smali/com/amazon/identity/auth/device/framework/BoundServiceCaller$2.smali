.class Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;
.super Ljava/lang/Object;
.source "BoundServiceCaller.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->call()Z
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
    .line 116
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mLocker:[Ljava/lang/Object;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$200(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)[Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 122
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceConnectionWasEstablished:Z
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$100(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 124
    monitor-exit v1

    .line 133
    :goto_0
    return-void

    .line 127
    :cond_0
    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v2, "Application timed out trying to bind to %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mServiceIntent:Landroid/content/Intent;
    invoke-static {v5}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$400(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;)Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Intent;->getComponent()Landroid/content/ComponentName;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    const/4 v2, 0x0

    # setter for: Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->mConnection:Landroid/content/ServiceConnection;
    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->access$302(Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;Landroid/content/ServiceConnection;)Landroid/content/ServiceConnection;

    .line 130
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 132
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller$2;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceCaller;->serviceTimedOut()V

    goto :goto_0

    .line 130
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

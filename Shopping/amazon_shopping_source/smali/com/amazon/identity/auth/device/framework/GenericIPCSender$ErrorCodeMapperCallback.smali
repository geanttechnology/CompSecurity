.class final Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;
.super Ljava/lang/Object;
.source "GenericIPCSender.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/GenericIPCSender;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ErrorCodeMapperCallback"
.end annotation


# instance fields
.field mFirstCallbackMethod:Ljava/lang/String;

.field final mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;


# direct methods
.method private constructor <init>(Lcom/amazon/identity/auth/device/framework/GenericIPCSender;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0
    .param p2, "innerCallback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 108
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->this$0:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 110
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/device/framework/GenericIPCSender;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/device/framework/GenericIPCSender;
    .param p2, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "x2"    # Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;

    .prologue
    .line 102
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;-><init>(Lcom/amazon/identity/auth/device/framework/GenericIPCSender;Lcom/amazon/identity/auth/device/api/Callback;)V

    return-void
.end method

.method private declared-synchronized claimCallback(Ljava/lang/String;)Z
    .locals 3
    .param p1, "callbackMethod"    # Ljava/lang/String;

    .prologue
    .line 146
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->mFirstCallbackMethod:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 148
    # getter for: Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->access$100()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Duplicate callback detected: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " called after "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->mFirstCallbackMethod:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 150
    const/4 v0, 0x0

    .line 155
    :goto_0
    monitor-exit p0

    return v0

    .line 154
    :cond_0
    :try_start_1
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->mFirstCallbackMethod:Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 155
    const/4 v0, 0x1

    goto :goto_0

    .line 146
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 131
    const-string/jumbo v0, "onError"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->claimCallback(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 142
    :cond_0
    :goto_0
    return-void

    .line 136
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

    if-eqz v0, :cond_0

    .line 141
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->this$0:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    # invokes: Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->mapErrorKeysInBundle(Landroid/os/Bundle;)Landroid/os/Bundle;
    invoke-static {v1, p1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->access$000(Lcom/amazon/identity/auth/device/framework/GenericIPCSender;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 115
    const-string/jumbo v0, "onSuccess"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->claimCallback(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 126
    :cond_0
    :goto_0
    return-void

    .line 120
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$ErrorCodeMapperCallback;->mInnerCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0
.end method

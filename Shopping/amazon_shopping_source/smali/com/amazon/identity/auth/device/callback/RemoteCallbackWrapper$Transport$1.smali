.class Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$1;
.super Ljava/lang/Object;
.source "RemoteCallbackWrapper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;->onSuccess(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;

.field final synthetic val$result:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$1;->this$0:Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$1;->val$result:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$1;->this$0:Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;

    # getter for: Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;->mCallback:Lcom/amazon/identity/auth/device/api/Callback;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;->access$000(Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/callback/RemoteCallbackWrapper$Transport$1;->val$result:Landroid/os/Bundle;

    invoke-interface {v0, v1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 38
    return-void
.end method

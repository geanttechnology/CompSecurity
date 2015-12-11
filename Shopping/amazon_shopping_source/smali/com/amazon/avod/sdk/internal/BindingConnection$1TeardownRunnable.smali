.class final Lcom/amazon/avod/sdk/internal/BindingConnection$1TeardownRunnable;
.super Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;
.source "BindingConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/sdk/internal/BindingConnection;->teardownPreparedVideo(Lcom/amazon/avod/sdk/ResponseHandler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "TeardownRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

.field final synthetic val$handler:Lcom/amazon/avod/sdk/ResponseHandler;


# direct methods
.method public constructor <init>(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/ResponseHandler;)V
    .locals 1
    .param p2, "bindingConnection"    # Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;",
            ")V"
        }
    .end annotation

    .prologue
    .line 174
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1TeardownRunnable;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1TeardownRunnable;->val$handler:Lcom/amazon/avod/sdk/ResponseHandler;

    .line 175
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/internal/BindingConnection$1;)V

    .line 176
    return-void
.end method


# virtual methods
.method public run(Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;)V
    .locals 2
    .param p1, "aivPlaybackSdk"    # Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 180
    invoke-interface {p1}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;->teardownPreparedVideo()V

    .line 181
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1TeardownRunnable;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1TeardownRunnable;->val$handler:Lcom/amazon/avod/sdk/ResponseHandler;

    # invokes: Lcom/amazon/avod/sdk/internal/BindingConnection;->sendDefaultSuccessResponse(Lcom/amazon/avod/sdk/ResponseHandler;)V
    invoke-static {v0, v1}, Lcom/amazon/avod/sdk/internal/BindingConnection;->access$400(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/ResponseHandler;)V

    .line 182
    return-void
.end method

.class final Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;
.super Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;
.source "BindingConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/sdk/internal/BindingConnection;->queryPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "QueryPlaybackSupportRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

.field final synthetic val$callback:Lcom/amazon/avod/sdk/PlaybackSupportResponse;


# direct methods
.method public constructor <init>(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V
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
    .line 106
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;->val$callback:Lcom/amazon/avod/sdk/PlaybackSupportResponse;

    .line 107
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/internal/BindingConnection$1;)V

    .line 108
    return-void
.end method


# virtual methods
.method public run(Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;)V
    .locals 5
    .param p1, "aivPlaybackSdk"    # Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 112
    invoke-interface {p1}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;->isPlaybackSupported()Z

    move-result v0

    .line 113
    .local v0, "isSupported":Z
    invoke-interface {p1}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;->isPlaybackSustainable()Z

    move-result v1

    .line 114
    .local v1, "isSustainable":Z
    invoke-static {v0, v1}, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport$Factory;->newPlaybackSupport(ZZ)Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    move-result-object v2

    .line 115
    .local v2, "support":Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;
    iget-object v3, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    # getter for: Lcom/amazon/avod/sdk/internal/BindingConnection;->mUiHandler:Landroid/os/Handler;
    invoke-static {v3}, Lcom/amazon/avod/sdk/internal/BindingConnection;->access$200(Lcom/amazon/avod/sdk/internal/BindingConnection;)Landroid/os/Handler;

    move-result-object v3

    new-instance v4, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable$1;

    invoke-direct {v4, p0, v2}, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable$1;-><init>(Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 121
    return-void
.end method

.class final Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;
.super Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;
.source "BindingConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/sdk/internal/BindingConnection;->playVideo(Ljava/lang/String;Ljava/util/Map;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "PlayVideoRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

.field final synthetic val$asin:Ljava/lang/String;

.field final synthetic val$bundle:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Ljava/lang/String;Landroid/os/Bundle;)V
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
    .line 140
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;->val$asin:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;->val$bundle:Landroid/os/Bundle;

    .line 141
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/internal/BindingConnection$1;)V

    .line 142
    return-void
.end method


# virtual methods
.method public run(Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;)V
    .locals 3
    .param p1, "aivPlaybackSdk"    # Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 146
    new-instance v0, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    # getter for: Lcom/amazon/avod/sdk/internal/BindingConnection;->mEventListener:Lcom/amazon/avod/sdk/PlaybackStateEventListener;
    invoke-static {v1}, Lcom/amazon/avod/sdk/internal/BindingConnection;->access$300(Lcom/amazon/avod/sdk/internal/BindingConnection;)Lcom/amazon/avod/sdk/PlaybackStateEventListener;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;-><init>(Lcom/amazon/avod/sdk/PlaybackStateEventListener;)V

    .line 147
    .local v0, "eventDelegate":Lcom/amazon/avod/sdk/internal/PlaybackEventResponseDelegate;
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;->val$asin:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1PlayVideoRunnable;->val$bundle:Landroid/os/Bundle;

    invoke-interface {p1, v1, v2, v0}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;->startPlayback(Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventResponse;)V

    .line 148
    return-void
.end method

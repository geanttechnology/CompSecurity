.class Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable$1;
.super Ljava/lang/Object;
.source "BindingConnection.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;->run(Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;

.field final synthetic val$support:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;


# direct methods
.method constructor <init>(Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable$1;->this$1:Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;

    iput-object p2, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable$1;->val$support:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable$1;->this$1:Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;

    iget-object v0, v0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable;->val$callback:Lcom/amazon/avod/sdk/PlaybackSupportResponse;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1QueryPlaybackSupportRunnable$1;->val$support:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    invoke-interface {v0, v1}, Lcom/amazon/avod/sdk/PlaybackSupportResponse;->onPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;)V

    .line 119
    return-void
.end method

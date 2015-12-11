.class Lcom/amazon/avod/sdk/internal/IntentConnection$1;
.super Ljava/lang/Object;
.source "IntentConnection.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/sdk/internal/IntentConnection;->queryPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/avod/sdk/internal/IntentConnection;

.field final synthetic val$callback:Lcom/amazon/avod/sdk/PlaybackSupportResponse;

.field final synthetic val$support:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;


# direct methods
.method constructor <init>(Lcom/amazon/avod/sdk/internal/IntentConnection;Lcom/amazon/avod/sdk/PlaybackSupportResponse;Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$1;->this$0:Lcom/amazon/avod/sdk/internal/IntentConnection;

    iput-object p2, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$1;->val$callback:Lcom/amazon/avod/sdk/PlaybackSupportResponse;

    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$1;->val$support:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$1;->val$callback:Lcom/amazon/avod/sdk/PlaybackSupportResponse;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$1;->val$support:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    invoke-interface {v0, v1}, Lcom/amazon/avod/sdk/PlaybackSupportResponse;->onPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;)V

    .line 110
    return-void
.end method

.class final Lcom/amazon/avod/sdk/internal/BindingConnection$1WhisperCacheRunnable;
.super Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;
.source "BindingConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/sdk/internal/BindingConnection;->whisperCacheContent(Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "WhisperCacheRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

.field final synthetic val$asins:Ljava/util/List;

.field final synthetic val$cacheLevel:Lcom/amazon/avod/sdk/CacheLevel;


# direct methods
.method public constructor <init>(Lcom/amazon/avod/sdk/internal/BindingConnection;Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V
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
    .line 201
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1WhisperCacheRunnable;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1WhisperCacheRunnable;->val$asins:Ljava/util/List;

    iput-object p4, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1WhisperCacheRunnable;->val$cacheLevel:Lcom/amazon/avod/sdk/CacheLevel;

    .line 202
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/amazon/avod/sdk/internal/BindingConnection$SdkRunnable;-><init>(Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;Lcom/amazon/avod/sdk/internal/BindingConnection$1;)V

    .line 203
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
    .line 207
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1WhisperCacheRunnable;->val$asins:Ljava/util/List;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1WhisperCacheRunnable;->val$cacheLevel:Lcom/amazon/avod/sdk/CacheLevel;

    invoke-virtual {v1}, Lcom/amazon/avod/sdk/CacheLevel;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lcom/amazon/avod/sdk/internal/aidl/AivPlaybackSdk;->whisperCacheContent(Ljava/util/List;Ljava/lang/String;)V

    .line 208
    return-void
.end method

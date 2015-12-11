.class Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable$1;
.super Ljava/lang/Object;
.source "AmazonInstantVideoProxy.java"

# interfaces
.implements Lcom/amazon/avod/sdk/PlaybackSupportResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable$1;->this$1:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;)V
    .locals 2
    .param p1, "support"    # Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable$1;->this$1:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;

    iget-object v0, v0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    invoke-virtual {p1}, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;->isPlaybackSupported()Z

    move-result v1

    # setter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mIsSupported:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$402(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Z)Z

    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable$1;->this$1:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;

    iget-object v0, v0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    invoke-virtual {p1}, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;->isPlaybackSustainable()Z

    move-result v1

    # setter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mIsSustainable:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$502(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Z)Z

    .line 98
    return-void
.end method

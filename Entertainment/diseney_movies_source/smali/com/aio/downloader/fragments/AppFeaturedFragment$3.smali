.class Lcom/aio/downloader/fragments/AppFeaturedFragment$3;
.super Ljava/lang/Object;
.source "AppFeaturedFragment.java"

# interfaces
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/AppFeaturedFragment;->facebookbanner()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/AppFeaturedFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/AppFeaturedFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/AppFeaturedFragment$3;->this$0:Lcom/aio/downloader/fragments/AppFeaturedFragment;

    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "ad"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 146
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "ad"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 141
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 2
    .param p1, "ad"    # Lcom/facebook/ads/Ad;
    .param p2, "error"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 132
    const-string v0, "rtrtr"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    return-void
.end method

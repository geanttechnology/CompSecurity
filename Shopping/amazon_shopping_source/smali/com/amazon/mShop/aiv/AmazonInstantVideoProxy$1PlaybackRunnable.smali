.class final Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;
.super Ljava/lang/Object;
.source "AmazonInstantVideoProxy.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->playContent(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "PlaybackRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$asin:Ljava/lang/String;

.field final synthetic val$timecode:J

.field final synthetic val$urlType:Lcom/amazon/avod/sdk/Constants$UrlType;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;J)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 189
    iput-object p1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    iput-object p2, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->val$activity:Landroid/app/Activity;

    iput-object p3, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->val$asin:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->val$urlType:Lcom/amazon/avod/sdk/Constants$UrlType;

    iput-wide p5, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->val$timecode:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 192
    iget-object v1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    # getter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;
    invoke-static {v1}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$200(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;)Lcom/amazon/avod/MShopAmazonInstantVideo;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/avod/MShopAmazonInstantVideo;->refreshUserData()V

    .line 194
    new-instance v0, Lcom/amazon/avod/sdk/AmazonInstantVideo;

    iget-object v1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->val$activity:Landroid/app/Activity;

    invoke-direct {v0, v1}, Lcom/amazon/avod/sdk/AmazonInstantVideo;-><init>(Landroid/content/Context;)V

    .line 195
    .local v0, "sdkLauncher":Lcom/amazon/avod/sdk/AmazonInstantVideo;
    iget-object v1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->val$asin:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->val$urlType:Lcom/amazon/avod/sdk/Constants$UrlType;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/avod/sdk/AmazonInstantVideo;->play(Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;)Lcom/amazon/avod/sdk/VideoPlaybackStarter;

    move-result-object v1

    const-string/jumbo v2, "sdk_3p"

    invoke-virtual {v1, v2}, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->withRefMarker(Ljava/lang/String;)Lcom/amazon/avod/sdk/VideoPlaybackStarter;

    move-result-object v1

    iget-wide v2, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1PlaybackRunnable;->val$timecode:J

    invoke-virtual {v1, v2, v3}, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->withResumeTimecode(J)Lcom/amazon/avod/sdk/VideoPlaybackStarter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->start()V

    .line 199
    invoke-virtual {v0}, Lcom/amazon/avod/sdk/AmazonInstantVideo;->cleanup()V

    .line 200
    return-void
.end method

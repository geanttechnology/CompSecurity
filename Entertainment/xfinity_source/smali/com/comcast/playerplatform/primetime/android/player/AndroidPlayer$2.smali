.class Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$2;
.super Ljava/lang/Object;
.source "AndroidPlayer.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 2
    .param p1, "mediaErrorCode"    # Lcom/adobe/ave/MediaErrorCode;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 111
    const-string v0, "yourface"

    const-string v1, "uhoh something went wrong"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 113
    return-void
.end method

.method public onLoadComplete(Lcom/adobe/mediacore/MediaPlayerItem;)V
    .locals 2
    .param p1, "playerItem"    # Lcom/adobe/mediacore/MediaPlayerItem;

    .prologue
    .line 116
    const-string v0, "yourface"

    const-string v1, "yaya"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 118
    return-void
.end method

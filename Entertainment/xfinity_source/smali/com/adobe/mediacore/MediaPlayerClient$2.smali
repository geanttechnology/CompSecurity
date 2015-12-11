.class Lcom/adobe/mediacore/MediaPlayerClient$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/MediaPlayerClient;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/MediaPlayerClient;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerClient$2;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 0

    return-void
.end method

.method public onAdBreakSkipped(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 0

    return-void
.end method

.method public onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 0

    return-void
.end method

.method public onAdClick(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdClick;)V
    .locals 0

    return-void
.end method

.method public onAdComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 0

    return-void
.end method

.method public onAdProgress(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V
    .locals 0

    return-void
.end method

.method public onAdStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 0

    return-void
.end method

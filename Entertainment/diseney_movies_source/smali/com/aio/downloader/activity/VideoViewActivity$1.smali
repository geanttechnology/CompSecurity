.class Lcom/aio/downloader/activity/VideoViewActivity$1;
.super Ljava/lang/Object;
.source "VideoViewActivity.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/VideoViewActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoViewActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoViewActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoViewActivity$1;->this$0:Lcom/aio/downloader/activity/VideoViewActivity;

    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 1
    .param p1, "arg0"    # Landroid/media/MediaPlayer;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoViewActivity$1;->this$0:Lcom/aio/downloader/activity/VideoViewActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/VideoViewActivity;->finish()V

    .line 65
    return-void
.end method

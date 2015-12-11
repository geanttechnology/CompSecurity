.class Lcom/adobe/mediacore/DefaultMediaPlayer$4;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/ContentPlacementCompletedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/DefaultMediaPlayer;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$4;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$4;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$400(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerClient;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$4;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$400(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->doneInitialResolving()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$4;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->endAdResolving()V

    :cond_0
    return-void
.end method

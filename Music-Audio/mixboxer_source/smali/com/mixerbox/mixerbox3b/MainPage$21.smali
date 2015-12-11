.class Lcom/mixerbox/mixerbox3b/MainPage$21;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1402
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 1405
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentTime:I

    const/4 v1, 0x5

    if-lt v0, v1, :cond_0

    .line 1406
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:seekTo(0)"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1415
    :goto_0
    return-void

    .line 1408
    :cond_0
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_REPEAT:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 1409
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    add-int/lit8 v1, v1, -0x1

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 1410
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 1411
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 1413
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$21;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->playPreviousSong()V

    goto :goto_0
.end method

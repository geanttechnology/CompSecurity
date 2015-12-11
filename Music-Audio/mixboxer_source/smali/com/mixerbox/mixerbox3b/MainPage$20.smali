.class Lcom/mixerbox/mixerbox3b/MainPage$20;
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
    .line 1393
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$20;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 1396
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_REPEAT:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$20;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 1397
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$20;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$20;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    add-int/lit8 v1, v1, 0x1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$20;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    rem-int/2addr v1, v2

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 1398
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$20;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->playNextSong()V

    .line 1399
    return-void
.end method

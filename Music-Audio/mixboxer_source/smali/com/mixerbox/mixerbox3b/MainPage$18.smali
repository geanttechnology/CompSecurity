.class Lcom/mixerbox/mixerbox3b/MainPage$18;
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
    .line 1372
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$18;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1375
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$18;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 1376
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$18;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 1377
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$18;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setUnFullScreen(Z)V

    .line 1379
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$18;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->closePlayer()V

    .line 1380
    return-void
.end method

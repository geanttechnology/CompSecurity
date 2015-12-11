.class Lcom/mixerbox/mixerbox3b/MainPage$25;
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
    .line 1470
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$25;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 1473
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$25;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_0

    .line 1474
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$25;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setFullScreen()V

    .line 1478
    :goto_0
    return-void

    .line 1476
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$25;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setUnFullScreen(Z)V

    goto :goto_0
.end method

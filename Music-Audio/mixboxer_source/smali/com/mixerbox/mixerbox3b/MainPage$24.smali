.class Lcom/mixerbox/mixerbox3b/MainPage$24;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$btnShuffle:Landroid/widget/ImageButton;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/widget/ImageButton;)V
    .locals 0

    .prologue
    .line 1446
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->val$btnShuffle:Landroid/widget/ImageButton;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1449
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 1450
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v4, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 1451
    sget-boolean v0, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_SHUFFLE:Z

    if-eqz v0, :cond_0

    .line 1452
    sput-boolean v3, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_SHUFFLE:Z

    .line 1453
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->val$btnShuffle:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020109

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1454
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080094

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 1466
    :goto_0
    return-void

    .line 1456
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleCount:I

    .line 1457
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->genShuffleIndexArray()V
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$300(Lcom/mixerbox/mixerbox3b/MainPage;)V

    .line 1458
    sput-boolean v4, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_SHUFFLE:Z

    .line 1459
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->val$btnShuffle:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f02010a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1461
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$24;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080095

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 1463
    const/16 v1, 0x10

    invoke-virtual {v0, v1, v3, v3}, Landroid/widget/Toast;->setGravity(III)V

    .line 1464
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

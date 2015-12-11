.class Lcom/mixerbox/mixerbox3b/MainPage$17;
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
    .line 1355
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x1

    .line 1358
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v3, :cond_0

    .line 1359
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    invoke-virtual {v0, v3}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 1360
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v3, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 1362
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v0

    if-ne v0, v4, :cond_1

    .line 1363
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1364
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200d3

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1369
    :goto_0
    return-void

    .line 1366
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1367
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$17;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200db

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.class Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field mActivity:Ljava/lang/ref/WeakReference;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 1

    .prologue
    .line 1686
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 1687
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->mActivity:Ljava/lang/ref/WeakReference;

    .line 1688
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6

    .prologue
    const/16 v5, 0x12c

    const/4 v4, 0x0

    .line 1692
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->mActivity:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    .line 1693
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 1694
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 1740
    :cond_0
    :goto_0
    return-void

    .line 1696
    :pswitch_0
    sget-boolean v1, Lcom/mixerbox/mixerbox3b/MainPage;->isPageLoaded:Z

    if-nez v1, :cond_0

    .line 1697
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setVideoPlayer()V

    goto :goto_0

    .line 1701
    :pswitch_1
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 1702
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1703
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    invoke-virtual {v2}, Landroid/widget/ImageButton;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0200db

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1705
    const/high16 v1, -0x40800000    # -1.0f

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;
    invoke-static {v5, v4, v4, v4, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->access$400(IFFFF)Landroid/view/animation/Animation;

    move-result-object v1

    .line 1706
    new-instance v2, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler$1;

    invoke-direct {v2, p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler$1;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 1720
    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 1721
    const/high16 v1, 0x3f800000    # 1.0f

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;
    invoke-static {v5, v4, v4, v4, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->access$400(IFFFF)Landroid/view/animation/Animation;

    move-result-object v1

    .line 1722
    new-instance v2, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler$2;

    invoke-direct {v2, p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler$2;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 1736
    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 1694
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

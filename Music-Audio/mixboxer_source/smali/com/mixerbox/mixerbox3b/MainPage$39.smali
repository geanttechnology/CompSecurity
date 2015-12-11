.class Lcom/mixerbox/mixerbox3b/MainPage$39;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 2834
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/high16 v6, -0x40800000    # -1.0f

    const/16 v5, 0x12c

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 2837
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 2838
    if-eq v0, v4, :cond_0

    .line 2893
    :goto_0
    return v4

    .line 2840
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v4, :cond_1

    .line 2841
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 2842
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v4, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 2844
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_3

    .line 2845
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 2846
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 2847
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;
    invoke-static {v5, v3, v3, v6, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->access$400(IFFFF)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 2848
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200d3

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 2853
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2854
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;
    invoke-static {v5, v3, v3, v6, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->access$400(IFFFF)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 2855
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2856
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    const/high16 v1, 0x3f800000    # 1.0f

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;
    invoke-static {v5, v3, v3, v1, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->access$400(IFFFF)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 2850
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 2851
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200db

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 2859
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 2860
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200db

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 2861
    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;
    invoke-static {v5, v3, v3, v3, v6}, Lcom/mixerbox/mixerbox3b/MainPage;->access$400(IFFFF)Landroid/view/animation/Animation;

    move-result-object v0

    .line 2862
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$39$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$39$1;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$39;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 2876
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 2877
    const/high16 v0, 0x3f800000    # 1.0f

    # invokes: Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;
    invoke-static {v5, v3, v3, v3, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$400(IFFFF)Landroid/view/animation/Animation;

    move-result-object v0

    .line 2878
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$39$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$39$2;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$39;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 2892
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$39;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_0
.end method

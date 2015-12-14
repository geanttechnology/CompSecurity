.class Lcom/livemixtapes/ui/widgets/SearchView$10;
.super Landroid/view/animation/Animation;
.source "SearchView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/ui/widgets/SearchView;->startAnimation(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/ui/widgets/SearchView;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ui/widgets/SearchView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    .line 287
    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 6
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    const/high16 v5, 0x42480000    # 50.0f

    .line 290
    iget-object v3, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->layoutPanel:Landroid/widget/RelativeLayout;
    invoke-static {v3}, Lcom/livemixtapes/ui/widgets/SearchView;->access$0(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/RelativeLayout;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout$LayoutParams;

    .line 291
    .local v2, "params":Landroid/widget/RelativeLayout$LayoutParams;
    iget-object v3, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->context:Landroid/content/Context;
    invoke-static {v3}, Lcom/livemixtapes/ui/widgets/SearchView;->access$8(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/content/Context;

    move-result-object v3

    mul-float v4, v5, p1

    sub-float v4, v5, v4

    invoke-static {v3, v4}, Lcom/livemixtapes/utils/Utility;->dpToPixel(Landroid/content/Context;F)F

    move-result v0

    .line 292
    .local v0, "marginOffset":F
    float-to-int v3, v0

    iput v3, v2, Landroid/widget/RelativeLayout$LayoutParams;->rightMargin:I

    .line 293
    iget-object v3, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->layoutPanel:Landroid/widget/RelativeLayout;
    invoke-static {v3}, Lcom/livemixtapes/ui/widgets/SearchView;->access$0(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/RelativeLayout;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 295
    iget-object v3, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    iget v3, v3, Lcom/livemixtapes/ui/widgets/SearchView;->widthPanel:I

    iget-object v4, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    iget v4, v4, Lcom/livemixtapes/ui/widgets/SearchView;->widthHint:I

    sub-int/2addr v3, v4

    int-to-float v3, v3

    sub-float/2addr v3, v0

    const/high16 v4, 0x41a00000    # 20.0f

    sub-float/2addr v3, v4

    float-to-int v1, v3

    .line 296
    .local v1, "maxMargin":I
    iget-object v3, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->layoutHint:Landroid/widget/LinearLayout;
    invoke-static {v3}, Lcom/livemixtapes/ui/widgets/SearchView;->access$1(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .end local v2    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    check-cast v2, Landroid/widget/RelativeLayout$LayoutParams;

    .line 297
    .restart local v2    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    iget-object v3, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    iget v3, v3, Lcom/livemixtapes/ui/widgets/SearchView;->widthHint:I

    int-to-float v3, v3

    int-to-float v4, v1

    int-to-float v5, v1

    mul-float/2addr v5, p1

    sub-float/2addr v4, v5

    add-float v0, v3, v4

    .line 298
    float-to-int v3, v0

    iput v3, v2, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    .line 299
    iget-object v3, p0, Lcom/livemixtapes/ui/widgets/SearchView$10;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->layoutHint:Landroid/widget/LinearLayout;
    invoke-static {v3}, Lcom/livemixtapes/ui/widgets/SearchView;->access$1(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 300
    return-void
.end method

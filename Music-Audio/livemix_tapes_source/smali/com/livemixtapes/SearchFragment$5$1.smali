.class Lcom/livemixtapes/SearchFragment$5$1;
.super Landroid/view/animation/Animation;
.source "SearchFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SearchFragment$5;->onBeforeExpand(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/SearchFragment$5;

.field private final synthetic val$expand:Z


# direct methods
.method constructor <init>(Lcom/livemixtapes/SearchFragment$5;Z)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$5$1;->this$1:Lcom/livemixtapes/SearchFragment$5;

    iput-boolean p2, p0, Lcom/livemixtapes/SearchFragment$5$1;->val$expand:Z

    .line 92
    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 5
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    const/high16 v4, 0x42480000    # 50.0f

    .line 95
    iget-object v2, p0, Lcom/livemixtapes/SearchFragment$5$1;->this$1:Lcom/livemixtapes/SearchFragment$5;

    # getter for: Lcom/livemixtapes/SearchFragment$5;->this$0:Lcom/livemixtapes/SearchFragment;
    invoke-static {v2}, Lcom/livemixtapes/SearchFragment$5;->access$0(Lcom/livemixtapes/SearchFragment$5;)Lcom/livemixtapes/SearchFragment;

    move-result-object v2

    iget-object v2, v2, Lcom/livemixtapes/SearchFragment;->layoutHeader:Landroid/widget/RelativeLayout;

    invoke-virtual {v2}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 96
    .local v1, "params":Landroid/widget/LinearLayout$LayoutParams;
    const/4 v0, 0x0

    .line 97
    .local v0, "height":F
    iget-boolean v2, p0, Lcom/livemixtapes/SearchFragment$5$1;->val$expand:Z

    if-eqz v2, :cond_0

    .line 98
    iget-object v2, p0, Lcom/livemixtapes/SearchFragment$5$1;->this$1:Lcom/livemixtapes/SearchFragment$5;

    # getter for: Lcom/livemixtapes/SearchFragment$5;->this$0:Lcom/livemixtapes/SearchFragment;
    invoke-static {v2}, Lcom/livemixtapes/SearchFragment$5;->access$0(Lcom/livemixtapes/SearchFragment$5;)Lcom/livemixtapes/SearchFragment;

    move-result-object v2

    iget-object v2, v2, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    mul-float v3, v4, p1

    sub-float v3, v4, v3

    invoke-static {v2, v3}, Lcom/livemixtapes/utils/Utility;->dpToPixel(Landroid/content/Context;F)F

    move-result v0

    .line 101
    :goto_0
    float-to-int v2, v0

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 102
    iget-object v2, p0, Lcom/livemixtapes/SearchFragment$5$1;->this$1:Lcom/livemixtapes/SearchFragment$5;

    # getter for: Lcom/livemixtapes/SearchFragment$5;->this$0:Lcom/livemixtapes/SearchFragment;
    invoke-static {v2}, Lcom/livemixtapes/SearchFragment$5;->access$0(Lcom/livemixtapes/SearchFragment$5;)Lcom/livemixtapes/SearchFragment;

    move-result-object v2

    iget-object v2, v2, Lcom/livemixtapes/SearchFragment;->layoutHeader:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v1}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 103
    return-void

    .line 100
    :cond_0
    iget-object v2, p0, Lcom/livemixtapes/SearchFragment$5$1;->this$1:Lcom/livemixtapes/SearchFragment$5;

    # getter for: Lcom/livemixtapes/SearchFragment$5;->this$0:Lcom/livemixtapes/SearchFragment;
    invoke-static {v2}, Lcom/livemixtapes/SearchFragment$5;->access$0(Lcom/livemixtapes/SearchFragment$5;)Lcom/livemixtapes/SearchFragment;

    move-result-object v2

    iget-object v2, v2, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    mul-float v3, v4, p1

    invoke-static {v2, v3}, Lcom/livemixtapes/utils/Utility;->dpToPixel(Landroid/content/Context;F)F

    move-result v0

    goto :goto_0
.end method
